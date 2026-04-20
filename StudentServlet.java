import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class StudentServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws IOException {

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/edupulse",
                    "root",
                    "WJ28krhps"
            );

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM students");

            out.println("<html><body>");
            out.println("<h2>Student Data</h2>");
            out.println("<table border='1'>");
            out.println("<tr><th>ID</th><th>Name</th><th>Enrollment</th><th>Score</th></tr>");

            while (rs.next()) {
                out.println("<tr>");
                out.println("<td>" + rs.getInt("id") + "</td>");
                out.println("<td>" + rs.getString("name") + "</td>");
                out.println("<td>" + rs.getString("enrollment") + "</td>");
                out.println("<td>" + rs.getDouble("score") + "</td>");
                out.println("</tr>");
            }

            out.println("</table>");
            out.println("</body></html>");

            rs.close();
            st.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace(out);
        }
    }
}