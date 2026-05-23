package io.appmetrica.analytics.impl;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Parcel;
/* renamed from: io.appmetrica.analytics.impl.mj  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class ServiceConnectionC0436mj implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    public final Dg f1098a;
    public final BinderC0410lj b;
    public final /* synthetic */ C0462nj c;

    public ServiceConnectionC0436mj(C0462nj c0462nj, Dg dg) {
        this.c = c0462nj;
        this.f1098a = dg;
        this.b = new BinderC0410lj(c0462nj, this);
    }

    @Override // android.content.ServiceConnection
    public final void onBindingDied(ComponentName componentName) {
        C0462nj.a(this.c, this);
        this.f1098a.a(new Jg("RuStore service binding died", null, 2, null));
    }

    @Override // android.content.ServiceConnection
    public final void onNullBinding(ComponentName componentName) {
        C0462nj.a(this.c, this);
        this.f1098a.a(new Jg("RuStore service returned null binding", null, 2, null));
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        try {
            Ab a2 = AbstractBinderC0765zb.a(iBinder);
            if (a2 == null) {
                C0462nj.a(this.c, this);
                this.f1098a.a(new Jg("RuStore service binder is null", null, 2, null));
                return;
            }
            String packageName = this.c.f1117a.getPackageName();
            BinderC0410lj binderC0410lj = this.b;
            C0739yb c0739yb = (C0739yb) a2;
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            obtain.writeInterfaceToken("ru.vk.store.sdk.install.referrer.InstallReferrerProvider");
            obtain.writeString(packageName);
            obtain.writeStrongInterface(binderC0410lj);
            c0739yb.f1292a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            obtain2.recycle();
            obtain.recycle();
        } catch (Throwable th) {
            C0462nj.a(this.c, this);
            this.f1098a.a(new Jg("Failed to referrer from RuStore service", th));
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
    }
}
