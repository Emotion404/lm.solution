#include <iostream>

class Tricycle
{
public:
	Tricycle();
	~Tricycle();

	int getSpeed();
	void setSpeed(int speed);
	void pedal();
	void brake();

private:
	int speed;
};

Tricycle::Tricycle()
{
	speed = 0;
}

Tricycle::~Tricycle()
{
}

int Tricycle::getSpeed()
{
	return speed;
}

void Tricycle::setSpeed(int newSpeed)
{
	if (newSpeed >= 0)
	{
		speed = newSpeed;
	}
}

void Tricycle::pedal()
{
	setSpeed(speed + 1);
	std::cout << "\n Pedaling; tricycle speed " << speed << " mph \n";
}

void Tricycle::brake()
{
	setSpeed(speed - 1);
	std::cout << "\n Braking; tricycle speed " << speed << " mph \n";
}

int main()
{
	Tricycle wichita;
	wichita.setSpeed(0);
	wichita.pedal();
	wichita.pedal();
	wichita.brake();
	wichita.brake();
	wichita.brake();

	return 0;
}