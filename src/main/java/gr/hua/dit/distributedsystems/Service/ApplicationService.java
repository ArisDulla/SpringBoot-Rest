package gr.hua.dit.distributedsystems.Service;

import gr.hua.dit.distributedsystems.entity.Application;
import gr.hua.dit.distributedsystems.repository.FormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApplicationService {

    @Autowired private FormRepository repo ;

    public List<Application> listAll(){
        
        return (List<Application>) repo.findAll();

    }

    public void save(Application application) {

        repo.save(application);
    }

    public void changeEn(Integer id) {

        Optional<Application> result = repo.findById(id);
        result.get().setEnabled(true);
        repo.save(result.get());

        System.out.println();
    }

    public void changeEn2(Integer id) {

        Optional<Application> result = repo.findById(id);
        result.get().setEnabled2(true);
        repo.save(result.get());
    }

    public void setDDD(Integer id , String user) {
        Optional<Application> result = repo.findById(id);
        result.get().setInfo(user);
        repo.save(result.get());

    }
}
