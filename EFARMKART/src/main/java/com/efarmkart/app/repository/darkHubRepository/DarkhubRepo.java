package com.efarmkart.app.repository.darkHubRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.efarmkart.app.model.darkHubModel.DarkHub;

import jakarta.transaction.Transactional;

@Repository
public interface DarkhubRepo extends JpaRepository<DarkHub, Long> {
    List<DarkHub> findByIsActive(boolean isActive); 
	Optional<DarkHub> findByName(String name); 
	
	    @Modifying
	    @Transactional
	    @Query("UPDATE DarkHub dh SET dh.isActive = :isActive WHERE dh.name = :name")
	    int updateHubStatusByName(@Param("name") String name, @Param("isActive") boolean isActive);
	}


