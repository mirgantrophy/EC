package io.valhala.ecenter.domain;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
@Transactional
public interface ClientRepository extends CrudRepository<Client, Long>
{
	List<Client> findBylastName(String lastName);
	
	List<Client> findByfirstName(String firstName);
}
