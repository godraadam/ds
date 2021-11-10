package dev.godraadam.dsassingment.api.assembler;

import org.springframework.stereotype.Component;

import dev.godraadam.dsassingment.api.dto.DeviceDTO;
import dev.godraadam.dsassingment.model.Device;

@Component
public class DeviceAssembler implements GeneralAssembler<Device, DeviceDTO> {

    @Override
    public Device createModel(DeviceDTO dto) {
        Device device = new Device();
        device.setDescription(dto.getDescription());
        device.setId(dto.getDeviceId());
        // maybe maxConsumption?
        return device;
    }

    @Override
    public DeviceDTO createDTO(Device model) {
        DeviceDTO dto = new DeviceDTO();
        dto.setAddress(model.getAddress());
        dto.setAvgConsumption(model.getAvgConsumption());
        dto.setDescription(model.getDescription());
        dto.setMaxConsumption(model.getMaxConsumption());
        if (model.getSensor() != null) {
            dto.setSensorId(model.getSensor().getId());
        }
        dto.setUserId(model.getOwner().getId());
        dto.setDeviceId(model.getId());
        return dto;
    }

}
