package okhttp3;

import androidx.autofill.HintConstants;
import androidx.compose.material3.MenuKt;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.adjust.sdk.Constants;
import com.google.android.gms.actions.SearchIntents;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.sessions.settings.RemoteSettings;
import io.appmetrica.analytics.BuildConfig;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import okhttp3.internal._HostnamesCommonKt;
import okhttp3.internal._UtilCommonKt;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
import okhttp3.internal.url._UrlKt;
/* compiled from: HttpUrl.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\"\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u001b\u0018\u0000 K2\u00020\u0001:\u0002JKBc\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n\u0012\u0010\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\n\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0016\u001a\u00020\u0017H\u0007¢\u0006\u0002\b\rJ\r\u0010\u0018\u001a\u00020\u0019H\u0007¢\u0006\u0002\b\u001aJ\u0010\u0010#\u001a\u0004\u0018\u00010\u00032\u0006\u0010$\u001a\u00020\u0003J\u0016\u0010(\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\n2\u0006\u0010$\u001a\u00020\u0003J\u000e\u0010)\u001a\u00020\u00032\u0006\u0010*\u001a\u00020\bJ\u0010\u0010+\u001a\u0004\u0018\u00010\u00032\u0006\u0010*\u001a\u00020\bJ\u0006\u0010-\u001a\u00020\u0003J\u0010\u0010.\u001a\u0004\u0018\u00010\u00002\u0006\u0010/\u001a\u00020\u0003J\u0006\u00100\u001a\u000201J\u0010\u00100\u001a\u0004\u0018\u0001012\u0006\u0010/\u001a\u00020\u0003J\u0013\u00102\u001a\u00020\u00142\b\u00103\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u00104\u001a\u00020\bH\u0016J\b\u00105\u001a\u00020\u0003H\u0016J\b\u00106\u001a\u0004\u0018\u00010\u0003J\r\u0010\r\u001a\u00020\u0017H\u0007¢\u0006\u0002\b7J\r\u0010\u001a\u001a\u00020\u0019H\u0007¢\u0006\u0002\b8J\r\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\b9J\r\u0010\u001b\u001a\u00020\u0003H\u0007¢\u0006\u0002\b:J\r\u0010\u0004\u001a\u00020\u0003H\u0007¢\u0006\u0002\b;J\r\u0010\u001c\u001a\u00020\u0003H\u0007¢\u0006\u0002\b<J\r\u0010\u0005\u001a\u00020\u0003H\u0007¢\u0006\u0002\b=J\r\u0010\u0006\u001a\u00020\u0003H\u0007¢\u0006\u0002\b>J\r\u0010\u0007\u001a\u00020\bH\u0007¢\u0006\u0002\b?J\r\u0010\u001d\u001a\u00020\bH\u0007¢\u0006\u0002\b@J\r\u0010\u001e\u001a\u00020\u0003H\u0007¢\u0006\u0002\bAJ\u0013\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00030\nH\u0007¢\u0006\u0002\bBJ\u0013\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\nH\u0007¢\u0006\u0002\bCJ\u000f\u0010 \u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0002\bDJ\u000f\u0010!\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0002\bEJ\r\u0010\"\u001a\u00020\bH\u0007¢\u0006\u0002\bFJ\u0013\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00030&H\u0007¢\u0006\u0002\bGJ\u000f\u0010,\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0002\bHJ\u000f\u0010\f\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0002\bIR\u0013\u0010\u0002\u001a\u00020\u00038G¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0010R\u0013\u0010\u0004\u001a\u00020\u00038G¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0010R\u0013\u0010\u0005\u001a\u00020\u00038G¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0010R\u0013\u0010\u0006\u001a\u00020\u00038G¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0010R\u0013\u0010\u0007\u001a\u00020\b8G¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0011R\u0019\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n8G¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0012R\u0018\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0015\u0010\f\u001a\u0004\u0018\u00010\u00038G¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0010R\u000e\u0010\r\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0013\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0015R\u0011\u0010\u001b\u001a\u00020\u00038G¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0010R\u0011\u0010\u001c\u001a\u00020\u00038G¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0010R\u0011\u0010\u001d\u001a\u00020\b8G¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0011R\u0011\u0010\u001e\u001a\u00020\u00038G¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u0010R\u0017\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00030\n8G¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0012R\u0013\u0010 \u001a\u0004\u0018\u00010\u00038G¢\u0006\u0006\u001a\u0004\b \u0010\u0010R\u0013\u0010!\u001a\u0004\u0018\u00010\u00038G¢\u0006\u0006\u001a\u0004\b!\u0010\u0010R\u0011\u0010\"\u001a\u00020\b8G¢\u0006\u0006\u001a\u0004\b\"\u0010\u0011R\u0017\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00030&8G¢\u0006\u0006\u001a\u0004\b%\u0010'R\u0013\u0010,\u001a\u0004\u0018\u00010\u00038G¢\u0006\u0006\u001a\u0004\b,\u0010\u0010¨\u0006L"}, d2 = {"Lokhttp3/HttpUrl;", "", "scheme", "", HintConstants.AUTOFILL_HINT_USERNAME, HintConstants.AUTOFILL_HINT_PASSWORD, "host", "port", "", "pathSegments", "", "queryNamesAndValues", "fragment", "url", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "()Ljava/lang/String;", "()I", "()Ljava/util/List;", "isHttps", "", "()Z", "toUrl", "Ljava/net/URL;", "toUri", "Ljava/net/URI;", "uri", "encodedUsername", "encodedPassword", "pathSize", "encodedPath", "encodedPathSegments", "encodedQuery", SearchIntents.EXTRA_QUERY, "querySize", "queryParameter", "name", "queryParameterNames", "", "()Ljava/util/Set;", "queryParameterValues", "queryParameterName", FirebaseAnalytics.Param.INDEX, "queryParameterValue", "encodedFragment", "redact", "resolve", "link", "newBuilder", "Lokhttp3/HttpUrl$Builder;", "equals", "other", "hashCode", "toString", "topPrivateDomain", "-deprecated_url", "-deprecated_uri", "-deprecated_scheme", "-deprecated_encodedUsername", "-deprecated_username", "-deprecated_encodedPassword", "-deprecated_password", "-deprecated_host", "-deprecated_port", "-deprecated_pathSize", "-deprecated_encodedPath", "-deprecated_encodedPathSegments", "-deprecated_pathSegments", "-deprecated_encodedQuery", "-deprecated_query", "-deprecated_querySize", "-deprecated_queryParameterNames", "-deprecated_encodedFragment", "-deprecated_fragment", "Builder", "Companion", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class HttpUrl {
    public static final Companion Companion = new Companion(null);
    private final String fragment;
    private final String host;
    private final String password;
    private final List<String> pathSegments;
    private final int port;
    private final List<String> queryNamesAndValues;
    private final String scheme;
    private final String url;
    private final String username;

    public /* synthetic */ HttpUrl(String str, String str2, String str3, String str4, int i, List list, List list2, String str5, String str6, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, i, list, list2, str5, str6);
    }

    @JvmStatic
    public static final int defaultPort(String str) {
        return Companion.defaultPort(str);
    }

    @JvmStatic
    public static final HttpUrl get(String str) {
        return Companion.get(str);
    }

    @JvmStatic
    public static final HttpUrl get(URI uri) {
        return Companion.get(uri);
    }

    @JvmStatic
    public static final HttpUrl get(URL url) {
        return Companion.get(url);
    }

    @JvmStatic
    public static final HttpUrl parse(String str) {
        return Companion.parse(str);
    }

    private HttpUrl(String str, String str2, String str3, String str4, int i, List<String> list, List<String> list2, String str5, String str6) {
        this.scheme = str;
        this.username = str2;
        this.password = str3;
        this.host = str4;
        this.port = i;
        this.pathSegments = list;
        this.queryNamesAndValues = list2;
        this.fragment = str5;
        this.url = str6;
    }

    public final String scheme() {
        return this.scheme;
    }

    public final String username() {
        return this.username;
    }

    public final String password() {
        return this.password;
    }

    public final String host() {
        return this.host;
    }

    public final int port() {
        return this.port;
    }

    public final List<String> pathSegments() {
        return this.pathSegments;
    }

    public final String fragment() {
        return this.fragment;
    }

    public final boolean isHttps() {
        return Intrinsics.areEqual(this.scheme, Constants.SCHEME);
    }

    public final URL url() {
        try {
            return new URL(this.url);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public final URI uri() {
        String builder = newBuilder().reencodeForUri$okhttp().toString();
        try {
            return new URI(builder);
        } catch (URISyntaxException e) {
            try {
                URI create = URI.create(new Regex("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]").replace(builder, ""));
                Intrinsics.checkNotNull(create);
                return create;
            } catch (Exception unused) {
                throw new RuntimeException(e);
            }
        }
    }

    public final String encodedUsername() {
        if (this.username.length() == 0) {
            return "";
        }
        int length = this.scheme.length() + 3;
        String str = this.url;
        String substring = this.url.substring(length, _UtilCommonKt.delimiterOffset(str, ":@", length, str.length()));
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        return substring;
    }

    public final String encodedPassword() {
        if (this.password.length() == 0) {
            return "";
        }
        int indexOf$default = StringsKt.indexOf$default((CharSequence) this.url, '@', 0, false, 6, (Object) null);
        String substring = this.url.substring(StringsKt.indexOf$default((CharSequence) this.url, (char) AbstractJsonLexerKt.COLON, this.scheme.length() + 3, false, 4, (Object) null) + 1, indexOf$default);
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        return substring;
    }

    public final int pathSize() {
        return this.pathSegments.size();
    }

    public final String encodedPath() {
        int indexOf$default = StringsKt.indexOf$default((CharSequence) this.url, '/', this.scheme.length() + 3, false, 4, (Object) null);
        String str = this.url;
        String substring = this.url.substring(indexOf$default, _UtilCommonKt.delimiterOffset(str, "?#", indexOf$default, str.length()));
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        return substring;
    }

    public final List<String> encodedPathSegments() {
        int indexOf$default = StringsKt.indexOf$default((CharSequence) this.url, '/', this.scheme.length() + 3, false, 4, (Object) null);
        String str = this.url;
        int delimiterOffset = _UtilCommonKt.delimiterOffset(str, "?#", indexOf$default, str.length());
        ArrayList arrayList = new ArrayList();
        while (indexOf$default < delimiterOffset) {
            int i = indexOf$default + 1;
            int delimiterOffset2 = _UtilCommonKt.delimiterOffset(this.url, '/', i, delimiterOffset);
            String substring = this.url.substring(i, delimiterOffset2);
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            arrayList.add(substring);
            indexOf$default = delimiterOffset2;
        }
        return arrayList;
    }

    public final String encodedQuery() {
        if (this.queryNamesAndValues == null) {
            return null;
        }
        int indexOf$default = StringsKt.indexOf$default((CharSequence) this.url, '?', 0, false, 6, (Object) null) + 1;
        String str = this.url;
        String substring = this.url.substring(indexOf$default, _UtilCommonKt.delimiterOffset(str, '#', indexOf$default, str.length()));
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        return substring;
    }

    public final String query() {
        if (this.queryNamesAndValues == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        Companion.toQueryString(this.queryNamesAndValues, sb);
        return sb.toString();
    }

    public final int querySize() {
        List<String> list = this.queryNamesAndValues;
        if (list != null) {
            return list.size() / 2;
        }
        return 0;
    }

    public final String queryParameter(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        List<String> list = this.queryNamesAndValues;
        if (list == null) {
            return null;
        }
        IntProgression step = RangesKt.step(RangesKt.until(0, list.size()), 2);
        int first = step.getFirst();
        int last = step.getLast();
        int step2 = step.getStep();
        if ((step2 > 0 && first <= last) || (step2 < 0 && last <= first)) {
            while (!Intrinsics.areEqual(name, this.queryNamesAndValues.get(first))) {
                if (first != last) {
                    first += step2;
                }
            }
            return this.queryNamesAndValues.get(first + 1);
        }
        return null;
    }

    public final Set<String> queryParameterNames() {
        if (this.queryNamesAndValues == null) {
            return SetsKt.emptySet();
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(this.queryNamesAndValues.size() / 2, 1.0f);
        IntProgression step = RangesKt.step(RangesKt.until(0, this.queryNamesAndValues.size()), 2);
        int first = step.getFirst();
        int last = step.getLast();
        int step2 = step.getStep();
        if ((step2 > 0 && first <= last) || (step2 < 0 && last <= first)) {
            while (true) {
                String str = this.queryNamesAndValues.get(first);
                Intrinsics.checkNotNull(str);
                linkedHashSet.add(str);
                if (first == last) {
                    break;
                }
                first += step2;
            }
        }
        Set<String> unmodifiableSet = Collections.unmodifiableSet(linkedHashSet);
        Intrinsics.checkNotNullExpressionValue(unmodifiableSet, "unmodifiableSet(...)");
        return unmodifiableSet;
    }

    public final List<String> queryParameterValues(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        if (this.queryNamesAndValues == null) {
            return CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList(4);
        IntProgression step = RangesKt.step(RangesKt.until(0, this.queryNamesAndValues.size()), 2);
        int first = step.getFirst();
        int last = step.getLast();
        int step2 = step.getStep();
        if ((step2 > 0 && first <= last) || (step2 < 0 && last <= first)) {
            while (true) {
                if (Intrinsics.areEqual(name, this.queryNamesAndValues.get(first))) {
                    arrayList.add(this.queryNamesAndValues.get(first + 1));
                }
                if (first == last) {
                    break;
                }
                first += step2;
            }
        }
        List<String> unmodifiableList = Collections.unmodifiableList(arrayList);
        Intrinsics.checkNotNullExpressionValue(unmodifiableList, "unmodifiableList(...)");
        return unmodifiableList;
    }

    public final String queryParameterName(int i) {
        List<String> list = this.queryNamesAndValues;
        if (list == null) {
            throw new IndexOutOfBoundsException();
        }
        String str = list.get(i * 2);
        Intrinsics.checkNotNull(str);
        return str;
    }

    public final String queryParameterValue(int i) {
        List<String> list = this.queryNamesAndValues;
        if (list == null) {
            throw new IndexOutOfBoundsException();
        }
        return list.get((i * 2) + 1);
    }

    public final String encodedFragment() {
        if (this.fragment == null) {
            return null;
        }
        String substring = this.url.substring(StringsKt.indexOf$default((CharSequence) this.url, '#', 0, false, 6, (Object) null) + 1);
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        return substring;
    }

    public final String redact() {
        Builder newBuilder = newBuilder("/...");
        Intrinsics.checkNotNull(newBuilder);
        return newBuilder.username("").password("").build().toString();
    }

    public final HttpUrl resolve(String link) {
        Intrinsics.checkNotNullParameter(link, "link");
        Builder newBuilder = newBuilder(link);
        if (newBuilder != null) {
            return newBuilder.build();
        }
        return null;
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        builder.setScheme$okhttp(this.scheme);
        builder.setEncodedUsername$okhttp(encodedUsername());
        builder.setEncodedPassword$okhttp(encodedPassword());
        builder.setHost$okhttp(this.host);
        builder.setPort$okhttp(this.port != Companion.defaultPort(this.scheme) ? this.port : -1);
        builder.getEncodedPathSegments$okhttp().clear();
        builder.getEncodedPathSegments$okhttp().addAll(encodedPathSegments());
        builder.encodedQuery(encodedQuery());
        builder.setEncodedFragment$okhttp(encodedFragment());
        return builder;
    }

    public final Builder newBuilder(String link) {
        Intrinsics.checkNotNullParameter(link, "link");
        try {
            return new Builder().parse$okhttp(this, link);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof HttpUrl) && Intrinsics.areEqual(((HttpUrl) obj).url, this.url);
    }

    public int hashCode() {
        return this.url.hashCode();
    }

    public String toString() {
        return this.url;
    }

    public final String topPrivateDomain() {
        if (_HostnamesCommonKt.canParseAsIpAddress(this.host)) {
            return null;
        }
        return PublicSuffixDatabase.Companion.get().getEffectiveTldPlusOne(this.host);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to toUrl()", replaceWith = @ReplaceWith(expression = "toUrl()", imports = {}))
    /* renamed from: -deprecated_url  reason: not valid java name */
    public final URL m10298deprecated_url() {
        return url();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to toUri()", replaceWith = @ReplaceWith(expression = "toUri()", imports = {}))
    /* renamed from: -deprecated_uri  reason: not valid java name */
    public final URI m10297deprecated_uri() {
        return uri();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "scheme", imports = {}))
    /* renamed from: -deprecated_scheme  reason: not valid java name */
    public final String m10296deprecated_scheme() {
        return this.scheme;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "encodedUsername", imports = {}))
    /* renamed from: -deprecated_encodedUsername  reason: not valid java name */
    public final String m10286deprecated_encodedUsername() {
        return encodedUsername();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = HintConstants.AUTOFILL_HINT_USERNAME, imports = {}))
    /* renamed from: -deprecated_username  reason: not valid java name */
    public final String m10299deprecated_username() {
        return this.username;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "encodedPassword", imports = {}))
    /* renamed from: -deprecated_encodedPassword  reason: not valid java name */
    public final String m10282deprecated_encodedPassword() {
        return encodedPassword();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = HintConstants.AUTOFILL_HINT_PASSWORD, imports = {}))
    /* renamed from: -deprecated_password  reason: not valid java name */
    public final String m10289deprecated_password() {
        return this.password;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "host", imports = {}))
    /* renamed from: -deprecated_host  reason: not valid java name */
    public final String m10288deprecated_host() {
        return this.host;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "port", imports = {}))
    /* renamed from: -deprecated_port  reason: not valid java name */
    public final int m10292deprecated_port() {
        return this.port;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "pathSize", imports = {}))
    /* renamed from: -deprecated_pathSize  reason: not valid java name */
    public final int m10291deprecated_pathSize() {
        return pathSize();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "encodedPath", imports = {}))
    /* renamed from: -deprecated_encodedPath  reason: not valid java name */
    public final String m10283deprecated_encodedPath() {
        return encodedPath();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "encodedPathSegments", imports = {}))
    /* renamed from: -deprecated_encodedPathSegments  reason: not valid java name */
    public final List<String> m10284deprecated_encodedPathSegments() {
        return encodedPathSegments();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "pathSegments", imports = {}))
    /* renamed from: -deprecated_pathSegments  reason: not valid java name */
    public final List<String> m10290deprecated_pathSegments() {
        return this.pathSegments;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "encodedQuery", imports = {}))
    /* renamed from: -deprecated_encodedQuery  reason: not valid java name */
    public final String m10285deprecated_encodedQuery() {
        return encodedQuery();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = SearchIntents.EXTRA_QUERY, imports = {}))
    /* renamed from: -deprecated_query  reason: not valid java name */
    public final String m10293deprecated_query() {
        return query();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "querySize", imports = {}))
    /* renamed from: -deprecated_querySize  reason: not valid java name */
    public final int m10295deprecated_querySize() {
        return querySize();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "queryParameterNames", imports = {}))
    /* renamed from: -deprecated_queryParameterNames  reason: not valid java name */
    public final Set<String> m10294deprecated_queryParameterNames() {
        return queryParameterNames();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "encodedFragment", imports = {}))
    /* renamed from: -deprecated_encodedFragment  reason: not valid java name */
    public final String m10281deprecated_encodedFragment() {
        return encodedFragment();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "fragment", imports = {}))
    /* renamed from: -deprecated_fragment  reason: not valid java name */
    public final String m10287deprecated_fragment() {
        return this.fragment;
    }

    /* compiled from: HttpUrl.kt */
    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0005J\u000e\u0010$\u001a\u00020\u00002\u0006\u0010$\u001a\u00020\u0005J\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0005J\u000e\u0010%\u001a\u00020\u00002\u0006\u0010%\u001a\u00020\u0005J\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u0005J\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0005J\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010&\u001a\u00020\u00002\u0006\u0010'\u001a\u00020\u0005J\u000e\u0010(\u001a\u00020\u00002\u0006\u0010)\u001a\u00020\u0005J\u000e\u0010*\u001a\u00020\u00002\u0006\u0010+\u001a\u00020\u0005J\u000e\u0010,\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0005J\u0018\u0010(\u001a\u00020\u00002\u0006\u0010)\u001a\u00020\u00052\u0006\u0010-\u001a\u00020.H\u0002J\u0016\u0010/\u001a\u00020\u00002\u0006\u00100\u001a\u00020\u00142\u0006\u0010'\u001a\u00020\u0005J\u0016\u00101\u001a\u00020\u00002\u0006\u00100\u001a\u00020\u00142\u0006\u0010+\u001a\u00020\u0005J\u000e\u00102\u001a\u00020\u00002\u0006\u00100\u001a\u00020\u0014J\u000e\u00103\u001a\u00020\u00002\u0006\u00103\u001a\u00020\u0005J\u0010\u00104\u001a\u00020\u00002\b\u00104\u001a\u0004\u0018\u00010\u0005J\u0010\u00105\u001a\u00020\u00002\b\u00105\u001a\u0004\u0018\u00010\u0005J\u0018\u00106\u001a\u00020\u00002\u0006\u00107\u001a\u00020\u00052\b\u00108\u001a\u0004\u0018\u00010\u0005J\u0018\u00109\u001a\u00020\u00002\u0006\u0010:\u001a\u00020\u00052\b\u0010;\u001a\u0004\u0018\u00010\u0005J\u0018\u0010<\u001a\u00020\u00002\u0006\u00107\u001a\u00020\u00052\b\u00108\u001a\u0004\u0018\u00010\u0005J\u0018\u0010=\u001a\u00020\u00002\u0006\u0010:\u001a\u00020\u00052\b\u0010;\u001a\u0004\u0018\u00010\u0005J\u000e\u0010>\u001a\u00020\u00002\u0006\u00107\u001a\u00020\u0005J\u000e\u0010?\u001a\u00020\u00002\u0006\u0010:\u001a\u00020\u0005J\u0010\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020\u0005H\u0002J\u0010\u0010C\u001a\u00020\u00002\b\u0010C\u001a\u0004\u0018\u00010\u0005J\u0010\u0010!\u001a\u00020\u00002\b\u0010!\u001a\u0004\u0018\u00010\u0005J\r\u0010D\u001a\u00020\u0000H\u0000¢\u0006\u0002\bEJ\u0006\u0010F\u001a\u00020GJ\b\u0010H\u001a\u00020\u0014H\u0002J\b\u0010I\u001a\u00020\u0005H\u0016J\u001e\u0010J\u001a\u00020A*\b\u0012\u0004\u0012\u00020\u00050K2\n\u0010L\u001a\u00060Mj\u0002`NH\u0002J\u001f\u0010O\u001a\u00020\u00002\b\u0010P\u001a\u0004\u0018\u00010G2\u0006\u0010Q\u001a\u00020\u0005H\u0000¢\u0006\u0002\bRJ \u0010S\u001a\u00020A2\u0006\u0010Q\u001a\u00020\u00052\u0006\u0010T\u001a\u00020\u00142\u0006\u0010U\u001a\u00020\u0014H\u0002J0\u0010V\u001a\u00020A2\u0006\u0010Q\u001a\u00020\u00052\u0006\u0010W\u001a\u00020\u00142\u0006\u0010U\u001a\u00020\u00142\u0006\u0010X\u001a\u00020.2\u0006\u0010-\u001a\u00020.H\u0002J\b\u0010Y\u001a\u00020AH\u0002J\u0010\u0010Z\u001a\u00020.2\u0006\u0010Q\u001a\u00020\u0005H\u0002J\u0010\u0010[\u001a\u00020.2\u0006\u0010Q\u001a\u00020\u0005H\u0002J\u0014\u0010\\\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u001a*\u00020\u0005H\u0002J \u0010]\u001a\u00020\u00142\u0006\u0010Q\u001a\u00020\u00052\u0006\u0010W\u001a\u00020\u00142\u0006\u0010U\u001a\u00020\u0014H\u0002J\u001c\u0010^\u001a\u00020\u0014*\u00020\u00052\u0006\u0010W\u001a\u00020\u00142\u0006\u0010U\u001a\u00020\u0014H\u0002J \u0010_\u001a\u00020\u00142\u0006\u0010Q\u001a\u00020\u00052\u0006\u0010W\u001a\u00020\u00142\u0006\u0010U\u001a\u00020\u0014H\u0002J \u0010`\u001a\u00020\u00142\u0006\u0010Q\u001a\u00020\u00052\u0006\u0010W\u001a\u00020\u00142\u0006\u0010U\u001a\u00020\u0014H\u0002R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001a\u0010\u0013\u001a\u00020\u0014X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00050\u001aX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR$\u0010\u001d\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u001aX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001c\"\u0004\b\u001f\u0010 R\u001c\u0010!\u001a\u0004\u0018\u00010\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0007\"\u0004\b#\u0010\t¨\u0006a"}, d2 = {"Lokhttp3/HttpUrl$Builder;", "", "<init>", "()V", "scheme", "", "getScheme$okhttp", "()Ljava/lang/String;", "setScheme$okhttp", "(Ljava/lang/String;)V", "encodedUsername", "getEncodedUsername$okhttp", "setEncodedUsername$okhttp", "encodedPassword", "getEncodedPassword$okhttp", "setEncodedPassword$okhttp", "host", "getHost$okhttp", "setHost$okhttp", "port", "", "getPort$okhttp", "()I", "setPort$okhttp", "(I)V", "encodedPathSegments", "", "getEncodedPathSegments$okhttp", "()Ljava/util/List;", "encodedQueryNamesAndValues", "getEncodedQueryNamesAndValues$okhttp", "setEncodedQueryNamesAndValues$okhttp", "(Ljava/util/List;)V", "encodedFragment", "getEncodedFragment$okhttp", "setEncodedFragment$okhttp", HintConstants.AUTOFILL_HINT_USERNAME, HintConstants.AUTOFILL_HINT_PASSWORD, "addPathSegment", "pathSegment", "addPathSegments", "pathSegments", "addEncodedPathSegment", "encodedPathSegment", "addEncodedPathSegments", "alreadyEncoded", "", "setPathSegment", FirebaseAnalytics.Param.INDEX, "setEncodedPathSegment", "removePathSegment", "encodedPath", SearchIntents.EXTRA_QUERY, "encodedQuery", "addQueryParameter", "name", "value", "addEncodedQueryParameter", "encodedName", "encodedValue", "setQueryParameter", "setEncodedQueryParameter", "removeAllQueryParameters", "removeAllEncodedQueryParameters", "removeAllCanonicalQueryParameters", "", "canonicalName", "fragment", "reencodeForUri", "reencodeForUri$okhttp", "build", "Lokhttp3/HttpUrl;", "effectivePort", "toString", "toPathString", "", "out", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "parse", TtmlNode.RUBY_BASE, "input", "parse$okhttp", "resolvePath", "startPos", "limit", Constants.PUSH, "pos", "addTrailingSlash", "pop", "isDot", "isDotDot", "toQueryNamesAndValues", "schemeDelimiterOffset", "slashCount", "portColonOffset", "parsePort", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Builder {
        private String encodedFragment;
        private List<String> encodedQueryNamesAndValues;
        private String host;
        private String scheme;
        private String encodedUsername = "";
        private String encodedPassword = "";
        private int port = -1;
        private final List<String> encodedPathSegments = CollectionsKt.mutableListOf("");

        public final String getScheme$okhttp() {
            return this.scheme;
        }

        public final void setScheme$okhttp(String str) {
            this.scheme = str;
        }

        public final String getEncodedUsername$okhttp() {
            return this.encodedUsername;
        }

        public final void setEncodedUsername$okhttp(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.encodedUsername = str;
        }

        public final String getEncodedPassword$okhttp() {
            return this.encodedPassword;
        }

        public final void setEncodedPassword$okhttp(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.encodedPassword = str;
        }

        public final String getHost$okhttp() {
            return this.host;
        }

        public final void setHost$okhttp(String str) {
            this.host = str;
        }

        public final int getPort$okhttp() {
            return this.port;
        }

        public final void setPort$okhttp(int i) {
            this.port = i;
        }

        public final List<String> getEncodedPathSegments$okhttp() {
            return this.encodedPathSegments;
        }

        public final List<String> getEncodedQueryNamesAndValues$okhttp() {
            return this.encodedQueryNamesAndValues;
        }

        public final void setEncodedQueryNamesAndValues$okhttp(List<String> list) {
            this.encodedQueryNamesAndValues = list;
        }

        public final String getEncodedFragment$okhttp() {
            return this.encodedFragment;
        }

        public final void setEncodedFragment$okhttp(String str) {
            this.encodedFragment = str;
        }

        public final Builder scheme(String scheme) {
            Intrinsics.checkNotNullParameter(scheme, "scheme");
            if (StringsKt.equals(scheme, "http", true)) {
                this.scheme = "http";
                return this;
            } else if (StringsKt.equals(scheme, Constants.SCHEME, true)) {
                this.scheme = Constants.SCHEME;
                return this;
            } else {
                throw new IllegalArgumentException("unexpected scheme: " + scheme);
            }
        }

        public final Builder username(String username) {
            Intrinsics.checkNotNullParameter(username, "username");
            this.encodedUsername = _UrlKt.canonicalize$default(username, 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, 123, null);
            return this;
        }

        public final Builder encodedUsername(String encodedUsername) {
            Intrinsics.checkNotNullParameter(encodedUsername, "encodedUsername");
            this.encodedUsername = _UrlKt.canonicalize$default(encodedUsername, 0, 0, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, BuildConfig.API_LEVEL, null);
            return this;
        }

        public final Builder password(String password) {
            Intrinsics.checkNotNullParameter(password, "password");
            this.encodedPassword = _UrlKt.canonicalize$default(password, 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, 123, null);
            return this;
        }

        public final Builder encodedPassword(String encodedPassword) {
            Intrinsics.checkNotNullParameter(encodedPassword, "encodedPassword");
            this.encodedPassword = _UrlKt.canonicalize$default(encodedPassword, 0, 0, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, BuildConfig.API_LEVEL, null);
            return this;
        }

        public final Builder host(String host) {
            Intrinsics.checkNotNullParameter(host, "host");
            String canonicalHost = _HostnamesCommonKt.toCanonicalHost(_UrlKt.percentDecode$default(host, 0, 0, false, 7, null));
            if (canonicalHost == null) {
                throw new IllegalArgumentException("unexpected host: " + host);
            }
            this.host = canonicalHost;
            return this;
        }

        public final Builder port(int i) {
            if (1 > i || i >= 65536) {
                throw new IllegalArgumentException(("unexpected port: " + i).toString());
            }
            this.port = i;
            return this;
        }

        public final Builder addPathSegment(String pathSegment) {
            Intrinsics.checkNotNullParameter(pathSegment, "pathSegment");
            push(pathSegment, 0, pathSegment.length(), false, false);
            return this;
        }

        public final Builder addPathSegments(String pathSegments) {
            Intrinsics.checkNotNullParameter(pathSegments, "pathSegments");
            return addPathSegments(pathSegments, false);
        }

        public final Builder addEncodedPathSegment(String encodedPathSegment) {
            Intrinsics.checkNotNullParameter(encodedPathSegment, "encodedPathSegment");
            push(encodedPathSegment, 0, encodedPathSegment.length(), false, true);
            return this;
        }

        public final Builder addEncodedPathSegments(String encodedPathSegments) {
            Intrinsics.checkNotNullParameter(encodedPathSegments, "encodedPathSegments");
            return addPathSegments(encodedPathSegments, true);
        }

        private final Builder addPathSegments(String str, boolean z) {
            boolean z2;
            Builder builder;
            String str2;
            boolean z3;
            int i = 0;
            while (true) {
                int delimiterOffset = _UtilCommonKt.delimiterOffset(str, "/\\", i, str.length());
                if (delimiterOffset < str.length()) {
                    z2 = true;
                    str2 = str;
                    z3 = z;
                    builder = this;
                } else {
                    z2 = false;
                    builder = this;
                    str2 = str;
                    z3 = z;
                }
                builder.push(str2, i, delimiterOffset, z2, z3);
                i = delimiterOffset + 1;
                if (i > str2.length()) {
                    return builder;
                }
                str = str2;
                z = z3;
            }
        }

        public final Builder setPathSegment(int i, String pathSegment) {
            Intrinsics.checkNotNullParameter(pathSegment, "pathSegment");
            String canonicalize$default = _UrlKt.canonicalize$default(pathSegment, 0, 0, _UrlKt.PATH_SEGMENT_ENCODE_SET, false, false, false, false, 123, null);
            if (isDot(canonicalize$default) || isDotDot(canonicalize$default)) {
                throw new IllegalArgumentException(("unexpected path segment: " + pathSegment).toString());
            }
            this.encodedPathSegments.set(i, canonicalize$default);
            return this;
        }

        public final Builder setEncodedPathSegment(int i, String encodedPathSegment) {
            Intrinsics.checkNotNullParameter(encodedPathSegment, "encodedPathSegment");
            String canonicalize$default = _UrlKt.canonicalize$default(encodedPathSegment, 0, 0, _UrlKt.PATH_SEGMENT_ENCODE_SET, true, false, false, false, BuildConfig.API_LEVEL, null);
            this.encodedPathSegments.set(i, canonicalize$default);
            if (isDot(canonicalize$default) || isDotDot(canonicalize$default)) {
                throw new IllegalArgumentException(("unexpected path segment: " + encodedPathSegment).toString());
            }
            return this;
        }

        public final Builder removePathSegment(int i) {
            this.encodedPathSegments.remove(i);
            if (this.encodedPathSegments.isEmpty()) {
                this.encodedPathSegments.add("");
            }
            return this;
        }

        public final Builder encodedPath(String encodedPath) {
            Intrinsics.checkNotNullParameter(encodedPath, "encodedPath");
            if (!StringsKt.startsWith$default(encodedPath, RemoteSettings.FORWARD_SLASH_STRING, false, 2, (Object) null)) {
                throw new IllegalArgumentException(("unexpected encodedPath: " + encodedPath).toString());
            }
            resolvePath(encodedPath, 0, encodedPath.length());
            return this;
        }

        public final Builder query(String str) {
            String canonicalize$default;
            this.encodedQueryNamesAndValues = (str == null || (canonicalize$default = _UrlKt.canonicalize$default(str, 0, 0, _UrlKt.QUERY_ENCODE_SET, false, false, true, false, 91, null)) == null) ? null : toQueryNamesAndValues(canonicalize$default);
            return this;
        }

        public final Builder encodedQuery(String str) {
            String canonicalize$default;
            this.encodedQueryNamesAndValues = (str == null || (canonicalize$default = _UrlKt.canonicalize$default(str, 0, 0, _UrlKt.QUERY_ENCODE_SET, true, false, true, false, 83, null)) == null) ? null : toQueryNamesAndValues(canonicalize$default);
            return this;
        }

        public final Builder addQueryParameter(String name, String str) {
            Intrinsics.checkNotNullParameter(name, "name");
            if (this.encodedQueryNamesAndValues == null) {
                this.encodedQueryNamesAndValues = new ArrayList();
            }
            List<String> list = this.encodedQueryNamesAndValues;
            Intrinsics.checkNotNull(list);
            list.add(_UrlKt.canonicalize$default(name, 0, 0, _UrlKt.QUERY_COMPONENT_ENCODE_SET, false, false, true, false, 91, null));
            List<String> list2 = this.encodedQueryNamesAndValues;
            Intrinsics.checkNotNull(list2);
            list2.add(str != null ? _UrlKt.canonicalize$default(str, 0, 0, _UrlKt.QUERY_COMPONENT_ENCODE_SET, false, false, true, false, 91, null) : null);
            return this;
        }

        public final Builder addEncodedQueryParameter(String encodedName, String str) {
            Intrinsics.checkNotNullParameter(encodedName, "encodedName");
            if (this.encodedQueryNamesAndValues == null) {
                this.encodedQueryNamesAndValues = new ArrayList();
            }
            List<String> list = this.encodedQueryNamesAndValues;
            Intrinsics.checkNotNull(list);
            list.add(_UrlKt.canonicalize$default(encodedName, 0, 0, _UrlKt.QUERY_COMPONENT_REENCODE_SET, true, false, true, false, 83, null));
            List<String> list2 = this.encodedQueryNamesAndValues;
            Intrinsics.checkNotNull(list2);
            list2.add(str != null ? _UrlKt.canonicalize$default(str, 0, 0, _UrlKt.QUERY_COMPONENT_REENCODE_SET, true, false, true, false, 83, null) : null);
            return this;
        }

        public final Builder setQueryParameter(String name, String str) {
            Intrinsics.checkNotNullParameter(name, "name");
            removeAllQueryParameters(name);
            addQueryParameter(name, str);
            return this;
        }

        public final Builder setEncodedQueryParameter(String encodedName, String str) {
            Intrinsics.checkNotNullParameter(encodedName, "encodedName");
            removeAllEncodedQueryParameters(encodedName);
            addEncodedQueryParameter(encodedName, str);
            return this;
        }

        public final Builder removeAllQueryParameters(String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            if (this.encodedQueryNamesAndValues == null) {
                return this;
            }
            removeAllCanonicalQueryParameters(_UrlKt.canonicalize$default(name, 0, 0, _UrlKt.QUERY_COMPONENT_ENCODE_SET, false, false, true, false, 91, null));
            return this;
        }

        public final Builder removeAllEncodedQueryParameters(String encodedName) {
            Intrinsics.checkNotNullParameter(encodedName, "encodedName");
            if (this.encodedQueryNamesAndValues == null) {
                return this;
            }
            removeAllCanonicalQueryParameters(_UrlKt.canonicalize$default(encodedName, 0, 0, _UrlKt.QUERY_COMPONENT_REENCODE_SET, true, false, true, false, 83, null));
            return this;
        }

        private final void removeAllCanonicalQueryParameters(String str) {
            List<String> list = this.encodedQueryNamesAndValues;
            Intrinsics.checkNotNull(list);
            int size = list.size() - 2;
            int progressionLastElement = ProgressionUtilKt.getProgressionLastElement(size, 0, -2);
            if (progressionLastElement > size) {
                return;
            }
            while (true) {
                List<String> list2 = this.encodedQueryNamesAndValues;
                Intrinsics.checkNotNull(list2);
                if (Intrinsics.areEqual(str, list2.get(size))) {
                    List<String> list3 = this.encodedQueryNamesAndValues;
                    Intrinsics.checkNotNull(list3);
                    list3.remove(size + 1);
                    List<String> list4 = this.encodedQueryNamesAndValues;
                    Intrinsics.checkNotNull(list4);
                    list4.remove(size);
                    List<String> list5 = this.encodedQueryNamesAndValues;
                    Intrinsics.checkNotNull(list5);
                    if (list5.isEmpty()) {
                        this.encodedQueryNamesAndValues = null;
                        return;
                    }
                }
                if (size == progressionLastElement) {
                    return;
                }
                size -= 2;
            }
        }

        public final Builder fragment(String str) {
            this.encodedFragment = str != null ? _UrlKt.canonicalize$default(str, 0, 0, "", false, false, false, true, 59, null) : null;
            return this;
        }

        public final Builder encodedFragment(String str) {
            this.encodedFragment = str != null ? _UrlKt.canonicalize$default(str, 0, 0, "", true, false, false, true, 51, null) : null;
            return this;
        }

        public final Builder reencodeForUri$okhttp() {
            String str = this.host;
            this.host = str != null ? new Regex("[\"<>^`{|}]").replace(str, "") : null;
            int size = this.encodedPathSegments.size();
            for (int i = 0; i < size; i++) {
                List<String> list = this.encodedPathSegments;
                list.set(i, _UrlKt.canonicalize$default(list.get(i), 0, 0, _UrlKt.PATH_SEGMENT_ENCODE_SET_URI, true, true, false, false, 99, null));
            }
            List<String> list2 = this.encodedQueryNamesAndValues;
            if (list2 != null) {
                int size2 = list2.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    String str2 = list2.get(i2);
                    list2.set(i2, str2 != null ? _UrlKt.canonicalize$default(str2, 0, 0, _UrlKt.QUERY_COMPONENT_ENCODE_SET_URI, true, true, true, false, 67, null) : null);
                }
            }
            String str3 = this.encodedFragment;
            this.encodedFragment = str3 != null ? _UrlKt.canonicalize$default(str3, 0, 0, _UrlKt.FRAGMENT_ENCODE_SET_URI, true, true, false, true, 35, null) : null;
            return this;
        }

        public final HttpUrl build() {
            ArrayList arrayList;
            String str = this.scheme;
            if (str == null) {
                throw new IllegalStateException("scheme == null");
            }
            String percentDecode$default = _UrlKt.percentDecode$default(this.encodedUsername, 0, 0, false, 7, null);
            String percentDecode$default2 = _UrlKt.percentDecode$default(this.encodedPassword, 0, 0, false, 7, null);
            String str2 = this.host;
            if (str2 == null) {
                throw new IllegalStateException("host == null");
            }
            int effectivePort = effectivePort();
            List<String> list = this.encodedPathSegments;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (String str3 : list) {
                arrayList2.add(_UrlKt.percentDecode$default(str3, 0, 0, false, 7, null));
            }
            ArrayList arrayList3 = arrayList2;
            List<String> list2 = this.encodedQueryNamesAndValues;
            if (list2 != null) {
                List<String> list3 = list2;
                ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
                for (String str4 : list3) {
                    arrayList4.add(str4 != null ? _UrlKt.percentDecode$default(str4, 0, 0, true, 3, null) : null);
                }
                arrayList = arrayList4;
            } else {
                arrayList = null;
            }
            String str5 = this.encodedFragment;
            return new HttpUrl(str, percentDecode$default, percentDecode$default2, str2, effectivePort, arrayList3, arrayList, str5 != null ? _UrlKt.percentDecode$default(str5, 0, 0, false, 7, null) : null, toString(), null);
        }

        private final int effectivePort() {
            int i = this.port;
            if (i != -1) {
                return i;
            }
            Companion companion = HttpUrl.Companion;
            String str = this.scheme;
            Intrinsics.checkNotNull(str);
            return companion.defaultPort(str);
        }

        /* JADX WARN: Code restructure failed: missing block: B:28:0x008d, code lost:
            if (r1 != r3.defaultPort(r4)) goto L31;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public String toString() {
            StringBuilder sb = new StringBuilder();
            String str = this.scheme;
            if (str != null) {
                sb.append(str);
                sb.append("://");
            } else {
                sb.append("//");
            }
            if (this.encodedUsername.length() > 0 || this.encodedPassword.length() > 0) {
                sb.append(this.encodedUsername);
                if (this.encodedPassword.length() > 0) {
                    sb.append(AbstractJsonLexerKt.COLON);
                    sb.append(this.encodedPassword);
                }
                sb.append('@');
            }
            String str2 = this.host;
            if (str2 != null) {
                Intrinsics.checkNotNull(str2);
                if (StringsKt.contains$default((CharSequence) str2, (char) AbstractJsonLexerKt.COLON, false, 2, (Object) null)) {
                    sb.append(AbstractJsonLexerKt.BEGIN_LIST);
                    sb.append(this.host);
                    sb.append(AbstractJsonLexerKt.END_LIST);
                } else {
                    sb.append(this.host);
                }
            }
            if (this.port != -1 || this.scheme != null) {
                int effectivePort = effectivePort();
                if (this.scheme != null) {
                    Companion companion = HttpUrl.Companion;
                    String str3 = this.scheme;
                    Intrinsics.checkNotNull(str3);
                }
                sb.append(AbstractJsonLexerKt.COLON);
                sb.append(effectivePort);
            }
            toPathString(this.encodedPathSegments, sb);
            if (this.encodedQueryNamesAndValues != null) {
                sb.append('?');
                Companion companion2 = HttpUrl.Companion;
                List<String> list = this.encodedQueryNamesAndValues;
                Intrinsics.checkNotNull(list);
                companion2.toQueryString(list, sb);
            }
            if (this.encodedFragment != null) {
                sb.append('#');
                sb.append(this.encodedFragment);
            }
            return sb.toString();
        }

        private final void toPathString(List<String> list, StringBuilder sb) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                sb.append('/');
                sb.append(list.get(i));
            }
        }

        public final Builder parse$okhttp(HttpUrl httpUrl, String str) {
            int delimiterOffset;
            boolean z;
            int i;
            int i2;
            char c;
            String input = str;
            Intrinsics.checkNotNullParameter(input, "input");
            int indexOfFirstNonAsciiWhitespace$default = _UtilCommonKt.indexOfFirstNonAsciiWhitespace$default(input, 0, 0, 3, null);
            int indexOfLastNonAsciiWhitespace$default = _UtilCommonKt.indexOfLastNonAsciiWhitespace$default(input, indexOfFirstNonAsciiWhitespace$default, 0, 2, null);
            int schemeDelimiterOffset = schemeDelimiterOffset(input, indexOfFirstNonAsciiWhitespace$default, indexOfLastNonAsciiWhitespace$default);
            boolean z2 = true;
            if (schemeDelimiterOffset != -1) {
                if (StringsKt.startsWith(input, "https:", indexOfFirstNonAsciiWhitespace$default, true)) {
                    this.scheme = Constants.SCHEME;
                    indexOfFirstNonAsciiWhitespace$default += 6;
                } else if (StringsKt.startsWith(input, "http:", indexOfFirstNonAsciiWhitespace$default, true)) {
                    this.scheme = "http";
                    indexOfFirstNonAsciiWhitespace$default += 5;
                } else {
                    StringBuilder sb = new StringBuilder("Expected URL scheme 'http' or 'https' but was '");
                    String substring = input.substring(0, schemeDelimiterOffset);
                    Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                    throw new IllegalArgumentException(sb.append(substring).append('\'').toString());
                }
            } else if (httpUrl != null) {
                this.scheme = httpUrl.scheme();
            } else {
                if (input.length() > 6) {
                    input = StringsKt.take(input, 6) + "...";
                }
                throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but no scheme was found for " + input);
            }
            int slashCount = slashCount(input, indexOfFirstNonAsciiWhitespace$default, indexOfLastNonAsciiWhitespace$default);
            char c2 = '?';
            char c3 = '#';
            if (slashCount >= 2 || httpUrl == null || !Intrinsics.areEqual(httpUrl.scheme(), this.scheme)) {
                boolean z3 = false;
                boolean z4 = false;
                int i3 = indexOfFirstNonAsciiWhitespace$default + slashCount;
                while (true) {
                    delimiterOffset = _UtilCommonKt.delimiterOffset(input, "@/\\?#", i3, indexOfLastNonAsciiWhitespace$default);
                    char charAt = delimiterOffset != indexOfLastNonAsciiWhitespace$default ? input.charAt(delimiterOffset) : (char) 65535;
                    if (charAt == 65535 || charAt == c3 || charAt == '/' || charAt == '\\' || charAt == c2) {
                        break;
                    } else if (charAt == '@') {
                        if (!z3) {
                            int delimiterOffset2 = _UtilCommonKt.delimiterOffset(input, (char) AbstractJsonLexerKt.COLON, i3, delimiterOffset);
                            z = z2;
                            String canonicalize$default = _UrlKt.canonicalize$default(input, i3, delimiterOffset2, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, 112, null);
                            if (z4) {
                                canonicalize$default = this.encodedUsername + "%40" + canonicalize$default;
                            }
                            this.encodedUsername = canonicalize$default;
                            if (delimiterOffset2 != delimiterOffset) {
                                i2 = delimiterOffset;
                                this.encodedPassword = _UrlKt.canonicalize$default(str, delimiterOffset2 + 1, i2, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, 112, null);
                                z3 = z;
                            } else {
                                i2 = delimiterOffset;
                            }
                            input = str;
                            i = i2;
                            z4 = z;
                        } else {
                            z = z2;
                            input = str;
                            i = delimiterOffset;
                            this.encodedPassword += "%40" + _UrlKt.canonicalize$default(input, i3, delimiterOffset, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, 112, null);
                        }
                        i3 = i + 1;
                        z2 = z;
                        c3 = '#';
                        c2 = '?';
                    }
                }
                int portColonOffset = portColonOffset(input, i3, delimiterOffset);
                int i4 = portColonOffset + 1;
                if (i4 < delimiterOffset) {
                    this.host = _HostnamesCommonKt.toCanonicalHost(_UrlKt.percentDecode$default(input, i3, portColonOffset, false, 4, null));
                    int parsePort = parsePort(input, i4, delimiterOffset);
                    this.port = parsePort;
                    if (parsePort == -1) {
                        StringBuilder sb2 = new StringBuilder("Invalid URL port: \"");
                        String substring2 = input.substring(i4, delimiterOffset);
                        Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
                        throw new IllegalArgumentException(sb2.append(substring2).append('\"').toString().toString());
                    }
                } else {
                    this.host = _HostnamesCommonKt.toCanonicalHost(_UrlKt.percentDecode$default(input, i3, portColonOffset, false, 4, null));
                    Companion companion = HttpUrl.Companion;
                    String str2 = this.scheme;
                    Intrinsics.checkNotNull(str2);
                    this.port = companion.defaultPort(str2);
                }
                if (this.host == null) {
                    StringBuilder sb3 = new StringBuilder("Invalid URL host: \"");
                    String substring3 = input.substring(i3, portColonOffset);
                    Intrinsics.checkNotNullExpressionValue(substring3, "substring(...)");
                    throw new IllegalArgumentException(sb3.append(substring3).append('\"').toString().toString());
                }
                indexOfFirstNonAsciiWhitespace$default = delimiterOffset;
            } else {
                this.encodedUsername = httpUrl.encodedUsername();
                this.encodedPassword = httpUrl.encodedPassword();
                this.host = httpUrl.host();
                this.port = httpUrl.port();
                this.encodedPathSegments.clear();
                this.encodedPathSegments.addAll(httpUrl.encodedPathSegments());
                if (indexOfFirstNonAsciiWhitespace$default == indexOfLastNonAsciiWhitespace$default || input.charAt(indexOfFirstNonAsciiWhitespace$default) == '#') {
                    encodedQuery(httpUrl.encodedQuery());
                }
            }
            int delimiterOffset3 = _UtilCommonKt.delimiterOffset(input, "?#", indexOfFirstNonAsciiWhitespace$default, indexOfLastNonAsciiWhitespace$default);
            resolvePath(input, indexOfFirstNonAsciiWhitespace$default, delimiterOffset3);
            if (delimiterOffset3 >= indexOfLastNonAsciiWhitespace$default || input.charAt(delimiterOffset3) != '?') {
                c = '#';
            } else {
                c = '#';
                int delimiterOffset4 = _UtilCommonKt.delimiterOffset(input, '#', delimiterOffset3, indexOfLastNonAsciiWhitespace$default);
                this.encodedQueryNamesAndValues = toQueryNamesAndValues(_UrlKt.canonicalize$default(input, delimiterOffset3 + 1, delimiterOffset4, _UrlKt.QUERY_ENCODE_SET, true, false, true, false, 80, null));
                delimiterOffset3 = delimiterOffset4;
            }
            if (delimiterOffset3 < indexOfLastNonAsciiWhitespace$default && input.charAt(delimiterOffset3) == c) {
                this.encodedFragment = _UrlKt.canonicalize$default(input, delimiterOffset3 + 1, indexOfLastNonAsciiWhitespace$default, "", true, false, false, true, 48, null);
            }
            return this;
        }

        private final void resolvePath(String str, int i, int i2) {
            if (i == i2) {
                return;
            }
            char charAt = str.charAt(i);
            if (charAt == '/' || charAt == '\\') {
                this.encodedPathSegments.clear();
                this.encodedPathSegments.add("");
                i++;
            } else {
                List<String> list = this.encodedPathSegments;
                list.set(list.size() - 1, "");
            }
            int i3 = i;
            while (i3 < i2) {
                int delimiterOffset = _UtilCommonKt.delimiterOffset(str, "/\\", i3, i2);
                boolean z = delimiterOffset < i2;
                String str2 = str;
                push(str2, i3, delimiterOffset, z, true);
                if (z) {
                    i3 = delimiterOffset + 1;
                    str = str2;
                } else {
                    str = str2;
                    i3 = delimiterOffset;
                }
            }
        }

        private final void push(String str, int i, int i2, boolean z, boolean z2) {
            String canonicalize$default = _UrlKt.canonicalize$default(str, i, i2, _UrlKt.PATH_SEGMENT_ENCODE_SET, z2, false, false, false, 112, null);
            if (isDot(canonicalize$default)) {
                return;
            }
            if (isDotDot(canonicalize$default)) {
                pop();
                return;
            }
            List<String> list = this.encodedPathSegments;
            if (list.get(list.size() - 1).length() == 0) {
                List<String> list2 = this.encodedPathSegments;
                list2.set(list2.size() - 1, canonicalize$default);
            } else {
                this.encodedPathSegments.add(canonicalize$default);
            }
            if (z) {
                this.encodedPathSegments.add("");
            }
        }

        private final void pop() {
            List<String> list = this.encodedPathSegments;
            if (list.remove(list.size() - 1).length() == 0 && !this.encodedPathSegments.isEmpty()) {
                List<String> list2 = this.encodedPathSegments;
                list2.set(list2.size() - 1, "");
                return;
            }
            this.encodedPathSegments.add("");
        }

        private final boolean isDot(String str) {
            return Intrinsics.areEqual(str, ".") || StringsKt.equals(str, "%2e", true);
        }

        private final boolean isDotDot(String str) {
            return Intrinsics.areEqual(str, "..") || StringsKt.equals(str, "%2e.", true) || StringsKt.equals(str, ".%2e", true) || StringsKt.equals(str, "%2e%2e", true);
        }

        private final List<String> toQueryNamesAndValues(String str) {
            ArrayList arrayList = new ArrayList();
            int i = 0;
            while (i <= str.length()) {
                String str2 = str;
                int indexOf$default = StringsKt.indexOf$default((CharSequence) str2, (char) Typography.amp, i, false, 4, (Object) null);
                if (indexOf$default == -1) {
                    indexOf$default = str.length();
                }
                int indexOf$default2 = StringsKt.indexOf$default((CharSequence) str2, '=', i, false, 4, (Object) null);
                if (indexOf$default2 == -1 || indexOf$default2 > indexOf$default) {
                    String substring = str.substring(i, indexOf$default);
                    Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                    arrayList.add(substring);
                    arrayList.add(null);
                } else {
                    String substring2 = str.substring(i, indexOf$default2);
                    Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
                    arrayList.add(substring2);
                    String substring3 = str.substring(indexOf$default2 + 1, indexOf$default);
                    Intrinsics.checkNotNullExpressionValue(substring3, "substring(...)");
                    arrayList.add(substring3);
                }
                i = indexOf$default + 1;
            }
            return arrayList;
        }

        private final int schemeDelimiterOffset(String str, int i, int i2) {
            if (i2 - i < 2) {
                return -1;
            }
            char charAt = str.charAt(i);
            if ((Intrinsics.compare((int) charAt, 97) >= 0 && Intrinsics.compare((int) charAt, 122) <= 0) || (Intrinsics.compare((int) charAt, 65) >= 0 && Intrinsics.compare((int) charAt, 90) <= 0)) {
                while (true) {
                    i++;
                    if (i >= i2) {
                        break;
                    }
                    char charAt2 = str.charAt(i);
                    if ('a' > charAt2 || charAt2 >= '{') {
                        if ('A' > charAt2 || charAt2 >= '[') {
                            if ('0' > charAt2 || charAt2 >= ':') {
                                if (charAt2 != '+' && charAt2 != '-' && charAt2 != '.') {
                                    if (charAt2 == ':') {
                                        return i;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return -1;
        }

        private final int slashCount(String str, int i, int i2) {
            int i3 = 0;
            while (i < i2) {
                char charAt = str.charAt(i);
                if (charAt != '/' && charAt != '\\') {
                    break;
                }
                i3++;
                i++;
            }
            return i3;
        }

        private final int portColonOffset(String str, int i, int i2) {
            while (i < i2) {
                char charAt = str.charAt(i);
                if (charAt == ':') {
                    return i;
                }
                if (charAt == '[') {
                    do {
                        i++;
                        if (i < i2) {
                        }
                    } while (str.charAt(i) != ']');
                }
                i++;
            }
            return i2;
        }

        private final int parsePort(String str, int i, int i2) {
            int parseInt;
            try {
                parseInt = Integer.parseInt(_UrlKt.canonicalize$default(str, i, i2, "", false, false, false, false, MenuKt.InTransitionDuration, null));
            } catch (NumberFormatException unused) {
            }
            if (1 > parseInt || parseInt >= 65536) {
                return -1;
            }
            return parseInt;
        }
    }

    /* compiled from: HttpUrl.kt */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J \u0010\b\u001a\u00020\t*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\n2\n\u0010\u000b\u001a\u00060\fj\u0002`\rH\u0002J\u0011\u0010\u000e\u001a\u00020\u000f*\u00020\u0007H\u0007¢\u0006\u0002\b\u0010J\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u000f*\u00020\u0007H\u0007¢\u0006\u0002\b\u0012J\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u000f*\u00020\u0013H\u0007¢\u0006\u0002\b\u0010J\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u000f*\u00020\u0014H\u0007¢\u0006\u0002\b\u0010J\u0015\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0007H\u0007¢\u0006\u0002\b\u0016J\u0017\u0010\u0012\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0015\u001a\u00020\u0007H\u0007¢\u0006\u0002\b\u0017J\u0017\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0015\u001a\u00020\u0013H\u0007¢\u0006\u0002\b\u0016J\u0017\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0018\u001a\u00020\u0014H\u0007¢\u0006\u0002\b\u0016¨\u0006\u0019"}, d2 = {"Lokhttp3/HttpUrl$Companion;", "", "<init>", "()V", "defaultPort", "", "scheme", "", "toQueryString", "", "", "out", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "toHttpUrl", "Lokhttp3/HttpUrl;", "get", "toHttpUrlOrNull", "parse", "Ljava/net/URL;", "Ljava/net/URI;", "url", "-deprecated_get", "-deprecated_parse", "uri", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final int defaultPort(String scheme) {
            Intrinsics.checkNotNullParameter(scheme, "scheme");
            if (Intrinsics.areEqual(scheme, "http")) {
                return 80;
            }
            return Intrinsics.areEqual(scheme, Constants.SCHEME) ? 443 : -1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void toQueryString(List<String> list, StringBuilder sb) {
            IntProgression step = RangesKt.step(RangesKt.until(0, list.size()), 2);
            int first = step.getFirst();
            int last = step.getLast();
            int step2 = step.getStep();
            if ((step2 <= 0 || first > last) && (step2 >= 0 || last > first)) {
                return;
            }
            while (true) {
                String str = list.get(first);
                String str2 = list.get(first + 1);
                if (first > 0) {
                    sb.append(Typography.amp);
                }
                sb.append(str);
                if (str2 != null) {
                    sb.append('=');
                    sb.append(str2);
                }
                if (first == last) {
                    return;
                }
                first += step2;
            }
        }

        @JvmStatic
        public final HttpUrl get(String str) {
            Intrinsics.checkNotNullParameter(str, "<this>");
            return new Builder().parse$okhttp(null, str).build();
        }

        @JvmStatic
        public final HttpUrl parse(String str) {
            Intrinsics.checkNotNullParameter(str, "<this>");
            try {
                return get(str);
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }

        @JvmStatic
        public final HttpUrl get(URL url) {
            Intrinsics.checkNotNullParameter(url, "<this>");
            String url2 = url.toString();
            Intrinsics.checkNotNullExpressionValue(url2, "toString(...)");
            return parse(url2);
        }

        @JvmStatic
        public final HttpUrl get(URI uri) {
            Intrinsics.checkNotNullParameter(uri, "<this>");
            String uri2 = uri.toString();
            Intrinsics.checkNotNullExpressionValue(uri2, "toString(...)");
            return parse(uri2);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "url.toHttpUrl()", imports = {"okhttp3.HttpUrl.Companion.toHttpUrl"}))
        /* renamed from: -deprecated_get  reason: not valid java name */
        public final HttpUrl m10300deprecated_get(String url) {
            Intrinsics.checkNotNullParameter(url, "url");
            return get(url);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "url.toHttpUrlOrNull()", imports = {"okhttp3.HttpUrl.Companion.toHttpUrlOrNull"}))
        /* renamed from: -deprecated_parse  reason: not valid java name */
        public final HttpUrl m10303deprecated_parse(String url) {
            Intrinsics.checkNotNullParameter(url, "url");
            return parse(url);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "url.toHttpUrlOrNull()", imports = {"okhttp3.HttpUrl.Companion.toHttpUrlOrNull"}))
        /* renamed from: -deprecated_get  reason: not valid java name */
        public final HttpUrl m10302deprecated_get(URL url) {
            Intrinsics.checkNotNullParameter(url, "url");
            return get(url);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "uri.toHttpUrlOrNull()", imports = {"okhttp3.HttpUrl.Companion.toHttpUrlOrNull"}))
        /* renamed from: -deprecated_get  reason: not valid java name */
        public final HttpUrl m10301deprecated_get(URI uri) {
            Intrinsics.checkNotNullParameter(uri, "uri");
            return get(uri);
        }
    }
}
