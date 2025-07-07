package com.arkivanov.decompose.router.children;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.arkivanov.decompose.Cancellation;
import com.arkivanov.decompose.Child;
import com.arkivanov.decompose.GenericComponentContext;
import com.arkivanov.decompose.Relay;
import com.arkivanov.decompose.backhandler.ChildBackHandlerKt;
import com.arkivanov.decompose.router.children.NavEvent;
import com.arkivanov.decompose.value.Value;
import com.arkivanov.essenty.backhandler.BackCallback;
import com.arkivanov.essenty.backhandler.BackCallbackKt;
import com.arkivanov.essenty.backhandler.BackHandler;
import com.arkivanov.essenty.instancekeeper.InstanceKeeper;
import com.arkivanov.essenty.lifecycle.Lifecycle;
import com.arkivanov.essenty.statekeeper.SerializableContainer;
import com.arkivanov.essenty.statekeeper.SerializableContainerKt;
import com.google.android.vending.expansion.downloader.DownloaderClientMarshaller;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
/* compiled from: ChildrenFactory.kt */
@Metadata(d1 = {"\u0000r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0083\u0004\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u000e\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u0004\"\b\b\u0001\u0010\u0005*\u00020\u0006\"\b\b\u0002\u0010\u0007*\u00020\u0006\"\b\b\u0003\u0010\b*\u00020\u0006\"\u000e\b\u0004\u0010\t*\b\u0012\u0004\u0012\u0002H\u00050\n\"\b\b\u0005\u0010\u0002*\u00020\u0006*\u0002H\u00032\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\b0\f2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u0002H\t\u0018\u00010\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\t0\u00102\u0006\u0010\u0011\u001a\u00020\u001226\u0010\u0013\u001a2\u0012\u0013\u0012\u0011H\t¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u0011H\b¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u0002H\t0\u00142H\u0010\u0019\u001aD\u0012\u0013\u0012\u0011H\t¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012%\u0012#\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u00070\u001b0\u001a¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0000\u0012\u0004\u0012\u0002H\u00020\u00142:\b\u0002\u0010\u001c\u001a4\u0012\u0013\u0012\u0011H\t¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u001d\u0012\u0015\u0012\u0013\u0018\u0001H\t¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u001f0\u00142M\b\u0002\u0010 \u001aG\u0012\u0013\u0012\u0011H\b¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u0011H\t¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u001d\u0012\u0013\u0012\u0011H\t¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u001f0!2+\b\u0002\u0010\"\u001a%\u0012\u0013\u0012\u0011H\t¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\f\u0012\n\u0012\u0004\u0012\u0002H\t\u0018\u00010\u00100#26\u0010$\u001a2\u0012\u0013\u0012\u0011H\u0005¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(%\u0012\u0013\u0012\u0011H\u0003¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(&\u0012\u0004\u0012\u0002H\u00070\u0014¢\u0006\u0002\u0010'\u001a½\u0004\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u000e\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u0004\"\b\b\u0001\u0010\u0005*\u00020\u0006\"\b\b\u0002\u0010\u0007*\u00020\u0006\"\b\b\u0003\u0010\b*\u00020\u0006\"\u000e\b\u0004\u0010\t*\b\u0012\u0004\u0012\u0002H\u00050\n\"\b\b\u0005\u0010\u0002*\u00020\u0006*\u0002H\u00032\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\b0\f2\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\t0\u00102#\u0010(\u001a\u001f\u0012\u0013\u0012\u0011H\t¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0006\u0012\u0004\u0018\u00010)0#2#\u0010*\u001a\u001f\u0012\u0013\u0012\u00110)¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(+\u0012\u0006\u0012\u0004\u0018\u0001H\t0#26\u0010\u0013\u001a2\u0012\u0013\u0012\u0011H\t¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u0011H\b¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u0002H\t0\u00142H\u0010\u0019\u001aD\u0012\u0013\u0012\u0011H\t¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012%\u0012#\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u00070\u001b0\u001a¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0000\u0012\u0004\u0012\u0002H\u00020\u00142:\b\u0002\u0010\u001c\u001a4\u0012\u0013\u0012\u0011H\t¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u001d\u0012\u0015\u0012\u0013\u0018\u0001H\t¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u001f0\u00142M\b\u0002\u0010 \u001aG\u0012\u0013\u0012\u0011H\b¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u0011H\t¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u001d\u0012\u0013\u0012\u0011H\t¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u001f0!2+\b\u0002\u0010\"\u001a%\u0012\u0013\u0012\u0011H\t¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\f\u0012\n\u0012\u0004\u0012\u0002H\t\u0018\u00010\u00100#26\u0010$\u001a2\u0012\u0013\u0012\u0011H\u0005¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(%\u0012\u0013\u0012\u0011H\u0003¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(&\u0012\u0004\u0012\u0002H\u00070\u0014¢\u0006\u0002\u0010,\u001aï\u0001\u0010-\u001a\u0014\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\t0.\"\u000e\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u0004\"\b\b\u0001\u0010\u0005*\u00020\u0006\"\b\b\u0002\u0010\u0007*\u00020\u0006\"\u000e\b\u0003\u0010\t*\b\u0012\u0004\u0012\u0002H\u00050\n*\u0002H\u00032\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\t0\u00102#\u0010(\u001a\u001f\u0012\u0013\u0012\u0011H\t¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0006\u0012\u0004\u0018\u00010)0#2#\u0010*\u001a\u001f\u0012\u0013\u0012\u00110)¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(+\u0012\u0006\u0012\u0004\u0018\u0001H\t0#26\u0010$\u001a2\u0012\u0013\u0012\u0011H\u0005¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(%\u0012\u0013\u0012\u0011H\u0003¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(&\u0012\u0004\u0012\u0002H\u00070\u0014H\u0002¢\u0006\u0002\u0010/¨\u00060"}, d2 = {"children", "Lcom/arkivanov/decompose/value/Value;", ExifInterface.LATITUDE_SOUTH, "Ctx", "Lcom/arkivanov/decompose/GenericComponentContext;", "C", "", ExifInterface.GPS_DIRECTION_TRUE, ExifInterface.LONGITUDE_EAST, "N", "Lcom/arkivanov/decompose/router/children/NavState;", "source", "Lcom/arkivanov/decompose/router/children/NavigationSource;", "stateSerializer", "Lkotlinx/serialization/KSerializer;", "initialState", "Lkotlin/Function0;", "key", "", "navTransformer", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", RemoteConfigConstants.ResponseFieldKey.STATE, NotificationCompat.CATEGORY_EVENT, "stateMapper", "", "Lcom/arkivanov/decompose/Child;", "onStateChanged", DownloaderClientMarshaller.PARAM_NEW_STATE, "oldState", "", "onEventComplete", "Lkotlin/Function3;", "backTransformer", "Lkotlin/Function1;", "childFactory", "configuration", "componentContext", "(Lcom/arkivanov/decompose/GenericComponentContext;Lcom/arkivanov/decompose/router/children/NavigationSource;Lkotlinx/serialization/KSerializer;Lkotlin/jvm/functions/Function0;Ljava/lang/String;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)Lcom/arkivanov/decompose/value/Value;", "saveState", "Lcom/arkivanov/essenty/statekeeper/SerializableContainer;", "restoreState", TtmlNode.RUBY_CONTAINER, "(Lcom/arkivanov/decompose/GenericComponentContext;Lcom/arkivanov/decompose/router/children/NavigationSource;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)Lcom/arkivanov/decompose/value/Value;", "childrenNavigator", "Lcom/arkivanov/decompose/router/children/ChildrenNavigator;", "(Lcom/arkivanov/decompose/GenericComponentContext;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)Lcom/arkivanov/decompose/router/children/ChildrenNavigator;", "decompose_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ChildrenFactoryKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit children$lambda$0(NavState navState, NavState navState2) {
        Intrinsics.checkNotNullParameter(navState, "<unused var>");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit children$lambda$1(Object obj, NavState navState, NavState navState2) {
        Intrinsics.checkNotNullParameter(obj, "<unused var>");
        Intrinsics.checkNotNullParameter(navState, "<unused var>");
        Intrinsics.checkNotNullParameter(navState2, "<unused var>");
        return Unit.INSTANCE;
    }

    public static final <Ctx extends GenericComponentContext<? extends Ctx>, C, T, E, N extends NavState<? extends C>, S> Value<S> children(Ctx ctx, NavigationSource<? extends E> source, final KSerializer<N> kSerializer, Function0<? extends N> initialState, String key, Function2<? super N, ? super E, ? extends N> navTransformer, Function2<? super N, ? super List<? extends Child<? extends C, ? extends T>>, ? extends S> stateMapper, Function2<? super N, ? super N, Unit> onStateChanged, Function3<? super E, ? super N, ? super N, Unit> onEventComplete, Function1<? super N, ? extends Function0<? extends N>> backTransformer, Function2<? super C, ? super Ctx, ? extends T> childFactory) {
        Intrinsics.checkNotNullParameter(ctx, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(initialState, "initialState");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(navTransformer, "navTransformer");
        Intrinsics.checkNotNullParameter(stateMapper, "stateMapper");
        Intrinsics.checkNotNullParameter(onStateChanged, "onStateChanged");
        Intrinsics.checkNotNullParameter(onEventComplete, "onEventComplete");
        Intrinsics.checkNotNullParameter(backTransformer, "backTransformer");
        Intrinsics.checkNotNullParameter(childFactory, "childFactory");
        return children(ctx, source, key, initialState, new Function1() { // from class: com.arkivanov.decompose.router.children.ChildrenFactoryKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                SerializableContainer children$lambda$2;
                children$lambda$2 = ChildrenFactoryKt.children$lambda$2(KSerializer.this, (NavState) obj);
                return children$lambda$2;
            }
        }, new Function1() { // from class: com.arkivanov.decompose.router.children.ChildrenFactoryKt$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                NavState children$lambda$3;
                children$lambda$3 = ChildrenFactoryKt.children$lambda$3(KSerializer.this, (SerializableContainer) obj);
                return children$lambda$3;
            }
        }, navTransformer, stateMapper, onStateChanged, onEventComplete, backTransformer, childFactory);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SerializableContainer children$lambda$2(KSerializer kSerializer, NavState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (kSerializer != null) {
            return SerializableContainerKt.SerializableContainer(state, kSerializer);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NavState children$lambda$3(KSerializer kSerializer, SerializableContainer container) {
        Intrinsics.checkNotNullParameter(container, "container");
        if (kSerializer != null) {
            return (NavState) SerializableContainerKt.consumeRequired(container, kSerializer);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit children$lambda$4(NavState navState, NavState navState2) {
        Intrinsics.checkNotNullParameter(navState, "<unused var>");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit children$lambda$5(Object obj, NavState navState, NavState navState2) {
        Intrinsics.checkNotNullParameter(obj, "<unused var>");
        Intrinsics.checkNotNullParameter(navState, "<unused var>");
        Intrinsics.checkNotNullParameter(navState2, "<unused var>");
        return Unit.INSTANCE;
    }

    public static final <Ctx extends GenericComponentContext<? extends Ctx>, C, T, E, N extends NavState<? extends C>, S> Value<S> children(Ctx ctx, NavigationSource<? extends E> source, String key, Function0<? extends N> initialState, Function1<? super N, SerializableContainer> saveState, Function1<? super SerializableContainer, ? extends N> restoreState, Function2<? super N, ? super E, ? extends N> navTransformer, Function2<? super N, ? super List<? extends Child<? extends C, ? extends T>>, ? extends S> stateMapper, final Function2<? super N, ? super N, Unit> onStateChanged, Function3<? super E, ? super N, ? super N, Unit> onEventComplete, Function1<? super N, ? extends Function0<? extends N>> backTransformer, Function2<? super C, ? super Ctx, ? extends T> childFactory) {
        Intrinsics.checkNotNullParameter(ctx, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(initialState, "initialState");
        Intrinsics.checkNotNullParameter(saveState, "saveState");
        Intrinsics.checkNotNullParameter(restoreState, "restoreState");
        Intrinsics.checkNotNullParameter(navTransformer, "navTransformer");
        Intrinsics.checkNotNullParameter(stateMapper, "stateMapper");
        Intrinsics.checkNotNullParameter(onStateChanged, "onStateChanged");
        Intrinsics.checkNotNullParameter(onEventComplete, "onEventComplete");
        Intrinsics.checkNotNullParameter(backTransformer, "backTransformer");
        Intrinsics.checkNotNullParameter(childFactory, "childFactory");
        BackHandler child$default = ChildBackHandlerKt.child$default(ctx.getBackHandler(), null, 0, 3, null);
        final Relay relay = new Relay();
        final Cancellation subscribe = source.subscribe(new Function1() { // from class: com.arkivanov.decompose.router.children.ChildrenFactoryKt$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit children$lambda$6;
                children$lambda$6 = ChildrenFactoryKt.children$lambda$6(Relay.this, obj);
                return children$lambda$6;
            }
        });
        final BackCallback BackCallback$default = BackCallbackKt.BackCallback$default(false, 0, null, null, null, new Function0() { // from class: com.arkivanov.decompose.router.children.ChildrenFactoryKt$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit children$lambda$7;
                children$lambda$7 = ChildrenFactoryKt.children$lambda$7(Relay.this);
                return children$lambda$7;
            }
        }, 31, null);
        relay.subscribe(new ChildrenFactoryKt$children$9(new EventProcessor()));
        Holder holder = new Holder(childrenNavigator(ctx, key, initialState, saveState, restoreState, childFactory), stateMapper, navTransformer, new Function3() { // from class: com.arkivanov.decompose.router.children.ChildrenFactoryKt$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit children$lambda$8;
                children$lambda$8 = ChildrenFactoryKt.children$lambda$8(BackCallback.this, onStateChanged, (NavState) obj, (NavState) obj2, ((Boolean) obj3).booleanValue());
                return children$lambda$8;
            }
        }, onEventComplete, backTransformer);
        relay.accept(new NavEvent.Init(holder));
        child$default.register(BackCallback$default);
        Lifecycle lifecycle = ctx.getLifecycle();
        if (lifecycle.getState() == Lifecycle.State.DESTROYED) {
            subscribe.cancel();
        } else {
            lifecycle.subscribe(new Lifecycle.Callbacks() { // from class: com.arkivanov.decompose.router.children.ChildrenFactoryKt$children$$inlined$doOnDestroy$1
                @Override // com.arkivanov.essenty.lifecycle.Lifecycle.Callbacks
                public void onCreate() {
                    Lifecycle.Callbacks.DefaultImpls.onCreate(this);
                }

                @Override // com.arkivanov.essenty.lifecycle.Lifecycle.Callbacks
                public void onPause() {
                    Lifecycle.Callbacks.DefaultImpls.onPause(this);
                }

                @Override // com.arkivanov.essenty.lifecycle.Lifecycle.Callbacks
                public void onResume() {
                    Lifecycle.Callbacks.DefaultImpls.onResume(this);
                }

                @Override // com.arkivanov.essenty.lifecycle.Lifecycle.Callbacks
                public void onStart() {
                    Lifecycle.Callbacks.DefaultImpls.onStart(this);
                }

                @Override // com.arkivanov.essenty.lifecycle.Lifecycle.Callbacks
                public void onStop() {
                    Lifecycle.Callbacks.DefaultImpls.onStop(this);
                }

                @Override // com.arkivanov.essenty.lifecycle.Lifecycle.Callbacks
                public void onDestroy() {
                    Cancellation.this.cancel();
                }
            });
        }
        return holder.getState();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit children$lambda$6(Relay relay, Object it) {
        Intrinsics.checkNotNullParameter(it, "it");
        relay.accept(new NavEvent.Event(it));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit children$lambda$7(Relay relay) {
        relay.accept(NavEvent.Back.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit children$lambda$8(BackCallback backCallback, Function2 function2, NavState newState, NavState navState, boolean z) {
        Intrinsics.checkNotNullParameter(newState, "newState");
        backCallback.setEnabled(z);
        function2.invoke(newState, navState);
        return Unit.INSTANCE;
    }

    private static final <Ctx extends GenericComponentContext<? extends Ctx>, C, T, N extends NavState<? extends C>> ChildrenNavigator<C, T, N> childrenNavigator(final Ctx ctx, final String str, Function0<? extends N> function0, final Function1<? super N, SerializableContainer> function1, Function1<? super SerializableContainer, ? extends N> function12, Function2<? super C, ? super Ctx, ? extends T> function2) {
        List<SerializableContainer> childState;
        SerializableContainer navState;
        Ctx ctx2 = ctx;
        SavedState savedState = (SavedState) ctx2.getStateKeeper().consume(str, SavedState.Companion.serializer());
        N invoke = (savedState == null || (navState = savedState.getNavState()) == null) ? null : function12.invoke(navState);
        Ctx ctx3 = ctx;
        final ChildrenNavigator<C, T, N> childrenNavigator = new ChildrenNavigator<>(ctx3.getLifecycle(), new Function1() { // from class: com.arkivanov.decompose.router.children.ChildrenFactoryKt$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                InstanceKeeper.Instance childrenNavigator$lambda$11$lambda$9;
                childrenNavigator$lambda$11$lambda$9 = ChildrenFactoryKt.childrenNavigator$lambda$11$lambda$9(GenericComponentContext.this, str, (Function0) obj);
                return childrenNavigator$lambda$11$lambda$9;
            }
        }, new DefaultChildItemFactory(ctx.getComponentContextFactory(), ctx3.getLifecycle(), ChildBackHandlerKt.child$default(ctx.getBackHandler(), null, 1, 1, null), function2), invoke == null ? function0.invoke() : invoke, (savedState == null || (childState = savedState.getChildState()) == null || invoke == null) ? null : childState);
        ctx2.getStateKeeper().register(str, SavedState.Companion.serializer(), new Function0() { // from class: com.arkivanov.decompose.router.children.ChildrenFactoryKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                SavedState childrenNavigator$lambda$13;
                childrenNavigator$lambda$13 = ChildrenFactoryKt.childrenNavigator$lambda$13(Function1.this, childrenNavigator);
                return childrenNavigator$lambda$13;
            }
        });
        return childrenNavigator;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InstanceKeeper.Instance childrenNavigator$lambda$11$lambda$9(GenericComponentContext genericComponentContext, String str, Function0 factory) {
        Intrinsics.checkNotNullParameter(factory, "factory");
        InstanceKeeper instanceKeeper = genericComponentContext.getInstanceKeeper();
        InstanceKeeper.Instance instance = instanceKeeper.get(str);
        if (instance == null) {
            InstanceKeeper.Instance instance2 = (InstanceKeeper.Instance) factory.invoke();
            instanceKeeper.put(str, instance2);
            return instance2;
        }
        return instance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SavedState childrenNavigator$lambda$13(Function1 function1, ChildrenNavigator childrenNavigator) {
        SerializableContainer serializableContainer = (SerializableContainer) function1.invoke(childrenNavigator.getNavState());
        if (serializableContainer != null) {
            return new SavedState(serializableContainer, childrenNavigator.saveChildState());
        }
        return null;
    }
}
