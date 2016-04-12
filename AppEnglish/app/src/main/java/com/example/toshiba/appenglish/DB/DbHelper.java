package com.example.toshiba.appenglish.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

/*
 * Created by Toshiba on 27/2/2559.
 */
public class DbHelper extends SQLiteAssetHelper {
    private static final int DATABASE_VERSION = 27;
    private static Context myContext;
    /*// Database Name
    private static final String DATABASE_NAME = "triviaQuiz";
    // tasks table name
    private static final String TABLE_QUEST = "quest";
    // tasks Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_QUES = "question";
    private static final String KEY_ANSWER = "answer"; //correct option
    private static final String KEY_OPTA= "opta"; //option a
    private static final String KEY_OPTB= "optb"; //option b
    private static final String KEY_OPTC= "optc"; //option c*/

    private SQLiteDatabase dbase;

    private static final String DATABASE_NAME = "db.sqlite";
    //private static String path = "";
    //private static final String path = "data/data/com.example.toshiba.appenglish/databases/";
    //private String path = myContext.getApplicationContext().getPackageName()+"/databases/";
    //private static final String path = "/data/data/" + myContext.getApplicationContext().getPackageName() + "/databases/";
    //private static String DB_path = path+DATABASE_NAME;
/*

    // tasks table name
    private static final String TABLE_QUEST = "Question";
    // tasks Table Columns names
    private static final String ID_QUES1 = "id_question";
    private static final String QUES = "question";
    private static final String ID_TENSE1 = "id_tense";

    // tasks table name
    private static final String TABLE_ANS= "answer";
    // tasks Table Columns names
    private static final String ID_ANS = "id_answer";
    private static final String ANS = "answer";
    private static final String KEY_BOOL = "key";
    private static final String ID_QUES2 = "id_question";

    // tasks table name
    private static final String TABLE_TENSE= "TENSE";
    // tasks Table Columns names
    private static final String ID_TENSE2 = "id_tense";
    private static final String TENSE_NAME = "tense_name";
*/




/*    private static DbHelper sInstance;

    public static synchronized DbHelper getInstance(Context context) {

        // Use the application context, which will ensure that you
        // don't accidentally leak an Activity's context.
        // See this article for more information: http://bit.ly/6LRzfx
        if (sInstance == null) {
            sInstance = new DbHelper(context.getApplicationContext());
        }
        return sInstance;
    }*/

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        //this.myContext=context;
        setForcedUpgrade(DATABASE_VERSION);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + db);
// Create tables again
        onCreate(db);

    }

/*    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }*/

    /////
/*
    *//**
     * Creates a empty database on the system and rewrites it with your own database.
     * *//*
    public void createDataBase() {
        //throws IOException
        boolean dbExist = checkDataBase();

        if(dbExist){
            //do nothing - database already exist
            Log.d("TAG", "DB already exist");
        }else{

            //By calling this method and empty database will be created into the default system path
            //of your application so we are gonna be able to overwrite that database with our database.
            this.getReadableDatabase();

            try {

                copyDataBase();

            } catch (IOException e) {

                //throw new Error("Error copying database");
                Log.d("TAG","Error copying database");

            }
        }

    }

    *//**
      Check if the database already exist to avoid re-copying the file each time you open the application.
      @return true if it exists, false if it doesn't
     **//*
    public boolean checkDataBase(){

        SQLiteDatabase checkDB = null;

        try{
            String myPath = path + DATABASE_NAME;
            checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);

        }catch(SQLiteException e){

            //database does't exist yet.

        }

        if(checkDB != null){

            checkDB.close();

        }

        return checkDB != null ? true : false;
    }

    *//**
      Copies your database from your local assets-folder to the just created empty database in the
      system folder, from where it can be accessed and handled.
      This is done by transfering bytestream.
      **//*
    private void copyDataBase() throws IOException {

        //String url = "/data/data/" + myContext.getApplicationContext().getPackageName() + "/databases/db";
        //Open your local db as the input stream
        InputStream myInput = myContext.getAssets().open(DATABASE_NAME);
        //InputStream myInput = myContext.getAssets().open("db");
        // Path to the just created empty db
        String outFileName = path + DATABASE_NAME;

        //Open the empty db as the output stream
        OutputStream myOutput = new FileOutputStream(outFileName);
        //OutputStream myOutput = new FileOutputStream(myContext.getApplicationContext().getPackageName()+"/databases/");

        //transfer bytes from the inputfile to the outputfile
        byte[] buffer = new byte[1024];
        int length;
        while ((length = myInput.read(buffer))>0){
            myOutput.write(buffer, 0, length);
        }

        //Close the streams
        myOutput.flush();
        myOutput.close();
        myInput.close();

    }

    public void openDataBase() throws SQLException {

        //Open the database
        String myPath = path + DATABASE_NAME;
        dbase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);

    }

    @Override
    public synchronized void close() {

        if(dbase != null)
            dbase.close();

        super.close();

    }

    */
    ///

