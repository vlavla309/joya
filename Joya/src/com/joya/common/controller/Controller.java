package com.joya.common.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * λͺ¨λ  ?ΈλΆ? μ»¨νΈλ‘€λ¬? ??? ?€?λ©μ? κ·μ½ ? ?Έ - μ»€λ§¨??¨?΄ ? ?©
 * @author κΉ?κΈ°μ 
 */
public interface Controller {
	
	/** ?€? κ·μ½ λ©μ? 
	 * @throws UnsupportedEncodingException */
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, UnsupportedEncodingException;
}