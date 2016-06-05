package jp.seizo.fujino;

import java.util.ArrayList;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.CheckBox;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.Model;

import jp.seizo.fujino.dao.RssSiteBean;
import jp.seizo.fujino.dao.SympleRssReaderDAO;

public class DeletePage  extends WebPage {
	private Model<Boolean> checkmodel;
	public DeletePage() {
		Label title = new Label("title", "Symple Rss Reader");
		this.add(title);

		Form<?> form1 = new Form("form1");


		//サイトのリストを表示
		ArrayList<RssSiteBean> rssLinkBeanList = new SympleRssReaderDAO().getRssLinkList();
		ListView<RssSiteBean> listview = new ListView<RssSiteBean>("listview", rssLinkBeanList) {
			private static final long serialVersionUID = 1L;

			@Override
			protected void populateItem(ListItem<RssSiteBean> item) {
				final RssSiteBean list = item.getModelObject();
				checkmodel = new Model<Boolean>();
				item.add(new CheckBox("bool", checkmodel));
				Label label = new Label("siteNameLabel", list.getLinkName());
				item.add(label);
			}
		};
		Button submit = new Button("submit") {
			private static final long serialVersionUID = 1L;

			@Override
			public void onSubmit() {
//				labelmodel.setObject("現在の値：" + checkmodel.getObject());
					setResponsePage(new ResultRegistrationPage());
			}
		};
		form1.add(listview);
		form1.add(submit);
		this.add(form1);
	}

//	public boolean submit() {
//		Boolean s = checkmodel.getObject();
//		int n = Integer.parseInt(s);
//		int total = 0;
//		for (int i = 1; i <= n; i++)
//			total += i;
//		labelmodel.setObject("合計は、" + total + "です。");
//		return true;
//	}
}
