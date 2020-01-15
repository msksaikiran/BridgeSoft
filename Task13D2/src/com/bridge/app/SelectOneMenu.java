package com.bridge.app;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "userData")
@SessionScoped
public class SelectOneMenu implements Serializable {
   private static final long serialVersionUID = 1L;
   public String[] data;
   
   public String[] getData() {
      return data;
   }

   public void setData(String[] data) {
      this.data = data;
   }
}