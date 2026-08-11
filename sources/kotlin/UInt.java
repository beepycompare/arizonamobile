package kotlin;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.facebook.internal.NativeProtocol;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.UIntRange;
import kotlin.ranges.URangesKt;
/* compiled from: UInt.kt */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b-\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\b\u0087@\u0018\u0000 \u0081\u00012\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002\u0081\u0001B\u0019\bA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0002\b\u0006\u001a\u0002\b\u0007¢\u0006\u0004\b\u0004\u0010\u0005J!\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH\u0087\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0010H\u0087\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b\u0011\u0010\u0012J!\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0000H\u0097\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b\u0013\u0010\u0014J!\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0015H\u0087\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b\u0016\u0010\u0017J!\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\fH\u0087\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b\u0019\u0010\u000eJ!\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0010H\u0087\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b\u001a\u0010\u0012J!\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0000H\u0087\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b\u001b\u0010\u0014J!\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u000b\u001a\u00020\u0015H\u0087\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b\u001c\u0010\u001dJ!\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\fH\u0087\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b\u001f\u0010\u000eJ!\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0010H\u0087\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b \u0010\u0012J!\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0000H\u0087\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b!\u0010\u0014J!\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u000b\u001a\u00020\u0015H\u0087\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b\"\u0010\u001dJ!\u0010#\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\fH\u0087\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b$\u0010\u000eJ!\u0010#\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0010H\u0087\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b%\u0010\u0012J!\u0010#\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0000H\u0087\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b&\u0010\u0014J!\u0010#\u001a\u00020\u00152\u0006\u0010\u000b\u001a\u00020\u0015H\u0087\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b'\u0010\u001dJ!\u0010(\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\fH\u0087\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b)\u0010\u000eJ!\u0010(\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0010H\u0087\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b*\u0010\u0012J!\u0010(\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0000H\u0087\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b+\u0010\u0014J!\u0010(\u001a\u00020\u00152\u0006\u0010\u000b\u001a\u00020\u0015H\u0087\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b,\u0010\u001dJ!\u0010-\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\fH\u0087\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b.\u0010\u000eJ!\u0010-\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0010H\u0087\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b/\u0010\u0012J!\u0010-\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0000H\u0087\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b0\u0010\u0014J!\u0010-\u001a\u00020\u00152\u0006\u0010\u000b\u001a\u00020\u0015H\u0087\u008a\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b1\u0010\u001dJ!\u00102\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\fH\u0087\u0088\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b3\u0010\u000eJ!\u00102\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0010H\u0087\u0088\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b4\u0010\u0012J!\u00102\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0000H\u0087\u0088\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b5\u0010\u0014J!\u00102\u001a\u00020\u00152\u0006\u0010\u000b\u001a\u00020\u0015H\u0087\u0088\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b6\u0010\u001dJ!\u00107\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\fH\u0087\u0088\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b8\u00109J!\u00107\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\u0010H\u0087\u0088\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b:\u0010;J!\u00107\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0000H\u0087\u0088\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b<\u0010\u0014J!\u00107\u001a\u00020\u00152\u0006\u0010\u000b\u001a\u00020\u0015H\u0087\u0088\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b=\u0010\u001dJ\u0015\u0010>\u001a\u00020\u0000H\u0087\u008a\u0004b\u0002\b\u000f¢\u0006\u0004\b?\u0010\u0005J\u0015\u0010@\u001a\u00020\u0000H\u0087\u008a\u0004b\u0002\b\u000f¢\u0006\u0004\bA\u0010\u0005J\u001d\u0010B\u001a\u00020C2\u0006\u0010\u000b\u001a\u00020\u0000H\u0087\u008a\u0004b\u0002\b\u000f¢\u0006\u0004\bD\u0010EJ=\u0010F\u001a\u00020C2\u0006\u0010\u000b\u001a\u00020\u0000H\u0087\u008a\u0004b\f\bH\u0012\b\bI\u0012\u0004\b\b(Jb\u0010\bK\u0012\f\bL\u0012\b\b\fJ\u0004\b\t0Mb\u0002\b\u000f¢\u0006\u0004\bG\u0010EJ!\u0010N\u001a\u00020\u00002\u0006\u0010O\u001a\u00020\u0003H\u0087\u008c\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\bP\u0010\u0014J!\u0010Q\u001a\u00020\u00002\u0006\u0010O\u001a\u00020\u0003H\u0087\u008c\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\bR\u0010\u0014J!\u0010S\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0000H\u0087\u008c\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\bT\u0010\u0014J!\u0010U\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0000H\u0087\u008c\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\bV\u0010\u0014J!\u0010W\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0000H\u0087\u008c\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\bX\u0010\u0014J\u0019\u0010Y\u001a\u00020\u0000H\u0087\u0088\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\bZ\u0010\u0005J\u0019\u0010[\u001a\u00020\\H\u0087\u0088\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\b]\u0010^J\u0019\u0010_\u001a\u00020`H\u0087\u0088\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\ba\u0010bJ\u0019\u0010c\u001a\u00020\u0003H\u0087\u0088\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\bd\u0010\u0005J\u0019\u0010e\u001a\u00020fH\u0087\u0088\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\bg\u0010hJ\u0019\u0010i\u001a\u00020\fH\u0087\u0088\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\bj\u0010^J\u0019\u0010k\u001a\u00020\u0010H\u0087\u0088\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\bl\u0010bJ\u0019\u0010m\u001a\u00020\u0000H\u0087\u0088\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\bn\u0010\u0005J\u0019\u0010o\u001a\u00020\u0015H\u0087\u0088\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\bp\u0010hJ\u0019\u0010q\u001a\u00020rH\u0087\u0088\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\bs\u0010tJ\u0019\u0010u\u001a\u00020vH\u0087\u0088\u0004b\u0002\b\u000fb\u0002\b\u0006¢\u0006\u0004\bw\u0010xJ\u0015\u0010y\u001a\u00020zH\u0097\u0080\u0004b\u0002\b\u0006¢\u0006\u0004\b{\u0010|J\u0014\u0010}\u001a\u00020~2\b\u0010\u000b\u001a\u0004\u0018\u00010\u007fHÖ\u0083\u0004J\u000b\u0010\u0080\u0001\u001a\u00020\u0003HÖ\u0081\u0004R\u001b\u0010\u0002\u001a\u00020\u00038\u0000X\u0081\u0084\br\u0002\b\u0007¢\u0006\b\n\u0000\u0012\u0004\b\b\u0010\t\u0088\u0001\u0002\u0092\u0001\u00020\u0003Ê\u0001\r\bH\u0012\t\bI\u0012\u0005\b\b(\u0083\u0001Ê\u0001\u0003\b\u0084\u0001¨\u0006\u0082\u0001"}, d2 = {"Lkotlin/UInt;", "", "data", "", "constructor-impl", "(I)I", "Lkotlin/internal/IntrinsicConstEvaluation;", "Lkotlin/PublishedApi;", "getData$annotations", "()V", "compareTo", "other", "Lkotlin/UByte;", "compareTo-7apg3OU", "(IB)I", "Lkotlin/internal/InlineOnly;", "Lkotlin/UShort;", "compareTo-xj2QHRw", "(IS)I", "compareTo-WZ4Q5Ns", "(II)I", "Lkotlin/ULong;", "compareTo-VKZWuLQ", "(IJ)I", "plus", "plus-7apg3OU", "plus-xj2QHRw", "plus-WZ4Q5Ns", "plus-VKZWuLQ", "(IJ)J", "minus", "minus-7apg3OU", "minus-xj2QHRw", "minus-WZ4Q5Ns", "minus-VKZWuLQ", "times", "times-7apg3OU", "times-xj2QHRw", "times-WZ4Q5Ns", "times-VKZWuLQ", TtmlNode.TAG_DIV, "div-7apg3OU", "div-xj2QHRw", "div-WZ4Q5Ns", "div-VKZWuLQ", "rem", "rem-7apg3OU", "rem-xj2QHRw", "rem-WZ4Q5Ns", "rem-VKZWuLQ", "floorDiv", "floorDiv-7apg3OU", "floorDiv-xj2QHRw", "floorDiv-WZ4Q5Ns", "floorDiv-VKZWuLQ", "mod", "mod-7apg3OU", "(IB)B", "mod-xj2QHRw", "(IS)S", "mod-WZ4Q5Ns", "mod-VKZWuLQ", "inc", "inc-pVg5ArA", "dec", "dec-pVg5ArA", "rangeTo", "Lkotlin/ranges/UIntRange;", "rangeTo-WZ4Q5Ns", "(II)Lkotlin/ranges/UIntRange;", "rangeUntil", "rangeUntil-WZ4Q5Ns", "Lkotlin/SinceKotlin;", NativeProtocol.PLATFORM_PROVIDER_VERSION_COLUMN, "1.9", "Lkotlin/WasExperimental;", "markerClass", "Lkotlin/ExperimentalStdlibApi;", "shl", "bitCount", "shl-pVg5ArA", "shr", "shr-pVg5ArA", "and", "and-WZ4Q5Ns", "or", "or-WZ4Q5Ns", "xor", "xor-WZ4Q5Ns", "inv", "inv-pVg5ArA", "toByte", "", "toByte-impl", "(I)B", "toShort", "", "toShort-impl", "(I)S", "toInt", "toInt-impl", "toLong", "", "toLong-impl", "(I)J", "toUByte", "toUByte-w2LRezQ", "toUShort", "toUShort-Mh2AYeg", "toUInt", "toUInt-pVg5ArA", "toULong", "toULong-s-VKNKU", "toFloat", "", "toFloat-impl", "(I)F", "toDouble", "", "toDouble-impl", "(I)D", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "equals", "", "", "hashCode", "Companion", "kotlin-stdlib", "1.5", "Lkotlin/jvm/JvmInline;"}, k = 1, mv = {2, 4, 0}, xi = 48)
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
    public static final /* synthetic */ UInt m10010boximpl(int i) {
        return new UInt(i);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static int m10016constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m10022equalsimpl(int i, Object obj) {
        return (obj instanceof UInt) && i == ((UInt) obj).m10068unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m10023equalsimpl0(int i, int i2) {
        return i == i2;
    }

    public static /* synthetic */ void getData$annotations() {
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m10028hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    /* renamed from: toByte-impl  reason: not valid java name */
    private static final byte m10056toByteimpl(int i) {
        return (byte) i;
    }

    /* renamed from: toInt-impl  reason: not valid java name */
    private static final int m10059toIntimpl(int i) {
        return i;
    }

    /* renamed from: toLong-impl  reason: not valid java name */
    private static final long m10060toLongimpl(int i) {
        return i & 4294967295L;
    }

    /* renamed from: toShort-impl  reason: not valid java name */
    private static final short m10061toShortimpl(int i) {
        return (short) i;
    }

    /* renamed from: toUInt-pVg5ArA  reason: not valid java name */
    private static final int m10064toUIntpVg5ArA(int i) {
        return i;
    }

    public boolean equals(Object obj) {
        return m10022equalsimpl(this.data, obj);
    }

    public int hashCode() {
        return m10028hashCodeimpl(this.data);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ int m10068unboximpl() {
        return this.data;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(UInt uInt) {
        return UnsignedKt.uintCompare(m10068unboximpl(), uInt.m10068unboximpl());
    }

    private /* synthetic */ UInt(int i) {
        this.data = i;
    }

    /* compiled from: UInt.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005X\u0086Ô\b¢\u0006\u0004\n\u0002\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0005X\u0086Ô\b¢\u0006\u0004\n\u0002\u0010\u0006R\u000f\u0010\b\u001a\u00020\tX\u0086Ô\b¢\u0006\u0002\n\u0000R\u000f\u0010\n\u001a\u00020\tX\u0086Ô\b¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lkotlin/UInt$Companion;", "", "<init>", "()V", "MIN_VALUE", "Lkotlin/UInt;", "I", "MAX_VALUE", "SIZE_BYTES", "", "SIZE_BITS", "kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* renamed from: compareTo-7apg3OU  reason: not valid java name */
    private static final int m10011compareTo7apg3OU(int i, byte b) {
        int compare;
        compare = Integer.compare(i ^ Integer.MIN_VALUE, m10016constructorimpl(b & 255) ^ Integer.MIN_VALUE);
        return compare;
    }

    /* renamed from: compareTo-xj2QHRw  reason: not valid java name */
    private static final int m10015compareToxj2QHRw(int i, short s) {
        int compare;
        compare = Integer.compare(i ^ Integer.MIN_VALUE, m10016constructorimpl(s & UShort.MAX_VALUE) ^ Integer.MIN_VALUE);
        return compare;
    }

    /* renamed from: compareTo-WZ4Q5Ns  reason: not valid java name */
    private int m10013compareToWZ4Q5Ns(int i) {
        return UnsignedKt.uintCompare(m10068unboximpl(), i);
    }

    /* renamed from: compareTo-WZ4Q5Ns  reason: not valid java name */
    private static int m10014compareToWZ4Q5Ns(int i, int i2) {
        return UnsignedKt.uintCompare(i, i2);
    }

    /* renamed from: compareTo-VKZWuLQ  reason: not valid java name */
    private static final int m10012compareToVKZWuLQ(int i, long j) {
        int compare;
        compare = Long.compare(ULong.m10095constructorimpl(i & 4294967295L) ^ Long.MIN_VALUE, j ^ Long.MIN_VALUE);
        return compare;
    }

    /* renamed from: plus-7apg3OU  reason: not valid java name */
    private static final int m10040plus7apg3OU(int i, byte b) {
        return m10016constructorimpl(i + m10016constructorimpl(b & 255));
    }

    /* renamed from: plus-xj2QHRw  reason: not valid java name */
    private static final int m10043plusxj2QHRw(int i, short s) {
        return m10016constructorimpl(i + m10016constructorimpl(s & UShort.MAX_VALUE));
    }

    /* renamed from: plus-WZ4Q5Ns  reason: not valid java name */
    private static final int m10042plusWZ4Q5Ns(int i, int i2) {
        return m10016constructorimpl(i + i2);
    }

    /* renamed from: plus-VKZWuLQ  reason: not valid java name */
    private static final long m10041plusVKZWuLQ(int i, long j) {
        return ULong.m10095constructorimpl(ULong.m10095constructorimpl(i & 4294967295L) + j);
    }

    /* renamed from: minus-7apg3OU  reason: not valid java name */
    private static final int m10031minus7apg3OU(int i, byte b) {
        return m10016constructorimpl(i - m10016constructorimpl(b & 255));
    }

    /* renamed from: minus-xj2QHRw  reason: not valid java name */
    private static final int m10034minusxj2QHRw(int i, short s) {
        return m10016constructorimpl(i - m10016constructorimpl(s & UShort.MAX_VALUE));
    }

    /* renamed from: minus-WZ4Q5Ns  reason: not valid java name */
    private static final int m10033minusWZ4Q5Ns(int i, int i2) {
        return m10016constructorimpl(i - i2);
    }

    /* renamed from: minus-VKZWuLQ  reason: not valid java name */
    private static final long m10032minusVKZWuLQ(int i, long j) {
        return ULong.m10095constructorimpl(ULong.m10095constructorimpl(i & 4294967295L) - j);
    }

    /* renamed from: times-7apg3OU  reason: not valid java name */
    private static final int m10052times7apg3OU(int i, byte b) {
        return m10016constructorimpl(i * m10016constructorimpl(b & 255));
    }

    /* renamed from: times-xj2QHRw  reason: not valid java name */
    private static final int m10055timesxj2QHRw(int i, short s) {
        return m10016constructorimpl(i * m10016constructorimpl(s & UShort.MAX_VALUE));
    }

    /* renamed from: times-WZ4Q5Ns  reason: not valid java name */
    private static final int m10054timesWZ4Q5Ns(int i, int i2) {
        return m10016constructorimpl(i * i2);
    }

    /* renamed from: times-VKZWuLQ  reason: not valid java name */
    private static final long m10053timesVKZWuLQ(int i, long j) {
        return ULong.m10095constructorimpl(ULong.m10095constructorimpl(i & 4294967295L) * j);
    }

    /* renamed from: div-7apg3OU  reason: not valid java name */
    private static final int m10018div7apg3OU(int i, byte b) {
        return UByte$$ExternalSyntheticBackport0.m(i, m10016constructorimpl(b & 255));
    }

    /* renamed from: div-xj2QHRw  reason: not valid java name */
    private static final int m10021divxj2QHRw(int i, short s) {
        return UByte$$ExternalSyntheticBackport0.m(i, m10016constructorimpl(s & UShort.MAX_VALUE));
    }

    /* renamed from: div-WZ4Q5Ns  reason: not valid java name */
    private static final int m10020divWZ4Q5Ns(int i, int i2) {
        return UnsignedKt.m10272uintDivideJ1ME1BU(i, i2);
    }

    /* renamed from: div-VKZWuLQ  reason: not valid java name */
    private static final long m10019divVKZWuLQ(int i, long j) {
        return UByte$$ExternalSyntheticBackport0.m9984m(ULong.m10095constructorimpl(i & 4294967295L), j);
    }

    /* renamed from: rem-7apg3OU  reason: not valid java name */
    private static final int m10046rem7apg3OU(int i, byte b) {
        return UByte$$ExternalSyntheticBackport0.m$1(i, m10016constructorimpl(b & 255));
    }

    /* renamed from: rem-xj2QHRw  reason: not valid java name */
    private static final int m10049remxj2QHRw(int i, short s) {
        return UByte$$ExternalSyntheticBackport0.m$1(i, m10016constructorimpl(s & UShort.MAX_VALUE));
    }

    /* renamed from: rem-WZ4Q5Ns  reason: not valid java name */
    private static final int m10048remWZ4Q5Ns(int i, int i2) {
        return UnsignedKt.m10273uintRemainderJ1ME1BU(i, i2);
    }

    /* renamed from: rem-VKZWuLQ  reason: not valid java name */
    private static final long m10047remVKZWuLQ(int i, long j) {
        return UByte$$ExternalSyntheticBackport0.m$1(ULong.m10095constructorimpl(i & 4294967295L), j);
    }

    /* renamed from: floorDiv-7apg3OU  reason: not valid java name */
    private static final int m10024floorDiv7apg3OU(int i, byte b) {
        return UByte$$ExternalSyntheticBackport0.m(i, m10016constructorimpl(b & 255));
    }

    /* renamed from: floorDiv-xj2QHRw  reason: not valid java name */
    private static final int m10027floorDivxj2QHRw(int i, short s) {
        return UByte$$ExternalSyntheticBackport0.m(i, m10016constructorimpl(s & UShort.MAX_VALUE));
    }

    /* renamed from: floorDiv-WZ4Q5Ns  reason: not valid java name */
    private static final int m10026floorDivWZ4Q5Ns(int i, int i2) {
        return UByte$$ExternalSyntheticBackport0.m(i, i2);
    }

    /* renamed from: floorDiv-VKZWuLQ  reason: not valid java name */
    private static final long m10025floorDivVKZWuLQ(int i, long j) {
        return UByte$$ExternalSyntheticBackport0.m9984m(ULong.m10095constructorimpl(i & 4294967295L), j);
    }

    /* renamed from: mod-7apg3OU  reason: not valid java name */
    private static final byte m10035mod7apg3OU(int i, byte b) {
        return UByte.m9933constructorimpl((byte) UByte$$ExternalSyntheticBackport0.m$1(i, m10016constructorimpl(b & 255)));
    }

    /* renamed from: mod-xj2QHRw  reason: not valid java name */
    private static final short m10038modxj2QHRw(int i, short s) {
        return UShort.m10202constructorimpl((short) UByte$$ExternalSyntheticBackport0.m$1(i, m10016constructorimpl(s & UShort.MAX_VALUE)));
    }

    /* renamed from: mod-WZ4Q5Ns  reason: not valid java name */
    private static final int m10037modWZ4Q5Ns(int i, int i2) {
        return UByte$$ExternalSyntheticBackport0.m$1(i, i2);
    }

    /* renamed from: mod-VKZWuLQ  reason: not valid java name */
    private static final long m10036modVKZWuLQ(int i, long j) {
        return UByte$$ExternalSyntheticBackport0.m$1(ULong.m10095constructorimpl(i & 4294967295L), j);
    }

    /* renamed from: inc-pVg5ArA  reason: not valid java name */
    private static final int m10029incpVg5ArA(int i) {
        return m10016constructorimpl(i + 1);
    }

    /* renamed from: dec-pVg5ArA  reason: not valid java name */
    private static final int m10017decpVg5ArA(int i) {
        return m10016constructorimpl(i - 1);
    }

    /* renamed from: rangeTo-WZ4Q5Ns  reason: not valid java name */
    private static final UIntRange m10044rangeToWZ4Q5Ns(int i, int i2) {
        return new UIntRange(i, i2, null);
    }

    /* renamed from: rangeUntil-WZ4Q5Ns  reason: not valid java name */
    private static final UIntRange m10045rangeUntilWZ4Q5Ns(int i, int i2) {
        return URangesKt.m11224untilJ1ME1BU(i, i2);
    }

    /* renamed from: shl-pVg5ArA  reason: not valid java name */
    private static final int m10050shlpVg5ArA(int i, int i2) {
        return m10016constructorimpl(i << i2);
    }

    /* renamed from: shr-pVg5ArA  reason: not valid java name */
    private static final int m10051shrpVg5ArA(int i, int i2) {
        return m10016constructorimpl(i >>> i2);
    }

    /* renamed from: and-WZ4Q5Ns  reason: not valid java name */
    private static final int m10009andWZ4Q5Ns(int i, int i2) {
        return m10016constructorimpl(i & i2);
    }

    /* renamed from: or-WZ4Q5Ns  reason: not valid java name */
    private static final int m10039orWZ4Q5Ns(int i, int i2) {
        return m10016constructorimpl(i | i2);
    }

    /* renamed from: xor-WZ4Q5Ns  reason: not valid java name */
    private static final int m10067xorWZ4Q5Ns(int i, int i2) {
        return m10016constructorimpl(i ^ i2);
    }

    /* renamed from: inv-pVg5ArA  reason: not valid java name */
    private static final int m10030invpVg5ArA(int i) {
        return m10016constructorimpl(~i);
    }

    /* renamed from: toUByte-w2LRezQ  reason: not valid java name */
    private static final byte m10063toUBytew2LRezQ(int i) {
        return UByte.m9933constructorimpl((byte) i);
    }

    /* renamed from: toUShort-Mh2AYeg  reason: not valid java name */
    private static final short m10066toUShortMh2AYeg(int i) {
        return UShort.m10202constructorimpl((short) i);
    }

    /* renamed from: toULong-s-VKNKU  reason: not valid java name */
    private static final long m10065toULongsVKNKU(int i) {
        return ULong.m10095constructorimpl(i & 4294967295L);
    }

    /* renamed from: toFloat-impl  reason: not valid java name */
    private static final float m10058toFloatimpl(int i) {
        return (float) UnsignedKt.uintToDouble(i);
    }

    /* renamed from: toDouble-impl  reason: not valid java name */
    private static final double m10057toDoubleimpl(int i) {
        return UnsignedKt.uintToDouble(i);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m10062toStringimpl(int i) {
        return String.valueOf(i & 4294967295L);
    }

    public String toString() {
        return m10062toStringimpl(this.data);
    }
}
