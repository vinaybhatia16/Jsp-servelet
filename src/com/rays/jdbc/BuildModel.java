package com.rays.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.rays.jdbc.util.JdbcDataSource;

public class BuildModel {

	public int nextpk() throws SQLException {

		int pk = 0;
		Connection conn = JdbcDataSource.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("select max(id from build ");
		
		
		ResultSet rs = pstmt.executeQuery();
	while (rs.next()) {
		
		pk = rs.getInt(1);
	}
	return pk +1;
	
	
	
	}
	public void Add(BuildBean bean) throws SQLException{
		Connection conn = JdbcDataSource.getConnection();
		conn.setAutoCommit(false);
		try {
			PreparedStatement pstmt = conn.prepareStatement("insert into build values(?,?,?,?)");
			pstmt.setLong(1, bean.getBuildId());
			pstmt.setString(2, bean.getBuildCode());
			pstmt.setString(3, bean.getBuildVersion());
			pstmt.setString(4, bean.getTriggeredBy());
		
			int i = pstmt.executeUpdate();
			System.out.println(i + "row affected (record insert....)");
			pstmt.close();
			conn.commit();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public void Update(BuildBean bean) throws SQLException {
		Connection conn = JdbcDataSource.getConnection();
		conn.setAutoCommit(false);

		try {
			PreparedStatement pstmt = conn.prepareStatement(
					"update build set buildcode= ?,buildversion= ?,triggeredby= ? where buildId= ?");
			pstmt.setString(1, bean.getBuildCode());
			pstmt.setString(2, bean.getBuildVersion());
			pstmt.setString(3, bean.getTriggeredBy());
			pstmt.setLong(4, bean.getBuildId());

			int i = pstmt.executeUpdate();
			pstmt.close();
System.out.println(i + "row affected");
			conn.commit();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();

		}

}
	public void Delete(BuildBean bean) throws SQLException {
		Connection conn = JdbcDataSource.getConnection();
		conn.setAutoCommit(false);

		try {
			PreparedStatement pstmt = conn.prepareStatement("delete from build where buildId =?");
			pstmt.setLong(1, bean.getBuildId());
			int i = pstmt.executeUpdate();
			System.out.println(i + "record deleted");
			pstmt.close();
			conn.commit();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public BuildBean FindByPk(int id) throws SQLException {
		Connection conn = JdbcDataSource.getConnection();
		BuildBean bean = null;
		conn.setAutoCommit(false);
		try {
			PreparedStatement pstmt = conn.prepareStatement("select * from build where buildId =?");
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				bean = new BuildBean();
				bean.setBuildId(rs.getLong(1));
				bean.setBuildCode(rs.getString(2));
				bean.setBuildVersion(rs.getString(3));
				bean.setTriggeredBy(rs.getString(4));
			}
			pstmt.close();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}

		return bean;
	}
	
	public List<BuildBean> Search(BuildBean bean) throws SQLException{
		List<BuildBean> list = new ArrayList<BuildBean>();
		Connection conn = JdbcDataSource.getConnection();
		StringBuffer sql = new StringBuffer("select * from build  where 1 = 1");
		if (bean != null) {
			if (bean.getBuildId()!= 0 && bean.getBuildId()>0) {
				sql.append(" and buildid like '" + "" + bean.getBuildId() +"%'");
				
			}
			if (bean.getBuildCode() != null && bean.getBuildCode().length()>0) {
				sql.append(" and buildcode like '" + "" + bean.getBuildCode() +"%'" );
			}
		}System.out.println("sql ==>" + sql.toString());
		PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		 ResultSet rs = pstmt.executeQuery();
		 while (rs.next()) {
			 bean = new BuildBean();
			 bean.setBuildId(rs.getLong(1));
			 bean.setBuildCode(rs.getString(2));
			 bean.setBuildVersion(rs.getString(3));
			 bean.setTriggeredBy(rs.getString(4));
			  
			 list.add(bean);
			 
			 
		 }
		
		return list;
	}
}


