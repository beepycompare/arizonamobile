package com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback;

import androidx.exifinterface.media.ExifInterface;
import com.arkivanov.decompose.Child;
import com.arkivanov.decompose.extensions.compose.stack.animation.StackAnimation;
import com.arkivanov.essenty.backhandler.BackEvent;
import com.arkivanov.essenty.backhandler.BackHandler;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: PredictiveBackAnimation.kt */
@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u001a½\u0001\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0004\"\b\b\u0001\u0010\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003\u0018\u00010\u00012e\b\u0002\u0010\b\u001a_\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u000e¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000f\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u000e¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00110\t2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0007¨\u0006\u0015"}, d2 = {"predictiveBackAnimation", "Lcom/arkivanov/decompose/extensions/compose/stack/animation/StackAnimation;", "C", ExifInterface.GPS_DIRECTION_TRUE, "", "backHandler", "Lcom/arkivanov/essenty/backhandler/BackHandler;", "fallbackAnimation", "selector", "Lkotlin/Function3;", "Lcom/arkivanov/essenty/backhandler/BackEvent;", "Lkotlin/ParameterName;", "name", "initialBackEvent", "Lcom/arkivanov/decompose/Child$Created;", "exitChild", "enterChild", "Lcom/arkivanov/decompose/extensions/compose/stack/animation/predictiveback/PredictiveBackAnimatable;", "onBack", "Lkotlin/Function0;", "", "extensions-compose_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class PredictiveBackAnimationKt {
    public static /* synthetic */ StackAnimation predictiveBackAnimation$default(BackHandler backHandler, StackAnimation stackAnimation, Function3 function3, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            stackAnimation = null;
        }
        if ((i & 4) != 0) {
            function3 = new Function3() { // from class: com.arkivanov.decompose.extensions.compose.stack.animation.predictiveback.PredictiveBackAnimationKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj2, Object obj3, Object obj4) {
                    PredictiveBackAnimatable predictiveBackAnimation$lambda$0;
                    predictiveBackAnimation$lambda$0 = PredictiveBackAnimationKt.predictiveBackAnimation$lambda$0((BackEvent) obj2, (Child.Created) obj3, (Child.Created) obj4);
                    return predictiveBackAnimation$lambda$0;
                }
            };
        }
        return predictiveBackAnimation(backHandler, stackAnimation, function3, function0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PredictiveBackAnimatable predictiveBackAnimation$lambda$0(BackEvent initialBackEvent, Child.Created created, Child.Created created2) {
        Intrinsics.checkNotNullParameter(initialBackEvent, "initialBackEvent");
        Intrinsics.checkNotNullParameter(created, "<unused var>");
        Intrinsics.checkNotNullParameter(created2, "<unused var>");
        return MaterialPredictiveBackAnimatableKt.materialPredictiveBackAnimatable$default(initialBackEvent, null, 2, null);
    }

    public static final <C, T> StackAnimation<C, T> predictiveBackAnimation(BackHandler backHandler, StackAnimation<C, T> stackAnimation, Function3<? super BackEvent, ? super Child.Created<? extends C, ? extends T>, ? super Child.Created<? extends C, ? extends T>, ? extends PredictiveBackAnimatable> selector, Function0<Unit> onBack) {
        Intrinsics.checkNotNullParameter(backHandler, "backHandler");
        Intrinsics.checkNotNullParameter(selector, "selector");
        Intrinsics.checkNotNullParameter(onBack, "onBack");
        return new PredictiveBackAnimation(backHandler, stackAnimation, selector, onBack);
    }
}
