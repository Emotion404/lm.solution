
// P398View.cpp : CP398View 类的实现
//

#include "stdafx.h"
#include "P410.h"

#include "P410Doc.h"
#include "P410View.h"

#include "Line.h"
#include "Ellipse.h"
#include "Rectangle.h"

#ifdef _DEBUG
#define new DEBUG_NEW
#endif


// CP398View

IMPLEMENT_DYNCREATE(CP410View, CView)

BEGIN_MESSAGE_MAP(CP410View, CView)
	// 标准打印命令
	ON_COMMAND(ID_FILE_PRINT, &CView::OnFilePrint)
	ON_COMMAND(ID_FILE_PRINT_DIRECT, &CView::OnFilePrint)
	ON_COMMAND(ID_FILE_PRINT_PREVIEW, &CP410View::OnFilePrintPreview)
	ON_COMMAND(ID_DRAW_ELLIPSE, &CP410View::OnDrawEllipse)
	ON_COMMAND(ID_DRAW_LINE, &CP410View::OnDrawLine)
	ON_COMMAND(ID_DRAW_RECTANGLE, &CP410View::OnDrawRectangle)
	ON_UPDATE_COMMAND_UI(ID_DRAW_LINE, &CP410View::OnUpdateDrawLine)
	ON_UPDATE_COMMAND_UI(ID_DRAW_ELLIPSE, &CP410View::OnUpdateDrawEllipse)
	ON_UPDATE_COMMAND_UI(ID_DRAW_RECTANGLE, &CP410View::OnUpdateDrawRectangle)
END_MESSAGE_MAP()

// CP398View 构造/析构

CP410View::CP410View()
{
	// TODO: 在此处添加构造代码

}

CP410View::~CP410View()
{
}

BOOL CP410View::PreCreateWindow(CREATESTRUCT& cs)
{
	// TODO: 在此处通过修改
	//  CREATESTRUCT cs 来修改窗口类或样式

	return CView::PreCreateWindow(cs);
}

// CP398View 绘制

void CP410View::OnDraw(CDC* pDC)
{
	CP410Doc* pDoc = GetDocument();
	ASSERT_VALID(pDoc);
	if (!pDoc)
		return;

	// TODO: 在此处为本机数据添加绘制代码

// 	CLine line(CPoint(50,90),CPoint(300,90));
// 	line.Draw(pDC);

// 	CEllipse ellipse(CPoint(232,202),CPoint(312,282));
// 	ellipse.Draw(pDC);

	//CRectangle rect(CPoint(102,202),CPoint(182,282));
	//rect.Draw(pDC);

}


// CP398View 打印


void CP410View::OnFilePrintPreview()
{
	AFXPrintPreview(this);
}

BOOL CP410View::OnPreparePrinting(CPrintInfo* pInfo)
{
	// 默认准备
	return DoPreparePrinting(pInfo);
}

void CP410View::OnBeginPrinting(CDC* /*pDC*/, CPrintInfo* /*pInfo*/)
{
	// TODO: 添加额外的打印前进行的初始化过程
}

void CP410View::OnEndPrinting(CDC* /*pDC*/, CPrintInfo* /*pInfo*/)
{
	// TODO: 添加打印后进行的清理过程
}

void CP410View::OnRButtonUp(UINT nFlags, CPoint point)
{
	ClientToScreen(&point);
	OnContextMenu(this, point);
}

void CP410View::OnContextMenu(CWnd* pWnd, CPoint point)
{
	theApp.GetContextMenuManager()->ShowPopupMenu(IDR_POPUP_EDIT, point.x, point.y, this, TRUE);
}


// CP398View 诊断

#ifdef _DEBUG
void CP410View::AssertValid() const
{
	CView::AssertValid();
}

void CP410View::Dump(CDumpContext& dc) const
{
	CView::Dump(dc);
}

CP410Doc* CP410View::GetDocument() const // 非调试版本是内联的
{
	ASSERT(m_pDocument->IsKindOf(RUNTIME_CLASS(CP410Doc)));
	return (CP410Doc*)m_pDocument;
}
#endif //_DEBUG


// CP398View 消息处理程序

void CP410View::OnDrawEllipse()
{
	// TODO: 在此添加命令处理程序代码
	CDC* pDC=GetDC();
	CEllipse ellipse(CPoint(232,202),CPoint(312,282));
	ellipse.Draw(pDC);

}

void CP410View::OnDrawLine()
{
	// TODO: 在此添加命令处理程序代码
	CDC* pDC=GetDC();
	CLine line(CPoint(50,90),CPoint(300,90));
	line.Draw(pDC);
}

void CP410View::OnDrawRectangle()
{
	// TODO: 在此添加命令处理程序代码
	CDC* pDC=GetDC();
	CRectangle rect(CPoint(102,202),CPoint(182,282));
	rect.Draw(pDC);
}

void CP410View::OnUpdateDrawLine(CCmdUI *pCmdUI)
{
	// TODO: 在此添加命令更新用户界面处理程序代码
}

void CP410View::OnUpdateDrawEllipse(CCmdUI *pCmdUI)
{
	// TODO: 在此添加命令更新用户界面处理程序代码
}

void CP410View::OnUpdateDrawRectangle(CCmdUI *pCmdUI)
{
	// TODO: 在此添加命令更新用户界面处理程序代码
}
