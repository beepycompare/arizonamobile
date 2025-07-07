package io.appmetrica.analytics.impl;

import android.os.Bundle;
import io.appmetrica.analytics.internal.CounterConfiguration;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class Qh extends C0206d4 {
    protected T8 c;
    protected Gf d;
    public boolean e;
    public String f;

    public Qh(Nf nf, CounterConfiguration counterConfiguration, T8 t8) {
        this(nf, counterConfiguration, t8, null);
    }

    public final Bundle c() {
        Bundle bundle = new Bundle();
        this.b.toBundle(bundle);
        Nf nf = this.f796a;
        synchronized (nf) {
            bundle.putParcelable("PROCESS_CFG_OBJ", nf);
        }
        return bundle;
    }

    public final synchronized String d() {
        T8 t8;
        t8 = this.c;
        return t8.f637a.isEmpty() ? null : new JSONObject(t8.f637a).toString();
    }

    public final synchronized String e() {
        return this.f;
    }

    public boolean f() {
        return this.e;
    }

    public Qh(Nf nf, CounterConfiguration counterConfiguration, T8 t8, String str) {
        super(nf, counterConfiguration);
        this.e = true;
        this.f = str;
        this.c = t8;
    }
}
