package com.example.demo.service;

import com.example.demo.entity.Board;

import java.util.List;

public interface BoardService {
    public void register(Board board) throws Exception;

    public Board read(Integer boardNo) throws Exception;

    public void modify(Board board) throws Exception;

    public void remove(Integer boardNo) throws Exception;

    public List<Board> list() throws Exception;
}
