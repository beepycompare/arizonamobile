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
public final class C0146b3 implements InterfaceC0590sk {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList f778a;
    public Intent b;
    public final Context c;
    public final C0175c6 d;

    public C0146b3(Context context, ICommonExecutor iCommonExecutor) {
        this(context, iCommonExecutor, 0);
    }

    public final synchronized Intent a(Consumer<Intent> consumer) {
        this.f778a.add(consumer);
        return this.b;
    }

    public final void b() {
        this.b = null;
        C0175c6 c0175c6 = this.d;
        Context context = this.c;
        synchronized (c0175c6) {
            if (c0175c6.b) {
                try {
                    context.unregisterReceiver(c0175c6.f794a);
                    c0175c6.b = false;
                } catch (Throwable unused) {
                }
            }
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0590sk
    public final synchronized void onCreate() {
        Intent a2 = a();
        this.b = a2;
        Iterator it = this.f778a.iterator();
        while (it.hasNext()) {
            ((Consumer) it.next()).consume(a2);
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0590sk
    public final synchronized void onDestroy() {
        this.b = null;
        b();
        Iterator it = this.f778a.iterator();
        while (it.hasNext()) {
            ((Consumer) it.next()).consume(null);
        }
    }

    public C0146b3(Context context, ICommonExecutor iCommonExecutor, int i) {
        this.f778a = new ArrayList();
        this.b = null;
        this.c = context;
        this.d = AbstractC0149b6.a(new F2(new C0120a3(this), iCommonExecutor));
    }

    public final Intent a() {
        Intent intent;
        IntentFilter intentFilter = new IntentFilter("android.intent.action.BATTERY_CHANGED");
        C0175c6 c0175c6 = this.d;
        Context context = this.c;
        synchronized (c0175c6) {
            try {
                intent = context.registerReceiver(c0175c6.f794a, intentFilter);
                try {
                    c0175c6.b = true;
                } catch (Throwable unused) {
                }
            } catch (Throwable unused2) {
                intent = null;
            }
        }
        return intent;
    }
}
