package jp.seizo.fujino;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.Model;
import org.apache.wicket.validation.validator.UrlValidator;

public class RegistrationPage extends WebPage {
	private static final long serialVersionUID = 1L;

	private Model<String> fieldmodelName;
	private Model<String> fieldmodelUrl;
	private Model<String> labelmodel;

	public RegistrationPage() {
		Label title = new Label("title", "Wicket Sample");
		this.add(title);

		this.add(new FeedbackPanel("error"));

		Form<?> form1 = new Form("form1");
		fieldmodelName = new Model<String>();
		fieldmodelUrl = new Model<String>();
		TextField<String> inputSiteName =
				new TextField<String>("inputSiteName", fieldmodelName);
		inputSiteName.setRequired(true);
		form1.add(inputSiteName);
		TextField<String> inputSiteUrl =
				new TextField<String>("inputSiteUrl", fieldmodelUrl);
		inputSiteUrl.setRequired(true);
		inputSiteUrl.add(new UrlValidator());
		form1.add(inputSiteUrl);
		Button submit = new Button("submit") {
			private static final long serialVersionUID = 1L;

			@Override
			public void onSubmit() {
					setResponsePage(new ResultRegistrationPage());
			}
		};
		form1.add(submit);
		this.add(form1);
	}

	public boolean submit() {
		String s = fieldmodelName.getObject();
		int n = Integer.parseInt(s);
		int total = 0;
		for (int i = 1; i <= n; i++)
			total += i;
		labelmodel.setObject("合計は、" + total + "です。");
		return true;
	}
}