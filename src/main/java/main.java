import Excel.ExcelUtils;
import Data.Test;
import Folder.FolderUtils;

import java.time.LocalDate;
import java.util.ArrayList;

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
        for (int i=1; i<11; i++) {
            Test test = new Test();
            test.setBookTitle("Onepiece "+i+"권");
            test.setReleasedDate("2021-02-25");
            test.setTotalRank(i);
            tests.add(test);
        }
        System.out.println("create.");
        return tests;

    }

}
