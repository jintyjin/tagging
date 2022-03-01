package com.ai.tagging.repository.event;

import com.ai.tagging.entity.event.box.Box;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoxRepository extends JpaRepository<Box, Long> {
}
