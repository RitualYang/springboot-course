package com.wty.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@ToString
@Table(name ="user")
public class User implements Serializable {

	private static final long serialVersionUID =  1681186685467210178L;

	@Id
	private Long uid;
   	@Column(name = "username" )
	private String username;

   	@Column(name = "password" )
	private String password;

   	@Column(name ="age")
	private Long age;

}
