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
public final class C0294h7 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1025a;
    public final int b;
    public final xo c;
    public final C0746z8 d;
    public final C0313i0 e;
    public final J8 f;
    public final C0371k7 g;
    public final P5 h;

    public C0294h7(Context context, Tk tk, int i, xo xoVar, C0746z8 c0746z8, C0313i0 c0313i0, J8 j8, C0371k7 c0371k7) {
        this.f1025a = context;
        this.b = i;
        this.c = xoVar;
        this.d = c0746z8;
        this.e = c0313i0;
        this.f = j8;
        this.g = c0371k7;
        this.h = c0746z8.f1330a;
    }

    public static String b() {
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        C0487on C = C0449na.I.C();
        C0268g7 c0268g7 = new C0268g7(objectRef);
        synchronized (C) {
            C.b.a(c0268g7);
        }
        return (String) objectRef.element;
    }

    public final C0191d7 a() {
        long optLong;
        Io io2;
        Integer valueOf = Integer.valueOf(this.h.e);
        String name = this.h.getName();
        String value = this.h.getValue();
        xo xoVar = this.c;
        int i = this.b;
        synchronized (xoVar) {
            JSONObject a2 = xoVar.f1313a.a();
            JSONObject optJSONObject = a2.optJSONObject("numbers_of_type");
            if (optJSONObject == null) {
                optJSONObject = new JSONObject();
            }
            optLong = optJSONObject.optLong(String.valueOf(i));
            optJSONObject.put(String.valueOf(i), 1 + optLong);
            xoVar.f1313a.a(a2.put("numbers_of_type", optJSONObject));
        }
        Long valueOf2 = Long.valueOf(optLong);
        C0371k7 c0371k7 = this.g;
        c0371k7.getClass();
        Kb m = C0449na.I.m();
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
        boolean z = c0371k7.f1078a.d;
        Double valueOf3 = io2 != null ? Double.valueOf(io2.getLatitude()) : null;
        Double valueOf4 = io2 != null ? Double.valueOf(io2.getLongitude()) : null;
        Long valueOf5 = io2 != null ? Long.valueOf(io2.getTime()) : null;
        Integer valueOf6 = io2 != null ? Integer.valueOf((int) io2.getAccuracy()) : null;
        Integer valueOf7 = io2 != null ? Integer.valueOf((int) io2.getBearing()) : null;
        Integer valueOf8 = io2 != null ? Integer.valueOf((int) io2.getSpeed()) : null;
        C0320i7 c0320i7 = new C0320i7(Boolean.valueOf(z), valueOf4, valueOf3, io2 != null ? Integer.valueOf((int) io2.getAltitude()) : null, valueOf7, valueOf6, valueOf8, valueOf5, io2 != null ? io2.getProvider() : null, io2 != null ? io2.f634a : null);
        String str = this.h.c;
        C0313i0 c0313i0 = this.e;
        String str2 = c0313i0.f1036a;
        Long valueOf9 = Long.valueOf(c0313i0.b);
        Integer valueOf10 = Integer.valueOf(this.h.g);
        Context context = this.f1025a;
        Ce ce = Ge.f597a;
        Integer valueOf11 = Integer.valueOf(((Integer) Ge.c.a((NetworkType) SystemServiceUtils.accessSystemServiceSafelyOrDefault((ConnectivityManager) context.getSystemService("connectivity"), "getting connection type", "ConnectivityManager", NetworkType.UNDEFINED, new Fe()))).intValue());
        String b = b();
        I8 i8 = this.d.b;
        P5 p5 = this.h;
        return new C0191d7(valueOf, name, value, valueOf2, c0320i7, str, str2, valueOf9, valueOf10, valueOf11, b, i8, p5.h, p5.k, p5.l, p5.n, p5.o, this.f.fromModel(p5.p));
    }

    public /* synthetic */ C0294h7(Context context, Tk tk, int i, xo xoVar, C0746z8 c0746z8, C0381kh c0381kh, C0313i0 c0313i0) {
        this(context, tk, i, xoVar, c0746z8, c0313i0, new J8(), new C0371k7(c0381kh));
    }
}
