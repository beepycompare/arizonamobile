package io.appmetrica.analytics.impl;

import android.content.Context;
import android.location.Location;
import android.net.ConnectivityManager;
import io.appmetrica.analytics.coreutils.internal.services.SafePackageManager;
import io.appmetrica.analytics.coreutils.internal.system.SystemServiceUtils;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class A7 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f331a;
    public final int b;
    public final C0360j9 c;
    public final P8 d;
    public final C0277g0 e;
    public final Z8 f;
    public final D7 g;
    public final C0333i6 h;

    public A7(Context context, Rk rk, int i, C0360j9 c0360j9, P8 p8, C0277g0 c0277g0, Z8 z8, D7 d7) {
        this.f331a = context;
        this.b = i;
        this.c = c0360j9;
        this.d = p8;
        this.e = c0277g0;
        this.f = z8;
        this.g = d7;
        this.h = p8.f577a;
    }

    public static String b() {
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        C0349in A = Ga.F.A();
        C0757z7 c0757z7 = new C0757z7(objectRef);
        synchronized (A) {
            A.b.a(c0757z7);
        }
        return (String) objectRef.element;
    }

    public final C0682w7 a() {
        JSONObject optJSONObject;
        Bo bo;
        Integer valueOf = Integer.valueOf(this.h.e);
        String name = this.h.getName();
        String value = this.h.getValue();
        C0360j9 c0360j9 = this.c;
        int i = this.b;
        ro roVar = c0360j9.f889a.f902a;
        synchronized (roVar) {
            optJSONObject = roVar.f1033a.a().optJSONObject("numbers_of_type");
        }
        long optLong = optJSONObject != null ? optJSONObject.optLong(String.valueOf(i)) : 0L;
        c0360j9.f889a.a(i, 1 + optLong);
        Long valueOf2 = Long.valueOf(optLong);
        D7 d7 = this.g;
        d7.getClass();
        InterfaceC0214dc l = Ga.F.l();
        Location userLocation = l.getUserLocation();
        if (userLocation != null) {
            int i2 = Bo.b;
            Location location = new Location(userLocation);
            String provider = location.getProvider();
            location.setProvider("");
            bo = new Bo(location, provider);
        } else {
            Location systemLocation = l.getSystemLocation();
            bo = systemLocation != null ? new Bo(new Location(systemLocation), "") : null;
        }
        boolean z = d7.f385a.d;
        Double valueOf3 = bo != null ? Double.valueOf(bo.getLatitude()) : null;
        Double valueOf4 = bo != null ? Double.valueOf(bo.getLongitude()) : null;
        Long valueOf5 = bo != null ? Long.valueOf(bo.getTime()) : null;
        Integer valueOf6 = bo != null ? Integer.valueOf((int) bo.getAccuracy()) : null;
        Integer valueOf7 = bo != null ? Integer.valueOf((int) bo.getBearing()) : null;
        Integer valueOf8 = bo != null ? Integer.valueOf((int) bo.getSpeed()) : null;
        B7 b7 = new B7(Boolean.valueOf(z), valueOf4, valueOf3, bo != null ? Integer.valueOf((int) bo.getAltitude()) : null, valueOf7, valueOf6, valueOf8, valueOf5, bo != null ? bo.getProvider() : null, bo != null ? bo.f360a : null);
        String str = this.h.c;
        C0277g0 c0277g0 = this.e;
        String str2 = c0277g0.f846a;
        Long valueOf9 = Long.valueOf(c0277g0.b);
        Integer valueOf10 = Integer.valueOf(this.h.g);
        Context context = this.f331a;
        SafePackageManager safePackageManager = Se.f625a;
        Integer valueOf11 = Integer.valueOf(((Integer) Se.d.a((Re) SystemServiceUtils.accessSystemServiceSafelyOrDefault((ConnectivityManager) context.getSystemService("connectivity"), "getting connection type", "ConnectivityManager", Re.UNDEFINED, new Qe()))).intValue());
        String b = b();
        Y8 y8 = this.d.b;
        C0333i6 c0333i6 = this.h;
        return new C0682w7(valueOf, name, value, valueOf2, b7, str, str2, valueOf9, valueOf10, valueOf11, b, y8, c0333i6.h, c0333i6.k, c0333i6.l, c0333i6.n, c0333i6.o, this.f.fromModel(c0333i6.p));
    }

    public /* synthetic */ A7(Context context, Rk rk, int i, C0360j9 c0360j9, P8 p8, C0667vh c0667vh, C0277g0 c0277g0) {
        this(context, rk, i, c0360j9, p8, c0277g0, new Z8(), new D7(c0667vh));
    }
}
