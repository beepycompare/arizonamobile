package io.appmetrica.analytics.impl;

import android.content.Context;
import android.os.Bundle;
import io.appmetrica.analytics.AppMetrica;
import io.appmetrica.analytics.internal.CounterConfiguration;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* loaded from: classes5.dex */
public class Y3 {

    /* renamed from: a  reason: collision with root package name */
    public final C0174cg f852a;
    public final CounterConfiguration b;

    public Y3(C0174cg c0174cg, CounterConfiguration counterConfiguration) {
        this.f852a = c0174cg;
        this.b = counterConfiguration;
    }

    public static Y3 a(Context context, Bundle bundle) {
        C0174cg c0174cg;
        CounterConfiguration fromBundle;
        String str = C0174cg.c;
        if (bundle != null) {
            try {
                c0174cg = (C0174cg) bundle.getParcelable("PROCESS_CFG_OBJ");
            } catch (Throwable unused) {
            }
            fromBundle = CounterConfiguration.fromBundle(bundle);
            if (fromBundle == null && c0174cg != null && context.getPackageName().equals(c0174cg.f930a.getAsString("PROCESS_CFG_PACKAGE_NAME")) && c0174cg.f930a.getAsInteger("PROCESS_CFG_SDK_API_LEVEL").intValue() == AppMetrica.getLibraryApiLevel()) {
                return new Y3(c0174cg, fromBundle);
            }
            return null;
        }
        c0174cg = null;
        fromBundle = CounterConfiguration.fromBundle(bundle);
        if (fromBundle == null) {
        }
        return null;
    }

    public final CounterConfiguration b() {
        return this.b;
    }

    public final String toString() {
        return "ClientConfiguration{mProcessConfiguration=" + this.f852a + ", mCounterConfiguration=" + this.b + AbstractJsonLexerKt.END_OBJ;
    }

    public final C0174cg a() {
        return this.f852a;
    }
}
