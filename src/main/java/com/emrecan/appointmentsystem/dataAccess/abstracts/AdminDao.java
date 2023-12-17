package com.emrecan.appointmentsystem.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emrecan.appointmentsystem.entities.Admin;

public interface AdminDao extends JpaRepository<Admin, String>{

}
