package net.movill.erp.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import static org.springframework.web.reactive.function.BodyInserters.fromFormData;

public class Utility {
    private static SimpleDateFormat FORMAT = new SimpleDateFormat("yyyyMMdd");

    public static Mono<?> sendPost(String url, Object body, ParameterizedTypeReference<?> resultClass) {
        WebClient client = WebClient.builder().build();

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> map = mapper.convertValue(body, Map.class);
        for (String key : map.keySet()) {
            params.add(key, map.get(key).toString());
        }

        return client
                .post()
                .uri(url)
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .accept( MediaType.APPLICATION_JSON )
                .body(fromFormData(params))
                .retrieve()
                .bodyToMono(resultClass);
    }

    public static Date parseDate(String strDate) throws ParseException {
        return FORMAT.parse(strDate);
    }

}
