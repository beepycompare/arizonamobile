package androidx.compose.ui.platform;

import androidx.compose.ui.focus.FocusDirection;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AndroidComposeView.android.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public /* synthetic */ class AndroidComposeView$focusOwner$3 extends FunctionReferenceImpl implements Function1<FocusDirection, Boolean> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public AndroidComposeView$focusOwner$3(Object obj) {
        super(1, obj, AndroidComposeView.class, "onMoveFocusInChildren", "onMoveFocusInChildren-3ESFkO8(I)Z", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(FocusDirection focusDirection) {
        return m5814invoke3ESFkO8(focusDirection.m3724unboximpl());
    }

    /* renamed from: invoke-3ESFkO8  reason: not valid java name */
    public final Boolean m5814invoke3ESFkO8(int i) {
        boolean m5806onMoveFocusInChildren3ESFkO8;
        m5806onMoveFocusInChildren3ESFkO8 = ((AndroidComposeView) this.receiver).m5806onMoveFocusInChildren3ESFkO8(i);
        return Boolean.valueOf(m5806onMoveFocusInChildren3ESFkO8);
    }
}
