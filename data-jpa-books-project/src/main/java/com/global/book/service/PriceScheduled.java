package com.global.book.service;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;

@Component
public class PriceScheduled {
	
	
	Logger log = LoggerFactory.getLogger(PriceScheduled.class);
	
////	@Scheduled(initialDelay = 3000 , fixedRateString = "${price.interval}")
//	@Scheduled(cron = "${interval-in-cron}")
//	@SchedulerLock(name = "bookComputePrice")
////	@Async
//	public void computePrice() throws InterruptedException {
//		
//		Thread.sleep(200000);
//		
//		log.info("compute price >> " + LocalDateTime.now());
//	}
//	
//	@Scheduled(fixedRate = 200000)
//	@SchedulerLock(name = "bookComputeDiscount")
//	public void computeDiscount() throws InterruptedException {
//		
//		Thread.sleep(40000);
//		
//		log.info("compute discount >> " + LocalDateTime.now());
//	}

}
