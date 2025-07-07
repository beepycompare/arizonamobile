package com.google.android.vending.expansion.downloader.impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDoneException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.provider.BaseColumns;
import android.util.Log;
import com.android.vending.expansion.zipfile.APEZProvider;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* loaded from: classes4.dex */
public class DownloadsDB {
    private static final int CONTROL_IDX = 7;
    private static final int CURRENTBYTES_IDX = 4;
    private static final String DATABASE_NAME = "DownloadsDB";
    private static final int DATABASE_VERSION = 7;
    private static final String[] DC_PROJECTION = {DownloadColumns.FILENAME, DownloadColumns.URI, DownloadColumns.ETAG, DownloadColumns.TOTALBYTES, DownloadColumns.CURRENTBYTES, DownloadColumns.LASTMOD, DownloadColumns.STATUS, DownloadColumns.CONTROL, DownloadColumns.NUM_FAILED, DownloadColumns.RETRY_AFTER, DownloadColumns.REDIRECT_COUNT, DownloadColumns.INDEX};
    private static final int ETAG_IDX = 2;
    private static final int FILENAME_IDX = 0;
    private static final int INDEX_IDX = 11;
    private static final int LASTMOD_IDX = 5;
    public static final String LOG_TAG = "com.google.android.vending.expansion.downloader.impl.DownloadsDB";
    private static final int NUM_FAILED_IDX = 8;
    private static final int REDIRECT_COUNT_IDX = 10;
    private static final int RETRY_AFTER_IDX = 9;
    private static final int STATUS_IDX = 6;
    private static final int TOTALBYTES_IDX = 3;
    private static final int URI_IDX = 1;
    private static DownloadsDB mDownloadsDB;
    int mFlags;
    SQLiteStatement mGetDownloadByIndex;
    final SQLiteOpenHelper mHelper;
    long mMetadataRowID;
    int mStatus;
    SQLiteStatement mUpdateCurrentBytes;
    int mVersionCode;

    /* loaded from: classes4.dex */
    public static class DownloadColumns implements BaseColumns {
        public static final String TABLE_NAME = "DownloadColumns";
        public static final String _ID = "DownloadColumns._id";
        public static final String INDEX = "FILEIDX";
        public static final String URI = "URI";
        public static final String FILENAME = "FN";
        public static final String ETAG = "ETAG";
        public static final String TOTALBYTES = "TOTALBYTES";
        public static final String CURRENTBYTES = "CURRENTBYTES";
        public static final String LASTMOD = "LASTMOD";
        public static final String STATUS = "STATUS";
        public static final String CONTROL = "CONTROL";
        public static final String NUM_FAILED = "FAILCOUNT";
        public static final String RETRY_AFTER = "RETRYAFTER";
        public static final String REDIRECT_COUNT = "REDIRECTCOUNT";
        public static final String[][] SCHEMA = {new String[]{APEZProvider.FILEID, "INTEGER PRIMARY KEY"}, new String[]{INDEX, "INTEGER UNIQUE"}, new String[]{URI, "TEXT"}, new String[]{FILENAME, "TEXT UNIQUE"}, new String[]{ETAG, "TEXT"}, new String[]{TOTALBYTES, "INTEGER"}, new String[]{CURRENTBYTES, "INTEGER"}, new String[]{LASTMOD, "INTEGER"}, new String[]{STATUS, "INTEGER"}, new String[]{CONTROL, "INTEGER"}, new String[]{NUM_FAILED, "INTEGER"}, new String[]{RETRY_AFTER, "INTEGER"}, new String[]{REDIRECT_COUNT, "INTEGER"}};
    }

    /* loaded from: classes4.dex */
    protected static class DownloadsContentDBHelper extends SQLiteOpenHelper {
        private static final String[][][] sSchemas = {DownloadColumns.SCHEMA, MetadataColumns.SCHEMA};
        private static final String[] sTables = {DownloadColumns.TABLE_NAME, MetadataColumns.TABLE_NAME};

        DownloadsContentDBHelper(Context context) {
            super(context, DownloadsDB.DATABASE_NAME, (SQLiteDatabase.CursorFactory) null, 7);
        }

