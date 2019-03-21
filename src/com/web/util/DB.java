package com.web.util;
import java.util.ArrayList;
import java.util.Date;

import com.web.entity.Article;
import com.web.entity.User;

import java.sql.*;
public class DB {
    Connection con;
    Statement stmt;
    ResultSet res;
    String url="jdbc:mysql://localhost:3306/renren?useUnicode=true&characterEncoding=utf8";
    String user="root";
    String pwd="123456";
    String driver="com.mysql.jdbc.Driver";
    public DB() {
    	try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,user,pwd);
			stmt=con.createStatement();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    public int addUser (String name,String account,String pwd,String email) {
    	try {
    		PreparedStatement psmt = con.prepareStatement("select*from user where nickName=?");
			psmt.setString(1,name);
    		res = psmt.executeQuery();
			if(res.next()) {//昵称重复
				return -1;
			}
			psmt = con.prepareStatement("select*from user where account=?");
			psmt.setString(1,account);
    		res = psmt.executeQuery();
			if(res.next()) {//账号重复
				return -2;
			}
			psmt = con.prepareStatement("select*from user where email=?");
			psmt.setString(1,email);
    		res = psmt.executeQuery();
			if(res.next()) {//邮箱重复
				return -3;
			}
			psmt = con.prepareStatement("insert into user(nickName,account,password,email,registerTime) values(?,?,?,?,?)");
			psmt.setString(1,name);
			psmt.setString(2,account);
			psmt.setString(3, pwd);
			psmt.setString(4, email);
			psmt.setString(5, GetDate.getTime(new Date()));
			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return 1;
    }
    public User login(String account,String pwd) {
    	User user=null;
    	try {
			res=stmt.executeQuery("select*from user where account='"+account+"' and password='"+pwd+"'");
			if(res.next()) {
				user = getUser(account);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return user;
    }
    public void changepassword(String account,String pwd) {
    	try {
    		PreparedStatement psmt = con.prepareStatement("update user set password=? where account=?");
			psmt.setString(1,pwd);
			psmt.setString(2, account);
			psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
    }
    public int updateUser (String name,String account,String hobby,int age,String sex,String email,String qianming,User user) {	
    	try {
			if(!user.getName().equals(name)) {//说明昵称被改了,要去判断有无重复昵称
				PreparedStatement psmt = con.prepareStatement("select*from user where nickName=?");
				psmt.setString(1, name);
				res = psmt.executeQuery();
				if(res.next()) {
					return -1;
				}
			}
			PreparedStatement psmt = con.prepareStatement("update user set nickName=?,sex=?,hobby=?,age=?,email=?,qianming=?where account=?");
			psmt.setString(1,name);
			psmt.setString(2, sex);
			psmt.setString(3, hobby);
			psmt.setInt(4,age);
			psmt.setString(5, email);
			psmt.setString(6, qianming);
			psmt.setString(7, account);
			psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return 1;
    }
    public User getUser(String account) {
    	User user=null;
    	try {
			res=stmt.executeQuery("select*from user where account="+account);
			if(res.next()) {
				user = new User(res.getInt(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getString(6),
						res.getString(7),res.getInt(8),res.getString(9),res.getString(10),res.getString(11));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return user;
    }
    public void addArticle(String title,String content,String contentType,int authorID,String authorName,String authorTouxiang,int money) {
    	try {
			PreparedStatement psmt = con.prepareStatement("insert into article(title,content,contentType,authorID,authorName,authorTouxiang,writeTime,searchTimes,hitlikeTimes,commentTimes,money,ifsolve) values(?,?,?,?,?,?,?,?,?,?,?,?)");
			psmt.setString(1, title);
			psmt.setString(2, content);
			psmt.setString(3, contentType);
			psmt.setInt(4, authorID);
			psmt.setString(5, authorName);
			psmt.setString(6, authorTouxiang);
			psmt.setString(7,GetDate.getTime(new Date()));
			psmt.setInt(8, 0);
			psmt.setInt(9, 0);
			psmt.setInt(10, 0);
			psmt.setInt(11, money);
			psmt.setInt(12, 0);
			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    public Article getArticle(int articleID) {
    	Article article = new Article();
    	try {
			PreparedStatement psmt = con.prepareStatement("select*from article where articleID=?");
			psmt.setInt(1, articleID);
			res = psmt.executeQuery();
			if(res.next()) {
				article = new Article(res.getInt(1),res.getString(2),res.getString(3),res.getString(4),res.getInt(5),res.getString(6),res.getString(7),res.getString(8),res.getInt(9),res.getInt(10),res.getInt(11),res.getInt(12),res.getInt(13));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return article;
    }
    public ArrayList<Article> getAllarticles(String type) {
    	ArrayList<Article>articles = new ArrayList<Article>();
    	try {
    		PreparedStatement psmt = con.prepareStatement("select*from article where contentType=? order by articleID desc");
    		psmt.setString(1, type);
    		res = psmt.executeQuery();
			while(res.next()) {
			  Article article = new Article(res.getInt(1),res.getString(2),res.getString(3),res.getString(4),res.getInt(5),res.getString(6),res.getString(7),res.getString(8),res.getInt(9),res.getInt(10),res.getInt(11),res.getInt(12),res.getInt(13));
			  articles.add(article);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return articles;
    }
    public int searchmail(String email) {
    	try {
			PreparedStatement psmt = con.prepareStatement("select *from user where email=?");
			psmt.setString(1, email);
			res = psmt.executeQuery();
			if(!res.next()) {
				return -1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return 1;
    }
    //通过邮件来改密码
    public void changePwdbyMail(String email,String pwd) {
    	try {
			PreparedStatement psmt = con.prepareStatement("update user set password=? where email=?");
			psmt.setString(1, pwd);
			psmt.setString(2, email);
			psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
}
