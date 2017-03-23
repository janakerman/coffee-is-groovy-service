package com.janakerman.repository

import com.janakerman.entity.Role
import org.springframework.data.jpa.repository.JpaRepository

interface RoleRepository extends JpaRepository<Role, Integer> {}