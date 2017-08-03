package com.rt3.rtsystem.interfaces;

import android.app.Dialog;

/**
 * 自定义对话框点击事件监听 
 */
public interface OnDialogClickListener {

	/** 点击确定按钮 */
	public void onConfirm(Dialog dialog);
	
	/** 点击取消按钮 */
	public void onCancel(Dialog dialog);
}

