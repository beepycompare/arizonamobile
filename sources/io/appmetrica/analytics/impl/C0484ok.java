package io.appmetrica.analytics.impl;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import io.appmetrica.analytics.coreutils.internal.encryption.AESEncrypter;
import io.appmetrica.analytics.coreutils.internal.io.CloseableUtilsKt;
import io.appmetrica.analytics.coreutils.internal.parsing.JsonUtils;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
/* renamed from: io.appmetrica.analytics.impl.ok  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0484ok implements Ic {

    /* renamed from: a  reason: collision with root package name */
    public final wo f1159a;
    public final String b = "startup_state";
    public final AESEncrypter c;

    public C0484ok(wo woVar) {
        this.f1159a = woVar;
        C0105a c0105a = new C0105a(C0449na.k().g());
        this.c = new AESEncrypter(AESEncrypter.DEFAULT_ALGORITHM, c0105a.b(), c0105a.a());
    }

    public static void a(wo woVar, C0334im c0334im, Ab ab) {
        String optStringOrNull;
        synchronized (woVar) {
            optStringOrNull = JsonUtils.optStringOrNull(woVar.f1293a.a(), "device_id");
        }
        if (TextUtils.isEmpty(optStringOrNull)) {
            if (!TextUtils.isEmpty(ab.d)) {
                woVar.a(ab.d);
            }
            if (!TextUtils.isEmpty(ab.e)) {
                woVar.b(ab.e);
            }
            if (TextUtils.isEmpty(ab.f497a)) {
                return;
            }
            c0334im.f1049a = ab.f497a;
        }
    }

    @Override // io.appmetrica.analytics.impl.Ic
    public final void a(Context context) {
        SQLiteDatabase readableDatabase = C0449na.I.B().f(context).getReadableDatabase();
        if (readableDatabase != null) {
            try {
                Ab a2 = a(readableDatabase);
                C0334im c0334im = new C0334im(new C0393l4(new C0342j4()));
                if (a2 != null) {
                    a(this.f1159a, c0334im, a2);
                    c0334im.p = a2.c;
                    c0334im.r = a2.b;
                }
                C0360jm c0360jm = new C0360jm(c0334im);
                Rm rm = (Rm) Pm.a(C0360jm.class);
                rm.a(context, rm.b(context)).save(c0360jm);
            } catch (Throwable unused) {
            }
        }
    }

    public final Ab a(SQLiteDatabase sQLiteDatabase) {
        Cursor cursor;
        try {
            cursor = sQLiteDatabase.query("binary_data", new String[]{"value"}, "data_key = ?", new String[]{this.b}, null, null, null);
            if (cursor != null) {
                try {
                    if (cursor.getCount() == 1 && cursor.moveToFirst()) {
                        Ab ab = (Ab) MessageNano.mergeFrom(new Ab(), this.c.decrypt(cursor.getBlob(cursor.getColumnIndexOrThrow("value"))));
                        CloseableUtilsKt.closeSafely(cursor);
                        return ab;
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
