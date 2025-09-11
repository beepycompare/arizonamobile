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
public final class Ek implements InterfaceC0329id {

    /* renamed from: a  reason: collision with root package name */
    public final Co f430a;
    public final String b = "startup_state";
    public final AESEncrypter c;

    public Ek(Co co) {
        this.f430a = co;
        C0108a c0108a = new C0108a(Na.j().f());
        this.c = new AESEncrypter(AESEncrypter.DEFAULT_ALGORITHM, c0108a.b(), c0108a.a());
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0329id
    public final void a(Context context) {
        SQLiteDatabase readableDatabase = C0728y7.a(context).h().getReadableDatabase();
        if (readableDatabase != null) {
            try {
                C0121ac a2 = a(readableDatabase);
                C0568rm c0568rm = new C0568rm(new J4(new H4()));
                if (a2 != null) {
                    a(this.f430a, c0568rm, a2);
                    c0568rm.p = a2.c;
                    c0568rm.r = a2.b;
                }
                C0593sm c0593sm = new C0593sm(c0568rm);
                AbstractC0132an a3 = Zm.a(C0593sm.class);
                a3.a(context, a3.d(context)).save(c0593sm);
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(Co co, C0568rm c0568rm, C0121ac c0121ac) {
        String optStringOrNull;
        synchronized (co) {
            optStringOrNull = JsonUtils.optStringOrNull(co.f397a.a(), "device_id");
        }
        if (TextUtils.isEmpty(optStringOrNull)) {
            if (!TextUtils.isEmpty(c0121ac.d)) {
                co.a(c0121ac.d);
            }
            if (!TextUtils.isEmpty(c0121ac.e)) {
                co.b(c0121ac.e);
            }
            if (TextUtils.isEmpty(c0121ac.f791a)) {
                return;
            }
            c0568rm.f1071a = c0121ac.f791a;
        }
    }

    public final C0121ac a(SQLiteDatabase sQLiteDatabase) {
        Cursor cursor;
        try {
            cursor = sQLiteDatabase.query("binary_data", new String[]{"value"}, "data_key = ?", new String[]{this.b}, null, null, null);
            if (cursor != null) {
                try {
                    if (cursor.getCount() == 1 && cursor.moveToFirst()) {
                        C0121ac c0121ac = (C0121ac) MessageNano.mergeFrom(new C0121ac(), this.c.decrypt(cursor.getBlob(cursor.getColumnIndexOrThrow("value"))));
                        CloseableUtilsKt.closeSafely(cursor);
                        return c0121ac;
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
