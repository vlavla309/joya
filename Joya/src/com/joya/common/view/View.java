package com.joya.common.view;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * λͺ¨λ  λ·°μ ??? ?€?λ©μ? κ·μ½ ? ?Έ
 * @author κΉ?κΈ°μ 
 */
public interface View {
	
	/** ?€? κ·μ½ λ©μ? */
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}