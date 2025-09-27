package io.appmetrica.analytics.impl;

import android.content.Context;
import android.location.Location;
import android.net.ConnectivityManager;
import io.appmetrica.analytics.coreutils.internal.system.SystemServiceUtils;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class H7 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f474a;
    public final int b;
    public final C0555r9 c;
    public final X8 d;
    public final C0290h0 e;
    public final C0299h9 f;
    public final K7 g;
    public final C0477o6 h;

    public H7(Context context, C0208dl c0208dl, int i, C0555r9 c0555r9, X8 x8, C0290h0 c0290h0, C0299h9 c0299h9, K7 k7) {
        this.f474a = context;
        this.b = i;
        this.c = c0555r9;
        this.d = x8;
        this.e = c0290h0;
        this.f = c0299h9;
        this.g = k7;
        this.h = x8.f739a;
    }

    public static String b() {
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        C0644un A = Na.F.A();
        G7 g7 = new G7(objectRef);
        synchronized (A) {
            A.b.a(g7);
        }
        return (String) objectRef.element;
    }

    public final D7 a() {
        JSONObject optJSONObject;
        No no;
        Integer valueOf = Integer.valueOf(this.h.e);
        String name = this.h.getName();
        String value = this.h.getValue();
        C0555r9 c0555r9 = this.c;
        int i = this.b;
        Do r7 = c0555r9.f1064a.f1080a;
        synchronized (r7) {
            optJSONObject = r7.f418a.a().optJSONObject("numbers_of_type");
        }
        long optLong = optJSONObject != null ? optJSONObject.optLong(String.valueOf(i)) : 0L;
        c0555r9.f1064a.a(i, 1 + optLong);
        Long valueOf2 = Long.valueOf(optLong);
        K7 k7 = this.g;
        k7.getClass();
        InterfaceC0379kc l = Na.F.l();
        Location userLocation = l.getUserLocation();
        if (userLocation != null) {
            int i2 = No.b;
            Location location = new Location(userLocation);
            String provider = location.getProvider();
            location.setProvider("");
            no = new No(location, provider);
        } else {
            Location systemLocation = l.getSystemLocation();
            no = systemLocation != null ? new No(new Location(systemLocation), "") : null;
        }
        boolean z = k7.f535a.d;
        Double valueOf3 = no != null ? Double.valueOf(no.getLatitude()) : null;
        Double valueOf4 = no != null ? Double.valueOf(no.getLongitude()) : null;
        Long valueOf5 = no != null ? Long.valueOf(no.getTime()) : null;
        Integer valueOf6 = no != null ? Integer.valueOf((int) no.getAccuracy()) : null;
        Integer valueOf7 = no != null ? Integer.valueOf((int) no.getBearing()) : null;
        Integer valueOf8 = no != null ? Integer.valueOf((int) no.getSpeed()) : null;
        I7 i7 = new I7(Boolean.valueOf(z), valueOf4, valueOf3, no != null ? Integer.valueOf((int) no.getAltitude()) : null, valueOf7, valueOf6, valueOf8, valueOf5, no != null ? no.getProvider() : null, no != null ? no.f601a : null);
        String str = this.h.c;
        C0290h0 c0290h0 = this.e;
        String str2 = c0290h0.f903a;
        Long valueOf9 = Long.valueOf(c0290h0.b);
        Integer valueOf10 = Integer.valueOf(this.h.g);
        Context context = this.f474a;
        Ve ve = AbstractC0124af.f794a;
        Integer valueOf11 = Integer.valueOf(((Integer) AbstractC0124af.c.a((Ze) SystemServiceUtils.accessSystemServiceSafelyOrDefault((ConnectivityManager) context.getSystemService("connectivity"), "getting connection type", "ConnectivityManager", Ze.UNDEFINED, new Ye()))).intValue());
        String b = b();
        EnumC0273g9 enumC0273g9 = this.d.b;
        C0477o6 c0477o6 = this.h;
        return new D7(valueOf, name, value, valueOf2, i7, str, str2, valueOf9, valueOf10, valueOf11, b, enumC0273g9, c0477o6.h, c0477o6.k, c0477o6.l, c0477o6.n, c0477o6.o, this.f.fromModel(c0477o6.p));
    }

    public /* synthetic */ H7(Context context, C0208dl c0208dl, int i, C0555r9 c0555r9, X8 x8, Gh gh, C0290h0 c0290h0) {
        this(context, c0208dl, i, c0555r9, x8, c0290h0, new C0299h9(), new K7(gh));
    }
}
