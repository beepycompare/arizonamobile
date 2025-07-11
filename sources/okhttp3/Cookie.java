package okhttp3;

import androidx.media3.exoplayer.upstream.CmcdData;
import com.google.android.vending.expansion.downloader.Constants;
import com.google.common.net.HttpHeaders;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import okhttp3.internal._HostnamesCommonKt;
import okhttp3.internal._UtilCommonKt;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal.http.DateFormattingKt;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
/* compiled from: Cookie.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 *2\u00020\u0001:\u0002)*B[\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\n\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u000e\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0016J\u0013\u0010\u0017\u001a\u00020\n2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0017J\b\u0010\u001b\u001a\u00020\u0003H\u0016J\r\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\b\u001cJ\r\u0010\u0004\u001a\u00020\u0003H\u0007¢\u0006\u0002\b\u001dJ\r\u0010\f\u001a\u00020\nH\u0007¢\u0006\u0002\b\u001eJ\r\u0010\u0005\u001a\u00020\u0006H\u0007¢\u0006\u0002\b\u001fJ\r\u0010\r\u001a\u00020\nH\u0007¢\u0006\u0002\b J\r\u0010\u0007\u001a\u00020\u0003H\u0007¢\u0006\u0002\b!J\r\u0010\b\u001a\u00020\u0003H\u0007¢\u0006\u0002\b\"J\r\u0010\u000b\u001a\u00020\nH\u0007¢\u0006\u0002\b#J\r\u0010\t\u001a\u00020\nH\u0007¢\u0006\u0002\b$J\u0015\u0010\u001b\u001a\u00020\u00032\u0006\u0010%\u001a\u00020\nH\u0000¢\u0006\u0002\b&J\u0006\u0010'\u001a\u00020(R\u0013\u0010\u0002\u001a\u00020\u00038G¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0011R\u0013\u0010\u0004\u001a\u00020\u00038G¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0011R\u0013\u0010\u0005\u001a\u00020\u00068G¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0012R\u0013\u0010\u0007\u001a\u00020\u00038G¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0011R\u0013\u0010\b\u001a\u00020\u00038G¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0011R\u0013\u0010\t\u001a\u00020\n8G¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0013R\u0013\u0010\u000b\u001a\u00020\n8G¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0013R\u0013\u0010\f\u001a\u00020\n8G¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0013R\u0013\u0010\r\u001a\u00020\n8G¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0013R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u00038G¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0011¨\u0006+"}, d2 = {"Lokhttp3/Cookie;", "", "name", "", "value", "expiresAt", "", "domain", "path", "secure", "", "httpOnly", "persistent", "hostOnly", "sameSite", "<init>", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;ZZZZLjava/lang/String;)V", "()Ljava/lang/String;", "()J", "()Z", "matches", "url", "Lokhttp3/HttpUrl;", "equals", "other", "hashCode", "", "toString", "-deprecated_name", "-deprecated_value", "-deprecated_persistent", "-deprecated_expiresAt", "-deprecated_hostOnly", "-deprecated_domain", "-deprecated_path", "-deprecated_httpOnly", "-deprecated_secure", "forObsoleteRfc2965", "toString$okhttp", "newBuilder", "Lokhttp3/Cookie$Builder;", "Builder", "Companion", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class Cookie {
    private final String domain;
    private final long expiresAt;
    private final boolean hostOnly;
    private final boolean httpOnly;
    private final String name;
    private final String path;
    private final boolean persistent;
    private final String sameSite;
    private final boolean secure;
    private final String value;
    public static final Companion Companion = new Companion(null);
    private static final Pattern YEAR_PATTERN = Pattern.compile("(\\d{2,4})[^\\d]*");
    private static final Pattern MONTH_PATTERN = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");
    private static final Pattern DAY_OF_MONTH_PATTERN = Pattern.compile("(\\d{1,2})[^\\d]*");
    private static final Pattern TIME_PATTERN = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");

    public /* synthetic */ Cookie(String str, String str2, long j, String str3, String str4, boolean z, boolean z2, boolean z3, boolean z4, String str5, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, j, str3, str4, z, z2, z3, z4, str5);
    }

    @JvmStatic
    public static final Cookie parse(HttpUrl httpUrl, String str) {
        return Companion.parse(httpUrl, str);
    }

    @JvmStatic
    public static final List<Cookie> parseAll(HttpUrl httpUrl, Headers headers) {
        return Companion.parseAll(httpUrl, headers);
    }

    private Cookie(String str, String str2, long j, String str3, String str4, boolean z, boolean z2, boolean z3, boolean z4, String str5) {
        this.name = str;
        this.value = str2;
        this.expiresAt = j;
        this.domain = str3;
        this.path = str4;
        this.secure = z;
        this.httpOnly = z2;
        this.persistent = z3;
        this.hostOnly = z4;
        this.sameSite = str5;
    }

    public final String name() {
        return this.name;
    }

    public final String value() {
        return this.value;
    }

    public final long expiresAt() {
        return this.expiresAt;
    }

    public final String domain() {
        return this.domain;
    }

    public final String path() {
        return this.path;
    }

    public final boolean secure() {
        return this.secure;
    }

    public final boolean httpOnly() {
        return this.httpOnly;
    }

    public final boolean persistent() {
        return this.persistent;
    }

    public final boolean hostOnly() {
        return this.hostOnly;
    }

    public final String sameSite() {
        return this.sameSite;
    }

    public final boolean matches(HttpUrl url) {
        boolean domainMatch;
        Intrinsics.checkNotNullParameter(url, "url");
        if (this.hostOnly) {
            domainMatch = Intrinsics.areEqual(url.host(), this.domain);
        } else {
            domainMatch = Companion.domainMatch(url.host(), this.domain);
        }
        if (domainMatch && Companion.pathMatch(url, this.path)) {
            return !this.secure || url.isHttps();
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Cookie) {
            Cookie cookie = (Cookie) obj;
            return Intrinsics.areEqual(cookie.name, this.name) && Intrinsics.areEqual(cookie.value, this.value) && cookie.expiresAt == this.expiresAt && Intrinsics.areEqual(cookie.domain, this.domain) && Intrinsics.areEqual(cookie.path, this.path) && cookie.secure == this.secure && cookie.httpOnly == this.httpOnly && cookie.persistent == this.persistent && cookie.hostOnly == this.hostOnly && Intrinsics.areEqual(cookie.sameSite, this.sameSite);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = (((((((((((((((((527 + this.name.hashCode()) * 31) + this.value.hashCode()) * 31) + Long.hashCode(this.expiresAt)) * 31) + this.domain.hashCode()) * 31) + this.path.hashCode()) * 31) + Boolean.hashCode(this.secure)) * 31) + Boolean.hashCode(this.httpOnly)) * 31) + Boolean.hashCode(this.persistent)) * 31) + Boolean.hashCode(this.hostOnly)) * 31;
        String str = this.sameSite;
        return hashCode + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return toString$okhttp(false);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "name", imports = {}))
    /* renamed from: -deprecated_name  reason: not valid java name */
    public final String m10263deprecated_name() {
        return this.name;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "value", imports = {}))
    /* renamed from: -deprecated_value  reason: not valid java name */
    public final String m10267deprecated_value() {
        return this.value;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "persistent", imports = {}))
    /* renamed from: -deprecated_persistent  reason: not valid java name */
    public final boolean m10265deprecated_persistent() {
        return this.persistent;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "expiresAt", imports = {}))
    /* renamed from: -deprecated_expiresAt  reason: not valid java name */
    public final long m10260deprecated_expiresAt() {
        return this.expiresAt;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "hostOnly", imports = {}))
    /* renamed from: -deprecated_hostOnly  reason: not valid java name */
    public final boolean m10261deprecated_hostOnly() {
        return this.hostOnly;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "domain", imports = {}))
    /* renamed from: -deprecated_domain  reason: not valid java name */
    public final String m10259deprecated_domain() {
        return this.domain;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "path", imports = {}))
    /* renamed from: -deprecated_path  reason: not valid java name */
    public final String m10264deprecated_path() {
        return this.path;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "httpOnly", imports = {}))
    /* renamed from: -deprecated_httpOnly  reason: not valid java name */
    public final boolean m10262deprecated_httpOnly() {
        return this.httpOnly;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "secure", imports = {}))
    /* renamed from: -deprecated_secure  reason: not valid java name */
    public final boolean m10266deprecated_secure() {
        return this.secure;
    }

    public final String toString$okhttp(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name);
        sb.append('=');
        sb.append(this.value);
        if (this.persistent) {
            if (this.expiresAt == Long.MIN_VALUE) {
                sb.append("; max-age=0");
            } else {
                sb.append("; expires=").append(DateFormattingKt.toHttpDateString(new Date(this.expiresAt)));
            }
        }
        if (!this.hostOnly) {
            sb.append("; domain=");
            if (z) {
                sb.append(".");
            }
            sb.append(this.domain);
        }
        sb.append("; path=").append(this.path);
        if (this.secure) {
            sb.append("; secure");
        }
        if (this.httpOnly) {
            sb.append("; httponly");
        }
        if (this.sameSite != null) {
            sb.append("; samesite=").append(this.sameSite);
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }

    public final Builder newBuilder() {
        return new Builder(this);
    }

    /* compiled from: Cookie.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0010\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\bJ\u000e\u0010\u0014\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\bJ\u0018\u0010\f\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u000fH\u0002J\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\bJ\u0006\u0010\u000e\u001a\u00020\u0000J\u0006\u0010\u0010\u001a\u00020\u0000J\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\bJ\u0006\u0010\u0015\u001a\u00020\u0005R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lokhttp3/Cookie$Builder;", "", "<init>", "()V", "cookie", "Lokhttp3/Cookie;", "(Lokhttp3/Cookie;)V", "name", "", "value", "expiresAt", "", "domain", "path", "secure", "", "httpOnly", "persistent", "hostOnly", "sameSite", "hostOnlyDomain", "build", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Builder {
        private String domain;
        private long expiresAt;
        private boolean hostOnly;
        private boolean httpOnly;
        private String name;
        private String path;
        private boolean persistent;
        private String sameSite;
        private boolean secure;
        private String value;

        public Builder() {
            this.expiresAt = DateFormattingKt.MAX_DATE;
            this.path = RemoteSettings.FORWARD_SLASH_STRING;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(Cookie cookie) {
            this();
            Intrinsics.checkNotNullParameter(cookie, "cookie");
            this.name = cookie.name();
            this.value = cookie.value();
            this.expiresAt = cookie.expiresAt();
            this.domain = cookie.domain();
            this.path = cookie.path();
            this.secure = cookie.secure();
            this.httpOnly = cookie.httpOnly();
            this.persistent = cookie.persistent();
            this.hostOnly = cookie.hostOnly();
            this.sameSite = cookie.sameSite();
        }

        public final Builder name(String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            if (!Intrinsics.areEqual(StringsKt.trim((CharSequence) name).toString(), name)) {
                throw new IllegalArgumentException("name is not trimmed".toString());
            }
            this.name = name;
            return this;
        }

        public final Builder value(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            if (!Intrinsics.areEqual(StringsKt.trim((CharSequence) value).toString(), value)) {
                throw new IllegalArgumentException("value is not trimmed".toString());
            }
            this.value = value;
            return this;
        }

        public final Builder expiresAt(long j) {
            if (j <= 0) {
                j = Long.MIN_VALUE;
            }
            if (j > DateFormattingKt.MAX_DATE) {
                j = 253402300799999L;
            }
            this.expiresAt = j;
            this.persistent = true;
            return this;
        }

        public final Builder domain(String domain) {
            Intrinsics.checkNotNullParameter(domain, "domain");
            return domain(domain, false);
        }

        public final Builder hostOnlyDomain(String domain) {
            Intrinsics.checkNotNullParameter(domain, "domain");
            return domain(domain, true);
        }

        private final Builder domain(String str, boolean z) {
            String canonicalHost = _HostnamesCommonKt.toCanonicalHost(str);
            if (canonicalHost == null) {
                throw new IllegalArgumentException("unexpected domain: " + str);
            }
            this.domain = canonicalHost;
            this.hostOnly = z;
            return this;
        }

        public final Builder path(String path) {
            Intrinsics.checkNotNullParameter(path, "path");
            if (!StringsKt.startsWith$default(path, RemoteSettings.FORWARD_SLASH_STRING, false, 2, (Object) null)) {
                throw new IllegalArgumentException("path must start with '/'".toString());
            }
            this.path = path;
            return this;
        }

        public final Builder secure() {
            this.secure = true;
            return this;
        }

        public final Builder httpOnly() {
            this.httpOnly = true;
            return this;
        }

        public final Builder sameSite(String sameSite) {
            Intrinsics.checkNotNullParameter(sameSite, "sameSite");
            if (!Intrinsics.areEqual(StringsKt.trim((CharSequence) sameSite).toString(), sameSite)) {
                throw new IllegalArgumentException("sameSite is not trimmed".toString());
            }
            this.sameSite = sameSite;
            return this;
        }

        public final Cookie build() {
            String str = this.name;
            if (str == null) {
                throw new NullPointerException("builder.name == null");
            }
            String str2 = this.value;
            if (str2 == null) {
                throw new NullPointerException("builder.value == null");
            }
            long j = this.expiresAt;
            String str3 = this.domain;
            if (str3 != null) {
                return new Cookie(str, str2, j, str3, this.path, this.secure, this.httpOnly, this.persistent, this.hostOnly, this.sameSite, null);
            }
            throw new NullPointerException("builder.domain == null");
        }
    }

    /* compiled from: Cookie.kt */
    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0018\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\rH\u0002J\u001a\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\rH\u0007J'\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\rH\u0000¢\u0006\u0002\b\u0018J \u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001cH\u0002J(\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\u000bH\u0002J\u0010\u0010!\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\rH\u0002J\u0010\u0010\"\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\rH\u0002J\u001e\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00140$2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010%\u001a\u00020&H\u0007R\u0016\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lokhttp3/Cookie$Companion;", "", "<init>", "()V", "YEAR_PATTERN", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "MONTH_PATTERN", "DAY_OF_MONTH_PATTERN", "TIME_PATTERN", "domainMatch", "", "urlHost", "", "domain", "pathMatch", "url", "Lokhttp3/HttpUrl;", "path", "parse", "Lokhttp3/Cookie;", "setCookie", "currentTimeMillis", "", "parse$okhttp", "parseExpires", CmcdData.STREAMING_FORMAT_SS, "pos", "", "limit", "dateCharacterOffset", "input", "invert", "parseMaxAge", "parseDomain", "parseAll", "", "headers", "Lokhttp3/Headers;", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean domainMatch(String str, String str2) {
            if (Intrinsics.areEqual(str, str2)) {
                return true;
            }
            return StringsKt.endsWith$default(str, str2, false, 2, (Object) null) && str.charAt((str.length() - str2.length()) - 1) == '.' && !_HostnamesCommonKt.canParseAsIpAddress(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean pathMatch(HttpUrl httpUrl, String str) {
            String encodedPath = httpUrl.encodedPath();
            if (Intrinsics.areEqual(encodedPath, str)) {
                return true;
            }
            return StringsKt.startsWith$default(encodedPath, str, false, 2, (Object) null) && (StringsKt.endsWith$default(str, RemoteSettings.FORWARD_SLASH_STRING, false, 2, (Object) null) || encodedPath.charAt(str.length()) == '/');
        }

        @JvmStatic
        public final Cookie parse(HttpUrl url, String setCookie) {
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(setCookie, "setCookie");
            return parse$okhttp(System.currentTimeMillis(), url, setCookie);
        }

        public final Cookie parse$okhttp(long j, HttpUrl url, String setCookie) {
            long j2;
            String str;
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(setCookie, "setCookie");
            int delimiterOffset$default = _UtilCommonKt.delimiterOffset$default(setCookie, ';', 0, 0, 6, (Object) null);
            int delimiterOffset$default2 = _UtilCommonKt.delimiterOffset$default(setCookie, '=', 0, delimiterOffset$default, 2, (Object) null);
            Cookie cookie = null;
            if (delimiterOffset$default2 == delimiterOffset$default) {
                return null;
            }
            String trimSubstring$default = _UtilCommonKt.trimSubstring$default(setCookie, 0, delimiterOffset$default2, 1, null);
            if (trimSubstring$default.length() != 0 && _UtilCommonKt.indexOfControlOrNonAscii(trimSubstring$default) == -1) {
                String trimSubstring = _UtilCommonKt.trimSubstring(setCookie, delimiterOffset$default2 + 1, delimiterOffset$default);
                if (_UtilCommonKt.indexOfControlOrNonAscii(trimSubstring) != -1) {
                    return null;
                }
                int i = delimiterOffset$default + 1;
                int length = setCookie.length();
                String str2 = null;
                String str3 = null;
                String str4 = null;
                boolean z = false;
                boolean z2 = false;
                boolean z3 = false;
                boolean z4 = true;
                long j3 = -1;
                long j4 = DateFormattingKt.MAX_DATE;
                while (i < length) {
                    int delimiterOffset = _UtilCommonKt.delimiterOffset(setCookie, ';', i, length);
                    int delimiterOffset2 = _UtilCommonKt.delimiterOffset(setCookie, '=', i, delimiterOffset);
                    String trimSubstring2 = _UtilCommonKt.trimSubstring(setCookie, i, delimiterOffset2);
                    if (delimiterOffset2 < delimiterOffset) {
                        str = _UtilCommonKt.trimSubstring(setCookie, delimiterOffset2 + 1, delimiterOffset);
                    } else {
                        str = "";
                    }
                    Cookie cookie2 = cookie;
                    if (StringsKt.equals(trimSubstring2, "expires", true)) {
                        try {
                            j4 = parseExpires(str, 0, str.length());
                        } catch (NumberFormatException | IllegalArgumentException unused) {
                        }
                    } else if (StringsKt.equals(trimSubstring2, "max-age", true)) {
                        j3 = parseMaxAge(str);
                    } else {
                        if (StringsKt.equals(trimSubstring2, "domain", true)) {
                            str2 = parseDomain(str);
                            z4 = false;
                        } else if (StringsKt.equals(trimSubstring2, "path", true)) {
                            str3 = str;
                        } else if (StringsKt.equals(trimSubstring2, "secure", true)) {
                            z3 = true;
                        } else if (StringsKt.equals(trimSubstring2, "httponly", true)) {
                            z = true;
                        } else if (StringsKt.equals(trimSubstring2, "samesite", true)) {
                            str4 = str;
                        }
                        i = delimiterOffset + 1;
                        cookie = cookie2;
                    }
                    z2 = true;
                    i = delimiterOffset + 1;
                    cookie = cookie2;
                }
                Cookie cookie3 = cookie;
                if (j3 == Long.MIN_VALUE) {
                    j2 = Long.MIN_VALUE;
                } else if (j3 != -1) {
                    long j5 = j + (j3 <= 9223372036854775L ? j3 * 1000 : Long.MAX_VALUE);
                    j2 = (j5 < j || j5 > DateFormattingKt.MAX_DATE) ? 253402300799999L : j5;
                } else {
                    j2 = j4;
                }
                String host = url.host();
                if (str2 == null) {
                    str2 = host;
                } else if (!domainMatch(host, str2)) {
                    return cookie3;
                }
                if (host.length() == str2.length() || PublicSuffixDatabase.Companion.get().getEffectiveTldPlusOne(str2) != null) {
                    String str5 = RemoteSettings.FORWARD_SLASH_STRING;
                    if (str3 == null || !StringsKt.startsWith$default(str3, RemoteSettings.FORWARD_SLASH_STRING, false, 2, (Object) cookie3)) {
                        String encodedPath = url.encodedPath();
                        int lastIndexOf$default = StringsKt.lastIndexOf$default((CharSequence) encodedPath, '/', 0, false, 6, (Object) null);
                        if (lastIndexOf$default != 0) {
                            str5 = encodedPath.substring(0, lastIndexOf$default);
                            Intrinsics.checkNotNullExpressionValue(str5, "substring(...)");
                        }
                        str3 = str5;
                    }
                    return new Cookie(trimSubstring$default, trimSubstring, j2, str2, str3, z3, z, z2, z4, str4, null);
                }
                return cookie3;
            }
            return null;
        }

        private final long parseExpires(String str, int i, int i2) {
            int dateCharacterOffset = dateCharacterOffset(str, i, i2, false);
            Matcher matcher = Cookie.TIME_PATTERN.matcher(str);
            int i3 = -1;
            int i4 = -1;
            int i5 = -1;
            int i6 = -1;
            int i7 = -1;
            int i8 = -1;
            while (dateCharacterOffset < i2) {
                int dateCharacterOffset2 = dateCharacterOffset(str, dateCharacterOffset + 1, i2, true);
                matcher.region(dateCharacterOffset, dateCharacterOffset2);
                if (i4 != -1 || !matcher.usePattern(Cookie.TIME_PATTERN).matches()) {
                    if (i5 != -1 || !matcher.usePattern(Cookie.DAY_OF_MONTH_PATTERN).matches()) {
                        if (i6 != -1 || !matcher.usePattern(Cookie.MONTH_PATTERN).matches()) {
                            if (i3 == -1 && matcher.usePattern(Cookie.YEAR_PATTERN).matches()) {
                                String group = matcher.group(1);
                                Intrinsics.checkNotNullExpressionValue(group, "group(...)");
                                i3 = Integer.parseInt(group);
                            }
                        } else {
                            String group2 = matcher.group(1);
                            Intrinsics.checkNotNullExpressionValue(group2, "group(...)");
                            Locale US = Locale.US;
                            Intrinsics.checkNotNullExpressionValue(US, "US");
                            String lowerCase = group2.toLowerCase(US);
                            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                            String pattern = Cookie.MONTH_PATTERN.pattern();
                            Intrinsics.checkNotNullExpressionValue(pattern, "pattern(...)");
                            i6 = StringsKt.indexOf$default((CharSequence) pattern, lowerCase, 0, false, 6, (Object) null) / 4;
                        }
                    } else {
                        String group3 = matcher.group(1);
                        Intrinsics.checkNotNullExpressionValue(group3, "group(...)");
                        i5 = Integer.parseInt(group3);
                    }
                } else {
                    String group4 = matcher.group(1);
                    Intrinsics.checkNotNullExpressionValue(group4, "group(...)");
                    i4 = Integer.parseInt(group4);
                    String group5 = matcher.group(2);
                    Intrinsics.checkNotNullExpressionValue(group5, "group(...)");
                    i7 = Integer.parseInt(group5);
                    String group6 = matcher.group(3);
                    Intrinsics.checkNotNullExpressionValue(group6, "group(...)");
                    i8 = Integer.parseInt(group6);
                }
                dateCharacterOffset = dateCharacterOffset(str, dateCharacterOffset2 + 1, i2, false);
            }
            if (70 <= i3 && i3 < 100) {
                i3 += 1900;
            }
            if (i3 >= 0 && i3 < 70) {
                i3 += 2000;
            }
            if (i3 >= 1601) {
                if (i6 != -1) {
                    if (1 > i5 || i5 >= 32) {
                        throw new IllegalArgumentException("Failed requirement.".toString());
                    }
                    if (i4 < 0 || i4 >= 24) {
                        throw new IllegalArgumentException("Failed requirement.".toString());
                    }
                    if (i7 < 0 || i7 >= 60) {
                        throw new IllegalArgumentException("Failed requirement.".toString());
                    }
                    if (i8 < 0 || i8 >= 60) {
                        throw new IllegalArgumentException("Failed requirement.".toString());
                    }
                    GregorianCalendar gregorianCalendar = new GregorianCalendar(_UtilJvmKt.UTC);
                    gregorianCalendar.setLenient(false);
                    gregorianCalendar.set(1, i3);
                    gregorianCalendar.set(2, i6 - 1);
                    gregorianCalendar.set(5, i5);
                    gregorianCalendar.set(11, i4);
                    gregorianCalendar.set(12, i7);
                    gregorianCalendar.set(13, i8);
                    gregorianCalendar.set(14, 0);
                    return gregorianCalendar.getTimeInMillis();
                }
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }

        private final int dateCharacterOffset(String str, int i, int i2, boolean z) {
            while (i < i2) {
                char charAt = str.charAt(i);
                if (((charAt < ' ' && charAt != '\t') || charAt >= 127 || ('0' <= charAt && charAt < ':') || (('a' <= charAt && charAt < '{') || (('A' <= charAt && charAt < '[') || charAt == ':'))) == (!z)) {
                    return i;
                }
                i++;
            }
            return i2;
        }

        private final long parseMaxAge(String str) {
            try {
                long parseLong = Long.parseLong(str);
                if (parseLong <= 0) {
                    return Long.MIN_VALUE;
                }
                return parseLong;
            } catch (NumberFormatException e) {
                if (new Regex("-?\\d+").matches(str)) {
                    return StringsKt.startsWith$default(str, Constants.FILENAME_SEQUENCE_SEPARATOR, false, 2, (Object) null) ? Long.MIN_VALUE : Long.MAX_VALUE;
                }
                throw e;
            }
        }

        private final String parseDomain(String str) {
            if (StringsKt.endsWith$default(str, ".", false, 2, (Object) null)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            String canonicalHost = _HostnamesCommonKt.toCanonicalHost(StringsKt.removePrefix(str, (CharSequence) "."));
            if (canonicalHost != null) {
                return canonicalHost;
            }
            throw new IllegalArgumentException();
        }

        @JvmStatic
        public final List<Cookie> parseAll(HttpUrl url, Headers headers) {
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(headers, "headers");
            List<String> values = headers.values(HttpHeaders.SET_COOKIE);
            int size = values.size();
            List<Cookie> list = null;
            ArrayList arrayList = null;
            for (int i = 0; i < size; i++) {
                Cookie parse = parse(url, values.get(i));
                if (parse != null) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(parse);
                }
            }
            if (arrayList != null) {
                list = Collections.unmodifiableList(arrayList);
                Intrinsics.checkNotNullExpressionValue(list, "unmodifiableList(...)");
            }
            return list == null ? CollectionsKt.emptyList() : list;
        }
    }
}
