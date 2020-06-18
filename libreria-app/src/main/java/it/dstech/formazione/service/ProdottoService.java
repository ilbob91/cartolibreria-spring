package it.dstech.formazione.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import it.dstech.formazione.model.Prodotto;
import it.dstech.formazione.repository.ProdottoRepository;

@Service
@Transactional
public class ProdottoService {
@Autowired
private ProdottoRepository prodottoRepository;

public Prodotto save(Prodotto prodotto){
	return prodottoRepository.save(prodotto);
}
public List<Prodotto> listAll() {
	return (List<Prodotto>) prodottoRepository.findAll();
}

public Prodotto get(Long id) {
	return prodottoRepository.findById(id).get();
}

public void delete(Long id) {
	prodottoRepository.deleteById(id);
}

}
