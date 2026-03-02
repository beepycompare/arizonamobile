package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TimePicker.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.material3.TimePickerKt", f = "TimePicker.kt", i = {0, 0, 1, 1}, l = {920, 923}, m = "onTap-uYHVD98", n = {"$this$onTap_u2duYHVD98", "autoSwitchToMinute", "$this$onTap_u2duYHVD98", "autoSwitchToMinute"}, s = {"L$0", "Z$0", "L$0", "Z$0"})
/* loaded from: classes.dex */
public final class TimePickerKt$onTap$1 extends ContinuationImpl {
    Object L$0;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TimePickerKt$onTap$1(Continuation<? super TimePickerKt$onTap$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object m2762onTapuYHVD98;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        m2762onTapuYHVD98 = TimePickerKt.m2762onTapuYHVD98(null, 0.0f, 0.0f, 0.0f, false, 0L, null, this);
        return m2762onTapuYHVD98;
    }
}
