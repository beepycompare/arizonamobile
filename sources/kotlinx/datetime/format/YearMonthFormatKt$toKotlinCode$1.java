package kotlinx.datetime.format;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.internal.ToKotlinCodeKt;
/* compiled from: YearMonthFormat.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
/* synthetic */ class YearMonthFormatKt$toKotlinCode$1 extends FunctionReferenceImpl implements Function1<String, String> {
    public static final YearMonthFormatKt$toKotlinCode$1 INSTANCE = new YearMonthFormatKt$toKotlinCode$1();

    YearMonthFormatKt$toKotlinCode$1() {
        super(1, ToKotlinCodeKt.class, "toKotlinCode", "toKotlinCode(Ljava/lang/String;)Ljava/lang/String;", 1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final String invoke(String p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return ToKotlinCodeKt.toKotlinCode(p0);
    }
}
