package io.appmetrica.analytics.impl;

import android.content.Context;
import android.text.TextUtils;
import io.appmetrica.analytics.coreutils.internal.io.FileUtils;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class P1 {

    /* renamed from: a  reason: collision with root package name */
    public final Aa f618a;
    public boolean b;

    public P1() {
        this(new Aa());
    }

    public final synchronized long a(Context context) {
        String a2;
        try {
            this.f618a.getClass();
            a2 = AbstractC0352jb.a(FileUtils.getFileFromAppStorage(context, "metrica_service_settings.dat"));
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

    public P1(Aa aa) {
        this.b = false;
        this.f618a = aa;
    }
}
