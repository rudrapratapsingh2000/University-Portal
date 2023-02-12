package com.UniversityEventManagement.Service;

import com.UniversityEventManagement.Model.EventModel;
import com.UniversityEventManagement.Model.StudentModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

@Service
public class EventService {
//    eventId eventName locationOfEvent date startTime endTime imageurl
    private static List<EventModel> events=new ArrayList<>();
    private static List<EventModel> newEventModels=new ArrayList<>();
    static {
        events.add(new EventModel(2001,"Annual-Meet","Noida","12-sep","9:00 am","10:00 am"));
        events.add(new EventModel(2002,"Annual-Meet","Delhi","13-sep","9:00 am","10:00 am"));
        events.add(new EventModel(2003,"Annual-Meet","Noida","12-sep","9:00 am","10:00 am"));
        events.add(new EventModel(2004,"Alumini-Meet","Gaziabad","13-sep","9:00 am","10:00 am"));
        events.add(new EventModel(2005,"Alumini-Meet","Noida","12-sep","9:00 am","10:00 am"));
        events.add(new EventModel(2006,"Alumini-Meet","Noida","13-sep","9:00 am","10:00 am"));
        events.add(new EventModel(2007,"Sports-Meet","Bangolore","12-sep","9:00 am","10:00 am"));
        events.add(new EventModel(2008,"Sports-Meet","Kanpur","15-sep","9:00 am","10:00 am"));
        events.add(new EventModel(2009,"Sports-Meet","Lucknow","12-sep","9:00 am","10:00 am"));
    }
public void addEvent(EventModel eventModel){
    events.add(eventModel);
}
    public static List<EventModel> getAllEvents(String date) {
        for (EventModel e:events) {
            if(e.getDate().equals(date)){
                newEventModels.add(new EventModel(e.getEventId(), e.getEventName(),e.getLocationOfEvent(),e.getDate(),e.getStartTime(),e.getEndTime()));
                System.out.println(newEventModels);
            }
        }
            return newEventModels;
    }
//    public EventModel getEventByDate(String date){
//        Predicate<? super EventModel> predicate= eventModel -> eventModel.getDate().equals(date);
//        EventModel eventModel=events.stream().filter(predicate).findFirst().get();
//        return eventModel;
//    }
    public EventModel getEventById(int number){
        Predicate<? super EventModel> predicate= eventModel -> eventModel.getEventId()==(number);
        EventModel eventModel=events.stream().filter(predicate).findFirst().get();
        return eventModel;
    }
    public void updateEvent(int number,EventModel newEventModel){
        EventModel eventModel=getEventById(number);
        eventModel.setEventId(newEventModel.getEventId());
        eventModel.setEventName(newEventModel.getEventName());
        eventModel.setLocationOfEvent(newEventModel.getLocationOfEvent());
        eventModel.setDate(newEventModel.getDate());
        eventModel.setStartTime(newEventModel.getStartTime());
        eventModel.setEndTime(newEventModel.getEndTime());
    }
    public void deleteEvent(int number){
        Predicate<? super EventModel> predicate=eventModel -> eventModel.getEventId() ==number;
        events.removeIf(predicate);
    }
}
