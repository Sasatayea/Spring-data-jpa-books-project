package com.global.book.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.global.book.base.BaseRepository;
import com.global.book.entity.Book;


@Repository
public interface BookRepo extends BaseRepository<Book, Long> {

	@Override
	@EntityGraph(attributePaths = { "auther" })
	Optional<Book> findById(Long id);

	@Query("delete from Book where auther.id = :id")
	@Transactional
	@Modifying
	int deleteByAutherId(Long id);

}
