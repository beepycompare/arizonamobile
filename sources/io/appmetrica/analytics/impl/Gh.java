package io.appmetrica.analytics.impl;

import android.os.Bundle;
import io.appmetrica.analytics.internal.CounterConfiguration;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class Gh extends I3 {
    protected E8 c;
    protected C0649vf d;
    public boolean e;
    public String f;

    public Gh(Cf cf, CounterConfiguration counterConfiguration, E8 e8) {
        this(cf, counterConfiguration, e8, null);
    }

    public final Bundle c() {
        Bundle bundle = new Bundle();
        this.b.toBundle(bundle);
        Cf cf = this.f616a;
        synchronized (cf) {
            bundle.putParcelable("PROCESS_CFG_OBJ", cf);
        }
        return bundle;
    }

    public final synchronized String d() {
        E8 e8;
        e8 = this.c;
        return e8.f555a.isEmpty() ? null : new JSONObject(e8.f555a).toString();
    }

    public final synchronized String e() {
        return this.f;
    }

    public boolean f() {
        return this.e;
    }

    public Gh(Cf cf, CounterConfiguration counterConfiguration, E8 e8, String str) {
        super(cf, counterConfiguration);
        this.e = true;
        this.f = str;
        this.c = e8;
    }
}
