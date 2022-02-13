package com.simeon.GameShop.models;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class Genre extends CommonObject {
    private String name;
}
