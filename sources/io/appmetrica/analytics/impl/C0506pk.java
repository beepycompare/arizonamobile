package io.appmetrica.analytics.impl;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import io.appmetrica.analytics.coreutils.internal.encryption.AESEncrypter;
import io.appmetrica.analytics.coreutils.internal.io.CloseableUtilsKt;
import io.appmetrica.analytics.coreutils.internal.parsing.JsonUtils;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
/* renamed from: io.appmetrica.analytics.impl.pk  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0506pk implements Jc {

    /* renamed from: a  reason: collision with root package name */
    public final xo f1072a;
    public final String b = "startup_state";
    public final AESEncrypter c;

    public C0506pk(xo xoVar) {
        this.f1072a = xoVar;
        C0101a c0101a = new C0101a(C0471oa.k().g());
        this.c = new AESEncrypter(AESEncrypter.DEFAULT_ALGORITHM, c0101a.b(), c0101a.a());
    }

    public static void a(xo xoVar, C0356jm c0356jm, Bb bb) {
        String optStringOrNull;
        synchronized (xoVar) {
            optStringOrNull = JsonUtils.optStringOrNull(xoVar.f1206a.a(), "device_id");
        }
        if (TextUtils.isEmpty(optStringOrNull)) {
            if (!TextUtils.isEmpty(bb.d)) {
                xoVar.a(bb.d);
            }
            if (!TextUtils.isEmpty(bb.e)) {
                xoVar.b(bb.e);
            }
            if (TextUtils.isEmpty(bb.f409a)) {
                return;
            }
            c0356jm.f961a = bb.f409a;
        }
    }

    @Override // io.appmetrica.analytics.impl.Jc
    public final void a(Context context) {
        SQLiteDatabase readableDatabase = C0471oa.I.B().f(context).getReadableDatabase();
        if (readableDatabase != null) {
            try {
                Bb a2 = a(readableDatabase);
                C0356jm c0356jm = new C0356jm(new C0415m4(new C0364k4()));
                if (a2 != null) {
                    a(this.f1072a, c0356jm, a2);
                    c0356jm.p = a2.c;
                    c0356jm.r = a2.b;
                }
                C0382km c0382km = new C0382km(c0356jm);
                Sm sm = (Sm) Qm.a(C0382km.class);
                sm.a(context, sm.b(context)).save(c0382km);
            } catch (Throwable unused) {
            }
        }
    }

    public final Bb a(SQLiteDatabase sQLiteDatabase) {
        Cursor cursor;
        try {
            cursor = sQLiteDatabase.query("binary_data", new String[]{"value"}, "data_key = ?", new String[]{this.b}, null, null, null);
            if (cursor != null) {
                try {
                    if (cursor.getCount() == 1 && cursor.moveToFirst()) {
                        Bb bb = (Bb) MessageNano.mergeFrom(new Bb(), this.c.decrypt(cursor.getBlob(cursor.getColumnIndexOrThrow("value"))));
                        CloseableUtilsKt.closeSafely(cursor);
                        return bb;
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
