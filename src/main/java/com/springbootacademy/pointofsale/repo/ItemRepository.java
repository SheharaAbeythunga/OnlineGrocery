package com.springbootacademy.pointofsale.repo;

import com.springbootacademy.pointofsale.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
@EnableJpaRepositories
public interface ItemRepository extends JpaRepository<Item,Integer> {
    Item findItemByActiveStateIsFalseAndItemNameEquals(String itemName);
    List<Item> findByActiveStateEqualsAndItemNameEquals(boolean status, String itemName);
}
