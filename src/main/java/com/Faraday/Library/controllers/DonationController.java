package com.Faraday.Library.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Faraday.Library.dto.DonationDto;
import com.Faraday.Library.entity.DonationEntity;
import com.Faraday.Library.services.DonationServiceImpl;
import com.Faraday.Library.dto.StatusMessageDto;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class DonationController {
	@Autowired
	private DonationServiceImpl donation;
	
	@SuppressWarnings("rawtypes")
	    private StatusMessageDto result = new StatusMessageDto();

	
	@GetMapping("/donation")
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(donation.getAll());
	}
	
	@GetMapping("/donation/id/{id}")
	public ResponseEntity<?> getById(@PathVariable Integer id){
		return ResponseEntity.ok(donation.getById(id));
	}
	
	@GetMapping("/donation/status/{status}")
	public ResponseEntity<?> getByStatus(@PathVariable Integer status){
		return ResponseEntity.ok(donation.getByStatus(status));
	}
	
	@PostMapping("/donation")
	public ResponseEntity<?> insert(@RequestBody DonationDto dto){
		return ResponseEntity.ok(donation.insert(dto));
	}

//	updateStatus
	@PutMapping("/donation/{id}")
	public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody DonationDto dto){
		return ResponseEntity.ok(donation.updateStatus(id, dto));
	}
	
//	update data
	@PutMapping("/donation-detail/{id}")
	public ResponseEntity<?> updateData(@PathVariable Integer id, @RequestBody DonationDto dto){
		return ResponseEntity.ok(donation.updateData(dto, id));
	}
	
	
//	softdelete donation data
    @SuppressWarnings("unchecked")
	@DeleteMapping("/donation/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id){
		try {
			DonationEntity donationEntity = donation.delete(id);
			
			if( donationEntity == null) {
				result.setStatus(400);
                result.setMessage("Data not found");
                result.setData(donationEntity);

                return ResponseEntity.status(400).body(result);
				
			}
			result.setStatus(200);
            result.setMessage("deleted");
            result.setData(donationEntity);

            return ResponseEntity.status(200).body(result);
			
		}catch(Exception e) {
			@SuppressWarnings("rawtypes")
            StatusMessageDto error = new StatusMessageDto(500,e.getMessage(), null);
            return ResponseEntity.status(500).body(error);
		}
	}
}
