import java.io.*;
import java.net.*;
import java.util.List;

public class MainServer {

    public static void main(String[] args) {

        try {
            ServerSocket server = new ServerSocket(9090);
            System.out.println("Server running at http://localhost:9090");

            while (true) {

                Socket socket = server.accept();
                System.out.println("Request received");

                BufferedWriter out = new BufferedWriter(
                        new OutputStreamWriter(socket.getOutputStream())
                );

                // GET DATA FROM DB
                List<Student> students = StudentDAO.getAllStudents();

                // SEND RESPONSE
                out.write("HTTP/1.1 200 OK\r\n");
                out.write("Content-Type: text/html\r\n\r\n");

                out.write("<html><body>");
                out.write("<h2>Student Data</h2>");

                out.write("<table border='1'>");
                out.write("<tr><th>ID</th><th>Name</th><th>Enrollment</th><th>Score</th></tr>");

                for (Student s : students) {
                    out.write("<tr>");
                    out.write("<td>" + s.getId() + "</td>");
                    out.write("<td>" + s.getName() + "</td>");
                    out.write("<td>" + s.getEnrollment() + "</td>");
                    out.write("<td>" + s.getScore() + "</td>");
                    out.write("</tr>");
                }

                out.write("</table>");
                out.write("</body></html>");

                out.flush();
                socket.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}