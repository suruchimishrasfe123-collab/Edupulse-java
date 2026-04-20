public class Student {

    private int id;
    private String name;
    private String enrollment;
    private double attendance;
    private double marks;
    private double assignment;
    private double lastSem;
    private double score;

    public Student(int id, String name, String enrollment,
                   double attendance, double marks,
                   double assignment, double lastSem, double score) {

        this.id = id;
        this.name = name;
        this.enrollment = enrollment;
        this.attendance = attendance;
        this.marks = marks;
        this.assignment = assignment;
        this.lastSem = lastSem;
        this.score = score;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getEnrollment() { return enrollment; }
    public double getScore() { return score; }
}