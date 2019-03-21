package com.web.entity;

public class Article {
	int articlID;
	String title;
	String content;
	String contentType;
    int authorID;
    String authorName;
    String authorTouxiang;
	String writeTime;
	int watchTimes;
	int hitlikeTimes;
    int commentTimes;
    int money;//ÐüÉÍ½ð¶î
    int ifsolve;
	public Article() {
		super();
	}
	
	public Article(int articlID, String title, String content, String contentType, int authorID, String authorName,
			String authorTouxiang, String writeTime, int watchTimes, int hitlikeTimes, int commentTimes, int money,
			int ifsolve) {
		super();
		this.articlID = articlID;
		this.title = title;
		this.content = content;
		this.contentType = contentType;
		this.authorID = authorID;
		this.authorName = authorName;
		this.authorTouxiang = authorTouxiang;
		this.writeTime = writeTime;
		this.watchTimes = watchTimes;
		this.hitlikeTimes = hitlikeTimes;
		this.commentTimes = commentTimes;
		this.money = money;
		this.ifsolve = ifsolve;
	}

	public int getArticlID() {
		return articlID;
	}
	public void setArticlID(int articlID) {
		this.articlID = articlID;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	public int getAuthorID() {
		return authorID;
	}
	public void setAuthorID(int authorID) {
		this.authorID = authorID;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public String getAuthorTouxiang() {
		return authorTouxiang;
	}
	public void setAuthorTouxiang(String authorTouxiang) {
		this.authorTouxiang = authorTouxiang;
	}
	public String getWriteTime() {
		return writeTime;
	}
	public void setWriteTime(String writeTime) {
		this.writeTime = writeTime;
	}
	public int getWatchTimes() {
		return watchTimes;
	}
	public void setWatchTimes(int watchTimes) {
		this.watchTimes = watchTimes;
	}
	public int getHitlikeTimes() {
		return hitlikeTimes;
	}
	public void setHitlikeTimes(int hitlikeTimes) {
		this.hitlikeTimes = hitlikeTimes;
	}
	public int getCommentTimes() {
		return commentTimes;
	}
	public void setCommentTimes(int commentTimes) {
		this.commentTimes = commentTimes;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public int getIfsolve() {
		return ifsolve;
	}
	public void setIfsolve(int ifsolve) {
		this.ifsolve = ifsolve;
	}
	
}
	