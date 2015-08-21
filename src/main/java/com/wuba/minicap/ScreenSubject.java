/**
 * 
 */
package com.wuba.minicap;

import java.awt.Image;


/**
 * @author hui.qian qianhui@58.com
 * @date 2015年8月12日 上午11:11:35
 */
public interface ScreenSubject {
	public void registerObserver(AndroidScreenObserver o);

	public void removeObserver(AndroidScreenObserver o);

	public void notifyObservers(Image image);

}
