package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.control.DataSendingRestrictionController;
import io.appmetrica.analytics.coreutils.internal.WrapUtils;
/* loaded from: classes4.dex */
public abstract class Ch implements Dh {

    /* renamed from: a  reason: collision with root package name */
    protected final DataSendingRestrictionController f387a;

    public Ch(DataSendingRestrictionController dataSendingRestrictionController) {
        this.f387a = dataSendingRestrictionController;
    }

    @Override // io.appmetrica.analytics.impl.Dh
    public boolean a(Boolean bool) {
        return ((Boolean) WrapUtils.getOrDefault(bool, Boolean.TRUE)).booleanValue();
    }
}
