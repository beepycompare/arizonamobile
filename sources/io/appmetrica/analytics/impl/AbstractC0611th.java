package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.control.DataSendingRestrictionController;
import io.appmetrica.analytics.coreutils.internal.WrapUtils;
/* renamed from: io.appmetrica.analytics.impl.th  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC0611th implements InterfaceC0636uh {

    /* renamed from: a  reason: collision with root package name */
    protected final DataSendingRestrictionController f1067a;

    public AbstractC0611th(DataSendingRestrictionController dataSendingRestrictionController) {
        this.f1067a = dataSendingRestrictionController;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0636uh
    public boolean a(Boolean bool) {
        return ((Boolean) WrapUtils.getOrDefault(bool, Boolean.TRUE)).booleanValue();
    }
}
