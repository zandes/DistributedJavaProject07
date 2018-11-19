public class Event {

    private int eventNum;
    private String eventName;
    private String eventDesc;
    private String eventTime;

    public Event(int eventNum, String eventName, String eventDesc, String eventTime){
        this.eventNum = eventNum;
        this.eventName = eventName;
        this.eventDesc = eventDesc;
        this.eventTime = eventTime;
    }

    public Event(){}

    public int getEventNum() {
        return eventNum;
    }

    public void setEventNum(int eventNum) {
        this.eventNum = eventNum;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventDesc() {
        return eventDesc;
    }

    public void setEventDesc(String eventDesc) {
        this.eventDesc = eventDesc;
    }

    public String getEventTime() {
        return eventTime;
    }

    public void setEventTime(String eventTime) {
        this.eventTime = eventTime;
    }
}
