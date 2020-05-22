package com.black.one.excel;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileOutputStream;

/**
 * 大数据写入excel
 *
 * @author swh
 * @create: 2020-05-22 20:46
 */
public class BigData {

    public static void main(String[] args) throws Exception {

        String path = "E:\\study\\";
        //创建工作簿HSS为03 XSS为07
        //注意事项03只有65535行，07没有限制   SXSSF使用07版本可以加速
        Workbook workbook = new HSSFWorkbook();
        //创建工作表
        Sheet sheet = workbook.createSheet();
        //创建一个行，默认0开始(1,1)
        for(int rowNum = 0; rowNum<65535; rowNum++){
            Row row = sheet.createRow(rowNum);
            for (int cellNum = 0 ;cellNum<10;cellNum++){
                Cell cell = row.createCell(cellNum);
                cell.setCellValue(rowNum+cellNum);
            }
        }

        //生成一张表（io流）03版 使用xls结尾
        FileOutputStream fileOutputStream = new FileOutputStream(path + "大数据.xls");
        workbook.write(fileOutputStream);
        fileOutputStream.close();
        System.out.println("创建excel");
    }
}
