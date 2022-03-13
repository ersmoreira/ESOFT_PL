package implementation;

import java.util.ArrayList;
import java.util.Comparator;

public class StudentListV2 {

    private ArrayList<Student> students;

    public StudentListV2() {
        this.students = new ArrayList();
    }

    public StudentListV2(Student[] students) {
        if (students == null) {
            throw new IllegalArgumentException("Students array shuould not be null");
        }
        this.students = new ArrayList();
        for (Student st : students) {
            this.add(st);
        }
    }

    public boolean add(Student student) {
        if (student == null) {
            return false;
        }
        if (this.students.contains(student)) {
            return false;
        }
        return this.students.add(student);
    }

    public boolean remove(Student student) {
        if (student == null) {
            return false;
        }
        if (!this.students.contains(student)) {
            return false;
        }
        return this.students.remove(student);
    }

    public void sortByNumberAsc() {
        this.students.sort(new SortByNumber());
    }

    public void sortByGradeDesc() {
        this.students.sort(new SortByGradeDesc());
    }

    public Student[] toArray() {
        Student[] array = new Student[this.students.size()];
        return this.students.toArray(array);
    }

    private class SortByNumber implements Comparator<Student> {
        public int compare(Student student1, Student student2) {
            return student1.compareToByNumber(student2);
        }
    }

    private class SortByGradeDesc implements Comparator<Student> {
        public int compare(Student student1, Student student2) {
            return student1.compareToByGrade(student2) * (-1);
        }
    }
}
