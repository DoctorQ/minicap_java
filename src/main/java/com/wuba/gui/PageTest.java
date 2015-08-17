/**
 * 
 */
package com.wuba.gui;

import java.awt.Graphics;
import java.awt.Image;
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

public class PageTest extends JFrame {
	private static final Logger LOG = Logger.getLogger("PageTest.class");

	private MyPanel mp = null;
	private IDevice device;
	private int width = 300;
	private int height = 500;

	public PageTest() {
		ADB adb = new ADB();
		device = adb.getDevices()[0];
		mp = new MyPanel(device);
		this.getContentPane().add(mp);
		this.setSize(300, height);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new PageTest();
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
				PageTest.this.setSize(width, height);
				g.drawImage(image, 0, 0, width, height, null);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		public void frameImageChange(BufferedImage image) {
			// TODO Auto-generated method stub
			this.image = image;
			// 设置精确到小数点后2位
			int radio = image.getWidth() / width;
			height = image.getHeight() / radio;
			this.repaint();
		}
	}
}
