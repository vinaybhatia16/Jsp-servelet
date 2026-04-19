package com.rays.jdbc;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestWatch {

	public static void main(String[] args) throws Exception {
		// testAdd();
		// testUpdate();
		// testDelete();
		// testFindByPk();
		testSearch();
	}

	public static void testAdd() throws SQLException {

		WatchBean bean = new WatchBean();
		WatchModel model = new WatchModel();

		bean.setId(7);
		bean.setDeviceName("samsung");
		bean.setHeartRate(440);
		bean.setStepsCount(5500);
		bean.setCaloriesBurned(440.00);
		model.Add(bean);

	}

	public static void testUpdate() throws Exception {
		WatchBean bean = new WatchBean();
		WatchModel model = new WatchModel();

		bean.setDeviceName("oneplus");
		bean.setHeartRate(220);
		bean.setStepsCount(9900);
		bean.setCaloriesBurned(600.00);
		bean.setId(1);
		model.update(bean);

	}

	public static void testDelete() throws Exception {

		WatchBean bean = new WatchBean();
		WatchModel model = new WatchModel();
		bean.setId(6);

		model.Delete(bean);
	}

	public static void testFindByPk() throws Exception {

		WatchBean bean = new WatchBean();
		WatchModel model = new WatchModel();

		bean = model.FindByPk(5);

		if (bean != null) {
			System.out.println(bean.getId());
			System.out.println(bean.getDeviceName());
			System.out.println(bean.getHeartRate());
			System.out.println(bean.getStepsCount());
			System.out.println(bean.getCaloriesBurned());

		} else {

			System.out.println("no record found");
		}

	}

	public static void testSearch() throws Exception {
		WatchBean bean = new WatchBean();
		WatchModel model = new WatchModel();

		bean.setId(2);
		bean.setDeviceName("jbjghg");

		List<WatchBean> list = model.Search(bean);

		if (list.size() == 0) {
			System.out.println("record not found");
			Iterator<WatchBean> it = list.iterator();

			while (it.hasNext()) {
				bean = it.next();
				System.out.println(bean.getId());
				System.out.println(bean.getDeviceName());
				System.out.println(bean.getHeartRate());
				System.out.println(bean.getStepsCount());
				System.out.println(bean.getCaloriesBurned());

				System.out.println("-------------");

			}

		}
	}
}
