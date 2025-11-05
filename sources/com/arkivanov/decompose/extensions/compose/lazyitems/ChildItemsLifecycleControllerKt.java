package com.arkivanov.decompose.extensions.compose.lazyitems;

import androidx.compose.foundation.lazy.LazyListItemInfo;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.grid.LazyGridItemInfo;
import androidx.compose.foundation.lazy.grid.LazyGridState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.media3.exoplayer.RendererCapabilities;
import com.arkivanov.decompose.extensions.compose.SubscribeAsStateKt;
import com.arkivanov.decompose.router.items.ChildItems;
import com.arkivanov.decompose.router.items.Items;
import com.arkivanov.decompose.router.items.LazyChildItems;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
/* compiled from: ChildItemsLifecycleController.kt */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u001aY\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0010\u0010\u0004\u001a\f\u0012\u0004\u0012\u0002H\u0002\u0012\u0002\b\u00030\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\t2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\nH\u0007¢\u0006\u0002\u0010\r\u001aY\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0010\u0010\u0004\u001a\f\u0012\u0004\u0012\u0002H\u0002\u0012\u0002\b\u00030\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\t2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\nH\u0007¢\u0006\u0002\u0010\u0010\u001a]\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0010\u0010\u0004\u001a\f\u0012\u0004\u0012\u0002H\u0002\u0012\u0002\b\u00030\u00052\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\nH\u0003¢\u0006\u0002\u0010\u0013¨\u0006\u0014²\u0006\n\u0010\u0011\u001a\u00020\nX\u008a\u0084\u0002²\u0006\n\u0010\u0012\u001a\u00020\nX\u008a\u0084\u0002²\u0006\n\u0010\u0011\u001a\u00020\nX\u008a\u0084\u0002²\u0006\n\u0010\u0012\u001a\u00020\nX\u008a\u0084\u0002²\u0006 \u0010\u0015\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00030\u0016\"\b\b\u0000\u0010\u0002*\u00020\u0003X\u008a\u0084\u0002²\u0006\u0016\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tX\u008a\u0084\u0002"}, d2 = {"ChildItemsLifecycleController", "", "C", "", "items", "Lcom/arkivanov/decompose/router/items/LazyChildItems;", "lazyListState", "Landroidx/compose/foundation/lazy/LazyListState;", "itemIndexConverter", "Lkotlin/Function1;", "", "forwardPreloadCount", "backwardPreloadCount", "(Lcom/arkivanov/decompose/router/items/LazyChildItems;Landroidx/compose/foundation/lazy/LazyListState;Lkotlin/jvm/functions/Function1;IILandroidx/compose/runtime/Composer;II)V", "lazyGridState", "Landroidx/compose/foundation/lazy/grid/LazyGridState;", "(Lcom/arkivanov/decompose/router/items/LazyChildItems;Landroidx/compose/foundation/lazy/grid/LazyGridState;Lkotlin/jvm/functions/Function1;IILandroidx/compose/runtime/Composer;II)V", "firstIndex", "lastIndex", "(Lcom/arkivanov/decompose/router/items/LazyChildItems;IILkotlin/jvm/functions/Function1;IILandroidx/compose/runtime/Composer;I)V", "extensions-compose_release", "childItems", "Lcom/arkivanov/decompose/router/items/ChildItems;", "itemIndexConverterRef"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ChildItemsLifecycleControllerKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ChildItemsLifecycleController$lambda$13(LazyChildItems lazyChildItems, LazyGridState lazyGridState, Function1 function1, int i, int i2, int i3, int i4, Composer composer, int i5) {
        ChildItemsLifecycleController(lazyChildItems, lazyGridState, function1, i, i2, composer, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), i4);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ChildItemsLifecycleController$lambda$21(LazyChildItems lazyChildItems, int i, int i2, Function1 function1, int i3, int i4, int i5, Composer composer, int i6) {
        ChildItemsLifecycleController(lazyChildItems, i, i2, function1, i3, i4, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ChildItemsLifecycleController$lambda$6(LazyChildItems lazyChildItems, LazyListState lazyListState, Function1 function1, int i, int i2, int i3, int i4, Composer composer, int i5) {
        ChildItemsLifecycleController(lazyChildItems, lazyListState, function1, i, i2, composer, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), i4);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:94:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <C> void ChildItemsLifecycleController(final LazyChildItems<C, ?> items, final LazyListState lazyListState, final Function1<? super Integer, Integer> itemIndexConverter, int i, int i2, Composer composer, final int i3, final int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        boolean z;
        Object rememberedValue;
        boolean z2;
        Object rememberedValue2;
        final int i9;
        final int i10;
        ScopeUpdateScope endRestartGroup;
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(lazyListState, "lazyListState");
        Intrinsics.checkNotNullParameter(itemIndexConverter, "itemIndexConverter");
        Composer startRestartGroup = composer.startRestartGroup(119216127);
        if ((i4 & 1) != 0) {
            i5 = i3 | 6;
        } else if ((i3 & 6) == 0) {
            i5 = (startRestartGroup.changedInstance(items) ? 4 : 2) | i3;
        } else {
            i5 = i3;
        }
        if ((i4 & 2) != 0) {
            i5 |= 48;
        } else if ((i3 & 48) == 0) {
            i5 |= startRestartGroup.changed(lazyListState) ? 32 : 16;
        }
        if ((i4 & 4) != 0) {
            i5 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        } else if ((i3 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i5 |= startRestartGroup.changedInstance(itemIndexConverter) ? 256 : 128;
        }
        int i11 = i4 & 8;
        if (i11 != 0) {
            i5 |= 3072;
        } else if ((i3 & 3072) == 0) {
            i6 = i;
            i5 |= startRestartGroup.changed(i6) ? 2048 : 1024;
            i7 = i4 & 16;
            if (i7 == 0) {
                i5 |= 24576;
            } else if ((i3 & 24576) == 0) {
                i8 = i2;
                i5 |= startRestartGroup.changed(i8) ? 16384 : 8192;
                if ((i5 & 9363) == 9362 || !startRestartGroup.getSkipping()) {
                    if (i11 != 0) {
                        i6 = 0;
                    }
                    if (i7 != 0) {
                        i8 = 0;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(119216127, i5, -1, "com.arkivanov.decompose.extensions.compose.lazyitems.ChildItemsLifecycleController (ChildItemsLifecycleController.kt:40)");
                    }
                    startRestartGroup.startReplaceGroup(-1524026310);
                    int i12 = i5 & 112;
                    z = i12 == 32;
                    rememberedValue = startRestartGroup.rememberedValue();
                    if (!z || rememberedValue == Composer.Companion.getEmpty()) {
                        rememberedValue = SnapshotStateKt.derivedStateOf(new Function0() { // from class: com.arkivanov.decompose.extensions.compose.lazyitems.ChildItemsLifecycleControllerKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                int ChildItemsLifecycleController$lambda$1$lambda$0;
                                ChildItemsLifecycleController$lambda$1$lambda$0 = ChildItemsLifecycleControllerKt.ChildItemsLifecycleController$lambda$1$lambda$0(LazyListState.this);
                                return Integer.valueOf(ChildItemsLifecycleController$lambda$1$lambda$0);
                            }
                        });
                        startRestartGroup.updateRememberedValue(rememberedValue);
                    }
                    State state = (State) rememberedValue;
                    startRestartGroup.endReplaceGroup();
                    startRestartGroup.startReplaceGroup(-1524020871);
                    z2 = i12 == 32;
                    rememberedValue2 = startRestartGroup.rememberedValue();
                    if (!z2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                        rememberedValue2 = SnapshotStateKt.derivedStateOf(new Function0() { // from class: com.arkivanov.decompose.extensions.compose.lazyitems.ChildItemsLifecycleControllerKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                int ChildItemsLifecycleController$lambda$4$lambda$3;
                                ChildItemsLifecycleController$lambda$4$lambda$3 = ChildItemsLifecycleControllerKt.ChildItemsLifecycleController$lambda$4$lambda$3(LazyListState.this);
                                return Integer.valueOf(ChildItemsLifecycleController$lambda$4$lambda$3);
                            }
                        });
                        startRestartGroup.updateRememberedValue(rememberedValue2);
                    }
                    startRestartGroup.endReplaceGroup();
                    int ChildItemsLifecycleController$lambda$2 = ChildItemsLifecycleController$lambda$2(state);
                    int ChildItemsLifecycleController$lambda$5 = ChildItemsLifecycleController$lambda$5((State) rememberedValue2);
                    int i13 = (i5 & 14) | ((i5 >> 9) & 112) | ((i5 >> 3) & 896) | ((i5 << 3) & 7168);
                    int i14 = i6;
                    int i15 = i8;
                    ChildItemsLifecycleController(items, i15, i14, itemIndexConverter, ChildItemsLifecycleController$lambda$2, ChildItemsLifecycleController$lambda$5, startRestartGroup, i13);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    i9 = i15;
                    i10 = i14;
                } else {
                    startRestartGroup.skipToGroupEnd();
                    i10 = i6;
                    i9 = i8;
                }
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2() { // from class: com.arkivanov.decompose.extensions.compose.lazyitems.ChildItemsLifecycleControllerKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            Unit ChildItemsLifecycleController$lambda$6;
                            ChildItemsLifecycleController$lambda$6 = ChildItemsLifecycleControllerKt.ChildItemsLifecycleController$lambda$6(LazyChildItems.this, lazyListState, itemIndexConverter, i10, i9, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                            return ChildItemsLifecycleController$lambda$6;
                        }
                    });
                    return;
                }
                return;
            }
            i8 = i2;
            if ((i5 & 9363) == 9362) {
            }
            if (i11 != 0) {
            }
            if (i7 != 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            startRestartGroup.startReplaceGroup(-1524026310);
            int i122 = i5 & 112;
            if (i122 == 32) {
            }
            rememberedValue = startRestartGroup.rememberedValue();
            if (!z) {
            }
            rememberedValue = SnapshotStateKt.derivedStateOf(new Function0() { // from class: com.arkivanov.decompose.extensions.compose.lazyitems.ChildItemsLifecycleControllerKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    int ChildItemsLifecycleController$lambda$1$lambda$0;
                    ChildItemsLifecycleController$lambda$1$lambda$0 = ChildItemsLifecycleControllerKt.ChildItemsLifecycleController$lambda$1$lambda$0(LazyListState.this);
                    return Integer.valueOf(ChildItemsLifecycleController$lambda$1$lambda$0);
                }
            });
            startRestartGroup.updateRememberedValue(rememberedValue);
            State state2 = (State) rememberedValue;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-1524020871);
            if (i122 == 32) {
            }
            rememberedValue2 = startRestartGroup.rememberedValue();
            if (!z2) {
            }
            rememberedValue2 = SnapshotStateKt.derivedStateOf(new Function0() { // from class: com.arkivanov.decompose.extensions.compose.lazyitems.ChildItemsLifecycleControllerKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    int ChildItemsLifecycleController$lambda$4$lambda$3;
                    ChildItemsLifecycleController$lambda$4$lambda$3 = ChildItemsLifecycleControllerKt.ChildItemsLifecycleController$lambda$4$lambda$3(LazyListState.this);
                    return Integer.valueOf(ChildItemsLifecycleController$lambda$4$lambda$3);
                }
            });
            startRestartGroup.updateRememberedValue(rememberedValue2);
            startRestartGroup.endReplaceGroup();
            int ChildItemsLifecycleController$lambda$22 = ChildItemsLifecycleController$lambda$2(state2);
            int ChildItemsLifecycleController$lambda$52 = ChildItemsLifecycleController$lambda$5((State) rememberedValue2);
            int i132 = (i5 & 14) | ((i5 >> 9) & 112) | ((i5 >> 3) & 896) | ((i5 << 3) & 7168);
            int i142 = i6;
            int i152 = i8;
            ChildItemsLifecycleController(items, i152, i142, itemIndexConverter, ChildItemsLifecycleController$lambda$22, ChildItemsLifecycleController$lambda$52, startRestartGroup, i132);
            if (ComposerKt.isTraceInProgress()) {
            }
            i9 = i152;
            i10 = i142;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        i6 = i;
        i7 = i4 & 16;
        if (i7 == 0) {
        }
        i8 = i2;
        if ((i5 & 9363) == 9362) {
        }
        if (i11 != 0) {
        }
        if (i7 != 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        startRestartGroup.startReplaceGroup(-1524026310);
        int i1222 = i5 & 112;
        if (i1222 == 32) {
        }
        rememberedValue = startRestartGroup.rememberedValue();
        if (!z) {
        }
        rememberedValue = SnapshotStateKt.derivedStateOf(new Function0() { // from class: com.arkivanov.decompose.extensions.compose.lazyitems.ChildItemsLifecycleControllerKt$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int ChildItemsLifecycleController$lambda$1$lambda$0;
                ChildItemsLifecycleController$lambda$1$lambda$0 = ChildItemsLifecycleControllerKt.ChildItemsLifecycleController$lambda$1$lambda$0(LazyListState.this);
                return Integer.valueOf(ChildItemsLifecycleController$lambda$1$lambda$0);
            }
        });
        startRestartGroup.updateRememberedValue(rememberedValue);
        State state22 = (State) rememberedValue;
        startRestartGroup.endReplaceGroup();
        startRestartGroup.startReplaceGroup(-1524020871);
        if (i1222 == 32) {
        }
        rememberedValue2 = startRestartGroup.rememberedValue();
        if (!z2) {
        }
        rememberedValue2 = SnapshotStateKt.derivedStateOf(new Function0() { // from class: com.arkivanov.decompose.extensions.compose.lazyitems.ChildItemsLifecycleControllerKt$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int ChildItemsLifecycleController$lambda$4$lambda$3;
                ChildItemsLifecycleController$lambda$4$lambda$3 = ChildItemsLifecycleControllerKt.ChildItemsLifecycleController$lambda$4$lambda$3(LazyListState.this);
                return Integer.valueOf(ChildItemsLifecycleController$lambda$4$lambda$3);
            }
        });
        startRestartGroup.updateRememberedValue(rememberedValue2);
        startRestartGroup.endReplaceGroup();
        int ChildItemsLifecycleController$lambda$222 = ChildItemsLifecycleController$lambda$2(state22);
        int ChildItemsLifecycleController$lambda$522 = ChildItemsLifecycleController$lambda$5((State) rememberedValue2);
        int i1322 = (i5 & 14) | ((i5 >> 9) & 112) | ((i5 >> 3) & 896) | ((i5 << 3) & 7168);
        int i1422 = i6;
        int i1522 = i8;
        ChildItemsLifecycleController(items, i1522, i1422, itemIndexConverter, ChildItemsLifecycleController$lambda$222, ChildItemsLifecycleController$lambda$522, startRestartGroup, i1322);
        if (ComposerKt.isTraceInProgress()) {
        }
        i9 = i1522;
        i10 = i1422;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int ChildItemsLifecycleController$lambda$1$lambda$0(LazyListState lazyListState) {
        LazyListItemInfo lazyListItemInfo = (LazyListItemInfo) CollectionsKt.firstOrNull((List<? extends Object>) lazyListState.getLayoutInfo().getVisibleItemsInfo());
        if (lazyListItemInfo != null) {
            return lazyListItemInfo.getIndex();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int ChildItemsLifecycleController$lambda$4$lambda$3(LazyListState lazyListState) {
        LazyListItemInfo lazyListItemInfo = (LazyListItemInfo) CollectionsKt.lastOrNull((List<? extends Object>) lazyListState.getLayoutInfo().getVisibleItemsInfo());
        if (lazyListItemInfo != null) {
            return lazyListItemInfo.getIndex();
        }
        return -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:94:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <C> void ChildItemsLifecycleController(final LazyChildItems<C, ?> items, final LazyGridState lazyGridState, final Function1<? super Integer, Integer> itemIndexConverter, int i, int i2, Composer composer, final int i3, final int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        boolean z;
        Object rememberedValue;
        boolean z2;
        Object rememberedValue2;
        final int i9;
        final int i10;
        ScopeUpdateScope endRestartGroup;
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(lazyGridState, "lazyGridState");
        Intrinsics.checkNotNullParameter(itemIndexConverter, "itemIndexConverter");
        Composer startRestartGroup = composer.startRestartGroup(1671148631);
        if ((i4 & 1) != 0) {
            i5 = i3 | 6;
        } else if ((i3 & 6) == 0) {
            i5 = (startRestartGroup.changedInstance(items) ? 4 : 2) | i3;
        } else {
            i5 = i3;
        }
        if ((i4 & 2) != 0) {
            i5 |= 48;
        } else if ((i3 & 48) == 0) {
            i5 |= startRestartGroup.changed(lazyGridState) ? 32 : 16;
        }
        if ((i4 & 4) != 0) {
            i5 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        } else if ((i3 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i5 |= startRestartGroup.changedInstance(itemIndexConverter) ? 256 : 128;
        }
        int i11 = i4 & 8;
        if (i11 != 0) {
            i5 |= 3072;
        } else if ((i3 & 3072) == 0) {
            i6 = i;
            i5 |= startRestartGroup.changed(i6) ? 2048 : 1024;
            i7 = i4 & 16;
            if (i7 == 0) {
                i5 |= 24576;
            } else if ((i3 & 24576) == 0) {
                i8 = i2;
                i5 |= startRestartGroup.changed(i8) ? 16384 : 8192;
                if ((i5 & 9363) == 9362 || !startRestartGroup.getSkipping()) {
                    if (i11 != 0) {
                        i6 = 0;
                    }
                    if (i7 != 0) {
                        i8 = 0;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1671148631, i5, -1, "com.arkivanov.decompose.extensions.compose.lazyitems.ChildItemsLifecycleController (ChildItemsLifecycleController.kt:86)");
                    }
                    startRestartGroup.startReplaceGroup(-1523966022);
                    int i12 = i5 & 112;
                    z = i12 == 32;
                    rememberedValue = startRestartGroup.rememberedValue();
                    if (!z || rememberedValue == Composer.Companion.getEmpty()) {
                        rememberedValue = SnapshotStateKt.derivedStateOf(new Function0() { // from class: com.arkivanov.decompose.extensions.compose.lazyitems.ChildItemsLifecycleControllerKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                int ChildItemsLifecycleController$lambda$8$lambda$7;
                                ChildItemsLifecycleController$lambda$8$lambda$7 = ChildItemsLifecycleControllerKt.ChildItemsLifecycleController$lambda$8$lambda$7(LazyGridState.this);
                                return Integer.valueOf(ChildItemsLifecycleController$lambda$8$lambda$7);
                            }
                        });
                        startRestartGroup.updateRememberedValue(rememberedValue);
                    }
                    State state = (State) rememberedValue;
                    startRestartGroup.endReplaceGroup();
                    startRestartGroup.startReplaceGroup(-1523960583);
                    z2 = i12 == 32;
                    rememberedValue2 = startRestartGroup.rememberedValue();
                    if (!z2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                        rememberedValue2 = SnapshotStateKt.derivedStateOf(new Function0() { // from class: com.arkivanov.decompose.extensions.compose.lazyitems.ChildItemsLifecycleControllerKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                int ChildItemsLifecycleController$lambda$11$lambda$10;
                                ChildItemsLifecycleController$lambda$11$lambda$10 = ChildItemsLifecycleControllerKt.ChildItemsLifecycleController$lambda$11$lambda$10(LazyGridState.this);
                                return Integer.valueOf(ChildItemsLifecycleController$lambda$11$lambda$10);
                            }
                        });
                        startRestartGroup.updateRememberedValue(rememberedValue2);
                    }
                    startRestartGroup.endReplaceGroup();
                    int ChildItemsLifecycleController$lambda$9 = ChildItemsLifecycleController$lambda$9(state);
                    int ChildItemsLifecycleController$lambda$12 = ChildItemsLifecycleController$lambda$12((State) rememberedValue2);
                    int i13 = (i5 & 14) | ((i5 >> 9) & 112) | ((i5 >> 3) & 896) | ((i5 << 3) & 7168);
                    int i14 = i6;
                    int i15 = i8;
                    ChildItemsLifecycleController(items, i15, i14, itemIndexConverter, ChildItemsLifecycleController$lambda$9, ChildItemsLifecycleController$lambda$12, startRestartGroup, i13);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    i9 = i15;
                    i10 = i14;
                } else {
                    startRestartGroup.skipToGroupEnd();
                    i10 = i6;
                    i9 = i8;
                }
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2() { // from class: com.arkivanov.decompose.extensions.compose.lazyitems.ChildItemsLifecycleControllerKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            Unit ChildItemsLifecycleController$lambda$13;
                            ChildItemsLifecycleController$lambda$13 = ChildItemsLifecycleControllerKt.ChildItemsLifecycleController$lambda$13(LazyChildItems.this, lazyGridState, itemIndexConverter, i10, i9, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                            return ChildItemsLifecycleController$lambda$13;
                        }
                    });
                    return;
                }
                return;
            }
            i8 = i2;
            if ((i5 & 9363) == 9362) {
            }
            if (i11 != 0) {
            }
            if (i7 != 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            startRestartGroup.startReplaceGroup(-1523966022);
            int i122 = i5 & 112;
            if (i122 == 32) {
            }
            rememberedValue = startRestartGroup.rememberedValue();
            if (!z) {
            }
            rememberedValue = SnapshotStateKt.derivedStateOf(new Function0() { // from class: com.arkivanov.decompose.extensions.compose.lazyitems.ChildItemsLifecycleControllerKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    int ChildItemsLifecycleController$lambda$8$lambda$7;
                    ChildItemsLifecycleController$lambda$8$lambda$7 = ChildItemsLifecycleControllerKt.ChildItemsLifecycleController$lambda$8$lambda$7(LazyGridState.this);
                    return Integer.valueOf(ChildItemsLifecycleController$lambda$8$lambda$7);
                }
            });
            startRestartGroup.updateRememberedValue(rememberedValue);
            State state2 = (State) rememberedValue;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-1523960583);
            if (i122 == 32) {
            }
            rememberedValue2 = startRestartGroup.rememberedValue();
            if (!z2) {
            }
            rememberedValue2 = SnapshotStateKt.derivedStateOf(new Function0() { // from class: com.arkivanov.decompose.extensions.compose.lazyitems.ChildItemsLifecycleControllerKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    int ChildItemsLifecycleController$lambda$11$lambda$10;
                    ChildItemsLifecycleController$lambda$11$lambda$10 = ChildItemsLifecycleControllerKt.ChildItemsLifecycleController$lambda$11$lambda$10(LazyGridState.this);
                    return Integer.valueOf(ChildItemsLifecycleController$lambda$11$lambda$10);
                }
            });
            startRestartGroup.updateRememberedValue(rememberedValue2);
            startRestartGroup.endReplaceGroup();
            int ChildItemsLifecycleController$lambda$92 = ChildItemsLifecycleController$lambda$9(state2);
            int ChildItemsLifecycleController$lambda$122 = ChildItemsLifecycleController$lambda$12((State) rememberedValue2);
            int i132 = (i5 & 14) | ((i5 >> 9) & 112) | ((i5 >> 3) & 896) | ((i5 << 3) & 7168);
            int i142 = i6;
            int i152 = i8;
            ChildItemsLifecycleController(items, i152, i142, itemIndexConverter, ChildItemsLifecycleController$lambda$92, ChildItemsLifecycleController$lambda$122, startRestartGroup, i132);
            if (ComposerKt.isTraceInProgress()) {
            }
            i9 = i152;
            i10 = i142;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        i6 = i;
        i7 = i4 & 16;
        if (i7 == 0) {
        }
        i8 = i2;
        if ((i5 & 9363) == 9362) {
        }
        if (i11 != 0) {
        }
        if (i7 != 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        startRestartGroup.startReplaceGroup(-1523966022);
        int i1222 = i5 & 112;
        if (i1222 == 32) {
        }
        rememberedValue = startRestartGroup.rememberedValue();
        if (!z) {
        }
        rememberedValue = SnapshotStateKt.derivedStateOf(new Function0() { // from class: com.arkivanov.decompose.extensions.compose.lazyitems.ChildItemsLifecycleControllerKt$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int ChildItemsLifecycleController$lambda$8$lambda$7;
                ChildItemsLifecycleController$lambda$8$lambda$7 = ChildItemsLifecycleControllerKt.ChildItemsLifecycleController$lambda$8$lambda$7(LazyGridState.this);
                return Integer.valueOf(ChildItemsLifecycleController$lambda$8$lambda$7);
            }
        });
        startRestartGroup.updateRememberedValue(rememberedValue);
        State state22 = (State) rememberedValue;
        startRestartGroup.endReplaceGroup();
        startRestartGroup.startReplaceGroup(-1523960583);
        if (i1222 == 32) {
        }
        rememberedValue2 = startRestartGroup.rememberedValue();
        if (!z2) {
        }
        rememberedValue2 = SnapshotStateKt.derivedStateOf(new Function0() { // from class: com.arkivanov.decompose.extensions.compose.lazyitems.ChildItemsLifecycleControllerKt$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int ChildItemsLifecycleController$lambda$11$lambda$10;
                ChildItemsLifecycleController$lambda$11$lambda$10 = ChildItemsLifecycleControllerKt.ChildItemsLifecycleController$lambda$11$lambda$10(LazyGridState.this);
                return Integer.valueOf(ChildItemsLifecycleController$lambda$11$lambda$10);
            }
        });
        startRestartGroup.updateRememberedValue(rememberedValue2);
        startRestartGroup.endReplaceGroup();
        int ChildItemsLifecycleController$lambda$922 = ChildItemsLifecycleController$lambda$9(state22);
        int ChildItemsLifecycleController$lambda$1222 = ChildItemsLifecycleController$lambda$12((State) rememberedValue2);
        int i1322 = (i5 & 14) | ((i5 >> 9) & 112) | ((i5 >> 3) & 896) | ((i5 << 3) & 7168);
        int i1422 = i6;
        int i1522 = i8;
        ChildItemsLifecycleController(items, i1522, i1422, itemIndexConverter, ChildItemsLifecycleController$lambda$922, ChildItemsLifecycleController$lambda$1222, startRestartGroup, i1322);
        if (ComposerKt.isTraceInProgress()) {
        }
        i9 = i1522;
        i10 = i1422;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int ChildItemsLifecycleController$lambda$8$lambda$7(LazyGridState lazyGridState) {
        LazyGridItemInfo lazyGridItemInfo = (LazyGridItemInfo) CollectionsKt.firstOrNull((List<? extends Object>) lazyGridState.getLayoutInfo().getVisibleItemsInfo());
        if (lazyGridItemInfo != null) {
            return lazyGridItemInfo.getIndex();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int ChildItemsLifecycleController$lambda$11$lambda$10(LazyGridState lazyGridState) {
        LazyGridItemInfo lazyGridItemInfo = (LazyGridItemInfo) CollectionsKt.lastOrNull((List<? extends Object>) lazyGridState.getLayoutInfo().getVisibleItemsInfo());
        if (lazyGridItemInfo != null) {
            return lazyGridItemInfo.getIndex();
        }
        return -1;
    }

    private static final <C> void ChildItemsLifecycleController(final LazyChildItems<C, ?> lazyChildItems, final int i, final int i2, final Function1<? super Integer, Integer> function1, final int i3, final int i4, Composer composer, final int i5) {
        int i6;
        int i7;
        Object[] objArr;
        Composer startRestartGroup = composer.startRestartGroup(1866700498);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(lazyChildItems) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(i) ? 32 : 16;
        }
        if ((i5 & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            i6 |= startRestartGroup.changed(i2) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changedInstance(function1) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i6 |= startRestartGroup.changed(i3) ? 16384 : 8192;
        }
        if ((196608 & i5) == 0) {
            i6 |= startRestartGroup.changed(i4) ? 131072 : 65536;
        }
        if ((74899 & i6) != 74898 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1866700498, i6, -1, "com.arkivanov.decompose.extensions.compose.lazyitems.ChildItemsLifecycleController (ChildItemsLifecycleController.kt:117)");
            }
            final List<C> items = ChildItemsLifecycleController$lambda$14(SubscribeAsStateKt.subscribeAsState(lazyChildItems, null, startRestartGroup, i6 & 14, 1)).getItems();
            final State rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function1, startRestartGroup, (i6 >> 9) & 14);
            int i8 = i6;
            Object[] objArr2 = {lazyChildItems, items, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
            startRestartGroup.startReplaceGroup(-1523929812);
            boolean changedInstance = startRestartGroup.changedInstance(lazyChildItems) | ((57344 & i8) == 16384) | ((458752 & i8) == 131072) | ((i8 & 112) == 32) | ((i8 & 896) == 256) | startRestartGroup.changedInstance(items) | startRestartGroup.changed(rememberUpdatedState);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                i7 = 0;
                objArr = objArr2;
                Function1 function12 = new Function1() { // from class: com.arkivanov.decompose.extensions.compose.lazyitems.ChildItemsLifecycleControllerKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        DisposableEffectResult ChildItemsLifecycleController$lambda$20$lambda$19;
                        ChildItemsLifecycleController$lambda$20$lambda$19 = ChildItemsLifecycleControllerKt.ChildItemsLifecycleController$lambda$20$lambda$19(LazyChildItems.this, i3, i4, i, i2, items, rememberUpdatedState, (DisposableEffectScope) obj);
                        return ChildItemsLifecycleController$lambda$20$lambda$19;
                    }
                };
                startRestartGroup.updateRememberedValue(function12);
                rememberedValue = function12;
            } else {
                objArr = objArr2;
                i7 = 0;
            }
            startRestartGroup.endReplaceGroup();
            EffectsKt.DisposableEffect(objArr, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) rememberedValue, startRestartGroup, i7);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.arkivanov.decompose.extensions.compose.lazyitems.ChildItemsLifecycleControllerKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit ChildItemsLifecycleController$lambda$21;
                    ChildItemsLifecycleController$lambda$21 = ChildItemsLifecycleControllerKt.ChildItemsLifecycleController$lambda$21(LazyChildItems.this, i, i2, function1, i3, i4, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return ChildItemsLifecycleController$lambda$21;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult ChildItemsLifecycleController$lambda$20$lambda$19(LazyChildItems lazyChildItems, final int i, final int i2, final int i3, final int i4, final List list, final State state, DisposableEffectScope DisposableEffect) {
        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
        lazyChildItems.navigate(new Function1<Items<C>, Items<C>>() { // from class: com.arkivanov.decompose.extensions.compose.lazyitems.ChildItemsLifecycleControllerKt$ChildItemsLifecycleController$lambda$20$lambda$19$$inlined$setActiveItems$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke((Items) ((Items) obj));
            }

            public final Items<C> invoke(Items<C> it) {
                int coerceAtLeast;
                int coerceAtLeast2;
                Function1 ChildItemsLifecycleController$lambda$15;
                Intrinsics.checkNotNullParameter(it, "it");
                it.getActiveItems();
                Map createMapBuilder = MapsKt.createMapBuilder();
                int i5 = i;
                if (i5 >= 0 && i2 >= 0 && (coerceAtLeast = i5 - RangesKt.coerceAtLeast(i3, 0)) <= (coerceAtLeast2 = i2 + RangesKt.coerceAtLeast(i4, 0))) {
                    while (true) {
                        List list2 = list;
                        ChildItemsLifecycleController$lambda$15 = ChildItemsLifecycleControllerKt.ChildItemsLifecycleController$lambda$15(state);
                        Object orNull = CollectionsKt.getOrNull(list2, ((Number) ChildItemsLifecycleController$lambda$15.invoke(Integer.valueOf(coerceAtLeast))).intValue());
                        if (orNull != null) {
                            createMapBuilder.put(orNull, (i > coerceAtLeast || coerceAtLeast > i2) ? Items.ActiveLifecycleState.CREATED : Items.ActiveLifecycleState.RESUMED);
                        }
                        if (coerceAtLeast == coerceAtLeast2) {
                            break;
                        }
                        coerceAtLeast++;
                    }
                }
                return Items.copy$default(it, null, MapsKt.build(createMapBuilder), 1, null);
            }
        }, new Function2<Items<C>, Items<C>, Unit>() { // from class: com.arkivanov.decompose.extensions.compose.lazyitems.ChildItemsLifecycleControllerKt$ChildItemsLifecycleController$lambda$20$lambda$19$$inlined$setActiveItems$2
            public final void invoke(Items<C> newItems, Items<C> oldItems) {
                Intrinsics.checkNotNullParameter(newItems, "newItems");
                Intrinsics.checkNotNullParameter(oldItems, "oldItems");
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Object obj, Object obj2) {
                invoke((Items) ((Items) obj), (Items) ((Items) obj2));
                return Unit.INSTANCE;
            }
        });
        return new DisposableEffectResult() { // from class: com.arkivanov.decompose.extensions.compose.lazyitems.ChildItemsLifecycleControllerKt$ChildItemsLifecycleController$lambda$20$lambda$19$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
            }
        };
    }

    private static final int ChildItemsLifecycleController$lambda$2(State<Integer> state) {
        return state.getValue().intValue();
    }

    private static final int ChildItemsLifecycleController$lambda$5(State<Integer> state) {
        return state.getValue().intValue();
    }

    private static final int ChildItemsLifecycleController$lambda$9(State<Integer> state) {
        return state.getValue().intValue();
    }

    private static final int ChildItemsLifecycleController$lambda$12(State<Integer> state) {
        return state.getValue().intValue();
    }

    private static final <C> ChildItems<C, Object> ChildItemsLifecycleController$lambda$14(State<? extends ChildItems<C, ? extends Object>> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function1<Integer, Integer> ChildItemsLifecycleController$lambda$15(State<? extends Function1<? super Integer, Integer>> state) {
        return (Function1) state.getValue();
    }
}
