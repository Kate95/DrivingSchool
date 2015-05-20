/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drivingschool.controller;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 *
 * @author Kate
 */
public class ConfigurationManager {

    private static ConfigurationManager instance;
    private ResourceBundle resourceBundle;

//класс извлекает информацию из файла config.properties 
    private static final String BUNDLE_NAME = "drivingschool.controller.config";

    public static final String ADMIN_LOGIN = "ADMIN_LOGIN";
    public static final String ADMIN_PASSWORD = "ADMIN_PASSWORD";

    public static ConfigurationManager getInstance() {
        if (instance == null) {
            instance = new ConfigurationManager();
            instance.resourceBundle = ResourceBundle.getBundle(BUNDLE_NAME, Locale.ENGLISH);
        }
        return instance;
    }

    public String getProperty(String key) {
        return (String)resourceBundle.getObject(key);
    }
}
