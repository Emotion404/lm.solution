// RegDlg.cpp : ʵ���ļ�
//

#include "stdafx.h"
#include "UserInfoRegSdi.h"
#include "RegDlg.h"


// CRegDlg �Ի���

IMPLEMENT_DYNCREATE(CRegDlg, CDHtmlDialog)

CRegDlg::CRegDlg(CWnd* pParent /*=NULL*/)
	: CDHtmlDialog(CRegDlg::IDD, CRegDlg::IDH, pParent)
	, m_edUserName(_T(""))
	, m_edPhone(_T(""))
	, m_edEmail(_T(""))
{

}

CRegDlg::~CRegDlg()
{
}

void CRegDlg::DoDataExchange(CDataExchange* pDX)
{
	CDHtmlDialog::DoDataExchange(pDX);

	//
	DDX_Text(pDX, IDC_ED_USERNAME, m_edUserName);
	DDX_Text(pDX, IDC_ED_PHONE, m_edPhone);
	DDX_Text(pDX, IDC_ED_EMAIL, m_edEmail);

	//
	DDV_MaxChars(pDX, m_edPhone, 13);
}

BOOL CRegDlg::OnInitDialog()
{
	m_edUserName=_T("Ҧ����");
	m_edEmail=_T("yaodongfeng@163.com");
	m_edPhone=_T("13088888888");

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

void CRegDlg::OnOK()
{
	// TODO: �ڴ����ר�ô����/����û���

	CDHtmlDialog::OnOK();

	//DestroyWindow();  // ���ٶԻ���
}

void CRegDlg::OnCancel()
{
	// TODO: �ڴ����ר�ô����/����û���

	CDHtmlDialog::OnCancel();

	//DestroyWindow();  // ���ٶԻ��� 
}

void CRegDlg::PostNcDestroy()
{
	// TODO: �ڴ����ר�ô����/����û���

	CDHtmlDialog::PostNcDestroy();

	//delete this;  // ɾ���Ի�����ռ�Ķ�̬�ڴ� 
}
