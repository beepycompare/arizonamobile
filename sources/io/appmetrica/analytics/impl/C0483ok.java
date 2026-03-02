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
public final class C0483ok implements Ic {

    /* renamed from: a  reason: collision with root package name */
    public final wo f1159a;
    public final String b = "startup_state";
    public final AESEncrypter c;

    public C0483ok(wo woVar) {
        this.f1159a = woVar;
        C0104a c0104a = new C0104a(C0448na.k().g());
        this.c = new AESEncrypter(AESEncrypter.DEFAULT_ALGORITHM, c0104a.b(), c0104a.a());
    }

    public static void a(wo woVar, C0333im c0333im, Ab ab) {
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
            c0333im.f1049a = ab.f497a;
        }
    }

    @Override // io.appmetrica.analytics.impl.Ic
    public final void a(Context context) {
        SQLiteDatabase readableDatabase = C0448na.I.B().f(context).getReadableDatabase();
        if (readableDatabase != null) {
            try {
                Ab a2 = a(readableDatabase);
                C0333im c0333im = new C0333im(new C0392l4(new C0341j4()));
                if (a2 != null) {
                    a(this.f1159a, c0333im, a2);
                    c0333im.p = a2.c;
                    c0333im.r = a2.b;
                }
                C0359jm c0359jm = new C0359jm(c0333im);
                Rm rm = (Rm) Pm.a(C0359jm.class);
                rm.a(context, rm.b(context)).save(c0359jm);
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
