package upm.prof.webcrawler.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import upm.prof.webcrawler.entity.Type;
import upm.prof.webcrawler.exceptions.AlreadyExistsException;
import upm.prof.webcrawler.exceptions.BadRequestException;
import upm.prof.webcrawler.repository.TypeRepository;

@Service
public class TypeService {
	
	@Autowired
	public TypeRepository typeRepository;
	
	public List<Type> getAllDemoType(){
		return typeRepository.findAll();
	}
	
	public Type getTypeById(int id) {
		return typeRepository.findTypeById(id);
	}
	
	public Type saveType(Type type) throws BadRequestException, AlreadyExistsException {
		if(type.getName()==null) {
			throw new BadRequestException("Rellene todos los campos obligatorios.");
		}
		
		if(typeRepository.findTypeById(type.getId())!=null)
		{
			throw new AlreadyExistsException("Ya existe un usuario con ese id.");
		}
		
		return typeRepository.save(type);
		}
}
