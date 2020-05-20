package com.ace.rectangleplugin;

import com.ace.pluginfill.interfaces.IPluginsAppPlugin;
import com.ace.pluginfill.interfaces.IShape;

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
