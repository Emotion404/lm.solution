#pragma once

class CEllipse
{
public:
	CEllipse(int left,int top,int right,int bottom);
	void Draw();
	void SetPos(int left,int top,int right,int bottom);

	~CEllipse(void);

private:
	int m_left;
	int m_top;

	int m_right;
	int m_bottom;
};
