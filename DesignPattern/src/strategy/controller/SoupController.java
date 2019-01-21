package strategy.controller;

import strategy.action.Find;

public class SoupController {
    private Find find;

    public void setFinder(Find find){
        this.find = find;
    }

    public void findbyPage(String url){
        find.findbyPage(url);
    }
}
