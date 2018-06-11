
// P398View.cpp : CP398View 类的实现
//

#include "stdafx.h"
#include "P398.h"

#include "P398Doc.h"
#include "P398View.h"

#include "Line.h"
#include "Ellipse.h"
#include "Rectangle.h"

#ifdef _DEBUG
#define new DEBUG_NEW
#endif


// CP398View

IMPLEMENT_DYNCREATE(CP398View, CView)

BEGIN_MESSAGE_MAP(CP398View, CView)
	// 标准打印命令
	ON_COMMAND(ID_FILE_PRINT, &CView::OnFilePrint)
	ON_COMMAND(ID_FILE_PRINT_DIRECT, &CView::OnFilePrint)
	ON_COMMAND(ID_FILE_PRINT_PREVIEW, &CP398View::OnFilePrintPreview)
END_MESSAGE_MAP()

// CP398View 构造/析构

CP398View::CP398View()
{
	// TODO: 在此处添加构造代码

}

CP398View::~CP398View()
{
}

BOOL CP398View::PreCreateWindow(CREATESTRUCT& cs)
{
	// TODO: 在此处通过修改
	//  CREATESTRUCT cs 来修改窗口类或样式

	return CView::PreCreateWindow(cs);
}

// CP398View 绘制

void CP398View::OnDraw(CDC* pDC)
{
	CP398Doc* pDoc = GetDocument();
	ASSERT_VALID(pDoc);
	if (!pDoc)
		return;

	// TODO: 在此处为本机数据添加绘制代码

	CLine line(CPoint(50,90),CPoint(300,90));
	line.Draw(pDC);

	CEllipse ellipse(CPoint(232,202),CPoint(312,282));
	ellipse.Draw(pDC);

	CRectangle rect(CPoint(102,202),CPoint(182,282));
	rect.Draw(pDC);

}


// CP398View 打印


void CP398View::OnFilePrintPreview()
{
	AFXPrintPreview(this);
}

BOOL CP398View::OnPreparePrinting(CPrintInfo* pInfo)
{
	// 默认准备
	return DoPreparePrinting(pInfo);
}

void CP398View::OnBeginPrinting(CDC* /*pDC*/, CPrintInfo* /*pInfo*/)
{
	// TODO: 添加额外的打印前进行的初始化过程
}

void CP398View::OnEndPrinting(CDC* /*pDC*/, CPrintInfo* /*pInfo*/)
{
	// TODO: 添加打印后进行的清理过程
}

void CP398View::OnRButtonUp(UINT nFlags, CPoint point)
{
	ClientToScreen(&point);
	OnContextMenu(this, point);
}

void CP398View::OnContextMenu(CWnd* pWnd, CPoint point)
{
	theApp.GetContextMenuManager()->ShowPopupMenu(IDR_POPUP_EDIT, point.x, point.y, this, TRUE);
}


// CP398View 诊断

#ifdef _DEBUG
void CP398View::AssertValid() const
{
	CView::AssertValid();
}

void CP398View::Dump(CDumpContext& dc) const
{
	CView::Dump(dc);
}

CP398Doc* CP398View::GetDocument() const // 非调试版本是内联的
{
	ASSERT(m_pDocument->IsKindOf(RUNTIME_CLASS(CP398Doc)));
	return (CP398Doc*)m_pDocument;
}
#endif //_DEBUG


// CP398View 消息处理程序
