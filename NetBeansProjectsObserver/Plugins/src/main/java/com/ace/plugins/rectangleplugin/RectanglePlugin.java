/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ace.plugins.rectangleplugin;

import com.ace.pluginfill.interfaces.IPluginsAppPlugin;
import com.ace.pluginfill.interfaces.IShape;

/**
 *
 * @author Ali
 */
public class RectanglePlugin implements IPluginsAppPlugin {

    @Override
    public String getUniqueNameText() {
        return "RectanglePlugin";
    }

    @Override
    public String getDisplayText() {
        return "Rectangle";
    }

    @Override
    public IShape getShape() {
        return new Rectangle();
    }
    
}
