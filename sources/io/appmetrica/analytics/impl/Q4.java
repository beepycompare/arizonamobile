package io.appmetrica.analytics.impl;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import io.appmetrica.analytics.coreapi.internal.db.DatabaseScript;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public final class Q4 extends DatabaseScript {

    /* renamed from: a  reason: collision with root package name */
    public final String f646a = "sessions";
    public final int b = 200;
    public final String c = "id";
    public final String d = "start_time";
    public final String e = "report_request_parameters";
    public final String f = "server_time_offset";
    public final String g = "type";
    public final String h = "obtained_before_first_sync";
    public final B7 i = new B7(null, 1, null);

    public final A7 a(Cursor cursor) {
        try {
            Long valueOf = Long.valueOf(cursor.getLong(cursor.getColumnIndexOrThrow(this.c)));
            int i = cursor.getInt(cursor.getColumnIndexOrThrow(this.g));
            EnumC0123al enumC0123al = EnumC0123al.FOREGROUND;
            boolean z = true;
            if (i != 0) {
                enumC0123al = EnumC0123al.BACKGROUND;
                if (i != 1) {
                    enumC0123al = null;
                }
            }
            String string = cursor.getString(cursor.getColumnIndexOrThrow(this.e));
            Long valueOf2 = Long.valueOf(cursor.getLong(cursor.getColumnIndexOrThrow(this.d)));
            Long valueOf3 = Long.valueOf(cursor.getLong(cursor.getColumnIndexOrThrow(this.f)));
            if (cursor.getInt(cursor.getColumnIndexOrThrow(this.h)) != 1) {
                z = false;
            }
            return new A7(valueOf, enumC0123al, string, new C0742z7(valueOf2, valueOf3, Boolean.valueOf(z)));
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x005c, code lost:
        if (r12 != null) goto L49;
     */
    @Override // io.appmetrica.analytics.coreapi.internal.db.DatabaseScript
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void runScript(SQLiteDatabase sQLiteDatabase) {
        SQLiteDatabase sQLiteDatabase2;
        Cursor cursor;
        Long l;
        String str;
        Long l2;
        ArrayList arrayList = new ArrayList();
        try {
            sQLiteDatabase2 = sQLiteDatabase;
        } catch (Throwable unused) {
            sQLiteDatabase2 = sQLiteDatabase;
        }
        try {
            cursor = sQLiteDatabase2.query(this.f646a, null, null, null, null, null, null, String.valueOf(this.b));
            while (cursor.moveToNext()) {
                try {
                    A7 a2 = a(cursor);
                    if (a2 != null && (l = a2.f392a) != null && l.longValue() >= 0 && a2.b != null && (str = a2.c) != null && str.length() != 0 && (l2 = a2.d.f1226a) != null && l2.longValue() > 0) {
                        arrayList.add(this.i.fromModel(a2));
                    }
                } catch (Throwable unused2) {
                }
            }
        } catch (Throwable unused3) {
            cursor = null;
        }
        cursor.close();
        sQLiteDatabase2.execSQL("DROP TABLE IF EXISTS " + this.f646a);
        sQLiteDatabase2.execSQL("CREATE TABLE IF NOT EXISTS sessions (id INTEGER,type INTEGER,report_request_parameters TEXT,session_description BLOB )");
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            try {
                sQLiteDatabase2.insertOrThrow("sessions", null, (ContentValues) it.next());
            } catch (Throwable unused4) {
            }
        }
    }
}
