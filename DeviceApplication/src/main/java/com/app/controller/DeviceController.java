package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Device;
import com.app.service.DeviceService;


@RestController
@RequestMapping("/devices")
public class DeviceController {

    @Autowired
    private DeviceService deviceService;
    

    @PostMapping("/matchDevice")
    public ResponseEntity<Device> matchDevice(@RequestBody String userAgentString) { 
    	Device device = deviceService.matchDevice(userAgentString);
        return device != null ? ResponseEntity.ok(device) : ResponseEntity.notFound().build();
    }
  
    @GetMapping("/{id}")
    public ResponseEntity<Device> getDeviceById(@PathVariable String id) {
        Device device = deviceService.getDeviceById(id);
        return device != null ? ResponseEntity.ok(device) : ResponseEntity.notFound().build();
    }
      

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDevice(@PathVariable String id) {
        String msg = deviceService.deleteDevice(id);
        return msg != null ? ResponseEntity.ok(msg) : ResponseEntity.notFound().build();       
    }
    
    /*@GetMapping("/getByOsName")
    public ResponseEntity<Device> getByOsName(@RequestParam String osName) {
        Device device = deviceService.getByOsName(osName);
        return device != null ? ResponseEntity.ok(device) : ResponseEntity.notFound().build();
    }*/
}
