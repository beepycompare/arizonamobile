package kotlin;

import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.UIntRange;
import kotlin.ranges.URangesKt;
/* compiled from: UInt.kt */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b-\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087@\u0018\u0000 x2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001xB\u0011\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0087\n¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\rH\u0087\n¢\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0000H\u0097\n¢\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0012H\u0087\n¢\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010\u0015\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\nH\u0087\n¢\u0006\u0004\b\u0016\u0010\fJ\u0018\u0010\u0015\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\rH\u0087\n¢\u0006\u0004\b\u0017\u0010\u000fJ\u0018\u0010\u0015\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b\u0018\u0010\u0011J\u0018\u0010\u0015\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\u0012H\u0087\n¢\u0006\u0004\b\u0019\u0010\u001aJ\u0018\u0010\u001b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\nH\u0087\n¢\u0006\u0004\b\u001c\u0010\fJ\u0018\u0010\u001b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\rH\u0087\n¢\u0006\u0004\b\u001d\u0010\u000fJ\u0018\u0010\u001b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b\u001e\u0010\u0011J\u0018\u0010\u001b\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\u0012H\u0087\n¢\u0006\u0004\b\u001f\u0010\u001aJ\u0018\u0010 \u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\nH\u0087\n¢\u0006\u0004\b!\u0010\fJ\u0018\u0010 \u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\rH\u0087\n¢\u0006\u0004\b\"\u0010\u000fJ\u0018\u0010 \u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b#\u0010\u0011J\u0018\u0010 \u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\u0012H\u0087\n¢\u0006\u0004\b$\u0010\u001aJ\u0018\u0010%\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\nH\u0087\n¢\u0006\u0004\b&\u0010\fJ\u0018\u0010%\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\rH\u0087\n¢\u0006\u0004\b'\u0010\u000fJ\u0018\u0010%\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b(\u0010\u0011J\u0018\u0010%\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\u0012H\u0087\n¢\u0006\u0004\b)\u0010\u001aJ\u0018\u0010*\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\nH\u0087\n¢\u0006\u0004\b+\u0010\fJ\u0018\u0010*\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\rH\u0087\n¢\u0006\u0004\b,\u0010\u000fJ\u0018\u0010*\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b-\u0010\u0011J\u0018\u0010*\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\u0012H\u0087\n¢\u0006\u0004\b.\u0010\u001aJ\u0018\u0010/\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\nH\u0087\b¢\u0006\u0004\b0\u0010\fJ\u0018\u0010/\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\rH\u0087\b¢\u0006\u0004\b1\u0010\u000fJ\u0018\u0010/\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\b¢\u0006\u0004\b2\u0010\u0011J\u0018\u0010/\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\u0012H\u0087\b¢\u0006\u0004\b3\u0010\u001aJ\u0018\u00104\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\nH\u0087\b¢\u0006\u0004\b5\u00106J\u0018\u00104\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\rH\u0087\b¢\u0006\u0004\b7\u00108J\u0018\u00104\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\b¢\u0006\u0004\b9\u0010\u0011J\u0018\u00104\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\u0012H\u0087\b¢\u0006\u0004\b:\u0010\u001aJ\u0010\u0010;\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b<\u0010\u0005J\u0010\u0010=\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b>\u0010\u0005J\u0018\u0010?\u001a\u00020@2\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\bA\u0010BJ\u0018\u0010C\u001a\u00020@2\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\bD\u0010BJ\u0018\u0010E\u001a\u00020\u00002\u0006\u0010F\u001a\u00020\u0003H\u0087\f¢\u0006\u0004\bG\u0010\u0011J\u0018\u0010H\u001a\u00020\u00002\u0006\u0010F\u001a\u00020\u0003H\u0087\f¢\u0006\u0004\bI\u0010\u0011J\u0018\u0010J\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\f¢\u0006\u0004\bK\u0010\u0011J\u0018\u0010L\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\f¢\u0006\u0004\bM\u0010\u0011J\u0018\u0010N\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\f¢\u0006\u0004\bO\u0010\u0011J\u0010\u0010P\u001a\u00020\u0000H\u0087\b¢\u0006\u0004\bQ\u0010\u0005J\u0010\u0010R\u001a\u00020SH\u0087\b¢\u0006\u0004\bT\u0010UJ\u0010\u0010V\u001a\u00020WH\u0087\b¢\u0006\u0004\bX\u0010YJ\u0010\u0010Z\u001a\u00020\u0003H\u0087\b¢\u0006\u0004\b[\u0010\u0005J\u0010\u0010\\\u001a\u00020]H\u0087\b¢\u0006\u0004\b^\u0010_J\u0010\u0010`\u001a\u00020\nH\u0087\b¢\u0006\u0004\ba\u0010UJ\u0010\u0010b\u001a\u00020\rH\u0087\b¢\u0006\u0004\bc\u0010YJ\u0010\u0010d\u001a\u00020\u0000H\u0087\b¢\u0006\u0004\be\u0010\u0005J\u0010\u0010f\u001a\u00020\u0012H\u0087\b¢\u0006\u0004\bg\u0010_J\u0010\u0010h\u001a\u00020iH\u0087\b¢\u0006\u0004\bj\u0010kJ\u0010\u0010l\u001a\u00020mH\u0087\b¢\u0006\u0004\bn\u0010oJ\u000f\u0010p\u001a\u00020qH\u0016¢\u0006\u0004\br\u0010sJ\u0013\u0010t\u001a\u00020u2\b\u0010\t\u001a\u0004\u0018\u00010vHÖ\u0003J\t\u0010w\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0081\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006y"}, d2 = {"Lkotlin/UInt;", "", "data", "", "constructor-impl", "(I)I", "getData$annotations", "()V", "compareTo", "other", "Lkotlin/UByte;", "compareTo-7apg3OU", "(IB)I", "Lkotlin/UShort;", "compareTo-xj2QHRw", "(IS)I", "compareTo-WZ4Q5Ns", "(II)I", "Lkotlin/ULong;", "compareTo-VKZWuLQ", "(IJ)I", "plus", "plus-7apg3OU", "plus-xj2QHRw", "plus-WZ4Q5Ns", "plus-VKZWuLQ", "(IJ)J", "minus", "minus-7apg3OU", "minus-xj2QHRw", "minus-WZ4Q5Ns", "minus-VKZWuLQ", "times", "times-7apg3OU", "times-xj2QHRw", "times-WZ4Q5Ns", "times-VKZWuLQ", TtmlNode.TAG_DIV, "div-7apg3OU", "div-xj2QHRw", "div-WZ4Q5Ns", "div-VKZWuLQ", "rem", "rem-7apg3OU", "rem-xj2QHRw", "rem-WZ4Q5Ns", "rem-VKZWuLQ", "floorDiv", "floorDiv-7apg3OU", "floorDiv-xj2QHRw", "floorDiv-WZ4Q5Ns", "floorDiv-VKZWuLQ", "mod", "mod-7apg3OU", "(IB)B", "mod-xj2QHRw", "(IS)S", "mod-WZ4Q5Ns", "mod-VKZWuLQ", "inc", "inc-pVg5ArA", "dec", "dec-pVg5ArA", "rangeTo", "Lkotlin/ranges/UIntRange;", "rangeTo-WZ4Q5Ns", "(II)Lkotlin/ranges/UIntRange;", "rangeUntil", "rangeUntil-WZ4Q5Ns", "shl", "bitCount", "shl-pVg5ArA", "shr", "shr-pVg5ArA", "and", "and-WZ4Q5Ns", "or", "or-WZ4Q5Ns", "xor", "xor-WZ4Q5Ns", "inv", "inv-pVg5ArA", "toByte", "", "toByte-impl", "(I)B", "toShort", "", "toShort-impl", "(I)S", "toInt", "toInt-impl", "toLong", "", "toLong-impl", "(I)J", "toUByte", "toUByte-w2LRezQ", "toUShort", "toUShort-Mh2AYeg", "toUInt", "toUInt-pVg5ArA", "toULong", "toULong-s-VKNKU", "toFloat", "", "toFloat-impl", "(I)F", "toDouble", "", "toDouble-impl", "(I)D", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "equals", "", "", "hashCode", "Companion", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
@JvmInline
/* loaded from: classes5.dex */
public final class UInt implements Comparable<UInt> {
    public static final Companion Companion = new Companion(null);
    public static final int MAX_VALUE = -1;
    public static final int MIN_VALUE = 0;
    public static final int SIZE_BITS = 32;
    public static final int SIZE_BYTES = 4;
    private final int data;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ UInt m8565boximpl(int i) {
        return new UInt(i);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static int m8571constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m8577equalsimpl(int i, Object obj) {
        return (obj instanceof UInt) && i == ((UInt) obj).m8623unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m8578equalsimpl0(int i, int i2) {
        return i == i2;
    }

    public static /* synthetic */ void getData$annotations() {
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m8583hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    /* renamed from: toByte-impl  reason: not valid java name */
    private static final byte m8611toByteimpl(int i) {
        return (byte) i;
    }

    /* renamed from: toInt-impl  reason: not valid java name */
    private static final int m8614toIntimpl(int i) {
        return i;
    }

    /* renamed from: toLong-impl  reason: not valid java name */
    private static final long m8615toLongimpl(int i) {
        return i & 4294967295L;
    }

    /* renamed from: toShort-impl  reason: not valid java name */
    private static final short m8616toShortimpl(int i) {
        return (short) i;
    }

    /* renamed from: toUInt-pVg5ArA  reason: not valid java name */
    private static final int m8619toUIntpVg5ArA(int i) {
        return i;
    }

    public boolean equals(Object obj) {
        return m8577equalsimpl(this.data, obj);
    }

    public int hashCode() {
        return m8583hashCodeimpl(this.data);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ int m8623unboximpl() {
        return this.data;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(UInt uInt) {
        return UnsignedKt.uintCompare(m8623unboximpl(), uInt.m8623unboximpl());
    }

    private /* synthetic */ UInt(int i) {
        this.data = i;
    }

    /* compiled from: UInt.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0004\n\u0002\u0010\u0006R\u0010\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0004\n\u0002\u0010\u0006R\u000e\u0010\b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lkotlin/UInt$Companion;", "", "<init>", "()V", "MIN_VALUE", "Lkotlin/UInt;", "I", "MAX_VALUE", "SIZE_BYTES", "", "SIZE_BITS", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* renamed from: compareTo-7apg3OU  reason: not valid java name */
    private static final int m8566compareTo7apg3OU(int i, byte b) {
        int compare;
        compare = Integer.compare(i ^ Integer.MIN_VALUE, m8571constructorimpl(b & 255) ^ Integer.MIN_VALUE);
        return compare;
    }

    /* renamed from: compareTo-xj2QHRw  reason: not valid java name */
    private static final int m8570compareToxj2QHRw(int i, short s) {
        int compare;
        compare = Integer.compare(i ^ Integer.MIN_VALUE, m8571constructorimpl(s & UShort.MAX_VALUE) ^ Integer.MIN_VALUE);
        return compare;
    }

    /* renamed from: compareTo-WZ4Q5Ns  reason: not valid java name */
    private int m8568compareToWZ4Q5Ns(int i) {
        return UnsignedKt.uintCompare(m8623unboximpl(), i);
    }

    /* renamed from: compareTo-WZ4Q5Ns  reason: not valid java name */
    private static int m8569compareToWZ4Q5Ns(int i, int i2) {
        return UnsignedKt.uintCompare(i, i2);
    }

    /* renamed from: compareTo-VKZWuLQ  reason: not valid java name */
    private static final int m8567compareToVKZWuLQ(int i, long j) {
        int compare;
        compare = Long.compare(ULong.m8650constructorimpl(i & 4294967295L) ^ Long.MIN_VALUE, j ^ Long.MIN_VALUE);
        return compare;
    }

    /* renamed from: plus-7apg3OU  reason: not valid java name */
    private static final int m8595plus7apg3OU(int i, byte b) {
        return m8571constructorimpl(i + m8571constructorimpl(b & 255));
    }

    /* renamed from: plus-xj2QHRw  reason: not valid java name */
    private static final int m8598plusxj2QHRw(int i, short s) {
        return m8571constructorimpl(i + m8571constructorimpl(s & UShort.MAX_VALUE));
    }

    /* renamed from: plus-WZ4Q5Ns  reason: not valid java name */
    private static final int m8597plusWZ4Q5Ns(int i, int i2) {
        return m8571constructorimpl(i + i2);
    }

    /* renamed from: plus-VKZWuLQ  reason: not valid java name */
    private static final long m8596plusVKZWuLQ(int i, long j) {
        return ULong.m8650constructorimpl(ULong.m8650constructorimpl(i & 4294967295L) + j);
    }

    /* renamed from: minus-7apg3OU  reason: not valid java name */
    private static final int m8586minus7apg3OU(int i, byte b) {
        return m8571constructorimpl(i - m8571constructorimpl(b & 255));
    }

    /* renamed from: minus-xj2QHRw  reason: not valid java name */
    private static final int m8589minusxj2QHRw(int i, short s) {
        return m8571constructorimpl(i - m8571constructorimpl(s & UShort.MAX_VALUE));
    }

    /* renamed from: minus-WZ4Q5Ns  reason: not valid java name */
    private static final int m8588minusWZ4Q5Ns(int i, int i2) {
        return m8571constructorimpl(i - i2);
    }

    /* renamed from: minus-VKZWuLQ  reason: not valid java name */
    private static final long m8587minusVKZWuLQ(int i, long j) {
        return ULong.m8650constructorimpl(ULong.m8650constructorimpl(i & 4294967295L) - j);
    }

    /* renamed from: times-7apg3OU  reason: not valid java name */
    private static final int m8607times7apg3OU(int i, byte b) {
        return m8571constructorimpl(i * m8571constructorimpl(b & 255));
    }

    /* renamed from: times-xj2QHRw  reason: not valid java name */
    private static final int m8610timesxj2QHRw(int i, short s) {
        return m8571constructorimpl(i * m8571constructorimpl(s & UShort.MAX_VALUE));
    }

    /* renamed from: times-WZ4Q5Ns  reason: not valid java name */
    private static final int m8609timesWZ4Q5Ns(int i, int i2) {
        return m8571constructorimpl(i * i2);
    }

    /* renamed from: times-VKZWuLQ  reason: not valid java name */
    private static final long m8608timesVKZWuLQ(int i, long j) {
        return ULong.m8650constructorimpl(ULong.m8650constructorimpl(i & 4294967295L) * j);
    }

    /* renamed from: div-7apg3OU  reason: not valid java name */
    private static final int m8573div7apg3OU(int i, byte b) {
        return UByte$$ExternalSyntheticBackport0.m(i, m8571constructorimpl(b & 255));
    }

    /* renamed from: div-xj2QHRw  reason: not valid java name */
    private static final int m8576divxj2QHRw(int i, short s) {
        return UByte$$ExternalSyntheticBackport0.m(i, m8571constructorimpl(s & UShort.MAX_VALUE));
    }

    /* renamed from: div-WZ4Q5Ns  reason: not valid java name */
    private static final int m8575divWZ4Q5Ns(int i, int i2) {
        return UnsignedKt.m8827uintDivideJ1ME1BU(i, i2);
    }

    /* renamed from: div-VKZWuLQ  reason: not valid java name */
    private static final long m8574divVKZWuLQ(int i, long j) {
        return UByte$$ExternalSyntheticBackport0.m$1(ULong.m8650constructorimpl(i & 4294967295L), j);
    }

    /* renamed from: rem-7apg3OU  reason: not valid java name */
    private static final int m8601rem7apg3OU(int i, byte b) {
        return UByte$$ExternalSyntheticBackport0.m$1(i, m8571constructorimpl(b & 255));
    }

    /* renamed from: rem-xj2QHRw  reason: not valid java name */
    private static final int m8604remxj2QHRw(int i, short s) {
        return UByte$$ExternalSyntheticBackport0.m$1(i, m8571constructorimpl(s & UShort.MAX_VALUE));
    }

    /* renamed from: rem-WZ4Q5Ns  reason: not valid java name */
    private static final int m8603remWZ4Q5Ns(int i, int i2) {
        return UnsignedKt.m8828uintRemainderJ1ME1BU(i, i2);
    }

    /* renamed from: rem-VKZWuLQ  reason: not valid java name */
    private static final long m8602remVKZWuLQ(int i, long j) {
        return UByte$$ExternalSyntheticBackport0.m8540m(ULong.m8650constructorimpl(i & 4294967295L), j);
    }

    /* renamed from: floorDiv-7apg3OU  reason: not valid java name */
    private static final int m8579floorDiv7apg3OU(int i, byte b) {
        return UByte$$ExternalSyntheticBackport0.m(i, m8571constructorimpl(b & 255));
    }

    /* renamed from: floorDiv-xj2QHRw  reason: not valid java name */
    private static final int m8582floorDivxj2QHRw(int i, short s) {
        return UByte$$ExternalSyntheticBackport0.m(i, m8571constructorimpl(s & UShort.MAX_VALUE));
    }

    /* renamed from: floorDiv-WZ4Q5Ns  reason: not valid java name */
    private static final int m8581floorDivWZ4Q5Ns(int i, int i2) {
        return UByte$$ExternalSyntheticBackport0.m(i, i2);
    }

    /* renamed from: floorDiv-VKZWuLQ  reason: not valid java name */
    private static final long m8580floorDivVKZWuLQ(int i, long j) {
        return UByte$$ExternalSyntheticBackport0.m$1(ULong.m8650constructorimpl(i & 4294967295L), j);
    }

    /* renamed from: mod-7apg3OU  reason: not valid java name */
    private static final byte m8590mod7apg3OU(int i, byte b) {
        return UByte.m8489constructorimpl((byte) UByte$$ExternalSyntheticBackport0.m$1(i, m8571constructorimpl(b & 255)));
    }

    /* renamed from: mod-xj2QHRw  reason: not valid java name */
    private static final short m8593modxj2QHRw(int i, short s) {
        return UShort.m8757constructorimpl((short) UByte$$ExternalSyntheticBackport0.m$1(i, m8571constructorimpl(s & UShort.MAX_VALUE)));
    }

    /* renamed from: mod-WZ4Q5Ns  reason: not valid java name */
    private static final int m8592modWZ4Q5Ns(int i, int i2) {
        return UByte$$ExternalSyntheticBackport0.m$1(i, i2);
    }

    /* renamed from: mod-VKZWuLQ  reason: not valid java name */
    private static final long m8591modVKZWuLQ(int i, long j) {
        return UByte$$ExternalSyntheticBackport0.m8540m(ULong.m8650constructorimpl(i & 4294967295L), j);
    }

    /* renamed from: inc-pVg5ArA  reason: not valid java name */
    private static final int m8584incpVg5ArA(int i) {
        return m8571constructorimpl(i + 1);
    }

    /* renamed from: dec-pVg5ArA  reason: not valid java name */
    private static final int m8572decpVg5ArA(int i) {
        return m8571constructorimpl(i - 1);
    }

    /* renamed from: rangeTo-WZ4Q5Ns  reason: not valid java name */
    private static final UIntRange m8599rangeToWZ4Q5Ns(int i, int i2) {
        return new UIntRange(i, i2, null);
    }

    /* renamed from: rangeUntil-WZ4Q5Ns  reason: not valid java name */
    private static final UIntRange m8600rangeUntilWZ4Q5Ns(int i, int i2) {
        return URangesKt.m9752untilJ1ME1BU(i, i2);
    }

    /* renamed from: shl-pVg5ArA  reason: not valid java name */
    private static final int m8605shlpVg5ArA(int i, int i2) {
        return m8571constructorimpl(i << i2);
    }

    /* renamed from: shr-pVg5ArA  reason: not valid java name */
    private static final int m8606shrpVg5ArA(int i, int i2) {
        return m8571constructorimpl(i >>> i2);
    }

    /* renamed from: and-WZ4Q5Ns  reason: not valid java name */
    private static final int m8564andWZ4Q5Ns(int i, int i2) {
        return m8571constructorimpl(i & i2);
    }

    /* renamed from: or-WZ4Q5Ns  reason: not valid java name */
    private static final int m8594orWZ4Q5Ns(int i, int i2) {
        return m8571constructorimpl(i | i2);
    }

    /* renamed from: xor-WZ4Q5Ns  reason: not valid java name */
    private static final int m8622xorWZ4Q5Ns(int i, int i2) {
        return m8571constructorimpl(i ^ i2);
    }

    /* renamed from: inv-pVg5ArA  reason: not valid java name */
    private static final int m8585invpVg5ArA(int i) {
        return m8571constructorimpl(~i);
    }

    /* renamed from: toUByte-w2LRezQ  reason: not valid java name */
    private static final byte m8618toUBytew2LRezQ(int i) {
        return UByte.m8489constructorimpl((byte) i);
    }

    /* renamed from: toUShort-Mh2AYeg  reason: not valid java name */
    private static final short m8621toUShortMh2AYeg(int i) {
        return UShort.m8757constructorimpl((short) i);
    }

    /* renamed from: toULong-s-VKNKU  reason: not valid java name */
    private static final long m8620toULongsVKNKU(int i) {
        return ULong.m8650constructorimpl(i & 4294967295L);
    }

    /* renamed from: toFloat-impl  reason: not valid java name */
    private static final float m8613toFloatimpl(int i) {
        return (float) UnsignedKt.uintToDouble(i);
    }

    /* renamed from: toDouble-impl  reason: not valid java name */
    private static final double m8612toDoubleimpl(int i) {
        return UnsignedKt.uintToDouble(i);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m8617toStringimpl(int i) {
        return String.valueOf(i & 4294967295L);
    }

    public String toString() {
        return m8617toStringimpl(this.data);
    }
}
