package com.global.book.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PostLoad;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Formula;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.global.book.base.BaseEntity;


@Entity
@Table(name = "books")
public class Book extends BaseEntity<Long> {
	
	@Min(value = 10)
	private Double price ;
	
	@Transient
	private Double discounted ;
	
	@Formula("(select count(*) from books)")
	private Long bookCount ;
	
	@NotNull
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "auther_id")
	private Auther auther;
	
	public Long getBookCount() {
		return bookCount;
	}

	public void setBookCount(Long bookCount) {
		this.bookCount = bookCount;
	}

	public Double getDiscounted() {
		return discounted;
	}

	public void setDiscounted(Double discounted) {
		this.discounted = discounted;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Auther getAuther() {
		return auther;
	}

	public void setAuther(Auther auther) {
		this.auther = auther;
	}
	
	@PostLoad
	private void calcDiscount() {
		this.setDiscounted(price * 0.25);
	}
	
}
