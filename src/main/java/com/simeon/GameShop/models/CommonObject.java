package com.simeon.GameShop.models;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



@MappedSuperclass
@ToString
@Getter
@Setter
@NoArgsConstructor
public class CommonObject {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

}
