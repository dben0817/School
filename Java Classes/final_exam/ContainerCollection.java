package final_exam;


class ContainerCollection
{
	Container[] collection;
	int numContainers;
	int containerCount=0;

	ContainerCollection(int numContainers)
	{
		// Fill in details
		collection = new Container[numContainers];

	}

	void addContainer( Container c)
	{
		// Fill in details
		// Don't forget to check to see if there is enough room
		// in collection before adding.  Complain if you can't add Container.
		if (containerCount < collection.length)
		{
			collection[containerCount++] = c;
		}
		else
			System.out.println("Too Many Items in Container.");
	}

	double getTotalVolume()
	{double totalVolume = 0.0;
	// Fill in details to return the total volume of 
	// all Containers in collection
	for (Container container:collection)
	{
	 try
	 {
			totalVolume += container.getVolume();
	 }
		catch(NullPointerException e)
		{
			totalVolume += 0.0;
		}
	}
	return totalVolume;
	}

	double getTotalSurfaceArea()
	{ double totalSurface = 0.0;
	// Fill in details to return the total surface area of 
	// all Containers in collection
	for (Container container:collection)
	{
		try
		{
			totalSurface += container.getSurfaceArea();
		}
		catch(NullPointerException e)
		{
			totalSurface += 0.0;
		}
	}
	return totalSurface;
	}

	// DO NOT CHANGE ANYTHING IN MAIN!!!! ... this will be used to test your code
	public static void main(String[] args)
	{
		// Container of Various Prism Shapes
		ContainerCollection cc = new ContainerCollection(10);

		cc.addContainer(new CircularContainer(10., 2.0)); // height, radius
		cc.addContainer(new RectangularContainer(10., 2.0, 3.0)); // height, width, length
		cc.addContainer(new TriangularContainer(10., 4.0, 3.0, 5.0)); // height, side_a, side_b, side_c
		cc.addContainer(new RegularPolygonContainer(10., 1.0, 4)); // height, side, num_sides


		cc.addContainer(new CircularContainer(5., 2.0)); // height, radius
		cc.addContainer(new RectangularContainer(5., 2.0, 3.0)); // height, width, length
		cc.addContainer(new TriangularContainer(5., 4.0, 3.0, 5.0)); // height, side_a, side_b, side_c
		cc.addContainer(new RegularPolygonContainer(5., 1.0, 4)); // height, side, num_sides


		cc.addContainer(new CircularContainer(2., 2.0)); // height, radius
		cc.addContainer(new RectangularContainer(2., 2.0, 3.0)); // height, width, length
		cc.addContainer(new TriangularContainer(2., 4.0, 3.0, 5.0)); // height, side_a, side_b, side_c
		cc.addContainer(new RegularPolygonContainer(2., 1.0, 4)); // height, side, num_sides

		System.out.println("Total Volume of all containers = " + cc.getTotalVolume());
		System.out.println("Total Surface Area of all containers = " + cc.getTotalSurfaceArea());

		// Container of Rectangular Prisms
		ContainerCollection ccRect = new ContainerCollection(4);
		ccRect.addContainer(new RectangularContainer(5.123456, 2.0, 3.0)); // height, width, length
		ccRect.addContainer(new RectangularContainer(9., 2.0, 3.0)); // height, width, length
		ccRect.addContainer(new RectangularContainer(8., 2.0, 3.0)); // height, width, length
		System.out.println("Total Volume of all containers for ccRect = " + ccRect.getTotalVolume());
		System.out.println("Total Surface Area for ccRect = " + ccRect.getTotalSurfaceArea());

		// Container of Circular  Prisms
		ContainerCollection ccCirc = new ContainerCollection(4);
		ccCirc.addContainer(new CircularContainer(1., 1.0)); // height, width, length
		ccCirc.addContainer(new CircularContainer(10., 10.0)); // height, width, length
		System.out.println("Total Volume of all containers for ccCirc = " + ccCirc.getTotalVolume());
		System.out.println("Total Surface Area for ccCirc = " + ccCirc.getTotalSurfaceArea());

		// Container of Triangular Prisms
		ContainerCollection ccTri = new ContainerCollection(4);
		ccTri.addContainer(new TriangularContainer(1., 2.0, 2.0, 3.0)); // height, width, length
		ccTri.addContainer(new TriangularContainer(2., 1.0, 1.0, 1.0)); // height, width, length
		System.out.println("Total Volume of all containers for ccTri = " + ccTri.getTotalVolume());
		System.out.println("Total Surface Area for ccTri = " + ccTri.getTotalSurfaceArea());

		// Container of Regular Polygon Prisms        
		ContainerCollection ccPoly = new ContainerCollection(4);
		ccPoly.addContainer(new RegularPolygonContainer(2., 1.0, 4)); // height, width, length
		ccPoly.addContainer(new RegularPolygonContainer(2., 2.0, 3)); // height, width, length
		ccPoly.addContainer(new RegularPolygonContainer(2., 3.0, 5)); // height, width, length
		System.out.println("Total Volume of all containers for ccPoly = " + ccPoly.getTotalVolume());
		System.out.println("Total Surface Area for ccPoly = " + ccPoly.getTotalSurfaceArea());
	}
}





