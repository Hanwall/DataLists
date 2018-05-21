package other.src.com.hafao.information.bean;

import java.util.HashMap;
import java.util.Map;

public class InformationMapping {
	private Map<String, Object> ClassNameToColumnName;// JavaBean===>显示列名
	public static final String[] CLASSNAME = { "账户详情", "手机详情", "邮箱详情", "卡号详情", "用户名详情", "产品详情", "公司详情", "类别详情" };
	public static final String[] COLUMNNAME = { "Account", "Phone", "Emails", "EbankCards", "Username", "User",
			"Company", "Category" };

	// 填值
	public InformationMapping() {
		ClassNameToColumnName = new HashMap<String, Object>();
		ClassNameToColumnName.put("账户详情", "Account");
		ClassNameToColumnName.put("手机详情", "Phone");
		ClassNameToColumnName.put("邮箱详情", "Emails");
		ClassNameToColumnName.put("卡号详情", "EbankCars");
		ClassNameToColumnName.put("用户名详情", "Username");
		ClassNameToColumnName.put("产品户详情", "User");
		ClassNameToColumnName.put("公司详情", "Company");
		ClassNameToColumnName.put("类别详情", "Category");

	}

	public Map<String, Object> getClassNameToColumnName() {
		return ClassNameToColumnName;
	}

}
