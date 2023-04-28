package com.example.goodneighbor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.goodneighbor.entity.MemberEntity;


public interface MemberRepository extends JpaRepository<MemberEntity, Long> {


}
