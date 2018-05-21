package other.src.com.hafao.information.view;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import other.src.com.hafao.information.bean.Account;
import other.src.com.hafao.information.modle.AccountDAO;

//构建表用到的数据源
public class AccountJTableModleBACK extends AbstractTableModel {
	public boolean isEditStatus = false;
	private static final long serialVersionUID = 1L;
	public String[] columnNames = { "选中", "账户序列", "用户名", "密码", "邮箱", "手机号", "其它内容信息", "使用时间" };
	public Object[][] data;
	private ArrayList<Account> lists;

	public AccountJTableModleBACK() {
		setDate();
	}

	public void addDate(Object[] newdata) {
		isEditStatus = true;
		if (newdata == null) {
			newdata = new Object[] { false, String.valueOf(data.length + 1), null, null, null, null, null, null };
		}
		Object[][] newdata1 = new Object[data.length + 1][columnNames.length];
		for (int i = 0; i <= data.length; i++) {
			for (int j = 0; j < columnNames.length; j++) {
				if (i < data.length) {
					newdata1[i][j] = data[i][j];
				} else {
					newdata1[i][j] = newdata[j];
				}
			}
		}
		data = newdata1;
	}

	public void removeDate(int index) {
		Object[][] newdata1 = new Object[data.length - 1][columnNames.length];
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < columnNames.length; j++) {
				if (j != index) {
					newdata1[i][j] = data[i][j];
				}
			}
		}
		data = newdata1;
	}

	public void setDate() {
		lists = new AccountDAO().query();
		data = new Object[lists.size()][columnNames.length];
		for (int j = 0; j < lists.size(); j++) {
//			data[j][0] = new Boolean(false);
//			data[j][1] = lists.get(j).getAccountId();
//			data[j][2] = lists.get(j).getAccountUsername();
//			data[j][3] = lists.get(j).getAccountPasswd();
//			data[j][4] = lists.get(j).getAccountEmail();
//			data[j][5] = lists.get(j).getAccountPhoneNo();
//			data[j][6] = lists.get(j).getAccountOtherInformation();
//			data[j][7] = lists.get(j).getAccountUsetime();
		}
	}

	public int getColumnCount() {
		return columnNames.length;
	}

	public int getRowCount() {
		return data.length;
	}

	public String getColumnName(int col) {
		return columnNames[col];
	}

	public Object getValueAt(int row, int col) {
		return data[row][col];
	}

	// 设置第一列checkbox可以编辑
	public boolean isCellEditable(int row, int col) {
		if (isEditStatus && row == data.length) {
		} else {
			return true;
		}
		if (col == 0) {
			return true;
		} else {
			return false;
		}
	}

	// 根据返回值 第一列默认渲染checkbox
	public void setValueAt(Object value, int row, int col) {
		data[row][col] = value;
		fireTableCellUpdated(row, col);
	}

	public Class getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}

}
