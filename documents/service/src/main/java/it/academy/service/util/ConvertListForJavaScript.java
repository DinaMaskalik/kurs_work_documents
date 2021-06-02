package it.academy.service.util;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ConvertListForJavaScript {

    public String convertList(List<String> stringList) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < stringList.size(); i++) {
            sb.append("\"").append(stringList.get(i)).append("\"");
            if (i + 1 < stringList.size()) {
                sb.append(",");
            }
        }
        sb.append("]");

        return sb.toString();
    }
}
