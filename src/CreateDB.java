import java.sql.*;

public class CreateDB
{
    public CreateDB()
    {

        try
        {
            // Create a named constant for the URL.
            // NOTE: This value is specific for Java DB.
            final String DB_URL = "jdbc:derby:ScheduleDB;create=true";

            // Create a connection to the database.
            Connection conn =
                    DriverManager.getConnection(DB_URL);

            // If the DB already exists, drop the tables.
            dropTables(conn);

            buildScheduleTable(conn);

            // Close the connection.
            conn.close();
        } catch (Exception e)
        {
            System.out.println("Error Creating the Schedule Table");
            System.out.println(e.getMessage());
        }

    }

    /**
     * The dropTables method drops any existing
     * in case the database already exists.
     */
    public static void dropTables(Connection conn)
    {
        System.out.println("Checking for existing tables.");

        try
        {
            // Get a Statement object.
            Statement stmt = conn.createStatement();

            try
            {
                // Drop the Schedule table.
                stmt.execute("DROP TABLE Schedule");
                System.out.println("Schedule table dropped.");
            } catch (SQLException ex)
            {
                // No need to report an error.
                // The table simply did not exist.
            }
        } catch (SQLException ex)
        {
            System.out.println("ERROR: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    public static void buildScheduleTable(Connection conn)
    {
        try
        {
            // Get a Statement object.
            Statement stmt = conn.createStatement();

            stmt.execute("CREATE TABLE Schedule" +
                    "( EventNum CHAR(10) NOT NULL PRIMARY KEY, " +
                    "  EventName CHAR(25), " +
                    "  EventDesc VARCHAR(8000), " +
                    "  EventTime TIME)");

            stmt.executeUpdate("INSERT INTO Schedule VALUES" +
                    "('100', 'Event Start', 'The event opens to the public.', '08:30')");

            stmt.executeUpdate("INSERT INTO Schedule VALUES" +
                    "('101', 'Event Start', 'The event opens to the public.', '09:30')");

            stmt.executeUpdate("INSERT INTO Schedule VALUES" +
                    "('102', 'Event Start', 'The event opens to the public.', '10:30')");

            stmt.executeUpdate("INSERT INTO Schedule VALUES" +
                    "('103', 'Event Start', 'The event opens to the public.', '11:30')");


            System.out.println("Schedule table created.");
        } catch (SQLException ex)
        {
            System.out.println("ERROR: " + ex.getMessage());
        }
    }
}