package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import io.appmetrica.analytics.coreapi.internal.backport.Consumer;
import io.appmetrica.analytics.coreapi.internal.backport.Function;
import java.io.File;
/* renamed from: io.appmetrica.analytics.impl.ob  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0471ob implements Function, Consumer {
    @Override // io.appmetrica.analytics.coreapi.internal.backport.Function
    /* renamed from: a */
    public final C0370kb apply(File file) {
        String a2 = Ka.a(file);
        if (!TextUtils.isEmpty(a2)) {
            try {
                return new C0370kb(a2);
            } catch (Throwable unused) {
                return null;
            }
        }
        return null;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.backport.Consumer
    /* renamed from: b */
    public final void consume(File file) {
        try {
            file.delete();
        } catch (Throwable unused) {
        }
    }
}
