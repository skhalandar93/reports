package in.khalandar.service;

import java.util.List;

import in.khalandar.entity.CitizenPlan;
import in.khalandar.request.SearchRequest;

public interface ReportService {
	
	public List<String> getPlanNames() ;
	
	public List<String> getPlanStatus();
	
	public List<CitizenPlan> search(SearchRequest request);
	
	public Boolean exportExcel();
	
	public Boolean exportPdf();
	
}
