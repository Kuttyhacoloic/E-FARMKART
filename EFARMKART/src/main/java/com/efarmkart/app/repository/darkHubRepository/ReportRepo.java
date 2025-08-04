package com.efarmkart.app.repository.darkHubRepository;

import java.lang.foreign.Linker.Option;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.efarmkart.app.model.darkHubModel.Report;

@Repository
public interface ReportRepo extends JpaRepository<Report, Long> {
	public Optional<List<Report>> findByType(String type);
	public List<Report> findByDate(LocalDate generatedOn);
}
