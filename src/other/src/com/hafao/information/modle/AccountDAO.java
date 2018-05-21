package other.src.com.hafao.information.modle;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import other.src.com.hafao.information.bean.Account;
import other.src.com.hafao.information.utils.DBHelper;
import other.src.com.hafao.information.utils.PrintHelper;

public class AccountDAO implements BaseDAO {
	private static final String tableName = "account";
	private String sql;

	@Override
	public String add(String[] data) {
		sql = " INSERT INTO " + tableName
				+ " (`account_id`, `account_username`, `account_passwd`, `account_email`, `account_phone`, `account_otherinformation`, `account_usertime`) VALUES (";// SQL语句
		for (int i = 0; i < data.length; i++) {
			sql = sql + "" + data[i] + "";
			if (i != data.length - 1) {
				sql = sql + ",";
			}
		}
		sql = sql + ")";
		PrintHelper.print("插入SQL = " + sql);
		DBHelper db1 = new DBHelper(sql);// 创建DBHelper对象
		try {
			db1.pst.executeUpdate();// 执行语句，得到结果集
			db1.close();// 关闭连接
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String delete(List<Integer> arr) {
		sql = "DELETE FROM " + tableName + " WHERE account_id in (";
		for (int i = 0; i < arr.size(); i++) {
			sql = sql + arr.get(i).toString();
			if (i != arr.size() - 1) {
				sql = sql + ",";
			}
		}
		sql = sql + ")";
		PrintHelper.print("删除SQL" + sql);
		DBHelper db1 = new DBHelper(sql);// 创建DBHelper对象
		try {
			db1.pst.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		db1.close();
		return null;

	}

	@Override
	public String update(int id) {
		return null;
	}

	@Override
	public ArrayList<Account> query() {
		sql = "select * from " + tableName;// SQL语句
		DBHelper db1 = new DBHelper(sql);// 创建DBHelper对象
		ResultSet ret;
		ArrayList<Account> arrayList = new ArrayList<Account>();
		try {
			ret = db1.pst.executeQuery();// 执行语句，得到结果集
			while (ret.next()) {
				Account account = new Account();
//				account.setAccountId(ret.getString(1));
//				account.setAccountUsername(ret.getString(2));
//				account.setAccountPasswd(ret.getString(3));
//				account.setAccountEmail(ret.getString(4));
//				account.setAccountPhoneNo(ret.getString(5));
//				account.setAccountOtherInformation(ret.getString(6));
//				account.setAccountUsetime(ret.getString(7));
				arrayList.add(account);
			} // 显示数据
			ret.close();
			db1.close();// 关闭连接
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arrayList;
	}

}
