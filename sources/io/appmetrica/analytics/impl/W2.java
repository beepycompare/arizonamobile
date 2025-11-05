package io.appmetrica.analytics.impl;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import io.appmetrica.analytics.coreapi.internal.backport.Consumer;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public final class W2 implements InterfaceC0506pk {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList f740a;
    public Intent b;
    public final Context c;
    public final N5 d;

    public W2(Context context, ICommonExecutor iCommonExecutor) {
        this(context, iCommonExecutor, 0);
    }

    public final synchronized Intent a(Consumer<Intent> consumer) {
        this.f740a.add(consumer);
        return this.b;
    }

    public final void b() {
        this.b = null;
        N5 n5 = this.d;
        Context context = this.c;
        synchronized (n5) {
            if (n5.b) {
                try {
                    context.unregisterReceiver(n5.f601a);
                    n5.b = false;
                } catch (Throwable unused) {
                }
            }
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0506pk
    public final synchronized void onCreate() {
        Intent a2 = a();
        this.b = a2;
        Iterator it = this.f740a.iterator();
        while (it.hasNext()) {
            ((Consumer) it.next()).consume(a2);
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0506pk
    public final synchronized void onDestroy() {
        this.b = null;
        b();
        Iterator it = this.f740a.iterator();
        while (it.hasNext()) {
            ((Consumer) it.next()).consume(null);
        }
    }

    public W2(Context context, ICommonExecutor iCommonExecutor, int i) {
        this.f740a = new ArrayList();
        this.b = null;
        this.c = context;
        this.d = M5.a(new B2(new V2(this), iCommonExecutor));
    }

    public final Intent a() {
        Intent intent;
        IntentFilter intentFilter = new IntentFilter("android.intent.action.BATTERY_CHANGED");
        N5 n5 = this.d;
        Context context = this.c;
        synchronized (n5) {
            try {
                intent = context.registerReceiver(n5.f601a, intentFilter);
                try {
                    n5.b = true;
                } catch (Throwable unused) {
                }
            } catch (Throwable unused2) {
                intent = null;
            }
        }
        return intent;
    }
}
