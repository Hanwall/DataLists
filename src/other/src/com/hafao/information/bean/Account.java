package other.src.com.hafao.information.bean;

import java.util.HashMap;
import java.util.Map;

public class Account {
	public static final String[] CLASSVALUE = { "id", "category", "username", "email", "phoneno", "passwd", "pruduct",
			"company", "link", "others", "usetime" };

	public static final String[] JTABLECOLUMNAME = { "序号", "类别", "用户名", "邮箱", "手机号", "密码", "账号名称", "账号所属公司", "账号链接",
			"其它信息", "使用时间段" };
	private Map<String, Object> ClassValueNameToColumnName;

	public Account() {
		ClassValueNameToColumnName = new HashMap<String, Object>();
		ClassValueNameToColumnName.put("序号", "id");
		ClassValueNameToColumnName.put("类别", "category");
		ClassValueNameToColumnName.put("用户名", "username");
		ClassValueNameToColumnName.put("邮箱", "email");
		ClassValueNameToColumnName.put("手机号", "phoneno");
		ClassValueNameToColumnName.put("密码", "passwd");
		ClassValueNameToColumnName.put("账户名称", "product");
		ClassValueNameToColumnName.put("账户所属公司", "comany");
		ClassValueNameToColumnName.put("其它信息", "others");
		ClassValueNameToColumnName.put("使用时间段", "usetime");
	}
	private String id;// 账户序列 自动增长
	private String category;// 账户类别
	private String username;// 账户用户名
	private String email;// 账户邮箱
	private String phoneno;// 账户手机号码
	private String passwd;// 账户密码
	private String pruduct;// 账户所属产品
	private String company;// 账户所属产品所属公司
	private String links;// 账户所属产品链接
	private String other;// 账户其它内容信息
	private String usetime;// 使用时间

	public Map<String, Object> getClassValueNameToColumnName() {
		return ClassValueNameToColumnName;
	}
	public void setClassValueNameToColumnName(Map<String, Object> classValueNameToColumnName) {
		ClassValueNameToColumnName = classValueNameToColumnName;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getPruduct() {
		return pruduct;
	}
	public void setPruduct(String pruduct) {
		this.pruduct = pruduct;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getLinks() {
		return links;
	}
	public void setLinks(String link) {
		this.links = link;
	}
	public String getOthers() {
		return other;
	}
	public void setOthers(String other) {
		this.other = other;
	}
	public String getUsetime() {
		return usetime;
	}
	public void setUsetime(String usetime) {
		this.usetime = usetime;
	}
	public static String[] getClassvalue() {
		return CLASSVALUE;
	}
	public static String[] getJtablecolumname() {
		return JTABLECOLUMNAME;
	}
}
