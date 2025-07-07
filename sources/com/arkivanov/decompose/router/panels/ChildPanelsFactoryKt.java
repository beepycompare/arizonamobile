package com.arkivanov.decompose.router.panels;

import com.arkivanov.decompose.Child;
import com.arkivanov.decompose.GenericComponentContext;
import com.arkivanov.decompose.router.children.ChildrenFactoryKt;
import com.arkivanov.decompose.router.children.NavigationSource;
import com.arkivanov.decompose.router.panels.Config;
import com.arkivanov.decompose.router.panels.Panel;
import com.arkivanov.decompose.router.panels.PanelsNavigation;
import com.arkivanov.decompose.value.Value;
import com.arkivanov.essenty.statekeeper.SerializableContainer;
import com.arkivanov.essenty.statekeeper.SerializableContainerKt;
import com.google.android.vending.expansion.downloader.DownloaderClientMarshaller;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
/* compiled from: ChildPanelsFactory.kt */
@Metadata(d1 = {"\u0000p\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u009b\u0003\u0010\u0000\u001a,\u0012(\u0012&\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00020\u0001\"\u000e\b\u0000\u0010\b*\b\u0012\u0004\u0012\u0002H\b0\t\"\b\b\u0001\u0010\u0003*\u00020\n\"\b\b\u0002\u0010\u0004*\u00020\n\"\b\b\u0003\u0010\u0005*\u00020\n\"\b\b\u0004\u0010\u0006*\u00020\n*\u0002H\b2\u001e\u0010\u000b\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u00020\u00070\r0\f2 \u0010\u000e\u001a\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\u0010\u0018\u00010\u000f2\u001e\u0010\u0011\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u00020\u00070\u00130\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u00152^\b\u0002\u0010\u0016\u001aX\u0012%\u0012#\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u00020\u00070\u0013¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012'\u0012%\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0013¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u001c0\u00172\b\b\u0002\u0010\u001d\u001a\u00020\u001e2'\u0010\u001f\u001a#\u0012\u0013\u0012\u0011H\u0003¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b( \u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u0002H\u00040\u00172'\u0010!\u001a#\u0012\u0013\u0012\u0011H\u0005¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b( \u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u0002H\u00060\u0017H\u0007¢\u0006\u0002\u0010\"\u001aÝ\u0003\u0010\u0000\u001a,\u0012(\u0012&\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H#\u0012\u0004\u0012\u0002H$0\u00020\u0001\"\u000e\b\u0000\u0010\b*\b\u0012\u0004\u0012\u0002H\b0\t\"\b\b\u0001\u0010\u0003*\u00020\n\"\b\b\u0002\u0010\u0004*\u00020\n\"\b\b\u0003\u0010\u0005*\u00020\n\"\b\b\u0004\u0010\u0006*\u00020\n\"\b\b\u0005\u0010#*\u00020\n\"\b\b\u0006\u0010$*\u00020\n*\u0002H\b2\u001e\u0010\u000b\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H#0\r0\f2\u001e\u0010\u0011\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H#0\u00130\u00122&\u0010%\u001a\"\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H#0\u0013\u0012\u0006\u0012\u0004\u0018\u00010'0&2&\u0010(\u001a\"\u0012\u0004\u0012\u00020'\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H#\u0018\u00010\u00130&2\b\b\u0002\u0010\u0014\u001a\u00020\u00152^\b\u0002\u0010\u0016\u001aX\u0012%\u0012#\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H#0\u0013¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012'\u0012%\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H#\u0018\u00010\u0013¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u001c0\u00172\b\b\u0002\u0010\u001d\u001a\u00020\u001e2'\u0010\u001f\u001a#\u0012\u0013\u0012\u0011H\u0003¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b( \u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u0002H\u00040\u00172'\u0010!\u001a#\u0012\u0013\u0012\u0011H\u0005¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b( \u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u0002H\u00060\u0017H\u0007¢\u0006\u0002\u0010)\u001aä\u0003\u0010\u0000\u001a,\u0012(\u0012&\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H#\u0012\u0004\u0012\u0002H$0\u00020\u0001\"\u000e\b\u0000\u0010\b*\b\u0012\u0004\u0012\u0002H\b0\t\"\b\b\u0001\u0010\u0003*\u00020\n\"\b\b\u0002\u0010\u0004*\u00020\n\"\b\b\u0003\u0010\u0005*\u00020\n\"\b\b\u0004\u0010\u0006*\u00020\n\"\b\b\u0005\u0010#*\u00020\n\"\b\b\u0006\u0010$*\u00020\n*\u0002H\b2\u001e\u0010\u000b\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H#0\r0\f2,\u0010\u000e\u001a(\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u0002H#0\u0010\u0018\u00010*2\u001e\u0010\u0011\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H#0\u00130\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u00152^\b\u0002\u0010\u0016\u001aX\u0012%\u0012#\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H#0\u0013¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012'\u0012%\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H#\u0018\u00010\u0013¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u001c0\u00172\b\b\u0002\u0010\u001d\u001a\u00020\u001e2'\u0010\u001f\u001a#\u0012\u0013\u0012\u0011H\u0003¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b( \u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u0002H\u00040\u00172'\u0010!\u001a#\u0012\u0013\u0012\u0011H\u0005¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b( \u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u0002H\u00060\u00172'\u0010+\u001a#\u0012\u0013\u0012\u0011H#¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b( \u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u0002H$0\u0017H\u0007¢\u0006\u0002\u0010,\u001a\u0086\u0004\u0010\u0000\u001a,\u0012(\u0012&\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H#\u0012\u0004\u0012\u0002H$0\u00020\u0001\"\u000e\b\u0000\u0010\b*\b\u0012\u0004\u0012\u0002H\b0\t\"\b\b\u0001\u0010\u0003*\u00020\n\"\b\b\u0002\u0010\u0004*\u00020\n\"\b\b\u0003\u0010\u0005*\u00020\n\"\b\b\u0004\u0010\u0006*\u00020\n\"\b\b\u0005\u0010#*\u00020\n\"\b\b\u0006\u0010$*\u00020\n*\u0002H\b2\u001e\u0010\u000b\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H#0\r0\f2\u001e\u0010\u0011\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H#0\u00130\u00122&\u0010%\u001a\"\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H#0\u0013\u0012\u0006\u0012\u0004\u0018\u00010'0&2&\u0010(\u001a\"\u0012\u0004\u0012\u00020'\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H#\u0018\u00010\u00130&2\b\b\u0002\u0010\u0014\u001a\u00020\u00152^\b\u0002\u0010\u0016\u001aX\u0012%\u0012#\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H#0\u0013¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012'\u0012%\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H#\u0018\u00010\u0013¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u001c0\u00172\b\b\u0002\u0010\u001d\u001a\u00020\u001e2'\u0010\u001f\u001a#\u0012\u0013\u0012\u0011H\u0003¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b( \u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u0002H\u00040\u00172'\u0010!\u001a#\u0012\u0013\u0012\u0011H\u0005¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b( \u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u0002H\u00060\u00172'\u0010+\u001a#\u0012\u0013\u0012\u0011H#¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b( \u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u0002H$0\u0017H\u0007¢\u0006\u0002\u0010-¨\u0006."}, d2 = {"childPanels", "Lcom/arkivanov/decompose/value/Value;", "Lcom/arkivanov/decompose/router/panels/ChildPanels;", "MC", "MT", "DC", "DT", "", "Ctx", "Lcom/arkivanov/decompose/GenericComponentContext;", "", "source", "Lcom/arkivanov/decompose/router/children/NavigationSource;", "Lcom/arkivanov/decompose/router/panels/PanelsNavigation$Event;", "serializers", "Lkotlin/Pair;", "Lkotlinx/serialization/KSerializer;", "initialPanels", "Lkotlin/Function0;", "Lcom/arkivanov/decompose/router/panels/Panels;", "key", "", "onStateChanged", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", DownloaderClientMarshaller.PARAM_NEW_STATE, "oldState", "", "handleBackButton", "", "mainFactory", "configuration", "detailsFactory", "(Lcom/arkivanov/decompose/GenericComponentContext;Lcom/arkivanov/decompose/router/children/NavigationSource;Lkotlin/Pair;Lkotlin/jvm/functions/Function0;Ljava/lang/String;Lkotlin/jvm/functions/Function2;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;)Lcom/arkivanov/decompose/value/Value;", "EC", "ET", "savePanels", "Lkotlin/Function1;", "Lcom/arkivanov/essenty/statekeeper/SerializableContainer;", "restorePanels", "(Lcom/arkivanov/decompose/GenericComponentContext;Lcom/arkivanov/decompose/router/children/NavigationSource;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Ljava/lang/String;Lkotlin/jvm/functions/Function2;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;)Lcom/arkivanov/decompose/value/Value;", "Lkotlin/Triple;", "extraFactory", "(Lcom/arkivanov/decompose/GenericComponentContext;Lcom/arkivanov/decompose/router/children/NavigationSource;Lkotlin/Triple;Lkotlin/jvm/functions/Function0;Ljava/lang/String;Lkotlin/jvm/functions/Function2;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;)Lcom/arkivanov/decompose/value/Value;", "(Lcom/arkivanov/decompose/GenericComponentContext;Lcom/arkivanov/decompose/router/children/NavigationSource;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Ljava/lang/String;Lkotlin/jvm/functions/Function2;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;)Lcom/arkivanov/decompose/value/Value;", "decompose_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ChildPanelsFactoryKt {
    public static /* synthetic */ Value childPanels$default(GenericComponentContext genericComponentContext, NavigationSource navigationSource, Pair pair, Function0 function0, String str, Function2 function2, boolean z, Function2 function22, Function2 function23, int i, Object obj) {
        if ((i & 8) != 0) {
            str = "DefaultChildPanels";
        }
        String str2 = str;
        if ((i & 16) != 0) {
            function2 = new Function2() { // from class: com.arkivanov.decompose.router.panels.ChildPanelsFactoryKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    Unit childPanels$lambda$0;
                    childPanels$lambda$0 = ChildPanelsFactoryKt.childPanels$lambda$0((Panels) obj2, (Panels) obj3);
                    return childPanels$lambda$0;
                }
            };
        }
        return childPanels(genericComponentContext, navigationSource, pair, function0, str2, function2, (i & 32) != 0 ? false : z, function22, function23);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit childPanels$lambda$0(Panels panels, Panels panels2) {
        Intrinsics.checkNotNullParameter(panels, "<unused var>");
        return Unit.INSTANCE;
    }

    @ExperimentalSerializationApi
    public static final <Ctx extends GenericComponentContext<? extends Ctx>, MC, MT, DC, DT> Value<ChildPanels> childPanels(Ctx ctx, NavigationSource<PanelsNavigation.Event> source, Pair<? extends KSerializer<MC>, ? extends KSerializer<DC>> pair, Function0<? extends Panels> initialPanels, String key, Function2<? super Panels, ? super Panels, Unit> onStateChanged, boolean z, Function2<? super MC, ? super Ctx, ? extends MT> mainFactory, Function2<? super DC, ? super Ctx, ? extends DT> detailsFactory) {
        Intrinsics.checkNotNullParameter(ctx, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(initialPanels, "initialPanels");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(onStateChanged, "onStateChanged");
        Intrinsics.checkNotNullParameter(mainFactory, "mainFactory");
        Intrinsics.checkNotNullParameter(detailsFactory, "detailsFactory");
        return childPanels(ctx, source, pair != null ? new Triple(pair.getFirst(), pair.getSecond(), BuiltinSerializersKt.NothingSerializer()) : null, initialPanels, key, onStateChanged, z, mainFactory, detailsFactory, new Function2() { // from class: com.arkivanov.decompose.router.panels.ChildPanelsFactoryKt$childPanels$3
            /* JADX WARN: Incorrect types in method signature: (Ljava/lang/Void;TCtx;)Ljava/lang/Void; */
            @Override // kotlin.jvm.functions.Function2
            public final Void invoke(Void r2, GenericComponentContext genericComponentContext) {
                Intrinsics.checkNotNullParameter(r2, "<unused var>");
                Intrinsics.checkNotNullParameter(genericComponentContext, "<unused var>");
                throw new IllegalStateException("Can't instantiate Nothing".toString());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit childPanels$lambda$2(Panels panels, Panels panels2) {
        Intrinsics.checkNotNullParameter(panels, "<unused var>");
        return Unit.INSTANCE;
    }

    public static final <Ctx extends GenericComponentContext<? extends Ctx>, MC, MT, DC, DT, EC, ET> Value<ChildPanels<MC, MT, DC, DT, EC, ET>> childPanels(Ctx ctx, NavigationSource<PanelsNavigation.Event<MC, DC, EC>> source, Function0<? extends Panels<? extends MC, ? extends DC, ? extends EC>> initialPanels, Function1<? super Panels<? extends MC, ? extends DC, ? extends EC>, SerializableContainer> savePanels, Function1<? super SerializableContainer, ? extends Panels<? extends MC, ? extends DC, ? extends EC>> restorePanels, String key, Function2<? super Panels<? extends MC, ? extends DC, ? extends EC>, ? super Panels<? extends MC, ? extends DC, ? extends EC>, Unit> onStateChanged, boolean z, Function2<? super MC, ? super Ctx, ? extends MT> mainFactory, Function2<? super DC, ? super Ctx, ? extends DT> detailsFactory) {
        Intrinsics.checkNotNullParameter(ctx, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(initialPanels, "initialPanels");
        Intrinsics.checkNotNullParameter(savePanels, "savePanels");
        Intrinsics.checkNotNullParameter(restorePanels, "restorePanels");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(onStateChanged, "onStateChanged");
        Intrinsics.checkNotNullParameter(mainFactory, "mainFactory");
        Intrinsics.checkNotNullParameter(detailsFactory, "detailsFactory");
        return childPanels(ctx, source, initialPanels, savePanels, restorePanels, key, onStateChanged, z, mainFactory, detailsFactory, new Function2() { // from class: com.arkivanov.decompose.router.panels.ChildPanelsFactoryKt$childPanels$5
            /* JADX WARN: Incorrect types in method signature: (TEC;TCtx;)Ljava/lang/Void; */
            @Override // kotlin.jvm.functions.Function2
            public final Void invoke(Object obj, GenericComponentContext genericComponentContext) {
                Intrinsics.checkNotNullParameter(obj, "<unused var>");
                Intrinsics.checkNotNullParameter(genericComponentContext, "<unused var>");
                throw new IllegalStateException("Can't instantiate Nothing".toString());
            }
        });
    }

    public static /* synthetic */ Value childPanels$default(GenericComponentContext genericComponentContext, NavigationSource navigationSource, Triple triple, Function0 function0, String str, Function2 function2, boolean z, Function2 function22, Function2 function23, Function2 function24, int i, Object obj) {
        if ((i & 8) != 0) {
            str = "DefaultChildPanels";
        }
        return childPanels(genericComponentContext, navigationSource, triple, function0, str, (i & 16) != 0 ? new Function2() { // from class: com.arkivanov.decompose.router.panels.ChildPanelsFactoryKt$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj2, Object obj3) {
                Unit childPanels$lambda$3;
                childPanels$lambda$3 = ChildPanelsFactoryKt.childPanels$lambda$3((Panels) obj2, (Panels) obj3);
                return childPanels$lambda$3;
            }
        } : function2, (i & 32) != 0 ? false : z, function22, function23, function24);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit childPanels$lambda$3(Panels panels, Panels panels2) {
        Intrinsics.checkNotNullParameter(panels, "<unused var>");
        return Unit.INSTANCE;
    }

    public static final <Ctx extends GenericComponentContext<? extends Ctx>, MC, MT, DC, DT, EC, ET> Value<ChildPanels<MC, MT, DC, DT, EC, ET>> childPanels(Ctx ctx, NavigationSource<PanelsNavigation.Event<MC, DC, EC>> source, final Triple<? extends KSerializer<MC>, ? extends KSerializer<DC>, ? extends KSerializer<EC>> triple, Function0<? extends Panels<? extends MC, ? extends DC, ? extends EC>> initialPanels, String key, Function2<? super Panels<? extends MC, ? extends DC, ? extends EC>, ? super Panels<? extends MC, ? extends DC, ? extends EC>, Unit> onStateChanged, boolean z, Function2<? super MC, ? super Ctx, ? extends MT> mainFactory, Function2<? super DC, ? super Ctx, ? extends DT> detailsFactory, Function2<? super EC, ? super Ctx, ? extends ET> extraFactory) {
        Intrinsics.checkNotNullParameter(ctx, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(initialPanels, "initialPanels");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(onStateChanged, "onStateChanged");
        Intrinsics.checkNotNullParameter(mainFactory, "mainFactory");
        Intrinsics.checkNotNullParameter(detailsFactory, "detailsFactory");
        Intrinsics.checkNotNullParameter(extraFactory, "extraFactory");
        return childPanels(ctx, source, initialPanels, new Function1() { // from class: com.arkivanov.decompose.router.panels.ChildPanelsFactoryKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                SerializableContainer childPanels$lambda$4;
                childPanels$lambda$4 = ChildPanelsFactoryKt.childPanels$lambda$4(Triple.this, (Panels) obj);
                return childPanels$lambda$4;
            }
        }, new Function1() { // from class: com.arkivanov.decompose.router.panels.ChildPanelsFactoryKt$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Panels childPanels$lambda$5;
                childPanels$lambda$5 = ChildPanelsFactoryKt.childPanels$lambda$5(Triple.this, (SerializableContainer) obj);
                return childPanels$lambda$5;
            }
        }, key, onStateChanged, z, mainFactory, detailsFactory, extraFactory);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SerializableContainer childPanels$lambda$4(Triple triple, Panels panels) {
        Intrinsics.checkNotNullParameter(panels, "panels");
        if (triple == null) {
            return null;
        }
        return SerializableContainerKt.SerializableContainer(panels, Panels.Companion.serializer((KSerializer) triple.component1(), (KSerializer) triple.component2(), (KSerializer) triple.component3()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Panels childPanels$lambda$5(Triple triple, SerializableContainer container) {
        Intrinsics.checkNotNullParameter(container, "container");
        if (triple == null) {
            return null;
        }
        return (Panels) container.consume(Panels.Companion.serializer((KSerializer) triple.component1(), (KSerializer) triple.component2(), (KSerializer) triple.component3()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit childPanels$lambda$6(Panels panels, Panels panels2) {
        Intrinsics.checkNotNullParameter(panels, "<unused var>");
        return Unit.INSTANCE;
    }

    public static final <Ctx extends GenericComponentContext<? extends Ctx>, MC, MT, DC, DT, EC, ET> Value<ChildPanels<MC, MT, DC, DT, EC, ET>> childPanels(Ctx ctx, NavigationSource<PanelsNavigation.Event<MC, DC, EC>> source, final Function0<? extends Panels<? extends MC, ? extends DC, ? extends EC>> initialPanels, final Function1<? super Panels<? extends MC, ? extends DC, ? extends EC>, SerializableContainer> savePanels, final Function1<? super SerializableContainer, ? extends Panels<? extends MC, ? extends DC, ? extends EC>> restorePanels, String key, final Function2<? super Panels<? extends MC, ? extends DC, ? extends EC>, ? super Panels<? extends MC, ? extends DC, ? extends EC>, Unit> onStateChanged, final boolean z, final Function2<? super MC, ? super Ctx, ? extends MT> mainFactory, final Function2<? super DC, ? super Ctx, ? extends DT> detailsFactory, final Function2<? super EC, ? super Ctx, ? extends ET> extraFactory) {
        Intrinsics.checkNotNullParameter(ctx, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(initialPanels, "initialPanels");
        Intrinsics.checkNotNullParameter(savePanels, "savePanels");
        Intrinsics.checkNotNullParameter(restorePanels, "restorePanels");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(onStateChanged, "onStateChanged");
        Intrinsics.checkNotNullParameter(mainFactory, "mainFactory");
        Intrinsics.checkNotNullParameter(detailsFactory, "detailsFactory");
        Intrinsics.checkNotNullParameter(extraFactory, "extraFactory");
        return ChildrenFactoryKt.children(ctx, source, key, new Function0() { // from class: com.arkivanov.decompose.router.panels.ChildPanelsFactoryKt$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                PanelsNavState childPanels$lambda$7;
                childPanels$lambda$7 = ChildPanelsFactoryKt.childPanels$lambda$7(Function0.this);
                return childPanels$lambda$7;
            }
        }, new Function1() { // from class: com.arkivanov.decompose.router.panels.ChildPanelsFactoryKt$$ExternalSyntheticLambda11
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                SerializableContainer childPanels$lambda$8;
                childPanels$lambda$8 = ChildPanelsFactoryKt.childPanels$lambda$8(Function1.this, (PanelsNavState) obj);
                return childPanels$lambda$8;
            }
        }, new Function1() { // from class: com.arkivanov.decompose.router.panels.ChildPanelsFactoryKt$$ExternalSyntheticLambda12
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                PanelsNavState childPanels$lambda$9;
                childPanels$lambda$9 = ChildPanelsFactoryKt.childPanels$lambda$9(Function1.this, (SerializableContainer) obj);
                return childPanels$lambda$9;
            }
        }, new Function2() { // from class: com.arkivanov.decompose.router.panels.ChildPanelsFactoryKt$$ExternalSyntheticLambda13
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                PanelsNavState childPanels$lambda$10;
                childPanels$lambda$10 = ChildPanelsFactoryKt.childPanels$lambda$10((PanelsNavState) obj, (PanelsNavigation.Event) obj2);
                return childPanels$lambda$10;
            }
        }, new Function2() { // from class: com.arkivanov.decompose.router.panels.ChildPanelsFactoryKt$$ExternalSyntheticLambda14
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                ChildPanels childPanels$lambda$16;
                childPanels$lambda$16 = ChildPanelsFactoryKt.childPanels$lambda$16((PanelsNavState) obj, (List) obj2);
                return childPanels$lambda$16;
            }
        }, new Function2() { // from class: com.arkivanov.decompose.router.panels.ChildPanelsFactoryKt$$ExternalSyntheticLambda15
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Unit childPanels$lambda$17;
                childPanels$lambda$17 = ChildPanelsFactoryKt.childPanels$lambda$17(Function2.this, (PanelsNavState) obj, (PanelsNavState) obj2);
                return childPanels$lambda$17;
            }
        }, new Function3() { // from class: com.arkivanov.decompose.router.panels.ChildPanelsFactoryKt$$ExternalSyntheticLambda16
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit childPanels$lambda$18;
                childPanels$lambda$18 = ChildPanelsFactoryKt.childPanels$lambda$18((PanelsNavigation.Event) obj, (PanelsNavState) obj2, (PanelsNavState) obj3);
                return childPanels$lambda$18;
            }
        }, new Function1() { // from class: com.arkivanov.decompose.router.panels.ChildPanelsFactoryKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Function0 childPanels$lambda$21;
                childPanels$lambda$21 = ChildPanelsFactoryKt.childPanels$lambda$21(z, (PanelsNavState) obj);
                return childPanels$lambda$21;
            }
        }, new Function2() { // from class: com.arkivanov.decompose.router.panels.ChildPanelsFactoryKt$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Panel childPanels$lambda$22;
                childPanels$lambda$22 = ChildPanelsFactoryKt.childPanels$lambda$22(Function2.this, detailsFactory, extraFactory, (Config) obj, (GenericComponentContext) obj2);
                return childPanels$lambda$22;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PanelsNavState childPanels$lambda$7(Function0 function0) {
        return new PanelsNavState((Panels) function0.invoke());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SerializableContainer childPanels$lambda$8(Function1 function1, PanelsNavState it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return (SerializableContainer) function1.invoke(it.getPanels());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PanelsNavState childPanels$lambda$9(Function1 function1, SerializableContainer it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Panels panels = (Panels) function1.invoke(it);
        if (panels != null) {
            return new PanelsNavState(panels);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PanelsNavState childPanels$lambda$10(PanelsNavState state, PanelsNavigation.Event event) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(event, "event");
        return new PanelsNavState((Panels) event.getTransformer().invoke(state.getPanels()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ChildPanels childPanels$lambda$16(PanelsNavState state, List children) {
        Panel.Main main;
        Panel.Details details;
        Panel.Extra extra;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(children, "children");
        List list = children;
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                main = null;
                break;
            }
            Object child = ((Child) it.next()).getInstance();
            if (child instanceof Panel.Main) {
                main = (Panel.Main) child;
                continue;
            } else {
                main = null;
                continue;
            }
            if (main != null) {
                break;
            }
        }
        if (main == null) {
            throw new NoSuchElementException("No element of the collection was transformed to a non-null value.");
        }
        Iterator it2 = list.iterator();
        while (true) {
            if (!it2.hasNext()) {
                details = null;
                break;
            }
            Object child2 = ((Child) it2.next()).getInstance();
            if (child2 instanceof Panel.Details) {
                details = (Panel.Details) child2;
                continue;
            } else {
                details = null;
                continue;
            }
            if (details != null) {
                break;
            }
        }
        Iterator it3 = list.iterator();
        while (true) {
            if (!it3.hasNext()) {
                extra = null;
                break;
            }
            Object child3 = ((Child) it3.next()).getInstance();
            if (child3 instanceof Panel.Extra) {
                extra = (Panel.Extra) child3;
                continue;
            } else {
                extra = null;
                continue;
            }
            if (extra != null) {
                break;
            }
        }
        return new ChildPanels(new Child.Created(main.getConfig(), main.getInstance()), details != null ? new Child.Created(details.getConfig(), details.getInstance()) : null, extra != null ? new Child.Created(extra.getConfig(), extra.getInstance()) : null, state.getPanels().getMode());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit childPanels$lambda$17(Function2 function2, PanelsNavState newState, PanelsNavState panelsNavState) {
        Intrinsics.checkNotNullParameter(newState, "newState");
        function2.invoke(newState.getPanels(), panelsNavState != null ? panelsNavState.getPanels() : null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit childPanels$lambda$18(PanelsNavigation.Event event, PanelsNavState newState, PanelsNavState oldState) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(newState, "newState");
        Intrinsics.checkNotNullParameter(oldState, "oldState");
        event.getOnComplete().invoke(newState.getPanels(), oldState.getPanels());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function0 childPanels$lambda$21(boolean z, final PanelsNavState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        final Panels panels = state.getPanels();
        if (z) {
            if (panels.getMode() == ChildPanelsMode.SINGLE && panels.getExtra() != null) {
                return new Function0() { // from class: com.arkivanov.decompose.router.panels.ChildPanelsFactoryKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        PanelsNavState childPanels$lambda$21$lambda$19;
                        childPanels$lambda$21$lambda$19 = ChildPanelsFactoryKt.childPanels$lambda$21$lambda$19(PanelsNavState.this, panels);
                        return childPanels$lambda$21$lambda$19;
                    }
                };
            }
            if (panels.getMode() != ChildPanelsMode.SINGLE || panels.getDetails() == null) {
                return null;
            }
            return new Function0() { // from class: com.arkivanov.decompose.router.panels.ChildPanelsFactoryKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    PanelsNavState childPanels$lambda$21$lambda$20;
                    childPanels$lambda$21$lambda$20 = ChildPanelsFactoryKt.childPanels$lambda$21$lambda$20(PanelsNavState.this, panels);
                    return childPanels$lambda$21$lambda$20;
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PanelsNavState childPanels$lambda$21$lambda$19(PanelsNavState panelsNavState, Panels panels) {
        return panelsNavState.copy(Panels.copy$default(panels, null, null, null, null, 11, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PanelsNavState childPanels$lambda$21$lambda$20(PanelsNavState panelsNavState, Panels panels) {
        return panelsNavState.copy(Panels.copy$default(panels, null, null, null, null, 13, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Panel childPanels$lambda$22(Function2 function2, Function2 function22, Function2 function23, Config config, GenericComponentContext ctx) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        if (config instanceof Config.Main) {
            Config.Main main = (Config.Main) config;
            return new Panel.Main(main.getConfig(), function2.invoke(main.getConfig(), ctx));
        } else if (config instanceof Config.Details) {
            Config.Details details = (Config.Details) config;
            return new Panel.Details(details.getConfig(), function22.invoke(details.getConfig(), ctx));
        } else if (config instanceof Config.Extra) {
            Config.Extra extra = (Config.Extra) config;
            return new Panel.Extra(extra.getConfig(), function23.invoke(extra.getConfig(), ctx));
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }
}
