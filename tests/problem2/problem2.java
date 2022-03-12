package problem2;

import org.junit.Assert;
import implementation.VectorMethods;
import org.junit.Test;

public class problem2 {

    @Test
    public void createCopyOfEmpty() {
        //Arrange
        int[] original = {};
        int[] expected = {};
        //Act
        int[] result = VectorMethods.createCopy(original);
        //Assert
        Assert.assertNotSame(original, result); // check that vectors are not the same
        Assert.assertEquals(original.length, result.length); // check dimension
        Assert.assertEquals(expected.length, result.length); // check dimension
        Assert.assertArrayEquals(expected, result); // check vector content
    }

    @Test
    public void createCopyOfNull() {
        //Act
        int[] result = VectorMethods.createCopy(null);
        //Assert
        Assert.assertNull(result);
    }

    @Test
    public void createCopyOfOneElement() {
        //Arrange
        int[] original = {1};
        int[] expected = {1};
        //Act
        int[] result = VectorMethods.createCopy(original);
        //Assert
        Assert.assertNotSame(original, result); // check that vectors are not the same
        Assert.assertEquals(original.length, result.length); // check dimension
        Assert.assertEquals(expected.length, result.length); // check dimension
        Assert.assertArrayEquals(expected, result); // check vector content
    }

    @Test
    public void createCopyOfSeveralElements() {
        //Arrange
        int[] data = {-21, 30, 20, 12, 34, 12, 55, 0, -1, -9};
        int[] expected = {-21, 30, 20, 12, 34, 12, 55, 0, -1, -9};
        //Act
        int[] result = VectorMethods.createCopy(data);
        //Assert
        Assert.assertNotSame(data, result); // check that vectors are not the same
        Assert.assertEquals(data.length, result.length); // check dimension
        Assert.assertEquals(expected.length, result.length); // check dimension
        Assert.assertArrayEquals(expected, result); // check vector content
    }

    @Test
    public void createCopyOfSeveralElementsPlusChanges() {
        //Arrange
        int[] original = {31, 21, 4, 34};
        int[] expected = {31, 21, 5, 34};
        //Act
        int[] result = VectorMethods.createCopy(original);
        result[2] = 5;
        //Assert
        Assert.assertNotSame(original, result); // check that vectors are not the same
        Assert.assertNotSame(expected, result); // check that vectors are not the same
        Assert.assertEquals(expected.length, result.length); // check dimension
        Assert.assertArrayEquals(expected, result); // check vector content
    }


}
