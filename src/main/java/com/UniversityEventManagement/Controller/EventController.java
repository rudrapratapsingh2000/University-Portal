package com.UniversityEventManagement.Controller;

import com.UniversityEventManagement.Model.EventModel;
import com.UniversityEventManagement.Model.StudentModel;
import com.UniversityEventManagement.Service.EventService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/event-app")
public class EventController {

    private final EventService eventService;
public EventController(EventService eventService){

    this.eventService=eventService;
}

@GetMapping("/findEvent-api/date/{date}")
public List<EventModel> findEvent(@PathVariable String date){
    return eventService.getAllEvents(date);
}
    @PostMapping("/add-api")
    public void addEvent(@RequestBody EventModel eventModel){
        eventService.addEvent(eventModel);
    }
    @PutMapping("/update-api/number/{number}")
    public  void updateEvent(@PathVariable int number, @RequestBody EventModel eventModel){
        eventService.updateEvent(number,eventModel);
    }
    @DeleteMapping("/delete-api/number/{number}")
    public void deleteEvent(@PathVariable int number){
        eventService.deleteEvent(number);
    }
}
