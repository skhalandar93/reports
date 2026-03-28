package in.khalandar.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import in.khalandar.Repository.CitizenPlanRepo;
import in.khalandar.entity.CitizenPlan;
import in.khalandar.request.SearchRequest;
import jakarta.persistence.criteria.Predicate;


@Service
public class ReportsServiceImpl implements ReportService {
	
	@Autowired
	private CitizenPlanRepo planRepo;
	
	
	@Override
	public List<String> getPlanNames() {
		return planRepo.getPlanNames();
	}

	@Override
	public List<String> getPlanStatus() {
		return planRepo.getPlanStatus();
	}

	@Override
	public List<CitizenPlan> search(SearchRequest request) {
		Specification<CitizenPlan> spec = (root, query, cb) -> {
	        List<Predicate> predicates = new ArrayList<>();

	        if (request.getPlanName() != null && !request.getPlanName().isEmpty()) {
	            predicates.add(cb.equal(root.get("planName"), request.getPlanName()));
	        }

	        if (request.getPlanStatus() != null && !request.getPlanStatus().isEmpty()) {
	            predicates.add(cb.equal(root.get("planStatus"), request.getPlanStatus()));
	        }

	        if (request.getGender() != null && !request.getGender().isEmpty()) {
	            predicates.add(cb.equal(root.get("gender"), request.getGender()));
	        }

	        if (request.getStartDate() != null) {
	            predicates.add(cb.greaterThanOrEqualTo(root.get("planStartDate"), request.getStartDate()));
	        }

	        if (request.getEndDate() != null) {
	            predicates.add(cb.lessThanOrEqualTo(root.get("planEndDate"), request.getEndDate()));
	        }

	        return cb.and(predicates.toArray(new Predicate[0]));
	    };

	    return planRepo.findAll(spec);
	}


	@Override
	public Boolean exportExcel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean exportPdf() {
		// TODO Auto-generated method stub
		return null;
	}

}
