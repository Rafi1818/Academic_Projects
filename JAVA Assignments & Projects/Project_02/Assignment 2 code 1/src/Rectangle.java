public class Rectangle{
    double width = 1.00;
    double height = 1.00;

    Rectangle(){                                                         //no-arg constructor
    }

    Rectangle(double widthIn, double heightIn){                          //arg constructor
        width = widthIn;
        height = heightIn;
    }
    public double getWidth(){
        return width;
    }                           //returns width

    public double getHeight(){
        return height;
    }                         //returns height

    public double getArea(){
        return width * height;
    }                   //returns area

    public double getPerimeter(){
        return (width * 2 + height * 2);
    }    //returns perimeter

}