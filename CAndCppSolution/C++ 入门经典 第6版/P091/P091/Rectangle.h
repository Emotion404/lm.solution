#pragma once
#include "Point.h"

class Rectangle
{
public:
	Rectangle(int newTop,int newLeft,int newBottom,int newRight);
	~Rectangle();

	Point getUpperLeft() const
	{
		return upperLeft;
	}
	Point getUpperRight() const
	{
		return upperRight;
	}
	Point getLowerLeft() const
	{
		return lowerLeft;
	}
	Point getLowerRight() const
	{
		return lowerRight;
	}

	int getTop() const
	{
		return top;
	}
	int getLeft() const
	{
		return left;
	}
	int getBottom() const
	{
		return bottom;
	}
	int getRight() const
	{
		return right;
	}

	void setUpperLeft(Point location);
	void setUpperRight(Point location);
	void setLowerLeft(Point location);
	void setLowerRight(Point location);

	void setTop(int newTop);
	void setLeft(int newLeft);
	void setBottom(int newBottom);
	void setRight(int newRight);

	int getArea() const;

private:
	Point upperLeft;
	Point upperRight;
	Point lowerLeft;
	Point lowerRight;

	int top;
	int left;
	int bottom;
	int right;
};
