/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package jUnitTest.web.modules;

import org.junit.Assert;
import org.junit.Test;
import web.modules.ModuleController;

public class ModuleControllerTest {

    @Test
    public void getViewName(){
        ModuleController moduleController = new ModuleController();
//        moduleController.getViewModule();
        Assert.assertEquals("getViewModule path '/index'<br>This page is index", moduleController.getViewName("/index"));

        Assert.assertEquals("getViewModule path '/'<br>This page is root.", moduleController.getViewName("/"));


    }

}