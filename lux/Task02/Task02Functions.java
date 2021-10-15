import java.util.*;
import java.util.stream.Collectors;

public class Task02Functions {
    public static void main(String[] args) {

        System.out.println("1) принимает массив чаров, выводит его на экран");
        char[] chars = {'c', 'd', 'e', 'f', 'g', 'a', 'b'};
        printChars(chars);
        System.out.println();

        System.out.println("2) принимает массив интов, возвращает массив чаров, каждый символ в позиции массива соответствует коду символа передаваемого инта");
        int[] ints = {74, 65, 86, 65};
        char[] charsFromInt = convertInts2Chars(ints);
        System.out.println(charsFromInt);
        System.out.println();

        System.out.println("3) приминает 2 инта, а и б, возвращает большее их этих 2х чисел");
        int a = 3, b = 9;
        int maxValue = getMaxInt(a, b);
        System.out.println(String.format("max(%d, %d) = %d", a, b, maxValue));
        System.out.println();

        System.out.println("4) принимает 3 инта, возвращает большее из них");
        int c = 13;
        maxValue = getMaxInt(a, b, c);
        System.out.println(String.format("max(%d, %d, %d) = %d", a, b, c, maxValue));
        System.out.println();

        System.out.println("5) приминает 5 интов, возвращает большее из них");
        int d = 130, e = 2048;
        maxValue = getMaxInt(a, b, c, d, e);
        System.out.println(String.format("max(%d, %d, %d, %d, %d) = %d", a, b, c, d, e, maxValue));
        System.out.println();

        System.out.println("6) принимает массив чаров, возвращает строку состоящую из символов массива");
        String stringFromChars = getStringFromChars(chars);
        System.out.println(stringFromChars);
        System.out.println();

        System.out.println("8) принимает массив интов, и значение типа инт, возвращает индекс массива в котором значение совпадает с передаваемым, начиная с начала массива. Если значения в массиве нет возвращает -1");
        int[] intArray = {1, 1, 2, 3, 5, 8, 13};
        int searchIntValue = 13;
        int index = getIntIndexFromArray(intArray, searchIntValue);
        System.out.println(String.format("Index of %d in %s is %d", searchIntValue, Arrays.toString(intArray), index));
        searchIntValue = 7;
        index = getIntIndexFromArray(intArray, searchIntValue);
        System.out.println(String.format("Index of %d in %s is %d", searchIntValue, Arrays.toString(intArray), index));
        System.out.println();

        System.out.println("9) принимает массив интов, и значение типа инт, возвращает индекс массива в котором значение совпадает с передаваемым, начиная с конца массива. Если значения в массиве нет возвращает -1");
        searchIntValue = 13;
        index = getIntIndexFromArrayReverse(intArray, searchIntValue);
        System.out.println(String.format("Index of %d in %s is %d", searchIntValue, Arrays.toString(intArray), index));
        searchIntValue = 7;
        index = getIntIndexFromArrayReverse(intArray, searchIntValue);
        System.out.println(String.format("Index of %d in %s is %d", searchIntValue, Arrays.toString(intArray), index));
        System.out.println();

        System.out.println("10) метод принимает инт, и возвращает факториал от заданого инта");
        int factorialValue = factorial(a);
        System.out.println(String.format("%d! = %d", a, factorialValue));
        System.out.println();

        System.out.println("11) принимает инт год, и возвращает тру если год высокосный");
        int year;
        boolean isLeap;
        year = 2020;
        isLeap = isLeapYear(year);
        System.out.println(String.format("%d is %s", year, isLeap ? "leap" : "not leap"));
        year = 2000;
        isLeap = isLeapYear(year);
        System.out.println(String.format("%d is %s", year, isLeap ? "leap" : "not leap"));
        year = 1900;
        isLeap = isLeapYear(year);
        System.out.println(String.format("%d is %s", year, isLeap ? "leap" : "not leap"));
        System.out.println();

        System.out.println("12) приминает массив интов и число, выводит на екран только елементы массива которые кратны этому числу");
        int[] intArray2 = {2, 4, 8, 16, 32};
        a = 8;
        printIntMultiplies(intArray2, a);
        System.out.println();

        System.out.println("13) метод принимает массив интов сортирует его по возрастанию");
        int[] randomNumbers = new int[5];
        Random random = new Random();
        for (int i = 0; i < randomNumbers.length; i++) {
            randomNumbers[i] = random.nextInt(100);
        }
        int[] sortedNumbers = Arrays.copyOf(randomNumbers, randomNumbers.length);
        sortAsc(sortedNumbers);
        System.out.println(String.format("%s sorted: %s", Arrays.toString(randomNumbers), Arrays.toString(sortedNumbers)));
        System.out.println();

        System.out.println("14) принимает массив байт, если в массиве есть повторяющиеся елементы, возвращает тру");
        byte[] duplicatesArray = {1, 3, 5, 3, 6};
        byte[] noDuplicatesArray = {1, 3, 5, 2, 6};
        boolean hasDuplicates;
        hasDuplicates = hasDuplicates(duplicatesArray);
        System.out.println(String.format("%s has duplicates? %s", Arrays.toString(duplicatesArray), hasDuplicates));
        hasDuplicates = hasDuplicates(noDuplicatesArray);
        System.out.println(String.format("%s has duplicates? %s", Arrays.toString(noDuplicatesArray), hasDuplicates));
        hasDuplicates = hasDuplicatesWithSet(duplicatesArray);
        System.out.println(String.format("%s has duplicates? %s", Arrays.toString(duplicatesArray), hasDuplicates));
        hasDuplicates = hasDuplicatesWithSet(noDuplicatesArray);
        System.out.println(String.format("%s has duplicates? %s", Arrays.toString(noDuplicatesArray), hasDuplicates));
        System.out.println();

        System.out.println("15) принимает два массива интов одинаковых по длинне, возращает массив интов который состоит из перемноженных елементов входящих массивов");
        int[] multipiersArray1 = {1, 3, 5};
        int[] multipiersArray2 = {2, 4, 6};
        int[] multiplicationResult = multiplyArrayElements(multipiersArray1, multipiersArray2);
        System.out.println(String.format("%s elements * %s elements = %s",
                Arrays.toString(multipiersArray1), Arrays.toString(multipiersArray2), Arrays.toString(multiplicationResult)));
        System.out.println();

        System.out.println("16) принимает два массива интов, возвращает массив из елементов которые не совпадают в массивах");
        int[] inputArray1 = {1, 1, 2, 3, 5, 8, 13, 21};
        int[] inputArray2 = {1, 3, 5, 7, 13};
        int[] uniqueArray = getUniqueElements(inputArray1, inputArray2);
        System.out.println(String.format("Unique numbers from %s and %s are: %s",
                Arrays.toString(inputArray1), Arrays.toString(inputArray2), Arrays.toString(uniqueArray)));
        System.out.println();

        System.out.println("17) принимает масив интов, возвращает его же но в реверсном порядке");
        int[] reversedArray1 = getReversedArray(inputArray1);
        System.out.println(String.format("Reversed %s: %s", Arrays.toString(inputArray1), Arrays.toString(reversedArray1)));
        int[] reversedArray2 = getReversedArray(inputArray2);
        System.out.println(String.format("Reversed %s: %s", Arrays.toString(inputArray2), Arrays.toString(reversedArray2)));
        System.out.println();

        System.out.println("18) принимает 3 инта:");
        System.out.println(" - размер выходного массива");
        System.out.println(" - нижняя граница");
        System.out.println(" - верхняя граница");
        System.out.println(" возвращает массив интов заданой длинный, который содержит случайные числа от нижней границы до верхней границы");
        int size = 5;
        int min = 10;
        int max = 20;
        int[] randomValues1 = generateRandomValues(size, min, max);
        System.out.println(String.format("size = %d, min = %d, max = %d: %s", size, min, max, Arrays.toString(randomValues1)));
        int[] randomValues2 = generateRandomValues2(size, min, max);
        System.out.println(String.format("size = %d, min = %d, max = %d: %s", size, min, max, Arrays.toString(randomValues2)));
        System.out.println();

        System.out.println("19) принимает 2 массива чаров, проверяет есть ли в 1 массиве, такая же последовательность символов которую представляет собой второй массив. Возвращает булеан");
        char[] string = {'H', 'e', 'l', 'l', 'o', ',', ' ', 'w', 'o', 'r', 'l', 'd', '!'};
        char[] substr1 = {'w', 'o', 'r', 'l', 'd'};
        char[] substr2 = {'b', 'y', 'e'};
        boolean hasSubstring;
        hasSubstring = hasSubstring(string, substr1);
        System.out.println(String.format("Has \"%s\" string \"%s\" inside? %s", String.valueOf(string), String.valueOf(substr1), hasSubstring));
        hasSubstring = hasSubstring(string, substr2);
        System.out.println(String.format("Has \"%s\" string \"%s\" inside? %s", String.valueOf(string), String.valueOf(substr2), hasSubstring));
        System.out.println();
    }

