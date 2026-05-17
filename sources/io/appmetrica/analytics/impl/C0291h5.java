package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.modulesapi.internal.client.adrevenue.ModuleAdRevenueProcessor;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
/* renamed from: io.appmetrica.analytics.impl.h5  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0291h5 extends Lambda implements Function1 {

    /* renamed from: a  reason: collision with root package name */
    public static final C0291h5 f1028a = new C0291h5();

    public C0291h5() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return ((ModuleAdRevenueProcessor) obj).getDescription();
    }
}
