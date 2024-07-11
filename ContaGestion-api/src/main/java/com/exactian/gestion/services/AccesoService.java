package com.exactian.gestion.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exactian.gestion.dto.AccesoDTO;
import com.exactian.gestion.mapper.AccesoMapper;
import com.exactian.gestion.repositories.AccesoRepository;

@Service
public class AccesoService {
	
	@Autowired
	private AccesoRepository accesoRepository;
	@Autowired
	private AccesoMapper accesoMapper;

	public List<AccesoDTO> listarHistorico() {

		return (List<AccesoDTO>)accesoRepository.findAll().stream()
                .map(this.accesoMapper::toDTO)
                .collect(Collectors.toList());
		
	}

	
	

}
