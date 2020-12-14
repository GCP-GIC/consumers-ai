package com.cts.consumers.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cts.consumers.entity.ConsumerQuery;

@Repository
public interface ConsumerQueryRepository extends JpaRepository<ConsumerQuery, Integer> {
	@Query("SELECT g FROM ConsumerQuery g where g.consumerId = :consumerId")
	public ConsumerQuery findByConsumerID(@Param("consumerId") String consumerId);
}