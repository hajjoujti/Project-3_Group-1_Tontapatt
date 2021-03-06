package fr.eql.ai109.tontapatt.entity;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "species")
public class Species implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "species", nullable = false)
	private String species;
	
	@JsonIgnore
	@OneToMany(mappedBy = "species", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Race> races;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "species")
	Set<FenceHeight> fenceHeights;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "species")
	Set<FlatnessPercentage> flatnessPercentages;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "species")
	Set<VegetationType> vegetationTypes;

	public Species() {
		super();
	}

	@Override
	public int hashCode() {
		return Objects.hash(species);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Species other = (Species) obj;
		return Objects.equals(species, other.species);
	}

	@Override
	public String toString() {
		return "Species [id=" + id + ", species=" + species + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public Set<FenceHeight> getFenceHeights() {
		return fenceHeights;
	}

	public void setFenceHeights(Set<FenceHeight> fenceHeights) {
		this.fenceHeights = fenceHeights;
	}

	public Set<FlatnessPercentage> getFlatnessPercentages() {
		return flatnessPercentages;
	}

	public void setFlatnessPercentages(
			Set<FlatnessPercentage> flatnessPercentages) {
		this.flatnessPercentages = flatnessPercentages;
	}

	public Set<VegetationType> getVegetationTypes() {
		return vegetationTypes;
	}

	public void setVegetationTypes(Set<VegetationType> vegetationTypes) {
		this.vegetationTypes = vegetationTypes;
	}

	public Set<Race> getRaces() {
		return races;
	}

	public void setRaces(Set<Race> races) {
		this.races = races;
	}

}
