package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.control.DataSendingRestrictionController;
import io.appmetrica.analytics.coreapi.internal.io.IExecutionPolicy;
/* loaded from: classes5.dex */
public final class Ji implements IExecutionPolicy {

    /* renamed from: a  reason: collision with root package name */
    public final DataSendingRestrictionController f614a;
    public final String b = "data restriction based";

    public Ji(DataSendingRestrictionController dataSendingRestrictionController) {
        this.f614a = dataSendingRestrictionController;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.io.IExecutionPolicy
    public final boolean canBeExecuted() {
        return !this.f614a.isRestrictedForSdk();
    }

    @Override // io.appmetrica.analytics.coreapi.internal.io.IExecutionPolicy
    public final String description() {
        return this.b;
    }
}
