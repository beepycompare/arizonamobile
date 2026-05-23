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
public final class C0735y7 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1288a;
    public final int b;
    public final ap c;
    public final S8 d;
    public final C0365k0 e;
    public final C0194d9 f;
    public final B7 g;
    public final C0242f6 h;

    public C0735y7(Context context, C0749yl c0749yl, int i, ap apVar, S8 s8, C0365k0 c0365k0, C0194d9 c0194d9, B7 b7) {
        this.f1288a = context;
        this.b = i;
        this.c = apVar;
        this.d = s8;
        this.e = c0365k0;
        this.f = c0194d9;
        this.g = b7;
        this.h = s8.f760a;
    }

    public static String b() {
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        Pn C = Na.I.C();
        C0709x7 c0709x7 = new C0709x7(objectRef);
        synchronized (C) {
            C.b.a(c0709x7);
        }
        return (String) objectRef.element;
    }

    public final C0631u7 a() {
        long optLong;
        mp mpVar;
        Integer valueOf = Integer.valueOf(this.h.e);
        String name = this.h.getName();
        String value = this.h.getValue();
        ap apVar = this.c;
        int i = this.b;
        synchronized (apVar) {
            JSONObject a2 = apVar.f893a.a();
            JSONObject optJSONObject = a2.optJSONObject("numbers_of_type");
            if (optJSONObject == null) {
                optJSONObject = new JSONObject();
            }
            optLong = optJSONObject.optLong(String.valueOf(i));
            optJSONObject.put(String.valueOf(i), 1 + optLong);
            apVar.f893a.a(a2.put("numbers_of_type", optJSONObject));
        }
        Long valueOf2 = Long.valueOf(optLong);
        B7 b7 = this.g;
        b7.getClass();
        InterfaceC0429mc m = Na.I.m();
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
        boolean z = b7.f469a.d;
        Double valueOf3 = mpVar != null ? Double.valueOf(mpVar.getLatitude()) : null;
        Double valueOf4 = mpVar != null ? Double.valueOf(mpVar.getLongitude()) : null;
        Long valueOf5 = mpVar != null ? Long.valueOf(mpVar.getTime()) : null;
        Integer valueOf6 = mpVar != null ? Integer.valueOf((int) mpVar.getAccuracy()) : null;
        Integer valueOf7 = mpVar != null ? Integer.valueOf((int) mpVar.getBearing()) : null;
        Integer valueOf8 = mpVar != null ? Integer.valueOf((int) mpVar.getSpeed()) : null;
        C0761z7 c0761z7 = new C0761z7(Boolean.valueOf(z), valueOf4, valueOf3, mpVar != null ? Integer.valueOf((int) mpVar.getAltitude()) : null, valueOf7, valueOf6, valueOf8, valueOf5, mpVar != null ? mpVar.getProvider() : null, mpVar != null ? mpVar.f1101a : null);
        String str = this.h.c;
        C0365k0 c0365k0 = this.e;
        String str2 = c0365k0.f1058a;
        Long valueOf9 = Long.valueOf(c0365k0.b);
        Integer valueOf10 = Integer.valueOf(this.h.g);
        Context context = this.f1288a;
        C0200df c0200df = AbstractC0303hf.f1014a;
        Integer valueOf11 = Integer.valueOf(((Integer) AbstractC0303hf.c.a((NetworkType) SystemServiceUtils.accessSystemServiceSafelyOrDefault((ConnectivityManager) context.getSystemService("connectivity"), "getting connection type", "ConnectivityManager", NetworkType.UNDEFINED, new C0277gf()))).intValue());
        String b = b();
        EnumC0168c9 enumC0168c9 = this.d.b;
        C0242f6 c0242f6 = this.h;
        return new C0631u7(valueOf, name, value, valueOf2, c0761z7, str, str2, valueOf9, valueOf10, valueOf11, b, enumC0168c9, c0242f6.h, c0242f6.k, c0242f6.l, c0242f6.n, c0242f6.o, this.f.fromModel(c0242f6.p));
    }

    public /* synthetic */ C0735y7(Context context, C0749yl c0749yl, int i, ap apVar, S8 s8, Eh eh, C0365k0 c0365k0) {
        this(context, c0749yl, i, apVar, s8, c0365k0, new C0194d9(), new B7(eh));
    }
}
