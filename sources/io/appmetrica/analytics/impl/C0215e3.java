package io.appmetrica.analytics.impl;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import io.appmetrica.analytics.coreapi.internal.backport.Consumer;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
import java.util.ArrayList;
import java.util.Iterator;
/* renamed from: io.appmetrica.analytics.impl.e3  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0215e3 implements Bk {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList f851a;
    public Intent b;
    public final Context c;
    public final C0244f6 d;

    public C0215e3(Context context, ICommonExecutor iCommonExecutor) {
        this(context, iCommonExecutor, 0);
    }

    public final synchronized Intent a(Consumer<Intent> consumer) {
        this.f851a.add(consumer);
        return this.b;
    }

    public final void b() {
        this.b = null;
        C0244f6 c0244f6 = this.d;
        Context context = this.c;
        synchronized (c0244f6) {
            if (c0244f6.b) {
                try {
                    context.unregisterReceiver(c0244f6.f869a);
                    c0244f6.b = false;
                } catch (Throwable unused) {
                }
            }
        }
    }

    @Override // io.appmetrica.analytics.impl.Bk
    public final synchronized void onCreate() {
        Intent a2 = a();
        this.b = a2;
        Iterator it = this.f851a.iterator();
        while (it.hasNext()) {
            ((Consumer) it.next()).consume(a2);
        }
    }

    @Override // io.appmetrica.analytics.impl.Bk
    public final synchronized void onDestroy() {
        this.b = null;
        b();
        Iterator it = this.f851a.iterator();
        while (it.hasNext()) {
            ((Consumer) it.next()).consume(null);
        }
    }

    public C0215e3(Context context, ICommonExecutor iCommonExecutor, int i) {
        this.f851a = new ArrayList();
        this.b = null;
        this.c = context;
        this.d = AbstractC0218e6.a(new I2(new C0190d3(this), iCommonExecutor));
    }

    public final Intent a() {
        Intent intent;
        IntentFilter intentFilter = new IntentFilter("android.intent.action.BATTERY_CHANGED");
        C0244f6 c0244f6 = this.d;
        Context context = this.c;
        synchronized (c0244f6) {
            try {
                intent = context.registerReceiver(c0244f6.f869a, intentFilter);
                try {
                    c0244f6.b = true;
                } catch (Throwable unused) {
                }
            } catch (Throwable unused2) {
                intent = null;
            }
        }
        return intent;
    }
}
