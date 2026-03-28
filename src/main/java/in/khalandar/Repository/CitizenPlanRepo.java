package in.khalandar.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import in.khalandar.entity.CitizenPlan;


public interface CitizenPlanRepo extends JpaRepository<CitizenPlan, Integer>, JpaSpecificationExecutor<CitizenPlan>{
	
	@Query("SELECT DISTINCT(planName) FROM CitizenPlan")
	public List<String> getPlanNames() ;
	
	@Query("SELECT DISTINCT(planStatus) FROM CitizenPlan")
	public List<String> getPlanStatus();
	
	

}
