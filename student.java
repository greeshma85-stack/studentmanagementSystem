
class Student {
    int rollNo;
    String name;
    ArrayList<Integer> marks;

    // Constructor
    Student(int rollNo, String name) {
        this.rollNo = rollNo;
        this.name = name;
        this.marks = new ArrayList<>();
    }

    // Add mark
    void addMark(int mark) {
        marks.add(mark);
    }

    // Calculate average
    double calculateAverage() {
        int sum = 0;
        for (int m : marks) {
            sum += m;
        }
        return marks.size() == 0 ? 0 : (double) sum / marks.size();
    }

    // Display student details
    void display() {
        System.out.println("Roll No : " + rollNo);
        System.out.println("Name    : " + name);
        System.out.println("Marks   : " + marks);
        System.out.println("Average : " + calculateAverage());
        System.out.println(calculateAverage() >= 40 ? "Status  : Pass" : "Status  : Fail");
        System.out.println("----------------------------------");
    }
}
