package com.black.one.excel;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileOutputStream;

/**
 * @author swh
 * @create: 2020-05-22 20:24
 */
public class ExcelWriteTest {
    private String path = "E:/github/back-github/tree/excel";

    public  void testWrite() throws Exception {
        //创建工作簿HSS为03 XSSF为07  SXSSF使用07版本可以加速
        Workbook workbook = new HSSFWorkbook();
        //创建工作表
        Sheet sheet = workbook.createSheet();
        //创建一个行，默认0开始(1,1)
        Row row = sheet.createRow(0);
        //创建一个单元格
        Cell cell = row.createCell(0);
        cell.setCellValue("进入新增");
        //(1,2)
        Cell cell1 = row.createCell(1);
        cell1.setCellValue("xin");
        //生成一张表（io流）03版 使用xls结尾
        FileOutputStream fileOutputStream = new FileOutputStream(path + "测试.xls");
        workbook.write(fileOutputStream);
        fileOutputStream.close();
        System.out.println("创建excel");
    }

    public static void main(String[] args) {
        try {
            new ExcelWriteTest().testWrite();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
