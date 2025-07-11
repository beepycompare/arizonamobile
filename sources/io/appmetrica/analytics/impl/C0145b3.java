package io.appmetrica.analytics.impl;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import io.appmetrica.analytics.coreapi.internal.backport.Consumer;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
import java.util.ArrayList;
import java.util.Iterator;
/* renamed from: io.appmetrica.analytics.impl.b3  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0145b3 implements InterfaceC0513pk {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList f765a;
    public Intent b;
    public final Context c;
    public final Z5 d;

    public C0145b3(Context context, ICommonExecutor iCommonExecutor) {
        this(context, iCommonExecutor, 0);
    }

    public final synchronized Intent a(Consumer<Intent> consumer) {
        this.f765a.add(consumer);
        return this.b;
    }

    public final void b() {
        this.b = null;
        Z5 z5 = this.d;
        Context context = this.c;
        synchronized (z5) {
            if (z5.b) {
                try {
                    context.unregisterReceiver(z5.f732a);
                    z5.b = false;
                } catch (Throwable unused) {
                }
            }
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0513pk
    public final synchronized void onCreate() {
        Intent a2 = a();
        this.b = a2;
        Iterator it = this.f765a.iterator();
        while (it.hasNext()) {
            ((Consumer) it.next()).consume(a2);
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0513pk
    public final synchronized void onDestroy() {
        this.b = null;
        b();
        Iterator it = this.f765a.iterator();
        while (it.hasNext()) {
            ((Consumer) it.next()).consume(null);
        }
    }

    public C0145b3(Context context, ICommonExecutor iCommonExecutor, int i) {
        this.f765a = new ArrayList();
        this.b = null;
        this.c = context;
        this.d = Y5.a(new F2(new C0119a3(this), iCommonExecutor));
    }

    public final Intent a() {
        Intent intent;
        IntentFilter intentFilter = new IntentFilter("android.intent.action.BATTERY_CHANGED");
        Z5 z5 = this.d;
        Context context = this.c;
        synchronized (z5) {
            try {
                intent = context.registerReceiver(z5.f732a, intentFilter);
                try {
                    z5.b = true;
                } catch (Throwable unused) {
                }
            } catch (Throwable unused2) {
                intent = null;
            }
        }
        return intent;
    }
}
