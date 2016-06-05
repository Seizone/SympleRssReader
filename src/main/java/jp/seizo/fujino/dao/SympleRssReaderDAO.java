package jp.seizo.fujino.dao;

import java.util.ArrayList;

public class SympleRssReaderDAO {

	//TODO DBにアクセスして自動で取得できるようにする。
	public ArrayList<RssSiteBean> getRssLinkList() {
		ArrayList<RssSiteBean> list = new ArrayList<RssSiteBean>();
		RssSiteBean rssLinkBean1 = new RssSiteBean();
		rssLinkBean1.setLinkId(1);
		rssLinkBean1.setLinkName("Apple");
		rssLinkBean1.setLinkUrl("http://www.apple.com/jp/main/rss/hotnews/hotnews.rss");
		RssSiteBean rssLinkBean2 = new RssSiteBean();
		rssLinkBean2.setLinkId(2);
		rssLinkBean2.setLinkName("Yahoo!");
		rssLinkBean2.setLinkUrl("http://news.yahoo.co.jp/pickup/rss.xml");
		RssSiteBean rssLinkBean3 = new RssSiteBean();
		rssLinkBean3.setLinkId(2);
		rssLinkBean3.setLinkName("Google");
		rssLinkBean3.setLinkUrl("http://news.google.com/news?hl=ja&ned=us&ie=UTF-8&oe=UTF-8&output=rss");
		list.add(0, rssLinkBean1);
		list.add(1, rssLinkBean2);
		list.add(1, rssLinkBean3);
		return list;

	}

}
