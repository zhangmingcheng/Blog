package net.zmcheng.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="Province")
@SuppressWarnings("serial")
public class Province  implements java.io.Serializable{
     private Integer id;
    private String name;
    private Set<City> citys = new HashSet<City>();
    @OneToMany(targetEntity=City.class,cascade={CascadeType.ALL},fetch = FetchType.EAGER)   
    @JoinColumn(name="pro_id",updatable=false)
    public Set<City> getCitys() {
		return citys;
	}

	public void setCitys(Set<City> citys) {
		this.citys = citys;
	}

	
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
     
}
