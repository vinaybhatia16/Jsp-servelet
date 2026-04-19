package com.rays.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InvoiceModel {
	public void Add(InvoiceBean bean) throws SQLException {

		Connection conn = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "vinu1997");
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement("insert into invoice values(?,?,?,?,?)");
			pstmt.setInt(1, bean.getInvoiceId());
			pstmt.setString(2, bean.getInvoiceCode());
			pstmt.setString(3, bean.getName());
			pstmt.setInt(4, bean.getTotalAmount());
			pstmt.setString(5, bean.getStatus());

			int i = pstmt.executeUpdate();

			System.out.println(i + " row affected(records inserted...)");

			conn.commit();

			conn.close();
			pstmt.close();

		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		}

	}

	public void Update(InvoiceBean bean) throws SQLException {

		Connection conn = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "vinu1997");
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement(
					"update invoice set invoice_code = ?,name= ?,total_amount= ?,status=? where invoice_id = ?");
			pstmt.setInt(1, bean.getInvoiceId());
			pstmt.setString(1, bean.getInvoiceCode());
			pstmt.setString(2, bean.getName());
			pstmt.setInt(3, bean.getTotalAmount());
			pstmt.setString(4, bean.getStatus());
			pstmt.setInt(5, bean.getInvoiceId());
			int i =pstmt.executeUpdate();

			System.out.println(i + " row updated(records updated...)");

			conn.commit();

			conn.close();
			pstmt.close();

		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		}

	}

	public void Delete(InvoiceBean bean) throws SQLException {

		Connection conn = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "vinu1997");
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement("delete from invoice where invoice_id =? ");

			pstmt.setInt(1, bean.getInvoiceId());

			int i = pstmt.executeUpdate();

			System.out.println(i + " record deleted");

			conn.commit();

			conn.close();
			pstmt.close();

		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		}
	}

	public InvoiceBean FindByPk(int invoice_id) throws SQLException {

		Connection conn = null;
		InvoiceBean bean = null;
		{}
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "vinu1997");
			PreparedStatement pstmt = conn.prepareStatement("select * from invoice where invoice_id = ? ");

			pstmt.setInt(1, invoice_id);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				bean = new InvoiceBean();
				bean.setInvoiceId(rs.getInt(1));
				bean.setInvoiceCode(rs.getString(2));
				bean.setName(rs.getString(3));
				bean.setTotalAmount(rs.getInt(4));
				bean.setStatus(rs.getString(5));

			}

			pstmt.close();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return bean;

	}

	public List<InvoiceBean> Search(InvoiceBean bean) throws Exception {
		List<InvoiceBean> list = new ArrayList<InvoiceBean>();
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays", "root", "vinu1997");
		StringBuffer sql = new StringBuffer("select * from Invoice where 1 = 1");

		if (bean != null) {

			if (bean.getInvoiceId() != 0 && bean.getInvoiceId() > 0) {
				sql.append(" and invoice_id = " + bean.getInvoiceId());
			}

			if (bean.getInvoiceCode() != null && bean.getInvoiceCode().length() > 0) {
				sql.append(" and Invoice_code like '" + "= " + bean.getInvoiceCode() + "%'");
			}
			if (bean.getName() != null && bean.getName().length() > 0) {
				sql.append(" and name like '" + "= " + bean.getName() + "%'");
			}
			if (bean.getTotalAmount() != 0 && bean.getTotalAmount() > 0) {
				sql.append(" and total_amount = " + bean.getTotalAmount());
			}
			if (bean.getStatus() != null && bean.getStatus().length() > 0) {
				sql.append(" and status like '" + "= " + bean.getStatus() + "%'");

			}
		}
		System.out.println("sql ==> " + sql.toString());
		PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			bean = new InvoiceBean();
			bean.setInvoiceId(rs.getInt(1));
			bean.setInvoiceCode(rs.getString(2));
			bean.setName(rs.getString(3));
			bean.setTotalAmount(rs.getInt(4));
			bean.setStatus(rs.getString(5));

			list.add(bean);

		}

		return list;
	}

}
