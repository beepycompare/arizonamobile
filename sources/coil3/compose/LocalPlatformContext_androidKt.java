package coil3.compose;

import android.content.Context;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import kotlin.Metadata;
/* compiled from: LocalPlatformContext.android.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0018\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00018Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"LocalPlatformContext", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroid/content/Context;", "getLocalPlatformContext", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "coil-compose-core_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class LocalPlatformContext_androidKt {
    public static final ProvidableCompositionLocal<Context> getLocalPlatformContext() {
        return AndroidCompositionLocals_androidKt.getLocalContext();
    }
}
