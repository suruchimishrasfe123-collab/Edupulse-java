import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    public static List<Student> getAllStudents() {

        List<Student> list = new ArrayList<>();

        try {
            Connection con = DBConnection.getConnection();

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM students");

            while (rs.next()) {
                Student s = new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("enrollment"),
                        rs.getDouble("attendance"),
                        rs.getDouble("marks"),
                        rs.getDouble("assignment"),
                        rs.getDouble("lastSem"),
                        rs.getDouble("score")
                );
                list.add(s);
            }

            rs.close();
            st.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}