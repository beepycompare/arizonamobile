package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.control.DataSendingRestrictionController;
import io.appmetrica.analytics.coreutils.internal.WrapUtils;
/* renamed from: io.appmetrica.analytics.impl.hh  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC0299hh implements InterfaceC0324ih {

    /* renamed from: a  reason: collision with root package name */
    protected final DataSendingRestrictionController f1008a;

    public AbstractC0299hh(DataSendingRestrictionController dataSendingRestrictionController) {
        this.f1008a = dataSendingRestrictionController;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0324ih
    public boolean a(Boolean bool) {
        return ((Boolean) WrapUtils.getOrDefault(bool, Boolean.TRUE)).booleanValue();
    }
}
