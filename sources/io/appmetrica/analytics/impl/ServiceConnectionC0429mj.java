package io.appmetrica.analytics.impl;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Parcel;
/* renamed from: io.appmetrica.analytics.impl.mj  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class ServiceConnectionC0429mj implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    public final Dg f1104a;
    public final BinderC0403lj b;
    public final /* synthetic */ C0455nj c;

    public ServiceConnectionC0429mj(C0455nj c0455nj, Dg dg) {
        this.c = c0455nj;
        this.f1104a = dg;
        this.b = new BinderC0403lj(c0455nj, this);
    }

    @Override // android.content.ServiceConnection
    public final void onBindingDied(ComponentName componentName) {
        C0455nj.a(this.c, this);
        this.f1104a.a(new Jg("RuStore service binding died", null, 2, null));
    }

    @Override // android.content.ServiceConnection
    public final void onNullBinding(ComponentName componentName) {
        C0455nj.a(this.c, this);
        this.f1104a.a(new Jg("RuStore service returned null binding", null, 2, null));
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        try {
            Ab a2 = AbstractBinderC0758zb.a(iBinder);
            if (a2 == null) {
                C0455nj.a(this.c, this);
                this.f1104a.a(new Jg("RuStore service binder is null", null, 2, null));
                return;
            }
            String packageName = this.c.f1123a.getPackageName();
            BinderC0403lj binderC0403lj = this.b;
            C0732yb c0732yb = (C0732yb) a2;
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            obtain.writeInterfaceToken("ru.vk.store.sdk.install.referrer.InstallReferrerProvider");
            obtain.writeString(packageName);
            obtain.writeStrongInterface(binderC0403lj);
            c0732yb.f1298a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            obtain2.recycle();
            obtain.recycle();
        } catch (Throwable th) {
            C0455nj.a(this.c, this);
            this.f1104a.a(new Jg("Failed to referrer from RuStore service", th));
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
    }
}
