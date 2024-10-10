package com.global.book.service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.global.book.base.BaseService;
import com.global.book.entity.Auther;
import com.global.book.entity.AutherSearch;
import com.global.book.error.DaplicateRecoredException;
import com.global.book.repository.AutherRepo;
import com.global.book.repository.AutherSpec;

@Service
public class AutherService extends BaseService<Auther, Long> {

	@Autowired
	AutherRepo autherRepo;
	
	@Autowired
	private MessageSource messageSource ;
	
	Logger log = LoggerFactory.getLogger(AutherService.class);

	@Override
	public Auther insert(Auther entity) {

		if (!entity.getEmail().isEmpty() && entity.getEmail() != null) {
			
			Optional<Auther> author = findByEmail(entity.getEmail());
			
			log.info(" author name is {} and email is {}",entity.getName() , entity.getEmail());
			
			if(author.isPresent()) {
				
				String [] msgParam = {entity.getEmail()} ;
				String msg =  messageSource.getMessage("validation.DaplicateRecoredExeption.message", msgParam , LocaleContextHolder.getLocale());
				
				log.error("this email is already found with anther user ");
				
				throw new DaplicateRecoredException(msg);
			}
		}

		return super.insert(entity);
	}

	@Override
	public Auther update(Auther entity) {

		Auther auther = findById(entity.getId());

		auther.setName(entity.getName());
		return super.update(auther);
	}

	public List<Auther> findAutherSpec(AutherSearch Search) {

		AutherSpec Spec = new AutherSpec(Search);

		return autherRepo.findAll(Spec);
	}

	private Optional<Auther> findByEmail(String email) {

		return autherRepo.findByEmail(email);
	}
	
	@Async
	public CompletableFuture<Auther> findByName(String name) {
		return CompletableFuture.completedFuture(autherRepo.findByName(name).get()) ;
	}

}
