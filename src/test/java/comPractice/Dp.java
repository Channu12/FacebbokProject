package comPractice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.trent.genericutility.ExcelUtility;

public class Dp {

	@Test(dataProvider = "dataProviderTicket")
	public void Sample(String src)
	{

		System.out.println(src+"=====city Name=====");
	}

	@DataProvider Object[][] dataProviderTicket() throws EncryptedDocumentException, IOException
	{
		
		ExcelUtility eLib = new ExcelUtility();
		Object[][] obj = new Object[2][1];
		obj[0][0] = eLib.getExcelData(null, 0, 0);
		
		obj[1][0] = "Krtrtk";
				return obj;
	}
}
