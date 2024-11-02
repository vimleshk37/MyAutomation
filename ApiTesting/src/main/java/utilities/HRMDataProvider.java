package utilities;

import org.testng.annotations.DataProvider;

public class HRMDataProvider {
	@DataProvider(name ="credentials")
	public Object[][] newDataset() {
		
		Object[][] dataset = null;
			dataset =new Object[][] {
									{"Admin", "admin123"}
									//{"Email12", "Password12"},
									//{"Email13", "Password13"},
									//{"Email14", "Password14"}
			};
	return dataset;
	}
}