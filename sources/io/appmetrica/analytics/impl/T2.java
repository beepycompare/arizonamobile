package io.appmetrica.analytics.impl;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import io.appmetrica.analytics.coreapi.internal.data.IBinaryDataHelper;
/* loaded from: classes5.dex */
public final class T2 implements IBinaryDataHelper {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0741z6 f687a;
    public final String b;

    public T2(InterfaceC0741z6 interfaceC0741z6, String str) {
        this.f687a = interfaceC0741z6;
        this.b = str;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.IBinaryDataHelper
    public final byte[] get(String str) {
        Cursor cursor;
        SQLiteDatabase sQLiteDatabase;
        try {
            sQLiteDatabase = this.f687a.a();
        } catch (Throwable unused) {
            cursor = null;
            sQLiteDatabase = null;
        }
        if (sQLiteDatabase != null) {
            try {
                cursor = sQLiteDatabase.query(this.b, null, "data_key = ?", new String[]{str}, null, null, null);
                if (cursor != null) {
                    try {
                        if (cursor.getCount() == 1 && cursor.moveToFirst()) {
                            byte[] blob = cursor.getBlob(cursor.getColumnIndexOrThrow("value"));
                            mo.a(cursor);
                            this.f687a.a(sQLiteDatabase);
                            return blob;
                        }
                    } catch (Throwable unused2) {
                    }
                }
                if (cursor != null) {
                    cursor.getCount();
                }
            } catch (Throwable unused3) {
            }
            mo.a(cursor);
            this.f687a.a(sQLiteDatabase);
            return null;
        }
        cursor = null;
        mo.a(cursor);
        this.f687a.a(sQLiteDatabase);
        return null;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.IBinaryDataHelper
    public final void insert(String str, byte[] bArr) {
        SQLiteDatabase sQLiteDatabase;
        SQLiteDatabase sQLiteDatabase2 = null;
        try {
            sQLiteDatabase = this.f687a.a();
            if (sQLiteDatabase != null) {
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("data_key", str);
                    contentValues.put("value", bArr);
                    sQLiteDatabase.insertWithOnConflict(this.b, null, contentValues, 5);
                } catch (Throwable unused) {
                    sQLiteDatabase2 = sQLiteDatabase;
                    sQLiteDatabase = sQLiteDatabase2;
                    this.f687a.a(sQLiteDatabase);
                }
            }
        } catch (Throwable unused2) {
        }
        this.f687a.a(sQLiteDatabase);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.IBinaryDataHelper
    public final void remove(String str) {
        SQLiteDatabase sQLiteDatabase;
        try {
            sQLiteDatabase = this.f687a.a();
            if (sQLiteDatabase != null) {
                try {
                    new ContentValues().put("data_key", str);
                    sQLiteDatabase.delete(this.b, "data_key = ?", new String[]{str});
                } catch (Throwable unused) {
                }
            }
        } catch (Throwable unused2) {
            sQLiteDatabase = null;
        }
        this.f687a.a(sQLiteDatabase);
    }
}
