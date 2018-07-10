
// MyNotepadDoc.h : CMyNotepadDoc 类的接口
//


#pragma once


class CMyNotepadDoc : public CDocument
{
protected: // 仅从序列化创建
	CMyNotepadDoc();
	DECLARE_DYNCREATE(CMyNotepadDoc)

// 属性
public:
	CString m_strText;  // 窗体上输入的字符
	CPoint m_ptCaretPos;  // 记录插入符的位置

// 操作
public:

// 重写
public:
	virtual BOOL OnNewDocument();
	virtual void Serialize(CArchive& ar);

// 实现
public:
	virtual ~CMyNotepadDoc();
#ifdef _DEBUG
	virtual void AssertValid() const;
	virtual void Dump(CDumpContext& dc) const;
#endif

protected:

// 生成的消息映射函数
protected:
	DECLARE_MESSAGE_MAP()
};


