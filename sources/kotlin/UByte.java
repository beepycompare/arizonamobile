package kotlin;

import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.UIntRange;
import kotlin.ranges.URangesKt;
/* compiled from: UByte.kt */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b-\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\n\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087@\u0018\u0000 s2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001sB\u0011\bA\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0000H\u0097\u008a\u0004¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\rH\u0087\u008a\u0004¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0010H\u0087\u008a\u0004¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0013H\u0087\u008a\u0004¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0016\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u0000H\u0087\u008a\u0004¢\u0006\u0004\b\u0017\u0010\fJ\u0019\u0010\u0016\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\rH\u0087\u008a\u0004¢\u0006\u0004\b\u0018\u0010\u000fJ\u0019\u0010\u0016\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u0010H\u0087\u008a\u0004¢\u0006\u0004\b\u0019\u0010\u0012J\u0019\u0010\u0016\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u0013H\u0087\u008a\u0004¢\u0006\u0004\b\u001a\u0010\u001bJ\u0019\u0010\u001c\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u0000H\u0087\u008a\u0004¢\u0006\u0004\b\u001d\u0010\fJ\u0019\u0010\u001c\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\rH\u0087\u008a\u0004¢\u0006\u0004\b\u001e\u0010\u000fJ\u0019\u0010\u001c\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u0010H\u0087\u008a\u0004¢\u0006\u0004\b\u001f\u0010\u0012J\u0019\u0010\u001c\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u0013H\u0087\u008a\u0004¢\u0006\u0004\b \u0010\u001bJ\u0019\u0010!\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u0000H\u0087\u008a\u0004¢\u0006\u0004\b\"\u0010\fJ\u0019\u0010!\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\rH\u0087\u008a\u0004¢\u0006\u0004\b#\u0010\u000fJ\u0019\u0010!\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u0010H\u0087\u008a\u0004¢\u0006\u0004\b$\u0010\u0012J\u0019\u0010!\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u0013H\u0087\u008a\u0004¢\u0006\u0004\b%\u0010\u001bJ\u0019\u0010&\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u0000H\u0087\u008a\u0004¢\u0006\u0004\b'\u0010\fJ\u0019\u0010&\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\rH\u0087\u008a\u0004¢\u0006\u0004\b(\u0010\u000fJ\u0019\u0010&\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u0010H\u0087\u008a\u0004¢\u0006\u0004\b)\u0010\u0012J\u0019\u0010&\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u0013H\u0087\u008a\u0004¢\u0006\u0004\b*\u0010\u001bJ\u0019\u0010+\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u0000H\u0087\u008a\u0004¢\u0006\u0004\b,\u0010\fJ\u0019\u0010+\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\rH\u0087\u008a\u0004¢\u0006\u0004\b-\u0010\u000fJ\u0019\u0010+\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u0010H\u0087\u008a\u0004¢\u0006\u0004\b.\u0010\u0012J\u0019\u0010+\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u0013H\u0087\u008a\u0004¢\u0006\u0004\b/\u0010\u001bJ\u0019\u00100\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u0000H\u0087\u0088\u0004¢\u0006\u0004\b1\u0010\fJ\u0019\u00100\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\rH\u0087\u0088\u0004¢\u0006\u0004\b2\u0010\u000fJ\u0019\u00100\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u0010H\u0087\u0088\u0004¢\u0006\u0004\b3\u0010\u0012J\u0019\u00100\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u0013H\u0087\u0088\u0004¢\u0006\u0004\b4\u0010\u001bJ\u0019\u00105\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0000H\u0087\u0088\u0004¢\u0006\u0004\b6\u00107J\u0019\u00105\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\rH\u0087\u0088\u0004¢\u0006\u0004\b8\u00109J\u0019\u00105\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u0010H\u0087\u0088\u0004¢\u0006\u0004\b:\u0010\u0012J\u0019\u00105\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u0013H\u0087\u0088\u0004¢\u0006\u0004\b;\u0010\u001bJ\u0011\u0010<\u001a\u00020\u0000H\u0087\u008a\u0004¢\u0006\u0004\b=\u0010\u0005J\u0011\u0010>\u001a\u00020\u0000H\u0087\u008a\u0004¢\u0006\u0004\b?\u0010\u0005J\u0019\u0010@\u001a\u00020A2\u0006\u0010\n\u001a\u00020\u0000H\u0087\u008a\u0004¢\u0006\u0004\bB\u0010CJ\u0019\u0010D\u001a\u00020A2\u0006\u0010\n\u001a\u00020\u0000H\u0087\u008a\u0004¢\u0006\u0004\bE\u0010CJ\u0019\u0010F\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0000H\u0087\u008c\u0004¢\u0006\u0004\bG\u00107J\u0019\u0010H\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0000H\u0087\u008c\u0004¢\u0006\u0004\bI\u00107J\u0019\u0010J\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0000H\u0087\u008c\u0004¢\u0006\u0004\bK\u00107J\u0011\u0010L\u001a\u00020\u0000H\u0087\u0088\u0004¢\u0006\u0004\bM\u0010\u0005J\u0011\u0010N\u001a\u00020\u0003H\u0087\u0088\u0004¢\u0006\u0004\bO\u0010\u0005J\u0011\u0010P\u001a\u00020QH\u0087\u0088\u0004¢\u0006\u0004\bR\u0010SJ\u0011\u0010T\u001a\u00020\tH\u0087\u0088\u0004¢\u0006\u0004\bU\u0010VJ\u0011\u0010W\u001a\u00020XH\u0087\u0088\u0004¢\u0006\u0004\bY\u0010ZJ\u0011\u0010[\u001a\u00020\u0000H\u0087\u0088\u0004¢\u0006\u0004\b\\\u0010\u0005J\u0011\u0010]\u001a\u00020\rH\u0087\u0088\u0004¢\u0006\u0004\b^\u0010SJ\u0011\u0010_\u001a\u00020\u0010H\u0087\u0088\u0004¢\u0006\u0004\b`\u0010VJ\u0011\u0010a\u001a\u00020\u0013H\u0087\u0088\u0004¢\u0006\u0004\bb\u0010ZJ\u0011\u0010c\u001a\u00020dH\u0087\u0088\u0004¢\u0006\u0004\be\u0010fJ\u0011\u0010g\u001a\u00020hH\u0087\u0088\u0004¢\u0006\u0004\bi\u0010jJ\u0011\u0010k\u001a\u00020lH\u0097\u0080\u0004¢\u0006\u0004\bm\u0010nJ\u0014\u0010o\u001a\u00020p2\b\u0010\n\u001a\u0004\u0018\u00010qHÖ\u0083\u0004J\n\u0010r\u001a\u00020\tHÖ\u0081\u0004R\u0017\u0010\u0002\u001a\u00020\u00038\u0000X\u0081\u0084\b¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006t"}, d2 = {"Lkotlin/UByte;", "", "data", "", "constructor-impl", "(B)B", "getData$annotations", "()V", "compareTo", "", "other", "compareTo-7apg3OU", "(BB)I", "Lkotlin/UShort;", "compareTo-xj2QHRw", "(BS)I", "Lkotlin/UInt;", "compareTo-WZ4Q5Ns", "(BI)I", "Lkotlin/ULong;", "compareTo-VKZWuLQ", "(BJ)I", "plus", "plus-7apg3OU", "plus-xj2QHRw", "plus-WZ4Q5Ns", "plus-VKZWuLQ", "(BJ)J", "minus", "minus-7apg3OU", "minus-xj2QHRw", "minus-WZ4Q5Ns", "minus-VKZWuLQ", "times", "times-7apg3OU", "times-xj2QHRw", "times-WZ4Q5Ns", "times-VKZWuLQ", TtmlNode.TAG_DIV, "div-7apg3OU", "div-xj2QHRw", "div-WZ4Q5Ns", "div-VKZWuLQ", "rem", "rem-7apg3OU", "rem-xj2QHRw", "rem-WZ4Q5Ns", "rem-VKZWuLQ", "floorDiv", "floorDiv-7apg3OU", "floorDiv-xj2QHRw", "floorDiv-WZ4Q5Ns", "floorDiv-VKZWuLQ", "mod", "mod-7apg3OU", "(BB)B", "mod-xj2QHRw", "(BS)S", "mod-WZ4Q5Ns", "mod-VKZWuLQ", "inc", "inc-w2LRezQ", "dec", "dec-w2LRezQ", "rangeTo", "Lkotlin/ranges/UIntRange;", "rangeTo-7apg3OU", "(BB)Lkotlin/ranges/UIntRange;", "rangeUntil", "rangeUntil-7apg3OU", "and", "and-7apg3OU", "or", "or-7apg3OU", "xor", "xor-7apg3OU", "inv", "inv-w2LRezQ", "toByte", "toByte-impl", "toShort", "", "toShort-impl", "(B)S", "toInt", "toInt-impl", "(B)I", "toLong", "", "toLong-impl", "(B)J", "toUByte", "toUByte-w2LRezQ", "toUShort", "toUShort-Mh2AYeg", "toUInt", "toUInt-pVg5ArA", "toULong", "toULong-s-VKNKU", "toFloat", "", "toFloat-impl", "(B)F", "toDouble", "", "toDouble-impl", "(B)D", "toString", "", "toString-impl", "(B)Ljava/lang/String;", "equals", "", "", "hashCode", "Companion", "kotlin-stdlib"}, k = 1, mv = {2, 3, 0}, xi = 48)
@JvmInline
/* loaded from: classes5.dex */
public final class UByte implements Comparable<UByte> {
    public static final Companion Companion = new Companion(null);
    public static final byte MAX_VALUE = -1;
    public static final byte MIN_VALUE = 0;
    public static final int SIZE_BITS = 8;
    public static final int SIZE_BYTES = 1;
    private final byte data;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ UByte m9214boximpl(byte b) {
        return new UByte(b);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static byte m9220constructorimpl(byte b) {
        return b;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m9226equalsimpl(byte b, Object obj) {
        return (obj instanceof UByte) && b == ((UByte) obj).m9270unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m9227equalsimpl0(byte b, byte b2) {
        return b == b2;
    }

    public static /* synthetic */ void getData$annotations() {
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m9232hashCodeimpl(byte b) {
        return Byte.hashCode(b);
    }

    /* renamed from: toByte-impl  reason: not valid java name */
    private static final byte m9258toByteimpl(byte b) {
        return b;
    }

    /* renamed from: toInt-impl  reason: not valid java name */
    private static final int m9261toIntimpl(byte b) {
        return b & 255;
    }

    /* renamed from: toLong-impl  reason: not valid java name */
    private static final long m9262toLongimpl(byte b) {
        return b & 255;
    }

    /* renamed from: toShort-impl  reason: not valid java name */
    private static final short m9263toShortimpl(byte b) {
        return (short) (b & 255);
    }

    /* renamed from: toUByte-w2LRezQ  reason: not valid java name */
    private static final byte m9265toUBytew2LRezQ(byte b) {
        return b;
    }

    public boolean equals(Object obj) {
        return m9226equalsimpl(this.data, obj);
    }

    public int hashCode() {
        return m9232hashCodeimpl(this.data);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ byte m9270unboximpl() {
        return this.data;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(UByte uByte) {
        return Intrinsics.compare(m9270unboximpl() & 255, uByte.m9270unboximpl() & 255);
    }

    private /* synthetic */ UByte(byte b) {
        this.data = b;
    }

    /* compiled from: UByte.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005X\u0086Ô\b¢\u0006\u0004\n\u0002\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0005X\u0086Ô\b¢\u0006\u0004\n\u0002\u0010\u0006R\u000f\u0010\b\u001a\u00020\tX\u0086Ô\b¢\u0006\u0002\n\u0000R\u000f\u0010\n\u001a\u00020\tX\u0086Ô\b¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lkotlin/UByte$Companion;", "", "<init>", "()V", "MIN_VALUE", "Lkotlin/UByte;", "B", "MAX_VALUE", "SIZE_BYTES", "", "SIZE_BITS", "kotlin-stdlib"}, k = 1, mv = {2, 3, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* renamed from: compareTo-7apg3OU  reason: not valid java name */
    private int m9215compareTo7apg3OU(byte b) {
        return Intrinsics.compare(m9270unboximpl() & 255, b & 255);
    }

    /* renamed from: compareTo-7apg3OU  reason: not valid java name */
    private static int m9216compareTo7apg3OU(byte b, byte b2) {
        return Intrinsics.compare(b & 255, b2 & 255);
    }

    /* renamed from: compareTo-xj2QHRw  reason: not valid java name */
    private static final int m9219compareToxj2QHRw(byte b, short s) {
        return Intrinsics.compare(b & 255, s & UShort.MAX_VALUE);
    }

    /* renamed from: compareTo-WZ4Q5Ns  reason: not valid java name */
    private static final int m9218compareToWZ4Q5Ns(byte b, int i) {
        int compare;
        compare = Integer.compare(UInt.m9302constructorimpl(b & 255) ^ Integer.MIN_VALUE, i ^ Integer.MIN_VALUE);
        return compare;
    }

    /* renamed from: compareTo-VKZWuLQ  reason: not valid java name */
    private static final int m9217compareToVKZWuLQ(byte b, long j) {
        int compare;
        compare = Long.compare(ULong.m9381constructorimpl(b & 255) ^ Long.MIN_VALUE, j ^ Long.MIN_VALUE);
        return compare;
    }

    /* renamed from: plus-7apg3OU  reason: not valid java name */
    private static final int m9244plus7apg3OU(byte b, byte b2) {
        return UInt.m9302constructorimpl(UInt.m9302constructorimpl(b & 255) + UInt.m9302constructorimpl(b2 & 255));
    }

    /* renamed from: plus-xj2QHRw  reason: not valid java name */
    private static final int m9247plusxj2QHRw(byte b, short s) {
        return UInt.m9302constructorimpl(UInt.m9302constructorimpl(b & 255) + UInt.m9302constructorimpl(s & UShort.MAX_VALUE));
    }

    /* renamed from: plus-WZ4Q5Ns  reason: not valid java name */
    private static final int m9246plusWZ4Q5Ns(byte b, int i) {
        return UInt.m9302constructorimpl(UInt.m9302constructorimpl(b & 255) + i);
    }

    /* renamed from: plus-VKZWuLQ  reason: not valid java name */
    private static final long m9245plusVKZWuLQ(byte b, long j) {
        return ULong.m9381constructorimpl(ULong.m9381constructorimpl(b & 255) + j);
    }

    /* renamed from: minus-7apg3OU  reason: not valid java name */
    private static final int m9235minus7apg3OU(byte b, byte b2) {
        return UInt.m9302constructorimpl(UInt.m9302constructorimpl(b & 255) - UInt.m9302constructorimpl(b2 & 255));
    }

    /* renamed from: minus-xj2QHRw  reason: not valid java name */
    private static final int m9238minusxj2QHRw(byte b, short s) {
        return UInt.m9302constructorimpl(UInt.m9302constructorimpl(b & 255) - UInt.m9302constructorimpl(s & UShort.MAX_VALUE));
    }

    /* renamed from: minus-WZ4Q5Ns  reason: not valid java name */
    private static final int m9237minusWZ4Q5Ns(byte b, int i) {
        return UInt.m9302constructorimpl(UInt.m9302constructorimpl(b & 255) - i);
    }

    /* renamed from: minus-VKZWuLQ  reason: not valid java name */
    private static final long m9236minusVKZWuLQ(byte b, long j) {
        return ULong.m9381constructorimpl(ULong.m9381constructorimpl(b & 255) - j);
    }

    /* renamed from: times-7apg3OU  reason: not valid java name */
    private static final int m9254times7apg3OU(byte b, byte b2) {
        return UInt.m9302constructorimpl(UInt.m9302constructorimpl(b & 255) * UInt.m9302constructorimpl(b2 & 255));
    }

    /* renamed from: times-xj2QHRw  reason: not valid java name */
    private static final int m9257timesxj2QHRw(byte b, short s) {
        return UInt.m9302constructorimpl(UInt.m9302constructorimpl(b & 255) * UInt.m9302constructorimpl(s & UShort.MAX_VALUE));
    }

    /* renamed from: times-WZ4Q5Ns  reason: not valid java name */
    private static final int m9256timesWZ4Q5Ns(byte b, int i) {
        return UInt.m9302constructorimpl(UInt.m9302constructorimpl(b & 255) * i);
    }

    /* renamed from: times-VKZWuLQ  reason: not valid java name */
    private static final long m9255timesVKZWuLQ(byte b, long j) {
        return ULong.m9381constructorimpl(ULong.m9381constructorimpl(b & 255) * j);
    }

    /* renamed from: div-7apg3OU  reason: not valid java name */
    private static final int m9222div7apg3OU(byte b, byte b2) {
        return UByte$$ExternalSyntheticBackport0.m(UInt.m9302constructorimpl(b & 255), UInt.m9302constructorimpl(b2 & 255));
    }

    /* renamed from: div-xj2QHRw  reason: not valid java name */
    private static final int m9225divxj2QHRw(byte b, short s) {
        return UByte$$ExternalSyntheticBackport0.m(UInt.m9302constructorimpl(b & 255), UInt.m9302constructorimpl(s & UShort.MAX_VALUE));
    }

    /* renamed from: div-WZ4Q5Ns  reason: not valid java name */
    private static final int m9224divWZ4Q5Ns(byte b, int i) {
        return UByte$$ExternalSyntheticBackport0.m(UInt.m9302constructorimpl(b & 255), i);
    }

    /* renamed from: div-VKZWuLQ  reason: not valid java name */
    private static final long m9223divVKZWuLQ(byte b, long j) {
        return UByte$$ExternalSyntheticBackport0.m$1(ULong.m9381constructorimpl(b & 255), j);
    }

    /* renamed from: rem-7apg3OU  reason: not valid java name */
    private static final int m9250rem7apg3OU(byte b, byte b2) {
        return UByte$$ExternalSyntheticBackport0.m$1(UInt.m9302constructorimpl(b & 255), UInt.m9302constructorimpl(b2 & 255));
    }

    /* renamed from: rem-xj2QHRw  reason: not valid java name */
    private static final int m9253remxj2QHRw(byte b, short s) {
        return UByte$$ExternalSyntheticBackport0.m$1(UInt.m9302constructorimpl(b & 255), UInt.m9302constructorimpl(s & UShort.MAX_VALUE));
    }

    /* renamed from: rem-WZ4Q5Ns  reason: not valid java name */
    private static final int m9252remWZ4Q5Ns(byte b, int i) {
        return UByte$$ExternalSyntheticBackport0.m$1(UInt.m9302constructorimpl(b & 255), i);
    }

    /* renamed from: rem-VKZWuLQ  reason: not valid java name */
    private static final long m9251remVKZWuLQ(byte b, long j) {
        return UByte$$ExternalSyntheticBackport0.m9271m(ULong.m9381constructorimpl(b & 255), j);
    }

    /* renamed from: floorDiv-7apg3OU  reason: not valid java name */
    private static final int m9228floorDiv7apg3OU(byte b, byte b2) {
        return UByte$$ExternalSyntheticBackport0.m(UInt.m9302constructorimpl(b & 255), UInt.m9302constructorimpl(b2 & 255));
    }

    /* renamed from: floorDiv-xj2QHRw  reason: not valid java name */
    private static final int m9231floorDivxj2QHRw(byte b, short s) {
        return UByte$$ExternalSyntheticBackport0.m(UInt.m9302constructorimpl(b & 255), UInt.m9302constructorimpl(s & UShort.MAX_VALUE));
    }

    /* renamed from: floorDiv-WZ4Q5Ns  reason: not valid java name */
    private static final int m9230floorDivWZ4Q5Ns(byte b, int i) {
        return UByte$$ExternalSyntheticBackport0.m(UInt.m9302constructorimpl(b & 255), i);
    }

    /* renamed from: floorDiv-VKZWuLQ  reason: not valid java name */
    private static final long m9229floorDivVKZWuLQ(byte b, long j) {
        return UByte$$ExternalSyntheticBackport0.m$1(ULong.m9381constructorimpl(b & 255), j);
    }

    /* renamed from: mod-7apg3OU  reason: not valid java name */
    private static final byte m9239mod7apg3OU(byte b, byte b2) {
        return m9220constructorimpl((byte) UByte$$ExternalSyntheticBackport0.m$1(UInt.m9302constructorimpl(b & 255), UInt.m9302constructorimpl(b2 & 255)));
    }

    /* renamed from: mod-xj2QHRw  reason: not valid java name */
    private static final short m9242modxj2QHRw(byte b, short s) {
        return UShort.m9488constructorimpl((short) UByte$$ExternalSyntheticBackport0.m$1(UInt.m9302constructorimpl(b & 255), UInt.m9302constructorimpl(s & UShort.MAX_VALUE)));
    }

    /* renamed from: mod-WZ4Q5Ns  reason: not valid java name */
    private static final int m9241modWZ4Q5Ns(byte b, int i) {
        return UByte$$ExternalSyntheticBackport0.m$1(UInt.m9302constructorimpl(b & 255), i);
    }

    /* renamed from: mod-VKZWuLQ  reason: not valid java name */
    private static final long m9240modVKZWuLQ(byte b, long j) {
        return UByte$$ExternalSyntheticBackport0.m9271m(ULong.m9381constructorimpl(b & 255), j);
    }

    /* renamed from: inc-w2LRezQ  reason: not valid java name */
    private static final byte m9233incw2LRezQ(byte b) {
        return m9220constructorimpl((byte) (b + 1));
    }

    /* renamed from: dec-w2LRezQ  reason: not valid java name */
    private static final byte m9221decw2LRezQ(byte b) {
        return m9220constructorimpl((byte) (b - 1));
    }

    /* renamed from: rangeTo-7apg3OU  reason: not valid java name */
    private static final UIntRange m9248rangeTo7apg3OU(byte b, byte b2) {
        return new UIntRange(UInt.m9302constructorimpl(b & 255), UInt.m9302constructorimpl(b2 & 255), null);
    }

    /* renamed from: rangeUntil-7apg3OU  reason: not valid java name */
    private static final UIntRange m9249rangeUntil7apg3OU(byte b, byte b2) {
        return URangesKt.m10490untilJ1ME1BU(UInt.m9302constructorimpl(b & 255), UInt.m9302constructorimpl(b2 & 255));
    }

    /* renamed from: and-7apg3OU  reason: not valid java name */
    private static final byte m9213and7apg3OU(byte b, byte b2) {
        return m9220constructorimpl((byte) (b & b2));
    }

    /* renamed from: or-7apg3OU  reason: not valid java name */
    private static final byte m9243or7apg3OU(byte b, byte b2) {
        return m9220constructorimpl((byte) (b | b2));
    }

    /* renamed from: xor-7apg3OU  reason: not valid java name */
    private static final byte m9269xor7apg3OU(byte b, byte b2) {
        return m9220constructorimpl((byte) (b ^ b2));
    }

    /* renamed from: inv-w2LRezQ  reason: not valid java name */
    private static final byte m9234invw2LRezQ(byte b) {
        return m9220constructorimpl((byte) (~b));
    }

    /* renamed from: toUShort-Mh2AYeg  reason: not valid java name */
    private static final short m9268toUShortMh2AYeg(byte b) {
        return UShort.m9488constructorimpl((short) (b & 255));
    }

    /* renamed from: toUInt-pVg5ArA  reason: not valid java name */
    private static final int m9266toUIntpVg5ArA(byte b) {
        return UInt.m9302constructorimpl(b & 255);
    }

    /* renamed from: toULong-s-VKNKU  reason: not valid java name */
    private static final long m9267toULongsVKNKU(byte b) {
        return ULong.m9381constructorimpl(b & 255);
    }

    /* renamed from: toFloat-impl  reason: not valid java name */
    private static final float m9260toFloatimpl(byte b) {
        return (float) UnsignedKt.uintToDouble(b & 255);
    }

    /* renamed from: toDouble-impl  reason: not valid java name */
    private static final double m9259toDoubleimpl(byte b) {
        return UnsignedKt.uintToDouble(b & 255);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m9264toStringimpl(byte b) {
        return String.valueOf(b & 255);
    }

    public String toString() {
        return m9264toStringimpl(this.data);
    }
}
