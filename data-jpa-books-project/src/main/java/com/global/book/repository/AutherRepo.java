package com.global.book.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.global.book.base.BaseRepository;
import com.global.book.entity.Auther;

@Repository
public interface AutherRepo extends BaseRepository<Auther, Long>  ,JpaSpecificationExecutor<Auther>{
	
	
	Optional<Auther> findByEmail(String email);
	
	Optional<Auther> findByName(String name);
	
}
