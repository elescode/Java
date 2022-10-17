package program.pkg2;
import java.lang.Math;

public class Conus {

    private static double h;
    private static double r;

    //конструктор по умолчанию
    public Conus() {
    }

    //конструктор
    public Conus(double h, double r) {
        this.h = h;
        this.r = r;
    }

    //конструктор копирования
    public Conus(Conus conus) {
        this.h = conus.h;
        this.r = conus.r;
    }

    //сеттеры и геттеры
    public void setH(double h) {
        this.h = h;
    }

    public void setR(double r) {
        this.r = r;
    }

    public double getH() {
        return h;
    }

    public double getR() {
        return r;
    }

    //объём
    public double volume() {
        return Math.PI * Math.pow(r, 2) * getH();
    }

    //площадь основания
    public double baseArea() {
        return Math.PI * Math.pow(r, 2);
    }

    //площадь сечения
    public double crossArea(double h2) {
        return Math.PI * Math.pow(((h2 * r) / h), 2);
    }

    //боковая поверхность
    public double sideSquare() {
        return Math.PI * getR() * Math.sqrt(Math.pow(r, 2) + Math.pow(h, 2));
    }

    //вся поверхность
    public double allSquare() {
        return sideSquare() + baseArea();
    }

    //вложен ли конус в другой
    public void inside(Conus conus) {
        System.out.println("Введите радиус основания второго конуса.");
        double r = Program2.inputData();
        System.out.println("Введите высоту второго конуса.");
        double h = Program2.inputData();
        if (conus.getH() < h || conus.getR() < r) {
            System.out.println("Ваш второй конус не вложен в первый.");
        } else if (conus.getR() == r && conus.getH() == h) {
            System.out.println("Ваш второй конус имеет такие же характеристики, как и первый.");
        } else {
            System.out.println("Ваш второй конус вложен в первый.");
        }          
}
}

