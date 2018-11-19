import java.util.ArrayList;
import java.util.List;

public class EventDetail {
    private static List<Event> eventList = new ArrayList<>();
    private static EventDetail single_instance = null;

    public EventDetail() {
        if(single_instance == null) {
            eventList.add(new Event(100, "Event Start1", "The event opens to the public.", "08:30"));
            eventList.add(new Event(101, "Event Start2", "The event opens to the public.", "09:30"));
            eventList.add(new Event(102, "Event Start3", "The event opens to the public.", "10:30"));
            eventList.add(new Event(103, "Event Start4", "The event opens to the public.", "11:30"));
            eventList.add(new Event(104, "Event Start5", "The event opens to the public.", "12:30"));
            single_instance = this;
        }
    }

    public List<Event> getEventList(){
        return eventList;
    }
}
