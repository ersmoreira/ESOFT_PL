package implementation;

public class Student {

    private int number;
    private String name;
    private int grade;

    public Student(int number, String name) {
        if (!this.isValidNumber(number)) {
            throw new IllegalArgumentException("Student number needs to be 7 digits number.");
        }
        if (!this.isValidName(name)) {
            throw new IllegalArgumentException("Student name cannot be shorter than 5 chars.");
        }
        this.number = number;
        this.name = name.trim();
        this.grade = -1;
    }

    private boolean isValidNumber(int number) {
        if (number != Math.abs(number)) {
            return false;
        }
        String strNumber = Integer.toString(number);
        return strNumber.length() == 7;
    }

    private boolean isValidName(String name) {
        if (name == null) {
            return false;
        }
        name = name.trim();
        return !(name.length() < 5);
    }

    private boolean isValidGrade(int grade) {
        return true;
    }

    private boolean isEvaluated() {
        return this.grade >= 10;
    }

    public int getNumber() {
        return this.number;
    }

    public String getName(){
        return this.name;
    }

    public int getGrade() {
        return this.grade;
    }

    public int compareToByNumber(Student other) {
        if (this.getNumber() < other.getNumber()) {
            return -1;
        }
        if (this.getNumber() > other.getNumber()) {
            return 1;
        }
        return 0;
    }

    public int compareToByGrade(Student other) {
        if (this.getGrade() < other.getGrade()) {
            return -1;
        }
        if (this.getGrade() > other.getGrade()) {
            return 1;
        }
        return 0;
    }

    public void doEvaluation(int grade) {
        if (!this.isEvaluated() && this.isValidGrade(grade)) {
            this.grade = grade;
        }
    }

    public static boolean sortStudentsByNumberAsc(Student[] students) {
        if (students == null) {
            return false;
        }

        Student tempStudent = null;

        for (int index1 = 0; index1 < students.length; index1++) {
            for (int index2 = index1 + 1; index2 < students.length; index2++) {
                if (students[index1].compareToByNumber(students[index2]) > 0) {
                    tempStudent = students[index1];
                    students[index1] = students[index2];
                    students[index2] = tempStudent;
                }
            }
        }

        return true;
    }

    public boolean equals(Object o){
        if (this == o){
            return true;
        }
        if (o == null || getClass() != o.getClass()){
            return false;
        }
        Student student = (Student) o;
        return this.getNumber() == student.getNumber();
    }

    public static boolean sortStudentsByGradesDesc(Student[] students) {
        return false;
    }
}
