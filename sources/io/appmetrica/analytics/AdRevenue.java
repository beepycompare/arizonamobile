package io.appmetrica.analytics;

import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import io.appmetrica.analytics.impl.fo;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.Map;
/* loaded from: classes4.dex */
public class AdRevenue {
    public final String adNetwork;
    public final String adPlacementId;
    public final String adPlacementName;
    public final BigDecimal adRevenue;
    public final AdType adType;
    public final String adUnitId;
    public final String adUnitName;
    public final Currency currency;
    public final Map<String, String> payload;
    public final String precision;

    /* loaded from: classes4.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        private final BigDecimal f190a;
        private final Currency b;
        private AdType c;
        private String d;
        private String e;
        private String f;
        private String g;
        private String h;
        private String i;
        private Map j;

        /* synthetic */ Builder(BigDecimal bigDecimal, Currency currency, int i) {
            this(bigDecimal, currency);
        }

        public AdRevenue build() {
            return new AdRevenue(this.f190a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, 0);
        }

        public Builder withAdNetwork(String str) {
            this.d = str;
            return this;
        }

        public Builder withAdPlacementId(String str) {
            this.g = str;
            return this;
        }

        public Builder withAdPlacementName(String str) {
            this.h = str;
            return this;
        }

        public Builder withAdType(AdType adType) {
            this.c = adType;
            return this;
        }

        public Builder withAdUnitId(String str) {
            this.e = str;
            return this;
        }

        public Builder withAdUnitName(String str) {
            this.f = str;
            return this;
        }

        public Builder withPayload(Map<String, String> map) {
            this.j = map == null ? null : CollectionUtils.copyOf(map);
            return this;
        }

        public Builder withPrecision(String str) {
            this.i = str;
            return this;
        }

        private Builder(BigDecimal bigDecimal, Currency currency) {
            this.f190a = bigDecimal;
            this.b = currency;
        }
    }

    /* synthetic */ AdRevenue(BigDecimal bigDecimal, Currency currency, AdType adType, String str, String str2, String str3, String str4, String str5, String str6, Map map, int i) {
        this(bigDecimal, currency, adType, str, str2, str3, str4, str5, str6, map);
    }

    public static Builder newBuilder(BigDecimal bigDecimal, Currency currency) {
        return new Builder(bigDecimal, currency, 0);
    }

    private AdRevenue(BigDecimal bigDecimal, Currency currency, AdType adType, String str, String str2, String str3, String str4, String str5, String str6, Map map) {
        this.adRevenue = bigDecimal;
        this.currency = currency;
        this.adType = adType;
        this.adNetwork = str;
        this.adUnitId = str2;
        this.adUnitName = str3;
        this.adPlacementId = str4;
        this.adPlacementName = str5;
        this.precision = str6;
        this.payload = map == null ? null : CollectionUtils.unmodifiableMapCopy(map);
    }

    public static Builder newBuilder(long j, Currency currency) {
        return new Builder(fo.a(j), currency, 0);
    }

    public static Builder newBuilder(double d, Currency currency) {
        return new Builder(new BigDecimal(fo.a(d)), currency, 0);
    }
}
