package ru.sbrf.efs_notification_ksh_dummy.core.extractors;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OperationNameExtractor implements IExtractor<String, String> {

    public String extract(String text) {
        return extractFirstTagName(text);
    }

    final String openTagStartsSymbol = "<";
    final String openTagEndsSymbol = ">";
    final String spaceSymbol = " ";
    String extractFirstTagName(String xml) {
        final int bodyStartPoint = findBodyStartPoint(xml);
        final int operationNameTagEndPoint = operationNameTagEndPoint(bodyStartPoint, xml);
        final String operationName = xml.substring(bodyStartPoint + openTagStartsSymbol.length(), operationNameTagEndPoint);
        return operationName;
    }

    final String metaDataEndsSymbol = "?>";
    int findBodyStartPoint(String xml) {
        final int metaDataEndsPoint = xml.indexOf(metaDataEndsSymbol);
        final boolean metaDataEndsPointNotFound = metaDataEndsPoint == -1;
        final int bodyStartPoint = metaDataEndsPointNotFound ? 0 : metaDataEndsPoint + metaDataEndsSymbol.length();
        return bodyStartPoint;
    }

    int operationNameTagEndPoint(int bodyStartPoint, String xml) {
        int openTagEndsSymbolPosition = xml.indexOf(openTagEndsSymbol, bodyStartPoint);
        int spaceSymbolPosition = xml.indexOf(spaceSymbol, bodyStartPoint);
        if (openTagEndsSymbolPosition >= 0 && spaceSymbolPosition >= 0) {
            return Math.min(openTagEndsSymbolPosition, spaceSymbolPosition);
        } else if (openTagEndsSymbolPosition >= 0 ){
            return openTagEndsSymbolPosition;
        } else {
            return spaceSymbolPosition;
        }
    }

}
