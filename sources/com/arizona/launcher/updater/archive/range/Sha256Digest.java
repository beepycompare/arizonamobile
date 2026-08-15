package com.arizona.launcher.updater.archive.range;

import com.google.common.base.Ascii;
import java.security.MessageDigest;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
/* compiled from: ArchiveRepresentationFencePolicy.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0001H\u0096\u0082\u0004J\n\u0010\u000b\u001a\u00020\fH\u0096\u0080\u0004J\n\u0010\r\u001a\u00020\u0003H\u0096\u0080\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007Ê\u0001\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u000f"}, d2 = {"Lcom/arizona/launcher/updater/archive/range/Sha256Digest;", "", "hex", "", "<init>", "(Ljava/lang/String;)V", "getHex", "()Ljava/lang/String;", "equals", "", "other", "hashCode", "", "toString", "Companion", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class Sha256Digest {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private static final String HEX_DIGITS = "0123456789abcdef";
    private static final int SHA256_HEX_LENGTH = 64;
    private final String hex;

    public /* synthetic */ Sha256Digest(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    private Sha256Digest(String str) {
        this.hex = str;
    }

    public final String getHex() {
        return this.hex;
    }

    public boolean equals(Object obj) {
        return (obj instanceof Sha256Digest) && Intrinsics.areEqual(this.hex, ((Sha256Digest) obj).hex);
    }

    public int hashCode() {
        return this.hex.hashCode();
    }

    public String toString() {
        return this.hex;
    }

    /* compiled from: ArchiveRepresentationFencePolicy.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007J\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nJ\f\u0010\u000b\u001a\u00020\f*\u00020\rH\u0002J\f\u0010\u000e\u001a\u00020\u0007*\u00020\nH\u0002R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/arizona/launcher/updater/archive/range/Sha256Digest$Companion;", "", "<init>", "()V", "parse", "Lcom/arizona/launcher/updater/archive/range/Sha256Digest;", "rawValue", "", "calculate", "bytes", "", "isHexDigit", "", "", "toLowerHex", "SHA256_HEX_LENGTH", "", "HEX_DIGITS", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final boolean isHexDigit(char c) {
            if ('0' > c || c >= ':') {
                if ('a' > c || c >= 'g') {
                    return 'A' <= c && c < 'G';
                }
                return true;
            }
            return true;
        }

        private Companion() {
        }

        public final Sha256Digest parse(String str) {
            String obj = str != null ? StringsKt.trim((CharSequence) str).toString() : null;
            if (obj == null) {
                obj = "";
            }
            if (obj.length() == 64) {
                String str2 = obj;
                for (int i = 0; i < str2.length(); i++) {
                    if (Sha256Digest.Companion.isHexDigit(str2.charAt(i))) {
                    }
                }
                Locale ROOT = Locale.ROOT;
                Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
                String lowerCase = obj.toLowerCase(ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                return new Sha256Digest(lowerCase, null);
            }
            return null;
        }

        public final Sha256Digest calculate(byte[] bytes) {
            Intrinsics.checkNotNullParameter(bytes, "bytes");
            byte[] digest = MessageDigest.getInstance("SHA-256").digest(bytes);
            Intrinsics.checkNotNullExpressionValue(digest, "digest(...)");
            return new Sha256Digest(toLowerHex(digest), null);
        }

        private final String toLowerHex(byte[] bArr) {
            StringBuilder sb = new StringBuilder(bArr.length * 2);
            for (byte b : bArr) {
                sb.append("0123456789abcdef".charAt((b & 255) >>> 4));
                sb.append("0123456789abcdef".charAt(b & Ascii.SI));
            }
            return sb.toString();
        }
    }
}
