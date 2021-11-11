package Service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Model.Booking;
import Model.Hoadon;


public class Downloadfileexcel {
	private List<Booking> lstapp;
	private List<Hoadon> lsthd;
	public Downloadfileexcel() {
		this.lstapp=new ArrayList<Booking>();
		this.lsthd = new ArrayList<Hoadon>();
}
	public void xuatbooking(List<Booking> lst,
			HttpServletResponse response) throws Exception {
		this.lstapp=lst;
		String fileName = "thongkebooking.xlsx";
		response.setContentType("application/octet-stream");
		response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
		ServletOutputStream pos = response.getOutputStream();
		XSSFWorkbook xssfw = new XSSFWorkbook();
		XSSFRow row, row1, row2, row3, row6;
		XSSFCell cellB, cellC, cellD, cellE, cellF, cellG, cellH,cellK;
		XSSFSheet sheet = xssfw.createSheet("Appointment");
			XSSFCellStyle style = xssfw.createCellStyle();
			style.setBorderTop(BorderStyle.MEDIUM);
			style.setBorderBottom(BorderStyle.MEDIUM);
			style.setBorderLeft(BorderStyle.MEDIUM);
			style.setBorderRight(BorderStyle.MEDIUM);
			sheet.setColumnWidth(2, 6000);
			sheet.setColumnWidth(3, 3000);
			sheet.setColumnWidth(0, 1000);
			sheet.setColumnWidth(5, 7000);
			sheet.setColumnWidth(6, 5000);
			sheet.setColumnWidth(7, 20000);
			row1 = sheet.createRow((short) 0);
			row2 = sheet.createRow((short) 1);
			row3 = sheet.createRow((short) lstapp.size()+8);
			row6 = sheet.createRow((short) 6);
			cellK = row6.createCell((short) 0);
			cellK.setCellStyle(style);
			cellK.setCellValue("STT");
			cellB = row6.createCell((short) 1);
			cellB.setCellStyle(style);
			cellB.setCellValue("ngày đặt bàn");
			cellC = row6.createCell((short) 2);
			cellC.setCellStyle(style);
			cellC.setCellValue("thời gian");
			cellD = row6.createCell((short) 3);
			cellD.setCellStyle(style);
			cellD.setCellValue("loại bàn");
			cellE = row6.createCell((short) 4);
			cellE.setCellStyle(style);
			cellE.setCellValue("số lượng bàn");
			cellF = row6.createCell((short) 5);
			cellF.setCellStyle(style);
			cellF.setCellValue("tên người đặt");
			cellG = row6.createCell((short) 6);
			cellG.setCellStyle(style);
			cellG.setCellValue("số điện thoại");
			cellH = row6.createCell((short) 7);
			cellH.setCellStyle(style);
			cellH.setCellValue("địa chỉ nhà hàng");
			cellB = row1.createCell((short) 3);
			cellB.setCellValue("Thống kê bàn đã đặt");
			cellB = row2.createCell((short) 3);
			cellB.setCellValue("thời gian: từ 12/10/2021"+"-"+java.time.LocalDate.now());
					for (int i = 1; i <= this.lstapp.size(); i++) {
						row = sheet.createRow((short) i + 6);
						cellK = row.createCell((short) 0);
						cellK.setCellStyle(style);
						cellK.setCellValue(i);
						cellB = row.createCell((short) 1);
						cellB.setCellStyle(style);
						cellB.setCellValue(this.lstapp.get(i - 1).getNgaydatban());
						cellC = row.createCell((short) 2);
						cellC.setCellStyle(style);
						cellC.setCellValue(this.lstapp.get(i - 1).getThoigiandatban().getTime());
						cellD = row.createCell((short) 3);
						cellD.setCellStyle(style);
						cellD.setCellValue(this.lstapp.get(i - 1).getLoaiban());
						cellE = row.createCell((short) 4);
						cellE.setCellStyle(style);
						cellE.setCellValue(this.lstapp.get(i-1).getSoluong());
						cellF = row.createCell((short) 5);
						cellF.setCellStyle(style);
						cellF.setCellValue(this.lstapp.get(i-1).getUser().getFullname().replaceAll("\\s+", ""));
						cellG = row.createCell((short) 6);
						cellG.setCellStyle(style);
						cellG.setCellValue(this.lstapp.get(i-1).getUser().getSdt().replaceAll("\\s+", ""));
						cellH = row.createCell((short) 7);
						cellH.setCellStyle(style);
						cellH.setCellValue(this.lstapp.get(i-1).getStore().getAddressStore().replaceAll("\\s+", ""));
					}
					cellK = row3.createCell((short) 6);
					cellK.setCellStyle(style);
					cellK.setCellValue("Tổng: ");
					cellB = row3.createCell((short) 7);
					cellB.setCellStyle(style);
					cellB.setCellValue(this.lstapp.size());
		xssfw.write(pos);
		xssfw.close();
		pos.close();
	}
	
