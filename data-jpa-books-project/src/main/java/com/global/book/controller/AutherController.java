package com.global.book.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.Min;

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

import io.swagger.v3.oas.annotations.Operation;


@RestController
@Validated
@RequestMapping("/auther")
public class AutherController {
	
	
	@Autowired
	private AutherService autherService;
	
	@GetMapping("/{id}")
	@Operation(summary = "find author by id")
	public ResponseEntity<?> findById(@PathVariable @Min(value = 0) Long id ) {
		
		return ResponseEntity.ok(autherService.findById(id));
	}
	
	@Operation(summary = "find All authors")
	@GetMapping("/All")
	public ResponseEntity<?> findAll(){
		
		return ResponseEntity.ok(autherService.findAll());
	}
	
	@Operation(summary = "find author by name")
	@GetMapping("/name/{name}")
	public  ResponseEntity<?> findByName(@PathVariable  String name ) {
		
		return  ResponseEntity.ok(autherService.findByName(name));
	}
	
	@Operation(summary = "insert author")
	@PostMapping("")
	public ResponseEntity<?> insert(@RequestBody @Valid Auther entity) {
		
		return ResponseEntity.ok(autherService.insert(entity));
	}
	
	@Operation(summary = "update author")
	@PutMapping("")
	public ResponseEntity<?> update(@RequestBody @Valid Auther entity) {
		
		return ResponseEntity.ok(autherService.update(entity));
	}
	
	@Operation(summary = "delete author by id")
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Long id) {
		autherService.deleteById(id);
		return ResponseEntity.ok(null);
	}
	
	@Operation(summary = "find specific author by id")
	@PostMapping("/spec")
	public ResponseEntity<?> findByAutherSpec(@RequestBody AutherSearch Search ){
		
		return  ResponseEntity.ok(autherService.findAutherSpec(Search));
	}

}
