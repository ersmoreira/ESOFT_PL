package implementation;

public class studentsList2_poc {

    public static void main(String[] args) {

        Student s1 = new Student(1000001, "Joaquim");
        Student s2 = new Student(1000002, "António");
        Student s3 = new Student(1000003, "Maria");

        StudentListV2 sl = new StudentListV2();
        sl.add(s2);
        sl.add(s1);
        sl.add(s3);

        sl.sortByNumberAsc();

        Student[] students = sl.toArray();
        for (Student student : students) {
            System.out.printf("Número: %3d -> Nome: %s%n", student.getNumber(), student.getName());
        }

    }

}
