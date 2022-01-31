package com.simeon.GameShop.models;

import javax.persistence.Entity;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")

public class Game extends CommonObject {
	
        public String name;
                 
        public BigDecimal price;

        public String picture;
	
	@ManyToOne
	@JoinColumn(name="game_studio_id", insertable=false, updatable=false)
	public GameStudio gameStudio;	
	
	@ManyToOne
	@JoinColumn(name="genre_id", insertable=false, updatable=false)
	public Genre genre;
    
        @OneToMany(fetch = FetchType.EAGER)
	public List<Platform> platform = new ArrayList<>();
          
}
