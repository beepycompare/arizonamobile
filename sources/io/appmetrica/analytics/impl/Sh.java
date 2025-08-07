package io.appmetrica.analytics.impl;

import android.os.Bundle;
import io.appmetrica.analytics.internal.CounterConfiguration;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class Sh extends C0199d4 {
    protected W8 c;
    protected If d;
    public boolean e;
    public String f;

    public Sh(Pf pf, CounterConfiguration counterConfiguration, W8 w8) {
        this(pf, counterConfiguration, w8, null);
    }

    public final Bundle c() {
        Bundle bundle = new Bundle();
        this.b.toBundle(bundle);
        Pf pf = this.f811a;
        synchronized (pf) {
            bundle.putParcelable("PROCESS_CFG_OBJ", pf);
        }
        return bundle;
    }

    public final synchronized String d() {
        W8 w8;
        w8 = this.c;
        return w8.f698a.isEmpty() ? null : new JSONObject(w8.f698a).toString();
    }

    public final synchronized String e() {
        return this.f;
    }

    public boolean f() {
        return this.e;
    }

    public Sh(Pf pf, CounterConfiguration counterConfiguration, W8 w8, String str) {
        super(pf, counterConfiguration);
        this.e = true;
        this.f = str;
        this.c = w8;
    }
}
