#pragma once

#include "Shape.h"


class CLine:public CShape
{
public:
	CLine(int x1,int y1,int x2,int y2,int color);
	void Draw(HDC hDC);

	~CLine(void);
};
