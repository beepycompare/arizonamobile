package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.control.DataSendingRestrictionController;
import io.appmetrica.analytics.coreapi.internal.io.IExecutionPolicy;
/* renamed from: io.appmetrica.analytics.impl.qi  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0528qi implements IExecutionPolicy {

    /* renamed from: a  reason: collision with root package name */
    public final DataSendingRestrictionController f1173a;
    public final String b = "data restriction based";

    public C0528qi(DataSendingRestrictionController dataSendingRestrictionController) {
        this.f1173a = dataSendingRestrictionController;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.io.IExecutionPolicy
    public final boolean canBeExecuted() {
        return !this.f1173a.isRestrictedForSdk();
    }

    @Override // io.appmetrica.analytics.coreapi.internal.io.IExecutionPolicy
    public final String description() {
        return this.b;
    }
}
