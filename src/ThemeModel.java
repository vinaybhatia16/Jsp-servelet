import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.rays.jdbc.util.JdbcDataSource;

public class ThemeModel {

	public void Add(ThemeBean bean) throws SQLException {
		Connection conn = JdbcDataSource.getConnection();
		conn.setAutoCommit(false);
		try {
			PreparedStatement pstmt = conn.prepareStatement("insert into theme values (?,?,?,?,?)");
			pstmt.setInt(1, bean.getThemeId());
			pstmt.setString(2, bean.getThemeCode());
			pstmt.setString(3, bean.getThemeName());
			pstmt.setString(4, bean.getColor());
			pstmt.setString(5, bean.getStatus());
			int i = pstmt.executeUpdate();
			System.out.println(i + "row affected (record inserted....)");
			conn.commit();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void Update(ThemeBean bean) throws SQLException {
		Connection conn = JdbcDataSource.getConnection();
		conn.setAutoCommit(false);
		try {
			PreparedStatement pstmt = conn
					.prepareStatement("update theme set themeCode =? ,themeName =?,color =?,status =? where themeid = ?");
			pstmt.setString(1, bean.getThemeCode());
			pstmt.setString(2, bean.getThemeName());
			pstmt.setString(3, bean.getColor());
			pstmt.setString(4, bean.getStatus());
			pstmt.setInt(5, bean.getThemeId());

			int i = pstmt.executeUpdate();
			System.out.println(i + "row affected(record updated.....)");
			pstmt.close();
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void Delete(ThemeBean bean) throws SQLException {
		Connection conn = JdbcDataSource.getConnection();
		conn.setAutoCommit(false);
		try {
			PreparedStatement pstmt = conn.prepareStatement("delete from theme where themeid =?");
			pstmt.setInt(1, bean.getThemeId());
			int i = pstmt.executeUpdate();
			System.out.println(i + "record deleted");
			conn.commit();
			conn.close();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	public ThemeBean FindByPk(int id) throws SQLException {
		ThemeBean bean = null;
		Connection conn = JdbcDataSource.getConnection();
		conn.setAutoCommit(false);
		try {
			PreparedStatement pstmt = conn.prepareStatement("select * from theme where id = ? ");
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				bean = new ThemeBean();
				bean.setThemeId(rs.getInt(1));
				bean.setThemeCode(rs.getString(2));
				bean.setThemeName(rs.getString(3));
				bean.setColor(rs.getString(4));
				bean.setStatus(rs.getString(5));

			}
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			conn.close();
		}
		return bean;
	}
	public List<ThemeBean> Search(ThemeBean bean) throws Exception {
		List<ThemeBean> list = new ArrayList<ThemeBean>();
		StringBuffer sql = new StringBuffer("select * from theme where 1=1");
		Connection conn = JdbcDataSource.getConnection();
		
		if (bean!= null) {
			if(bean.getThemeId() != 0 && bean.getThemeId()>0) {
				sql.append(" and themeid like '" + "" + bean.getThemeId() + "%'");
			}
			if(bean.getThemeName() != null && bean.getThemeName().length()>0) {
				sql.append(" and themeName like'" + "" + bean.getThemeName() + "%'");
			}
		}
		System.out.println("sql==> " + sql.toString());
		PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		ResultSet rs = pstmt.executeQuery();
		System.out.println("excute uery");

		while(rs.next()) {

			bean = new ThemeBean();
			bean.setThemeId(rs.getInt(1));
			bean.setThemeCode(rs.getString(2));
			bean.setThemeName(rs.getString(3));
			bean.setColor(rs.getString(4));
			bean.setStatus(rs.getString(5));
			list.add(bean);
			
			
		}
		return list; 
	}
}
