package Folder;

import java.io.File;

public class FolderUtils {

    /* Folder Create */
    public static void createFolder() {
        String root = new File("").getPath();
        String path = root+"Excels";
        File Folder = new File(path);

        if (!Folder.exists()) {
            try {
                Folder.mkdir(); // Created Folder
                System.out.println(path+"SUCCESS. ");
            }catch (Exception e){
                e.getStackTrace();
                System.out.println(path+"FAIL. ");
            }
        } else {
            System.out.println(path+"ALREADY EXISTED. ");
        }
    }

    /* Folder Delete */
    public static void deleteFolder()

}
