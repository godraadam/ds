package dev.godraadam.dsassingment.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dev.godraadam.dsassingment.api.assembler.DeviceAssembler;
import dev.godraadam.dsassingment.api.dto.DeviceDTO;
import dev.godraadam.dsassingment.service.DeviceService;

@RestController
public class DeviceController {

    @Autowired
    private DeviceAssembler deviceAssembler;

    @Autowired
    private DeviceService deviceService;

    @PostMapping("/admin/api/device/add/{userId}")
    public DeviceDTO addDeviceForUser(@RequestBody DeviceDTO dto, @PathVariable Long userId) {
        return deviceAssembler.createDTO(deviceService.addDeviceForUser(userId, deviceAssembler.createModel(dto)));
    }

    @GetMapping("/api/device/ls/{userId}")
    public List<DeviceDTO> getAllDevicesForUser(@PathVariable Long userId) {
        return deviceAssembler.createDTOList(deviceService.getAllDevicesForUser(userId));
    }

    @DeleteMapping("/admin/api/device/rm/{deviceId}")
    public void removeDevice(@PathVariable Long deviceId) {
        deviceService.removeDevice(deviceId);
    }

    @PutMapping("/admin/api/device")
    public DeviceDTO updateDevice(@RequestBody DeviceDTO dto) {
        return deviceAssembler.createDTO(deviceService.updateDevice(deviceAssembler.createModel(dto)));
    }
}
