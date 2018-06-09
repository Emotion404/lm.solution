
#include <tchar.h>
#include <Windows.h>
#include <iostream>

#include "Line.h"
#include "Rectangle.h"
#include "Ellipse.h"

using namespace std;

LRESULT CALLBACK WindowProc(HWND hWnd,UINT uMsg,WPARAM wParam,LPARAM lParam);

int WINAPI WinMain( HINSTANCE hInstance, 
				    HINSTANCE hPrevInstance, 
				    LPSTR lpCmdLine, 
				    int nShowCmd )
{
	WNDCLASS wndClass;
	wndClass.lpfnWndProc=WindowProc;
	wndClass.cbClsExtra=0;
	wndClass.cbWndExtra=0;
	wndClass.style=CS_HREDRAW|CS_VREDRAW;
	wndClass.lpszClassName=_T("我的窗体");
	wndClass.hInstance=hInstance;
	wndClass.hCursor=LoadCursor(NULL,IDC_ARROW);
	wndClass.hIcon=0;
	wndClass.hbrBackground=(HBRUSH)(COLOR_WINDOW+1);
	wndClass.lpszMenuName=0;

	if(RegisterClass(&wndClass)==0)
	{
		MessageBox(0,_T("注册窗口类失败"),_T("我的窗体"),MB_OK);
		return 0;
	}

	HWND hWnd=CreateWindow(_T("我的窗体"),_T("窗体绘图"),WS_OVERLAPPEDWINDOW,100,100,500,400,0,0,hInstance,0);

	ShowWindow(hWnd,SW_SHOW);
	UpdateWindow(hWnd);

	MSG msg;
	while (GetMessage(&msg,0,0,0))
	{
		TranslateMessage(&msg);
		DispatchMessage(&msg);
	}

	return 0;
}

LRESULT CALLBACK WindowProc(HWND hWnd,UINT uMsg,WPARAM wParam,LPARAM lParam)
{
	switch(uMsg)
	{
	case WM_PAINT:
		{
			PAINTSTRUCT ps;
			HDC hDC=BeginPaint(hWnd,&ps);
			
			CLine line(50,90,300,90,RGB(0,0,0));
			line.Draw(hDC);

			CRectangle rect(102,202,182,282,RGB(192,192,192));
			rect.Draw(hDC);

			CEllipse ellipse(232,202,312,282,RGB(128,128,0));
			ellipse.Draw(hDC);

			EndPaint(hWnd,&ps);

		}
		break;
	case WM_CLOSE:
			PostQuitMessage(0);
		break;
	default:
		return DefWindowProc(hWnd,uMsg,wParam,lParam);
	}

	return 0;
}
