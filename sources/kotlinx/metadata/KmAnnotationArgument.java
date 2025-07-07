package kotlinx.metadata;

import androidx.exifinterface.media.ExifInterface;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Annotations.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0013\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017B\u0007\b\u0004¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&\u0082\u0001\u0006\u0018\u0019\u001a\u001b\u001c\u001d¨\u0006\u001e"}, d2 = {"Lkotlinx/metadata/KmAnnotationArgument;", "", "()V", "toString", "", "AnnotationValue", "ArrayKClassValue", "ArrayValue", "BooleanValue", "ByteValue", "CharValue", "DoubleValue", "EnumValue", "FloatValue", "IntValue", "KClassValue", "LiteralValue", "LongValue", "ShortValue", "StringValue", "UByteValue", "UIntValue", "ULongValue", "UShortValue", "Lkotlinx/metadata/KmAnnotationArgument$AnnotationValue;", "Lkotlinx/metadata/KmAnnotationArgument$ArrayKClassValue;", "Lkotlinx/metadata/KmAnnotationArgument$ArrayValue;", "Lkotlinx/metadata/KmAnnotationArgument$EnumValue;", "Lkotlinx/metadata/KmAnnotationArgument$KClassValue;", "Lkotlinx/metadata/KmAnnotationArgument$LiteralValue;", "kotlinx-metadata"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class KmAnnotationArgument {
    public /* synthetic */ KmAnnotationArgument(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract String toString();

    private KmAnnotationArgument() {
    }

    /* compiled from: Annotations.kt */
    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000*\n\b\u0000\u0010\u0001 \u0001*\u00020\u00022\u00020\u0003B\u0007\b\u0004¢\u0006\u0002\u0010\u0004J\u0006\u0010\b\u001a\u00020\tR\u0012\u0010\u0005\u001a\u00028\u0000X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\r\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016¨\u0006\u0017"}, d2 = {"Lkotlinx/metadata/KmAnnotationArgument$LiteralValue;", ExifInterface.GPS_DIRECTION_TRUE, "", "Lkotlinx/metadata/KmAnnotationArgument;", "()V", "value", "getValue", "()Ljava/lang/Object;", "toString", "", "Lkotlinx/metadata/KmAnnotationArgument$BooleanValue;", "Lkotlinx/metadata/KmAnnotationArgument$ByteValue;", "Lkotlinx/metadata/KmAnnotationArgument$CharValue;", "Lkotlinx/metadata/KmAnnotationArgument$DoubleValue;", "Lkotlinx/metadata/KmAnnotationArgument$FloatValue;", "Lkotlinx/metadata/KmAnnotationArgument$IntValue;", "Lkotlinx/metadata/KmAnnotationArgument$LongValue;", "Lkotlinx/metadata/KmAnnotationArgument$ShortValue;", "Lkotlinx/metadata/KmAnnotationArgument$StringValue;", "Lkotlinx/metadata/KmAnnotationArgument$UByteValue;", "Lkotlinx/metadata/KmAnnotationArgument$UIntValue;", "Lkotlinx/metadata/KmAnnotationArgument$ULongValue;", "Lkotlinx/metadata/KmAnnotationArgument$UShortValue;", "kotlinx-metadata"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static abstract class LiteralValue<T> extends KmAnnotationArgument {
        public /* synthetic */ LiteralValue(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public abstract T getValue();

        private LiteralValue() {
            super(null);
        }

        @Override // kotlinx.metadata.KmAnnotationArgument
        public final String toString() {
            return getClass().getSimpleName() + '(' + (this instanceof StringValue ? "\"" + ((StringValue) this).getValue() + '\"' : getValue().toString()) + ')';
        }
    }

    /* compiled from: Annotations.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0005\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lkotlinx/metadata/KmAnnotationArgument$ByteValue;", "Lkotlinx/metadata/KmAnnotationArgument$LiteralValue;", "", "value", "(B)V", "getValue", "()Ljava/lang/Byte;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "kotlinx-metadata"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class ByteValue extends LiteralValue<Byte> {
        private final byte value;

        public static /* synthetic */ ByteValue copy$default(ByteValue byteValue, byte b, int i, Object obj) {
            if ((i & 1) != 0) {
                b = byteValue.value;
            }
            return byteValue.copy(b);
        }

        public final byte component1() {
            return this.value;
        }

        public final ByteValue copy(byte b) {
            return new ByteValue(b);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ByteValue) && this.value == ((ByteValue) obj).value;
        }

        public int hashCode() {
            return Byte.hashCode(this.value);
        }

        public ByteValue(byte b) {
            super(null);
            this.value = b;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlinx.metadata.KmAnnotationArgument.LiteralValue
        public Byte getValue() {
            return Byte.valueOf(this.value);
        }
    }

    /* compiled from: Annotations.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lkotlinx/metadata/KmAnnotationArgument$CharValue;", "Lkotlinx/metadata/KmAnnotationArgument$LiteralValue;", "", "value", "(C)V", "getValue", "()Ljava/lang/Character;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "kotlinx-metadata"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class CharValue extends LiteralValue<Character> {
        private final char value;

        public static /* synthetic */ CharValue copy$default(CharValue charValue, char c, int i, Object obj) {
            if ((i & 1) != 0) {
                c = charValue.value;
            }
            return charValue.copy(c);
        }

        public final char component1() {
            return this.value;
        }

        public final CharValue copy(char c) {
            return new CharValue(c);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof CharValue) && this.value == ((CharValue) obj).value;
        }

        public int hashCode() {
            return Character.hashCode(this.value);
        }

        public CharValue(char c) {
            super(null);
            this.value = c;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlinx.metadata.KmAnnotationArgument.LiteralValue
        public Character getValue() {
            return Character.valueOf(this.value);
        }
    }

    /* compiled from: Annotations.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\n\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lkotlinx/metadata/KmAnnotationArgument$ShortValue;", "Lkotlinx/metadata/KmAnnotationArgument$LiteralValue;", "", "value", "(S)V", "getValue", "()Ljava/lang/Short;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "kotlinx-metadata"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class ShortValue extends LiteralValue<Short> {
        private final short value;

        public static /* synthetic */ ShortValue copy$default(ShortValue shortValue, short s, int i, Object obj) {
            if ((i & 1) != 0) {
                s = shortValue.value;
            }
            return shortValue.copy(s);
        }

        public final short component1() {
            return this.value;
        }

        public final ShortValue copy(short s) {
            return new ShortValue(s);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ShortValue) && this.value == ((ShortValue) obj).value;
        }

        public int hashCode() {
            return Short.hashCode(this.value);
        }

        public ShortValue(short s) {
            super(null);
            this.value = s;
        }

        @Override // kotlinx.metadata.KmAnnotationArgument.LiteralValue
        public Short getValue() {
            return Short.valueOf(this.value);
        }
    }

    /* compiled from: Annotations.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000e"}, d2 = {"Lkotlinx/metadata/KmAnnotationArgument$IntValue;", "Lkotlinx/metadata/KmAnnotationArgument$LiteralValue;", "", "value", "(I)V", "getValue", "()Ljava/lang/Integer;", "component1", "copy", "equals", "", "other", "", "hashCode", "kotlinx-metadata"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class IntValue extends LiteralValue<Integer> {
        private final int value;

        public static /* synthetic */ IntValue copy$default(IntValue intValue, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = intValue.value;
            }
            return intValue.copy(i);
        }

        public final int component1() {
            return this.value;
        }

        public final IntValue copy(int i) {
            return new IntValue(i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof IntValue) && this.value == ((IntValue) obj).value;
        }

        public int hashCode() {
            return Integer.hashCode(this.value);
        }

        public IntValue(int i) {
            super(null);
            this.value = i;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlinx.metadata.KmAnnotationArgument.LiteralValue
        public Integer getValue() {
            return Integer.valueOf(this.value);
        }
    }

    /* compiled from: Annotations.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lkotlinx/metadata/KmAnnotationArgument$LongValue;", "Lkotlinx/metadata/KmAnnotationArgument$LiteralValue;", "", "value", "(J)V", "getValue", "()Ljava/lang/Long;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "kotlinx-metadata"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class LongValue extends LiteralValue<Long> {
        private final long value;

        public static /* synthetic */ LongValue copy$default(LongValue longValue, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                j = longValue.value;
            }
            return longValue.copy(j);
        }

        public final long component1() {
            return this.value;
        }

        public final LongValue copy(long j) {
            return new LongValue(j);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof LongValue) && this.value == ((LongValue) obj).value;
        }

        public int hashCode() {
            return Long.hashCode(this.value);
        }

        public LongValue(long j) {
            super(null);
            this.value = j;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlinx.metadata.KmAnnotationArgument.LiteralValue
        public Long getValue() {
            return Long.valueOf(this.value);
        }
    }

    /* compiled from: Annotations.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lkotlinx/metadata/KmAnnotationArgument$FloatValue;", "Lkotlinx/metadata/KmAnnotationArgument$LiteralValue;", "", "value", "(F)V", "getValue", "()Ljava/lang/Float;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "kotlinx-metadata"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class FloatValue extends LiteralValue<Float> {
        private final float value;

        public static /* synthetic */ FloatValue copy$default(FloatValue floatValue, float f, int i, Object obj) {
            if ((i & 1) != 0) {
                f = floatValue.value;
            }
            return floatValue.copy(f);
        }

        public final float component1() {
            return this.value;
        }

        public final FloatValue copy(float f) {
            return new FloatValue(f);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof FloatValue) && Float.compare(this.value, ((FloatValue) obj).value) == 0;
        }

        public int hashCode() {
            return Float.hashCode(this.value);
        }

        public FloatValue(float f) {
            super(null);
            this.value = f;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlinx.metadata.KmAnnotationArgument.LiteralValue
        public Float getValue() {
            return Float.valueOf(this.value);
        }
    }

    /* compiled from: Annotations.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lkotlinx/metadata/KmAnnotationArgument$DoubleValue;", "Lkotlinx/metadata/KmAnnotationArgument$LiteralValue;", "", "value", "(D)V", "getValue", "()Ljava/lang/Double;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "kotlinx-metadata"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class DoubleValue extends LiteralValue<Double> {
        private final double value;

        public static /* synthetic */ DoubleValue copy$default(DoubleValue doubleValue, double d, int i, Object obj) {
            if ((i & 1) != 0) {
                d = doubleValue.value;
            }
            return doubleValue.copy(d);
        }

        public final double component1() {
            return this.value;
        }

        public final DoubleValue copy(double d) {
            return new DoubleValue(d);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof DoubleValue) && Double.compare(this.value, ((DoubleValue) obj).value) == 0;
        }

        public int hashCode() {
            return Double.hashCode(this.value);
        }

        public DoubleValue(double d) {
            super(null);
            this.value = d;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlinx.metadata.KmAnnotationArgument.LiteralValue
        public Double getValue() {
            return Double.valueOf(this.value);
        }
    }

    /* compiled from: Annotations.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000e"}, d2 = {"Lkotlinx/metadata/KmAnnotationArgument$BooleanValue;", "Lkotlinx/metadata/KmAnnotationArgument$LiteralValue;", "", "value", "(Z)V", "getValue", "()Ljava/lang/Boolean;", "component1", "copy", "equals", "other", "", "hashCode", "", "kotlinx-metadata"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class BooleanValue extends LiteralValue<Boolean> {
        private final boolean value;

        public static /* synthetic */ BooleanValue copy$default(BooleanValue booleanValue, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = booleanValue.value;
            }
            return booleanValue.copy(z);
        }

        public final boolean component1() {
            return this.value;
        }

        public final BooleanValue copy(boolean z) {
            return new BooleanValue(z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof BooleanValue) && this.value == ((BooleanValue) obj).value;
        }

        public int hashCode() {
            return Boolean.hashCode(this.value);
        }

        public BooleanValue(boolean z) {
            super(null);
            this.value = z;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlinx.metadata.KmAnnotationArgument.LiteralValue
        public Boolean getValue() {
            return Boolean.valueOf(this.value);
        }
    }

    /* compiled from: Annotations.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0002\u0010\u0004J\u0016\u0010\b\u001a\u00020\u0002HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\t\u0010\u0006J\u001d\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u001c\u0010\u0003\u001a\u00020\u0002X\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0013"}, d2 = {"Lkotlinx/metadata/KmAnnotationArgument$UByteValue;", "Lkotlinx/metadata/KmAnnotationArgument$LiteralValue;", "Lkotlin/UByte;", "value", "(BLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getValue-w2LRezQ", "()B", "B", "component1", "component1-w2LRezQ", "copy", "copy-7apg3OU", "(B)Lkotlinx/metadata/KmAnnotationArgument$UByteValue;", "equals", "", "other", "", "hashCode", "", "kotlinx-metadata"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class UByteValue extends LiteralValue<UByte> {
        private final byte value;

        public /* synthetic */ UByteValue(byte b, DefaultConstructorMarker defaultConstructorMarker) {
            this(b);
        }

        /* renamed from: copy-7apg3OU$default  reason: not valid java name */
        public static /* synthetic */ UByteValue m10086copy7apg3OU$default(UByteValue uByteValue, byte b, int i, Object obj) {
            if ((i & 1) != 0) {
                b = uByteValue.value;
            }
            return uByteValue.m10088copy7apg3OU(b);
        }

        /* renamed from: component1-w2LRezQ  reason: not valid java name */
        public final byte m10087component1w2LRezQ() {
            return this.value;
        }

        /* renamed from: copy-7apg3OU  reason: not valid java name */
        public final UByteValue m10088copy7apg3OU(byte b) {
            return new UByteValue(b, null);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof UByteValue) && this.value == ((UByteValue) obj).value;
        }

        public int hashCode() {
            return UByte.m8473hashCodeimpl(this.value);
        }

        private UByteValue(byte b) {
            super(null);
            this.value = b;
        }

        @Override // kotlinx.metadata.KmAnnotationArgument.LiteralValue
        public /* bridge */ /* synthetic */ UByte getValue() {
            return UByte.m8455boximpl(m10089getValuew2LRezQ());
        }

        /* renamed from: getValue-w2LRezQ  reason: not valid java name */
        public byte m10089getValuew2LRezQ() {
            return this.value;
        }
    }

    /* compiled from: Annotations.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0002\u0010\u0004J\u0016\u0010\b\u001a\u00020\u0002HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\t\u0010\u0006J\u001d\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u001c\u0010\u0003\u001a\u00020\u0002X\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0013"}, d2 = {"Lkotlinx/metadata/KmAnnotationArgument$UShortValue;", "Lkotlinx/metadata/KmAnnotationArgument$LiteralValue;", "Lkotlin/UShort;", "value", "(SLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getValue-Mh2AYeg", "()S", ExifInterface.LATITUDE_SOUTH, "component1", "component1-Mh2AYeg", "copy", "copy-xj2QHRw", "(S)Lkotlinx/metadata/KmAnnotationArgument$UShortValue;", "equals", "", "other", "", "hashCode", "", "kotlinx-metadata"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class UShortValue extends LiteralValue<UShort> {
        private final short value;

        public /* synthetic */ UShortValue(short s, DefaultConstructorMarker defaultConstructorMarker) {
            this(s);
        }

        /* renamed from: copy-xj2QHRw$default  reason: not valid java name */
        public static /* synthetic */ UShortValue m10098copyxj2QHRw$default(UShortValue uShortValue, short s, int i, Object obj) {
            if ((i & 1) != 0) {
                s = uShortValue.value;
            }
            return uShortValue.m10100copyxj2QHRw(s);
        }

        /* renamed from: component1-Mh2AYeg  reason: not valid java name */
        public final short m10099component1Mh2AYeg() {
            return this.value;
        }

        /* renamed from: copy-xj2QHRw  reason: not valid java name */
        public final UShortValue m10100copyxj2QHRw(short s) {
            return new UShortValue(s, null);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof UShortValue) && this.value == ((UShortValue) obj).value;
        }

        public int hashCode() {
            return UShort.m8738hashCodeimpl(this.value);
        }

        private UShortValue(short s) {
            super(null);
            this.value = s;
        }

        @Override // kotlinx.metadata.KmAnnotationArgument.LiteralValue
        public /* bridge */ /* synthetic */ UShort getValue() {
            return UShort.m8720boximpl(m10101getValueMh2AYeg());
        }

        /* renamed from: getValue-Mh2AYeg  reason: not valid java name */
        public short m10101getValueMh2AYeg() {
            return this.value;
        }
    }

    /* compiled from: Annotations.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0002\u0010\u0004J\u0016\u0010\b\u001a\u00020\u0002HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\t\u0010\u0006J\u001d\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u001c\u0010\u0003\u001a\u00020\u0002X\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0013"}, d2 = {"Lkotlinx/metadata/KmAnnotationArgument$UIntValue;", "Lkotlinx/metadata/KmAnnotationArgument$LiteralValue;", "Lkotlin/UInt;", "value", "(ILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getValue-pVg5ArA", "()I", "I", "component1", "component1-pVg5ArA", "copy", "copy-WZ4Q5Ns", "(I)Lkotlinx/metadata/KmAnnotationArgument$UIntValue;", "equals", "", "other", "", "hashCode", "", "kotlinx-metadata"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class UIntValue extends LiteralValue<UInt> {
        private final int value;

        public /* synthetic */ UIntValue(int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(i);
        }

        /* renamed from: copy-WZ4Q5Ns$default  reason: not valid java name */
        public static /* synthetic */ UIntValue m10090copyWZ4Q5Ns$default(UIntValue uIntValue, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = uIntValue.value;
            }
            return uIntValue.m10092copyWZ4Q5Ns(i);
        }

        /* renamed from: component1-pVg5ArA  reason: not valid java name */
        public final int m10091component1pVg5ArA() {
            return this.value;
        }

        /* renamed from: copy-WZ4Q5Ns  reason: not valid java name */
        public final UIntValue m10092copyWZ4Q5Ns(int i) {
            return new UIntValue(i, null);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof UIntValue) && this.value == ((UIntValue) obj).value;
        }

        public int hashCode() {
            return UInt.m8552hashCodeimpl(this.value);
        }

        private UIntValue(int i) {
            super(null);
            this.value = i;
        }

        @Override // kotlinx.metadata.KmAnnotationArgument.LiteralValue
        public /* bridge */ /* synthetic */ UInt getValue() {
            return UInt.m8534boximpl(m10093getValuepVg5ArA());
        }

        /* renamed from: getValue-pVg5ArA  reason: not valid java name */
        public int m10093getValuepVg5ArA() {
            return this.value;
        }
    }

    /* compiled from: Annotations.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0002\u0010\u0004J\u0016\u0010\b\u001a\u00020\u0002HÆ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\t\u0010\u0006J\u001d\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u001c\u0010\u0003\u001a\u00020\u0002X\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0013"}, d2 = {"Lkotlinx/metadata/KmAnnotationArgument$ULongValue;", "Lkotlinx/metadata/KmAnnotationArgument$LiteralValue;", "Lkotlin/ULong;", "value", "(JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getValue-s-VKNKU", "()J", "J", "component1", "component1-s-VKNKU", "copy", "copy-VKZWuLQ", "(J)Lkotlinx/metadata/KmAnnotationArgument$ULongValue;", "equals", "", "other", "", "hashCode", "", "kotlinx-metadata"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class ULongValue extends LiteralValue<ULong> {
        private final long value;

        public /* synthetic */ ULongValue(long j, DefaultConstructorMarker defaultConstructorMarker) {
            this(j);
        }

        /* renamed from: copy-VKZWuLQ$default  reason: not valid java name */
        public static /* synthetic */ ULongValue m10094copyVKZWuLQ$default(ULongValue uLongValue, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                j = uLongValue.value;
            }
            return uLongValue.m10096copyVKZWuLQ(j);
        }

        /* renamed from: component1-s-VKNKU  reason: not valid java name */
        public final long m10095component1sVKNKU() {
            return this.value;
        }

        /* renamed from: copy-VKZWuLQ  reason: not valid java name */
        public final ULongValue m10096copyVKZWuLQ(long j) {
            return new ULongValue(j, null);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ULongValue) && this.value == ((ULongValue) obj).value;
        }

        public int hashCode() {
            return ULong.m8631hashCodeimpl(this.value);
        }

        private ULongValue(long j) {
            super(null);
            this.value = j;
        }

        @Override // kotlinx.metadata.KmAnnotationArgument.LiteralValue
        public /* bridge */ /* synthetic */ ULong getValue() {
            return ULong.m8613boximpl(m10097getValuesVKNKU());
        }

        /* renamed from: getValue-s-VKNKU  reason: not valid java name */
        public long m10097getValuesVKNKU() {
            return this.value;
        }
    }

    /* compiled from: Annotations.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lkotlinx/metadata/KmAnnotationArgument$StringValue;", "Lkotlinx/metadata/KmAnnotationArgument$LiteralValue;", "", "value", "(Ljava/lang/String;)V", "getValue", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "kotlinx-metadata"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class StringValue extends LiteralValue<String> {
        private final String value;

        public static /* synthetic */ StringValue copy$default(StringValue stringValue, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = stringValue.value;
            }
            return stringValue.copy(str);
        }

        public final String component1() {
            return this.value;
        }

        public final StringValue copy(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return new StringValue(value);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof StringValue) && Intrinsics.areEqual(this.value, ((StringValue) obj).value);
        }

        public int hashCode() {
            return this.value.hashCode();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public StringValue(String value) {
            super(null);
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        @Override // kotlinx.metadata.KmAnnotationArgument.LiteralValue
        public String getValue() {
            return this.value;
        }
    }

    /* compiled from: Annotations.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\r\u0010\n\u001a\u00060\u0003j\u0002`\u0004HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J!\u0010\f\u001a\u00020\u00002\f\b\u0002\u0010\u0002\u001a\u00060\u0003j\u0002`\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\b\u0010\u0013\u001a\u00020\u0003H\u0016R\u0015\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lkotlinx/metadata/KmAnnotationArgument$EnumValue;", "Lkotlinx/metadata/KmAnnotationArgument;", "enumClassName", "", "Lkotlinx/metadata/ClassName;", "enumEntryName", "(Ljava/lang/String;Ljava/lang/String;)V", "getEnumClassName", "()Ljava/lang/String;", "getEnumEntryName", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "kotlinx-metadata"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class EnumValue extends KmAnnotationArgument {
        private final String enumClassName;
        private final String enumEntryName;

        public static /* synthetic */ EnumValue copy$default(EnumValue enumValue, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = enumValue.enumClassName;
            }
            if ((i & 2) != 0) {
                str2 = enumValue.enumEntryName;
            }
            return enumValue.copy(str, str2);
        }

        public final String component1() {
            return this.enumClassName;
        }

        public final String component2() {
            return this.enumEntryName;
        }

        public final EnumValue copy(String enumClassName, String enumEntryName) {
            Intrinsics.checkNotNullParameter(enumClassName, "enumClassName");
            Intrinsics.checkNotNullParameter(enumEntryName, "enumEntryName");
            return new EnumValue(enumClassName, enumEntryName);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof EnumValue) {
                EnumValue enumValue = (EnumValue) obj;
                return Intrinsics.areEqual(this.enumClassName, enumValue.enumClassName) && Intrinsics.areEqual(this.enumEntryName, enumValue.enumEntryName);
            }
            return false;
        }

        public int hashCode() {
            return (this.enumClassName.hashCode() * 31) + this.enumEntryName.hashCode();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public EnumValue(String enumClassName, String enumEntryName) {
            super(null);
            Intrinsics.checkNotNullParameter(enumClassName, "enumClassName");
            Intrinsics.checkNotNullParameter(enumEntryName, "enumEntryName");
            this.enumClassName = enumClassName;
            this.enumEntryName = enumEntryName;
        }

        public final String getEnumClassName() {
            return this.enumClassName;
        }

        public final String getEnumEntryName() {
            return this.enumEntryName;
        }

        @Override // kotlinx.metadata.KmAnnotationArgument
        public String toString() {
            return "EnumValue(" + this.enumClassName + '.' + this.enumEntryName + ')';
        }
    }

    /* compiled from: Annotations.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\b\u0010\u000f\u001a\u00020\u0010H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lkotlinx/metadata/KmAnnotationArgument$AnnotationValue;", "Lkotlinx/metadata/KmAnnotationArgument;", "annotation", "Lkotlinx/metadata/KmAnnotation;", "(Lkotlinx/metadata/KmAnnotation;)V", "getAnnotation", "()Lkotlinx/metadata/KmAnnotation;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "kotlinx-metadata"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class AnnotationValue extends KmAnnotationArgument {
        private final KmAnnotation annotation;

        public static /* synthetic */ AnnotationValue copy$default(AnnotationValue annotationValue, KmAnnotation kmAnnotation, int i, Object obj) {
            if ((i & 1) != 0) {
                kmAnnotation = annotationValue.annotation;
            }
            return annotationValue.copy(kmAnnotation);
        }

        public final KmAnnotation component1() {
            return this.annotation;
        }

        public final AnnotationValue copy(KmAnnotation annotation) {
            Intrinsics.checkNotNullParameter(annotation, "annotation");
            return new AnnotationValue(annotation);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof AnnotationValue) && Intrinsics.areEqual(this.annotation, ((AnnotationValue) obj).annotation);
        }

        public int hashCode() {
            return this.annotation.hashCode();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnnotationValue(KmAnnotation annotation) {
            super(null);
            Intrinsics.checkNotNullParameter(annotation, "annotation");
            this.annotation = annotation;
        }

        public final KmAnnotation getAnnotation() {
            return this.annotation;
        }

        @Override // kotlinx.metadata.KmAnnotationArgument
        public String toString() {
            return "AnnotationValue(" + this.annotation + ')';
        }
    }

    /* compiled from: Annotations.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003HÆ\u0003J\u0019\u0010\b\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\b\u0010\u000f\u001a\u00020\u0010H\u0016R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lkotlinx/metadata/KmAnnotationArgument$ArrayValue;", "Lkotlinx/metadata/KmAnnotationArgument;", "elements", "", "(Ljava/util/List;)V", "getElements", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "kotlinx-metadata"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class ArrayValue extends KmAnnotationArgument {
        private final List<KmAnnotationArgument> elements;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ArrayValue copy$default(ArrayValue arrayValue, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = arrayValue.elements;
            }
            return arrayValue.copy(list);
        }

        public final List<KmAnnotationArgument> component1() {
            return this.elements;
        }

        public final ArrayValue copy(List<? extends KmAnnotationArgument> elements) {
            Intrinsics.checkNotNullParameter(elements, "elements");
            return new ArrayValue(elements);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ArrayValue) && Intrinsics.areEqual(this.elements, ((ArrayValue) obj).elements);
        }

        public int hashCode() {
            return this.elements.hashCode();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public ArrayValue(List<? extends KmAnnotationArgument> elements) {
            super(null);
            Intrinsics.checkNotNullParameter(elements, "elements");
            this.elements = elements;
        }

        public final List<KmAnnotationArgument> getElements() {
            return this.elements;
        }

        @Override // kotlinx.metadata.KmAnnotationArgument
        public String toString() {
            return "ArrayValue(" + this.elements + ')';
        }
    }

    /* compiled from: Annotations.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\b\u0016\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0002\u0010\u0005B\u001b\b\u0007\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\r\u0010\u000f\u001a\u00060\u0003j\u0002`\u0004HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0007HÆ\u0003J!\u0010\u0011\u001a\u00020\u00002\f\b\u0002\u0010\u0002\u001a\u00060\u0003j\u0002`\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÖ\u0001J\b\u0010\u0017\u001a\u00020\u0003H\u0016R\u001c\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0015\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lkotlinx/metadata/KmAnnotationArgument$KClassValue;", "Lkotlinx/metadata/KmAnnotationArgument;", "className", "", "Lkotlinx/metadata/ClassName;", "(Ljava/lang/String;)V", "arrayDimensionCount", "", "(Ljava/lang/String;I)V", "getArrayDimensionCount$annotations", "()V", "getArrayDimensionCount", "()I", "getClassName", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "kotlinx-metadata"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class KClassValue extends KmAnnotationArgument {
        private final int arrayDimensionCount;
        private final String className;

        public static /* synthetic */ KClassValue copy$default(KClassValue kClassValue, String str, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = kClassValue.className;
            }
            if ((i2 & 2) != 0) {
                i = kClassValue.arrayDimensionCount;
            }
            return kClassValue.copy(str, i);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Use ArrayKClassValue instead")
        public static /* synthetic */ void getArrayDimensionCount$annotations() {
        }

        public final String component1() {
            return this.className;
        }

        public final int component2() {
            return this.arrayDimensionCount;
        }

        public final KClassValue copy(String className, int i) {
            Intrinsics.checkNotNullParameter(className, "className");
            return new KClassValue(className, i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof KClassValue) {
                KClassValue kClassValue = (KClassValue) obj;
                return Intrinsics.areEqual(this.className, kClassValue.className) && this.arrayDimensionCount == kClassValue.arrayDimensionCount;
            }
            return false;
        }

        public int hashCode() {
            return (this.className.hashCode() * 31) + Integer.hashCode(this.arrayDimensionCount);
        }

        public final String getClassName() {
            return this.className;
        }

        public final int getArrayDimensionCount() {
            return this.arrayDimensionCount;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        @Deprecated(level = DeprecationLevel.ERROR, message = "Use single-argument constructor instead or ArrayKClassValue")
        public KClassValue(String className, int i) {
            super(null);
            Intrinsics.checkNotNullParameter(className, "className");
            this.className = className;
            this.arrayDimensionCount = i;
            if (i != 0) {
                throw new IllegalArgumentException("KClassValue must not have array dimensions. For Array<X>::class, use ArrayKClassValue.".toString());
            }
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public KClassValue(String className) {
            this(className, 0);
            Intrinsics.checkNotNullParameter(className, "className");
        }

        @Override // kotlinx.metadata.KmAnnotationArgument
        public String toString() {
            return "KClassValue(" + this.className + ')';
        }
    }

    /* compiled from: Annotations.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\r\u0010\r\u001a\u00060\u0003j\u0002`\u0004HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0006HÆ\u0003J!\u0010\u000f\u001a\u00020\u00002\f\b\u0002\u0010\u0002\u001a\u00060\u0003j\u0002`\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÖ\u0001J\b\u0010\u0015\u001a\u00020\u0003H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0015\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lkotlinx/metadata/KmAnnotationArgument$ArrayKClassValue;", "Lkotlinx/metadata/KmAnnotationArgument;", "className", "", "Lkotlinx/metadata/ClassName;", "arrayDimensionCount", "", "(Ljava/lang/String;I)V", "getArrayDimensionCount", "()I", "getClassName", "()Ljava/lang/String;", "stringRepresentation", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "kotlinx-metadata"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class ArrayKClassValue extends KmAnnotationArgument {
        private final int arrayDimensionCount;
        private final String className;
        private final String stringRepresentation;

        public static /* synthetic */ ArrayKClassValue copy$default(ArrayKClassValue arrayKClassValue, String str, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = arrayKClassValue.className;
            }
            if ((i2 & 2) != 0) {
                i = arrayKClassValue.arrayDimensionCount;
            }
            return arrayKClassValue.copy(str, i);
        }

        public final String component1() {
            return this.className;
        }

        public final int component2() {
            return this.arrayDimensionCount;
        }

        public final ArrayKClassValue copy(String className, int i) {
            Intrinsics.checkNotNullParameter(className, "className");
            return new ArrayKClassValue(className, i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ArrayKClassValue) {
                ArrayKClassValue arrayKClassValue = (ArrayKClassValue) obj;
                return Intrinsics.areEqual(this.className, arrayKClassValue.className) && this.arrayDimensionCount == arrayKClassValue.arrayDimensionCount;
            }
            return false;
        }

        public int hashCode() {
            return (this.className.hashCode() * 31) + Integer.hashCode(this.arrayDimensionCount);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ArrayKClassValue(String className, int i) {
            super(null);
            Intrinsics.checkNotNullParameter(className, "className");
            this.className = className;
            this.arrayDimensionCount = i;
            if (i <= 0) {
                throw new IllegalArgumentException("ArrayKClassValue must have at least one dimension. For regular X::class argument, use KClassValue.".toString());
            }
            StringBuilder sb = new StringBuilder("ArrayKClassValue(");
            for (int i2 = 0; i2 < i; i2++) {
                sb.append("kotlin/Array<");
            }
            sb.append(this.className);
            int i3 = this.arrayDimensionCount;
            for (int i4 = 0; i4 < i3; i4++) {
                sb.append(">");
            }
            sb.append(")");
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
            this.stringRepresentation = sb2;
        }

        public final int getArrayDimensionCount() {
            return this.arrayDimensionCount;
        }

        public final String getClassName() {
            return this.className;
        }

        @Override // kotlinx.metadata.KmAnnotationArgument
        public String toString() {
            return this.stringRepresentation;
        }
    }
}
