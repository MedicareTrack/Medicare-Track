package com.app.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "Categories")
@Getter
@Setter
public class Categories extends BaseEntity {
	
	@Column(name = "category_name" , nullable = false) 
	private String categoryName;
	@Column(name = "description" , nullable = false)
	@Length(max = 100)
	private String description;
	@Column(length = 1000,nullable = false)
	@OneToMany(mappedBy = "categoryId", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	private Set<Products> productList = new HashSet<Products>();

}
