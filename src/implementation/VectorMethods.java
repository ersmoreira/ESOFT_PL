package implementation;

public class VectorMethods {

    public static int[] sortVectorAsc(int[] vector) {
        if (vector != null) {
            int temp = 0;
            //Sort the vector in ascending order using two for loops
            for (int index1 = 0; index1 < vector.length; index1++) {
                for (int index2 = index1 + 1; index2 < vector.length; index2++) {
                    if (vector[index1] > vector[index2]) {
                        temp = vector[index1];
                        vector[index1] = vector[index2];
                        vector[index2] = temp;
                    }
                }
            }
        }
        return vector;
    }

    public static int[] createCopy(int[] vector) {
        int[] newVector = null;
        if (vector != null){
            newVector = new int[vector.length];
            for (int index = 0; index < vector.length; index++) {
                newVector[index] = vector[index];
            }
        }
        return newVector;
    }
}
