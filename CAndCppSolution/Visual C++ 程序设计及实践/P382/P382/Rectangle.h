#pragma once

#include "Shape.h"


class CRectangle:public CShape
{
public:
	CRectangle(int left,int top,int right,int bottom);
	void Draw();

	~CRectangle(void);
};
