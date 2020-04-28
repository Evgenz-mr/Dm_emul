package ru.sbrf.efs_notification_ksh_dummy.modules.webserver;

/**
 * Класс для вывода страницы приветсвия, можно удалять
 */
class  InfoPage extends WebServerController{

    static String getInfoPage(){
        return head + body + tail;
    }

    private final static String head = "";

    private final static String body = "";

    private final static String tail = "";
}

