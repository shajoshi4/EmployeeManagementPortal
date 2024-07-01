package com.app.controllers;

	import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.pojos.Notice;
import com.app.pojos.Person;
import com.app.services.EmployeeServiceIntf;
import com.app.services.NoticeServiceIntf;
import com.app.services.PersonServiceIntf;



	@Controller
	//@RequestMapping("/General")
	public class GeneralController {

		@Autowired
		private PersonServiceIntf pService;
		@Autowired
		private NoticeServiceIntf noticeSerIntf;
		@Autowired
		private HttpSession session;
		@Autowired
		private EmployeeServiceIntf eservice;

		@GetMapping("/General/login")
		public String showLogin(Model map)
		{
			map.addAttribute("person",new Person());
			return "General/login";
		}
		
		
		@PostMapping("/General/login")
		public String doLogin(@ModelAttribute("person") Person p)
		{
			
			System.out.println("in Post Login");
			return pService.getPojo(p.getEmail(), p.getPassword());
			
		}
		
		@RequestMapping("/Manager/homeMgr")
		public String pathredirect(Model map)
		{
			System.out.println("in get showNotices");
			Person p = (Person)session.getAttribute("user");
			List<Notice> showNotices = noticeSerIntf.getNoticeByDeptId(p.getDept().getDeptId());
			map.addAttribute("viewNotices",showNotices);
			return "/Manager/homeMgr";
		}
		
		@RequestMapping("/Employee/homeEmp")
		public String pathEmpPage(Model map)
		{
			System.out.println("in get showNotices");
			Person p = (Person)session.getAttribute("user");
			List<Notice> showNotices = noticeSerIntf.getNoticeByDeptId(p.getDept().getDeptId());
			map.addAttribute("viewNotices",showNotices);
			return "/Employee/homeEmp";
		}
		
		@GetMapping("/General/editProfile")
		public String editProfile(Model map)
		{
			map.addAttribute("user",session.getAttribute("user"));
			//System.out.println(map.addAttribute(session.getAttribute("user")));
			return "General/editProfile";
		}
		
		@PostMapping("/General/editProfile")
		public String doEditProfile(@ModelAttribute(name="person")Person p,Model map)
		{
			//int empId=p.getEmpId();
			//System.out.println();
			pService.editProfile(p.getEmpId(), p.getAddress(), p.getContactNo(), p.getEmail());
			return "General/editComplete";
		}
		
		@GetMapping("/General/changePassword")
		public String changePassword(HttpSession session,Model map)
		{	System.out.println("***********************************************************************************");
			session.setAttribute("code",eservice.getCaptchaCode());
			System.out.println("User Id:"+session.getAttribute("user"));
			return "/General/changePassword";
		}
		
		@PostMapping("/General/setNewPassword")
		public String setNewPassword(@RequestParam int empId,@RequestParam String oldPass,@RequestParam String newPass,@RequestParam String confirmPass,
				@RequestParam String hcapcha,HttpSession session,Model map)
		{
			System.out.println("hcapcha:"+hcapcha);
			System.out.println("code"+session.getAttribute("code"));
			if(hcapcha.equals(session.getAttribute("code")))
			{
				if(newPass.equals(confirmPass))
				{
					Person emp=eservice.getEmpById(empId);
					if(emp.getPassword().equals(oldPass))
					{
					eservice.updatePassword(empId, newPass);
					map.addAttribute("msg","Your Password changed successfully");
					return "/General/passwordMsg";
					}
					else
					{
					map.addAttribute("msg","Old Password is not valid");
					return "/General/passwordMsg";
					}
				
				}
				else
				{
				map.addAttribute("msg","Confirm and New password must be same");
				return "/General/passwordMsg";
				}
			}
			else
			{
			map.addAttribute("msg","Enter Captcha again");
			return "/General/passwordMsg";
			}
		}
		
		@GetMapping("/General/logout")
		public String logout()
		{
			pService.logout();
			return "redirect:/General/login";
		}
		
	}
