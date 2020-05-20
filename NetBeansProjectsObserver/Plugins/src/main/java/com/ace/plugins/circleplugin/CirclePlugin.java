/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ace.plugins.circleplugin;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.ace.pluginfill.interfaces.IPluginsAppPlugin;
import com.ace.pluginfill.interfaces.IShape;
/**
 *
 * @author catalin
 */
public class CirclePlugin implements IPluginsAppPlugin {

    @Override
    public String getUniqueNameText() {
        return "CirclePlugin";
    }

    @Override
    public String getDisplayText() {
        return "Circle";
    }

    @Override
    public IShape getShape() {
        return new Circle();
    }
    
}