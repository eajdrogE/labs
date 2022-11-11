public class Triangle {
    private  Point[] point = new Point[3];
    private double[] side = new double[3];
    private double perimeter, square;
    private String typeTriangle;
    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        point[0]= new Point(x1,y1);
        point[1]= new Point(x2,y2);
        point[2]= new Point(x3,y3);
        side[0] = Math.sqrt(pow((point[1].x- point[0].x) + pow(point[1].y - point[0].y)));
        side[1] = Math.sqrt(pow((point[2].x - point[0].x) + pow(point[2].y - point[0].y)));
        side[2] = Math.sqrt(pow((point[2].x - point[1].x)) + pow((point[2].y - point[1].y)));
        perimeter=side[0]+side[1]+side[2];
        square=((point[1].x-point[0].x)*(point[2].y-point[0].y)-(point[2].x-point[0].x)*(point[1].y-point[0].y))/2;
        getTypeToTriangle();
    }
   /* public Triangle(Triangle triangle) {
        this.point[0].x= triangle.point[0].x;
        this.point[0].y= triangle.point[0].y;
        this.point[1].x= triangle.point[1].x;
        this.point[1].y= triangle.point[1].y;
        this.point[2].x= triangle.point[2].x;
        this.point[2].y= triangle.point[2].y;
        this.side[0] = Math.sqrt(pow((triangle.point[1].x- triangle.point[0].x) + pow(triangle.point[1].y - triangle.point[0].y)));
        this.side[1] = Math.sqrt(pow((triangle.point[2].x - triangle.point[0].x) + pow(triangle.point[2].y - triangle.point[0].y)));
        this.side[2] = Math.sqrt(pow((triangle.point[2].x - triangle.point[1].x)) + pow((triangle.point[2].y - triangle.point[1].y)));
        this.perimeter=triangle.side[0]+triangle.side[1]+triangle.side[2];
        this.square=((triangle.point[1].x-triangle.point[0].x)*(triangle.point[2].y-triangle.point[0].y)-(triangle.point[2].x-triangle.point[0].x)*(triangle.point[1].y-triangle.point[0].y))/2;
        getTypeToTriangle();
    }
*/

    public static double pow(double value){
        return value*value;
    }
    public double getSquare(){
        return square;
    }
    public double getPerimeter(){
        return perimeter;
    }
    public String getTypeTriangle() {
        return typeTriangle;
    }
public void getTypeToTriangle(){
    if (side[0] != side[1] && side[1] != side[2])
        typeTriangle = "versatile";
    else if ((side[0] == side[1] && side[0] != side[2]) || (side[1] == side[2] && side[0] != side[2]) || (side[0] == side[2] && side[1] != side[2]))
        typeTriangle = "isosceles";
    else if (side[0] == side[1] && side[1] == side[2])
        typeTriangle = "equilateral";
    else if (cos()==0)
        typeTriangle="rectangular";
}

   public double cos(){/*Считалось по формуле угла между векторами, при значении 0 - угол равен 90 градусов*/
        double q1,q2,q3;
        q1=(Math.sqrt(pow(point[0].x-point[1].x))*Math.sqrt(pow(point[1].x-point[2].x)))+(Math.sqrt(pow(point[0].y-point[1].y))*Math.sqrt(pow(point[1].y-point[2].y)));
        q1/=Math.sqrt(pow(point[0].x-point[1].x)+pow(point[0].y-point[1].y));
        q1/=Math.sqrt(pow(point[1].x-point[2].x)+pow(point[1].y-point[2].y));
        q2=(Math.sqrt(pow(point[1].x-point[2].x))*Math.sqrt(pow(point[2].x-point[0].x)))+(Math.sqrt(pow(point[1].y-point[2].y))*Math.sqrt(pow(point[2].y-point[0].y)));
        q2/=Math.sqrt(pow(point[1].x-point[2].x)+pow(point[1].y-point[2].y));
        q2/=Math.sqrt(pow(point[2].x-point[0].x)+pow(point[2].y-point[0].y));
        q3=(Math.sqrt(pow(point[2].x-point[0].x))*Math.sqrt(pow(point[0].x-point[1].x)))+(Math.sqrt(pow(point[2].y-point[0].y))*Math.sqrt(pow(point[0].y-point[1].y)));
        q3/=Math.sqrt(pow(point[2].x-point[0].x)+pow(point[2].y-point[0].y));
        q3/=Math.sqrt(pow(point[0].x-point[1].x)+pow(point[0].y-point[1].y));
        return Math.min(Math.min(q1,q2),q3);
    }

    public String showInfo(){
        return "point1=" + point[0].x + " "+ point[0].y+
                ", side2=" + point[1].x + " "+ point[1].y+
                ", side3=" + point[2].x + " "+ point[2].y+
                ", perimeter=" + perimeter+
                ", square=" + square+
                ", typeOfTriangle='" + typeTriangle + '\'';
    }
}
