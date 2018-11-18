package com.sellproducts.thiennt.shipper.model;

public class ShippingInfomation {
    private String orderId, shipperPhone;
    private  Double lat, lng;

    public ShippingInfomation() {
    }

    public ShippingInfomation(String orderId, String shipperPhone, Double lat, Double lng) {
        this.orderId = orderId;
        this.shipperPhone = shipperPhone;
        this.lat = lat;
        this.lng = lng;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getShipperPhone() {
        return shipperPhone;
    }

    public void setShipperPhone(String shipperPhone) {
        this.shipperPhone = shipperPhone;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }
}
