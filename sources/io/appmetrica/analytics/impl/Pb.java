package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.backport.Consumer;
import io.appmetrica.analytics.coreapi.internal.backport.Function;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.io.File;
/* loaded from: classes5.dex */
public final class Pb implements Function, Consumer {
    @Override // io.appmetrica.analytics.coreapi.internal.backport.Function
    /* renamed from: a */
    public final Lb apply(File file) {
        String a2 = AbstractC0402lb.a(file);
        long lastModified = file.lastModified();
        if (!StringUtils.isNullOrEmpty(a2)) {
            try {
                return new Lb(a2, lastModified);
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
