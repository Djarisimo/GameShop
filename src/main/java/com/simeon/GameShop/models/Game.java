package com.simeon.GameShop.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Game extends CommonObject {

    public String name;

    public BigDecimal price;

    public String pictureUrl;
    
    @Lob
    public String description;

//    @ManyToOne
//    @JoinColumn(name = "studio_id")
//    public Studio studio;
//
//    @ManyToOne
//    @JoinColumn(name = "genre_id")
//    public Genre genre;
//
//    @OneToMany(mappedBy = "game", fetch = FetchType.EAGER)
//    public List<Platform> platforms = new ArrayList<>();
    
        @ManyToOne
	@JoinColumn(name="studioid", insertable=false, updatable=false)
	public Studio studio;
	public Integer studioid;	
	
	@ManyToOne
	@JoinColumn(name="genreid", insertable=false, updatable=false)
	public Genre genre;
	public Integer genreid;
        
        @ManyToOne
	@JoinColumn(name="platformid", insertable=false, updatable=false)
	public Platform platform;
	public Integer platformid;

}
