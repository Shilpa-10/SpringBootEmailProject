package com.abc.student.location.controllers;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.abc.student.location.entities.Location;
import com.abc.student.location.repos.LocationRepository;
import com.abc.student.location.service.LocationService;
import com.abc.student.location.util.EmailUtil;
//import com.abc.student.location.util.ReportUtil;

@Controller
public class LocationController {

	@Autowired
	LocationService service;

	@Autowired
	EmailUtil emailUtil;
	@Autowired
	LocationRepository repository;
	//@Autowired
	//ReportUtil reportUtil;
	@Autowired
	ServletContext sc;

	@RequestMapping(value = "/showCreate")
	public String showCreate() {
		return "createLocation"; // only name of jsp page should be there.. nd .jsp suffix we'll add i
									// application.properties file.

	}
	// ModelAttribute is used to handle request to database and ModelMap is used to
	// handle the response from DB.

	@RequestMapping(value = "/saveLoc")
	public String saveLocation(@ModelAttribute("location") Location location, ModelMap modelmapd) {
		Location locationSaved = service.saveLocation(location);
		String msg = "Location saved with id:" + locationSaved.getId();
		modelmapd.addAttribute("msg", msg);
		emailUtil.sendEmail("testa4360@gmail.com", "LocationSaved",
				"Location saved successfully and about to return a response");
		return "createLocation";
	}

	@RequestMapping("/displaylocations")
	public String displayLocation(ModelMap modelMap) {
		List<Location> locations = service.getAllLocations();
		modelMap.addAttribute("locations", locations);
		return "displayLocations";

	}

	@RequestMapping("/deleteLocation")
	public String deleteLocation(@RequestParam("id") int id, ModelMap modelMap) { // this @RequestParam will bind id
																					// from jsp page to this int id in
																					// controller.
		Location location = service.getLocationById(id);
		service.deleteLocation(location);
		List<Location> locations = service.getAllLocations();
		modelMap.addAttribute("locations", locations);
		return "displayLocations";

	}

	@RequestMapping("/showUpdate")
	public String showUpdate(@RequestParam("id") int id, ModelMap modelMap) {
		Location location = service.getLocationById(id);
		modelMap.addAttribute("location", location);
		return "updateLocation";
	}

	@RequestMapping("/updateLoc")
	public String UpdateLocation(@ModelAttribute("location") Location location, ModelMap modelmap) {
		service.updateLocation(location);
		List<Location> locations = service.getAllLocations();
		modelmap.addAttribute("locations", locations);
		return "displayLocations";
	}

	/*
	 * @RequestMapping("/generateReport") public String generateReport() { String
	 * path = sc.getRealPath("/"); List<Object[]> data =
	 * repository.findTypeAndTypeCount(); reportUtil.generatePieChart(path, data);
	 * return "report"; }
	 */
}
