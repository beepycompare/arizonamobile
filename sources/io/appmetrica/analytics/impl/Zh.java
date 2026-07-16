package io.appmetrica.analytics.impl;

import android.os.Bundle;
import io.appmetrica.analytics.internal.CounterConfiguration;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class Zh extends Y3 {
    protected W8 c;
    protected Uf d;
    public boolean e;
    public String f;

    public Zh(C0175cg c0175cg, CounterConfiguration counterConfiguration, W8 w8) {
        this(c0175cg, counterConfiguration, w8, null);
    }

    public final Bundle c() {
        Bundle bundle = new Bundle();
        this.b.toBundle(bundle);
        C0175cg c0175cg = this.f852a;
        synchronized (c0175cg) {
            bundle.putParcelable("PROCESS_CFG_OBJ", c0175cg);
        }
        return bundle;
    }

    public final synchronized String d() {
        W8 w8;
        w8 = this.c;
        return w8.f824a.isEmpty() ? null : new JSONObject(w8.f824a).toString();
    }

    public final synchronized String e() {
        return this.f;
    }

    public boolean f() {
        return this.e;
    }

    public Zh(C0175cg c0175cg, CounterConfiguration counterConfiguration, W8 w8, String str) {
        super(c0175cg, counterConfiguration);
        this.e = true;
        this.f = str;
        this.c = w8;
    }
}
