package strategy.actionImpl;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import strategy.action.Find;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class HyperLinkFinder implements Find {

    private HashMap<String, String> urlHashMap;
    private Queue<URL> urldeque;

    public HyperLinkFinder(){
        this.urlHashMap = new HashMap<>();
    }

    public void findbyPage(String url){
        if(urlHashMap.size() > 0){
            urlHashMap.clear();
        }
        try {
            Document document = Jsoup.connect(url).get();
            Elements elements = document.getElementsByTag("a");
            for (Element element : elements) {
                String linkText = element.text();
                String linkHref = element.attr("href");
                System.out.println(linkText + " : " + linkHref);
                urlHashMap.put(linkText, linkHref);
            }
        }catch (IOException ex){
            System.err.println("Not data connection. please check the connection");
            ex.printStackTrace();
        }
    }

    public HashMap<String,String> findbyHashMap(HashMap<String,String> hashMap){
        HashMap<String,String> resultmap = new HashMap<>();
        for(String url:hashMap.values()){
            try {
                Document document = Jsoup.connect(url).get();
                Elements elements = document.getElementsByTag("a");
                for (Element element : elements) {
                    String linkText = element.text();
                    String linkHref = element.attr("href");
                    resultmap.put(linkText, linkHref);
                }
            }catch (IOException ex){
                System.err.println("Not data connection. please check the connection");
                ex.printStackTrace();
            }
        }
        return resultmap;
    }

}
