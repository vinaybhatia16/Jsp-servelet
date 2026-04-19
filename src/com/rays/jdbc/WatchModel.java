package com.rays.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.rays.jdbc.util.JdbcDataSource;

public class WatchModel {
	public void Add(WatchBean bean) throws SQLException {

		Connection conn = JdbcDataSource.getConnection();
		conn.setAutoCommit(false);

		try {
			PreparedStatement pstmt = conn.prepareStatement("insert into watch values (?,?,?,?,?)");
			pstmt.setInt(1, bean.getId());
			pstmt.setString(2, bean.getDeviceName());
			pstmt.setInt(3, bean.getHeartRate());
			pstmt.setInt(4, bean.getStepsCount());
			pstmt.setDouble(5, bean.getCaloriesBurned());

			int i = pstmt.executeUpdate();
			System.out.println(i + "row affected (record inserted....)");
			conn.commit();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	public void update(WatchBean bean) throws SQLException {

		Connection conn = JdbcDataSource.getConnection();
		conn.setAutoCommit(false);

		try {
			PreparedStatement pstmt = conn.prepareStatement(
					"update watch set devicename = ?,heartrate = ?,stepscount = ?,caloriesburned = ? where id =?");
			pstmt.setString(1, bean.getDeviceName());
			pstmt.setInt(2, bean.getHeartRate());
			pstmt.setInt(3, bean.getStepsCount());
			pstmt.setDouble(4, bean.getCaloriesBurned());
			pstmt.setInt(5, bean.getId());

			int i = pstmt.executeUpdate();
			System.out.println(i + " row updated (record updated ....)");
			conn.commit();
			conn.close();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void Delete(WatchBean bean) throws SQLException {
		Connection conn = JdbcDataSource.getConnection();
		conn.setAutoCommit(false);

		try {
			PreparedStatement pstmt = conn.prepareStatement(" delete from watch where id =? ");

			pstmt.setInt(1, bean.getId());
			int i = pstmt.executeUpdate();
			System.out.println(i + "record deleted");
			conn.commit();
			conn.close();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public WatchBean FindByPk(int id) throws SQLException {
		WatchBean bean = null;
		Connection conn = JdbcDataSource.getConnection();
		try {

			PreparedStatement pstmt = conn.prepareStatement("select * from watch where id = ? ");
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				bean = new WatchBean();
				bean.setId(rs.getInt(1));
				bean.setDeviceName(rs.getString(2));
				bean.setHeartRate(rs.getInt(3));
				bean.setStepsCount(rs.getInt(4));
				bean.setCaloriesBurned(rs.getDouble(5));
			}
			pstmt.close();

		} catch (

		Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return bean;
	}

	public List<WatchBean> Search(WatchBean bean) throws Exception {

		List<WatchBean> list = new ArrayList<WatchBean>();
		Connection conn = JdbcDataSource.getConnection();
		StringBuffer sql = new StringBuffer("select * from watch where 1 = 1");
		
		
		
		if (bean != null) {
			if (bean.getId() != 0 && bean.getId() > 0) {
				sql.append(" and id like '" + "" + bean.getId() + "%'");

			}
			if (bean.getDeviceName() != null && bean.getDeviceName().length() > 0) {
				sql.append(" and devicename like '" + "" + bean.getDeviceName() + "%'");
			}

		}
		
		
		System.out.println("sql ==> " + sql.toString());
		PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {

			bean = new WatchBean();
			bean.setId(rs.getInt(1));
			bean.setDeviceName(rs.getString(2));
			bean.setHeartRate(rs.getInt(3));
			bean.setStepsCount(rs.getInt(4));
			bean.setCaloriesBurned(rs.getDouble(5));
			list.add(bean);

		}
		
		return list;
		
		
	}

}
