package online.portowyi.ppmtool.web;

import online.portowyi.ppmtool.domain.Project;
import online.portowyi.ppmtool.services.MapValidationErrorService;
import online.portowyi.ppmtool.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.xml.transform.sax.SAXTransformerFactory;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

    private ProjectService projectService;
    private MapValidationErrorService mapValidationErrorService;

    @Autowired
    public void setProjectService(ProjectService projectService) {
        this.projectService = projectService;
    }

    @Autowired
    public void setMapValidationErrorService(MapValidationErrorService mapValidationErrorService) {
        this.mapValidationErrorService = mapValidationErrorService;
    }

    @PostMapping
    public ResponseEntity<?> createNewProject(@Valid @RequestBody Project project, BindingResult bindingResult){

        ResponseEntity<?> responseEntity = mapValidationErrorService.MapValidationService(bindingResult);
        if (responseEntity != null) return responseEntity;
        return new ResponseEntity<Project>(projectService.saveOrUpdateProject(project), HttpStatus.CREATED);
    }

    @GetMapping("/{projectId}")
    public ResponseEntity<?> getProjectByProjectId(@PathVariable String projectId){
        Project project = projectService.findProjectByIdentifier(projectId);
        return new ResponseEntity<Project>(project, HttpStatus.OK);
    }

    @GetMapping("/all")
    public Iterable<Project> getAllProjects(){
        return projectService.findAllProjects();
    }

    @DeleteMapping("/{projectId}")
    public ResponseEntity<?> deleteProjectById(@PathVariable String projectId){
        projectService.deleteObjectById(projectId);
        return new ResponseEntity<String>("Проект с идентификатором '" + projectId + "' был удален", HttpStatus.OK);
    }

}