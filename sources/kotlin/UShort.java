package kotlin;

import androidx.exifinterface.media.ExifInterface;
import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.UIntRange;
import kotlin.ranges.URangesKt;
import okhttp3.internal.ws.WebSocketProtocol;
/* compiled from: UShort.kt */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\n\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b-\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0005\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087@\u0018\u0000 s2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001sB\u0011\bA\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0087\u008a\u0004¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0000H\u0097\u008a\u0004¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0010H\u0087\u008a\u0004¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0013H\u0087\u008a\u0004¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0016\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u000bH\u0087\u008a\u0004¢\u0006\u0004\b\u0017\u0010\rJ\u0019\u0010\u0016\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u0000H\u0087\u008a\u0004¢\u0006\u0004\b\u0018\u0010\u000fJ\u0019\u0010\u0016\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u0010H\u0087\u008a\u0004¢\u0006\u0004\b\u0019\u0010\u0012J\u0019\u0010\u0016\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u0013H\u0087\u008a\u0004¢\u0006\u0004\b\u001a\u0010\u001bJ\u0019\u0010\u001c\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u000bH\u0087\u008a\u0004¢\u0006\u0004\b\u001d\u0010\rJ\u0019\u0010\u001c\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u0000H\u0087\u008a\u0004¢\u0006\u0004\b\u001e\u0010\u000fJ\u0019\u0010\u001c\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u0010H\u0087\u008a\u0004¢\u0006\u0004\b\u001f\u0010\u0012J\u0019\u0010\u001c\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u0013H\u0087\u008a\u0004¢\u0006\u0004\b \u0010\u001bJ\u0019\u0010!\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u000bH\u0087\u008a\u0004¢\u0006\u0004\b\"\u0010\rJ\u0019\u0010!\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u0000H\u0087\u008a\u0004¢\u0006\u0004\b#\u0010\u000fJ\u0019\u0010!\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u0010H\u0087\u008a\u0004¢\u0006\u0004\b$\u0010\u0012J\u0019\u0010!\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u0013H\u0087\u008a\u0004¢\u0006\u0004\b%\u0010\u001bJ\u0019\u0010&\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u000bH\u0087\u008a\u0004¢\u0006\u0004\b'\u0010\rJ\u0019\u0010&\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u0000H\u0087\u008a\u0004¢\u0006\u0004\b(\u0010\u000fJ\u0019\u0010&\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u0010H\u0087\u008a\u0004¢\u0006\u0004\b)\u0010\u0012J\u0019\u0010&\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u0013H\u0087\u008a\u0004¢\u0006\u0004\b*\u0010\u001bJ\u0019\u0010+\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u000bH\u0087\u008a\u0004¢\u0006\u0004\b,\u0010\rJ\u0019\u0010+\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u0000H\u0087\u008a\u0004¢\u0006\u0004\b-\u0010\u000fJ\u0019\u0010+\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u0010H\u0087\u008a\u0004¢\u0006\u0004\b.\u0010\u0012J\u0019\u0010+\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u0013H\u0087\u008a\u0004¢\u0006\u0004\b/\u0010\u001bJ\u0019\u00100\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u000bH\u0087\u0088\u0004¢\u0006\u0004\b1\u0010\rJ\u0019\u00100\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u0000H\u0087\u0088\u0004¢\u0006\u0004\b2\u0010\u000fJ\u0019\u00100\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u0010H\u0087\u0088\u0004¢\u0006\u0004\b3\u0010\u0012J\u0019\u00100\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u0013H\u0087\u0088\u0004¢\u0006\u0004\b4\u0010\u001bJ\u0019\u00105\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000bH\u0087\u0088\u0004¢\u0006\u0004\b6\u00107J\u0019\u00105\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0000H\u0087\u0088\u0004¢\u0006\u0004\b8\u00109J\u0019\u00105\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u0010H\u0087\u0088\u0004¢\u0006\u0004\b:\u0010\u0012J\u0019\u00105\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u0013H\u0087\u0088\u0004¢\u0006\u0004\b;\u0010\u001bJ\u0011\u0010<\u001a\u00020\u0000H\u0087\u008a\u0004¢\u0006\u0004\b=\u0010\u0005J\u0011\u0010>\u001a\u00020\u0000H\u0087\u008a\u0004¢\u0006\u0004\b?\u0010\u0005J\u0019\u0010@\u001a\u00020A2\u0006\u0010\n\u001a\u00020\u0000H\u0087\u008a\u0004¢\u0006\u0004\bB\u0010CJ\u0019\u0010D\u001a\u00020A2\u0006\u0010\n\u001a\u00020\u0000H\u0087\u008a\u0004¢\u0006\u0004\bE\u0010CJ\u0019\u0010F\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0000H\u0087\u008c\u0004¢\u0006\u0004\bG\u00109J\u0019\u0010H\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0000H\u0087\u008c\u0004¢\u0006\u0004\bI\u00109J\u0019\u0010J\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0000H\u0087\u008c\u0004¢\u0006\u0004\bK\u00109J\u0011\u0010L\u001a\u00020\u0000H\u0087\u0088\u0004¢\u0006\u0004\bM\u0010\u0005J\u0011\u0010N\u001a\u00020OH\u0087\u0088\u0004¢\u0006\u0004\bP\u0010QJ\u0011\u0010R\u001a\u00020\u0003H\u0087\u0088\u0004¢\u0006\u0004\bS\u0010\u0005J\u0011\u0010T\u001a\u00020\tH\u0087\u0088\u0004¢\u0006\u0004\bU\u0010VJ\u0011\u0010W\u001a\u00020XH\u0087\u0088\u0004¢\u0006\u0004\bY\u0010ZJ\u0011\u0010[\u001a\u00020\u000bH\u0087\u0088\u0004¢\u0006\u0004\b\\\u0010QJ\u0011\u0010]\u001a\u00020\u0000H\u0087\u0088\u0004¢\u0006\u0004\b^\u0010\u0005J\u0011\u0010_\u001a\u00020\u0010H\u0087\u0088\u0004¢\u0006\u0004\b`\u0010VJ\u0011\u0010a\u001a\u00020\u0013H\u0087\u0088\u0004¢\u0006\u0004\bb\u0010ZJ\u0011\u0010c\u001a\u00020dH\u0087\u0088\u0004¢\u0006\u0004\be\u0010fJ\u0011\u0010g\u001a\u00020hH\u0087\u0088\u0004¢\u0006\u0004\bi\u0010jJ\u0011\u0010k\u001a\u00020lH\u0097\u0080\u0004¢\u0006\u0004\bm\u0010nJ\u0014\u0010o\u001a\u00020p2\b\u0010\n\u001a\u0004\u0018\u00010qHÖ\u0083\u0004J\n\u0010r\u001a\u00020\tHÖ\u0081\u0004R\u0017\u0010\u0002\u001a\u00020\u00038\u0000X\u0081\u0084\b¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006t"}, d2 = {"Lkotlin/UShort;", "", "data", "", "constructor-impl", "(S)S", "getData$annotations", "()V", "compareTo", "", "other", "Lkotlin/UByte;", "compareTo-7apg3OU", "(SB)I", "compareTo-xj2QHRw", "(SS)I", "Lkotlin/UInt;", "compareTo-WZ4Q5Ns", "(SI)I", "Lkotlin/ULong;", "compareTo-VKZWuLQ", "(SJ)I", "plus", "plus-7apg3OU", "plus-xj2QHRw", "plus-WZ4Q5Ns", "plus-VKZWuLQ", "(SJ)J", "minus", "minus-7apg3OU", "minus-xj2QHRw", "minus-WZ4Q5Ns", "minus-VKZWuLQ", "times", "times-7apg3OU", "times-xj2QHRw", "times-WZ4Q5Ns", "times-VKZWuLQ", TtmlNode.TAG_DIV, "div-7apg3OU", "div-xj2QHRw", "div-WZ4Q5Ns", "div-VKZWuLQ", "rem", "rem-7apg3OU", "rem-xj2QHRw", "rem-WZ4Q5Ns", "rem-VKZWuLQ", "floorDiv", "floorDiv-7apg3OU", "floorDiv-xj2QHRw", "floorDiv-WZ4Q5Ns", "floorDiv-VKZWuLQ", "mod", "mod-7apg3OU", "(SB)B", "mod-xj2QHRw", "(SS)S", "mod-WZ4Q5Ns", "mod-VKZWuLQ", "inc", "inc-Mh2AYeg", "dec", "dec-Mh2AYeg", "rangeTo", "Lkotlin/ranges/UIntRange;", "rangeTo-xj2QHRw", "(SS)Lkotlin/ranges/UIntRange;", "rangeUntil", "rangeUntil-xj2QHRw", "and", "and-xj2QHRw", "or", "or-xj2QHRw", "xor", "xor-xj2QHRw", "inv", "inv-Mh2AYeg", "toByte", "", "toByte-impl", "(S)B", "toShort", "toShort-impl", "toInt", "toInt-impl", "(S)I", "toLong", "", "toLong-impl", "(S)J", "toUByte", "toUByte-w2LRezQ", "toUShort", "toUShort-Mh2AYeg", "toUInt", "toUInt-pVg5ArA", "toULong", "toULong-s-VKNKU", "toFloat", "", "toFloat-impl", "(S)F", "toDouble", "", "toDouble-impl", "(S)D", "toString", "", "toString-impl", "(S)Ljava/lang/String;", "equals", "", "", "hashCode", "Companion", "kotlin-stdlib"}, k = 1, mv = {2, 3, 0}, xi = 48)
@JvmInline
/* loaded from: classes5.dex */
public final class UShort implements Comparable<UShort> {
    public static final Companion Companion = new Companion(null);
    public static final short MAX_VALUE = -1;
    public static final short MIN_VALUE = 0;
    public static final int SIZE_BITS = 16;
    public static final int SIZE_BYTES = 2;
    private final short data;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ UShort m10122boximpl(short s) {
        return new UShort(s);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static short m10128constructorimpl(short s) {
        return s;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m10134equalsimpl(short s, Object obj) {
        return (obj instanceof UShort) && s == ((UShort) obj).m10178unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m10135equalsimpl0(short s, short s2) {
        return s == s2;
    }

    public static /* synthetic */ void getData$annotations() {
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m10140hashCodeimpl(short s) {
        return Short.hashCode(s);
    }

    /* renamed from: toByte-impl  reason: not valid java name */
    private static final byte m10166toByteimpl(short s) {
        return (byte) s;
    }

    /* renamed from: toInt-impl  reason: not valid java name */
    private static final int m10169toIntimpl(short s) {
        return s & MAX_VALUE;
    }

    /* renamed from: toLong-impl  reason: not valid java name */
    private static final long m10170toLongimpl(short s) {
        return s & WebSocketProtocol.PAYLOAD_SHORT_MAX;
    }

    /* renamed from: toShort-impl  reason: not valid java name */
    private static final short m10171toShortimpl(short s) {
        return s;
    }

    /* renamed from: toUShort-Mh2AYeg  reason: not valid java name */
    private static final short m10176toUShortMh2AYeg(short s) {
        return s;
    }

    public boolean equals(Object obj) {
        return m10134equalsimpl(this.data, obj);
    }

    public int hashCode() {
        return m10140hashCodeimpl(this.data);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ short m10178unboximpl() {
        return this.data;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(UShort uShort) {
        return Intrinsics.compare(m10178unboximpl() & MAX_VALUE, uShort.m10178unboximpl() & MAX_VALUE);
    }

    private /* synthetic */ UShort(short s) {
        this.data = s;
    }

    /* compiled from: UShort.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005X\u0086Ô\b¢\u0006\u0004\n\u0002\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0005X\u0086Ô\b¢\u0006\u0004\n\u0002\u0010\u0006R\u000f\u0010\b\u001a\u00020\tX\u0086Ô\b¢\u0006\u0002\n\u0000R\u000f\u0010\n\u001a\u00020\tX\u0086Ô\b¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lkotlin/UShort$Companion;", "", "<init>", "()V", "MIN_VALUE", "Lkotlin/UShort;", ExifInterface.LATITUDE_SOUTH, "MAX_VALUE", "SIZE_BYTES", "", "SIZE_BITS", "kotlin-stdlib"}, k = 1, mv = {2, 3, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* renamed from: compareTo-7apg3OU  reason: not valid java name */
    private static final int m10123compareTo7apg3OU(short s, byte b) {
        return Intrinsics.compare(s & MAX_VALUE, b & 255);
    }

    /* renamed from: compareTo-xj2QHRw  reason: not valid java name */
    private int m10126compareToxj2QHRw(short s) {
        return Intrinsics.compare(m10178unboximpl() & MAX_VALUE, s & MAX_VALUE);
    }

    /* renamed from: compareTo-xj2QHRw  reason: not valid java name */
    private static int m10127compareToxj2QHRw(short s, short s2) {
        return Intrinsics.compare(s & MAX_VALUE, s2 & MAX_VALUE);
    }

    /* renamed from: compareTo-WZ4Q5Ns  reason: not valid java name */
    private static final int m10125compareToWZ4Q5Ns(short s, int i) {
        int compare;
        compare = Integer.compare(UInt.m9942constructorimpl(s & MAX_VALUE) ^ Integer.MIN_VALUE, i ^ Integer.MIN_VALUE);
        return compare;
    }

    /* renamed from: compareTo-VKZWuLQ  reason: not valid java name */
    private static final int m10124compareToVKZWuLQ(short s, long j) {
        int compare;
        compare = Long.compare(ULong.m10021constructorimpl(s & WebSocketProtocol.PAYLOAD_SHORT_MAX) ^ Long.MIN_VALUE, j ^ Long.MIN_VALUE);
        return compare;
    }

    /* renamed from: plus-7apg3OU  reason: not valid java name */
    private static final int m10152plus7apg3OU(short s, byte b) {
        return UInt.m9942constructorimpl(UInt.m9942constructorimpl(s & MAX_VALUE) + UInt.m9942constructorimpl(b & 255));
    }

    /* renamed from: plus-xj2QHRw  reason: not valid java name */
    private static final int m10155plusxj2QHRw(short s, short s2) {
        return UInt.m9942constructorimpl(UInt.m9942constructorimpl(s & MAX_VALUE) + UInt.m9942constructorimpl(s2 & MAX_VALUE));
    }

    /* renamed from: plus-WZ4Q5Ns  reason: not valid java name */
    private static final int m10154plusWZ4Q5Ns(short s, int i) {
        return UInt.m9942constructorimpl(UInt.m9942constructorimpl(s & MAX_VALUE) + i);
    }

    /* renamed from: plus-VKZWuLQ  reason: not valid java name */
    private static final long m10153plusVKZWuLQ(short s, long j) {
        return ULong.m10021constructorimpl(ULong.m10021constructorimpl(s & WebSocketProtocol.PAYLOAD_SHORT_MAX) + j);
    }

    /* renamed from: minus-7apg3OU  reason: not valid java name */
    private static final int m10143minus7apg3OU(short s, byte b) {
        return UInt.m9942constructorimpl(UInt.m9942constructorimpl(s & MAX_VALUE) - UInt.m9942constructorimpl(b & 255));
    }

    /* renamed from: minus-xj2QHRw  reason: not valid java name */
    private static final int m10146minusxj2QHRw(short s, short s2) {
        return UInt.m9942constructorimpl(UInt.m9942constructorimpl(s & MAX_VALUE) - UInt.m9942constructorimpl(s2 & MAX_VALUE));
    }

    /* renamed from: minus-WZ4Q5Ns  reason: not valid java name */
    private static final int m10145minusWZ4Q5Ns(short s, int i) {
        return UInt.m9942constructorimpl(UInt.m9942constructorimpl(s & MAX_VALUE) - i);
    }

    /* renamed from: minus-VKZWuLQ  reason: not valid java name */
    private static final long m10144minusVKZWuLQ(short s, long j) {
        return ULong.m10021constructorimpl(ULong.m10021constructorimpl(s & WebSocketProtocol.PAYLOAD_SHORT_MAX) - j);
    }

    /* renamed from: times-7apg3OU  reason: not valid java name */
    private static final int m10162times7apg3OU(short s, byte b) {
        return UInt.m9942constructorimpl(UInt.m9942constructorimpl(s & MAX_VALUE) * UInt.m9942constructorimpl(b & 255));
    }

    /* renamed from: times-xj2QHRw  reason: not valid java name */
    private static final int m10165timesxj2QHRw(short s, short s2) {
        return UInt.m9942constructorimpl(UInt.m9942constructorimpl(s & MAX_VALUE) * UInt.m9942constructorimpl(s2 & MAX_VALUE));
    }

    /* renamed from: times-WZ4Q5Ns  reason: not valid java name */
    private static final int m10164timesWZ4Q5Ns(short s, int i) {
        return UInt.m9942constructorimpl(UInt.m9942constructorimpl(s & MAX_VALUE) * i);
    }

    /* renamed from: times-VKZWuLQ  reason: not valid java name */
    private static final long m10163timesVKZWuLQ(short s, long j) {
        return ULong.m10021constructorimpl(ULong.m10021constructorimpl(s & WebSocketProtocol.PAYLOAD_SHORT_MAX) * j);
    }

    /* renamed from: div-7apg3OU  reason: not valid java name */
    private static final int m10130div7apg3OU(short s, byte b) {
        return UByte$$ExternalSyntheticBackport0.m(UInt.m9942constructorimpl(s & MAX_VALUE), UInt.m9942constructorimpl(b & 255));
    }

    /* renamed from: div-xj2QHRw  reason: not valid java name */
    private static final int m10133divxj2QHRw(short s, short s2) {
        return UByte$$ExternalSyntheticBackport0.m(UInt.m9942constructorimpl(s & MAX_VALUE), UInt.m9942constructorimpl(s2 & MAX_VALUE));
    }

    /* renamed from: div-WZ4Q5Ns  reason: not valid java name */
    private static final int m10132divWZ4Q5Ns(short s, int i) {
        return UByte$$ExternalSyntheticBackport0.m(UInt.m9942constructorimpl(s & MAX_VALUE), i);
    }

    /* renamed from: div-VKZWuLQ  reason: not valid java name */
    private static final long m10131divVKZWuLQ(short s, long j) {
        return UByte$$ExternalSyntheticBackport0.m$1(ULong.m10021constructorimpl(s & WebSocketProtocol.PAYLOAD_SHORT_MAX), j);
    }

    /* renamed from: rem-7apg3OU  reason: not valid java name */
    private static final int m10158rem7apg3OU(short s, byte b) {
        return UByte$$ExternalSyntheticBackport0.m$1(UInt.m9942constructorimpl(s & MAX_VALUE), UInt.m9942constructorimpl(b & 255));
    }

    /* renamed from: rem-xj2QHRw  reason: not valid java name */
    private static final int m10161remxj2QHRw(short s, short s2) {
        return UByte$$ExternalSyntheticBackport0.m$1(UInt.m9942constructorimpl(s & MAX_VALUE), UInt.m9942constructorimpl(s2 & MAX_VALUE));
    }

    /* renamed from: rem-WZ4Q5Ns  reason: not valid java name */
    private static final int m10160remWZ4Q5Ns(short s, int i) {
        return UByte$$ExternalSyntheticBackport0.m$1(UInt.m9942constructorimpl(s & MAX_VALUE), i);
    }

    /* renamed from: rem-VKZWuLQ  reason: not valid java name */
    private static final long m10159remVKZWuLQ(short s, long j) {
        return UByte$$ExternalSyntheticBackport0.m9911m(ULong.m10021constructorimpl(s & WebSocketProtocol.PAYLOAD_SHORT_MAX), j);
    }

    /* renamed from: floorDiv-7apg3OU  reason: not valid java name */
    private static final int m10136floorDiv7apg3OU(short s, byte b) {
        return UByte$$ExternalSyntheticBackport0.m(UInt.m9942constructorimpl(s & MAX_VALUE), UInt.m9942constructorimpl(b & 255));
    }

    /* renamed from: floorDiv-xj2QHRw  reason: not valid java name */
    private static final int m10139floorDivxj2QHRw(short s, short s2) {
        return UByte$$ExternalSyntheticBackport0.m(UInt.m9942constructorimpl(s & MAX_VALUE), UInt.m9942constructorimpl(s2 & MAX_VALUE));
    }

    /* renamed from: floorDiv-WZ4Q5Ns  reason: not valid java name */
    private static final int m10138floorDivWZ4Q5Ns(short s, int i) {
        return UByte$$ExternalSyntheticBackport0.m(UInt.m9942constructorimpl(s & MAX_VALUE), i);
    }

    /* renamed from: floorDiv-VKZWuLQ  reason: not valid java name */
    private static final long m10137floorDivVKZWuLQ(short s, long j) {
        return UByte$$ExternalSyntheticBackport0.m$1(ULong.m10021constructorimpl(s & WebSocketProtocol.PAYLOAD_SHORT_MAX), j);
    }

    /* renamed from: mod-7apg3OU  reason: not valid java name */
    private static final byte m10147mod7apg3OU(short s, byte b) {
        return UByte.m9860constructorimpl((byte) UByte$$ExternalSyntheticBackport0.m$1(UInt.m9942constructorimpl(s & MAX_VALUE), UInt.m9942constructorimpl(b & 255)));
    }

    /* renamed from: mod-xj2QHRw  reason: not valid java name */
    private static final short m10150modxj2QHRw(short s, short s2) {
        return m10128constructorimpl((short) UByte$$ExternalSyntheticBackport0.m$1(UInt.m9942constructorimpl(s & MAX_VALUE), UInt.m9942constructorimpl(s2 & MAX_VALUE)));
    }

    /* renamed from: mod-WZ4Q5Ns  reason: not valid java name */
    private static final int m10149modWZ4Q5Ns(short s, int i) {
        return UByte$$ExternalSyntheticBackport0.m$1(UInt.m9942constructorimpl(s & MAX_VALUE), i);
    }

    /* renamed from: mod-VKZWuLQ  reason: not valid java name */
    private static final long m10148modVKZWuLQ(short s, long j) {
        return UByte$$ExternalSyntheticBackport0.m9911m(ULong.m10021constructorimpl(s & WebSocketProtocol.PAYLOAD_SHORT_MAX), j);
    }

    /* renamed from: inc-Mh2AYeg  reason: not valid java name */
    private static final short m10141incMh2AYeg(short s) {
        return m10128constructorimpl((short) (s + 1));
    }

    /* renamed from: dec-Mh2AYeg  reason: not valid java name */
    private static final short m10129decMh2AYeg(short s) {
        return m10128constructorimpl((short) (s - 1));
    }

    /* renamed from: rangeTo-xj2QHRw  reason: not valid java name */
    private static final UIntRange m10156rangeToxj2QHRw(short s, short s2) {
        return new UIntRange(UInt.m9942constructorimpl(s & MAX_VALUE), UInt.m9942constructorimpl(s2 & MAX_VALUE), null);
    }

    /* renamed from: rangeUntil-xj2QHRw  reason: not valid java name */
    private static final UIntRange m10157rangeUntilxj2QHRw(short s, short s2) {
        return URangesKt.m11130untilJ1ME1BU(UInt.m9942constructorimpl(s & MAX_VALUE), UInt.m9942constructorimpl(s2 & MAX_VALUE));
    }

    /* renamed from: and-xj2QHRw  reason: not valid java name */
    private static final short m10121andxj2QHRw(short s, short s2) {
        return m10128constructorimpl((short) (s & s2));
    }

    /* renamed from: or-xj2QHRw  reason: not valid java name */
    private static final short m10151orxj2QHRw(short s, short s2) {
        return m10128constructorimpl((short) (s | s2));
    }

    /* renamed from: xor-xj2QHRw  reason: not valid java name */
    private static final short m10177xorxj2QHRw(short s, short s2) {
        return m10128constructorimpl((short) (s ^ s2));
    }

    /* renamed from: inv-Mh2AYeg  reason: not valid java name */
    private static final short m10142invMh2AYeg(short s) {
        return m10128constructorimpl((short) (~s));
    }

    /* renamed from: toUByte-w2LRezQ  reason: not valid java name */
    private static final byte m10173toUBytew2LRezQ(short s) {
        return UByte.m9860constructorimpl((byte) s);
    }

    /* renamed from: toUInt-pVg5ArA  reason: not valid java name */
    private static final int m10174toUIntpVg5ArA(short s) {
        return UInt.m9942constructorimpl(s & MAX_VALUE);
    }

    /* renamed from: toULong-s-VKNKU  reason: not valid java name */
    private static final long m10175toULongsVKNKU(short s) {
        return ULong.m10021constructorimpl(s & WebSocketProtocol.PAYLOAD_SHORT_MAX);
    }

    /* renamed from: toFloat-impl  reason: not valid java name */
    private static final float m10168toFloatimpl(short s) {
        return (float) UnsignedKt.uintToDouble(s & MAX_VALUE);
    }

    /* renamed from: toDouble-impl  reason: not valid java name */
    private static final double m10167toDoubleimpl(short s) {
        return UnsignedKt.uintToDouble(s & MAX_VALUE);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m10172toStringimpl(short s) {
        return String.valueOf(s & MAX_VALUE);
    }

    public String toString() {
        return m10172toStringimpl(this.data);
    }
}
