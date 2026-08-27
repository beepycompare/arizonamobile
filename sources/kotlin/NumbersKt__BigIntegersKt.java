package kotlin;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.facebook.internal.NativeProtocol;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: BigIntegers.kt */
@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\u008a\u0004b\u0002\b\u0003\u001a\u001a\u0010\u0004\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\u008a\u0004b\u0002\b\u0003\u001a\u001a\u0010\u0005\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\u008a\u0004b\u0002\b\u0003\u001a\u001a\u0010\u0006\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\u008a\u0004b\u0002\b\u0003\u001a(\u0010\u0007\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\u008a\u0004b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\nb\u0002\b\u0003\u001a\u0012\u0010\u000b\u001a\u00020\u0001*\u00020\u0001H\u0087\u008a\u0004b\u0002\b\u0003\u001a \u0010\f\u001a\u00020\u0001*\u00020\u0001H\u0087\u008a\u0004b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\rb\u0002\b\u0003\u001a \u0010\u000e\u001a\u00020\u0001*\u00020\u0001H\u0087\u008a\u0004b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\rb\u0002\b\u0003\u001a \u0010\u000f\u001a\u00020\u0001*\u00020\u0001H\u0087\u0088\u0004b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\rb\u0002\b\u0003\u001a(\u0010\u0010\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\u008c\u0004b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\rb\u0002\b\u0003\u001a(\u0010\u0011\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\u008c\u0004b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\rb\u0002\b\u0003\u001a(\u0010\u0012\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\u008c\u0004b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\rb\u0002\b\u0003\u001a(\u0010\u0013\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u0015H\u0087\u008c\u0004b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\rb\u0002\b\u0003\u001a(\u0010\u0016\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u0015H\u0087\u008c\u0004b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\rb\u0002\b\u0003\u001a \u0010\u0017\u001a\u00020\u0001*\u00020\u0015H\u0087\u0088\u0004b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\rb\u0002\b\u0003\u001a \u0010\u0017\u001a\u00020\u0001*\u00020\u0018H\u0087\u0088\u0004b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\rb\u0002\b\u0003\u001a'\u0010\u0017\u001a\u00020\u0001*\u00020\u0019H\u0087\u0088\u0004b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u001cb\u0002\b\u0003¢\u0006\u0004\b\u001a\u0010\u001b\u001a#\u0010\u0017\u001a\u00020\u0001*\u00020\u001dH\u0087\u0080\u0004b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u001c¢\u0006\u0004\b\u001e\u0010\u001f\u001a \u0010 \u001a\u00020!*\u00020\u0001H\u0087\u0088\u0004b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\rb\u0002\b\u0003\u001a4\u0010 \u001a\u00020!*\u00020\u00012\b\b\u0002\u0010\"\u001a\u00020\u00152\b\b\u0002\u0010#\u001a\u00020$H\u0087\u0088\u0004b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\rb\u0002\b\u0003¨\u0006%"}, d2 = {"plus", "Ljava/math/BigInteger;", "other", "Lkotlin/internal/InlineOnly;", "minus", "times", TtmlNode.TAG_DIV, "rem", "Lkotlin/SinceKotlin;", NativeProtocol.PLATFORM_PROVIDER_VERSION_COLUMN, "1.1", "unaryMinus", "inc", "1.2", "dec", "inv", "and", "or", "xor", "shl", "n", "", "shr", "toBigInteger", "", "Lkotlin/UInt;", "toBigInteger-WZ4Q5Ns", "(I)Ljava/math/BigInteger;", "2.4", "Lkotlin/ULong;", "toBigInteger-VKZWuLQ", "(J)Ljava/math/BigInteger;", "toBigDecimal", "Ljava/math/BigDecimal;", "scale", "mathContext", "Ljava/math/MathContext;", "kotlin-stdlib"}, k = 5, mv = {2, 4, 0}, xi = 49, xs = "kotlin/NumbersKt")
/* loaded from: classes5.dex */
class NumbersKt__BigIntegersKt extends NumbersKt__BigDecimalsKt {
    private static final BigInteger plus(BigInteger bigInteger, BigInteger other) {
        Intrinsics.checkNotNullParameter(bigInteger, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        BigInteger add = bigInteger.add(other);
        Intrinsics.checkNotNullExpressionValue(add, "add(...)");
        return add;
    }

    private static final BigInteger minus(BigInteger bigInteger, BigInteger other) {
        Intrinsics.checkNotNullParameter(bigInteger, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        BigInteger subtract = bigInteger.subtract(other);
        Intrinsics.checkNotNullExpressionValue(subtract, "subtract(...)");
        return subtract;
    }

    private static final BigInteger times(BigInteger bigInteger, BigInteger other) {
        Intrinsics.checkNotNullParameter(bigInteger, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        BigInteger multiply = bigInteger.multiply(other);
        Intrinsics.checkNotNullExpressionValue(multiply, "multiply(...)");
        return multiply;
    }

    private static final BigInteger div(BigInteger bigInteger, BigInteger other) {
        Intrinsics.checkNotNullParameter(bigInteger, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        BigInteger divide = bigInteger.divide(other);
        Intrinsics.checkNotNullExpressionValue(divide, "divide(...)");
        return divide;
    }

    private static final BigInteger rem(BigInteger bigInteger, BigInteger other) {
        Intrinsics.checkNotNullParameter(bigInteger, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        BigInteger remainder = bigInteger.remainder(other);
        Intrinsics.checkNotNullExpressionValue(remainder, "remainder(...)");
        return remainder;
    }

    private static final BigInteger unaryMinus(BigInteger bigInteger) {
        Intrinsics.checkNotNullParameter(bigInteger, "<this>");
        BigInteger negate = bigInteger.negate();
        Intrinsics.checkNotNullExpressionValue(negate, "negate(...)");
        return negate;
    }

    private static final BigInteger inc(BigInteger bigInteger) {
        Intrinsics.checkNotNullParameter(bigInteger, "<this>");
        BigInteger add = bigInteger.add(BigInteger.ONE);
        Intrinsics.checkNotNullExpressionValue(add, "add(...)");
        return add;
    }

    private static final BigInteger dec(BigInteger bigInteger) {
        Intrinsics.checkNotNullParameter(bigInteger, "<this>");
        BigInteger subtract = bigInteger.subtract(BigInteger.ONE);
        Intrinsics.checkNotNullExpressionValue(subtract, "subtract(...)");
        return subtract;
    }

    private static final BigInteger inv(BigInteger bigInteger) {
        Intrinsics.checkNotNullParameter(bigInteger, "<this>");
        BigInteger not = bigInteger.not();
        Intrinsics.checkNotNullExpressionValue(not, "not(...)");
        return not;
    }

    private static final BigInteger and(BigInteger bigInteger, BigInteger other) {
        Intrinsics.checkNotNullParameter(bigInteger, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        BigInteger and = bigInteger.and(other);
        Intrinsics.checkNotNullExpressionValue(and, "and(...)");
        return and;
    }

    private static final BigInteger or(BigInteger bigInteger, BigInteger other) {
        Intrinsics.checkNotNullParameter(bigInteger, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        BigInteger or = bigInteger.or(other);
        Intrinsics.checkNotNullExpressionValue(or, "or(...)");
        return or;
    }

    private static final BigInteger xor(BigInteger bigInteger, BigInteger other) {
        Intrinsics.checkNotNullParameter(bigInteger, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        BigInteger xor = bigInteger.xor(other);
        Intrinsics.checkNotNullExpressionValue(xor, "xor(...)");
        return xor;
    }

    private static final BigInteger shl(BigInteger bigInteger, int i) {
        Intrinsics.checkNotNullParameter(bigInteger, "<this>");
        BigInteger shiftLeft = bigInteger.shiftLeft(i);
        Intrinsics.checkNotNullExpressionValue(shiftLeft, "shiftLeft(...)");
        return shiftLeft;
    }

    private static final BigInteger shr(BigInteger bigInteger, int i) {
        Intrinsics.checkNotNullParameter(bigInteger, "<this>");
        BigInteger shiftRight = bigInteger.shiftRight(i);
        Intrinsics.checkNotNullExpressionValue(shiftRight, "shiftRight(...)");
        return shiftRight;
    }

    private static final BigInteger toBigInteger(int i) {
        BigInteger valueOf = BigInteger.valueOf(i);
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(...)");
        return valueOf;
    }

    private static final BigInteger toBigInteger(long j) {
        BigInteger valueOf = BigInteger.valueOf(j);
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(...)");
        return valueOf;
    }

    /* renamed from: toBigInteger-WZ4Q5Ns  reason: not valid java name */
    private static final BigInteger m9915toBigIntegerWZ4Q5Ns(int i) {
        BigInteger valueOf = BigInteger.valueOf(i & 4294967295L);
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(...)");
        return valueOf;
    }

    /* renamed from: toBigInteger-VKZWuLQ  reason: not valid java name */
    public static final BigInteger m9914toBigIntegerVKZWuLQ(long j) {
        if (j >= 0) {
            BigInteger valueOf = BigInteger.valueOf(j);
            Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(...)");
            return valueOf;
        }
        BigInteger valueOf2 = BigInteger.valueOf(UByte$$ExternalSyntheticBackport0.m9988m(j, 2L));
        Intrinsics.checkNotNullExpressionValue(valueOf2, "valueOf(...)");
        BigInteger shiftLeft = valueOf2.shiftLeft(1);
        int i = (UByte$$ExternalSyntheticBackport0.m$1(j, 2L) > 1L ? 1 : (UByte$$ExternalSyntheticBackport0.m$1(j, 2L) == 1L ? 0 : -1));
        Intrinsics.checkNotNull(shiftLeft);
        if (i == 0) {
            BigInteger ONE = BigInteger.ONE;
            Intrinsics.checkNotNullExpressionValue(ONE, "ONE");
            BigInteger add = shiftLeft.add(ONE);
            Intrinsics.checkNotNullExpressionValue(add, "add(...)");
            return add;
        }
        return shiftLeft;
    }

    private static final BigDecimal toBigDecimal(BigInteger bigInteger) {
        Intrinsics.checkNotNullParameter(bigInteger, "<this>");
        return new BigDecimal(bigInteger);
    }

    static /* synthetic */ BigDecimal toBigDecimal$default(BigInteger bigInteger, int i, MathContext mathContext, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        if ((i2 & 2) != 0) {
            mathContext = MathContext.UNLIMITED;
            Intrinsics.checkNotNullExpressionValue(mathContext, "UNLIMITED");
        }
        Intrinsics.checkNotNullParameter(bigInteger, "<this>");
        Intrinsics.checkNotNullParameter(mathContext, "mathContext");
        return new BigDecimal(bigInteger, i, mathContext);
    }

    private static final BigDecimal toBigDecimal(BigInteger bigInteger, int i, MathContext mathContext) {
        Intrinsics.checkNotNullParameter(bigInteger, "<this>");
        Intrinsics.checkNotNullParameter(mathContext, "mathContext");
        return new BigDecimal(bigInteger, i, mathContext);
    }
}
