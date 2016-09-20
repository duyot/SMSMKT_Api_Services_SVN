package com.vivas.service;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

/**
 * Created by duyot on 9/13/2016.
 */
@WebService
public class BaseServiceImpl {
    @Resource
    public WebServiceContext wsContext;

    public HttpSession session;
    public ServletContext servletContext;
    public HttpServletRequest request;

    public BaseServiceImpl() {
        MessageContext mc_ = wsContext.getMessageContext();
        HttpServletRequest request_ = (HttpServletRequest)mc_.get("javax.xml.ws.servlet.request");
        HttpSession session_ = request_.getSession();
        ServletContext appContext_ = (ServletContext)mc_.get("javax.xml.ws.servlet.context");

        setSession(session_);
        setServletContext(appContext_);
        setRequest(request_);
    }

    public WebServiceContext getWsContext() {
        return wsContext;
    }

    public void setWsContext(WebServiceContext wsContext) {
        this.wsContext = wsContext;
    }

    public HttpSession getSession() {
        return session;
    }

    public void setSession(HttpSession session) {
        this.session = session;
    }

    public ServletContext getServletContext() {
        return servletContext;
    }

    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

    public HttpServletRequest getRequest() {
        return request;
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }
}
