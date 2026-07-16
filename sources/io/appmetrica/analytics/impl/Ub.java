package io.appmetrica.analytics.impl;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import io.appmetrica.analytics.coreutils.internal.buffering.BatchProcessor;
import io.appmetrica.analytics.coreutils.internal.buffering.DeferredBatchExecutor;
import io.appmetrica.analytics.coreutils.internal.buffering.MapMergingBuffer;
import io.appmetrica.analytics.coreutils.internal.parsing.ParseUtils;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class Ub implements InterfaceC0350jb, Closeable {
    public static final Tb g = new Tb();

    /* renamed from: a  reason: collision with root package name */
    public final String f791a;
    public final Q6 b;
    public final LinkedHashMap c = new LinkedHashMap();
    public final Object d = new Object();
    public volatile boolean e;
    public final DeferredBatchExecutor f;

    public Ub(String str, Q6 q6, IHandlerExecutor iHandlerExecutor) {
        this.f791a = str;
        this.b = q6;
        this.f = new DeferredBatchExecutor(iHandlerExecutor, new MapMergingBuffer(), new BatchProcessor() { // from class: io.appmetrica.analytics.impl.Ub$$ExternalSyntheticLambda0
            @Override // io.appmetrica.analytics.coreutils.internal.buffering.BatchProcessor
            public final void processBatch(List list) {
                Ub.a(Ub.this, list);
            }
        }, 1000L, "[KeyValueTableDbHelper-(" + str + ")]");
        iHandlerExecutor.execute(new Runnable() { // from class: io.appmetrica.analytics.impl.Ub$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                Ub.a(Ub.this);
            }
        });
    }

    public static final void a(Ub ub, List list) {
        SQLiteDatabase sQLiteDatabase;
        Map map = (Map) CollectionsKt.first((List<? extends Object>) list);
        ub.getClass();
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry entry : map.entrySet()) {
            Object value = entry.getValue();
            ContentValues contentValues = new ContentValues();
            contentValues.put("key", (String) entry.getKey());
            if (value == ub) {
                contentValues.putNull("value");
            } else if (value instanceof String) {
                contentValues.put("value", (String) value);
                contentValues.put("type", (Integer) 4);
            } else if (value instanceof Long) {
                contentValues.put("value", (Long) value);
                contentValues.put("type", (Integer) 3);
            } else if (value instanceof Integer) {
                contentValues.put("value", (Integer) value);
                contentValues.put("type", (Integer) 2);
            } else if (value instanceof Boolean) {
                contentValues.put("value", String.valueOf(((Boolean) value).booleanValue()));
                contentValues.put("type", (Integer) 1);
            } else if (value instanceof Float) {
                contentValues.put("value", (Float) value);
                contentValues.put("type", (Integer) 5);
            }
            arrayList.add(contentValues);
        }
        ContentValues[] contentValuesArr = (ContentValues[]) arrayList.toArray(new ContentValues[0]);
        if (contentValuesArr == null) {
            return;
        }
        SQLiteDatabase sQLiteDatabase2 = null;
        try {
            sQLiteDatabase = ub.b.a();
            if (sQLiteDatabase != null) {
                try {
                    sQLiteDatabase.beginTransaction();
                    Iterator it = ArrayIteratorKt.iterator(contentValuesArr);
                    while (it.hasNext()) {
                        ContentValues contentValues2 = (ContentValues) it.next();
                        if (contentValues2.getAsString("value") == null) {
                            sQLiteDatabase.delete(ub.f791a, "key = ?", new String[]{contentValues2.getAsString("key")});
                        } else {
                            sQLiteDatabase.insertWithOnConflict(ub.f791a, null, contentValues2, 5);
                        }
                    }
                    sQLiteDatabase.setTransactionSuccessful();
                    Oo.a(sQLiteDatabase);
                } catch (Throwable unused) {
                    sQLiteDatabase2 = sQLiteDatabase;
                    sQLiteDatabase = sQLiteDatabase2;
                    ub.b.a(sQLiteDatabase);
                }
            }
        } catch (Throwable unused2) {
        }
        ub.b.a(sQLiteDatabase);
    }

    public final float b(String str, float f) {
        Object b = b(str);
        return b instanceof Float ? ((Number) b).floatValue() : f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0084 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0028 A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r8v10, types: [java.lang.Long] */
    /* JADX WARN: Type inference failed for: r8v11, types: [java.lang.Float] */
    /* JADX WARN: Type inference failed for: r8v5, types: [java.lang.Boolean] */
    /* JADX WARN: Type inference failed for: r8v6, types: [java.lang.Boolean] */
    /* JADX WARN: Type inference failed for: r8v9, types: [java.lang.Integer] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void c() {
        SQLiteDatabase sQLiteDatabase;
        String str;
        SQLiteDatabase sQLiteDatabase2 = null;
        try {
            sQLiteDatabase = this.b.a();
            if (sQLiteDatabase != null) {
                try {
                    Cursor query = sQLiteDatabase.query(this.f791a, new String[]{"key", "value", "type"}, null, null, null, null, null);
                    if (query != null) {
                        while (query.moveToNext()) {
                            String string = query.getString(query.getColumnIndexOrThrow("key"));
                            String string2 = query.getString(query.getColumnIndexOrThrow("value"));
                            int i = query.getInt(query.getColumnIndexOrThrow("type"));
                            if (string != null && string.length() != 0) {
                                if (i != 1) {
                                    if (i == 2) {
                                        str = ParseUtils.parseInt(string2);
                                    } else if (i != 3) {
                                        str = string2;
                                        if (i != 4) {
                                            str = i != 5 ? null : ParseUtils.parseFloat(string2);
                                        }
                                    } else {
                                        str = ParseUtils.parseLong(string2);
                                    }
                                    if (str == null) {
                                        this.c.put(string, str);
                                    }
                                } else {
                                    if (Intrinsics.areEqual(string2, "true")) {
                                        str = Boolean.TRUE;
                                    } else {
                                        if (Intrinsics.areEqual(string2, "false")) {
                                            str = Boolean.FALSE;
                                        }
                                    }
                                    if (str == null) {
                                    }
                                }
                            }
                        }
                        Unit unit = Unit.INSTANCE;
                        CloseableKt.closeFinally(query, null);
                    }
                } catch (Throwable unused) {
                    sQLiteDatabase2 = sQLiteDatabase;
                    sQLiteDatabase = sQLiteDatabase2;
                    this.b.a(sQLiteDatabase);
                }
            }
        } catch (Throwable unused2) {
        }
        this.b.a(sQLiteDatabase);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f.flush();
    }

    public final void d() {
        if (this.e) {
            return;
        }
        try {
            Object obj = this.d;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type java.lang.Object");
            obj.wait();
        } catch (InterruptedException unused) {
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0350jb
    public final void flushAsync() {
        this.f.flushAsync();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0350jb
    public final boolean getBoolean(String str, boolean z) {
        Object b = b(str);
        return b instanceof Boolean ? ((Boolean) b).booleanValue() : z;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0350jb
    public final int getInt(String str, int i) {
        Object b = b(str);
        return b instanceof Integer ? ((Number) b).intValue() : i;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0350jb
    public final long getLong(String str, long j) {
        Object b = b(str);
        return b instanceof Long ? ((Number) b).longValue() : j;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0350jb
    public final String getString(String str, String str2) {
        Object b = b(str);
        return b instanceof String ? (String) b : str2;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0350jb
    public final InterfaceC0350jb remove(String str) {
        synchronized (this.d) {
            d();
            this.c.remove(str);
        }
        DeferredBatchExecutor.submit$default(this.f, MapsKt.mapOf(TuplesKt.to(str, this)), false, 2, null);
        return this;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0350jb
    public final Set<String> b() {
        HashSet hashSet;
        synchronized (this.d) {
            hashSet = new HashSet(this.c.keySet());
        }
        return hashSet;
    }

    public final Object b(String str) {
        Object obj;
        synchronized (this.d) {
            d();
            obj = this.c.get(str);
        }
        return obj;
    }

    public static final void a(Ub ub) {
        synchronized (ub.d) {
            ub.c();
            ub.e = true;
            Object obj = ub.d;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type java.lang.Object");
            obj.notifyAll();
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0350jb
    public final void a() {
        this.f.flush();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0350jb
    public final InterfaceC0350jb a(String str, String str2) {
        a(str, (Object) str2);
        return this;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0350jb
    public final InterfaceC0350jb a(String str, long j) {
        a(str, Long.valueOf(j));
        return this;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0350jb
    public final InterfaceC0350jb a(String str, int i) {
        a(str, Integer.valueOf(i));
        return this;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0350jb
    public final InterfaceC0350jb a(String str, boolean z) {
        a(str, Boolean.valueOf(z));
        return this;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0350jb
    public final InterfaceC0350jb a(String str, float f) {
        a(str, Float.valueOf(f));
        return this;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0350jb
    public final boolean a(String str) {
        boolean containsKey;
        synchronized (this.d) {
            d();
            containsKey = this.c.containsKey(str);
        }
        return containsKey;
    }

    public final void a(String str, Object obj) {
        synchronized (this.d) {
            d();
            this.c.put(str, obj);
            Unit unit = Unit.INSTANCE;
        }
        DeferredBatchExecutor.submit$default(this.f, MapsKt.mapOf(TuplesKt.to(str, obj)), false, 2, null);
    }
}
