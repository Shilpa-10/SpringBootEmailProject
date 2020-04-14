package com.abc.student.location.service;

import java.util.List;

import com.abc.student.location.entities.Location;

public interface LocationService {
	
	//defining methods
	Location saveLocation(Location location);
	Location updateLocation(Location location);
	void deleteLocation(Location location);
	Location getLocationById(int id);
	List<Location> getAllLocations();

}
