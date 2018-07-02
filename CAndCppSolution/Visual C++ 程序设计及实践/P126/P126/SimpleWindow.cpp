#include <Windows.h>
#include <tchar.h>

LRESULT CALLBACK WindowProc(
							HWND hwnd,
							UINT uMsg,
							WPARAM wParam,
							LPARAM lParam);

int WINAPI WinMain( 
				   HINSTANCE hInstance,
				   HINSTANCE hPreInstance,
				   LPSTR lpCmdLine,
				   int nCmdShow)
{
	WNDCLASS wndclass;
	wndclass.lpfnWndProc=WindowProc;
	wndclass.cbClsExtra=0;
	wndclass.cbWndExtra=0;
	wndclass.style=CS_HREDRAW|CS_VREDRAW;
	wndclass.lpszClassName=_T("我的窗体");
	wndclass.hInstance=hInstance;
	wndclass.hCursor=LoadCursor(NULL,IDC_ARROW);
	wndclass.hIcon=0;
	wndclass.hbrBackground=(HBRUSH)(COLOR_WINDOW+1);
	wndclass.lpszMenuName=0;

	if(RegisterClass(&wndclass)==0)
	{
		MessageBox(0,_T("注册窗口类失败"),_T("我的窗体"),MB_OK);
		return 0;
	}

	HWND hWnd=CreateWindow(
		_T("我的窗体"),
		_T("我的第一个窗体"),
		WS_OVERLAPPEDWINDOW,
		100,
		100,
		500,
		400,
		0,
		0,
		hInstance,
		0);

	ShowWindow(hWnd,SW_SHOW);
	UpdateWindow(hWnd);

	MSG msg;
	while(GetMessage(&msg,0,0,0))
	{
		TranslateMessage(&msg);
		DispatchMessage(&msg);
	}

	return 0;
}

LRESULT CALLBACK WindowProc(
							HWND hwnd,
							UINT uMsg,
							WPARAM wParam,
							LPARAM lParam)
{
	switch (uMsg)
	{
	case WM_CLOSE:
		PostQuitMessage(0);
		break;
	default:
		return DefWindowProc(hwnd,uMsg,wParam,lParam);
	}

	return 0;
}
