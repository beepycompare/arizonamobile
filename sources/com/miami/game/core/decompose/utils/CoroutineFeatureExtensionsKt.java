package com.miami.game.core.decompose.utils;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
/* compiled from: CoroutineFeatureExtensions.kt */
@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0083\u0001\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u000427\b\u0004\u0010\u0005\u001a1\b\u0001\u0012\u0017\u0012\u00150\u0007j\u0002`\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u00062)\b\u0004\u0010\u000f\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u0006¢\u0006\u0002\b\u0010H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u0011\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0012"}, d2 = {"launchSafe", "Lkotlinx/coroutines/Job;", "Lcom/miami/game/core/decompose/utils/CoroutineFeature;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "errorHandler", "Lkotlin/Function2;", "Ljava/lang/Exception;", "Lkotlin/ParameterName;", "name", "exception", "Lkotlin/Exception;", "Lkotlin/coroutines/Continuation;", "", "", "block", "Lkotlin/ExtensionFunctionType;", "(Lcom/miami/game/core/decompose/utils/CoroutineFeature;Lkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/Job;", "decompose-utils_release_web"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CoroutineFeatureExtensionsKt {
    public static /* synthetic */ Job launchSafe$default(CoroutineFeature coroutineFeature, CoroutineScope coroutineScope, Function2 errorHandler, Function2 block, int i, Object obj) {
        Job launch$default;
        if ((i & 1) != 0) {
            coroutineScope = coroutineFeature.getScope();
        }
        CoroutineScope coroutineScope2 = coroutineScope;
        Intrinsics.checkNotNullParameter(coroutineFeature, "<this>");
        Intrinsics.checkNotNullParameter(coroutineScope2, "coroutineScope");
        Intrinsics.checkNotNullParameter(errorHandler, "errorHandler");
        Intrinsics.checkNotNullParameter(block, "block");
        launch$default = BuildersKt__Builders_commonKt.launch$default(coroutineScope2, null, null, new CoroutineFeatureExtensionsKt$launchSafe$1(block, errorHandler, null), 3, null);
        return launch$default;
    }

    public static final Job launchSafe(CoroutineFeature coroutineFeature, CoroutineScope coroutineScope, Function2<? super Exception, ? super Continuation<? super Unit>, ? extends Object> errorHandler, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> block) {
        Job launch$default;
        Intrinsics.checkNotNullParameter(coroutineFeature, "<this>");
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        Intrinsics.checkNotNullParameter(errorHandler, "errorHandler");
        Intrinsics.checkNotNullParameter(block, "block");
        launch$default = BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new CoroutineFeatureExtensionsKt$launchSafe$1(block, errorHandler, null), 3, null);
        return launch$default;
    }
}
