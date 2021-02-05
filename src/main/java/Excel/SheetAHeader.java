package Excel;

public enum SheetAHeader {
    /** Header **/
    totalRank(0, "순번/순위"),
    bookTitle(1, "상품명"),
    releasedDate(2, "출간일"),
    country(3, "국가"),
    isbn(4, "isbn"),
    author(5, "저자"),
    publisher(6, "출판사"),
    originalPrice(7, "정가"),
    deliveryState(8, "유통상태"),
    deliveryInfo(9, "배송예정일"),
    salePrice(10, "판매가"),
    savingPrice(11, "적립금"),
    discountPer(12, "할인률"),
    savingPer(13, "적립률");

    /** Setting */
    private final int columnIndex;
    private final String columnName;

    SheetAHeader(int index, String name) {
        this.columnIndex = index;
        this.columnName = name;
    }
    public int columnIndex() {
        return this.columnIndex;
    }
    public String columnName(){
        return this.columnName;
    }
    public SheetAHeader[] getHeader() {
        return SheetAHeader.values();
    }
}
