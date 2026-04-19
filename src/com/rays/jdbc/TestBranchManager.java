package com.rays.jdbc;

import java.util.Iterator;
import java.util.List;

public class TestBranchManager {

	public static void main(String[] args) throws Exception {
		// testAdd();
		// testUpdate();
		// testDelete();
		// testFindByPk();
		testSearch();
	}

	public static void testAdd() throws Exception {

		BranchManagerBean bean = new BranchManagerBean();
		BranchManagerModel model = new BranchManagerModel();

		bean.setManagerid(6);
		bean.setManagername("suresh");
		bean.setBranchname("indore ");
		bean.setContactnumber("9926278640");

		model.Add(bean);

	}

	public static void testUpdate() throws Exception {

		BranchManagerBean bean = new BranchManagerBean();
		BranchManagerModel model = new BranchManagerModel();

		bean.setManagerid(6);
		bean.setManagername("virat");
		bean.setBranchname("indrre");
		bean.setContactnumber("445we");

		model.Update(bean);

	}

	public static void testDelete() throws Exception {
		BranchManagerBean bean = new BranchManagerBean();
		BranchManagerModel model = new BranchManagerModel();
		bean.setManagerid(6);

		model.Delete(bean);

	}

	public static void testFindByPk() throws Exception {
		BranchManagerBean bean = new BranchManagerBean();
		BranchManagerModel model = new BranchManagerModel();
		bean = model.FindByPk(5);

		if (bean != null) {
			System.out.println(bean.getManagerid());
			System.out.println(bean.getManagername());
			System.out.println(bean.getBranchname());
			System.out.println(bean.getContactnumber());

		} else {
			System.out.println("user not found");
		}

	}

	public static void testSearch() throws Exception {
		BranchManagerBean bean = new BranchManagerBean();
		BranchManagerModel model = new BranchManagerModel();

		bean.setManagerid(1);
		//bean.setManagername("Rajesh Kumar");
		List<BranchManagerBean> list = model.Search(bean);
		Iterator<BranchManagerBean> it = list.iterator();

		while (it.hasNext()) {
			bean = it.next();
			System.out.println(bean.getManagerid());
			System.out.println(bean.getManagername());
			System.out.println(bean.getBranchname());
			System.out.println(bean.getContactnumber());
		}
	}
}