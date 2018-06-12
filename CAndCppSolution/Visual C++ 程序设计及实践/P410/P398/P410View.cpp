
// P398View.cpp : CP398View ���ʵ��
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
	// ��׼��ӡ����
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

// CP398View ����/����

CP410View::CP410View()
{
	// TODO: �ڴ˴���ӹ������

}

CP410View::~CP410View()
{
}

BOOL CP410View::PreCreateWindow(CREATESTRUCT& cs)
{
	// TODO: �ڴ˴�ͨ���޸�
	//  CREATESTRUCT cs ���޸Ĵ��������ʽ

	return CView::PreCreateWindow(cs);
}

// CP398View ����

void CP410View::OnDraw(CDC* pDC)
{
	CP410Doc* pDoc = GetDocument();
	ASSERT_VALID(pDoc);
	if (!pDoc)
		return;

	// TODO: �ڴ˴�Ϊ����������ӻ��ƴ���

// 	CLine line(CPoint(50,90),CPoint(300,90));
// 	line.Draw(pDC);

// 	CEllipse ellipse(CPoint(232,202),CPoint(312,282));
// 	ellipse.Draw(pDC);

	//CRectangle rect(CPoint(102,202),CPoint(182,282));
	//rect.Draw(pDC);

}


// CP398View ��ӡ


void CP410View::OnFilePrintPreview()
{
	AFXPrintPreview(this);
}

BOOL CP410View::OnPreparePrinting(CPrintInfo* pInfo)
{
	// Ĭ��׼��
	return DoPreparePrinting(pInfo);
}

void CP410View::OnBeginPrinting(CDC* /*pDC*/, CPrintInfo* /*pInfo*/)
{
	// TODO: ��Ӷ���Ĵ�ӡǰ���еĳ�ʼ������
}

void CP410View::OnEndPrinting(CDC* /*pDC*/, CPrintInfo* /*pInfo*/)
{
	// TODO: ��Ӵ�ӡ����е��������
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


// CP398View ���

#ifdef _DEBUG
void CP410View::AssertValid() const
{
	CView::AssertValid();
}

void CP410View::Dump(CDumpContext& dc) const
{
	CView::Dump(dc);
}

CP410Doc* CP410View::GetDocument() const // �ǵ��԰汾��������
{
	ASSERT(m_pDocument->IsKindOf(RUNTIME_CLASS(CP410Doc)));
	return (CP410Doc*)m_pDocument;
}
#endif //_DEBUG


// CP398View ��Ϣ�������

void CP410View::OnDrawEllipse()
{
	// TODO: �ڴ���������������
	CDC* pDC=GetDC();
	CEllipse ellipse(CPoint(232,202),CPoint(312,282));
	ellipse.Draw(pDC);

}

void CP410View::OnDrawLine()
{
	// TODO: �ڴ���������������
	CDC* pDC=GetDC();
	CLine line(CPoint(50,90),CPoint(300,90));
	line.Draw(pDC);
}

void CP410View::OnDrawRectangle()
{
	// TODO: �ڴ���������������
	CDC* pDC=GetDC();
	CRectangle rect(CPoint(102,202),CPoint(182,282));
	rect.Draw(pDC);
}

void CP410View::OnUpdateDrawLine(CCmdUI *pCmdUI)
{
	// TODO: �ڴ������������û����洦��������
}

void CP410View::OnUpdateDrawEllipse(CCmdUI *pCmdUI)
{
	// TODO: �ڴ������������û����洦��������
}

void CP410View::OnUpdateDrawRectangle(CCmdUI *pCmdUI)
{
	// TODO: �ڴ������������û����洦��������
}
