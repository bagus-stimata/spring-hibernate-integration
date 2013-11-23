package org.config.spring.hibernate.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="tb_salesman")
public class Salesman implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional=false)
	@Column(name="id_salesman", nullable=false, length=10)
	private String idSalesman;
	@Column(name="fist_name")
	private String fistName;
	@Column(name="last_name")
	private String lastName;	
	private String address;
	private String city;
	@Column(name="join_date")
	@Temporal(TemporalType.DATE)
	private Date joinDate;
	public String getIdSalesman() {
		return idSalesman;
	}
	public void setIdSalesman(String idSalesman) {
		this.idSalesman = idSalesman;
	}
	public String getFistName() {
		return fistName;
	}
	public void setFistName(String fistName) {
		this.fistName = fistName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	@Override
	public String toString() {
		return "Salesman [idSalesman=" + idSalesman + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idSalesman == null) ? 0 : idSalesman.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Salesman other = (Salesman) obj;
		if (idSalesman == null) {
			if (other.idSalesman != null)
				return false;
		} else if (!idSalesman.equals(other.idSalesman))
			return false;
		return true;
	}

	
	
}
