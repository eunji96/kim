package com.human.member;

import java.util.ArrayList;

public interface iMember {
	String listName(String id, String pwd);
	int checkId(String id, String pwd);
	void insert(String id, String pwd, String name, String mobile);
	
	ArrayList<mDTO> listBoard();
	mDTO oneBoard(int se); 
	void inBoard(String title,
			String content,
			String writer);
	void dePost(int se);
	void upPost(String title,
			String content,
			int seqbbs,
			String writer);
	void upVw(int vw, int se);
}
