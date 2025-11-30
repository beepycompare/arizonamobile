package io.appmetrica.analytics.impl;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.ln  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0409ln implements InterfaceC0383kn {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f997a;

    public C0409ln(String str, HashMap<String, List<String>> hashMap) {
        this.f997a = hashMap;
    }

    public final HashMap<String, List<String>> a() {
        return this.f997a;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0383kn
    public final boolean a(SQLiteDatabase sQLiteDatabase) {
        try {
            boolean z = true;
            for (Map.Entry entry : this.f997a.entrySet()) {
                SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
                Cursor query = sQLiteDatabase2.query((String) entry.getKey(), null, null, null, null, null, null);
                if (query == null) {
                    mo.a(query);
                    return false;
                }
                String str = (String) entry.getKey();
                List asList = Arrays.asList(query.getColumnNames());
                Collections.sort(asList);
                z &= ((List) entry.getValue()).equals(asList);
                mo.a(query);
                sQLiteDatabase = sQLiteDatabase2;
            }
            return z;
        } catch (Throwable unused) {
            return false;
        }
    }
}
