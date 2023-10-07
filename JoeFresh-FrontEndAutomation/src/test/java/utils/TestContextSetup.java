package utils;

import pages.PageObjectManager;
import resources.Base;
import resources.ColumnDataDriven;
import util.BasicOperations;
import util.Common;

import java.io.IOException;

public class TestContextSetup {

    public PageObjectManager pom;

    public BasicOperations basic;

    public Base base;
    public ColumnDataDriven ddt;
    public Common common;

    public TestContextSetup() throws IOException {
        base=new Base();
        pom =new PageObjectManager(base.initializeDriver());
        basic=new BasicOperations(base.initializeDriver());
        common = new Common(base.initializeDriver());
        ddt=new ColumnDataDriven();
    }
}
