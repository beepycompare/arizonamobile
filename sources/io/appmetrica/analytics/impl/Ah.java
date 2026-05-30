package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.control.DataSendingRestrictionController;
import io.appmetrica.analytics.coreutils.internal.WrapUtils;
/* loaded from: classes5.dex */
public abstract class Ah implements Bh {

    /* renamed from: a  reason: collision with root package name */
    protected final DataSendingRestrictionController f460a;

    public Ah(DataSendingRestrictionController dataSendingRestrictionController) {
        this.f460a = dataSendingRestrictionController;
    }

    @Override // io.appmetrica.analytics.impl.Bh
    public boolean a(Boolean bool) {
        return ((Boolean) WrapUtils.getOrDefault(bool, Boolean.TRUE)).booleanValue();
    }
}
