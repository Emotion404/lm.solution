#include <iostream>
#include "Rectangle.h"

int main()
{
	Rectangle rect(100, 20, 50, 80);

	int area = rect.getArea();

	std::cout << "Area : " << area << std::endl;
	std::cout << "Upper Left X Coordinate : " << rect.getUpperLeft().getX() << std::endl;

	return 0;
}