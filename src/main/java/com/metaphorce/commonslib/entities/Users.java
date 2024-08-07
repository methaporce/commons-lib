package com.metaphorce.commonslib.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users", indexes = {
		@Index(name = "idx_users__username", columnList = "username", unique = true)
})
public final class Users implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "username", unique = true, nullable = false)
	private String username;

	@Column(name = "first_name", nullable = false)
	private String firstname;

	@Column(name = "last_name", nullable = false)
	private String lastname;

	@Column(name = "password", nullable = false)
	private String password;

	@Column(name = "phone")
	private String phone;

	@Column(name = "email", unique = true, nullable = false)
	private String email;

	@Column(name = "role", nullable = false)
	private String role;

	@Column(name = "active", nullable = false)
	private Boolean active;

	@Column(name = "deleted", nullable = false)
	private Boolean deleted;

	@Column(name = "created_at", nullable = false)
	private LocalDateTime createdAt;

	@Column(name = "updated_at", nullable = false)
	private LocalDateTime updatedAt;
}