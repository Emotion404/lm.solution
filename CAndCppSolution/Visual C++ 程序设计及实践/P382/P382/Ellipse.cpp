#include "Ellipse.h"
#include <iostream>

using namespace std;

CEllipse::CEllipse(int left,int top,int right,int bottom)
:CShape(left,top,right,bottom)
{
}

void CEllipse::Draw()
{
	cout<<"������Բ"<<endl;
}

CEllipse::~CEllipse(void)
{
}
