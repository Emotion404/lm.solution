
// P398View.cpp : CP398View ���ʵ��
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
	// ��׼��ӡ����
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

// CP398View ����/����

CP414View::CP414View()
{
	// TODO: �ڴ˴���ӹ������

}

CP414View::~CP414View()
{
}

BOOL CP414View::PreCreateWindow(CREATESTRUCT& cs)
{
	// TODO: �ڴ˴�ͨ���޸�
	//  CREATESTRUCT cs ���޸Ĵ��������ʽ

	return CView::PreCreateWindow(cs);
}



// CP398View ����

void CP414View::OnDraw(CDC* pDC)
{
	CP414Doc* pDoc = GetDocument();
	ASSERT_VALID(pDoc);
	if (!pDoc)
		return;

	// TODO: �ڴ˴�Ϊ����������ӻ��ƴ���

	// ��������
	POSITION pos;
	for(pos=GetDocument()->m_obList.GetHeadPosition();pos!=NULL;)
	{
		CShape* pShape=(CShape*)(GetDocument()->m_obList.GetNext(pos));
		pShape->Draw(pDC);
	}

	// ���Ƶ�ǰ
	if(m_nType>0&&m_bDrawing)
	{
		m_pShape->Draw(pDC);
	}

}


// CP398View ��ӡ


void CP414View::OnFilePrintPreview()
{
	AFXPrintPreview(this);
}

BOOL CP414View::OnPreparePrinting(CPrintInfo* pInfo)
{
	// Ĭ��׼��
	return DoPreparePrinting(pInfo);
}

void CP414View::OnBeginPrinting(CDC* /*pDC*/, CPrintInfo* /*pInfo*/)
{
	// TODO: ��Ӷ���Ĵ�ӡǰ���еĳ�ʼ������
}

void CP414View::OnEndPrinting(CDC* /*pDC*/, CPrintInfo* /*pInfo*/)
{
	// TODO: ��Ӵ�ӡ����е��������
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


// CP398View ���

#ifdef _DEBUG
void CP414View::AssertValid() const
{
	CView::AssertValid();
}

void CP414View::Dump(CDumpContext& dc) const
{
	CView::Dump(dc);
}

CP414Doc* CP414View::GetDocument() const // �ǵ��԰汾��������
{
	ASSERT(m_pDocument->IsKindOf(RUNTIME_CLASS(CP414Doc)));
	return (CP414Doc*)m_pDocument;
}
#endif //_DEBUG


// CP398View ��Ϣ�������

void CP414View::OnDrawEllipse()
{
	// TODO: �ڴ���������������
	//CDC* pDC=GetDC();
	//CEllipse ellipse(CPoint(232,202),CPoint(312,282));
	//ellipse.Draw(pDC);
	m_nType=3;

}

void CP414View::OnDrawLine()
{
	// TODO: �ڴ���������������
	CDC* pDC=GetDC();
	CLine line(CPoint(50,90),CPoint(300,90));
	line.Draw(pDC);

	//m_nType=1;
}

void CP414View::OnDrawRectangle()
{
	// TODO: �ڴ���������������
	//CDC* pDC=GetDC();
	//CRectangle rect(CPoint(102,202),CPoint(182,282));
	//rect.Draw(pDC);

	m_nType=2;

}

void CP414View::OnUpdateDrawLine(CCmdUI *pCmdUI)
{
	// TODO: �ڴ������������û����洦��������

	pCmdUI->SetCheck(m_nType==1);

}

void CP414View::OnUpdateDrawEllipse(CCmdUI *pCmdUI)
{
	// TODO: �ڴ������������û����洦��������

	pCmdUI->SetCheck(m_nType==3);

}

void CP414View::OnUpdateDrawRectangle(CCmdUI *pCmdUI)
{
	// TODO: �ڴ������������û����洦��������

	pCmdUI->SetCheck(m_nType==2);

}

void CP414View::OnLButtonDown(UINT nFlags, CPoint point)
{
	// TODO: �ڴ������Ϣ�����������/�����Ĭ��ֵ

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
	// TODO: �ڴ������Ϣ�����������/�����Ĭ��ֵ

	if(m_nType>0&& m_bDrawing)
	{
		m_pShape->SetPos(m_ptStart,point);
		Invalidate();
	}

	CView::OnMouseMove(nFlags, point);
}

void CP414View::OnLButtonUp(UINT nFlags, CPoint point)
{
	// TODO: �ڴ������Ϣ�����������/�����Ĭ��ֵ

	if(m_nType>0)
	{
		m_bDrawing=FALSE;
		GetDocument()->m_obList.AddTail(m_pShape);
		m_nType=0;
	}

	CView::OnLButtonUp(nFlags, point);
}
