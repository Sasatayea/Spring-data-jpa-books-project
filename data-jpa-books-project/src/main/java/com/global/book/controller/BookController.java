package com.global.book.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.global.book.entity.Auther;
import com.global.book.entity.Book;
import com.global.book.entity.BookDto;
import com.global.book.service.AutherService;
import com.global.book.service.BookService;


@RestController
@RequestMapping("/book")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id ) {
		
		Book book = bookService.findById(id) ;
		
//		BookDto dto = new BookDto() ;
//		dto.setId(book.getId());
//		dto.setName(book.getName()) ;
//		dto.setPrice(book.getPrice());
//		
		return ResponseEntity.ok(book);
	}
	
	@DeleteMapping("/auther/{id}")
	public ResponseEntity<?> deleteByAutherId (@PathVariable Long id) {
		return ResponseEntity.ok(bookService.deleteByAutherId(id)); 
	}
	
	@GetMapping("/All")
	public ResponseEntity<?> findAll(){
		
		return ResponseEntity.ok(bookService.findAll());
	}
	@PostMapping("")
	public ResponseEntity<?> insert(@RequestBody @Valid BookDto dto) {
		
		Book book = new Book() ;
		
		book.setName(dto.getName());
		book.setPrice(dto.getPrice());
		book.setAuther(dto.getAuther());
		book.setStatusCode(dto.getStatusCode());
				
		return ResponseEntity.ok(bookService.insert(book));
	}
	
	@PutMapping("")
	public ResponseEntity<?> update(@RequestBody @Valid Book entity) {
		
		return ResponseEntity.ok(bookService.insert(entity));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Long id) {
		bookService.deleteById(id);
		return ResponseEntity.ok(null);
	}


}
