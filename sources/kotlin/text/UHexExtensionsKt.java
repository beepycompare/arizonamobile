package kotlin.text;

import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UByteArray;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: UHexExtensions.kt */
@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\b¢\u0006\u0004\b\u0005\u0010\u0006\u001a2\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\b¢\u0006\u0004\b\n\u0010\u000b\u001a\u001c\u0010\f\u001a\u00020\u0002*\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\b¢\u0006\u0002\u0010\r\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u000e2\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\b¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u001c\u0010\u0011\u001a\u00020\u000e*\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\b¢\u0006\u0002\u0010\u0012\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00132\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\b¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u001c\u0010\u0016\u001a\u00020\u0013*\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\b¢\u0006\u0002\u0010\u0017\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00182\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\b¢\u0006\u0004\b\u0019\u0010\u001a\u001a\u001c\u0010\u001b\u001a\u00020\u0018*\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\b¢\u0006\u0002\u0010\u001c\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u001d2\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\b¢\u0006\u0004\b\u001e\u0010\u001f\u001a\u001c\u0010 \u001a\u00020\u001d*\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\b¢\u0006\u0002\u0010!¨\u0006\""}, d2 = {"toHexString", "", "Lkotlin/UByteArray;", "format", "Lkotlin/text/HexFormat;", "toHexString-zHuV2wU", "([BLkotlin/text/HexFormat;)Ljava/lang/String;", "startIndex", "", "endIndex", "toHexString-lZCiFrA", "([BIILkotlin/text/HexFormat;)Ljava/lang/String;", "hexToUByteArray", "(Ljava/lang/String;Lkotlin/text/HexFormat;)[B", "Lkotlin/UByte;", "toHexString-ZQbaR00", "(BLkotlin/text/HexFormat;)Ljava/lang/String;", "hexToUByte", "(Ljava/lang/String;Lkotlin/text/HexFormat;)B", "Lkotlin/UShort;", "toHexString-r3ox_E0", "(SLkotlin/text/HexFormat;)Ljava/lang/String;", "hexToUShort", "(Ljava/lang/String;Lkotlin/text/HexFormat;)S", "Lkotlin/UInt;", "toHexString-8M7LxHw", "(ILkotlin/text/HexFormat;)Ljava/lang/String;", "hexToUInt", "(Ljava/lang/String;Lkotlin/text/HexFormat;)I", "Lkotlin/ULong;", "toHexString-8UJCm-I", "(JLkotlin/text/HexFormat;)Ljava/lang/String;", "hexToULong", "(Ljava/lang/String;Lkotlin/text/HexFormat;)J", "kotlin-stdlib"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class UHexExtensionsKt {
    /* renamed from: toHexString-zHuV2wU  reason: not valid java name */
    private static final String m9807toHexStringzHuV2wU(byte[] toHexString, HexFormat format) {
        Intrinsics.checkNotNullParameter(toHexString, "$this$toHexString");
        Intrinsics.checkNotNullParameter(format, "format");
        return HexExtensionsKt.toHexString(toHexString, format);
    }

    /* renamed from: toHexString-zHuV2wU$default  reason: not valid java name */
    static /* synthetic */ String m9808toHexStringzHuV2wU$default(byte[] toHexString, HexFormat format, int i, Object obj) {
        if ((i & 1) != 0) {
            format = HexFormat.Companion.getDefault();
        }
        Intrinsics.checkNotNullParameter(toHexString, "$this$toHexString");
        Intrinsics.checkNotNullParameter(format, "format");
        return HexExtensionsKt.toHexString(toHexString, format);
    }

    /* renamed from: toHexString-lZCiFrA$default  reason: not valid java name */
    static /* synthetic */ String m9804toHexStringlZCiFrA$default(byte[] toHexString, int i, int i2, HexFormat format, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = UByteArray.m8553getSizeimpl(toHexString);
        }
        if ((i3 & 4) != 0) {
            format = HexFormat.Companion.getDefault();
        }
        Intrinsics.checkNotNullParameter(toHexString, "$this$toHexString");
        Intrinsics.checkNotNullParameter(format, "format");
        return HexExtensionsKt.toHexString(toHexString, i, i2, format);
    }

    /* renamed from: toHexString-lZCiFrA  reason: not valid java name */
    private static final String m9803toHexStringlZCiFrA(byte[] toHexString, int i, int i2, HexFormat format) {
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
        return UByteArray.m8547constructorimpl(HexExtensionsKt.hexToByteArray(str, format));
    }

    private static final byte[] hexToUByteArray(String str, HexFormat format) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(format, "format");
        return UByteArray.m8547constructorimpl(HexExtensionsKt.hexToByteArray(str, format));
    }

    /* renamed from: toHexString-ZQbaR00  reason: not valid java name */
    private static final String m9801toHexStringZQbaR00(byte b, HexFormat format) {
        Intrinsics.checkNotNullParameter(format, "format");
        return HexExtensionsKt.toHexString(b, format);
    }

    /* renamed from: toHexString-ZQbaR00$default  reason: not valid java name */
    static /* synthetic */ String m9802toHexStringZQbaR00$default(byte b, HexFormat format, int i, Object obj) {
        if ((i & 1) != 0) {
            format = HexFormat.Companion.getDefault();
        }
        Intrinsics.checkNotNullParameter(format, "format");
        return HexExtensionsKt.toHexString(b, format);
    }

    private static final byte hexToUByte(String str, HexFormat format) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(format, "format");
        return UByte.m8489constructorimpl(HexExtensionsKt.hexToByte(str, format));
    }

    static /* synthetic */ byte hexToUByte$default(String str, HexFormat format, int i, Object obj) {
        if ((i & 1) != 0) {
            format = HexFormat.Companion.getDefault();
        }
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(format, "format");
        return UByte.m8489constructorimpl(HexExtensionsKt.hexToByte(str, format));
    }

    /* renamed from: toHexString-r3ox_E0  reason: not valid java name */
    private static final String m9805toHexStringr3ox_E0(short s, HexFormat format) {
        Intrinsics.checkNotNullParameter(format, "format");
        return HexExtensionsKt.toHexString(s, format);
    }

    /* renamed from: toHexString-r3ox_E0$default  reason: not valid java name */
    static /* synthetic */ String m9806toHexStringr3ox_E0$default(short s, HexFormat format, int i, Object obj) {
        if ((i & 1) != 0) {
            format = HexFormat.Companion.getDefault();
        }
        Intrinsics.checkNotNullParameter(format, "format");
        return HexExtensionsKt.toHexString(s, format);
    }

    private static final short hexToUShort(String str, HexFormat format) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(format, "format");
        return UShort.m8757constructorimpl(HexExtensionsKt.hexToShort(str, format));
    }

    static /* synthetic */ short hexToUShort$default(String str, HexFormat format, int i, Object obj) {
        if ((i & 1) != 0) {
            format = HexFormat.Companion.getDefault();
        }
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(format, "format");
        return UShort.m8757constructorimpl(HexExtensionsKt.hexToShort(str, format));
    }

    /* renamed from: toHexString-8M7LxHw  reason: not valid java name */
    private static final String m9797toHexString8M7LxHw(int i, HexFormat format) {
        Intrinsics.checkNotNullParameter(format, "format");
        return HexExtensionsKt.toHexString(i, format);
    }

    /* renamed from: toHexString-8M7LxHw$default  reason: not valid java name */
    static /* synthetic */ String m9798toHexString8M7LxHw$default(int i, HexFormat format, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            format = HexFormat.Companion.getDefault();
        }
        Intrinsics.checkNotNullParameter(format, "format");
        return HexExtensionsKt.toHexString(i, format);
    }

    private static final int hexToUInt(String str, HexFormat format) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(format, "format");
        return UInt.m8571constructorimpl(HexExtensionsKt.hexToInt(str, format));
    }

    static /* synthetic */ int hexToUInt$default(String str, HexFormat format, int i, Object obj) {
        if ((i & 1) != 0) {
            format = HexFormat.Companion.getDefault();
        }
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(format, "format");
        return UInt.m8571constructorimpl(HexExtensionsKt.hexToInt(str, format));
    }

    /* renamed from: toHexString-8UJCm-I  reason: not valid java name */
    private static final String m9799toHexString8UJCmI(long j, HexFormat format) {
        Intrinsics.checkNotNullParameter(format, "format");
        return HexExtensionsKt.toHexString(j, format);
    }

    /* renamed from: toHexString-8UJCm-I$default  reason: not valid java name */
    static /* synthetic */ String m9800toHexString8UJCmI$default(long j, HexFormat format, int i, Object obj) {
        if ((i & 1) != 0) {
            format = HexFormat.Companion.getDefault();
        }
        Intrinsics.checkNotNullParameter(format, "format");
        return HexExtensionsKt.toHexString(j, format);
    }

    private static final long hexToULong(String str, HexFormat format) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(format, "format");
        return ULong.m8650constructorimpl(HexExtensionsKt.hexToLong(str, format));
    }

    static /* synthetic */ long hexToULong$default(String str, HexFormat format, int i, Object obj) {
        if ((i & 1) != 0) {
            format = HexFormat.Companion.getDefault();
        }
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(format, "format");
        return ULong.m8650constructorimpl(HexExtensionsKt.hexToLong(str, format));
    }
}
