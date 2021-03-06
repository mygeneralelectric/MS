package com.tys.ms.view;


import com.tys.ms.model.ProductIns;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/10/26.
 */
public class ProductXlsxView extends AbstractXlsxView {
    @Override
    protected void buildExcelDocument(Map<String, Object> map, Workbook workbook, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        // change the file name
        httpServletResponse.setHeader("Content-Disposition", "attachment; filename=\"Product.xlsx\"");

        @SuppressWarnings("unchecked")
        List<ProductIns> productInsList = (List<ProductIns>) map.get("productInsList");

        // create excel xls sheet
        Sheet sheet = workbook.createSheet("Product");

        // create header row
        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("序号");
        header.createCell(1).setCellValue("承保公司地市");
        header.createCell(2).setCellValue("产险销售人员姓名");
        header.createCell(3).setCellValue("报价公司");
        header.createCell(4).setCellValue("险种");
        header.createCell(5).setCellValue("投保类型");
        header.createCell(6).setCellValue("车主");
        header.createCell(7).setCellValue("车牌号码");
        header.createCell(8).setCellValue("报价时间");
        header.createCell(9).setCellValue("车辆类型");
        header.createCell(10).setCellValue("商业险");
        header.createCell(11).setCellValue("交强险");
        header.createCell(12).setCellValue("车船税");
        header.createCell(13).setCellValue("保费合计");

        // Create data cells
        int rowCount = 1;
        for (ProductIns productIns : productInsList){
            Row productInsRow = sheet.createRow(rowCount++);
            productInsRow.createCell(0).setCellValue(rowCount-1);
            productInsRow.createCell(1).setCellValue(productIns.getCompany());
            productInsRow.createCell(2).setCellValue(productIns.getEmployee());
            productInsRow.createCell(3).setCellValue(productIns.getInsCompany());
            productInsRow.createCell(4).setCellValue(productIns.getProductType());
            productInsRow.createCell(5).setCellValue(productIns.getInsIllustration());
            productInsRow.createCell(6).setCellValue(productIns.getInsPerson());
            productInsRow.createCell(7).setCellValue(productIns.getCarNumber());
            productInsRow.createCell(8).setCellValue(productIns.getInsTime());
            productInsRow.createCell(9).setCellValue(productIns.getCarType());
            productInsRow.createCell(10).setCellValue(productIns.getCarBusinessMoney());
            productInsRow.createCell(11).setCellValue(productIns.getCarMandatoryMoney());
            productInsRow.createCell(12).setCellValue(productIns.getCarTaxMoney());
            productInsRow.createCell(13).setCellValue(productIns.getInsMoney());
        }
    }
}
