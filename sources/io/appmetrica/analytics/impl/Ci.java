package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.control.DataSendingRestrictionController;
import io.appmetrica.analytics.coreapi.internal.io.IExecutionPolicy;
/* loaded from: classes4.dex */
public final class Ci implements IExecutionPolicy {

    /* renamed from: a  reason: collision with root package name */
    public final DataSendingRestrictionController f381a;
    public final String b = "data restriction based";

    public Ci(DataSendingRestrictionController dataSendingRestrictionController) {
        this.f381a = dataSendingRestrictionController;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.io.IExecutionPolicy
    public final boolean canBeExecuted() {
        return !this.f381a.isRestrictedForSdk();
    }

    @Override // io.appmetrica.analytics.coreapi.internal.io.IExecutionPolicy
    public final String description() {
        return this.b;
    }
}
