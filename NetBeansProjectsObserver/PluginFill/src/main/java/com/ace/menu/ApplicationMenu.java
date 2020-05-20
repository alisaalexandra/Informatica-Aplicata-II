package com.ace.menu;

import com.ace.draw.Sketch;
import com.ace.exceptions.PositionNotFoundException;
import com.ace.plugins.PluginManager;
import com.ace.pluginfill.interfaces.IShape;
import java.util.ArrayList;
import java.util.Scanner;

public class ApplicationMenu{
    
    private PluginManager pluginMan;
    private Menu mainMenu = null;
    private Menu submenu = null;
    private Sketch sketch;
    public ApplicationMenu(PluginManager pluginMan,Sketch sketch)
    {
        this.pluginMan = pluginMan;       
        this.sketch = sketch;
    }
    
    public void load()
    {
        Scanner scanner = new Scanner(System.in);
        pluginMan.loadPlugins("/plugins");
        ArrayList<IMenuItem> menuItems = new ArrayList();
        
        int shortCut = 1;
        var plugins = pluginMan.getPlugins();
        
        for (int i = 0 ; i < plugins.size(); i++)
        {      
           var currentPlugin = plugins.get(i); 
           MenuItem currentItem = new MenuItem(plugins.get(i).getDisplayText(), shortCut++, (parameters)->{
               IShape shape = currentPlugin.getShape();
               sketch.setShape(shape);
               sketch.add();
           });
           menuItems.add(currentItem);
           
        }
        submenu=new Menu("Add shape",1,menuItems);
        mainMenu = new Menu("Main Menu", -1);
        mainMenu.addItem(1, "Add shape",(parameters)->{
               submenu.execute();
           });   
        mainMenu.addItem(2, "View canvas", (parameters) ->{
            sketch.print();
        });
        mainMenu.addItem(3, "Modify shape", (parameters) ->{
            sketch.print();
            try{
            sketch.modifyShape(scanner.nextInt());
            } catch(PositionNotFoundException | IndexOutOfBoundsException e){
                System.out.println("Missmatch input");
            }
           
        });
        mainMenu.addItem(4, "Remove shape", (parameters) ->{
            sketch.print();
            try{
            sketch.delete(scanner.nextInt());
            } catch(PositionNotFoundException | IndexOutOfBoundsException e){
                System.out.println("Missmatch input");
            }
        });
    }
    
    public void execute()
    {
        mainMenu.execute();
    }
    
}
