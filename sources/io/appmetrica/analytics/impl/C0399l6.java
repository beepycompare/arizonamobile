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
/* renamed from: io.appmetrica.analytics.impl.l6  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C0399l6 implements CounterReportApi, Parcelable {
    public static final Parcelable.Creator<C0399l6> CREATOR = new C0373k6();

    /* renamed from: a  reason: collision with root package name */
    protected String f950a;
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
    public J9 l;
    public Bundle m;
    public Boolean n;
    public Integer o;
    public Map p;

    public C0399l6() {
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
        return this.f950a;
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

    public final J9 k() {
        return this.l;
    }

    public final boolean l() {
        return this.f950a == null;
    }

    public final boolean m() {
        EnumC0728yb enumC0728yb = EnumC0728yb.EVENT_TYPE_UNDEFINED;
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
        this.f950a = str;
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
        String str = this.f950a;
        String str2 = EnumC0728yb.a(this.d).b;
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
        bundle.putString("CounterReport.Event", this.f950a);
        bundle.putString("CounterReport.Value", this.b);
        bundle.putInt("CounterReport.Type", this.d);
        bundle.putInt("CounterReport.CustomType", this.e);
        bundle.putInt("CounterReport.TRUNCATED", this.g);
        bundle.putString("CounterReport.ProfileID", this.h);
        bundle.putInt("CounterReport.UniquenessStatus", this.k.f344a);
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
        J9 j9 = this.l;
        if (j9 != null) {
            bundle.putInt("CounterReport.Source", j9.f513a);
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

    public C0399l6(String str, int i) {
        this("", str, i);
    }

    public static C0399l6 e(C0399l6 c0399l6) {
        return a(c0399l6, EnumC0728yb.EVENT_TYPE_APP_UPDATE);
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

    public C0399l6(String str, String str2, int i) {
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

    public C0399l6(String str, String str2, int i, SystemTimeProvider systemTimeProvider) {
        this.k = Aa.UNKNOWN;
        this.p = new HashMap();
        this.f950a = str2;
        this.d = i;
        this.b = str;
        this.i = systemTimeProvider.elapsedRealtime();
        this.j = systemTimeProvider.currentTimeMillis();
    }

    public static C0399l6 b(Bundle bundle) {
        if (bundle != null) {
            try {
                C0399l6 c0399l6 = (C0399l6) bundle.getParcelable("CounterReport.Object");
                if (c0399l6 != null) {
                    return c0399l6;
                }
            } catch (Throwable unused) {
                return new C0399l6("", 0);
            }
        }
        return new C0399l6("", 0);
    }

    public static C0399l6 c(C0399l6 c0399l6) {
        return a(c0399l6, EnumC0728yb.EVENT_TYPE_INIT);
    }

    public static C0399l6 d(C0399l6 c0399l6) {
        C0399l6 c0399l62 = new C0399l6("", 0);
        c0399l62.j = c0399l6.j;
        c0399l62.i = c0399l6.i;
        c0399l62.f = c0399l6.f;
        c0399l62.c = c0399l6.c;
        c0399l62.m = c0399l6.m;
        c0399l62.p = c0399l6.p;
        c0399l62.h = c0399l6.h;
        return c0399l62;
    }

    public final void a(Aa aa) {
        this.k = aa;
    }

    public final void a(J9 j9) {
        this.l = j9;
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

    public static C0399l6 a(C0399l6 c0399l6, EnumC0728yb enumC0728yb) {
        C0399l6 d = d(c0399l6);
        d.d = enumC0728yb.f1157a;
        return d;
    }

    public static C0399l6 b(C0399l6 c0399l6) {
        return a(c0399l6, EnumC0728yb.EVENT_TYPE_FIRST_ACTIVATION);
    }

    public static C0399l6 a(C0399l6 c0399l6) {
        return a(c0399l6, EnumC0728yb.EVENT_TYPE_ALIVE);
    }

    public static C0399l6 a(C0399l6 c0399l6, C0351ja c0351ja) {
        C0399l6 a2 = a(c0399l6, EnumC0728yb.EVENT_TYPE_START);
        a2.setValueBytes(MessageNano.toByteArray(new M9().fromModel(new L9((String) c0351ja.b.a()))));
        a2.j = c0399l6.j;
        a2.i = c0399l6.i;
        return a2;
    }

    public static C0399l6 a(C0399l6 c0399l6, Collection<PermissionState> collection, J2 j2, C0318i2 c0318i2, List<String> list) {
        String str;
        String str2;
        C0399l6 d = d(c0399l6);
        try {
            JSONArray jSONArray = new JSONArray();
            for (PermissionState permissionState : collection) {
                jSONArray.put(new JSONObject().put("name", permissionState.name).put("granted", permissionState.granted));
            }
            JSONObject jSONObject = new JSONObject();
            if (j2 != null) {
                jSONObject.put("background_restricted", j2.b);
                I2 i2 = j2.f507a;
                c0318i2.getClass();
                if (i2 != null) {
                    switch (i2.ordinal()) {
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
        EnumC0728yb enumC0728yb = EnumC0728yb.EVENT_TYPE_UNDEFINED;
        d.d = 12288;
        d.setValue(str);
        return d;
    }

    public static C0399l6 a(C0399l6 c0399l6, String str) {
        C0399l6 d = d(c0399l6);
        EnumC0728yb enumC0728yb = EnumC0728yb.EVENT_TYPE_UNDEFINED;
        d.d = 12289;
        d.setValue(str);
        return d;
    }

    public static C0399l6 a() {
        C0399l6 c0399l6 = new C0399l6("", 0);
        EnumC0728yb enumC0728yb = EnumC0728yb.EVENT_TYPE_UNDEFINED;
        c0399l6.d = 16384;
        return c0399l6;
    }

    public static C0399l6 a(Yf yf) {
        String str = "";
        int i = 0;
        C0399l6 c0399l6 = new C0399l6("", "", 0);
        EnumC0728yb enumC0728yb = EnumC0728yb.EVENT_TYPE_UNDEFINED;
        c0399l6.d = 40976;
        ProductInfo productInfo = yf.f743a;
        C0231ej c0231ej = new C0231ej();
        c0231ej.f844a = productInfo.quantity;
        c0231ej.f = productInfo.priceMicros;
        try {
            str = Currency.getInstance(productInfo.priceCurrency).getCurrencyCode();
        } catch (Throwable unused) {
        }
        c0231ej.b = str.getBytes();
        c0231ej.c = productInfo.sku.getBytes();
        Zi zi = new Zi();
        zi.f761a = productInfo.purchaseOriginalJson.getBytes();
        zi.b = productInfo.signature.getBytes();
        c0231ej.e = zi;
        c0231ej.g = true;
        c0231ej.h = 1;
        c0231ej.i = Xf.f727a[productInfo.type.ordinal()] != 2 ? 1 : 2;
        C0206dj c0206dj = new C0206dj();
        c0206dj.f833a = productInfo.purchaseToken.getBytes();
        c0206dj.b = TimeUnit.MILLISECONDS.toSeconds(productInfo.purchaseTime);
        c0231ej.j = c0206dj;
        if (productInfo.type == ProductType.SUBS) {
            C0180cj c0180cj = new C0180cj();
            c0180cj.f815a = productInfo.autoRenewing;
            Period period = productInfo.subscriptionPeriod;
            if (period != null) {
                C0154bj c0154bj = new C0154bj();
                c0154bj.f797a = period.number;
                int i2 = Xf.b[period.timeUnit.ordinal()];
                c0154bj.b = i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? 0 : 4 : 3 : 2 : 1;
                c0180cj.b = c0154bj;
            }
            C0128aj c0128aj = new C0128aj();
            c0128aj.f782a = productInfo.introductoryPriceMicros;
            Period period2 = productInfo.introductoryPricePeriod;
            if (period2 != null) {
                C0154bj c0154bj2 = new C0154bj();
                c0154bj2.f797a = period2.number;
                int i3 = Xf.b[period2.timeUnit.ordinal()];
                if (i3 == 1) {
                    i = 1;
                } else if (i3 == 2) {
                    i = 2;
                } else if (i3 == 3) {
                    i = 3;
                } else if (i3 == 4) {
                    i = 4;
                }
                c0154bj2.b = i;
                c0128aj.b = c0154bj2;
            }
            c0128aj.c = productInfo.introductoryPriceCycles;
            c0180cj.c = c0128aj;
            c0231ej.k = c0180cj;
        }
        c0399l6.setValueBytes(MessageNano.toByteArray(c0231ej));
        return c0399l6;
    }

    public static C0399l6 a(String str) {
        C0399l6 c0399l6 = new C0399l6("", 0);
        EnumC0728yb enumC0728yb = EnumC0728yb.EVENT_TYPE_UNDEFINED;
        c0399l6.d = 12320;
        c0399l6.b = str;
        c0399l6.l = J9.JS;
        return c0399l6;
    }
}
