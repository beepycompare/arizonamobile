package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.ModuleEvent;
import io.appmetrica.analytics.ModulesFacade;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* loaded from: classes5.dex */
public final class H0 {

    /* renamed from: a  reason: collision with root package name */
    public final C0195dc f571a = new C0195dc(C0574s4.l().d());
    public final C0220ec b = new C0220ec();
    public final C0272gc c = new C0272gc();

    public final void a(final String str, final String str2, final String str3) {
        C0195dc c0195dc = this.f571a;
        if (c0195dc.c.a((Void) null).f784a && c0195dc.d.a(str).f784a && c0195dc.e.a(str2).f784a && c0195dc.f.a(str3).f784a) {
            this.b.getClass();
            IHandlerExecutor a2 = C0574s4.l().c.a();
            ((U9) a2).b.post(new Runnable() { // from class: io.appmetrica.analytics.impl.H0$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    H0.a(H0.this, str, str2, str3);
                }
            });
            return;
        }
        PublicLogger.Companion.getAnonymousInstance().warning("[AppMetricaLibraryAdapterProxy]" + ("Failed report event from sender: " + str + " with name = " + str2 + " and payload = " + str3), new Object[0]);
    }

    public static final void a(H0 h0, String str, String str2, String str3) {
        List<InterfaceC0621u> list;
        Context a2;
        C0272gc c0272gc = h0.c;
        c0272gc.getClass();
        Pair[] pairArr = new Pair[3];
        if (str == null) {
            str = AbstractJsonLexerKt.NULL;
        }
        pairArr[0] = TuplesKt.to("sender", str);
        if (str2 == null) {
            str2 = AbstractJsonLexerKt.NULL;
        }
        pairArr[1] = TuplesKt.to("event", str2);
        if (str3 == null) {
            str3 = AbstractJsonLexerKt.NULL;
        }
        pairArr[2] = TuplesKt.to("payload", str3);
        Map<String, Object> mutableMapOf = MapsKt.mutableMapOf(pairArr);
        ModuleEvent.Builder withName = ModuleEvent.newBuilder(4).withName("appmetrica_system_event_42");
        synchronized (c0272gc) {
            if (c0272gc.f997a == null && (a2 = C0574s4.l().g.a()) != null) {
                c0272gc.f997a = CollectionsKt.listOf((Object[]) new InterfaceC0621u[]{new C0533qe(), new Gn(a2), new np()});
            }
            list = c0272gc.f997a;
        }
        if (list != null) {
            for (InterfaceC0621u interfaceC0621u : list) {
                interfaceC0621u.a(mutableMapOf);
            }
        }
        ModulesFacade.reportEvent(withName.withAttributes(mutableMapOf).build());
    }
}
