/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.firstsampleproject;

/**
 *
 * @author catalin
 */
public interface IMenuItem {
    String getText();
    int getShortCut();

    void render();
    void execute();
}