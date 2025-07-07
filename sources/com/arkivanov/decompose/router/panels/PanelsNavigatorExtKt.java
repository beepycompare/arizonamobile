package com.arkivanov.decompose.router.panels;

import com.arizona.launcher.UpdateActivity;
import com.google.android.vending.expansion.downloader.DownloaderClientMarshaller;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.metadata.internal.metadata.jvm.deserialization.JvmProtoBufUtil;
/* compiled from: PanelsNavigatorExt.kt */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\u001at\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0003\"\b\b\u0002\u0010\u0005*\u00020\u0003*\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u000626\u0010\u0007\u001a2\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\t\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\t0\bH\u0007\u001a»\u0001\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0003\"\b\b\u0002\u0010\u0005*\u00020\u0003*\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u00062\u0006\u0010\n\u001a\u0002H\u00022\b\u0010\u000b\u001a\u0004\u0018\u0001H\u00042\b\u0010\f\u001a\u0004\u0018\u0001H\u00052\\\b\u0002\u0010\r\u001aV\u0012%\u0012#\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\t¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012%\u0012#\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\t¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00010\u000eH\u0007¢\u0006\u0002\u0010\u0013\u001a³\u0001\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0003\"\b\b\u0002\u0010\u0005*\u00020\u0003*\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u00062\b\u0010\u000b\u001a\u0004\u0018\u0001H\u00042\b\u0010\f\u001a\u0004\u0018\u0001H\u00052\\\b\u0002\u0010\r\u001aV\u0012%\u0012#\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\t¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012%\u0012#\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\t¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00010\u000eH\u0007¢\u0006\u0002\u0010\u0014\u001a©\u0001\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0003\"\b\b\u0002\u0010\u0005*\u00020\u0003*\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u00062\b\u0010\f\u001a\u0004\u0018\u0001H\u00052\\\b\u0002\u0010\r\u001aV\u0012%\u0012#\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\t¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012%\u0012#\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\t¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00010\u000eH\u0007¢\u0006\u0002\u0010\u0015\u001a§\u0001\u0010\u0016\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0003\"\b\b\u0002\u0010\u0005*\u00020\u0003*\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u00062\u0006\u0010\n\u001a\u0002H\u00022\\\b\u0002\u0010\r\u001aV\u0012%\u0012#\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\t¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012%\u0012#\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\t¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00010\u000eH\u0007¢\u0006\u0002\u0010\u0015\u001a§\u0001\u0010\u0017\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0003\"\b\b\u0002\u0010\u0005*\u00020\u0003*\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u00062\u0006\u0010\u000b\u001a\u0002H\u00042\\\b\u0002\u0010\r\u001aV\u0012%\u0012#\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\t¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012%\u0012#\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\t¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00010\u000eH\u0007¢\u0006\u0002\u0010\u0015\u001a\u009a\u0001\u0010\u0018\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0003\"\b\b\u0002\u0010\u0005*\u00020\u0003*\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u00062\\\b\u0002\u0010\r\u001aV\u0012%\u0012#\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\t¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012%\u0012#\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\t¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00010\u000eH\u0007\u001a§\u0001\u0010\u0019\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0003\"\b\b\u0002\u0010\u0005*\u00020\u0003*\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u00062\u0006\u0010\f\u001a\u0002H\u00052\\\b\u0002\u0010\r\u001aV\u0012%\u0012#\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\t¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012%\u0012#\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\t¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00010\u000eH\u0007¢\u0006\u0002\u0010\u0015\u001a\u009a\u0001\u0010\u001a\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0003\"\b\b\u0002\u0010\u0005*\u00020\u0003*\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u00062\\\b\u0002\u0010\r\u001aV\u0012%\u0012#\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\t¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012%\u0012#\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\t¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00010\u000eH\u0007\u001a\u009a\u0001\u0010\u001b\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0003\"\b\b\u0002\u0010\u0005*\u00020\u0003*\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u00062\\\b\u0002\u0010\r\u001aV\u0012%\u0012#\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\t¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012%\u0012#\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\t¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00010\u000eH\u0007\u001a¢\u0001\u0010\u001c\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0003\"\b\b\u0002\u0010\u0005*\u00020\u0003*\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u00062\u0006\u0010\u001d\u001a\u00020\u001e2\\\b\u0002\u0010\r\u001aV\u0012%\u0012#\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\t¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012%\u0012#\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\t¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00010\u000eH\u0007¨\u0006\u001f"}, d2 = {"navigate", "", "MC", "", "DC", "EC", "Lcom/arkivanov/decompose/router/panels/PanelsNavigator;", "transformer", "Lkotlin/Function1;", "Lcom/arkivanov/decompose/router/panels/Panels;", JvmProtoBufUtil.DEFAULT_MODULE_NAME, "details", "extra", "onComplete", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", DownloaderClientMarshaller.PARAM_NEW_STATE, "oldState", "(Lcom/arkivanov/decompose/router/panels/PanelsNavigator;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "(Lcom/arkivanov/decompose/router/panels/PanelsNavigator;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "(Lcom/arkivanov/decompose/router/panels/PanelsNavigator;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "activateMain", "activateDetails", "dismissDetails", "activateExtra", "dismissExtra", "pop", "setMode", UpdateActivity.UPDATE_MODE, "Lcom/arkivanov/decompose/router/panels/ChildPanelsMode;", "decompose_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class PanelsNavigatorExtKt {
    public static final <MC, DC, EC> void navigate(PanelsNavigator<MC, DC, EC> panelsNavigator, Function1<? super Panels<? extends MC, ? extends DC, ? extends EC>, ? extends Panels<? extends MC, ? extends DC, ? extends EC>> transformer) {
        Intrinsics.checkNotNullParameter(panelsNavigator, "<this>");
        Intrinsics.checkNotNullParameter(transformer, "transformer");
        panelsNavigator.navigate(transformer, new Function2() { // from class: com.arkivanov.decompose.router.panels.PanelsNavigatorExtKt$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Unit navigate$lambda$0;
                navigate$lambda$0 = PanelsNavigatorExtKt.navigate$lambda$0((Panels) obj, (Panels) obj2);
                return navigate$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit navigate$lambda$0(Panels panels, Panels panels2) {
        Intrinsics.checkNotNullParameter(panels, "<unused var>");
        Intrinsics.checkNotNullParameter(panels2, "<unused var>");
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void navigate$default(PanelsNavigator panelsNavigator, Object obj, Object obj2, Object obj3, Function2 function2, int i, Object obj4) {
        if ((i & 8) != 0) {
            function2 = new Function2() { // from class: com.arkivanov.decompose.router.panels.PanelsNavigatorExtKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj5, Object obj6) {
                    Unit navigate$lambda$1;
                    navigate$lambda$1 = PanelsNavigatorExtKt.navigate$lambda$1((Panels) obj5, (Panels) obj6);
                    return navigate$lambda$1;
                }
            };
        }
        navigate(panelsNavigator, obj, obj2, obj3, function2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit navigate$lambda$1(Panels panels, Panels panels2) {
        Intrinsics.checkNotNullParameter(panels, "<unused var>");
        Intrinsics.checkNotNullParameter(panels2, "<unused var>");
        return Unit.INSTANCE;
    }

    public static final <MC, DC, EC> void navigate(PanelsNavigator<MC, DC, EC> panelsNavigator, final MC main, final DC dc, final EC ec, Function2<? super Panels<? extends MC, ? extends DC, ? extends EC>, ? super Panels<? extends MC, ? extends DC, ? extends EC>, Unit> onComplete) {
        Intrinsics.checkNotNullParameter(panelsNavigator, "<this>");
        Intrinsics.checkNotNullParameter(main, "main");
        Intrinsics.checkNotNullParameter(onComplete, "onComplete");
        panelsNavigator.navigate(new Function1() { // from class: com.arkivanov.decompose.router.panels.PanelsNavigatorExtKt$$ExternalSyntheticLambda12
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Panels navigate$lambda$2;
                navigate$lambda$2 = PanelsNavigatorExtKt.navigate$lambda$2(main, dc, ec, (Panels) obj);
                return navigate$lambda$2;
            }
        }, onComplete);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Panels navigate$lambda$2(Object obj, Object obj2, Object obj3, Panels it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Panels.copy$default(it, obj, obj2, obj3, null, 8, null);
    }

    public static /* synthetic */ void navigate$default(PanelsNavigator panelsNavigator, Object obj, Object obj2, Function2 function2, int i, Object obj3) {
        if ((i & 4) != 0) {
            function2 = new Function2() { // from class: com.arkivanov.decompose.router.panels.PanelsNavigatorExtKt$$ExternalSyntheticLambda16
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj4, Object obj5) {
                    Unit navigate$lambda$3;
                    navigate$lambda$3 = PanelsNavigatorExtKt.navigate$lambda$3((Panels) obj4, (Panels) obj5);
                    return navigate$lambda$3;
                }
            };
        }
        navigate(panelsNavigator, obj, obj2, function2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit navigate$lambda$3(Panels panels, Panels panels2) {
        Intrinsics.checkNotNullParameter(panels, "<unused var>");
        Intrinsics.checkNotNullParameter(panels2, "<unused var>");
        return Unit.INSTANCE;
    }

    public static final <MC, DC, EC> void navigate(PanelsNavigator<MC, DC, EC> panelsNavigator, final DC dc, final EC ec, Function2<? super Panels<? extends MC, ? extends DC, ? extends EC>, ? super Panels<? extends MC, ? extends DC, ? extends EC>, Unit> onComplete) {
        Intrinsics.checkNotNullParameter(panelsNavigator, "<this>");
        Intrinsics.checkNotNullParameter(onComplete, "onComplete");
        panelsNavigator.navigate(new Function1() { // from class: com.arkivanov.decompose.router.panels.PanelsNavigatorExtKt$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Panels navigate$lambda$4;
                navigate$lambda$4 = PanelsNavigatorExtKt.navigate$lambda$4(dc, ec, (Panels) obj);
                return navigate$lambda$4;
            }
        }, onComplete);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Panels navigate$lambda$4(Object obj, Object obj2, Panels it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Panels.copy$default(it, null, obj, obj2, null, 9, null);
    }

    public static /* synthetic */ void navigate$default(PanelsNavigator panelsNavigator, Object obj, Function2 function2, int i, Object obj2) {
        if ((i & 2) != 0) {
            function2 = new Function2() { // from class: com.arkivanov.decompose.router.panels.PanelsNavigatorExtKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj3, Object obj4) {
                    Unit navigate$lambda$5;
                    navigate$lambda$5 = PanelsNavigatorExtKt.navigate$lambda$5((Panels) obj3, (Panels) obj4);
                    return navigate$lambda$5;
                }
            };
        }
        navigate(panelsNavigator, obj, function2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit navigate$lambda$5(Panels panels, Panels panels2) {
        Intrinsics.checkNotNullParameter(panels, "<unused var>");
        Intrinsics.checkNotNullParameter(panels2, "<unused var>");
        return Unit.INSTANCE;
    }

    public static final <MC, DC, EC> void navigate(PanelsNavigator<MC, DC, EC> panelsNavigator, final EC ec, Function2<? super Panels<? extends MC, ? extends DC, ? extends EC>, ? super Panels<? extends MC, ? extends DC, ? extends EC>, Unit> onComplete) {
        Intrinsics.checkNotNullParameter(panelsNavigator, "<this>");
        Intrinsics.checkNotNullParameter(onComplete, "onComplete");
        panelsNavigator.navigate(new Function1() { // from class: com.arkivanov.decompose.router.panels.PanelsNavigatorExtKt$$ExternalSyntheticLambda19
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Panels navigate$lambda$6;
                navigate$lambda$6 = PanelsNavigatorExtKt.navigate$lambda$6(ec, (Panels) obj);
                return navigate$lambda$6;
            }
        }, onComplete);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Panels navigate$lambda$6(Object obj, Panels it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Panels.copy$default(it, null, null, obj, null, 11, null);
    }

    public static /* synthetic */ void activateMain$default(PanelsNavigator panelsNavigator, Object obj, Function2 function2, int i, Object obj2) {
        if ((i & 2) != 0) {
            function2 = new Function2() { // from class: com.arkivanov.decompose.router.panels.PanelsNavigatorExtKt$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj3, Object obj4) {
                    Unit activateMain$lambda$7;
                    activateMain$lambda$7 = PanelsNavigatorExtKt.activateMain$lambda$7((Panels) obj3, (Panels) obj4);
                    return activateMain$lambda$7;
                }
            };
        }
        activateMain(panelsNavigator, obj, function2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit activateMain$lambda$7(Panels panels, Panels panels2) {
        Intrinsics.checkNotNullParameter(panels, "<unused var>");
        Intrinsics.checkNotNullParameter(panels2, "<unused var>");
        return Unit.INSTANCE;
    }

    public static final <MC, DC, EC> void activateMain(PanelsNavigator<MC, DC, EC> panelsNavigator, final MC main, Function2<? super Panels<? extends MC, ? extends DC, ? extends EC>, ? super Panels<? extends MC, ? extends DC, ? extends EC>, Unit> onComplete) {
        Intrinsics.checkNotNullParameter(panelsNavigator, "<this>");
        Intrinsics.checkNotNullParameter(main, "main");
        Intrinsics.checkNotNullParameter(onComplete, "onComplete");
        panelsNavigator.navigate(new Function1() { // from class: com.arkivanov.decompose.router.panels.PanelsNavigatorExtKt$$ExternalSyntheticLambda13
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Panels activateMain$lambda$8;
                activateMain$lambda$8 = PanelsNavigatorExtKt.activateMain$lambda$8(main, (Panels) obj);
                return activateMain$lambda$8;
            }
        }, onComplete);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Panels activateMain$lambda$8(Object obj, Panels it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Panels.copy$default(it, obj, null, null, null, 14, null);
    }

    public static /* synthetic */ void activateDetails$default(PanelsNavigator panelsNavigator, Object obj, Function2 function2, int i, Object obj2) {
        if ((i & 2) != 0) {
            function2 = new Function2() { // from class: com.arkivanov.decompose.router.panels.PanelsNavigatorExtKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj3, Object obj4) {
                    Unit activateDetails$lambda$9;
                    activateDetails$lambda$9 = PanelsNavigatorExtKt.activateDetails$lambda$9((Panels) obj3, (Panels) obj4);
                    return activateDetails$lambda$9;
                }
            };
        }
        activateDetails(panelsNavigator, obj, function2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit activateDetails$lambda$9(Panels panels, Panels panels2) {
        Intrinsics.checkNotNullParameter(panels, "<unused var>");
        Intrinsics.checkNotNullParameter(panels2, "<unused var>");
        return Unit.INSTANCE;
    }

    public static final <MC, DC, EC> void activateDetails(PanelsNavigator<MC, DC, EC> panelsNavigator, final DC details, Function2<? super Panels<? extends MC, ? extends DC, ? extends EC>, ? super Panels<? extends MC, ? extends DC, ? extends EC>, Unit> onComplete) {
        Intrinsics.checkNotNullParameter(panelsNavigator, "<this>");
        Intrinsics.checkNotNullParameter(details, "details");
        Intrinsics.checkNotNullParameter(onComplete, "onComplete");
        panelsNavigator.navigate(new Function1() { // from class: com.arkivanov.decompose.router.panels.PanelsNavigatorExtKt$$ExternalSyntheticLambda17
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Panels activateDetails$lambda$10;
                activateDetails$lambda$10 = PanelsNavigatorExtKt.activateDetails$lambda$10(details, (Panels) obj);
                return activateDetails$lambda$10;
            }
        }, onComplete);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Panels activateDetails$lambda$10(Object obj, Panels it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Panels.copy$default(it, null, obj, null, null, 13, null);
    }

    public static /* synthetic */ void dismissDetails$default(PanelsNavigator panelsNavigator, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            function2 = new Function2() { // from class: com.arkivanov.decompose.router.panels.PanelsNavigatorExtKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    Unit dismissDetails$lambda$11;
                    dismissDetails$lambda$11 = PanelsNavigatorExtKt.dismissDetails$lambda$11((Panels) obj2, (Panels) obj3);
                    return dismissDetails$lambda$11;
                }
            };
        }
        dismissDetails(panelsNavigator, function2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit dismissDetails$lambda$11(Panels panels, Panels panels2) {
        Intrinsics.checkNotNullParameter(panels, "<unused var>");
        Intrinsics.checkNotNullParameter(panels2, "<unused var>");
        return Unit.INSTANCE;
    }

    public static final <MC, DC, EC> void dismissDetails(PanelsNavigator<MC, DC, EC> panelsNavigator, Function2<? super Panels<? extends MC, ? extends DC, ? extends EC>, ? super Panels<? extends MC, ? extends DC, ? extends EC>, Unit> onComplete) {
        Intrinsics.checkNotNullParameter(panelsNavigator, "<this>");
        Intrinsics.checkNotNullParameter(onComplete, "onComplete");
        panelsNavigator.navigate(new Function1() { // from class: com.arkivanov.decompose.router.panels.PanelsNavigatorExtKt$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Panels dismissDetails$lambda$12;
                dismissDetails$lambda$12 = PanelsNavigatorExtKt.dismissDetails$lambda$12((Panels) obj);
                return dismissDetails$lambda$12;
            }
        }, onComplete);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Panels dismissDetails$lambda$12(Panels it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Panels.copy$default(it, null, null, null, null, 13, null);
    }

    public static /* synthetic */ void activateExtra$default(PanelsNavigator panelsNavigator, Object obj, Function2 function2, int i, Object obj2) {
        if ((i & 2) != 0) {
            function2 = new Function2() { // from class: com.arkivanov.decompose.router.panels.PanelsNavigatorExtKt$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj3, Object obj4) {
                    Unit activateExtra$lambda$13;
                    activateExtra$lambda$13 = PanelsNavigatorExtKt.activateExtra$lambda$13((Panels) obj3, (Panels) obj4);
                    return activateExtra$lambda$13;
                }
            };
        }
        activateExtra(panelsNavigator, obj, function2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit activateExtra$lambda$13(Panels panels, Panels panels2) {
        Intrinsics.checkNotNullParameter(panels, "<unused var>");
        Intrinsics.checkNotNullParameter(panels2, "<unused var>");
        return Unit.INSTANCE;
    }

    public static final <MC, DC, EC> void activateExtra(PanelsNavigator<MC, DC, EC> panelsNavigator, final EC extra, Function2<? super Panels<? extends MC, ? extends DC, ? extends EC>, ? super Panels<? extends MC, ? extends DC, ? extends EC>, Unit> onComplete) {
        Intrinsics.checkNotNullParameter(panelsNavigator, "<this>");
        Intrinsics.checkNotNullParameter(extra, "extra");
        Intrinsics.checkNotNullParameter(onComplete, "onComplete");
        panelsNavigator.navigate(new Function1() { // from class: com.arkivanov.decompose.router.panels.PanelsNavigatorExtKt$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Panels activateExtra$lambda$14;
                activateExtra$lambda$14 = PanelsNavigatorExtKt.activateExtra$lambda$14(extra, (Panels) obj);
                return activateExtra$lambda$14;
            }
        }, onComplete);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Panels activateExtra$lambda$14(Object obj, Panels it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Panels.copy$default(it, null, null, obj, null, 11, null);
    }

    public static /* synthetic */ void dismissExtra$default(PanelsNavigator panelsNavigator, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            function2 = new Function2() { // from class: com.arkivanov.decompose.router.panels.PanelsNavigatorExtKt$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    Unit dismissExtra$lambda$15;
                    dismissExtra$lambda$15 = PanelsNavigatorExtKt.dismissExtra$lambda$15((Panels) obj2, (Panels) obj3);
                    return dismissExtra$lambda$15;
                }
            };
        }
        dismissExtra(panelsNavigator, function2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit dismissExtra$lambda$15(Panels panels, Panels panels2) {
        Intrinsics.checkNotNullParameter(panels, "<unused var>");
        Intrinsics.checkNotNullParameter(panels2, "<unused var>");
        return Unit.INSTANCE;
    }

    public static final <MC, DC, EC> void dismissExtra(PanelsNavigator<MC, DC, EC> panelsNavigator, Function2<? super Panels<? extends MC, ? extends DC, ? extends EC>, ? super Panels<? extends MC, ? extends DC, ? extends EC>, Unit> onComplete) {
        Intrinsics.checkNotNullParameter(panelsNavigator, "<this>");
        Intrinsics.checkNotNullParameter(onComplete, "onComplete");
        panelsNavigator.navigate(new Function1() { // from class: com.arkivanov.decompose.router.panels.PanelsNavigatorExtKt$$ExternalSyntheticLambda15
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Panels dismissExtra$lambda$16;
                dismissExtra$lambda$16 = PanelsNavigatorExtKt.dismissExtra$lambda$16((Panels) obj);
                return dismissExtra$lambda$16;
            }
        }, onComplete);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Panels dismissExtra$lambda$16(Panels it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Panels.copy$default(it, null, null, null, null, 11, null);
    }

    public static /* synthetic */ void pop$default(PanelsNavigator panelsNavigator, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            function2 = new Function2() { // from class: com.arkivanov.decompose.router.panels.PanelsNavigatorExtKt$$ExternalSyntheticLambda20
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    Unit pop$lambda$17;
                    pop$lambda$17 = PanelsNavigatorExtKt.pop$lambda$17((Panels) obj2, (Panels) obj3);
                    return pop$lambda$17;
                }
            };
        }
        pop(panelsNavigator, function2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit pop$lambda$17(Panels panels, Panels panels2) {
        Intrinsics.checkNotNullParameter(panels, "<unused var>");
        Intrinsics.checkNotNullParameter(panels2, "<unused var>");
        return Unit.INSTANCE;
    }

    public static final <MC, DC, EC> void pop(PanelsNavigator<MC, DC, EC> panelsNavigator, Function2<? super Panels<? extends MC, ? extends DC, ? extends EC>, ? super Panels<? extends MC, ? extends DC, ? extends EC>, Unit> onComplete) {
        Intrinsics.checkNotNullParameter(panelsNavigator, "<this>");
        Intrinsics.checkNotNullParameter(onComplete, "onComplete");
        panelsNavigator.navigate(new Function1() { // from class: com.arkivanov.decompose.router.panels.PanelsNavigatorExtKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Panels pop$lambda$18;
                pop$lambda$18 = PanelsNavigatorExtKt.pop$lambda$18((Panels) obj);
                return pop$lambda$18;
            }
        }, onComplete);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Panels pop$lambda$18(Panels state) {
        Intrinsics.checkNotNullParameter(state, "state");
        return state.getExtra() != null ? Panels.copy$default(state, null, null, null, null, 11, null) : state.getDetails() != null ? Panels.copy$default(state, null, null, null, null, 13, null) : state;
    }

    public static /* synthetic */ void setMode$default(PanelsNavigator panelsNavigator, ChildPanelsMode childPanelsMode, Function2 function2, int i, Object obj) {
        if ((i & 2) != 0) {
            function2 = new Function2() { // from class: com.arkivanov.decompose.router.panels.PanelsNavigatorExtKt$$ExternalSyntheticLambda18
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    Unit mode$lambda$19;
                    mode$lambda$19 = PanelsNavigatorExtKt.setMode$lambda$19((Panels) obj2, (Panels) obj3);
                    return mode$lambda$19;
                }
            };
        }
        setMode(panelsNavigator, childPanelsMode, function2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setMode$lambda$19(Panels panels, Panels panels2) {
        Intrinsics.checkNotNullParameter(panels, "<unused var>");
        Intrinsics.checkNotNullParameter(panels2, "<unused var>");
        return Unit.INSTANCE;
    }

    public static final <MC, DC, EC> void setMode(PanelsNavigator<MC, DC, EC> panelsNavigator, final ChildPanelsMode mode, Function2<? super Panels<? extends MC, ? extends DC, ? extends EC>, ? super Panels<? extends MC, ? extends DC, ? extends EC>, Unit> onComplete) {
        Intrinsics.checkNotNullParameter(panelsNavigator, "<this>");
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(onComplete, "onComplete");
        panelsNavigator.navigate(new Function1() { // from class: com.arkivanov.decompose.router.panels.PanelsNavigatorExtKt$$ExternalSyntheticLambda14
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Panels mode$lambda$20;
                mode$lambda$20 = PanelsNavigatorExtKt.setMode$lambda$20(ChildPanelsMode.this, (Panels) obj);
                return mode$lambda$20;
            }
        }, onComplete);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Panels setMode$lambda$20(ChildPanelsMode childPanelsMode, Panels it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Panels.copy$default(it, null, null, null, childPanelsMode, 7, null);
    }
}
