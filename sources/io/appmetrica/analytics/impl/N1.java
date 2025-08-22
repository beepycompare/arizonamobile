package io.appmetrica.analytics.impl;

import android.content.Context;
import android.text.TextUtils;
import io.appmetrica.analytics.coreutils.internal.io.FileUtils;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class N1 {

    /* renamed from: a  reason: collision with root package name */
    public final C0702xa f570a;
    public boolean b;

    public N1() {
        this(new C0702xa());
    }

    public final synchronized long a(Context context) {
        String a2;
        try {
            this.f570a.getClass();
            a2 = AbstractC0275gb.a(FileUtils.getFileFromAppStorage(context, "metrica_service_settings.dat"));
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

    public N1(C0702xa c0702xa) {
        this.b = false;
        this.f570a = c0702xa;
    }
}
