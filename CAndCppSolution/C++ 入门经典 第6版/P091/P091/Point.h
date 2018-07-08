#pragma once

class Point
{
public:
	void setX(int newX)
	{
		x = newX;
	}
	void setY(int newY)
	{
		y = newY;
	}

	int getX() const
	{
		return x;
	}

	int getY() const
	{
		return y;
	}

private:
	int x;
	int y;
};