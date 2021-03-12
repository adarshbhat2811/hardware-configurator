package org.pilz.pnozmulti.hardware_configurator.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class HardwareModule {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "module_name", nullable = false)
	private String moduleName;
	
	@Column(name = "inputs", nullable = false)
	private int inputs;
	
	@Column(name = "outputs", nullable = false)
	private int outputs;
	
	@ManyToOne
	@JoinColumn(name = "base_module", nullable = false, updatable = false)
	private BaseModule baseModule;

	public HardwareModule() {
		super();
	}

	

	public HardwareModule(String moduleName, int inputs, int outputs, BaseModule baseModule) {
		super();
		this.moduleName = moduleName;
		this.inputs = inputs;
		this.outputs = outputs;
		this.baseModule = baseModule;
	}



	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public int getInputs() {
		return inputs;
	}

	public void setInputs(int inputs) {
		this.inputs = inputs;
	}

	public int getOutputs() {
		return outputs;
	}

	public void setOutputs(int outputs) {
		this.outputs = outputs;
	}

	public BaseModule getBaseModule() {
		return baseModule;
	}

	public void setBaseModule(BaseModule baseModule) {
		this.baseModule = baseModule;
	}

	public Long getId() {
		return id;
	}
	
	
	
	
	

}
