/**
 * 
 */
package com.wuba.device;

/**
 * @author hui.qian qianhui@58.com
 * @date 2015年8月17日 下午5:35:11
 */
public class Test {

	public void testContain(int x, int y) {
		int X = 370;
		int Y = 848;
		int W = 592;
		int H = 1028;

		if (x == X && y == Y) {
			System.out.println("true");
		} else if ((x > X && x < W) && (y > Y && y < H)) {
			System.out.println(X);
			System.out.println(Y);
			System.out.println(W);
			System.out.println(H);
			System.out.println("true 2");

		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Test().testContain(371, 849);

	}

}
