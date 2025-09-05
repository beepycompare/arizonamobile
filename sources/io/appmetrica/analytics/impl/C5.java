package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.io.IExecutionPolicy;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
/* loaded from: classes4.dex */
public final class C5 extends Lambda implements Function1 {

    /* renamed from: a  reason: collision with root package name */
    public static final C5 f379a = new C5();

    public C5() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return ((IExecutionPolicy) obj).description();
    }
}
