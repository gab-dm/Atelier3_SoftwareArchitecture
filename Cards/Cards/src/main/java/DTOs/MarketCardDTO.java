package DTOs;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity(name="Card")
public final class MarketCardDTO {


@Id
@GeneratedValue
private Integer id;
private String name;
private Integer idJoueur;
private Integer price;
	
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	
	public void setPrice(Integer price) {
		this.price = price;
	}
	
	public Integer getPrice() {
		return price;
	}
	
	@Override
	public String toString() {
		return "Carte ["+getId()+"]: name:"+getName()+" idJoueur : "+this.getIdJoueur();
	}

	public Integer getIdJoueur() {
		return idJoueur;
	}

	public void setIdJoueur(Integer _idJoueur) {
		idJoueur = _idJoueur;
	}
	

} 
