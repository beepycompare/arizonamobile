package com.arkivanov.decompose.router.stack;

import androidx.exifinterface.media.ExifInterface;
import com.arkivanov.decompose.Child;
import com.arkivanov.decompose.router.webhistory.WebNavigation;
import com.arkivanov.decompose.router.webhistory.WebNavigationOwner;
import com.arkivanov.decompose.value.Value;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
/* compiled from: StackWebNavigation.kt */
@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001aè\u0001\u0010\u0000\u001a\u0006\u0012\u0002\b\u00030\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00062\u0018\u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00040\t0\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\"\b\u0002\u0010\u000e\u001a\u001c\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00040\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u000f2.\b\u0002\u0010\u0012\u001a(\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00040\u0010\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00130\u000f2\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\r0\u00152\"\b\u0002\u0010\u0016\u001a\u001c\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00040\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u000fH\u0007¨\u0006\u0018"}, d2 = {"childStackWebNavigation", "Lcom/arkivanov/decompose/router/webhistory/WebNavigation;", "C", "", ExifInterface.GPS_DIRECTION_TRUE, "navigator", "Lcom/arkivanov/decompose/router/stack/StackNavigator;", "stack", "Lcom/arkivanov/decompose/value/Value;", "Lcom/arkivanov/decompose/router/stack/ChildStack;", "serializer", "Lkotlinx/serialization/KSerializer;", "enableHistory", "", "pathMapper", "Lkotlin/Function1;", "Lcom/arkivanov/decompose/Child$Created;", "", "parametersMapper", "", "onBeforeNavigate", "Lkotlin/Function0;", "childSelector", "Lcom/arkivanov/decompose/router/webhistory/WebNavigationOwner;", "decompose_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class StackWebNavigationKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean childStackWebNavigation$lambda$0() {
        return true;
    }

    public static /* synthetic */ WebNavigation childStackWebNavigation$default(StackNavigator stackNavigator, Value value, KSerializer kSerializer, boolean z, Function1 function1, Function1 function12, Function0 function0, Function1 function13, int i, Object obj) {
        if ((i & 8) != 0) {
            z = true;
        }
        boolean z2 = z;
        if ((i & 16) != 0) {
            function1 = new Function1() { // from class: com.arkivanov.decompose.router.stack.StackWebNavigationKt$childStackWebNavigation$1
                @Override // kotlin.jvm.functions.Function1
                public final Void invoke(Child.Created<? extends C, ? extends T> it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return null;
                }
            };
        }
        Function1 function14 = function1;
        if ((i & 32) != 0) {
            function12 = new Function1() { // from class: com.arkivanov.decompose.router.stack.StackWebNavigationKt$childStackWebNavigation$2
                @Override // kotlin.jvm.functions.Function1
                public final Void invoke(Child.Created<? extends C, ? extends T> it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return null;
                }
            };
        }
        return childStackWebNavigation(stackNavigator, value, kSerializer, z2, function14, function12, (i & 64) != 0 ? new Function0() { // from class: com.arkivanov.decompose.router.stack.StackWebNavigationKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                boolean childStackWebNavigation$lambda$0;
                childStackWebNavigation$lambda$0 = StackWebNavigationKt.childStackWebNavigation$lambda$0();
                return Boolean.valueOf(childStackWebNavigation$lambda$0);
            }
        } : function0, (i & 128) != 0 ? new Function1() { // from class: com.arkivanov.decompose.router.stack.StackWebNavigationKt$childStackWebNavigation$4
            @Override // kotlin.jvm.functions.Function1
            public final Void invoke(Child.Created<? extends C, ? extends T> it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return null;
            }
        } : function13);
    }

    public static final <C, T> WebNavigation<?> childStackWebNavigation(StackNavigator<C> navigator, Value<? extends ChildStack<? extends C, ? extends T>> stack, KSerializer<C> serializer, boolean z, Function1<? super Child.Created<? extends C, ? extends T>, String> pathMapper, Function1<? super Child.Created<? extends C, ? extends T>, ? extends Map<String, String>> parametersMapper, Function0<Boolean> onBeforeNavigate, Function1<? super Child.Created<? extends C, ? extends T>, ? extends WebNavigationOwner> childSelector) {
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        Intrinsics.checkNotNullParameter(stack, "stack");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        Intrinsics.checkNotNullParameter(pathMapper, "pathMapper");
        Intrinsics.checkNotNullParameter(parametersMapper, "parametersMapper");
        Intrinsics.checkNotNullParameter(onBeforeNavigate, "onBeforeNavigate");
        Intrinsics.checkNotNullParameter(childSelector, "childSelector");
        return new StackWebNavigation(navigator, stack, serializer, z, pathMapper, parametersMapper, onBeforeNavigate, childSelector);
    }
}
