package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.control.DataSendingRestrictionController;
import io.appmetrica.analytics.coreutils.internal.WrapUtils;
/* renamed from: io.appmetrica.analytics.impl.rh  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC0567rh implements InterfaceC0592sh {

    /* renamed from: a  reason: collision with root package name */
    protected final DataSendingRestrictionController f1027a;

    public AbstractC0567rh(DataSendingRestrictionController dataSendingRestrictionController) {
        this.f1027a = dataSendingRestrictionController;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0592sh
    public boolean a(Boolean bool) {
        return ((Boolean) WrapUtils.getOrDefault(bool, Boolean.TRUE)).booleanValue();
    }
}
