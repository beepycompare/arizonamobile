package ru.rustore.sdk.appupdate;

import android.content.Context;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import ru.rustore.sdk.analytics.AnalyticsEventProvider;
import ru.rustore.sdk.metrics.MetricsClient;
/* loaded from: classes4.dex */
public final class e0 {
    public static volatile e0 i;

    /* renamed from: a  reason: collision with root package name */
    public final Context f1380a;
    public final Map<String, Object> b;
    public final Lazy c = LazyKt.lazy(new d());
    public final Lazy d = LazyKt.lazy(new c());
    public final Lazy e = LazyKt.lazy(new e());
    public final Lazy f = LazyKt.lazy(b.f1381a);
    public final Lazy g = LazyKt.lazy(new f());
    public final Lazy h = LazyKt.lazy(new g());

    /* loaded from: classes4.dex */
    public static final class a {
    }

    /* loaded from: classes4.dex */
    public static final class b extends Lambda implements Function0<C0805j> {

        /* renamed from: a  reason: collision with root package name */
        public static final b f1381a = new b();

        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final C0805j invoke() {
            return new C0805j();
        }
    }

    /* loaded from: classes4.dex */
    public static final class c extends Lambda implements Function0<C0809n> {
        public c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final C0809n invoke() {
            return new C0809n((C0805j) e0.this.f.getValue(), (MetricsClient) e0.this.g.getValue());
        }
    }

    /* loaded from: classes4.dex */
    public static final class d extends Lambda implements Function0<C0800e> {
        public d() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final C0800e invoke() {
            return new C0800e((C0809n) e0.this.d.getValue(), (a0) e0.this.h.getValue(), (L) e0.this.e.getValue(), AnalyticsEventProvider.INSTANCE, e0.this.f1380a);
        }
    }

    /* loaded from: classes4.dex */
    public static final class e extends Lambda implements Function0<L> {
        public e() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final L invoke() {
            return new L(new K(e0.this.f1380a));
        }
    }

    /* loaded from: classes4.dex */
    public static final class f extends Lambda implements Function0<MetricsClient> {
        public f() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final MetricsClient invoke() {
            return MetricsClient.Companion.getInstance(e0.this.f1380a);
        }
    }

    /* loaded from: classes4.dex */
    public static final class g extends Lambda implements Function0<a0> {
        public g() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final a0 invoke() {
            return new a0(new b0(), new c0(e0.this.b), new d0());
        }
    }

    public e0(Context context, Map map) {
        this.f1380a = context;
        this.b = map;
    }
}
