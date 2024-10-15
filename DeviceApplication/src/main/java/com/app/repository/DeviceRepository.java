package com.app.repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.aerospike.client.AerospikeClient;
import com.aerospike.client.Key;
import com.aerospike.client.Record;
import com.app.model.Device;

@Repository
public class DeviceRepository {

	private final AerospikeClient aerospikeClient;
	

    @Autowired
    public DeviceRepository(AerospikeClient aerospikeClient) {
        this.aerospikeClient = aerospikeClient;     
    }

    public Device findByKey(String deviceId) {
		Key key = new Key("test", "device", deviceId); 
        Record record = aerospikeClient.get(null, key);         
        return record != null ? convertRecordToDevice(record, deviceId) : null;
    }

   
    public void save(Device device) {    	
        aerospikeClient.put(null, device.getKey(), device.getBins());
    }

    public String deleteByID(String deviceId) {
        Key key = new Key("test", "device", deviceId); 
        if(aerospikeClient.delete(null,key)) {
        	return "Success";
        }
        return "";
    }
  
    private Device convertRecordToDevice(Record record, String deviceId) {
        return new Device(
            deviceId,
            record.getInt("hitCount"),
            record.getString("osName"),
            record.getString("osVersion"),
            record.getString("browserName"),
            record.getString("browserVersion")
        );
    }
    
   /* public Device findByOsName(String osName) {
        Key key = new Key("test", "device", osName); 
        Record record = aerospikeClient.get(null, key);    
        aerospikeClient.get(null, key);  
        return record != null ? convertRecordToDevice(record, osName) : null;
    }*/
  
}
