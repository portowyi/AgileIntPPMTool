package online.portowyi.ppmtool.services;

import online.portowyi.ppmtool.domain.Project;
import online.portowyi.ppmtool.exceptions.ProjectIdException;
import online.portowyi.ppmtool.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    private ProjectRepository projectRepository;

    @Autowired
    public void setProjectRepository(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public Project saveOrUpdateProject(Project project){
        try {
            project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
            return projectRepository.save(project);
        } catch (Exception exception) {
            throw new ProjectIdException(
                    "Project ID '" + project.getProjectIdentifier().toUpperCase() + "' already exist"
            );
        }
    }

    public Project findProjectByIdentifier(String projectId){
        return projectRepository.findByProjectIdentifier(projectId);
    }
}
