package org.pilz.pnozmulti.hardware_configurator.resolvers;

import org.pilz.pnozmulti.hardware_configurator.model.BaseModule;
import org.pilz.pnozmulti.hardware_configurator.model.HardwareModule;
import org.pilz.pnozmulti.hardware_configurator.repository.BaseModuleRepository;
import org.pilz.pnozmulti.hardware_configurator.repository.HardwareModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;

@Component
public class ModuleQuery implements GraphQLQueryResolver {

	private BaseModuleRepository baseModuleRepository;
	private HardwareModuleRepository hardwareModuleRepository;
	
	@Autowired
	public ModuleQuery(BaseModuleRepository baseModuleRepository, HardwareModuleRepository hardwareModuleRepository) {
		super();
		this.baseModuleRepository = baseModuleRepository;
		this.hardwareModuleRepository = hardwareModuleRepository;
	}
	
	public Iterable<BaseModule> findAllBaseModules(){
		return baseModuleRepository.findAll();
	}
	
	public Iterable<HardwareModule> findAllHardwareModules(){
		return hardwareModuleRepository.findAll();
	}
	
}
