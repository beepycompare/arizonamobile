package com.arkivanov.decompose.extensions.compose.stack.animation;

import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
/* compiled from: StackAnimationProvider.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0017\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"LocalStackAnimationProvider", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Lcom/arkivanov/decompose/extensions/compose/stack/animation/StackAnimationProvider;", "getLocalStackAnimationProvider", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "extensions-compose_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class StackAnimationProviderKt {
    private static final ProvidableCompositionLocal<StackAnimationProvider> LocalStackAnimationProvider = CompositionLocalKt.compositionLocalOf$default(null, new Function0() { // from class: com.arkivanov.decompose.extensions.compose.stack.animation.StackAnimationProviderKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            StackAnimationProvider LocalStackAnimationProvider$lambda$0;
            LocalStackAnimationProvider$lambda$0 = StackAnimationProviderKt.LocalStackAnimationProvider$lambda$0();
            return LocalStackAnimationProvider$lambda$0;
        }
    }, 1, null);

    public static final ProvidableCompositionLocal<StackAnimationProvider> getLocalStackAnimationProvider() {
        return LocalStackAnimationProvider;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StackAnimationProvider LocalStackAnimationProvider$lambda$0() {
        return new StackAnimationProvider() { // from class: com.arkivanov.decompose.extensions.compose.stack.animation.StackAnimationProviderKt$LocalStackAnimationProvider$1$1
            @Override // com.arkivanov.decompose.extensions.compose.stack.animation.StackAnimationProvider
            public <C, T> StackAnimation<C, T> provide() {
                return null;
            }
        };
    }
}
