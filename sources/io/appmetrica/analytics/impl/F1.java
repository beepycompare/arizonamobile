package io.appmetrica.analytics.impl;

import android.content.Context;
import android.text.TextUtils;
import io.appmetrica.analytics.coreutils.internal.io.FileUtils;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class F1 {

    /* renamed from: a  reason: collision with root package name */
    public final C0115aa f576a;
    public boolean b;

    public F1() {
        this(new C0115aa());
    }

    public final synchronized long a(Context context) {
        String a2;
        try {
            this.f576a.getClass();
            a2 = Ja.a(FileUtils.getFileFromAppStorage(context, "metrica_service_settings.dat"));
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

    public F1(C0115aa c0115aa) {
        this.b = false;
        this.f576a = c0115aa;
    }
}
