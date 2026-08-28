package com.arizona.launcher.updater.archive.download;

import com.adjust.sdk.Constants;
import java.net.InetAddress;
import java.net.URI;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* compiled from: ArchiveNetworkSecurity.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\u0005*\u0004\u0018\u00010\u0007H\u0002J\u000e\u0010\r\u001a\u0004\u0018\u00010\u000b*\u00020\u0007H\u0002J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0010H\u0002R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000Ê\u0001\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0013"}, d2 = {"Lcom/arizona/launcher/updater/archive/download/ArchiveRemoteNetworkPolicy;", "", "<init>", "()V", "isAllowedUrl", "", "url", "", "allowInsecureLoopback", "isUnsafeAddress", "address", "Ljava/net/InetAddress;", "isLoopbackHostName", "toLiteralInetAddressOrNull", "isUnsafeIpv4", "bytes", "", "IPV4_LITERAL", "Lkotlin/text/Regex;", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchiveRemoteNetworkPolicy {
    public static final int $stable = 0;
    public static final ArchiveRemoteNetworkPolicy INSTANCE = new ArchiveRemoteNetworkPolicy();
    private static final Regex IPV4_LITERAL = new Regex("[0-9]{1,3}(?:\\.[0-9]{1,3}){3}");

    private ArchiveRemoteNetworkPolicy() {
    }

    public final boolean isAllowedUrl(String url, boolean z) {
        Object m9920constructorimpl;
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(url, "url");
        try {
            Result.Companion companion = Result.Companion;
            ArchiveRemoteNetworkPolicy archiveRemoteNetworkPolicy = this;
            m9920constructorimpl = Result.m9920constructorimpl(new URI(url));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m9920constructorimpl = Result.m9920constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m9926isFailureimpl(m9920constructorimpl)) {
            m9920constructorimpl = null;
        }
        URI uri = (URI) m9920constructorimpl;
        if (uri != null) {
            String host = uri.getHost();
            if (host != null) {
                Locale ROOT = Locale.ROOT;
                Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
                str = host.toLowerCase(ROOT);
                Intrinsics.checkNotNullExpressionValue(str, "toLowerCase(...)");
            } else {
                str = null;
            }
            InetAddress literalInetAddressOrNull = str != null ? INSTANCE.toLiteralInetAddressOrNull(str) : null;
            boolean z2 = literalInetAddressOrNull == null || !INSTANCE.isUnsafeAddress(literalInetAddressOrNull) || (z && literalInetAddressOrNull.isLoopbackAddress());
            ArchiveRemoteNetworkPolicy archiveRemoteNetworkPolicy2 = INSTANCE;
            return ((StringsKt.equals(uri.getScheme(), Constants.SCHEME, true) && (str2 = str) != null && !StringsKt.isBlank(str2) && uri.getUserInfo() == null && ((!archiveRemoteNetworkPolicy2.isLoopbackHostName(str) || z) && z2)) || (z && StringsKt.equals(uri.getScheme(), "http", true) && (archiveRemoteNetworkPolicy2.isLoopbackHostName(str) || (literalInetAddressOrNull != null && literalInetAddressOrNull.isLoopbackAddress())) && uri.getUserInfo() == null)) && uri.getFragment() == null;
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

    private final boolean isLoopbackHostName(String str) {
        return Intrinsics.areEqual(str, "localhost") || (str != null && StringsKt.endsWith$default(str, ".localhost", false, 2, (Object) null));
    }

    private final InetAddress toLiteralInetAddressOrNull(String str) {
        Object m9920constructorimpl;
        String str2 = str;
        boolean matches = IPV4_LITERAL.matches(str2);
        boolean contains$default = StringsKt.contains$default((CharSequence) str2, (char) AbstractJsonLexerKt.COLON, false, 2, (Object) null);
        if (matches || contains$default) {
            try {
                Result.Companion companion = Result.Companion;
                m9920constructorimpl = Result.m9920constructorimpl(InetAddress.getByName(str));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                m9920constructorimpl = Result.m9920constructorimpl(ResultKt.createFailure(th));
            }
            return Result.m9926isFailureimpl(m9920constructorimpl) ? null : m9920constructorimpl;
        }
        return null;
    }

    private final boolean isUnsafeIpv4(byte[] bArr) {
        int i = bArr[0] & 255;
        int i2 = bArr[1] & 255;
        return i == 0 || i == 10 || i == 127 || (i == 169 && i2 == 254) || ((i == 172 && 16 <= i2 && i2 < 32) || ((i == 192 && i2 == 0) || ((i == 192 && i2 == 168) || ((i == 198 && 18 <= i2 && i2 < 20) || ((i == 100 && 64 <= i2 && i2 < 128) || i >= 224)))));
    }
}