	public void xuathoadon(List<Hoadon> lst,
			HttpServletResponse response) throws Exception {
		this.lsthd=lst;
		double sumgia=0;
		String fileName = "thongkehoadon.xlsx";
		response.setContentType("application/octet-stream");
		response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
		ServletOutputStream pos = response.getOutputStream();
		XSSFWorkbook xssfw = new XSSFWorkbook();
		XSSFRow row, row1, row2, row3, row6;
		XSSFCell cellB, cellC, cellD, cellE, cellF, cellG, cellH,cellK,cellL,Cellj,cellm,celln,cellz;
		XSSFSheet sheet = xssfw.createSheet("Hoa-Don");
			XSSFCellStyle style = xssfw.createCellStyle();
			style.setBorderTop(BorderStyle.MEDIUM);
			style.setBorderBottom(BorderStyle.MEDIUM);
			style.setBorderLeft(BorderStyle.MEDIUM);
			style.setBorderRight(BorderStyle.MEDIUM);
			sheet.setColumnWidth(2, 6000);
			sheet.setColumnWidth(3, 3000);
			sheet.setColumnWidth(0, 1000);
			sheet.setColumnWidth(1, 3000);
			sheet.setColumnWidth(5, 10000);
			sheet.setColumnWidth(6, 4000);
			sheet.setColumnWidth(7, 2000);
			sheet.setColumnWidth(4, 10000);
			row1 = sheet.createRow((short) 0);
			row2 = sheet.createRow((short) 1);
			row3 = sheet.createRow((short) lst.size()+8);
			row6 = sheet.createRow((short) 6);
			cellK = row6.createCell((short) 0);
			cellK.setCellStyle(style);
			cellK.setCellValue("STT");
			cellB = row6.createCell((short) 1);
			cellB.setCellStyle(style);
			cellB.setCellValue("Thời gian đặt hàng");
			cellC = row6.createCell((short) 2);
			cellC.setCellStyle(style);
			cellC.setCellValue("Tên người đặt");
			cellD = row6.createCell((short) 3);
			cellD.setCellStyle(style);
			cellD.setCellValue("số điện thoại");
			cellE = row6.createCell((short) 4);
			cellE.setCellStyle(style);
			cellE.setCellValue("địa chỉ nhận hàng");
			cellF = row6.createCell((short) 5);
			cellF.setCellStyle(style);
			cellF.setCellValue("tên món ăn");
			cellG = row6.createCell((short) 6);
			cellG.setCellStyle(style);
			cellG.setCellValue("số lượng");
			cellH = row6.createCell((short) 7);
			cellH.setCellStyle(style);
			cellH.setCellValue("giá");
			cellL = row1.createCell((short) 3);
			cellL.setCellValue("Thống kê hóa đơn");
			Cellj = row2.createCell((short) 3);
			Cellj.setCellValue("thời gian: từ 12/10/2021"+" đến "+java.time.LocalDate.now());
					for (int i = 1; i <= this.lsthd.size(); i++) {
						row = sheet.createRow((short) i + 6);
						cellK = row.createCell((short) 0);
						cellK.setCellStyle(style);
						cellK.setCellValue(i);
						cellB = row.createCell((short) 1);
						cellB.setCellStyle(style);
						cellB.setCellValue(this.lsthd.get(i - 1).getThoigian().getTime());
						cellC = row.createCell((short) 2);
						cellC.setCellStyle(style);
						cellC.setCellValue(this.lsthd.get(i - 1).getUser().getFullname());
						cellD = row.createCell((short) 3);
						cellD.setCellStyle(style);
						cellD.setCellValue(this.lsthd.get(i - 1).getUser().getSdt());
						cellE = row.createCell((short) 4);
						cellE.setCellStyle(style);
						cellE.setCellValue(this.lsthd.get(i-1).getUser().getDiachi());
						cellF = row.createCell((short) 5);
						cellF.setCellStyle(style);
						cellF.setCellValue(this.lsthd.get(i-1).getFood().getNamefood().replaceAll("\\s+", ""));
						cellG = row.createCell((short) 6);
						cellG.setCellStyle(style);
						cellG.setCellValue(1);
						cellH = row.createCell((short) 7);
						cellH.setCellStyle(style);
						cellH.setCellValue(this.lsthd.get(i-1).getFood().getGia());
						sumgia+=this.lsthd.get(i-1).getFood().getGia();
					}
					cellz = row3.createCell((short) 5);
					cellz.setCellStyle(style);
					cellz.setCellValue("Tổng: ");
					
					  cellB = row3.createCell((short) 6); cellB.setCellStyle(style);
					  cellB.setCellValue(this.lsthd.size()); cellm = row3.createCell((short) 7);
					  cellm.setCellStyle(style); cellm.setCellValue(sumgia); celln =
					  row3.createCell((short) 8); celln.setCellStyle(style);
					  celln.setCellValue(this.lsthd.size());
					 
		xssfw.write(pos);
		xssfw.close();
		pos.close();
	}
}
