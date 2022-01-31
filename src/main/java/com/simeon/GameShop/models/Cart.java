package com.simeon.GameShop.models;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Cart extends CommonObject {
    
    @ManyToOne
	@JoinColumn(name="game_id")
	private Game game;

    public Cart(Game game, int quantity) {
        this.game = game;
        this.quantity = quantity;
    }
    
        private int quantity;
}
