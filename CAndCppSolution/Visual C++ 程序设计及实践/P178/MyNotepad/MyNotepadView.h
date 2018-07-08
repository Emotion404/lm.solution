
// MyNotepadView.h : CMyNotepadView 类的接口
//


#pragma once


class CMyNotepadView : public CView
{
protected: // 仅从序列化创建
	CMyNotepadView();
	DECLARE_DYNCREATE(CMyNotepadView)

// 属性
public:
	CMyNotepadDoc* GetDocument() const;

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
	virtual ~CMyNotepadView();
#ifdef _DEBUG
	virtual void AssertValid() const;
	virtual void Dump(CDumpContext& dc) const;
#endif

protected:
	BOOL m_nShowed; // 指明是否需要显示文字

private:
	CPoint m_ptOrigin;  // 用来记录直线起点


// 生成的消息映射函数
protected:
	DECLARE_MESSAGE_MAP()
public:
	afx_msg void OnLButtonDown(UINT nFlags, CPoint point);
	afx_msg void OnLButtonUp(UINT nFlags, CPoint point);
	afx_msg void OnOpShow();
	afx_msg void OnUpdateOpShow(CCmdUI *pCmdUI);
	afx_msg void OnRButtonUp(UINT nFlags, CPoint point);
};

#ifndef _DEBUG  // MyNotepadView.cpp 中的调试版本
inline CMyNotepadDoc* CMyNotepadView::GetDocument() const
   { return reinterpret_cast<CMyNotepadDoc*>(m_pDocument); }
#endif

