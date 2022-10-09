package com.yash.sbrest.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="roomavaiable")
public class RoomAvaiable {
	
	@Id @GeneratedValue
	Integer id;
	@Column
	Date avaiableDate;
	@Column
	Integer count;
	@OneToMany
	Set<Resvered> resvered;
	
	
	public Set<Resvered> getResvered() {
		return resvered;
	}
	public void setResvered(Set<Resvered> resvered) {
		this.resvered = resvered;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getAvaiableDate() {
		return avaiableDate;
	}
	public void setAvaiableDate(Date avaiableDate) {
		this.avaiableDate = avaiableDate;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	
	
	

}
