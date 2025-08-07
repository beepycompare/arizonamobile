package io.appmetrica.analytics.impl;

import android.content.Context;
import android.location.Location;
import android.net.ConnectivityManager;
import io.appmetrica.analytics.coreutils.internal.services.SafePackageManager;
import io.appmetrica.analytics.coreutils.internal.system.SystemServiceUtils;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class D7 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f391a;
    public final int b;
    public final C0430m9 c;
    public final S8 d;
    public final C0272g0 e;
    public final C0178c9 f;
    public final G7 g;
    public final C0402l6 h;

    public D7(Context context, Uk uk, int i, C0430m9 c0430m9, S8 s8, C0272g0 c0272g0, C0178c9 c0178c9, G7 g7) {
        this.f391a = context;
        this.b = i;
        this.c = c0430m9;
        this.d = s8;
        this.e = c0272g0;
        this.f = c0178c9;
        this.g = g7;
        this.h = s8.f636a;
    }

    public static String b() {
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        C0419ln A = Ia.F.A();
        C7 c7 = new C7(objectRef);
        synchronized (A) {
            A.b.a(c7);
        }
        return (String) objectRef.element;
    }

    public final C0752z7 a() {
        JSONObject optJSONObject;
        Eo eo;
        Integer valueOf = Integer.valueOf(this.h.e);
        String name = this.h.getName();
        String value = this.h.getValue();
        C0430m9 c0430m9 = this.c;
        int i = this.b;
        uo uoVar = c0430m9.f950a.f966a;
        synchronized (uoVar) {
            optJSONObject = uoVar.f1091a.a().optJSONObject("numbers_of_type");
        }
        long optLong = optJSONObject != null ? optJSONObject.optLong(String.valueOf(i)) : 0L;
        c0430m9.f950a.a(i, 1 + optLong);
        Long valueOf2 = Long.valueOf(optLong);
        G7 g7 = this.g;
        g7.getClass();
        InterfaceC0258fc l = Ia.F.l();
        Location userLocation = l.getUserLocation();
        if (userLocation != null) {
            int i2 = Eo.b;
            Location location = new Location(userLocation);
            String provider = location.getProvider();
            location.setProvider("");
            eo = new Eo(location, provider);
        } else {
            Location systemLocation = l.getSystemLocation();
            eo = systemLocation != null ? new Eo(new Location(systemLocation), "") : null;
        }
        boolean z = g7.f449a.d;
        Double valueOf3 = eo != null ? Double.valueOf(eo.getLatitude()) : null;
        Double valueOf4 = eo != null ? Double.valueOf(eo.getLongitude()) : null;
        Long valueOf5 = eo != null ? Long.valueOf(eo.getTime()) : null;
        Integer valueOf6 = eo != null ? Integer.valueOf((int) eo.getAccuracy()) : null;
        Integer valueOf7 = eo != null ? Integer.valueOf((int) eo.getBearing()) : null;
        Integer valueOf8 = eo != null ? Integer.valueOf((int) eo.getSpeed()) : null;
        E7 e7 = new E7(Boolean.valueOf(z), valueOf4, valueOf3, eo != null ? Integer.valueOf((int) eo.getAltitude()) : null, valueOf7, valueOf6, valueOf8, valueOf5, eo != null ? eo.getProvider() : null, eo != null ? eo.f423a : null);
        String str = this.h.c;
        C0272g0 c0272g0 = this.e;
        String str2 = c0272g0.f855a;
        Long valueOf9 = Long.valueOf(c0272g0.b);
        Integer valueOf10 = Integer.valueOf(this.h.g);
        Context context = this.f391a;
        SafePackageManager safePackageManager = Ue.f670a;
        Integer valueOf11 = Integer.valueOf(((Integer) Ue.d.a((Te) SystemServiceUtils.accessSystemServiceSafelyOrDefault((ConnectivityManager) context.getSystemService("connectivity"), "getting connection type", "ConnectivityManager", Te.UNDEFINED, new Se()))).intValue());
        String b = b();
        EnumC0152b9 enumC0152b9 = this.d.b;
        C0402l6 c0402l6 = this.h;
        return new C0752z7(valueOf, name, value, valueOf2, e7, str, str2, valueOf9, valueOf10, valueOf11, b, enumC0152b9, c0402l6.h, c0402l6.k, c0402l6.l, c0402l6.n, c0402l6.o, this.f.fromModel(c0402l6.p));
    }

    public /* synthetic */ D7(Context context, Uk uk, int i, C0430m9 c0430m9, S8 s8, C0712xh c0712xh, C0272g0 c0272g0) {
        this(context, uk, i, c0430m9, s8, c0272g0, new C0178c9(), new G7(c0712xh));
    }
}
