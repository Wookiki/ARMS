package arms.db;

import java.sql.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class jdbcUtil {
	
	
	public static Connection getConnection() {
		Connection con = null;
		try {
			Context initCtx = new InitialContext();
			//현재 실행되는 톰캣 자체의 Context
			Context envCtx = (Context)initCtx.lookup("java:comp/env");
			//Resource 정의에 관한 Context를 얻어옴
			DataSource ds = (DataSource)envCtx.lookup("jdbc/jsptest");
			con = ds.getConnection();
			con.setAutoCommit(false);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return con;
	}

	public static void close(Connection con) {
		try {
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public static void close(Statement stmt) {
		try {
			stmt.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public static void close(ResultSet rs) {
		try {
			rs.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static void commit(Connection con) {
		try {
			con.commit();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static void rollback(Connection con) {
		try {
			con.rollback();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
