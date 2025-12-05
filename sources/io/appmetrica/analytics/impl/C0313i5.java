package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.modulesapi.internal.client.adrevenue.ModuleAdRevenueProcessor;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
/* renamed from: io.appmetrica.analytics.impl.i5  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0313i5 extends Lambda implements Function1 {

    /* renamed from: a  reason: collision with root package name */
    public static final C0313i5 f1018a = new C0313i5();

    public C0313i5() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return ((ModuleAdRevenueProcessor) obj).getDescription();
    }
}
