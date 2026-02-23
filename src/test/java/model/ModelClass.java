package model;

import java.util.ArrayList;
import java.util.List;

public class ModelClass
{
    private String welcomeMsg = "Welcome to the Dreams Section";
    private String loadingMsg = "Loading your dream portal...";
    private String exploreText = "Explore your dream journey";
    private final List<String> list = new ArrayList<>();

    public List<String> getList() {
        return list;
    }

    public void setList(String c1,String c2,String c3)
    {
        list.add(c1);
        list.add(c2);
        list.add(c3);
    }

    public String getExploreText() {
        return exploreText;
    }

    public void setExploreText(String exploreText) {
        this.exploreText = exploreText;
    }

    public String getLoadingMsg() {
        return loadingMsg;
    }

    public void setLoadingMsg(String loadingMsg) {
        this.loadingMsg = loadingMsg;
    }

    public String getWelcomeMsg() {
        return welcomeMsg;
    }

    public void setWelcomeMsg(String welcomeMsg) {
        this.welcomeMsg = welcomeMsg;
    }
}
