package com.example.jwtspringboot.excel;

import com.example.jwtspringboot.entity.bill;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class BillExcelExporter {
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;

    private List<bill> listBill;

    public BillExcelExporter(List<bill> listBill){
        this.listBill = listBill;
        workbook = new XSSFWorkbook();
    }

    private void createCell(Row row, int columnCount, Object value, CellStyle style){
        sheet.autoSizeColumn(columnCount);
        Cell cell = row.createCell(columnCount);
        if(value instanceof Long){
            cell.setCellValue((Long)value);
        } else if(value instanceof Integer){
            cell.setCellValue((Integer)value);
        } else if(value instanceof Boolean){
            cell.setCellValue((Boolean)value);
        } else if(value instanceof String){
            cell.setCellValue((String)value);
        } else if(value instanceof Float){
            cell.setCellValue((Float)value);
        } else if(value instanceof Date){
            cell.setCellValue((Date)value);
        }
        cell.setCellStyle(style);
    }
    private void writeHeaderLine(){
        sheet = workbook.createSheet("Bill");
        Row row = sheet.createRow(0);
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);//in đậm
        font.setFontHeight(20);//size
        style.setFont(font);
        style.setAlignment(HorizontalAlignment.CENTER);//ra giữa
        createCell(row,0,"Bill Information",style);
        sheet.addMergedRegion(new CellRangeAddress(0,0,0,5));//vị trí của dòng student information là 1 dòng đầu và 4 cột
        font.setFontHeightInPoints((short) 10);
        row = sheet.createRow(1);
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);
        createCell(row,0,"Bill Id",style);
        createCell(row,1,"Bill Idemp",style);
        createCell(row,2,"Bill Quantity",style);
        createCell(row,3,"Bill Datetime",style);
        createCell(row,4,"Bill Employee",style);
        createCell(row,5,"Bill Product",style);


    }
    private void writeDataLines(){
        int rowCount = 2;
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        style.setFont(font);

        for(bill b:listBill){
            Row row=sheet.createRow(rowCount++);
            int columCount=0;
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            createCell(row,columCount++,b.getIdBill(),style);
            createCell(row,columCount++,b.getIdEmp(),style);
            createCell(row,columCount++,b.getQuantity(),style);
            createCell(row,columCount++,df.format(b.getDateTime()),style);
            createCell(row,columCount++,b.getEmployee().toString(),style);
            createCell(row,columCount++,b.getProduct().toString(),style);
        }
    }
    public void export(HttpServletResponse response) throws IOException {
        writeHeaderLine();
        writeDataLines();

        ServletOutputStream outputStream=response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();

    }

}
