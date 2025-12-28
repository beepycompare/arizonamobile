package ru.rustore.sdk.metrics.internal;

import android.content.Context;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import ru.rustore.sdk.metrics.MetricsClient;
/* loaded from: classes6.dex */
public final class X {
    public static final a c = new a();
    public static X d;

    /* renamed from: a  reason: collision with root package name */
    public final U f1588a;
    public final MetricsClient b;

    /* loaded from: classes6.dex */
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

    /* loaded from: classes6.dex */
    public static final class b implements InterfaceC0816g {
        @Override // ru.rustore.sdk.metrics.internal.InterfaceC0816g
        public final void a(Function0<String> messageBuilder) {
            Intrinsics.checkNotNullParameter(messageBuilder, "messageBuilder");
        }
    }

    public X(Context context) {
        Z z = new Z();
        b bVar = new b();
        Y y = new Y(context);
        N n = new N(new I(new C0824o(context, new B(new C0831w(), new C0832x(), new C0834z(new a0()), new A())), bVar), new K(new C0828t(), new c0()), new L(new C0828t()), bVar);
        U u = new U(n, new T(n, new S(new b0(y, new c0()), new C(context), new O(new C0827s(new C0811b(), new Q(), bVar)), new e0(context))));
        this.f1588a = u;
        this.b = new MetricsClient(new C0823n(u, new C0812c(n), new V(context, new C0813d(new C0815f(new C0814e()))), z, bVar));
    }
}
