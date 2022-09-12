package gr.hua.dit.distributedsystems.repository;


import gr.hua.dit.distributedsystems.entity.AuthPK;
import gr.hua.dit.distributedsystems.entity.Authorities;
import org.springframework.data.jpa.repository.JpaRepository;
public interface AuthorityRepository  extends JpaRepository<Authorities, AuthPK> {
}
