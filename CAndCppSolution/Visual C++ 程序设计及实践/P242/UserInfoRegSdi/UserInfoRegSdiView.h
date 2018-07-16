
// UserInfoRegSdiView.h : CUserInfoRegSdiView 类的接口
//


#pragma once


class CUserInfoRegSdiView : public CView
{
protected: // 仅从序列化创建
	CUserInfoRegSdiView();
	DECLARE_DYNCREATE(CUserInfoRegSdiView)

// 属性
public:
	CUserInfoRegSdiDoc* GetDocument() const;

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
	virtual ~CUserInfoRegSdiView();
#ifdef _DEBUG
	virtual void AssertValid() const;
	virtual void Dump(CDumpContext& dc) const;
#endif

protected:

// 生成的消息映射函数
protected:
	DECLARE_MESSAGE_MAP()
public:
	afx_msg void OnAppReg();
};

#ifndef _DEBUG  // UserInfoRegSdiView.cpp 中的调试版本
inline CUserInfoRegSdiDoc* CUserInfoRegSdiView::GetDocument() const
   { return reinterpret_cast<CUserInfoRegSdiDoc*>(m_pDocument); }
#endif

