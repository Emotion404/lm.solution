#include <afxwin.h>  // ���� MFC ͷ�ļ�

class CMyWnd:public CFrameWnd  // �� MFC ������ܴ��������û�������
{
public:
	CMyWnd(LPCTSTR szTitle)
	{
		Create(NULL,szTitle);  // ���ø���� Create ������������
	}
};

class CMyApp:public CWinApp  // �� MFC ��Ӧ�ó��������û�������
{
public:
	virtual BOOL InitInstance();
};
BOOL CMyApp:: InitInstance()  // ���Ǽ̳е�Ӧ�ó����ʼ���麯��
{
	// �������岢���浽 m_pMainWnd ��
	m_pMainWnd=new CMyWnd(_T("һ���򵥵� MFC ����"));
	m_pMainWnd->ShowWindow(m_nCmdShow);

	return TRUE;
}

CMyApp myApp; // �����û�����ȫ�ֶ���
