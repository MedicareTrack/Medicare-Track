package com.app.entities;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "carts")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Carts extends BaseEntity {
	@Column(name = "created_date" )
	private LocalDate createdDate;
	@Column(name = "total_item")
	private int totalItem;
	@Column(name = "total_price")
	private double totalPrice;
	@Column(name = "updated_date")
	private LocalDate updatedDate;
	
	@OneToOne
	//@JsonIgnore
	@JoinColumn(name = "user_id")
	@MapsId
	private User user;
	
	@ElementCollection
	@OneToMany( mappedBy = "cartId", orphanRemoval = true ,cascade = CascadeType.ALL )
	@JsonIgnore
	 private Set<CartItem> cartItem = new HashSet<>();
	
	public void setCartItem(CartItem cartItems) {
		cartItem.add(cartItems);
	}
	

}
