package org.pilz.pnozmulti.hardware_configurator.resolvers;

import org.pilz.pnozmulti.hardware_configurator.model.BaseModule;
import org.pilz.pnozmulti.hardware_configurator.model.HardwareModule;
import org.pilz.pnozmulti.hardware_configurator.repository.BaseModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLResolver;

@Component
public class HardwareModuleResolver implements GraphQLResolver<HardwareModule>{
	
	@Autowired
	private BaseModuleRepository baseModuleRepository;

	public HardwareModuleResolver(BaseModuleRepository baseModuleRepository) {
		this.baseModuleRepository = baseModuleRepository;
	}
	
	public BaseModule getBaseModule(HardwareModule hardwareModule) {
		return baseModuleRepository.findById(hardwareModule.getId()).orElseThrow(null);
	}
	
	
	
	

}
