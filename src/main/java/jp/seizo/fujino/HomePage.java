package jp.seizo.fujino;

import java.util.ArrayList;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;

import jp.seizo.fujino.dao.RssSiteBean;
import jp.seizo.fujino.dao.SympleRssReaderDAO;

public class HomePage extends WebPage {
	private static final long serialVersionUID = 1L;

	public HomePage() {
		Label title = new Label("title", "Symple Rss Reader");
		this.add(title);

		/*TODO
		//登録する
		Label registrationLabel = new Label("registrationLabel", "登録する");
		Link registrationPageLink = new Link("registrationPageLink") {
			@Override
			public void onClick() {
				setResponsePage(new RegistrationPage());
			}
		};
		this.add(registrationPageLink);
		registrationPageLink.add(registrationLabel);

		//削除する
		Label deleteLabel = new Label("deleteLabel", "削除する");
		Link deletePageLink = new Link("deletePageLink") {
			@Override
			public void onClick() {
				setResponsePage(new DeletePage());
			}
		};
		this.add(deletePageLink);
		deletePageLink.add(deleteLabel);
		 */

		//サイトのリストを表示
		ArrayList<RssSiteBean> rssLinkBeanList = new SympleRssReaderDAO().getRssLinkList();
		ListView<RssSiteBean> listview = new ListView<RssSiteBean>("listview", rssLinkBeanList) {
			private static final long serialVersionUID = 1L;

			@Override
			protected void populateItem(ListItem<RssSiteBean> item) {
				final RssSiteBean list = item.getModelObject();
				//サイト名を取得
				Label label = new Label("linkNameLabel", list.getLinkName());
				Link listPageLink = new Link("listPageLink") {
					@Override
					public void onClick() {
						//リンク先を開く
						setResponsePage(new RssListPage(list));
					}
				};
				item.add(listPageLink);
				listPageLink.add(label);
			}
		};
		this.add(listview);
	}
}
