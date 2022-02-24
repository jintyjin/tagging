package com.ai.tagging.repository;

import com.ai.tagging.entity.Live;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LiveRepository extends JpaRepository<Live, Long> {
}
