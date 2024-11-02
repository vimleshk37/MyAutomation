package javaUtilities;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;


public class TestNGDataProvider {
	@DataProvider(name="create")
	public Object[][] newDataset(Method m) {
		
		Object[][] dataset = null;
		
		if(m.getName().equals("newloginTest"))
			dataset =new Object[][] {
									{"Email1", "Password1", "otp1"},
									{"Email2", "Password2", "otp2"},
									{"Email3", "Password3", "otp3"},
									{"Email4", "Password4", "otp4"}
			};
	if(m.getName().equals("loginTest"))
		dataset =new Object[][] {
								{"Email1", "Password1", "Vimlesh"},
								{"Email2", "Password2", "Vimlesh"},
								{"Email3", "Password3", "Vimlesh"},
								{"Email4", "Password4", "Vimlesh"}
			};
	return dataset;
	}
}