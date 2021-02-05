package Data;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
public class Test {
    private String bookTitle;
    private int totalRank;
    private String releasedDate;
    // 추가
    private String country;
    private int isbn;
    private String author;
    private String publisher;
    private int originalPrice;
    private String deliveryState;
    private String deliveryInfo;            // 배송 예정일 등 배송정보
    private int salePrice;
    private int savingPrice;       // 적립금
    private int discountPer;        // 할인률
    private int savingPer;          // 적립률
}
