package org.pilz.pnozmulti.hardware_configurator.resolvers;

import java.util.Optional;

import org.pilz.pnozmulti.hardware_configurator.model.BaseModule;
import org.pilz.pnozmulti.hardware_configurator.model.HardwareModule;
import org.pilz.pnozmulti.hardware_configurator.repository.BaseModuleRepository;
import org.pilz.pnozmulti.hardware_configurator.repository.HardwareModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;

import javassist.NotFoundException;

@Component
public class ModuleMutation implements GraphQLMutationResolver{

	private BaseModuleRepository baseModuleRepository;
	private HardwareModuleRepository hardwareModuleRepository;
	
	@Autowired
	public ModuleMutation(BaseModuleRepository baseModuleRepository,
			HardwareModuleRepository hardwareModuleRepository) {
		super();
		this.baseModuleRepository = baseModuleRepository;
		this.hardwareModuleRepository = hardwareModuleRepository;
	}
	
	
	public BaseModule createBaseModule(String name, String type) {
		BaseModule baseModule = new BaseModule(name, type);
		baseModuleRepository.save(baseModule);
		return baseModule;
	}
	
	public HardwareModule createHardwareModule(String moduleName, int inputs, int outputs, Long baseModuleID) {
		HardwareModule hardwareModule = new HardwareModule();
		hardwareModule.setBaseModule(new BaseModule(baseModuleID));
		hardwareModule.setModuleName(moduleName);
		hardwareModule.setInputs(inputs);
		hardwareModule.setOutputs(outputs);
		hardwareModuleRepository.save(hardwareModule);
		return hardwareModule;
	}
	
	public HardwareModule updateHardwareModule(Long id, String moduleName, int inputs, int outputs, Long basemoduleID) throws NotFoundException{
		Optional<HardwareModule> foundHardwareModule = hardwareModuleRepository.findById(id);
		if(foundHardwareModule.isPresent()) {
			HardwareModule hardwareModule = foundHardwareModule.get();
			hardwareModule.setModuleName(moduleName);
			hardwareModule.setInputs(inputs);
			hardwareModule.setOutputs(outputs);
			hardwareModule.setBaseModule(new BaseModule(basemoduleID));
			hardwareModuleRepository.save(hardwareModule);
			return hardwareModule;
		}
		throw new NotFoundException("Hardware Module for the Id not found");
	}
	
}
