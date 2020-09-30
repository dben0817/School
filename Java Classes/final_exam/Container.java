package final_exam;
	
	abstract class Container {
	    private double height;
	    Container(double height)
	    {
	        this.height = height;
	    }
	    abstract double getTopArea();
	    abstract double getTopPerimeter();
	    
	    double getVolume()
	    {
	        return height * getTopArea();
	    }
	    double getSurfaceArea()
	    {
	        return 2 * getTopArea() + height * getTopPerimeter();
	    }
	}

	class CircularContainer extends Container
	{
		double radius, height;
	        // add appropriate data definitions
	    CircularContainer(double height, double radius)
	    {
	        // Fill in details
	    	super(height);
	    	this.radius = radius;
	    }
	    // implement required abstract methods
	    double getTopArea()
	    {
	    	return Math.PI * radius * radius;
	    }
	    
	    double getTopPerimeter()
	    {
	    	return 2.0 * Math.PI * radius;	    	
	    }

	}
	class RectangularContainer extends Container
	{
	    // add appropriate data definitions
		double width, length;
	    RectangularContainer(double height, double width, double length)
	    {
	        // Fill in details
	    	super(height);
	    	this.width = width;
	    	this.length = length;
	    }
	    // implement required abstract methods
	    double getTopArea()
	    {
	    	return width * length;
	    }
	    
	    double getTopPerimeter()
	    {
	    	return 2.0 * (width + length);	    	
	    }
	}

	class TriangularContainer extends Container
	{
	    // add appropriate data definitions
		double side_a, side_b, side_c;
	    TriangularContainer(double height, double side_a, double side_b, double side_c)
	    {
	        // Fill in details
	    	super(height);
	    	this.side_a = side_a;
	    	this.side_b = side_b;
	    	this.side_c = side_c;
	    }
	    // implement required abstract methods
	    double getTopArea()
	    {
	    	double s =  (side_a + side_b + side_c) / 2.0;
	    	return Math.sqrt(s * (s - side_a) * (s - side_b) * (s - side_c));   	
	    }
	    
	    double getTopPerimeter()
	    {
	    	return side_a + side_b + side_c;	    	
	    }
	}


	class RegularPolygonContainer extends Container
	{
	    // add appropriate data definitions
		double side;
		int numSides;
	    RegularPolygonContainer(double height, double side, int numSides)
	    {
	        // Fill in details
	    	super(height);
	    	this.side = side;
	    	this.numSides = numSides;
	    }
	    // implement required abstract methods
	    double getTopArea()
	    {
	    	return numSides * side * side / (4 * Math.tan(Math.PI / numSides));	    	
	    }
	    
	    double getTopPerimeter()
	    {
	    	return numSides * side;	    	
	    }
	}
	
