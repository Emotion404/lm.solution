
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
END_MESSAGE_MAP()

// CMyNotepadView ����/����

CMyNotepadView::CMyNotepadView()
{
	// TODO: �ڴ˴���ӹ������

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
