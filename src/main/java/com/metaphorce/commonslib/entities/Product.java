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
@Table(name = "product",
		uniqueConstraints = { @UniqueConstraint(name = "uk_product__name", columnNames = { "name" }) }
)
public final class Product implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id", nullable = false,
			foreignKey = @ForeignKey(name = "fk_product__category"))
	private Category category;

	@Column(name = "name", unique = true, nullable = false)
	private String name;

	@Column(name = "price", nullable = false, precision = 19, scale = 2)
	private BigDecimal price;

	@Column(name = "stock", nullable = false)
	private Integer stock;

	@Column(name = "path_image", nullable = false)
	private String pathImage;

	@Column(name = "description")
	private String description;

	@Column(name = "active", nullable = false)
	private Boolean active;

	@Column(name = "deleted", nullable = false)
	private Boolean deleted;

	@Column(name = "created_at", nullable = false)
	private LocalDateTime createdAt;

	@Column(name = "updated_at", nullable = false)
	private LocalDateTime updatedAt;
}