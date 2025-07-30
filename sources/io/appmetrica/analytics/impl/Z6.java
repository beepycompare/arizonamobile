package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.control.DataSendingRestrictionController;
import io.appmetrica.analytics.coreutils.internal.WrapUtils;
import java.util.HashSet;
/* loaded from: classes4.dex */
public final class Z6 implements DataSendingRestrictionController {

    /* renamed from: a  reason: collision with root package name */
    public final X6 f745a;
    public Boolean b;
    public final HashSet c = new HashSet();
    public final HashSet d = new HashSet();

    public Z6(X6 x6) {
        this.f745a = x6;
        this.b = ((Y6) x6).a();
    }

    public final synchronized void a(Boolean bool) {
        if (io.a(bool) || this.b == null) {
            Boolean valueOf = Boolean.valueOf(Boolean.FALSE.equals(bool));
            this.b = valueOf;
            X6 x6 = this.f745a;
            ((Y6) x6).f731a.c(valueOf.booleanValue()).b();
        }
    }

    public final synchronized void b(Boolean bool) {
        if (this.b == null) {
            a(bool);
        }
    }

    @Override // io.appmetrica.analytics.coreapi.internal.control.DataSendingRestrictionController
    public final synchronized boolean isRestrictedForSdk() {
        Boolean bool;
        bool = this.b;
        return bool == null ? this.d.isEmpty() : bool.booleanValue();
    }

    public final synchronized void a(String str, Boolean bool) {
        if (io.a(bool) || (!this.d.contains(str) && !this.c.contains(str))) {
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
