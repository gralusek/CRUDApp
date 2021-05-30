package com.crud.tasks.mapper;

import com.crud.tasks.domain.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TrelloMapperTest {

    @Autowired
    private TrelloMapper trelloMapper;

    @Test
    void mapToBoards() {

        //Given
        TrelloBoardDto trelloBoardDto1 = new TrelloBoardDto("1", "test1", new ArrayList<>());
        TrelloBoardDto trelloBoardDto2 = new TrelloBoardDto("2", "test1", new ArrayList<>());
        List<TrelloBoardDto> list = new ArrayList<>();
        list.add(trelloBoardDto1);
        list.add(trelloBoardDto2);
        //When
        List<TrelloBoard> resultList = trelloMapper.mapToBoards(list);
        //Then
        assertEquals("test1",resultList.get(0).getName());
        assertEquals(2, resultList.size());
    }

    @Test
    void mapToBoardsDto() {
        //Given
        TrelloBoard trelloBoard1 = new TrelloBoard("1", "test1", new ArrayList<>());
        TrelloBoard trelloBoard2 = new TrelloBoard("2", "test2", new ArrayList<>());
        List<TrelloBoard> list = new ArrayList<>();
        list.add(trelloBoard1);
        list.add(trelloBoard2);
        //When
        List<TrelloBoardDto> resultList = trelloMapper.mapToBoardsDto(list);
        //Then
        assertEquals(2, resultList.size());
        assertEquals("1", resultList.get(0).getId());
    }

    @Test
    void mapToList() {
        //Given
        TrelloListDto trelloListDto1 = new TrelloListDto("1", "test1", false);
        TrelloListDto trelloListDto2 = new TrelloListDto("2", "test2", false);
        List<TrelloListDto> list = new ArrayList<>();
        list.add(trelloListDto1);
        list.add(trelloListDto2);
        //When
        List<TrelloList> resultList = trelloMapper.mapToList(list);
        //Then
        assertEquals(2, resultList.size());
        assertEquals("test2", resultList.get(1).getName());
    }

    @Test
    void mapToListDto() {
        //Given
        TrelloList trelloList1 = new TrelloList("1", "test1", false);
        TrelloList trelloList2 = new TrelloList("2", "test2", false);
        List<TrelloList> list = new ArrayList<>();
        list.add(trelloList1);
        list.add(trelloList2);
        //When
        List<TrelloListDto> resultList = trelloMapper.mapToListDto(list);
        //Then
        assertEquals(2, resultList.size());
        assertEquals("test1", resultList.get(0).getName());
    }

    @Test
    void mapToCardDto() {
        //Given
        TrelloCard trelloCard = new TrelloCard("testName", "test Description",
                "1", "1");
        //When
        TrelloCardDto result = trelloMapper.mapToCardDto(trelloCard);
        //Then
        assertEquals("test Description", result.getDescription());
    }

    @Test
    void mapToCard() {
        //Given
        TrelloCardDto trelloCardDto = new TrelloCardDto("name", "desc", "1", "1");
        //When
        TrelloCard result = trelloMapper.mapToCard(trelloCardDto);
        //Then
        assertEquals("1", result.getPos());
    }
}