// RegDlg.cpp : ʵ���ļ�
//

#include "stdafx.h"
#include "UserInfoRegSdi.h"
#include "RegDlg.h"


// CRegDlg �Ի���

IMPLEMENT_DYNCREATE(CRegDlg, CDHtmlDialog)

CRegDlg::CRegDlg(CWnd* pParent /*=NULL*/)
	: CDHtmlDialog(CRegDlg::IDD, CRegDlg::IDH, pParent)
{

}

CRegDlg::~CRegDlg()
{
}

void CRegDlg::DoDataExchange(CDataExchange* pDX)
{
	CDHtmlDialog::DoDataExchange(pDX);
}

BOOL CRegDlg::OnInitDialog()
{
	CDHtmlDialog::OnInitDialog();
	return TRUE;  // ���ǽ��������õ��ؼ������򷵻� TRUE
}

BEGIN_MESSAGE_MAP(CRegDlg, CDHtmlDialog)
END_MESSAGE_MAP()

BEGIN_DHTML_EVENT_MAP(CRegDlg)
	DHTML_EVENT_ONCLICK(_T("ButtonOK"), OnButtonOK)
	DHTML_EVENT_ONCLICK(_T("ButtonCancel"), OnButtonCancel)
END_DHTML_EVENT_MAP()



// CRegDlg ��Ϣ�������

HRESULT CRegDlg::OnButtonOK(IHTMLElement* /*pElement*/)
{
	OnOK();
	return S_OK;
}

HRESULT CRegDlg::OnButtonCancel(IHTMLElement* /*pElement*/)
{
	OnCancel();
	return S_OK;
}
