package io.appmetrica.analytics.impl;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import io.appmetrica.analytics.coreapi.internal.data.TempCacheStorage;
import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
/* renamed from: io.appmetrica.analytics.impl.mn  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0441mn implements TempCacheStorage {

    /* renamed from: a  reason: collision with root package name */
    public final Q6 f947a;
    public final String b;
    public final SystemTimeProvider c = new SystemTimeProvider();

    public C0441mn(Q6 q6, String str) {
        this.f947a = q6;
        this.b = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1 */
    @Override // io.appmetrica.analytics.coreapi.internal.data.TempCacheStorage
    /* renamed from: a */
    public final List<TempCacheStorage.Entry> get(String str, int i) {
        Cursor cursor;
        SQLiteDatabase sQLiteDatabase;
        SQLiteDatabase sQLiteDatabase2;
        C0491on c0491on;
        ArrayList arrayList = new ArrayList();
        Cursor cursor2 = null;
        try {
            sQLiteDatabase = this.f947a.a();
            sQLiteDatabase2 = sQLiteDatabase;
        } catch (Throwable unused) {
            cursor = null;
        }
        if (sQLiteDatabase != null) {
            try {
                cursor = sQLiteDatabase.query(false, this.b, null, "scope=?", new String[]{str}, null, null, "id", String.valueOf(i));
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        try {
                            try {
                                c0491on = new C0491on(cursor.getLong(cursor.getColumnIndexOrThrow("id")), cursor.getString(cursor.getColumnIndexOrThrow("scope")), cursor.getLong(cursor.getColumnIndexOrThrow("timestamp")), cursor.getBlob(cursor.getColumnIndexOrThrow("data")));
                            } catch (Throwable unused2) {
                                c0491on = null;
                            }
                            if (c0491on != null) {
                                arrayList.add(c0491on);
                            }
                        } catch (Throwable unused3) {
                            cursor2 = sQLiteDatabase;
                            sQLiteDatabase = cursor2;
                            cursor2 = cursor;
                            sQLiteDatabase2 = sQLiteDatabase;
                            fo.a(cursor2);
                            this.f947a.a(sQLiteDatabase2);
                            return arrayList;
                        }
                    }
                }
            } catch (Throwable unused4) {
                cursor = null;
            }
            cursor2 = cursor;
            sQLiteDatabase2 = sQLiteDatabase;
        }
        fo.a(cursor2);
        this.f947a.a(sQLiteDatabase2);
        return arrayList;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.TempCacheStorage
    public final long put(String str, long j, byte[] bArr) {
        SQLiteDatabase sQLiteDatabase;
        SQLiteDatabase sQLiteDatabase2 = null;
        try {
            sQLiteDatabase = this.f947a.a();
            if (sQLiteDatabase != null) {
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("scope", str);
                    contentValues.put("timestamp", Long.valueOf(j));
                    contentValues.put("data", bArr);
                    long insertOrThrow = sQLiteDatabase.insertOrThrow(this.b, null, contentValues);
                    this.f947a.a(sQLiteDatabase);
                    return insertOrThrow;
                } catch (Throwable unused) {
                    sQLiteDatabase2 = sQLiteDatabase;
                    sQLiteDatabase = sQLiteDatabase2;
                    this.f947a.a(sQLiteDatabase);
                    return -1L;
                }
            }
        } catch (Throwable unused2) {
        }
        this.f947a.a(sQLiteDatabase);
        return -1L;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.TempCacheStorage
    public final void remove(long j) {
        a("id=?", new String[]{String.valueOf(j)});
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.TempCacheStorage
    public final void removeOlderThan(String str, long j) {
        a("scope=? AND timestamp<?", new String[]{str, String.valueOf(this.c.currentTimeMillis() - j)});
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.TempCacheStorage
    public final TempCacheStorage.Entry get(String str) {
        return (TempCacheStorage.Entry) CollectionsKt.firstOrNull((List<? extends Object>) get(str, 1));
    }

    public final void a(String str, String[] strArr) {
        SQLiteDatabase sQLiteDatabase;
        try {
            sQLiteDatabase = this.f947a.a();
            if (sQLiteDatabase != null) {
                try {
                    sQLiteDatabase.delete(this.b, str, strArr);
                } catch (Throwable unused) {
                }
            }
        } catch (Throwable unused2) {
            sQLiteDatabase = null;
        }
        this.f947a.a(sQLiteDatabase);
    }
}
