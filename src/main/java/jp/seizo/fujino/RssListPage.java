package jp.seizo.fujino;

import java.util.ArrayList;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.ExternalLink;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;

import jp.seizo.fujino.dao.RssLinkBean;
import jp.seizo.fujino.dao.RssSiteBean;
import jp.seizo.fujino.recources.RssResource;

public class RssListPage extends WebPage{

	public RssListPage(RssSiteBean bean) {
		Label title = new Label("title", "Symple Rss Reader");
		this.add(title);

		//サイトのリストを表示
		RssResource rssResource = new RssResource();
		ArrayList<RssLinkBean> RssLinklist = rssResource.parseXML(bean.getLinkUrl());
		ListView<RssLinkBean> listview = new ListView<RssLinkBean>("listview", RssLinklist) {
			private static final long serialVersionUID = 1L;

			@Override
			protected void populateItem(ListItem<RssLinkBean> item) {
				final RssLinkBean list = item.getModelObject();
				//Label label = new Label("linkNameLabel", list.getTitleName());
				//ハイパーリンク
				ExternalLink listPageLink = new ExternalLink("listPageLink", list.getLinkUrl(), list.getTitleName()) {
//					@Override
//					public void onClick() {
//						setResponsePage(new RssListPage());
//					}
				};
				item.add(listPageLink);
				//listPageLink.add(label);
			}
		};
		this.add(listview);
	}

}
