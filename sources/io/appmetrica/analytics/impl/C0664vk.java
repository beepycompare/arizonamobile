package io.appmetrica.analytics.impl;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import io.appmetrica.analytics.coreutils.internal.encryption.AESEncrypter;
import io.appmetrica.analytics.coreutils.internal.io.CloseableUtilsKt;
import io.appmetrica.analytics.coreutils.internal.parsing.JsonUtils;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
/* renamed from: io.appmetrica.analytics.impl.vk  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0664vk implements InterfaceC0207dd {

    /* renamed from: a  reason: collision with root package name */
    public final to f1104a;
    public final String b = "startup_state";
    public final AESEncrypter c;

    public C0664vk(to toVar) {
        this.f1104a = toVar;
        C0115a c0115a = new C0115a(Ia.j().f());
        this.c = new AESEncrypter(AESEncrypter.DEFAULT_ALGORITHM, c0115a.b(), c0115a.a());
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0207dd
    public final void a(Context context) {
        SQLiteDatabase readableDatabase = C0626u7.a(context).h().getReadableDatabase();
        if (readableDatabase != null) {
            try {
                Vb a2 = a(readableDatabase);
                C0342im c0342im = new C0342im(new G4(new E4()));
                if (a2 != null) {
                    a(this.f1104a, c0342im, a2);
                    c0342im.p = a2.c;
                    c0342im.r = a2.b;
                }
                C0367jm c0367jm = new C0367jm(c0342im);
                Rm a3 = Qm.a(C0367jm.class);
                a3.a(context, a3.d(context)).save(c0367jm);
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(to toVar, C0342im c0342im, Vb vb) {
        String optStringOrNull;
        synchronized (toVar) {
            optStringOrNull = JsonUtils.optStringOrNull(toVar.f1073a.a(), "device_id");
        }
        if (TextUtils.isEmpty(optStringOrNull)) {
            if (!TextUtils.isEmpty(vb.d)) {
                toVar.a(vb.d);
            }
            if (!TextUtils.isEmpty(vb.e)) {
                toVar.b(vb.e);
            }
            if (TextUtils.isEmpty(vb.f684a)) {
                return;
            }
            c0342im.f905a = vb.f684a;
        }
    }

    public final Vb a(SQLiteDatabase sQLiteDatabase) {
        Cursor cursor;
        try {
            cursor = sQLiteDatabase.query("binary_data", new String[]{"value"}, "data_key = ?", new String[]{this.b}, null, null, null);
            if (cursor != null) {
                try {
                    if (cursor.getCount() == 1 && cursor.moveToFirst()) {
                        Vb vb = (Vb) MessageNano.mergeFrom(new Vb(), this.c.decrypt(cursor.getBlob(cursor.getColumnIndexOrThrow("value"))));
                        CloseableUtilsKt.closeSafely(cursor);
                        return vb;
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
