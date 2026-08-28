package kotlin.text;

import com.facebook.internal.NativeProtocol;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UByteArray;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: UHexExtensions.kt */
@Metadata(d1 = {"\u0000X\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aG\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\u0088\u0004b\u0010\b\u0007\u0012\f\b\b\u0012\b\b\fJ\u0004\b\t0\tb\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\fb\u0002\b\rb\u0002\b\u000e¢\u0006\u0004\b\u0005\u0010\u0006\u001a[\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\u0088\u0004b\u0010\b\u0007\u0012\f\b\b\u0012\b\b\fJ\u0004\b\t0\tb\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\fb\u0002\b\rb\u0002\b\u000e¢\u0006\u0004\b\u0012\u0010\u0013\u001aE\u0010\u0014\u001a\u00020\u0002*\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\u0088\u0004b\u0010\b\u0007\u0012\f\b\b\u0012\b\b\fJ\u0004\b\t0\tb\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\fb\u0002\b\rb\u0002\b\u000e¢\u0006\u0002\u0010\u0015\u001aC\u0010\u0000\u001a\u00020\u0001*\u00020\u00162\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\u0088\u0004b\u0010\b\u0007\u0012\f\b\b\u0012\b\b\fJ\u0004\b\t0\tb\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\fb\u0002\b\u000e¢\u0006\u0004\b\u0017\u0010\u0018\u001aA\u0010\u0019\u001a\u00020\u0016*\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\u0088\u0004b\u0010\b\u0007\u0012\f\b\b\u0012\b\b\fJ\u0004\b\t0\tb\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\fb\u0002\b\u000e¢\u0006\u0002\u0010\u001a\u001aC\u0010\u0000\u001a\u00020\u0001*\u00020\u001b2\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\u0088\u0004b\u0010\b\u0007\u0012\f\b\b\u0012\b\b\fJ\u0004\b\t0\tb\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\fb\u0002\b\u000e¢\u0006\u0004\b\u001c\u0010\u001d\u001aA\u0010\u001e\u001a\u00020\u001b*\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\u0088\u0004b\u0010\b\u0007\u0012\f\b\b\u0012\b\b\fJ\u0004\b\t0\tb\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\fb\u0002\b\u000e¢\u0006\u0002\u0010\u001f\u001aC\u0010\u0000\u001a\u00020\u0001*\u00020 2\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\u0088\u0004b\u0010\b\u0007\u0012\f\b\b\u0012\b\b\fJ\u0004\b\t0\tb\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\fb\u0002\b\u000e¢\u0006\u0004\b!\u0010\"\u001aA\u0010#\u001a\u00020 *\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\u0088\u0004b\u0010\b\u0007\u0012\f\b\b\u0012\b\b\fJ\u0004\b\t0\tb\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\fb\u0002\b\u000e¢\u0006\u0002\u0010$\u001aC\u0010\u0000\u001a\u00020\u0001*\u00020%2\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\u0088\u0004b\u0010\b\u0007\u0012\f\b\b\u0012\b\b\fJ\u0004\b\t0\tb\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\fb\u0002\b\u000e¢\u0006\u0004\b&\u0010'\u001aA\u0010(\u001a\u00020%*\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\u0088\u0004b\u0010\b\u0007\u0012\f\b\b\u0012\b\b\fJ\u0004\b\t0\tb\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\fb\u0002\b\u000e¢\u0006\u0002\u0010)¨\u0006*"}, d2 = {"toHexString", "", "Lkotlin/UByteArray;", "format", "Lkotlin/text/HexFormat;", "toHexString-zHuV2wU", "([BLkotlin/text/HexFormat;)Ljava/lang/String;", "Lkotlin/WasExperimental;", "markerClass", "Lkotlin/ExperimentalStdlibApi;", "Lkotlin/SinceKotlin;", NativeProtocol.PLATFORM_PROVIDER_VERSION_COLUMN, "2.2", "Lkotlin/ExperimentalUnsignedTypes;", "Lkotlin/internal/InlineOnly;", "startIndex", "", "endIndex", "toHexString-lZCiFrA", "([BIILkotlin/text/HexFormat;)Ljava/lang/String;", "hexToUByteArray", "(Ljava/lang/String;Lkotlin/text/HexFormat;)[B", "Lkotlin/UByte;", "toHexString-ZQbaR00", "(BLkotlin/text/HexFormat;)Ljava/lang/String;", "hexToUByte", "(Ljava/lang/String;Lkotlin/text/HexFormat;)B", "Lkotlin/UShort;", "toHexString-r3ox_E0", "(SLkotlin/text/HexFormat;)Ljava/lang/String;", "hexToUShort", "(Ljava/lang/String;Lkotlin/text/HexFormat;)S", "Lkotlin/UInt;", "toHexString-8M7LxHw", "(ILkotlin/text/HexFormat;)Ljava/lang/String;", "hexToUInt", "(Ljava/lang/String;Lkotlin/text/HexFormat;)I", "Lkotlin/ULong;", "toHexString-8UJCm-I", "(JLkotlin/text/HexFormat;)Ljava/lang/String;", "hexToULong", "(Ljava/lang/String;Lkotlin/text/HexFormat;)J", "kotlin-stdlib"}, k = 2, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class UHexExtensionsKt {
    /* renamed from: toHexString-zHuV2wU  reason: not valid java name */
    private static final String m11279toHexStringzHuV2wU(byte[] toHexString, HexFormat format) {
        Intrinsics.checkNotNullParameter(toHexString, "$this$toHexString");
        Intrinsics.checkNotNullParameter(format, "format");
        return HexExtensionsKt.toHexString(toHexString, format);
    }

    /* renamed from: toHexString-zHuV2wU$default  reason: not valid java name */
    static /* synthetic */ String m11280toHexStringzHuV2wU$default(byte[] toHexString, HexFormat format, int i, Object obj) {
        if ((i & 1) != 0) {
            format = HexFormat.Companion.getDefault();
        }
        Intrinsics.checkNotNullParameter(toHexString, "$this$toHexString");
        Intrinsics.checkNotNullParameter(format, "format");
        return HexExtensionsKt.toHexString(toHexString, format);
    }

    /* renamed from: toHexString-lZCiFrA$default  reason: not valid java name */
    static /* synthetic */ String m11276toHexStringlZCiFrA$default(byte[] toHexString, int i, int i2, HexFormat format, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = UByteArray.m10003getSizeimpl(toHexString);
        }
        if ((i3 & 4) != 0) {
            format = HexFormat.Companion.getDefault();
        }
        Intrinsics.checkNotNullParameter(toHexString, "$this$toHexString");
        Intrinsics.checkNotNullParameter(format, "format");
        return HexExtensionsKt.toHexString(toHexString, i, i2, format);
    }

    /* renamed from: toHexString-lZCiFrA  reason: not valid java name */
    private static final String m11275toHexStringlZCiFrA(byte[] toHexString, int i, int i2, HexFormat format) {
        Intrinsics.checkNotNullParameter(toHexString, "$this$toHexString");
        Intrinsics.checkNotNullParameter(format, "format");
        return HexExtensionsKt.toHexString(toHexString, i, i2, format);
    }

    static /* synthetic */ byte[] hexToUByteArray$default(String str, HexFormat format, int i, Object obj) {
        if ((i & 1) != 0) {
            format = HexFormat.Companion.getDefault();
        }
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(format, "format");
        return UByteArray.m9997constructorimpl(HexExtensionsKt.hexToByteArray(str, format));
    }

    private static final byte[] hexToUByteArray(String str, HexFormat format) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(format, "format");
        return UByteArray.m9997constructorimpl(HexExtensionsKt.hexToByteArray(str, format));
    }

    /* renamed from: toHexString-ZQbaR00  reason: not valid java name */
    private static final String m11273toHexStringZQbaR00(byte b, HexFormat format) {
        Intrinsics.checkNotNullParameter(format, "format");
        return HexExtensionsKt.toHexString(b, format);
    }

    /* renamed from: toHexString-ZQbaR00$default  reason: not valid java name */
    static /* synthetic */ String m11274toHexStringZQbaR00$default(byte b, HexFormat format, int i, Object obj) {
        if ((i & 1) != 0) {
            format = HexFormat.Companion.getDefault();
        }
        Intrinsics.checkNotNullParameter(format, "format");
        return HexExtensionsKt.toHexString(b, format);
    }

    private static final byte hexToUByte(String str, HexFormat format) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(format, "format");
        return UByte.m9938constructorimpl(HexExtensionsKt.hexToByte(str, format));
    }

    static /* synthetic */ byte hexToUByte$default(String str, HexFormat format, int i, Object obj) {
        if ((i & 1) != 0) {
            format = HexFormat.Companion.getDefault();
        }
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(format, "format");
        return UByte.m9938constructorimpl(HexExtensionsKt.hexToByte(str, format));
    }

    /* renamed from: toHexString-r3ox_E0  reason: not valid java name */
    private static final String m11277toHexStringr3ox_E0(short s, HexFormat format) {
        Intrinsics.checkNotNullParameter(format, "format");
        return HexExtensionsKt.toHexString(s, format);
    }

    /* renamed from: toHexString-r3ox_E0$default  reason: not valid java name */
    static /* synthetic */ String m11278toHexStringr3ox_E0$default(short s, HexFormat format, int i, Object obj) {
        if ((i & 1) != 0) {
            format = HexFormat.Companion.getDefault();
        }
        Intrinsics.checkNotNullParameter(format, "format");
        return HexExtensionsKt.toHexString(s, format);
    }

    private static final short hexToUShort(String str, HexFormat format) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(format, "format");
        return UShort.m10207constructorimpl(HexExtensionsKt.hexToShort(str, format));
    }

    static /* synthetic */ short hexToUShort$default(String str, HexFormat format, int i, Object obj) {
        if ((i & 1) != 0) {
            format = HexFormat.Companion.getDefault();
        }
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(format, "format");
        return UShort.m10207constructorimpl(HexExtensionsKt.hexToShort(str, format));
    }

    /* renamed from: toHexString-8M7LxHw  reason: not valid java name */
    private static final String m11269toHexString8M7LxHw(int i, HexFormat format) {
        Intrinsics.checkNotNullParameter(format, "format");
        return HexExtensionsKt.toHexString(i, format);
    }

    /* renamed from: toHexString-8M7LxHw$default  reason: not valid java name */
    static /* synthetic */ String m11270toHexString8M7LxHw$default(int i, HexFormat format, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            format = HexFormat.Companion.getDefault();
        }
        Intrinsics.checkNotNullParameter(format, "format");
        return HexExtensionsKt.toHexString(i, format);
    }

    private static final int hexToUInt(String str, HexFormat format) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(format, "format");
        return UInt.m10021constructorimpl(HexExtensionsKt.hexToInt(str, format));
    }

    static /* synthetic */ int hexToUInt$default(String str, HexFormat format, int i, Object obj) {
        if ((i & 1) != 0) {
            format = HexFormat.Companion.getDefault();
        }
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(format, "format");
        return UInt.m10021constructorimpl(HexExtensionsKt.hexToInt(str, format));
    }

    /* renamed from: toHexString-8UJCm-I  reason: not valid java name */
    private static final String m11271toHexString8UJCmI(long j, HexFormat format) {
        Intrinsics.checkNotNullParameter(format, "format");
        return HexExtensionsKt.toHexString(j, format);
    }

    /* renamed from: toHexString-8UJCm-I$default  reason: not valid java name */
    static /* synthetic */ String m11272toHexString8UJCmI$default(long j, HexFormat format, int i, Object obj) {
        if ((i & 1) != 0) {
            format = HexFormat.Companion.getDefault();
        }
        Intrinsics.checkNotNullParameter(format, "format");
        return HexExtensionsKt.toHexString(j, format);
    }

    private static final long hexToULong(String str, HexFormat format) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(format, "format");
        return ULong.m10100constructorimpl(HexExtensionsKt.hexToLong(str, format));
    }

    static /* synthetic */ long hexToULong$default(String str, HexFormat format, int i, Object obj) {
        if ((i & 1) != 0) {
            format = HexFormat.Companion.getDefault();
        }
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(format, "format");
        return ULong.m10100constructorimpl(HexExtensionsKt.hexToLong(str, format));
    }
}
