package com.example.demo.persistence;

import org.springframework.data.repository.CrudRepository;
import com.example.demo.domain.WebBoard;

public interface CustomCrudRepository extends CrudRepository<WebBoard, Long>, CustomWebBoard {

}