    public static void printChars(char[] chars) {
        System.out.println(chars);
    }

    public static char[] convertInts2Chars(int[] ints) {
        char[] result = new char[ints.length];
        for (int i = 0; i < ints.length; i++) {
            result[i] = (char)ints[i];
        }
        return result;
    }

    public static int getMaxInt(int a, int b) {
        return Math.max(a, b);
    }

    public static int getMaxInt(int a, int b, int c) {
        return getMaxInt(a, getMaxInt(b, c));
    }

    public static int getMaxInt(int a, int b, int c, int d, int e) {
        return getMaxInt(a, b, getMaxInt(c, d, e));
    }

    public static String getStringFromChars(char[] chars) {
        return new String(chars);
    }

    public static int getIntIndexFromArray(int[] intArray, int value) {
        int index = -1;
        for (int i = 0; i < intArray.length; i++) {
            if (intArray[i] == value) {
                index = i;
                break;
            }
        }
        return index;
    }

    public static int getIntIndexFromArrayReverse(int[] intArray, int value) {
        int index = -1;
        for (int i = intArray.length - 1; i >= 0; i--) {
            if (intArray[i] == value) {
                index = i;
                return intArray.length - index - 1;
            }
        }
        return index;
    }

    public static int factorial(int x) {
        if (x == 0) {
            return 1;
        } else {
            return x * factorial(x - 1);
        }
    }

