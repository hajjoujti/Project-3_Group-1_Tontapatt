package fr.eql.ai109.tontapatt.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "anomaly")
public class Anomaly implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@Column(name = "creation_date", nullable = false)
	private LocalDateTime creationDate;
	@Column(name = "description", nullable = false)
	private String description;
	@Column(name = "end_date", nullable = true)
	private LocalDateTime endDate;
	@ManyToOne
	@JoinColumn(referencedColumnName = "id", nullable = false)
	private Service service;
	@ManyToOne
	@JoinColumn(referencedColumnName = "id", nullable = false)
	private User declarer;
	@ManyToOne
	@JoinColumn(referencedColumnName = "id", nullable = false)
	private AnomalyType anomalyType;

	public Anomaly() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public User getDeclarer() {
		return declarer;
	}

	public void setDeclarer(User declarer) {
		this.declarer = declarer;
	}

	public AnomalyType getAnomalyType() {
		return anomalyType;
	}

	public void setAnomalyType(AnomalyType anomalyType) {
		this.anomalyType = anomalyType;
	}

}