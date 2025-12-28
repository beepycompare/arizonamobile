package io.appmetrica.analytics.impl;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import io.appmetrica.analytics.coreapi.internal.backport.Consumer;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes5.dex */
public final class P2 implements InterfaceC0430mk {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList f728a;
    public Intent b;
    public final Context c;
    public final H5 d;
    public final IHandlerExecutor e;

    public P2(Context context, IHandlerExecutor iHandlerExecutor) {
        this(context, iHandlerExecutor, 0);
    }

    public final synchronized Intent a(Consumer<Intent> consumer) {
        this.f728a.add(consumer);
        return this.b;
    }

    public final void b() {
        this.b = null;
        H5 h5 = this.d;
        Context context = this.c;
        synchronized (h5) {
            if (h5.b) {
                try {
                    context.unregisterReceiver(h5.f600a);
                    h5.b = false;
                } catch (Throwable unused) {
                }
            }
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0430mk
    public final synchronized void onCreate() {
        Intent a2 = a();
        this.b = a2;
        Iterator it = this.f728a.iterator();
        while (it.hasNext()) {
            ((Consumer) it.next()).consume(a2);
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0430mk
    public final synchronized void onDestroy() {
        this.b = null;
        b();
        Iterator it = this.f728a.iterator();
        while (it.hasNext()) {
            ((Consumer) it.next()).consume(null);
        }
    }

    public P2(Context context, IHandlerExecutor iHandlerExecutor, int i) {
        this.f728a = new ArrayList();
        this.b = null;
        this.c = context;
        this.e = iHandlerExecutor;
        this.d = G5.a(new C0611u2(new O2(this), iHandlerExecutor));
    }

    public final Intent a() {
        Intent intent;
        IntentFilter intentFilter = new IntentFilter("android.intent.action.BATTERY_CHANGED");
        H5 h5 = this.d;
        Context context = this.c;
        IHandlerExecutor iHandlerExecutor = this.e;
        synchronized (h5) {
            intent = null;
            try {
                intent = context.registerReceiver(h5.f600a, intentFilter, null, iHandlerExecutor.getHandler());
                h5.b = true;
            } catch (Throwable unused) {
            }
        }
        return intent;
    }
}
