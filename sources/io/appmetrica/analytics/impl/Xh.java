package io.appmetrica.analytics.impl;

import android.os.Bundle;
import io.appmetrica.analytics.internal.CounterConfiguration;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class Xh extends C0191d4 {
    protected Y8 c;
    protected Kf d;
    public boolean e;
    public String f;

    public Xh(Rf rf, CounterConfiguration counterConfiguration, Y8 y8) {
        this(rf, counterConfiguration, y8, null);
    }

    public final Bundle c() {
        Bundle bundle = new Bundle();
        this.b.toBundle(bundle);
        Rf rf = this.f823a;
        synchronized (rf) {
            bundle.putParcelable("PROCESS_CFG_OBJ", rf);
        }
        return bundle;
    }

    public final synchronized String d() {
        Y8 y8;
        y8 = this.c;
        return y8.f738a.isEmpty() ? null : new JSONObject(y8.f738a).toString();
    }

    public final synchronized String e() {
        return this.f;
    }

    public boolean f() {
        return this.e;
    }

    public Xh(Rf rf, CounterConfiguration counterConfiguration, Y8 y8, String str) {
        super(rf, counterConfiguration);
        this.e = true;
        this.f = str;
        this.c = y8;
    }
}
