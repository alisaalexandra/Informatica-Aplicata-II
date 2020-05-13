
package com.ace.circleplugin;

import com.ace.pluginfill.interfaces.IPluginsAppPlugin;
import com.ace.pluginfill.interfaces.IShape;

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