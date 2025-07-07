package io.appmetrica.analytics.impl;

import android.content.Context;
import android.text.TextUtils;
import io.appmetrica.analytics.coreutils.internal.io.FileUtils;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class N1 {

    /* renamed from: a  reason: collision with root package name */
    public final C0610ta f545a;
    public boolean b;

    public N1() {
        this(new C0610ta());
    }

    public final synchronized long a(Context context) {
        String a2;
        try {
            this.f545a.getClass();
            a2 = AbstractC0187cb.a(FileUtils.getFileFromAppStorage(context, "metrica_service_settings.dat"));
        } catch (Throwable unused) {
        }
        return TextUtils.isEmpty(a2) ? 0L : new JSONObject(a2).optLong("delay");
    }

    public final void b(Context context) {
        synchronized (this) {
        }
        if (this.b) {
            return;
        }
        long a2 = a(context);
        if (a2 > 0) {
            try {
                Thread.sleep(a2);
            } catch (Throwable unused) {
            }
        }
        this.b = true;
    }

    public N1(C0610ta c0610ta) {
        this.b = false;
        this.f545a = c0610ta;
    }
}
