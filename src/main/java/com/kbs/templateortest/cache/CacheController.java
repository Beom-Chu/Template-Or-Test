package com.kbs.templateortest.cache;

import com.kbs.templateortest.cache.entity.OrderEntity;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 데이터 변경이 잦지 않고 반복적으로 같은 데이터를 조회하는 경우 매번 DB에 접근하지 않고 캐싱으로 처리
 *
 * 주의 사항
 * 1. application에 @EnableCaching 필수
 * 2. pulbic method에만 사용가능
 * 3. 같은 객체 내의 method끼리 호출 시에는 @Cacheable이 설정되어있어도 캐싱되지 않음
 */

@RestController
public class CacheController {

    @GetMapping("/order/menu")
    @Cacheable(value = "menu") /* 캐시 저장 */
    public List<OrderEntity> getOrderMenu(){
        System.out.println("메뉴 조회 / 캐시 저장 ");

        /* 테스트 용으로 DB 조회 대신 객체 생성으로 처리 */
        List<OrderEntity> menu = new ArrayList<>();
        menu.add(new OrderEntity(1,"order1",1000,2));
        menu.add(new OrderEntity(2,"order2",1500,4));
        menu.add(new OrderEntity(3,"order3",3000,1));

        return menu;
    }

    @GetMapping("/order/menu/put")
    @CachePut(value = "menu") /* 캐시 갱신 */
    public List<OrderEntity> updateMenu(){
        System.out.println("메뉴 수정 / 캐시 업데이트");

        /* 테스트 용으로 DB 조회 대신 객체 생성으로 처리 */
        List<OrderEntity> menu = new ArrayList<>();
        menu.add(new OrderEntity(1,"order11",1001,3));
        menu.add(new OrderEntity(2,"order22",1502,5));
        menu.add(new OrderEntity(3,"order33",3003,2));

        return menu;
    }

    @GetMapping("/order/menu/delete")
    @CacheEvict(value = "menu", allEntries = true) /* 캐시 삭제 */
    public String deleteMenu(){
        System.out.println("캐시 삭제");
        return "삭제 완료";
    }
}
