package com.springbootacademy.pointofsale.controller;
import com.springbootacademy.pointofsale.dto.paginated.PaginatedResponseGetItemsDTO;
import com.springbootacademy.pointofsale.dto.request.ItemSaveDTO;
import com.springbootacademy.pointofsale.dto.response.ItemGetDTO;
import com.springbootacademy.pointofsale.service.ItemService;
import com.springbootacademy.pointofsale.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/item")
@CrossOrigin
public class ItemController {
    @Autowired
    private ItemService itemService;
    //    @PostMapping("/save")
//    public String saveItem(@RequestBody ItemSaveDTO itemSaveDTO){
//        itemService.saveItem(itemSaveDTO);
//        return "saved item";
//    }
    @PostMapping("/save")
    public ResponseEntity<StandardResponse> saveItem(@RequestBody ItemSaveDTO itemSaveDTO) {
        String message=itemService.saveItem(itemSaveDTO);
       // this is correct.but not very much good
//        ResponseEntity<StandardResponse> response=new ResponseEntity<StandardResponse>(
//                new StandardResponse(201,"success",message),
//                HttpStatus.CREATED
//                );
//        return response;

        //this is best
         return new ResponseEntity<StandardResponse>(
                 new StandardResponse(201,"success",message),
                 HttpStatus.CREATED);
    }

    @GetMapping(value = "/search-item-by-name-status", params = "itemName")
    public List<ItemGetDTO> searchItemByNameStatus(@RequestParam(value = "itemName") String itemName) {
        List<ItemGetDTO> itemGetDTOList = itemService.searchItemByNameStatus(itemName);
        return itemGetDTOList;
    }

    @GetMapping(value = "/search-item-by-name-status-by-mapstruct", params = "itemName")
    public List<ItemGetDTO> searchItemByNameStatusByMapstruct(@RequestParam(value = "itemName") String itemName) {
        List<ItemGetDTO> itemGetDTOList = itemService.searchItemByNameStatusByMapstruct(itemName);
        return itemGetDTOList;
    }
    //paginating
    @GetMapping(value = "/get-items-by-status-using-paginating",
            params ={ "activeStatus","page","size"}
    )
    public ResponseEntity<StandardResponse> searchItemByNameStatusUsingPaginating(
            @RequestParam(value = "activeStatus") Boolean activeStatus,
            @RequestParam(value = "page") int page,
            @RequestParam(value = "size") int size)
    {
        //List<ItemGetDTO> itemGetDTOList = itemService.searchItemByNameStatusUsingPaginating(activeStatus,page,size);
        PaginatedResponseGetItemsDTO paginatedResponseGetItemsDTO = itemService.searchItemByNameStatusUsingPaginating(activeStatus,page,size);

        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"success",paginatedResponseGetItemsDTO),
                HttpStatus.OK);
    }
    @DeleteMapping(value="/delete-item", params="deleteId")
    public ResponseEntity<StandardResponse> deleteItem(@RequestParam(value = "deleteId") int deleteId){
        String message=itemService.deleteItem(deleteId);

        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201,"success",message),
                HttpStatus.OK
        );
    }
}
