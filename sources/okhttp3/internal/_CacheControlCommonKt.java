package okhttp3.internal;

import androidx.collection.SieveCacheKt;
import com.google.common.net.HttpHeaders;
import io.appmetrica.analytics.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import okhttp3.CacheControl;
import okhttp3.Headers;
/* compiled from: -CacheControlCommon.kt */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\u0003\u001a\u00020\u0004*\u00020\u0005H\u0000\u001a\f\u0010\u0006\u001a\u00020\u0002*\u00020\u0007H\u0000\u001a\f\u0010\b\u001a\u00020\u0002*\u00020\u0007H\u0000\u001a\f\u0010\t\u001a\u00020\u0002*\u00020\nH\u0000\u001a\f\u0010\u000b\u001a\u00020\n*\u00020\nH\u0000\u001a\f\u0010\f\u001a\u00020\n*\u00020\nH\u0000\u001a\f\u0010\r\u001a\u00020\n*\u00020\nH\u0000\u001a\f\u0010\u000e\u001a\u00020\n*\u00020\nH\u0000\u001a\f\u0010\u000f\u001a\u00020\n*\u00020\nH\u0000\u001a\u0014\u0010\u0010\u001a\u00020\u0002*\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0012H\u0000\u001a\u001e\u0010\u0013\u001a\u00020\u0004*\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u00012\b\b\u0002\u0010\u0015\u001a\u00020\u0004H\u0002¨\u0006\u0016"}, d2 = {"commonToString", "", "Lokhttp3/CacheControl;", "commonClampToInt", "", "", "commonForceNetwork", "Lokhttp3/CacheControl$Companion;", "commonForceCache", "commonBuild", "Lokhttp3/CacheControl$Builder;", "commonNoCache", "commonNoStore", "commonOnlyIfCached", "commonNoTransform", "commonImmutable", "commonParse", "headers", "Lokhttp3/Headers;", "indexOfElement", "characters", "startIndex", "okhttp"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class _CacheControlCommonKt {
    public static final int commonClampToInt(long j) {
        if (j > SieveCacheKt.NodeLinkMask) {
            return Integer.MAX_VALUE;
        }
        return (int) j;
    }

    public static final String commonToString(CacheControl cacheControl) {
        Intrinsics.checkNotNullParameter(cacheControl, "<this>");
        String headerValue$okhttp = cacheControl.getHeaderValue$okhttp();
        if (headerValue$okhttp == null) {
            StringBuilder sb = new StringBuilder();
            if (cacheControl.noCache()) {
                sb.append("no-cache, ");
            }
            if (cacheControl.noStore()) {
                sb.append("no-store, ");
            }
            if (cacheControl.maxAgeSeconds() != -1) {
                sb.append("max-age=").append(cacheControl.maxAgeSeconds()).append(", ");
            }
            if (cacheControl.sMaxAgeSeconds() != -1) {
                sb.append("s-maxage=").append(cacheControl.sMaxAgeSeconds()).append(", ");
            }
            if (cacheControl.isPrivate()) {
                sb.append("private, ");
            }
            if (cacheControl.isPublic()) {
                sb.append("public, ");
            }
            if (cacheControl.mustRevalidate()) {
                sb.append("must-revalidate, ");
            }
            if (cacheControl.maxStaleSeconds() != -1) {
                sb.append("max-stale=").append(cacheControl.maxStaleSeconds()).append(", ");
            }
            if (cacheControl.minFreshSeconds() != -1) {
                sb.append("min-fresh=").append(cacheControl.minFreshSeconds()).append(", ");
            }
            if (cacheControl.onlyIfCached()) {
                sb.append("only-if-cached, ");
            }
            if (cacheControl.noTransform()) {
                sb.append("no-transform, ");
            }
            if (cacheControl.immutable()) {
                sb.append("immutable, ");
            }
            if (sb.length() == 0) {
                return "";
            }
            Intrinsics.checkNotNullExpressionValue(sb.delete(sb.length() - 2, sb.length()), "delete(...)");
            String sb2 = sb.toString();
            cacheControl.setHeaderValue$okhttp(sb2);
            return sb2;
        }
        return headerValue$okhttp;
    }

    public static final CacheControl commonForceNetwork(CacheControl.Companion companion) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        return new CacheControl.Builder().noCache().build();
    }

    public static final CacheControl commonForceCache(CacheControl.Companion companion) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        CacheControl.Builder onlyIfCached = new CacheControl.Builder().onlyIfCached();
        Duration.Companion companion2 = Duration.Companion;
        return onlyIfCached.m10249maxStaleLRDsOJo(DurationKt.toDuration(Integer.MAX_VALUE, DurationUnit.SECONDS)).build();
    }

    public static final CacheControl commonBuild(CacheControl.Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        return new CacheControl(builder.getNoCache$okhttp(), builder.getNoStore$okhttp(), builder.getMaxAgeSeconds$okhttp(), -1, false, false, false, builder.getMaxStaleSeconds$okhttp(), builder.getMinFreshSeconds$okhttp(), builder.getOnlyIfCached$okhttp(), builder.getNoTransform$okhttp(), builder.getImmutable$okhttp(), null);
    }

    public static final CacheControl.Builder commonNoCache(CacheControl.Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        builder.setNoCache$okhttp(true);
        return builder;
    }

    public static final CacheControl.Builder commonNoStore(CacheControl.Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        builder.setNoStore$okhttp(true);
        return builder;
    }

    public static final CacheControl.Builder commonOnlyIfCached(CacheControl.Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        builder.setOnlyIfCached$okhttp(true);
        return builder;
    }

    public static final CacheControl.Builder commonNoTransform(CacheControl.Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        builder.setNoTransform$okhttp(true);
        return builder;
    }

    public static final CacheControl.Builder commonImmutable(CacheControl.Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        builder.setImmutable$okhttp(true);
        return builder;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00e9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final CacheControl commonParse(CacheControl.Companion companion, Headers headers) {
        int i;
        int i2;
        int i3;
        String str;
        Headers headers2 = headers;
        Intrinsics.checkNotNullParameter(companion, "<this>");
        Intrinsics.checkNotNullParameter(headers2, "headers");
        int size = headers2.size();
        boolean z = true;
        boolean z2 = true;
        int i4 = 0;
        String str2 = null;
        boolean z3 = false;
        boolean z4 = false;
        int i5 = -1;
        int i6 = -1;
        boolean z5 = false;
        boolean z6 = false;
        boolean z7 = false;
        int i7 = -1;
        int i8 = -1;
        boolean z8 = false;
        boolean z9 = false;
        boolean z10 = false;
        while (i4 < size) {
            String name = headers2.name(i4);
            String value = headers2.value(i4);
            if (StringsKt.equals(name, "Cache-Control", z)) {
                if (str2 == null) {
                    str2 = value;
                    i = 0;
                    while (i < value.length()) {
                        int indexOfElement = indexOfElement(value, "=,;", i);
                        String substring = value.substring(i, indexOfElement);
                        boolean z11 = z;
                        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                        String obj = StringsKt.trim((CharSequence) substring).toString();
                        if (indexOfElement != value.length()) {
                            i2 = size;
                            if (value.charAt(indexOfElement) != ',' && value.charAt(indexOfElement) != ';') {
                                int indexOfNonWhitespace = _UtilCommonKt.indexOfNonWhitespace(value, indexOfElement + 1);
                                if (indexOfNonWhitespace < value.length() && value.charAt(indexOfNonWhitespace) == '\"') {
                                    int i9 = indexOfNonWhitespace + 1;
                                    int indexOf$default = StringsKt.indexOf$default((CharSequence) value, '\"', i9, false, 4, (Object) null);
                                    str = value.substring(i9, indexOf$default);
                                    Intrinsics.checkNotNullExpressionValue(str, "substring(...)");
                                    i3 = indexOf$default + 1;
                                } else {
                                    int indexOfElement2 = indexOfElement(value, ",;", indexOfNonWhitespace);
                                    String substring2 = value.substring(indexOfNonWhitespace, indexOfElement2);
                                    Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
                                    str = StringsKt.trim((CharSequence) substring2).toString();
                                    i3 = indexOfElement2;
                                }
                                z = z11;
                                if (!StringsKt.equals("no-cache", obj, z)) {
                                    i = i3;
                                    z3 = z;
                                } else if (StringsKt.equals("no-store", obj, z)) {
                                    i = i3;
                                    z4 = z;
                                } else {
                                    if (StringsKt.equals("max-age", obj, z)) {
                                        i5 = _UtilCommonKt.toNonNegativeInt(str, -1);
                                    } else if (StringsKt.equals("s-maxage", obj, z)) {
                                        i6 = _UtilCommonKt.toNonNegativeInt(str, -1);
                                    } else if (StringsKt.equals("private", obj, z)) {
                                        i = i3;
                                        z5 = z;
                                    } else if (StringsKt.equals(BuildConfig.SDK_BUILD_FLAVOR, obj, z)) {
                                        i = i3;
                                        z6 = z;
                                    } else if (StringsKt.equals("must-revalidate", obj, z)) {
                                        i = i3;
                                        z7 = z;
                                    } else if (StringsKt.equals("max-stale", obj, z)) {
                                        i7 = _UtilCommonKt.toNonNegativeInt(str, Integer.MAX_VALUE);
                                    } else if (StringsKt.equals("min-fresh", obj, z)) {
                                        i8 = _UtilCommonKt.toNonNegativeInt(str, -1);
                                    } else if (StringsKt.equals("only-if-cached", obj, z)) {
                                        i = i3;
                                        z8 = z;
                                    } else if (StringsKt.equals("no-transform", obj, z)) {
                                        i = i3;
                                        z9 = z;
                                    } else {
                                        boolean equals = StringsKt.equals("immutable", obj, z);
                                        i = i3;
                                        if (equals) {
                                            z10 = z;
                                        }
                                    }
                                    i = i3;
                                }
                                size = i2;
                            }
                        } else {
                            i2 = size;
                        }
                        i3 = indexOfElement + 1;
                        str = null;
                        z = z11;
                        if (!StringsKt.equals("no-cache", obj, z)) {
                        }
                        size = i2;
                    }
                    i4++;
                    headers2 = headers;
                    size = size;
                }
            } else if (!StringsKt.equals(name, HttpHeaders.PRAGMA, z)) {
                i4++;
                headers2 = headers;
                size = size;
            }
            z2 = false;
            i = 0;
            while (i < value.length()) {
            }
            i4++;
            headers2 = headers;
            size = size;
        }
        return new CacheControl(z3, z4, i5, i6, z5, z6, z7, i7, i8, z8, z9, z10, !z2 ? null : str2);
    }

    static /* synthetic */ int indexOfElement$default(String str, String str2, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return indexOfElement(str, str2, i);
    }

    private static final int indexOfElement(String str, String str2, int i) {
        int length = str.length();
        while (i < length) {
            if (StringsKt.contains$default((CharSequence) str2, str.charAt(i), false, 2, (Object) null)) {
                return i;
            }
            i++;
        }
        return str.length();
    }
}
