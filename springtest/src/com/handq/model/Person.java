package com.handq.model;

public class Person
{
    
    private String personName;
    
    private String pwd;
    
    public Person()
    {
        super();
    }
    
    public Person(String pName, String pwd)
    {
        super();
        this.personName = pName;
        this.pwd = pwd;
    }
    
    public String getPersonName()
    {
        return personName;
    }
    
    public void setPersonName(String pName)
    {
        this.personName = pName;
    }
    
    public String getPwd()
    {
        return pwd;
    }
    
    public void setPwd(String pwd)
    {
        this.pwd = pwd;
    }
}
