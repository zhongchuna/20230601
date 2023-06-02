package cn.key.gwc;

public class GwcItem {
	private int bookId;//���
    private String bookName;//����
    private int num;//����</td>
    private float price;//ԭ��</td>
    private float ygcPrice;//�ƹ�����</td>

    public GwcItem() {
		super();
	}

	public GwcItem(int bookId, String bookName, float price,
			float ygcPrice) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.price = price;
		this.ygcPrice = ygcPrice;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bookId;
		result = prime * result
				+ ((bookName == null) ? 0 : bookName.hashCode());
		result = prime * result + num;
		result = prime * result + Float.floatToIntBits(price);
		result = prime * result + Float.floatToIntBits(ygcPrice);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if ((obj == null) || (getClass() != obj.getClass()))
			return false;
		GwcItem other = (GwcItem) obj;
		if (bookId != other.bookId)
			return false;
		if (bookName == null) {
			if (other.bookName != null)
				return false;
		} else if (!bookName.equals(other.bookName))
			return false;
		if ((num != other.num) || (Float.floatToIntBits(price) != Float.floatToIntBits(other.price)) || (Float.floatToIntBits(ygcPrice) != Float
				.floatToIntBits(other.ygcPrice)))
			return false;
		return true;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public float getYgcPrice() {
		return ygcPrice;
	}

	public void setYgcPrice(float ygcPrice) {
		this.ygcPrice = ygcPrice;
	}

}
