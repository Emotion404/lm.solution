#include <iostream>

class Tricycle
{
public:
	Tricycle( int);
	~Tricycle();

	int getSpeed();
	void setSpeed(int);

	void pedal();
	void brake();

private:
	int speed;
};

Tricycle::Tricycle(int initialSpeed)
{
	setSpeed(initialSpeed);
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
	std::cout << "\n Pedal : " << speed << std::endl;
}

void Tricycle::brake()
{
	setSpeed(speed - 1);
	std::cout << "\n Brake : " << speed << std::endl;
}

void main()
{
	Tricycle tt(5);
	tt.pedal();
	tt.pedal();
	tt.brake();
	tt.brake();
	tt.brake();

	return;
}