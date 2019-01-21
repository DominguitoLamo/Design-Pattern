package strategy.action;

import java.util.HashMap;

public interface Find {

    public void findbyPage(String url);

    public HashMap<String,String> findbyHashMap(HashMap<String,String> hashMap);

}
