package ru.mrlargha.commonui.utils.ui;

import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: locker.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a(\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0006¨\u0006\u0007"}, d2 = {"setLockingClickListener", "", "Landroid/view/View;", "lockMs", "", "onClick", "Lkotlin/Function1;", "CommonUI"}, k = 2, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class LockerKt {
    public static /* synthetic */ void setLockingClickListener$default(View view, long j, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 1000;
        }
        setLockingClickListener(view, j, function1);
    }

    public static final void setLockingClickListener(View view, final long j, final Function1<? super View, Unit> onClick) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        view.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.utils.ui.LockerKt$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                LockerKt.setLockingClickListener$lambda$0(Function1.this, j, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void setLockingClickListener$lambda$0(Function1 function1, long j, final View view) {
        if (view.isEnabled()) {
            view.setEnabled(false);
            Intrinsics.checkNotNull(view);
            function1.invoke(view);
            view.postDelayed(new Runnable() { // from class: ru.mrlargha.commonui.utils.ui.LockerKt$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    view.setEnabled(true);
                }
            }, j);
        }
    }
}
