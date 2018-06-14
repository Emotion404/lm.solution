#pragma once

#include "Shape.h"



class CRectangle:public CShape
{
DECLARE_SERIAL(CRectangle)

public:
	CRectangle();
	CRectangle(CPoint ptStart,CPoint ptEnd);
	void Draw(CDC* pDC);

	~CRectangle(void);
};
