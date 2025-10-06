package io.appmetrica.analytics.impl;

import android.text.TextUtils;
import io.appmetrica.analytics.coreapi.internal.backport.Consumer;
import io.appmetrica.analytics.coreapi.internal.backport.Function;
import java.io.File;
/* loaded from: classes4.dex */
public final class Nb implements Function, Consumer {
    @Override // io.appmetrica.analytics.coreapi.internal.backport.Function
    /* renamed from: a */
    public final Jb apply(File file) {
        String a2 = AbstractC0353jb.a(file);
        if (!TextUtils.isEmpty(a2)) {
            try {
                return new Jb(a2);
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
