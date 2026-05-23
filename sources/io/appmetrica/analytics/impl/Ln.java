package io.appmetrica.analytics.impl;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public final class Ln implements Kn {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f651a;

    public Ln(String str, HashMap<String, List<String>> hashMap) {
        this.f651a = hashMap;
    }

    public final HashMap<String, List<String>> a() {
        return this.f651a;
    }

    @Override // io.appmetrica.analytics.impl.Kn
    public final boolean a(SQLiteDatabase sQLiteDatabase) {
        try {
            boolean z = true;
            for (Map.Entry entry : this.f651a.entrySet()) {
                SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
                Cursor query = sQLiteDatabase2.query((String) entry.getKey(), null, null, null, null, null, null);
                if (query == null) {
                    Oo.a(query);
                    return false;
                }
                String str = (String) entry.getKey();
                List asList = Arrays.asList(query.getColumnNames());
                Collections.sort(asList);
                z &= ((List) entry.getValue()).equals(asList);
                Oo.a(query);
                sQLiteDatabase = sQLiteDatabase2;
            }
            return z;
        } catch (Throwable unused) {
            return false;
        }
    }
}
