package com.rays.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.rays.jdbc.util.JdbcDataSource;

public class BranchManagerModel {

	public int nextPk() throws SQLException {

		int pk = 0;

		Connection conn = JdbcDataSource.getConnection();

		PreparedStatement pstmt = conn.prepareStatement("select max(id) from branchmanager");

		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			pk = rs.getInt(1);
		}

		return pk + 1;
	}

	public void Add(BranchManagerBean bean) throws SQLException {
		Connection conn = JdbcDataSource.getConnection();
		conn.setAutoCommit(false);
		try {
			PreparedStatement pstmt = conn.prepareStatement("insert into branchmanager values(?,?,?,?)");
			pstmt.setInt(1, bean.getManagerid());
			pstmt.setString(2, bean.getManagername());
			pstmt.setString(3, bean.getBranchname());
			pstmt.setString(4, bean.getContactnumber());
			int i = pstmt.executeUpdate();
			System.out.println(i + "row affected (record insert....)");
			pstmt.close();
			conn.commit();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void Update(BranchManagerBean bean) throws SQLException {
		Connection conn = JdbcDataSource.getConnection();
		conn.setAutoCommit(false);

		try {
			PreparedStatement pstmt = conn.prepareStatement(
					"update branchmanager set managername= ?,branchname= ?,contactnumber= ? where managerid =?");
			pstmt.setString(1, bean.getManagername());
			pstmt.setString(2, bean.getBranchname());
			pstmt.setString(3, bean.getContactnumber());
			pstmt.setInt(4, bean.getManagerid());

			int i = pstmt.executeUpdate();
			pstmt.close();
System.out.println(i + "row affected");
			conn.commit();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	public void Delete(BranchManagerBean bean) throws SQLException {
		Connection conn = JdbcDataSource.getConnection();
		conn.setAutoCommit(false);

		try {
			PreparedStatement pstmt = conn.prepareStatement("delete from branchmanager where managerid =?");
			pstmt.setInt(1, bean.getManagerid());
			int i = pstmt.executeUpdate();
			System.out.println(i + "record deleted");
			pstmt.close();
			conn.commit();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public BranchManagerBean FindByPk(int id) throws SQLException {
		Connection conn = JdbcDataSource.getConnection();
		BranchManagerBean bean = null;
		conn.setAutoCommit(false);
		try {
			PreparedStatement pstmt = conn.prepareStatement("select * from branchmanager where managerid =?");
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				bean = new BranchManagerBean();
				bean.setManagerid(rs.getInt(1));
				bean.setManagername(rs.getString(2));
				bean.setBranchname(rs.getString(3));
				bean.setContactnumber(rs.getString(4));
			}
			pstmt.close();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}

		return bean;
	}

	public List<BranchManagerBean> Search(BranchManagerBean bean) throws SQLException {
		List<BranchManagerBean> list = new ArrayList<BranchManagerBean>();
		Connection conn = JdbcDataSource.getConnection();
		StringBuffer sql = new StringBuffer("select * from branchmanager  where 1 = 1");
		if (bean != null) {
			if (bean.getManagerid() != 0 && bean.getManagerid() > 0) {
				sql.append(" and managerid like '" + "" + bean.getManagerid() + "%'");

			}
			if (bean.getManagername() != null && bean.getManagername().length() > 0) {
				sql.append(" and managername like '" + bean.getManagername() + "%'");
			}

		}
		System.out.println("sql ==> " + sql.toString());
		PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			bean = new BranchManagerBean();
			bean.setManagerid(rs.getInt(1));
			bean.setManagername(rs.getString(2));
			bean.setBranchname(rs.getString(3));
			bean.setContactnumber(rs.getString(4));

			list.add(bean);

		}
		return list;
	}
}
