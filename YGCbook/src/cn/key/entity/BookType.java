package cn.key.entity;

public class BookType {
	private int bookTypeId;
	private int parentId;
	private String bookTypeName;
	private int isDelete;
	private String context;

	public BookType() {
		super();
	}

	public BookType(int bookTypeId, int parentId, String bookTypeName,
			int isDelete, String context) {
		super();
		this.bookTypeId = bookTypeId;
		this.parentId = parentId;
		this.bookTypeName = bookTypeName;
		this.isDelete = isDelete;
		this.context = context;
	}
	public BookType(int parentId, String bookTypeName,
			int isDelete, String context) {
		this.parentId = parentId;
		this.bookTypeName = bookTypeName;
		this.isDelete = isDelete;
		this.context = context;
	}


	public BookType(int parentId, String bookTypeName, String context) {
		this.parentId = parentId;
		this.bookTypeName = bookTypeName;
		this.context = context;
	}


	public BookType(int bookTypeId, int parentId, String bookTypeName,
			String context) {
		super();
		this.bookTypeId = bookTypeId;
		this.parentId = parentId;
		this.bookTypeName = bookTypeName;
		this.context = context;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bookTypeId;
		result = prime * result
				+ ((bookTypeName == null) ? 0 : bookTypeName.hashCode());
		result = prime * result + ((context == null) ? 0 : context.hashCode());
		result = prime * result + isDelete;
		result = prime * result + parentId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if ((obj == null) || (getClass() != obj.getClass()))
			return false;
		BookType other = (BookType) obj;
		if (bookTypeId != other.bookTypeId)
			return false;
		if (bookTypeName == null) {
			if (other.bookTypeName != null)
				return false;
		} else if (!bookTypeName.equals(other.bookTypeName))
			return false;
		if (context == null) {
			if (other.context != null)
				return false;
		} else if (!context.equals(other.context))
			return false;
		if ((isDelete != other.isDelete) || (parentId != other.parentId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BookType [bookTypeId=" + bookTypeId + ", parentId=" + parentId
				+ ", bookTypeName=" + bookTypeName + ", isDelete=" + isDelete
				+ ", context=" + context + "]";
	}

	public int getBookTypeId() {
		return bookTypeId;
	}
	public void setBookTypeId(int bookTypeId) {
		this.bookTypeId = bookTypeId;
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public String getBookTypeName() {
		return bookTypeName;
	}
	public void setBookTypeName(String bookTypeName) {
		this.bookTypeName = bookTypeName;
	}
	public int getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}

}
