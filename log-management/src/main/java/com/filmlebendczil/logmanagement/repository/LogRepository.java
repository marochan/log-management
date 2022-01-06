package com.filmlebendczil.logmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.filmlebendczil.logmanagement.entities.Log;

@Repository
public interface LogRepository extends JpaRepository<Log, Long> {

}
