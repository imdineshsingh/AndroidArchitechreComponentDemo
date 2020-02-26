package com.dinesh.sheduleit.sqlite.dbOperations;

public class Note {  //Model to manage nOtes easily
    /*
    In this class we define the SQLite table name, column names and create table SQL query along with getter / setter methods.

    *The `notes` table needs three columns i.e `id`, `note` and `timestamp`.
    *Column `id` is defined as Primary Key and Auto Increment which means each note will be uniquely identified by its id.
    *Column `note` stores the actual note text.
    *Column `timestamp` stores the date and time of the note that is created
     */

    public static final String TABLE_NAME="notes";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NOTE = "note";
    public static final String COLUMN_TIMESTAMP = "timestamp";

    private int id;
    private String note;
    private String timestamp;

    //create table sql queries
    public static final String CREATE_TABLE=
            "CREATE TABLE "+TABLE_NAME+"("
                    +COLUMN_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"
                    +COLUMN_NOTE+" TEXT,"
            +COLUMN_TIMESTAMP+" DATETIME DEFAULT CURRENT_TIMESTAMP"
                    +")";


    //CONSTRUCTORS AND GETTER SETTER
    public Note(){ }

    public Note(int id, String note, String timestamp) {
        this.id = id;
        this.note = note;
        this.timestamp = timestamp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
