#include "stdafx.h"
#include "Shape.h"

CShape::CShape()
{

}

CShape::CShape(CPoint ptStart,CPoint ptEnd)
{
	m_ptStart=ptStart;
	m_ptEnd=ptEnd;
}

void CShape::SetPos(CPoint ptStart,CPoint ptEnd)
{


	m_ptEnd=CPoint(10,10);
	m_ptStart=CPoint(5,5);
}


CShape::~CShape(void)
{
}
