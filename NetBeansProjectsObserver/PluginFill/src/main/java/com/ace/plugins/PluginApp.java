package com.ace.plugins;

import com.ace.draw.Sketch;
import com.ace.menu.ApplicationMenu;
import com.ace.pluginfill.interfaces.IShape;

public class PluginApp {
    public static void main(String[] args)
    {
        PluginManager pluginMan = new PluginManager();
        Sketch sketch = new Sketch();
       
        ApplicationMenu menu = new ApplicationMenu(pluginMan,sketch);
        menu.load();
        menu.execute();        
    }
    
}
