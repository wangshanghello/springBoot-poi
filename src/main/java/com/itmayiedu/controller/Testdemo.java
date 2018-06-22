package com.itmayiedu.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Testdemo {
	public static void main(String[] args) throws Exception {
		List<HashMap<String, Object>> listMap = new ArrayList<HashMap<String, Object>>();
		HashMap<String, Object> dataMap = new HashMap<String, Object>();

		for (int i = 0; i < 2; i++) {
			dataMap.put("datetime", "2017-12-13 10:43:00");
			dataMap.put("person", "张翠山");
			dataMap.put("type", "文本");
			dataMap.put("content", "工作一定要认真，态度要端正，作风要优良，行事要效率，力争打造一个完美的产品出来。");
			listMap.add(dataMap);
		}

		String title = "张翠山的发言记录";
		String[] rowsName = new String[] { "序号", "时间", "发言人", "类型", "消息" };
		List<Object[]> dataList = new ArrayList<Object[]>();
		Object[] objs = null;
		for (int i = 0; i < listMap.size(); i++) {
			HashMap<String, Object> data = listMap.get(i);
			objs = new Object[rowsName.length];
			objs[0] = i;
			objs[1] = data.get("datetime");
			objs[2] = data.get("person");
			objs[3] = data.get("type");
			objs[4] = data.get("content");
			dataList.add(objs);
		}
		ExportExcel ex = new ExportExcel(title, rowsName, dataList);
		ex.export();
	}
}