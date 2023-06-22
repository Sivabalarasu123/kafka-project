package com.springboot.kafkaconsumer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.kafkaconsumer.entity.WikimediaData;

public interface WikimediaDataRepository extends JpaRepository<WikimediaData,Long>{

}
