package com.horrordb.jpa;

import com.horrordb.entity.WebSeries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WebRepository extends JpaRepository<WebSeries, Long> {
    List<WebSeries> findByNameContaining(String name);
}
