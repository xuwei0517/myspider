package com.xuwei.core;

import groovy.lang.Binding;
import groovy.lang.GroovyShell;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;

public class TestScript {

	public static void main(String[] args)throws Exception {
		String path = "E:\\workspace\\myspider\\src\\test\\resources\\a.txt";
		Binding binding = new Binding();
		//保存返回值
		Map<Object, Object> fields = new HashMap<Object, Object>();
		binding.setProperty("fields", fields);
		//保存新的url
		ArrayList<String> urls = new ArrayList<String>();
		binding.setProperty("urls", urls);
		GroovyShell shell = new GroovyShell(binding);
		//运行脚本
		String im = "import org.jsoup.*;\r";
		String sc = FileUtils.readFileToString(new File(path));
		shell.evaluate(im+sc);
		//获取结果
		System.out.println(fields);
		System.out.println(urls);
	}
}