    public static boolean isLeapYear(int year) {
        return ((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0);
    }

    public static void printIntMultiplies(int[] numbers, int value) {
        Arrays.stream(numbers).filter(number -> number % value == 0).forEach(System.out::println);
    }

    public static void sortAsc(int[] numbers) {
        Arrays.sort(numbers);
    }

    public static boolean hasDuplicates(byte[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] == numbers[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean hasDuplicatesWithSet(byte[] numbers) {
        Set<Byte> set = new HashSet<Byte>();
        for (byte number : numbers) {
            set.add(number);
        }
        return numbers.length != set.size();
    }

    public static int[] multiplyArrayElements(int[] multipiersArray1, int[] multipiersArray2) {
        int[] result = new int[multipiersArray1.length];
        for (int i = 0; i < multipiersArray1.length; i++) {
            result[i] = multipiersArray1[i] * multipiersArray2[i];
        }
        return result;
    }

    public static int[] getUniqueElements(int[] inputArray1, int[] inputArray2) {
        Set<Integer> set1 = Arrays.stream(inputArray1).boxed().collect(Collectors.toSet());
        Set<Integer> set2 = Arrays.stream(inputArray2).boxed().collect(Collectors.toSet());
        Set<Integer> setA = new HashSet<Integer>(set1);
        setA.removeAll(set2);
        Set<Integer> setB = new HashSet<Integer>(set2);
        setB.removeAll(set1);
        setA.addAll(setB);
        int[] result = setA.stream().mapToInt(Number::intValue).toArray();
        return result;
    }

    public static int[] getReversedArray(int[] numbers) {
        int[] result = new int[numbers.length];
        int N = numbers.length;
        for (int i = 0; i < N; i++) {
            result[i] = numbers[N - i - 1];
        }
        return result;
    }

    public static int[] generateRandomValues(int size, int min, int max) {
        int[] result = new int[size];
        Random random = new Random();
        int diff = max - min + 1;
        result = Arrays.stream(result).map(x -> random.nextInt(diff) + min).toArray();
        return result;
    }

    public static int[] generateRandomValues2(int size, int min, int max) {
        Random random = new Random();
        int[] result = random.ints(size, min, max + 1).toArray();
        return result;
    }

    public static boolean hasSubstring(char[] haystack, char[] needle) {
        String haystackString = new String(haystack);
        String needleString = new String(needle);
        int index = haystackString.indexOf(needleString);
        return index != -1;
    }
}
