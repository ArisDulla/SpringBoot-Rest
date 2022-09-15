package gr.hua.dit.distributedsystems.repository;

import gr.hua.dit.distributedsystems.entity.Authorities;
import gr.hua.dit.distributedsystems.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(path="authorities")
public interface AuthorityRepository  extends JpaRepository<Authorities, User> {

}
