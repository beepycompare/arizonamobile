package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.control.DataSendingRestrictionController;
import io.appmetrica.analytics.coreutils.internal.WrapUtils;
import java.util.HashSet;
/* loaded from: classes4.dex */
public final class W6 implements DataSendingRestrictionController {

    /* renamed from: a  reason: collision with root package name */
    public final U6 f682a;
    public Boolean b;
    public final HashSet c = new HashSet();
    public final HashSet d = new HashSet();

    public W6(U6 u6) {
        this.f682a = u6;
        this.b = ((V6) u6).a();
    }

    public final synchronized void a(Boolean bool) {
        if (fo.a(bool) || this.b == null) {
            Boolean valueOf = Boolean.valueOf(Boolean.FALSE.equals(bool));
            this.b = valueOf;
            U6 u6 = this.f682a;
            ((V6) u6).f670a.c(valueOf.booleanValue()).b();
        }
    }

    @Override // io.appmetrica.analytics.coreapi.internal.control.DataSendingRestrictionController
    public final boolean isRestrictedForBackgroundDataCollection() {
        Boolean bool = this.b;
        if (bool == null) {
            return !this.c.isEmpty() || this.d.isEmpty();
        }
        return bool.booleanValue();
    }

    @Override // io.appmetrica.analytics.coreapi.internal.control.DataSendingRestrictionController
    public final synchronized boolean isRestrictedForReporter() {
        boolean booleanValue;
        Boolean bool = this.b;
        if (bool == null) {
            booleanValue = this.d.isEmpty() && this.c.isEmpty();
        } else {
            booleanValue = bool.booleanValue();
        }
        return booleanValue;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.control.DataSendingRestrictionController
    public final synchronized boolean isRestrictedForSdk() {
        Boolean bool;
        bool = this.b;
        return bool == null ? this.d.isEmpty() : bool.booleanValue();
    }

    public final synchronized void a(String str, Boolean bool) {
        if (fo.a(bool) || (!this.d.contains(str) && !this.c.contains(str))) {
            if (((Boolean) WrapUtils.getOrDefault(bool, Boolean.TRUE)).booleanValue()) {
                this.d.add(str);
                this.c.remove(str);
            } else {
                this.c.add(str);
                this.d.remove(str);
            }
        }
    }
}
