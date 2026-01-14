package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.control.DataSendingRestrictionController;
import io.appmetrica.analytics.coreutils.internal.WrapUtils;
/* renamed from: io.appmetrica.analytics.impl.gh  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC0278gh implements InterfaceC0304hh {

    /* renamed from: a  reason: collision with root package name */
    protected final DataSendingRestrictionController f1015a;

    public AbstractC0278gh(DataSendingRestrictionController dataSendingRestrictionController) {
        this.f1015a = dataSendingRestrictionController;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0304hh
    public boolean a(Boolean bool) {
        return ((Boolean) WrapUtils.getOrDefault(bool, Boolean.TRUE)).booleanValue();
    }
}
