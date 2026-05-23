package io.appmetrica.analytics.impl;

import android.content.Context;
import androidx.core.app.NotificationCompat;
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
    public final C0197dc f568a = new C0197dc(C0576s4.l().d());
    public final C0222ec b = new C0222ec();
    public final C0274gc c = new C0274gc();

    public final void a(final String str, final String str2, final String str3) {
        C0197dc c0197dc = this.f568a;
        if (c0197dc.c.a((Void) null).f781a && c0197dc.d.a(str).f781a && c0197dc.e.a(str2).f781a && c0197dc.f.a(str3).f781a) {
            this.b.getClass();
            IHandlerExecutor a2 = C0576s4.l().c.a();
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
        List<InterfaceC0623u> list;
        Context a2;
        C0274gc c0274gc = h0.c;
        c0274gc.getClass();
        Pair[] pairArr = new Pair[3];
        if (str == null) {
            str = AbstractJsonLexerKt.NULL;
        }
        pairArr[0] = TuplesKt.to("sender", str);
        if (str2 == null) {
            str2 = AbstractJsonLexerKt.NULL;
        }
        pairArr[1] = TuplesKt.to(NotificationCompat.CATEGORY_EVENT, str2);
        if (str3 == null) {
            str3 = AbstractJsonLexerKt.NULL;
        }
        pairArr[2] = TuplesKt.to("payload", str3);
        Map<String, Object> mutableMapOf = MapsKt.mutableMapOf(pairArr);
        ModuleEvent.Builder withName = ModuleEvent.newBuilder(4).withName("appmetrica_system_event_42");
        synchronized (c0274gc) {
            if (c0274gc.f994a == null && (a2 = C0576s4.l().g.a()) != null) {
                c0274gc.f994a = CollectionsKt.listOf((Object[]) new InterfaceC0623u[]{new C0535qe(), new Gn(a2), new np()});
            }
            list = c0274gc.f994a;
        }
        if (list != null) {
            for (InterfaceC0623u interfaceC0623u : list) {
                interfaceC0623u.a(mutableMapOf);
            }
        }
        ModulesFacade.reportEvent(withName.withAttributes(mutableMapOf).build());
    }
}
