package io.appmetrica.analytics.impl;

import android.content.Context;
import android.os.Bundle;
import io.appmetrica.analytics.AppMetrica;
import io.appmetrica.analytics.internal.CounterConfiguration;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.g4  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C0268g4 {

    /* renamed from: a  reason: collision with root package name */
    public final Vf f888a;
    public final CounterConfiguration b;

    public C0268g4(Vf vf, CounterConfiguration counterConfiguration) {
        this.f888a = vf;
        this.b = counterConfiguration;
    }

    public static C0268g4 a(Context context, Bundle bundle) {
        Vf vf;
        CounterConfiguration fromBundle;
        String str = Vf.c;
        if (bundle != null) {
            try {
                vf = (Vf) bundle.getParcelable("PROCESS_CFG_OBJ");
            } catch (Throwable unused) {
            }
            fromBundle = CounterConfiguration.fromBundle(bundle);
            if (fromBundle == null && vf != null && context.getPackageName().equals(vf.f712a.getAsString("PROCESS_CFG_PACKAGE_NAME")) && vf.f712a.getAsInteger("PROCESS_CFG_SDK_API_LEVEL").intValue() == AppMetrica.getLibraryApiLevel()) {
                return new C0268g4(vf, fromBundle);
            }
            return null;
        }
        vf = null;
        fromBundle = CounterConfiguration.fromBundle(bundle);
        if (fromBundle == null) {
        }
        return null;
    }

    public final CounterConfiguration b() {
        return this.b;
    }

    public final String toString() {
        return "ClientConfiguration{mProcessConfiguration=" + this.f888a + ", mCounterConfiguration=" + this.b + AbstractJsonLexerKt.END_OBJ;
    }

    public final Vf a() {
        return this.f888a;
    }
}
