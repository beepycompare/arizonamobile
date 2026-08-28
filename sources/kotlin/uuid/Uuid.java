package kotlin.uuid;

import androidx.exifinterface.media.ExifInterface;
import com.facebook.internal.NativeProtocol;
import com.google.common.base.Ascii;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Comparator;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.UByteArray;
import kotlin.ULong;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.time.Clock;
import kotlin.time.Instant;
import okio.Utf8;
/* compiled from: Uuid.kt */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\b\u0007\u0018\u0000 32\b\u0012\u0004\u0012\u00020\u00000\u00012\u00060\u0002j\u0002`\u0003:\u00013B\u0019\bB\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJa\u0010\u0010\u001a\u0002H\u0011\"\u0004\b\u0000\u0010\u001126\u0010\u0012\u001a2\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0004\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u0002H\u00110\u0013H\u0087\u0088\u0004b\u0002\b\u0017ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u0016Ja\u0010\u0018\u001a\u0002H\u0011\"\u0004\b\u0000\u0010\u001126\u0010\u0012\u001a2\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0004\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u0002H\u00110\u0013H\u0087\u0088\u0004b\u0002\b\u0017ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u0016J\n\u0010\u001a\u001a\u00020\u001bH\u0096\u0080\u0004J\n\u0010\u001c\u001a\u00020\u001bH\u0086\u0080\u0004J\n\u0010\u001d\u001a\u00020\u001bH\u0086\u0080\u0004J\n\u0010\u001e\u001a\u00020\u001fH\u0086\u0080\u0004J\u0015\u0010 \u001a\u00020!H\u0087\u0080\u0004b\u0002\b$¢\u0006\u0004\b\"\u0010#J\u0014\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(H\u0096\u0082\u0004J\u0012\u0010)\u001a\u00020*2\u0006\u0010'\u001a\u00020\u0000H\u0096\u0082\u0004J\n\u0010+\u001a\u00020*H\u0096\u0080\u0004J\n\u0010,\u001a\u00020(H\u0082\u0080\u0004J\u001b\u0010-\u001a\u00020.2\n\u0010/\u001a\u000600j\u0002`1H\u0082\u0080\u0004¢\u0006\u0002\u00102R!\u0010\u0004\u001a\u00020\u00058\u0000X\u0081\u0084\br\u0002\b\r¢\u0006\u000e\n\u0000\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR!\u0010\u0006\u001a\u00020\u00058\u0000X\u0081\u0084\br\u0002\b\r¢\u0006\u000e\n\u0000\u0012\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fÊ\u0001\f\b5\u0012\b\b6\u0012\u0004\b\b(7Ê\u0001\u0010\b8\u0012\f\b9\u0012\b\b\fJ\u0004\b\t0:\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u00064"}, d2 = {"Lkotlin/uuid/Uuid;", "", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "mostSignificantBits", "", "leastSignificantBits", "<init>", "(JJ)V", "getMostSignificantBits$annotations", "()V", "getMostSignificantBits", "()J", "Lkotlin/PublishedApi;", "getLeastSignificantBits$annotations", "getLeastSignificantBits", "toLongs", ExifInterface.GPS_DIRECTION_TRUE, "action", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "(Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "Lkotlin/internal/InlineOnly;", "toULongs", "Lkotlin/ULong;", "toString", "", "toHexDashString", "toHexString", "toByteArray", "", "toUByteArray", "Lkotlin/UByteArray;", "toUByteArray-TcUX1vc", "()[B", "Lkotlin/ExperimentalUnsignedTypes;", "equals", "", "other", "", "compareTo", "", "hashCode", "writeReplace", "readObject", "", "input", "Ljava/io/ObjectInputStream;", "Lkotlin/internal/ReadObjectParameterType;", "(Ljava/io/ObjectInputStream;)V", "Companion", "kotlin-stdlib", "Lkotlin/SinceKotlin;", NativeProtocol.PLATFORM_PROVIDER_VERSION_COLUMN, "2.4", "Lkotlin/WasExperimental;", "markerClass", "Lkotlin/uuid/ExperimentalUuidApi;"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class Uuid implements Comparable<Uuid>, Serializable {
    public static final Companion Companion = new Companion(null);
    private static final Uuid NIL = new Uuid(0, 0);
    public static final int SIZE_BITS = 128;
    public static final int SIZE_BYTES = 16;
    private final long leastSignificantBits;
    private final long mostSignificantBits;

    public /* synthetic */ Uuid(long j, long j2, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2);
    }

    public static /* synthetic */ void getLeastSignificantBits$annotations() {
    }

    public static /* synthetic */ void getMostSignificantBits$annotations() {
    }

    private Uuid(long j, long j2) {
        this.mostSignificantBits = j;
        this.leastSignificantBits = j2;
    }

    public final long getMostSignificantBits() {
        return this.mostSignificantBits;
    }

    public final long getLeastSignificantBits() {
        return this.leastSignificantBits;
    }

    private final <T> T toLongs(Function2<? super Long, ? super Long, ? extends T> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        return action.invoke(Long.valueOf(getMostSignificantBits()), Long.valueOf(getLeastSignificantBits()));
    }

    private final <T> T toULongs(Function2<? super ULong, ? super ULong, ? extends T> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        return action.invoke(ULong.m10094boximpl(ULong.m10100constructorimpl(getMostSignificantBits())), ULong.m10094boximpl(ULong.m10100constructorimpl(getLeastSignificantBits())));
    }

    public String toString() {
        return toHexDashString();
    }

    public final String toHexDashString() {
        byte[] bArr = new byte[36];
        UuidKt.formatBytesInto(this.mostSignificantBits, bArr, 0, 0, 4);
        bArr[8] = 45;
        UuidKt.formatBytesInto(this.mostSignificantBits, bArr, 9, 4, 6);
        bArr[13] = 45;
        UuidKt.formatBytesInto(this.mostSignificantBits, bArr, 14, 6, 8);
        bArr[18] = 45;
        UuidKt.formatBytesInto(this.leastSignificantBits, bArr, 19, 0, 2);
        bArr[23] = 45;
        UuidKt.formatBytesInto(this.leastSignificantBits, bArr, 24, 2, 8);
        return StringsKt.decodeToString(bArr);
    }

    public final String toHexString() {
        byte[] bArr = new byte[32];
        UuidKt.formatBytesInto(this.mostSignificantBits, bArr, 0, 0, 8);
        UuidKt.formatBytesInto(this.leastSignificantBits, bArr, 16, 0, 8);
        return StringsKt.decodeToString(bArr);
    }

    public final byte[] toByteArray() {
        byte[] bArr = new byte[16];
        UuidKt.setLongAt(bArr, 0, this.mostSignificantBits);
        UuidKt.setLongAt(bArr, 8, this.leastSignificantBits);
        return bArr;
    }

    /* renamed from: toUByteArray-TcUX1vc  reason: not valid java name */
    public final byte[] m11438toUByteArrayTcUX1vc() {
        return UByteArray.m9997constructorimpl(toByteArray());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Uuid) {
            Uuid uuid = (Uuid) obj;
            return this.mostSignificantBits == uuid.mostSignificantBits && this.leastSignificantBits == uuid.leastSignificantBits;
        }
        return false;
    }

    @Override // java.lang.Comparable
    public int compareTo(Uuid other) {
        int compare;
        int compare2;
        Intrinsics.checkNotNullParameter(other, "other");
        long j = this.mostSignificantBits;
        if (j != other.mostSignificantBits) {
            compare2 = Long.compare(ULong.m10100constructorimpl(j) ^ Long.MIN_VALUE, ULong.m10100constructorimpl(other.mostSignificantBits) ^ Long.MIN_VALUE);
            return compare2;
        }
        compare = Long.compare(ULong.m10100constructorimpl(this.leastSignificantBits) ^ Long.MIN_VALUE, ULong.m10100constructorimpl(other.leastSignificantBits) ^ Long.MIN_VALUE);
        return compare;
    }

    public int hashCode() {
        return Long.hashCode(this.mostSignificantBits ^ this.leastSignificantBits);
    }

    private final Object writeReplace() {
        return UuidKt.serializedUuid(this);
    }

    private final void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization is supported via proxy only");
    }

    /* compiled from: Uuid.kt */
    @Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0086\u0080\u0004J!\u0010\u000f\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\u0010H\u0086\u0080\u0004¢\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0015H\u0086\u0080\u0004J\u001d\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0018H\u0087\u0080\u0004b\u0002\b\u001b¢\u0006\u0004\b\u0019\u0010\u001aJ\u0012\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001eH\u0086\u0080\u0004J\u0014\u0010\u001f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001d\u001a\u00020\u001eH\u0086\u0080\u0004J\u0012\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u001eH\u0086\u0080\u0004J\u0014\u0010\"\u001a\u0004\u0018\u00010\u00052\u0006\u0010!\u001a\u00020\u001eH\u0086\u0080\u0004J\u0012\u0010#\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u001eH\u0086\u0080\u0004J\u0014\u0010%\u001a\u0004\u0018\u00010\u00052\u0006\u0010$\u001a\u00020\u001eH\u0086\u0080\u0004J\n\u0010&\u001a\u00020\u0005H\u0086\u0080\u0004J\u001c\u0010'\u001a\u00020\u0005H\u0087\u0080\u0004b\f\b(\u0012\b\b)\u0012\u0004\b\b(*b\u0002\b+J\u001c\u0010,\u001a\u00020\u0005H\u0087\u0080\u0004b\f\b(\u0012\b\b)\u0012\u0004\b\b(*b\u0002\b+J$\u0010-\u001a\u00020\u00052\u0006\u0010.\u001a\u00020/H\u0087\u0080\u0004b\f\b(\u0012\b\b)\u0012\u0004\b\b(*b\u0002\b+J\u0017\u0010,\u001a\u00020\u00052\u0006\u00100\u001a\u000201H\u0080\u0080\u0004¢\u0006\u0002\b2R\u0015\u0010\u0004\u001a\u00020\u0005X\u0086\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000f\u0010\b\u001a\u00020\tX\u0086Ô\b¢\u0006\u0002\n\u0000R\u000f\u0010\n\u001a\u00020\tX\u0086Ô\b¢\u0006\u0002\n\u0000Ry\u00103\u001a\u0012\u0012\u0004\u0012\u00020\u000504j\b\u0012\u0004\u0012\u00020\u0005`58FX\u0087\u0084\br\u0002\b+r0\b9\u0012\b\b:\u0012\u0004\b\b(;\u0012\"\b<\u0012\u001e\b\u000bB\u001a\b=\u0012\b\b>\u0012\u0004\b\b(?\u0012\f\b@\u0012\b\b\fJ\u0004\b\b(Ar\u0016\bB\u0012\b\bC\u0012\u0004\b\b(D\u0012\b\bE\u0012\u0004\b\b(F¢\u0006\f\u0012\u0004\b6\u0010\u0003\u001a\u0004\b7\u00108¨\u0006G"}, d2 = {"Lkotlin/uuid/Uuid$Companion;", "", "<init>", "()V", "NIL", "Lkotlin/uuid/Uuid;", "getNIL", "()Lkotlin/uuid/Uuid;", "SIZE_BYTES", "", "SIZE_BITS", "fromLongs", "mostSignificantBits", "", "leastSignificantBits", "fromULongs", "Lkotlin/ULong;", "fromULongs-eb3DHEI", "(JJ)Lkotlin/uuid/Uuid;", "fromByteArray", "byteArray", "", "fromUByteArray", "ubyteArray", "Lkotlin/UByteArray;", "fromUByteArray-GBYM_sE", "([B)Lkotlin/uuid/Uuid;", "Lkotlin/ExperimentalUnsignedTypes;", "parse", "uuidString", "", "parseOrNull", "parseHexDash", "hexDashString", "parseHexDashOrNull", "parseHex", "hexString", "parseHexOrNull", "random", "generateV4", "Lkotlin/SinceKotlin;", NativeProtocol.PLATFORM_PROVIDER_VERSION_COLUMN, "2.3", "Lkotlin/uuid/ExperimentalUuidApi;", "generateV7", "generateV7NonMonotonicAt", "timestamp", "Lkotlin/time/Instant;", "clock", "Lkotlin/time/Clock;", "generateV7$kotlin_stdlib", "LEXICAL_ORDER", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "getLEXICAL_ORDER$annotations", "getLEXICAL_ORDER", "()Ljava/util/Comparator;", "Lkotlin/Deprecated;", "message", "Use naturalOrder<Uuid>() instead", "replaceWith", "Lkotlin/ReplaceWith;", "expression", "naturalOrder<Uuid>()", "imports", "kotlin.comparisons.naturalOrder", "Lkotlin/DeprecatedSinceKotlin;", "warningSince", "2.1", "errorSince", "2.4", "kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Deprecated(message = "Use naturalOrder<Uuid>() instead", replaceWith = @ReplaceWith(expression = "naturalOrder<Uuid>()", imports = {"kotlin.comparisons.naturalOrder"}))
        @DeprecatedSinceKotlin(errorSince = "2.4", warningSince = "2.1")
        public static /* synthetic */ void getLEXICAL_ORDER$annotations() {
        }

        private Companion() {
        }

        public final Uuid getNIL() {
            return Uuid.NIL;
        }

        public final Uuid fromLongs(long j, long j2) {
            if (j == 0 && j2 == 0) {
                return getNIL();
            }
            return new Uuid(j, j2, null);
        }

        /* renamed from: fromULongs-eb3DHEI  reason: not valid java name */
        public final Uuid m11440fromULongseb3DHEI(long j, long j2) {
            return fromLongs(j, j2);
        }

        public final Uuid fromByteArray(byte[] byteArray) {
            String truncateForErrorMessage$UuidKt__UuidKt;
            Intrinsics.checkNotNullParameter(byteArray, "byteArray");
            if (byteArray.length != 16) {
                StringBuilder sb = new StringBuilder("Expected exactly 16 bytes, but was ");
                truncateForErrorMessage$UuidKt__UuidKt = UuidKt__UuidKt.truncateForErrorMessage$UuidKt__UuidKt(byteArray, 32);
                throw new IllegalArgumentException(sb.append(truncateForErrorMessage$UuidKt__UuidKt).append(" of size ").append(byteArray.length).toString().toString());
            }
            return fromLongs(UuidKt.getLongAt(byteArray, 0), UuidKt.getLongAt(byteArray, 8));
        }

        /* renamed from: fromUByteArray-GBYM_sE  reason: not valid java name */
        public final Uuid m11439fromUByteArrayGBYM_sE(byte[] ubyteArray) {
            Intrinsics.checkNotNullParameter(ubyteArray, "ubyteArray");
            return fromByteArray(ubyteArray);
        }

        public final Uuid parse(String uuidString) {
            String truncateForErrorMessage$UuidKt__UuidKt;
            Intrinsics.checkNotNullParameter(uuidString, "uuidString");
            int length = uuidString.length();
            if (length != 32) {
                if (length == 36) {
                    return UuidKt.uuidParseHexDash(uuidString);
                }
                StringBuilder sb = new StringBuilder("Expected either a 36-char string in the standard hex-and-dash UUID format or a 32-char hexadecimal string, but was \"");
                truncateForErrorMessage$UuidKt__UuidKt = UuidKt__UuidKt.truncateForErrorMessage$UuidKt__UuidKt(uuidString, 64);
                throw new IllegalArgumentException(sb.append(truncateForErrorMessage$UuidKt__UuidKt).append("\" of length ").append(uuidString.length()).toString());
            }
            return UuidKt.uuidParseHex(uuidString);
        }

        public final Uuid parseOrNull(String uuidString) {
            Intrinsics.checkNotNullParameter(uuidString, "uuidString");
            int length = uuidString.length();
            if (length != 32) {
                if (length != 36) {
                    return null;
                }
                return parseHexDashOrNull(uuidString);
            }
            return parseHexOrNull(uuidString);
        }

        public final Uuid parseHexDash(String hexDashString) {
            String truncateForErrorMessage$UuidKt__UuidKt;
            Intrinsics.checkNotNullParameter(hexDashString, "hexDashString");
            if (hexDashString.length() == 36) {
                return UuidKt.uuidParseHexDash(hexDashString);
            }
            StringBuilder sb = new StringBuilder("Expected a 36-char string in the standard hex-and-dash UUID format, but was \"");
            truncateForErrorMessage$UuidKt__UuidKt = UuidKt__UuidKt.truncateForErrorMessage$UuidKt__UuidKt(hexDashString, 64);
            throw new IllegalArgumentException(sb.append(truncateForErrorMessage$UuidKt__UuidKt).append("\" of length ").append(hexDashString.length()).toString().toString());
        }

        public final Uuid parseHexDashOrNull(String hexDashString) {
            Intrinsics.checkNotNullParameter(hexDashString, "hexDashString");
            if (hexDashString.length() != 36) {
                return null;
            }
            return UuidKt.uuidParseHexDashOrNull(hexDashString);
        }

        public final Uuid parseHex(String hexString) {
            String truncateForErrorMessage$UuidKt__UuidKt;
            Intrinsics.checkNotNullParameter(hexString, "hexString");
            if (hexString.length() == 32) {
                return UuidKt.uuidParseHex(hexString);
            }
            StringBuilder sb = new StringBuilder("Expected a 32-char hexadecimal string, but was \"");
            truncateForErrorMessage$UuidKt__UuidKt = UuidKt__UuidKt.truncateForErrorMessage$UuidKt__UuidKt(hexString, 64);
            throw new IllegalArgumentException(sb.append(truncateForErrorMessage$UuidKt__UuidKt).append("\" of length ").append(hexString.length()).toString().toString());
        }

        public final Uuid parseHexOrNull(String hexString) {
            Intrinsics.checkNotNullParameter(hexString, "hexString");
            if (hexString.length() != 32) {
                return null;
            }
            return UuidKt.uuidParseHexOrNull(hexString);
        }

        public final Uuid random() {
            return generateV4();
        }

        public final Uuid generateV4() {
            return UuidKt.secureRandomUuid();
        }

        public final Uuid generateV7() {
            return generateV7$kotlin_stdlib(Clock.System.INSTANCE);
        }

        public final Uuid generateV7NonMonotonicAt(Instant timestamp) {
            Intrinsics.checkNotNullParameter(timestamp, "timestamp");
            byte[] bArr = new byte[10];
            UuidKt.secureRandomBytes(bArr);
            int i = (((bArr[8] & Ascii.SI) | 112) << 8) | (bArr[9] & 255);
            bArr[0] = (byte) (((byte) (bArr[0] & Utf8.REPLACEMENT_BYTE)) | Byte.MIN_VALUE);
            return fromLongs((timestamp.toEpochMilliseconds() << 16) | i, UuidKt.getLongAt(bArr, 0));
        }

        public final Uuid generateV7$kotlin_stdlib(Clock clock) {
            Intrinsics.checkNotNullParameter(clock, "clock");
            return UuidV7Generator.INSTANCE.generate(clock);
        }

        public final Comparator<Uuid> getLEXICAL_ORDER() {
            return ComparisonsKt.naturalOrder();
        }
    }
}
