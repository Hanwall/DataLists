package other.src.com.hafao.information.modle;

import java.util.ArrayList;
import java.util.List;

import other.src.com.hafao.information.bean.Account;

public interface BaseDAO {

	// 增加
	public  String add(String[] data);

	// 删除
	public String delete(List<Integer> arr);

	// 修改
	public String update(int id);

	// 查询
	public ArrayList<Account> query();

}
