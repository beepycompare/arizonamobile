package androidx.compose.material3;

import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.material3.internal.SystemBarsDefaultInsets_androidKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;
/* compiled from: Scaffold.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/compose/material3/ScaffoldDefaults;", "", "()V", "contentWindowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "getContentWindowInsets", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/layout/WindowInsets;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ScaffoldDefaults {
    public static final int $stable = 0;
    public static final ScaffoldDefaults INSTANCE = new ScaffoldDefaults();

    private ScaffoldDefaults() {
    }

    public final WindowInsets getContentWindowInsets(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 757124140, "C292@13799L29:Scaffold.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(757124140, i, -1, "androidx.compose.material3.ScaffoldDefaults.<get-contentWindowInsets> (Scaffold.kt:292)");
        }
        WindowInsets systemBarsForVisualComponents = SystemBarsDefaultInsets_androidKt.getSystemBarsForVisualComponents(WindowInsets.Companion, composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return systemBarsForVisualComponents;
    }
}
