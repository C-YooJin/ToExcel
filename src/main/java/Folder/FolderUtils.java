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
                System.out.println("Make path: "+path+" SUCCESS. ");
            }catch (Exception e){
                e.getStackTrace();
                System.out.println("Make path:" +path+"FAIL. ");
            }
        } else {
            System.out.println("The path:"+ path+"ALREADY EXISTED. ");
        }
    }

    /* Folder Delete */
    public static void deleteFolder() {
        String root = new File("").getPath();
        String path = root+"Excels"; //폴더 경로
        File Folder = new File(path);

        while(Folder.exists()) {
            File[] folder_list = Folder.listFiles(); //파일리스트 얻어오기

            for (int j = 0; j < folder_list.length; j++) {
                folder_list[j].delete(); //파일 삭제
                System.out.println("파일이 삭제되었습니다.");
            }

            if(folder_list.length == 0 && Folder.isDirectory()){
                Folder.delete(); //대상폴더 삭제
                System.out.println("폴더가 삭제되었습니다.");
            }
        }
    }

    /* Files Delete in Folder */
    public static void deleteFiles() {
        String root = new File("").getPath();
        String path = root+"Excels"; //폴더 경로
        File Folder = new File(path);

        while(Folder.exists()) {
            File[] folder_list = Folder.listFiles(); //파일리스트 얻어오기

            for (int j = 0; j < folder_list.length; j++) {
                folder_list[j].delete(); //파일 삭제
                System.out.println("파일이 삭제되었습니다.");
            }

            break;
        }
    }

}
