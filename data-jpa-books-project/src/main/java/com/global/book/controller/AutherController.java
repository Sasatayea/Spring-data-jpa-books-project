package com.global.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.global.book.entity.Auther;
import com.global.book.entity.AutherSearch;
import com.global.book.repository.AutherRepo;
import com.global.book.service.AutherService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;

@RestController
@Validated
@RequestMapping("/auther")
public class AutherController {
	
	
	@Autowired
	private AutherService autherService;
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable @Min(value = 6) Long id ) {
		
		return ResponseEntity.ok(autherService.findById(id));
	}
	
	@GetMapping("/All")
	public ResponseEntity<?> findAll(){
		
		return ResponseEntity.ok(autherService.findAll());
	}
	@PostMapping("")
	public ResponseEntity<?> insert(@RequestBody @Valid Auther entity) {
		
		return ResponseEntity.ok(autherService.insert(entity));
	}
	
	@PutMapping("")
	public ResponseEntity<?> update(@RequestBody @Valid Auther entity) {
		
		return ResponseEntity.ok(autherService.update(entity));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Long id) {
		autherService.deleteById(id);
		return ResponseEntity.ok(null);
	}
	
	@PostMapping("/spec")
	public ResponseEntity<?> findByAutherSpec(@RequestBody AutherSearch Search ){
		
		return  ResponseEntity.ok(autherService.findAutherSpec(Search));
	}

}
