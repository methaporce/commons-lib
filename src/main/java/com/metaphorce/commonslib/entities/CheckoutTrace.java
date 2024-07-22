package com.metaphorce.commonslib.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "checkout_trace")
public final class CheckoutTrace implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "checkout_id", nullable = false,
			foreignKey = @ForeignKey(name = "fk_checkout_trace__checkout"))
	private Checkout checkout;

	@Column(name = "message", nullable = false)
	private String message;

	@Column(name = "date", nullable = false)
	private LocalDateTime date;
}