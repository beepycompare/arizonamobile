package kotlinx.datetime.internal.format.parser;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ParseResult.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0081@\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJA\u0010\u0010\u001a\u0002H\u0011\"\u0004\b\u0000\u0010\u00112\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u0002H\u00110\u00132\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u0002H\u00110\u0013H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0088\u0001\u0002\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001d"}, d2 = {"Lkotlinx/datetime/internal/format/parser/ParseResult;", "", "value", "constructor-impl", "(Ljava/lang/Object;)Ljava/lang/Object;", "getValue", "()Ljava/lang/Object;", "equals", "", "other", "equals-impl", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(Ljava/lang/Object;)I", "match", ExifInterface.GPS_DIRECTION_TRUE, "onSuccess", "Lkotlin/Function1;", "onFailure", "Lkotlinx/datetime/internal/format/parser/ParseError;", "match-impl", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "toString", "", "toString-impl", "(Ljava/lang/Object;)Ljava/lang/String;", "Companion", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
@JvmInline
/* loaded from: classes5.dex */
public final class ParseResult {
    public static final Companion Companion = new Companion(null);
    private final Object value;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ ParseResult m10064boximpl(Object obj) {
        return new ParseResult(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: constructor-impl  reason: not valid java name */
    public static Object m10065constructorimpl(Object obj) {
        return obj;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m10066equalsimpl(Object obj, Object obj2) {
        return (obj2 instanceof ParseResult) && Intrinsics.areEqual(obj, ((ParseResult) obj2).m10071unboximpl());
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m10067equalsimpl0(Object obj, Object obj2) {
        return Intrinsics.areEqual(obj, obj2);
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m10068hashCodeimpl(Object obj) {
        return obj.hashCode();
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m10070toStringimpl(Object obj) {
        return "ParseResult(value=" + obj + ')';
    }

    public boolean equals(Object obj) {
        return m10066equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m10068hashCodeimpl(this.value);
    }

    public String toString() {
        return m10070toStringimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ Object m10071unboximpl() {
        return this.value;
    }

    /* compiled from: ParseResult.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J)\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000e\u0010\u000f\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u0010"}, d2 = {"Lkotlinx/datetime/internal/format/parser/ParseResult$Companion;", "", "()V", "Error", "Lkotlinx/datetime/internal/format/parser/ParseResult;", "position", "", "message", "Lkotlin/Function0;", "", "Error-Rg3Co2E", "(ILkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "Ok", "indexOfNextUnparsed", "Ok-Qi1bsqg", "(I)Ljava/lang/Object;", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: Ok-Qi1bsqg  reason: not valid java name */
        public final Object m10073OkQi1bsqg(int i) {
            return ParseResult.m10065constructorimpl(Integer.valueOf(i));
        }

        /* renamed from: Error-Rg3Co2E  reason: not valid java name */
        public final Object m10072ErrorRg3Co2E(int i, Function0<String> message) {
            Intrinsics.checkNotNullParameter(message, "message");
            return ParseResult.m10065constructorimpl(new ParseError(i, message));
        }
    }

    private /* synthetic */ ParseResult(Object obj) {
        this.value = obj;
    }

    public final Object getValue() {
        return this.value;
    }

    /* renamed from: match-impl  reason: not valid java name */
    public static final <T> T m10069matchimpl(Object obj, Function1<? super Integer, ? extends T> onSuccess, Function1<? super ParseError, ? extends T> onFailure) {
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onFailure, "onFailure");
        if (obj instanceof Integer) {
            return onSuccess.invoke(obj);
        }
        if (obj instanceof ParseError) {
            return onFailure.invoke(obj);
        }
        throw new IllegalStateException(("Unexpected parse result: " + obj).toString());
    }
}
