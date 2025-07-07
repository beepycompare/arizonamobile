package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.backport.Consumer;
import io.appmetrica.analytics.coreutils.internal.logger.LoggerStorage;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.util.HashMap;
import java.util.Set;
/* renamed from: io.appmetrica.analytics.impl.fh  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0269fh {

    /* renamed from: a  reason: collision with root package name */
    public final Context f839a;
    public final Xk b;
    public final Gb c = new Gb();
    public final K4 d = new K4(new Wl(), new J4(), null);
    public final Consumer e;

    public C0269fh(Context context, final InterfaceC0681w6 interfaceC0681w6, final EnumC0636ub enumC0636ub, Xk xk) {
        this.f839a = context;
        this.b = xk;
        this.e = new Consumer() { // from class: io.appmetrica.analytics.impl.fh$$ExternalSyntheticLambda0
            @Override // io.appmetrica.analytics.coreapi.internal.backport.Consumer
            public final void consume(Object obj) {
                C0269fh.a(EnumC0636ub.this, interfaceC0681w6, this, (Cb) obj);
            }
        };
    }

    public static final void a(EnumC0636ub enumC0636ub, InterfaceC0681w6 interfaceC0681w6, C0269fh c0269fh, Cb cb) {
        String str = cb.h;
        C0405l4 c0405l4 = new C0405l4(str, cb.e, cb.f, cb.g, cb.i);
        String str2 = cb.b;
        byte[] bArr = cb.f371a;
        int i = cb.c;
        HashMap hashMap = cb.d;
        String str3 = cb.j;
        PublicLogger orCreatePublicLogger = LoggerStorage.getOrCreatePublicLogger(str);
        Set set = O9.f564a;
        C0331i4 c0331i4 = new C0331i4(bArr, str2, enumC0636ub.f1073a, orCreatePublicLogger);
        c0331i4.q = hashMap;
        c0331i4.g = i;
        c0331i4.c = str3;
        ((C0219dh) interfaceC0681w6).a(c0405l4, c0331i4, c0269fh.d);
    }
}
