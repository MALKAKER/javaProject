package com.javaproject.malki.projectstepone.model.backend;

import com.javaproject.malki.projectstepone.model.DataSource.ListDbManager;
import com.javaproject.malki.projectstepone.model.DataSource.List_DB;

/**
 * factory for the DB
 * Created by malki on 20-Nov-17.
 */

public class DbManagerFactory {
    private final DbManagerFactory factory = new DbManagerFactory();
    public DB_Manager DbType()
    {
        //here the type of the DB , if the type is changed,
        //the developer needs only to change that line
        return new ListDbManager();
    }
}
