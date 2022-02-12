package com.simeon.GameShop.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Game extends CommonObject {

    private String name;

    private BigDecimal price;

    private String pictureUrl;
    
    @Lob
    private String description; 

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
	private Studio studio;
	private Integer studioid;	
	
	@ManyToOne
	@JoinColumn(name="genreid", insertable=false, updatable=false)
	private Genre genre;
	private Integer genreid;
        
        @ManyToOne
	@JoinColumn(name="platformid", insertable=false, updatable=false)
	private Platform platform;
	private Integer platformid;

}
