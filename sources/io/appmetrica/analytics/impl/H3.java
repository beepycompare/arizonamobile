package io.appmetrica.analytics.impl;

import android.content.Context;
import android.os.Bundle;
import io.appmetrica.analytics.AppMetrica;
import io.appmetrica.analytics.internal.CounterConfiguration;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* loaded from: classes5.dex */
public class H3 {

    /* renamed from: a  reason: collision with root package name */
    public final Bf f612a;
    public final CounterConfiguration b;

    public H3(Bf bf, CounterConfiguration counterConfiguration) {
        this.f612a = bf;
        this.b = counterConfiguration;
    }

    public static H3 a(Context context, Bundle bundle) {
        Bf bf;
        CounterConfiguration fromBundle;
        String str = Bf.c;
        if (bundle != null) {
            try {
                bf = (Bf) bundle.getParcelable("PROCESS_CFG_OBJ");
            } catch (Throwable unused) {
            }
            fromBundle = CounterConfiguration.fromBundle(bundle);
            if (fromBundle == null && bf != null && context.getPackageName().equals(bf.f525a.getAsString("PROCESS_CFG_PACKAGE_NAME")) && bf.f525a.getAsInteger("PROCESS_CFG_SDK_API_LEVEL").intValue() == AppMetrica.getLibraryApiLevel()) {
                return new H3(bf, fromBundle);
            }
            return null;
        }
        bf = null;
        fromBundle = CounterConfiguration.fromBundle(bundle);
        if (fromBundle == null) {
        }
        return null;
    }

    public final CounterConfiguration b() {
        return this.b;
    }

    public final String toString() {
        return "ClientConfiguration{mProcessConfiguration=" + this.f612a + ", mCounterConfiguration=" + this.b + AbstractJsonLexerKt.END_OBJ;
    }

    public final Bf a() {
        return this.f612a;
    }
}
