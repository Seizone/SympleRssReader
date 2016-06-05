package jp.seizo.fujino;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;

public class ResultRegistrationPage extends WebPage{

	public ResultRegistrationPage() {
		Label title = new Label("title", "Symple Rss Reader");
		this.add(title);

		//戻る
		Link homePageLink = new Link("homePageLink") {
			@Override
			public void onClick() {
				setResponsePage(new HomePage());
			}
		};
		this.add(homePageLink);
	}
}
