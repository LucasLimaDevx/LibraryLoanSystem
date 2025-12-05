package com.lucasdevx.LibraryLoanSystem.model;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TB_BOOK")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, name = "title", length = 100)
	private String title;
	
	@Column(nullable = false, name = "year", length = 4)
	private String year;
	
	@Column(nullable = false, name = "quantity_copies", length = 30)
	private Integer quantityCopies = 0;
	
	@ManyToOne
	@JoinColumn(name = "author_id")
	private Author author;
	
	@JsonIgnore
	@OneToMany(mappedBy = "book", fetch = FetchType.EAGER)
	private Set<Loan> loans = new HashSet<>();

	
}
