/**
 * 
 */
package com.wuba.device;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.android.ddmlib.AdbCommandRejectedException;
import com.android.ddmlib.IDevice;
import com.android.ddmlib.RawImage;
import com.android.ddmlib.TimeoutException;

/**
 * @author hui.qian qianhui@58.com
 * @date 2015年8月17日 上午11:56:33
 */
public class ADBTest {
	private static final Logger LOG = Logger.getLogger("ADBTest");
	private ADB adb;
	private IDevice device;

	@BeforeClass
	public void setUp() {
		adb = new ADB();
		IDevice[] devices = adb.getDevices();
		Assert.assertTrue(devices.length > 0);
		device = devices[0];
	}

	@Test
	public void adbTest() throws TimeoutException, AdbCommandRejectedException,
			IOException {
		
		while (true) {
			RawImage image = device.getScreenshot();
			LOG.info("连接成功");
		}
	}

}
