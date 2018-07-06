#include <iostream>

using namespace std;

int main()
{
	char name[50];
	char quest[80];
	char velocity[80];

	cout << "\n What is your name ? ";
	cin.getline(name, 49);

	cout << "\n What is your quest ? ";
	cin.getline(quest, 79);

	cout << "\n What is the velocity of an unladen swallow ? ";
	cin.getline(velocity, 79);

	cout << "\n Name: " << name << endl;
	cout << "\n Quest : " << quest << endl;
	cout << "\n Velocity : " << velocity << endl;

	return 0;
}