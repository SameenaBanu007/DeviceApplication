package com.app.repository;

import org.springframework.data.aerospike.repository.AerospikeRepository;
import org.springframework.stereotype.Repository;

import com.app.model.Device;

@Repository
public interface DevicesRepository extends AerospikeRepository<Device, String> {
	
	
}
