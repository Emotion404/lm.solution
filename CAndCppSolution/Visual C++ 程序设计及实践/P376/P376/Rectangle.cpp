#include "Rectangle.h"

#include <iostream>

using namespace std;

CRectangle::CRectangle(int left,int top,int right,int bottom)
{
	m_left=left;
	m_top=top;

	m_right=right;
	m_bottom=bottom;
}

void CRectangle::Draw()
{
	cout<<"»æÖÆ¾ØÐÎ"<<endl;
}

void CRectangle::SetPos(int left,int top,int right,int bottom)
{
	m_left=left;
	m_top=top;

	m_right=right;
	m_bottom=bottom;
}

CRectangle::~CRectangle(void)
{
}
