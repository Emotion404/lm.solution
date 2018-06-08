#include "Ellipse.h"
#include <iostream>

using namespace std;

CEllipse::CEllipse(int left,int top,int right,int bottom)
:CShape(left,top,right,bottom)
{
}

void CEllipse::Draw()
{
	cout<<"»æÖÆÍÖÔ²"<<endl;
}

CEllipse::~CEllipse(void)
{
}
