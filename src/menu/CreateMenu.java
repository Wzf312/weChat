package menu;

import menu.Button;
import menu.ClickButton;
import menu.SubButton;
import menu.ViewButton;
import net.sf.json.JSONObject;
import service.WxService;
import util.Util;

public class CreateMenu {
	
	public static void main(String[] args) {
		// 菜单对象
		Button btn = new Button();
		// 第一个一级菜单
		btn.getButton().add(new ClickButton("查看详情", "1"));
		// 第二个一级菜单
		btn.getButton().add(new ViewButton("链接跳转", "http://www.ecmee.com"));
		// 第三个一级菜单
		SubButton sb = new SubButton("更多");
		// 第三个一级菜单添加二级菜单
		//sb.getSub_button().add(new PhotoOrAlbum("传图", "31"));
		//sb.getSub_button().add(new ClickButton("合作", "32"));
		//sb.getSub_button().add(new ViewButton("新闻", "http://news.163.com"));
		sb.getSub_button().add(new ClickButton("安徽","AnHui"));
		sb.getSub_button().add(new ClickButton("江苏","JiangSu"));
		sb.getSub_button().add(new ClickButton("湖南","HuNan"));
		// 将包含子菜单的一级菜单加入
		btn.getButton().add(sb);
		// 转为JSON
		JSONObject jsonObject = JSONObject.fromObject(btn);
		// 准备url
		String url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
		url = url.replace("ACCESS_TOKEN", WxService.getAccessToken());
		// 发送请求
		@SuppressWarnings("unused")
		String result = Util.post(url, jsonObject.toString());
		//System.out.println(result);
	}
}
