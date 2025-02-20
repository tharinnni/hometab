package week6.marathon;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class SalesForceDataProvider {

	public static String[][] readData(String fileName) throws IOException {
		XSSFWorkbook workBook = new XSSFWorkbook("data/"+fileName+".xlsx");
		XSSFSheet sheetAt = workBook.getSheetAt(0);
		int lastRowNum = sheetAt.getLastRowNum();
		short lastCellNum = sheetAt.getRow(0).getLastCellNum();	
		String[][] data = new String[lastRowNum][lastCellNum];

		for (int i = 1; i <= lastRowNum; i++) {
			XSSFRow row = sheetAt.getRow(i);
			for (int j = 0; j < lastCellNum; j++) {
				XSSFCell cell = row.getCell(j);
				data[i-1][j] = cell.getStringCellValue();

			}
		}
		workBook.close();
		return data;
	}

}
