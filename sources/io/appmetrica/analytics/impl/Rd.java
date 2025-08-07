package io.appmetrica.analytics.impl;

import android.os.Bundle;
import io.appmetrica.analytics.coreapi.internal.backport.Consumer;
import io.appmetrica.analytics.coreutils.internal.logger.LoggerStorage;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.util.Set;
/* loaded from: classes4.dex */
public final class Rd implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final C0263fh f622a;
    public final C0 b;
    public final C0131ae c;

    public Rd(C0263fh c0263fh, C0 c0, C0131ae c0131ae) {
        this.f622a = c0263fh;
        this.b = c0;
        this.c = c0131ae;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.backport.Consumer
    /* renamed from: a */
    public final void consume(String str) {
        C0263fh c0263fh = this.f622a;
        C0 c0 = this.b;
        String str2 = c0.f367a;
        String str3 = c0.b;
        Integer valueOf = Integer.valueOf(c0.d);
        C0 c02 = this.b;
        C0400l4 c0400l4 = new C0400l4(str2, str3, valueOf, c02.e, c02.c);
        C0131ae c0131ae = this.c;
        EnumC0681wb enumC0681wb = c0131ae.b;
        B0 b0 = c0131ae.f768a;
        String str4 = b0.c;
        PublicLogger orCreatePublicLogger = LoggerStorage.getOrCreatePublicLogger(b0.f.f367a);
        Set set = R9.f620a;
        Bundle bundle = new Bundle();
        bundle.putString("payload_crash_id", str4);
        C0326i4 c0326i4 = new C0326i4("", "", enumC0681wb.f1119a, orCreatePublicLogger);
        if (str != null) {
            c0326i4.f(str);
        }
        c0326i4.m = bundle;
        c0326i4.c = c0131ae.f768a.f.f;
        c0263fh.a(c0400l4, c0326i4, new K4(new Zl(), new J4(), null));
    }
}
