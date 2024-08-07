package com.metaphorce.commonslib.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cart")
public final class Cart implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "users_id", nullable = false,
			foreignKey = @ForeignKey(name = "fk_cart__user"))
	private Users user;

	@Column(nullable = false)
	private Boolean active;

	@Column(nullable = false)
	private Boolean deleted;

	@JsonManagedReference
	@OneToMany(mappedBy = "cart", fetch = FetchType.LAZY)
	private List<CartItem> items;
}