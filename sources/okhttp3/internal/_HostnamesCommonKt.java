package okhttp3.internal;

import io.appmetrica.analytics.coreutils.internal.StringUtils;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import okhttp3.internal.idn.IdnaMappingTableInstanceKt;
import okhttp3.internal.idn.Punycode;
import okio.Buffer;
/* compiled from: -HostnamesCommon.kt */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\u001a\n\u0010\u0002\u001a\u00020\u0003*\u00020\u0004\u001a\f\u0010\u0005\u001a\u00020\u0003*\u00020\u0004H\u0000\u001a\f\u0010\u0006\u001a\u00020\u0003*\u00020\u0004H\u0000\u001a\"\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0000\u001a0\u0010\r\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000bH\u0000\u001a\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\bH\u0000\u001a\u0010\u0010\u0011\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\bH\u0000\u001a\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\bH\u0002\u001a\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\bH\u0000\u001a\u000e\u0010\u0014\u001a\u0004\u0018\u00010\u0004*\u00020\u0004H\u0000\u001a\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0016\u001a\u00020\u0004H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"VERIFY_AS_IP_ADDRESS", "Lkotlin/text/Regex;", "canParseAsIpAddress", "", "", "containsInvalidLabelLengths", "containsInvalidHostnameAsciiCodes", "decodeIpv6", "", "input", "pos", "", "limit", "decodeIpv4Suffix", "address", "addressOffset", "inet6AddressToAscii", "canonicalizeInetAddress", "isMappedIpv4Address", "inet4AddressToAscii", "toCanonicalHost", "idnToAscii", "host", "okhttp"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class _HostnamesCommonKt {
    private static final Regex VERIFY_AS_IP_ADDRESS = new Regex("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");

    public static final boolean canParseAsIpAddress(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return VERIFY_AS_IP_ADDRESS.matches(str);
    }

    public static final boolean containsInvalidLabelLengths(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        int length = str.length();
        if (1 <= length && length < 254) {
            int i = 0;
            while (true) {
                int indexOf$default = StringsKt.indexOf$default((CharSequence) str, '.', i, false, 4, (Object) null);
                int length2 = indexOf$default == -1 ? str.length() - i : indexOf$default - i;
                if (1 > length2 || length2 >= 64) {
                    break;
                } else if (indexOf$default == -1 || indexOf$default == str.length() - 1) {
                    break;
                } else {
                    i = indexOf$default + 1;
                }
            }
            return false;
        }
        return true;
    }

    public static final boolean containsInvalidHostnameAsciiCodes(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (Intrinsics.compare((int) charAt, 31) <= 0 || Intrinsics.compare((int) charAt, 127) >= 0 || StringsKt.indexOf$default((CharSequence) " #%/:?@[\\]", charAt, 0, false, 6, (Object) null) != -1) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x0095, code lost:
        if (r11 == 16) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0097, code lost:
        if (r12 != (-1)) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0099, code lost:
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x009a, code lost:
        kotlin.collections.ArraysKt.copyInto(r8, r8, 16 - (r11 - r12), r12, r11);
        kotlin.collections.ArraysKt.fill(r8, (byte) 0, r12, (16 - r11) + r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00a6, code lost:
        return r8;
     */
    /* JADX WARN: Removed duplicated region for block: B:31:0x006b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final byte[] decodeIpv6(String str, int i, int i2) {
        int i3;
        String input = str;
        Intrinsics.checkNotNullParameter(input, "input");
        byte[] bArr = new byte[16];
        int i4 = i;
        int i5 = 0;
        int i6 = -1;
        int i7 = -1;
        while (true) {
            if (i4 < i2) {
                if (i5 != 16) {
                    int i8 = i4 + 2;
                    if (i8 <= i2 && StringsKt.startsWith$default(input, "::", i4, false, 4, (Object) null)) {
                        if (i6 == -1) {
                            i5 += 2;
                            if (i8 != i2) {
                                input = str;
                                i6 = i5;
                                i7 = i8;
                                int i9 = 0;
                                i4 = i7;
                                while (i4 < i2) {
                                }
                                i3 = i4 - i7;
                                if (i3 == 0) {
                                    break;
                                }
                                break;
                            }
                            i6 = i5;
                            break;
                        }
                        return null;
                    }
                    if (i5 != 0) {
                        if (StringsKt.startsWith$default(str, StringUtils.PROCESS_POSTFIX_DELIMITER, i4, false, 4, (Object) null)) {
                            i4++;
                        } else if (!StringsKt.startsWith$default(str, ".", i4, false, 4, (Object) null) || !decodeIpv4Suffix(str, i7, i2, bArr, i5 - 2)) {
                            return null;
                        } else {
                            i5 += 2;
                        }
                    }
                    input = str;
                    i7 = i4;
                    int i92 = 0;
                    i4 = i7;
                    while (i4 < i2) {
                        int parseHexDigit = _UtilCommonKt.parseHexDigit(input.charAt(i4));
                        if (parseHexDigit == -1) {
                            break;
                        }
                        i92 = (i92 << 4) + parseHexDigit;
                        i4++;
                    }
                    i3 = i4 - i7;
                    if (i3 == 0 || i3 > 4) {
                        break;
                    }
                    int i10 = i5 + 1;
                    bArr[i5] = (byte) ((i92 >>> 8) & 255);
                    i5 += 2;
                    bArr[i10] = (byte) (i92 & 255);
                } else {
                    return null;
                }
            } else {
                break;
            }
        }
        return null;
    }

    public static final boolean decodeIpv4Suffix(String input, int i, int i2, byte[] address, int i3) {
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(address, "address");
        int i4 = i3;
        while (i < i2) {
            if (i4 == address.length) {
                return false;
            }
            if (i4 != i3) {
                if (input.charAt(i) != '.') {
                    return false;
                }
                i++;
            }
            int i5 = i;
            int i6 = 0;
            while (i5 < i2) {
                char charAt = input.charAt(i5);
                if (Intrinsics.compare((int) charAt, 48) < 0 || Intrinsics.compare((int) charAt, 57) > 0) {
                    break;
                } else if ((i6 == 0 && i != i5) || (i6 = ((i6 * 10) + charAt) - 48) > 255) {
                    return false;
                } else {
                    i5++;
                }
            }
            if (i5 - i == 0) {
                return false;
            }
            address[i4] = (byte) i6;
            i4++;
            i = i5;
        }
        return i4 == i3 + 4;
    }

    public static final String inet6AddressToAscii(byte[] address) {
        Intrinsics.checkNotNullParameter(address, "address");
        int i = -1;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i3 < address.length) {
            int i5 = i3;
            while (i5 < 16 && address[i5] == 0 && address[i5 + 1] == 0) {
                i5 += 2;
            }
            int i6 = i5 - i3;
            if (i6 > i4 && i6 >= 4) {
                i = i3;
                i4 = i6;
            }
            i3 = i5 + 2;
        }
        Buffer buffer = new Buffer();
        while (i2 < address.length) {
            if (i2 == i) {
                buffer.writeByte(58);
                i2 += i4;
                if (i2 == 16) {
                    buffer.writeByte(58);
                }
            } else {
                if (i2 > 0) {
                    buffer.writeByte(58);
                }
                buffer.writeHexadecimalUnsignedLong((_UtilCommonKt.and(address[i2], 255) << 8) | _UtilCommonKt.and(address[i2 + 1], 255));
                i2 += 2;
            }
        }
        return buffer.readUtf8();
    }

    public static final byte[] canonicalizeInetAddress(byte[] address) {
        Intrinsics.checkNotNullParameter(address, "address");
        return isMappedIpv4Address(address) ? ArraysKt.sliceArray(address, RangesKt.until(12, 16)) : address;
    }

    private static final boolean isMappedIpv4Address(byte[] bArr) {
        if (bArr.length != 16) {
            return false;
        }
        for (int i = 0; i < 10; i++) {
            if (bArr[i] != 0) {
                return false;
            }
        }
        return bArr[10] == -1 && bArr[11] == -1;
    }

    public static final String inet4AddressToAscii(byte[] address) {
        Intrinsics.checkNotNullParameter(address, "address");
        if (address.length != 4) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        return new Buffer().writeDecimalLong(_UtilCommonKt.and(address[0], 255)).writeByte(46).writeDecimalLong(_UtilCommonKt.and(address[1], 255)).writeByte(46).writeDecimalLong(_UtilCommonKt.and(address[2], 255)).writeByte(46).writeDecimalLong(_UtilCommonKt.and(address[3], 255)).readUtf8();
    }

    public static final String toCanonicalHost(String str) {
        byte[] decodeIpv6;
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (StringsKt.contains$default((CharSequence) str, (CharSequence) StringUtils.PROCESS_POSTFIX_DELIMITER, false, 2, (Object) null)) {
            if (StringsKt.startsWith$default(str, "[", false, 2, (Object) null) && StringsKt.endsWith$default(str, "]", false, 2, (Object) null)) {
                decodeIpv6 = decodeIpv6(str, 1, str.length() - 1);
            } else {
                decodeIpv6 = decodeIpv6(str, 0, str.length());
            }
            if (decodeIpv6 == null) {
                return null;
            }
            byte[] canonicalizeInetAddress = canonicalizeInetAddress(decodeIpv6);
            if (canonicalizeInetAddress.length == 16) {
                return inet6AddressToAscii(canonicalizeInetAddress);
            }
            if (canonicalizeInetAddress.length == 4) {
                return inet4AddressToAscii(canonicalizeInetAddress);
            }
            throw new AssertionError("Invalid IPv6 address: '" + str + '\'');
        }
        String idnToAscii = idnToAscii(str);
        if (idnToAscii == null || idnToAscii.length() == 0 || containsInvalidHostnameAsciiCodes(idnToAscii) || containsInvalidLabelLengths(idnToAscii)) {
            return null;
        }
        return idnToAscii;
    }

    public static final String idnToAscii(String host) {
        Intrinsics.checkNotNullParameter(host, "host");
        Buffer writeUtf8 = new Buffer().writeUtf8(host);
        Buffer buffer = new Buffer();
        while (!writeUtf8.exhausted()) {
            if (!IdnaMappingTableInstanceKt.getIDNA_MAPPING_TABLE().map(writeUtf8.readUtf8CodePoint(), buffer)) {
                return null;
            }
        }
        writeUtf8.writeUtf8(_NormalizeJvmKt.normalizeNfc(buffer.readUtf8()));
        String decode = Punycode.INSTANCE.decode(writeUtf8.readUtf8());
        if (decode != null && Intrinsics.areEqual(decode, _NormalizeJvmKt.normalizeNfc(decode))) {
            return Punycode.INSTANCE.encode(decode);
        }
        return null;
    }
}
