package com.Faraday.Library.services;

import com.Faraday.Library.dto.AddBookDto;
import com.Faraday.Library.dto.BookDto;
import com.Faraday.Library.entity.*;
import com.Faraday.Library.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BookServiceImplement implements BookService{

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private PublisherRepository publisherRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookDetailsRepository bookDetailsRepository;

    @Override
    public List<BookEntity> getBooks() {
        List<BookEntity> books = bookRepository.findAllActive();
        return books;
    }

    @Override
    public BookEntity getBook(String bookCode) {
        BookEntity book = bookRepository.findByBookCodeIgnoreCase(bookCode);
        if (book == null) {
            book = null;
            return book;
        }
        return book;
    }

    @Override
    public List<BookEntity> getCatalog(){
        List<BookEntity> books = bookRepository.findCatalog();
        return books;
    }

    @Override
    public List<BookEntity> getPopular(String categoryCode){
        List<BookEntity> books = bookRepository.findPopular(categoryCode);
        return books;
    }
    
    @Override
	public BookEntity getBookDetails(Integer id) {
		// TODO Auto-generated method stub
		BookEntity bookEntities = bookRepository.findBookDetails(id);
    	return bookEntities;
	}

    @Override
    public BookEntity post(BookDto dto) {
        BookEntity books = new BookEntity();
        books.setBookCode("");
        books.setIsbn(dto.getIsbn());
        books.setPublishedDate(dto.getPublishedDate());
        books.setStatus(1);

        //masukkan kode kategori, publisher, author, bookDetail
        CategoryEntity categoryEntity = categoryRepository.findByCategoryCodeIgnoreCase(dto.getCategoryCode());
        PublisherEntity publisherEntity = publisherRepository.findByPublisherCode(dto.getPublisherCode());
        AuthorEntity authorEntity = authorRepository.findByAuthorCodeIgnoreCase(dto.getAuthorCode());
        BookDetailsEntity bookDetailsEntity = bookDetailsRepository.findByBookDetailCodeIgnoreCase(dto.getBookDetailCode());

        books.setCategoryEntity(categoryEntity);
        books.setPublisherEntity(publisherEntity);
        books.setAuthorEntity(authorEntity);
        books.setBookDetailsEntity(bookDetailsEntity);
        bookRepository.save(books);

        String kodeBuku = "";
        Integer bookId = books.getId();
        if(bookId.toString().length() == 1) kodeBuku = "B00" + bookId.toString();
        else if (bookId.toString().length() == 2) kodeBuku = "B0" + bookId.toString();
        else if (bookId.toString().length() == 3) kodeBuku = "B" + bookId.toString();

        books.setBookCode(kodeBuku);
        bookRepository.save(books);
        return books;
    }

    @Override
    public BookEntity put(String bookCode, BookDto dto) {
        BookEntity books = bookRepository.findByBookCodeIgnoreCase(bookCode);
        CategoryEntity category = categoryRepository.findByCategoryCodeIgnoreCase(dto.getCategoryCode());
        PublisherEntity publisher = publisherRepository.findByPublisherCode(dto.getPublisherCode());
        AuthorEntity author = authorRepository.findByAuthorCodeIgnoreCase(dto.getAuthorCode());
        BookDetailsEntity bookdetail = bookDetailsRepository.findByBookDetailCodeIgnoreCase(dto.getBookDetailCode());

        if (books == null) {
            books = null;
            return books;
        }

        books.setBookCode(dto.getBookCode());
        books.setIsbn(dto.getIsbn());
        books.setPublishedDate(dto.getPublishedDate());
        books.setCategoryEntity(category);
        books.setPublisherEntity(publisher);
        books.setAuthorEntity(author);
        books.setBookDetailsEntity(bookdetail);
        bookRepository.save(books);
        return books;
    }

    @Override
    public BookEntity delete(String bookCode) {
        BookEntity books = bookRepository.findByBookCodeIgnoreCase(bookCode);

        if (books == null) {
            books = null;
            return books;
        }

        books.setStatus(0);
        bookRepository.save(books);

        return books;
    }

    @Override
    public BookEntity postNew(AddBookDto dto ) {
        AuthorEntity authorEntity = convertToAuthorEntity(dto);
        AuthorEntity savedAuthor = authorRepository.save(authorEntity);
        BookDetailsEntity bookDetailEntity = convertToBookDetailEntity(dto);
        BookDetailsEntity savedBookDetail = bookDetailsRepository.save(bookDetailEntity);
        CategoryEntity categoryEntity = convertToCategoryEntity(dto);
        CategoryEntity savedCategory = categoryRepository.save(categoryEntity);
        PublisherEntity publisherEntity = convertToPublisherEntity(dto);
        PublisherEntity savedPublisher = publisherRepository.save(publisherEntity);
        BookEntity bookEntity = convertToBookEntity(dto, savedCategory, savedAuthor, savedBookDetail, savedPublisher);
        bookEntity.setAuthorEntity(authorEntity);
        bookEntity.setBookDetailsEntity(bookDetailEntity);
        bookEntity.setCategoryEntity(categoryEntity);
        bookEntity.setPublisherEntity(publisherEntity);
        bookRepository.save(bookEntity);

        return bookEntity;
    }

    // Method Convert
    public AuthorEntity convertToAuthorEntity(AddBookDto dto) {
        AuthorEntity author = new AuthorEntity();
        author.setAuthorName(dto.getAuthorName());
        author.setAuthorCode("");
        author.setStatus(1);
        authorRepository.save(author);

        String kodeAuthor = "";
        Integer authorId = author.getId();
        if(authorId.toString().length() == 1) kodeAuthor = "BA00" + authorId.toString();
        else if (authorId.toString().length() == 2) kodeAuthor = "BA0" + authorId.toString();
        else if (authorId.toString().length() == 3) kodeAuthor = "BA" + authorId.toString();
        author.setAuthorCode(kodeAuthor);
        return author;
    }

    public BookDetailsEntity convertToBookDetailEntity(AddBookDto dto) {
        BookDetailsEntity bookDetailsEntity = new BookDetailsEntity();
        bookDetailsEntity.setBookTitle(dto.getBookTitle());
        bookDetailsEntity.setBookSubtitle(dto.getBookSubtitle());
        bookDetailsEntity.setDescription(dto.getDescription());
        bookDetailsEntity.setCover(dto.getCover());
        bookDetailsEntity.setNumberOfPages(dto.getNumberOfPages());
        bookDetailsEntity.setLanguage(dto.getLanguage());
        bookDetailsEntity.setBookDetailCode("");
        bookDetailsEntity.setIsActive(1);

        bookDetailsRepository.save(bookDetailsEntity);

        String kodeDetailBuku = "";
        Integer bookId = bookDetailsEntity.getId();
        if(bookId.toString().length() == 1) kodeDetailBuku = "BD00" + bookId.toString();
        else if (bookId.toString().length() == 2) kodeDetailBuku = "BD0" + bookId.toString();
        else if (bookId.toString().length() == 3) kodeDetailBuku = "BD" + bookId.toString();
        bookDetailsEntity.setBookDetailCode(kodeDetailBuku);
        return bookDetailsEntity;
    }

    public CategoryEntity convertToCategoryEntity(AddBookDto dto) {
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setCategoryName(dto.getCategoryName());
        categoryEntity.setCategoryCode("");
        categoryEntity.setStatus(1);

        categoryRepository.save(categoryEntity);

        String kodeKategori = "";
        Integer categoryId = categoryEntity.getId();
        if(categoryId.toString().length() == 1) kodeKategori = "BC00" + categoryId.toString();
        else if (categoryId.toString().length() == 2) kodeKategori = "BC0" + categoryId.toString();
        else if (categoryId.toString().length() == 3) kodeKategori = "BC" + categoryId.toString();
        categoryEntity.setCategoryCode(kodeKategori);
        return categoryEntity;
    }

    public PublisherEntity convertToPublisherEntity(AddBookDto dto) {
        PublisherEntity publisherEntity = new PublisherEntity();
        publisherEntity.setPublisherName(dto.getPublisherName());
        publisherEntity.setAddress(dto.getAddress());
        publisherEntity.setStatus(1);
        publisherEntity.setPublisherCode("");

        publisherRepository.save(publisherEntity);

        String kodePublisher = "";
        Integer publisherId = publisherEntity.getId();
        if(publisherId.toString().length() == 1) kodePublisher = "BP00" + publisherId.toString();
        else if (publisherId.toString().length() == 2) kodePublisher = "BP0" + publisherId.toString();
        else if (publisherId.toString().length() == 3) kodePublisher = "BP" + publisherId.toString();
        publisherEntity.setPublisherCode(kodePublisher);
        return publisherEntity;
    }

    public BookEntity convertToBookEntity(AddBookDto dto, CategoryEntity categoryEntity, AuthorEntity authorEntity, BookDetailsEntity bookDetailsEntity, PublisherEntity publisherEntity) {
        BookEntity bookEntity = new BookEntity();
        bookEntity.setIsbn(dto.getIsbn());
        bookEntity.setPublishedDate(dto.getPublishedDate());
        bookEntity.setStatus(1);
        bookEntity.setBookCode("");

        bookRepository.save(bookEntity);

        String kodeBuku = "";
        Integer bookId = bookEntity.getId();
        if(bookId.toString().length() == 1) kodeBuku = "B00" + bookId.toString();
        else if (bookId.toString().length() == 2) kodeBuku = "B0" + bookId.toString();
        else if (bookId.toString().length() == 3) kodeBuku = "B" + bookId.toString();
        bookEntity.setBookCode(kodeBuku);

        //masukkan kode kategori, publisher, author, bookDetail
//        String getLastCodeCategory  = categoryRepository.findLastCode();
//        String getLastCodePublisher = publisherRepository.findLastCode();
//        String getLastCodeAuthor = authorRepository.findLastCode();
//        String getLastCodeBookDetail = bookDetailsRepository.findLastCode();

        bookEntity.setCategoryEntity(categoryEntity);
        bookEntity.setPublisherEntity(publisherEntity);
        bookEntity.setAuthorEntity(authorEntity);
        bookEntity.setBookDetailsEntity(bookDetailsEntity);
        return bookEntity;
    }

	@Override
	public BookEntity getBookByBookDetailCode(String bookDetailCode) {
		// TODO Auto-generated method stub
		BookEntity bookEntity = bookRepository.findAllActiveByBookDetailCode(bookDetailCode);
		return bookEntity;
	}
	
	@Override
	public BookEntity updateStatus(String bookCode, BookDto dto) {
		BookEntity bookEntity = bookRepository.findByBookCodeIgnoreCase(bookCode);
		bookEntity.setStatus(dto.getStatus());
		bookRepository.save(bookEntity);
		return bookEntity;
	}
}
