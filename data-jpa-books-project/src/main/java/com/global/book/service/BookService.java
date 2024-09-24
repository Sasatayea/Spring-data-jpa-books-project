package com.global.book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.global.book.base.BaseService;
import com.global.book.entity.Auther;
import com.global.book.entity.Book;
import com.global.book.repository.AutherRepo;
import com.global.book.repository.BookRepo;

@Service
public class BookService extends BaseService<Book, Long> {

	@Autowired
	BookRepo bookRepo;

	public int deleteByAutherId(Long id) {
		return bookRepo.deleteByAutherId(id);
	}

	@Override
	public Book update(Book entity) {

		Book book = findById(entity.getId());

		book.setName(entity.getName());
		book.setPrice(entity.getPrice());

		return bookRepo.save(book);
	}

}
