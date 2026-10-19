package io.appmetrica.analytics.impl;

import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import io.appmetrica.analytics.IReporter;
import java.util.HashMap;
/* renamed from: io.appmetrica.analytics.impl.jh  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0349jh extends AbstractC0298hh {
    public final IReporter b;

    public C0349jh(C0441n5 c0441n5, IReporter iReporter) {
        super(c0441n5);
        this.b = iReporter;
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0298hh
    public final boolean a(C0235f6 c0235f6) {
        C0294hd c0294hd = (C0294hd) C0294hd.c.get(c0235f6.d);
        HashMap hashMap = new HashMap();
        hashMap.put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, c0294hd.f1018a);
        hashMap.put("delivery_method", c0294hd.b);
        this.b.reportEvent("crash_saved", hashMap);
        return false;
    }
}
