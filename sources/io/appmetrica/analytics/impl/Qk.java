package io.appmetrica.analytics.impl;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.miami.game.core.firebase.notification.NotificationStatsPayloadFactory;
import io.appmetrica.analytics.coreutils.internal.encryption.AESEncrypter;
import io.appmetrica.analytics.coreutils.internal.io.CloseableUtils;
import io.appmetrica.analytics.coreutils.internal.parsing.JsonUtils;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
/* loaded from: classes5.dex */
public final class Qk implements InterfaceC0352jd {

    /* renamed from: a  reason: collision with root package name */
    public final Zo f736a;
    public final String b = "startup_state";
    public final AESEncrypter c;

    public Qk(Zo zo) {
        this.f736a = zo;
        C0106a c0106a = new C0106a(Na.k().g());
        this.c = new AESEncrypter(AESEncrypter.DEFAULT_ALGORITHM, c0106a.b(), c0106a.a());
    }

    public static void a(Zo zo, Km km, C0171cc c0171cc) {
        String optStringOrNull;
        synchronized (zo) {
            optStringOrNull = JsonUtils.optStringOrNull(zo.f876a.a(), NotificationStatsPayloadFactory.KEY_DEVICE_ID);
        }
        if (TextUtils.isEmpty(optStringOrNull)) {
            if (!TextUtils.isEmpty(c0171cc.d)) {
                zo.a(c0171cc.d);
            }
            if (!TextUtils.isEmpty(c0171cc.e)) {
                zo.b(c0171cc.e);
            }
            if (TextUtils.isEmpty(c0171cc.f924a)) {
                return;
            }
            km.f633a = c0171cc.f924a;
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0352jd
    public final void a(Context context) {
        SQLiteDatabase readableDatabase = Na.I.B().f(context).getReadableDatabase();
        if (readableDatabase != null) {
            try {
                C0171cc a2 = a(readableDatabase);
                Km km = new Km(new C4(new A4()));
                if (a2 != null) {
                    a(this.f736a, km, a2);
                    km.p = a2.c;
                    km.r = a2.b;
                }
                Lm lm = new Lm(km);
                AbstractC0621tn abstractC0621tn = (AbstractC0621tn) C0569rn.a(Lm.class);
                abstractC0621tn.a(context, abstractC0621tn.b(context)).save(lm);
            } catch (Throwable unused) {
            }
        }
    }

    public final C0171cc a(SQLiteDatabase sQLiteDatabase) {
        Cursor cursor;
        try {
            cursor = sQLiteDatabase.query("binary_data", new String[]{"value"}, "data_key = ?", new String[]{this.b}, null, null, null);
            if (cursor != null) {
                try {
                    if (cursor.getCount() == 1 && cursor.moveToFirst()) {
                        C0171cc c0171cc = (C0171cc) MessageNano.mergeFrom(new C0171cc(), this.c.decrypt(cursor.getBlob(cursor.getColumnIndexOrThrow("value"))));
                        CloseableUtils.closeSafely(cursor);
                        return c0171cc;
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
        CloseableUtils.closeSafely(cursor);
        return null;
    }
}
