package io.appmetrica.analytics.impl;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import io.appmetrica.analytics.coreapi.internal.backport.Consumer;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import java.util.ArrayList;
import java.util.Iterator;
/* renamed from: io.appmetrica.analytics.impl.b3  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0135b3 implements Nk {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList f901a;
    public Intent b;
    public final Context c;
    public final W5 d;
    public final IHandlerExecutor e;

    public C0135b3(Context context, IHandlerExecutor iHandlerExecutor) {
        this(context, iHandlerExecutor, 0);
    }

    public final synchronized Intent a(Consumer<Intent> consumer) {
        this.f901a.add(consumer);
        return this.b;
    }

    public final void b() {
        this.b = null;
        W5 w5 = this.d;
        Context context = this.c;
        synchronized (w5) {
            if (w5.b) {
                try {
                    context.unregisterReceiver(w5.f821a);
                    w5.b = false;
                } catch (Throwable unused) {
                }
            }
        }
    }

    @Override // io.appmetrica.analytics.impl.Nk
    public final synchronized void onCreate() {
        Intent a2 = a();
        this.b = a2;
        Iterator it = this.f901a.iterator();
        while (it.hasNext()) {
            ((Consumer) it.next()).consume(a2);
        }
    }

    @Override // io.appmetrica.analytics.impl.Nk
    public final synchronized void onDestroy() {
        this.b = null;
        b();
        Iterator it = this.f901a.iterator();
        while (it.hasNext()) {
            ((Consumer) it.next()).consume(null);
        }
    }

    public C0135b3(Context context, IHandlerExecutor iHandlerExecutor, int i) {
        this.f901a = new ArrayList();
        this.b = null;
        this.c = context;
        this.e = iHandlerExecutor;
        this.d = V5.a(new G2(new C0109a3(this), iHandlerExecutor));
    }

    public final Intent a() {
        Intent intent;
        IntentFilter intentFilter = new IntentFilter("android.intent.action.BATTERY_CHANGED");
        W5 w5 = this.d;
        Context context = this.c;
        IHandlerExecutor iHandlerExecutor = this.e;
        synchronized (w5) {
            intent = null;
            try {
                intent = context.registerReceiver(w5.f821a, intentFilter, null, iHandlerExecutor.getHandler());
                w5.b = true;
            } catch (Throwable unused) {
            }
        }
        return intent;
    }
}
