package kotlin.collections.unsigned;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Comparator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.UByte;
import kotlin.UByteArray;
import kotlin.UInt;
import kotlin.UIntArray;
import kotlin.ULong;
import kotlin.ULongArray;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.UnsignedKt;
import kotlin.collections.AbstractList;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: _UArraysJvm.kt */
@Metadata(d1 = {"\u0000j\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u001f\n\u0002\u0010\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\b¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u001c\u0010\u0000\u001a\u00020\u0007*\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\b¢\u0006\u0004\b\t\u0010\n\u001a\u001c\u0010\u0000\u001a\u00020\u000b*\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\b¢\u0006\u0004\b\r\u0010\u000e\u001a\u001c\u0010\u0000\u001a\u00020\u000f*\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\b¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u0019\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00010\u0014*\u00020\u0002H\u0007¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u0019\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\u0014*\u00020\bH\u0007¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u0019\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0014*\u00020\fH\u0007¢\u0006\u0004\b\u0019\u0010\u001a\u001a\u0019\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0014*\u00020\u0010H\u0007¢\u0006\u0004\b\u001b\u0010\u001c\u001a/\u0010\u001d\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u00012\b\b\u0002\u0010\u001f\u001a\u00020\u00042\b\b\u0002\u0010 \u001a\u00020\u0004H\u0007¢\u0006\u0004\b!\u0010\"\u001a/\u0010\u001d\u001a\u00020\u0004*\u00020\b2\u0006\u0010\u001e\u001a\u00020\u00072\b\b\u0002\u0010\u001f\u001a\u00020\u00042\b\b\u0002\u0010 \u001a\u00020\u0004H\u0007¢\u0006\u0004\b#\u0010$\u001a/\u0010\u001d\u001a\u00020\u0004*\u00020\f2\u0006\u0010\u001e\u001a\u00020\u000b2\b\b\u0002\u0010\u001f\u001a\u00020\u00042\b\b\u0002\u0010 \u001a\u00020\u0004H\u0007¢\u0006\u0004\b%\u0010&\u001a/\u0010\u001d\u001a\u00020\u0004*\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u000f2\b\b\u0002\u0010\u001f\u001a\u00020\u00042\b\b\u0002\u0010 \u001a\u00020\u0004H\u0007¢\u0006\u0004\b'\u0010(\u001a\u0015\u0010)\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0007¢\u0006\u0004\b*\u0010+\u001a\u0015\u0010)\u001a\u0004\u0018\u00010\u0007*\u00020\bH\u0007¢\u0006\u0004\b,\u0010-\u001a\u0015\u0010)\u001a\u0004\u0018\u00010\u000b*\u00020\fH\u0007¢\u0006\u0004\b.\u0010/\u001a\u0015\u0010)\u001a\u0004\u0018\u00010\u000f*\u00020\u0010H\u0007¢\u0006\u0004\b0\u00101\u001a=\u00102\u001a\u0004\u0018\u00010\u0001\"\u000e\b\u0000\u00103*\b\u0012\u0004\u0012\u0002H304*\u00020\u00022\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u0002H306H\u0087\bø\u0001\u0000¢\u0006\u0004\b7\u00108\u001a=\u00102\u001a\u0004\u0018\u00010\u0007\"\u000e\b\u0000\u00103*\b\u0012\u0004\u0012\u0002H304*\u00020\b2\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u0002H306H\u0087\bø\u0001\u0000¢\u0006\u0004\b9\u0010:\u001a=\u00102\u001a\u0004\u0018\u00010\u000b\"\u000e\b\u0000\u00103*\b\u0012\u0004\u0012\u0002H304*\u00020\f2\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u0002H306H\u0087\bø\u0001\u0000¢\u0006\u0004\b;\u0010<\u001a=\u00102\u001a\u0004\u0018\u00010\u000f\"\u000e\b\u0000\u00103*\b\u0012\u0004\u0012\u0002H304*\u00020\u00102\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u0002H306H\u0087\bø\u0001\u0000¢\u0006\u0004\b=\u0010>\u001a1\u0010?\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u001a\u0010@\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\u00010Aj\n\u0012\u0006\b\u0000\u0012\u00020\u0001`BH\u0007¢\u0006\u0004\bC\u0010D\u001a1\u0010?\u001a\u0004\u0018\u00010\u0007*\u00020\b2\u001a\u0010@\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\u00070Aj\n\u0012\u0006\b\u0000\u0012\u00020\u0007`BH\u0007¢\u0006\u0004\bE\u0010F\u001a1\u0010?\u001a\u0004\u0018\u00010\u000b*\u00020\f2\u001a\u0010@\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\u000b0Aj\n\u0012\u0006\b\u0000\u0012\u00020\u000b`BH\u0007¢\u0006\u0004\bG\u0010H\u001a1\u0010?\u001a\u0004\u0018\u00010\u000f*\u00020\u00102\u001a\u0010@\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\u000f0Aj\n\u0012\u0006\b\u0000\u0012\u00020\u000f`BH\u0007¢\u0006\u0004\bI\u0010J\u001a\u0015\u0010K\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0007¢\u0006\u0004\bL\u0010+\u001a\u0015\u0010K\u001a\u0004\u0018\u00010\u0007*\u00020\bH\u0007¢\u0006\u0004\bM\u0010-\u001a\u0015\u0010K\u001a\u0004\u0018\u00010\u000b*\u00020\fH\u0007¢\u0006\u0004\bN\u0010/\u001a\u0015\u0010K\u001a\u0004\u0018\u00010\u000f*\u00020\u0010H\u0007¢\u0006\u0004\bO\u00101\u001a=\u0010P\u001a\u0004\u0018\u00010\u0001\"\u000e\b\u0000\u00103*\b\u0012\u0004\u0012\u0002H304*\u00020\u00022\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u0002H306H\u0087\bø\u0001\u0000¢\u0006\u0004\bQ\u00108\u001a=\u0010P\u001a\u0004\u0018\u00010\u0007\"\u000e\b\u0000\u00103*\b\u0012\u0004\u0012\u0002H304*\u00020\b2\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u0002H306H\u0087\bø\u0001\u0000¢\u0006\u0004\bR\u0010:\u001a=\u0010P\u001a\u0004\u0018\u00010\u000b\"\u000e\b\u0000\u00103*\b\u0012\u0004\u0012\u0002H304*\u00020\f2\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u0002H306H\u0087\bø\u0001\u0000¢\u0006\u0004\bS\u0010<\u001a=\u0010P\u001a\u0004\u0018\u00010\u000f\"\u000e\b\u0000\u00103*\b\u0012\u0004\u0012\u0002H304*\u00020\u00102\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u0002H306H\u0087\bø\u0001\u0000¢\u0006\u0004\bT\u0010>\u001a1\u0010U\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u001a\u0010@\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\u00010Aj\n\u0012\u0006\b\u0000\u0012\u00020\u0001`BH\u0007¢\u0006\u0004\bV\u0010D\u001a1\u0010U\u001a\u0004\u0018\u00010\u0007*\u00020\b2\u001a\u0010@\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\u00070Aj\n\u0012\u0006\b\u0000\u0012\u00020\u0007`BH\u0007¢\u0006\u0004\bW\u0010F\u001a1\u0010U\u001a\u0004\u0018\u00010\u000b*\u00020\f2\u001a\u0010@\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\u000b0Aj\n\u0012\u0006\b\u0000\u0012\u00020\u000b`BH\u0007¢\u0006\u0004\bX\u0010H\u001a1\u0010U\u001a\u0004\u0018\u00010\u000f*\u00020\u00102\u001a\u0010@\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\u000f0Aj\n\u0012\u0006\b\u0000\u0012\u00020\u000f`BH\u0007¢\u0006\u0004\bY\u0010J\u001a+\u0010Z\u001a\u00020[*\u00020\u00022\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020[06H\u0087\bø\u0001\u0000¢\u0006\u0004\b\\\u0010]\u001a+\u0010Z\u001a\u00020[*\u00020\b2\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020[06H\u0087\bø\u0001\u0000¢\u0006\u0004\b\\\u0010^\u001a+\u0010Z\u001a\u00020[*\u00020\f2\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020[06H\u0087\bø\u0001\u0000¢\u0006\u0004\b\\\u0010_\u001a+\u0010Z\u001a\u00020[*\u00020\u00102\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020[06H\u0087\bø\u0001\u0000¢\u0006\u0004\b\\\u0010`\u001a+\u0010Z\u001a\u00020a*\u00020\u00022\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020a06H\u0087\bø\u0001\u0000¢\u0006\u0004\bb\u0010c\u001a+\u0010Z\u001a\u00020a*\u00020\b2\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020a06H\u0087\bø\u0001\u0000¢\u0006\u0004\bb\u0010d\u001a+\u0010Z\u001a\u00020a*\u00020\f2\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020a06H\u0087\bø\u0001\u0000¢\u0006\u0004\bb\u0010e\u001a+\u0010Z\u001a\u00020a*\u00020\u00102\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020a06H\u0087\bø\u0001\u0000¢\u0006\u0004\bb\u0010f\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006g"}, d2 = {"elementAt", "Lkotlin/UInt;", "Lkotlin/UIntArray;", FirebaseAnalytics.Param.INDEX, "", "elementAt-qFRl0hI", "([II)I", "Lkotlin/ULong;", "Lkotlin/ULongArray;", "elementAt-r7IrZao", "([JI)J", "Lkotlin/UByte;", "Lkotlin/UByteArray;", "elementAt-PpDY95g", "([BI)B", "Lkotlin/UShort;", "Lkotlin/UShortArray;", "elementAt-nggk6HY", "([SI)S", "asList", "", "asList--ajY-9A", "([I)Ljava/util/List;", "asList-QwZRm1k", "([J)Ljava/util/List;", "asList-GBYM_sE", "([B)Ljava/util/List;", "asList-rL5Bavg", "([S)Ljava/util/List;", "binarySearch", "element", "fromIndex", "toIndex", "binarySearch-2fe2U9s", "([IIII)I", "binarySearch-K6DWlUc", "([JJII)I", "binarySearch-WpHrYlw", "([BBII)I", "binarySearch-EtDCXyQ", "([SSII)I", "max", "max--ajY-9A", "([I)Lkotlin/UInt;", "max-QwZRm1k", "([J)Lkotlin/ULong;", "max-GBYM_sE", "([B)Lkotlin/UByte;", "max-rL5Bavg", "([S)Lkotlin/UShort;", "maxBy", "R", "", "selector", "Lkotlin/Function1;", "maxBy-jgv0xPQ", "([ILkotlin/jvm/functions/Function1;)Lkotlin/UInt;", "maxBy-MShoTSo", "([JLkotlin/jvm/functions/Function1;)Lkotlin/ULong;", "maxBy-JOV_ifY", "([BLkotlin/jvm/functions/Function1;)Lkotlin/UByte;", "maxBy-xTcfx_M", "([SLkotlin/jvm/functions/Function1;)Lkotlin/UShort;", "maxWith", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "maxWith-YmdZ_VM", "([ILjava/util/Comparator;)Lkotlin/UInt;", "maxWith-zrEWJaI", "([JLjava/util/Comparator;)Lkotlin/ULong;", "maxWith-XMRcp5o", "([BLjava/util/Comparator;)Lkotlin/UByte;", "maxWith-eOHTfZs", "([SLjava/util/Comparator;)Lkotlin/UShort;", "min", "min--ajY-9A", "min-QwZRm1k", "min-GBYM_sE", "min-rL5Bavg", "minBy", "minBy-jgv0xPQ", "minBy-MShoTSo", "minBy-JOV_ifY", "minBy-xTcfx_M", "minWith", "minWith-YmdZ_VM", "minWith-zrEWJaI", "minWith-XMRcp5o", "minWith-eOHTfZs", "sumOf", "Ljava/math/BigDecimal;", "sumOfBigDecimal", "([ILkotlin/jvm/functions/Function1;)Ljava/math/BigDecimal;", "([JLkotlin/jvm/functions/Function1;)Ljava/math/BigDecimal;", "([BLkotlin/jvm/functions/Function1;)Ljava/math/BigDecimal;", "([SLkotlin/jvm/functions/Function1;)Ljava/math/BigDecimal;", "Ljava/math/BigInteger;", "sumOfBigInteger", "([ILkotlin/jvm/functions/Function1;)Ljava/math/BigInteger;", "([JLkotlin/jvm/functions/Function1;)Ljava/math/BigInteger;", "([BLkotlin/jvm/functions/Function1;)Ljava/math/BigInteger;", "([SLkotlin/jvm/functions/Function1;)Ljava/math/BigInteger;", "kotlin-stdlib"}, k = 5, mv = {2, 2, 0}, pn = "kotlin.collections", xi = 49, xs = "kotlin/collections/unsigned/UArraysKt")
/* loaded from: classes5.dex */
public class UArraysKt___UArraysJvmKt {
    /* renamed from: elementAt-qFRl0hI  reason: not valid java name */
    private static final int m10690elementAtqFRl0hI(int[] iArr, int i) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$elementAt$0");
        return UIntArray.m10359getpVg5ArA(iArr, i);
    }

    /* renamed from: elementAt-r7IrZao  reason: not valid java name */
    private static final long m10691elementAtr7IrZao(long[] jArr, int i) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$elementAt$0");
        return ULongArray.m10438getsVKNKU(jArr, i);
    }

    /* renamed from: elementAt-PpDY95g  reason: not valid java name */
    private static final byte m10688elementAtPpDY95g(byte[] bArr, int i) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$elementAt$0");
        return UByteArray.m10280getw2LRezQ(bArr, i);
    }

    /* renamed from: elementAt-nggk6HY  reason: not valid java name */
    private static final short m10689elementAtnggk6HY(short[] sArr, int i) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$elementAt$0");
        return UShortArray.m10543getMh2AYeg(sArr, i);
    }

    /* renamed from: asList--ajY-9A  reason: not valid java name */
    public static final List<UInt> m10676asListajY9A(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$asList$0");
        return new UArraysKt___UArraysJvmKt$asList$1(iArr);
    }

    /* renamed from: asList-QwZRm1k  reason: not valid java name */
    public static final List<ULong> m10678asListQwZRm1k(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$asList$0");
        return new UArraysKt___UArraysJvmKt$asList$2(jArr);
    }

    /* renamed from: asList-GBYM_sE  reason: not valid java name */
    public static final List<UByte> m10677asListGBYM_sE(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$asList$0");
        return new UArraysKt___UArraysJvmKt$asList$3(bArr);
    }

    /* renamed from: asList-rL5Bavg  reason: not valid java name */
    public static final List<UShort> m10679asListrL5Bavg(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$asList$0");
        return new UArraysKt___UArraysJvmKt$asList$4(sArr);
    }

    /* renamed from: binarySearch-2fe2U9s$default  reason: not valid java name */
    public static /* synthetic */ int m10681binarySearch2fe2U9s$default(int[] iArr, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = UIntArray.m10360getSizeimpl(iArr);
        }
        return UArraysKt.m10680binarySearch2fe2U9s(iArr, i, i2, i3);
    }

    /* renamed from: binarySearch-2fe2U9s  reason: not valid java name */
    public static final int m10680binarySearch2fe2U9s(int[] iArr, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$binarySearch$0");
        AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(i2, i3, UIntArray.m10360getSizeimpl(iArr));
        int i4 = i3 - 1;
        while (i2 <= i4) {
            int i5 = (i2 + i4) >>> 1;
            int uintCompare = UnsignedKt.uintCompare(iArr[i5], i);
            if (uintCompare < 0) {
                i2 = i5 + 1;
            } else if (uintCompare <= 0) {
                return i5;
            } else {
                i4 = i5 - 1;
            }
        }
        return -(i2 + 1);
    }

    /* renamed from: binarySearch-K6DWlUc$default  reason: not valid java name */
    public static /* synthetic */ int m10685binarySearchK6DWlUc$default(long[] jArr, long j, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = ULongArray.m10439getSizeimpl(jArr);
        }
        return UArraysKt.m10684binarySearchK6DWlUc(jArr, j, i, i2);
    }

    /* renamed from: binarySearch-K6DWlUc  reason: not valid java name */
    public static final int m10684binarySearchK6DWlUc(long[] jArr, long j, int i, int i2) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$binarySearch$0");
        AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(i, i2, ULongArray.m10439getSizeimpl(jArr));
        int i3 = i2 - 1;
        while (i <= i3) {
            int i4 = (i + i3) >>> 1;
            int ulongCompare = UnsignedKt.ulongCompare(jArr[i4], j);
            if (ulongCompare < 0) {
                i = i4 + 1;
            } else if (ulongCompare <= 0) {
                return i4;
            } else {
                i3 = i4 - 1;
            }
        }
        return -(i + 1);
    }

    /* renamed from: binarySearch-WpHrYlw$default  reason: not valid java name */
    public static /* synthetic */ int m10687binarySearchWpHrYlw$default(byte[] bArr, byte b, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = UByteArray.m10281getSizeimpl(bArr);
        }
        return UArraysKt.m10686binarySearchWpHrYlw(bArr, b, i, i2);
    }

    /* renamed from: binarySearch-WpHrYlw  reason: not valid java name */
    public static final int m10686binarySearchWpHrYlw(byte[] bArr, byte b, int i, int i2) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$binarySearch$0");
        AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(i, i2, UByteArray.m10281getSizeimpl(bArr));
        int i3 = b & 255;
        int i4 = i2 - 1;
        while (i <= i4) {
            int i5 = (i + i4) >>> 1;
            int uintCompare = UnsignedKt.uintCompare(bArr[i5], i3);
            if (uintCompare < 0) {
                i = i5 + 1;
            } else if (uintCompare <= 0) {
                return i5;
            } else {
                i4 = i5 - 1;
            }
        }
        return -(i + 1);
    }

    /* renamed from: binarySearch-EtDCXyQ$default  reason: not valid java name */
    public static /* synthetic */ int m10683binarySearchEtDCXyQ$default(short[] sArr, short s, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = UShortArray.m10544getSizeimpl(sArr);
        }
        return UArraysKt.m10682binarySearchEtDCXyQ(sArr, s, i, i2);
    }

    /* renamed from: binarySearch-EtDCXyQ  reason: not valid java name */
    public static final int m10682binarySearchEtDCXyQ(short[] sArr, short s, int i, int i2) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$binarySearch$0");
        AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(i, i2, UShortArray.m10544getSizeimpl(sArr));
        int i3 = s & UShort.MAX_VALUE;
        int i4 = i2 - 1;
        while (i <= i4) {
            int i5 = (i + i4) >>> 1;
            int uintCompare = UnsignedKt.uintCompare(sArr[i5], i3);
            if (uintCompare < 0) {
                i = i5 + 1;
            } else if (uintCompare <= 0) {
                return i5;
            } else {
                i4 = i5 - 1;
            }
        }
        return -(i + 1);
    }

    @Deprecated(message = "Use maxOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* renamed from: max--ajY-9A  reason: not valid java name */
    public static final /* synthetic */ UInt m10692maxajY9A(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$max$0");
        return UArraysKt.m11067maxOrNullajY9A(iArr);
    }

    @Deprecated(message = "Use maxOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* renamed from: max-QwZRm1k  reason: not valid java name */
    public static final /* synthetic */ ULong m10694maxQwZRm1k(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$max$0");
        return UArraysKt.m11069maxOrNullQwZRm1k(jArr);
    }

    @Deprecated(message = "Use maxOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* renamed from: max-GBYM_sE  reason: not valid java name */
    public static final /* synthetic */ UByte m10693maxGBYM_sE(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$max$0");
        return UArraysKt.m11068maxOrNullGBYM_sE(bArr);
    }

    @Deprecated(message = "Use maxOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* renamed from: max-rL5Bavg  reason: not valid java name */
    public static final /* synthetic */ UShort m10695maxrL5Bavg(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$max$0");
        return UArraysKt.m11070maxOrNullrL5Bavg(sArr);
    }

    @Deprecated(message = "Use maxByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* renamed from: maxBy-jgv0xPQ  reason: not valid java name */
    private static final /* synthetic */ <R extends Comparable<? super R>> UInt m10698maxByjgv0xPQ(int[] iArr, Function1<? super UInt, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$maxBy$0");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (UIntArray.m10362isEmptyimpl(iArr)) {
            return null;
        }
        int m10359getpVg5ArA = UIntArray.m10359getpVg5ArA(iArr, 0);
        int lastIndex = ArraysKt.getLastIndex(iArr);
        if (lastIndex == 0) {
            return UInt.m10293boximpl(m10359getpVg5ArA);
        }
        R invoke = selector.invoke(UInt.m10293boximpl(m10359getpVg5ArA));
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                int m10359getpVg5ArA2 = UIntArray.m10359getpVg5ArA(iArr, i);
                R invoke2 = selector.invoke(UInt.m10293boximpl(m10359getpVg5ArA2));
                if (invoke.compareTo(invoke2) < 0) {
                    m10359getpVg5ArA = m10359getpVg5ArA2;
                    invoke = invoke2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return UInt.m10293boximpl(m10359getpVg5ArA);
    }

    @Deprecated(message = "Use maxByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* renamed from: maxBy-MShoTSo  reason: not valid java name */
    private static final /* synthetic */ <R extends Comparable<? super R>> ULong m10697maxByMShoTSo(long[] jArr, Function1<? super ULong, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$maxBy$0");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (ULongArray.m10441isEmptyimpl(jArr)) {
            return null;
        }
        long m10438getsVKNKU = ULongArray.m10438getsVKNKU(jArr, 0);
        int lastIndex = ArraysKt.getLastIndex(jArr);
        if (lastIndex == 0) {
            return ULong.m10372boximpl(m10438getsVKNKU);
        }
        R invoke = selector.invoke(ULong.m10372boximpl(m10438getsVKNKU));
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                long m10438getsVKNKU2 = ULongArray.m10438getsVKNKU(jArr, i);
                R invoke2 = selector.invoke(ULong.m10372boximpl(m10438getsVKNKU2));
                if (invoke.compareTo(invoke2) < 0) {
                    m10438getsVKNKU = m10438getsVKNKU2;
                    invoke = invoke2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return ULong.m10372boximpl(m10438getsVKNKU);
    }

    @Deprecated(message = "Use maxByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* renamed from: maxBy-JOV_ifY  reason: not valid java name */
    private static final /* synthetic */ <R extends Comparable<? super R>> UByte m10696maxByJOV_ifY(byte[] bArr, Function1<? super UByte, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$maxBy$0");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (UByteArray.m10283isEmptyimpl(bArr)) {
            return null;
        }
        byte m10280getw2LRezQ = UByteArray.m10280getw2LRezQ(bArr, 0);
        int lastIndex = ArraysKt.getLastIndex(bArr);
        if (lastIndex == 0) {
            return UByte.m10211boximpl(m10280getw2LRezQ);
        }
        R invoke = selector.invoke(UByte.m10211boximpl(m10280getw2LRezQ));
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                byte m10280getw2LRezQ2 = UByteArray.m10280getw2LRezQ(bArr, i);
                R invoke2 = selector.invoke(UByte.m10211boximpl(m10280getw2LRezQ2));
                if (invoke.compareTo(invoke2) < 0) {
                    m10280getw2LRezQ = m10280getw2LRezQ2;
                    invoke = invoke2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return UByte.m10211boximpl(m10280getw2LRezQ);
    }

    @Deprecated(message = "Use maxByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* renamed from: maxBy-xTcfx_M  reason: not valid java name */
    private static final /* synthetic */ <R extends Comparable<? super R>> UShort m10699maxByxTcfx_M(short[] sArr, Function1<? super UShort, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$maxBy$0");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (UShortArray.m10546isEmptyimpl(sArr)) {
            return null;
        }
        short m10543getMh2AYeg = UShortArray.m10543getMh2AYeg(sArr, 0);
        int lastIndex = ArraysKt.getLastIndex(sArr);
        if (lastIndex == 0) {
            return UShort.m10479boximpl(m10543getMh2AYeg);
        }
        R invoke = selector.invoke(UShort.m10479boximpl(m10543getMh2AYeg));
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                short m10543getMh2AYeg2 = UShortArray.m10543getMh2AYeg(sArr, i);
                R invoke2 = selector.invoke(UShort.m10479boximpl(m10543getMh2AYeg2));
                if (invoke.compareTo(invoke2) < 0) {
                    m10543getMh2AYeg = m10543getMh2AYeg2;
                    invoke = invoke2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return UShort.m10479boximpl(m10543getMh2AYeg);
    }

    @Deprecated(message = "Use maxWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* renamed from: maxWith-YmdZ_VM  reason: not valid java name */
    public static final /* synthetic */ UInt m10701maxWithYmdZ_VM(int[] iArr, Comparator comparator) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$maxWith$0");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return UArraysKt.m11076maxWithOrNullYmdZ_VM(iArr, comparator);
    }

    @Deprecated(message = "Use maxWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* renamed from: maxWith-zrEWJaI  reason: not valid java name */
    public static final /* synthetic */ ULong m10703maxWithzrEWJaI(long[] jArr, Comparator comparator) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$maxWith$0");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return UArraysKt.m11078maxWithOrNullzrEWJaI(jArr, comparator);
    }

    @Deprecated(message = "Use maxWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* renamed from: maxWith-XMRcp5o  reason: not valid java name */
    public static final /* synthetic */ UByte m10700maxWithXMRcp5o(byte[] bArr, Comparator comparator) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$maxWith$0");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return UArraysKt.m11075maxWithOrNullXMRcp5o(bArr, comparator);
    }

    @Deprecated(message = "Use maxWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* renamed from: maxWith-eOHTfZs  reason: not valid java name */
    public static final /* synthetic */ UShort m10702maxWitheOHTfZs(short[] sArr, Comparator comparator) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$maxWith$0");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return UArraysKt.m11077maxWithOrNulleOHTfZs(sArr, comparator);
    }

    @Deprecated(message = "Use minOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* renamed from: min--ajY-9A  reason: not valid java name */
    public static final /* synthetic */ UInt m10704minajY9A(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$min$0");
        return UArraysKt.m11123minOrNullajY9A(iArr);
    }

    @Deprecated(message = "Use minOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* renamed from: min-QwZRm1k  reason: not valid java name */
    public static final /* synthetic */ ULong m10706minQwZRm1k(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$min$0");
        return UArraysKt.m11125minOrNullQwZRm1k(jArr);
    }

    @Deprecated(message = "Use minOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* renamed from: min-GBYM_sE  reason: not valid java name */
    public static final /* synthetic */ UByte m10705minGBYM_sE(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$min$0");
        return UArraysKt.m11124minOrNullGBYM_sE(bArr);
    }

    @Deprecated(message = "Use minOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minOrNull()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* renamed from: min-rL5Bavg  reason: not valid java name */
    public static final /* synthetic */ UShort m10707minrL5Bavg(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$min$0");
        return UArraysKt.m11126minOrNullrL5Bavg(sArr);
    }

    @Deprecated(message = "Use minByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* renamed from: minBy-jgv0xPQ  reason: not valid java name */
    private static final /* synthetic */ <R extends Comparable<? super R>> UInt m10710minByjgv0xPQ(int[] iArr, Function1<? super UInt, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$minBy$0");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (UIntArray.m10362isEmptyimpl(iArr)) {
            return null;
        }
        int m10359getpVg5ArA = UIntArray.m10359getpVg5ArA(iArr, 0);
        int lastIndex = ArraysKt.getLastIndex(iArr);
        if (lastIndex == 0) {
            return UInt.m10293boximpl(m10359getpVg5ArA);
        }
        R invoke = selector.invoke(UInt.m10293boximpl(m10359getpVg5ArA));
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                int m10359getpVg5ArA2 = UIntArray.m10359getpVg5ArA(iArr, i);
                R invoke2 = selector.invoke(UInt.m10293boximpl(m10359getpVg5ArA2));
                if (invoke.compareTo(invoke2) > 0) {
                    m10359getpVg5ArA = m10359getpVg5ArA2;
                    invoke = invoke2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return UInt.m10293boximpl(m10359getpVg5ArA);
    }

    @Deprecated(message = "Use minByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* renamed from: minBy-MShoTSo  reason: not valid java name */
    private static final /* synthetic */ <R extends Comparable<? super R>> ULong m10709minByMShoTSo(long[] jArr, Function1<? super ULong, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$minBy$0");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (ULongArray.m10441isEmptyimpl(jArr)) {
            return null;
        }
        long m10438getsVKNKU = ULongArray.m10438getsVKNKU(jArr, 0);
        int lastIndex = ArraysKt.getLastIndex(jArr);
        if (lastIndex == 0) {
            return ULong.m10372boximpl(m10438getsVKNKU);
        }
        R invoke = selector.invoke(ULong.m10372boximpl(m10438getsVKNKU));
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                long m10438getsVKNKU2 = ULongArray.m10438getsVKNKU(jArr, i);
                R invoke2 = selector.invoke(ULong.m10372boximpl(m10438getsVKNKU2));
                if (invoke.compareTo(invoke2) > 0) {
                    m10438getsVKNKU = m10438getsVKNKU2;
                    invoke = invoke2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return ULong.m10372boximpl(m10438getsVKNKU);
    }

    @Deprecated(message = "Use minByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* renamed from: minBy-JOV_ifY  reason: not valid java name */
    private static final /* synthetic */ <R extends Comparable<? super R>> UByte m10708minByJOV_ifY(byte[] bArr, Function1<? super UByte, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$minBy$0");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (UByteArray.m10283isEmptyimpl(bArr)) {
            return null;
        }
        byte m10280getw2LRezQ = UByteArray.m10280getw2LRezQ(bArr, 0);
        int lastIndex = ArraysKt.getLastIndex(bArr);
        if (lastIndex == 0) {
            return UByte.m10211boximpl(m10280getw2LRezQ);
        }
        R invoke = selector.invoke(UByte.m10211boximpl(m10280getw2LRezQ));
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                byte m10280getw2LRezQ2 = UByteArray.m10280getw2LRezQ(bArr, i);
                R invoke2 = selector.invoke(UByte.m10211boximpl(m10280getw2LRezQ2));
                if (invoke.compareTo(invoke2) > 0) {
                    m10280getw2LRezQ = m10280getw2LRezQ2;
                    invoke = invoke2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return UByte.m10211boximpl(m10280getw2LRezQ);
    }

    @Deprecated(message = "Use minByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* renamed from: minBy-xTcfx_M  reason: not valid java name */
    private static final /* synthetic */ <R extends Comparable<? super R>> UShort m10711minByxTcfx_M(short[] sArr, Function1<? super UShort, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$minBy$0");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (UShortArray.m10546isEmptyimpl(sArr)) {
            return null;
        }
        short m10543getMh2AYeg = UShortArray.m10543getMh2AYeg(sArr, 0);
        int lastIndex = ArraysKt.getLastIndex(sArr);
        if (lastIndex == 0) {
            return UShort.m10479boximpl(m10543getMh2AYeg);
        }
        R invoke = selector.invoke(UShort.m10479boximpl(m10543getMh2AYeg));
        int i = 1;
        if (1 <= lastIndex) {
            while (true) {
                short m10543getMh2AYeg2 = UShortArray.m10543getMh2AYeg(sArr, i);
                R invoke2 = selector.invoke(UShort.m10479boximpl(m10543getMh2AYeg2));
                if (invoke.compareTo(invoke2) > 0) {
                    m10543getMh2AYeg = m10543getMh2AYeg2;
                    invoke = invoke2;
                }
                if (i == lastIndex) {
                    break;
                }
                i++;
            }
        }
        return UShort.m10479boximpl(m10543getMh2AYeg);
    }

    @Deprecated(message = "Use minWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* renamed from: minWith-YmdZ_VM  reason: not valid java name */
    public static final /* synthetic */ UInt m10713minWithYmdZ_VM(int[] iArr, Comparator comparator) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$minWith$0");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return UArraysKt.m11132minWithOrNullYmdZ_VM(iArr, comparator);
    }

    @Deprecated(message = "Use minWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* renamed from: minWith-zrEWJaI  reason: not valid java name */
    public static final /* synthetic */ ULong m10715minWithzrEWJaI(long[] jArr, Comparator comparator) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$minWith$0");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return UArraysKt.m11134minWithOrNullzrEWJaI(jArr, comparator);
    }

    @Deprecated(message = "Use minWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* renamed from: minWith-XMRcp5o  reason: not valid java name */
    public static final /* synthetic */ UByte m10712minWithXMRcp5o(byte[] bArr, Comparator comparator) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$minWith$0");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return UArraysKt.m11131minWithOrNullXMRcp5o(bArr, comparator);
    }

    @Deprecated(message = "Use minWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    /* renamed from: minWith-eOHTfZs  reason: not valid java name */
    public static final /* synthetic */ UShort m10714minWitheOHTfZs(short[] sArr, Comparator comparator) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$minWith$0");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return UArraysKt.m11133minWithOrNulleOHTfZs(sArr, comparator);
    }

    private static final BigDecimal sumOfBigDecimal(int[] iArr, Function1<? super UInt, ? extends BigDecimal> selector) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$sumOf$0");
        Intrinsics.checkNotNullParameter(selector, "selector");
        BigDecimal valueOf = BigDecimal.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(...)");
        int m10360getSizeimpl = UIntArray.m10360getSizeimpl(iArr);
        for (int i = 0; i < m10360getSizeimpl; i++) {
            valueOf = valueOf.add(selector.invoke(UInt.m10293boximpl(UIntArray.m10359getpVg5ArA(iArr, i))));
            Intrinsics.checkNotNullExpressionValue(valueOf, "add(...)");
        }
        return valueOf;
    }

    private static final BigDecimal sumOfBigDecimal(long[] jArr, Function1<? super ULong, ? extends BigDecimal> selector) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$sumOf$0");
        Intrinsics.checkNotNullParameter(selector, "selector");
        BigDecimal valueOf = BigDecimal.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(...)");
        int m10439getSizeimpl = ULongArray.m10439getSizeimpl(jArr);
        for (int i = 0; i < m10439getSizeimpl; i++) {
            valueOf = valueOf.add(selector.invoke(ULong.m10372boximpl(ULongArray.m10438getsVKNKU(jArr, i))));
            Intrinsics.checkNotNullExpressionValue(valueOf, "add(...)");
        }
        return valueOf;
    }

    private static final BigDecimal sumOfBigDecimal(byte[] bArr, Function1<? super UByte, ? extends BigDecimal> selector) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$sumOf$0");
        Intrinsics.checkNotNullParameter(selector, "selector");
        BigDecimal valueOf = BigDecimal.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(...)");
        int m10281getSizeimpl = UByteArray.m10281getSizeimpl(bArr);
        for (int i = 0; i < m10281getSizeimpl; i++) {
            valueOf = valueOf.add(selector.invoke(UByte.m10211boximpl(UByteArray.m10280getw2LRezQ(bArr, i))));
            Intrinsics.checkNotNullExpressionValue(valueOf, "add(...)");
        }
        return valueOf;
    }

    private static final BigDecimal sumOfBigDecimal(short[] sArr, Function1<? super UShort, ? extends BigDecimal> selector) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$sumOf$0");
        Intrinsics.checkNotNullParameter(selector, "selector");
        BigDecimal valueOf = BigDecimal.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(...)");
        int m10544getSizeimpl = UShortArray.m10544getSizeimpl(sArr);
        for (int i = 0; i < m10544getSizeimpl; i++) {
            valueOf = valueOf.add(selector.invoke(UShort.m10479boximpl(UShortArray.m10543getMh2AYeg(sArr, i))));
            Intrinsics.checkNotNullExpressionValue(valueOf, "add(...)");
        }
        return valueOf;
    }

    private static final BigInteger sumOfBigInteger(int[] iArr, Function1<? super UInt, ? extends BigInteger> selector) {
        Intrinsics.checkNotNullParameter(iArr, "$v$c$kotlin-UIntArray$-$this$sumOf$0");
        Intrinsics.checkNotNullParameter(selector, "selector");
        BigInteger valueOf = BigInteger.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(...)");
        int m10360getSizeimpl = UIntArray.m10360getSizeimpl(iArr);
        for (int i = 0; i < m10360getSizeimpl; i++) {
            valueOf = valueOf.add(selector.invoke(UInt.m10293boximpl(UIntArray.m10359getpVg5ArA(iArr, i))));
            Intrinsics.checkNotNullExpressionValue(valueOf, "add(...)");
        }
        return valueOf;
    }

    private static final BigInteger sumOfBigInteger(long[] jArr, Function1<? super ULong, ? extends BigInteger> selector) {
        Intrinsics.checkNotNullParameter(jArr, "$v$c$kotlin-ULongArray$-$this$sumOf$0");
        Intrinsics.checkNotNullParameter(selector, "selector");
        BigInteger valueOf = BigInteger.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(...)");
        int m10439getSizeimpl = ULongArray.m10439getSizeimpl(jArr);
        for (int i = 0; i < m10439getSizeimpl; i++) {
            valueOf = valueOf.add(selector.invoke(ULong.m10372boximpl(ULongArray.m10438getsVKNKU(jArr, i))));
            Intrinsics.checkNotNullExpressionValue(valueOf, "add(...)");
        }
        return valueOf;
    }

    private static final BigInteger sumOfBigInteger(byte[] bArr, Function1<? super UByte, ? extends BigInteger> selector) {
        Intrinsics.checkNotNullParameter(bArr, "$v$c$kotlin-UByteArray$-$this$sumOf$0");
        Intrinsics.checkNotNullParameter(selector, "selector");
        BigInteger valueOf = BigInteger.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(...)");
        int m10281getSizeimpl = UByteArray.m10281getSizeimpl(bArr);
        for (int i = 0; i < m10281getSizeimpl; i++) {
            valueOf = valueOf.add(selector.invoke(UByte.m10211boximpl(UByteArray.m10280getw2LRezQ(bArr, i))));
            Intrinsics.checkNotNullExpressionValue(valueOf, "add(...)");
        }
        return valueOf;
    }

    private static final BigInteger sumOfBigInteger(short[] sArr, Function1<? super UShort, ? extends BigInteger> selector) {
        Intrinsics.checkNotNullParameter(sArr, "$v$c$kotlin-UShortArray$-$this$sumOf$0");
        Intrinsics.checkNotNullParameter(selector, "selector");
        BigInteger valueOf = BigInteger.valueOf(0L);
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(...)");
        int m10544getSizeimpl = UShortArray.m10544getSizeimpl(sArr);
        for (int i = 0; i < m10544getSizeimpl; i++) {
            valueOf = valueOf.add(selector.invoke(UShort.m10479boximpl(UShortArray.m10543getMh2AYeg(sArr, i))));
            Intrinsics.checkNotNullExpressionValue(valueOf, "add(...)");
        }
        return valueOf;
    }
}
