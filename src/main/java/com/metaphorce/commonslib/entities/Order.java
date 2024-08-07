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
@Table(name = "orders")
public final class Order implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cart_id", nullable = false,
			foreignKey = @ForeignKey(name = "fk_order__cart"))
	private Cart cart;

	@Column(name = "total_to_pay", nullable = false, precision = 19, scale = 2)
	private BigDecimal totalToPay;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "users_id", nullable = false,
			foreignKey = @ForeignKey(name = "fk_order__user"))
	private Users users;

	@Column(name = "date", nullable = false)
	private LocalDateTime date;

	@Enumerated(EnumType.STRING)
	@Column(name = "status", nullable = false)
	private OrderStatusEnum orderStatus;

	public enum OrderStatusEnum {
		INITIAL,
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