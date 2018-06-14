
// P398View.h : CP398View ��Ľӿ�
//


#pragma once

#include "Shape.h"

class CP414View : public CView
{
protected: // �������л�����
	CP414View();
	DECLARE_DYNCREATE(CP414View)

// ����
public:
	CP414Doc* GetDocument() const;

// ����
public:

// ��д
public:
	virtual void OnDraw(CDC* pDC);  // ��д�Ի��Ƹ���ͼ
	virtual BOOL PreCreateWindow(CREATESTRUCT& cs);
protected:
	virtual BOOL OnPreparePrinting(CPrintInfo* pInfo);
	virtual void OnBeginPrinting(CDC* pDC, CPrintInfo* pInfo);
	virtual void OnEndPrinting(CDC* pDC, CPrintInfo* pInfo);

// ʵ��
public:
	virtual ~CP414View();
#ifdef _DEBUG
	virtual void AssertValid() const;
	virtual void Dump(CDumpContext& dc) const;
#endif

protected:
	/* 0-������ 1-ֱ�� 2-���� 3-��Բ*/
	int m_nType;
	CPoint m_ptStart;
	BOOL m_bDrawing;
	CShape* m_pShape;

// ���ɵ���Ϣӳ�亯��
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

#ifndef _DEBUG  // P398View.cpp �еĵ��԰汾
inline CP414Doc* CP414View::GetDocument() const
   { return reinterpret_cast<CP414Doc*>(m_pDocument); }
#endif

