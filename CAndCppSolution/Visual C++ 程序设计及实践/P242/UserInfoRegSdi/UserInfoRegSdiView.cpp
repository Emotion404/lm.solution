
// UserInfoRegSdiView.cpp : CUserInfoRegSdiView ���ʵ��
//

#include "stdafx.h"
#include "UserInfoRegSdi.h"

#include "UserInfoRegSdiDoc.h"
#include "UserInfoRegSdiView.h"

#ifdef _DEBUG
#define new DEBUG_NEW
#endif


// CUserInfoRegSdiView

IMPLEMENT_DYNCREATE(CUserInfoRegSdiView, CView)

BEGIN_MESSAGE_MAP(CUserInfoRegSdiView, CView)
	// ��׼��ӡ����
	ON_COMMAND(ID_FILE_PRINT, &CView::OnFilePrint)
	ON_COMMAND(ID_FILE_PRINT_DIRECT, &CView::OnFilePrint)
	ON_COMMAND(ID_FILE_PRINT_PREVIEW, &CView::OnFilePrintPreview)
END_MESSAGE_MAP()

// CUserInfoRegSdiView ����/����

CUserInfoRegSdiView::CUserInfoRegSdiView()
{
	// TODO: �ڴ˴���ӹ������

}

CUserInfoRegSdiView::~CUserInfoRegSdiView()
{
}

BOOL CUserInfoRegSdiView::PreCreateWindow(CREATESTRUCT& cs)
{
	// TODO: �ڴ˴�ͨ���޸�
	//  CREATESTRUCT cs ���޸Ĵ��������ʽ

	return CView::PreCreateWindow(cs);
}

// CUserInfoRegSdiView ����

void CUserInfoRegSdiView::OnDraw(CDC* /*pDC*/)
{
	CUserInfoRegSdiDoc* pDoc = GetDocument();
	ASSERT_VALID(pDoc);
	if (!pDoc)
		return;

	// TODO: �ڴ˴�Ϊ����������ӻ��ƴ���
}


// CUserInfoRegSdiView ��ӡ

BOOL CUserInfoRegSdiView::OnPreparePrinting(CPrintInfo* pInfo)
{
	// Ĭ��׼��
	return DoPreparePrinting(pInfo);
}

void CUserInfoRegSdiView::OnBeginPrinting(CDC* /*pDC*/, CPrintInfo* /*pInfo*/)
{
	// TODO: ��Ӷ���Ĵ�ӡǰ���еĳ�ʼ������
}

void CUserInfoRegSdiView::OnEndPrinting(CDC* /*pDC*/, CPrintInfo* /*pInfo*/)
{
	// TODO: ��Ӵ�ӡ����е��������
}


// CUserInfoRegSdiView ���

#ifdef _DEBUG
void CUserInfoRegSdiView::AssertValid() const
{
	CView::AssertValid();
}

void CUserInfoRegSdiView::Dump(CDumpContext& dc) const
{
	CView::Dump(dc);
}

CUserInfoRegSdiDoc* CUserInfoRegSdiView::GetDocument() const // �ǵ��԰汾��������
{
	ASSERT(m_pDocument->IsKindOf(RUNTIME_CLASS(CUserInfoRegSdiDoc)));
	return (CUserInfoRegSdiDoc*)m_pDocument;
}
#endif //_DEBUG


// CUserInfoRegSdiView ��Ϣ�������
