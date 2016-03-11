package com.pascal.counterdb;

import io.realm.RealmObject;

/**
 * @author alexfacciorusso
 * @since 11/03/16
 */
public class GlobalData extends RealmObject {
    private int counter;

    public int getCounter() {
        return counter;
    }

    public void setCounter(int nuovoValore) {
        counter = nuovoValore;
    }

    public void incrementa() {
        counter = counter + 1;
    }
}
