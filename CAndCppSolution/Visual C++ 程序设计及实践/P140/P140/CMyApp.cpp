#include <afxwin.h>  // ���� MFC ͷ�ļ�
#include "CMyApp.h"

BOOL CMyApp:: InitInstance()  // ���Ǽ̳е�Ӧ�ó����ʼ���麯��
{
	// �������岢���浽 m_pMainWnd ��
	m_pMainWnd=new CMyWnd(_T("һ���򵥵� MFC ����"));
	m_pMainWnd->ShowWindow(m_nCmdShow);

	// ���� AfxMessageBox() �������÷�
	int nRet = AfxMessageBox(_T("����"),MB_ABORTRETRYIGNORE );
	if(nRet==IDABORT)
	{
		AfxMessageBox(_T("�û�������'��ֹ'��ť"),MB_OK|MB_ICONINFORMATION);
	}
	else if(nRet==IDRETRY)
	{
		AfxMessageBox(_T("�û�������'����'��ť"),MB_OK|MB_ICONINFORMATION		  );
	}
	else if(nRet==IDIGNORE)
	{
		AfxMessageBox(_T("�û�������'����'��ť"),MB_OK|MB_ICONINFORMATION		  );
	}

	// �����ַ���
	CString str1(_T("������"));
	CString str2(_T("��������"));
	CString str3=str1+str2;
	str3=str3+_T("�ൺ");
	AfxMessageBox(str3);

	// �����ַ���
	nRet=str3.Find(str2);
	if(nRet>=0)
	{
		AfxMessageBox(_T("�ҵ��ַ���"));
	}
	else
	{
		AfxMessageBox(_T("û��ƥ����ַ���"));
	}

	// ��ȡ�ַ���
	CString str4=str1.Left(2)+str3.Mid(3,2)+str2.Right(2);
	AfxMessageBox(_T("��ȡ���ַ���Ϊ:" )+str4);

	return TRUE;
}
