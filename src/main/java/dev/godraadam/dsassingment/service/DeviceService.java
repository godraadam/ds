package dev.godraadam.dsassingment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.godraadam.dsassingment.exception.ResourceNotFoundException;
import dev.godraadam.dsassingment.exception.UserNotFoundException;
import dev.godraadam.dsassingment.model.AppUser;
import dev.godraadam.dsassingment.model.Device;
import dev.godraadam.dsassingment.repo.DeviceRepo;
import dev.godraadam.dsassingment.repo.UserRepo;

@Service
public class DeviceService {

    @Autowired
    private DeviceRepo deviceRepo;

    @Autowired
    private UserRepo userRepo;

    public Device addDeviceForUser(Long userId, Device device) throws UserNotFoundException {
        Optional<AppUser> userFromRepoOptional = userRepo.findById(userId);
        AppUser userFromRepo = userFromRepoOptional.orElseThrow(UserNotFoundException::new);
        device.setOwner(userFromRepo);
        device = deviceRepo.save(device);
        userFromRepo.getDevices().add(device);
        userRepo.save(userFromRepo);
        return device;
    }

    public List<Device> getAllDevicesForUser(Long userId) {
        return deviceRepo.findAllByOwner_Id(userId);
    }

    public void removeDevice(Long deviceId) {
        deviceRepo.deleteById(deviceId);
    }

    public Device updateDevice(Device updatedDevice) throws ResourceNotFoundException {
        Optional<Device> deviceOptional = deviceRepo.findById(updatedDevice.getId());
        Device device = deviceOptional.orElseThrow(ResourceNotFoundException::new);
        return deviceRepo.save(device);
    }

    public Device getDeviceById(Long deviceId) {
        Optional<Device> deviceOptional = deviceRepo.findById(deviceId);
        return deviceOptional.orElseThrow(ResourceNotFoundException::new);
    }

    public Device saveDevice(Device device) {
        return deviceRepo.save(device);
    }
}
