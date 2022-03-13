package problem3;

import implementation.Student;
import implementation.StudentListV2;
import org.junit.Assert;
import org.junit.Test;

public class problem3V2 {

    @Test
    public void sortStudentsByNumberAscWithSeveralElementsIncorrectlyOrdered() {
        //Arrange
        Student student1 = new Student(1200145, "Sampaio");
        Student student2 = new Student(1200054, "Moreira");
        Student student3 = new Student(1200086, "Silva");
        Student[] students = {student1, student2, student3};
        Student[] expected = {student2, student3, student1};
        //Act
        boolean result = Student.sortStudentsByNumberAsc(students);
        //Assert
        Assert.assertTrue(result); // check if sort runs with no errors
        Assert.assertArrayEquals(expected, students); //check students is sorted
    }

    @Test
    public void createValidStudent() {
        // Arrange + Act
        Student student = new Student(1190001, "Paulo");
        // Assert
        Assert.assertNotNull(student);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createStudentNegativeNumberWith6Digits() {
        Student student = new Student(-190001, "Paulo Maio");
    }

    @Test(expected = IllegalArgumentException.class)
    public void createStudentNegativeNumberWith7Digits() {
        Student student = new Student(-1190001, "Paulo Maio");

    }

    @Test(expected = IllegalArgumentException.class)
    public void createStudentLongerNumberDigits() {
        Student student = new Student(11900013, "Paulo Maio");

    }

    @Test(expected = IllegalArgumentException.class)
    public void createStudentNameIsEmpty() {
        Student student = new Student(1190001, "");

    }

    @Test(expected = IllegalArgumentException.class)
    public void createStudentNameIsFullOsSpaces() {
        Student student = new Student(1190001, "        ");

    }

    @Test(expected = IllegalArgumentException.class)
    public void createStudentShortNameLength() {
        Student student = new Student(1190001, "Rui");

    }

    @Test(expected = IllegalArgumentException.class)
    public void createStudentInvalidValidNumberButInvalidName() {
        Student student = new Student(1980398, "Bia");

    }


    @Test
    public void createStudentList() {
        //Act
        StudentListV2 stList = new StudentListV2();
        Student[] result = stList.toArray();
        //Assert
        Assert.assertEquals(0, result.length);
    }

    @Test
    public void createStudentListWithSomeElements() {
        //Arrange
        Student student1 = new Student(1200145, "Sampaio");
        Student student2 = new Student(1200054, "Moreira");
        Student student3 = new Student(1200086, "Silva");
        Student[] students = {student1, student2, student3};
        Student[] expected = {student1, student2, student3};
        //Act
        StudentListV2 stList = new StudentListV2(students);
        students[2] = student1;
        Student[] result = stList.toArray();
        //Assert
        Assert.assertArrayEquals(expected, result);
        Assert.assertNotSame(students, result);
    }

    @Test
    public void sortByGradeDescWithSeveralElementsIncorrectlyOrdered() {
        //Arrange
        Student student1 = new Student(1200145, "Sampaio");
        student1.doEvaluation(12);
        Student student2 = new Student(1200054, "Moreira");
        student2.doEvaluation(17);
        Student student3 = new Student(1200086, "Silva");
        student3.doEvaluation(15);
        Student[] students = {student1, student2, student3};
        StudentListV2 stList = new StudentListV2(students);
        Student[] expected = {student2, student3, student1};
        //Act
        stList.sortByGradeDesc();
        Student[] result = stList.toArray();
        //Assert
        Assert.assertArrayEquals(expected, result);
    }


    @Test
    public void equalsTrue() {
        //Arrange
        Student student1 = new Student(1980398, "Beatriz");
        Student student2 = new Student(1980398, "Beatriz Costa");
        //Act
        boolean result = student1.equals(student2);
        //Assert
        Assert.assertTrue(result);
    }

    @Test
    public void equalsTrueToItself() {
        //Arrange
        Student student1 = new Student(1980398, "Beatriz");
        //Act + Assert
        Assert.assertTrue(student1.equals(student1));
    }

    @Test
    public void equalsFalseDueToNull() {
        //Arrange
        Student student1 = new Student(1980398, "Beatriz");
        //Act
        boolean result = student1.equals(null);
        //Assert
        Assert.assertFalse(result);
    }

    @Test
    public void equalsFalseDueToDifferentType() {
        //Arrange
        Student student1 = new Student(1980398, "Beatriz");
        //Act
        boolean result = student1.equals(new String("1980398"));
        //Assert
        Assert.assertFalse(result);
    }

    @Test
    public void equalsFalseDueToDifferentNumbers() {
        //Arrange
        Student student1 = new Student(1980398, "Beatriz");
        Student student2 = new Student(1980399, "Beatriz Costa");
        //Act
        boolean result = student1.equals(student2);
        //Assert
        Assert.assertFalse(result);
    }

    @Test
    public void addWhenNotEmptyButDifferent() {
        //Arrange
        Student student1 = new Student(1200054, "Moreira");
        Student student2 = new Student(1200145, "Sampaio");
        StudentListV2 stList = new StudentListV2();
        stList.add(student1);
        //Act
        boolean result = stList.add(student2);
        Student[] content = stList.toArray();
        //Assert
        Assert.assertTrue(result);
        Assert.assertEquals(2, content.length);
    }

    @Test
    public void addingSameStudentTwice() {
        //Arrange
        Student student1 = new Student(1200054, "Moreira");
        StudentListV2 stList = new StudentListV2();
        stList.add(student1);
        //Act
        boolean result = stList.add(student1);
        Student[] content = stList.toArray();
        //Assert
        Assert.assertFalse(result);
        Assert.assertEquals(1, content.length);
    }

    @Test
    public void addingSameStudentWithSameNumber() {
        //Arrange
        Student student1 = new Student(1200054, "Moreira");
        Student student2 = new Student(1200054, "Sampaio");
        StudentListV2 stList = new StudentListV2();
        stList.add(student1);
        //Act
        boolean result = stList.add(student2);
        Student[] content = stList.toArray();
        //Assert
        Assert.assertFalse(result);
        Assert.assertEquals(1, content.length);
    }

    @Test
    public void addingNull() {
        //Arrange
        Student student1 = new Student(1200054, "Moreira");
        StudentListV2 stList = new StudentListV2();
        stList.add(student1);
        //Act
        boolean result = stList.add(null);
        Student[] content = stList.toArray();
        //Assert
        Assert.assertFalse(result);
        Assert.assertEquals(1, content.length);
    }

    @Test
    public void removingMiddleStudentInSeveral() {
        //Arrange
        Student student1 = new Student(1200054, "Moreira");
        Student student2 = new Student(1200054, "Sampaio");
        Student student3 = new Student(1200054, "Costa");
        Student student4 = new Student(1200054, "Lidia");
        Student student5 = new Student(1200054, "Maria");
        Student[] all = {student1, student2, student3, student4, student5};
        Student[] expected = {student1, student2, student3, student5};
        StudentListV2 stList = new StudentListV2(all);
        //Act
        boolean result = stList.remove(student4);
        Student[] content = stList.toArray();
        //Assert
        Assert.assertTrue(result);
        Assert.assertArrayEquals(expected, content);
    }

    @Test
    public void removingSameStudentTwice() {
        //Arrange
        Student student1 = new Student(1200054, "Moreira");
        StudentListV2 stList = new StudentListV2();
        stList.add(student1);
        //Act
        boolean result1 = stList.remove(student1);
        boolean result2 = stList.remove(student1);
        Student[] content = stList.toArray();
        //Assert
        Assert.assertTrue(result1);
        Assert.assertFalse(result2);
        Assert.assertEquals(0, content.length);
    }


}