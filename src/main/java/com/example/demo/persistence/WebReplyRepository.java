package com.example.demo.persistence;

import java.util.List;

import com.example.demo.domain.WebBoard;
import com.example.demo.domain.WebReply;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface WebReplyRepository extends CrudRepository<WebReply, Long>{

    @Query("SELECT r FROM WebReply r WHERE r.board = ?1" + " AND r.rno > 0 ORDER BY r.rno ASC")
    public List<WebReply> getRepliesOfBoard(WebBoard board);
}