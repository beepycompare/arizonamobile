package androidx.compose.foundation.gestures;

import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
/* compiled from: ContentInViewNode.kt */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\"\u0010\t\u001a\u00020\u0007*\u00020\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u000bH\u0082\b¢\u0006\u0004\b\f\u0010\r\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\b¨\u0006\u000e"}, d2 = {"DEBUG", "", "TAG", "", "MinScrollThreshold", "", "UnspecifiedIntSize", "Landroidx/compose/ui/unit/IntSize;", "J", "takeOrElse", "other", "Lkotlin/Function0;", "takeOrElse-viCIZxY", "(JLkotlin/jvm/functions/Function0;)J", "foundation"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ContentInViewNodeKt {
    private static final boolean DEBUG = false;
    private static final float MinScrollThreshold = 0.5f;
    private static final String TAG = "ContentInViewModifier";
    private static final long UnspecifiedIntSize = IntSize.m8326constructorimpl(-1);

    /* renamed from: takeOrElse-viCIZxY  reason: not valid java name */
    private static final long m471takeOrElseviCIZxY(long j, Function0<IntSize> function0) {
        return IntSize.m8329equalsimpl0(j, UnspecifiedIntSize) ? function0.invoke().m8335unboximpl() : j;
    }
}
