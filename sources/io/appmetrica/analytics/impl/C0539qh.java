package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.backport.Consumer;
import io.appmetrica.analytics.coreutils.internal.logger.LoggerStorage;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.util.HashMap;
import java.util.Set;
/* renamed from: io.appmetrica.analytics.impl.qh  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0539qh {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1051a;
    public final InterfaceC0362jl b;
    public final Nb c = new Nb();
    public final N4 d = new N4(new C0337im(), new M4(), null);
    public final Consumer e;

    public C0539qh(Context context, final C6 c6, final Bb bb, InterfaceC0362jl interfaceC0362jl) {
        this.f1051a = context;
        this.b = interfaceC0362jl;
        this.e = new Consumer() { // from class: io.appmetrica.analytics.impl.qh$$ExternalSyntheticLambda0
            @Override // io.appmetrica.analytics.coreapi.internal.backport.Consumer
            public final void consume(Object obj) {
                C0539qh.a(Bb.this, c6, this, (Jb) obj);
            }
        };
    }

    public static final void a(Bb bb, C6 c6, C0539qh c0539qh, Jb jb) {
        String str = jb.h;
        C0475o4 c0475o4 = new C0475o4(str, jb.e, jb.f, jb.g, jb.i);
        String str2 = jb.b;
        byte[] bArr = jb.f515a;
        int i = jb.c;
        HashMap hashMap = jb.d;
        String str3 = jb.j;
        PublicLogger orCreatePublicLogger = LoggerStorage.getOrCreatePublicLogger(str);
        Set set = W9.f725a;
        C0397l4 c0397l4 = new C0397l4(bArr, str2, bb.f368a, orCreatePublicLogger);
        c0397l4.q = hashMap;
        c0397l4.g = i;
        c0397l4.c = str3;
        ((C0488oh) c6).a(c0475o4, c0397l4, c0539qh.d);
    }
}
