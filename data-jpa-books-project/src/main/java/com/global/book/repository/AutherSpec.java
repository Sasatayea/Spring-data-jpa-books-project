package com.global.book.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import com.global.book.entity.Auther;
import com.global.book.entity.AutherSearch;
import com.global.book.entity.Book;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class AutherSpec implements Specification<Auther> {

	private AutherSearch Search;

	public AutherSpec(AutherSearch search) {
		super();
		this.Search = search;
	}

	@Override
	public Predicate toPredicate(Root<Auther> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		// TODO Auto-generated method stub

		Join<Auther, Book> BookJoin = root.join("books", JoinType.LEFT);

		List<Predicate> predicates = new ArrayList<>();

		// AutherName
		if (Search.getAutherName() != null && !Search.getAutherName().isEmpty()) {

			predicates.add(cb.like(root.get("name"), Search.getAutherName()));
		}

		// email
		if (Search.getEmail() != null && !Search.getEmail().isEmpty()) {

			predicates.add(cb.like(root.get("email"), Search.getEmail()));
		}

		if (Search.getIpAddress() != null && !Search.getIpAddress().isEmpty()) {
			predicates.add(cb.like(root.get("ipAdress"), "%" + Search.getIpAddress() + "%"));
		}

		if (Search.getBookName() != null && !Search.getBookName().isEmpty()) {
			// "%" ==> contain
			predicates.add(cb.like(BookJoin.get("name"), "%" + Search.getBookName() + "%"));
		}

		if (Search.getPrice() != null) {
			predicates.add(cb.equal(BookJoin.get("price"), Search.getPrice()));
		}
		return cb.and(predicates.toArray(new Predicate[0]));
	}

}
