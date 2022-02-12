package com.simeon.GameShop.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
public class Platform extends CommonObject {

    private String name;

//    @ManyToOne
//    @JoinColumn(name = "game_id")
//    private Game game;
}