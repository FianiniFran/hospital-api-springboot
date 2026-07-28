package apiRest.hospital.service;

import org.springframework.data.domain.Pageable;

import apiRest.hospital.dto.TurnDTO;

import org.springframework.data.domain.Page;


public interface ITurnService {
	public Page<TurnDTO> turnList(Pageable pageable);
	public TurnDTO getTurn(int id);
	public TurnDTO saveTurn(TurnDTO turnDto);
	public void deleteTurn(int id);
	public Boolean existsById(int id);
}
