package com.arkivanov.decompose.extensions.compose.pages;

import androidx.compose.foundation.pager.PagerScope;
import androidx.compose.foundation.pager.PagerState;
import androidx.compose.foundation.pager.PagerStateKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import androidx.profileinstaller.ProfileVerifier;
import com.arkivanov.decompose.Child;
import com.arkivanov.decompose.Ref;
import com.arkivanov.decompose.extensions.compose.SubscribeAsStateKt;
import com.arkivanov.decompose.extensions.compose.pages.PagesScrollAnimation;
import com.arkivanov.decompose.router.pages.ChildPages;
import com.arkivanov.decompose.value.Value;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.ranges.RangesKt;
/* compiled from: ChildPages.kt */
@Metadata(d1 = {"\u0000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u001aó\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u00032\u0018\u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00040\u00070\u00062!\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00010\t2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u0094\u0001\b\u0002\u0010\u0012\u001a\u008d\u0001\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0014\u0012.\u0012,\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00030\t¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0015\u0012>\u0012<\u0012\u0004\u0012\u00020\u0017\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0002\b\u0018¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0019¢\u0006\u0002\b\u001a\u0012\u0004\u0012\u00020\u00010\u0013j\u0002`\u001b¢\u0006\u0002\b\u00182 \b\u0002\u0010\u0015\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00040\u001c\u0012\u0004\u0012\u00020\u00030\t2F\u0010\u0019\u001aB\u0012\u0004\u0012\u00020\u0017\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u0011H\u0004¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u00010\u001d¢\u0006\u0002\b\u0018¢\u0006\u0002\b\u001aH\u0007¢\u0006\u0002\u0010\u001f\u001aù\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u00032\u0018\u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00040\u00070\u00062!\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00010\t2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u0094\u0001\b\u0002\u0010\u0012\u001a\u008d\u0001\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0014\u0012.\u0012,\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00030\t¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0015\u0012>\u0012<\u0012\u0004\u0012\u00020\u0017\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0002\b\u0018¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0019¢\u0006\u0002\b\u001a\u0012\u0004\u0012\u00020\u00010\u0013j\u0002`\u001b¢\u0006\u0002\b\u00182 \b\u0002\u0010\u0015\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00040\u001c\u0012\u0004\u0012\u00020\u00030\t2L\u0010\u0019\u001aH\u0012\u0004\u0012\u00020\u0017\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u0011H\u0004¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00010\u0013¢\u0006\u0002\b\u0018¢\u0006\u0002\b\u001aH\u0007¢\u0006\u0002\u0010 \u001aí\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u00032\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00040\u00072!\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00010\t2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u0094\u0001\b\u0002\u0010\u0012\u001a\u008d\u0001\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0014\u0012.\u0012,\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00030\t¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0015\u0012>\u0012<\u0012\u0004\u0012\u00020\u0017\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0002\b\u0018¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0019¢\u0006\u0002\b\u001a\u0012\u0004\u0012\u00020\u00010\u0013j\u0002`\u001b¢\u0006\u0002\b\u00182 \b\u0002\u0010\u0015\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00040\u001c\u0012\u0004\u0012\u00020\u00030\t2F\u0010\u0019\u001aB\u0012\u0004\u0012\u00020\u0017\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u0011H\u0004¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u00010\u001d¢\u0006\u0002\b\u0018¢\u0006\u0002\b\u001aH\u0007¢\u0006\u0002\u0010!\u001aó\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u00032\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00040\u00072!\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00010\t2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u0094\u0001\b\u0002\u0010\u0012\u001a\u008d\u0001\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0014\u0012.\u0012,\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00030\t¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0015\u0012>\u0012<\u0012\u0004\u0012\u00020\u0017\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0002\b\u0018¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0019¢\u0006\u0002\b\u001a\u0012\u0004\u0012\u00020\u00010\u0013j\u0002`\u001b¢\u0006\u0002\b\u00182 \b\u0002\u0010\u0015\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00040\u001c\u0012\u0004\u0012\u00020\u00030\t2L\u0010\u0019\u001aH\u0012\u0004\u0012\u00020\u0017\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u0011H\u0004¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00010\u0013¢\u0006\u0002\b\u0018¢\u0006\u0002\b\u001aH\u0007¢\u0006\u0002\u0010\"\u001a\u0097\u0001\u0010#\u001a\u008d\u0001\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0014\u0012.\u0012,\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00030\t¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0015\u0012>\u0012<\u0012\u0004\u0012\u00020\u0017\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0002\b\u0018¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0019¢\u0006\u0002\b\u001a\u0012\u0004\u0012\u00020\u00010\u0013j\u0002`\u001b¢\u0006\u0002\b\u0018¢\u0006\u0002\u0010$\u001a\u0097\u0001\u0010%\u001a\u008d\u0001\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0014\u0012.\u0012,\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00030\t¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0015\u0012>\u0012<\u0012\u0004\u0012\u00020\u0017\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0002\b\u0018¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0019¢\u0006\u0002\b\u001a\u0012\u0004\u0012\u00020\u00010\u0013j\u0002`\u001b¢\u0006\u0002\b\u0018¢\u0006\u0002\u0010$*\u009a\u0002\u0010&\"\u0089\u0001\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0014\u0012.\u0012,\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00030\t¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0015\u0012>\u0012<\u0012\u0004\u0012\u00020\u0017\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0002\b\u0018¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0019¢\u0006\u0002\b\u001a\u0012\u0004\u0012\u00020\u00010\u0013¢\u0006\u0002\b\u00182\u0089\u0001\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0014\u0012.\u0012,\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00030\t¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0015\u0012>\u0012<\u0012\u0004\u0012\u00020\u0017\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0002\b\u0018¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0019¢\u0006\u0002\b\u001a\u0012\u0004\u0012\u00020\u00010\u0013¢\u0006\u0002\b\u0018¨\u0006'²\u0006*\u0010(\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00040\u0007\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0003X\u008a\u0084\u0002"}, d2 = {"ChildPages", "", "C", "", ExifInterface.GPS_DIRECTION_TRUE, "pages", "Lcom/arkivanov/decompose/value/Value;", "Lcom/arkivanov/decompose/router/pages/ChildPages;", "onPageSelected", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", FirebaseAnalytics.Param.INDEX, "modifier", "Landroidx/compose/ui/Modifier;", "scrollAnimation", "Lcom/arkivanov/decompose/extensions/compose/pages/PagesScrollAnimation;", "pager", "Lkotlin/Function4;", "Landroidx/compose/foundation/pager/PagerState;", "key", "Lkotlin/Function2;", "Landroidx/compose/foundation/pager/PagerScope;", "Landroidx/compose/runtime/Composable;", "pageContent", "Lkotlin/ExtensionFunctionType;", "Lcom/arkivanov/decompose/extensions/compose/pages/ChildPagesPager;", "Lcom/arkivanov/decompose/Child;", "Lkotlin/Function3;", "page", "(Lcom/arkivanov/decompose/value/Value;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Lcom/arkivanov/decompose/extensions/compose/pages/PagesScrollAnimation;Lkotlin/jvm/functions/Function6;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function5;Landroidx/compose/runtime/Composer;II)V", "(Lcom/arkivanov/decompose/value/Value;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Lcom/arkivanov/decompose/extensions/compose/pages/PagesScrollAnimation;Lkotlin/jvm/functions/Function6;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function6;Landroidx/compose/runtime/Composer;II)V", "(Lcom/arkivanov/decompose/router/pages/ChildPages;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Lcom/arkivanov/decompose/extensions/compose/pages/PagesScrollAnimation;Lkotlin/jvm/functions/Function6;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function5;Landroidx/compose/runtime/Composer;II)V", "(Lcom/arkivanov/decompose/router/pages/ChildPages;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Lcom/arkivanov/decompose/extensions/compose/pages/PagesScrollAnimation;Lkotlin/jvm/functions/Function6;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function6;Landroidx/compose/runtime/Composer;II)V", "defaultHorizontalPager", "()Lkotlin/jvm/functions/Function6;", "defaultVerticalPager", "ChildPagesPager", "extensions-compose_release", RemoteConfigConstants.ResponseFieldKey.STATE}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ChildPagesKt {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ChildPages$lambda$0(Value value, Function1 function1, Modifier modifier, PagesScrollAnimation pagesScrollAnimation, Function6 function6, Function1 function12, Function5 function5, int i, int i2, Composer composer, int i3) {
        ChildPages(value, function1, modifier, pagesScrollAnimation, function6, function12, function5, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ChildPages$lambda$12(ChildPages childPages, Function1 function1, Modifier modifier, PagesScrollAnimation pagesScrollAnimation, Function6 function6, Function1 function12, Function6 function62, int i, int i2, Composer composer, int i3) {
        ChildPages(childPages, function1, modifier, pagesScrollAnimation, function6, function12, function62, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ChildPages$lambda$2(Value value, Function1 function1, Modifier modifier, PagesScrollAnimation pagesScrollAnimation, Function6 function6, Function1 function12, Function6 function62, int i, int i2, Composer composer, int i3) {
        ChildPages(value, function1, modifier, pagesScrollAnimation, function6, function12, function62, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ChildPages$lambda$3(ChildPages childPages, Function1 function1, Modifier modifier, PagesScrollAnimation pagesScrollAnimation, Function6 function6, Function1 function12, Function5 function5, int i, int i2, Composer composer, int i3) {
        ChildPages(childPages, function1, modifier, pagesScrollAnimation, function6, function12, function5, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final Function6<Modifier, PagerState, Function1<? super Integer, ? extends Object>, Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit>, Composer, Integer, Unit> defaultHorizontalPager() {
        return ComposableSingletons$ChildPagesKt.INSTANCE.m9474getLambda1$extensions_compose_release();
    }

    public static final Function6<Modifier, PagerState, Function1<? super Integer, ? extends Object>, Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit>, Composer, Integer, Unit> defaultVerticalPager() {
        return ComposableSingletons$ChildPagesKt.INSTANCE.m9475getLambda2$extensions_compose_release();
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:118:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x011e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <C, T> void ChildPages(final Value<? extends ChildPages<? extends C, ? extends T>> pages, final Function1<? super Integer, Unit> onPageSelected, Modifier modifier, PagesScrollAnimation pagesScrollAnimation, Function6<? super Modifier, ? super PagerState, ? super Function1<? super Integer, ? extends Object>, ? super Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function6, Function1<? super Child<? extends C, ? extends T>, ? extends Object> function1, final Function5<? super PagerScope, ? super Integer, ? super T, ? super Composer, ? super Integer, Unit> pageContent, Composer composer, final int i, final int i2) {
        int i3;
        Modifier.Companion companion;
        int i4;
        Function6<Modifier, PagerState, Function1<? super Integer, ? extends Object>, Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit>, Composer, Integer, Unit> function62;
        Object obj;
        ChildPagesKt$ChildPages$1 childPagesKt$ChildPages$1;
        Object obj2;
        Modifier modifier2;
        int i5;
        final Function1<? super Child<? extends C, ? extends T>, ? extends Object> function12;
        final Function6<? super Modifier, ? super PagerState, ? super Function1<? super Integer, ? extends Object>, ? super Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function63;
        final PagesScrollAnimation pagesScrollAnimation2;
        final Modifier modifier3;
        ScopeUpdateScope endRestartGroup;
        int i6;
        int i7;
        PagesScrollAnimation.Disabled disabled = pagesScrollAnimation;
        Intrinsics.checkNotNullParameter(pages, "pages");
        Intrinsics.checkNotNullParameter(onPageSelected, "onPageSelected");
        Intrinsics.checkNotNullParameter(pageContent, "pageContent");
        Composer startRestartGroup = composer.startRestartGroup(-1455675035);
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changedInstance(pages) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= startRestartGroup.changedInstance(onPageSelected) ? 32 : 16;
        }
        int i8 = i2 & 4;
        if (i8 != 0) {
            i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            companion = modifier;
            i3 |= startRestartGroup.changed(companion) ? 256 : 128;
            i4 = i2 & 8;
            if (i4 == 0) {
                i3 |= 3072;
            } else if ((i & 3072) == 0) {
                i3 |= (i & 4096) == 0 ? startRestartGroup.changed(disabled) : startRestartGroup.changedInstance(disabled) ? 2048 : 1024;
            }
            if ((i & 24576) != 0) {
                if ((i2 & 16) == 0) {
                    function62 = function6;
                    if (startRestartGroup.changedInstance(function62)) {
                        i7 = 16384;
                        i3 |= i7;
                    }
                } else {
                    function62 = function6;
                }
                i7 = 8192;
                i3 |= i7;
            } else {
                function62 = function6;
            }
            if ((196608 & i) != 0) {
                if ((i2 & 32) == 0) {
                    obj = function1;
                    if (startRestartGroup.changedInstance(obj)) {
                        i6 = 131072;
                        i3 |= i6;
                    }
                } else {
                    obj = function1;
                }
                i6 = 65536;
                i3 |= i6;
            } else {
                obj = function1;
            }
            if ((i2 & 64) == 0) {
                i3 |= 1572864;
            } else if ((i & 1572864) == 0) {
                i3 |= startRestartGroup.changedInstance(pageContent) ? 1048576 : 524288;
            }
            if ((599187 & i3) == 599186 || !startRestartGroup.getSkipping()) {
                startRestartGroup.startDefaults();
                if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                    if (i8 != 0) {
                        companion = Modifier.Companion;
                    }
                    if (i4 != 0) {
                        disabled = PagesScrollAnimation.Disabled.INSTANCE;
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        function62 = defaultHorizontalPager();
                    }
                    if ((i2 & 32) != 0) {
                        childPagesKt$ChildPages$1 = new PropertyReference1Impl() { // from class: com.arkivanov.decompose.extensions.compose.pages.ChildPagesKt$ChildPages$1
                            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                            public Object get(Object obj3) {
                                return ((Child) obj3).getKey();
                            }
                        };
                        int i9 = i3 & (-458753);
                        obj2 = disabled;
                        modifier2 = companion;
                        i5 = i9;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1455675035, i5, -1, "com.arkivanov.decompose.extensions.compose.pages.ChildPages (ChildPages.kt:43)");
                        }
                        PagesScrollAnimation pagesScrollAnimation3 = obj2;
                        Function6<? super Modifier, ? super PagerState, ? super Function1<? super Integer, ? extends Object>, ? super Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function64 = function62;
                        ChildPages((Value) pages, onPageSelected, modifier2, pagesScrollAnimation3, function64, (Function1) childPagesKt$ChildPages$1, (Function6) ComposableLambdaKt.rememberComposableLambda(1392546492, true, new Function6<PagerScope, Integer, T, PagerState, Composer, Integer, Unit>() { // from class: com.arkivanov.decompose.extensions.compose.pages.ChildPagesKt$ChildPages$2
                            /* JADX WARN: Multi-variable type inference failed */
                            @Override // kotlin.jvm.functions.Function6
                            public /* bridge */ /* synthetic */ Unit invoke(PagerScope pagerScope, Integer num, Object obj3, PagerState pagerState, Composer composer2, Integer num2) {
                                invoke(pagerScope, num.intValue(), (int) obj3, pagerState, composer2, num2.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(PagerScope ChildPages, int i10, T page, PagerState unused$var$, Composer composer2, int i11) {
                                Intrinsics.checkNotNullParameter(ChildPages, "$this$ChildPages");
                                Intrinsics.checkNotNullParameter(page, "page");
                                Intrinsics.checkNotNullParameter(unused$var$, "$unused$var$");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1392546492, i11, -1, "com.arkivanov.decompose.extensions.compose.pages.ChildPages.<anonymous> (ChildPages.kt:51)");
                                }
                                pageContent.invoke(ChildPages, Integer.valueOf(i10), page, composer2, Integer.valueOf(i11 & AnalyticsListener.EVENT_DRM_SESSION_ACQUIRED));
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, startRestartGroup, 54), startRestartGroup, (i5 & 14) | 1572864 | (i5 & 112) | (i5 & 896) | (i5 & 7168) | (57344 & i5) | (i5 & 458752), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        function12 = childPagesKt$ChildPages$1;
                        function63 = function64;
                        pagesScrollAnimation2 = pagesScrollAnimation3;
                        modifier3 = modifier2;
                    }
                } else {
                    startRestartGroup.skipToGroupEnd();
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                    }
                }
                int i10 = i3;
                obj2 = disabled;
                modifier2 = companion;
                i5 = i10;
                childPagesKt$ChildPages$1 = obj;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                PagesScrollAnimation pagesScrollAnimation32 = obj2;
                Function6<? super Modifier, ? super PagerState, ? super Function1<? super Integer, ? extends Object>, ? super Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function642 = function62;
                ChildPages((Value) pages, onPageSelected, modifier2, pagesScrollAnimation32, function642, (Function1) childPagesKt$ChildPages$1, (Function6) ComposableLambdaKt.rememberComposableLambda(1392546492, true, new Function6<PagerScope, Integer, T, PagerState, Composer, Integer, Unit>() { // from class: com.arkivanov.decompose.extensions.compose.pages.ChildPagesKt$ChildPages$2
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // kotlin.jvm.functions.Function6
                    public /* bridge */ /* synthetic */ Unit invoke(PagerScope pagerScope, Integer num, Object obj3, PagerState pagerState, Composer composer2, Integer num2) {
                        invoke(pagerScope, num.intValue(), (int) obj3, pagerState, composer2, num2.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(PagerScope ChildPages, int i102, T page, PagerState unused$var$, Composer composer2, int i11) {
                        Intrinsics.checkNotNullParameter(ChildPages, "$this$ChildPages");
                        Intrinsics.checkNotNullParameter(page, "page");
                        Intrinsics.checkNotNullParameter(unused$var$, "$unused$var$");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1392546492, i11, -1, "com.arkivanov.decompose.extensions.compose.pages.ChildPages.<anonymous> (ChildPages.kt:51)");
                        }
                        pageContent.invoke(ChildPages, Integer.valueOf(i102), page, composer2, Integer.valueOf(i11 & AnalyticsListener.EVENT_DRM_SESSION_ACQUIRED));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, startRestartGroup, 54), startRestartGroup, (i5 & 14) | 1572864 | (i5 & 112) | (i5 & 896) | (i5 & 7168) | (57344 & i5) | (i5 & 458752), 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                function12 = childPagesKt$ChildPages$1;
                function63 = function642;
                pagesScrollAnimation2 = pagesScrollAnimation32;
                modifier3 = modifier2;
            } else {
                startRestartGroup.skipToGroupEnd();
                pagesScrollAnimation2 = disabled;
                modifier3 = companion;
                function63 = function62;
                function12 = obj;
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
                endRestartGroup.updateScope(new Function2() { // from class: com.arkivanov.decompose.extensions.compose.pages.ChildPagesKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj3, Object obj4) {
                        return ChildPagesKt.ChildPages$lambda$0(Value.this, onPageSelected, modifier3, pagesScrollAnimation2, function63, function12, pageContent, i, i2, (Composer) obj3, ((Integer) obj4).intValue());
                    }
                });
                return;
            }
            return;
        }
        companion = modifier;
        i4 = i2 & 8;
        if (i4 == 0) {
        }
        if ((i & 24576) != 0) {
        }
        if ((196608 & i) != 0) {
        }
        if ((i2 & 64) == 0) {
        }
        if ((599187 & i3) == 599186) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i8 != 0) {
        }
        if (i4 != 0) {
        }
        if ((i2 & 16) != 0) {
        }
        if ((i2 & 32) != 0) {
        }
        int i102 = i3;
        obj2 = disabled;
        modifier2 = companion;
        i5 = i102;
        childPagesKt$ChildPages$1 = obj;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        PagesScrollAnimation pagesScrollAnimation322 = obj2;
        Function6<? super Modifier, ? super PagerState, ? super Function1<? super Integer, ? extends Object>, ? super Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function6422 = function62;
        ChildPages((Value) pages, onPageSelected, modifier2, pagesScrollAnimation322, function6422, (Function1) childPagesKt$ChildPages$1, (Function6) ComposableLambdaKt.rememberComposableLambda(1392546492, true, new Function6<PagerScope, Integer, T, PagerState, Composer, Integer, Unit>() { // from class: com.arkivanov.decompose.extensions.compose.pages.ChildPagesKt$ChildPages$2
            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function6
            public /* bridge */ /* synthetic */ Unit invoke(PagerScope pagerScope, Integer num, Object obj3, PagerState pagerState, Composer composer2, Integer num2) {
                invoke(pagerScope, num.intValue(), (int) obj3, pagerState, composer2, num2.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(PagerScope ChildPages, int i1022, T page, PagerState unused$var$, Composer composer2, int i11) {
                Intrinsics.checkNotNullParameter(ChildPages, "$this$ChildPages");
                Intrinsics.checkNotNullParameter(page, "page");
                Intrinsics.checkNotNullParameter(unused$var$, "$unused$var$");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1392546492, i11, -1, "com.arkivanov.decompose.extensions.compose.pages.ChildPages.<anonymous> (ChildPages.kt:51)");
                }
                pageContent.invoke(ChildPages, Integer.valueOf(i1022), page, composer2, Integer.valueOf(i11 & AnalyticsListener.EVENT_DRM_SESSION_ACQUIRED));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }, startRestartGroup, 54), startRestartGroup, (i5 & 14) | 1572864 | (i5 & 112) | (i5 & 896) | (i5 & 7168) | (57344 & i5) | (i5 & 458752), 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        function12 = childPagesKt$ChildPages$1;
        function63 = function6422;
        pagesScrollAnimation2 = pagesScrollAnimation322;
        modifier3 = modifier2;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:118:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x011d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <C, T> void ChildPages(final Value<? extends ChildPages<? extends C, ? extends T>> pages, final Function1<? super Integer, Unit> onPageSelected, Modifier modifier, PagesScrollAnimation pagesScrollAnimation, Function6<? super Modifier, ? super PagerState, ? super Function1<? super Integer, ? extends Object>, ? super Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function6, Function1<? super Child<? extends C, ? extends T>, ? extends Object> function1, final Function6<? super PagerScope, ? super Integer, ? super T, ? super PagerState, ? super Composer, ? super Integer, Unit> pageContent, Composer composer, final int i, final int i2) {
        int i3;
        Modifier.Companion companion;
        int i4;
        Function6<Modifier, PagerState, Function1<? super Integer, ? extends Object>, Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit>, Composer, Integer, Unit> function62;
        Object obj;
        ChildPagesKt$ChildPages$4 childPagesKt$ChildPages$4;
        PagesScrollAnimation pagesScrollAnimation2;
        int i5;
        Modifier modifier2;
        Function6<? super Modifier, ? super PagerState, ? super Function1<? super Integer, ? extends Object>, ? super Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function63;
        final Modifier modifier3;
        final PagesScrollAnimation pagesScrollAnimation3;
        final Function6<? super Modifier, ? super PagerState, ? super Function1<? super Integer, ? extends Object>, ? super Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function64;
        final Function1<? super Child<? extends C, ? extends T>, ? extends Object> function12;
        ScopeUpdateScope endRestartGroup;
        int i6;
        int i7;
        PagesScrollAnimation.Disabled disabled = pagesScrollAnimation;
        Intrinsics.checkNotNullParameter(pages, "pages");
        Intrinsics.checkNotNullParameter(onPageSelected, "onPageSelected");
        Intrinsics.checkNotNullParameter(pageContent, "pageContent");
        Composer startRestartGroup = composer.startRestartGroup(-1036158204);
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changedInstance(pages) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= startRestartGroup.changedInstance(onPageSelected) ? 32 : 16;
        }
        int i8 = i2 & 4;
        if (i8 != 0) {
            i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            companion = modifier;
            i3 |= startRestartGroup.changed(companion) ? 256 : 128;
            i4 = i2 & 8;
            if (i4 == 0) {
                i3 |= 3072;
            } else if ((i & 3072) == 0) {
                i3 |= (i & 4096) == 0 ? startRestartGroup.changed(disabled) : startRestartGroup.changedInstance(disabled) ? 2048 : 1024;
            }
            if ((i & 24576) != 0) {
                if ((i2 & 16) == 0) {
                    function62 = function6;
                    if (startRestartGroup.changedInstance(function62)) {
                        i7 = 16384;
                        i3 |= i7;
                    }
                } else {
                    function62 = function6;
                }
                i7 = 8192;
                i3 |= i7;
            } else {
                function62 = function6;
            }
            if ((196608 & i) != 0) {
                if ((i2 & 32) == 0) {
                    obj = function1;
                    if (startRestartGroup.changedInstance(obj)) {
                        i6 = 131072;
                        i3 |= i6;
                    }
                } else {
                    obj = function1;
                }
                i6 = 65536;
                i3 |= i6;
            } else {
                obj = function1;
            }
            if ((i2 & 64) == 0) {
                i3 |= 1572864;
            } else if ((i & 1572864) == 0) {
                i3 |= startRestartGroup.changedInstance(pageContent) ? 1048576 : 524288;
            }
            if ((599187 & i3) == 599186 || !startRestartGroup.getSkipping()) {
                startRestartGroup.startDefaults();
                if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                    if (i8 != 0) {
                        companion = Modifier.Companion;
                    }
                    if (i4 != 0) {
                        disabled = PagesScrollAnimation.Disabled.INSTANCE;
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        function62 = defaultHorizontalPager();
                    }
                    if ((i2 & 32) != 0) {
                        childPagesKt$ChildPages$4 = new PropertyReference1Impl() { // from class: com.arkivanov.decompose.extensions.compose.pages.ChildPagesKt$ChildPages$4
                            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                            public Object get(Object obj2) {
                                return ((Child) obj2).getKey();
                            }
                        };
                        pagesScrollAnimation2 = disabled;
                        i5 = i3 & (-458753);
                        modifier2 = companion;
                        function63 = function62;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1036158204, i5, -1, "com.arkivanov.decompose.extensions.compose.pages.ChildPages (ChildPages.kt:79)");
                        }
                        ChildPages(ChildPages$lambda$1(SubscribeAsStateKt.subscribeAsState(pages, null, startRestartGroup, i5 & 14, 1)), onPageSelected, modifier2, pagesScrollAnimation2, function63, childPagesKt$ChildPages$4, pageContent, startRestartGroup, i5 & 4194288, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                        pagesScrollAnimation3 = pagesScrollAnimation2;
                        function64 = function63;
                        function12 = childPagesKt$ChildPages$4;
                    }
                } else {
                    startRestartGroup.skipToGroupEnd();
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                    }
                }
                pagesScrollAnimation2 = disabled;
                i5 = i3;
                modifier2 = companion;
                function63 = function62;
                childPagesKt$ChildPages$4 = obj;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                ChildPages(ChildPages$lambda$1(SubscribeAsStateKt.subscribeAsState(pages, null, startRestartGroup, i5 & 14, 1)), onPageSelected, modifier2, pagesScrollAnimation2, function63, childPagesKt$ChildPages$4, pageContent, startRestartGroup, i5 & 4194288, 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier3 = modifier2;
                pagesScrollAnimation3 = pagesScrollAnimation2;
                function64 = function63;
                function12 = childPagesKt$ChildPages$4;
            } else {
                startRestartGroup.skipToGroupEnd();
                pagesScrollAnimation3 = disabled;
                modifier3 = companion;
                function64 = function62;
                function12 = obj;
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
                endRestartGroup.updateScope(new Function2() { // from class: com.arkivanov.decompose.extensions.compose.pages.ChildPagesKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj2, Object obj3) {
                        return ChildPagesKt.ChildPages$lambda$2(Value.this, onPageSelected, modifier3, pagesScrollAnimation3, function64, function12, pageContent, i, i2, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                });
                return;
            }
            return;
        }
        companion = modifier;
        i4 = i2 & 8;
        if (i4 == 0) {
        }
        if ((i & 24576) != 0) {
        }
        if ((196608 & i) != 0) {
        }
        if ((i2 & 64) == 0) {
        }
        if ((599187 & i3) == 599186) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i8 != 0) {
        }
        if (i4 != 0) {
        }
        if ((i2 & 16) != 0) {
        }
        if ((i2 & 32) != 0) {
        }
        pagesScrollAnimation2 = disabled;
        i5 = i3;
        modifier2 = companion;
        function63 = function62;
        childPagesKt$ChildPages$4 = obj;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        ChildPages(ChildPages$lambda$1(SubscribeAsStateKt.subscribeAsState(pages, null, startRestartGroup, i5 & 14, 1)), onPageSelected, modifier2, pagesScrollAnimation2, function63, childPagesKt$ChildPages$4, pageContent, startRestartGroup, i5 & 4194288, 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier3 = modifier2;
        pagesScrollAnimation3 = pagesScrollAnimation2;
        function64 = function63;
        function12 = childPagesKt$ChildPages$4;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:118:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x011e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <C, T> void ChildPages(final ChildPages<? extends C, ? extends T> pages, final Function1<? super Integer, Unit> onPageSelected, Modifier modifier, PagesScrollAnimation pagesScrollAnimation, Function6<? super Modifier, ? super PagerState, ? super Function1<? super Integer, ? extends Object>, ? super Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function6, Function1<? super Child<? extends C, ? extends T>, ? extends Object> function1, final Function5<? super PagerScope, ? super Integer, ? super T, ? super Composer, ? super Integer, Unit> pageContent, Composer composer, final int i, final int i2) {
        int i3;
        Modifier.Companion companion;
        int i4;
        Function6<Modifier, PagerState, Function1<? super Integer, ? extends Object>, Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit>, Composer, Integer, Unit> function62;
        Object obj;
        ChildPagesKt$ChildPages$6 childPagesKt$ChildPages$6;
        Object obj2;
        Modifier modifier2;
        int i5;
        final Function1<? super Child<? extends C, ? extends T>, ? extends Object> function12;
        final Function6<? super Modifier, ? super PagerState, ? super Function1<? super Integer, ? extends Object>, ? super Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function63;
        final PagesScrollAnimation pagesScrollAnimation2;
        final Modifier modifier3;
        ScopeUpdateScope endRestartGroup;
        int i6;
        int i7;
        PagesScrollAnimation.Disabled disabled = pagesScrollAnimation;
        Intrinsics.checkNotNullParameter(pages, "pages");
        Intrinsics.checkNotNullParameter(onPageSelected, "onPageSelected");
        Intrinsics.checkNotNullParameter(pageContent, "pageContent");
        Composer startRestartGroup = composer.startRestartGroup(123234442);
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changedInstance(pages) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= startRestartGroup.changedInstance(onPageSelected) ? 32 : 16;
        }
        int i8 = i2 & 4;
        if (i8 != 0) {
            i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            companion = modifier;
            i3 |= startRestartGroup.changed(companion) ? 256 : 128;
            i4 = i2 & 8;
            if (i4 == 0) {
                i3 |= 3072;
            } else if ((i & 3072) == 0) {
                i3 |= (i & 4096) == 0 ? startRestartGroup.changed(disabled) : startRestartGroup.changedInstance(disabled) ? 2048 : 1024;
            }
            if ((i & 24576) != 0) {
                if ((i2 & 16) == 0) {
                    function62 = function6;
                    if (startRestartGroup.changedInstance(function62)) {
                        i7 = 16384;
                        i3 |= i7;
                    }
                } else {
                    function62 = function6;
                }
                i7 = 8192;
                i3 |= i7;
            } else {
                function62 = function6;
            }
            if ((196608 & i) != 0) {
                if ((i2 & 32) == 0) {
                    obj = function1;
                    if (startRestartGroup.changedInstance(obj)) {
                        i6 = 131072;
                        i3 |= i6;
                    }
                } else {
                    obj = function1;
                }
                i6 = 65536;
                i3 |= i6;
            } else {
                obj = function1;
            }
            if ((i2 & 64) == 0) {
                i3 |= 1572864;
            } else if ((i & 1572864) == 0) {
                i3 |= startRestartGroup.changedInstance(pageContent) ? 1048576 : 524288;
            }
            if ((599187 & i3) == 599186 || !startRestartGroup.getSkipping()) {
                startRestartGroup.startDefaults();
                if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                    if (i8 != 0) {
                        companion = Modifier.Companion;
                    }
                    if (i4 != 0) {
                        disabled = PagesScrollAnimation.Disabled.INSTANCE;
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        function62 = defaultHorizontalPager();
                    }
                    if ((i2 & 32) != 0) {
                        childPagesKt$ChildPages$6 = new PropertyReference1Impl() { // from class: com.arkivanov.decompose.extensions.compose.pages.ChildPagesKt$ChildPages$6
                            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                            public Object get(Object obj3) {
                                return ((Child) obj3).getKey();
                            }
                        };
                        int i9 = i3 & (-458753);
                        obj2 = disabled;
                        modifier2 = companion;
                        i5 = i9;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(123234442, i5, -1, "com.arkivanov.decompose.extensions.compose.pages.ChildPages (ChildPages.kt:116)");
                        }
                        PagesScrollAnimation pagesScrollAnimation3 = obj2;
                        Function6<? super Modifier, ? super PagerState, ? super Function1<? super Integer, ? extends Object>, ? super Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function64 = function62;
                        ChildPages((ChildPages) pages, onPageSelected, modifier2, pagesScrollAnimation3, function64, (Function1) childPagesKt$ChildPages$6, (Function6) ComposableLambdaKt.rememberComposableLambda(-1721549421, true, new Function6<PagerScope, Integer, T, PagerState, Composer, Integer, Unit>() { // from class: com.arkivanov.decompose.extensions.compose.pages.ChildPagesKt$ChildPages$7
                            /* JADX WARN: Multi-variable type inference failed */
                            @Override // kotlin.jvm.functions.Function6
                            public /* bridge */ /* synthetic */ Unit invoke(PagerScope pagerScope, Integer num, Object obj3, PagerState pagerState, Composer composer2, Integer num2) {
                                invoke(pagerScope, num.intValue(), (int) obj3, pagerState, composer2, num2.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(PagerScope ChildPages, int i10, T page, PagerState unused$var$, Composer composer2, int i11) {
                                Intrinsics.checkNotNullParameter(ChildPages, "$this$ChildPages");
                                Intrinsics.checkNotNullParameter(page, "page");
                                Intrinsics.checkNotNullParameter(unused$var$, "$unused$var$");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1721549421, i11, -1, "com.arkivanov.decompose.extensions.compose.pages.ChildPages.<anonymous> (ChildPages.kt:124)");
                                }
                                pageContent.invoke(ChildPages, Integer.valueOf(i10), page, composer2, Integer.valueOf(i11 & AnalyticsListener.EVENT_DRM_SESSION_ACQUIRED));
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, startRestartGroup, 54), startRestartGroup, (i5 & 14) | 1572864 | (i5 & 112) | (i5 & 896) | (i5 & 7168) | (57344 & i5) | (i5 & 458752), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        function12 = childPagesKt$ChildPages$6;
                        function63 = function64;
                        pagesScrollAnimation2 = pagesScrollAnimation3;
                        modifier3 = modifier2;
                    }
                } else {
                    startRestartGroup.skipToGroupEnd();
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                    }
                }
                int i10 = i3;
                obj2 = disabled;
                modifier2 = companion;
                i5 = i10;
                childPagesKt$ChildPages$6 = obj;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                PagesScrollAnimation pagesScrollAnimation32 = obj2;
                Function6<? super Modifier, ? super PagerState, ? super Function1<? super Integer, ? extends Object>, ? super Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function642 = function62;
                ChildPages((ChildPages) pages, onPageSelected, modifier2, pagesScrollAnimation32, function642, (Function1) childPagesKt$ChildPages$6, (Function6) ComposableLambdaKt.rememberComposableLambda(-1721549421, true, new Function6<PagerScope, Integer, T, PagerState, Composer, Integer, Unit>() { // from class: com.arkivanov.decompose.extensions.compose.pages.ChildPagesKt$ChildPages$7
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // kotlin.jvm.functions.Function6
                    public /* bridge */ /* synthetic */ Unit invoke(PagerScope pagerScope, Integer num, Object obj3, PagerState pagerState, Composer composer2, Integer num2) {
                        invoke(pagerScope, num.intValue(), (int) obj3, pagerState, composer2, num2.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(PagerScope ChildPages, int i102, T page, PagerState unused$var$, Composer composer2, int i11) {
                        Intrinsics.checkNotNullParameter(ChildPages, "$this$ChildPages");
                        Intrinsics.checkNotNullParameter(page, "page");
                        Intrinsics.checkNotNullParameter(unused$var$, "$unused$var$");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1721549421, i11, -1, "com.arkivanov.decompose.extensions.compose.pages.ChildPages.<anonymous> (ChildPages.kt:124)");
                        }
                        pageContent.invoke(ChildPages, Integer.valueOf(i102), page, composer2, Integer.valueOf(i11 & AnalyticsListener.EVENT_DRM_SESSION_ACQUIRED));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, startRestartGroup, 54), startRestartGroup, (i5 & 14) | 1572864 | (i5 & 112) | (i5 & 896) | (i5 & 7168) | (57344 & i5) | (i5 & 458752), 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                function12 = childPagesKt$ChildPages$6;
                function63 = function642;
                pagesScrollAnimation2 = pagesScrollAnimation32;
                modifier3 = modifier2;
            } else {
                startRestartGroup.skipToGroupEnd();
                pagesScrollAnimation2 = disabled;
                modifier3 = companion;
                function63 = function62;
                function12 = obj;
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
                endRestartGroup.updateScope(new Function2() { // from class: com.arkivanov.decompose.extensions.compose.pages.ChildPagesKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj3, Object obj4) {
                        return ChildPagesKt.ChildPages$lambda$3(ChildPages.this, onPageSelected, modifier3, pagesScrollAnimation2, function63, function12, pageContent, i, i2, (Composer) obj3, ((Integer) obj4).intValue());
                    }
                });
                return;
            }
            return;
        }
        companion = modifier;
        i4 = i2 & 8;
        if (i4 == 0) {
        }
        if ((i & 24576) != 0) {
        }
        if ((196608 & i) != 0) {
        }
        if ((i2 & 64) == 0) {
        }
        if ((599187 & i3) == 599186) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i8 != 0) {
        }
        if (i4 != 0) {
        }
        if ((i2 & 16) != 0) {
        }
        if ((i2 & 32) != 0) {
        }
        int i102 = i3;
        obj2 = disabled;
        modifier2 = companion;
        i5 = i102;
        childPagesKt$ChildPages$6 = obj;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        PagesScrollAnimation pagesScrollAnimation322 = obj2;
        Function6<? super Modifier, ? super PagerState, ? super Function1<? super Integer, ? extends Object>, ? super Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function6422 = function62;
        ChildPages((ChildPages) pages, onPageSelected, modifier2, pagesScrollAnimation322, function6422, (Function1) childPagesKt$ChildPages$6, (Function6) ComposableLambdaKt.rememberComposableLambda(-1721549421, true, new Function6<PagerScope, Integer, T, PagerState, Composer, Integer, Unit>() { // from class: com.arkivanov.decompose.extensions.compose.pages.ChildPagesKt$ChildPages$7
            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function6
            public /* bridge */ /* synthetic */ Unit invoke(PagerScope pagerScope, Integer num, Object obj3, PagerState pagerState, Composer composer2, Integer num2) {
                invoke(pagerScope, num.intValue(), (int) obj3, pagerState, composer2, num2.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(PagerScope ChildPages, int i1022, T page, PagerState unused$var$, Composer composer2, int i11) {
                Intrinsics.checkNotNullParameter(ChildPages, "$this$ChildPages");
                Intrinsics.checkNotNullParameter(page, "page");
                Intrinsics.checkNotNullParameter(unused$var$, "$unused$var$");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1721549421, i11, -1, "com.arkivanov.decompose.extensions.compose.pages.ChildPages.<anonymous> (ChildPages.kt:124)");
                }
                pageContent.invoke(ChildPages, Integer.valueOf(i1022), page, composer2, Integer.valueOf(i11 & AnalyticsListener.EVENT_DRM_SESSION_ACQUIRED));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }, startRestartGroup, 54), startRestartGroup, (i5 & 14) | 1572864 | (i5 & 112) | (i5 & 896) | (i5 & 7168) | (57344 & i5) | (i5 & 458752), 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        function12 = childPagesKt$ChildPages$6;
        function63 = function6422;
        pagesScrollAnimation2 = pagesScrollAnimation322;
        modifier3 = modifier2;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x01fb  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x01fd  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0242  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0281  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0127  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <C, T> void ChildPages(final ChildPages<? extends C, ? extends T> pages, final Function1<? super Integer, Unit> onPageSelected, Modifier modifier, PagesScrollAnimation pagesScrollAnimation, Function6<? super Modifier, ? super PagerState, ? super Function1<? super Integer, ? extends Object>, ? super Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function6, Function1<? super Child<? extends C, ? extends T>, ? extends Object> function1, final Function6<? super PagerScope, ? super Integer, ? super T, ? super PagerState, ? super Composer, ? super Integer, Unit> pageContent, Composer composer, final int i, final int i2) {
        int i3;
        Object obj;
        int i4;
        Object obj2;
        Object obj3;
        Object obj4;
        int i5;
        final ChildPagesKt$ChildPages$9 childPagesKt$ChildPages$9;
        int coerceAtLeast;
        Object rememberedValue;
        boolean changed;
        ChildPagesKt$ChildPages$10$1 rememberedValue2;
        boolean z;
        Object rememberedValue3;
        boolean changedInstance;
        Object rememberedValue4;
        final Function1<? super Child<? extends C, ? extends T>, ? extends Object> function12;
        final Function6<? super Modifier, ? super PagerState, ? super Function1<? super Integer, ? extends Object>, ? super Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function62;
        final Modifier modifier2;
        final PagesScrollAnimation pagesScrollAnimation2;
        int i6;
        PagesScrollAnimation.Disabled disabled = pagesScrollAnimation;
        Intrinsics.checkNotNullParameter(pages, "pages");
        Intrinsics.checkNotNullParameter(onPageSelected, "onPageSelected");
        Intrinsics.checkNotNullParameter(pageContent, "pageContent");
        Composer startRestartGroup = composer.startRestartGroup(542751273);
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changedInstance(pages) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= startRestartGroup.changedInstance(onPageSelected) ? 32 : 16;
        }
        int i7 = i2 & 4;
        if (i7 != 0) {
            i3 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        } else if ((i & RendererCapabilities.DECODER_SUPPORT_MASK) == 0) {
            obj = modifier;
            i3 |= startRestartGroup.changed(obj) ? 256 : 128;
            i4 = i2 & 8;
            if (i4 == 0) {
                i3 |= 3072;
            } else if ((i & 3072) == 0) {
                i3 |= (i & 4096) == 0 ? startRestartGroup.changed(disabled) : startRestartGroup.changedInstance(disabled) ? 2048 : 1024;
            }
            if ((i & 24576) != 0) {
                if ((i2 & 16) == 0) {
                    obj2 = function6;
                    if (startRestartGroup.changedInstance(obj2)) {
                        i6 = 16384;
                        i3 |= i6;
                    }
                } else {
                    obj2 = function6;
                }
                i6 = 8192;
                i3 |= i6;
            } else {
                obj2 = function6;
            }
            if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 0) {
                obj3 = function1;
                i3 |= ((i2 & 32) == 0 && startRestartGroup.changedInstance(obj3)) ? 131072 : 65536;
            } else {
                obj3 = function1;
            }
            if ((i2 & 64) == 0) {
                i3 |= 1572864;
            } else if ((i & 1572864) == 0) {
                i3 |= startRestartGroup.changedInstance(pageContent) ? 1048576 : 524288;
            }
            if ((i3 & 599187) == 599186 || !startRestartGroup.getSkipping()) {
                startRestartGroup.startDefaults();
                if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                    Modifier.Companion companion = i7 == 0 ? Modifier.Companion : obj;
                    if (i4 != 0) {
                        disabled = PagesScrollAnimation.Disabled.INSTANCE;
                    }
                    if ((i2 & 16) == 0) {
                        obj4 = defaultHorizontalPager();
                        i3 &= -57345;
                    } else {
                        obj4 = obj2;
                    }
                    if ((i2 & 32) == 0) {
                        Object obj5 = companion;
                        i5 = i3 & (-458753);
                        childPagesKt$ChildPages$9 = new PropertyReference1Impl() { // from class: com.arkivanov.decompose.extensions.compose.pages.ChildPagesKt$ChildPages$9
                            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                            public Object get(Object obj6) {
                                return ((Child) obj6).getKey();
                            }
                        };
                        obj = obj5;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(542751273, i5, -1, "com.arkivanov.decompose.extensions.compose.pages.ChildPages (ChildPages.kt:152)");
                        }
                        coerceAtLeast = RangesKt.coerceAtLeast(pages.getSelectedIndex(), 0);
                        final State rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Integer.valueOf(pages.getItems().size()), startRestartGroup, 0);
                        startRestartGroup.startReplaceGroup(150950216);
                        rememberedValue = startRestartGroup.rememberedValue();
                        if (rememberedValue == Composer.Companion.getEmpty()) {
                            rememberedValue = PagerStateKt.PagerState$default(coerceAtLeast, 0.0f, new Function0() { // from class: com.arkivanov.decompose.extensions.compose.pages.ChildPagesKt$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    int intValue;
                                    intValue = ((Number) State.this.getValue()).intValue();
                                    return Integer.valueOf(intValue);
                                }
                            }, 2, null);
                            startRestartGroup.updateRememberedValue(rememberedValue);
                        }
                        final PagerState pagerState = (PagerState) rememberedValue;
                        startRestartGroup.endReplaceGroup();
                        Integer valueOf = Integer.valueOf(coerceAtLeast);
                        startRestartGroup.startReplaceGroup(150956665);
                        changed = ((i5 & 7168) != 2048 || ((i5 & 4096) != 0 && startRestartGroup.changedInstance(disabled))) | startRestartGroup.changed(coerceAtLeast);
                        rememberedValue2 = startRestartGroup.rememberedValue();
                        if (!changed || rememberedValue2 == Composer.Companion.getEmpty()) {
                            rememberedValue2 = new ChildPagesKt$ChildPages$10$1(pagerState, disabled, coerceAtLeast, null);
                            startRestartGroup.updateRememberedValue(rememberedValue2);
                        }
                        startRestartGroup.endReplaceGroup();
                        EffectsKt.LaunchedEffect(valueOf, (Function2) rememberedValue2, startRestartGroup, 0);
                        Integer valueOf2 = Integer.valueOf(pagerState.getCurrentPage());
                        Integer valueOf3 = Integer.valueOf(pagerState.getTargetPage());
                        startRestartGroup.startReplaceGroup(150972053);
                        z = (i5 & 112) != 32;
                        rememberedValue3 = startRestartGroup.rememberedValue();
                        if (!z || rememberedValue3 == Composer.Companion.getEmpty()) {
                            rememberedValue3 = new Function1() { // from class: com.arkivanov.decompose.extensions.compose.pages.ChildPagesKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj6) {
                                    return ChildPagesKt.ChildPages$lambda$9$lambda$8(PagerState.this, onPageSelected, (DisposableEffectScope) obj6);
                                }
                            };
                            startRestartGroup.updateRememberedValue(rememberedValue3);
                        }
                        startRestartGroup.endReplaceGroup();
                        EffectsKt.DisposableEffect(valueOf2, valueOf3, (Function1) rememberedValue3, startRestartGroup, 0);
                        startRestartGroup.startReplaceGroup(150978083);
                        changedInstance = startRestartGroup.changedInstance(pages) | ((((458752 & i5) ^ ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) > 131072 && startRestartGroup.changed(childPagesKt$ChildPages$9)) || (i5 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 131072);
                        rememberedValue4 = startRestartGroup.rememberedValue();
                        if (!changedInstance || rememberedValue4 == Composer.Companion.getEmpty()) {
                            rememberedValue4 = new Function1() { // from class: com.arkivanov.decompose.extensions.compose.pages.ChildPagesKt$$ExternalSyntheticLambda5
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj6) {
                                    Object invoke;
                                    invoke = Function1.this.invoke(pages.getItems().get(((Integer) obj6).intValue()));
                                    return invoke;
                                }
                            };
                            startRestartGroup.updateRememberedValue(rememberedValue4);
                        }
                        startRestartGroup.endReplaceGroup();
                        obj4.invoke(obj, pagerState, (Function1) rememberedValue4, ComposableLambdaKt.rememberComposableLambda(-2032743591, true, new Function4<PagerScope, Integer, Composer, Integer, Unit>() { // from class: com.arkivanov.decompose.extensions.compose.pages.ChildPagesKt$ChildPages$13
                            @Override // kotlin.jvm.functions.Function4
                            public /* bridge */ /* synthetic */ Unit invoke(PagerScope pagerScope, Integer num, Composer composer2, Integer num2) {
                                invoke(pagerScope, num.intValue(), composer2, num2.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(PagerScope pager, int i8, Composer composer2, int i9) {
                                Intrinsics.checkNotNullParameter(pager, "$this$pager");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-2032743591, i9, -1, "com.arkivanov.decompose.extensions.compose.pages.ChildPages.<anonymous> (ChildPages.kt:187)");
                                }
                                Child child = (Child) pages.getItems().get(i8);
                                String key = child.getKey();
                                composer2.startReplaceGroup(750671283);
                                boolean changed2 = composer2.changed(key);
                                Object rememberedValue5 = composer2.rememberedValue();
                                if (changed2 || rememberedValue5 == Composer.Companion.getEmpty()) {
                                    rememberedValue5 = new Ref(child.getInstance());
                                    composer2.updateRememberedValue(rememberedValue5);
                                }
                                Ref ref = (Ref) rememberedValue5;
                                composer2.endReplaceGroup();
                                if (child.getInstance() != null) {
                                    ref.setValue(child.getInstance());
                                }
                                Object value = ref.getValue();
                                if (value != null) {
                                    pageContent.invoke(pager, Integer.valueOf(i8), value, pagerState, composer2, Integer.valueOf((i9 & 14) | 3072 | (i9 & 112)));
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, startRestartGroup, 54), startRestartGroup, Integer.valueOf(((i5 >> 6) & 14) | 3120 | (i5 & 57344)));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        function12 = childPagesKt$ChildPages$9;
                        function62 = obj4;
                        modifier2 = obj;
                        pagesScrollAnimation2 = disabled;
                    } else {
                        obj = companion;
                        i5 = i3;
                    }
                } else {
                    startRestartGroup.skipToGroupEnd();
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                    }
                    i5 = i3;
                    obj4 = obj2;
                }
                childPagesKt$ChildPages$9 = obj3;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                coerceAtLeast = RangesKt.coerceAtLeast(pages.getSelectedIndex(), 0);
                final State rememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(Integer.valueOf(pages.getItems().size()), startRestartGroup, 0);
                startRestartGroup.startReplaceGroup(150950216);
                rememberedValue = startRestartGroup.rememberedValue();
                if (rememberedValue == Composer.Companion.getEmpty()) {
                }
                final PagerState pagerState2 = (PagerState) rememberedValue;
                startRestartGroup.endReplaceGroup();
                Integer valueOf4 = Integer.valueOf(coerceAtLeast);
                startRestartGroup.startReplaceGroup(150956665);
                changed = ((i5 & 7168) != 2048 || ((i5 & 4096) != 0 && startRestartGroup.changedInstance(disabled))) | startRestartGroup.changed(coerceAtLeast);
                rememberedValue2 = startRestartGroup.rememberedValue();
                if (!changed) {
                }
                rememberedValue2 = new ChildPagesKt$ChildPages$10$1(pagerState2, disabled, coerceAtLeast, null);
                startRestartGroup.updateRememberedValue(rememberedValue2);
                startRestartGroup.endReplaceGroup();
                EffectsKt.LaunchedEffect(valueOf4, (Function2) rememberedValue2, startRestartGroup, 0);
                Integer valueOf22 = Integer.valueOf(pagerState2.getCurrentPage());
                Integer valueOf32 = Integer.valueOf(pagerState2.getTargetPage());
                startRestartGroup.startReplaceGroup(150972053);
                if ((i5 & 112) != 32) {
                }
                rememberedValue3 = startRestartGroup.rememberedValue();
                if (!z) {
                }
                rememberedValue3 = new Function1() { // from class: com.arkivanov.decompose.extensions.compose.pages.ChildPagesKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj6) {
                        return ChildPagesKt.ChildPages$lambda$9$lambda$8(PagerState.this, onPageSelected, (DisposableEffectScope) obj6);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue3);
                startRestartGroup.endReplaceGroup();
                EffectsKt.DisposableEffect(valueOf22, valueOf32, (Function1) rememberedValue3, startRestartGroup, 0);
                startRestartGroup.startReplaceGroup(150978083);
                if (((458752 & i5) ^ ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) > 131072) {
                    changedInstance = startRestartGroup.changedInstance(pages) | ((((458752 & i5) ^ ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) > 131072 && startRestartGroup.changed(childPagesKt$ChildPages$9)) || (i5 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 131072);
                    rememberedValue4 = startRestartGroup.rememberedValue();
                    if (!changedInstance) {
                    }
                    rememberedValue4 = new Function1() { // from class: com.arkivanov.decompose.extensions.compose.pages.ChildPagesKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj6) {
                            Object invoke;
                            invoke = Function1.this.invoke(pages.getItems().get(((Integer) obj6).intValue()));
                            return invoke;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue4);
                    startRestartGroup.endReplaceGroup();
                    obj4.invoke(obj, pagerState2, (Function1) rememberedValue4, ComposableLambdaKt.rememberComposableLambda(-2032743591, true, new Function4<PagerScope, Integer, Composer, Integer, Unit>() { // from class: com.arkivanov.decompose.extensions.compose.pages.ChildPagesKt$ChildPages$13
                        @Override // kotlin.jvm.functions.Function4
                        public /* bridge */ /* synthetic */ Unit invoke(PagerScope pagerScope, Integer num, Composer composer2, Integer num2) {
                            invoke(pagerScope, num.intValue(), composer2, num2.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(PagerScope pager, int i8, Composer composer2, int i9) {
                            Intrinsics.checkNotNullParameter(pager, "$this$pager");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-2032743591, i9, -1, "com.arkivanov.decompose.extensions.compose.pages.ChildPages.<anonymous> (ChildPages.kt:187)");
                            }
                            Child child = (Child) pages.getItems().get(i8);
                            String key = child.getKey();
                            composer2.startReplaceGroup(750671283);
                            boolean changed2 = composer2.changed(key);
                            Object rememberedValue5 = composer2.rememberedValue();
                            if (changed2 || rememberedValue5 == Composer.Companion.getEmpty()) {
                                rememberedValue5 = new Ref(child.getInstance());
                                composer2.updateRememberedValue(rememberedValue5);
                            }
                            Ref ref = (Ref) rememberedValue5;
                            composer2.endReplaceGroup();
                            if (child.getInstance() != null) {
                                ref.setValue(child.getInstance());
                            }
                            Object value = ref.getValue();
                            if (value != null) {
                                pageContent.invoke(pager, Integer.valueOf(i8), value, pagerState2, composer2, Integer.valueOf((i9 & 14) | 3072 | (i9 & 112)));
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, startRestartGroup, 54), startRestartGroup, Integer.valueOf(((i5 >> 6) & 14) | 3120 | (i5 & 57344)));
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    function12 = childPagesKt$ChildPages$9;
                    function62 = obj4;
                    modifier2 = obj;
                    pagesScrollAnimation2 = disabled;
                }
                changedInstance = startRestartGroup.changedInstance(pages) | ((((458752 & i5) ^ ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) > 131072 && startRestartGroup.changed(childPagesKt$ChildPages$9)) || (i5 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 131072);
                rememberedValue4 = startRestartGroup.rememberedValue();
                if (!changedInstance) {
                }
                rememberedValue4 = new Function1() { // from class: com.arkivanov.decompose.extensions.compose.pages.ChildPagesKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj6) {
                        Object invoke;
                        invoke = Function1.this.invoke(pages.getItems().get(((Integer) obj6).intValue()));
                        return invoke;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue4);
                startRestartGroup.endReplaceGroup();
                obj4.invoke(obj, pagerState2, (Function1) rememberedValue4, ComposableLambdaKt.rememberComposableLambda(-2032743591, true, new Function4<PagerScope, Integer, Composer, Integer, Unit>() { // from class: com.arkivanov.decompose.extensions.compose.pages.ChildPagesKt$ChildPages$13
                    @Override // kotlin.jvm.functions.Function4
                    public /* bridge */ /* synthetic */ Unit invoke(PagerScope pagerScope, Integer num, Composer composer2, Integer num2) {
                        invoke(pagerScope, num.intValue(), composer2, num2.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(PagerScope pager, int i8, Composer composer2, int i9) {
                        Intrinsics.checkNotNullParameter(pager, "$this$pager");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-2032743591, i9, -1, "com.arkivanov.decompose.extensions.compose.pages.ChildPages.<anonymous> (ChildPages.kt:187)");
                        }
                        Child child = (Child) pages.getItems().get(i8);
                        String key = child.getKey();
                        composer2.startReplaceGroup(750671283);
                        boolean changed2 = composer2.changed(key);
                        Object rememberedValue5 = composer2.rememberedValue();
                        if (changed2 || rememberedValue5 == Composer.Companion.getEmpty()) {
                            rememberedValue5 = new Ref(child.getInstance());
                            composer2.updateRememberedValue(rememberedValue5);
                        }
                        Ref ref = (Ref) rememberedValue5;
                        composer2.endReplaceGroup();
                        if (child.getInstance() != null) {
                            ref.setValue(child.getInstance());
                        }
                        Object value = ref.getValue();
                        if (value != null) {
                            pageContent.invoke(pager, Integer.valueOf(i8), value, pagerState2, composer2, Integer.valueOf((i9 & 14) | 3072 | (i9 & 112)));
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, startRestartGroup, 54), startRestartGroup, Integer.valueOf(((i5 >> 6) & 14) | 3120 | (i5 & 57344)));
                if (ComposerKt.isTraceInProgress()) {
                }
                function12 = childPagesKt$ChildPages$9;
                function62 = obj4;
                modifier2 = obj;
                pagesScrollAnimation2 = disabled;
            } else {
                startRestartGroup.skipToGroupEnd();
                function62 = obj2;
                function12 = obj3;
                pagesScrollAnimation2 = disabled;
                modifier2 = obj;
            }
            ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
                endRestartGroup.updateScope(new Function2() { // from class: com.arkivanov.decompose.extensions.compose.pages.ChildPagesKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj6, Object obj7) {
                        return ChildPagesKt.ChildPages$lambda$12(ChildPages.this, onPageSelected, modifier2, pagesScrollAnimation2, function62, function12, pageContent, i, i2, (Composer) obj6, ((Integer) obj7).intValue());
                    }
                });
                return;
            }
            return;
        }
        obj = modifier;
        i4 = i2 & 8;
        if (i4 == 0) {
        }
        if ((i & 24576) != 0) {
        }
        if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 0) {
        }
        if ((i2 & 64) == 0) {
        }
        if ((i3 & 599187) == 599186) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i7 == 0) {
        }
        if (i4 != 0) {
        }
        if ((i2 & 16) == 0) {
        }
        if ((i2 & 32) == 0) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final DisposableEffectResult ChildPages$lambda$9$lambda$8(PagerState pagerState, Function1 function1, DisposableEffectScope DisposableEffect) {
        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
        if (pagerState.getCurrentPage() == pagerState.getTargetPage()) {
            function1.invoke(Integer.valueOf(pagerState.getCurrentPage()));
        }
        return new DisposableEffectResult() { // from class: com.arkivanov.decompose.extensions.compose.pages.ChildPagesKt$ChildPages$lambda$9$lambda$8$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
            }
        };
    }

    private static final <C, T> ChildPages<C, T> ChildPages$lambda$1(State<? extends ChildPages<? extends C, ? extends T>> state) {
        return (ChildPages) ((ChildPages<? extends C, ? extends T>) state.getValue());
    }
}
