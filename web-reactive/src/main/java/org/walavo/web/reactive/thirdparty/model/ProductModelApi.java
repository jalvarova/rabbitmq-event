package org.walavo.web.reactive.thirdparty.model;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class ProductModelApi {

    /**
     * Código interno de producto
     * (Required)
     */
    private String productCode;
    /**
     * Código único de producto
     * (Required)
     */
    private String skuCode;
    /**
     * Código de Compañia
     */
    private String companyCode;
    /**
     * Descripcion del producto
     */
    private String description;
    /**
     * Descripción interna del producto
     */
    private String internalDescription;
    /**
     * Tipo del producto (ST)
     */
    private String productType;
    /**
     * Código único de la jerarquia
     */
    private String hierarchyCode;
    /**
     * Precio del producto
     */
    private Double price;
    /**
     * Impuesto de venta del producto
     */
    private String taxSale;
    /**
     * Impuesto selectivo del producto
     */
    private Double taxSelective;
    /**
     * Largo del producto
     */
    private Double length;
    /**
     * Ancho del producto
     */
    private Double width;
    /**
     * Alto del producto
     */
    private Double height;
    /**
     * Peso del producto
     */
    private Double weight;
    /**
     * Codigos de barras del Producto
     * <p>
     * Lista de Barcodes
     */
    private String dispatchType;
    private String unitMeasurement;
    private String unitedNationsCode;
    private String productPmmStatus;
    private List<BarcodeModelApi> barcodes;
    private Map<String, String> attributes;
}
