package com.arkivanov.decompose.router.pages;

import androidx.exifinterface.media.ExifInterface;
import com.arkivanov.decompose.GenericComponentContext;
import com.arkivanov.decompose.router.children.ChildNavState;
import com.arkivanov.decompose.router.children.ChildrenFactoryKt;
import com.arkivanov.decompose.router.children.NavigationSource;
import com.arkivanov.decompose.router.pages.PagesNavigation;
import com.arkivanov.decompose.value.Value;
import com.arkivanov.essenty.statekeeper.SerializableContainer;
import com.arkivanov.essenty.statekeeper.SerializableContainerKt;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
/* compiled from: ChildPagesFactory.kt */
@Metadata(d1 = {"\u0000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aí\u0001\u0010\u0000\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u00040\u00020\u0001\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u0002H\u00050\u0006\"\b\b\u0001\u0010\u0003*\u00020\u0007\"\b\b\u0002\u0010\u0004*\u00020\u0007*\u0002H\u00052\u0012\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\n0\t2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u0002H\u0003\u0018\u00010\f2\u0014\b\u0002\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u000f0\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00112/\b\u0002\u0010\u0012\u001a)\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u000f\u0012\u0004\u0012\u00020\u00180\u00132\b\b\u0002\u0010\u0019\u001a\u00020\u001a2'\u0010\u001b\u001a#\u0012\u0013\u0012\u0011H\u0003¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u00040\u0013¢\u0006\u0002\u0010\u001d\u001a\u0093\u0002\u0010\u0000\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u00040\u00020\u0001\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u0002H\u00050\u0006\"\b\b\u0001\u0010\u0003*\u00020\u0007\"\b\b\u0002\u0010\u0004*\u00020\u0007*\u0002H\u00052\u0012\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\n0\t2\u0012\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u000f0\u000e2\u001a\u0010\u001e\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u000f\u0012\u0006\u0012\u0004\u0018\u00010 0\u001f2\u001a\u0010!\u001a\u0016\u0012\u0004\u0012\u00020 \u0012\f\u0012\n\u0012\u0004\u0012\u0002H\u0003\u0018\u00010\u000f0\u001f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112/\b\u0002\u0010\u0012\u001a)\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u000f\u0012\u0004\u0012\u00020\u00180\u00132\b\b\u0002\u0010\u0019\u001a\u00020\u001a2'\u0010\u001b\u001a#\u0012\u0013\u0012\u0011H\u0003¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u00040\u0013¢\u0006\u0002\u0010\"\u001a\u001c\u0010#\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u00142\n\u0010$\u001a\u0006\u0012\u0002\b\u00030\u000fH\u0001¨\u0006%"}, d2 = {"childPages", "Lcom/arkivanov/decompose/value/Value;", "Lcom/arkivanov/decompose/router/pages/ChildPages;", "C", ExifInterface.GPS_DIRECTION_TRUE, "Ctx", "Lcom/arkivanov/decompose/GenericComponentContext;", "", "source", "Lcom/arkivanov/decompose/router/children/NavigationSource;", "Lcom/arkivanov/decompose/router/pages/PagesNavigation$Event;", "serializer", "Lkotlinx/serialization/KSerializer;", "initialPages", "Lkotlin/Function0;", "Lcom/arkivanov/decompose/router/pages/Pages;", "key", "", "pageStatus", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", FirebaseAnalytics.Param.INDEX, "Lcom/arkivanov/decompose/router/children/ChildNavState$Status;", "handleBackButton", "", "childFactory", "configuration", "(Lcom/arkivanov/decompose/GenericComponentContext;Lcom/arkivanov/decompose/router/children/NavigationSource;Lkotlinx/serialization/KSerializer;Lkotlin/jvm/functions/Function0;Ljava/lang/String;Lkotlin/jvm/functions/Function2;ZLkotlin/jvm/functions/Function2;)Lcom/arkivanov/decompose/value/Value;", "savePages", "Lkotlin/Function1;", "Lcom/arkivanov/essenty/statekeeper/SerializableContainer;", "restorePages", "(Lcom/arkivanov/decompose/GenericComponentContext;Lcom/arkivanov/decompose/router/children/NavigationSource;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Ljava/lang/String;Lkotlin/jvm/functions/Function2;ZLkotlin/jvm/functions/Function2;)Lcom/arkivanov/decompose/value/Value;", "getDefaultPageStatus", "pages", "decompose_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ChildPagesFactoryKt {
    public static /* synthetic */ Value childPages$default(GenericComponentContext genericComponentContext, NavigationSource navigationSource, KSerializer kSerializer, Function0 function0, String str, Function2 function2, boolean z, Function2 function22, int i, Object obj) {
        if ((i & 4) != 0) {
            function0 = new Function0() { // from class: com.arkivanov.decompose.router.pages.ChildPagesFactoryKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Pages childPages$lambda$0;
                    childPages$lambda$0 = ChildPagesFactoryKt.childPages$lambda$0();
                    return childPages$lambda$0;
                }
            };
        }
        Function0 function02 = function0;
        if ((i & 8) != 0) {
            str = "DefaultChildPages";
        }
        String str2 = str;
        if ((i & 16) != 0) {
            function2 = ChildPagesFactoryKt$childPages$2.INSTANCE;
        }
        Function2 function23 = function2;
        if ((i & 32) != 0) {
            z = false;
        }
        return childPages(genericComponentContext, navigationSource, kSerializer, function02, str2, function23, z, function22);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Pages childPages$lambda$0() {
        return new Pages();
    }

    public static final <Ctx extends GenericComponentContext<? extends Ctx>, C, T> Value<ChildPages<C, T>> childPages(Ctx ctx, NavigationSource<PagesNavigation.Event<C>> source, final KSerializer<C> kSerializer, Function0<? extends Pages<? extends C>> initialPages, String key, Function2<? super Integer, ? super Pages<? extends C>, ? extends ChildNavState.Status> pageStatus, boolean z, Function2<? super C, ? super Ctx, ? extends T> childFactory) {
        Intrinsics.checkNotNullParameter(ctx, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(initialPages, "initialPages");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(pageStatus, "pageStatus");
        Intrinsics.checkNotNullParameter(childFactory, "childFactory");
        return childPages(ctx, source, initialPages, new Function1() { // from class: com.arkivanov.decompose.router.pages.ChildPagesFactoryKt$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                SerializableContainer childPages$lambda$1;
                childPages$lambda$1 = ChildPagesFactoryKt.childPages$lambda$1(KSerializer.this, (Pages) obj);
                return childPages$lambda$1;
            }
        }, new Function1() { // from class: com.arkivanov.decompose.router.pages.ChildPagesFactoryKt$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Pages childPages$lambda$2;
                childPages$lambda$2 = ChildPagesFactoryKt.childPages$lambda$2(KSerializer.this, (SerializableContainer) obj);
                return childPages$lambda$2;
            }
        }, key, pageStatus, z, childFactory);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SerializableContainer childPages$lambda$1(KSerializer kSerializer, Pages pages) {
        Intrinsics.checkNotNullParameter(pages, "pages");
        if (kSerializer != null) {
            return SerializableContainerKt.SerializableContainer(new SerializablePages(pages.getItems(), pages.getSelectedIndex()), SerializablePages.Companion.serializer(kSerializer));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Pages childPages$lambda$2(KSerializer kSerializer, SerializableContainer container) {
        Intrinsics.checkNotNullParameter(container, "container");
        if (kSerializer != null) {
            SerializablePages serializablePages = (SerializablePages) SerializableContainerKt.consumeRequired(container, SerializablePages.Companion.serializer(kSerializer));
            return new Pages(serializablePages.getItems(), serializablePages.getSelectedIndex());
        }
        return null;
    }

    public static /* synthetic */ Value childPages$default(GenericComponentContext genericComponentContext, NavigationSource navigationSource, Function0 function0, Function1 function1, Function1 function12, String str, Function2 function2, boolean z, Function2 function22, int i, Object obj) {
        if ((i & 16) != 0) {
            str = "DefaultChildPages";
        }
        return childPages(genericComponentContext, navigationSource, function0, function1, function12, str, (i & 32) != 0 ? ChildPagesFactoryKt$childPages$5.INSTANCE : function2, (i & 64) != 0 ? false : z, function22);
    }

    public static final <Ctx extends GenericComponentContext<? extends Ctx>, C, T> Value<ChildPages<C, T>> childPages(Ctx ctx, NavigationSource<PagesNavigation.Event<C>> source, final Function0<? extends Pages<? extends C>> initialPages, final Function1<? super Pages<? extends C>, SerializableContainer> savePages, final Function1<? super SerializableContainer, ? extends Pages<? extends C>> restorePages, String key, final Function2<? super Integer, ? super Pages<? extends C>, ? extends ChildNavState.Status> pageStatus, final boolean z, Function2<? super C, ? super Ctx, ? extends T> childFactory) {
        Intrinsics.checkNotNullParameter(ctx, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(initialPages, "initialPages");
        Intrinsics.checkNotNullParameter(savePages, "savePages");
        Intrinsics.checkNotNullParameter(restorePages, "restorePages");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(pageStatus, "pageStatus");
        Intrinsics.checkNotNullParameter(childFactory, "childFactory");
        return ChildrenFactoryKt.children$default(ctx, source, key, new Function0() { // from class: com.arkivanov.decompose.router.pages.ChildPagesFactoryKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                PagesNavState childPages$lambda$3;
                childPages$lambda$3 = ChildPagesFactoryKt.childPages$lambda$3(Function0.this, pageStatus);
                return childPages$lambda$3;
            }
        }, new Function1() { // from class: com.arkivanov.decompose.router.pages.ChildPagesFactoryKt$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                SerializableContainer childPages$lambda$4;
                childPages$lambda$4 = ChildPagesFactoryKt.childPages$lambda$4(Function1.this, (PagesNavState) obj);
                return childPages$lambda$4;
            }
        }, new Function1() { // from class: com.arkivanov.decompose.router.pages.ChildPagesFactoryKt$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                PagesNavState childPages$lambda$5;
                childPages$lambda$5 = ChildPagesFactoryKt.childPages$lambda$5(Function1.this, initialPages, pageStatus, (SerializableContainer) obj);
                return childPages$lambda$5;
            }
        }, new Function2() { // from class: com.arkivanov.decompose.router.pages.ChildPagesFactoryKt$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                PagesNavState childPages$lambda$6;
                childPages$lambda$6 = ChildPagesFactoryKt.childPages$lambda$6(Function2.this, (PagesNavState) obj, (PagesNavigation.Event) obj2);
                return childPages$lambda$6;
            }
        }, new Function2() { // from class: com.arkivanov.decompose.router.pages.ChildPagesFactoryKt$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                ChildPages childPages$lambda$7;
                childPages$lambda$7 = ChildPagesFactoryKt.childPages$lambda$7((PagesNavState) obj, (List) obj2);
                return childPages$lambda$7;
            }
        }, null, new Function3() { // from class: com.arkivanov.decompose.router.pages.ChildPagesFactoryKt$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit childPages$lambda$8;
                childPages$lambda$8 = ChildPagesFactoryKt.childPages$lambda$8((PagesNavigation.Event) obj, (PagesNavState) obj2, (PagesNavState) obj3);
                return childPages$lambda$8;
            }
        }, new Function1() { // from class: com.arkivanov.decompose.router.pages.ChildPagesFactoryKt$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Function0 childPages$lambda$10;
                childPages$lambda$10 = ChildPagesFactoryKt.childPages$lambda$10(z, (PagesNavState) obj);
                return childPages$lambda$10;
            }
        }, childFactory, 128, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PagesNavState childPages$lambda$3(Function0 function0, Function2 function2) {
        return new PagesNavState((Pages) function0.invoke(), function2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SerializableContainer childPages$lambda$4(Function1 function1, PagesNavState it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return (SerializableContainer) function1.invoke(it.getPages());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PagesNavState childPages$lambda$5(Function1 function1, Function0 function0, Function2 function2, SerializableContainer container) {
        Intrinsics.checkNotNullParameter(container, "container");
        Pages pages = (Pages) function1.invoke(container);
        if (pages == null) {
            pages = (Pages) function0.invoke();
        }
        return new PagesNavState(pages, function2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PagesNavState childPages$lambda$6(Function2 function2, PagesNavState state, PagesNavigation.Event event) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(event, "event");
        return new PagesNavState((Pages) event.getTransformer().invoke(state.getPages()), function2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ChildPages childPages$lambda$7(PagesNavState state, List children) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(children, "children");
        return new ChildPages(children, state.getPages().getSelectedIndex());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit childPages$lambda$8(PagesNavigation.Event event, PagesNavState newState, PagesNavState oldState) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(newState, "newState");
        Intrinsics.checkNotNullParameter(oldState, "oldState");
        event.getOnComplete().invoke(newState.getPages(), oldState.getPages());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function0 childPages$lambda$10(boolean z, final PagesNavState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        final int selectedIndex = state.getPages().getSelectedIndex();
        if (!z || state.getPages().getItems().isEmpty() || selectedIndex <= 0) {
            return null;
        }
        return new Function0() { // from class: com.arkivanov.decompose.router.pages.ChildPagesFactoryKt$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                PagesNavState childPages$lambda$10$lambda$9;
                childPages$lambda$10$lambda$9 = ChildPagesFactoryKt.childPages$lambda$10$lambda$9(PagesNavState.this, selectedIndex);
                return childPages$lambda$10$lambda$9;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PagesNavState childPages$lambda$10$lambda$9(PagesNavState pagesNavState, int i) {
        return PagesNavState.copy$default(pagesNavState, Pages.copy$default(pagesNavState.getPages(), null, i - 1, 1, null), null, 2, null);
    }

    public static final ChildNavState.Status getDefaultPageStatus(int i, Pages<?> pages) {
        Intrinsics.checkNotNullParameter(pages, "pages");
        if (i == pages.getSelectedIndex()) {
            return ChildNavState.Status.RESUMED;
        }
        return (i > pages.getSelectedIndex() + 1 || pages.getSelectedIndex() + (-1) > i) ? ChildNavState.Status.DESTROYED : ChildNavState.Status.CREATED;
    }
}
