import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class EventsController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        EventDetail eventDetail = new EventDetail();
        List<Event> eventList = eventDetail.getEventList();

        if(request.getAttribute("events") == null){
            eventList.sort(Comparator.comparing(Event::getEventTime));
            request.setAttribute("events", eventList);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("adminSchedule.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        String name = request.getParameter("name");
        String desc = request.getParameter("desc");
        String time = request.getParameter("time");

        EventDetail eventDetail = new EventDetail();
        List<Event> eventList = eventDetail.getEventList();
        Event lastEvent = eventList.get(eventList.size()-1);

        if((name != null && !name.isEmpty()) || (desc != null && !desc.isEmpty()) || (time != null && !time.isEmpty())) {
            int num = lastEvent.getEventNum() + 1;
            eventList.add(new Event(num, name, desc, time));
        }
        if(request.getParameter("delete") != null && !request.getParameter("delete").isEmpty()){
            eventList.remove(Integer.parseInt(request.getParameter("delete")) - 1);
            eventList.sort(Comparator.comparing(Event::getEventTime));
            request.setAttribute("events", eventList);
        }

        eventList.sort(Comparator.comparing(Event::getEventTime));
        request.setAttribute("events", eventList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("adminSchedule.jsp");
        dispatcher.forward(request, response);
    }
}
