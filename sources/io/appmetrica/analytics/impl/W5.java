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
/* loaded from: classes3.dex */
public class W5 implements CounterReportApi, Parcelable {
    public static final Parcelable.Creator<W5> CREATOR = new V5();

    /* renamed from: a  reason: collision with root package name */
    protected String f741a;
    protected String b;
    public String c;
    public int d;
    public int e;
    public Pair f;
    public int g;
    public String h;
    public long i;
    public long j;
    public EnumC0370ka k;
    public EnumC0594t9 l;
    public Bundle m;
    public Boolean n;
    public Integer o;
    public Map p;

    public W5() {
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

    public final EnumC0370ka g() {
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
        return this.f741a;
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

    public final EnumC0594t9 k() {
        return this.l;
    }

    public final boolean l() {
        return this.f741a == null;
    }

    public final boolean m() {
        EnumC0320ib enumC0320ib = EnumC0320ib.EVENT_TYPE_UNDEFINED;
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
        this.f741a = str;
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
        String str = this.f741a;
        String str2 = EnumC0320ib.a(this.d).b;
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
        bundle.putString("CounterReport.Event", this.f741a);
        bundle.putString("CounterReport.Value", this.b);
        bundle.putInt("CounterReport.Type", this.d);
        bundle.putInt("CounterReport.CustomType", this.e);
        bundle.putInt("CounterReport.TRUNCATED", this.g);
        bundle.putString("CounterReport.ProfileID", this.h);
        bundle.putInt("CounterReport.UniquenessStatus", this.k.f971a);
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
        EnumC0594t9 enumC0594t9 = this.l;
        if (enumC0594t9 != null) {
            bundle.putInt("CounterReport.Source", enumC0594t9.f1130a);
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

    public W5(String str, int i) {
        this("", str, i);
    }

    public static W5 e(W5 w5) {
        return a(w5, EnumC0320ib.EVENT_TYPE_APP_UPDATE);
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

    public W5(String str, String str2, int i) {
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

    public W5(String str, String str2, int i, SystemTimeProvider systemTimeProvider) {
        this.k = EnumC0370ka.UNKNOWN;
        this.p = new HashMap();
        this.f741a = str2;
        this.d = i;
        this.b = str;
        this.i = systemTimeProvider.elapsedRealtime();
        this.j = systemTimeProvider.currentTimeMillis();
    }

    public static W5 b(Bundle bundle) {
        if (bundle != null) {
            try {
                W5 w5 = (W5) bundle.getParcelable("CounterReport.Object");
                if (w5 != null) {
                    return w5;
                }
            } catch (Throwable unused) {
                return new W5("", 0);
            }
        }
        return new W5("", 0);
    }

    public static W5 c(W5 w5) {
        return a(w5, EnumC0320ib.EVENT_TYPE_INIT);
    }

    public static W5 d(W5 w5) {
        W5 w52 = new W5("", 0);
        w52.j = w5.j;
        w52.i = w5.i;
        w52.f = w5.f;
        w52.c = w5.c;
        w52.m = w5.m;
        w52.p = w5.p;
        w52.h = w5.h;
        return w52;
    }

    public final void a(EnumC0370ka enumC0370ka) {
        this.k = enumC0370ka;
    }

    public final void a(EnumC0594t9 enumC0594t9) {
        this.l = enumC0594t9;
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

    public static W5 a(W5 w5, EnumC0320ib enumC0320ib) {
        W5 d = d(w5);
        d.d = enumC0320ib.f931a;
        return d;
    }

    public static W5 b(W5 w5) {
        return a(w5, EnumC0320ib.EVENT_TYPE_FIRST_ACTIVATION);
    }

    public static W5 a(W5 w5) {
        return a(w5, EnumC0320ib.EVENT_TYPE_ALIVE);
    }

    public static W5 a(W5 w5, T9 t9) {
        W5 a2 = a(w5, EnumC0320ib.EVENT_TYPE_START);
        a2.setValueBytes(MessageNano.toByteArray(new C0669w9().fromModel(new C0644v9((String) t9.b.a()))));
        a2.j = w5.j;
        a2.i = w5.i;
        return a2;
    }

    public static W5 a(W5 w5, Collection<PermissionState> collection, F2 f2, C0388l2 c0388l2, List<String> list) {
        String str;
        String str2;
        W5 d = d(w5);
        try {
            JSONArray jSONArray = new JSONArray();
            for (PermissionState permissionState : collection) {
                jSONArray.put(new JSONObject().put("name", permissionState.name).put("granted", permissionState.granted));
            }
            JSONObject jSONObject = new JSONObject();
            if (f2 != null) {
                jSONObject.put("background_restricted", f2.b);
                E2 e2 = f2.f470a;
                c0388l2.getClass();
                if (e2 != null) {
                    switch (e2.ordinal()) {
                        case 0:
                            str2 = "EXEMPTED";
                            break;
                        case 1:
                            str2 = "ACTIVE";
                            break;
                        case 2:
                            str2 = "WORKING_SET";
                            break;
                        case 3:
                            str2 = "FREQUENT";
                            break;
                        case 4:
                            str2 = "RARE";
                            break;
                        case 5:
                            str2 = "RESTRICTED";
                            break;
                        case 6:
                            str2 = "UNKNOWN";
                            break;
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
        EnumC0320ib enumC0320ib = EnumC0320ib.EVENT_TYPE_UNDEFINED;
        d.d = 12288;
        d.setValue(str);
        return d;
    }

    public static W5 a(W5 w5, String str) {
        W5 d = d(w5);
        EnumC0320ib enumC0320ib = EnumC0320ib.EVENT_TYPE_UNDEFINED;
        d.d = 12289;
        d.setValue(str);
        return d;
    }

    public static W5 a() {
        W5 w5 = new W5("", 0);
        EnumC0320ib enumC0320ib = EnumC0320ib.EVENT_TYPE_UNDEFINED;
        w5.d = 16384;
        return w5;
    }

    public static W5 a(String str) {
        W5 w5 = new W5("", 0);
        EnumC0320ib enumC0320ib = EnumC0320ib.EVENT_TYPE_UNDEFINED;
        w5.d = 12320;
        w5.b = str;
        w5.l = EnumC0594t9.JS;
        return w5;
    }
}
