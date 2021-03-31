package com.example.sunsetstudy;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

public class GlobalVars extends Application {
    private List<Project> projectsList = new ArrayList<>();


    public List<Project> getProjectsList() {
        return projectsList;
    }

    public void addProject(Project project) {
        this.projectsList.add(project);
    }

    /**
     * removes a project from projects list
     * @param name name of project to remove
     * @return 0 for success
     */
    public int removeProject(String name){
        for (Project proj:projectsList){
            if(proj.projectName.equals(name)){
                projectsList.remove(proj);
                return 0;   //Name found successfully
            }
        }
        return 2; //Name not found
    }
}
