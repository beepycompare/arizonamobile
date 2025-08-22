package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.control.DataSendingRestrictionController;
import io.appmetrica.analytics.coreutils.internal.WrapUtils;
/* renamed from: io.appmetrica.analytics.impl.yh  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC0734yh implements InterfaceC0759zh {

    /* renamed from: a  reason: collision with root package name */
    protected final DataSendingRestrictionController f1161a;

    public AbstractC0734yh(DataSendingRestrictionController dataSendingRestrictionController) {
        this.f1161a = dataSendingRestrictionController;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0759zh
    public boolean a(Boolean bool) {
        return ((Boolean) WrapUtils.getOrDefault(bool, Boolean.TRUE)).booleanValue();
    }
}
