import java.util.Random;

/**
 * Основной класс
 */
public class Sample01 {
    /**
     * Точка входа в программу
     * @param args
     */
    public static void main(String[] args) {

        // Массив для первой задачи
        int[] arrayForTask1 = { 1, 1, 0, 0, 1, 0, 1, 1, 0, 0};

        // Выполнение первой задачи
        showOneDimensionalArray(arrayForTask1);
        replaceZeroToOne(arrayForTask1);
        showOneDimensionalArray(arrayForTask1);

        // Массив для второй задачи
        int[] arrayForTask2 = new int[8];

        // Выполнение второй задачи

        for (int i = 0; i < arrayForTask2.length; i++) {

            arrayForTask2[i] = i * 3;

        }

        showOneDimensionalArray(arrayForTask2);

        // Массив для третьей задачи
        int[] arrayForTask3 = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };

        // Выполнение третьей задачи

        showOneDimensionalArray(arrayForTask3);

        for (int i = 0; i < arrayForTask3.length; i++) {

            if (arrayForTask3[i] < 6) {
                arrayForTask3[i] *= 2;
            }

        }

        showOneDimensionalArray(arrayForTask3);

        // Массив для четвёртой задачи
        int[][] arrayForTask4 = new int[5][5];
        Random random = new Random();

        // Выполнение четвёртой задачи

        for (int i = 0; i < arrayForTask4.length; i++) {

            for (int j = 0; j < arrayForTask4[i].length; j++) {

                if (i == j || i + j == arrayForTask4.length - 1) {

                    arrayForTask4[i][j] = 1;

                } else {

                    arrayForTask4[i][j] = random.nextInt(10);

                }

                System.out.print(arrayForTask4[i][j] + " ");

            }

            System.out.println();

        }

        // Массив для пятой задачи**
        int[] arrayForTask5 = { -15, -10, -5, 777, -222, 0, 5, 10, 15};

        // Выполнение пятой задачи
        System.out.println("Индекс максимального элемента : " + findMaxElementOfArray(arrayForTask5));
        System.out.println("Значение максимального элемента : " + arrayForTask5[findMaxElementOfArray(arrayForTask5)]);

        System.out.println("Индекс минимального элемента : " + findMinElementOfArray(arrayForTask5));
        System.out.println("Значение минимального элемента : " + arrayForTask5[findMinElementOfArray(arrayForTask5)]);

        // Массив для шестой задачи**
        int[] arrayForTask6 = { 2, 2, 2, 1, 2, 2, 10, 1};

        // Выполнение шестой задачи
        System.out.println(isLeftSideEqualRightSide(arrayForTask6));

        // Массив для седьмой задачи****
        int[] arrayForTask7 = { 1, 2, 3, 4, 5, 6};

        // Выполнение седьмой задачи****
        arrayShift(arrayForTask7, -2);
        showOneDimensionalArray(arrayForTask7);
    }

    /**
     * Метод для сдвига элементов на указанное число
     * @param array массив который двигаем
     * @param shift количество сдвигов
     */
    public static void arrayShift(int[] array, int shift) {

        int lastElement = array[0];
        int test = 0;

        if (shift > 0) {

            for (int j = 1; j <= shift; j++) {

                for (int i = 0; i < array.length; i++) {

                    if (i == 0)
                        continue;
                    test = array[i];
                    array[i] = lastElement;


                    lastElement = test;
                }

            }

            array[0] = lastElement;

        } else {

            for (int j = 1; j <= -shift; j++) {

                for (int i = array.length - 1; i > 0; i--) {

                    test = array[i];
                    array[i] = lastElement;


                    lastElement = test;
                }

            }

            array[0] = lastElement;

        }



    }

    /**
     * Метод для определения есть ли в массиве точка в которой сумма элементов массива левой и правой части массива равны
     * @param array массив с которым работает
     * @return возвращаем истину если такая точка в массиве есть, возвращаем false если такой точки в массиве нет.
     */
    public static boolean isLeftSideEqualRightSide(int[] array) {

        boolean result = false;

        int leftSide = 0;
        int rightSide = 0;

        for (int i = 0; i < array.length; i++) {

            leftSide += array[i];

            for (int j = i + 1; j < array.length; j++) {

                rightSide += array[j];

                if (rightSide > leftSide) {

                    rightSide = 0;
                    break;
                }

            }

            // System.out.print(array[i] + " ");

            if (leftSide == rightSide) {
                result = true;
                // System.out.print("|| ");
                break;
            }

        }

        return result;
    }

    /**
     * Метод для нахождения индекса максимального элемента в массиве
     * @param array Массив в котором ищем максимальный элемент
     * @return возвращаем индекс максимального элемента
     */
    public static int findMaxElementOfArray(int[] array) {

        int max = array[0];
        int result = 0;

        for (int i = 0; i < array.length; i++) {

            if (array[i] > max) {

                max = array[i];
                result = i;

            }

        }

        return result;
    }

    /**
     * Метод для нахождения индекса минимального элемента в массиве
     * @param array Массив в котором ищем минимальный элемент
     * @return возвращаем индекс минимальный элемента
     */
    public static int findMinElementOfArray(int[] array) {

        int min = array[0];
        int result = 0;

        for (int i = 0; i < array.length; i++) {

            if (array[i] < min) {

                min = array[i];
                result = i;

            }

        }

        return result;
    }

    /**
     * Метод для вывода одномерного массива
     * @param array на вход подаётся одномерный массив который нужно вывести
     */
    public static void showOneDimensionalArray(int[] array) {

        for (int i = 0; i < array.length; i++) {

            System.out.print(array[i] + " ");

        }

        System.out.println();

    }

    /**
     * Метод для замены всех единиц в массиве на ноль и наобарот
     * @param array массив который нужно изменить
     */
    public static void replaceZeroToOne(int[] array) {

        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0)
                array[i] = 1;
            else
                array[i] = 0;
        }

    }
}
