package io.appmetrica.analytics.impl;

import android.content.Context;
import android.os.Bundle;
import io.appmetrica.analytics.AppMetrica;
import io.appmetrica.analytics.internal.CounterConfiguration;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.d4  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C0191d4 {

    /* renamed from: a  reason: collision with root package name */
    public final Rf f823a;
    public final CounterConfiguration b;

    public C0191d4(Rf rf, CounterConfiguration counterConfiguration) {
        this.f823a = rf;
        this.b = counterConfiguration;
    }

    public static C0191d4 a(Context context, Bundle bundle) {
        Rf rf;
        CounterConfiguration fromBundle;
        String str = Rf.c;
        if (bundle != null) {
            try {
                rf = (Rf) bundle.getParcelable("PROCESS_CFG_OBJ");
            } catch (Throwable unused) {
            }
            fromBundle = CounterConfiguration.fromBundle(bundle);
            if (fromBundle == null && rf != null && context.getPackageName().equals(rf.f635a.getAsString("PROCESS_CFG_PACKAGE_NAME")) && rf.f635a.getAsInteger("PROCESS_CFG_SDK_API_LEVEL").intValue() == AppMetrica.getLibraryApiLevel()) {
                return new C0191d4(rf, fromBundle);
            }
            return null;
        }
        rf = null;
        fromBundle = CounterConfiguration.fromBundle(bundle);
        if (fromBundle == null) {
        }
        return null;
    }

    public final CounterConfiguration b() {
        return this.b;
    }

    public final String toString() {
        return "ClientConfiguration{mProcessConfiguration=" + this.f823a + ", mCounterConfiguration=" + this.b + AbstractJsonLexerKt.END_OBJ;
    }

    public final Rf a() {
        return this.f823a;
    }
}
