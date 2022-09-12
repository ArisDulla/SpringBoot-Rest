package gr.hua.dit.distributedsystems.repository;

import gr.hua.dit.distributedsystems.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path="students")
public interface FormRepository extends JpaRepository<Application, Integer> {
}
