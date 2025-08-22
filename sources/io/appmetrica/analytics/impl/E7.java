package io.appmetrica.analytics.impl;

import android.content.Context;
import android.location.Location;
import android.net.ConnectivityManager;
import io.appmetrica.analytics.coreutils.internal.system.SystemServiceUtils;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class E7 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f409a;
    public final int b;
    public final C0477o9 c;
    public final U8 d;
    public final C0264g0 e;
    public final C0221e9 f;
    public final H7 g;
    public final C0399l6 h;

    public E7(Context context, Zk zk, int i, C0477o9 c0477o9, U8 u8, C0264g0 c0264g0, C0221e9 c0221e9, H7 h7) {
        this.f409a = context;
        this.b = i;
        this.c = c0477o9;
        this.d = u8;
        this.e = c0264g0;
        this.f = c0221e9;
        this.g = h7;
        this.h = u8.f674a;
    }

    public static String b() {
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        C0541qn A = Ka.F.A();
        D7 d7 = new D7(objectRef);
        synchronized (A) {
            A.b.a(d7);
        }
        return (String) objectRef.element;
    }

    public final A7 a() {
        JSONObject optJSONObject;
        Jo jo;
        Integer valueOf = Integer.valueOf(this.h.e);
        String name = this.h.getName();
        String value = this.h.getValue();
        C0477o9 c0477o9 = this.c;
        int i = this.b;
        zo zoVar = c0477o9.f997a.f1009a;
        synchronized (zoVar) {
            optJSONObject = zoVar.f1187a.a().optJSONObject("numbers_of_type");
        }
        long optLong = optJSONObject != null ? optJSONObject.optLong(String.valueOf(i)) : 0L;
        c0477o9.f997a.a(i, 1 + optLong);
        Long valueOf2 = Long.valueOf(optLong);
        H7 h7 = this.g;
        h7.getClass();
        InterfaceC0302hc l = Ka.F.l();
        Location userLocation = l.getUserLocation();
        if (userLocation != null) {
            int i2 = Jo.b;
            Location location = new Location(userLocation);
            String provider = location.getProvider();
            location.setProvider("");
            jo = new Jo(location, provider);
        } else {
            Location systemLocation = l.getSystemLocation();
            jo = systemLocation != null ? new Jo(new Location(systemLocation), "") : null;
        }
        boolean z = h7.f472a.d;
        Double valueOf3 = jo != null ? Double.valueOf(jo.getLatitude()) : null;
        Double valueOf4 = jo != null ? Double.valueOf(jo.getLongitude()) : null;
        Long valueOf5 = jo != null ? Long.valueOf(jo.getTime()) : null;
        Integer valueOf6 = jo != null ? Integer.valueOf((int) jo.getAccuracy()) : null;
        Integer valueOf7 = jo != null ? Integer.valueOf((int) jo.getBearing()) : null;
        Integer valueOf8 = jo != null ? Integer.valueOf((int) jo.getSpeed()) : null;
        F7 f7 = new F7(Boolean.valueOf(z), valueOf4, valueOf3, jo != null ? Integer.valueOf((int) jo.getAltitude()) : null, valueOf7, valueOf6, valueOf8, valueOf5, jo != null ? jo.getProvider() : null, jo != null ? jo.f520a : null);
        String str = this.h.c;
        C0264g0 c0264g0 = this.e;
        String str2 = c0264g0.f862a;
        Long valueOf9 = Long.valueOf(c0264g0.b);
        Integer valueOf10 = Integer.valueOf(this.h.g);
        Context context = this.f409a;
        Re re = We.f709a;
        Integer valueOf11 = Integer.valueOf(((Integer) We.c.a((Ve) SystemServiceUtils.accessSystemServiceSafelyOrDefault((ConnectivityManager) context.getSystemService("connectivity"), "getting connection type", "ConnectivityManager", Ve.UNDEFINED, new Ue()))).intValue());
        String b = b();
        EnumC0196d9 enumC0196d9 = this.d.b;
        C0399l6 c0399l6 = this.h;
        return new A7(valueOf, name, value, valueOf2, f7, str, str2, valueOf9, valueOf10, valueOf11, b, enumC0196d9, c0399l6.h, c0399l6.k, c0399l6.l, c0399l6.n, c0399l6.o, this.f.fromModel(c0399l6.p));
    }

    public /* synthetic */ E7(Context context, Zk zk, int i, C0477o9 c0477o9, U8 u8, Ch ch, C0264g0 c0264g0) {
        this(context, zk, i, c0477o9, u8, c0264g0, new C0221e9(), new H7(ch));
    }
}
