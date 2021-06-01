package com.sentry.Sentry.controller;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.sentry.Sentry.entity.Room;
import com.sentry.Sentry.entity.User;
import com.sentry.Sentry.service.RoomService;

import com.sentry.Sentry.service.DeviceService;

import com.sentry.Sentry.service.SensorService;
import com.sentry.Sentry.service.UserService;




@Controller
public class DashboardController {
	
	


private UserService userService;
private SensorService sensorService;
private static SensorDataService sensorDataService;

private DeviceService deviceService;

public DashboardController(UserService userService,SensorService sensorService, DeviceService deviceservice, SensorDataService sensorDataService) {
  
       this.userService = userService;
       this.sensorService = sensorService;
       this.deviceService = deviceservice;
       this.sensorDataService = sensorDataService;
}




	 @GetMapping("/dashboard")
	    public String displayDashboardPage(Model theModel,Authentication authentication){
		 User theUser = userService.findByUserName(authentication.getName());

		 long countsensoractive = sensorService.countactive(theUser.getId());
		 long countsensorinactive = sensorService.countinactive(theUser.getId());
		 long countsensorerror = sensorService.counterror(theUser.getId());
		 
		 long countdeviceactive = deviceService.countactive(theUser.getId());
		 long countdeviceinactive = deviceService.countinactive(theUser.getId());
		 long countdeviceerror = deviceService.counterror(theUser.getId());
		 
		 theModel.addAttribute("sensoractive", countsensoractive);
		 theModel.addAttribute("sensorinactive", countsensorinactive);
		 theModel.addAttribute("sensorerror", countsensorerror);
		 
		 theModel.addAttribute("deviceactive", countdeviceactive);
		 theModel.addAttribute("deviceinactive", countdeviceinactive);
		 theModel.addAttribute("deviceerror", countdeviceerror);
		    
		 List<SensorData> sensorData = sensorDataService.sensorValueType(5);

		 theModel.addAttribute("sensor", sensorData);
		 for (int i = 0; i < sensorData.size(); i++) {
	        
	        System.out.println(sensorData.get(i));
	        theModel.addAttribute("sensorData", sensorData.get(i));
	       }
		 theModel.addAttribute("sensor", sensorData);

		    

	        return "dashboard";
	    }

}
