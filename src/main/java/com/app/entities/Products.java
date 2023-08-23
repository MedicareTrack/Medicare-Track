package com.app.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "products")
@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class Products extends BaseEntity {
	
	@Column(name = "product_name" , nullable = false)
	private String name;
	@Column(name = "price" , nullable = false )
	private double price;
	@Column(name = "description" , nullable = false)
	@Length(max = 200)
	private String description;
	@Column(name = "Stock" , nullable = false)
	private int stock;
	@ManyToOne
	@JoinColumn(name="category_id")
	// mapping with categories table
	private Categories categoryId;
	@Column(name = "image_path")
    private String imagePath;
	@Column(name = "expiry_date" , nullable = false)
	private LocalDate expDate;

}
