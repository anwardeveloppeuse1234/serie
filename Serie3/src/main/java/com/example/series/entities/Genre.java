package com.example.series.entities;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@Entity
public class Genre {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long idGen;
private String nomGen;
private String descriptionGen;
@JsonIgnore
@OneToMany(mappedBy = "genre")
private List<Serie> series;
public Genre() {}
public Genre(String nomGen, String descriptionGen, List<Serie> series) 
{
super();
this.nomGen = nomGen;
this.descriptionGen = descriptionGen;
this.series = series;
}
public Long getIdGen() {
return idGen;
}
public void setIdGen(Long idGen) {
this.idGen = idGen;
}
public String getNomGen() {
return nomGen;
}
public void setNomGen(String nomGen) {
this.nomGen = nomGen;
}
public String getDescriptionGen() {
return descriptionGen;
}
public void setDescriptionGen(String descriptionGen) {
this.descriptionGen = descriptionGen;
}
public List<Serie> getSeries() {
return series;
}
public void setSeries(List<Serie> series) {
this.series = series;
}
@Override
public String toString() {
	return "Genre [idGen=" + idGen+ ", nomGen=" + nomGen + ", descriptionGen=" + descriptionGen + "]";
}
}