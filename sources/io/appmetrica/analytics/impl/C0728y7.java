package io.appmetrica.analytics.impl;

import android.content.Context;
import android.location.Location;
import android.net.ConnectivityManager;
import io.appmetrica.analytics.coreapi.internal.system.NetworkType;
import io.appmetrica.analytics.coreutils.internal.system.SystemServiceUtils;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;
/* renamed from: io.appmetrica.analytics.impl.y7  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0728y7 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1294a;
    public final int b;
    public final ap c;
    public final S8 d;
    public final C0358k0 e;
    public final C0187d9 f;
    public final B7 g;
    public final C0235f6 h;

    public C0728y7(Context context, C0742yl c0742yl, int i, ap apVar, S8 s8, C0358k0 c0358k0, C0187d9 c0187d9, B7 b7) {
        this.f1294a = context;
        this.b = i;
        this.c = apVar;
        this.d = s8;
        this.e = c0358k0;
        this.f = c0187d9;
        this.g = b7;
        this.h = s8.f766a;
    }

    public static String b() {
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        Pn C = Na.I.C();
        C0702x7 c0702x7 = new C0702x7(objectRef);
        synchronized (C) {
            C.b.a(c0702x7);
        }
        return (String) objectRef.element;
    }

    public final C0624u7 a() {
        long optLong;
        mp mpVar;
        Integer valueOf = Integer.valueOf(this.h.e);
        String name = this.h.getName();
        String value = this.h.getValue();
        ap apVar = this.c;
        int i = this.b;
        synchronized (apVar) {
            JSONObject a2 = apVar.f899a.a();
            JSONObject optJSONObject = a2.optJSONObject("numbers_of_type");
            if (optJSONObject == null) {
                optJSONObject = new JSONObject();
            }
            optLong = optJSONObject.optLong(String.valueOf(i));
            optJSONObject.put(String.valueOf(i), 1 + optLong);
            apVar.f899a.a(a2.put("numbers_of_type", optJSONObject));
        }
        Long valueOf2 = Long.valueOf(optLong);
        B7 b7 = this.g;
        b7.getClass();
        InterfaceC0422mc m = Na.I.m();
        Location userLocation = m.getUserLocation();
        if (userLocation != null) {
            int i2 = mp.b;
            Location location = new Location(userLocation);
            String provider = location.getProvider();
            location.setProvider("");
            mpVar = new mp(location, provider);
        } else {
            Location systemLocation = m.getSystemLocation();
            mpVar = systemLocation != null ? new mp(new Location(systemLocation), "") : null;
        }
        boolean z = b7.f475a.d;
        Double valueOf3 = mpVar != null ? Double.valueOf(mpVar.getLatitude()) : null;
        Double valueOf4 = mpVar != null ? Double.valueOf(mpVar.getLongitude()) : null;
        Long valueOf5 = mpVar != null ? Long.valueOf(mpVar.getTime()) : null;
        Integer valueOf6 = mpVar != null ? Integer.valueOf((int) mpVar.getAccuracy()) : null;
        Integer valueOf7 = mpVar != null ? Integer.valueOf((int) mpVar.getBearing()) : null;
        Integer valueOf8 = mpVar != null ? Integer.valueOf((int) mpVar.getSpeed()) : null;
        C0754z7 c0754z7 = new C0754z7(Boolean.valueOf(z), valueOf4, valueOf3, mpVar != null ? Integer.valueOf((int) mpVar.getAltitude()) : null, valueOf7, valueOf6, valueOf8, valueOf5, mpVar != null ? mpVar.getProvider() : null, mpVar != null ? mpVar.f1107a : null);
        String str = this.h.c;
        C0358k0 c0358k0 = this.e;
        String str2 = c0358k0.f1064a;
        Long valueOf9 = Long.valueOf(c0358k0.b);
        Integer valueOf10 = Integer.valueOf(this.h.g);
        Context context = this.f1294a;
        C0193df c0193df = AbstractC0296hf.f1020a;
        Integer valueOf11 = Integer.valueOf(((Integer) AbstractC0296hf.c.a((NetworkType) SystemServiceUtils.accessSystemServiceSafelyOrDefault((ConnectivityManager) context.getSystemService("connectivity"), "getting connection type", "ConnectivityManager", NetworkType.UNDEFINED, new C0270gf()))).intValue());
        String b = b();
        EnumC0161c9 enumC0161c9 = this.d.b;
        C0235f6 c0235f6 = this.h;
        return new C0624u7(valueOf, name, value, valueOf2, c0754z7, str, str2, valueOf9, valueOf10, valueOf11, b, enumC0161c9, c0235f6.h, c0235f6.k, c0235f6.l, c0235f6.n, c0235f6.o, this.f.fromModel(c0235f6.p));
    }

    public /* synthetic */ C0728y7(Context context, C0742yl c0742yl, int i, ap apVar, S8 s8, Eh eh, C0358k0 c0358k0) {
        this(context, c0742yl, i, apVar, s8, c0358k0, new C0187d9(), new B7(eh));
    }
}
