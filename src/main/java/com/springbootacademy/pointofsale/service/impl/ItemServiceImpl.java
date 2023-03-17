package com.springbootacademy.pointofsale.service.impl;

import com.springbootacademy.pointofsale.dto.ItemDTO;
import com.springbootacademy.pointofsale.dto.paginated.PaginatedResponseGetItemsDTO;
import com.springbootacademy.pointofsale.dto.request.ItemSaveDTO;
import com.springbootacademy.pointofsale.dto.response.ItemGetDTO;
import com.springbootacademy.pointofsale.entity.Item;
import com.springbootacademy.pointofsale.repo.ItemRepository;
import com.springbootacademy.pointofsale.service.ItemService;
import com.springbootacademy.pointofsale.util.mappers.ItemMapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ItemMapper itemMapper;
    @Override
    public String saveItem(ItemSaveDTO itemSaveDTO) {
        Item item = modelMapper.map(itemSaveDTO, Item.class);

        if (!itemRepository.existsById(item.getItemId())) {

            itemRepository.save(item);

            return item.getItemName() + " saved successfully.";
        } else {
            throw new DuplicateKeyException("Already added ");
        }
    }
//modelMapperMethod
    @Override
    public List<ItemGetDTO> searchItemByNameStatus(String itemName) {
        boolean status = true;
        List<Item> itemList = itemRepository.findByActiveStateEqualsAndItemNameEquals(status, itemName);

        if (itemList.size() > 0) {
            List<ItemGetDTO> itemGetDTO=modelMapper.map(itemList,new TypeToken<List<ItemGetDTO>>(){}.getType());
            return itemGetDTO;
        } else {
throw new RuntimeException("Item is not active.");
        }

    }
//method by mapstruct
    @Override
    public List<ItemGetDTO> searchItemByNameStatusByMapstruct(String itemName) {
        boolean status = true;
        List<Item> itemList = itemRepository.findByActiveStateEqualsAndItemNameEquals(status, itemName);

        if (itemList.size() > 0) {
            List<ItemGetDTO> itemGetDTO=itemMapper.entityListToDtoList(itemList);
            return itemGetDTO;
        } else {
            throw new RuntimeException("Item is not active.");
        }
    }

    @Override
    public PaginatedResponseGetItemsDTO searchItemByNameStatusUsingPaginating(Boolean activeStatus, int page, int size) {
        return null;
    }

    @Override
    public String deleteItem(int deleteId) {
        itemRepository.deleteById(deleteId);
        return "deleted "+deleteId;
    }
}
