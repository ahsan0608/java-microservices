package com.ahsan.spam;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpamCheckHistoryRepository extends JpaRepository<SpamCheckHistory,Integer> {
}
