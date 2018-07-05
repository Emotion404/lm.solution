
// P168View.cpp : CP168View ���ʵ��
//

#include "stdafx.h"
#include "P168.h"

#include "P168Doc.h"
#include "P168View.h"

#ifdef _DEBUG
#define new DEBUG_NEW
#endif


// CP168View

IMPLEMENT_DYNCREATE(CP168View, CView)

BEGIN_MESSAGE_MAP(CP168View, CView)
	// ��׼��ӡ����
	ON_COMMAND(ID_FILE_PRINT, &CView::OnFilePrint)
	ON_COMMAND(ID_FILE_PRINT_DIRECT, &CView::OnFilePrint)
	ON_COMMAND(ID_FILE_PRINT_PREVIEW, &CP168View::OnFilePrintPreview)
END_MESSAGE_MAP()

// CP168View ����/����

CP168View::CP168View()
{
	// TODO: �ڴ˴���ӹ������

}

CP168View::~CP168View()
{
}

BOOL CP168View::PreCreateWindow(CREATESTRUCT& cs)
{
	// TODO: �ڴ˴�ͨ���޸�
	//  CREATESTRUCT cs ���޸Ĵ��������ʽ

	return CView::PreCreateWindow(cs);
}

// CP168View ����

void CP168View::OnDraw(CDC* pDC)
{
	CP168Doc* pDoc = GetDocument();
	ASSERT_VALID(pDoc);
	if (!pDoc)
		return;

	// TODO: �ڴ˴�Ϊ����������ӻ��ƴ���

	// ��ʾ��ͼ�����ʹ��
	pDC->Rectangle(90,90,300,200);
	CPen pen1,pen2;  // ���컭�ʶ���
	pen1.CreatePen(PS_SOLID,2,RGB(128,128,128));  // ��������
	pen2.CreatePen(PS_SOLID,2,RGB(128,128,0));
	CPen* pOldPen=pDC->SelectObject(&pen1);  // ѡ������ DC ,��������ľɶ���
	pDC->LineTo(100,100);  // ��ͼ
	pDC->SelectObject(&pen2);
	pDC->Ellipse(200,200,300,300);
	pDC->SelectObject(pOldPen);  // ���ָ�ԭ���Ķ���

}


// CP168View ��ӡ


void CP168View::OnFilePrintPreview()
{
	AFXPrintPreview(this);
}

BOOL CP168View::OnPreparePrinting(CPrintInfo* pInfo)
{
	// Ĭ��׼��
	return DoPreparePrinting(pInfo);
}

void CP168View::OnBeginPrinting(CDC* /*pDC*/, CPrintInfo* /*pInfo*/)
{
	// TODO: ��Ӷ���Ĵ�ӡǰ���еĳ�ʼ������
}

void CP168View::OnEndPrinting(CDC* /*pDC*/, CPrintInfo* /*pInfo*/)
{
	// TODO: ��Ӵ�ӡ����е��������
}

void CP168View::OnRButtonUp(UINT nFlags, CPoint point)
{
	ClientToScreen(&point);
	OnContextMenu(this, point);
}

void CP168View::OnContextMenu(CWnd* pWnd, CPoint point)
{
	theApp.GetContextMenuManager()->ShowPopupMenu(IDR_POPUP_EDIT, point.x, point.y, this, TRUE);
}


// CP168View ���

#ifdef _DEBUG
void CP168View::AssertValid() const
{
	CView::AssertValid();
}

void CP168View::Dump(CDumpContext& dc) const
{
	CView::Dump(dc);
}

CP168Doc* CP168View::GetDocument() const // �ǵ��԰汾��������
{
	ASSERT(m_pDocument->IsKindOf(RUNTIME_CLASS(CP168Doc)));
	return (CP168Doc*)m_pDocument;
}
#endif //_DEBUG


// CP168View ��Ϣ�������
