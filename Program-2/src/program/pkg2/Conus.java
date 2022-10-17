package program.pkg2;
//import java.lang.Math;

public class Conus {

    private static double height;
    private static double radius;

    //конструктор по умолчанию
    public Conus() {
    }

    //конструктор
    public Conus(double h, double r) {
        this.height = h;
        this.radius = r;
    }

    //конструктор копирования
    public Conus(Conus conus) {
        height = conus.height;
        radius = conus.radius;
    }

    //сеттеры и геттеры
    public void setH(double h) {
        this.height = h;
    }

    public void setR(double r) {
        this.radius = r;
    }

    public double getH() {
        return height;
    }

    public double getR() {
        return radius;
    }

    //объём
    public double volume() {
        return Math.PI * Math.pow(radius, 2) * height;
    }

    //площадь основания
    public double baseArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    //площадь сечения
    public double crossArea(double h2) {
        return Math.PI * Math.pow(((h2 * radius) / height), 2);
    }

    //боковая поверхность
    public double sideSquare() {
        return Math.PI * height * Math.sqrt(Math.pow(radius, 2) + Math.pow(height, 2));
    }

    //вся поверхность
    public double allSquare() {
        return sideSquare() + baseArea();
    }

    //вложен ли конус в другой
    public int insideConus(double radius, double height) {
        if (this.height < height || this.radius < radius) {
            return 1;
        } else if (this.height == height && this.radius == radius) {
            return 2;
        } else {
            return 3;
        }
    }
}

