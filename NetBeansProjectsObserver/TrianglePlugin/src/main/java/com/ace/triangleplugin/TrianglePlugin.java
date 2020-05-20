
package com.ace.triangleplugin;

import com.ace.pluginfill.interfaces.IPluginsAppPlugin;
import com.ace.pluginfill.interfaces.IShape;

public class TrianglePlugin implements IPluginsAppPlugin {

    @Override
    public String getUniqueNameText() {
        return "TrianglePlugin";
    }

    @Override
    public String getDisplayText() {
        return "Triangle";
    }

    @Override
    public IShape getShape() {
        return new Triangle();
    }
    
}
