package com.rt3.rtsystem.view;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.rt3.rtsystem.R;
import com.rt3.rtsystem.interfaces.OnDialogClickListener;

/**
 * 确认对话框
 */
public class ConfirmDialog extends Dialog implements View.OnClickListener {

	private String title;
	private String content;
	private TextView tv_title;
	private TextView tv_content;
	private Button btn_confirm;
	private Button btn_cancel;
	
	private OnDialogClickListener onDialogClickListener;
	
	public ConfirmDialog(Context context, String title, String content,
						 OnDialogClickListener onDialogClickListener) {
		
		super(context);
		this.title = title;
		this.content = content;
		this.onDialogClickListener = onDialogClickListener;
		init();
	}

	private void init() {
		Window window = getWindow();
		// 去掉对话框标题栏
		window.requestFeature(Window.FEATURE_NO_TITLE);
		
		// 设置背景为透明色
		window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
		
		setContentView(R.layout.dialog_confirm);
		
		tv_title = (TextView) findViewById(R.id.tv_title);
		tv_content = (TextView) findViewById(R.id.tv_content);
		
		tv_title.setText(title);
		tv_content.setText(content);
		
		btn_confirm = (Button) findViewById(R.id.btn_confirm);
		btn_cancel = (Button) findViewById(R.id.btn_cancel);
		
		btn_confirm.setOnClickListener(this);
		btn_cancel.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_confirm:	// 确定
			if (onDialogClickListener != null) {
				onDialogClickListener.onConfirm(this);
			}
			
			break;
		case R.id.btn_cancel:	// 取消
			if (onDialogClickListener != null) {
				onDialogClickListener.onCancel(this);
			}
			break;
		}
	}
}
















