package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.control.DataSendingRestrictionController;
import io.appmetrica.analytics.coreutils.internal.WrapUtils;
/* renamed from: io.appmetrica.analytics.impl.hh  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC0300hh implements InterfaceC0325ih {

    /* renamed from: a  reason: collision with root package name */
    protected final DataSendingRestrictionController f925a;

    public AbstractC0300hh(DataSendingRestrictionController dataSendingRestrictionController) {
        this.f925a = dataSendingRestrictionController;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0325ih
    public boolean a(Boolean bool) {
        return ((Boolean) WrapUtils.getOrDefault(bool, Boolean.TRUE)).booleanValue();
    }
}
