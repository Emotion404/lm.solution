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

	// 

	return TRUE;
}
