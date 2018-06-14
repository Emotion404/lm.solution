
// P398Doc.h : CP398Doc 类的接口
//


#pragma once


class CP414Doc : public CDocument
{
protected: // 仅从序列化创建
	CP414Doc();
	DECLARE_DYNCREATE(CP414Doc)

// 属性
public:

// 操作
public:

// 重写
public:
	
	CObList m_obList;

	virtual BOOL OnNewDocument();
	virtual void Serialize(CArchive& ar);

// 实现
public:
	virtual ~CP414Doc();
#ifdef _DEBUG
	virtual void AssertValid() const;
	virtual void Dump(CDumpContext& dc) const;
#endif

protected:

// 生成的消息映射函数
protected:
	DECLARE_MESSAGE_MAP()
};


