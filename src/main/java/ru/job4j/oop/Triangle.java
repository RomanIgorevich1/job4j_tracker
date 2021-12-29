package ru.job4j.oop;

public class Triangle {
    private Point first;
    private Point second;
    private Point third;

    public Triangle(Point ap, Point bp, Point cp) {
        this.first = ap;
        this.second = bp;
        this.third = cp;
    }

    public double semiPerimeter(double a, double b, double c) {
        return (a + b + c) / 2;
    }

    public boolean exist(double ac, double ab, double bc) {
        return (ac + bc) > ab || (bc + ab) > ac || (ac + ab) > bc;
    }

    public double area() {
        double s = 0;
        double ab = first.distance(second);
        double ac = first.distance(third);
        double bc = second.distance(third);
        if (this.exist(ac, ab, bc)) {
            double p = semiPerimeter(ac, ab, bc);
            s =  Math.sqrt(p * (p - ac) * (p - ab) * (p - bc));
        }
        return s;
    }
}
