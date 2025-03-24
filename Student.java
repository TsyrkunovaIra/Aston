public class Student implements Comparable<Student> {
    private int groupNumber;
    private int bookNumber;
    private double avgGrade;

    public Student(int groupNumber, int bookNumber, double avrgGrade) {
        this.groupNumber = groupNumber;
        this.bookNumber = bookNumber;
        this.avgGrade = avrgGrade;
    }

    private Student(StudentBuilder SB)
    {
        groupNumber = SB.groupNumber;
        bookNumber = SB.bookNumber;
        avgGrade = SB.avgGrade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "groupNumber=" + groupNumber +
                ", bookNumber=" + bookNumber +
                ", avrgGrade=" + avgGrade +
                '}';
    }

    public int compareTo(Student other)
    {
        double epsilon = 0.00001;
        double diff = this.avgGrade - other.avgGrade;


        if(this.groupNumber != other.groupNumber)
            return Integer.compare(this.groupNumber, other.groupNumber);
        if(this.bookNumber != other.bookNumber)
            return Integer.compare(this.bookNumber, other.bookNumber);

        if(Math.abs(diff) < epsilon)
            return 0;
        else if(diff < 0)
            return -1;
        else return 1;
    }

    public static class StudentBuilder {
        private int groupNumber;
        private int bookNumber;
        private double avgGrade;

        public StudentBuilder(int bookNumber) {
            this.bookNumber = bookNumber;
        }

        public StudentBuilder setGroupNumber(int groupNumber) {
            this.groupNumber = groupNumber;
            return this;
        }

        public StudentBuilder setAvgGrade(double avgGrade) {
            this.avgGrade = avgGrade;
            return this;
        }

        public Student build() {
            return new Student(this);
        }
    }
}
