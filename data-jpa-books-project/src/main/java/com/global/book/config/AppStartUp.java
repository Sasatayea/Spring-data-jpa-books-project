package com.global.book.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.global.book.entity.Auther;
import com.global.book.entity.Book;
import com.global.book.service.AutherService;
import com.global.book.service.BookService;

@Component
public class AppStartUp implements CommandLineRunner {

	@Autowired
	private AutherService autherService;
	
	@Autowired
	private BookService bookService ;
	
	@Override
	public void run(String... args) throws Exception {
		
		Auther auther1 = new Auther();
		auther1.setName("mostafa salah");
		
		Auther auther2 = new Auther();
		auther2.setName("mohamed tayea");
		
		Auther auther3 = new Auther();
		auther3.setName("salah");
		
		
		autherService.insertAll(Arrays.asList(auther1 ,auther2 ,auther3));
		
		Book book1 = new Book();
		book1.setName("mostafa salah");
		book1.setPrice(200.0);
		book1.setAuther(autherService.getReferenceById(1l));
		
		Book book2 = new Book();
		book2.setName("salah");
		book2.setPrice(300.0);
		book2.setAuther(autherService.getReferenceById(2l));
		
		Book book3 = new Book();
		book3.setName("mama");
		book3.setPrice(400.0);
		book3.setAuther(autherService.getReferenceById(3l));
		
		bookService.insertAll(Arrays.asList(book1 ,book2 ,book3));
		
	}

}
