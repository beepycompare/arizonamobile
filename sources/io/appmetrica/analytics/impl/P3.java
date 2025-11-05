package io.appmetrica.analytics.impl;

import android.content.Context;
import android.os.Bundle;
import io.appmetrica.analytics.AppMetrica;
import io.appmetrica.analytics.internal.CounterConfiguration;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* loaded from: classes3.dex */
public class P3 {

    /* renamed from: a  reason: collision with root package name */
    public final Gf f629a;
    public final CounterConfiguration b;

    public P3(Gf gf, CounterConfiguration counterConfiguration) {
        this.f629a = gf;
        this.b = counterConfiguration;
    }

    public static P3 a(Context context, Bundle bundle) {
        Gf gf;
        CounterConfiguration fromBundle;
        String str = Gf.c;
        if (bundle != null) {
            try {
                gf = (Gf) bundle.getParcelable("PROCESS_CFG_OBJ");
            } catch (Throwable unused) {
            }
            fromBundle = CounterConfiguration.fromBundle(bundle);
            if (fromBundle == null && gf != null && context.getPackageName().equals(gf.f492a.getAsString("PROCESS_CFG_PACKAGE_NAME")) && gf.f492a.getAsInteger("PROCESS_CFG_SDK_API_LEVEL").intValue() == AppMetrica.getLibraryApiLevel()) {
                return new P3(gf, fromBundle);
            }
            return null;
        }
        gf = null;
        fromBundle = CounterConfiguration.fromBundle(bundle);
        if (fromBundle == null) {
        }
        return null;
    }

    public final CounterConfiguration b() {
        return this.b;
    }

    public final String toString() {
        return "ClientConfiguration{mProcessConfiguration=" + this.f629a + ", mCounterConfiguration=" + this.b + AbstractJsonLexerKt.END_OBJ;
    }

    public final Gf a() {
        return this.f629a;
    }
}
