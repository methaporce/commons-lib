package com.metaphorce.commonslib.entities;

import java.io.Serializable;
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

	@Column(name = "location")
	private String location;

	@Column(name = "phone")
	private String phone;
}