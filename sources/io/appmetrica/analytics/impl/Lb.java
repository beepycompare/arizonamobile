package io.appmetrica.analytics.impl;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import io.appmetrica.analytics.coreutils.internal.parsing.ParseUtils;
import java.io.Closeable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
/* loaded from: classes4.dex */
public final class Lb implements InterfaceC0135ab, Closeable {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f516a = new HashMap();
    public final HashMap b = new HashMap();
    public final String c = "preferences";
    public final Kb d;
    public volatile boolean e;
    public final Q6 f;

    public Lb(Q6 q6) {
        this.f = q6;
        Kb kb = new Kb(this, String.format(Locale.US, "IAA-DW-%s", Integer.valueOf(Md.a())));
        this.d = kb;
        kb.start();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0081 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0029 A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r8v10, types: [java.lang.Long] */
    /* JADX WARN: Type inference failed for: r8v11, types: [java.lang.Float] */
    /* JADX WARN: Type inference failed for: r8v5, types: [java.lang.Boolean] */
    /* JADX WARN: Type inference failed for: r8v6, types: [java.lang.Boolean] */
    /* JADX WARN: Type inference failed for: r8v9, types: [java.lang.Integer] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(Lb lb) {
        SQLiteDatabase sQLiteDatabase;
        String str;
        lb.getClass();
        Cursor cursor = null;
        try {
            sQLiteDatabase = lb.f.a();
            if (sQLiteDatabase != null) {
                try {
                    Cursor query = sQLiteDatabase.query(lb.c, new String[]{"key", "value", "type"}, null, null, null, null, null);
                    while (query.moveToNext()) {
                        try {
                            String string = query.getString(query.getColumnIndexOrThrow("key"));
                            String string2 = query.getString(query.getColumnIndexOrThrow("value"));
                            int i = query.getInt(query.getColumnIndexOrThrow("type"));
                            if (!TextUtils.isEmpty(string)) {
                                if (i != 1) {
                                    if (i == 2) {
                                        str = ParseUtils.parseInt(string2);
                                    } else if (i != 3) {
                                        str = string2;
                                        if (i != 4) {
                                            if (i == 5) {
                                                str = ParseUtils.parseFloat(string2);
                                            }
                                            str = null;
                                        }
                                    } else {
                                        str = ParseUtils.parseLong(string2);
                                    }
                                    if (str == null) {
                                        lb.f516a.put(string, str);
                                    }
                                } else {
                                    if ("true".equals(string2)) {
                                        str = Boolean.TRUE;
                                    } else {
                                        if ("false".equals(string2)) {
                                            str = Boolean.FALSE;
                                        }
                                        str = null;
                                    }
                                    if (str == null) {
                                    }
                                }
                            }
                        } catch (Throwable unused) {
                        }
                    }
                    cursor = query;
                } catch (Throwable unused2) {
                }
            }
        } catch (Throwable unused3) {
            sQLiteDatabase = null;
        }
        fo.a(cursor);
        lb.f.a(sQLiteDatabase);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0135ab
    public final void b() {
        synchronized (this.d) {
            this.d.notifyAll();
        }
    }

    public final void c() {
        if (this.e) {
            return;
        }
        try {
            this.f516a.wait();
        } catch (InterruptedException unused) {
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.d.isRunning()) {
            this.d.stopRunning();
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0135ab
    public final boolean getBoolean(String str, boolean z) {
        Object b = b(str);
        return b instanceof Boolean ? ((Boolean) b).booleanValue() : z;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0135ab
    public final int getInt(String str, int i) {
        Object b = b(str);
        return b instanceof Integer ? ((Integer) b).intValue() : i;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0135ab
    public final long getLong(String str, long j) {
        Object b = b(str);
        return b instanceof Long ? ((Long) b).longValue() : j;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0135ab
    public final String getString(String str, String str2) {
        Object b = b(str);
        return b instanceof String ? (String) b : str2;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0135ab
    public final InterfaceC0135ab remove(String str) {
        synchronized (this.f516a) {
            c();
            this.f516a.remove(str);
        }
        synchronized (this.d) {
            this.b.put(str, this);
            this.d.notifyAll();
        }
        return this;
    }

    public final Object b(String str) {
        Object obj;
        synchronized (this.f516a) {
            c();
            obj = this.f516a.get(str);
        }
        return obj;
    }

    public static void a(Lb lb, HashMap hashMap) {
        SQLiteDatabase sQLiteDatabase;
        lb.getClass();
        int size = hashMap.size();
        ContentValues[] contentValuesArr = new ContentValues[size];
        int i = 0;
        for (Map.Entry entry : hashMap.entrySet()) {
            ContentValues contentValues = new ContentValues();
            Object value = entry.getValue();
            contentValues.put("key", (String) entry.getKey());
            if (value == lb) {
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
            contentValuesArr[i] = contentValues;
            i++;
        }
        SQLiteDatabase sQLiteDatabase2 = null;
        try {
            sQLiteDatabase = lb.f.a();
            if (sQLiteDatabase != null) {
                try {
                    sQLiteDatabase.beginTransaction();
                    for (int i2 = 0; i2 < size; i2++) {
                        ContentValues contentValues2 = contentValuesArr[i2];
                        if (contentValues2.getAsString("value") == null) {
                            sQLiteDatabase.delete(lb.c, "key = ?", new String[]{contentValues2.getAsString("key")});
                        } else {
                            sQLiteDatabase.insertWithOnConflict(lb.c, null, contentValues2, 5);
                        }
                    }
                    sQLiteDatabase.setTransactionSuccessful();
                } catch (Throwable unused) {
                    sQLiteDatabase2 = sQLiteDatabase;
                    if (sQLiteDatabase2 != null) {
                        try {
                            sQLiteDatabase2.endTransaction();
                        } catch (Throwable unused2) {
                        }
                    }
                    sQLiteDatabase = sQLiteDatabase2;
                    lb.f.a(sQLiteDatabase);
                }
            }
            if (sQLiteDatabase != null) {
                try {
                    sQLiteDatabase.endTransaction();
                } catch (Throwable unused3) {
                }
            }
        } catch (Throwable unused4) {
        }
        lb.f.a(sQLiteDatabase);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0135ab
    public final synchronized InterfaceC0135ab a(String str, String str2) {
        a(str, (Object) str2);
        return this;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0135ab
    public final InterfaceC0135ab a(String str, long j) {
        a(str, Long.valueOf(j));
        return this;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0135ab
    public final synchronized InterfaceC0135ab a(int i, String str) {
        a(str, Integer.valueOf(i));
        return this;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0135ab
    public final InterfaceC0135ab a(String str, boolean z) {
        a(str, Boolean.valueOf(z));
        return this;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0135ab
    public final InterfaceC0135ab a(String str, float f) {
        a(str, Float.valueOf(f));
        return this;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0135ab
    public final boolean a(String str) {
        boolean containsKey;
        synchronized (this.f516a) {
            c();
            containsKey = this.f516a.containsKey(str);
        }
        return containsKey;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0135ab
    public final Set a() {
        HashSet hashSet;
        synchronized (this.f516a) {
            hashSet = new HashSet(this.f516a.keySet());
        }
        return hashSet;
    }

    public final void a(String str, Object obj) {
        synchronized (this.f516a) {
            c();
            this.f516a.put(str, obj);
        }
        synchronized (this.d) {
            this.b.put(str, obj);
            this.d.notifyAll();
        }
    }
}