/*    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + db);
// Create tables again
        onCreate(db);

    }*/


/*    @Override
    public void onCreate(SQLiteDatabase db) {
        dbase=db;
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_QUEST + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
                + " TEXT, " + KEY_ANSWER+ " TEXT, "+KEY_OPTA +" TEXT, "
                +KEY_OPTB +" TEXT, "+KEY_OPTC+" TEXT)";


        db.execSQL(sql);
        addQuestions();
        //db.close();
    }*/
    /*@Override
    public void onCreate(SQLiteDatabase db) {
        dbase=db;
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_QUEST + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
                + " TEXT, " + KEY_ANSWER+ " TEXT, "+KEY_OPTA +" TEXT, "
                +KEY_OPTB +" TEXT, "+KEY_OPTC+" TEXT)";
        db.execSQL(sql);
        Question q1=new Question("Which company is the largest manufacturer" +
                " of network equipment?","HP", "IBM", "CISCO", "C");
        this.addQuestion(q1);
        Question q2=new Question("Which of the following is NOT " +
                "an operating system?", "SuSe", "BIOS", "DOS", "B");
        this.addQuestion(q2);
        Question q3=new Question("Which of the following is the fastest" +
                " writable memory?","RAM", "FLASH","Register","C");
        this.addQuestion(q3);
        Question q4=new Question("Which of the following device" +
                " regulates internet traffic?",    "Router", "Bridge", "Hub","A");
        this.addQuestion(q4);
        Question q5=new Question("Which of the following is NOT an" +
                " interpreted language?","Ruby","Python","BASIC","C");
        this.addQuestion(q5);
        //db.close();
    }
*/

/*    private void addQuestions()
    {
        Question q1=new Question("Which company is the largest manufacturer" +
                " of network equipment?","HP", "IBM", "CISCO", "C");
        this.addQuestion(q1);
        Question q2=new Question("Which of the following is NOT " +
                "an operating system?", "SuSe", "BIOS", "DOS", "B");
        this.addQuestion(q2);
        Question q3=new Question("Which of the following is the fastest" +
                " writable memory?","RAM", "FLASH","Register","C");
        this.addQuestion(q3);
        Question q4=new Question("Which of the following device" +
                " regulates internet traffic?",    "Router", "Bridge", "Hub","A");
        this.addQuestion(q4);
        Question q5=new Question("Which of the following is NOT an" +
                " interpreted language?","Ruby","Python","BASIC","C");
        this.addQuestion(q5);
    }*/
    /*@Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
// Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUEST);
// Create tables again
        onCreate(db);
    }
    // Adding new question
    public void addQuestion(Question quest) {
//SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_QUES, quest.getQUESTION());
        values.put(KEY_ANSWER, quest.getANSWER());
        values.put(KEY_OPTA, quest.getOPTA());
        values.put(KEY_OPTB, quest.getOPTB());
        values.put(KEY_OPTC, quest.getOPTC());
// Inserting Row
        dbase.insert(TABLE_QUEST, null, values);
    }
    public List<Question> getAllQuestions() {
        List<Question> quesList = new ArrayList<Question>();
// Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_QUEST;
        dbase=this.getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuery, null);
// looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Question quest = new Question();
                quest.setID(cursor.getInt(0));
                quest.setQUESTION(cursor.getString(1));
                quest.setANSWER(cursor.getString(2));
                quest.setOPTA(cursor.getString(3));
                quest.setOPTB(cursor.getString(4));
                quest.setOPTC(cursor.getString(5));
                quesList.add(quest);
            } while (cursor.moveToNext());
        }

// return quest list
        return quesList;
    }
    public int rowcount()
    {
        int row=0;
        String selectQuery = "SELECT  * FROM " + TABLE_QUEST;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        row=cursor.getCount();
        return row;
    }*/
}
