package com.rays.jdbc;

import java.util.Iterator;
import java.util.List;

public class TestInvoice {
	public static void main(String[] args)throws Exception {
		//testAdd();
		//testUpdate();
		//testDelete();
		//testFindByPk();	
		testSearch();
	}
	public static void testAdd() throws Exception {

		InvoiceBean bean = new InvoiceBean();
		InvoiceModel model = new InvoiceModel();

		bean.setInvoiceId(5);
		bean.setInvoiceCode("1005");
		bean.setName("hamza ali");
		bean.setTotalAmount(100000);
		bean.setStatus("paid");

		model.Add(bean);
	}


	public static void testUpdate() throws Exception {
		
		InvoiceBean bean = new InvoiceBean();
		InvoiceModel model = new InvoiceModel();


		
		bean.setInvoiceCode("1003");
		bean.setName("jamal");
		bean.setTotalAmount(99000);
		bean.setStatus("paid");
		bean.setInvoiceId(3);

		model.Update(bean);

	}
	public static void testDelete() throws Exception {
		InvoiceBean bean = new InvoiceBean();
		InvoiceModel model = new InvoiceModel();

		
		bean.setInvoiceId(1);;
		model.Delete(bean);

	}
	public static void testFindByPk() throws Exception {
		InvoiceBean bean = new InvoiceBean();
		InvoiceModel model = new InvoiceModel();
		
		bean = model.FindByPk(5);
		if (bean != null) {
			System.out.println(bean.getInvoiceId());
			System.out.println(bean.getInvoiceCode());
			System.out.println(bean.getName());
			System.out.println(bean.getTotalAmount());
			System.out.println(bean.getStatus());
		} else {

			System.out.println("user not found");
		}
	}
	private static void testSearch() throws Exception {
		InvoiceBean bean = new InvoiceBean();
		InvoiceModel model = new InvoiceModel();

		

	 	
	 	//bean.setInvoiceId(2);
	  bean.setName("vinay");


		List<InvoiceBean> list = model.Search(bean);

		Iterator<InvoiceBean> it = list.iterator();

		while (it.hasNext()) {
			bean = it.next();

			System.out.println(bean.getInvoiceId());
			System.out.println(bean.getInvoiceCode());
			System.out.println(bean.getName());
			System.out.println(bean.getTotalAmount());
			
			System.out.println("------");

		}
	}
	}


