package org.jmsu.zhiyuan.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

/**
 * Tiny C Compiler 编译运行类
 * 
 * @author 支援
 *
 */
public class TCCUtil {
	public File createtmpfile(String sourcecode) throws IOException {
		File tempfile = File.createTempFile("tmp", ".c");
		FileWriter filewriter = new FileWriter(tempfile);
		filewriter.write(sourcecode);
		filewriter.close();
		return tempfile;
	}

	public String tccrun(String sourcefile, String inputdata) throws IOException {
		Runtime runtime = Runtime.getRuntime();
		String result = null;
		String contextpath = Application.getrootpath();
		String wincmd = "cmd /C ";
		String tccexe = contextpath + "/tcc/tcc.exe -run ";
		Process process = runtime.exec(wincmd + tccexe + sourcefile);

		OutputStream outputstream = process.getOutputStream();
		BufferedWriter bufferedwriter = new BufferedWriter(new OutputStreamWriter(outputstream));
		bufferedwriter.write(inputdata + "\r\n");
		bufferedwriter.flush();
		bufferedwriter.close();

		String templine;
		StringBuffer successstring = new StringBuffer();
		InputStream successstream = process.getInputStream();
		BufferedReader successreader = new BufferedReader(new InputStreamReader(successstream));
		while ((templine = successreader.readLine()) != null) {
			successstring.append(templine).append(System.getProperty("line.separator"));
		}
		result = "运行结果\r\n" + successstring.toString();

		StringBuffer errorstring = new StringBuffer();
		InputStream errorstream = process.getErrorStream();
		BufferedReader errorreader = new BufferedReader(new InputStreamReader(errorstream));
		while ((templine = errorreader.readLine()) != null) {
			errorstring.append(templine).append(System.getProperty("line.separator"));
		}
		String error = errorstring.toString();
		if (!error.equals("")) {
			if (error.contains(sourcefile)) {
				error = error.replace(sourcefile, "tcc");
			}
			result = "编译结果\r\n" + error;
		}

		process.destroy();
		return result;
	}
}
