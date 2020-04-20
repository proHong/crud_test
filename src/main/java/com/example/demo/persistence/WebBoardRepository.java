package com.example.demo.persistence;

import com.example.demo.domain.WebBoard;

import org.springframework.data.repository.CrudRepository;

public interface WebBoardRepository extends CrudRepository<WebBoard,Long> {

}