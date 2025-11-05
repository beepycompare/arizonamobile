package io.appmetrica.analytics.impl;

import android.content.Context;
import android.location.Location;
import android.net.ConnectivityManager;
import io.appmetrica.analytics.coreapi.internal.system.NetworkType;
import io.appmetrica.analytics.coreutils.internal.system.SystemServiceUtils;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;
/* renamed from: io.appmetrica.analytics.impl.p7  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0493p7 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1052a;
    public final int b;
    public final Y8 c;
    public final E8 d;
    public final C0309i0 e;
    public final O8 f;
    public final C0567s7 g;
    public final W5 h;

    public C0493p7(Context context, Yk yk, int i, Y8 y8, E8 e8, C0309i0 c0309i0, O8 o8, C0567s7 c0567s7) {
        this.f1052a = context;
        this.b = i;
        this.c = y8;
        this.d = e8;
        this.e = c0309i0;
        this.f = o8;
        this.g = c0567s7;
        this.h = e8.f455a;
    }

    public static String b() {
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        C0534qn C = C0620ua.H.C();
        C0468o7 c0468o7 = new C0468o7(objectRef);
        synchronized (C) {
            C.b.a(c0468o7);
        }
        return (String) objectRef.element;
    }

    public final C0393l7 a() {
        JSONObject optJSONObject;
        Jo jo;
        Integer valueOf = Integer.valueOf(this.h.e);
        String name = this.h.getName();
        String value = this.h.getValue();
        Y8 y8 = this.c;
        int i = this.b;
        zo zoVar = y8.f768a.f782a;
        synchronized (zoVar) {
            optJSONObject = zoVar.f1238a.a().optJSONObject("numbers_of_type");
        }
        long optLong = optJSONObject != null ? optJSONObject.optLong(String.valueOf(i)) : 0L;
        y8.f768a.a(i, 1 + optLong);
        Long valueOf2 = Long.valueOf(optLong);
        C0567s7 c0567s7 = this.g;
        c0567s7.getClass();
        Rb m = C0620ua.H.m();
        Location userLocation = m.getUserLocation();
        if (userLocation != null) {
            int i2 = Jo.b;
            Location location = new Location(userLocation);
            String provider = location.getProvider();
            location.setProvider("");
            jo = new Jo(location, provider);
        } else {
            Location systemLocation = m.getSystemLocation();
            jo = systemLocation != null ? new Jo(new Location(systemLocation), "") : null;
        }
        boolean z = c0567s7.f1108a.d;
        Double valueOf3 = jo != null ? Double.valueOf(jo.getLatitude()) : null;
        Double valueOf4 = jo != null ? Double.valueOf(jo.getLongitude()) : null;
        Long valueOf5 = jo != null ? Long.valueOf(jo.getTime()) : null;
        Integer valueOf6 = jo != null ? Integer.valueOf((int) jo.getAccuracy()) : null;
        Integer valueOf7 = jo != null ? Integer.valueOf((int) jo.getBearing()) : null;
        Integer valueOf8 = jo != null ? Integer.valueOf((int) jo.getSpeed()) : null;
        C0518q7 c0518q7 = new C0518q7(Boolean.valueOf(z), valueOf4, valueOf3, jo != null ? Integer.valueOf((int) jo.getAltitude()) : null, valueOf7, valueOf6, valueOf8, valueOf5, jo != null ? jo.getProvider() : null, jo != null ? jo.f551a : null);
        String str = this.h.c;
        C0309i0 c0309i0 = this.e;
        String str2 = c0309i0.f920a;
        Long valueOf9 = Long.valueOf(c0309i0.b);
        Integer valueOf10 = Integer.valueOf(this.h.g);
        Context context = this.f1052a;
        He he = Le.f575a;
        Integer valueOf11 = Integer.valueOf(((Integer) Le.c.a((NetworkType) SystemServiceUtils.accessSystemServiceSafelyOrDefault((ConnectivityManager) context.getSystemService("connectivity"), "getting connection type", "ConnectivityManager", NetworkType.UNDEFINED, new Ke()))).intValue());
        String b = b();
        N8 n8 = this.d.b;
        W5 w5 = this.h;
        return new C0393l7(valueOf, name, value, valueOf2, c0518q7, str, str2, valueOf9, valueOf10, valueOf11, b, n8, w5.h, w5.k, w5.l, w5.n, w5.o, this.f.fromModel(w5.p));
    }

    public /* synthetic */ C0493p7(Context context, Yk yk, int i, Y8 y8, E8 e8, C0503ph c0503ph, C0309i0 c0309i0) {
        this(context, yk, i, y8, e8, c0309i0, new O8(), new C0567s7(c0503ph));
    }
}
