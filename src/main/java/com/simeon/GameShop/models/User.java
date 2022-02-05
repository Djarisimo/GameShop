package com.simeon.GameShop.models;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class User extends CommonObject {		
         
	private String username;
	private String password;
}
