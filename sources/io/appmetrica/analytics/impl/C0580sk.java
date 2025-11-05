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
/* loaded from: classes3.dex */
public final class C0580sk implements Pc {

    /* renamed from: a  reason: collision with root package name */
    public final yo f1117a;
    public final String b = "startup_state";
    public final AESEncrypter c;

    public C0580sk(yo yoVar) {
        this.f1117a = yoVar;
        C0101a c0101a = new C0101a(C0620ua.k().g());
        this.c = new AESEncrypter(AESEncrypter.DEFAULT_ALGORITHM, c0101a.b(), c0101a.a());
    }

    @Override // io.appmetrica.analytics.impl.Pc
    public final void a(Context context) {
        SQLiteDatabase readableDatabase = C0264g7.a(context).h().getReadableDatabase();
        if (readableDatabase != null) {
            try {
                Hb a2 = a(readableDatabase);
                C0433mm c0433mm = new C0433mm(new C0564s4(new C0515q4()));
                if (a2 != null) {
                    a(this.f1117a, c0433mm, a2);
                    c0433mm.p = a2.c;
                    c0433mm.r = a2.b;
                }
                C0458nm c0458nm = new C0458nm(c0433mm);
                Vm vm = (Vm) Tm.a(C0458nm.class);
                vm.a(context, vm.b(context)).save(c0458nm);
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(yo yoVar, C0433mm c0433mm, Hb hb) {
        String optStringOrNull;
        synchronized (yoVar) {
            optStringOrNull = JsonUtils.optStringOrNull(yoVar.f1220a.a(), "device_id");
        }
        if (TextUtils.isEmpty(optStringOrNull)) {
            if (!TextUtils.isEmpty(hb.d)) {
                yoVar.a(hb.d);
            }
            if (!TextUtils.isEmpty(hb.e)) {
                yoVar.b(hb.e);
            }
            if (TextUtils.isEmpty(hb.f505a)) {
                return;
            }
            c0433mm.f1014a = hb.f505a;
        }
    }

    public final Hb a(SQLiteDatabase sQLiteDatabase) {
        Cursor cursor;
        try {
            cursor = sQLiteDatabase.query("binary_data", new String[]{"value"}, "data_key = ?", new String[]{this.b}, null, null, null);
            if (cursor != null) {
                try {
                    if (cursor.getCount() == 1 && cursor.moveToFirst()) {
                        Hb hb = (Hb) MessageNano.mergeFrom(new Hb(), this.c.decrypt(cursor.getBlob(cursor.getColumnIndexOrThrow("value"))));
                        CloseableUtilsKt.closeSafely(cursor);
                        return hb;
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
