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
/* loaded from: classes3.dex */
public final class D0 {

    /* renamed from: a  reason: collision with root package name */
    public final Ib f433a = new Ib(C0338j4.l().d());
    public final Jb b = new Jb();
    public final Lb c = new Lb();

    public final void a(final String str, final String str2, final String str3) {
        Ib ib = this.f433a;
        if (ib.c.a((Void) null).f1120a && ib.d.a(str).f1120a && ib.e.a(str2).f1120a && ib.f.a(str3).f1120a) {
            this.b.getClass();
            IHandlerExecutor a2 = C0338j4.l().c.a();
            ((G9) a2).b.post(new Runnable() { // from class: io.appmetrica.analytics.impl.D0$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    D0.a(D0.this, str, str2, str3);
                }
            });
            return;
        }
        PublicLogger.Companion.getAnonymousInstance().warning("[AppMetricaLibraryAdapterProxy]" + ("Failed report event from sender: " + str + " with name = " + str2 + " and payload = " + str3), new Object[0]);
    }

    public static final void a(D0 d0, String str, String str2, String str3) {
        List<InterfaceC0584t> list;
        Context a2;
        Lb lb = d0.c;
        lb.getClass();
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
        synchronized (lb) {
            if (lb.f572a == null && (a2 = C0338j4.l().g.a()) != null) {
                lb.f572a = CollectionsKt.listOf((Object[]) new InterfaceC0584t[]{new Wd(), new C0331in(a2), new Ko()});
            }
            list = lb.f572a;
        }
        if (list != null) {
            for (InterfaceC0584t interfaceC0584t : list) {
                interfaceC0584t.a(mutableMapOf);
            }
        }
        ModulesFacade.reportEvent(withName.withAttributes(mutableMapOf).build());
    }
}
