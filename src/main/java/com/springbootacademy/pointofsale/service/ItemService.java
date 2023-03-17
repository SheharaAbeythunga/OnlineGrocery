package com.springbootacademy.pointofsale.service;

import com.springbootacademy.pointofsale.dto.ItemDTO;
import com.springbootacademy.pointofsale.dto.paginated.PaginatedResponseGetItemsDTO;
import com.springbootacademy.pointofsale.dto.request.ItemSaveDTO;
import com.springbootacademy.pointofsale.dto.response.ItemGetDTO;

import java.util.List;

public interface ItemService{
    String saveItem(ItemSaveDTO itemSaveDTO);

    List<ItemGetDTO> searchItemByNameStatus(String itemName);

    List<ItemGetDTO> searchItemByNameStatusByMapstruct(String itemName);

    PaginatedResponseGetItemsDTO searchItemByNameStatusUsingPaginating(Boolean activeStatus, int page, int size);

    String deleteItem(int deleteId);
}
