package kotlinx.datetime.format;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.internal.ToKotlinCodeKt;
/* compiled from: LocalDateFormat.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
/* synthetic */ class LocalDateFormatKt$toKotlinCode$2 extends FunctionReferenceImpl implements Function1<String, String> {
    public static final LocalDateFormatKt$toKotlinCode$2 INSTANCE = new LocalDateFormatKt$toKotlinCode$2();

    LocalDateFormatKt$toKotlinCode$2() {
        super(1, ToKotlinCodeKt.class, "toKotlinCode", "toKotlinCode(Ljava/lang/String;)Ljava/lang/String;", 1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final String invoke(String p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return ToKotlinCodeKt.toKotlinCode(p0);
    }
}
