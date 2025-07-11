package kotlinx.datetime.format;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.format.DateTimeFormatBuilder;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* compiled from: LocalTimeFormat.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\"\u001b\u0010\u0000\u001a\u00020\u00018@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0002\u0010\u0003\"\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"ISO_TIME", "Lkotlinx/datetime/format/LocalTimeFormat;", "getISO_TIME", "()Lkotlinx/datetime/format/LocalTimeFormat;", "ISO_TIME$delegate", "Lkotlin/Lazy;", "emptyIncompleteLocalTime", "Lkotlinx/datetime/format/IncompleteLocalTime;", "kotlinx-datetime"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class LocalTimeFormatKt {
    private static final Lazy ISO_TIME$delegate = LazyKt.lazy(new Function0() { // from class: kotlinx.datetime.format.LocalTimeFormatKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            LocalTimeFormat ISO_TIME_delegate$lambda$4;
            ISO_TIME_delegate$lambda$4 = LocalTimeFormatKt.ISO_TIME_delegate$lambda$4();
            return ISO_TIME_delegate$lambda$4;
        }
    });
    private static final IncompleteLocalTime emptyIncompleteLocalTime = new IncompleteLocalTime(null, null, null, null, null, null, 63, null);

    public static final /* synthetic */ IncompleteLocalTime access$getEmptyIncompleteLocalTime$p() {
        return emptyIncompleteLocalTime;
    }

    public static final LocalTimeFormat getISO_TIME() {
        return (LocalTimeFormat) ISO_TIME$delegate.getValue();
    }

    public static final LocalTimeFormat ISO_TIME_delegate$lambda$4() {
        return LocalTimeFormat.Companion.build(new Function1() { // from class: kotlinx.datetime.format.LocalTimeFormatKt$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit ISO_TIME_delegate$lambda$4$lambda$3;
                ISO_TIME_delegate$lambda$4$lambda$3 = LocalTimeFormatKt.ISO_TIME_delegate$lambda$4$lambda$3((DateTimeFormatBuilder.WithTime) obj);
                return ISO_TIME_delegate$lambda$4$lambda$3;
            }
        });
    }

    public static final Unit ISO_TIME_delegate$lambda$4$lambda$3(DateTimeFormatBuilder.WithTime build) {
        Intrinsics.checkNotNullParameter(build, "$this$build");
        DateTimeFormatBuilder.WithTime.hour$default(build, null, 1, null);
        DateTimeFormatBuilder.WithTime withTime = build;
        DateTimeFormatBuilderKt.m10098char(withTime, AbstractJsonLexerKt.COLON);
        DateTimeFormatBuilder.WithTime.minute$default(build, null, 1, null);
        DateTimeFormatBuilderKt.alternativeParsing(withTime, new Function1[]{new Function1() { // from class: kotlinx.datetime.format.LocalTimeFormatKt$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit ISO_TIME_delegate$lambda$4$lambda$3$lambda$0;
                ISO_TIME_delegate$lambda$4$lambda$3$lambda$0 = LocalTimeFormatKt.ISO_TIME_delegate$lambda$4$lambda$3$lambda$0((DateTimeFormatBuilder.WithTime) obj);
                return ISO_TIME_delegate$lambda$4$lambda$3$lambda$0;
            }
        }}, new Function1() { // from class: kotlinx.datetime.format.LocalTimeFormatKt$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit ISO_TIME_delegate$lambda$4$lambda$3$lambda$2;
                ISO_TIME_delegate$lambda$4$lambda$3$lambda$2 = LocalTimeFormatKt.ISO_TIME_delegate$lambda$4$lambda$3$lambda$2((DateTimeFormatBuilder.WithTime) obj);
                return ISO_TIME_delegate$lambda$4$lambda$3$lambda$2;
            }
        });
        return Unit.INSTANCE;
    }

    public static final Unit ISO_TIME_delegate$lambda$4$lambda$3$lambda$0(DateTimeFormatBuilder.WithTime alternativeParsing) {
        Intrinsics.checkNotNullParameter(alternativeParsing, "$this$alternativeParsing");
        return Unit.INSTANCE;
    }

    public static final Unit ISO_TIME_delegate$lambda$4$lambda$3$lambda$2(DateTimeFormatBuilder.WithTime alternativeParsing) {
        Intrinsics.checkNotNullParameter(alternativeParsing, "$this$alternativeParsing");
        DateTimeFormatBuilder.WithTime withTime = alternativeParsing;
        DateTimeFormatBuilderKt.m10098char(withTime, AbstractJsonLexerKt.COLON);
        DateTimeFormatBuilder.WithTime.second$default(alternativeParsing, null, 1, null);
        DateTimeFormatBuilderKt.optional$default(withTime, null, new Function1() { // from class: kotlinx.datetime.format.LocalTimeFormatKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit ISO_TIME_delegate$lambda$4$lambda$3$lambda$2$lambda$1;
                ISO_TIME_delegate$lambda$4$lambda$3$lambda$2$lambda$1 = LocalTimeFormatKt.ISO_TIME_delegate$lambda$4$lambda$3$lambda$2$lambda$1((DateTimeFormatBuilder.WithTime) obj);
                return ISO_TIME_delegate$lambda$4$lambda$3$lambda$2$lambda$1;
            }
        }, 1, null);
        return Unit.INSTANCE;
    }

    public static final Unit ISO_TIME_delegate$lambda$4$lambda$3$lambda$2$lambda$1(DateTimeFormatBuilder.WithTime optional) {
        Intrinsics.checkNotNullParameter(optional, "$this$optional");
        DateTimeFormatBuilderKt.m10098char(optional, '.');
        optional.secondFraction(1, 9);
        return Unit.INSTANCE;
    }
}
