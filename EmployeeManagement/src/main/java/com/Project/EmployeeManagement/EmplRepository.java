package com.Project.EmployeeManagement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface EmplRepository extends JpaRepository<EmplEntity,Long> {



    
}
