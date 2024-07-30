package com.metaphorce.commonslib.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "payment_method")
public final class PaymentMethod implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Enumerated(EnumType.STRING)
	@Column(name = "name", nullable = false)
	private NameEnum name;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "card_id", nullable = false,
			foreignKey = @ForeignKey(name = "fk_payment_method__card"))
	private Card card;

	public enum NameEnum {
		TRANSFER,
		CREDIT_CARD,
		DEBIT_CARD,
		OTHER
	}
}