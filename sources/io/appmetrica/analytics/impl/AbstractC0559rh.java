package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.control.DataSendingRestrictionController;
import io.appmetrica.analytics.coreutils.internal.WrapUtils;
/* renamed from: io.appmetrica.analytics.impl.rh  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC0559rh implements InterfaceC0584sh {

    /* renamed from: a  reason: collision with root package name */
    protected final DataSendingRestrictionController f1028a;

    public AbstractC0559rh(DataSendingRestrictionController dataSendingRestrictionController) {
        this.f1028a = dataSendingRestrictionController;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0584sh
    public boolean a(Boolean bool) {
        return ((Boolean) WrapUtils.getOrDefault(bool, Boolean.TRUE)).booleanValue();
    }
}
