
// P398View.h : CP398View 类的接口
//


#pragma once

#include "Shape.h"

class CP414View : public CView
{
protected: // 仅从序列化创建
	CP414View();
	DECLARE_DYNCREATE(CP414View)

// 属性
public:
	CP414Doc* GetDocument() const;

// 操作
public:

// 重写
public:
	virtual void OnDraw(CDC* pDC);  // 重写以绘制该视图
	virtual BOOL PreCreateWindow(CREATESTRUCT& cs);
protected:
	virtual BOOL OnPreparePrinting(CPrintInfo* pInfo);
	virtual void OnBeginPrinting(CDC* pDC, CPrintInfo* pInfo);
	virtual void OnEndPrinting(CDC* pDC, CPrintInfo* pInfo);

// 实现
public:
	virtual ~CP414View();
#ifdef _DEBUG
	virtual void AssertValid() const;
	virtual void Dump(CDumpContext& dc) const;
#endif

protected:
	/* 0-不绘制 1-直线 2-矩形 3-椭圆*/
	int m_nType;
	CPoint m_ptStart;
	BOOL m_bDrawing;
	CShape* m_pShape;

// 生成的消息映射函数
protected:
	afx_msg void OnFilePrintPreview();
	afx_msg void OnRButtonUp(UINT nFlags, CPoint point);
	afx_msg void OnContextMenu(CWnd* pWnd, CPoint point);
	DECLARE_MESSAGE_MAP()
public:
	afx_msg void OnDrawEllipse();
	afx_msg void OnDrawLine();
	afx_msg void OnDrawRectangle();
	afx_msg void OnUpdateDrawLine(CCmdUI *pCmdUI);
	afx_msg void OnUpdateDrawEllipse(CCmdUI *pCmdUI);
	afx_msg void OnUpdateDrawRectangle(CCmdUI *pCmdUI);
	afx_msg void OnLButtonDown(UINT nFlags, CPoint point);
	afx_msg void OnMouseMove(UINT nFlags, CPoint point);
	afx_msg void OnLButtonUp(UINT nFlags, CPoint point);
};

#ifndef _DEBUG  // P398View.cpp 中的调试版本
inline CP414Doc* CP414View::GetDocument() const
   { return reinterpret_cast<CP414Doc*>(m_pDocument); }
#endif

