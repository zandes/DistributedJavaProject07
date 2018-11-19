import java.util.List;

public class Main {

    public static void main(String args[]){
//        CreateDB createDB = new CreateDB();
        EventDetail eventDetail = new EventDetail();
        List list = eventDetail.getEventList();

        for(int i = 0; i < list.size(); i++){
            Event event = (Event) list.get(i);
            System.out.println(event.getEventName());
        }
    }
}
