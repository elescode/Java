
package program.pkg1;
import java.util.Scanner;

public class Program1 {

    private static java.util.Scanner Key = new java.util.Scanner(System.in);
    private static int number;
    private static char key;

    private static boolean checkData() {
        if (number <= 0) {
            return false;
        } else {
            return true;
        }
    }

    private static void inputData() {
        do {
            System.out.print("Введите натуральное целое число для решения задачи:");
            if (Key.hasNextInt()) {
                number = Key.nextInt();
                if (!checkData()) {
                    System.out.println("Нужно положительное число! Попробуйте снова...");
                    System.out.println();
                } else {
                    break;
                }
            } else {
                System.out.println("Ввод неверный... Попробуйте снова...");
                System.out.println();
                Key.next();
            }
        } while (true);
    }

    private static void printData() {
        if (!checkData()) {
            System.out.println("Нету исходных данных!");
        } else {
            System.out.println("Ввёденное значение: " + number);
        }
    }

    private static void solveTask() {
        switch (number) {
            case 0:
                System.out.println("Нету исходных данных!");
                break;
            case 1:
                System.out.println("Это единица! Всего один множитель - 1.");
                break;
            default: {
                System.out.print("Множители числа " + number + ": 1");
                int n = number;
                int div = 2;
                while (n > 1) {
                    while (n % div == 0) {
                        System.out.print(" * " + div);
                        n = n / div;
                    }
                    div++;
                }
                System.out.println();
                break;
            }
        }
    }

    private static char doMenu() {
        System.out.println();
        System.out.print("Выберите действие:");
        char key;
        key = Key.next().toLowerCase().charAt(0);
        return key;
    }

    public static void main(String[] args) {
        System.out.println("Программа ищет множители положительного числа. Попробуйте ниже!");
        boolean program = true;
        do {
            System.out.println();
            System.out.println("a - посмотреть исходные данные;");
            System.out.println("b - ввести исходные данные;");
            System.out.println("c - решить задачу;");
            System.out.println("d - выйти из программы;");
            char set = doMenu(); 
            switch (set) {
                case 'a':
                    printData();
                    break;
                case 'b':
                    inputData();
                    break;
                case 'c':
                    solveTask();
                    break;
                case 'd':
                    program = false;
                    System.out.print("До свидания!");
                    break;
                default:
                    System.out.println("Ввод неверный... Попробуйте снова...");
                    break;
            }
        } while (program);
    }
    
}
