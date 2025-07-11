package io.appmetrica.analytics.impl;

import android.content.Context;
import android.os.Bundle;
import io.appmetrica.analytics.AppMetrica;
import io.appmetrica.analytics.internal.CounterConfiguration;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* renamed from: io.appmetrica.analytics.impl.d4  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C0198d4 {

    /* renamed from: a  reason: collision with root package name */
    public final Nf f797a;
    public final CounterConfiguration b;

    public C0198d4(Nf nf, CounterConfiguration counterConfiguration) {
        this.f797a = nf;
        this.b = counterConfiguration;
    }

    public static C0198d4 a(Context context, Bundle bundle) {
        Nf nf;
        CounterConfiguration fromBundle;
        String str = Nf.c;
        if (bundle != null) {
            try {
                nf = (Nf) bundle.getParcelable("PROCESS_CFG_OBJ");
            } catch (Throwable unused) {
            }
            fromBundle = CounterConfiguration.fromBundle(bundle);
            if (fromBundle == null && nf != null && context.getPackageName().equals(nf.f554a.getAsString("PROCESS_CFG_PACKAGE_NAME")) && nf.f554a.getAsInteger("PROCESS_CFG_SDK_API_LEVEL").intValue() == AppMetrica.getLibraryApiLevel()) {
                return new C0198d4(nf, fromBundle);
            }
            return null;
        }
        nf = null;
        fromBundle = CounterConfiguration.fromBundle(bundle);
        if (fromBundle == null) {
        }
        return null;
    }

    public final CounterConfiguration b() {
        return this.b;
    }

    public final String toString() {
        return "ClientConfiguration{mProcessConfiguration=" + this.f797a + ", mCounterConfiguration=" + this.b + AbstractJsonLexerKt.END_OBJ;
    }

    public final Nf a() {
        return this.f797a;
    }
}
