package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.io.IExecutionPolicy;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
/* renamed from: io.appmetrica.analytics.impl.u5  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0629u5 extends Lambda implements Function1 {

    /* renamed from: a  reason: collision with root package name */
    public static final C0629u5 f1225a = new C0629u5();

    public C0629u5() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return ((IExecutionPolicy) obj).description();
    }
}
