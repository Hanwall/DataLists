package other.src.com.hafao.information.view;


import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import other.src.com.hafao.information.modle.AccountDAO;
import other.src.com.hafao.information.utils.PrintHelper;

public class DesktopJTablePane extends JPanel {
	private static final long serialVersionUID = 5563919229138348873L;
	
	JTable table; // 表
	DesktopJTableModle jtableMode; // 表模型
	Boolean isSelect = false; // 是否选中 默认是没有选中
	int rowSelectIndex = -1; // 选中的行数
	int columnSelectIndex = -1;// 选中的列数
	private String commandName = "initStatus"; // 保存状态，区别是修改保存还是增加保存
	ArrayList<Object> rowDataList = new ArrayList<Object>();

	public DesktopJTablePane() {
		jtableMode = new DesktopJTableModle();
		this.table = new JTable(jtableMode);
		table.setPreferredScrollableViewportSize(new Dimension(550, 30));
		table.setFillsViewportHeight(true);

		table.getSelectionModel().addListSelectionListener(new RowListener());// 选中行监听
		table.getColumnModel().getSelectionModel().addListSelectionListener(new ColumnListener());// 选中列监听

		JScrollPane scrollPane = new JScrollPane(table);
		add(scrollPane);

		JPanel jp = new JPanel();

		// 构建刷新按钮
		JButton refreshButton = new JButton("刷新");
		refreshButton.setBounds(506, 497, 89, 23);

		// 刷新功能
		refreshButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				jtableMode.setDate();
				jtableMode.fireTableDataChanged();

			}
		});
		jp.add(refreshButton);

		// 构建删除按钮
		JButton deleteButton = new JButton("删除");
		deleteButton.setBounds(244, 497, 89, 23);

		// 删除功能 // 多选功能没有实现
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PrintHelper.print("delete");
				List<Integer> arr = new ArrayList<Integer>();
				int dataIndex = 0;
				for (dataIndex = 0; dataIndex < jtableMode.data.length; dataIndex++) {
					Boolean valueAtIndex = (Boolean) jtableMode.getValueAt(dataIndex, 0);// 获取数据中的值
					if (valueAtIndex) {
						arr.add(dataIndex);
					}
				}
				if (arr.size() == 0) {
					JOptionPane.showMessageDialog(null, "未选中行", "错误信息", JOptionPane.WARNING_MESSAGE);
				} else {
					new AccountDAO().delete(arr);
				}
			}
		});
		jp.add(deleteButton);

		// 构建增加按钮
		JButton addButton = new JButton("增加");
		addButton.setBounds(114, 497, 89, 23);
		// 增加功能
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PrintHelper.print("增加");
				// 添加新的行并且可以编辑
				jtableMode.addDate(null);
				jtableMode.fireTableDataChanged();
				commandName = "addStatus";

			}
		});
		jp.add(addButton);

		// 构建修改按钮
		JButton changButton = new JButton("修改");
		changButton.setBounds(373, 497, 89, 23);
		// 修改功能
		changButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 点击修改按钮，所选行进入可编辑状态，修改某处的值，按保存按钮保存数据，使所选行进入不可编辑状态
				PrintHelper.print("修改");
				table.setEditingRow(rowSelectIndex);
				commandName = "changeStatus";
			}
		});
		jp.add(changButton);

		// 构建保存按钮
		JButton saveButton = new JButton("保存");
		saveButton.setBounds(373, 497, 89, 23);
		// 保存功能
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (commandName.equals("changeStatus")) {
					PrintHelper.print("进入修改模式下保存");
					// 获取修改的值
					Object value = jtableMode.getValueAt(rowSelectIndex, columnSelectIndex);

					// 构建数据结构插入数据库
				} else if (commandName.equals("addStatus")) {
					// 修改模式下
					PrintHelper.print("进入增加模式下保存");
					// 增加模式下
					// 获取修改的值
					String dataarr[] = new String[7];
					int i;
					// 第一个boolean不要
					for (i = 0; i < jtableMode.columnNames.length - 1; i++) {
						dataarr[i] = (String) jtableMode.getValueAt(jtableMode.data.length - 1, i + 1);
					}
					// 设置编辑模式为不可编辑
					// 存入数据库
					new AccountDAO().add(dataarr);

				} else {
					PrintHelper.print("没有修改数据，还要保存啥");
				}
				commandName = "initStatus";
			}
		});
		jp.add(saveButton);
		add(jp);
	}

	// 选中行监听调用
	private class RowListener implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent event) {
			if (event.getValueIsAdjusting()) {
				rowSelectIndex = table.getSelectedRows()[0];// 获取选中的行
				Boolean valueAtIndex = (Boolean) jtableMode.getValueAt(rowSelectIndex, 0);// 获取数据中的值
				if (valueAtIndex) {
					isSelect = false;
					PrintHelper.print("取消选中了第" + (rowSelectIndex + 1) + "行");
				} else {
					isSelect = true;
					PrintHelper.print("选中了第" + (rowSelectIndex + 1) + "行");
				}
				jtableMode.setValueAt(isSelect, rowSelectIndex, 0);// 点击知乎设置相应的值
			}

		}
	}

	// 选中列监听调用
	private class ColumnListener implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent event) {
			if (event.getValueIsAdjusting()) {
				if (columnSelectIndex != -1) {
					PrintHelper.print("取消选中了第" + (columnSelectIndex + 1) + "列");
				}
				columnSelectIndex = table.getSelectedColumn();// 获取选中的列
				PrintHelper.print("选中了第" + (columnSelectIndex + 1) + "列");
			}
		}
	}

	
	
}
