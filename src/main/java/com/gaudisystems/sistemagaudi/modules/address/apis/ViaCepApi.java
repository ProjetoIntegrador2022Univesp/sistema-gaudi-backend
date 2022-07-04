package com.gaudisystems.sistemagaudi.modules.address.apis;

import java.net.URI;

public class ViaCepApi {
    
    private static final String URL_VIA_CEP = "http://viacep.com.br/ws/%s/json/";

    public static URI getViaCepUrl(String cep) {
        String uri = String.format(URL_VIA_CEP, cep);
        return URI.create(uri);
    }
}
