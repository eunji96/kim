package com.human.member;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;


/**
 * Handles requests for the application home page.
 */


@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */

	@Autowired
	private SqlSession sqlSession;

	@RequestMapping("/")
	public String home(HttpServletRequest req, Model model) {
		HttpSession session = req.getSession();
		
		if(session.getAttribute("userid")==null) {
			model.addAttribute("userinfo","");
		}else { //로그인 성공 후
			model.addAttribute("userinfo",session.getAttribute("realname"));
		}
		
		iMember ime=sqlSession.getMapper(iMember.class);
		ArrayList<mDTO>mlist=ime.listBoard();
		
		model.addAttribute("list",mlist);
		
		return "home";
	}
	
	@RequestMapping("/login")
	public String doLogin() {
		return "login";
	}

	@RequestMapping(value="/user_check",method = RequestMethod.POST)
	public String doUserCheck(@RequestParam("userid") String userid,
			@RequestParam("pwd") String pwd, 
			HttpServletRequest req, Model model) {
		
		HttpSession session=req.getSession();
		
		iMember ime=sqlSession.getMapper(iMember.class);
		int n=ime.checkId(userid,pwd);
		String nm=ime.listName(userid,pwd);
		
		if(n>0) {
			session.setAttribute("userid",userid);
			session.setAttribute("realname", nm);
		} else {
			model.addAttribute("ss","<h3>등록되지않은 계정입니다<h3>");
			return "login";
		}
//		
//		if(userid.equals(session.getAttribute("newuser")) && pwd.equals(session.getAttribute("newpwd"))) {
//			session.setAttribute("userid",userid);
//			session.setAttribute("realname", "Eunji🦝");
//		}else if(!userid.equals(session.getAttribute("newuser")) && pwd.equals(session.getAttribute("newpwd"))) {
//			model.addAttribute("ss","<h3>등록되지않은 아이디입니다<h3>");
//			return "login";
//		}else if(userid.equals(session.getAttribute("newuser")) && !pwd.equals(session.getAttribute("newpwd"))) {
//			model.addAttribute("ss","<h3>잘못된 비밀번호입니다<h3>");
//			return "login";
//		}else {
//			return "login";
//		}
		return "redirect:/";
	}
	
	@RequestMapping("/signin")
	public String doSignin() {
		return "signin";
	}
	
	@RequestMapping(value="/signin_ch", method = RequestMethod.POST)
	public String signinCh(@RequestParam("userid") String userid, 
			@RequestParam("pwd") String pwd, 
			@RequestParam("name") String name,
			@RequestParam("mobile") String mb,
			HttpServletRequest req) {

//		HttpSession session=req.getSession();
		
		iMember ime=sqlSession.getMapper(iMember.class);
		
		ime.insert(userid, pwd, name, mb);
//		session.setAttribute("newuser", userid);
//		session.setAttribute("newpwd", pwd);
		return "login";
	}
	
	@RequestMapping("/newpost")
	public String doNewpost() {
		return "new";
	}
	
	@RequestMapping("/post")
	public String doPost(@RequestParam int se, @RequestParam int vw, HttpServletRequest req, Model model) {
		HttpSession session=req.getSession();
		
		if(session.getAttribute("realname")==null) {
			model.addAttribute("user_a","");
		}else {
			model.addAttribute("user_a",session.getAttribute("realname"));
		}
		
		iMember ime=sqlSession.getMapper(iMember.class);
		mDTO mdto=ime.oneBoard(se);
		model.addAttribute("mdto",mdto);
		
		ime.upVw(vw+1, se);
		
		
		return "post";
	}
	
	@RequestMapping("/uppost")
	public String upPost(HttpServletRequest req) {
		HttpSession session=req.getSession();
		String title=req.getParameter("uptitle");
		String content=req.getParameter("upcontent");
		int seqbbs=Integer.parseInt(req.getParameter("se"));

		iMember ime=sqlSession.getMapper(iMember.class);
		ime.upPost(title, content, seqbbs, (String)session.getAttribute("realname"));
		return "redirect:/";
	}
	
	@RequestMapping("/depost")
	public String dePost(@RequestParam int se) {
		iMember ime=sqlSession.getMapper(iMember.class);
		ime.dePost(se);
		return "redirect:/";
	}
	
	@RequestMapping("/postwriter")
	public String dopostWriter(HttpServletRequest req) {
		HttpSession session=req.getSession();
		String title=req.getParameter("title");
		String content=req.getParameter("content");

		iMember ime=sqlSession.getMapper(iMember.class);
		ime.inBoard(title, content, (String)session.getAttribute("realname"));
		return "redirect:/";
	}
	
	@RequestMapping("/logout")
	public String doLogout(HttpServletRequest req) {
		HttpSession session=req.getSession();
		session.invalidate(); //저장되있던 정보들 다 삭제
		return "redirect:/";
	}
}
