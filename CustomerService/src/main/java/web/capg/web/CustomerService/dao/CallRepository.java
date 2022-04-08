package web.capg.web.CustomerService.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import web.capg.web.CustomerService.entity.Call;

@Repository
public interface CallRepository extends JpaRepository<Call , Integer>{

}
