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
public final class C0505pk implements Jc {

    /* renamed from: a  reason: collision with root package name */
    public final xo f1169a;
    public final String b = "startup_state";
    public final AESEncrypter c;

    public C0505pk(xo xoVar) {
        this.f1169a = xoVar;
        C0100a c0100a = new C0100a(C0470oa.k().g());
        this.c = new AESEncrypter(AESEncrypter.DEFAULT_ALGORITHM, c0100a.b(), c0100a.a());
    }

    public static void a(xo xoVar, C0355jm c0355jm, Bb bb) {
        String optStringOrNull;
        synchronized (xoVar) {
            optStringOrNull = JsonUtils.optStringOrNull(xoVar.f1303a.a(), "device_id");
        }
        if (TextUtils.isEmpty(optStringOrNull)) {
            if (!TextUtils.isEmpty(bb.d)) {
                xoVar.a(bb.d);
            }
            if (!TextUtils.isEmpty(bb.e)) {
                xoVar.b(bb.e);
            }
            if (TextUtils.isEmpty(bb.f506a)) {
                return;
            }
            c0355jm.f1058a = bb.f506a;
        }
    }

    @Override // io.appmetrica.analytics.impl.Jc
    public final void a(Context context) {
        SQLiteDatabase readableDatabase = C0470oa.I.B().f(context).getReadableDatabase();
        if (readableDatabase != null) {
            try {
                Bb a2 = a(readableDatabase);
                C0355jm c0355jm = new C0355jm(new C0414m4(new C0363k4()));
                if (a2 != null) {
                    a(this.f1169a, c0355jm, a2);
                    c0355jm.p = a2.c;
                    c0355jm.r = a2.b;
                }
                C0381km c0381km = new C0381km(c0355jm);
                Sm sm = (Sm) Qm.a(C0381km.class);
                sm.a(context, sm.b(context)).save(c0381km);
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
