
// P398View.cpp : CP398View ���ʵ��
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
	// ��׼��ӡ����
	ON_COMMAND(ID_FILE_PRINT, &CView::OnFilePrint)
	ON_COMMAND(ID_FILE_PRINT_DIRECT, &CView::OnFilePrint)
	ON_COMMAND(ID_FILE_PRINT_PREVIEW, &CP398View::OnFilePrintPreview)
END_MESSAGE_MAP()

// CP398View ����/����

CP398View::CP398View()
{
	// TODO: �ڴ˴���ӹ������

}

CP398View::~CP398View()
{
}

BOOL CP398View::PreCreateWindow(CREATESTRUCT& cs)
{
	// TODO: �ڴ˴�ͨ���޸�
	//  CREATESTRUCT cs ���޸Ĵ��������ʽ

	return CView::PreCreateWindow(cs);
}

// CP398View ����

void CP398View::OnDraw(CDC* pDC)
{
	CP398Doc* pDoc = GetDocument();
	ASSERT_VALID(pDoc);
	if (!pDoc)
		return;

	// TODO: �ڴ˴�Ϊ����������ӻ��ƴ���

	CLine line(CPoint(50,90),CPoint(300,90));
	line.Draw(pDC);

	CEllipse ellipse(CPoint(232,202),CPoint(312,282));
	ellipse.Draw(pDC);

	CRectangle rect(CPoint(102,202),CPoint(182,282));
	rect.Draw(pDC);

}


// CP398View ��ӡ


void CP398View::OnFilePrintPreview()
{
	AFXPrintPreview(this);
}

BOOL CP398View::OnPreparePrinting(CPrintInfo* pInfo)
{
	// Ĭ��׼��
	return DoPreparePrinting(pInfo);
}

void CP398View::OnBeginPrinting(CDC* /*pDC*/, CPrintInfo* /*pInfo*/)
{
	// TODO: ��Ӷ���Ĵ�ӡǰ���еĳ�ʼ������
}

void CP398View::OnEndPrinting(CDC* /*pDC*/, CPrintInfo* /*pInfo*/)
{
	// TODO: ��Ӵ�ӡ����е��������
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


// CP398View ���

#ifdef _DEBUG
void CP398View::AssertValid() const
{
	CView::AssertValid();
}

void CP398View::Dump(CDumpContext& dc) const
{
	CView::Dump(dc);
}

CP398Doc* CP398View::GetDocument() const // �ǵ��԰汾��������
{
	ASSERT(m_pDocument->IsKindOf(RUNTIME_CLASS(CP398Doc)));
	return (CP398Doc*)m_pDocument;
}
#endif //_DEBUG


// CP398View ��Ϣ�������
