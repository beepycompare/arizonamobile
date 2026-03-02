package io.appmetrica.analytics.impl;

import android.content.Context;
import android.location.Location;
import android.net.ConnectivityManager;
import io.appmetrica.analytics.coreapi.internal.system.NetworkType;
import io.appmetrica.analytics.coreutils.internal.system.SystemServiceUtils;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;
/* renamed from: io.appmetrica.analytics.impl.h7  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0293h7 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1024a;
    public final int b;
    public final xo c;
    public final C0745z8 d;
    public final C0312i0 e;
    public final J8 f;
    public final C0370k7 g;
    public final P5 h;

    public C0293h7(Context context, Tk tk, int i, xo xoVar, C0745z8 c0745z8, C0312i0 c0312i0, J8 j8, C0370k7 c0370k7) {
        this.f1024a = context;
        this.b = i;
        this.c = xoVar;
        this.d = c0745z8;
        this.e = c0312i0;
        this.f = j8;
        this.g = c0370k7;
        this.h = c0745z8.f1329a;
    }

    public static String b() {
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        C0486on C = C0448na.I.C();
        C0267g7 c0267g7 = new C0267g7(objectRef);
        synchronized (C) {
            C.b.a(c0267g7);
        }
        return (String) objectRef.element;
    }

    public final C0190d7 a() {
        long optLong;
        Io io2;
        Integer valueOf = Integer.valueOf(this.h.e);
        String name = this.h.getName();
        String value = this.h.getValue();
        xo xoVar = this.c;
        int i = this.b;
        synchronized (xoVar) {
            JSONObject a2 = xoVar.f1312a.a();
            JSONObject optJSONObject = a2.optJSONObject("numbers_of_type");
            if (optJSONObject == null) {
                optJSONObject = new JSONObject();
            }
            optLong = optJSONObject.optLong(String.valueOf(i));
            optJSONObject.put(String.valueOf(i), 1 + optLong);
            xoVar.f1312a.a(a2.put("numbers_of_type", optJSONObject));
        }
        Long valueOf2 = Long.valueOf(optLong);
        C0370k7 c0370k7 = this.g;
        c0370k7.getClass();
        Kb m = C0448na.I.m();
        Location userLocation = m.getUserLocation();
        if (userLocation != null) {
            int i2 = Io.b;
            Location location = new Location(userLocation);
            String provider = location.getProvider();
            location.setProvider("");
            io2 = new Io(location, provider);
        } else {
            Location systemLocation = m.getSystemLocation();
            io2 = systemLocation != null ? new Io(new Location(systemLocation), "") : null;
        }
        boolean z = c0370k7.f1077a.d;
        Double valueOf3 = io2 != null ? Double.valueOf(io2.getLatitude()) : null;
        Double valueOf4 = io2 != null ? Double.valueOf(io2.getLongitude()) : null;
        Long valueOf5 = io2 != null ? Long.valueOf(io2.getTime()) : null;
        Integer valueOf6 = io2 != null ? Integer.valueOf((int) io2.getAccuracy()) : null;
        Integer valueOf7 = io2 != null ? Integer.valueOf((int) io2.getBearing()) : null;
        Integer valueOf8 = io2 != null ? Integer.valueOf((int) io2.getSpeed()) : null;
        C0319i7 c0319i7 = new C0319i7(Boolean.valueOf(z), valueOf4, valueOf3, io2 != null ? Integer.valueOf((int) io2.getAltitude()) : null, valueOf7, valueOf6, valueOf8, valueOf5, io2 != null ? io2.getProvider() : null, io2 != null ? io2.f633a : null);
        String str = this.h.c;
        C0312i0 c0312i0 = this.e;
        String str2 = c0312i0.f1035a;
        Long valueOf9 = Long.valueOf(c0312i0.b);
        Integer valueOf10 = Integer.valueOf(this.h.g);
        Context context = this.f1024a;
        Ce ce = Ge.f596a;
        Integer valueOf11 = Integer.valueOf(((Integer) Ge.c.a((NetworkType) SystemServiceUtils.accessSystemServiceSafelyOrDefault((ConnectivityManager) context.getSystemService("connectivity"), "getting connection type", "ConnectivityManager", NetworkType.UNDEFINED, new Fe()))).intValue());
        String b = b();
        I8 i8 = this.d.b;
        P5 p5 = this.h;
        return new C0190d7(valueOf, name, value, valueOf2, c0319i7, str, str2, valueOf9, valueOf10, valueOf11, b, i8, p5.h, p5.k, p5.l, p5.n, p5.o, this.f.fromModel(p5.p));
    }

    public /* synthetic */ C0293h7(Context context, Tk tk, int i, xo xoVar, C0745z8 c0745z8, C0380kh c0380kh, C0312i0 c0312i0) {
        this(context, tk, i, xoVar, c0745z8, c0312i0, new J8(), new C0370k7(c0380kh));
    }
}
