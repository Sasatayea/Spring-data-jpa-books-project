package com.global.book.entity;

import org.hibernate.annotations.Formula;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.global.book.base.BaseEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PostLoad;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "books")
public class Book extends BaseEntity<Long> {
	
	@NotBlank
	private String name ;
	
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
