package com.example.demo;

import java.util.stream.IntStream;

import com.example.demo.domain.WebBoard;
import com.example.demo.persistence.WebBoardRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class WebBoardRepositoryTests {

    @Autowired
    WebBoardRepository repo;

    @Test
        public void insertBoardDummies(){
            IntStream.range(0, 300).forEach(i ->{

                WebBoard board = new WebBoard();

                board.setTitle("Sample Board Title " + i );
                board.setContent("Content Sample ..." + i + " of Board ");
                board.setWriter("user0" + (i % 10));

                repo.save(board);
            });
        }
}