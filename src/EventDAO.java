import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EventDAO {

    public List<Event> retrieveEvents(){
        List<Event> events = new ArrayList<>();

        final String DB_URL = "jdbc:derby:ScheduleDB";
        Statement stmt = null;
        Connection conn = null;

        try{
            conn = DriverManager.getConnection(DB_URL);
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT EventNum, EventName, EventDesc, EventTime FROM Schedule";
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){
                Event event = new Event();
                event.setEventNum(rs.getInt("EventNum"));
                event.setEventName(rs.getString("EventName"));
                event.setEventDesc(rs.getString("EventDesc"));
                event.setEventTime(rs.getString("EventTime"));

                events.add(event);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }// nothing we can do
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try

        return events;
    }
}
