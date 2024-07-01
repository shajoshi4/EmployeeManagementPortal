package com.app.controllers;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.app.pojos.Employee;
import com.app.pojos.Feedback;
import com.app.pojos.Leave;
import com.app.pojos.Manager;
import com.app.pojos.Notice;
import com.app.pojos.Task;
import com.app.services.EmployeeServiceIntf;
import com.app.services.FeedbackServiceIntf;
import com.app.services.LeaveServiceIntf;
import com.app.services.NoticeServiceIntf;
import com.app.services.PersonServiceIntf;
import com.app.services.TaskServiceIntf;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/Manager")
public class ManagerController {

	@Autowired
	private EmployeeServiceIntf empService;
	@Autowired
	private PersonServiceIntf pService;
	@Autowired
	private LeaveServiceIntf leaveIntf;
	@Autowired
	private HttpSession session;
	@Autowired
	 private JavaMailSender mailSender;
	@Autowired
	private NoticeServiceIntf noticeSerIntf;
	@Autowired
	private FeedbackServiceIntf fService;
	@Autowired
	private TaskServiceIntf tService;

	@GetMapping("/register")
	public String showRegisterEmp(Model map)
	{
		System.out.println("in get Manager");
		map.addAttribute("emp",new Employee());
		return "Manager/register";
	}
	
	@PostMapping("/register")
	public String registerEmp(@ModelAttribute(name="emp")Employee e, Model map)
	{
		System.out.println("in post registration");
		//e.setManagerId(mgrid);
		int id=empService.addEmp(e);
		
		if(id>0)
			map.addAttribute("msg","Employee Id "+id+" Registered Successfully");
		else
			map.addAttribute("msg","Employee Registration Failed. Please Retry");
				
		return "/Manager/empRegistered";
		
		
	}
	
	@GetMapping("/showLeaves")
	public String showLeaves(Model map)
	{
		System.out.println("in get viewleaves");
		Manager m = (Manager)session.getAttribute("user");
		List<Leave> viewLeave = leaveIntf.showLeaves(m.getEmpId());
		System.out.println(viewLeave);
		map.addAttribute("viewLeaves",viewLeave);
		return "/Manager/viewLeave";
		
	}
	
	@GetMapping("/permission")
	public String grantPage(@RequestParam String id, @RequestParam String status,HttpServletRequest request)
	{
		System.out.println("in mail "+ status);
		int Id=Integer.parseInt(id);
		char stat = status.charAt(0);
		System.out.println("in get leave id="+Id);
		int empId = leaveIntf.getEmpIdByLeaveId(Id);
		Employee e = empService.getEmp(empId);
		String name= e.getFirstName();
		String recipientAddress = e.getEmail();
		Manager m = (Manager)session.getAttribute("user");
		String mName= m.getFirstName();
		System.out.println("email send to"+recipientAddress);
		 String subject ="Response to your Leave request";
	     String message=null;
		if(leaveIntf.updateLeaveStatus(Id, stat))
			
		{
			if(stat=='A')
			{
	        message	="Hi"+" "+name+"\n"+"Your Leave has been approved."+ "\n"+"Regards"+"\n"+mName;
			}
			else
			{
		     message	="Your Leave has not been approved"+"\n"+mName;
			}
		}
		
		// creates a simple e-mail object
        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(recipientAddress);
        email.setSubject(subject);
        email.setText(message);
         
     // sends the e-mail
        mailSender.send(email);
        
		return "/Manager/grant";
		
		
	}
	
	
	@GetMapping("addNotice")
	public String showNoticeForm(Model map)
	{
		map.addAttribute("notice" ,new Notice());
		return "Manager/noticeForm";
		
	}
	
	@PostMapping("/addNotice")
	public String requestLeave (@ModelAttribute(name="notice")Notice n,Model map)
	{
		System.out.println("in post notice");
		int id = noticeSerIntf.addNotice(n);
		if(id>0)
		{
		map.addAttribute("msg","Notice Id "+id+" added Successfully");
		}
		else
			map.addAttribute("msg","Notice is not added,Please Retry....");
				
		return "/Manager/noticeAddResult";
		
		
	}
	
   @GetMapping("/deleteNotice")
	public String noticesForDelete(Model map)
	{
		System.out.println("in delete notice get page");
		Manager m = (Manager)session.getAttribute("user");
		List<Notice> list = noticeSerIntf.getNoticeByMngId(m.getEmpId());
		System.out.println(list);
		map.addAttribute("notices", list);
		return "Manager/noticesForDelete";
	
	}
	
