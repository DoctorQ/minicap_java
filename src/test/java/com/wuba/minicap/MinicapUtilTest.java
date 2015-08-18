/**
 * 
 */
package com.wuba.minicap;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.android.ddmlib.IDevice;
import com.wuba.device.ADB;

/**
 * @author hui.qian qianhui@58.com
 * @date 2015年8月17日 下午3:15:07
 */
public class MinicapUtilTest {
	private MiniCapUtil minicap = null;

	@BeforeClass
	public void setUp() {
		ADB adb = new ADB();
		IDevice[] devices = adb.getDevices();
		Assert.assertTrue(devices.length > 0);
		minicap = new MiniCapUtil(devices[0]);

	}

	@Test
	public void takeScreenShotOnceTest() {
		while (true) {
			minicap.takeScreenShotOnce();
		}
	}

}
