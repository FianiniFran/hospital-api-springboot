package apiRest.hospital.services;

import org.springframework.data.domain.Pageable;

import apiRest.hospital.entities.Turn;

import org.springframework.data.domain.Page;


public interface ITurnService {
	public Page<Turn> turnList(Pageable pageable);
	public Turn getTurn(int id);
	public Turn saveTurn(Turn turn);
	public void deleteTurn(int id);
}
