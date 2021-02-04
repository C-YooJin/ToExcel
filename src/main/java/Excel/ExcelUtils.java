package Excel;

import Data.Test;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class ExcelUtils {

    public static void ExcelSave(String fileName, ArrayList<Test> datas) {
        // Header
        SheetAHeader[] A_headers = SheetAHeader.values();

        Workbook workbook = null;
        FileOutputStream fos = null;
        try {
            workbook = new SXSSFWorkbook(); // Excel Workbook 생성

            Sheet SheetA = workbook.createSheet("Kyobo");

            // Excel Write Header
            try {
                HeaderASetting(workbook, SheetA, A_headers);
            } catch (Exception e) {
                e.printStackTrace();
            }

            // Excel Write Body
            try {
                BodyASetting(workbook, SheetA, datas);
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                String root = new File("").getPath();
                String path = root + "Excels"; //폴더 경로
                fos = new FileOutputStream(path + "/" + fileName + ".xlsx"); // file 생성
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            try {
                workbook.write(fos); // excel 저장
            } catch (IOException e) {
                e.printStackTrace();
            }
        } finally {
            if (fos != null) {
                try {
                    fos.close(); // file resource 반환
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            // 자바 7버전 이후부터 Autoclose
//            if (workbook != null) {
//                try {
//                    workbook.close(); // excel resource 반환
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
        }
    }

    public static void HeaderASetting(Workbook workbook, Sheet sheet, SheetAHeader[] sheetHeader) {
        /** Style Set **/

        // Style
        CellStyle styleOfHeader = workbook.createCellStyle();

        // Align
        styleOfHeader.setAlignment(CellStyle.ALIGN_CENTER); // 가로 가운데 정렬
        styleOfHeader.setAlignment(CellStyle.VERTICAL_CENTER);  // 세로 가운데 정렬

        // Border
        styleOfHeader.setBorderRight(HSSFCellStyle.BORDER_THIN);
        styleOfHeader.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        styleOfHeader.setBorderTop(HSSFCellStyle.BORDER_THIN);
        styleOfHeader.setBorderBottom(HSSFCellStyle.BORDER_THIN);

        // Background
        styleOfHeader.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
        styleOfHeader.setFillPattern(CellStyle.SOLID_FOREGROUND);

        // Font
        Font HeadFont = workbook.createFont();
        HeadFont.setBoldweight(Font.BOLDWEIGHT_BOLD);   //  폰트 굵게
        styleOfHeader.setFont(HeadFont);

        /** data Header **/
        Row row = sheet.createRow(0);       // Excel Row 생성
        for (int columnNum = 0; columnNum < sheetHeader.length; columnNum++) {
            Cell cell = row.createCell(columnNum);      // cell 생성
            String headerName = sheetHeader[columnNum].columnName();
            cell.setCellStyle(styleOfHeader);
            cell.setCellValue(headerName);

            // Column Width
            sheet.setColumnWidth(columnNum, 20*256);


//            // Width Dynamic Setting
//            switch (headerName.length()) {
//                case 0:
//                    sheet.autoSizeColumn(columnNum);
//                case 1:
//                    sheet.autoSizeColumn(columnNum);
//                case 2:
//                    sheet.autoSizeColumn(columnNum);
//                case 3:
//                case 4:
//                    sheet.setColumnWidth(columnNum,2800);
//                    break;
//                case 5:
//                    sheet.setColumnWidth(columnNum,3200);
//                    break;
//                case 6:
//                    sheet.setColumnWidth(columnNum,4200);
//                    break;
//                case 7:
//                    sheet.setColumnWidth(columnNum,4700);
//                    break;
//                case 8:
//                    sheet.setColumnWidth(columnNum,5500);
//                    break;
//                case 9:
//                    sheet.setColumnWidth(columnNum,6200);
//                    break;
//                default:
//                    sheet.setColumnWidth(columnNum,7000);
//                    break;
//            }
        }
    }

    public static void BodyASetting(Workbook workbook, Sheet sheet, ArrayList<Test> body) {
        /** Style set **/

        // Style
        CellStyle styleOfBody = workbook.createCellStyle();

        // Align
        styleOfBody.setVerticalAlignment(CellStyle.VERTICAL_CENTER);

        // Border
        styleOfBody.setBorderRight(HSSFCellStyle.BORDER_THIN);
        styleOfBody.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        styleOfBody.setBorderTop(HSSFCellStyle.BORDER_THIN);
        styleOfBody.setBorderBottom(HSSFCellStyle.BORDER_THIN);

        for (int rownum = 1; rownum < body.size(); rownum++) {      // data row 개수만큼 반복해서 처리
            Row row = sheet.createRow(rownum);
            Test test = body.get(rownum-1);
            int cellnum = 0;

            Cell cell = row.createCell(cellnum++);

            cell.setCellValue(test.getTotalRank());
            cell = row.createCell(cellnum++);

            cell.setCellValue(test.getBookTitle());
            cell = row.createCell(cellnum++);

            cell.setCellValue(test.getReleasedDate());
            cell = row.createCell(cellnum++);

            for(int i=0; i<cellnum; i++) {
                Cell cell2 = row.getCell(i);
                cell2.setCellValue(String.valueOf(styleOfBody));        // 스타일 적용
            }
        }

    }
}
