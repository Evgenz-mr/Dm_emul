package ru.sbrf.efs_notification_ksh_dummy.modules.webserver;

/**
 * Класс для вывода страницы приветсвия, можно удалять
 */
public enum InfoPage {
    INSTANCE;

    public static String getInfoPage(){
        return head + body + tail;
    }

    private final static String head = "";
    private final static String body ="{\"success\" : <#switch request.body.query.dictionary>\n" +
            "<#case \"RATE_BRANCH_ARK\">\n" +
            "true,\n" +
            "\"body\" : {\n" +
            "\"responseId\" : \"91573778-d1bf-44b0-90b0-4ccf01201729\",\n" +
            "\"requestId\" : \"d245ae2f-2934-447d-9d7a-7bb25470a5ae\",\n" +
            "\"success\" : true,\n" +
            "\"serverInfo\" : {\n" +
            "\"distribVersion\" : \"P-03.003.03-2834\"\n" +
            "},\n" +
            "\"dataSourceId\" : \"48e614ae-141d-4986-b09f-ee0354c0e6f4\",\n" +
            "\"versionCode\" : \"86a8a8f7-2305-4f44-80a1-05946cf0a8fe\",\n" +
            "\"rowHeader\" : {\n" +
            "\"attrs\" : [ \"branch\" ]\n" +
            "},\n" +
            "\"rowDatas\" : [ {\n" +
            "\"values\" : [ \"UFS5244\" ]\n" +
            "} ]\n" +
            "}\n" +
            "<#break>\n" +
            "<#case \"RATE_TIER_ARK\">\n" +
            "true,\n" +
            "\"body\" : {\n" +
            "\"responseId\" : \"d62bab8c-1050-4d25-958a-2f5370299538\",\n" +
            "\"requestId\" : \"10759ceb-6245-4acb-8dbe-cd8f241c3d5d\",\n" +
            "\"success\" : true,\n" +
            "\"serverInfo\" : {\n" +
            "\"distribVersion\" : \"P-03.003.03-2834\"\n" +
            "},\n" +
            "\"dataSourceId\" : \"48e614ae-141d-4986-b09f-ee0354c0e6f4\",\n" +
            "\"versionCode\" : \"61b940e9-65c9-400c-831f-884ec04acd8d\",\n" +
            "\"rowHeader\" : {\n" +
            "\"attrs\" : [ \"credit\", \"tierCode\", \"tierVersion\", \"value\", \"valueType\" ]\n" +
            "},\n" +
            "\"rowDatas\" : [ {\n" +
            "\"values\" : [ \"NSTR-1\", \"593\", \"17\", \"CHNL-1\", \"channel\" ]\n" +
            "}, {\n" +
            "\"values\" : [ \"NSTR-1\", \"92\", \"27\", \"UFS5244\", \"branch\" ]\n" +
            "}, {\n" +
            "\"values\" : [ null, \"793\", \"16\", \"CHNL-1\", \"channel\" ]\n" +
            "}, {\n" +
            "\"values\" : [ \"NSTR-1\", \"293\", \"17\", \"NSTR-1\", \"instrument\" ]\n" +
            "}, {\n" +
            "\"values\" : [ \"NSTR-1\", \"997\", \"33\", \"UFS5244\", \"branch\" ]\n" +
            "}, {\n" +
            "\"values\" : [ \"NSTR-1\", \"998\", \"23\", \"UFS5244\", \"branch\" ]\n" +
            "}, {\n" +
            "\"values\" : [ \"NSTR-1\", \"793\", \"16\", \"NSTR-1\", \"instrument\" ]\n" +
            "}, {\n" +
            "\"values\" : [ \"NSTR-1\", \"995\", \"19\", \"UFS5244\", \"branch\" ]\n" +
            "}, {\n" +
            "\"values\" : [ \"NSTR-1\", \"75\", \"35\", \"NSTR-1\", \"instrument\" ]\n" +
            "}, {\n" +
            "\"values\" : [ \"NSTR-1\", \"92\", \"27\", \"CHNL-1\", \"channel\" ]\n" +
            "}, {\n" +
            "\"values\" : [ \"NSTR-1\", \"998\", \"23\", \"CHNL-1\", \"channel\" ]\n" +
            "}, {\n" +
            "\"values\" : [ \"NSTR-1\", \"93\", \"18\", \"UFS5244\", \"branch\" ]\n" +
            "}, {\n" +
            "\"values\" : [ \"NSTR-1\", \"997\", \"33\", \"NSTR-1\", \"instrument\" ]\n" +
            "}, {\n" +
            "\"values\" : [ \"NSTR-1\", \"93\", \"18\", \"NSTR-1\", \"instrument\" ]\n" +
            "}, {\n" +
            "\"values\" : [ \"NSTR-1\", \"85\", \"19\", \"CHNL-1\", \"channel\" ]\n" +
            "}, {\n" +
            "\"values\" : [ \"NSTR-1\", \"79\", \"34\", \"CHNL-1\", \"channel\" ]\n" +
            "}, {\n" +
            "\"values\" : [ \"NSTR-1\", \"393\", \"17\", \"CHNL-1\", \"channel\" ]\n" +
            "}, {\n" +
            "\"values\" : [ \"NSTR-1\", \"893\", \"16\", \"CHNL-1\", \"channel\" ]\n" +
            "}, {\n" +
            "\"values\" : [ \"NSTR-1\", \"79\", \"34\", \"UFS5244\", \"branch\" ]\n" +
            "}, {\n" +
            "\"values\" : [ \"NSTR-1\", \"493\", \"17\", \"CHNL-1\", \"channel\" ]\n" +
            "}, {\n" +
            "\"values\" : [ \"NSTR-1\", \"999\", \"20\", \"UFS5244\", \"branch\" ]\n" +
            "}, {\n" +
            "\"values\" : [ \"NSTR-1\", \"393\", \"17\", \"NSTR-1\", \"instrument\" ]\n" +
            "}, {\n" +
            "\"values\" : [ \"NSTR-1\", \"993\", \"61\", \"NSTR-1\", \"instrument\" ]\n" +
            "}, {\n" +
            "\"values\" : [ \"NSTR-1\", \"293\", \"17\", \"CHNL-1\", \"channel\" ]\n" +
            "}, {\n" +
            "\"values\" : [ \"NSTR-1\", \"75\", \"35\", \"5\", \"package\" ]\n" +
            "}, {\n" +
            "\"values\" : [ \"NSTR-1\", \"993\", \"61\", \"CHNL-1\", \"channel\" ]\n" +
            "}, {\n" +
            "\"values\" : [ \"NSTR-1\", \"75\", \"35\", \"UFS5244\", \"branch\" ]\n" +
            "}, {\n" +
            "\"values\" : [ \"NSTR-1\", \"995\", \"19\", \"5\", \"package\" ]\n" +
            "}, {\n" +
            "\"values\" : [ \"NSTR-1\", \"999\", \"20\", \"NSTR-1\", \"instrument\" ]\n" +
            "}, {\n" +
            "\"values\" : [ \"NSTR-1\", \"693\", \"17\", \"NSTR-1\", \"instrument\" ]\n" +
            "}, {\n" +
            "\"values\" : [ \"NSTR-1\", \"998\", \"23\", \"NSTR-1\", \"instrument\" ]\n" +
            "}, {\n" +
            "\"values\" : [ \"NSTR-1\", \"79\", \"34\", \"NSTR-1\", \"instrument\" ]\n" +
            "}, {\n" +
            "\"values\" : [ \"NSTR-1\", \"997\", \"33\", \"CHNL-1\", \"channel\" ]\n" +
            "}, {\n" +
            "\"values\" : [ \"NSTR-1\", \"75\", \"35\", \"CHNL-1\", \"channel\" ]\n" +
            "}, {\n" +
            "\"values\" : [ \"NSTR-1\", \"85\", \"19\", \"NSTR-1\", \"instrument\" ]\n" +
            "}, {\n" +
            "\"values\" : [ \"NSTR-1\", \"493\", \"17\", \"NSTR-1\", \"instrument\" ]\n" +
            "}, {\n" +
            "\"values\" : [ \"NSTR-1\", \"193\", \"18\", \"NSTR-1\", \"instrument\" ]\n" +
            "}, {\n" +
            "\"values\" : [ \"NSTR-1\", \"693\", \"17\", \"CHNL-1\", \"channel\" ]\n" +
            "}, {\n" +
            "\"values\" : [ \"NSTR-1\", \"893\", \"16\", \"NSTR-1\", \"instrument\" ]\n" +
            "}, {\n" +
            "\"values\" : [ \"NSTR-1\", \"193\", \"18\", \"CHNL-1\", \"channel\" ]\n" +
            "}, {\n" +
            "\"values\" : [ \"NSTR-1\", \"995\", \"19\", \"CHNL-1\", \"channel\" ]\n" +
            "}, {\n" +
            "\"values\" : [ \"NSTR-1\", \"999\", \"20\", \"CHNL-1\", \"channel\" ]\n" +
            "}, {\n" +
            "\"values\" : [ \"NSTR-1\", \"593\", \"17\", \"NSTR-1\", \"instrument\" ]\n" +
            "}, {\n" +
            "\"values\" : [ \"NSTR-1\", \"92\", \"27\", \"NSTR-1\", \"instrument\" ]\n" +
            "}, {\n" +
            "\"values\" : [ \"NSTR-1\", \"93\", \"18\", \"CHNL-1\", \"channel\" ]\n" +
            "}, {\n" +
            "\"values\" : [ \"NSTR-1\", \"995\", \"19\", \"NSTR-1\", \"instrument\" ]\n" +
            "}, {\n" +
            "\"values\" : [ \"NSTR-1\", \"85\", \"19\", \"UFS5244\", \"branch\" ]\n" +
            "} ]\n" +
            "}\n" +
            "<#break>\n" +
            "<#case \"RATE_QUOTE_ARK\">\n" +
            "<#if request.body.query.filter.compositeFilter.filters[0].propertyFilter.values[0] == \"75\">\n" +
            "true,\n" +
            "\"body\" : {\n" +
            "\"responseId\" : \"eb554cf8-cd39-4581-bb4d-ad57fc0a5b0d\",\n" +
            "\"requestId\" : \"dda9a81a-df29-41ce-b0a7-2243e4c9dcae\",\n" +
            "\"success\" : true,\n" +
            "\"serverInfo\" : {\n" +
            "\"distribVersion\" : \"P-03.003.03-2834\"\n" +
            "},\n" +
            "\"dataSourceId\" : \"48e614ae-141d-4986-b09f-ee0354c0e6f4\",\n" +
            "\"versionCode\" : \"c1ba9aba-883e-4e12-8e37-f0fb4e7fadca\",\n" +
            "\"rowHeader\" : {\n" +
            "\"attrs\" : [ \"base\", \"bid\", \"elSign\", \"limitVol\", \"messageType\", \"offer\", \"protocol\"," +
            " \"quoted\", \"reqDt\", \"scale\", \"scale\", \"seqNum\", \"startDate\", \"task_id\", \"tierCode\", " +
            "\"tierVersion\", \"vol\" ]\n" +
            "},\n" +
            "\"rowDatas\" : [ {\n" +
            "\"values\" : [ \"GBP\", [ \"java.math.BigDecimal\", 10 ], \"EqqhtXKYHzBMy5la0Dik3OCf689QGcEu8OeQiLDuRO0d/lVA/by3E+dXemtGY5DIDBt3gP8yWd7zDH9ZryZG1kE4xyWKmraDK0WFxtcYgMOFn8XGt37/n84ibZsSq/Qrv52ap0UKTPVNEUGHf2g76dC02yXuWV36RBBcR36PYE0X/Vwya/FtE393BvqrJV0GYmZT6v7QTrve16QJaUqp3ojGVZgM5XPg3UfJC9q1TREUIYnHmQU2t5H8nQuP8E2U7zbxt6k+CHTY4bMYmOMNi5AM7P+yQ1gpimB1dag605dnZsdXesrSUu7xzuFwTk3Szkw+p87WN3cAxIKoGR+amw==\", null, \"UPDATE\", [ \"java.math.BigDecimal\", 10 ], \"v1\", \"RUB\", [ \"java.util.Date\", \"2019-12-25T14:23:56.000+0300\" ], [ \"java.math.BigDecimal\", 1 ], [ \"java.math.BigDecimal\", 1 ], [ \"java.math.BigDecimal\", 19269 ], [ \"java.util.Date\", \"2019-12-25T14:24:56.000+0300\" ], \"p7:261d87fc-8fe6-4f13-9115-16fec7c598c2\", \"75\", \"35\", [ \"java.math.BigDecimal\", 0 ] ]\n" +
            "}, {\n" +
            "\"values\" : [ \"GBP\", [ \"java.math.BigDecimal\", 10 ], \"GFzDIiRWSaIzPWs+mvxc88HMwlbxgDvQLU86uihoX5te5fMZLFarlNuwZBy0/8yAQmbgRNvPLRoskKFqhtckEb767uQuIrYfW69ydE7iDMOh1pibcUDSigF8/r8fjmsAK9E7c8uAHL2uHunGS7tNiKVpMXK/mHAdRffSt8D+OrazQZ+3NQQymxnP3vGKzOFQ0KGALQpx/CAM4PqZtECT7R57KLa1C+QbOf79wZ7EVSbERLTXhxYrHY8c4L424oIux+NdtTscculfWFMFkVpZ8XMaT5vidKdaVIfW8awFVIHpbbzsac/a67WjSSwouz0SXENQ/CoanRBT1L4OmmyBfQ==\", null, \"SNAPSHOT\", [ \"java.math.BigDecimal\", 10 ], \"v1\", \"RUB\", [ \"java.util.Date\", \"2019-12-24T17:07:22.000+0300\" ], [ \"java.math.BigDecimal\", 1 ], [ \"java.math.BigDecimal\", 1 ], [ \"java.math.BigDecimal\", 19226 ], [ \"java.util.Date\", \"2019-12-24T10:48:47.000+0300\" ], \"p7:9eb3c739-7b59-4dd7-bf3c-088f38131453\", \"75\", \"35\", [ \"java.math.BigDecimal\", 0 ] ]\n" +
            "}, {\n" +
            "\"values\" : [ \"GBP\", [ \"java.math.BigDecimal\", 10 ], \"zGQUlMJH2S2bsULDVtA02TslO0ht5yTc2xOnt+s5K9a6vHk2veidofh82/hgzGTse3JbdOKdn2X3uIUi6rA5EsMfmaeSosAJ/z7EZxDNnsAP2nnwpLmq9TOjyDxuWDzCMRq3iI3UC1P60jHt++jDnEKNrZTKShANnja7K2AgXdBZPh1tJyQBzzYgiuYO4C4Z4FQfMyy6Bi/CxH+BN2/RqAnjiGIgSlqTGe5zbLkk8igfecZYeu0r3sKBg7k+chkcgx7ijkxo0BVNah+s7+7Fgglmz72YKmA1c2IDL95eSvhO4N7OAjYqPjP2rscoyJOar82xuJYu6iMW6YNG0I6MQg==\", null, \"UPDATE\", [ \"java.math.BigDecimal\", 10 ], \"v1\", \"RUB\", [ \"java.util.Date\", \"2019-12-24T22:59:00.000+0300\" ], [ \"java.math.BigDecimal\", 1 ], [ \"java.math.BigDecimal\", 1 ], [ \"java.math.BigDecimal\", 19239 ], [ \"java.util.Date\", \"2019-12-24T23:00:00.000+0300\" ], \"p7:771d73a9-4a08-462d-baac-8143815278a0\", \"75\", \"35\", [ \"java.math.BigDecimal\", 0 ] ]\n" +
            "} ]\n" +
            "}\n" +
            "<#else>\n" +
            "true,\n" +
            "\"body\" : {\n" +
            "\"responseId\" : \"69172af1-81d3-455c-863c-402e7833823f\",\n" +
            "\"requestId\" : \"28e81882-897c-47d7-b1f2-3e987a9d5d83\",\n" +
            "\"success\" : true,\n" +
            "\"serverInfo\" : {\n" +
            "\"distribVersion\" : \"P-03.003.03-2834\"\n" +
            "},\n" +
            "\"dataSourceId\" : \"48e614ae-141d-4986-b09f-ee0354c0e6f4\",\n" +
            "\"versionCode\" : \"c1ba9aba-883e-4e12-8e37-f0fb4e7fadca\",\n" +
            "\"rowHeader\" : {\n" +
            "\"attrs\" : [ \"base\", \"bid\", \"elSign\", \"limitVol\", \"messageType\", \"offer\", \"protocol\", \"quoted\", \"reqDt\", \"scale\", \"scale\", \"seqNum\", \"startDate\", \"task_id\", \"tierCode\", \"tierVersion\", \"vol\" ]\n" +
            "},\n" +
            "\"rowDatas\" : [ ]\n" +
            "}\n" +
            "</#if>\n" +
            "<#break>\n" +
            "<#case \"CAS_E0_CURRENCY_NEW\">\n" +
            "<#if request.body.query.filter.compositeFilter.filters[0].propertyFilter.values[0] == \"RUB\">\n" +
            "true,\n" +
            "\"body\" : {\n" +
            "\"responseId\" : \"07e1584e-9c16-4f6c-ac24-1af6f2dca577\",\n" +
            "\"requestId\" : \"cfeb1553-ba6c-4a4e-9168-e2ac68fad547\",\n" +
            "\"success\" : true,\n" +
            "\"messages\" : [ {\n" +
            "\"level\" : \"WARN\",\n" +
            "\"message\" : \"Для подсистемы 'subsystem' запрещен доступ к справочнику 'CAS_E0_CURRENCY_NEW'\"\n" +
            "} ],\n" +
            "\"serverInfo\" : {\n" +
            "\"distribVersion\" : \"D-03.003.00-2768\"\n" +
            "},\n" +
            "\"dataSourceId\" : \"208555f1-71bd-4083-81de-5ed2f833a7b6\",\n" +
            "\"versionCode\" : \"CAS_payments.EFK.71.2019.09.24.13:16\",\n" +
            "\"rowHeader\" : {\n" +
            "\"attrs\" : [ \"cas_digit\" ]\n" +
            "},\n" +
            "\"rowData\" : {\n" +
            "\"values\" : [ [ \"java.math.BigDecimal\", 2 ] ]\n" +
            "}\n" +
            "}\n" +
            "<#elseif request.body.query.filter.compositeFilter.filters[0].propertyFilter.values[0] == \"GBP\">\n" +
            "<#if request.body.query.resultAttrs[0] == \"cas_digit\">\n" +
            "true,\n" +
            "\"body\" : {\n" +
            "\"responseId\" : \"ad9be9a1-10e0-4d3b-b210-b76c75357c63\",\n" +
            "\"requestId\" : \"381f363a-0005-4f53-a7c2-229ea8c7fc0a\",\n" +
            "\"success\" : true,\n" +
            "\"serverInfo\" : {\n" +
            "\"distribVersion\" : \"P-03.003.03-2834\"\n" +
            "},\n" +
            "\"dataSourceId\" : \"48e614ae-141d-4986-b09f-ee0354c0e6f4\",\n" +
            "\"versionCode\" : \"CAS_payments.EFK.21.2019.11.20.07:38\",\n" +
            "\"rowHeader\" : {\n" +
            "\"attrs\" : [ \"cas_digit\" ]\n" +
            "},\n" +
            "\"rowData\" : {\n" +
            "\"values\" : [ [ \"java.math.BigDecimal\", 2 ] ]\n" +
            "}\n" +
            "}\n" +
            "<#elseif request.body.query.resultAttrs[0] == \"cas_cr_num\">\n" +
            "true,\n" +
            "\"body\" : {\n" +
            "\"responseId\" : \"31df4fc6-27ea-4ee0-a453-d81c02c82a84\",\n" +
            "\"requestId\" : \"a188dec6-f9ef-4f0d-ba96-c2e3196ad50f\",\n" +
            "\"success\" : true,\n" +
            "\"serverInfo\" : {\n" +
            "\"distribVersion\" : \"P-03.003.03-2834\"\n" +
            "},\n" +
            "\"dataSourceId\" : \"48e614ae-141d-4986-b09f-ee0354c0e6f4\",\n" +
            "\"versionCode\" : \"CAS_payments.EFK.21.2019.11.20.07:38\",\n" +
            "\"rowHeader\" : {\n" +
            "\"attrs\" : [ \"cas_cr_num\" ]\n" +
            "},\n" +
            "\"rowData\" : {\n" +
            "\"values\" : [ \"826\" ]\n" +
            "}\n" +
            "}\n" +
            "<#else>\n" +
            "\"ifelsssss\"\n" +
            "</#if>\n" +
            "<#elseif request.body.query.filter.compositeFilter.filters[0].propertyFilter.values[0] == \"JPY\">\n" +
            "<#if request.body.query.resultAttrs[0] == \"cas_digit\">\n" +
            "true,\n" +
            "\"body\" : {\n" +
            "\"responseId\" : \"66477934-0429-4a71-8984-4ab76e025737\",\n" +
            "\"requestId\" : \"fd74e87c-64ab-4646-b043-937ecca5c712\",\n" +
            "\"success\" : true,\n" +
            "\"messages\" : [ {\n" +
            "\"level\" : \"WARN\",\n" +
            "\"message\" : \"Для подсистемы 'subsystem' запрещен доступ к справочнику 'CAS_E0_CURRENCY_NEW'\"\n" +
            "} ],\n" +
            "\"serverInfo\" : {\n" +
            "\"distribVersion\" : \"D-03.003.00-2768\"\n" +
            "},\n" +
            "\"dataSourceId\" : \"208555f1-71bd-4083-81de-5ed2f833a7b6\",\n" +
            "\"versionCode\" : \"CAS_payments.EFK.71.2019.09.24.13:16\",\n" +
            "\"rowHeader\" : {\n" +
            "\"attrs\" : [ \"cas_digit\" ]\n" +
            "},\n" +
            "\"rowData\" : {\n" +
            "\"values\" : [ [ \"java.math.BigDecimal\", 0 ] ]\n" +
            "}\n" +
            "}\n" +
            "<#elseif request.body.query.resultAttrs[0] == \"cas_cr_num\">\n" +
            "true,\n" +
            "\"body\" : {\n" +
            "\"responseId\" : \"86c5094b-bd02-4523-a867-d2e80bb3f814\",\n" +
            "\"requestId\" : \"135bf4ea-8127-4074-acc5-b8207da584d6\",\n" +
            "\"success\" : true,\n" +
            "\"messages\" : [ {\n" +
            "\"level\" : \"WARN\",\n" +
            "\"message\" : \"Для подсистемы 'subsystem' запрещен доступ к справочнику 'CAS_E0_CURRENCY_NEW'\"\n" +
            "} ],\n" +
            "\"serverInfo\" : {\n" +
            "\"distribVersion\" : \"D-03.003.00-2768\"\n" +
            "},\n" +
            "\"dataSourceId\" : \"208555f1-71bd-4083-81de-5ed2f833a7b6\",\n" +
            "\"versionCode\" : \"CAS_payments.EFK.71.2019.09.24.13:16\",\n" +
            "\"rowHeader\" : {\n" +
            "\"attrs\" : [ \"cas_cr_num\" ]\n" +
            "},\n" +
            "\"rowData\" : {\n" +
            "\"values\" : [ \"392\" ]\n" +
            "}\n" +
            "}\n" +
            "<#else>\n" +
            "\"ifelsssss\"\n" +
            "</#if>\n" +
            "<#elseif request.body.query.filter.compositeFilter.filters[0].propertyFilter.values[0] == \"USD\">\n" +
            "<#if request.body.query.resultAttrs[0] == \"cas_digit\">\n" +
            "true,\n" +
            "\"body\" : {\n" +
            "\"responseId\" : \"3a5cd8d2-4497-420a-8d47-d7309cb4e86d\",\n" +
            "\"requestId\" : \"240344a9-1a0d-43fe-8ae5-e34ec2db3904\",\n" +
            "\"success\" : true,\n" +
            "\"serverInfo\" : {\n" +
            "\"distribVersion\" : \"P-03.003.03-2840\"\n" +
            "},\n" +
            "\"dataSourceId\" : \"48e614ae-141d-4986-b09f-ee0354c0e6f4\",\n" +
            "\"versionCode\" : \"CAS_payments.EFK.35.2020.01.14.10:56\",\n" +
            "\"rowHeader\" : {\n" +
            "\"attrs\" : [ \"cas_digit\" ]\n" +
            "},\n" +
            "\"rowData\" : {\n" +
            "\"values\" : [ [ \"java.math.BigDecimal\", 2 ] ]\n" +
            "}\n" +
            "}\n" +
            "<#elseif request.body.query.resultAttrs[0] == \"cas_cr_num\">\n" +
            "true,\n" +
            "\"body\" : {\n" +
            "\"responseId\" : \"075a2bbd-04f1-46de-b7b2-11741a1fa450\",\n" +
            "\"requestId\" : \"84247149-ec7e-4fa3-910e-0f1a63cc7122\",\n" +
            "\"success\" : true,\n" +
            "\"serverInfo\" : {\n" +
            "\"distribVersion\" : \"P-03.003.03-2840\"\n" +
            "},\n" +
            "\"dataSourceId\" : \"48e614ae-141d-4986-b09f-ee0354c0e6f4\",\n" +
            "\"versionCode\" : \"CAS_payments.EFK.35.2020.01.14.10:56\",\n" +
            "\"rowHeader\" : {\n" +
            "\"attrs\" : [ \"cas_cr_num\" ]\n" +
            "},\n" +
            "\"rowData\" : {\n" +
            "\"values\" : [ \"840\" ]\n" +
            "}\n" +
            "}\n" +
            "<#else>\n" +
            "\"ifelsssss\"\n" +
            "</#if>\n" +
            "<#else>\n" +
            "\"else\"\n" +
            "</#if>\n" +
            "<#break>\n" +
            "<#case \"RATE_CURRENCY\">\n" +
            "true,\n" +
            "\"body\" : {\n" +
            "\"responseId\" : \"4d34a7ce-a451-4d03-80a7-28a8416e437f\",\n" +
            "\"requestId\" : \"875bf190-1ef4-4701-afd2-9ef27cd4f91e\",\n" +
            "\"success\" : true,\n" +
            "\"serverInfo\" : {\n" +
            "\"distribVersion\" : \"P-03.003.03-2834\"\n" +
            "},\n" +
            "\"dataSourceId\" : \"48e614ae-141d-4986-b09f-ee0354c0e6f4\",\n" +
            "\"versionCode\" : \"2ad04024-839f-4547-8dc5-140397bd9c9a\",\n" +
            "\"rowHeader\" : {\n" +
            "\"attrs\" : [ \"lot_size\", \"order_date_time\", \"rate_central_bank\", \"start_date_time\" ]\n" +
            "},\n" +
            "\"rowDatas\" : [ {\n" +
            "\"values\" : [ [ \"java.math.BigDecimal\", 1 ], [ \"java.util.Date\", \"2019-11-22T14:13:48.000+0300\" ], " +
            "[ \"java.math.BigDecimal\", 10 ], [ \"java.util.Date\", \"2019-11-23T00:00:00.000+0300\" ] ]\n" +
            "}, {\n" +
            "\"values\" : [ [ \"java.math.BigDecimal\", 1 ], [ \"java.util.Date\", \"2019-11-22T10:37:29.000+0300\" ], " +
            "[ \"java.math.BigDecimal\", 10 ], [ \"java.util.Date\", \"2019-11-23T00:00:00.000+0300\" ] ]\n" +
            "} ]\n" +
            "}\n" +
            "<#break>\n" +
            "</#switch>\n" +
            "}\n ";

    private final static String tail = "";


}