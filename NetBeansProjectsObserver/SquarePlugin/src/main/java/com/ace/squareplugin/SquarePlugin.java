
package com.ace.squareplugin;

import com.ace.pluginfill.interfaces.*;

public class SquarePlugin implements IPluginsAppPlugin {

    @Override
    public String getUniqueNameText() {
        return "SquarePlugin";
    }

    @Override
    public String getDisplayText() {
        return "Square";
    }

    @Override
    public IShape getShape() {
        return new Square();
    }
    
}
