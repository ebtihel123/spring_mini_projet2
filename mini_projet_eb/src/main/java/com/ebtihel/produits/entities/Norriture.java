package com.ebtihel.produits.entities;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
@Entity
public class Norriture {
//id auto increment	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long idNorriture;

@NotNull
@Size (min = 4,max = 15)
private String nomNorriture;

public Categorie getCategorie() {
	return categorie;
}
public void setCategorie(Categorie categorie) {
	this.categorie = categorie;
}
@Min(value = 10)
@Max(value = 100000000)
private Double prixNorriture;


@Temporal(TemporalType.DATE)
@DateTimeFormat(pattern = "yyyy-MM-dd")
@PastOrPresent
private Date dateCreation;

//relation entre les table
@ManyToOne
private Categorie categorie;

public Norriture() {
super();
}
public Norriture(String nomNorriture, Double prixNorriture, Date dateCreation) {
super();
this.nomNorriture = nomNorriture;
this.prixNorriture = prixNorriture;
this.dateCreation = dateCreation;
}


public Long getIdNorriture() {
return idNorriture;
}
public void setIdNorriture(Long idNorriture) {
this.idNorriture = idNorriture;
}
public String getNomNorriture() {
return nomNorriture;
}
public void setNomNorriture(String nomNorriture) {
this.nomNorriture = nomNorriture;
}
public Double getPrixNorriture() {
return prixNorriture;
}
public void setPrixNorriture(Double prixNorriture) {
this.prixNorriture= prixNorriture;
}
public Date getDateCreation() {
return dateCreation;
}
public void setDateCreation(Date dateCreation) {
this.dateCreation = dateCreation;
}
@Override
public String toString() {
	return "Norriture [idNorriture=" + idNorriture + ", nomNorriture=" + nomNorriture + ", prixNorriture="
			+ prixNorriture + ", dateCreation=" + dateCreation + ", categorie=" + categorie + "]";
}

}
