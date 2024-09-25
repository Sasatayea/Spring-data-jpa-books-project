package com.global.book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.global.book.base.BaseService;
import com.global.book.entity.Auther;
import com.global.book.entity.AutherSearch;
import com.global.book.repository.AutherRepo;
import com.global.book.repository.AutherSpec;

@Service
public class AutherService extends BaseService<Auther, Long> {

	@Autowired
	AutherRepo autherRepo ;
	
	@Override
	public Auther update(Auther entity) {

		Auther auther = findById(entity.getId());

		auther.setName(entity.getName());
		return super.update(auther);
	}
	
	public List <Auther> findAutherSpec(AutherSearch Search){
		
		AutherSpec Spec = new  AutherSpec(Search);
		
		return autherRepo.findAll(Spec) ;
	}

}
