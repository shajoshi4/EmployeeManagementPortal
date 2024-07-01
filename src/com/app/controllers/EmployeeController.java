package com.app.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.app.pojos.Employee;
import com.app.pojos.Feedback;
import com.app.pojos.Leave;
import com.app.services.FeedbackServiceIntf;
import com.app.services.LeaveServiceIntf;
import com.app.services.PersonServiceIntf;
import com.app.services.TaskServiceIntf;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Controller
@RequestMapping("/Employee")
public class EmployeeController {
	
	@Autowired
	private LeaveServiceIntf leaveService;
	@Autowired
	private HttpSession session;
	@Autowired
	private FeedbackServiceIntf fService;
	@Autowired
	private PersonServiceIntf pService;
	@Autowired
	private TaskServiceIntf tservice;
	@GetMapping("/leave")
	public String showLeaveForm(Model map)
	{
		map.addAttribute("leave" ,new Leave());
		return "Employee/leave";
		
	}
	
	@PostMapping("/leave")
	public String requestLeave (@ModelAttribute(name="leave")Leave l,Model map)
	{
		System.out.println("in post leave");
		int id = leaveService.addLeave(l);
		if(id>0)
		{
			return "Employee/requestedLeave";
		}
		
		else
		{
			return "Employee/leave";
		}
		
		
	}
	
	@GetMapping("/editProfile")
	public String editProfile(Model map)
	{
		System.out.println("In edit profile.");
		return "redirect:/General/editProfile";
	}
	
	@GetMapping("/feedback")
	public String showFeedback(Model map)
	{
		map.addAttribute("feed",new Feedback());
		return "/Employee/feedback";
	}
	
	@PostMapping("/feedback")
	public String giveFeedback(@ModelAttribute(name="feed")Feedback f,Model map)
	{
		int id=fService.addFeedback(f);
		if(id>0)
			map.addAttribute("msg","Feedback submitted successfully!");
		else
			map.addAttribute("msg","Feedback submittion failed. Please Retry");
		return "/Employee/feedbackSubmit";
	}
	
	/***************Task operation**************************/
	
	@GetMapping("/showAllotedTask")
	public String showAllocatedTask(Model map,HttpSession session)
	{
		System.out.println("In Employee show allocated tasks ......");
		Employee emp=(Employee)session.getAttribute("user");
		System.out.println(emp);
		//System.out.println(emp.getEmpId()+" "+emp.getEmail());
		
		//Here, we are getting list from tservice.viewAllotedTask(2) method and we are putting list 
		//into model map
		Employee e=(Employee)session.getAttribute("user");

		map.addAttribute("list",tservice.viewAllotedTask(e.getEmpId()));
		return "/Employee/showAllotedTask";
	}
	
	
	
	@GetMapping("/downloadTask")
	public String uploadTask(@RequestParam int taskId,@RequestParam String taskFileNm,HttpServletRequest request,HttpServletResponse response)throws Exception
	{
		System.out.println("In upload task.................id:"+taskFileNm);
		final int BUFFER_SIZE = 4096;
		String fullPath="E:/Employee Management Task/Upload/"+taskFileNm;
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
        tservice.updateTaskStatus(taskId, "INPROCESS");
        inputStream.close();
        outStream.close();

		return "/Employee/taskLinkMsg";
	}
	
	
	@PostMapping("/submitTask")
	public String submitTask(@RequestParam int taskId,@RequestParam int empId,@RequestParam CommonsMultipartFile fileUpload) throws Exception
	{
		System.out.println("In submit task.................id:"+taskId);
		tservice.updateResponseFile(taskId, fileUpload.getOriginalFilename());
        tservice.updateTaskStatus(taskId, "SUBMITTED");
		Employee e=(Employee)session.getAttribute("user");
		String saveDirectory="E:/Employee Management Task/ManagerId"+e.getManagerId()+"/";	
		if(fileUpload !=null)
		{
			if(!fileUpload.getOriginalFilename().equals(""))
			{
				fileUpload.transferTo(new File(saveDirectory+fileUpload.getOriginalFilename()));
			}
		}
		return "/Employee/taskLinkMsg";
	}
	
	
	
	/*@GetMapping("/showNotices")
	public String showLeaves(Model map)
	{
		System.out.println("in get showNotices");
		Person p = (Person)session.getAttribute("user");
		List<Notice> showNotices = noticeSerIntf.getNoticeByDeptId(p.getDept().getDeptId());
		map.addAttribute("viewNotices",showNotices);
		return "/Employee/viewNotices";
		
	}*/
	

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
