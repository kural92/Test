package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excelutlis {

	public static String filename=System.getProperty("user.dir")+"/Inputs/testdatasheet.xlsx";
	
	

		 // String SheetName =  FileAndEnv.envAndFile().get("testerName");
		  public static  String userid() throws Exception {
				String userid = readdatafromExcelusingcolumnName("userid");
			return userid;
			}
			public static  void updateuseridIn_Excel(String userid) throws IOException {
				 wirtefromExcel(1, 0, userid);
				 }
			public static  void updateauthtokenIn_Excel(String customer_id) throws IOException {
				 wirtefromExcel(1, 1, customer_id);
				 }
			public static  String authtoken() throws Exception {
				String authtoken = readdatafromExcelusingcolumnName("authtoken");
			return authtoken;
			}
			
			public static  String ExistingUserWishlistorder() throws Exception {
				String authtoken = readdatafromExcelusingcolumnName("Existing user Wishlistorder");
			return authtoken;
			}
			public static  String Withstorecredit() throws Exception {
				String authtoken = readdatafromExcelusingcolumnName("With store credit");
			return authtoken;
			}
			
			public static  String Withoutstorecredit() throws Exception{
				String authtoken = readdatafromExcelusingcolumnName("Without store credit");
			return authtoken;
			}
			public static  String NewUserWishlistorder()throws Exception {
				String authtoken = readdatafromExcelusingcolumnName("new user Wishlistorder");
			return authtoken;
			}
			public static  String newaddress()throws Exception {
				String authtoken = readdatafromExcelusingcolumnName("new address");
			return authtoken;
			}
			public static  String getaddress()throws Exception {
				String authtoken = readdatafromExcelusingcolumnName("getaddress");
			return authtoken;
			}
			public static  String updateCustomer() throws Exception {
				String authtoken = readdatafromExcelusingcolumnName("update customer");
			return authtoken;
			}
			public static  String addMulipleItems() throws Exception {
				String authtoken = readdatafromExcelusingcolumnName("add muliple items");
			return authtoken;
			}
			public static  String getOrderId() throws Exception {
				String authtoken = readdatafromExcelusingcolumnName("get order id");
			return authtoken;
			}
			public static  String switchAlternateProducts() throws Exception{
				String authtoken = readdatafromExcelusingcolumnName("switch alternate products");
			return authtoken;
			}
			public static String readdatafromExcelusingcolumnName(String ColumnName)
					   throws EncryptedDocumentException, InvalidFormatException, IOException {
					  String SheetName =  FileAndEnv.envAndFile().get("testerName");
					  File file = new File(filename);
					  FileInputStream fi = new FileInputStream(file);
					  Workbook wb = WorkbookFactory.create(fi);
					  Sheet sheet = wb.getSheet(SheetName);
					 
					  Row row = sheet.getRow(0);

					  short lastcolumnused = row.getLastCellNum();

					  int colnum = 0;
					  for (int i = 0; i < lastcolumnused; i++) {
					   if (row.getCell(i).getStringCellValue().equalsIgnoreCase(ColumnName)) {
					    colnum = i;
					    break;
					   }
					  }

					  // it will take value from Second row
					  row = sheet.getRow(1);
					  Cell column = row.getCell(colnum);
					  String CellValue = column.getStringCellValue();

					  return CellValue;

					 }
			/*public static List<HashMap<String, String>> readValueFromExcel() {
				List<HashMap<String, String>> mapDatasList = new ArrayList();
				try {
					File excelLocaltion = new File(filename);

					String sheetName = "Sheet1";

					FileInputStream f = new FileInputStream(
							excelLocaltion);
					Workbook w = new XSSFWorkbook(f);
					Sheet sheet = w.getSheet(sheetName);
					Row headerRow = sheet.getRow(0);
					for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
						Row currentRow = sheet.getRow(i);
						HashMap<String, String> mapDatas = new HashMap<String, String>();
						for (int j = 0; j < headerRow.getPhysicalNumberOfCells(); j++) {
							Cell currentCell = currentRow.getCell(j);
							
							switch (currentCell.getCellType()) {
							case Cell.CELL_TYPE_STRING:
								mapDatas.put(headerRow.getCell(j).getStringCellValue(),
										currentCell.getStringCellValue());
								break;
							case Cell.CELL_TYPE_NUMERIC:
								mapDatas.put(headerRow.getCell(j).getStringCellValue(),
										String.valueOf(currentCell
												.getNumericCellValue()));

								break;

							}
						}

						mapDatasList.add(mapDatas);
					}

				} catch (Throwable e) {
					//e.printStackTrace();
				}
				return mapDatasList;

			}
			*/
			
			public static void wirtefromExcel(int rownum,int cellnum, String msg) throws IOException {
				File excelLocaltion = new File(filename);
					String sheetName =FileAndEnv.envAndFile().get("testerName");
					FileInputStream f = new FileInputStream(
							excelLocaltion);
					 Workbook workbook = new XSSFWorkbook(f);
					    Sheet sheet = workbook.getSheet(sheetName);
					  			    CellStyle style = workbook.createCellStyle();
					  			    Cell cell = null;
					    Row sheetrow = sheet.getRow(rownum);
			            if(sheetrow == null){
			                sheetrow = sheet.createRow(rownum);
			            }
			          	            cell = sheetrow.getCell(cellnum);
			            if(cell == null){
			                cell = sheetrow.createCell(cellnum);
			            }
			            cell.setCellValue(msg);
			            cell.setCellStyle(style);
			       	            f.close();
					    FileOutputStream fos =new FileOutputStream(filename);
					    workbook.write(fos);
					    fos.close();
					    System.out.println("Done");
		           
		   }
			/*public static void main(String[] args)throws NullPointerException  {
				String string = readValueFromExcel().get(1).get("authtoken");
				System.out.println(string);
			}*/
		}
