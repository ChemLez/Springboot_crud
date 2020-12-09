package cn.lizhi.springboot_crud.mapper;

import cn.lizhi.springboot_crud.entity.Admin;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface AdminMapper extends Mapper<Admin> {
}