package in.khalandar.runner;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import in.khalandar.Repository.CitizenPlanRepo;
import in.khalandar.entity.CitizenPlan;
@Component
public class DataLoader implements ApplicationRunner{
	@Autowired
	private CitizenPlanRepo citizenPlanRepo;
	@Override
	public void run(ApplicationArguments args) throws Exception{
		
		citizenPlanRepo.deleteAll();
		//cash plan
		CitizenPlan c1 = new CitizenPlan();
		c1.setCitizenName("john");
		c1.setGender("Male");
		c1.setPlanName("Cash");
		c1.setPlanStatus("Approved");
		c1.setPlanStartDate(LocalDate.now());
		c1.setPlanEndDate(LocalDate.now().plusMonths(6));
		c1.setBenfitAmt(5000.00);
		 
		CitizenPlan c2= new CitizenPlan();
		c2.setCitizenName("Smith");
		c2.setGender("Male");
		c2.setPlanName("Cash");
		c2.setPlanStatus("Denied");
		c2.setDenialReason("Rental income");
		
		CitizenPlan c3 = new CitizenPlan();
		c3.setCitizenName("Cathy");
		c3.setGender("Female");
		c3.setPlanName("Cash");
		c3.setPlanStatus("Terminated");
		c3.setPlanStartDate(LocalDate.now().minusMonths(6));
		c3.setPlanEndDate(LocalDate.now().plusMonths(6));
		c3.setBenfitAmt(5000.00);
		c3.setTerminatedDate(LocalDate.now());
		c3.setTerminationRsn("Employed");
		
		//Food plan
		CitizenPlan c4 = new CitizenPlan();
		c4.setCitizenName("David");
		c4.setGender("Male");
		c4.setPlanName("Food");
		c4.setPlanStatus("Approved");
		c4.setPlanStartDate(LocalDate.now());
		c4.setPlanEndDate(LocalDate.now().plusMonths(6));
		c4.setBenfitAmt(6000.00);
		
		CitizenPlan c5= new CitizenPlan();
		c5.setCitizenName("Robert");
		c5.setGender("Male");
		c5.setPlanName("Food");
		c5.setPlanStatus("Denied");
		c5.setDenialReason("Property income");
		
		CitizenPlan c6= new CitizenPlan();
		c6.setCitizenName("Orlen");
		c6.setGender("Female");
		c6.setPlanName("Food");
		c6.setPlanStatus("Terminated");
		c6.setPlanStartDate(LocalDate.now().minusMonths(6));
		c6.setPlanEndDate(LocalDate.now().plusMonths(6));
		c6.setBenfitAmt(5000.00);
		c6.setTerminatedDate(LocalDate.now());
		c6.setTerminationRsn("Employed");
		
		//Medical plan Data
		CitizenPlan c7 = new CitizenPlan();
		c7.setCitizenName("Charless");
		c7.setGender("Male");
		c7.setPlanName("Medical");
		c7.setPlanStatus("Approved");
		c7.setPlanStartDate(LocalDate.now());
		c7.setPlanEndDate(LocalDate.now().plusMonths(6));
		c7.setBenfitAmt(4000.00);
		 
		CitizenPlan c8= new CitizenPlan();
		c8.setCitizenName("Robert");
		c8.setGender("Male");
		c8.setPlanName("Medical");
		c8.setPlanStatus("Denied");
		c8.setDenialReason("Property income");
		
		CitizenPlan c9 = new CitizenPlan();
		c9.setCitizenName("Cathy");
		c9.setGender("Female");
		c9.setPlanName("Medical");
		c9.setPlanStatus("Terminated");
		c9.setPlanStartDate(LocalDate.now().minusMonths(6));
		c9.setPlanEndDate(LocalDate.now().plusMonths(6));
		c9.setBenfitAmt(5000.00);
		c9.setTerminatedDate(LocalDate.now());
		c9.setTerminationRsn("Govt job");
		//
		CitizenPlan c10 = new CitizenPlan();
		c10.setCitizenName("karan");
		c10.setGender("Male");
		c10.setPlanName("Employement");
		c10.setPlanStatus("Approved");
		c10.setPlanStartDate(LocalDate.now());
		c10.setPlanEndDate(LocalDate.now().plusMonths(6));
		c10.setBenfitAmt(7000.00);
		 
		CitizenPlan c11= new CitizenPlan();
		c11.setCitizenName("Sam");
		c11.setGender("Male");
		c11.setPlanName("Employement");
		c11.setPlanStatus("Denied");
		c11.setDenialReason("Rental income");
		
		CitizenPlan c12 = new CitizenPlan();
		c12.setCitizenName("queeny");
		c12.setGender("Female");
		c12.setPlanName("Employement");
		c12.setPlanStatus("Terminated");
		c12.setPlanStartDate(LocalDate.now().minusMonths(6));
		c12.setPlanEndDate(LocalDate.now().plusMonths(6));
		c12.setBenfitAmt(9000.00);
		c12.setTerminatedDate(LocalDate.now());
		c12.setTerminationRsn("Employed");
		
		
		List<CitizenPlan> list=Arrays.asList(c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12);
		citizenPlanRepo.saveAll(list); 
	}

}
