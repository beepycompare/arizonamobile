package io.appmetrica.analytics.impl;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import io.appmetrica.analytics.coreapi.internal.backport.Consumer;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes5.dex */
public final class O2 implements InterfaceC0409lk {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList f720a;
    public Intent b;
    public final Context c;
    public final G5 d;
    public final IHandlerExecutor e;

    public O2(Context context, IHandlerExecutor iHandlerExecutor) {
        this(context, iHandlerExecutor, 0);
    }

    public final synchronized Intent a(Consumer<Intent> consumer) {
        this.f720a.add(consumer);
        return this.b;
    }

    public final void b() {
        this.b = null;
        G5 g5 = this.d;
        Context context = this.c;
        synchronized (g5) {
            if (g5.b) {
                try {
                    context.unregisterReceiver(g5.f592a);
                    g5.b = false;
                } catch (Throwable unused) {
                }
            }
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0409lk
    public final synchronized void onCreate() {
        Intent a2 = a();
        this.b = a2;
        Iterator it = this.f720a.iterator();
        while (it.hasNext()) {
            ((Consumer) it.next()).consume(a2);
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0409lk
    public final synchronized void onDestroy() {
        this.b = null;
        b();
        Iterator it = this.f720a.iterator();
        while (it.hasNext()) {
            ((Consumer) it.next()).consume(null);
        }
    }

    public O2(Context context, IHandlerExecutor iHandlerExecutor, int i) {
        this.f720a = new ArrayList();
        this.b = null;
        this.c = context;
        this.e = iHandlerExecutor;
        this.d = F5.a(new C0590t2(new N2(this), iHandlerExecutor));
    }

    public final Intent a() {
        Intent intent;
        IntentFilter intentFilter = new IntentFilter("android.intent.action.BATTERY_CHANGED");
        G5 g5 = this.d;
        Context context = this.c;
        IHandlerExecutor iHandlerExecutor = this.e;
        synchronized (g5) {
            intent = null;
            try {
                intent = context.registerReceiver(g5.f592a, intentFilter, null, iHandlerExecutor.getHandler());
                g5.b = true;
            } catch (Throwable unused) {
            }
        }
        return intent;
    }
}
