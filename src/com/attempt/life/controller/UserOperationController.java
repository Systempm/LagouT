package com.attempt.life.controller;

import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.attempt.life.po.AlldbPageVo;
import com.attempt.life.po.MylistVo;
import com.attempt.life.po.UserOperationVo;
import com.attempt.life.po.UserhighselectVo;
import com.attempt.life.service.impl.UserLoginServiceImpl;
import com.attempt.life.service.impl.UserOperationServiceImpl;

@Controller
public class UserOperationController {

	
	@Autowired
	private UserOperationServiceImpl userOperationServiceImpl;
	
	
	@RequestMapping("/Usermy")
	public String Usermy(HttpSession httpSession,Model model)throws Exception{
		//�����û��� �õ�����
	MylistVo mylistvo=	userOperationServiceImpl.getmy((String)httpSession.getAttribute("username"));
	System.out.println(mylistvo.getHatenum());	
	model .addAttribute("mylist",mylistvo);
		return "user_my";
	}
	
	//ϲ�� ������ ��������ʾ�� ȫ���б��� 
	@RequestMapping("/Userinlove")
	public String Userinlove(String username,String positionid,String page)throws Exception {
		UserOperationVo nv =new UserOperationVo();
		nv.setUsername(username);
		nv.setPositionid(positionid);
			userOperationServiceImpl.Userinlove(nv);
			return "redirect:user_highselectdb?page="+page;
	}
	
	
	@RequestMapping("/Userinhate")
	public String Userinhate( String username,String positionid,String page)throws Exception {
		UserOperationVo nv =new UserOperationVo();
		nv.setUsername(username);
		nv.setPositionid(positionid);
		userOperationServiceImpl.Userinhate(nv);
		
		   return "redirect:user_highselectdb?page="+page;
	}
	@RequestMapping("/Userselectlove")
	public String Userselectlove(Model model,HttpSession httpSession)throws Exception {
		
	String username = (String)httpSession.getAttribute("username");
		model.addAttribute("list", 	userOperationServiceImpl.userselectlove(username));
		   return "user_love";
	}
	@RequestMapping("/Userselecthate")
	public String Userselecthate(Model model,HttpSession httpSession)throws Exception {
		String username = (String)httpSession.getAttribute("username");
		model.addAttribute("list",	userOperationServiceImpl.userselecthate(username));
		
		   return "user_hate";
	}
	
	
	//�û� ������Ϣ�б�
	@RequestMapping("/user_select_db")
    public String  user_select_db(Model model,Integer page,HttpSession httpSession) throws Exception {
    	//Ĭ�� ÿҳ13��
		String username = (String)httpSession.getAttribute("username");
    	if (page ==null)
    	{
    		page=1;
    	}
    	AlldbPageVo AlldbPageVo =userOperationServiceImpl.user_select_db(page,username);
    	 model.addAttribute("pagevo", AlldbPageVo);
    	return "user_dblist";
    }
	//�б� �߼����� 
	@RequestMapping("/user_highselectdb")
    public String  user_highselectdb( Model model,HttpServletRequest request,Integer page,HttpSession httpSession) throws Exception {
		int num=1;
		if (page ==null)
    	{
			num = 0;
    		page=1;
    	}
		//�ж�page 
        //����ǲ�����uv ����vo    ���� . �ڶ�������
	
		if(httpSession.getAttribute("uv")==null|| num==0) {
		//Ϊ��  Ϊ�����uv
			UserhighselectVo uv = new UserhighselectVo();
    	uv .setCity(request.getParameter("city"));
    	uv.setMaxsalary(request.getParameter("maxsalary"));
    	uv.setMinsalary(request.getParameter("minsalary"));
        uv .setPosition(request.getParameter("position"));
        AlldbPageVo alldbPageVo =userOperationServiceImpl.user_highselect(page,(String)httpSession.getAttribute("username"),uv);
             //��uv�ŵ�session
        model.addAttribute("pagevo", alldbPageVo);
        httpSession.setAttribute("uv",uv);
		}
		else{
			//   2 . ��ҳ 
			//�ж�page 
			UserhighselectVo uv =(UserhighselectVo) httpSession.getAttribute("uv");
				//û��page ���� 
			AlldbPageVo alldbPageVo =userOperationServiceImpl.user_highselect(page,(String)httpSession.getAttribute("username"),uv);
			model.addAttribute("pagevo", alldbPageVo);
		}
		 return "user_dblist_highlist";
    }
	
	
	
	//�û� ������Ϣ�б� ͼ�Σ�
	@RequestMapping("/user_select_db_pi")
    public String  user_select_db_pi(Model model,Integer page,HttpSession httpSession) throws Exception {
    	//Ĭ�� ÿҳ13��
		String username = (String)httpSession.getAttribute("username");
    	if (page ==null)
    	{
    		page=1;
    	}
    	AlldbPageVo alldbPageVo =userOperationServiceImpl.user_select_db(page,username);
    	 model.addAttribute("pagevo", alldbPageVo);
    	return "user_pilist";
    }
	
	@RequestMapping("/user_highselect")
    public String  user_highselect( Model model,HttpServletRequest request,Integer page,HttpSession httpSession) throws Exception {
		int num=1;
		if (page ==null)
    	{
			num = 0;
    		page=1;
    	}
		//�ж�page 
        //����ǲ�����uv ����vo    ���� . �ڶ�������
	
		if(httpSession.getAttribute("uv")==null|| num==0) {
		//Ϊ��  Ϊ�����uv
			UserhighselectVo uv = new UserhighselectVo();
    	uv .setCity(request.getParameter("city"));
    	uv.setMaxsalary(request.getParameter("maxsalary"));
    	uv.setMinsalary(request.getParameter("minsalary"));
        uv .setPosition(request.getParameter("position"));
        AlldbPageVo alldbPageVo =userOperationServiceImpl.user_highselect(page,(String)httpSession.getAttribute("username"),uv);
             //��uv�ŵ�session
        model.addAttribute("pagevo", alldbPageVo);
        httpSession.setAttribute("uv",uv);
		}
		else{
			//   2 . ��ҳ 
			//�ж�page 
			UserhighselectVo uv =(UserhighselectVo) httpSession.getAttribute("uv");
				//û��page ���� 
			AlldbPageVo alldbPageVo =userOperationServiceImpl.user_highselect(page,(String)httpSession.getAttribute("username"),uv);
			model.addAttribute("pagevo", alldbPageVo);
		}
        
      
		 
      
        return "user_pilist_highlist";
    }
	
}
