package com.arizonagames.feature.arizona.bank.ui;

import android.view.View;
import com.arizona.common.utils.EasyAnimation;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: BankClickAnimation.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0004H\u0000¨\u0006\u0005"}, d2 = {"setAnimatedClickListener", "", "Landroid/view/View;", "onClick", "Lkotlin/Function0;", "bank"}, k = 2, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BankClickAnimationKt {
    public static final void setAnimatedClickListener(View view, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        if (function0 == null) {
            view.setOnClickListener(null);
        } else {
            EasyAnimation.animateClick$default(EasyAnimation.INSTANCE, view, 0L, null, function0, 3, null);
        }
    }
}
