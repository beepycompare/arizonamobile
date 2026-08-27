package com.arizona.launcher.updater.apk;

import java.net.InetAddress;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import okhttp3.HttpUrl;
/* compiled from: LauncherApkNetworkSecurity.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\u0003*\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000bH\u0002J\f\u0010\u000f\u001a\u00020\u0003*\u00020\rH\u0002J\u000e\u0010\u0010\u001a\u0004\u0018\u00010\u000b*\u00020\rH\u0002J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0013H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000Ê\u0001\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0015"}, d2 = {"Lcom/arizona/launcher/updater/apk/LauncherApkNetworkPolicy;", "", "allowInsecureLoopback", "", "<init>", "(Z)V", "isAllowed", "url", "Lokhttp3/HttpUrl;", "isUnsafeAddress", "address", "Ljava/net/InetAddress;", "isLoopbackTarget", "", "literalAddress", "isLoopbackHostName", "toLiteralInetAddressOrNull", "isUnsafeIpv4", "bytes", "", "Companion", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class LauncherApkNetworkPolicy {
    public static final int $stable = 0;
    @Deprecated
    public static final int IPV4_BYTE_COUNT = 4;
    @Deprecated
    public static final int IPV4_MAPPED_PREFIX_BYTES = 10;
    @Deprecated
    public static final int IPV6_BYTE_COUNT = 16;
    @Deprecated
    public static final int IPV6_MULTICAST_PREFIX = 255;
    @Deprecated
    public static final int IPV6_UNIQUE_LOCAL_MASK = 254;
    @Deprecated
    public static final int IPV6_UNIQUE_LOCAL_PREFIX = 252;
    @Deprecated
    public static final int UNSIGNED_BYTE_MASK = 255;
    private final boolean allowInsecureLoopback;
    private static final Companion Companion = new Companion(null);
    private static final Regex IPV4_LITERAL = new Regex("[0-9]{1,3}(?:\\.[0-9]{1,3}){3}");

    public LauncherApkNetworkPolicy(boolean z) {
        this.allowInsecureLoopback = z;
    }

    public final boolean isAllowed(HttpUrl url) {
        Intrinsics.checkNotNullParameter(url, "url");
        if (url.username().length() <= 0 && url.password().length() <= 0 && url.fragment() == null) {
            String host = url.host();
            Locale ROOT = Locale.ROOT;
            Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
            String lowerCase = host.toLowerCase(ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            if (StringsKt.isBlank(lowerCase)) {
                return false;
            }
            InetAddress literalInetAddressOrNull = toLiteralInetAddressOrNull(lowerCase);
            if (literalInetAddressOrNull == null || !isUnsafeAddress(literalInetAddressOrNull) || (this.allowInsecureLoopback && literalInetAddressOrNull.isLoopbackAddress())) {
                boolean isHttps = url.isHttps();
                boolean z = this.allowInsecureLoopback;
                return isHttps ? z || !isLoopbackHostName(lowerCase) : z && isLoopbackTarget(lowerCase, literalInetAddressOrNull);
            }
            return false;
        }
        return false;
    }

    public final boolean isUnsafeAddress(InetAddress address) {
        Intrinsics.checkNotNullParameter(address, "address");
        if (address.isAnyLocalAddress() || address.isLoopbackAddress() || address.isLinkLocalAddress() || address.isSiteLocalAddress() || address.isMulticastAddress()) {
            return true;
        }
        byte[] address2 = address.getAddress();
        if (address2.length == 4) {
            Intrinsics.checkNotNull(address2);
            return isUnsafeIpv4(address2);
        } else if (address2.length != 16) {
            return true;
        } else {
            byte b = address2[0];
            int i = b & 255;
            if ((b & 254) == 252 || i == 255) {
                return true;
            }
            if (b == 32 && address2[1] == 1 && address2[2] == 13 && address2[3] == -72) {
                return true;
            }
            Intrinsics.checkNotNull(address2);
            List<Byte> take = ArraysKt.take(address2, 10);
            if (!(take instanceof Collection) || !take.isEmpty()) {
                for (Number number : take) {
                    if (number.byteValue() != 0) {
                        break;
                    }
                }
            }
            return address2[10] == -1 && address2[11] == -1 && isUnsafeIpv4(ArraysKt.copyOfRange(address2, 12, 16));
        }
    }

    private final boolean isLoopbackTarget(String str, InetAddress inetAddress) {
        return isLoopbackHostName(str) || (inetAddress != null && inetAddress.isLoopbackAddress());
    }

    private final boolean isLoopbackHostName(String str) {
        return Intrinsics.areEqual(str, "localhost") || StringsKt.endsWith$default(str, ".localhost", false, 2, (Object) null);
    }

    private final InetAddress toLiteralInetAddressOrNull(String str) {
        Object m9919constructorimpl;
        String str2 = str;
        boolean matches = IPV4_LITERAL.matches(str2);
        boolean contains$default = StringsKt.contains$default((CharSequence) str2, (char) AbstractJsonLexerKt.COLON, false, 2, (Object) null);
        if (matches || contains$default) {
            try {
                Result.Companion companion = Result.Companion;
                m9919constructorimpl = Result.m9919constructorimpl(InetAddress.getByName(str));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                m9919constructorimpl = Result.m9919constructorimpl(ResultKt.createFailure(th));
            }
            return Result.m9925isFailureimpl(m9919constructorimpl) ? null : m9919constructorimpl;
        }
        return null;
    }

    private final boolean isUnsafeIpv4(byte[] bArr) {
        int i = bArr[0] & 255;
        int i2 = bArr[1] & 255;
        int i3 = bArr[2] & 255;
        return i == 0 || i == 10 || i == 127 || (i == 169 && i2 == 254) || ((i == 172 && 16 <= i2 && i2 < 32) || ((i == 192 && i2 == 0) || ((i == 192 && i2 == 168) || ((i == 198 && 18 <= i2 && i2 < 20) || ((i == 198 && i2 == 51 && i3 == 100) || ((i == 203 && i2 == 0 && i3 == 113) || ((i == 100 && 64 <= i2 && i2 < 128) || i >= 224)))))));
    }

    /* compiled from: LauncherApkNetworkSecurity.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/arizona/launcher/updater/apk/LauncherApkNetworkPolicy$Companion;", "", "<init>", "()V", "IPV4_BYTE_COUNT", "", "IPV6_BYTE_COUNT", "UNSIGNED_BYTE_MASK", "IPV6_UNIQUE_LOCAL_MASK", "IPV6_UNIQUE_LOCAL_PREFIX", "IPV6_MULTICAST_PREFIX", "IPV4_MAPPED_PREFIX_BYTES", "IPV4_LITERAL", "Lkotlin/text/Regex;", "getIPV4_LITERAL", "()Lkotlin/text/Regex;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Regex getIPV4_LITERAL() {
            return LauncherApkNetworkPolicy.IPV4_LITERAL;
        }
    }
}
