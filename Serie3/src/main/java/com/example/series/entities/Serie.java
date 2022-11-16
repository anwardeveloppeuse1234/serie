package com.example.series.entities;
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
public class Serie {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long idSerie;

@NotNull
@Size (min = 4,max = 50)
private String nomSerie;

public Genre getGenre() {
	return genre;
}
public void setGenre(Genre genre) {
	this.genre = genre;
}
@Min(value = 10)
@Max(value = 10000)
private Double prixSerie;

@Temporal(TemporalType.DATE)
@DateTimeFormat(pattern = "yyyy-MM-dd")
@PastOrPresent
private Date dateCreation;

@ManyToOne
private Genre genre;
public Serie() {
super();
}
public Serie(String nomSerie, Double prixSerie, Date dateCreation) {
super();
this.nomSerie = nomSerie;
this.prixSerie = prixSerie;
this.dateCreation = dateCreation;
}
public Long getIdSerie() {
return idSerie;
}
public void setIdSerie(Long idSerie) {
this.idSerie = idSerie;
}
public String getNomSerie() {
return nomSerie;
}
public void setNomSerie(String nomSerie) {
this.nomSerie = nomSerie;
}
public Double getPrixSerie() {
return prixSerie;
}
public void setPrixSerie(Double prixSerie) {
this.prixSerie = prixSerie;
}
public Date getDateCreation() {
return dateCreation;
}
public void setDateCreation(Date dateCreation) {
this.dateCreation = dateCreation;
}
@Override
public String toString() {
	return "Serie [idSerie=" + idSerie + ", nomSerie=" + nomSerie + ", prixSerie=" + prixSerie
			+ ", dateCreation=" + dateCreation + ", genre=" + genre + "]";
}
}
