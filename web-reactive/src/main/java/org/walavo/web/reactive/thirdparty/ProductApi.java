package org.walavo.web.reactive.thirdparty;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.walavo.web.reactive.thirdparty.model.ProductModelApi;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collection;
import java.util.List;

@Component
public class ProductApi {

    @Value("${product-auth-basic}")
    private String authCredentials;

    private final WebClient client;

    public ProductApi(WebClient client) {
        this.client = client;
    }

    public Flux<ProductModelApi> callProductApi(List<String> skus) {
        return client
                .post()
                .uri("/products")
                .header(HttpHeaders.AUTHORIZATION, getAuthenticationBasic())
                .body(Mono.just(skus), List.class)
                .retrieve()
                .bodyToFlux(ProductModelApi.class);
    }

    public Mono<ProductModelApi> callProductApiBySku(String skuCode) {
        return client
                .get()
                .uri("/products/search/"+skuCode)
                .header(HttpHeaders.AUTHORIZATION, getAuthenticationBasic())
                .retrieve()
                .bodyToFlux(ProductModelApi.class)
                .next();
    }
    private static String[] toArray(List<String> strings){
        return strings.toArray(new String[0]);
    }

    private synchronized String getAuthenticationBasic() {
        byte[] authBytes = Base64.encodeBase64(authCredentials.getBytes());
        String authStringEnc = new String(authBytes);
        return "Basic ".concat(authStringEnc);
    }
}
