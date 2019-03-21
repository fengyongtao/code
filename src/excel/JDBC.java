package excel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.List;

public class JDBC {

	// 驱动
	private final static String driver = "com.mysql.jdbc.Driver";
	// 获取mysql连接地址
	private final static String url = "jdbc:mysql://127.0.0.1:3306/dsun?useUnicode=true&characterEncoding=utf8&useSSL=false&allowPublicKeyRetrieval=true";
	// 数据名称
	private final static String username = "root";
	// 数据库密码
	private final static String password = "root";

	/*
	 * public static void main(String[] args) { List<String> sqls = new
	 * ArrayList<String>(); sqls.
	 * add("INSERT INTO dsun_excel (excel, sheet, cell_key, cell_value) VALUES ('5', '5', '5', '5')"
	 * ); sqls.
	 * add("INSERT INTO dsun_excel (excel, sheet, cell_key, cell_value) VALUES ('8', '8', '8', '8')"
	 * );
	 * 
	 * doExecute(sqls);
	 * 
	 * }
	 */

	public static void doExecute(List<String> sqls) {

		// 定义需要的对象
		Statement st = null;
		Connection ct = null;
		try {
			Class.forName(driver);
			ct = DriverManager.getConnection(url, username, password);
			st = ct.createStatement();
			// 将所有的SQL语句添加到Statement中
			for (int i = 0; i < sqls.size(); i++) {
				st.addBatch(sqls.get(i));
			}
			// 一次执行多条SQL语句
			int[] results = st.executeBatch();
			System.out.println(results);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭资源
			try {
				// 为了程序健壮
				if (st != null)
					st.close();
				if (ct != null)
					ct.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	
}
