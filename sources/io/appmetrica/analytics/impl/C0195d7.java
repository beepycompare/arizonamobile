package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.control.DataSendingRestrictionController;
import io.appmetrica.analytics.coreutils.internal.WrapUtils;
import java.util.HashSet;
/* renamed from: io.appmetrica.analytics.impl.d7  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0195d7 implements DataSendingRestrictionController {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0143b7 f839a;
    public Boolean b;
    public final HashSet c = new HashSet();
    public final HashSet d = new HashSet();

    public C0195d7(InterfaceC0143b7 interfaceC0143b7) {
        this.f839a = interfaceC0143b7;
        this.b = ((C0169c7) interfaceC0143b7).a();
    }

    public final synchronized void a(Boolean bool) {
        if (ro.a(bool) || this.b == null) {
            Boolean valueOf = Boolean.valueOf(Boolean.FALSE.equals(bool));
            this.b = valueOf;
            InterfaceC0143b7 interfaceC0143b7 = this.f839a;
            ((C0169c7) interfaceC0143b7).f822a.c(valueOf.booleanValue()).b();
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
        if (ro.a(bool) || (!this.d.contains(str) && !this.c.contains(str))) {
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
