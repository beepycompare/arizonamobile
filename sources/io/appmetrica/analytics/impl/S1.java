package io.appmetrica.analytics.impl;

import android.content.Context;
import android.text.TextUtils;
import io.appmetrica.analytics.coreutils.internal.io.FileUtils;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class S1 {

    /* renamed from: a  reason: collision with root package name */
    public final C0685wa f757a;
    public boolean b;

    public S1() {
        this(new C0685wa());
    }

    public final synchronized long a(Context context) {
        String a2;
        try {
            this.f757a.getClass();
            a2 = AbstractC0401lb.a(FileUtils.getFileFromAppStorage(context, "metrica_service_settings.dat"));
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

    public S1(C0685wa c0685wa) {
        this.b = false;
        this.f757a = c0685wa;
    }
}
