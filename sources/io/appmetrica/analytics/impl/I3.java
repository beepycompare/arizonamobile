package io.appmetrica.analytics.impl;

import android.content.Context;
import android.os.Bundle;
import io.appmetrica.analytics.AppMetrica;
import io.appmetrica.analytics.internal.CounterConfiguration;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* loaded from: classes5.dex */
public class I3 {

    /* renamed from: a  reason: collision with root package name */
    public final Cf f518a;
    public final CounterConfiguration b;

    public I3(Cf cf, CounterConfiguration counterConfiguration) {
        this.f518a = cf;
        this.b = counterConfiguration;
    }

    public static I3 a(Context context, Bundle bundle) {
        Cf cf;
        CounterConfiguration fromBundle;
        String str = Cf.c;
        if (bundle != null) {
            try {
                cf = (Cf) bundle.getParcelable("PROCESS_CFG_OBJ");
            } catch (Throwable unused) {
            }
            fromBundle = CounterConfiguration.fromBundle(bundle);
            if (fromBundle == null && cf != null && context.getPackageName().equals(cf.f432a.getAsString("PROCESS_CFG_PACKAGE_NAME")) && cf.f432a.getAsInteger("PROCESS_CFG_SDK_API_LEVEL").intValue() == AppMetrica.getLibraryApiLevel()) {
                return new I3(cf, fromBundle);
            }
            return null;
        }
        cf = null;
        fromBundle = CounterConfiguration.fromBundle(bundle);
        if (fromBundle == null) {
        }
        return null;
    }

    public final CounterConfiguration b() {
        return this.b;
    }

    public final String toString() {
        return "ClientConfiguration{mProcessConfiguration=" + this.f518a + ", mCounterConfiguration=" + this.b + AbstractJsonLexerKt.END_OBJ;
    }

    public final Cf a() {
        return this.f518a;
    }
}
