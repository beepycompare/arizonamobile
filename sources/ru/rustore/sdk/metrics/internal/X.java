package ru.rustore.sdk.metrics.internal;

import android.content.Context;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import ru.rustore.sdk.metrics.MetricsClient;
/* loaded from: classes4.dex */
public final class X {
    public static final a c = new a();
    public static X d;

    /* renamed from: a  reason: collision with root package name */
    public final U f1444a;
    public final MetricsClient b;

    /* loaded from: classes4.dex */
    public static final class a {
        public final X a(Context context) {
            X x;
            Intrinsics.checkNotNullParameter(context, "context");
            synchronized (this) {
                x = X.d;
                if (x == null) {
                    Context applicationContext = context.getApplicationContext();
                    Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
                    x = new X(applicationContext);
                    X.d = x;
                }
            }
            return x;
        }
    }

    /* loaded from: classes4.dex */
    public static final class b implements InterfaceC0828g {
        @Override // ru.rustore.sdk.metrics.internal.InterfaceC0828g
        public final void a(Function0<String> messageBuilder) {
            Intrinsics.checkNotNullParameter(messageBuilder, "messageBuilder");
        }
    }

    public X(Context context) {
        Z z = new Z();
        b bVar = new b();
        Y y = new Y(context);
        N n = new N(new I(new C0836o(context, new B(new C0843w(), new C0844x(), new C0846z(new a0()), new A())), bVar), new K(new C0840t(), new c0()), new L(new C0840t()), bVar);
        U u = new U(n, new T(n, new S(new b0(y, new c0()), new C(context), new O(new C0839s(new C0823b(), new Q(), bVar)), new e0(context))));
        this.f1444a = u;
        this.b = new MetricsClient(new C0835n(u, new C0824c(n), new V(context, new C0825d(new C0827f(new C0826e()))), z, bVar));
    }
}
