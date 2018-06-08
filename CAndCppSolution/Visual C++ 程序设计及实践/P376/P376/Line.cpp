#include "Line.h"

#include <iostream>

using namespace std;


CLine::CLine(int x1, int y1, int x2, int y2)
{
	m_x1=x1;
	m_y1=y1;

	m_x2=x2;
	m_y2=y2;
}

void CLine::Draw()
{
	cout<<"»æÖÆÖ±Ïß"<<endl;
}

void CLine::SetPos(int x1,int y1,int x2,int y2)
{
	m_x1=x1;
	m_y1=y1;

	m_x2=x2;
	m_y2=y2;
}

CLine::~CLine(void)
{
}
