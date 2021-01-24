package com.jluque.sprinboot.backend.apirest.enums;

public class ResourceServerConfigEnums {

	private static final String UPLOADS = "/api/uploads/img/**";
	private static final String IMAGES = "/images/**";
	private static final String USUARIOS = "/api/usuarios";
	private static final String USUARIOS_ID = "/api/usuarios/**";
	private static final String BUGS = "/api/bugs"; 
	private static final String BUGS_ID = "/api/bugs/**";
	private static final String COMENTARIOS_BUG = "/api/comentariosbug"; 
	private static final String COMENTARIOS_BUG_ID = "/api/comentariosbug/**";
	private static final String PRODUCT_LINES = "/api/productlines";
	private static final String PRODUCT_LINES_ID = "/api/productlines/**";
	private static final String PRODUCTS = "/api/products";
	private static final String PRODUCTS_ID = "/api/products/**"; 
	private static final String PRODUCTS_BY_PRODUCT_LINE_ID = "/api/products/findbyproductline/**";
	private static final String OFFICES = "/api/offices"; 
	private static final String OFFICES_ID = "/api/offices/**";
	private static final String EMPLOYEES = "/api/employees";
	private static final String EMPLOYEES_ID = "/api/employees/**";
	private static final String NOTIFICATIONS = "/api/notifications";
	private static final String CUSTOMERS = "/api/customers";
	private static final String CUSTOMERS_PAGE = "/api/customers/page/**";

	
	public static final String[] GET_MATCHERS = {UPLOADS,IMAGES,USUARIOS_ID,BUGS,BUGS_ID,COMENTARIOS_BUG,COMENTARIOS_BUG_ID,PRODUCT_LINES,PRODUCT_LINES_ID
			,PRODUCTS,PRODUCTS_ID,PRODUCTS_BY_PRODUCT_LINE_ID,OFFICES,OFFICES_ID,EMPLOYEES,EMPLOYEES_ID,CUSTOMERS,CUSTOMERS_PAGE};
		
	public static final String[] POST_MATCHERS = {USUARIOS,NOTIFICATIONS,PRODUCT_LINES,EMPLOYEES};
	
	public static final String[] PUT_MATCHERS = {USUARIOS_ID,PRODUCT_LINES_ID};
	
	public static final String[] DELETE_MATCHERS = {USUARIOS_ID, OFFICES_ID,EMPLOYEES};
}
