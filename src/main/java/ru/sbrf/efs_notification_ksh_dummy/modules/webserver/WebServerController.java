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

    // максимальное число сна
    private static int rnd(int max) {
        return (int) (Math.random() * ++max);
    }

    private int Get_random(String... args) {

        final int max = 100; // Максимальное число для диапазона от 0 до max
        final int rnd = rnd(max);
        return rnd;
    }

    // обращение к справочникам
    @SneakyThrows(IOException.class)
    @RequestMapping("/data-dictionary-service/rest/pm/ver.4.0/getRow")
    public void defaultGet(@RequestBody String requestBody, HttpServletResponse response) throws IOException, InterruptedException {

        Thread.sleep(Get_random());

        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print(new Stub().response(requestBody));
        out.close();
    }

    // обращение к справочникам
    @SneakyThrows(IOException.class)
    @RequestMapping("/data-dictionary-service/rest/pm/ver.4.0/getRows")
    public void defaultGets(@RequestBody String requestBody, HttpServletResponse response) throws IOException, InterruptedException {

        Thread.sleep(Get_random());

        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print(new Stub().response(requestBody));
        out.close();
    }


    // обращение к справочникам
    @SneakyThrows(IOException.class)
    @RequestMapping("/data-dictionary-service/")
    public void defaulGet(@RequestBody String requestBody, HttpServletResponse response) throws IOException, InterruptedException {

        Thread.sleep(Get_random());

        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print(new Stub().response(requestBody));
        out.close();
    }

}