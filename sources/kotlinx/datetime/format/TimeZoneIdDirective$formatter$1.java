package kotlinx.datetime.format;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.internal.format.Accessor;
/* compiled from: DateTimeComponents.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
/* synthetic */ class TimeZoneIdDirective$formatter$1 extends FunctionReferenceImpl implements Function1<DateTimeComponentsContents, String> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public TimeZoneIdDirective$formatter$1(Object obj) {
        super(1, obj, Accessor.class, "getterNotNull", "getterNotNull(Ljava/lang/Object;)Ljava/lang/Object;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final String invoke(DateTimeComponentsContents p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return (String) ((Accessor) this.receiver).getterNotNull(p0);
    }
}
