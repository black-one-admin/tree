package com.black.one.excel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import java.io.FileOutputStream;

/**
 * 使用SXSSF
 *
 * @author swh
 * @create: 2020-05-22 21:01
 */
public class SXSSF {

    public static void main(String[] args) throws Exception{

        String path = "E:\\study\\";
        //创建工作簿HSS为03 XSS为07
        //注意事项03只有65535行，07没有限制   SXSSF使用07版本可以加速
        Workbook workbook = new SXSSFWorkbook();
        //创建工作表
        Sheet sheet = workbook.createSheet();
        //创建一个行，默认0开始(1,1)
        for(int rowNum = 0; rowNum<100000; rowNum++){
            Row row = sheet.createRow(rowNum);
            for (int cellNum = 0 ;cellNum<10;cellNum++){
                Cell cell = row.createCell(cellNum);
                cell.setCellValue(rowNum+cellNum);
            }
        }

        //生成一张表（io流）03版 使用xls结尾
        FileOutputStream fileOutputStream = new FileOutputStream(path + "sxss大数据.xlsx");
        workbook.write(fileOutputStream);
        fileOutputStream.close();
        //清理临时文件
        ((SXSSFWorkbook)workbook).dispose();
        System.out.println("创建excel");
    }
}
