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
    private LocalDate releasedDate;
}
