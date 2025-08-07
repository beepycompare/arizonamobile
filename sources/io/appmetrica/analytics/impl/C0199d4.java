package io.appmetrica.analytics.impl;

import android.content.Context;
import android.os.Bundle;
import io.appmetrica.analytics.AppMetrica;
import io.appmetrica.analytics.internal.CounterConfiguration;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.d4  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C0199d4 {

    /* renamed from: a  reason: collision with root package name */
    public final Pf f811a;
    public final CounterConfiguration b;

    public C0199d4(Pf pf, CounterConfiguration counterConfiguration) {
        this.f811a = pf;
        this.b = counterConfiguration;
    }

    public static C0199d4 a(Context context, Bundle bundle) {
        Pf pf;
        CounterConfiguration fromBundle;
        String str = Pf.c;
        if (bundle != null) {
            try {
                pf = (Pf) bundle.getParcelable("PROCESS_CFG_OBJ");
            } catch (Throwable unused) {
            }
            fromBundle = CounterConfiguration.fromBundle(bundle);
            if (fromBundle == null && pf != null && context.getPackageName().equals(pf.f595a.getAsString("PROCESS_CFG_PACKAGE_NAME")) && pf.f595a.getAsInteger("PROCESS_CFG_SDK_API_LEVEL").intValue() == AppMetrica.getLibraryApiLevel()) {
                return new C0199d4(pf, fromBundle);
            }
            return null;
        }
        pf = null;
        fromBundle = CounterConfiguration.fromBundle(bundle);
        if (fromBundle == null) {
        }
        return null;
    }

    public final CounterConfiguration b() {
        return this.b;
    }

    public final String toString() {
        return "ClientConfiguration{mProcessConfiguration=" + this.f811a + ", mCounterConfiguration=" + this.b + AbstractJsonLexerKt.END_OBJ;
    }

    public final Pf a() {
        return this.f811a;
    }
}
