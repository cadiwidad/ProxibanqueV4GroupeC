package com.jit.proxiBanqueV4.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jit.proxiBanqueV4.entites.Operation;

public interface IOperationDao extends JpaRepository<Operation, Long> {

}
