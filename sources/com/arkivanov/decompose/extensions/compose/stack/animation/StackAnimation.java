package com.arkivanov.decompose.extensions.compose.stack.animation;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.exifinterface.media.ExifInterface;
import com.arkivanov.decompose.Child;
import com.arkivanov.decompose.router.stack.ChildStack;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
/* compiled from: StackAnimation.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bæ\u0080\u0001\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00022\u00020\u0002J^\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00072\u0006\u0010\b\u001a\u00020\t22\u0010\n\u001a.\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00050\u000b¢\u0006\u0002\b\u0010H§\u0002¢\u0006\u0002\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/arkivanov/decompose/extensions/compose/stack/animation/StackAnimation;", "C", "", ExifInterface.GPS_DIRECTION_TRUE, "invoke", "", "stack", "Lcom/arkivanov/decompose/router/stack/ChildStack;", "modifier", "Landroidx/compose/ui/Modifier;", FirebaseAnalytics.Param.CONTENT, "Lkotlin/Function1;", "Lcom/arkivanov/decompose/Child$Created;", "Lkotlin/ParameterName;", "name", "child", "Landroidx/compose/runtime/Composable;", "(Lcom/arkivanov/decompose/router/stack/ChildStack;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "extensions-compose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface StackAnimation<C, T> {
    void invoke(ChildStack<? extends C, ? extends T> childStack, Modifier modifier, Function3<? super Child.Created<? extends C, ? extends T>, ? super Composer, ? super Integer, Unit> function3, Composer composer, int i);
}
