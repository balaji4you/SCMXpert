package com.demo.models;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Shipments")
public class ShipmentDetails {
	
	@Id
	private String id;
	@NotNull
	@Pattern(regexp = "^[a-zA-Z0-9]*$", message="invoiceNumber is invalid")   
	
	private String invoiceNumber;
	@NotNull
	@Pattern(regexp = "^[a-zA-Z0-9]*$", message="containerNumber is invalid")   
	
	private String containerNumber;
	private String shipmentDescription;
	private List<String> routeDetail;
	private String goodsType;
	private String device;
	private String expectedDeliverydate;
	@NotNull
	@Pattern(regexp = "^[a-zA-Z0-9]*$", message="poNumber is invalid")   
	
	private String poNumber;
	@NotNull
	@Pattern(regexp = "^[a-zA-Z0-9]*$", message="deliveryNumber is invalid")   
	
	private String deliveryNumber;
	@NotNull
	@Pattern(regexp = "^[a-zA-Z0-9]*$", message="NdcNumber is invalid")   
	
	private String NdcNumber;
	@NotNull
	@Pattern(regexp = "^[a-zA-Z0-9]*$", message="batchId is invalid")   
	
	private String batchId;
	@NotNull
	@Pattern(regexp = "^[a-zA-Z0-9]*$", message="serialNumber is invalid")   
	
	private String serialNumber;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getInvoiceNumber() {
		return invoiceNumber;
	}
	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}
	public String getContainerNumber() {
		return containerNumber;
	}
	public void setContainerNumber(String containerNumber) {
		this.containerNumber = containerNumber;
	}
	public String getShipmentDescription() {
		return shipmentDescription;
	}
	public void setShipmentDescription(String shipmentDescription) {
		this.shipmentDescription = shipmentDescription;
	}
	
	
	
	public List<String> getRouteDetail() {
		return routeDetail;
	}
	public void setRouteDetail(List<String> routeDetail) {
		this.routeDetail = routeDetail;
	}
	public String getGoodsType() {
		return goodsType;
	}
	public void setGoodsType(String goodsType) {
		this.goodsType = goodsType;
	}
	public String getDevice() {
		return device;
	}
	public void setDevice(String device) {
		this.device = device;
	}
	public String getExpectedDeliverydate() {
		return expectedDeliverydate;
	}
	public void setExpectedDeliverydate(String expectedDeliverydate) {
		this.expectedDeliverydate = expectedDeliverydate;
	}
	public String getPoNumber() {
		return poNumber;
	}
	public void setPoNumber(String poNumber) {
		this.poNumber = poNumber;
	}
	public String getDeliveryNumber() {
		return deliveryNumber;
	}
	public void setDeliveryNumber(String deliveryNumber) {
		this.deliveryNumber = deliveryNumber;
	}
	public String getNdcNumber() {
		return NdcNumber;
	}
	public void setNdcNumber(String ndcNumber) {
		NdcNumber = ndcNumber;
	}
	public String getBatchId() {
		return batchId;
	}
	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	
	
	
	


}
