package Excel;

public enum SheetAHeader {
    /** Header **/
    totalRank(0, "순번/순위"),
    bookTitle(1, "상품명"),
    releasedDate(2, "출간일");

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
