package kotlin;

import androidx.exifinterface.media.ExifInterface;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.facebook.internal.NativeProtocol;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.UIntRange;
import kotlin.ranges.URangesKt;
import okhttp3.internal.ws.WebSocketProtocol;
/* compiled from: UShort.kt */
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b-\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0005\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\b\u0087@\u0018\u0000 |2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001|B\u0019\bA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0002\b\u0006\u001a\u0002\b\u0007¢\u0006\u0004\b\u0004\u0010\u0005J!\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0087\u008a\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0000H\u0097\u008a\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b\u0011\u0010\u0012J!\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0013H\u0087\u008a\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b\u0014\u0010\u0015J!\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0016H\u0087\u008a\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b\u0017\u0010\u0018J!\u0010\u0019\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\rH\u0087\u008a\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b\u001a\u0010\u000fJ!\u0010\u0019\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0000H\u0087\u008a\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b\u001b\u0010\u0012J!\u0010\u0019\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0013H\u0087\u008a\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b\u001c\u0010\u0015J!\u0010\u0019\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\u0016H\u0087\u008a\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b\u001d\u0010\u001eJ!\u0010\u001f\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\rH\u0087\u008a\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b \u0010\u000fJ!\u0010\u001f\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0000H\u0087\u008a\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b!\u0010\u0012J!\u0010\u001f\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0013H\u0087\u008a\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b\"\u0010\u0015J!\u0010\u001f\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\u0016H\u0087\u008a\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b#\u0010\u001eJ!\u0010$\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\rH\u0087\u008a\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b%\u0010\u000fJ!\u0010$\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0000H\u0087\u008a\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b&\u0010\u0012J!\u0010$\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0013H\u0087\u008a\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b'\u0010\u0015J!\u0010$\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\u0016H\u0087\u008a\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b(\u0010\u001eJ!\u0010)\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\rH\u0087\u008a\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b*\u0010\u000fJ!\u0010)\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0000H\u0087\u008a\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b+\u0010\u0012J!\u0010)\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0013H\u0087\u008a\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b,\u0010\u0015J!\u0010)\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\u0016H\u0087\u008a\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b-\u0010\u001eJ!\u0010.\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\rH\u0087\u008a\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b/\u0010\u000fJ!\u0010.\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0000H\u0087\u008a\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b0\u0010\u0012J!\u0010.\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0013H\u0087\u008a\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b1\u0010\u0015J!\u0010.\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\u0016H\u0087\u008a\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b2\u0010\u001eJ!\u00103\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\rH\u0087\u0088\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b4\u0010\u000fJ!\u00103\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0000H\u0087\u0088\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b5\u0010\u0012J!\u00103\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0013H\u0087\u0088\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b6\u0010\u0015J!\u00103\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\u0016H\u0087\u0088\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b7\u0010\u001eJ!\u00108\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\rH\u0087\u0088\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b9\u0010:J!\u00108\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0000H\u0087\u0088\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b;\u0010<J!\u00108\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0013H\u0087\u0088\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b=\u0010\u0015J!\u00108\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\u0016H\u0087\u0088\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b>\u0010\u001eJ\u0015\u0010?\u001a\u00020\u0000H\u0087\u008a\u0004b\u0002\b\u0010¢\u0006\u0004\b@\u0010\u0005J\u0015\u0010A\u001a\u00020\u0000H\u0087\u008a\u0004b\u0002\b\u0010¢\u0006\u0004\bB\u0010\u0005J\u001d\u0010C\u001a\u00020D2\u0006\u0010\f\u001a\u00020\u0000H\u0087\u008a\u0004b\u0002\b\u0010¢\u0006\u0004\bE\u0010FJ=\u0010G\u001a\u00020D2\u0006\u0010\f\u001a\u00020\u0000H\u0087\u008a\u0004b\f\bI\u0012\b\bJ\u0012\u0004\b\b(Kb\u0010\bL\u0012\f\bM\u0012\b\b\fJ\u0004\b\t0Nb\u0002\b\u0010¢\u0006\u0004\bH\u0010FJ!\u0010O\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0000H\u0087\u008c\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\bP\u0010<J!\u0010Q\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0000H\u0087\u008c\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\bR\u0010<J!\u0010S\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0000H\u0087\u008c\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\bT\u0010<J\u0019\u0010U\u001a\u00020\u0000H\u0087\u0088\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\bV\u0010\u0005J\u0019\u0010W\u001a\u00020XH\u0087\u0088\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\bY\u0010ZJ\u0019\u0010[\u001a\u00020\u0003H\u0087\u0088\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b\\\u0010\u0005J\u0019\u0010]\u001a\u00020\u000bH\u0087\u0088\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\b^\u0010_J\u0019\u0010`\u001a\u00020aH\u0087\u0088\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\bb\u0010cJ\u0019\u0010d\u001a\u00020\rH\u0087\u0088\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\be\u0010ZJ\u0019\u0010f\u001a\u00020\u0000H\u0087\u0088\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\bg\u0010\u0005J\u0019\u0010h\u001a\u00020\u0013H\u0087\u0088\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\bi\u0010_J\u0019\u0010j\u001a\u00020\u0016H\u0087\u0088\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\bk\u0010cJ\u0019\u0010l\u001a\u00020mH\u0087\u0088\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\bn\u0010oJ\u0019\u0010p\u001a\u00020qH\u0087\u0088\u0004b\u0002\b\u0010b\u0002\b\u0006¢\u0006\u0004\br\u0010sJ\u0015\u0010t\u001a\u00020uH\u0097\u0080\u0004b\u0002\b\u0006¢\u0006\u0004\bv\u0010wJ\u0014\u0010x\u001a\u00020y2\b\u0010\f\u001a\u0004\u0018\u00010zHÖ\u0083\u0004J\n\u0010{\u001a\u00020\u000bHÖ\u0081\u0004R\u001b\u0010\u0002\u001a\u00020\u00038\u0000X\u0081\u0084\br\u0002\b\u0007¢\u0006\b\n\u0000\u0012\u0004\b\b\u0010\t\u0088\u0001\u0002\u0092\u0001\u00020\u0003Ê\u0001\f\bI\u0012\b\bJ\u0012\u0004\b\b(~Ê\u0001\u0002\b\u007f¨\u0006}"}, d2 = {"Lkotlin/UShort;", "", "data", "", "constructor-impl", "(S)S", "Lkotlin/internal/IntrinsicConstEvaluation;", "Lkotlin/PublishedApi;", "getData$annotations", "()V", "compareTo", "", "other", "Lkotlin/UByte;", "compareTo-7apg3OU", "(SB)I", "Lkotlin/internal/InlineOnly;", "compareTo-xj2QHRw", "(SS)I", "Lkotlin/UInt;", "compareTo-WZ4Q5Ns", "(SI)I", "Lkotlin/ULong;", "compareTo-VKZWuLQ", "(SJ)I", "plus", "plus-7apg3OU", "plus-xj2QHRw", "plus-WZ4Q5Ns", "plus-VKZWuLQ", "(SJ)J", "minus", "minus-7apg3OU", "minus-xj2QHRw", "minus-WZ4Q5Ns", "minus-VKZWuLQ", "times", "times-7apg3OU", "times-xj2QHRw", "times-WZ4Q5Ns", "times-VKZWuLQ", TtmlNode.TAG_DIV, "div-7apg3OU", "div-xj2QHRw", "div-WZ4Q5Ns", "div-VKZWuLQ", "rem", "rem-7apg3OU", "rem-xj2QHRw", "rem-WZ4Q5Ns", "rem-VKZWuLQ", "floorDiv", "floorDiv-7apg3OU", "floorDiv-xj2QHRw", "floorDiv-WZ4Q5Ns", "floorDiv-VKZWuLQ", "mod", "mod-7apg3OU", "(SB)B", "mod-xj2QHRw", "(SS)S", "mod-WZ4Q5Ns", "mod-VKZWuLQ", "inc", "inc-Mh2AYeg", "dec", "dec-Mh2AYeg", "rangeTo", "Lkotlin/ranges/UIntRange;", "rangeTo-xj2QHRw", "(SS)Lkotlin/ranges/UIntRange;", "rangeUntil", "rangeUntil-xj2QHRw", "Lkotlin/SinceKotlin;", NativeProtocol.PLATFORM_PROVIDER_VERSION_COLUMN, "1.9", "Lkotlin/WasExperimental;", "markerClass", "Lkotlin/ExperimentalStdlibApi;", "and", "and-xj2QHRw", "or", "or-xj2QHRw", "xor", "xor-xj2QHRw", "inv", "inv-Mh2AYeg", "toByte", "", "toByte-impl", "(S)B", "toShort", "toShort-impl", "toInt", "toInt-impl", "(S)I", "toLong", "", "toLong-impl", "(S)J", "toUByte", "toUByte-w2LRezQ", "toUShort", "toUShort-Mh2AYeg", "toUInt", "toUInt-pVg5ArA", "toULong", "toULong-s-VKNKU", "toFloat", "", "toFloat-impl", "(S)F", "toDouble", "", "toDouble-impl", "(S)D", "toString", "", "toString-impl", "(S)Ljava/lang/String;", "equals", "", "", "hashCode", "Companion", "kotlin-stdlib", "1.5", "Lkotlin/jvm/JvmInline;"}, k = 1, mv = {2, 4, 0}, xi = 48)
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
    public static final /* synthetic */ UShort m10196boximpl(short s) {
        return new UShort(s);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static short m10202constructorimpl(short s) {
        return s;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m10208equalsimpl(short s, Object obj) {
        return (obj instanceof UShort) && s == ((UShort) obj).m10252unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m10209equalsimpl0(short s, short s2) {
        return s == s2;
    }

    public static /* synthetic */ void getData$annotations() {
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m10214hashCodeimpl(short s) {
        return Short.hashCode(s);
    }

    /* renamed from: toByte-impl  reason: not valid java name */
    private static final byte m10240toByteimpl(short s) {
        return (byte) s;
    }

    /* renamed from: toInt-impl  reason: not valid java name */
    private static final int m10243toIntimpl(short s) {
        return s & MAX_VALUE;
    }

    /* renamed from: toLong-impl  reason: not valid java name */
    private static final long m10244toLongimpl(short s) {
        return s & WebSocketProtocol.PAYLOAD_SHORT_MAX;
    }

    /* renamed from: toShort-impl  reason: not valid java name */
    private static final short m10245toShortimpl(short s) {
        return s;
    }

    /* renamed from: toUShort-Mh2AYeg  reason: not valid java name */
    private static final short m10250toUShortMh2AYeg(short s) {
        return s;
    }

    public boolean equals(Object obj) {
        return m10208equalsimpl(this.data, obj);
    }

    public int hashCode() {
        return m10214hashCodeimpl(this.data);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ short m10252unboximpl() {
        return this.data;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(UShort uShort) {
        return Intrinsics.compare(m10252unboximpl() & MAX_VALUE, uShort.m10252unboximpl() & MAX_VALUE);
    }

    private /* synthetic */ UShort(short s) {
        this.data = s;
    }

    /* compiled from: UShort.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005X\u0086Ô\b¢\u0006\u0004\n\u0002\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0005X\u0086Ô\b¢\u0006\u0004\n\u0002\u0010\u0006R\u000f\u0010\b\u001a\u00020\tX\u0086Ô\b¢\u0006\u0002\n\u0000R\u000f\u0010\n\u001a\u00020\tX\u0086Ô\b¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lkotlin/UShort$Companion;", "", "<init>", "()V", "MIN_VALUE", "Lkotlin/UShort;", ExifInterface.LATITUDE_SOUTH, "MAX_VALUE", "SIZE_BYTES", "", "SIZE_BITS", "kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* renamed from: compareTo-7apg3OU  reason: not valid java name */
    private static final int m10197compareTo7apg3OU(short s, byte b) {
        return Intrinsics.compare(s & MAX_VALUE, b & 255);
    }

    /* renamed from: compareTo-xj2QHRw  reason: not valid java name */
    private int m10200compareToxj2QHRw(short s) {
        return Intrinsics.compare(m10252unboximpl() & MAX_VALUE, s & MAX_VALUE);
    }

    /* renamed from: compareTo-xj2QHRw  reason: not valid java name */
    private static int m10201compareToxj2QHRw(short s, short s2) {
        return Intrinsics.compare(s & MAX_VALUE, s2 & MAX_VALUE);
    }

    /* renamed from: compareTo-WZ4Q5Ns  reason: not valid java name */
    private static final int m10199compareToWZ4Q5Ns(short s, int i) {
        int compare;
        compare = Integer.compare(UInt.m10016constructorimpl(s & MAX_VALUE) ^ Integer.MIN_VALUE, i ^ Integer.MIN_VALUE);
        return compare;
    }

    /* renamed from: compareTo-VKZWuLQ  reason: not valid java name */
    private static final int m10198compareToVKZWuLQ(short s, long j) {
        int compare;
        compare = Long.compare(ULong.m10095constructorimpl(s & WebSocketProtocol.PAYLOAD_SHORT_MAX) ^ Long.MIN_VALUE, j ^ Long.MIN_VALUE);
        return compare;
    }

    /* renamed from: plus-7apg3OU  reason: not valid java name */
    private static final int m10226plus7apg3OU(short s, byte b) {
        return UInt.m10016constructorimpl(UInt.m10016constructorimpl(s & MAX_VALUE) + UInt.m10016constructorimpl(b & 255));
    }

    /* renamed from: plus-xj2QHRw  reason: not valid java name */
    private static final int m10229plusxj2QHRw(short s, short s2) {
        return UInt.m10016constructorimpl(UInt.m10016constructorimpl(s & MAX_VALUE) + UInt.m10016constructorimpl(s2 & MAX_VALUE));
    }

    /* renamed from: plus-WZ4Q5Ns  reason: not valid java name */
    private static final int m10228plusWZ4Q5Ns(short s, int i) {
        return UInt.m10016constructorimpl(UInt.m10016constructorimpl(s & MAX_VALUE) + i);
    }

    /* renamed from: plus-VKZWuLQ  reason: not valid java name */
    private static final long m10227plusVKZWuLQ(short s, long j) {
        return ULong.m10095constructorimpl(ULong.m10095constructorimpl(s & WebSocketProtocol.PAYLOAD_SHORT_MAX) + j);
    }

    /* renamed from: minus-7apg3OU  reason: not valid java name */
    private static final int m10217minus7apg3OU(short s, byte b) {
        return UInt.m10016constructorimpl(UInt.m10016constructorimpl(s & MAX_VALUE) - UInt.m10016constructorimpl(b & 255));
    }

    /* renamed from: minus-xj2QHRw  reason: not valid java name */
    private static final int m10220minusxj2QHRw(short s, short s2) {
        return UInt.m10016constructorimpl(UInt.m10016constructorimpl(s & MAX_VALUE) - UInt.m10016constructorimpl(s2 & MAX_VALUE));
    }

    /* renamed from: minus-WZ4Q5Ns  reason: not valid java name */
    private static final int m10219minusWZ4Q5Ns(short s, int i) {
        return UInt.m10016constructorimpl(UInt.m10016constructorimpl(s & MAX_VALUE) - i);
    }

    /* renamed from: minus-VKZWuLQ  reason: not valid java name */
    private static final long m10218minusVKZWuLQ(short s, long j) {
        return ULong.m10095constructorimpl(ULong.m10095constructorimpl(s & WebSocketProtocol.PAYLOAD_SHORT_MAX) - j);
    }

    /* renamed from: times-7apg3OU  reason: not valid java name */
    private static final int m10236times7apg3OU(short s, byte b) {
        return UInt.m10016constructorimpl(UInt.m10016constructorimpl(s & MAX_VALUE) * UInt.m10016constructorimpl(b & 255));
    }

    /* renamed from: times-xj2QHRw  reason: not valid java name */
    private static final int m10239timesxj2QHRw(short s, short s2) {
        return UInt.m10016constructorimpl(UInt.m10016constructorimpl(s & MAX_VALUE) * UInt.m10016constructorimpl(s2 & MAX_VALUE));
    }

    /* renamed from: times-WZ4Q5Ns  reason: not valid java name */
    private static final int m10238timesWZ4Q5Ns(short s, int i) {
        return UInt.m10016constructorimpl(UInt.m10016constructorimpl(s & MAX_VALUE) * i);
    }

    /* renamed from: times-VKZWuLQ  reason: not valid java name */
    private static final long m10237timesVKZWuLQ(short s, long j) {
        return ULong.m10095constructorimpl(ULong.m10095constructorimpl(s & WebSocketProtocol.PAYLOAD_SHORT_MAX) * j);
    }

    /* renamed from: div-7apg3OU  reason: not valid java name */
    private static final int m10204div7apg3OU(short s, byte b) {
        return UByte$$ExternalSyntheticBackport0.m(UInt.m10016constructorimpl(s & MAX_VALUE), UInt.m10016constructorimpl(b & 255));
    }

    /* renamed from: div-xj2QHRw  reason: not valid java name */
    private static final int m10207divxj2QHRw(short s, short s2) {
        return UByte$$ExternalSyntheticBackport0.m(UInt.m10016constructorimpl(s & MAX_VALUE), UInt.m10016constructorimpl(s2 & MAX_VALUE));
    }

    /* renamed from: div-WZ4Q5Ns  reason: not valid java name */
    private static final int m10206divWZ4Q5Ns(short s, int i) {
        return UByte$$ExternalSyntheticBackport0.m(UInt.m10016constructorimpl(s & MAX_VALUE), i);
    }

    /* renamed from: div-VKZWuLQ  reason: not valid java name */
    private static final long m10205divVKZWuLQ(short s, long j) {
        return UByte$$ExternalSyntheticBackport0.m9984m(ULong.m10095constructorimpl(s & WebSocketProtocol.PAYLOAD_SHORT_MAX), j);
    }

    /* renamed from: rem-7apg3OU  reason: not valid java name */
    private static final int m10232rem7apg3OU(short s, byte b) {
        return UByte$$ExternalSyntheticBackport0.m$1(UInt.m10016constructorimpl(s & MAX_VALUE), UInt.m10016constructorimpl(b & 255));
    }

    /* renamed from: rem-xj2QHRw  reason: not valid java name */
    private static final int m10235remxj2QHRw(short s, short s2) {
        return UByte$$ExternalSyntheticBackport0.m$1(UInt.m10016constructorimpl(s & MAX_VALUE), UInt.m10016constructorimpl(s2 & MAX_VALUE));
    }

    /* renamed from: rem-WZ4Q5Ns  reason: not valid java name */
    private static final int m10234remWZ4Q5Ns(short s, int i) {
        return UByte$$ExternalSyntheticBackport0.m$1(UInt.m10016constructorimpl(s & MAX_VALUE), i);
    }

    /* renamed from: rem-VKZWuLQ  reason: not valid java name */
    private static final long m10233remVKZWuLQ(short s, long j) {
        return UByte$$ExternalSyntheticBackport0.m$1(ULong.m10095constructorimpl(s & WebSocketProtocol.PAYLOAD_SHORT_MAX), j);
    }

    /* renamed from: floorDiv-7apg3OU  reason: not valid java name */
    private static final int m10210floorDiv7apg3OU(short s, byte b) {
        return UByte$$ExternalSyntheticBackport0.m(UInt.m10016constructorimpl(s & MAX_VALUE), UInt.m10016constructorimpl(b & 255));
    }

    /* renamed from: floorDiv-xj2QHRw  reason: not valid java name */
    private static final int m10213floorDivxj2QHRw(short s, short s2) {
        return UByte$$ExternalSyntheticBackport0.m(UInt.m10016constructorimpl(s & MAX_VALUE), UInt.m10016constructorimpl(s2 & MAX_VALUE));
    }

    /* renamed from: floorDiv-WZ4Q5Ns  reason: not valid java name */
    private static final int m10212floorDivWZ4Q5Ns(short s, int i) {
        return UByte$$ExternalSyntheticBackport0.m(UInt.m10016constructorimpl(s & MAX_VALUE), i);
    }

    /* renamed from: floorDiv-VKZWuLQ  reason: not valid java name */
    private static final long m10211floorDivVKZWuLQ(short s, long j) {
        return UByte$$ExternalSyntheticBackport0.m9984m(ULong.m10095constructorimpl(s & WebSocketProtocol.PAYLOAD_SHORT_MAX), j);
    }

    /* renamed from: mod-7apg3OU  reason: not valid java name */
    private static final byte m10221mod7apg3OU(short s, byte b) {
        return UByte.m9933constructorimpl((byte) UByte$$ExternalSyntheticBackport0.m$1(UInt.m10016constructorimpl(s & MAX_VALUE), UInt.m10016constructorimpl(b & 255)));
    }

    /* renamed from: mod-xj2QHRw  reason: not valid java name */
    private static final short m10224modxj2QHRw(short s, short s2) {
        return m10202constructorimpl((short) UByte$$ExternalSyntheticBackport0.m$1(UInt.m10016constructorimpl(s & MAX_VALUE), UInt.m10016constructorimpl(s2 & MAX_VALUE)));
    }

    /* renamed from: mod-WZ4Q5Ns  reason: not valid java name */
    private static final int m10223modWZ4Q5Ns(short s, int i) {
        return UByte$$ExternalSyntheticBackport0.m$1(UInt.m10016constructorimpl(s & MAX_VALUE), i);
    }

    /* renamed from: mod-VKZWuLQ  reason: not valid java name */
    private static final long m10222modVKZWuLQ(short s, long j) {
        return UByte$$ExternalSyntheticBackport0.m$1(ULong.m10095constructorimpl(s & WebSocketProtocol.PAYLOAD_SHORT_MAX), j);
    }

    /* renamed from: inc-Mh2AYeg  reason: not valid java name */
    private static final short m10215incMh2AYeg(short s) {
        return m10202constructorimpl((short) (s + 1));
    }

    /* renamed from: dec-Mh2AYeg  reason: not valid java name */
    private static final short m10203decMh2AYeg(short s) {
        return m10202constructorimpl((short) (s - 1));
    }

    /* renamed from: rangeTo-xj2QHRw  reason: not valid java name */
    private static final UIntRange m10230rangeToxj2QHRw(short s, short s2) {
        return new UIntRange(UInt.m10016constructorimpl(s & MAX_VALUE), UInt.m10016constructorimpl(s2 & MAX_VALUE), null);
    }

    /* renamed from: rangeUntil-xj2QHRw  reason: not valid java name */
    private static final UIntRange m10231rangeUntilxj2QHRw(short s, short s2) {
        return URangesKt.m11224untilJ1ME1BU(UInt.m10016constructorimpl(s & MAX_VALUE), UInt.m10016constructorimpl(s2 & MAX_VALUE));
    }

    /* renamed from: and-xj2QHRw  reason: not valid java name */
    private static final short m10195andxj2QHRw(short s, short s2) {
        return m10202constructorimpl((short) (s & s2));
    }

    /* renamed from: or-xj2QHRw  reason: not valid java name */
    private static final short m10225orxj2QHRw(short s, short s2) {
        return m10202constructorimpl((short) (s | s2));
    }

    /* renamed from: xor-xj2QHRw  reason: not valid java name */
    private static final short m10251xorxj2QHRw(short s, short s2) {
        return m10202constructorimpl((short) (s ^ s2));
    }

    /* renamed from: inv-Mh2AYeg  reason: not valid java name */
    private static final short m10216invMh2AYeg(short s) {
        return m10202constructorimpl((short) (~s));
    }

    /* renamed from: toUByte-w2LRezQ  reason: not valid java name */
    private static final byte m10247toUBytew2LRezQ(short s) {
        return UByte.m9933constructorimpl((byte) s);
    }

    /* renamed from: toUInt-pVg5ArA  reason: not valid java name */
    private static final int m10248toUIntpVg5ArA(short s) {
        return UInt.m10016constructorimpl(s & MAX_VALUE);
    }

    /* renamed from: toULong-s-VKNKU  reason: not valid java name */
    private static final long m10249toULongsVKNKU(short s) {
        return ULong.m10095constructorimpl(s & WebSocketProtocol.PAYLOAD_SHORT_MAX);
    }

    /* renamed from: toFloat-impl  reason: not valid java name */
    private static final float m10242toFloatimpl(short s) {
        return (float) UnsignedKt.uintToDouble(s & MAX_VALUE);
    }

    /* renamed from: toDouble-impl  reason: not valid java name */
    private static final double m10241toDoubleimpl(short s) {
        return UnsignedKt.uintToDouble(s & MAX_VALUE);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m10246toStringimpl(short s) {
        return String.valueOf(s & MAX_VALUE);
    }

    public String toString() {
        return m10246toStringimpl(this.data);
    }
}
