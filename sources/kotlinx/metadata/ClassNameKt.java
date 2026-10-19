package kotlinx.metadata;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
/* compiled from: ClassName.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u000e\u0010\u0007\u001a\u00020\u0001*\u00060\u0002j\u0002`\u0003\"\"\u0010\u0000\u001a\u00020\u0001*\u00060\u0002j\u0002`\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0000\u0010\u0006*\n\u0010\b\"\u00020\u00022\u00020\u0002¨\u0006\t"}, d2 = {"isLocal", "", "", "Lkotlinx/metadata/ClassName;", "isLocal$annotations", "(Ljava/lang/String;)V", "(Ljava/lang/String;)Z", "isLocalClassName", "ClassName", "kotlinx-metadata"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ClassNameKt {
    @Deprecated(level = DeprecationLevel.ERROR, message = "Renamed to isLocalClassName() to avoid confusion with String properties", replaceWith = @ReplaceWith(expression = "isLocalClassName()", imports = {}))
    public static /* synthetic */ void isLocal$annotations(String str) {
    }

    public static final boolean isLocalClassName(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return StringsKt.startsWith$default(str, ".", false, 2, (Object) null);
    }

    public static final boolean isLocal(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return isLocalClassName(str);
    }
}
