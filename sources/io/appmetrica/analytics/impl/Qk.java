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
public final class Qk implements InterfaceC0351jd {

    /* renamed from: a  reason: collision with root package name */
    public final Zo f738a;
    public final String b = "startup_state";
    public final AESEncrypter c;

    public Qk(Zo zo) {
        this.f738a = zo;
        C0105a c0105a = new C0105a(Na.k().g());
        this.c = new AESEncrypter(AESEncrypter.DEFAULT_ALGORITHM, c0105a.b(), c0105a.a());
    }

    public static void a(Zo zo, Km km, C0170cc c0170cc) {
        String optStringOrNull;
        synchronized (zo) {
            optStringOrNull = JsonUtils.optStringOrNull(zo.f878a.a(), NotificationStatsPayloadFactory.KEY_DEVICE_ID);
        }
        if (TextUtils.isEmpty(optStringOrNull)) {
            if (!TextUtils.isEmpty(c0170cc.d)) {
                zo.a(c0170cc.d);
            }
            if (!TextUtils.isEmpty(c0170cc.e)) {
                zo.b(c0170cc.e);
            }
            if (TextUtils.isEmpty(c0170cc.f926a)) {
                return;
            }
            km.f635a = c0170cc.f926a;
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0351jd
    public final void a(Context context) {
        SQLiteDatabase readableDatabase = Na.I.B().f(context).getReadableDatabase();
        if (readableDatabase != null) {
            try {
                C0170cc a2 = a(readableDatabase);
                Km km = new Km(new C4(new A4()));
                if (a2 != null) {
                    a(this.f738a, km, a2);
                    km.p = a2.c;
                    km.r = a2.b;
                }
                Lm lm = new Lm(km);
                AbstractC0620tn abstractC0620tn = (AbstractC0620tn) C0568rn.a(Lm.class);
                abstractC0620tn.a(context, abstractC0620tn.b(context)).save(lm);
            } catch (Throwable unused) {
            }
        }
    }

    public final C0170cc a(SQLiteDatabase sQLiteDatabase) {
        Cursor cursor;
        try {
            cursor = sQLiteDatabase.query("binary_data", new String[]{"value"}, "data_key = ?", new String[]{this.b}, null, null, null);
            if (cursor != null) {
                try {
                    if (cursor.getCount() == 1 && cursor.moveToFirst()) {
                        C0170cc c0170cc = (C0170cc) MessageNano.mergeFrom(new C0170cc(), this.c.decrypt(cursor.getBlob(cursor.getColumnIndexOrThrow("value"))));
                        CloseableUtils.closeSafely(cursor);
                        return c0170cc;
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
