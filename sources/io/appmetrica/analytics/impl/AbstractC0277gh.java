package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.control.DataSendingRestrictionController;
import io.appmetrica.analytics.coreutils.internal.WrapUtils;
/* renamed from: io.appmetrica.analytics.impl.gh  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC0277gh implements InterfaceC0303hh {

    /* renamed from: a  reason: collision with root package name */
    protected final DataSendingRestrictionController f1014a;

    public AbstractC0277gh(DataSendingRestrictionController dataSendingRestrictionController) {
        this.f1014a = dataSendingRestrictionController;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0303hh
    public boolean a(Boolean bool) {
        return ((Boolean) WrapUtils.getOrDefault(bool, Boolean.TRUE)).booleanValue();
    }
}
