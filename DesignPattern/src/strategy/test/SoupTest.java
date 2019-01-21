package strategy.test;

import strategy.action.Find;
import strategy.actionImpl.HyperLinkFinder;
import strategy.controller.SoupController;

public class SoupTest {
    public static void main(String[] args){
        SoupController soupController = new SoupController();
        Find find = new HyperLinkFinder();
        soupController.setFinder(find);
        soupController.findbyPage("https://blog.csdn.net/zhangfengBX/article/details/76783348");

    }
}
