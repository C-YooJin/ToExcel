import Excel.ExcelUtils;
import Data.Test;
import Folder.FolderUtils;
import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

import static java.lang.Math.random;

/**
 * Created by R&D팀/최유진 on 2021.02
 * PC : MacBook Pro (13-inch, 2017)
 * OS Version : macOS Big Sur - 11.0.1
 * */

public class main {

    public static void main(String[] args) {
        System.out.println("Create Project");

        // Create Folder
        FolderUtils.createFolder();


        //Delete Folder
//        FolderUtils.deleteFolder();

        //Delete Files
//        FolderUtils.deleteFiles();

        //CreateData
        ArrayList<Test> testList = createList();
        for (Test test : testList) {
            System.out.println(test);
        }

        //CreateExcel
        ExcelUtils.ExcelSave("SAMPLE", testList);
    }

    /* Create Data */
    public static ArrayList<Test> createList() {
        ArrayList<Test> tests = new ArrayList<>();
        for (int i=1; i<22; i++) {
            Random random = new Random();
            Faker faker = new Faker();

            Test test = new Test();
            test.setBookTitle(faker.book().title());
            test.setReleasedDate("2021-02-05");
            test.setTotalRank(i);
            test.setCountry("KR");
            test.setIsbn(random.nextInt(62849213) + 1929849132);
            test.setAuthor(faker.book().author());
            test.setPublisher(faker.book().publisher());
            test.setOriginalPrice(faker.number().randomDigitNotZero());
            test.setDeliveryState("판매중");
            test.setDeliveryInfo(faker.address().city());
            test.setSalePrice(10);
            test.setSavingPrice(1400);
            test.setDiscountPer(20);
            test.setSavingPer(20);
            tests.add(test);
        }
        System.out.println("create.");
        return tests;

    }

}
