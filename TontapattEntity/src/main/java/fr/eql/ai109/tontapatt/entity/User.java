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
@Table(name = "user")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@Column(name = "first_name", nullable = false)
	private String firstName;
	@Column(name = "last_name", nullable = false)
	private String lastName;
	@Column(name = "birthdate", nullable = true)
	private LocalDate birthDate;
	@Column(name = "email", nullable = false, unique = true)
	private String email;
	@Column(name = "password", nullable = false)
	private String password;
	@Column(name = "address", nullable = false)
	private String address;
	@Column(name = "signup_date", nullable = false)
	private LocalDateTime signupDate;
	@Column(name = "description", nullable = true)
	private String description;
	@Column(name = "siret", nullable = true)
	private String siret;
	@Column(name = "phone_number", nullable = false)
	private String phoneNumber;
	@Column(name = "unsubscription_date", nullable = true)
	private LocalDateTime unsubscriptionDate;
	@Column(name = "photo", nullable = true)
	private String photo;
	@JsonIgnore
	@OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Field> fields;
	@JsonIgnore
	@OneToMany(mappedBy = "breeder", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<ShearingOffer> shearingOffers;
	@JsonIgnore
	@OneToMany(mappedBy = "evaluator", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Rating> ratings;
	@JsonIgnore
	@OneToMany(mappedBy = "declarer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Anomaly> anomalies;
	@ManyToOne
	@JoinColumn(referencedColumnName = "id", nullable = false)
	private ZipCodeCity zipCodeCity;
	@ManyToOne
	@JoinColumn(referencedColumnName = "id", nullable = false)
	private UserCategory userCategory;
	@ManyToOne
	@JoinColumn(referencedColumnName = "id")
	private UnsubscriptionReason unsubscriptionReason;

	public User() {
		super();
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, birthDate, description, email, firstName,
				lastName, password, phoneNumber, photo, signupDate, siret,
				unsubscriptionDate);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(address, other.address)
				&& Objects.equals(birthDate, other.birthDate)
				&& Objects.equals(description, other.description)
				&& Objects.equals(email, other.email)
				&& Objects.equals(firstName, other.firstName)
				&& Objects.equals(lastName, other.lastName)
				&& Objects.equals(password, other.password)
				&& Objects.equals(phoneNumber, other.phoneNumber)
				&& Objects.equals(photo, other.photo)
				&& Objects.equals(signupDate, other.signupDate)
				&& Objects.equals(siret, other.siret)
				&& Objects.equals(unsubscriptionDate, other.unsubscriptionDate);
	}

	@Override
	public String toString() {
		return "User [id=" + id
				+ ", firstName="
				+ firstName
				+ ", lastName="
				+ lastName
				+ ", birthDate="
				+ birthDate
				+ ", email="
				+ email
				+ ", password="
				+ password
				+ ", address="
				+ address
				+ ", signupDate="
				+ signupDate
				+ ", description="
				+ description
				+ ", siret="
				+ siret
				+ ", phoneNumber="
				+ phoneNumber
				+ ", unsubscriptionDate="
				+ unsubscriptionDate
				+ ", photo="
				+ photo
				+ "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public LocalDateTime getSignupDate() {
		return signupDate;
	}

	public void setSignupDate(LocalDateTime signupDate) {
		this.signupDate = signupDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSiret() {
		return siret;
	}

	public void setSiret(String siret) {
		this.siret = siret;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public LocalDateTime getUnsubscriptionDate() {
		return unsubscriptionDate;
	}

	public void setUnsubscriptionDate(LocalDateTime unsubscriptionDate) {
		this.unsubscriptionDate = unsubscriptionDate;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public ZipCodeCity getZipCodeCity() {
		return zipCodeCity;
	}

	public void setZipCodeCity(ZipCodeCity zipCodeCity) {
		this.zipCodeCity = zipCodeCity;
	}

	public UserCategory getUserCategory() {
		return userCategory;
	}

	public void setUserCategory(UserCategory userCategory) {
		this.userCategory = userCategory;
	}

	public UnsubscriptionReason getUnsubscriptionReason() {
		return unsubscriptionReason;
	}

	public void setUnsubscriptionReason(
			UnsubscriptionReason unsubscriptionReason) {
		this.unsubscriptionReason = unsubscriptionReason;
	}

	public Set<Field> getFields() {
		return fields;
	}

	public void setFields(Set<Field> fields) {
		this.fields = fields;
	}

	public Set<ShearingOffer> getShearingOffers() {
		return shearingOffers;
	}

	public void setShearingOffers(Set<ShearingOffer> shearingOffers) {
		this.shearingOffers = shearingOffers;
	}

	public Set<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(Set<Rating> ratings) {
		this.ratings = ratings;
	}

	public Set<Anomaly> getAnomalies() {
		return anomalies;
	}

	public void setAnomalies(Set<Anomaly> anomalies) {
		this.anomalies = anomalies;
	}

}
