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
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.exoplayer.RendererCapabilities;
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
import kotlin.reflect.KFunction;
import okhttp3.internal.ws.WebSocketProtocol;
/* compiled from: ChildPages.kt */
@Metadata(d1 = {"\u0000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u001aó\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u00032\u0018\u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00040\u00070\u00062!\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00010\t2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u0094\u0001\b\u0002\u0010\u0012\u001a\u008d\u0001\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0014\u0012.\u0012,\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00030\t¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0015\u0012>\u0012<\u0012\u0004\u0012\u00020\u0017\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0002\b\u0018¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0019¢\u0006\u0002\b\u001a\u0012\u0004\u0012\u00020\u00010\u0013j\u0002`\u001b¢\u0006\u0002\b\u00182 \b\u0002\u0010\u0015\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00040\u001c\u0012\u0004\u0012\u00020\u00030\t2F\u0010\u0019\u001aB\u0012\u0004\u0012\u00020\u0017\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u0011H\u0004¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u00010\u001d¢\u0006\u0002\b\u0018¢\u0006\u0002\b\u001aH\u0007¢\u0006\u0002\u0010\u001f\u001aí\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u00032\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00040\u00072!\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00010\t2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u0094\u0001\b\u0002\u0010\u0012\u001a\u008d\u0001\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0014\u0012.\u0012,\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00030\t¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0015\u0012>\u0012<\u0012\u0004\u0012\u00020\u0017\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0002\b\u0018¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0019¢\u0006\u0002\b\u001a\u0012\u0004\u0012\u00020\u00010\u0013j\u0002`\u001b¢\u0006\u0002\b\u00182 \b\u0002\u0010\u0015\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00040\u001c\u0012\u0004\u0012\u00020\u00030\t2F\u0010\u0019\u001aB\u0012\u0004\u0012\u00020\u0017\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u0011H\u0004¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u00010\u001d¢\u0006\u0002\b\u0018¢\u0006\u0002\b\u001aH\u0007¢\u0006\u0002\u0010 \u001a\u0097\u0001\u0010!\u001a\u008d\u0001\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0014\u0012.\u0012,\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00030\t¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0015\u0012>\u0012<\u0012\u0004\u0012\u00020\u0017\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0002\b\u0018¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0019¢\u0006\u0002\b\u001a\u0012\u0004\u0012\u00020\u00010\u0013j\u0002`\u001b¢\u0006\u0002\b\u0018¢\u0006\u0002\u0010\"\u001a\u0097\u0001\u0010#\u001a\u008d\u0001\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0014\u0012.\u0012,\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00030\t¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0015\u0012>\u0012<\u0012\u0004\u0012\u00020\u0017\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0002\b\u0018¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0019¢\u0006\u0002\b\u001a\u0012\u0004\u0012\u00020\u00010\u0013j\u0002`\u001b¢\u0006\u0002\b\u0018¢\u0006\u0002\u0010\"*\u009c\u0002\b\u0000\u0010$\"\u0089\u0001\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0014\u0012.\u0012,\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00030\t¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0015\u0012>\u0012<\u0012\u0004\u0012\u00020\u0017\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0002\b\u0018¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0019¢\u0006\u0002\b\u001a\u0012\u0004\u0012\u00020\u00010\u0013¢\u0006\u0002\b\u00182\u0089\u0001\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0014\u0012.\u0012,\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00030\t¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0015\u0012>\u0012<\u0012\u0004\u0012\u00020\u0017\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0002\b\u0018¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0019¢\u0006\u0002\b\u001a\u0012\u0004\u0012\u00020\u00010\u0013¢\u0006\u0002\b\u0018¨\u0006%²\u0006*\u0010&\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00040\u0007\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0003X\u008a\u0084\u0002"}, d2 = {"ChildPages", "", "C", "", ExifInterface.GPS_DIRECTION_TRUE, "pages", "Lcom/arkivanov/decompose/value/Value;", "Lcom/arkivanov/decompose/router/pages/ChildPages;", "onPageSelected", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", FirebaseAnalytics.Param.INDEX, "modifier", "Landroidx/compose/ui/Modifier;", "scrollAnimation", "Lcom/arkivanov/decompose/extensions/compose/pages/PagesScrollAnimation;", "pager", "Lkotlin/Function4;", "Landroidx/compose/foundation/pager/PagerState;", "key", "Lkotlin/Function2;", "Landroidx/compose/foundation/pager/PagerScope;", "Landroidx/compose/runtime/Composable;", "pageContent", "Lkotlin/ExtensionFunctionType;", "Lcom/arkivanov/decompose/extensions/compose/pages/Pager;", "Lcom/arkivanov/decompose/Child;", "Lkotlin/Function3;", "page", "(Lcom/arkivanov/decompose/value/Value;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Lcom/arkivanov/decompose/extensions/compose/pages/PagesScrollAnimation;Lkotlin/jvm/functions/Function6;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function5;Landroidx/compose/runtime/Composer;II)V", "(Lcom/arkivanov/decompose/router/pages/ChildPages;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Lcom/arkivanov/decompose/extensions/compose/pages/PagesScrollAnimation;Lkotlin/jvm/functions/Function6;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function5;Landroidx/compose/runtime/Composer;II)V", "defaultHorizontalPager", "()Lkotlin/jvm/functions/Function6;", "defaultVerticalPager", "Pager", "extensions-compose_release", RemoteConfigConstants.ResponseFieldKey.STATE}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ChildPagesKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ChildPages$lambda$12(ChildPages childPages, Function1 function1, Modifier modifier, PagesScrollAnimation pagesScrollAnimation, Function6 function6, Function1 function12, Function5 function5, int i, int i2, Composer composer, int i3) {
        ChildPages(childPages, function1, modifier, pagesScrollAnimation, function6, function12, function5, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ChildPages$lambda$2(Value value, Function1 function1, Modifier modifier, PagesScrollAnimation pagesScrollAnimation, Function6 function6, Function1 function12, Function5 function5, int i, int i2, Composer composer, int i3) {
        ChildPages(value, function1, modifier, pagesScrollAnimation, function6, function12, function5, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final Function6<Modifier, PagerState, Function1<? super Integer, ? extends Object>, Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit>, Composer, Integer, Unit> defaultHorizontalPager() {
        return ComposableSingletons$ChildPagesKt.INSTANCE.m7978getLambda1$extensions_compose_release();
    }

    public static final Function6<Modifier, PagerState, Function1<? super Integer, ? extends Object>, Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit>, Composer, Integer, Unit> defaultVerticalPager() {
        return ComposableSingletons$ChildPagesKt.INSTANCE.m7979getLambda2$extensions_compose_release();
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:117:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x011c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <C, T> void ChildPages(final Value<? extends ChildPages<? extends C, ? extends T>> pages, final Function1<? super Integer, Unit> onPageSelected, Modifier modifier, PagesScrollAnimation pagesScrollAnimation, Function6<? super Modifier, ? super PagerState, ? super Function1<? super Integer, ? extends Object>, ? super Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function6, Function1<? super Child<? extends C, ? extends T>, ? extends Object> function1, final Function5<? super PagerScope, ? super Integer, ? super T, ? super Composer, ? super Integer, Unit> pageContent, Composer composer, final int i, final int i2) {
        int i3;
        Modifier.Companion companion;
        int i4;
        Function6<Modifier, PagerState, Function1<? super Integer, ? extends Object>, Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit>, Composer, Integer, Unit> function62;
        int i5;
        Object obj;
        Function1<? super Child<? extends C, ? extends T>, ? extends Object> function12;
        PagesScrollAnimation pagesScrollAnimation2;
        int i6;
        Modifier modifier2;
        Function6<? super Modifier, ? super PagerState, ? super Function1<? super Integer, ? extends Object>, ? super Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function63;
        final Modifier modifier3;
        final PagesScrollAnimation pagesScrollAnimation3;
        final Function6<? super Modifier, ? super PagerState, ? super Function1<? super Integer, ? extends Object>, ? super Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function64;
        final Function1<? super Child<? extends C, ? extends T>, ? extends Object> function13;
        ScopeUpdateScope endRestartGroup;
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
            i5 = i2 & 32;
            if (i5 == 0) {
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else if ((196608 & i) == 0) {
                obj = function1;
                i3 |= startRestartGroup.changedInstance(obj) ? 131072 : 65536;
                if ((i2 & 64) != 0) {
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
                        if (i5 != 0) {
                            startRestartGroup.startReplaceGroup(150774917);
                            ChildPagesKt$ChildPages$1$1 rememberedValue = startRestartGroup.rememberedValue();
                            if (rememberedValue == Composer.Companion.getEmpty()) {
                                rememberedValue = ChildPagesKt$ChildPages$1$1.INSTANCE;
                                startRestartGroup.updateRememberedValue(rememberedValue);
                            }
                            startRestartGroup.endReplaceGroup();
                            function12 = (Function1) ((KFunction) rememberedValue);
                            pagesScrollAnimation2 = disabled;
                            i6 = i3;
                            modifier2 = companion;
                            function63 = function62;
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1455675035, i6, -1, "com.arkivanov.decompose.extensions.compose.pages.ChildPages (ChildPages.kt:32)");
                            }
                            ChildPages(ChildPages$lambda$1(SubscribeAsStateKt.subscribeAsState(pages, null, startRestartGroup, i6 & 14, 1)), onPageSelected, modifier2, pagesScrollAnimation2, function63, function12, pageContent, startRestartGroup, i6 & 4194288, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier2;
                            pagesScrollAnimation3 = pagesScrollAnimation2;
                            function64 = function63;
                            function13 = function12;
                        }
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                        }
                    }
                    pagesScrollAnimation2 = disabled;
                    i6 = i3;
                    modifier2 = companion;
                    function63 = function62;
                    function12 = obj;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    ChildPages(ChildPages$lambda$1(SubscribeAsStateKt.subscribeAsState(pages, null, startRestartGroup, i6 & 14, 1)), onPageSelected, modifier2, pagesScrollAnimation2, function63, function12, pageContent, startRestartGroup, i6 & 4194288, 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    modifier3 = modifier2;
                    pagesScrollAnimation3 = pagesScrollAnimation2;
                    function64 = function63;
                    function13 = function12;
                } else {
                    startRestartGroup.skipToGroupEnd();
                    pagesScrollAnimation3 = disabled;
                    modifier3 = companion;
                    function64 = function62;
                    function13 = obj;
                }
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2() { // from class: com.arkivanov.decompose.extensions.compose.pages.ChildPagesKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj2, Object obj3) {
                            Unit ChildPages$lambda$2;
                            ChildPages$lambda$2 = ChildPagesKt.ChildPages$lambda$2(Value.this, onPageSelected, modifier3, pagesScrollAnimation3, function64, function13, pageContent, i, i2, (Composer) obj2, ((Integer) obj3).intValue());
                            return ChildPages$lambda$2;
                        }
                    });
                    return;
                }
                return;
            }
            obj = function1;
            if ((i2 & 64) != 0) {
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
            if (i5 != 0) {
            }
            pagesScrollAnimation2 = disabled;
            i6 = i3;
            modifier2 = companion;
            function63 = function62;
            function12 = obj;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            ChildPages(ChildPages$lambda$1(SubscribeAsStateKt.subscribeAsState(pages, null, startRestartGroup, i6 & 14, 1)), onPageSelected, modifier2, pagesScrollAnimation2, function63, function12, pageContent, startRestartGroup, i6 & 4194288, 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier3 = modifier2;
            pagesScrollAnimation3 = pagesScrollAnimation2;
            function64 = function63;
            function13 = function12;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        companion = modifier;
        i4 = i2 & 8;
        if (i4 == 0) {
        }
        if ((i & 24576) != 0) {
        }
        i5 = i2 & 32;
        if (i5 == 0) {
        }
        obj = function1;
        if ((i2 & 64) != 0) {
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
        if (i5 != 0) {
        }
        pagesScrollAnimation2 = disabled;
        i6 = i3;
        modifier2 = companion;
        function63 = function62;
        function12 = obj;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        ChildPages(ChildPages$lambda$1(SubscribeAsStateKt.subscribeAsState(pages, null, startRestartGroup, i6 & 14, 1)), onPageSelected, modifier2, pagesScrollAnimation2, function63, function12, pageContent, startRestartGroup, i6 & 4194288, 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier3 = modifier2;
        pagesScrollAnimation3 = pagesScrollAnimation2;
        function64 = function63;
        function13 = function12;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x01c5  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0202  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0232  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0234  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0281  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x028c  */
    /* JADX WARN: Removed duplicated region for block: B:154:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0121  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <C, T> void ChildPages(final ChildPages<? extends C, ? extends T> pages, final Function1<? super Integer, Unit> onPageSelected, Modifier modifier, PagesScrollAnimation pagesScrollAnimation, Function6<? super Modifier, ? super PagerState, ? super Function1<? super Integer, ? extends Object>, ? super Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function6, Function1<? super Child<? extends C, ? extends T>, ? extends Object> function1, final Function5<? super PagerScope, ? super Integer, ? super T, ? super Composer, ? super Integer, Unit> pageContent, Composer composer, final int i, final int i2) {
        int i3;
        Modifier.Companion companion;
        int i4;
        Function6<Modifier, PagerState, Function1<? super Integer, ? extends Object>, Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit>, Composer, Integer, Unit> function62;
        int i5;
        Object obj;
        int i6;
        final Function1<? super Child<? extends C, ? extends T>, ? extends Object> function12;
        Function6<? super Modifier, ? super PagerState, ? super Function1<? super Integer, ? extends Object>, ? super Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function63;
        final PagesScrollAnimation pagesScrollAnimation2;
        boolean changedInstance;
        Object rememberedValue;
        boolean changed;
        ChildPagesKt$ChildPages$4$1 rememberedValue2;
        boolean changed2;
        Object rememberedValue3;
        boolean changedInstance2;
        Object rememberedValue4;
        final Function6<? super Modifier, ? super PagerState, ? super Function1<? super Integer, ? extends Object>, ? super Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function64;
        final Modifier modifier2;
        ScopeUpdateScope endRestartGroup;
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
            i5 = i2 & 32;
            if (i5 == 0) {
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                obj = function1;
            } else {
                obj = function1;
                if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    i3 |= startRestartGroup.changedInstance(obj) ? 131072 : 65536;
                }
            }
            if ((i2 & 64) == 0) {
                i3 |= 1572864;
            } else if ((i & 1572864) == 0) {
                i3 |= startRestartGroup.changedInstance(pageContent) ? 1048576 : 524288;
            }
            if ((i3 & 599187) == 599186 || !startRestartGroup.getSkipping()) {
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
                    if (i5 != 0) {
                        startRestartGroup.startReplaceGroup(150799045);
                        ChildPagesKt$ChildPages$3$1 rememberedValue5 = startRestartGroup.rememberedValue();
                        if (rememberedValue5 == Composer.Companion.getEmpty()) {
                            rememberedValue5 = ChildPagesKt$ChildPages$3$1.INSTANCE;
                            startRestartGroup.updateRememberedValue(rememberedValue5);
                        }
                        startRestartGroup.endReplaceGroup();
                        i6 = i3;
                        function12 = (Function1) ((KFunction) rememberedValue5);
                        function63 = function62;
                        pagesScrollAnimation2 = disabled;
                        Object obj2 = companion;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(123234442, i6, -1, "com.arkivanov.decompose.extensions.compose.pages.ChildPages (ChildPages.kt:58)");
                        }
                        int selectedIndex = pages.getSelectedIndex();
                        startRestartGroup.startReplaceGroup(150806719);
                        changedInstance = startRestartGroup.changedInstance(pages);
                        rememberedValue = startRestartGroup.rememberedValue();
                        if (!changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                            rememberedValue = new Function0() { // from class: com.arkivanov.decompose.extensions.compose.pages.ChildPagesKt$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    int ChildPages$lambda$5$lambda$4;
                                    ChildPages$lambda$5$lambda$4 = ChildPagesKt.ChildPages$lambda$5$lambda$4(ChildPages.this);
                                    return Integer.valueOf(ChildPages$lambda$5$lambda$4);
                                }
                            };
                            startRestartGroup.updateRememberedValue(rememberedValue);
                        }
                        startRestartGroup.endReplaceGroup();
                        final PagerState rememberPagerState = PagerStateKt.rememberPagerState(selectedIndex, 0.0f, (Function0) rememberedValue, startRestartGroup, 0, 2);
                        Integer valueOf = Integer.valueOf(selectedIndex);
                        startRestartGroup.startReplaceGroup(150809154);
                        changed = ((i6 & 7168) != 2048 || ((i6 & 4096) != 0 && startRestartGroup.changedInstance(pagesScrollAnimation2))) | startRestartGroup.changed(rememberPagerState) | startRestartGroup.changed(selectedIndex);
                        rememberedValue2 = startRestartGroup.rememberedValue();
                        if (!changed || rememberedValue2 == Composer.Companion.getEmpty()) {
                            rememberedValue2 = new ChildPagesKt$ChildPages$4$1(rememberPagerState, selectedIndex, pagesScrollAnimation2, null);
                            startRestartGroup.updateRememberedValue(rememberedValue2);
                        }
                        startRestartGroup.endReplaceGroup();
                        EffectsKt.LaunchedEffect(valueOf, (Function2) rememberedValue2, startRestartGroup, 0);
                        Integer valueOf2 = Integer.valueOf(rememberPagerState.getCurrentPage());
                        Integer valueOf3 = Integer.valueOf(rememberPagerState.getTargetPage());
                        startRestartGroup.startReplaceGroup(150824821);
                        changed2 = startRestartGroup.changed(rememberPagerState) | ((i6 & 112) == 32);
                        rememberedValue3 = startRestartGroup.rememberedValue();
                        if (!changed2 || rememberedValue3 == Composer.Companion.getEmpty()) {
                            rememberedValue3 = new Function1() { // from class: com.arkivanov.decompose.extensions.compose.pages.ChildPagesKt$$ExternalSyntheticLambda2
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj3) {
                                    DisposableEffectResult ChildPages$lambda$9$lambda$8;
                                    ChildPages$lambda$9$lambda$8 = ChildPagesKt.ChildPages$lambda$9$lambda$8(PagerState.this, onPageSelected, (DisposableEffectScope) obj3);
                                    return ChildPages$lambda$9$lambda$8;
                                }
                            };
                            startRestartGroup.updateRememberedValue(rememberedValue3);
                        }
                        startRestartGroup.endReplaceGroup();
                        EffectsKt.DisposableEffect(valueOf2, valueOf3, (Function1) rememberedValue3, startRestartGroup, 0);
                        startRestartGroup.startReplaceGroup(150830851);
                        changedInstance2 = ((458752 & i6) == 131072) | startRestartGroup.changedInstance(pages);
                        rememberedValue4 = startRestartGroup.rememberedValue();
                        if (!changedInstance2 || rememberedValue4 == Composer.Companion.getEmpty()) {
                            rememberedValue4 = new Function1() { // from class: com.arkivanov.decompose.extensions.compose.pages.ChildPagesKt$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj3) {
                                    Object ChildPages$lambda$11$lambda$10;
                                    ChildPages$lambda$11$lambda$10 = ChildPagesKt.ChildPages$lambda$11$lambda$10(Function1.this, pages, ((Integer) obj3).intValue());
                                    return ChildPages$lambda$11$lambda$10;
                                }
                            };
                            startRestartGroup.updateRememberedValue(rememberedValue4);
                        }
                        startRestartGroup.endReplaceGroup();
                        Function6<? super Modifier, ? super PagerState, ? super Function1<? super Integer, ? extends Object>, ? super Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function65 = function63;
                        function65.invoke(obj2, rememberPagerState, (Function1) rememberedValue4, ComposableLambdaKt.rememberComposableLambda(1842706874, true, new Function4<PagerScope, Integer, Composer, Integer, Unit>() { // from class: com.arkivanov.decompose.extensions.compose.pages.ChildPagesKt$ChildPages$7
                            @Override // kotlin.jvm.functions.Function4
                            public /* bridge */ /* synthetic */ Unit invoke(PagerScope pagerScope, Integer num, Composer composer2, Integer num2) {
                                invoke(pagerScope, num.intValue(), composer2, num2.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(PagerScope pager, int i9, Composer composer2, int i10) {
                                Intrinsics.checkNotNullParameter(pager, "$this$pager");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1842706874, i10, -1, "com.arkivanov.decompose.extensions.compose.pages.ChildPages.<anonymous> (ChildPages.kt:88)");
                                }
                                Child child = (Child) pages.getItems().get(i9);
                                Object key = child.getKey();
                                composer2.startReplaceGroup(750524051);
                                boolean changed3 = composer2.changed(key);
                                Object rememberedValue6 = composer2.rememberedValue();
                                if (changed3 || rememberedValue6 == Composer.Companion.getEmpty()) {
                                    rememberedValue6 = new Ref(child.getInstance());
                                    composer2.updateRememberedValue(rememberedValue6);
                                }
                                Ref ref = (Ref) rememberedValue6;
                                composer2.endReplaceGroup();
                                if (child.getInstance() != null) {
                                    ref.setValue(child.getInstance());
                                }
                                Object value = ref.getValue();
                                if (value != null) {
                                    pageContent.invoke(pager, Integer.valueOf(i9), value, composer2, Integer.valueOf(i10 & WebSocketProtocol.PAYLOAD_SHORT));
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, startRestartGroup, 54), startRestartGroup, Integer.valueOf(((i6 >> 6) & 14) | 3072 | (57344 & i6)));
                        startRestartGroup = startRestartGroup;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        function64 = function65;
                        modifier2 = obj2;
                    }
                } else {
                    startRestartGroup.skipToGroupEnd();
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                    }
                }
                i6 = i3;
                function63 = function62;
                function12 = obj;
                pagesScrollAnimation2 = disabled;
                Object obj22 = companion;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                int selectedIndex2 = pages.getSelectedIndex();
                startRestartGroup.startReplaceGroup(150806719);
                changedInstance = startRestartGroup.changedInstance(pages);
                rememberedValue = startRestartGroup.rememberedValue();
                if (!changedInstance) {
                }
                rememberedValue = new Function0() { // from class: com.arkivanov.decompose.extensions.compose.pages.ChildPagesKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        int ChildPages$lambda$5$lambda$4;
                        ChildPages$lambda$5$lambda$4 = ChildPagesKt.ChildPages$lambda$5$lambda$4(ChildPages.this);
                        return Integer.valueOf(ChildPages$lambda$5$lambda$4);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
                startRestartGroup.endReplaceGroup();
                final PagerState rememberPagerState2 = PagerStateKt.rememberPagerState(selectedIndex2, 0.0f, (Function0) rememberedValue, startRestartGroup, 0, 2);
                Integer valueOf4 = Integer.valueOf(selectedIndex2);
                startRestartGroup.startReplaceGroup(150809154);
                changed = ((i6 & 7168) != 2048 || ((i6 & 4096) != 0 && startRestartGroup.changedInstance(pagesScrollAnimation2))) | startRestartGroup.changed(rememberPagerState2) | startRestartGroup.changed(selectedIndex2);
                rememberedValue2 = startRestartGroup.rememberedValue();
                if (!changed) {
                }
                rememberedValue2 = new ChildPagesKt$ChildPages$4$1(rememberPagerState2, selectedIndex2, pagesScrollAnimation2, null);
                startRestartGroup.updateRememberedValue(rememberedValue2);
                startRestartGroup.endReplaceGroup();
                EffectsKt.LaunchedEffect(valueOf4, (Function2) rememberedValue2, startRestartGroup, 0);
                Integer valueOf22 = Integer.valueOf(rememberPagerState2.getCurrentPage());
                Integer valueOf32 = Integer.valueOf(rememberPagerState2.getTargetPage());
                startRestartGroup.startReplaceGroup(150824821);
                changed2 = startRestartGroup.changed(rememberPagerState2) | ((i6 & 112) == 32);
                rememberedValue3 = startRestartGroup.rememberedValue();
                if (!changed2) {
                }
                rememberedValue3 = new Function1() { // from class: com.arkivanov.decompose.extensions.compose.pages.ChildPagesKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj3) {
                        DisposableEffectResult ChildPages$lambda$9$lambda$8;
                        ChildPages$lambda$9$lambda$8 = ChildPagesKt.ChildPages$lambda$9$lambda$8(PagerState.this, onPageSelected, (DisposableEffectScope) obj3);
                        return ChildPages$lambda$9$lambda$8;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue3);
                startRestartGroup.endReplaceGroup();
                EffectsKt.DisposableEffect(valueOf22, valueOf32, (Function1) rememberedValue3, startRestartGroup, 0);
                startRestartGroup.startReplaceGroup(150830851);
                changedInstance2 = ((458752 & i6) == 131072) | startRestartGroup.changedInstance(pages);
                rememberedValue4 = startRestartGroup.rememberedValue();
                if (!changedInstance2) {
                }
                rememberedValue4 = new Function1() { // from class: com.arkivanov.decompose.extensions.compose.pages.ChildPagesKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj3) {
                        Object ChildPages$lambda$11$lambda$10;
                        ChildPages$lambda$11$lambda$10 = ChildPagesKt.ChildPages$lambda$11$lambda$10(Function1.this, pages, ((Integer) obj3).intValue());
                        return ChildPages$lambda$11$lambda$10;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue4);
                startRestartGroup.endReplaceGroup();
                Function6<? super Modifier, ? super PagerState, ? super Function1<? super Integer, ? extends Object>, ? super Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function652 = function63;
                function652.invoke(obj22, rememberPagerState2, (Function1) rememberedValue4, ComposableLambdaKt.rememberComposableLambda(1842706874, true, new Function4<PagerScope, Integer, Composer, Integer, Unit>() { // from class: com.arkivanov.decompose.extensions.compose.pages.ChildPagesKt$ChildPages$7
                    @Override // kotlin.jvm.functions.Function4
                    public /* bridge */ /* synthetic */ Unit invoke(PagerScope pagerScope, Integer num, Composer composer2, Integer num2) {
                        invoke(pagerScope, num.intValue(), composer2, num2.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(PagerScope pager, int i9, Composer composer2, int i10) {
                        Intrinsics.checkNotNullParameter(pager, "$this$pager");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1842706874, i10, -1, "com.arkivanov.decompose.extensions.compose.pages.ChildPages.<anonymous> (ChildPages.kt:88)");
                        }
                        Child child = (Child) pages.getItems().get(i9);
                        Object key = child.getKey();
                        composer2.startReplaceGroup(750524051);
                        boolean changed3 = composer2.changed(key);
                        Object rememberedValue6 = composer2.rememberedValue();
                        if (changed3 || rememberedValue6 == Composer.Companion.getEmpty()) {
                            rememberedValue6 = new Ref(child.getInstance());
                            composer2.updateRememberedValue(rememberedValue6);
                        }
                        Ref ref = (Ref) rememberedValue6;
                        composer2.endReplaceGroup();
                        if (child.getInstance() != null) {
                            ref.setValue(child.getInstance());
                        }
                        Object value = ref.getValue();
                        if (value != null) {
                            pageContent.invoke(pager, Integer.valueOf(i9), value, composer2, Integer.valueOf(i10 & WebSocketProtocol.PAYLOAD_SHORT));
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, startRestartGroup, 54), startRestartGroup, Integer.valueOf(((i6 >> 6) & 14) | 3072 | (57344 & i6)));
                startRestartGroup = startRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                }
                function64 = function652;
                modifier2 = obj22;
            } else {
                startRestartGroup.skipToGroupEnd();
                pagesScrollAnimation2 = disabled;
                modifier2 = companion;
                function64 = function62;
                function12 = obj;
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
                endRestartGroup.updateScope(new Function2() { // from class: com.arkivanov.decompose.extensions.compose.pages.ChildPagesKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj3, Object obj4) {
                        Unit ChildPages$lambda$12;
                        ChildPages$lambda$12 = ChildPagesKt.ChildPages$lambda$12(ChildPages.this, onPageSelected, modifier2, pagesScrollAnimation2, function64, function12, pageContent, i, i2, (Composer) obj3, ((Integer) obj4).intValue());
                        return ChildPages$lambda$12;
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
        i5 = i2 & 32;
        if (i5 == 0) {
        }
        if ((i2 & 64) == 0) {
        }
        if ((i3 & 599187) == 599186) {
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
        if (i5 != 0) {
        }
        i6 = i3;
        function63 = function62;
        function12 = obj;
        pagesScrollAnimation2 = disabled;
        Object obj222 = companion;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        int selectedIndex22 = pages.getSelectedIndex();
        startRestartGroup.startReplaceGroup(150806719);
        changedInstance = startRestartGroup.changedInstance(pages);
        rememberedValue = startRestartGroup.rememberedValue();
        if (!changedInstance) {
        }
        rememberedValue = new Function0() { // from class: com.arkivanov.decompose.extensions.compose.pages.ChildPagesKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int ChildPages$lambda$5$lambda$4;
                ChildPages$lambda$5$lambda$4 = ChildPagesKt.ChildPages$lambda$5$lambda$4(ChildPages.this);
                return Integer.valueOf(ChildPages$lambda$5$lambda$4);
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue);
        startRestartGroup.endReplaceGroup();
        final PagerState rememberPagerState22 = PagerStateKt.rememberPagerState(selectedIndex22, 0.0f, (Function0) rememberedValue, startRestartGroup, 0, 2);
        Integer valueOf42 = Integer.valueOf(selectedIndex22);
        startRestartGroup.startReplaceGroup(150809154);
        changed = ((i6 & 7168) != 2048 || ((i6 & 4096) != 0 && startRestartGroup.changedInstance(pagesScrollAnimation2))) | startRestartGroup.changed(rememberPagerState22) | startRestartGroup.changed(selectedIndex22);
        rememberedValue2 = startRestartGroup.rememberedValue();
        if (!changed) {
        }
        rememberedValue2 = new ChildPagesKt$ChildPages$4$1(rememberPagerState22, selectedIndex22, pagesScrollAnimation2, null);
        startRestartGroup.updateRememberedValue(rememberedValue2);
        startRestartGroup.endReplaceGroup();
        EffectsKt.LaunchedEffect(valueOf42, (Function2) rememberedValue2, startRestartGroup, 0);
        Integer valueOf222 = Integer.valueOf(rememberPagerState22.getCurrentPage());
        Integer valueOf322 = Integer.valueOf(rememberPagerState22.getTargetPage());
        startRestartGroup.startReplaceGroup(150824821);
        changed2 = startRestartGroup.changed(rememberPagerState22) | ((i6 & 112) == 32);
        rememberedValue3 = startRestartGroup.rememberedValue();
        if (!changed2) {
        }
        rememberedValue3 = new Function1() { // from class: com.arkivanov.decompose.extensions.compose.pages.ChildPagesKt$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj3) {
                DisposableEffectResult ChildPages$lambda$9$lambda$8;
                ChildPages$lambda$9$lambda$8 = ChildPagesKt.ChildPages$lambda$9$lambda$8(PagerState.this, onPageSelected, (DisposableEffectScope) obj3);
                return ChildPages$lambda$9$lambda$8;
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue3);
        startRestartGroup.endReplaceGroup();
        EffectsKt.DisposableEffect(valueOf222, valueOf322, (Function1) rememberedValue3, startRestartGroup, 0);
        startRestartGroup.startReplaceGroup(150830851);
        changedInstance2 = ((458752 & i6) == 131072) | startRestartGroup.changedInstance(pages);
        rememberedValue4 = startRestartGroup.rememberedValue();
        if (!changedInstance2) {
        }
        rememberedValue4 = new Function1() { // from class: com.arkivanov.decompose.extensions.compose.pages.ChildPagesKt$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj3) {
                Object ChildPages$lambda$11$lambda$10;
                ChildPages$lambda$11$lambda$10 = ChildPagesKt.ChildPages$lambda$11$lambda$10(Function1.this, pages, ((Integer) obj3).intValue());
                return ChildPages$lambda$11$lambda$10;
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue4);
        startRestartGroup.endReplaceGroup();
        Function6<? super Modifier, ? super PagerState, ? super Function1<? super Integer, ? extends Object>, ? super Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function6522 = function63;
        function6522.invoke(obj222, rememberPagerState22, (Function1) rememberedValue4, ComposableLambdaKt.rememberComposableLambda(1842706874, true, new Function4<PagerScope, Integer, Composer, Integer, Unit>() { // from class: com.arkivanov.decompose.extensions.compose.pages.ChildPagesKt$ChildPages$7
            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(PagerScope pagerScope, Integer num, Composer composer2, Integer num2) {
                invoke(pagerScope, num.intValue(), composer2, num2.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(PagerScope pager, int i9, Composer composer2, int i10) {
                Intrinsics.checkNotNullParameter(pager, "$this$pager");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1842706874, i10, -1, "com.arkivanov.decompose.extensions.compose.pages.ChildPages.<anonymous> (ChildPages.kt:88)");
                }
                Child child = (Child) pages.getItems().get(i9);
                Object key = child.getKey();
                composer2.startReplaceGroup(750524051);
                boolean changed3 = composer2.changed(key);
                Object rememberedValue6 = composer2.rememberedValue();
                if (changed3 || rememberedValue6 == Composer.Companion.getEmpty()) {
                    rememberedValue6 = new Ref(child.getInstance());
                    composer2.updateRememberedValue(rememberedValue6);
                }
                Ref ref = (Ref) rememberedValue6;
                composer2.endReplaceGroup();
                if (child.getInstance() != null) {
                    ref.setValue(child.getInstance());
                }
                Object value = ref.getValue();
                if (value != null) {
                    pageContent.invoke(pager, Integer.valueOf(i9), value, composer2, Integer.valueOf(i10 & WebSocketProtocol.PAYLOAD_SHORT));
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }, startRestartGroup, 54), startRestartGroup, Integer.valueOf(((i6 >> 6) & 14) | 3072 | (57344 & i6)));
        startRestartGroup = startRestartGroup;
        if (ComposerKt.isTraceInProgress()) {
        }
        function64 = function6522;
        modifier2 = obj222;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int ChildPages$lambda$5$lambda$4(ChildPages childPages) {
        return childPages.getItems().size();
    }

    /* JADX INFO: Access modifiers changed from: private */
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object ChildPages$lambda$11$lambda$10(Function1 function1, ChildPages childPages, int i) {
        return function1.invoke(childPages.getItems().get(i));
    }

    private static final <C, T> ChildPages<C, T> ChildPages$lambda$1(State<? extends ChildPages<? extends C, ? extends T>> state) {
        return (ChildPages) ((ChildPages<? extends C, ? extends T>) state.getValue());
    }
}
