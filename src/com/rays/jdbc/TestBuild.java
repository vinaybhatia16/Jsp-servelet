package com.rays.jdbc;

import java.util.Iterator;
import java.util.List;

public class TestBuild {
	public static void main(String[] args) throws Exception {
		//testAdd();
		 //testUpdate();
		//testDelete();
		 //testFindByPk();
		testSearch();
	}
	public static void testAdd() throws Exception {

		BuildBean bean = new BuildBean();
		BuildModel model = new BuildModel();

		bean.setBuildId(6);
		bean.setBuildCode("bld -001");
		bean.setBuildVersion("old");
		bean.setTriggeredBy("tomact");

	
		model.Add(bean);
	}
	
	public static void testUpdate() throws Exception {
		BuildBean bean = new BuildBean();
		BuildModel model = new BuildModel();
		
		
		bean.setBuildId(6);
		bean.setBuildCode("virat");
		bean.setBuildVersion("indrre");
		bean.setTriggeredBy("445we");

		model.Update(bean);

	}
	public static void testDelete() throws Exception {
		BuildBean bean = new BuildBean();
		BuildModel model = new BuildModel();
		
		bean.setBuildId(6);
		model.Delete(bean);
	
}
	public static void testFindByPk() throws Exception {
		BuildBean bean = new BuildBean();
		BuildModel model = new BuildModel();
		
		bean = model.FindByPk(5);

		if (bean != null) {
			System.out.println(bean.getBuildId());
			System.out.println(bean.getBuildCode());
			System.out.println(bean.getBuildVersion());
			System.out.println(bean.getTriggeredBy());

		} else {
			System.out.println("user not found");
		}

	}
	public static void testSearch() throws Exception {
		
		BuildBean bean = new BuildBean();
		BuildModel model = new BuildModel();
		
		//bean.setBuildId(1);
		bean.setBuildCode("BLD-2024-001");
		List<BuildBean> list = model.Search(bean);
		Iterator<BuildBean> it = list.iterator();

		while (it.hasNext()) {
			bean = it.next();
			System.out.println(bean.getBuildId());
			System.out.println(bean.getBuildCode());
			System.out.println(bean.getBuildVersion());
			System.out.println(bean.getTriggeredBy());
		}
	}
}