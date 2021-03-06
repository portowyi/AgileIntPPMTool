package online.portowyi.ppmtool.repositories;

import online.portowyi.ppmtool.domain.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {

    Project findByProjectIdentifier(String s);



}
