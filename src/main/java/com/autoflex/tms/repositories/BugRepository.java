package com.autoflex.tms.repositories;

import com.autoflex.tms.entities.Bug;
import com.autoflex.tms.entities.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BugRepository extends JpaRepository<Bug, Long>{
    List<Bug> findByStatusAndUrgent(Status status, boolean urgent);
    List<Bug> findByUrgentAndDetectedVersion(boolean urgent, String detectedVersion);
    List<Bug> findByUrgentAndImportantAndDetectedVersion(boolean urgent, boolean important, String detectedVersion);
}