package androidx.lifecycle;

import kotlin.Function;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Transformations.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class Transformations$sam$androidx_lifecycle_Observer$0 implements Observer, FunctionAdapter {
    private final /* synthetic */ Function1 function;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Transformations$sam$androidx_lifecycle_Observer$0(Function1 function) {
        Intrinsics.checkNotNullParameter(function, "function");
        this.function = function;
    }

    public final boolean equals(Object obj) {
        if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
        }
        return false;
    }

    @Override // kotlin.jvm.internal.FunctionAdapter
    public final Function<?> getFunctionDelegate() {
        return this.function;
    }

    public final int hashCode() {
        return getFunctionDelegate().hashCode();
    }

    @Override // androidx.lifecycle.Observer
    public final /* synthetic */ void onChanged(Object obj) {
        this.function.invoke(obj);
    }
}
