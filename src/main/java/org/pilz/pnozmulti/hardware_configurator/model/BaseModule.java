package org.pilz.pnozmulti.hardware_configurator.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BaseModule {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "type", nullable = false)
	private String type;

	public BaseModule(Long id) {
		this.id = id;
	}

	public BaseModule(String name, String type) {
		this.name = name;
		this.type = type;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "BaseModule [id=" + id + ", name=" + name + ", hardwareId=" + type + "]";
	}

}
