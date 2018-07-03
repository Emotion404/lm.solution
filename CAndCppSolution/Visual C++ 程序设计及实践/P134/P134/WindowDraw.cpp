#include <Windows.h>
#include <tchar.h>

LRESULT CALLBACK WindowProc(
							HWND hwnd,
							UINT uMsg,
							WPARAM wParam,
							LPARAM lParam);

int WINAPI WinMain(
				   HINSTANCE hInstance,
				   HINSTANCE hPrevInstance,
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
		_T("窗体绘图"),
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
	switch(uMsg)
	{
	case WM_PAINT:
		{
			PAINTSTRUCT ps;
			HDC hDC=BeginPaint(hwnd,&ps);

			HPEN hPen=CreatePen(PS_SOLID,1,RGB(255,0,0));
			HPEN hOldPen=(HPEN)SelectObject(hDC,hPen);

			MoveToEx(hDC,10,10,NULL);
			LineTo(hDC,90,50);

			HBRUSH hBrush=CreateSolidBrush(RGB(0,0,255));
			HBRUSH hOldBrush=(HBRUSH)SelectObject(hDC,hBrush);

			Rectangle(hDC,100,100,200,170);

			Ellipse(hDC,200,230,260,300);

			TextOut(hDC,200,30,_T("绘图测试"),4);

			SelectObject(hDC,hOldPen);
			SelectObject(hDC,hOldBrush);

			DeleteObject(hPen);
			DeleteObject(hBrush);

			EndPaint(hwnd,&ps);
		}
		break;
	case WM_CLOSE:
		{
			PostQuitMessage(0);
		}
		break;
	default:
		{
			return DefWindowProc(hwnd,uMsg,wParam,lParam);
		}
	}

	return 0;

}

