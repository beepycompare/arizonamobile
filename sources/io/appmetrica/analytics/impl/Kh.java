package io.appmetrica.analytics.impl;

import android.os.Bundle;
import io.appmetrica.analytics.internal.CounterConfiguration;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class Kh extends P3 {
    protected I8 c;
    protected C0750zf d;
    public boolean e;
    public String f;

    public Kh(Gf gf, CounterConfiguration counterConfiguration, I8 i8) {
        this(gf, counterConfiguration, i8, null);
    }

    public final Bundle c() {
        Bundle bundle = new Bundle();
        this.b.toBundle(bundle);
        Gf gf = this.f629a;
        synchronized (gf) {
            bundle.putParcelable("PROCESS_CFG_OBJ", gf);
        }
        return bundle;
    }

    public final synchronized String d() {
        I8 i8;
        i8 = this.c;
        return i8.f523a.isEmpty() ? null : new JSONObject(i8.f523a).toString();
    }

    public final synchronized String e() {
        return this.f;
    }

    public boolean f() {
        return this.e;
    }

    public Kh(Gf gf, CounterConfiguration counterConfiguration, I8 i8, String str) {
        super(gf, counterConfiguration);
        this.e = true;
        this.f = str;
        this.c = i8;
    }
}