        private String createTableQueryFromArray(String str, String[][] strArr) {
            StringBuilder sb = new StringBuilder();
            sb.append("CREATE TABLE ");
            sb.append(str);
            sb.append(" (");
            for (String[] strArr2 : strArr) {
                sb.append(' ');
                sb.append(strArr2[0]);
                sb.append(' ');
                sb.append(strArr2[1]);
                sb.append(AbstractJsonLexerKt.COMMA);
            }
            sb.setLength(sb.length() - 1);
            sb.append(");");
            return sb.toString();
        }

        private void dropTables(SQLiteDatabase sQLiteDatabase) {
            String[] strArr = sTables;
            int length = strArr.length;
            for (int i = 0; i < length; i++) {
                try {
                    sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + strArr[i]);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            int length = sSchemas.length;
            for (int i = 0; i < length; i++) {
                try {
                    sQLiteDatabase.execSQL(createTableQueryFromArray(sTables[i], sSchemas[i]));
                } catch (Exception e) {
                    while (true) {
                        e.printStackTrace();
                    }
                }
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Log.w(DownloadsContentDBHelper.class.getName(), "Upgrading database from version " + i + " to " + i2 + ", which will destroy all old data");
            dropTables(sQLiteDatabase);
            onCreate(sQLiteDatabase);
        }
    }

    /* loaded from: classes4.dex */
    public static class MetadataColumns implements BaseColumns {
        public static final String APKVERSION = "APKVERSION";
        public static final String DOWNLOAD_STATUS = "DOWNLOADSTATUS";
        public static final String FLAGS = "DOWNLOADFLAGS";
        public static final String[][] SCHEMA = {new String[]{APEZProvider.FILEID, "INTEGER PRIMARY KEY"}, new String[]{APKVERSION, "INTEGER"}, new String[]{DOWNLOAD_STATUS, "INTEGER"}, new String[]{FLAGS, "INTEGER"}};
        public static final String TABLE_NAME = "MetadataColumns";
        public static final String _ID = "MetadataColumns._id";
    }

    private DownloadsDB(Context context) {
        this.mMetadataRowID = -1L;
        this.mVersionCode = -1;
        this.mStatus = -1;
        DownloadsContentDBHelper downloadsContentDBHelper = new DownloadsContentDBHelper(context);
        this.mHelper = downloadsContentDBHelper;
        Cursor rawQuery = downloadsContentDBHelper.getReadableDatabase().rawQuery("SELECT APKVERSION,_id,DOWNLOADSTATUS,DOWNLOADFLAGS FROM MetadataColumns LIMIT 1", null);
        if (rawQuery != null) {
            if (rawQuery.moveToFirst()) {
                this.mVersionCode = rawQuery.getInt(0);
                this.mMetadataRowID = rawQuery.getLong(1);
                this.mStatus = rawQuery.getInt(2);
                this.mFlags = rawQuery.getInt(3);
            }
            rawQuery.close();
        }
        mDownloadsDB = this;
    }

    public static DownloadsDB getDB(Context context) {
        DownloadsDB downloadsDB;
        synchronized (DownloadsDB.class) {
            try {
                downloadsDB = mDownloadsDB;
                if (downloadsDB == null) {
                    downloadsDB = new DownloadsDB(context);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return downloadsDB;
    }

    private SQLiteStatement getDownloadByIndexStatement() {
        if (this.mGetDownloadByIndex == null) {
            this.mGetDownloadByIndex = this.mHelper.getReadableDatabase().compileStatement("SELECT _id FROM DownloadColumns WHERE FILEIDX = ?");
        }
        return this.mGetDownloadByIndex;
    }

    private SQLiteStatement getUpdateCurrentBytesStatement() {
        if (this.mUpdateCurrentBytes == null) {
            this.mUpdateCurrentBytes = this.mHelper.getReadableDatabase().compileStatement("UPDATE DownloadColumns SET CURRENTBYTES = ? WHERE FILEIDX = ?");
        }
        return this.mUpdateCurrentBytes;
    }

    public void close() {
        this.mHelper.close();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public DownloadInfo getDownloadInfoByFileName(String str) {
        Cursor cursor = null;
        try {
            Cursor query = this.mHelper.getReadableDatabase().query(DownloadColumns.TABLE_NAME, DC_PROJECTION, "FN = ?", new String[]{str}, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        DownloadInfo downloadInfoFromCursor = getDownloadInfoFromCursor(query);
                        if (query != null) {
                            query.close();
                        }
                        return downloadInfoFromCursor;
                    }
                } catch (Throwable th) {
                    th = th;
                    cursor = query;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            if (query != null) {
                query.close();
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public DownloadInfo getDownloadInfoFromCursor(Cursor cursor) {
        DownloadInfo downloadInfo = new DownloadInfo(cursor.getInt(11), cursor.getString(0), getClass().getPackage().getName());
        setDownloadInfoFromCursor(downloadInfo, cursor);
        return downloadInfo;
    }

    public DownloadInfo[] getDownloads() {
        Cursor cursor = null;
        try {
            Cursor query = this.mHelper.getReadableDatabase().query(DownloadColumns.TABLE_NAME, DC_PROJECTION, null, null, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        DownloadInfo[] downloadInfoArr = new DownloadInfo[query.getCount()];
                        int i = 0;
                        while (true) {
                            downloadInfoArr[i] = getDownloadInfoFromCursor(query);
                            if (!query.moveToNext()) {
                                break;
                            }
                            i++;
                        }
                        if (query != null) {
                            query.close();
                        }
                        return downloadInfoArr;
                    }
                } catch (Throwable th) {
                    th = th;
                    cursor = query;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            if (query != null) {
                query.close();
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public int getFlags() {
        return this.mFlags;
    }

    public long getIDByIndex(int i) {
        SQLiteStatement downloadByIndexStatement = getDownloadByIndexStatement();
        downloadByIndexStatement.clearBindings();
        downloadByIndexStatement.bindLong(1, i);
        try {
            return downloadByIndexStatement.simpleQueryForLong();
        } catch (SQLiteDoneException unused) {
            return -1L;
        }
    }

    public long getIDForDownloadInfo(DownloadInfo downloadInfo) {
        return getIDByIndex(downloadInfo.mIndex);
    }

    public int getLastCheckedVersionCode() {
        return this.mVersionCode;
    }

    public boolean isDownloadRequired() {
        Cursor rawQuery = this.mHelper.getReadableDatabase().rawQuery("SELECT Count(*) FROM DownloadColumns WHERE STATUS <> 0", null);
        if (rawQuery != null) {
            try {
                if (rawQuery.moveToFirst()) {
                    return rawQuery.getInt(0) == 0;
                }
            } finally {
                if (rawQuery != null) {
                    rawQuery.close();
                }
            }
        }
        if (rawQuery != null) {
            rawQuery.close();
        }
        return true;
    }

    public void setDownloadInfoFromCursor(DownloadInfo downloadInfo, Cursor cursor) {
        downloadInfo.mUri = cursor.getString(1);
        downloadInfo.mETag = cursor.getString(2);
        downloadInfo.mTotalBytes = cursor.getLong(3);
        downloadInfo.mCurrentBytes = cursor.getLong(4);
        downloadInfo.mLastMod = cursor.getLong(5);
        downloadInfo.mStatus = cursor.getInt(6);
        downloadInfo.mControl = cursor.getInt(7);
        downloadInfo.mNumFailed = cursor.getInt(8);
        downloadInfo.mRetryAfter = cursor.getInt(9);
        downloadInfo.mRedirectCount = cursor.getInt(10);
    }

    public boolean updateDownload(DownloadInfo downloadInfo) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadColumns.INDEX, Integer.valueOf(downloadInfo.mIndex));
        contentValues.put(DownloadColumns.FILENAME, downloadInfo.mFileName);
        contentValues.put(DownloadColumns.URI, downloadInfo.mUri);
        contentValues.put(DownloadColumns.ETAG, downloadInfo.mETag);
        contentValues.put(DownloadColumns.TOTALBYTES, Long.valueOf(downloadInfo.mTotalBytes));
        contentValues.put(DownloadColumns.CURRENTBYTES, Long.valueOf(downloadInfo.mCurrentBytes));
        contentValues.put(DownloadColumns.LASTMOD, Long.valueOf(downloadInfo.mLastMod));
        contentValues.put(DownloadColumns.STATUS, Integer.valueOf(downloadInfo.mStatus));
        contentValues.put(DownloadColumns.CONTROL, Integer.valueOf(downloadInfo.mControl));
        contentValues.put(DownloadColumns.NUM_FAILED, Integer.valueOf(downloadInfo.mNumFailed));
        contentValues.put(DownloadColumns.RETRY_AFTER, Integer.valueOf(downloadInfo.mRetryAfter));
        contentValues.put(DownloadColumns.REDIRECT_COUNT, Integer.valueOf(downloadInfo.mRedirectCount));
        return updateDownload(downloadInfo, contentValues);
    }

    public boolean updateDownload(DownloadInfo downloadInfo, ContentValues contentValues) {
        long iDForDownloadInfo = downloadInfo == null ? -1L : getIDForDownloadInfo(downloadInfo);
        try {
            SQLiteDatabase writableDatabase = this.mHelper.getWritableDatabase();
            if (iDForDownloadInfo == -1) {
                return -1 != writableDatabase.insert(DownloadColumns.TABLE_NAME, DownloadColumns.URI, contentValues);
            }
            writableDatabase.update(DownloadColumns.TABLE_NAME, contentValues, "DownloadColumns._id = " + iDForDownloadInfo, null);
            return false;
        } catch (SQLiteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void updateDownloadCurrentBytes(DownloadInfo downloadInfo) {
        SQLiteStatement updateCurrentBytesStatement = getUpdateCurrentBytesStatement();
        updateCurrentBytesStatement.clearBindings();
        updateCurrentBytesStatement.bindLong(1, downloadInfo.mCurrentBytes);
        updateCurrentBytesStatement.bindLong(2, downloadInfo.mIndex);
        updateCurrentBytesStatement.execute();
    }

    public boolean updateFlags(int i) {
        if (this.mFlags != i) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(MetadataColumns.FLAGS, Integer.valueOf(i));
            if (updateMetadata(contentValues)) {
                this.mFlags = i;
                return true;
            }
            return false;
        }
        return true;
    }

    public boolean updateFromDb(DownloadInfo downloadInfo) {
        Cursor cursor = null;
        try {
            cursor = this.mHelper.getReadableDatabase().query(DownloadColumns.TABLE_NAME, DC_PROJECTION, "FN= ?", new String[]{downloadInfo.mFileName}, null, null, null);
            if (cursor == null || !cursor.moveToFirst()) {
                if (cursor != null) {
                    cursor.close();
                }
                return false;
            }
            setDownloadInfoFromCursor(downloadInfo, cursor);
            if (cursor != null) {
                cursor.close();
            }
            return true;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public boolean updateMetadata(int i, int i2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(MetadataColumns.APKVERSION, Integer.valueOf(i));
        contentValues.put(MetadataColumns.DOWNLOAD_STATUS, Integer.valueOf(i2));
        if (updateMetadata(contentValues)) {
            this.mVersionCode = i;
            this.mStatus = i2;
            return true;
        }
        return false;
    }

    public boolean updateMetadata(ContentValues contentValues) {
        SQLiteDatabase writableDatabase = this.mHelper.getWritableDatabase();
        if (-1 != this.mMetadataRowID) {
            return writableDatabase.update(MetadataColumns.TABLE_NAME, contentValues, new StringBuilder("_id = ").append(this.mMetadataRowID).toString(), null) != 0;
        }
        long insert = writableDatabase.insert(MetadataColumns.TABLE_NAME, MetadataColumns.APKVERSION, contentValues);
        if (-1 == insert) {
            return false;
        }
        this.mMetadataRowID = insert;
        return true;
    }

    public boolean updateStatus(int i) {
        if (this.mStatus != i) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(MetadataColumns.DOWNLOAD_STATUS, Integer.valueOf(i));
            if (updateMetadata(contentValues)) {
                this.mStatus = i;
                return true;
            }
            return false;
        }
        return true;
    }
}
