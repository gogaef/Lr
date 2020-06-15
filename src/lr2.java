/*Создайте следующую геометрическую модель- есть класс Фигура,
есть классы Треугольник, Прямоугольник, Трапеция. Каждая
фигура задается набором ее вершин, у каждой вершины есть
координаты декартовые (x,y) У Фигуры есть метод найти_площадь.
Создать метод , позволяющий найти суммарную площадь любого
набора Фигур.
*/
import java.lang.reflect.Array;
import java.util.ArrayList;
//Yefremov George gr 202
public class lr2 {
    public static void main(String[] args) {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(1, 4);
        Point p3 = new Point(5, 4);
        Point p4 = new Point(7, 0);
        Point p5 = new Point(0, 6);
        Point p6 = new Point(7, 6);
        Triangle t1 = new Triangle(p1, p2, p3);
        //System.out.println("Square of this triangle is - " + t1.square());
        Rectangle r1 = new Rectangle(p1, p5, p6, p4);
        //System.out.println("Square of this rectangle is - " + r1.square());
        Trapezoid tr1 = new Trapezoid(p1, p2, p3, p4);
        //System.out.println("Square of this trapeze is - " + tr1.square());
        ArrayList<Figure> listOfFigures = new ArrayList<>();
        listOfFigures.add(t1);
        listOfFigures.add(tr1);
        listOfFigures.add(r1);
        lr2 l = new lr2();
        //System.out.println(l.sumSquare(listOfFigures));
        lr2 l1 = new lr2();
        int [] arr = {14, 62, 13, 34, 57, 16,};
        l1.BubleSort(arr);
    }

        double sumSquare(ArrayList<Figure> listOfFigures){
        double sq = 0;
        for (int i = 0; i < listOfFigures.size(); i++){
            sq += listOfFigures.get(i).square();
        }
        return sq;
    }





   void BubleSort(int [] arr){
       int length = arr.length;
       int counter = 0;
       while (counter < length - 1){
        for (int i = 0; i < length -1; i++){
                    if(arr[i] > arr[i + 1]){
                        int a = arr[i];
                        arr[i] = arr[i + 1];
                        arr[i + 1] = a;
                    }


        }
       counter ++;
       }

        for (int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }

    }



}





class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public static double Length(Point p1, Point p2){
        double rez;
        rez = Math.sqrt(Math.pow(p2.getX()-p1.getX(), 2) + Math.pow(p2.getY() - p1.getY(), 2));
        return rez;
    }
}

abstract class Figure{
    ArrayList<Point> Cords = new ArrayList<>();
    public abstract double square();
}

class Triangle extends Figure{

    public Triangle(Point p1, Point p2, Point p3) {
        Cords.add(p1);
        Cords.add(p2);
        Cords.add(p3);
    }

    public double square(){
        double p = 0.5 * (Point.Length(Cords.get(0), Cords.get(1)) + Point.Length(Cords.get(1), Cords.get(2)) + Point.Length(Cords.get(2), Cords.get(0)));
        double S = Math.sqrt(p * (p - Point.Length(Cords.get(0), Cords.get(1))) * (p - Point.Length(Cords.get(1), Cords.get(2)))* (p - Point.Length(Cords.get(2), Cords.get(0))));
        return S;
    }
}

class Rectangle extends Figure{
    public Rectangle(Point p1, Point p2, Point p3, Point p4) {
        Cords.add(p1);
        Cords.add(p2);
        Cords.add(p3);
        Cords.add(p4);
    }
    public double square(){
        double S = Point.Length(Cords.get(0), Cords.get(1)) * Point.Length(Cords.get(1), Cords.get(2));
        return S;
    }
}

class Trapezoid extends Figure{
    public Trapezoid(Point p1, Point p2, Point p3, Point p4) {
        Cords.add(p1);
        Cords.add(p2);
        Cords.add(p3);
        Cords.add(p4);
    }

    public double square() {
        double S;
        Point hpoint = new Point(Cords.get(1).getX(), Cords.get(0).getY());
        double h;
        double osn1 = Point.Length(Cords.get(0), Cords.get(3));
        double osn2 = Point.Length(Cords.get(1), Cords.get(2));
        double side1 = Point.Length(Cords.get(0), Cords.get(1));
        double side2 = Point.Length(Cords.get(2), Cords.get(3));
        h = Point.Length(Cords.get(1), hpoint);
        S =  (osn1 + osn2) / 2 * h;
        return S;
    }
}

