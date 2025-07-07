package androidx.compose.runtime;

import androidx.compose.runtime.internal.PlatformOptimizedCancellationException;
import kotlin.Metadata;
/* compiled from: Effects.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Landroidx/compose/runtime/ForgottenCoroutineScopeException;", "Landroidx/compose/runtime/internal/PlatformOptimizedCancellationException;", "()V", "runtime_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
final class ForgottenCoroutineScopeException extends PlatformOptimizedCancellationException {
    public ForgottenCoroutineScopeException() {
        super("rememberCoroutineScope left the composition");
    }
}
