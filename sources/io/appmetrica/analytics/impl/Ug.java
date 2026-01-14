package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.backport.Consumer;
import io.appmetrica.analytics.coreutils.internal.logger.LoggerStorage;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.util.HashMap;
import java.util.Set;
/* loaded from: classes5.dex */
public final class Ug {

    /* renamed from: a  reason: collision with root package name */
    public final Context f814a;
    public final InterfaceC0127al b;
    public final C0450nb c = new C0450nb();
    public final C0493p4 d = new C0493p4(new Zl(), new C0468o4(), null);
    public final Consumer e;

    public Ug(Context context, final InterfaceC0190d6 interfaceC0190d6, final EnumC0143bb enumC0143bb, InterfaceC0127al interfaceC0127al) {
        this.f814a = context;
        this.b = interfaceC0127al;
        this.e = new Consumer() { // from class: io.appmetrica.analytics.impl.Ug$$ExternalSyntheticLambda0
            @Override // io.appmetrica.analytics.coreapi.internal.backport.Consumer
            public final void consume(Object obj) {
                Ug.a(EnumC0143bb.this, interfaceC0190d6, this, (C0349jb) obj);
            }
        };
    }

    public static final void a(EnumC0143bb enumC0143bb, InterfaceC0190d6 interfaceC0190d6, Ug ug, C0349jb c0349jb) {
        String str = c0349jb.h;
        P3 p3 = new P3(str, c0349jb.e, c0349jb.f, c0349jb.g, c0349jb.i);
        String str2 = c0349jb.b;
        byte[] bArr = c0349jb.f1062a;
        int i = c0349jb.c;
        HashMap hashMap = c0349jb.d;
        String str3 = c0349jb.j;
        PublicLogger orCreatePublicLogger = LoggerStorage.getOrCreatePublicLogger(str);
        Set set = AbstractC0672w9.f1285a;
        M3 m3 = new M3(bArr, str2, enumC0143bb.f918a, orCreatePublicLogger);
        m3.q = hashMap;
        m3.g = i;
        m3.c = str3;
        ((Sg) interfaceC0190d6).a(p3, m3, ug.d);
    }
}
