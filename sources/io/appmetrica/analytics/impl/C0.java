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
public final class C0 {

    /* renamed from: a  reason: collision with root package name */
    public final C0148bc f379a = new C0148bc(A4.l().d());
    public final C0174cc b = new C0174cc();
    public final C0225ec c = new C0225ec();

    public final void a(final String str, final String str2, final String str3) {
        C0148bc c0148bc = this.f379a;
        if (c0148bc.c.a((Void) null).f1146a && c0148bc.d.a(str).f1146a && c0148bc.e.a(str2).f1146a && c0148bc.f.a(str3).f1146a) {
            this.b.getClass();
            IHandlerExecutor a2 = A4.l().c.a();
            ((Z9) a2).b.post(new Runnable() { // from class: io.appmetrica.analytics.impl.C0$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    C0.a(C0.this, str, str2, str3);
                }
            });
            return;
        }
        PublicLogger.Companion.getAnonymousInstance().warning("[AppMetricaLibraryAdapterProxy]" + ("Failed report event from sender: " + str + " with name = " + str2 + " and payload = " + str3), new Object[0]);
    }

    public static final void a(C0 c0, String str, String str2, String str3) {
        List<InterfaceC0571s> list;
        Context a2;
        C0225ec c0225ec = c0.c;
        c0225ec.getClass();
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
        synchronized (c0225ec) {
            if (c0225ec.f859a == null && (a2 = A4.l().g.a()) != null) {
                c0225ec.f859a = CollectionsKt.listOf((Object[]) new InterfaceC0571s[]{new C0382ke(), new C0469nn(a2), new Oo()});
            }
            list = c0225ec.f859a;
        }
        if (list != null) {
            for (InterfaceC0571s interfaceC0571s : list) {
                interfaceC0571s.a(mutableMapOf);
            }
        }
        ModulesFacade.reportEvent(withName.withAttributes(mutableMapOf).build());
    }
}
