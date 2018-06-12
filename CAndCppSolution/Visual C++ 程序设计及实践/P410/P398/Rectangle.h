#pragma once

#include "Shape.h"


class CRectangle:public CShape
{
public:
	CRectangle(CPoint ptStart,CPoint ptEnd);
	void Draw(CDC* pDC);

	~CRectangle(void);
};
