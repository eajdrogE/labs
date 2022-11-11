import java.util.ArrayList;

public class ArrayTriangles {
    private ArrayList<Triangle> triangles = new ArrayList<Triangle>();
    private ArrayList<Triangle> versatileTriangles = new ArrayList<>();
    private ArrayList<Triangle> isoscelesTriangles = new ArrayList<>();
    private ArrayList<Triangle> equilateralTriangles = new ArrayList<>();
    private ArrayList<Triangle> rectangularTriangles = new ArrayList<>();

    private void sortTriangle(){

    }

    public void addTriangle(){
        triangles.add(new Triangle(Math.random()*20,Math.random()*20,Math.random()*20,Math.random()*20,Math.random()*20,Math.random()*20));
        sortTriangle();
    }
    public void addTriangle(double x1, double y1, double x2, double y2, double x3, double y3){
        triangles.add(new Triangle(x1,y1,x2,y2,x3,y3));
        separateTriangles(new Triangle(x1,y1,x2,y2,x3,y3));
    }
    public int length(){
        return triangles.size();
    }
    public void separateTriangles(Triangle triangle) {

            if (triangle.getTypeTriangle().equalsIgnoreCase("versatile"))
                versatileTriangles.add(triangle);
            else if (triangle.getTypeTriangle().equalsIgnoreCase("rectangular"))
                isoscelesTriangles.add(triangle);
            else if (triangle.getTypeTriangle().equalsIgnoreCase("equilateral"))
                equilateralTriangles.add(triangle);
            else if (triangle.getTypeTriangle().equalsIgnoreCase("isosceles"))
                rectangularTriangles.add(triangle);

    }
    public void amountOfTriangles() {
        System.out.println("\namount of versatile triangles" + " = " + versatileTriangles.size());
        System.out.println("amount of isosceles triangles" + " = " + isoscelesTriangles.size());
        System.out.println("amount of equilateral triangles" + " = " + equilateralTriangles.size());
        System.out.println("amount of rectangular triangles" + " = " + rectangularTriangles.size() + "\n");
    }
    public void printMaxMinTriangles() {
        System.out.println("max versatile triangle = " + findMaxTriangle(versatileTriangles));
        System.out.println("min versatile triangle = " + findMinTriangle(versatileTriangles) + "\n");
        System.out.println("max isosceles triangle = " + findMaxTriangle(isoscelesTriangles));
        System.out.println("min isosceles triangle = " + findMinTriangle(isoscelesTriangles) + "\n");
        System.out.println("max equilateral triangle = " + findMaxTriangle(equilateralTriangles));
        System.out.println("min equilateral triangle = " + findMinTriangle(equilateralTriangles) + "\n");
        System.out.println("max rectangular triangle = " + findMaxTriangle(rectangularTriangles));
        System.out.println("min rectangular triangle = " +  findMinTriangle(rectangularTriangles) + "\n");

    }
    public static Triangle findMaxTriangle(ArrayList<Triangle> triangles){
        double saveSquare = 0;
        Triangle saveTriangle = null;
        for (Triangle triangle : triangles) {
            if(triangle.getSquare() > saveSquare) {
                saveSquare = triangle.getSquare();
                saveTriangle = triangle;
            }
        }
        return saveTriangle;
    }
    public static Triangle findMinTriangle(ArrayList<Triangle> triangles){
        double saveSquare = 10000000;
        Triangle saveTriangle = null;
        for (Triangle triangle : triangles) {
            if(triangle.getSquare() < saveSquare) {
                saveSquare = triangle.getSquare();
                saveTriangle = triangle;
            }
        }
        return saveTriangle;
    }
}
