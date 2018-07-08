
// MyNotepadView.h : CMyNotepadView ��Ľӿ�
//


#pragma once


class CMyNotepadView : public CView
{
protected: // �������л�����
	CMyNotepadView();
	DECLARE_DYNCREATE(CMyNotepadView)

// ����
public:
	CMyNotepadDoc* GetDocument() const;

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
	virtual ~CMyNotepadView();
#ifdef _DEBUG
	virtual void AssertValid() const;
	virtual void Dump(CDumpContext& dc) const;
#endif

protected:
	BOOL m_nShowed; // ָ���Ƿ���Ҫ��ʾ����

private:
	CPoint m_ptOrigin;  // ������¼ֱ�����


// ���ɵ���Ϣӳ�亯��
protected:
	DECLARE_MESSAGE_MAP()
public:
	afx_msg void OnLButtonDown(UINT nFlags, CPoint point);
	afx_msg void OnLButtonUp(UINT nFlags, CPoint point);
	afx_msg void OnOpShow();
	afx_msg void OnUpdateOpShow(CCmdUI *pCmdUI);
	afx_msg void OnRButtonUp(UINT nFlags, CPoint point);
};

#ifndef _DEBUG  // MyNotepadView.cpp �еĵ��԰汾
inline CMyNotepadDoc* CMyNotepadView::GetDocument() const
   { return reinterpret_cast<CMyNotepadDoc*>(m_pDocument); }
#endif

