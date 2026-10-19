package io.appmetrica.analytics.impl;

import android.content.Context;
import android.os.Bundle;
import io.appmetrica.analytics.AppMetrica;
import io.appmetrica.analytics.internal.CounterConfiguration;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* loaded from: classes5.dex */
public class Y3 {

    /* renamed from: a  reason: collision with root package name */
    public final C0168cg f855a;
    public final CounterConfiguration b;

    public Y3(C0168cg c0168cg, CounterConfiguration counterConfiguration) {
        this.f855a = c0168cg;
        this.b = counterConfiguration;
    }

    public static Y3 a(Context context, Bundle bundle) {
        C0168cg c0168cg;
        CounterConfiguration fromBundle;
        String str = C0168cg.c;
        if (bundle != null) {
            try {
                c0168cg = (C0168cg) bundle.getParcelable("PROCESS_CFG_OBJ");
            } catch (Throwable unused) {
            }
            fromBundle = CounterConfiguration.fromBundle(bundle);
            if (fromBundle == null && c0168cg != null && context.getPackageName().equals(c0168cg.f933a.getAsString("PROCESS_CFG_PACKAGE_NAME")) && c0168cg.f933a.getAsInteger("PROCESS_CFG_SDK_API_LEVEL").intValue() == AppMetrica.getLibraryApiLevel()) {
                return new Y3(c0168cg, fromBundle);
            }
            return null;
        }
        c0168cg = null;
        fromBundle = CounterConfiguration.fromBundle(bundle);
        if (fromBundle == null) {
        }
        return null;
    }

    public final CounterConfiguration b() {
        return this.b;
    }

    public final String toString() {
        return "ClientConfiguration{mProcessConfiguration=" + this.f855a + ", mCounterConfiguration=" + this.b + AbstractJsonLexerKt.END_OBJ;
    }

    public final C0168cg a() {
        return this.f855a;
    }
}
