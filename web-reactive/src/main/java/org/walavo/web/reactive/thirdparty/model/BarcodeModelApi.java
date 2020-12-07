package org.walavo.web.reactive.thirdparty.model;

import lombok.Data;

/**
 * Codigo de barra
 * <p>
 */
@Data
public class BarcodeModelApi {

    /**
     * Codigo de barras del producto
     */
    private String eanCode;
    /**
     * Identificador único del producto
     */
    private String productCode;
    /**
     * Código de Compañia
     */
    private String companyCode;
    /**
     * Example
     */
    private String indicator;
    /**
     * Example
     */
    private String action;
}
