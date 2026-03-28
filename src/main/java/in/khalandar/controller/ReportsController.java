package in.khalandar.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import in.khalandar.request.SearchRequest;
import in.khalandar.service.ReportsServiceImpl;
import in.khalandar.utils.EmailUtils;

@Controller
public class ReportsController {
	
	@Autowired
	private ReportsServiceImpl serviceImpl;
	
	@Autowired
    private EmailUtils emailUtils;
	
	@PostMapping("/search")
	public String hanleSearch(SearchRequest request, Model model){
		System.out.println(request);
//		List<CitizenPlan> plans=serviceImpl.search(request);
		model.addAttribute("plans", serviceImpl.search(request));
		init(model);
		return "index";
	}
	@RequestMapping("/")
	public String indexPage(Model model) {
		init(model);
		return "index";
	}	
	private void init(Model model) {
		SearchRequest searchObj = new SearchRequest();
		model.addAttribute("search", searchObj);
		model.addAttribute("names", serviceImpl.getPlanNames());
		model.addAttribute("status", serviceImpl.getPlanStatus());
	}
	@GetMapping("/reset")
	public String clearForm(Model model) {
	    model.addAttribute("search", new SearchRequest());
	    return "index"; // Change as needed
	}

	@RequestMapping("/E-Mail")
	public void emailSender() {
		try {
		emailUtils.SendEmailWithHyperLink("s.khalandar93@gmail.com","search ", "http://localhost:8080/search",    "Click here to view the report");
	}catch (Exception e) {
		e.printStackTrace();
		// TODO: handle exception
	}	
}
}
