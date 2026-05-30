package io.appmetrica.analytics.impl;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import io.appmetrica.analytics.coreapi.internal.data.TempCacheStorage;
import io.appmetrica.analytics.coreutils.internal.buffering.DeferredBatchExecutor;
import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
/* loaded from: classes5.dex */
public final class Un implements TempCacheStorage {

    /* renamed from: a  reason: collision with root package name */
    public final Q6 f799a;
    public final String b;
    public final SystemTimeProvider c = new SystemTimeProvider();
    public final C0472o3 d = new C0472o3(new Tn(this));

    public Un(Q6 q6, String str) {
        this.f799a = q6;
        this.b = str;
    }

    public final void b() {
        this.d.b.flushAsync();
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.TempCacheStorage
    public final void put(String str, long j, byte[] bArr) {
        DeferredBatchExecutor.submit$default(this.d.b, new Xn(str, j, bArr), false, 2, null);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.TempCacheStorage
    public final void remove(long j) {
        a("id=?", new String[]{String.valueOf(j)});
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.TempCacheStorage
    public final void removeOlderThan(String str, long j) {
        a("scope=? AND timestamp<?", new String[]{str, String.valueOf(this.c.currentTimeMillis() - j)});
    }

    public final long a(String str, long j, byte[] bArr) {
        return a(CollectionsKt.listOf(new Xn(str, j, bArr)));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.TempCacheStorage
    public final TempCacheStorage.Entry get(String str) {
        return (TempCacheStorage.Entry) CollectionsKt.firstOrNull((List<? extends Object>) get(str, 1));
    }

    public final long a(List list) {
        long j = -1;
        if (list.isEmpty()) {
            return -1L;
        }
        SQLiteDatabase sQLiteDatabase = null;
        try {
            SQLiteDatabase a2 = this.f799a.a();
            if (a2 != null) {
                try {
                    a2.beginTransaction();
                    Iterator it = list.iterator();
                    long j2 = -1;
                    while (it.hasNext()) {
                        Xn xn = (Xn) it.next();
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("scope", xn.f844a);
                        contentValues.put("timestamp", Long.valueOf(xn.b));
                        contentValues.put("data", xn.c);
                        j2 = a2.insertOrThrow(this.b, null, contentValues);
                    }
                    a2.setTransactionSuccessful();
                    a2.endTransaction();
                    j = j2;
                } catch (Throwable unused) {
                    sQLiteDatabase = a2;
                    this.f799a.a(sQLiteDatabase);
                    return j;
                }
            }
            this.f799a.a(a2);
            return j;
        } catch (Throwable unused2) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1 */
    @Override // io.appmetrica.analytics.coreapi.internal.data.TempCacheStorage
    /* renamed from: a */
    public final List<TempCacheStorage.Entry> get(String str, int i) {
        Cursor cursor;
        SQLiteDatabase sQLiteDatabase;
        SQLiteDatabase sQLiteDatabase2;
        Wn wn;
        ArrayList arrayList = new ArrayList();
        Cursor cursor2 = null;
        try {
            sQLiteDatabase = this.f799a.a();
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
                                wn = new Wn(cursor.getLong(cursor.getColumnIndexOrThrow("id")), cursor.getString(cursor.getColumnIndexOrThrow("scope")), cursor.getLong(cursor.getColumnIndexOrThrow("timestamp")), cursor.getBlob(cursor.getColumnIndexOrThrow("data")));
                            } catch (Throwable unused2) {
                                wn = null;
                            }
                            if (wn != null) {
                                arrayList.add(wn);
                            }
                        } catch (Throwable unused3) {
                            cursor2 = sQLiteDatabase;
                            sQLiteDatabase = cursor2;
                            cursor2 = cursor;
                            sQLiteDatabase2 = sQLiteDatabase;
                            Oo.a(cursor2);
                            this.f799a.a(sQLiteDatabase2);
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
        Oo.a(cursor2);
        this.f799a.a(sQLiteDatabase2);
        return arrayList;
    }

    public final void a(String str, String[] strArr) {
        SQLiteDatabase sQLiteDatabase;
        try {
            sQLiteDatabase = this.f799a.a();
            if (sQLiteDatabase != null) {
                try {
                    sQLiteDatabase.delete(this.b, str, strArr);
                } catch (Throwable unused) {
                }
            }
        } catch (Throwable unused2) {
            sQLiteDatabase = null;
        }
        this.f799a.a(sQLiteDatabase);
    }

    public final void a() {
        this.d.b.flush();
    }
}
