package com.springbootacademy.pointofsale.dto.paginated;

import com.springbootacademy.pointofsale.dto.response.ItemGetDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PaginatedResponseGetItemsDTO {
    List<ItemGetDTO> itemGetDTOList;
    long itemsCount;
}
