package com.suoyi.sys;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.suoyi.entity.Dict;
import com.suoyi.entity.DictMap;
import com.suoyi.entity.UserBean;
import com.suoyi.ui.Button;
import com.suoyi.ui.Menu;
import com.suoyi.ui.PageModel;
import com.suoyi.ui.qlist.ContentTD;
import com.suoyi.ui.qlist.QueryList;
import com.suoyi.ui.qlist.SearchField;
import com.suoyi.util.SessionUtil;

@SuppressWarnings("unchecked")
public class ContextManager {
	private static String uilocation = "/ui";
	private static String menuLocation = "/ui/menu.xml";
	private static String pageLocation = "/ui/page.xml";
	public static ServletContext context;
	private static Map<String, UserBean> users = new HashMap<String, UserBean>();
	public static List<Menu> menu = new ArrayList<Menu>();
	public static Map<String, PageModel> pages = new HashMap<String, PageModel>();
	public static Map<Integer,List<Dict>> dict = new HashMap<Integer,List<Dict>>();
	
	public static void init() {
		initMenu();
		initPage();
		initDict();
	}

	/**
	 * 初始化系统菜单
	 */
	private static void initMenu() {
		SAXReader reader = new SAXReader();
		InputStream input = null;
		try {
			input = ContextManager.class.getResourceAsStream(menuLocation);
			Document doc_menu = reader.read(input);
			Element root = doc_menu.getRootElement();

			List<Element> eles = root.elements();

			for (Element ele : eles) {
				Menu m = new Menu();

				m.setId(Integer.valueOf(ele.attributeValue("id")));

				m.setName(ele.attributeValue("name"));
				List<Element> c_eles = ele.elements();
				for (Element e : c_eles) {
					Button btn = new Button();
					btn.setId(Integer.valueOf(e.attributeValue("id")));
					btn.setName(e.attributeValue("name"));

					StringBuffer click = new StringBuffer("doMenu('");
					click.append(e.attributeValue("id"));
					click.append("','").append(e.attributeValue("name"));
					click.append("','").append(e.attributeValue("href"));
					click.append("')");

					btn.setOnclick(click.toString());
					m.getBtns().add(btn);
				}

				menu.add(m);
			}
			System.out.println("系统菜单初始化完成...System menu Initialized sucess");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 初始化系统页面
	 */
	private static void initPage() {

		SAXReader reader = new SAXReader();
		InputStream input = null;
		try {
			input = ContextManager.class.getResourceAsStream(pageLocation);
			Document doc_page = reader.read(input);
			Element root = doc_page.getRootElement();

			List<Element> eles = root.elements();

			for (Element ele : eles) {
				PageModel page = new PageModel();
				page.setId(ele.attributeValue("id"));
				page.setType(ele.attributeValue("type"));
				QueryList ql = new QueryList();

				String target = uilocation + "/target/" + page.getId() + ".xml";
				Document doc_target = reader.read(ContextManager.class.getResourceAsStream(target));
				Element root_target = doc_target.getRootElement();
				List<Element> es_target = root_target.elements();
				for (Element e_target : es_target) {
					ql.setHibean(e_target.attributeValue("hibean"));
					ql.setSvc(e_target.attributeValue("svc"));

					List<Element> e_t_cs = e_target.elements();

					for (Element etc : e_t_cs) {
						if (etc.getName().equals("searchForm")) {

							List<Element> e_sfs = etc.elements();
							for (Element esf : e_sfs) {
								SearchField sf = new SearchField();
								sf.setId(esf.attributeValue("id"));
								sf.setField(esf.attributeValue("field"));
								sf.setIsRead(esf.attributeValue("isread"));
								sf.setLabel(esf.attributeValue("label"));
								sf.setOp(esf.attributeValue("op"));
								sf.setType(esf.attributeValue("type"));
								ql.getSearch().add(sf);
							}

						} else if (etc.getName().equals("content")) {

							List<Element> e_ctd = etc.elements();
							for (Element etd : e_ctd) {
								ContentTD td = new ContentTD();
								td.setColor(etd.attributeValue("color"));
								td.setField(etd.attributeValue("field"));
								td.setHref(etd.attributeValue("href"));
								td.setId(etd.attributeValue("id"));
								td.setIsHide(etd.attributeValue("ishide"));
								td.setName(etd.attributeValue("name"));
								td.setRem(etd.attributeValue("rem"));
								td.setType(etd.attributeValue("type"));
								ql.getContent().add(td);
							}

						}
					}

				}
				page.setQuerylist(ql);
				pages.put(page.getId(), page);
			}
			System.out.println("系统页面初始化完成...System page Initialized sucess");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * 初始化系统字典
	 */
	private static void initDict() {
		try{
			List<DictMap> sys_dict_map = SessionUtil.getSession().createQuery("From DictMap").list();
			for(DictMap dcm:sys_dict_map){
				List<Dict> dicts = SessionUtil.getSession().createQuery("From Dict where typeid = "+dcm.getTypeid()).list();
				dict.put(Integer.valueOf(dcm.getTypeid()), dicts);
			}
			System.out.println("系统字典初始化完成...System Dict Initialized sucess");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static List<Dict> getDictbyType(String typeid){
		List<Dict> list = dict.get(Integer.parseInt(typeid));
		return list;
	}
	
	public static PageModel getPageByTarget(String target){
		return pages.get(target);
	}
	/**
	 * 获取当前登录的用户
	 * 
	 * @param sessionid
	 * @return
	 */
	public static UserBean getCurUser(HttpServletRequest request) {
		String sessionid = (String) request.getSession().getId();
		return users.get(sessionid);
	}

	public static void addOnLineUser(String sessionid, UserBean user) {
		users.put(sessionid, user);
	}

	public static void removeUser(HttpServletRequest request) {
		String sessionid = (String) request.getSession().getId();
		users.remove(sessionid);
	}
}
