package com.metaphorce.commonslib.entities;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "card")
public final class Card implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false,
			foreignKey = @ForeignKey(name = "fk_card__users"))
	private Users user;

	@Enumerated(EnumType.STRING)
	@Column(name = "card_type", nullable = false)
	private CardTypeEnum cardType;

	@Column(name = "card_number", nullable = false)
	private String cardNumber;

	@Column(name = "expiration", nullable = false)
	private LocalDate expiration;

	public enum CardTypeEnum {
		DEBIT,
		CREDIT,
		PREPAID,
		CASH,
		OTHER;
	}
}