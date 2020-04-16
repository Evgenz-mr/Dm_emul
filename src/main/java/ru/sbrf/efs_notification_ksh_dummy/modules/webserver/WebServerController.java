package ru.sbrf.efs_notification_ksh_dummy.modules.webserver;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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

    int Get_random(String... args) {

        final int max = 100; // Максимальное число для диапазона от 0 до max
        final int rnd = rnd(max);
        return rnd;
    }

    public static int rnd(int max)
    {
        return (int) (Math.random() * ++max);
    }

    @SneakyThrows(IOException.class)
    @RequestMapping("/dictionary/")
    public void defaultGet(HttpServletResponse response) throws IOException, InterruptedException {

        Thread.sleep(rnd(100));

        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print(InfoPage.getInfoPage());
        out.close();
    }

}