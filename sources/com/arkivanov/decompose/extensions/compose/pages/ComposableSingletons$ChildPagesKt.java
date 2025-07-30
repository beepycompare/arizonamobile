package com.arkivanov.decompose.extensions.compose.pages;

import androidx.compose.foundation.pager.PagerKt;
import androidx.compose.foundation.pager.PagerScope;
import androidx.compose.foundation.pager.PagerState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.media3.exoplayer.RendererCapabilities;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ChildPages.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ComposableSingletons$ChildPagesKt {
    public static final ComposableSingletons$ChildPagesKt INSTANCE = new ComposableSingletons$ChildPagesKt();

    /* renamed from: lambda-1  reason: not valid java name */
    private static Function6<Modifier, PagerState, Function1<? super Integer, ? extends Object>, Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit>, Composer, Integer, Unit> f66lambda1 = ComposableLambdaKt.composableLambdaInstance(1649886492, false, new Function6<Modifier, PagerState, Function1<? super Integer, ? extends Object>, Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: com.arkivanov.decompose.extensions.compose.pages.ComposableSingletons$ChildPagesKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function6
        public /* bridge */ /* synthetic */ Unit invoke(Modifier modifier, PagerState pagerState, Function1<? super Integer, ? extends Object> function1, Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, ? extends Unit> function4, Composer composer, Integer num) {
            invoke(modifier, pagerState, function1, (Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit>) function4, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Modifier modifier, PagerState state, Function1<? super Integer, ? extends Object> key, Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit> pageContent, Composer composer, int i) {
            int i2;
            Intrinsics.checkNotNullParameter(modifier, "modifier");
            Intrinsics.checkNotNullParameter(state, "state");
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(pageContent, "pageContent");
            if ((i & 6) == 0) {
                i2 = (composer.changed(modifier) ? 4 : 2) | i;
            } else {
                i2 = i;
            }
            if ((i & 48) == 0) {
                i2 |= composer.changed(state) ? 32 : 16;
            }
            if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                i2 |= composer.changedInstance(key) ? 256 : 128;
            }
            if ((i & 3072) == 0) {
                i2 |= composer.changedInstance(pageContent) ? 2048 : 1024;
            }
            if ((i2 & 9363) != 9362 || !composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1649886492, i2, -1, "com.arkivanov.decompose.extensions.compose.pages.ComposableSingletons$ChildPagesKt.lambda-1.<anonymous> (ChildPages.kt:104)");
                }
                PagerKt.m984HorizontalPageroI3XNZo(state, modifier, null, null, 0, 0.0f, null, null, false, false, key, null, null, pageContent, composer, ((i2 >> 3) & 14) | ((i2 << 3) & 112), ((i2 >> 6) & 14) | (i2 & 7168), 7164);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    });

    /* renamed from: lambda-2  reason: not valid java name */
    private static Function6<Modifier, PagerState, Function1<? super Integer, ? extends Object>, Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit>, Composer, Integer, Unit> f67lambda2 = ComposableLambdaKt.composableLambdaInstance(-896049490, false, new Function6<Modifier, PagerState, Function1<? super Integer, ? extends Object>, Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: com.arkivanov.decompose.extensions.compose.pages.ComposableSingletons$ChildPagesKt$lambda-2$1
        @Override // kotlin.jvm.functions.Function6
        public /* bridge */ /* synthetic */ Unit invoke(Modifier modifier, PagerState pagerState, Function1<? super Integer, ? extends Object> function1, Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, ? extends Unit> function4, Composer composer, Integer num) {
            invoke(modifier, pagerState, function1, (Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit>) function4, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Modifier modifier, PagerState state, Function1<? super Integer, ? extends Object> key, Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit> pageContent, Composer composer, int i) {
            int i2;
            Intrinsics.checkNotNullParameter(modifier, "modifier");
            Intrinsics.checkNotNullParameter(state, "state");
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(pageContent, "pageContent");
            if ((i & 6) == 0) {
                i2 = (composer.changed(modifier) ? 4 : 2) | i;
            } else {
                i2 = i;
            }
            if ((i & 48) == 0) {
                i2 |= composer.changed(state) ? 32 : 16;
            }
            if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
                i2 |= composer.changedInstance(key) ? 256 : 128;
            }
            if ((i & 3072) == 0) {
                i2 |= composer.changedInstance(pageContent) ? 2048 : 1024;
            }
            if ((i2 & 9363) != 9362 || !composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-896049490, i2, -1, "com.arkivanov.decompose.extensions.compose.pages.ComposableSingletons$ChildPagesKt.lambda-2.<anonymous> (ChildPages.kt:114)");
                }
                PagerKt.m986VerticalPageroI3XNZo(state, modifier, null, null, 0, 0.0f, null, null, false, false, key, null, null, pageContent, composer, ((i2 >> 3) & 14) | ((i2 << 3) & 112), ((i2 >> 6) & 14) | (i2 & 7168), 7164);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    });

    /* renamed from: getLambda-1$extensions_compose_release  reason: not valid java name */
    public final Function6<Modifier, PagerState, Function1<? super Integer, ? extends Object>, Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit>, Composer, Integer, Unit> m7978getLambda1$extensions_compose_release() {
        return f66lambda1;
    }

    /* renamed from: getLambda-2$extensions_compose_release  reason: not valid java name */
    public final Function6<Modifier, PagerState, Function1<? super Integer, ? extends Object>, Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit>, Composer, Integer, Unit> m7979getLambda2$extensions_compose_release() {
        return f67lambda2;
    }
}
