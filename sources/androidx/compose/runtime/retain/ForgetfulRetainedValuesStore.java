package androidx.compose.runtime.retain;

import kotlin.Metadata;
/* compiled from: ForgetfulRetainedValuesStore.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u001c\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\bH\u0016J\u001a\u0010\u000b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\r"}, d2 = {"Landroidx/compose/runtime/retain/ForgetfulRetainedValuesStore;", "Landroidx/compose/runtime/retain/RetainedValuesStore;", "<init>", "()V", "onContentEnteredComposition", "", "onContentExitComposition", "consumeExitedValueOrDefault", "", "key", "defaultValue", "saveExitingValue", "value", "runtime-retain"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ForgetfulRetainedValuesStore implements RetainedValuesStore {
    public static final int $stable = 0;
    public static final ForgetfulRetainedValuesStore INSTANCE = new ForgetfulRetainedValuesStore();

    @Override // androidx.compose.runtime.retain.RetainedValuesStore
    public Object consumeExitedValueOrDefault(Object obj, Object obj2) {
        return obj2;
    }

    @Override // androidx.compose.runtime.retain.RetainedValuesStore
    public void onContentEnteredComposition() {
    }

    @Override // androidx.compose.runtime.retain.RetainedValuesStore
    public void onContentExitComposition() {
    }

    private ForgetfulRetainedValuesStore() {
    }

    @Override // androidx.compose.runtime.retain.RetainedValuesStore
    public void saveExitingValue(Object obj, Object obj2) {
        if (obj2 instanceof RetainObserver) {
            ((RetainObserver) obj2).onRetired();
        }
    }
}
