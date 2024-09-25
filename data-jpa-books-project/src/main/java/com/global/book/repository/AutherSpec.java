package com.global.book.repository;

import org.springframework.data.jpa.domain.Specification;

import com.global.book.entity.Auther;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class AutherSpec  implements Specification<Auther> {

	@Override
	public Predicate toPredicate(Root<Auther> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
		// TODO Auto-generated method stub
		return null;
	}

}
