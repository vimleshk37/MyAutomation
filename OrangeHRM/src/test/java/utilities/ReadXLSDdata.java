package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ReadXLSDdata {
	
		@DataProvider(name="allusers")
		public static Object[][] ProvideData() throws IOException {
			FileInputStream  fileIn = new FileInputStream (System.getProperty("user.dir") + "\\src\\test\\resources\\testdata\\OrangeUserPass.xlsx");
			String sheename="User";
			@SuppressWarnings("resource")
			Workbook workbook = new XSSFWorkbook(fileIn);
			Sheet sheet = workbook.getSheet(sheename);
		
			int totalrow= sheet.getLastRowNum();
			Row rowCells = sheet.getRow(0);
			int totalcell= rowCells.getLastCellNum();
		
			DataFormatter formate = new DataFormatter();
			String testdata[][] = new String[totalrow][totalcell];
		
			for(int r=1 ; r <= totalrow;r++) {
				for(int c=0 ; c < totalcell;c++) {
					testdata[r-1][c]=formate.formatCellValue(sheet.getRow(r).getCell(c));
					System.out.println(testdata[r-1][c]);
			}
		}
		return testdata;
	}
	
	public String ReadDataFromCell(String sheetname, int rowNO, int colNo) throws IOException {
		FileInputStream  fileIn = new FileInputStream (System.getProperty("user.dir") + "\\src\\test\\resources\\testdata\\OrangeUserPass.xlsx");

			try (Workbook workbook = new XSSFWorkbook(fileIn)){
			Sheet sheet = workbook.getSheet(sheetname);
			Row row = sheet.getRow(rowNO);
			Cell cell = row.getCell(colNo);
			String cellValue = cell.getStringCellValue();
			return cellValue;
				}
	}
	
	public int rowTotal(String SheetName) throws IOException {
		FileInputStream fileIn = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\testdata\\OrangeUserPass.xlsx");
			try (Workbook workbook = new XSSFWorkbook(fileIn)) {
				Sheet sheet = workbook.getSheet(SheetName);	
				int rowTotal = sheet.getLastRowNum();
				if ((rowTotal > 0) || (sheet.getPhysicalNumberOfRows() > 0))
				rowTotal++;
				return(rowTotal);
		}
	}
	
	public int cellTotal(String SheetName) throws IOException {
		FileInputStream fileIn = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\testdata\\OrangeUserPass.xlsx");
			try (Workbook workbook = new XSSFWorkbook(fileIn)) {
				Sheet sheet = workbook.getSheet(SheetName);	
				int cellTotal=sheet.getRow(0).getLastCellNum();
				return(cellTotal);
		}
	}
}
