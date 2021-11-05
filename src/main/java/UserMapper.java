import java.sql.*;
import java.util.IdentityHashMap;

public class UserMapper {
    public UserMapper(){

    }

    public static User getUser(int key) throws Exception, ClassNotFoundException, SQLException {
        User user = IdentityMap.isInto(key);
        if(user!=null)
        {
            return user;
        }
        else {
            User mapuser = findinDB(key);
            IdentityMap.add(mapuser);
            return mapuser;
        }
    }
    private static User findinDB(int key) throws Exception{
        Class.forName("org.sqlite.JDBC");

        Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Java\\courses\\archjava6\\bin\\person.db");
        Statement stat = conn.createStatement();
        String query = "select * from people where key = " + '\'' + key + '\'';
        ResultSet rs = stat.executeQuery(query);

        if (rs.next()) {
            String name = rs.getString("name");
            String surname = rs.getString("surname");

            rs.close();
            conn.close();

            User trovata = new User(key, name, surname);

            return trovata;

        }
        else {
            System.out.println("Record not found");
            System.exit(1);

        }

        return null;
    }
}
