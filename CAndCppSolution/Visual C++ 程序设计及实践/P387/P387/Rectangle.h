#pragma once

#include "Shape.h"


class CRectangle:public CShape
{
public:
	CRectangle(int left,int top,int right,int bottom,int color);
	void Draw(HDC hDC);

	~CRectangle(void);
};
