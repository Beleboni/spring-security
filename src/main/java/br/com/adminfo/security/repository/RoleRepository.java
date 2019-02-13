package br.com.adminfo.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.adminfo.security.models.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{

}