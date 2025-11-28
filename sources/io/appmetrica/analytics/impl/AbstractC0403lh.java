package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.control.DataSendingRestrictionController;
import io.appmetrica.analytics.coreutils.internal.WrapUtils;
/* renamed from: io.appmetrica.analytics.impl.lh  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC0403lh implements InterfaceC0428mh {

    /* renamed from: a  reason: collision with root package name */
    protected final DataSendingRestrictionController f992a;

    public AbstractC0403lh(DataSendingRestrictionController dataSendingRestrictionController) {
        this.f992a = dataSendingRestrictionController;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0428mh
    public boolean a(Boolean bool) {
        return ((Boolean) WrapUtils.getOrDefault(bool, Boolean.TRUE)).booleanValue();
    }
}
