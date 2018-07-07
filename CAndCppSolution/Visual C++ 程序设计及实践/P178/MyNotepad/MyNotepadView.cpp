
// MyNotepadView.cpp : CMyNotepadView 类的实现
//

#include "stdafx.h"
#include "MyNotepad.h"

#include "MyNotepadDoc.h"
#include "MyNotepadView.h"

#ifdef _DEBUG
#define new DEBUG_NEW
#endif


// CMyNotepadView

IMPLEMENT_DYNCREATE(CMyNotepadView, CView)

BEGIN_MESSAGE_MAP(CMyNotepadView, CView)
	// 标准打印命令
	ON_COMMAND(ID_FILE_PRINT, &CView::OnFilePrint)
	ON_COMMAND(ID_FILE_PRINT_DIRECT, &CView::OnFilePrint)
	ON_COMMAND(ID_FILE_PRINT_PREVIEW, &CView::OnFilePrintPreview)

	ON_WM_LBUTTONDOWN()
	ON_WM_LBUTTONUP()
	ON_COMMAND(ID_OP_SHOW, &CMyNotepadView::OnOpShow)
END_MESSAGE_MAP()

// CMyNotepadView 构造/析构

CMyNotepadView::CMyNotepadView()
{
	// TODO: 在此处添加构造代码

	this->m_ptOrigin=0;
}

CMyNotepadView::~CMyNotepadView()
{
}

BOOL CMyNotepadView::PreCreateWindow(CREATESTRUCT& cs)
{
	// TODO: 在此处通过修改
	//  CREATESTRUCT cs 来修改窗口类或样式

	return CView::PreCreateWindow(cs);
}

// CMyNotepadView 绘制

void CMyNotepadView::OnDraw(CDC* /*pDC*/)
{
	CMyNotepadDoc* pDoc = GetDocument();
	ASSERT_VALID(pDoc);
	if (!pDoc)
		return;

	// TODO: 在此处为本机数据添加绘制代码
}


// CMyNotepadView 打印

BOOL CMyNotepadView::OnPreparePrinting(CPrintInfo* pInfo)
{
	// 默认准备
	return DoPreparePrinting(pInfo);
}

void CMyNotepadView::OnBeginPrinting(CDC* /*pDC*/, CPrintInfo* /*pInfo*/)
{
	// TODO: 添加额外的打印前进行的初始化过程
}

void CMyNotepadView::OnEndPrinting(CDC* /*pDC*/, CPrintInfo* /*pInfo*/)
{
	// TODO: 添加打印后进行的清理过程
}


// CMyNotepadView 诊断

#ifdef _DEBUG
void CMyNotepadView::AssertValid() const
{
	CView::AssertValid();
}

void CMyNotepadView::Dump(CDumpContext& dc) const
{
	CView::Dump(dc);
}

CMyNotepadDoc* CMyNotepadView::GetDocument() const // 非调试版本是内联的
{
	ASSERT(m_pDocument->IsKindOf(RUNTIME_CLASS(CMyNotepadDoc)));
	return (CMyNotepadDoc*)m_pDocument;
}
#endif //_DEBUG


// CMyNotepadView 消息处理程序

void CMyNotepadView::OnLButtonDown(UINT nFlags, CPoint point)
{
	// TODO: 在此添加消息处理程序代码和/或调用默认值

	// 直线的起点
	m_ptOrigin=point;

	//
	CView::OnLButtonDown(nFlags, point);
}

void CMyNotepadView::OnLButtonUp(UINT nFlags, CPoint point)
{
	// TODO: 在此添加消息处理程序代码和/或调用默认值

	// 使用 SDK 方式进行画线
	HDC hdc;
	hdc=::GetDC(m_hWnd);
	MoveToEx(hdc,m_ptOrigin.x,m_ptOrigin.y,NULL);
	LineTo(hdc,point.x,point.y);
	::ReleaseDC(m_hWnd,hdc);

	// 使用 CDC 方式进行画线
	CDC *dc;
	dc=GetDC();
	dc->MoveTo(m_ptOrigin);
	dc->LineTo(point);
	ReleaseDC(dc);

	// 使用 CClientDC 方式进行画线
	CClientDC dc2(this);
	dc2.MoveTo(m_ptOrigin);
	dc2.LineTo(point);

	// 使用 CWindowDC 方式进行画线
	// 略

	//
	CView::OnLButtonUp(nFlags, point);
}

void CMyNotepadView::OnOpShow()
{
	// TODO: 在此添加命令处理程序代码

	CDC* pDC=GetDC();
	CString strText=_T("hello SDI");
	pDC->TextOut(100,100,strText);
	ReleaseDC(pDC);
}
