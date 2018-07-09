
// MyNotepadView.cpp : CMyNotepadView ���ʵ��
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
	// ��׼��ӡ����
	ON_COMMAND(ID_FILE_PRINT, &CView::OnFilePrint)
	ON_COMMAND(ID_FILE_PRINT_DIRECT, &CView::OnFilePrint)
	ON_COMMAND(ID_FILE_PRINT_PREVIEW, &CView::OnFilePrintPreview)

//	ON_WM_LBUTTONDOWN()
	ON_WM_LBUTTONUP()
	ON_COMMAND(ID_OP_SHOW, &CMyNotepadView::OnOpShow)
	ON_UPDATE_COMMAND_UI(ID_OP_SHOW, &CMyNotepadView::OnUpdateOpShow)
	ON_WM_RBUTTONUP()
		ON_WM_LBUTTONDOWN()
END_MESSAGE_MAP()

// CMyNotepadView ����/����

CMyNotepadView::CMyNotepadView()
{
	// TODO: �ڴ˴���ӹ������

	this->m_ptOrigin=0;
	this->m_nShowed=FALSE;  // ��ʼ�� m_nShowed ֵ
}

CMyNotepadView::~CMyNotepadView()
{
}

BOOL CMyNotepadView::PreCreateWindow(CREATESTRUCT& cs)
{
	// TODO: �ڴ˴�ͨ���޸�
	//  CREATESTRUCT cs ���޸Ĵ��������ʽ

	return CView::PreCreateWindow(cs);
}

// CMyNotepadView ����

void CMyNotepadView::OnDraw(CDC* /*pDC*/)
{
	CMyNotepadDoc* pDoc = GetDocument();
	ASSERT_VALID(pDoc);
	if (!pDoc)
		return;

	// TODO: �ڴ˴�Ϊ����������ӻ��ƴ���
}


// CMyNotepadView ��ӡ

BOOL CMyNotepadView::OnPreparePrinting(CPrintInfo* pInfo)
{
	// Ĭ��׼��
	return DoPreparePrinting(pInfo);
}

void CMyNotepadView::OnBeginPrinting(CDC* /*pDC*/, CPrintInfo* /*pInfo*/)
{
	// TODO: ��Ӷ���Ĵ�ӡǰ���еĳ�ʼ������
}

void CMyNotepadView::OnEndPrinting(CDC* /*pDC*/, CPrintInfo* /*pInfo*/)
{
	// TODO: ��Ӵ�ӡ����е��������
}


// CMyNotepadView ���

#ifdef _DEBUG
void CMyNotepadView::AssertValid() const
{
	CView::AssertValid();
}

void CMyNotepadView::Dump(CDumpContext& dc) const
{
	CView::Dump(dc);
}

CMyNotepadDoc* CMyNotepadView::GetDocument() const // �ǵ��԰汾��������
{
	ASSERT(m_pDocument->IsKindOf(RUNTIME_CLASS(CMyNotepadDoc)));
	return (CMyNotepadDoc*)m_pDocument;
}
#endif //_DEBUG


// CMyNotepadView ��Ϣ�������

void CMyNotepadView::OnLButtonDown(UINT nFlags, CPoint point)
{
	// TODO: �ڴ������Ϣ�����������/�����Ĭ��ֵ

	// ֱ�ߵ����
	m_ptOrigin=point;

	SetCaretPos(point);  // ���ò������ʾ��λ��

	//
	CView::OnLButtonDown(nFlags, point);
}

void CMyNotepadView::OnLButtonUp(UINT nFlags, CPoint point)
{
	// TODO: �ڴ������Ϣ�����������/�����Ĭ��ֵ

	// ʹ�� SDK ��ʽ���л���
	HDC hdc;
	hdc=::GetDC(m_hWnd);
	MoveToEx(hdc,m_ptOrigin.x,m_ptOrigin.y,NULL);
	LineTo(hdc,point.x,point.y);
	::ReleaseDC(m_hWnd,hdc);

	// ʹ�� CDC ��ʽ���л���
	CDC *dc;
	dc=GetDC();
	dc->MoveTo(m_ptOrigin);
	dc->LineTo(point);
	ReleaseDC(dc);

	// ʹ�� CClientDC ��ʽ���л���
	CClientDC dc2(this);
	dc2.MoveTo(m_ptOrigin);
	dc2.LineTo(point);

	// ʹ�� CWindowDC ��ʽ���л���
	// ��

	//
	CView::OnLButtonUp(nFlags, point);
}

void CMyNotepadView::OnOpShow()  // �˵�������Ϣ����
{
	// TODO: �ڴ���������������

	if(!m_nShowed)  // ��ʾ����
	{
		CDC* pDC=GetDC();
		CString strText=_T("hello SDI");
		pDC->TextOut(100,100,strText);
		ReleaseDC(pDC);

	}
	else  // ˢ��,����ʾ����
	{

		InvalidateRect(NULL);  // �ú���ʹ����������ʾ��Ч,����ʵ��ˢ��
	}

	m_nShowed=!m_nShowed;
}

void CMyNotepadView::OnUpdateOpShow(CCmdUI *pCmdUI)  // �˵����������
{
	// TODO: �ڴ������������û����洦��������

	// ����ѡ�б��
	pCmdUI->SetCheck(m_nShowed);
}

void CMyNotepadView::OnRButtonUp(UINT nFlags, CPoint point)
{
	// TODO: �ڴ������Ϣ�����������/�����Ĭ��ֵ

	CMenu menu;  // ʹ�� CMenu ��ʵ�����˵�����
	menu.LoadMenu(IDR_MYPOP_MENU);  // ���ز˵���Դ
	CMenu* pMenu=menu.GetSubMenu(0);  // 0������ֵ, ����ָ����˵��ĵ�һ���Ӳ˵�
	ClientToScreen(&point);  // ���Կͻ�������ת������Ļ����
	pMenu->TrackPopupMenu(TPM_LEFTALIGN,point.x,point.y,this);  // �����˵�

	CView::OnRButtonUp(nFlags, point);
}

void CMyNotepadView::OnInitialUpdate()
{
	CView::OnInitialUpdate();



	// TODO: �ڴ����ר�ô����/����û���

	CreateSolidCaret(5,20);  // ������5�����ظ�20�����صĲ����
	ShowCaret();  // ��ʾ�����

}


