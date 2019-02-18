package itsmby.addressbook.tests;

import itsmby.addressbook.model.GroupData;
import itsmby.addressbook.model.Groups;
import org.testng.annotations.Test;

import java.sql.*;

public class DbConnection {

    @Test
    public void testDbConnection(){
        Connection conn = null;
        try{
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/addressbook?user=root&password=");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT group_id,group_name,group_header,group_footer FROM group_list");
            Groups groups = new Groups();
            while(rs.next()){
                groups.add(new GroupData().withId(rs.getInt("group_id"))
                        .withName(rs.getString("group_name"))
                        .withHeader(rs.getString("group_header"))
                        .withFooter(rs.getString("group_footer")));
            }
            rs.close();
            stmt.close();
            conn.close();
            System.out.println(groups);
        } catch (SQLException e) {
            System.out.println("SQLException: "+ e.getMessage());
            System.out.println("SQLState: "+ e.getSQLState());
            System.out.println("VendorError: "+ e.getErrorCode());
        }
    }
}
