#include <iostream>

using namespace std;

enum Direction
{
	North,
	Northeast,
	East,
	Southeast,
	South,
	Southwest,
	West,
	Northwest
};


int main()
{

	Direction heading;

	heading = Direction::Southeast;

	cout << "Moving : " << heading << endl;

	return 0;
}