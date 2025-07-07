package com.arkivanov.decompose.router.panels;

import com.arkivanov.decompose.router.webhistory.WebNavigation;
import com.arkivanov.decompose.router.webhistory.WebNavigationOwner;
import com.arkivanov.decompose.value.Value;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
/* compiled from: PanelsWebNavigation.kt */
@Metadata(d1 = {"\u0000V\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001að\u0002\u0010\u0000\u001a\u0006\u0012\u0002\b\u00030\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0003\"\b\b\u0002\u0010\u0005*\u00020\u0003\"\b\b\u0003\u0010\u0006*\u00020\u00032\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u00020\t0\b20\u0010\n\u001a,\u0012(\u0012&\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\f0\u000b2\u001e\u0010\r\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\u000f0\u000e2:\b\u0002\u0010\u0010\u001a4\u0012(\u0012&\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\f\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u00112F\b\u0002\u0010\u0013\u001a@\u0012(\u0012&\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\f\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00140\u00112\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162:\b\u0002\u0010\u0018\u001a4\u0012(\u0012&\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\f\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0011H\u0007\u001a\u0090\u0003\u0010\u0000\u001a\u0006\u0012\u0002\b\u00030\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0003\"\b\b\u0002\u0010\u0005*\u00020\u0003\"\b\b\u0003\u0010\u0006*\u00020\u0003\"\b\b\u0004\u0010\u001a*\u00020\u0003\"\b\b\u0005\u0010\u001b*\u00020\u00032\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u001a0\b20\u0010\n\u001a,\u0012(\u0012&\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u001a\u0012\u0004\u0012\u0002H\u001b0\f0\u000b2*\u0010\r\u001a&\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001a0\u000f0\u001c2:\b\u0002\u0010\u0010\u001a4\u0012(\u0012&\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u001a\u0012\u0004\u0012\u0002H\u001b0\f\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u00112F\b\u0002\u0010\u0013\u001a@\u0012(\u0012&\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u001a\u0012\u0004\u0012\u0002H\u001b0\f\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00140\u00112\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162:\b\u0002\u0010\u0018\u001a4\u0012(\u0012&\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u001a\u0012\u0004\u0012\u0002H\u001b0\f\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0011H\u0007¨\u0006\u001d"}, d2 = {"childPanelsWebNavigation", "Lcom/arkivanov/decompose/router/webhistory/WebNavigation;", "MC", "", "MT", "DC", "DT", "navigator", "Lcom/arkivanov/decompose/router/panels/PanelsNavigator;", "", "panels", "Lcom/arkivanov/decompose/value/Value;", "Lcom/arkivanov/decompose/router/panels/ChildPanels;", "serializers", "Lkotlin/Pair;", "Lkotlinx/serialization/KSerializer;", "pathMapper", "Lkotlin/Function1;", "", "parametersMapper", "", "onBeforeNavigate", "Lkotlin/Function0;", "", "childSelector", "Lcom/arkivanov/decompose/router/webhistory/WebNavigationOwner;", "EC", "ET", "Lkotlin/Triple;", "decompose_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class PanelsWebNavigationKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean childPanelsWebNavigation$lambda$0() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean childPanelsWebNavigation$lambda$1() {
        return true;
    }

    public static /* synthetic */ WebNavigation childPanelsWebNavigation$default(PanelsNavigator panelsNavigator, Value value, Pair pair, Function1 function1, Function1 function12, Function0 function0, Function1 function13, int i, Object obj) {
        if ((i & 8) != 0) {
            function1 = new Function1() { // from class: com.arkivanov.decompose.router.panels.PanelsWebNavigationKt$childPanelsWebNavigation$1
                @Override // kotlin.jvm.functions.Function1
                public final Void invoke(ChildPanels it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return null;
                }
            };
        }
        Function1 function14 = function1;
        if ((i & 16) != 0) {
            function12 = new Function1() { // from class: com.arkivanov.decompose.router.panels.PanelsWebNavigationKt$childPanelsWebNavigation$2
                @Override // kotlin.jvm.functions.Function1
                public final Void invoke(ChildPanels it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return null;
                }
            };
        }
        Function1 function15 = function12;
        if ((i & 32) != 0) {
            function0 = new Function0() { // from class: com.arkivanov.decompose.router.panels.PanelsWebNavigationKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    boolean childPanelsWebNavigation$lambda$0;
                    childPanelsWebNavigation$lambda$0 = PanelsWebNavigationKt.childPanelsWebNavigation$lambda$0();
                    return Boolean.valueOf(childPanelsWebNavigation$lambda$0);
                }
            };
        }
        Function0 function02 = function0;
        if ((i & 64) != 0) {
            function13 = new Function1() { // from class: com.arkivanov.decompose.router.panels.PanelsWebNavigationKt$childPanelsWebNavigation$4
                @Override // kotlin.jvm.functions.Function1
                public final Void invoke(ChildPanels it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return null;
                }
            };
        }
        return childPanelsWebNavigation(panelsNavigator, value, pair, function14, function15, function02, function13);
    }

    @ExperimentalSerializationApi
    public static final <MC, MT, DC, DT> WebNavigation<?> childPanelsWebNavigation(PanelsNavigator navigator, Value<? extends ChildPanels> panels, Pair<? extends KSerializer<MC>, ? extends KSerializer<DC>> serializers, Function1<? super ChildPanels, String> pathMapper, Function1<? super ChildPanels, ? extends Map<String, String>> parametersMapper, Function0<Boolean> onBeforeNavigate, Function1<? super ChildPanels, ? extends WebNavigationOwner> childSelector) {
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        Intrinsics.checkNotNullParameter(panels, "panels");
        Intrinsics.checkNotNullParameter(serializers, "serializers");
        Intrinsics.checkNotNullParameter(pathMapper, "pathMapper");
        Intrinsics.checkNotNullParameter(parametersMapper, "parametersMapper");
        Intrinsics.checkNotNullParameter(onBeforeNavigate, "onBeforeNavigate");
        Intrinsics.checkNotNullParameter(childSelector, "childSelector");
        return childPanelsWebNavigation(navigator, panels, new Triple(serializers.getFirst(), serializers.getSecond(), BuiltinSerializersKt.NothingSerializer()), pathMapper, parametersMapper, onBeforeNavigate, childSelector);
    }

    public static /* synthetic */ WebNavigation childPanelsWebNavigation$default(PanelsNavigator panelsNavigator, Value value, Triple triple, Function1 function1, Function1 function12, Function0 function0, Function1 function13, int i, Object obj) {
        if ((i & 8) != 0) {
            function1 = new Function1() { // from class: com.arkivanov.decompose.router.panels.PanelsWebNavigationKt$childPanelsWebNavigation$5
                @Override // kotlin.jvm.functions.Function1
                public final Void invoke(ChildPanels<? extends MC, ? extends MT, ? extends DC, ? extends DT, ? extends EC, ? extends ET> it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return null;
                }
            };
        }
        Function1 function14 = function1;
        if ((i & 16) != 0) {
            function12 = new Function1() { // from class: com.arkivanov.decompose.router.panels.PanelsWebNavigationKt$childPanelsWebNavigation$6
                @Override // kotlin.jvm.functions.Function1
                public final Void invoke(ChildPanels<? extends MC, ? extends MT, ? extends DC, ? extends DT, ? extends EC, ? extends ET> it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return null;
                }
            };
        }
        Function1 function15 = function12;
        if ((i & 32) != 0) {
            function0 = new Function0() { // from class: com.arkivanov.decompose.router.panels.PanelsWebNavigationKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    boolean childPanelsWebNavigation$lambda$1;
                    childPanelsWebNavigation$lambda$1 = PanelsWebNavigationKt.childPanelsWebNavigation$lambda$1();
                    return Boolean.valueOf(childPanelsWebNavigation$lambda$1);
                }
            };
        }
        Function0 function02 = function0;
        if ((i & 64) != 0) {
            function13 = new Function1() { // from class: com.arkivanov.decompose.router.panels.PanelsWebNavigationKt$childPanelsWebNavigation$8
                @Override // kotlin.jvm.functions.Function1
                public final Void invoke(ChildPanels<? extends MC, ? extends MT, ? extends DC, ? extends DT, ? extends EC, ? extends ET> it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return null;
                }
            };
        }
        return childPanelsWebNavigation(panelsNavigator, value, triple, function14, function15, function02, function13);
    }

    public static final <MC, MT, DC, DT, EC, ET> WebNavigation<?> childPanelsWebNavigation(PanelsNavigator<MC, DC, EC> navigator, Value<? extends ChildPanels<? extends MC, ? extends MT, ? extends DC, ? extends DT, ? extends EC, ? extends ET>> panels, Triple<? extends KSerializer<MC>, ? extends KSerializer<DC>, ? extends KSerializer<EC>> serializers, Function1<? super ChildPanels<? extends MC, ? extends MT, ? extends DC, ? extends DT, ? extends EC, ? extends ET>, String> pathMapper, Function1<? super ChildPanels<? extends MC, ? extends MT, ? extends DC, ? extends DT, ? extends EC, ? extends ET>, ? extends Map<String, String>> parametersMapper, Function0<Boolean> onBeforeNavigate, Function1<? super ChildPanels<? extends MC, ? extends MT, ? extends DC, ? extends DT, ? extends EC, ? extends ET>, ? extends WebNavigationOwner> childSelector) {
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        Intrinsics.checkNotNullParameter(panels, "panels");
        Intrinsics.checkNotNullParameter(serializers, "serializers");
        Intrinsics.checkNotNullParameter(pathMapper, "pathMapper");
        Intrinsics.checkNotNullParameter(parametersMapper, "parametersMapper");
        Intrinsics.checkNotNullParameter(onBeforeNavigate, "onBeforeNavigate");
        Intrinsics.checkNotNullParameter(childSelector, "childSelector");
        return new PanelsWebNavigation(navigator, panels, serializers.getFirst(), serializers.getSecond(), serializers.getThird(), pathMapper, parametersMapper, onBeforeNavigate, childSelector);
    }
}
