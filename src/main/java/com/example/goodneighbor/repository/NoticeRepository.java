package com.example.goodneighbor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.goodneighbor.entity.NoticeEntity;

public interface NoticeRepository extends JpaRepository<NoticeEntity, Long> {

}
