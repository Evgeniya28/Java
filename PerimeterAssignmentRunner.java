import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        int numPoint = 0;
        Point prevPt = s.getLastPoint();
        for (Point currPt : s.getPoints()){
            numPoint++;
            prevPt = currPt;
        }
        return numPoint;
    }

    public double getAverageLength(Shape s) {
        double lenght = getPerimeter(s);
        int number = getNumPoints(s);
        return lenght / number ;
    }

    public double getLargestSide(Shape s) {
        Point prevPt = s.getLastPoint();
        double LargestSide = 0;
            for (Point currPt : s.getPoints()) {
            double currDist = prevPt.distance(currPt);
            if (currDist > LargestSide){
            LargestSide = currDist;  
        }
        }
        return LargestSide; 
    }

    public double getLargestX(Shape s) {
        
        double LargestX = 0;
              
        for (Point currPt : s.getPoints()){
            int currX = currPt.getX();
            if (currX>LargestX){
                LargestX = currX;
            }
            
        }
        
        return LargestX;
    }

    public double getLargestPerimeterMultipleFiles() {
        double LargestPr = 0;
        DirectoryResource dr = new DirectoryResource();
        
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double currPr = getPerimeter (s);
            if (currPr > LargestPr){
                LargestPr = currPr;
            }
        }
        return LargestPr;
    }

    public String getFileWithLargestPerimeter() {
        String FileWithLargPerim = null;
        double LargestPr = 0;
        DirectoryResource dr = new DirectoryResource();
        
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double currPr = getPerimeter (s);
            if (currPr > LargestPr){
                LargestPr = currPr;
                FileWithLargPerim = f.getName();
            }
    }
    return FileWithLargPerim;
}

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        int numberPoint = getNumPoints(s);
        double avLength = getAverageLength(s);
        double LargestSide = getLargestSide(s);
        double LargX = getLargestX(s);
        System.out.println("perimeter = " + length);
        System.out.println("number_point = " + numberPoint);
        System.out.println("avLength = " + avLength);
        System.out.println("LargSide = " + LargestSide);
        System.out.println("LargX = " + LargX);
        
    }
    
    public void testPerimeterMultipleFiles() {
       
        Double LargPr = getLargestPerimeterMultipleFiles();
        System.out.println("LargPr = " + LargPr);
 
    }

    public void testFileWithLargestPerimeter() {
        
        String Name = getFileWithLargestPerimeter();
        System.out.println("Name = " + Name);
    
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
    }
}
