package com.rk.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "user_tab")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id_col")
	private Integer id;
	@Column(name = "user_firstname_col")
	private String firstname;
	@Column(name = "user_lastname_col")
	private String lastname;
	@Column(name = "user_dob_col")
	private String dob;
	@Column(name = "user_address_col")
	private String address;
}
