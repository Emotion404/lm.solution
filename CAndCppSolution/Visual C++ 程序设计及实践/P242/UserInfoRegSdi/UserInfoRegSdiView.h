
// UserInfoRegSdiView.h : CUserInfoRegSdiView ��Ľӿ�
//


#pragma once


class CUserInfoRegSdiView : public CView
{
protected: // �������л�����
	CUserInfoRegSdiView();
	DECLARE_DYNCREATE(CUserInfoRegSdiView)

// ����
public:
	CUserInfoRegSdiDoc* GetDocument() const;

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
	virtual ~CUserInfoRegSdiView();
#ifdef _DEBUG
	virtual void AssertValid() const;
	virtual void Dump(CDumpContext& dc) const;
#endif

protected:

// ���ɵ���Ϣӳ�亯��
protected:
	DECLARE_MESSAGE_MAP()
public:
	afx_msg void OnAppReg();
};

#ifndef _DEBUG  // UserInfoRegSdiView.cpp �еĵ��԰汾
inline CUserInfoRegSdiDoc* CUserInfoRegSdiView::GetDocument() const
   { return reinterpret_cast<CUserInfoRegSdiDoc*>(m_pDocument); }
#endif

