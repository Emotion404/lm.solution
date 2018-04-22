package lm.solution.console.spring.spring.conditional;

import lm.solution.pojo.model.console.spring.spring.ListService;

public class LinuxListService implements ListService {

    @Override
    public String showListCmd() {

        return "ls";

    }

}
