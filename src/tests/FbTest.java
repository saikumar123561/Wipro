package tests;

import pages.Fbpage;

public class FbTest {

	Fbpage fb = new Fbpage();
	
	public void test() {
		fb.enterEmail();
		fb.enterPassword();
		fb.clickLogin();
		
	}
}
