package io.appmetrica.analytics.impl;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import io.appmetrica.analytics.coreutils.internal.encryption.AESEncrypter;
import io.appmetrica.analytics.coreutils.internal.io.CloseableUtilsKt;
import io.appmetrica.analytics.coreutils.internal.parsing.JsonUtils;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
/* loaded from: classes4.dex */
public final class Ek implements InterfaceC0330id {

    /* renamed from: a  reason: collision with root package name */
    public final Co f431a;
    public final String b = "startup_state";
    public final AESEncrypter c;

    public Ek(Co co) {
        this.f431a = co;
        C0109a c0109a = new C0109a(Na.j().f());
        this.c = new AESEncrypter(AESEncrypter.DEFAULT_ALGORITHM, c0109a.b(), c0109a.a());
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0330id
    public final void a(Context context) {
        SQLiteDatabase readableDatabase = C0729y7.a(context).h().getReadableDatabase();
        if (readableDatabase != null) {
            try {
                C0122ac a2 = a(readableDatabase);
                C0569rm c0569rm = new C0569rm(new J4(new H4()));
                if (a2 != null) {
                    a(this.f431a, c0569rm, a2);
                    c0569rm.p = a2.c;
                    c0569rm.r = a2.b;
                }
                C0594sm c0594sm = new C0594sm(c0569rm);
                AbstractC0133an a3 = Zm.a(C0594sm.class);
                a3.a(context, a3.d(context)).save(c0594sm);
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(Co co, C0569rm c0569rm, C0122ac c0122ac) {
        String optStringOrNull;
        synchronized (co) {
            optStringOrNull = JsonUtils.optStringOrNull(co.f398a.a(), "device_id");
        }
        if (TextUtils.isEmpty(optStringOrNull)) {
            if (!TextUtils.isEmpty(c0122ac.d)) {
                co.a(c0122ac.d);
            }
            if (!TextUtils.isEmpty(c0122ac.e)) {
                co.b(c0122ac.e);
            }
            if (TextUtils.isEmpty(c0122ac.f792a)) {
                return;
            }
            c0569rm.f1072a = c0122ac.f792a;
        }
    }

    public final C0122ac a(SQLiteDatabase sQLiteDatabase) {
        Cursor cursor;
        try {
            cursor = sQLiteDatabase.query("binary_data", new String[]{"value"}, "data_key = ?", new String[]{this.b}, null, null, null);
            if (cursor != null) {
                try {
                    if (cursor.getCount() == 1 && cursor.moveToFirst()) {
                        C0122ac c0122ac = (C0122ac) MessageNano.mergeFrom(new C0122ac(), this.c.decrypt(cursor.getBlob(cursor.getColumnIndexOrThrow("value"))));
                        CloseableUtilsKt.closeSafely(cursor);
                        return c0122ac;
                    }
                } catch (Throwable unused) {
                }
            }
            if (cursor != null) {
                cursor.getCount();
            }
        } catch (Throwable unused2) {
            cursor = null;
        }
        CloseableUtilsKt.closeSafely(cursor);
        return null;
    }
}
