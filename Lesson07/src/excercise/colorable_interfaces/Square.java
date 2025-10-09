package excercise.colorable_interfaces;

public class Square extends Shape implements Colorable {
    private double side = 1.0;

    public Square() {
    }

    public Square(double side) {
        this.side = side;
    }

    public Square(double side, String color, boolean filled) {
        super(color, filled);
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public double getPerimeter() {
        return side * 4;
    }

    public double getArea() {
        return Math.pow(side, 2);
    }

    @Override
    public String toString() {
        return "Square [side=" + String.format("%.2f", side) +
                ", Area = " + String.format("%.2f", getArea()) + "]";
    }

    @Override
    public void howToColor() {
        System.out.println("Color all four sides.");
    }

}
