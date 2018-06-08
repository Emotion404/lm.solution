#include "Ellipse.h"
#include <iostream>

using namespace std;

CEllipse::CEllipse(int left,int top,int right,int bottom)
{
	m_left=left;
	m_top=top;

	m_right=right;
	m_bottom=bottom;
}

void CEllipse::Draw()
{
	cout<<"»æÖÆÍÖÔ²"<<endl;
}

void CEllipse::SetPos(int left,int top,int right,int bottom)
{
	m_left=left;
	m_top=top;

	m_right=right;
	m_bottom=bottom;
}


CEllipse::~CEllipse(void)
{
}
