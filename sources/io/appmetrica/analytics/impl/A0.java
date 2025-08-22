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
/* loaded from: classes4.dex */
public final class A0 {

    /* renamed from: a  reason: collision with root package name */
    public final Yb f336a = new Yb(C0696x4.l().d());
    public final Zb b = new Zb();
    public final C0147bc c = new C0147bc();

    public final void a(final String str, final String str2, final String str3) {
        Yb yb = this.f336a;
        if (yb.c.a((Void) null).f1067a && yb.d.a(str).f1067a && yb.e.a(str2).f1067a && yb.f.a(str3).f1067a) {
            this.b.getClass();
            IHandlerExecutor a2 = C0696x4.l().c.a();
            ((W9) a2).b.post(new Runnable() { // from class: io.appmetrica.analytics.impl.A0$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    A0.a(A0.this, str, str2, str3);
                }
            });
            return;
        }
        PublicLogger.Companion.getAnonymousInstance().warning("[AppMetricaLibraryAdapterProxy]" + ("Failed report event from sender: " + str + " with name = " + str2 + " and payload = " + str3), new Object[0]);
    }

    public static final void a(A0 a0, String str, String str2, String str3) {
        List<InterfaceC0566s> list;
        Context a2;
        C0147bc c0147bc = a0.c;
        c0147bc.getClass();
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
        synchronized (c0147bc) {
            if (c0147bc.f792a == null && (a2 = C0696x4.l().g.a()) != null) {
                c0147bc.f792a = CollectionsKt.listOf((Object[]) new InterfaceC0566s[]{new C0278ge(), new C0364jn(a2), new Ko()});
            }
            list = c0147bc.f792a;
        }
        if (list != null) {
            for (InterfaceC0566s interfaceC0566s : list) {
                interfaceC0566s.a(mutableMapOf);
            }
        }
        ModulesFacade.reportEvent(withName.withAttributes(mutableMapOf).build());
    }
}
