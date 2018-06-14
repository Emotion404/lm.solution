
// P398View.cpp : CP398View 类的实现
//

#include "stdafx.h"
#include "P414.h"

#include "P414Doc.h"
#include "P414View.h"

#include "Line.h"
#include "Ellipse.h"
#include "Rectangle.h"

#ifdef _DEBUG
#define new DEBUG_NEW
#endif


// CP398View

IMPLEMENT_DYNCREATE(CP414View, CView)

BEGIN_MESSAGE_MAP(CP414View, CView)
	// 标准打印命令
	ON_COMMAND(ID_FILE_PRINT, &CView::OnFilePrint)
	ON_COMMAND(ID_FILE_PRINT_DIRECT, &CView::OnFilePrint)
	ON_COMMAND(ID_FILE_PRINT_PREVIEW, &CP414View::OnFilePrintPreview)
	ON_COMMAND(ID_DRAW_ELLIPSE, &CP414View::OnDrawEllipse)
	ON_COMMAND(ID_DRAW_LINE, &CP414View::OnDrawLine)
	ON_COMMAND(ID_DRAW_RECTANGLE, &CP414View::OnDrawRectangle)
	ON_UPDATE_COMMAND_UI(ID_DRAW_LINE, &CP414View::OnUpdateDrawLine)
	ON_UPDATE_COMMAND_UI(ID_DRAW_ELLIPSE, &CP414View::OnUpdateDrawEllipse)
	ON_UPDATE_COMMAND_UI(ID_DRAW_RECTANGLE, &CP414View::OnUpdateDrawRectangle)
	ON_WM_LBUTTONDOWN()
	ON_WM_MOUSEMOVE()
	ON_WM_LBUTTONUP()
END_MESSAGE_MAP()

// CP398View 构造/析构

CP414View::CP414View()
{
	// TODO: 在此处添加构造代码

}

CP414View::~CP414View()
{
}

BOOL CP414View::PreCreateWindow(CREATESTRUCT& cs)
{
	// TODO: 在此处通过修改
	//  CREATESTRUCT cs 来修改窗口类或样式

	return CView::PreCreateWindow(cs);
}



// CP398View 绘制

void CP414View::OnDraw(CDC* pDC)
{
	CP414Doc* pDoc = GetDocument();
	ASSERT_VALID(pDoc);
	if (!pDoc)
		return;

	// TODO: 在此处为本机数据添加绘制代码

	// 绘制已有
	POSITION pos;
	for(pos=GetDocument()->m_obList.GetHeadPosition();pos!=NULL;)
	{
		CShape* pShape=(CShape*)(GetDocument()->m_obList.GetNext(pos));
		pShape->Draw(pDC);
	}

	// 绘制当前
	if(m_nType>0&&m_bDrawing)
	{
		m_pShape->Draw(pDC);
	}

}


// CP398View 打印


void CP414View::OnFilePrintPreview()
{
	AFXPrintPreview(this);
}

BOOL CP414View::OnPreparePrinting(CPrintInfo* pInfo)
{
	// 默认准备
	return DoPreparePrinting(pInfo);
}

void CP414View::OnBeginPrinting(CDC* /*pDC*/, CPrintInfo* /*pInfo*/)
{
	// TODO: 添加额外的打印前进行的初始化过程
}

void CP414View::OnEndPrinting(CDC* /*pDC*/, CPrintInfo* /*pInfo*/)
{
	// TODO: 添加打印后进行的清理过程
}

void CP414View::OnRButtonUp(UINT nFlags, CPoint point)
{
	ClientToScreen(&point);
	OnContextMenu(this, point);
}

void CP414View::OnContextMenu(CWnd* pWnd, CPoint point)
{
	theApp.GetContextMenuManager()->ShowPopupMenu(IDR_POPUP_EDIT, point.x, point.y, this, TRUE);
}


// CP398View 诊断

#ifdef _DEBUG
void CP414View::AssertValid() const
{
	CView::AssertValid();
}

void CP414View::Dump(CDumpContext& dc) const
{
	CView::Dump(dc);
}

CP414Doc* CP414View::GetDocument() const // 非调试版本是内联的
{
	ASSERT(m_pDocument->IsKindOf(RUNTIME_CLASS(CP414Doc)));
	return (CP414Doc*)m_pDocument;
}
#endif //_DEBUG


// CP398View 消息处理程序

void CP414View::OnDrawEllipse()
{
	// TODO: 在此添加命令处理程序代码
	//CDC* pDC=GetDC();
	//CEllipse ellipse(CPoint(232,202),CPoint(312,282));
	//ellipse.Draw(pDC);
	m_nType=3;

}

void CP414View::OnDrawLine()
{
	// TODO: 在此添加命令处理程序代码
	CDC* pDC=GetDC();
	CLine line(CPoint(50,90),CPoint(300,90));
	line.Draw(pDC);

	//m_nType=1;
}

void CP414View::OnDrawRectangle()
{
	// TODO: 在此添加命令处理程序代码
	//CDC* pDC=GetDC();
	//CRectangle rect(CPoint(102,202),CPoint(182,282));
	//rect.Draw(pDC);

	m_nType=2;

}

void CP414View::OnUpdateDrawLine(CCmdUI *pCmdUI)
{
	// TODO: 在此添加命令更新用户界面处理程序代码

	pCmdUI->SetCheck(m_nType==1);

}

void CP414View::OnUpdateDrawEllipse(CCmdUI *pCmdUI)
{
	// TODO: 在此添加命令更新用户界面处理程序代码

	pCmdUI->SetCheck(m_nType==3);

}

void CP414View::OnUpdateDrawRectangle(CCmdUI *pCmdUI)
{
	// TODO: 在此添加命令更新用户界面处理程序代码

	pCmdUI->SetCheck(m_nType==2);

}

void CP414View::OnLButtonDown(UINT nFlags, CPoint point)
{
	// TODO: 在此添加消息处理程序代码和/或调用默认值

	if(m_nType>0)
	{
		m_ptStart=point;
		m_bDrawing=TRUE;

		switch(m_nType)
		{
		case 1:
				m_pShape=new CLine(m_ptStart,m_ptStart);
			break;
		case 2:
				m_pShape=new CRectangle(m_ptStart,m_ptStart);
			break;
		case 3:
				m_pShape=new CEllipse(m_ptStart,m_ptStart);
			break;
		}
	}

	CView::OnLButtonDown(nFlags, point);
}

void CP414View::OnMouseMove(UINT nFlags, CPoint point)
{
	// TODO: 在此添加消息处理程序代码和/或调用默认值

	if(m_nType>0&& m_bDrawing)
	{
		m_pShape->SetPos(m_ptStart,point);
		Invalidate();
	}

	CView::OnMouseMove(nFlags, point);
}

void CP414View::OnLButtonUp(UINT nFlags, CPoint point)
{
	// TODO: 在此添加消息处理程序代码和/或调用默认值

	if(m_nType>0)
	{
		m_bDrawing=FALSE;
		GetDocument()->m_obList.AddTail(m_pShape);
		m_nType=0;
	}

	CView::OnLButtonUp(nFlags, point);
}
