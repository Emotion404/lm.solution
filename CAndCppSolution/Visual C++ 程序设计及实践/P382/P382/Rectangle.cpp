#include "Rectangle.h"
#include <iostream>

using namespace std;

CRectangle::CRectangle(int left,int top,int right,int bottom)
:CShape(left,top,right,bottom)
{
}

void CRectangle::Draw()
{
	cout<<"���ƾ���"<<endl;
}

CRectangle::~CRectangle(void)
{
}
