package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.control.DataSendingRestrictionController;
import io.appmetrica.analytics.coreutils.internal.WrapUtils;
import java.util.HashSet;
/* loaded from: classes5.dex */
public final class F6 implements DataSendingRestrictionController {

    /* renamed from: a  reason: collision with root package name */
    public final D6 f474a;
    public Boolean b;
    public final HashSet c = new HashSet();
    public final HashSet d = new HashSet();

    public F6(D6 d6) {
        this.f474a = d6;
        this.b = ((E6) d6).a();
    }

    public final synchronized void a(Boolean bool) {
        if (mo.a(bool) || this.b == null) {
            Boolean valueOf = Boolean.valueOf(Boolean.FALSE.equals(bool));
            this.b = valueOf;
            D6 d6 = this.f474a;
            ((E6) d6).f455a.c(valueOf.booleanValue()).b();
        }
    }

    public final synchronized void b(Boolean bool) {
        if (this.b == null) {
            a(bool);
        }
    }

    @Override // io.appmetrica.analytics.coreapi.internal.control.DataSendingRestrictionController
    public final synchronized boolean isRestrictedForMainReporter() {
        return Boolean.TRUE.equals(this.b);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.control.DataSendingRestrictionController
    public final synchronized boolean isRestrictedForReporter(String str) {
        boolean z;
        if (!this.c.contains(str)) {
            z = Boolean.TRUE.equals(this.b);
        }
        return z;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.control.DataSendingRestrictionController
    public final synchronized boolean isRestrictedForSdk() {
        Boolean bool;
        bool = this.b;
        return bool == null ? this.d.isEmpty() : bool.booleanValue();
    }

    public final synchronized void a(String str, Boolean bool) {
        if (mo.a(bool) || (!this.d.contains(str) && !this.c.contains(str))) {
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
