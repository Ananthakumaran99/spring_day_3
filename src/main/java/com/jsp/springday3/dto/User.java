package com.jsp.springday3.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class User {

	@Id
	private int id;
	@NotBlank(message = "name should not be blank")
	@NotNull(message = "name should not be null" )
	private String name;
	@NotBlank(message = "Address should not be blank")
	@NotNull(message = "Address should not be null" )
	private String address;

}
