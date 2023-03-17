package com.springbootacademy.pointofsale.util.mappers;

import com.springbootacademy.pointofsale.dto.response.ItemGetDTO;
import com.springbootacademy.pointofsale.entity.Item;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemMapper {
    List<ItemGetDTO> entityListToDtoList(List<Item>items);
}
