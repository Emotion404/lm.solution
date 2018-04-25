package lm.solution.console.spring.spring.conditional;

import lm.solution.pojo.model.console.spring.spring.ListService;

public class WindowsListService implements ListService {

    @Override
    public String showListCmd() {

        return "dir";

    }

}
