package kotlinx.datetime.internal.format.parser;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ParseResult.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0081@\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004JA\u0010\u0007\u001a\u0002H\b\"\u0004\b\u0000\u0010\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u0002H\b0\n2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u0002H\b0\nH\u0086\bø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u000bHÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0088\u0001\u0002\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0017"}, d2 = {"Lkotlinx/datetime/internal/format/parser/ParseResult;", "", "value", "constructor-impl", "(Ljava/lang/Object;)Ljava/lang/Object;", "getValue", "()Ljava/lang/Object;", "match", ExifInterface.GPS_DIRECTION_TRUE, "onSuccess", "Lkotlin/Function1;", "", "onFailure", "Lkotlinx/datetime/internal/format/parser/ParseError;", "match-impl", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "equals", "", "other", "hashCode", "toString", "", "Companion", "kotlinx-datetime"}, k = 1, mv = {2, 1, 0}, xi = 48)
@JvmInline
/* loaded from: classes5.dex */
public final class ParseResult {
    public static final Companion Companion = new Companion(null);
    private final Object value;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ ParseResult m10122boximpl(Object obj) {
        return new ParseResult(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: constructor-impl  reason: not valid java name */
    public static Object m10123constructorimpl(Object obj) {
        return obj;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m10124equalsimpl(Object obj, Object obj2) {
        return (obj2 instanceof ParseResult) && Intrinsics.areEqual(obj, ((ParseResult) obj2).m10129unboximpl());
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m10125equalsimpl0(Object obj, Object obj2) {
        return Intrinsics.areEqual(obj, obj2);
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m10126hashCodeimpl(Object obj) {
        return obj.hashCode();
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m10128toStringimpl(Object obj) {
        return "ParseResult(value=" + obj + ')';
    }

    public boolean equals(Object obj) {
        return m10124equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m10126hashCodeimpl(this.value);
    }

    public String toString() {
        return m10128toStringimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ Object m10129unboximpl() {
        return this.value;
    }

    /* compiled from: ParseResult.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ#\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00072\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lkotlinx/datetime/internal/format/parser/ParseResult$Companion;", "", "<init>", "()V", "Ok", "Lkotlinx/datetime/internal/format/parser/ParseResult;", "indexOfNextUnparsed", "", "Ok-Qi1bsqg", "(I)Ljava/lang/Object;", "Error", "position", "message", "Lkotlin/Function0;", "", "Error-Rg3Co2E", "(ILkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "kotlinx-datetime"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: Ok-Qi1bsqg  reason: not valid java name */
        public final Object m10131OkQi1bsqg(int i) {
            return ParseResult.m10123constructorimpl(Integer.valueOf(i));
        }

        /* renamed from: Error-Rg3Co2E  reason: not valid java name */
        public final Object m10130ErrorRg3Co2E(int i, Function0<String> message) {
            Intrinsics.checkNotNullParameter(message, "message");
            return ParseResult.m10123constructorimpl(new ParseError(i, message));
        }
    }

    private /* synthetic */ ParseResult(Object obj) {
        this.value = obj;
    }

    public final Object getValue() {
        return this.value;
    }

    /* renamed from: match-impl  reason: not valid java name */
    public static final <T> T m10127matchimpl(Object obj, Function1<? super Integer, ? extends T> onSuccess, Function1<? super ParseError, ? extends T> onFailure) {
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
