package com.synectiks.asset.controller.testservicedata;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class ServiceDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String associatedOU;
	public String associatedDept;
	public String associatedProduct;
	public String associatedEnv;
    private String serviceType;
	private String serviceHostingType;
	private String serviceNature;
	private String associatedCommonService;
	private String associatedBusinessService;
	private String serviceName;
	private String description;
	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

		public String getAssociatedBusinessService() {
		return associatedBusinessService;
	}

	public void setAssociatedBusinessService(String associatedBusinessService) {
		this.associatedBusinessService = associatedBusinessService;
	}

		public String getAssociatedCommonService() {
		return associatedCommonService;
	}

	public void setAssociatedCommonService(String associatedCommonService) {
		this.associatedCommonService = associatedCommonService;
	}

	public String getServiceNature() {
		return serviceNature;
	}

	public void setServiceNature(String serviceNature) {
		this.serviceNature = serviceNature;
	}
		public String getServiceHostingType() {
		return serviceHostingType;
	}

	public void setServiceHostingType(String serviceHostingType) {
		this.serviceHostingType = serviceHostingType;
	}

    public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	
	

	public String getAssociatedOU() {
		return associatedOU;
	}

	public void setAssociatedOU(String associatedOU) {
		this.associatedOU = associatedOU;
	}

	public String getAssociatedDept() {
		return associatedDept;
	}

	public void setAssociatedDept(String associatedDept) {
		this.associatedDept = associatedDept;
	}

	public String getAssociatedProduct() {
		return associatedProduct;
	}

	public void setAssociatedProduct(String associatedProduct) {
		this.associatedProduct = associatedProduct;
	}

	public String getAssociatedEnv() {
		return associatedEnv;
	}

	public void setAssociatedEnv(String associatedEnv) {
		this.associatedEnv = associatedEnv;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public static String getHostingType(String jsonFile) {
		JSONParser parser = new JSONParser();
		JSONObject jsonObject = null;
		try {
			Object obj = parser.parse(new FileReader(jsonFile));
            jsonObject =  (JSONObject) obj;
		}catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
			e.printStackTrace();
		}
		
		return (String)jsonObject.get("serviceHostingType");
	}
	
	protected ServiceDto readJson(String json) {	
		return null;
	}
	
	protected void save() throws JsonParseException, JsonMappingException, IOException {	
		
	}
	
	public static ServiceDto instantiate(String hostingType) {
		switch (hostingType) {
	        case "ClusterManaged":
	            return new ClusterServiceDto();
	        case "CloudManaged":
	            return new CloudServiceDto();
	        case "GlobalManaged":
	            return new GlobalServiceDto();
	        default:
	            throw new IllegalArgumentException("Unknown hosting type: "+hostingType);
        }
	}
}
