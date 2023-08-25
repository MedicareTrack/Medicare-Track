package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "cart_item")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CartItem extends BaseEntity {
	
	@Column(name="quantity")
	private Integer quantity;
	@Column(name = "total_price", nullable=false)
	private double totalPrice;
	@ManyToOne
	@JoinColumn(name = "cart_id")
    @JsonIgnore
	private Carts cartId;
	@OneToOne
	@JoinColumn(name = "product_id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private Products productId;

}
