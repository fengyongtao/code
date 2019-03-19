package store.coding;

public enum Code {

	UTF8(1, "UTF-8"), 
	GBK(2, "GBK"),
	USASCII(3, "US-ASCII"),
	ISO88591(4, "ISO8859-1"),
	GB2312(5, "GB2312"),
	BIG5(6, "BIG5"),
	Unicode(7, "Unicode"),
	windows1252(8, "windows-1252"),
	ShiftJis(9, "Shift_Jis"),
	UTF16(10, "UTF_16"),
	UTF16LE(11, "UTF_16LE"),
	UTF16BE(12, "UTF_16BE");
	
	// 成员变量
	private Integer index;
	private String name;
	
	// 构造函数 
	private Code(int index, String name) {
		this.index = index;
        this.name = name;
    }
	
	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}
	
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
