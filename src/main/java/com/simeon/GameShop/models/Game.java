package com.simeon.GameShop.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Game extends CommonObject {

    public String name;

    public BigDecimal price;

    public String pictureUrl;

    @ManyToOne
    @JoinColumn(name = "game_studio_id")
    public Studio studio;

    @ManyToOne
    @JoinColumn(name = "genre_id")
    public Genre genre;

    @OneToMany(mappedBy = "game", fetch = FetchType.EAGER)
    public List<Platform> platforms = new ArrayList<>();

}
