package fr.eql.ai109.tontapatt.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "shearing_offer_photo")
public class ShearingOfferPhoto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@Column(name = "link", nullable = false)
	private String link;
	@ManyToOne
	@JoinColumn(referencedColumnName = "id", nullable = false)
	private ShearingOffer shearingOffer;

	public ShearingOfferPhoto() {
		super();
	}

	@Override
	public int hashCode() {
		return Objects.hash(link);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ShearingOfferPhoto other = (ShearingOfferPhoto) obj;
		return Objects.equals(link, other.link);
	}

	@Override
	public String toString() {
		return "ShearingOfferPhoto [id=" + id + ", link=" + link + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public ShearingOffer getShearingOffer() {
		return shearingOffer;
	}

	public void setShearingOffer(ShearingOffer shearingOffer) {
		this.shearingOffer = shearingOffer;
	}

}
