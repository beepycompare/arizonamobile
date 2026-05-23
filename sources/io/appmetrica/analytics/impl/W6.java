package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.control.DataSendingRestrictionController;
import io.appmetrica.analytics.coreutils.internal.WrapUtils;
import java.util.HashSet;
/* loaded from: classes5.dex */
public final class W6 implements DataSendingRestrictionController {

    /* renamed from: a  reason: collision with root package name */
    public final U6 f819a;
    public Boolean b;
    public final HashSet c = new HashSet();
    public final HashSet d = new HashSet();

    public W6(U6 u6) {
        this.f819a = u6;
        this.b = ((V6) u6).a();
    }

    public final synchronized void a(Boolean bool) {
        if (Oo.a(bool) || this.b == null) {
            Boolean valueOf = Boolean.valueOf(Boolean.FALSE.equals(bool));
            this.b = valueOf;
            U6 u6 = this.f819a;
            ((V6) u6).f803a.c(valueOf.booleanValue());
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
        if (Oo.a(bool) || (!this.d.contains(str) && !this.c.contains(str))) {
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
