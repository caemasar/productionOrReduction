//package idv.caemasar.action;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.apache.struts2.ServletActionContext;
//
//import idv.caemasar.entity.ExtensionContent;
//import idv.caemasar.redisclient.RedisService;
//import idv.caemasar.redisclient.RedisTool;
//
//public class RExtConQueryAction extends BaseAction {
//	RedisService rs = RedisTool.getRedisService();
//	List<ExtensionContent> extensionContentlist = new ArrayList<ExtensionContent>();
//	ExtensionContent extensionContent;
//
//	public String execute() {
//		if (rs != null) {
//			System.out.println("RedisService : " + rs);
//			getAll();
//		}
//		ServletActionContext.getRequest().setAttribute("extensionContentlist", extensionContentlist);
//		return SUCCESS;
//	}
//
//	private void getAll() {
//		extensionContentlist = new ArrayList<ExtensionContent>();
//		int num = Integer.parseInt(rs.get("ExtensionContent:count"));
//		for (int i = 0; i < num; i++) {
//			String cid = "ExtensionContent:" + (i + 1);
//			extensionContent = new ExtensionContent();
//			// int id = Integer.parseInt(String.valueOf(rs.getHash(cid, "ID")));
//			// extensionContent.setId(id);
//			// System.out.println("ID:" + id);
//			// String name = (String) rs.getHash(cid, "NAME");
//			// c.setName(name);
//			// System.out.println("NAME:" + name);
//			// String comment = (String) rs.getHash(cid, "COMMENT");
//			// c.setComment(comment);
//			// System.out.println("COMMENT:" + comment);
//			// extensionContentlist.add(c);
//		}
//	}
//
//}
