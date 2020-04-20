package com.example.demo.persistence;

import com.example.demo.domain.QWebBoard;
import com.example.demo.domain.WebBoard;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

public interface WebBoardRepository extends CrudRepository<WebBoard,Long>, QuerydslPredicateExecutor<WebBoard> {

    public default Predicate makePredicate(String type, String keyword){

        BooleanBuilder builder = new BooleanBuilder();

        QWebBoard board = QWebBoard.webBoard;

        // type if ~ else

        // bno > 0
        builder.and(board.bno.gt(0));

        return builder;
    }

}