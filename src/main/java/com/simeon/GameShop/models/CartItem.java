package com.simeon.GameShop.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartItem extends CommonObject {
    private int quantity;
    
    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;
}
