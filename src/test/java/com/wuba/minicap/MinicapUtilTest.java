/**
 * 
 */
package com.wuba.minicap;

import java.io.IOException;

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
	public void setUp() throws InterruptedException {
		ADB adb = new ADB();
		IDevice[] devices = adb.getDevices();
		Assert.assertTrue(devices.length > 0);
		minicap = new MiniCapUtil(devices[0]);

	}

	@Test
	public void takeScreenShotOnceTest() {
		long start = System.currentTimeMillis();
		while (true) {
			minicap.takeScreenShotOnce();
			long current = System.currentTimeMillis();
			System.out.println(current-start);
			start = System.currentTimeMillis();
		}
	}

	@Test
	public void taktest() throws IOException {
		Runtime.getRuntime()
				.exec("adb shell LD_LIBRARY_PATH=/data/local/tmp /data/local/tmp/minicap -P 1440x2560@1440x2560/0 -s > /data/local/tmp/screen.jpg");
	}

}
