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
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\"\u001b\u0010\u0000\u001a\u00020\u00018@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0002\u0010\u0003\"\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"ISO_TIME", "Lkotlinx/datetime/format/LocalTimeFormat;", "getISO_TIME", "()Lkotlinx/datetime/format/LocalTimeFormat;", "ISO_TIME$delegate", "Lkotlin/Lazy;", "emptyIncompleteLocalTime", "Lkotlinx/datetime/format/IncompleteLocalTime;", "kotlinx-datetime"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class LocalTimeFormatKt {
    private static final Lazy ISO_TIME$delegate = LazyKt.lazy(new Function0<LocalTimeFormat>() { // from class: kotlinx.datetime.format.LocalTimeFormatKt$ISO_TIME$2
        @Override // kotlin.jvm.functions.Function0
        public final LocalTimeFormat invoke() {
            return LocalTimeFormat.Companion.build(new Function1<DateTimeFormatBuilder.WithTime, Unit>() { // from class: kotlinx.datetime.format.LocalTimeFormatKt$ISO_TIME$2.1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(DateTimeFormatBuilder.WithTime withTime) {
                    invoke2(withTime);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(DateTimeFormatBuilder.WithTime build) {
                    Intrinsics.checkNotNullParameter(build, "$this$build");
                    DateTimeFormatBuilder.WithTime.DefaultImpls.hour$default(build, null, 1, null);
                    DateTimeFormatBuilder.WithTime withTime = build;
                    DateTimeFormatBuilderKt.m10056char(withTime, AbstractJsonLexerKt.COLON);
                    DateTimeFormatBuilder.WithTime.DefaultImpls.minute$default(build, null, 1, null);
                    DateTimeFormatBuilderKt.alternativeParsing(withTime, new Function1[]{new Function1<DateTimeFormatBuilder.WithTime, Unit>() { // from class: kotlinx.datetime.format.LocalTimeFormatKt.ISO_TIME.2.1.1
                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                        public final void invoke2(DateTimeFormatBuilder.WithTime alternativeParsing) {
                            Intrinsics.checkNotNullParameter(alternativeParsing, "$this$alternativeParsing");
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(DateTimeFormatBuilder.WithTime withTime2) {
                            invoke2(withTime2);
                            return Unit.INSTANCE;
                        }
                    }}, new Function1<DateTimeFormatBuilder.WithTime, Unit>() { // from class: kotlinx.datetime.format.LocalTimeFormatKt.ISO_TIME.2.1.2
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(DateTimeFormatBuilder.WithTime withTime2) {
                            invoke2(withTime2);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                        public final void invoke2(DateTimeFormatBuilder.WithTime alternativeParsing) {
                            Intrinsics.checkNotNullParameter(alternativeParsing, "$this$alternativeParsing");
                            DateTimeFormatBuilder.WithTime withTime2 = alternativeParsing;
                            DateTimeFormatBuilderKt.m10056char(withTime2, AbstractJsonLexerKt.COLON);
                            DateTimeFormatBuilder.WithTime.DefaultImpls.second$default(alternativeParsing, null, 1, null);
                            DateTimeFormatBuilderKt.optional$default(withTime2, null, new Function1<DateTimeFormatBuilder.WithTime, Unit>() { // from class: kotlinx.datetime.format.LocalTimeFormatKt.ISO_TIME.2.1.2.1
                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(DateTimeFormatBuilder.WithTime withTime3) {
                                    invoke2(withTime3);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                                public final void invoke2(DateTimeFormatBuilder.WithTime optional) {
                                    Intrinsics.checkNotNullParameter(optional, "$this$optional");
                                    DateTimeFormatBuilderKt.m10056char(optional, '.');
                                    optional.secondFraction(1, 9);
                                }
                            }, 1, null);
                        }
                    });
                }
            });
        }
    });
    private static final IncompleteLocalTime emptyIncompleteLocalTime = new IncompleteLocalTime(null, null, null, null, null, null, 63, null);

    public static final LocalTimeFormat getISO_TIME() {
        return (LocalTimeFormat) ISO_TIME$delegate.getValue();
    }
}
