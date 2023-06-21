package com.side.cooktime.domain.member.repository;

import com.side.cooktime.domain.member.model.Email;
import com.side.cooktime.domain.member.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByEmail(Email email);
}
