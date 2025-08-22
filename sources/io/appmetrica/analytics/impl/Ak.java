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
public final class Ak implements InterfaceC0251fd {

    /* renamed from: a  reason: collision with root package name */
    public final yo f349a;
    public final String b = "startup_state";
    public final AESEncrypter c;

    public Ak(yo yoVar) {
        this.f349a = yoVar;
        C0108a c0108a = new C0108a(Ka.j().f());
        this.c = new AESEncrypter(AESEncrypter.DEFAULT_ALGORITHM, c0108a.b(), c0108a.a());
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0251fd
    public final void a(Context context) {
        SQLiteDatabase readableDatabase = C0649v7.a(context).h().getReadableDatabase();
        if (readableDatabase != null) {
            try {
                Xb a2 = a(readableDatabase);
                C0465nm c0465nm = new C0465nm(new G4(new E4()));
                if (a2 != null) {
                    a(this.f349a, c0465nm, a2);
                    c0465nm.p = a2.c;
                    c0465nm.r = a2.b;
                }
                C0490om c0490om = new C0490om(c0465nm);
                Wm a3 = Vm.a(C0490om.class);
                a3.a(context, a3.d(context)).save(c0490om);
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(yo yoVar, C0465nm c0465nm, Xb xb) {
        String optStringOrNull;
        synchronized (yoVar) {
            optStringOrNull = JsonUtils.optStringOrNull(yoVar.f1167a.a(), "device_id");
        }
        if (TextUtils.isEmpty(optStringOrNull)) {
            if (!TextUtils.isEmpty(xb.d)) {
                yoVar.a(xb.d);
            }
            if (!TextUtils.isEmpty(xb.e)) {
                yoVar.b(xb.e);
            }
            if (TextUtils.isEmpty(xb.f725a)) {
                return;
            }
            c0465nm.f988a = xb.f725a;
        }
    }

    public final Xb a(SQLiteDatabase sQLiteDatabase) {
        Cursor cursor;
        try {
            cursor = sQLiteDatabase.query("binary_data", new String[]{"value"}, "data_key = ?", new String[]{this.b}, null, null, null);
            if (cursor != null) {
                try {
                    if (cursor.getCount() == 1 && cursor.moveToFirst()) {
                        Xb xb = (Xb) MessageNano.mergeFrom(new Xb(), this.c.decrypt(cursor.getBlob(cursor.getColumnIndexOrThrow("value"))));
                        CloseableUtilsKt.closeSafely(cursor);
                        return xb;
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
