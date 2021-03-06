package fr.eql.ai109.tontapatt.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "shearing_offer")
public class ShearingOffer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "address", nullable = false)
	private String address;

	@Column(name = "creation_date", nullable = false)
	private LocalDateTime creationDate;

	@Column(name = "start_date", nullable = false)
	private LocalDate startDate;

	@Column(name = "end_date", nullable = false)
	private LocalDate endDate;

	@Column(name = "description", nullable = false)
	private String description;

	@Column(name = "animal_count", nullable = false)
	private Integer animalCount;

	@Column(name = "max_travel_dist", nullable = false)
	private Integer maxTravelDist;

	@Column(name = "animal_daily_price", nullable = false)
	private Double animalDailyPrice;

	@Column(name = "withdrawal_date", nullable = true)
	private LocalDateTime withdrawalDate;

	@Column(name = "distance", nullable = true, insertable = false, updatable = false)
	private Double distance;

	@JsonIgnore
	@OneToMany(mappedBy = "shearingOffer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<ShearingOfferPhoto> photos;

	@JsonIgnore
	@OneToMany(mappedBy = "shearingOffer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Service> services;

	@ManyToOne
	@JoinColumn(referencedColumnName = "id", nullable = false)
	private Race race;

	@ManyToOne
	@JoinColumn(referencedColumnName = "id")
	private OfferWithdrawalReason offerWithdrawalReason;

	@ManyToOne
	@JoinColumn(referencedColumnName = "id", nullable = false)
	private ZipCodeCity zipCodeCity;

	@ManyToOne
	@JoinColumn(referencedColumnName = "id", nullable = false)
	private User breeder;

	public ShearingOffer() {
		super();
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, animalCount, animalDailyPrice,
				creationDate, description, distance, endDate, maxTravelDist,
				name, startDate, withdrawalDate);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ShearingOffer other = (ShearingOffer) obj;
		return Objects.equals(address, other.address)
				&& Objects.equals(animalCount, other.animalCount)
				&& Objects.equals(animalDailyPrice, other.animalDailyPrice)
				&& Objects.equals(creationDate, other.creationDate)
				&& Objects.equals(description, other.description)
				&& Objects.equals(distance, other.distance)
				&& Objects.equals(endDate, other.endDate)
				&& Objects.equals(maxTravelDist, other.maxTravelDist)
				&& Objects.equals(name, other.name)
				&& Objects.equals(startDate, other.startDate)
				&& Objects.equals(withdrawalDate, other.withdrawalDate);
	}

	@Override
	public String toString() {
		return "ShearingOffer [id=" + id
				+ ", name="
				+ name
				+ ", address="
				+ address
				+ ", creationDate="
				+ creationDate
				+ ", startDate="
				+ startDate
				+ ", endDate="
				+ endDate
				+ ", description="
				+ description
				+ ", animalCount="
				+ animalCount
				+ ", maxTravelDist="
				+ maxTravelDist
				+ ", animalDailyPrice="
				+ animalDailyPrice
				+ ", withdrawalDate="
				+ withdrawalDate
				+ ", distance="
				+ distance
				+ "]";
	}

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getAnimalCount() {
		return animalCount;
	}

	public void setAnimalCount(Integer animalCount) {
		this.animalCount = animalCount;
	}

	public Integer getMaxTravelDist() {
		return maxTravelDist;
	}

	public void setMaxTravelDist(Integer maxTravelDist) {
		this.maxTravelDist = maxTravelDist;
	}

	public Double getAnimalDailyPrice() {
		return animalDailyPrice;
	}

	public void setAnimalDailyPrice(Double animalDailyPrice) {
		this.animalDailyPrice = animalDailyPrice;
	}

	public LocalDateTime getWithdrawalDate() {
		return withdrawalDate;
	}

	public void setWithdrawalDate(LocalDateTime withdrawalDate) {
		this.withdrawalDate = withdrawalDate;
	}

	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}

	public Set<ShearingOfferPhoto> getPhotos() {
		return photos;
	}

	public void setPhotos(Set<ShearingOfferPhoto> photos) {
		this.photos = photos;
	}

	public Race getRace() {
		return race;
	}

	public void setRace(Race race) {
		this.race = race;
	}

	public Set<Service> getServices() {
		return services;
	}

	public void setServices(Set<Service> services) {
		this.services = services;
	}

	public OfferWithdrawalReason getOfferWithdrawalReason() {
		return offerWithdrawalReason;
	}

	public void setOfferWithdrawalReason(
			OfferWithdrawalReason offerWithdrawalReason) {
		this.offerWithdrawalReason = offerWithdrawalReason;
	}

	public ZipCodeCity getZipCodeCity() {
		return zipCodeCity;
	}

	public void setZipCodeCity(ZipCodeCity zipCodeCity) {
		this.zipCodeCity = zipCodeCity;
	}

	public User getBreeder() {
		return breeder;
	}

	public void setBreeder(User breeder) {
		this.breeder = breeder;
	}

}
