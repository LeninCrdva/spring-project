package eduv.tecazuay.tec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import eduv.tecazuay.tec.repository.IGenericRepository;

public class GenericServiceImpl<T> implements IGenericService<T>{

	@Autowired
	private IGenericRepository<T> genericRepository;

	@Override
	public List<T> findAll() {
		return genericRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public T findById(String id) {
		return genericRepository.findById(id).orElseThrow(() -> new RuntimeException("Not Found."));
	}

	@Override
	@Transactional
	public T save(T entity) {
		return genericRepository.save((T) entity);
	}

	@Override
	@Transactional
	public void delete(String id) {
		genericRepository.deleteById(id);
	}
}
