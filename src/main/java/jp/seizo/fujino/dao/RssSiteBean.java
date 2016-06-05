package jp.seizo.fujino.dao;

public class RssSiteBean {

	private int linkId = 0;
	private String linkName = "";
	private String linkUrl = "";

	public int getLinkId() {
		return linkId;
	}

	public void setLinkId(int i) {
		this.linkId = i;
	}

	public String getLinkName() {
		return linkName;
	}

	public void setLinkName(String linkName) {
		this.linkName = linkName;
	}

	public String getLinkUrl() {
		return linkUrl;
	}

	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}

}
