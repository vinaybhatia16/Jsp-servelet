package com.rays.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.rays.jdbc.util.JdbcDataSource;

public class DashboardModel {
	public void Add(DashboardBean bean) throws SQLException {
		Connection conn = JdbcDataSource.getConnection();
		conn.setAutoCommit(false);

		try {
			PreparedStatement pstmt = conn.prepareStatement(" insert into dashboard vales(?,?,?,?,?)");
			pstmt.setInt(1, bean.getDashboardid());
			pstmt.setString(2, bean.getDashboardcode());
			pstmt.setString(3, bean.getDashboardname());
			pstmt.setString(4, bean.getUsername());
			pstmt.setString(5, bean.getStatus());
			int i = pstmt.executeUpdate();
			System.out.println(i + "row affected (record inserted....)");
			pstmt.close();
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void Update(DashboardBean bean) throws SQLException {
		Connection conn = JdbcDataSource.getConnection();
		conn.setAutoCommit(false);
		try {
			PreparedStatement pstmt = conn.prepareStatement(
					"update dashboard set dashboardcode =? ,dashboardname =? ,username =?,status =? where dashboardid =?");

			pstmt.setString(1, bean.getDashboardcode());
			pstmt.setString(2, bean.getDashboardname());
			pstmt.setString(3, bean.getUsername());
			pstmt.setString(4, bean.getStatus());
			pstmt.setInt(5, bean.getDashboardid());
			
			int i = pstmt.executeUpdate();

			System.out.println(i + "row affected(record updated.....)");
			pstmt.close();
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void Delete(DashboardBean bean) throws SQLException {
		Connection conn = JdbcDataSource.getConnection();
		conn.setAutoCommit(false);
		try {
			PreparedStatement pstmt = conn.prepareStatement("delete from dashboard where dashboardid =?");
			pstmt.setInt(1, bean.getDashboardid());
			pstmt.close();
			conn.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public DashboardBean FindByPk(int id) throws SQLException {
		DashboardBean bean = null;
		Connection conn = JdbcDataSource.getConnection();
		conn.setAutoCommit(false);
		try {
			PreparedStatement pstmt = conn.prepareStatement("select * from where dashboardid = 1");
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				bean = new DashboardBean();
				bean.setDashboardid(rs.getInt(1));
				bean.setDashboardcode(rs.getString(2));
				bean.setDashboardname(rs.getString(3));
				bean.setUsername(rs.getString(4));
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

	public List<DashboardBean> Search(DashboardBean bean) throws SQLException {
		List<DashboardBean> list = new ArrayList<DashboardBean>();
		Connection conn = JdbcDataSource.getConnection();
		StringBuffer sql = new StringBuffer("select * from dashboard where 1 = 1");
		if (bean != null) {
			if (bean.getDashboardid() != 0 && bean.getDashboardid() > 0) {
				sql.append(" and dashboardid like '" + "" + bean.getDashboardid() + "%'");

			}
			if (bean.getDashboardcode() != null && bean.getDashboardcode().length() > 0) {
				sql.append(" and dashboardcode like '" + "" + bean.getDashboardcode() + "%'");

			}
		}
		System.out.println("sql ==> " + sql.toString());
		PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			bean = new DashboardBean();
			bean.setDashboardid(rs.getInt(1));
			bean.setDashboardcode(rs.getString(2));
			bean.setDashboardname(rs.getString(3));
			bean.setUsername(rs.getString(4));
			bean.setStatus(rs.getString(5));
			list.add(bean);

		}
		return list;
	}
}