	@GetMapping("/deleteNotice1")
	public String deleteNotice(@RequestParam int notices[],Model map)
	{
		//System.out.println("in delete get array:"+notices[0]+"  "+notices[1]);
		List<Integer> list = new ArrayList<Integer>();
		System.out.println("in delete notice1");
		for(int a:notices)
		{
			list.add(a);
			//s += (" "+a);
			
		}
		System.out.println("list values"+list);
		noticeSerIntf.deleteNotice(list);
		map.addAttribute("msg", "Notices deleted successfully");
		
		
		return "Manager/resultDeleteNotice";
	}

	
	@GetMapping("/showNotices")
	public String showNotices()
	{
	   return"redirect:/Employee/showNotices";
	}
	
	@GetMapping("/editProfile")
	public String editProfile(Model map)
	{
		System.out.println("In edit profile.");
		return "redirect:/General/editProfile";
	}
	
	@GetMapping("/showFeedback")
	public String showFeedback(Model map)
	{
		map.addAttribute("feed",new Feedback());
		map.addAttribute("flist",fService.getFeedback());
		return "/Manager/displayFeedback";
	}
	
	//*********task Operation*************************/
	

	@GetMapping("/addTask")
	public String showTaskForm(Task t,Model map,HttpServletRequest request,HttpSession session)
	{	
		//System.out.println(t.getAllocatedTo().getEmpId());
		System.out.println("In show task form............");
		Manager m=(Manager)session.getAttribute("user");
		System.out.println("manager is"+m);
		map.addAttribute("empList", empService.getEmployeeByMgrId(m.getEmpId()));
		return "/Manager/addTask";
	}
	
	@PostMapping("/addTask")
	public String allocateTask(Task t,Model map,
            @RequestParam CommonsMultipartFile fileUpload) throws Exception
	{		
		System.out.println("****************************************************");
		Manager m=(Manager)session.getAttribute("user");
		t.setAllocatedBy(m);
		t.setAllocatedOn(new Date());
		String saveDirectory="E:/Employee Management Task/Upload/";
		if(fileUpload !=null)
		{
			if(!fileUpload.getOriginalFilename().equals(""))
			{
				fileUpload.transferTo(new File(saveDirectory+fileUpload.getOriginalFilename()));
			}
		}
		System.out.println("In allocate Task...............");
		t.setStatus("NEWTASK");
        t.setTaskFile(fileUpload.getOriginalFilename());
		int taskId=tService.allotTask(t);
		if(taskId>0)
		{
			map.addAttribute("msg", "Task is added with Task ID:"+taskId);
		}
		else
		{
			map.addAttribute("msg", "Could not allocate task...Please retry ");
		}
		return "/Manager/taskAdded";
	}

	
	@GetMapping("/viewSubmittedTask")
	public String viewSubmittedTask(Model map)
	{	
		Manager m=(Manager)session.getAttribute("user");
		map.addAttribute("tasks", tService.viewSubmittedTask(m.getEmpId()));
		return "/Manager/viewSubmittedTask";
	}
	
	@GetMapping("/downloadSubmitedTask")
	public String downloadTask(@RequestParam String taskFileNm,HttpServletRequest request,HttpServletResponse response)throws Exception
	{
		System.out.println("In Manager upload task.................id:"+taskFileNm);
		final int BUFFER_SIZE = 4096;
		Manager m=(Manager)session.getAttribute("user");
		String fullPath="E:/Employee Management Task/ManagerId"+m.getEmpId()+"/"+taskFileNm;

		File downloadFile = new File(fullPath);
		FileInputStream inputStream = new FileInputStream(downloadFile);
		ServletContext context = request.getServletContext();
		String mimeType = context.getMimeType(fullPath);
		if (mimeType == null) 
		{
            mimeType = "application/octet-stream";
        }
		response.setContentType(mimeType);
        response.setContentLength((int) downloadFile.length());
        OutputStream outStream = response.getOutputStream();
        
        byte[] buffer = new byte[BUFFER_SIZE];
        int bytesRead = -1;
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            outStream.write(buffer, 0, bytesRead);
        }
        inputStream.close();
        outStream.close();

		return "/Manager/viewSubmittedTask";
	}
	
	
	@GetMapping("/taskSetToSuccessful")
	public String taskSetToSuccessful(@RequestParam int taskId,Model map)
	{
		System.out.println("In set to successful");
		tService.updateTaskStatus(taskId, "SUCCESSFUL");
		map.addAttribute("statusMsg", "Submitted");
		return "/Manager/showTaskStatusCompleted";	
	}
	
	@GetMapping("/taskSetToReassigned")
	public String taskSetToReassigned(@RequestParam int taskId,Model map)
	{
		System.out.println("In set to successful");
		tService.updateTaskStatus(taskId, "REASSIGNED");
		map.addAttribute("statusMsg", "Reassigned");
		return "/Manager/showTaskStatusCompleted";	
	}
	
	
	
	
	
	@GetMapping("/changePassword")
	public String changePassword()
	{
		return "redirect:/General/changePassword";
	}
	
	@RequestMapping("/logout")
	public String goToLogout()
	{
		return "redirect:/General/logout";
	}
}
