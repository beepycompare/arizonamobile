package io.appmetrica.analytics.impl;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import android.util.Pair;
import com.google.firebase.messaging.ServiceStarter;
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
/* loaded from: classes5.dex */
public class Q5 implements CounterReportApi, Parcelable {
    public static final Parcelable.Creator<Q5> CREATOR = new P5();

    /* renamed from: a  reason: collision with root package name */
    protected String f745a;
    protected String b;
    public String c;
    public int d;
    public int e;
    public Pair f;
    public int g;
    public String h;
    public long i;
    public long j;
    public EnumC0214ea k;
    public EnumC0444n9 l;
    public Bundle m;
    public Boolean n;
    public Integer o;
    public Map p;

    public Q5() {
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

    public final EnumC0214ea g() {
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
        return this.f745a;
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

    public final EnumC0444n9 k() {
        return this.l;
    }

    public final boolean l() {
        return this.f745a == null;
    }

    public final boolean m() {
        EnumC0164cb enumC0164cb = EnumC0164cb.EVENT_TYPE_UNDEFINED;
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
        this.f745a = str;
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
        String str = this.f745a;
        String str2 = EnumC0164cb.a(this.d).b;
        String str3 = this.b;
        if (str3 == null) {
            str3 = null;
        } else if (str3.length() > 500) {
            str3 = str3.substring(0, ServiceStarter.ERROR_UNKNOWN);
        }
        return String.format(locale, "[event: %s, type: %s, value: %s]", str, str2, str3);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        Bundle bundle = new Bundle();
        bundle.putString("CounterReport.Event", this.f745a);
        bundle.putString("CounterReport.Value", this.b);
        bundle.putInt("CounterReport.Type", this.d);
        bundle.putInt("CounterReport.CustomType", this.e);
        bundle.putInt("CounterReport.TRUNCATED", this.g);
        bundle.putString("CounterReport.ProfileID", this.h);
        bundle.putInt("CounterReport.UniquenessStatus", this.k.f966a);
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
        EnumC0444n9 enumC0444n9 = this.l;
        if (enumC0444n9 != null) {
            bundle.putInt("CounterReport.Source", enumC0444n9.f1124a);
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

    public Q5(String str, int i) {
        this("", str, i);
    }

    public static Q5 e(Q5 q5) {
        return a(q5, EnumC0164cb.EVENT_TYPE_APP_UPDATE);
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

    public Q5(String str, String str2, int i) {
        this(str, str2, i, new SystemTimeProvider());
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

    public Q5(String str, String str2, int i, SystemTimeProvider systemTimeProvider) {
        this.k = EnumC0214ea.UNKNOWN;
        this.p = new HashMap();
        this.f745a = str2;
        this.d = i;
        this.b = str;
        this.i = systemTimeProvider.elapsedRealtime();
        this.j = systemTimeProvider.currentTimeMillis();
    }

    public static Q5 b(Bundle bundle) {
        if (bundle != null) {
            try {
                Q5 q5 = (Q5) bundle.getParcelable("CounterReport.Object");
                if (q5 != null) {
                    return q5;
                }
            } catch (Throwable unused) {
                return new Q5("", 0);
            }
        }
        return new Q5("", 0);
    }

    public static Q5 c(Q5 q5) {
        return a(q5, EnumC0164cb.EVENT_TYPE_INIT);
    }

    public static Q5 d(Q5 q5) {
        Q5 q52 = new Q5("", 0);
        q52.j = q5.j;
        q52.i = q5.i;
        q52.f = q5.f;
        q52.c = q5.c;
        q52.m = q5.m;
        q52.p = q5.p;
        q52.h = q5.h;
        return q52;
    }

    public final void a(EnumC0214ea enumC0214ea) {
        this.k = enumC0214ea;
    }

    public final void a(EnumC0444n9 enumC0444n9) {
        this.l = enumC0444n9;
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

    public static Q5 a(Q5 q5, EnumC0164cb enumC0164cb) {
        Q5 d = d(q5);
        d.d = enumC0164cb.f926a;
        return d;
    }

    public static Q5 b(Q5 q5) {
        return a(q5, EnumC0164cb.EVENT_TYPE_FIRST_ACTIVATION);
    }

    public static Q5 a(Q5 q5) {
        return a(q5, EnumC0164cb.EVENT_TYPE_ALIVE);
    }

    public static Q5 a(Q5 q5, N9 n9) {
        Q5 a2 = a(q5, EnumC0164cb.EVENT_TYPE_START);
        a2.setValueBytes(MessageNano.toByteArray(new C0519q9().fromModel(new C0494p9((String) n9.b.a()))));
        a2.j = q5.j;
        a2.i = q5.i;
        return a2;
    }

    public static Q5 a(Q5 q5, Collection<PermissionState> collection, C0711y2 c0711y2, C0181d2 c0181d2, List<String> list) {
        String str;
        String str2;
        Q5 d = d(q5);
        try {
            JSONArray jSONArray = new JSONArray();
            for (PermissionState permissionState : collection) {
                jSONArray.put(new JSONObject().put("name", permissionState.name).put("granted", permissionState.granted));
            }
            JSONObject jSONObject = new JSONObject();
            if (c0711y2 != null) {
                jSONObject.put("background_restricted", c0711y2.b);
                EnumC0686x2 enumC0686x2 = c0711y2.f1306a;
                c0181d2.getClass();
                if (enumC0686x2 != null) {
                    int ordinal = enumC0686x2.ordinal();
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
        EnumC0164cb enumC0164cb = EnumC0164cb.EVENT_TYPE_UNDEFINED;
        d.d = 12288;
        d.setValue(str);
        return d;
    }

    public static Q5 a(Q5 q5, String str) {
        Q5 d = d(q5);
        EnumC0164cb enumC0164cb = EnumC0164cb.EVENT_TYPE_UNDEFINED;
        d.d = 12289;
        d.setValue(str);
        return d;
    }

    public static Q5 a() {
        Q5 q5 = new Q5("", 0);
        EnumC0164cb enumC0164cb = EnumC0164cb.EVENT_TYPE_UNDEFINED;
        q5.d = 16384;
        return q5;
    }

    public static Q5 a(String str) {
        Q5 q5 = new Q5("", 0);
        EnumC0164cb enumC0164cb = EnumC0164cb.EVENT_TYPE_UNDEFINED;
        q5.d = 12320;
        q5.b = str;
        q5.l = EnumC0444n9.JS;
        return q5;
    }
}
