package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.services.UtilityServiceConfiguration;
import io.appmetrica.analytics.coreutils.internal.services.UtilityServiceProvider;
/* renamed from: io.appmetrica.analytics.impl.ko  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0383ko implements InterfaceC0407lm {

    /* renamed from: a  reason: collision with root package name */
    public final UtilityServiceProvider f1080a;

    public C0383ko(UtilityServiceProvider utilityServiceProvider) {
        this.f1080a = utilityServiceProvider;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0407lm
    public final void a(C0278gm c0278gm) {
        this.f1080a.updateConfiguration(new UtilityServiceConfiguration(c0278gm.v, c0278gm.u));
    }
}
