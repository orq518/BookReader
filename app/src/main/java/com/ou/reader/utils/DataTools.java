package com.ou.reader.utils;

import android.content.Context;

import com.ou.reader.bean.base.Base;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class DataTools {

	public static final String WALLET_FILENAME = "READ_APP_MODEL";
	/**
	 * 写文件
	 * 
	 * @throws IOException
	 */
	public static void writeData(Context context, Base baseBean, String name) throws IOException {
		// Log.e("ouou", "开始写数据:" + name);
		if (name==null) {
			name="";
		}
		String pathString=context.getPackageName()+WALLET_FILENAME+name;
		try {
			context.deleteFile(pathString);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		FileOutputStream fos = context.openFileOutput(pathString,
				Context.MODE_PRIVATE);
		ByteArrayOutputStream baos = new ByteArrayOutputStream(); // 构造一个字节输出流
		ObjectOutputStream oos = new ObjectOutputStream(baos); // 构造一个类输出流

		try {
			oos.writeObject(baseBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		byte[] buf = baos.toByteArray(); // 从这个地层字节流中把传输的数组给一个新的数组
		oos.flush();
		fos.write(buf);
		fos.close();
		oos.close();
		baos.close();
	}

	/**
	 * 读文件
	 * 
	 */
	@SuppressWarnings("unchecked")
	public static Base readData(Context context, String name) {
		if (name==null) {
			name="";
		}
		String pathString=context.getPackageName()+WALLET_FILENAME+name;
		Base walletGateModel = null;
		FileInputStream fos = null;
		try {
			fos = context.openFileInput(pathString);
		} catch (FileNotFoundException e1) {
			return null;
		}

		try {
			if (fos.available() < 0) {
				fos.close();
				return null;
			}

			byte[] buf = new byte[fos.available()];
			fos.read(buf);

			// 构建一个类输入流，地层用字节输入流实现
			ByteArrayInputStream bais = new ByteArrayInputStream(buf);
			ObjectInputStream ois = new ObjectInputStream(bais);
			walletGateModel = (Base) ois.readObject();
			fos.close();
			bais.close();
			ois.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return walletGateModel;
	}
	/**
	 * 删除文件
	 */
	public static void clearAllData(Context context,String name) {
		String pathString=context.getPackageName()+WALLET_FILENAME+name;
		context.deleteFile(pathString);
	}
}
