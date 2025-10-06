package io.appmetrica.analytics.impl;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import android.util.Pair;
import com.google.firebase.messaging.ServiceStarter;
import io.appmetrica.analytics.billinginterface.internal.Period;
import io.appmetrica.analytics.billinginterface.internal.ProductInfo;
import io.appmetrica.analytics.billinginterface.internal.ProductType;
import io.appmetrica.analytics.coreapi.internal.event.CounterReportApi;
import io.appmetrica.analytics.coreapi.internal.permission.PermissionState;
import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import java.util.Collection;
import java.util.Currency;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;
/* renamed from: io.appmetrica.analytics.impl.o6  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C0478o6 implements CounterReportApi, Parcelable {
    public static final Parcelable.Creator<C0478o6> CREATOR = new C0452n6();

    /* renamed from: a  reason: collision with root package name */
    protected String f1018a;
    protected String b;
    public String c;
    public int d;
    public int e;
    public Pair f;
    public int g;
    public String h;
    public long i;
    public long j;
    public Da k;
    public M9 l;
    public Bundle m;
    public Boolean n;
    public Integer o;
    public Map p;

    public C0478o6() {
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

    public final Da g() {
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
        return this.f1018a;
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

    public final M9 k() {
        return this.l;
    }

    public final boolean l() {
        return this.f1018a == null;
    }

    public final boolean m() {
        Bb bb = Bb.EVENT_TYPE_UNDEFINED;
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
        this.f1018a = str;
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
        String str = this.f1018a;
        String str2 = Bb.a(this.d).b;
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
        bundle.putString("CounterReport.Event", this.f1018a);
        bundle.putString("CounterReport.Value", this.b);
        bundle.putInt("CounterReport.Type", this.d);
        bundle.putInt("CounterReport.CustomType", this.e);
        bundle.putInt("CounterReport.TRUNCATED", this.g);
        bundle.putString("CounterReport.ProfileID", this.h);
        bundle.putInt("CounterReport.UniquenessStatus", this.k.f408a);
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
        M9 m9 = this.l;
        if (m9 != null) {
            bundle.putInt("CounterReport.Source", m9.f576a);
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

    public C0478o6(String str, int i) {
        this("", str, i);
    }

    public static C0478o6 e(C0478o6 c0478o6) {
        return a(c0478o6, Bb.EVENT_TYPE_APP_UPDATE);
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

    public C0478o6(String str, String str2, int i) {
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

    public C0478o6(String str, String str2, int i, SystemTimeProvider systemTimeProvider) {
        this.k = Da.UNKNOWN;
        this.p = new HashMap();
        this.f1018a = str2;
        this.d = i;
        this.b = str;
        this.i = systemTimeProvider.elapsedRealtime();
        this.j = systemTimeProvider.currentTimeMillis();
    }

    public static C0478o6 b(Bundle bundle) {
        if (bundle != null) {
            try {
                C0478o6 c0478o6 = (C0478o6) bundle.getParcelable("CounterReport.Object");
                if (c0478o6 != null) {
                    return c0478o6;
                }
            } catch (Throwable unused) {
                return new C0478o6("", 0);
            }
        }
        return new C0478o6("", 0);
    }

    public static C0478o6 c(C0478o6 c0478o6) {
        return a(c0478o6, Bb.EVENT_TYPE_INIT);
    }

    public static C0478o6 d(C0478o6 c0478o6) {
        C0478o6 c0478o62 = new C0478o6("", 0);
        c0478o62.j = c0478o6.j;
        c0478o62.i = c0478o6.i;
        c0478o62.f = c0478o6.f;
        c0478o62.c = c0478o6.c;
        c0478o62.m = c0478o6.m;
        c0478o62.p = c0478o6.p;
        c0478o62.h = c0478o6.h;
        return c0478o62;
    }

    public final void a(Da da) {
        this.k = da;
    }

    public final void a(M9 m9) {
        this.l = m9;
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

    public static C0478o6 a(C0478o6 c0478o6, Bb bb) {
        C0478o6 d = d(c0478o6);
        d.d = bb.f369a;
        return d;
    }

    public static C0478o6 b(C0478o6 c0478o6) {
        return a(c0478o6, Bb.EVENT_TYPE_FIRST_ACTIVATION);
    }

    public static C0478o6 a(C0478o6 c0478o6) {
        return a(c0478o6, Bb.EVENT_TYPE_ALIVE);
    }

    public static C0478o6 a(C0478o6 c0478o6, C0430ma c0430ma) {
        C0478o6 a2 = a(c0478o6, Bb.EVENT_TYPE_START);
        a2.setValueBytes(MessageNano.toByteArray(new P9().fromModel(new O9((String) c0430ma.b.a()))));
        a2.j = c0478o6.j;
        a2.i = c0478o6.i;
        return a2;
    }

    public static C0478o6 a(C0478o6 c0478o6, Collection<PermissionState> collection, M2 m2, C0370k2 c0370k2, List<String> list) {
        String str;
        String str2;
        C0478o6 d = d(c0478o6);
        try {
            JSONArray jSONArray = new JSONArray();
            for (PermissionState permissionState : collection) {
                jSONArray.put(new JSONObject().put("name", permissionState.name).put("granted", permissionState.granted));
            }
            JSONObject jSONObject = new JSONObject();
            if (m2 != null) {
                jSONObject.put("background_restricted", m2.b);
                L2 l2 = m2.f570a;
                c0370k2.getClass();
                if (l2 != null) {
                    switch (l2.ordinal()) {
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
        Bb bb = Bb.EVENT_TYPE_UNDEFINED;
        d.d = 12288;
        d.setValue(str);
        return d;
    }

    public static C0478o6 a(C0478o6 c0478o6, String str) {
        C0478o6 d = d(c0478o6);
        Bb bb = Bb.EVENT_TYPE_UNDEFINED;
        d.d = 12289;
        d.setValue(str);
        return d;
    }

    public static C0478o6 a() {
        C0478o6 c0478o6 = new C0478o6("", 0);
        Bb bb = Bb.EVENT_TYPE_UNDEFINED;
        c0478o6.d = 16384;
        return c0478o6;
    }

    public static C0478o6 a(C0178cg c0178cg) {
        String str = "";
        int i = 0;
        C0478o6 c0478o6 = new C0478o6("", "", 0);
        Bb bb = Bb.EVENT_TYPE_UNDEFINED;
        c0478o6.d = 40976;
        ProductInfo productInfo = c0178cg.f826a;
        C0335ij c0335ij = new C0335ij();
        c0335ij.f926a = productInfo.quantity;
        c0335ij.f = productInfo.priceMicros;
        try {
            str = Currency.getInstance(productInfo.priceCurrency).getCurrencyCode();
        } catch (Throwable unused) {
        }
        c0335ij.b = str.getBytes();
        c0335ij.c = productInfo.sku.getBytes();
        C0207dj c0207dj = new C0207dj();
        c0207dj.f848a = productInfo.purchaseOriginalJson.getBytes();
        c0207dj.b = productInfo.signature.getBytes();
        c0335ij.e = c0207dj;
        c0335ij.g = true;
        c0335ij.h = 1;
        c0335ij.i = AbstractC0152bg.f813a[productInfo.type.ordinal()] != 2 ? 1 : 2;
        C0310hj c0310hj = new C0310hj();
        c0310hj.f913a = productInfo.purchaseToken.getBytes();
        c0310hj.b = TimeUnit.MILLISECONDS.toSeconds(productInfo.purchaseTime);
        c0335ij.j = c0310hj;
        if (productInfo.type == ProductType.SUBS) {
            C0284gj c0284gj = new C0284gj();
            c0284gj.f900a = productInfo.autoRenewing;
            Period period = productInfo.subscriptionPeriod;
            if (period != null) {
                C0258fj c0258fj = new C0258fj();
                c0258fj.f882a = period.number;
                int i2 = AbstractC0152bg.b[period.timeUnit.ordinal()];
                c0258fj.b = i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? 0 : 4 : 3 : 2 : 1;
                c0284gj.b = c0258fj;
            }
            C0232ej c0232ej = new C0232ej();
            c0232ej.f866a = productInfo.introductoryPriceMicros;
            Period period2 = productInfo.introductoryPricePeriod;
            if (period2 != null) {
                C0258fj c0258fj2 = new C0258fj();
                c0258fj2.f882a = period2.number;
                int i3 = AbstractC0152bg.b[period2.timeUnit.ordinal()];
                if (i3 == 1) {
                    i = 1;
                } else if (i3 == 2) {
                    i = 2;
                } else if (i3 == 3) {
                    i = 3;
                } else if (i3 == 4) {
                    i = 4;
                }
                c0258fj2.b = i;
                c0232ej.b = c0258fj2;
            }
            c0232ej.c = productInfo.introductoryPriceCycles;
            c0284gj.c = c0232ej;
            c0335ij.k = c0284gj;
        }
        c0478o6.setValueBytes(MessageNano.toByteArray(c0335ij));
        return c0478o6;
    }

    public static C0478o6 a(String str) {
        C0478o6 c0478o6 = new C0478o6("", 0);
        Bb bb = Bb.EVENT_TYPE_UNDEFINED;
        c0478o6.d = 12320;
        c0478o6.b = str;
        c0478o6.l = M9.JS;
        return c0478o6;
    }
}
