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
public final class Qk implements InterfaceC0345jd {

    /* renamed from: a  reason: collision with root package name */
    public final Zo f741a;
    public final String b = "startup_state";
    public final AESEncrypter c;

    public Qk(Zo zo) {
        this.f741a = zo;
        C0099a c0099a = new C0099a(Na.k().g());
        this.c = new AESEncrypter(AESEncrypter.DEFAULT_ALGORITHM, c0099a.b(), c0099a.a());
    }

    public static void a(Zo zo, Km km, C0164cc c0164cc) {
        String optStringOrNull;
        synchronized (zo) {
            optStringOrNull = JsonUtils.optStringOrNull(zo.f881a.a(), NotificationStatsPayloadFactory.KEY_DEVICE_ID);
        }
        if (TextUtils.isEmpty(optStringOrNull)) {
            if (!TextUtils.isEmpty(c0164cc.d)) {
                zo.a(c0164cc.d);
            }
            if (!TextUtils.isEmpty(c0164cc.e)) {
                zo.b(c0164cc.e);
            }
            if (TextUtils.isEmpty(c0164cc.f929a)) {
                return;
            }
            km.f638a = c0164cc.f929a;
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0345jd
    public final void a(Context context) {
        SQLiteDatabase readableDatabase = Na.I.B().f(context).getReadableDatabase();
        if (readableDatabase != null) {
            try {
                C0164cc a2 = a(readableDatabase);
                Km km = new Km(new C4(new A4()));
                if (a2 != null) {
                    a(this.f741a, km, a2);
                    km.p = a2.c;
                    km.r = a2.b;
                }
                Lm lm = new Lm(km);
                AbstractC0614tn abstractC0614tn = (AbstractC0614tn) C0562rn.a(Lm.class);
                abstractC0614tn.a(context, abstractC0614tn.b(context)).save(lm);
            } catch (Throwable unused) {
            }
        }
    }

    public final C0164cc a(SQLiteDatabase sQLiteDatabase) {
        Cursor cursor;
        try {
            cursor = sQLiteDatabase.query("binary_data", new String[]{"value"}, "data_key = ?", new String[]{this.b}, null, null, null);
            if (cursor != null) {
                try {
                    if (cursor.getCount() == 1 && cursor.moveToFirst()) {
                        C0164cc c0164cc = (C0164cc) MessageNano.mergeFrom(new C0164cc(), this.c.decrypt(cursor.getBlob(cursor.getColumnIndexOrThrow("value"))));
                        CloseableUtils.closeSafely(cursor);
                        return c0164cc;
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
