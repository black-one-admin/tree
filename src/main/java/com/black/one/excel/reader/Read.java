package com.black.one.excel.reader;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileInputStream;

/**
 * 读取excel文件
 *
 * @author swh
 * @create: 2020-05-22 21:07
 */
public class Read {

    public static void main(String[] args) throws Exception{
        String path = "E:\\study\\sxss大数据.xlsx";

        FileInputStream fileInputStream = new FileInputStream(path);
        //注意版本问题03或07
        Workbook workbook = new HSSFWorkbook(fileInputStream);
        Sheet sheet = workbook.getSheetAt(0);
        Row row = sheet.getRow(0);
        Cell cell = row.getCell(0);
        //读取有多少行数据
        int physicalNumberOfCells = row.getPhysicalNumberOfCells();
        //注意获取的值类型
        String stringCellValue = cell.getStringCellValue();
        //获取表中的内容
        int rowCount = sheet.getPhysicalNumberOfRows();
        for (int rowNum = 1 ; rowNum<rowCount; rowNum++){
            Row rowData = sheet.getRow(rowNum);
            if (rowData!=null){
                int cellCount = rowData.getPhysicalNumberOfCells();
                for (int cellNum = 0;cellNum<cellCount;cellNum++){
                    Cell cell1 = rowData.getCell(cellNum);
                    if (cell1!=null){
                        //判断数据类型
                        int cellType = cell1.getCellType();
                        switch (cellType){
                            case HSSFCell.CELL_TYPE_BLANK :
                                break;
                        }
                    }
                }
            }
        }



        fileInputStream.close();

    }
}
