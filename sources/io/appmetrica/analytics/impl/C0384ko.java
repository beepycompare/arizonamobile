package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.services.UtilityServiceConfiguration;
import io.appmetrica.analytics.coreutils.internal.services.UtilityServiceProvider;
/* renamed from: io.appmetrica.analytics.impl.ko  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0384ko implements InterfaceC0408lm {

    /* renamed from: a  reason: collision with root package name */
    public final UtilityServiceProvider f982a;

    public C0384ko(UtilityServiceProvider utilityServiceProvider) {
        this.f982a = utilityServiceProvider;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0408lm
    public final void a(C0279gm c0279gm) {
        this.f982a.updateConfiguration(new UtilityServiceConfiguration(c0279gm.v, c0279gm.u));
    }
}
