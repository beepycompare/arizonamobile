package io.appmetrica.analytics.impl;

import android.os.Bundle;
import io.appmetrica.analytics.coreapi.internal.backport.Consumer;
import io.appmetrica.analytics.coreutils.internal.logger.LoggerStorage;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.util.Set;
/* loaded from: classes4.dex */
public final class Rd implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final C0262fh f623a;
    public final C0 b;
    public final C0130ae c;

    public Rd(C0262fh c0262fh, C0 c0, C0130ae c0130ae) {
        this.f623a = c0262fh;
        this.b = c0;
        this.c = c0130ae;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.backport.Consumer
    /* renamed from: a */
    public final void consume(String str) {
        C0262fh c0262fh = this.f623a;
        C0 c0 = this.b;
        String str2 = c0.f368a;
        String str3 = c0.b;
        Integer valueOf = Integer.valueOf(c0.d);
        C0 c02 = this.b;
        C0399l4 c0399l4 = new C0399l4(str2, str3, valueOf, c02.e, c02.c);
        C0130ae c0130ae = this.c;
        EnumC0680wb enumC0680wb = c0130ae.b;
        B0 b0 = c0130ae.f769a;
        String str4 = b0.c;
        PublicLogger orCreatePublicLogger = LoggerStorage.getOrCreatePublicLogger(b0.f.f368a);
        Set set = R9.f621a;
        Bundle bundle = new Bundle();
        bundle.putString("payload_crash_id", str4);
        C0325i4 c0325i4 = new C0325i4("", "", enumC0680wb.f1120a, orCreatePublicLogger);
        if (str != null) {
            c0325i4.f(str);
        }
        c0325i4.m = bundle;
        c0325i4.c = c0130ae.f769a.f.f;
        c0262fh.a(c0399l4, c0325i4, new K4(new Zl(), new J4(), null));
    }
}
