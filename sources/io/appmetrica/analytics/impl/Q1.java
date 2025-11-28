package io.appmetrica.analytics.impl;

import android.content.Context;
import android.text.TextUtils;
import io.appmetrica.analytics.coreutils.internal.io.FileUtils;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class Q1 {

    /* renamed from: a  reason: collision with root package name */
    public final C0293ha f644a;
    public boolean b;

    public Q1() {
        this(new C0293ha());
    }

    public final synchronized long a(Context context) {
        String a2;
        try {
            this.f644a.getClass();
            a2 = Qa.a(FileUtils.getFileFromAppStorage(context, "metrica_service_settings.dat"));
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

    public Q1(C0293ha c0293ha) {
        this.b = false;
        this.f644a = c0293ha;
    }
}
