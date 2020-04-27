package ru.sbrf.efs_notification_ksh_dummy.modules.webserver;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.imageio.IIOException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * Класс Веб-сервера, позволяет мапить урл-пути для выполнения нужных операций
 * Рекомендую  в аннотацию @import(...) вносить классы где обьявляются бины, используемые в этом контроллере
 */

@Slf4j
@Controller
public class WebServerController {
    String response = "{\n" +
            "\"channel\" : \"CHNL-1\",\n" +
            "\"office\" : null,\n" +
            "\"division\" : null,\n" +
            "\"bank\" : \"38\",\n" +
            "\"operationId\" : \"10594ec7c81a4c39b19a8c09b4970d99\",\n" +
            "\"atm\" : null,\n" +
            "\"auditContextUuid\" : \"37ccb422-0c32-4236-b4d8-830bf3f91a78\",\n" +
            "\"card\" : null,\n" +
            "\"option\" : null,\n" +
            "\"conversionDateTime\" : \"2020-04-24T01:00:00.004+0004\",\n" +
            "\"packageTypes\" : [ \"6\" ],\n" +
            "\"conversions\" : [ \n" +
            "                {\n" +
            "\"buyCurrency\" : \"GBP\",\n" +
            "\"sellCurrency\" : \"JPY\",\n" +
            "\"buyAmount\" : null,\n" +
            "\"sellAmount\" : 10,\n" +
            "\"instrumentDebit\" : \"NSTR-1\",\n" +
            "\"instrumentCredit\" : \"NSTR-1\",\n" +
            "\"conversionUUID\" : \"111111111\"\n" +
            "}\n" +
            "]\n" +
            "}\n";

    int Get_random(String... args) {

        final int max = 100; // Максимальное число для диапазона от 0 до max
        final int rnd = rnd(max);
        return rnd;
    }
//    @RequestMapping(path="/data-dictionary-service/rest/pm/ver.4.0/getRow", method = RequestMethod.POST)
//    public String Post(){
//        // return new Stub().response(response);
//        return "Hello";
//    }

//    @SneakyThrows(IOException.class)
//    @RequestMapping(path = "/data-dictionary-service/rest/pm/ver.4.0/getRowss")
//    public void Http(HttpServletResponse response) throws IIOException, InterruptedException {
//        Thread.sleep(rnd(100));
//
//        response.setContentType("application/json;charset=UTF-8");
//        PrintWriter out = response.getWriter();
//        out.print(new Stub().response(r));
//        out.close();
//    }

    @SneakyThrows(IOException.class)
    @RequestMapping("/data-dictionary-service/rest/pm/ver.4.0/getRow")
    public void defaultGet(@RequestBody String requestBody, HttpServletResponse response) throws IOException, InterruptedException {

        Thread.sleep(100);

        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print(new Stub().response(requestBody));
        out.close();
    }

    @SneakyThrows(IOException.class)
    @RequestMapping("/data-dictionary-service/rest/pm/ver.4.0/getRows")
    public void defaultGets(@RequestBody String requestBody, HttpServletResponse response) throws IOException, InterruptedException {

        Thread.sleep(100);

        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print(new Stub().response(requestBody));
        out.close();
    }



//    @PostMapping(path="/data-dictionary-service/rest/pm/ver.4.0/getRow")
//   public ResponseEntity<?> newBazz(){
//        return new ResponseEntity<>(new Stub().response(response), HttpStatus.OK);
//    }
//
//
   public static int rnd(int max) {
        return (int) (Math.random() * ++max);
    }

//    @SneakyThrows(IOException.class)
//    @RequestMapping("/data-dictionary-service/rest/pm/ver.4.0/getRows")
//    public void defaultGet(HttpServletResponse response) throws IOException, InterruptedException {
//
//        Thread.sleep(rnd(100));
//
//        response.setContentType("application/json;charset=UTF-8");
//        PrintWriter out = response.getWriter();
//        out.print(InfoPage.getInfoPage());
//        out.close();
//    }

    // обращение к справочникам
    @SneakyThrows(IOException.class)
    @RequestMapping("/data-dictionary-service/")
    public void defaulGet(@RequestBody String requestBody, HttpServletResponse response) throws IOException, InterruptedException {

        Thread.sleep(100);

        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print(new Stub().response(requestBody));
        out.close();
    }

    // получение количества строк
    @SneakyThrows(IOException.class)
    @RequestMapping("/data-dictionary-service/rest/pm/ver.4.0/getCount")
    public void defaultGet_1(HttpServletResponse response) throws IOException, InterruptedException {

        Thread.sleep(rnd(100));

        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print(InfoPage.getInfoPage());
        out.close();
    }

    // получение строки
//    @SneakyThrows(IOException.class)
//    @RequestMapping("/data-dictionary-service/rest/pm/ver.4.0/getRow")
//    public void defaultGet_2(HttpServletResponse response) throws IOException, InterruptedException {
//
//        Thread.sleep(rnd(100));
//
//        response.setContentType("application/json;charset=UTF-8");
//        PrintWriter out = response.getWriter();
//        out.print(InfoPage.getInfoPage());
//        out.close();
//    }

    // получение максимального размера страницы
    @SneakyThrows(IOException.class)
    @RequestMapping("/data-dictionary-service/rest/pm/ver.4.0/getMaxPageSize")
    public void defaultGet_3(HttpServletResponse response) throws IOException, InterruptedException {

        Thread.sleep(rnd(100));

        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print(InfoPage.getInfoPage());
        out.close();
    }

}