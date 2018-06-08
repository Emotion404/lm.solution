#include "Rectangle.h"
#include <iostream>

using namespace std;

CRectangle::CRectangle(int left,int top,int right,int bottom)
:CShape(left,top,right,bottom)
{
}

void CRectangle::Draw()
{
	cout<<"»æÖÆ¾ØÐÎ"<<endl;
}

CRectangle::~CRectangle(void)
{
}
