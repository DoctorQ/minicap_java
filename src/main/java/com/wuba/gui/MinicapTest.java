/**
 * 
 */
package com.wuba.gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.apache.log4j.Logger;

import com.android.ddmlib.IDevice;
import com.wuba.device.ADB;
import com.wuba.minicap.AndroidScreenObserver;
import com.wuba.minicap.MiniCapUtil;

/**
 * @author hui.qian qianhui@58.com
 * @date 2015年8月14日 下午7:40:17
 */

public class MinicapTest extends JFrame {
	private static final Logger LOG = Logger.getLogger("PageTest.class");

	private MyPanel mp = null;
	private IDevice device;
	private int width = 300;
	private int height = 500;

	public MinicapTest() {
		ADB adb = new ADB();
		if (adb.getDevices().length <= 0) {
			LOG.error("无连接设备,请检查");
			return;
		}
		device = adb.getDevices()[0];
		mp = new MyPanel(device);
		this.getContentPane().add(mp);
		this.setSize(300, height);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((dim.width - this.getWidth()) / 2, 0);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new MinicapTest();
	}

	class MyPanel extends JPanel implements AndroidScreenObserver {

		Image image = null;
		MiniCapUtil minicap = null;

		public MyPanel(IDevice device) {
			minicap = new MiniCapUtil(device);
			minicap.registerObserver(this);
			minicap.startScreenListener();

		}

		public void paint(Graphics g) {
			try {
				if (image == null)
					return;
				MinicapTest.this.setSize(width, height);
				g.drawImage(image, 0, 0, width, height, null);
				image.flush();
				image = null;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		public void frameImageChange(BufferedImage image) {
			this.image = image;
			float radio = (float) (width) / (float) (image.getWidth());
			height = (int) (Math.round(radio * image.getHeight()));
			this.repaint();
		}
	}
}
