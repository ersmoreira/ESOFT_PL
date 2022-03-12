package problem1;

import implementation.VectorMethods;
import org.junit.Assert;
import org.junit.Test;

public class Problem1 {

    @Test
    public void SortVectorAscWithNull() {
        //Act
        int[] result = VectorMethods.sortVectorAsc(null);
        //Assert
        Assert.assertNull(result);
    }

    @Test
    public void sortVectorAscBeingEmpty() {
        //Arrange
        int[] data = {};
        int[] expected = {};
        //Act
        int[] result = VectorMethods.sortVectorAsc(data);
        //Assert
        Assert.assertSame(data, result);
        Assert.assertEquals(expected.length, result.length);
        Assert.assertArrayEquals(expected, result);
    }

    @Test
    public void sortVectorAscWithOneElements() {
        //Arrange
        int[] data = {4};
        int[] expected = {4};
        //Act
        int[] result = VectorMethods.sortVectorAsc(data);
        //Assert
        Assert.assertSame(data, result);
        Assert.assertEquals(expected.length, result.length);
        Assert.assertArrayEquals(expected, result);
    }

    @Test
    public void sortVectorAscWithTwoElementsCorretlyOrdered() {
        //Arrange
        int[] data = {-1, 4};
        int[] expected = {-1, 4};
        //Act
        int[] result = VectorMethods.sortVectorAsc(data);
        //Assert
        Assert.assertSame(data, result);
        Assert.assertEquals(expected.length, result.length);
        Assert.assertArrayEquals(expected, result);
    }

    @Test
    public void sortVectorAscWithTwoElementsIncorrectlyOrdered() {
        //Arrange
        int[] data = {30, 25};
        int[] expected = {25, 30};
        //Act
        int[] result = VectorMethods.sortVectorAsc(data);
        //Assert
        Assert.assertSame(data, result);
        Assert.assertEquals(expected.length, result.length);
        Assert.assertArrayEquals(expected, result);
    }

    @Test
    public void sortVectorAscWithSeveralElementsIncorrectlyOrdered() {
        //Arrange
        int[] data = {30, 25, 25, -1, 20};
        int[] expected = {-1, 20, 25, 25, 30};
        //Act
        int[] result = VectorMethods.sortVectorAsc(data);
        //Assert
        Assert.assertSame(data, result);
        Assert.assertEquals(expected.length, result.length);
        Assert.assertArrayEquals(expected, result);
    }
}
