package main.com.excercise.triangle;

public class TriangleClassCifier {
    public static String classifyTriangle(double firstSide, double secondSide, double thirdSide) {
        if (firstSide <= 0 || secondSide <= 0 || thirdSide <= 0)
            return "Not a Triangle";
        if (firstSide + secondSide <= thirdSide || firstSide + thirdSide <= secondSide
                || secondSide + thirdSide <= firstSide)
            return "Not a Triangle";

        if (firstSide == secondSide && secondSide == thirdSide)
            return "Equilateral Triangle";
        if (firstSide == secondSide || firstSide == thirdSide || secondSide == thirdSide)
            return "Isosceles Triangle";
        return "Scalene Triangle";
    }
}
