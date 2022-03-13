package implementation;

public class StudentList {

    // Internal list of students - stored as an array
    private Student[] students;

    //Create an empty student list
    public StudentList() {
        this.students = new Student[0];
    }

    //Creates a new StudentList and populates with input students
    public StudentList(Student[] students) {
        if (students == null) {
            throw new IllegalArgumentException("Students arrays should not be null");
        }
        this.students = copyStudentsFromArray(students, students.length);
    }

    // Sort the list using students number
    public void sortByNumberAsc() {
        Student tempStudent = null;
        for (int index1 = 0; index1 < this.students.length; index1++) {
            for (int index2 = index1 + 1; index2 < this.students.length; index2++) {
                if (this.students[index1].compareToByNumber(this.students[index2]) > 0) {
                    tempStudent = this.students[index1];
                    this.students[index1] = this.students[index2];
                    this.students[index2] = tempStudent;
                }
            }
        }
    }

    // Sort the list using students grade
    public void sortByGradeDesc() {
        Student tempStudent = null;
        for (int index1 = 0; index1 < this.students.length; index1++) {
            for (int index2 = index1 + 1; index2 < this.students.length; index2++) {
                if (this.students[index1].compareToByGrade(this.students[index2]) < 0) {
                    tempStudent = this.students[index1];
                    this.students[index1] = this.students[index2];
                    this.students[index2] = tempStudent;
                }
            }
        }
    }

    // Returns a copy of students stored in the list as an array
    public Student[] toArray() {
        return this.copyStudentsFromArray(this.students, this.students.length);
    }

    private Student[] copyStudentsFromArray(Student[] students, int size) {
        return this.copyStudentsFromArray(students, 0, size);
    }

    private Student[] copyStudentsFromArray(Student[] students, int start, int size) {
        Student[] copyArray = new Student[size];
        int count = 0;
        for (int idx = start; (count < size && idx < students.length); idx++) {
            copyArray[idx - start] = students[idx];
            count++;
        }
        return copyArray;
    }

    private Student[] join(Student[] student1, Student[] student2) {
        int size = student1.length + student2.length;
        Student[] copyArray = new Student[size];

        for (int idx = 0; idx < student1.length; idx++) {
            copyArray[idx] = student1[idx];
        }

        for (int idx = 0; idx < student2.length; idx++) {
            copyArray[idx + student1.length] = student2[idx];
        }
        return copyArray;
    }

    public boolean add(Student student) {
        if (student == null) {
            return false;
        }
        if (this.exists(student)) {
            return false;
        }
        this.students = copyStudentsFromArray(this.students, this.students.length + 1);
        this.students[this.students.length - 1] = student;
        return true;
    }

    private boolean exists(Student student) {
        if (student == null) {
            return false;
        }
        for (int index = 0; index < this.students.length; index++) {
            if (this.students[index].getNumber() == student.getNumber()) {
                return true;
            }
        }
        return false;
    }

    private int getIndexOf(Student student) {
        if (student == null) {
            return -1;
        }
        for (int index = 0; index < this.students.length; index++) {
            if (this.students[index].getNumber() == student.getNumber()) {
                return index;
            }
        }
        return -1;
    }

    public boolean remove(Student student) {
        if (student == null) {
            return false;
        }
        int idx = this.getIndexOf(student);
        if (idx < 0) {
            return false;
        }
        Student[] leftSide = this.copyStudentsFromArray(this.students, idx);
        Student[] rightSide = this.copyStudentsFromArray(this.students, idx + 1, this.students.length - idx - 1);
        this.students = join(leftSide, rightSide);
        return true;
    }

}
