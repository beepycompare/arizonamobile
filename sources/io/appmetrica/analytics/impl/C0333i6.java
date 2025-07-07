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
/* renamed from: io.appmetrica.analytics.impl.i6  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C0333i6 implements CounterReportApi, Parcelable {
    public static final Parcelable.Creator<C0333i6> CREATOR = new C0308h6();

    /* renamed from: a  reason: collision with root package name */
    protected String f874a;
    protected String b;
    public String c;
    public int d;
    public int e;
    public Pair f;
    public int g;
    public String h;
    public long i;
    public long j;
    public EnumC0685wa k;
    public E9 l;
    public Bundle m;
    public Boolean n;
    public Integer o;
    public Map p;

    public C0333i6() {
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

    public final EnumC0685wa g() {
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
        return this.f874a;
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

    public final E9 k() {
        return this.l;
    }

    public final boolean l() {
        return this.f874a == null;
    }

    public final boolean m() {
        EnumC0636ub enumC0636ub = EnumC0636ub.EVENT_TYPE_UNDEFINED;
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
        this.f874a = str;
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
        String str = this.f874a;
        String str2 = EnumC0636ub.a(this.d).b;
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
        bundle.putString("CounterReport.Event", this.f874a);
        bundle.putString("CounterReport.Value", this.b);
        bundle.putInt("CounterReport.Type", this.d);
        bundle.putInt("CounterReport.CustomType", this.e);
        bundle.putInt("CounterReport.TRUNCATED", this.g);
        bundle.putString("CounterReport.ProfileID", this.h);
        bundle.putInt("CounterReport.UniquenessStatus", this.k.f1103a);
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
        E9 e9 = this.l;
        if (e9 != null) {
            bundle.putInt("CounterReport.Source", e9.f405a);
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

    public C0333i6(String str, int i) {
        this("", str, i);
    }

    public static C0333i6 e(C0333i6 c0333i6) {
        return a(c0333i6, EnumC0636ub.EVENT_TYPE_APP_UPDATE);
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

    public C0333i6(String str, String str2, int i) {
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

    public C0333i6(String str, String str2, int i, SystemTimeProvider systemTimeProvider) {
        this.k = EnumC0685wa.UNKNOWN;
        this.p = new HashMap();
        this.f874a = str2;
        this.d = i;
        this.b = str;
        this.i = systemTimeProvider.elapsedRealtime();
        this.j = systemTimeProvider.currentTimeMillis();
    }

    public static C0333i6 b(Bundle bundle) {
        if (bundle != null) {
            try {
                C0333i6 c0333i6 = (C0333i6) bundle.getParcelable("CounterReport.Object");
                if (c0333i6 != null) {
                    return c0333i6;
                }
            } catch (Throwable unused) {
                return new C0333i6("", 0);
            }
        }
        return new C0333i6("", 0);
    }

    public static C0333i6 c(C0333i6 c0333i6) {
        return a(c0333i6, EnumC0636ub.EVENT_TYPE_INIT);
    }

    public static C0333i6 d(C0333i6 c0333i6) {
        C0333i6 c0333i62 = new C0333i6("", 0);
        c0333i62.j = c0333i6.j;
        c0333i62.i = c0333i6.i;
        c0333i62.f = c0333i6.f;
        c0333i62.c = c0333i6.c;
        c0333i62.m = c0333i6.m;
        c0333i62.p = c0333i6.p;
        c0333i62.h = c0333i6.h;
        return c0333i62;
    }

    public final void a(EnumC0685wa enumC0685wa) {
        this.k = enumC0685wa;
    }

    public final void a(E9 e9) {
        this.l = e9;
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

    public static C0333i6 a(C0333i6 c0333i6, EnumC0636ub enumC0636ub) {
        C0333i6 d = d(c0333i6);
        d.d = enumC0636ub.f1073a;
        return d;
    }

    public static C0333i6 b(C0333i6 c0333i6) {
        return a(c0333i6, EnumC0636ub.EVENT_TYPE_FIRST_ACTIVATION);
    }

    public static C0333i6 a(C0333i6 c0333i6) {
        return a(c0333i6, EnumC0636ub.EVENT_TYPE_ALIVE);
    }

    public static C0333i6 a(C0333i6 c0333i6, C0262fa c0262fa) {
        C0333i6 a2 = a(c0333i6, EnumC0636ub.EVENT_TYPE_START);
        a2.setValueBytes(MessageNano.toByteArray(new H9().fromModel(new G9((String) c0262fa.b.a()))));
        a2.j = c0333i6.j;
        a2.i = c0333i6.i;
        return a2;
    }

    public static C0333i6 a(C0333i6 c0333i6, Collection<PermissionState> collection, J2 j2, C0329i2 c0329i2, List<String> list) {
        String str;
        String str2;
        C0333i6 d = d(c0333i6);
        try {
            JSONArray jSONArray = new JSONArray();
            for (PermissionState permissionState : collection) {
                jSONArray.put(new JSONObject().put("name", permissionState.name).put("granted", permissionState.granted));
            }
            JSONObject jSONObject = new JSONObject();
            if (j2 != null) {
                jSONObject.put("background_restricted", j2.b);
                I2 i2 = j2.f484a;
                c0329i2.getClass();
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
        EnumC0636ub enumC0636ub = EnumC0636ub.EVENT_TYPE_UNDEFINED;
        d.d = 12288;
        d.setValue(str);
        return d;
    }

    public static C0333i6 a(C0333i6 c0333i6, String str) {
        C0333i6 d = d(c0333i6);
        EnumC0636ub enumC0636ub = EnumC0636ub.EVENT_TYPE_UNDEFINED;
        d.d = 12289;
        d.setValue(str);
        return d;
    }

    public static C0333i6 a() {
        C0333i6 c0333i6 = new C0333i6("", 0);
        EnumC0636ub enumC0636ub = EnumC0636ub.EVENT_TYPE_UNDEFINED;
        c0333i6.d = 16384;
        return c0333i6;
    }

    public static C0333i6 a(Rf rf) {
        String str = "";
        int i = 0;
        C0333i6 c0333i6 = new C0333i6("", "", 0);
        EnumC0636ub enumC0636ub = EnumC0636ub.EVENT_TYPE_UNDEFINED;
        c0333i6.d = 40976;
        ProductInfo productInfo = rf.f610a;
        Wi wi = new Wi();
        wi.f690a = productInfo.quantity;
        wi.f = productInfo.priceMicros;
        try {
            str = Currency.getInstance(productInfo.priceCurrency).getCurrencyCode();
        } catch (Throwable unused) {
        }
        wi.b = str.getBytes();
        wi.c = productInfo.sku.getBytes();
        Ri ri = new Ri();
        ri.f612a = productInfo.purchaseOriginalJson.getBytes();
        ri.b = productInfo.signature.getBytes();
        wi.e = ri;
        wi.g = true;
        wi.h = 1;
        wi.i = Qf.f595a[productInfo.type.ordinal()] != 2 ? 1 : 2;
        Vi vi = new Vi();
        vi.f676a = productInfo.purchaseToken.getBytes();
        vi.b = TimeUnit.MILLISECONDS.toSeconds(productInfo.purchaseTime);
        wi.j = vi;
        if (productInfo.type == ProductType.SUBS) {
            Ui ui = new Ui();
            ui.f661a = productInfo.autoRenewing;
            Period period = productInfo.subscriptionPeriod;
            if (period != null) {
                Ti ti = new Ti();
                ti.f644a = period.number;
                int i2 = Qf.b[period.timeUnit.ordinal()];
                ti.b = i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? 0 : 4 : 3 : 2 : 1;
                ui.b = ti;
            }
            Si si = new Si();
            si.f628a = productInfo.introductoryPriceMicros;
            Period period2 = productInfo.introductoryPricePeriod;
            if (period2 != null) {
                Ti ti2 = new Ti();
                ti2.f644a = period2.number;
                int i3 = Qf.b[period2.timeUnit.ordinal()];
                if (i3 == 1) {
                    i = 1;
                } else if (i3 == 2) {
                    i = 2;
                } else if (i3 == 3) {
                    i = 3;
                } else if (i3 == 4) {
                    i = 4;
                }
                ti2.b = i;
                si.b = ti2;
            }
            si.c = productInfo.introductoryPriceCycles;
            ui.c = si;
            wi.k = ui;
        }
        c0333i6.setValueBytes(MessageNano.toByteArray(wi));
        return c0333i6;
    }

    public static C0333i6 a(String str) {
        C0333i6 c0333i6 = new C0333i6("", 0);
        EnumC0636ub enumC0636ub = EnumC0636ub.EVENT_TYPE_UNDEFINED;
        c0333i6.d = 12320;
        c0333i6.b = str;
        c0333i6.l = E9.JS;
        return c0333i6;
    }
}
