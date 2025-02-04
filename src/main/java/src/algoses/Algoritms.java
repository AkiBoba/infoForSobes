package src.algoses;

public class Algoritms {
    public static void main(String[] args) {
        int[] array = {1, 3, 6, 4, 0, 9, 5, 1};
        getArray(array, 1, 3);

}

//поиск минимального элемента в массиве на интервале [left0, right0]

    static int[][] getArray(int[] array, int left0, int right0) {
        int[][] memoryArray = new int[array.length][array.length];

        for (int left = 0; left < array.length; left++) {
            int min = array[left];
            for (int right = left + 1; right < array.length; right++) {
                memoryArray[left][right] = min;
                if (array[right] < min) {
                    min = array[right];
                    memoryArray[left][right] = min;
                }
            }
        }

        System.out.println(memoryArray[left0][right0]);
        return memoryArray;
    }
}
