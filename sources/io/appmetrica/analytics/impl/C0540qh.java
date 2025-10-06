package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.backport.Consumer;
import io.appmetrica.analytics.coreutils.internal.logger.LoggerStorage;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.util.HashMap;
import java.util.Set;
/* renamed from: io.appmetrica.analytics.impl.qh  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0540qh {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1052a;
    public final InterfaceC0363jl b;
    public final Nb c = new Nb();
    public final N4 d = new N4(new C0338im(), new M4(), null);
    public final Consumer e;

    public C0540qh(Context context, final C6 c6, final Bb bb, InterfaceC0363jl interfaceC0363jl) {
        this.f1052a = context;
        this.b = interfaceC0363jl;
        this.e = new Consumer() { // from class: io.appmetrica.analytics.impl.qh$$ExternalSyntheticLambda0
            @Override // io.appmetrica.analytics.coreapi.internal.backport.Consumer
            public final void consume(Object obj) {
                C0540qh.a(Bb.this, c6, this, (Jb) obj);
            }
        };
    }

    public static final void a(Bb bb, C6 c6, C0540qh c0540qh, Jb jb) {
        String str = jb.h;
        C0476o4 c0476o4 = new C0476o4(str, jb.e, jb.f, jb.g, jb.i);
        String str2 = jb.b;
        byte[] bArr = jb.f516a;
        int i = jb.c;
        HashMap hashMap = jb.d;
        String str3 = jb.j;
        PublicLogger orCreatePublicLogger = LoggerStorage.getOrCreatePublicLogger(str);
        Set set = W9.f726a;
        C0398l4 c0398l4 = new C0398l4(bArr, str2, bb.f369a, orCreatePublicLogger);
        c0398l4.q = hashMap;
        c0398l4.g = i;
        c0398l4.c = str3;
        ((C0489oh) c6).a(c0476o4, c0398l4, c0540qh.d);
    }
}
