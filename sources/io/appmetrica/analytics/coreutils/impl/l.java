package io.appmetrica.analytics.coreutils.impl;

import io.appmetrica.analytics.coreutils.internal.services.FirstExecutionConditionServiceImpl;
import io.appmetrica.analytics.coreutils.internal.services.UtilityServiceProvider;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
/* loaded from: classes5.dex */
public final class l extends Lambda implements Function0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UtilityServiceProvider f346a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(UtilityServiceProvider utilityServiceProvider) {
        super(0);
        this.f346a = utilityServiceProvider;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        return new FirstExecutionConditionServiceImpl(this.f346a);
    }
}
