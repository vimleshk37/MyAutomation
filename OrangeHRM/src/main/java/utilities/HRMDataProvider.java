package utilities;

import org.testng.annotations.DataProvider;

public class HRMDataProvider {
	@DataProvider(name ="credentials")
	public Object[][] newDataset() {
		
		Object[][] dataset = null;
			dataset =new Object[][] {
									{"Admin", "admin123"}
									//{"Admin", "admin123"},
									//{"Admin", "admin123"},
									//{"Admin", "admin123"}
			};
	return dataset;
	}
}