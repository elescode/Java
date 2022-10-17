package program.pkg2;
import java.util.Scanner;

public class Program2 {

    public static Scanner scanner = new Scanner(System.in);
    public static char key;
    public static double n;
    public static Conus conus = new Conus(0, 0);

    public static char doMenu() {
        System.out.println();
        System.out.println("Выберите действие:");
        System.out.println("a - создать конус;");
        System.out.println("b - выполнить действия с конусом;");
        System.out.println("c - посмотреть состояние конуса;");
        System.out.println("d - выйти из программы...");
        char key;
        key = scanner.next().toLowerCase().charAt(0);
        return key;
    }

    public static boolean checkData() {
        if (n <= 0) {
            return false;
        } else {
            return true;
        }
    }

    public static double inputData() {
        do {
            System.out.print("Введите значение: ");
            if (scanner.hasNextDouble()) {
                n = scanner.nextDouble();
                if (!checkData()) {
                    System.out.println("Значение может быть только положительным числом! Попробуйте снова...");
                    System.out.println();
                } else {
                    return n;
                }
            } else {
                System.out.println("Ввод неверный... Попробуйте снова...");
                System.out.println();
                scanner.next();
            }
        } while (true);
    }

    public static void createObject() {
        System.out.println("Вы решили создать конус.");
        System.out.println("Введите радиус основания конуса.");
        conus.setR(inputData());
        System.out.println("Введите высоту конуса.");
        conus.setH(inputData());
    }

    public static char doSolveMenu() {
        System.out.println();
        System.out.println("Выберите действие:");
        System.out.println("a - найти объём конуса;");
        System.out.println("b - найти площадь основания конуса;");
        System.out.println("c - найти площадь боковой поверхности конуса;");
        System.out.println("d - найти площадь всей поверхности конуса;");
        System.out.println("e - найти площадь сечения конуса на заданной высоте;");
        System.out.println("f - проверить вложен ли другой конус в этот;");
        System.out.println("g - вернуться...");
        char key;
        key = scanner.next().toLowerCase().charAt(0);
        return key;
    }

    public static void solveTask() {
        if (conus.getR() == 0 || conus.getH() == 0) {
            System.out.println("Данные отсутствуют...");
        } else {
            System.out.println("Вы решили произвести действия с конусом.");
            boolean program = true;

            do {
                char set = doSolveMenu();
                switch (set) {
                    case 'a':
                        System.out.println("Объём конуса: " + conus.volume());
                        break;
                    case 'b':
                        System.out.println("Площадь основания конуса: " + conus.baseArea());
                        break;
                    case 'c':
                        System.out.println("Площадь боковой поверхности конуса: " + conus.sideSquare());
                        break;
                    case 'd':
                        System.out.println("Площадь всей поверхности конуса: " + conus.allSquare());
                        break;
                    case 'e':
                        do {
                            n = inputData();
                            if (n >= conus.getH()) {
                                System.out.println("Значение должно быть меньше истиной высоты конуса.");
                            }
                        } while (n >= conus.getH());
                        System.out.println("Площадь сечения конуса на высоте " + n + " : " + conus.crossArea(n));
                        break;
                    case 'f':
                        System.out.println("Введите высоту второго конуса.");
                        double height = inputData();
                        System.out.println("Введите радиус основания второго конуса.");
                        double radius = inputData();
                        switch(conus.insideConus(radius, height)){
                            case 1: System.out.println("Ваш второй конус не вложен в первый."); break;
                            case 2: System.out.println("Ваш второй конус имеет такие же характеристики, как и первый."); break;
                            case 3: System.out.println("Ваш второй конус вложен в первый."); break;
                            default: System.out.println("Ошибка при выполнении..."); break;
                        } 
                        break;
                    case 'g':
                        program = false;
                        System.out.println("Возвращение...");
                        break;
                    default:
                        System.out.println("Ввод неверный... Попробуйте снова...");
                        break;
                }
            } while (program);
        }
    }

    public static void checkState() {
        if (conus.getR() == 0 || conus.getH() == 0) {
            System.out.println("Данные отсутствуют...");
        } else {
            System.out.println("Вы решили просмотреть состояние конуса.");
            System.out.println("У вас он очень интересный!");
            System.out.println();
            System.out.println("Его радиус:\t" + conus.getR());
            System.out.println("Его высота:\t" + conus.getH());
        }
    }

    public static void main(String[] args) {
        System.out.println("Данная программа выполняет различные действия с конусами. Попробуйте ниже!");
        boolean program = true;

        do {
            char set = doMenu();
            switch (set) {
                case 'a':
                    createObject();
                    break;
                case 'b':
                    solveTask();
                    break;
                case 'c':
                    checkState();
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
