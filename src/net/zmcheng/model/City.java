package net.zmcheng.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="City")
@SuppressWarnings("serial")
public class City  implements java.io.Serializable{
     private Integer id;
     private String name;
     private Province province;
    @Id
    @GeneratedValue
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name="name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	 @ManyToOne(cascade ={CascadeType.ALL},optional=false,fetch = FetchType.LAZY,targetEntity = Province.class)
	 @JoinColumn(name="pro_id")
	public Province getProvince() {
		return province;
	}
	public void setProvince(Province province) {
		this.province = province;
	}
     
}
