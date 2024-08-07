package com.metaphorce.commonslib.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "checkout")
public final class Checkout implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "order_id", nullable = false,
			foreignKey = @ForeignKey(name = "fk_checkout__order"))
	private Order order;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "card_user_id", nullable = false,
			foreignKey = @ForeignKey(name = "fk_checkout__card_user"))
	private Card cardUser;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "payment_method_id", nullable = false,
			foreignKey = @ForeignKey(name = "fk_checkout__payment_method"))
	private PaymentMethod paymentMethod;

	@Column(name = "total_paid", nullable = false, precision = 19, scale = 2)
	private BigDecimal totalPaid;

	@Enumerated(EnumType.STRING)
	@Column(name = "status", nullable = false)
	private CheckoutStatusEnum status;

	@Column(name = "date", nullable = false)
	private LocalDateTime date;

	public enum CheckoutStatusEnum {
		INITIAL,
		IN_PROGRESS,
		ACCEPTED,
		REJECTED,
		COMPLETED,
		CANCELLED,
		EXPIRED,
		ERROR,
		WAITING,
		UNKNOWN;
	}
}