package io.appmetrica.analytics.impl;

import android.os.Bundle;
import io.appmetrica.analytics.internal.CounterConfiguration;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class Fh extends H3 {
    protected D8 c;
    protected C0628uf d;
    public boolean e;
    public String f;

    public Fh(Bf bf, CounterConfiguration counterConfiguration, D8 d8) {
        this(bf, counterConfiguration, d8, null);
    }

    public final Bundle c() {
        Bundle bundle = new Bundle();
        this.b.toBundle(bundle);
        Bf bf = this.f607a;
        synchronized (bf) {
            bundle.putParcelable("PROCESS_CFG_OBJ", bf);
        }
        return bundle;
    }

    public final synchronized String d() {
        D8 d8;
        d8 = this.c;
        return d8.f546a.isEmpty() ? null : new JSONObject(d8.f546a).toString();
    }

    public final synchronized String e() {
        return this.f;
    }

    public boolean f() {
        return this.e;
    }

    public Fh(Bf bf, CounterConfiguration counterConfiguration, D8 d8, String str) {
        super(bf, counterConfiguration);
        this.e = true;
        this.f = str;
        this.c = d8;
    }
}
