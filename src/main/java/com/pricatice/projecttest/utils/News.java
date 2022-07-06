package com.pricatice.projecttest.utils;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class News {
    public static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
    public static final String WEB_DRIVER_PATH = "D:\\chromedriver.exe";
    private WebDriver driver;

    public static void main(String[] args) {
        News news = new News();
        WebElement newsDiv = null;
        int paging = 0;


        //크롬 설정을 담은 객체 생성
        ChromeOptions options = new ChromeOptions();
        //브라우저가 눈에 보이지 않고 내부적으로 돈다.
        //설정하지 않을 시 실제 크롬 창이 생성되고, 어떤 순서로 진행되는지 확인할 수 있다.
        options.addArguments("headless");

        //운영체제에 드라이버 설정
        System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);

        //설정한 옵션 객체를 ChromeDriver 생성자를 통해 전달한다.
        news.driver = new ChromeDriver(options);

        options.setBinary("/path/to/other/chrome/binary");

        String url = "https://news.naver.com/main/list.naver?mode=LS2D&mid=shm&sid1=101&sid2=258";

        //요청할 URL을 get()에 전달하면 응답된 페이지를 브라우저를 통해 확인할 수 있다.
        news.driver.get(url);

        try {
            //브라우저가 실행되는 시간을 기다려준다.
            Thread.sleep(1000);
        } catch (InterruptedException e) { // 자바가 셀레니움보다 빨라서 1초씩은 기다려준다. 브라우저 열리기도 전에 태그를 가져올수 있기떄문에
            e.printStackTrace();
        }
        news.driver.findElement(By.className("content"));



        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        newsDiv = news.driver.findElement(By.className("content")); //증권 메인 페이지



        //div태그 안에 title클래스 태그를 전부 가져온다.(findElements())
        for(WebElement el:newsDiv.findElements(By.className("type06_headline"))){
            newsDiv.findElements(By.linkText("href"));
            //각각의 <strong class="title">태그를 el에 순서대로 담아준다.
            //가져온 태그안에 있는 내용(요소 , 컨텐츠, 텍스트)를 getText()로 가져올 수 있다.
            System.out.println(el.getText() + "\n");
        }

        //div태그 안에 title클래스 태그를 전부 가져온다.(findElements())
        for(WebElement el:newsDiv.findElements(By.className("type06"))){
            System.out.println(el.getText() + "\n");
        }

        news.driver.close();
        news.driver.quit();

    }
}

