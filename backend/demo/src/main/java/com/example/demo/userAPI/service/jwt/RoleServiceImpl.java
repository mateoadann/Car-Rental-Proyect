package com.example.demo.userAPI.service.jwt;
import com.example.demo.userAPI.dto.jwt.RoleDTO;
import com.example.demo.userAPI.persistance.entities.jwt.RoleEntity;
import com.example.demo.userAPI.persistance.repository.jwt.IRoleRepository;
import com.example.demo.util.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private IRoleRepository roleRepository;

    @Autowired
    private MapperUtil mapperUtil;


    @Override
    public List<RoleDTO> findAll() {
        return mapperUtil.mapAll(roleRepository.findAll(), RoleDTO.class);
    }

    @Override
    public RoleDTO findById(Long id) {
        return mapperUtil.map(roleRepository.findById(id), RoleDTO.class);
    }

    @Override
    public RoleDTO save(RoleDTO role) {
        return mapperUtil.map(roleRepository.save(mapperUtil.map(role, RoleEntity.class)), RoleDTO.class);
    }

    @Override
    public RoleDTO update(RoleDTO role, Long id) {
        RoleEntity roleUpdated = roleRepository.findById(id).orElse(null);
        if (roleUpdated == null) {
            // error
        }
        roleUpdated.setName(role.getName());
        roleUpdated.setEnable(role.getEnable());

        return mapperUtil.map(roleRepository.save(roleUpdated), RoleDTO.class);
    }

    @Override
    public RoleDTO delete(Long id) {
        RoleDTO roleDeleted = mapperUtil.map(roleRepository.findById(id), RoleDTO.class);
        roleRepository.delete(mapperUtil.map(roleDeleted, RoleEntity.class));
        return roleDeleted;
    }
}
