package io.appmetrica.analytics.impl;

import android.os.Bundle;
import io.appmetrica.analytics.internal.CounterConfiguration;
import org.json.JSONObject;
/* renamed from: io.appmetrica.analytics.impl.bi  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C0153bi extends C0268g4 {
    protected C0144b9 c;
    protected Of d;
    public boolean e;
    public String f;

    public C0153bi(Vf vf, CounterConfiguration counterConfiguration, C0144b9 c0144b9) {
        this(vf, counterConfiguration, c0144b9, null);
    }

    public final Bundle c() {
        Bundle bundle = new Bundle();
        this.b.toBundle(bundle);
        Vf vf = this.f889a;
        synchronized (vf) {
            bundle.putParcelable("PROCESS_CFG_OBJ", vf);
        }
        return bundle;
    }

    public final synchronized String d() {
        C0144b9 c0144b9;
        c0144b9 = this.c;
        return c0144b9.f808a.isEmpty() ? null : new JSONObject(c0144b9.f808a).toString();
    }

    public final synchronized String e() {
        return this.f;
    }

    public boolean f() {
        return this.e;
    }

    public C0153bi(Vf vf, CounterConfiguration counterConfiguration, C0144b9 c0144b9, String str) {
        super(vf, counterConfiguration);
        this.e = true;
        this.f = str;
        this.c = c0144b9;
    }
}
