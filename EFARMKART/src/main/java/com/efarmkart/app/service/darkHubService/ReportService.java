package com.efarmkart.app.service.darkHubService;

import java.lang.foreign.Linker.Option;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.efarmkart.app.model.darkHubModel.Report;
import com.efarmkart.app.repository.darkHubRepository.ReportRepo;

@Service
public class ReportService {
	
	@Autowired
	private ReportRepo reportrepo;
	
	public List<Report> getAll()
	{
		return reportrepo.findAll();
		
	}
	
	public Report createReport(Report report) {
		return reportrepo.save(report);
	}
	
	public Optional<Report> findById(Long id) {
		return reportrepo.findById(id);
	}
	
	public Optional<Report> findByType(String type) {
	    Optional<List<Report>> reportsOpt = reportrepo.findByType(type);
	    return reportsOpt.flatMap(list -> list.stream().findFirst());
	}

	public  List<Report> findByDate(LocalDate generatedOn){
		return reportrepo.findByDate(generatedOn);
	}
	
	public void delete(Long id) {
		reportrepo.deleteById(id);
	}
}
