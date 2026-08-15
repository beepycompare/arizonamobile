package io.appmetrica.analytics.impl;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import android.util.Pair;
import io.appmetrica.analytics.coreapi.internal.event.CounterReportApi;
import io.appmetrica.analytics.coreapi.internal.permission.PermissionState;
import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* renamed from: io.appmetrica.analytics.impl.f6  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C0241f6 implements CounterReportApi, Parcelable {
    public static final Parcelable.Creator<C0241f6> CREATOR = new C0215e6();

    /* renamed from: a  reason: collision with root package name */
    protected String f977a;
    protected String b;
    public String c;
    public int d;
    public int e;
    public Pair f;
    public int g;
    public String h;
    public long i;
    public long j;
    public Aa k;
    public G9 l;
    public Bundle m;
    public Boolean n;
    public Integer o;
    public Map p;

    public C0241f6() {
        this("", 0);
    }

    public final void a(String str, String str2) {
        if (this.f == null) {
            this.f = new Pair(str, str2);
        }
    }

    public final Pair<String, String> b() {
        return this.f;
    }

    public final void c(Bundle bundle) {
        this.m = bundle;
    }

    public final long d() {
        return this.i;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final long e() {
        return this.j;
    }

    public final String f() {
        return this.c;
    }

    public final Aa g() {
        return this.k;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.event.CounterReportApi
    public final int getBytesTruncated() {
        return this.g;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.event.CounterReportApi
    public final int getCustomType() {
        return this.e;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.event.CounterReportApi
    public final Map<String, byte[]> getExtras() {
        return this.p;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.event.CounterReportApi
    public final String getName() {
        return this.f977a;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.event.CounterReportApi
    public final int getType() {
        return this.d;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.event.CounterReportApi
    public final String getValue() {
        return this.b;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.event.CounterReportApi
    public final byte[] getValueBytes() {
        String str = this.b;
        if (str == null) {
            return null;
        }
        return Base64.decode(str, 0);
    }

    public final Integer h() {
        return this.o;
    }

    public final Bundle i() {
        return this.m;
    }

    public final String j() {
        return this.h;
    }

    public final G9 k() {
        return this.l;
    }

    public final boolean l() {
        return this.f977a == null;
    }

    public final boolean m() {
        Db db = Db.EVENT_TYPE_UNDEFINED;
        return -1 == this.d;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.event.CounterReportApi
    public final void setBytesTruncated(int i) {
        this.g = i;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.event.CounterReportApi
    public final void setCustomType(int i) {
        this.e = i;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.event.CounterReportApi
    public final void setExtras(Map<String, byte[]> map) {
        this.p = map;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.event.CounterReportApi
    public void setName(String str) {
        this.f977a = str;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.event.CounterReportApi
    public final void setType(int i) {
        this.d = i;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.event.CounterReportApi
    public void setValue(String str) {
        this.b = str;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.event.CounterReportApi
    public void setValueBytes(byte[] bArr) {
        this.b = bArr == null ? null : new String(Base64.encode(bArr, 0));
    }

    public final String toString() {
        Locale locale = Locale.US;
        String str = this.f977a;
        String str2 = Db.a(this.d).b;
        String str3 = this.b;
        if (str3 == null) {
            str3 = null;
        } else if (str3.length() > 500) {
            str3 = str3.substring(0, 500);
        }
        return String.format(locale, "[event: %s, type: %s, value: %s]", str, str2, str3);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        Bundle bundle = new Bundle();
        bundle.putString("CounterReport.Event", this.f977a);
        bundle.putString("CounterReport.Value", this.b);
        bundle.putInt("CounterReport.Type", this.d);
        bundle.putInt("CounterReport.CustomType", this.e);
        bundle.putInt("CounterReport.TRUNCATED", this.g);
        bundle.putString("CounterReport.ProfileID", this.h);
        bundle.putInt("CounterReport.UniquenessStatus", this.k.f458a);
        Bundle bundle2 = this.m;
        if (bundle2 != null) {
            bundle.putParcelable("CounterReport.Payload", bundle2);
        }
        String str = this.c;
        if (str != null) {
            bundle.putString("CounterReport.Environment", str);
        }
        Pair pair = this.f;
        if (pair != null) {
            bundle.putString("CounterReport.AppEnvironmentDiffKey", (String) pair.first);
            bundle.putString("CounterReport.AppEnvironmentDiffValue", (String) pair.second);
        }
        bundle.putLong("CounterReport.CreationElapsedRealtime", this.i);
        bundle.putLong("CounterReport.CreationTimestamp", this.j);
        G9 g9 = this.l;
        if (g9 != null) {
            bundle.putInt("CounterReport.Source", g9.f564a);
        }
        Boolean bool = this.n;
        if (bool != null) {
            bundle.putBoolean("CounterReport.AttributionIdChanged", bool.booleanValue());
        }
        Integer num = this.o;
        if (num != null) {
            bundle.putInt("CounterReport.OpenId", num.intValue());
        }
        bundle.putBundle("CounterReport.Extras", CollectionUtils.mapToBundle(this.p));
        parcel.writeBundle(bundle);
    }

    public C0241f6(String str, int i) {
        this("", str, i);
    }

    public static C0241f6 e(C0241f6 c0241f6) {
        return a(c0241f6, Db.EVENT_TYPE_APP_UPDATE);
    }

    public final void b(String str) {
        this.c = str;
    }

    public void c(String str) {
        this.h = str;
    }

    public final Bundle d(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putParcelable("CounterReport.Object", this);
        return bundle;
    }

    public C0241f6(String str, String str2, int i) {
        this.k = Aa.UNKNOWN;
        this.p = new HashMap();
        SystemTimeProvider systemTimeProvider = new SystemTimeProvider();
        this.f977a = str2;
        this.d = i;
        this.b = str;
        this.i = systemTimeProvider.elapsedRealtime();
        this.j = systemTimeProvider.currentTimeMillis();
    }

    public final void a(long j) {
        this.i = j;
    }

    public final void b(long j) {
        this.j = j;
    }

    public final Boolean c() {
        return this.n;
    }

    public static C0241f6 b(Bundle bundle) {
        if (bundle != null) {
            try {
                C0241f6 c0241f6 = (C0241f6) bundle.getParcelable("CounterReport.Object");
                if (c0241f6 != null) {
                    return c0241f6;
                }
            } catch (Throwable unused) {
                return new C0241f6("", 0);
            }
        }
        return new C0241f6("", 0);
    }

    public static C0241f6 c(C0241f6 c0241f6) {
        return a(c0241f6, Db.EVENT_TYPE_INIT);
    }

    public static C0241f6 d(C0241f6 c0241f6) {
        C0241f6 c0241f62 = new C0241f6("", 0);
        c0241f62.j = c0241f6.j;
        c0241f62.i = c0241f6.i;
        c0241f62.f = c0241f6.f;
        c0241f62.c = c0241f6.c;
        c0241f62.m = c0241f6.m;
        c0241f62.p = c0241f6.p;
        c0241f62.h = c0241f6.h;
        return c0241f62;
    }

    public final void a(Aa aa) {
        this.k = aa;
    }

    public final void a(G9 g9) {
        this.l = g9;
    }

    public final void a(Boolean bool) {
        this.n = bool;
    }

    public final void a(Integer num) {
        this.o = num;
    }

    public static Pair a(Bundle bundle) {
        if (bundle.containsKey("CounterReport.AppEnvironmentDiffKey") && bundle.containsKey("CounterReport.AppEnvironmentDiffValue")) {
            return new Pair(bundle.getString("CounterReport.AppEnvironmentDiffKey"), bundle.getString("CounterReport.AppEnvironmentDiffValue"));
        }
        return null;
    }

    public static C0241f6 a(C0241f6 c0241f6, Db db) {
        C0241f6 d = d(c0241f6);
        d.d = db.f513a;
        return d;
    }

    public static C0241f6 b(C0241f6 c0241f6) {
        return a(c0241f6, Db.EVENT_TYPE_FIRST_ACTIVATION);
    }

    public static C0241f6 a(C0241f6 c0241f6) {
        return a(c0241f6, Db.EVENT_TYPE_ALIVE);
    }

    public static C0241f6 a(C0241f6 c0241f6, C0297ha c0297ha) {
        C0241f6 a2 = a(c0241f6, Db.EVENT_TYPE_START);
        a2.setValueBytes(MessageNano.toByteArray(new J9().fromModel(new I9((String) c0297ha.b.a()))));
        a2.j = c0241f6.j;
        a2.i = c0241f6.i;
        return a2;
    }

    public static C0241f6 a(C0241f6 c0241f6, Collection<PermissionState> collection, K2 k2, C0496p2 c0496p2, List<String> list) {
        String str;
        String str2;
        C0241f6 d = d(c0241f6);
        try {
            JSONArray jSONArray = new JSONArray();
            for (PermissionState permissionState : collection) {
                jSONArray.put(new JSONObject().put("name", permissionState.name).put("granted", permissionState.granted));
            }
            JSONObject jSONObject = new JSONObject();
            if (k2 != null) {
                jSONObject.put("background_restricted", k2.b);
                J2 j2 = k2.f625a;
                c0496p2.getClass();
                if (j2 != null) {
                    int ordinal = j2.ordinal();
                    if (ordinal == 0) {
                        str2 = "EXEMPTED";
                    } else if (ordinal == 1) {
                        str2 = "ACTIVE";
                    } else if (ordinal == 2) {
                        str2 = "WORKING_SET";
                    } else if (ordinal == 3) {
                        str2 = "FREQUENT";
                    } else if (ordinal == 4) {
                        str2 = "RARE";
                    } else if (ordinal == 5) {
                        str2 = "RESTRICTED";
                    }
                    jSONObject.put("app_standby_bucket", str2);
                }
                str2 = null;
                jSONObject.put("app_standby_bucket", str2);
            }
            str = new JSONObject().put("permissions", jSONArray).put("background_restrictions", jSONObject).put("available_providers", new JSONArray((Collection) list)).toString();
        } catch (Throwable unused) {
            str = "";
        }
        Db db = Db.EVENT_TYPE_UNDEFINED;
        d.d = 12288;
        d.setValue(str);
        return d;
    }

    public C0241f6(String str, String str2, int i, long j) {
        this(str, str2, i);
        b(j);
    }

    public static C0241f6 a(C0241f6 c0241f6, String str) {
        C0241f6 d = d(c0241f6);
        Db db = Db.EVENT_TYPE_UNDEFINED;
        d.d = 12289;
        d.setValue(str);
        return d;
    }

    public static C0241f6 a() {
        C0241f6 c0241f6 = new C0241f6("", 0);
        Db db = Db.EVENT_TYPE_UNDEFINED;
        c0241f6.d = 16384;
        return c0241f6;
    }

    public static C0241f6 a(String str) {
        C0241f6 c0241f6 = new C0241f6("", 0);
        Db db = Db.EVENT_TYPE_UNDEFINED;
        c0241f6.d = 12320;
        c0241f6.b = str;
        c0241f6.l = G9.JS;
        return c0241f6;
    }
}
