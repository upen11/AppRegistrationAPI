package com.company.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.company.entity.CitizenAppEntity;

@Repository
public interface CitizenAppRepository extends JpaRepository<CitizenAppEntity, Serializable>{

}
