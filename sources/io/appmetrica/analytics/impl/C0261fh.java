package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.backport.Consumer;
import io.appmetrica.analytics.coreutils.internal.logger.LoggerStorage;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.util.HashMap;
import java.util.Set;
/* renamed from: io.appmetrica.analytics.impl.fh  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0261fh {

    /* renamed from: a  reason: collision with root package name */
    public final Context f840a;
    public final Xk b;
    public final Gb c = new Gb();
    public final K4 d = new K4(new Wl(), new J4(), null);
    public final Consumer e;

    public C0261fh(Context context, final InterfaceC0673w6 interfaceC0673w6, final EnumC0628ub enumC0628ub, Xk xk) {
        this.f840a = context;
        this.b = xk;
        this.e = new Consumer() { // from class: io.appmetrica.analytics.impl.fh$$ExternalSyntheticLambda0
            @Override // io.appmetrica.analytics.coreapi.internal.backport.Consumer
            public final void consume(Object obj) {
                C0261fh.a(EnumC0628ub.this, interfaceC0673w6, this, (Cb) obj);
            }
        };
    }

    public static final void a(EnumC0628ub enumC0628ub, InterfaceC0673w6 interfaceC0673w6, C0261fh c0261fh, Cb cb) {
        String str = cb.h;
        C0397l4 c0397l4 = new C0397l4(str, cb.e, cb.f, cb.g, cb.i);
        String str2 = cb.b;
        byte[] bArr = cb.f372a;
        int i = cb.c;
        HashMap hashMap = cb.d;
        String str3 = cb.j;
        PublicLogger orCreatePublicLogger = LoggerStorage.getOrCreatePublicLogger(str);
        Set set = O9.f565a;
        C0323i4 c0323i4 = new C0323i4(bArr, str2, enumC0628ub.f1074a, orCreatePublicLogger);
        c0323i4.q = hashMap;
        c0323i4.g = i;
        c0323i4.c = str3;
        ((C0211dh) interfaceC0673w6).a(c0397l4, c0323i4, c0261fh.d);
    }
}
