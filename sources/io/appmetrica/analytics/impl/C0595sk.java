package io.appmetrica.analytics.impl;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import io.appmetrica.analytics.coreutils.internal.encryption.AESEncrypter;
import io.appmetrica.analytics.coreutils.internal.io.CloseableUtilsKt;
import io.appmetrica.analytics.coreutils.internal.parsing.JsonUtils;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
/* renamed from: io.appmetrica.analytics.impl.sk  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0595sk implements InterfaceC0163bd {

    /* renamed from: a  reason: collision with root package name */
    public final qo f1047a;
    public final String b = "startup_state";
    public final AESEncrypter c;

    public C0595sk(qo qoVar) {
        this.f1047a = qoVar;
        C0123a c0123a = new C0123a(Ga.j().f());
        this.c = new AESEncrypter(AESEncrypter.DEFAULT_ALGORITHM, c0123a.b(), c0123a.a());
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0163bd
    public final void a(Context context) {
        SQLiteDatabase readableDatabase = C0557r7.a(context).h().getReadableDatabase();
        if (readableDatabase != null) {
            try {
                Tb a2 = a(readableDatabase);
                C0274fm c0274fm = new C0274fm(new G4(new E4()));
                if (a2 != null) {
                    a(this.f1047a, c0274fm, a2);
                    c0274fm.p = a2.c;
                    c0274fm.r = a2.b;
                }
                C0299gm c0299gm = new C0299gm(c0274fm);
                Om a3 = Nm.a(C0299gm.class);
                a3.a(context, a3.d(context)).save(c0299gm);
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(qo qoVar, C0274fm c0274fm, Tb tb) {
        String optStringOrNull;
        synchronized (qoVar) {
            optStringOrNull = JsonUtils.optStringOrNull(qoVar.f1012a.a(), "device_id");
        }
        if (TextUtils.isEmpty(optStringOrNull)) {
            if (!TextUtils.isEmpty(tb.d)) {
                qoVar.a(tb.d);
            }
            if (!TextUtils.isEmpty(tb.e)) {
                qoVar.b(tb.e);
            }
            if (TextUtils.isEmpty(tb.f639a)) {
                return;
            }
            c0274fm.f843a = tb.f639a;
        }
    }

    public final Tb a(SQLiteDatabase sQLiteDatabase) {
        Cursor cursor;
        try {
            cursor = sQLiteDatabase.query("binary_data", new String[]{"value"}, "data_key = ?", new String[]{this.b}, null, null, null);
            if (cursor != null) {
                try {
                    if (cursor.getCount() == 1 && cursor.moveToFirst()) {
                        Tb tb = (Tb) MessageNano.mergeFrom(new Tb(), this.c.decrypt(cursor.getBlob(cursor.getColumnIndexOrThrow("value"))));
                        CloseableUtilsKt.closeSafely(cursor);
                        return tb;
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
