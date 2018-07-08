#include "Tricycle.h"

Tricycle::Tricycle(int initialSpeed)
{
	setSpeed(initialSpeed);
}

Tricycle:: ~Tricycle()
{

}

void Tricycle::setSpeed(int newSpeed)
{
	if (newSpeed >= 0)
	{
		speed = newSpeed;
	}
}