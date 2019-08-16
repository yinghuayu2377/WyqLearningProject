package com.example.sd.learningproject.contentProvider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import com.example.sd.learningproject.storage.sql.MyDatabaseHelper;

/**
 * 自定义内容提供器--供其他应用获取数据
 */
public class MyContentProvider extends ContentProvider {
    public static final int Book_DIR = 0;
    public static final int Book_ITEM = 1;
    public static final int Category_DIR = 2;
    public static final int Category_ITEM = 3;
    public static final String AUTHORITY = "com.example.sd.learningproject.provider";
    private static UriMatcher mUriMatcher;
    private MyDatabaseHelper mDbHelper;

    static {
        mUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        mUriMatcher.addURI(AUTHORITY, "book", Book_DIR);
        mUriMatcher.addURI(AUTHORITY, "book/#", Book_ITEM);
        mUriMatcher.addURI(AUTHORITY, "category", Category_DIR);
        mUriMatcher.addURI(AUTHORITY, "category/#", Category_ITEM);
    }

    @Override
    public boolean onCreate() {
        mDbHelper = new MyDatabaseHelper(getContext(), "BookStore.db", null, 3);
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        SQLiteDatabase sqLiteDatabase = mDbHelper.getReadableDatabase();
        Cursor cursor = null;
        switch (mUriMatcher.match(uri)) {
            case Book_DIR:
                // 查询table1表中所有的数据
                cursor = sqLiteDatabase.query("Book", projection, selection, selectionArgs, null, null, sortOrder);
                break;
            case Book_ITEM:
                // 查询table1表中的单条数据
                String bookId = uri.getPathSegments().get(1);
                cursor = sqLiteDatabase.query("Book", projection, "id = ?", new String[]{bookId}, null, null, sortOrder);
                break;
            case Category_DIR:
                cursor = sqLiteDatabase.query("Category", projection, selection, selectionArgs, null, null, sortOrder);
                // 查询table2表中所有的数据
                break;
            case Category_ITEM:
                // 查询table2表中的单条数据
                String categoryId = uri.getPathSegments().get(1);
                cursor = sqLiteDatabase.query("Category", projection, "id = ?", new String[]{categoryId}, null, null, sortOrder);
                break;
        }
        return cursor;
    }

    @Override
    public String getType(Uri uri) {
        switch (mUriMatcher.match(uri)) {
            case Book_DIR:
                return "vnd.android.cursor.dir/vnd.com.example.sd.learningproject.provider.book";
            case Book_ITEM:
                return "vnd.android.cursor.item/vnd.com.example.sd.learningproject.provider.book";
            case Category_DIR:
                return "vnd.android.cursor.dir/vnd.com.example.sd.learningproject.provider.category";
            case Category_ITEM:
                return "vnd.android.cursor.item/vnd.com.example.sd.learningproject.provider.category";
        }
        return null;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        SQLiteDatabase sqLiteDatabase = mDbHelper.getWritableDatabase();
        Uri uriReturn = null;
        switch (mUriMatcher.match(uri)) {
            case Book_DIR:
            case Book_ITEM:
                long newBookId = sqLiteDatabase.insert("Book", null, values);
                uriReturn = Uri.parse("content://" + AUTHORITY + "/book/" + newBookId);
                break;
            case Category_DIR:
            case Category_ITEM:
                long newCategoryId = sqLiteDatabase.insert("Category", null, values);
                uriReturn = Uri.parse("content://" + AUTHORITY + "/category/" + newCategoryId);
                break;
        }
        return uriReturn;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        SQLiteDatabase sqLiteDatabase = mDbHelper.getReadableDatabase();
        int deleteRows = 0;
        switch (mUriMatcher.match(uri)) {
            case Book_DIR:
                deleteRows = sqLiteDatabase.delete("Book", selection, selectionArgs);
                break;
            case Book_ITEM:
                String bookId = uri.getPathSegments().get(1);  // 第0个位置存放的是路径，1个位置存放的是id
                deleteRows = sqLiteDatabase.delete("Book", "id = ?", new String[]{bookId});
                break;
            case Category_DIR:
                deleteRows = sqLiteDatabase.delete("Category", selection, selectionArgs);
                break;
            case Category_ITEM:
                String categoryId = uri.getPathSegments().get(1);
                deleteRows = sqLiteDatabase.delete("Category", "id = ?", new String[]{categoryId});
                break;
        }
        return deleteRows;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        SQLiteDatabase sqLiteDatabase = mDbHelper.getReadableDatabase();
        int updateRows = 0;
        switch (mUriMatcher.match(uri)) {
            case Book_DIR:
                updateRows = sqLiteDatabase.update("Book", values, selection, selectionArgs);
                break;
            case Book_ITEM:
                String bookId = uri.getPathSegments().get(1);
                updateRows = sqLiteDatabase.update("Book", values, "id = ?", new String[]{bookId});
                break;
            case Category_DIR:
                updateRows = sqLiteDatabase.update("Category", values, selection, selectionArgs);
                break;
            case Category_ITEM:
                String categoryId = uri.getPathSegments().get(1);
                updateRows = sqLiteDatabase.update("Category", values, "id = ?", new String[]{categoryId});
                break;
        }
        return updateRows;
    }
}
