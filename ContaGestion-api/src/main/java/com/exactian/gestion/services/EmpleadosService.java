package com.exactian.gestion.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exactian.gestion.dto.EmpleadoDTO;
import com.exactian.gestion.mapper.EmpleadoMapper;
import com.exactian.gestion.repositories.EmpleadoRepository;

@Service
public class EmpleadosService {
	
	@Autowired
	private EmpleadoRepository empleadoRepository;
	@Autowired
	private EmpleadoMapper empleadoMapper;
	
	
	public List<EmpleadoDTO> listEmpleados() {
		
		return (List<EmpleadoDTO>)empleadoRepository.findAll().stream()
                .map(this.empleadoMapper::toDTO)
                .collect(Collectors.toList());
	}
	
	
	
}
