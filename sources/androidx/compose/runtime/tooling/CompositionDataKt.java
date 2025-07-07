package androidx.compose.runtime.tooling;

import kotlin.Metadata;
/* compiled from: CompositionData.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"findCompositionInstance", "Landroidx/compose/runtime/tooling/CompositionInstance;", "Landroidx/compose/runtime/tooling/CompositionData;", "runtime_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CompositionDataKt {
    public static final CompositionInstance findCompositionInstance(CompositionData compositionData) {
        if (compositionData instanceof CompositionInstance) {
            return (CompositionInstance) compositionData;
        }
        return null;
    }
}
