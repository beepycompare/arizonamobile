package androidx.compose.foundation.layout;

import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.platform.AbstractComposeView;
import androidx.compose.ui.platform.ComposeView;
import androidx.core.graphics.Insets;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
/* compiled from: WindowInsets.android.kt */
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b5\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010P\u001a\u00020Q2\u0006\u0010R\u001a\u00020S2\u0006\u0010T\u001a\u00020UH\u0000\u001a\f\u0010V\u001a\u00020W*\u00020SH\u0000\"\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00028GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u001e\u0010\u0007\u001a\u00020\u0001*\u00020\u00028GX\u0087\u0004¢\u0006\f\u0012\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006\"\u001e\u0010\n\u001a\u00020\u0001*\u00020\u00028GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006\"\u0015\u0010\r\u001a\u00020\u000e*\u00020\u00028G¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\"\u001e\u0010\u0011\u001a\u00020\u000e*\u00020\u00028GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0010\"(\u0010\u0015\u001a\u00020\u0001*\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u00018F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a\".\u0010\u0015\u001a\u00020\u0001*\u00020\u001b2\u0006\u0010\u0014\u001a\u00020\u00018F@FX\u0087\u000e¢\u0006\u0012\u0012\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u0017\u0010\u001e\"\u0004\b\u0019\u0010\u001f\"\u0015\u0010 \u001a\u00020\u000e*\u00020\u00028G¢\u0006\u0006\u001a\u0004\b!\u0010\u0010\"\u0015\u0010\"\u001a\u00020\u000e*\u00020\u00028G¢\u0006\u0006\u001a\u0004\b#\u0010\u0010\"\u001e\u0010$\u001a\u00020\u000e*\u00020\u00028GX\u0087\u0004¢\u0006\f\u0012\u0004\b%\u0010\u0004\u001a\u0004\b&\u0010\u0010\"\u001e\u0010'\u001a\u00020\u000e*\u00020\u00028GX\u0087\u0004¢\u0006\f\u0012\u0004\b(\u0010\u0004\u001a\u0004\b)\u0010\u0010\"\u001e\u0010*\u001a\u00020\u0001*\u00020\u00028GX\u0087\u0004¢\u0006\f\u0012\u0004\b+\u0010\u0004\u001a\u0004\b*\u0010\u0006\"\u001e\u0010,\u001a\u00020\u0001*\u00020\u00028GX\u0087\u0004¢\u0006\f\u0012\u0004\b-\u0010\u0004\u001a\u0004\b,\u0010\u0006\"\u001e\u0010.\u001a\u00020\u0001*\u00020\u00028GX\u0087\u0004¢\u0006\f\u0012\u0004\b/\u0010\u0004\u001a\u0004\b.\u0010\u0006\"\u0015\u00100\u001a\u00020\u000e*\u00020\u00028G¢\u0006\u0006\u001a\u0004\b1\u0010\u0010\"\u0015\u00102\u001a\u00020\u000e*\u00020\u00028G¢\u0006\u0006\u001a\u0004\b3\u0010\u0010\"\u001e\u00104\u001a\u00020\u000e*\u00020\u00028GX\u0087\u0004¢\u0006\f\u0012\u0004\b5\u0010\u0004\u001a\u0004\b6\u0010\u0010\"\u0015\u00107\u001a\u00020\u000e*\u00020\u00028G¢\u0006\u0006\u001a\u0004\b8\u0010\u0010\"\u0015\u00109\u001a\u00020\u000e*\u00020\u00028G¢\u0006\u0006\u001a\u0004\b:\u0010\u0010\"\u0015\u0010;\u001a\u00020\u000e*\u00020\u00028G¢\u0006\u0006\u001a\u0004\b<\u0010\u0010\"\u0015\u0010=\u001a\u00020\u000e*\u00020\u00028G¢\u0006\u0006\u001a\u0004\b>\u0010\u0010\"\u001e\u0010?\u001a\u00020\u000e*\u00020\u00028GX\u0087\u0004¢\u0006\f\u0012\u0004\b@\u0010\u0004\u001a\u0004\bA\u0010\u0010\"\u0015\u0010B\u001a\u00020\u000e*\u00020\u00028G¢\u0006\u0006\u001a\u0004\bC\u0010\u0010\"\u001e\u0010D\u001a\u00020\u000e*\u00020\u00028GX\u0087\u0004¢\u0006\f\u0012\u0004\bE\u0010\u0004\u001a\u0004\bF\u0010\u0010\"\u0015\u0010G\u001a\u00020\u000e*\u00020\u00028G¢\u0006\u0006\u001a\u0004\bH\u0010\u0010\"\u0015\u0010I\u001a\u00020\u000e*\u00020\u00028G¢\u0006\u0006\u001a\u0004\bJ\u0010\u0010\"\u001e\u0010K\u001a\u00020\u000e*\u00020\u00028GX\u0087\u0004¢\u0006\f\u0012\u0004\bL\u0010\u0004\u001a\u0004\bM\u0010\u0010\"\u0015\u0010N\u001a\u00020\u000e*\u00020\u00028G¢\u0006\u0006\u001a\u0004\bO\u0010\u0010¨\u0006X"}, d2 = {"areNavigationBarsVisible", "", "Landroidx/compose/foundation/layout/WindowInsets$Companion;", "getAreNavigationBarsVisible$annotations", "(Landroidx/compose/foundation/layout/WindowInsets$Companion;)V", "getAreNavigationBarsVisible", "(Landroidx/compose/foundation/layout/WindowInsets$Companion;Landroidx/compose/runtime/Composer;I)Z", "areStatusBarsVisible", "getAreStatusBarsVisible$annotations", "getAreStatusBarsVisible", "areSystemBarsVisible", "getAreSystemBarsVisible$annotations", "getAreSystemBarsVisible", "captionBar", "Landroidx/compose/foundation/layout/WindowInsets;", "getCaptionBar", "(Landroidx/compose/foundation/layout/WindowInsets$Companion;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/layout/WindowInsets;", "captionBarIgnoringVisibility", "getCaptionBarIgnoringVisibility$annotations", "getCaptionBarIgnoringVisibility", "value", "consumeWindowInsets", "Landroidx/compose/ui/platform/AbstractComposeView;", "getConsumeWindowInsets", "(Landroidx/compose/ui/platform/AbstractComposeView;)Z", "setConsumeWindowInsets", "(Landroidx/compose/ui/platform/AbstractComposeView;Z)V", "Landroidx/compose/ui/platform/ComposeView;", "getConsumeWindowInsets$annotations", "(Landroidx/compose/ui/platform/ComposeView;)V", "(Landroidx/compose/ui/platform/ComposeView;)Z", "(Landroidx/compose/ui/platform/ComposeView;Z)V", "displayCutout", "getDisplayCutout", "ime", "getIme", "imeAnimationSource", "getImeAnimationSource$annotations", "getImeAnimationSource", "imeAnimationTarget", "getImeAnimationTarget$annotations", "getImeAnimationTarget", "isCaptionBarVisible", "isCaptionBarVisible$annotations", "isImeVisible", "isImeVisible$annotations", "isTappableElementVisible", "isTappableElementVisible$annotations", "mandatorySystemGestures", "getMandatorySystemGestures", "navigationBars", "getNavigationBars", "navigationBarsIgnoringVisibility", "getNavigationBarsIgnoringVisibility$annotations", "getNavigationBarsIgnoringVisibility", "safeContent", "getSafeContent", "safeDrawing", "getSafeDrawing", "safeGestures", "getSafeGestures", "statusBars", "getStatusBars", "statusBarsIgnoringVisibility", "getStatusBarsIgnoringVisibility$annotations", "getStatusBarsIgnoringVisibility", "systemBars", "getSystemBars", "systemBarsIgnoringVisibility", "getSystemBarsIgnoringVisibility$annotations", "getSystemBarsIgnoringVisibility", "systemGestures", "getSystemGestures", "tappableElement", "getTappableElement", "tappableElementIgnoringVisibility", "getTappableElementIgnoringVisibility$annotations", "getTappableElementIgnoringVisibility", "waterfall", "getWaterfall", "ValueInsets", "Landroidx/compose/foundation/layout/ValueInsets;", "insets", "Landroidx/core/graphics/Insets;", "name", "", "toInsetsValues", "Landroidx/compose/foundation/layout/InsetsValues;", "foundation-layout_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class WindowInsets_androidKt {
    public static /* synthetic */ void getAreNavigationBarsVisible$annotations(WindowInsets.Companion companion) {
    }

    public static /* synthetic */ void getAreStatusBarsVisible$annotations(WindowInsets.Companion companion) {
    }

    public static /* synthetic */ void getAreSystemBarsVisible$annotations(WindowInsets.Companion companion) {
    }

    public static /* synthetic */ void getCaptionBarIgnoringVisibility$annotations(WindowInsets.Companion companion) {
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Please use AbstractComposeView.consumeWindowInsets")
    public static /* synthetic */ void getConsumeWindowInsets$annotations(ComposeView composeView) {
    }

    public static /* synthetic */ void getImeAnimationSource$annotations(WindowInsets.Companion companion) {
    }

    public static /* synthetic */ void getImeAnimationTarget$annotations(WindowInsets.Companion companion) {
    }

    public static /* synthetic */ void getNavigationBarsIgnoringVisibility$annotations(WindowInsets.Companion companion) {
    }

    public static /* synthetic */ void getStatusBarsIgnoringVisibility$annotations(WindowInsets.Companion companion) {
    }

    public static /* synthetic */ void getSystemBarsIgnoringVisibility$annotations(WindowInsets.Companion companion) {
    }

    public static /* synthetic */ void getTappableElementIgnoringVisibility$annotations(WindowInsets.Companion companion) {
    }

    public static /* synthetic */ void isCaptionBarVisible$annotations(WindowInsets.Companion companion) {
    }

    public static /* synthetic */ void isImeVisible$annotations(WindowInsets.Companion companion) {
    }

    public static /* synthetic */ void isTappableElementVisible$annotations(WindowInsets.Companion companion) {
    }

    public static final InsetsValues toInsetsValues(Insets insets) {
        return new InsetsValues(insets.left, insets.top, insets.right, insets.bottom);
    }

    public static final ValueInsets ValueInsets(Insets insets, String str) {
        return new ValueInsets(toInsetsValues(insets), str);
    }

    public static final boolean getConsumeWindowInsets(AbstractComposeView abstractComposeView) {
        Object tag = abstractComposeView.getTag(androidx.compose.ui.R.id.consume_window_insets_tag);
        Boolean bool = tag instanceof Boolean ? (Boolean) tag : null;
        if (bool != null) {
            return bool.booleanValue();
        }
        return true;
    }

    public static final void setConsumeWindowInsets(AbstractComposeView abstractComposeView, boolean z) {
        abstractComposeView.setTag(androidx.compose.ui.R.id.consume_window_insets_tag, Boolean.valueOf(z));
    }

    public static final /* synthetic */ boolean getConsumeWindowInsets(ComposeView composeView) {
        Object tag = composeView.getTag(androidx.compose.ui.R.id.consume_window_insets_tag);
        Boolean bool = tag instanceof Boolean ? (Boolean) tag : null;
        if (bool != null) {
            return bool.booleanValue();
        }
        return true;
    }

    public static final WindowInsets getCaptionBar(WindowInsets.Companion companion, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1832025528, "C(<get-captionBar>)136@4932L9:WindowInsets.android.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1832025528, i, -1, "androidx.compose.foundation.layout.<get-captionBar> (WindowInsets.android.kt:136)");
        }
        AndroidWindowInsets captionBar = WindowInsetsHolder.Companion.current(composer, 6).getCaptionBar();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return captionBar;
    }

    public static final WindowInsets getDisplayCutout(WindowInsets.Companion companion, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1324817724, "C(<get-displayCutout>)143@5272L9:WindowInsets.android.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1324817724, i, -1, "androidx.compose.foundation.layout.<get-displayCutout> (WindowInsets.android.kt:143)");
        }
        AndroidWindowInsets displayCutout = WindowInsetsHolder.Companion.current(composer, 6).getDisplayCutout();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return displayCutout;
    }

    public static final WindowInsets getIme(WindowInsets.Companion companion, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1466917860, "C(<get-ime>)155@5898L9:WindowInsets.android.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1466917860, i, -1, "androidx.compose.foundation.layout.<get-ime> (WindowInsets.android.kt:155)");
        }
        AndroidWindowInsets ime = WindowInsetsHolder.Companion.current(composer, 6).getIme();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return ime;
    }

    public static final WindowInsets getMandatorySystemGestures(WindowInsets.Companion companion, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1369492988, "C(<get-mandatorySystemGestures>)164@6232L9:WindowInsets.android.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1369492988, i, -1, "androidx.compose.foundation.layout.<get-mandatorySystemGestures> (WindowInsets.android.kt:164)");
        }
        AndroidWindowInsets mandatorySystemGestures = WindowInsetsHolder.Companion.current(composer, 6).getMandatorySystemGestures();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return mandatorySystemGestures;
    }

    public static final WindowInsets getNavigationBars(WindowInsets.Companion companion, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1596175702, "C(<get-navigationBars>)171@6580L9:WindowInsets.android.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1596175702, i, -1, "androidx.compose.foundation.layout.<get-navigationBars> (WindowInsets.android.kt:171)");
        }
        AndroidWindowInsets navigationBars = WindowInsetsHolder.Companion.current(composer, 6).getNavigationBars();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return navigationBars;
    }

    public static final WindowInsets getStatusBars(WindowInsets.Companion companion, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -675090670, "C(<get-statusBars>)175@6787L9:WindowInsets.android.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-675090670, i, -1, "androidx.compose.foundation.layout.<get-statusBars> (WindowInsets.android.kt:175)");
        }
        AndroidWindowInsets statusBars = WindowInsetsHolder.Companion.current(composer, 6).getStatusBars();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return statusBars;
    }

    public static final WindowInsets getSystemBars(WindowInsets.Companion companion, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -282936756, "C(<get-systemBars>)179@6990L9:WindowInsets.android.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-282936756, i, -1, "androidx.compose.foundation.layout.<get-systemBars> (WindowInsets.android.kt:179)");
        }
        AndroidWindowInsets systemBars = WindowInsetsHolder.Companion.current(composer, 6).getSystemBars();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return systemBars;
    }

    public static final WindowInsets getSystemGestures(WindowInsets.Companion companion, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 989216224, "C(<get-systemGestures>)183@7201L9:WindowInsets.android.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(989216224, i, -1, "androidx.compose.foundation.layout.<get-systemGestures> (WindowInsets.android.kt:183)");
        }
        AndroidWindowInsets systemGestures = WindowInsetsHolder.Companion.current(composer, 6).getSystemGestures();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return systemGestures;
    }

    public static final WindowInsets getTappableElement(WindowInsets.Companion companion, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1994205284, "C(<get-tappableElement>)187@7418L9:WindowInsets.android.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1994205284, i, -1, "androidx.compose.foundation.layout.<get-tappableElement> (WindowInsets.android.kt:187)");
        }
        AndroidWindowInsets tappableElement = WindowInsetsHolder.Companion.current(composer, 6).getTappableElement();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return tappableElement;
    }

    public static final WindowInsets getWaterfall(WindowInsets.Companion companion, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1943241020, "C(<get-waterfall>)191@7635L9:WindowInsets.android.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1943241020, i, -1, "androidx.compose.foundation.layout.<get-waterfall> (WindowInsets.android.kt:191)");
        }
        ValueInsets waterfall = WindowInsetsHolder.Companion.current(composer, 6).getWaterfall();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return waterfall;
    }

    public static final WindowInsets getSafeDrawing(WindowInsets.Companion companion, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -49441252, "C(<get-safeDrawing>)198@7986L9:WindowInsets.android.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-49441252, i, -1, "androidx.compose.foundation.layout.<get-safeDrawing> (WindowInsets.android.kt:198)");
        }
        WindowInsets safeDrawing = WindowInsetsHolder.Companion.current(composer, 6).getSafeDrawing();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return safeDrawing;
    }

    public static final WindowInsets getSafeGestures(WindowInsets.Companion companion, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1594247780, "C(<get-safeGestures>)206@8409L9:WindowInsets.android.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1594247780, i, -1, "androidx.compose.foundation.layout.<get-safeGestures> (WindowInsets.android.kt:206)");
        }
        WindowInsets safeGestures = WindowInsetsHolder.Companion.current(composer, 6).getSafeGestures();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return safeGestures;
    }

    public static final WindowInsets getSafeContent(WindowInsets.Companion companion, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -2026663876, "C(<get-safeContent>)213@8718L9:WindowInsets.android.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2026663876, i, -1, "androidx.compose.foundation.layout.<get-safeContent> (WindowInsets.android.kt:213)");
        }
        WindowInsets safeContent = WindowInsetsHolder.Companion.current(composer, 6).getSafeContent();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return safeContent;
    }

    public static final WindowInsets getCaptionBarIgnoringVisibility(WindowInsets.Companion companion, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1731251574, "C(<get-captionBarIgnoringVisibility>)225@9126L9:WindowInsets.android.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1731251574, i, -1, "androidx.compose.foundation.layout.<get-captionBarIgnoringVisibility> (WindowInsets.android.kt:225)");
        }
        ValueInsets captionBarIgnoringVisibility = WindowInsetsHolder.Companion.current(composer, 6).getCaptionBarIgnoringVisibility();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return captionBarIgnoringVisibility;
    }

    public static final WindowInsets getNavigationBarsIgnoringVisibility(WindowInsets.Companion companion, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1990981160, "C(<get-navigationBarsIgnoringVisibility>)238@9689L9:WindowInsets.android.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1990981160, i, -1, "androidx.compose.foundation.layout.<get-navigationBarsIgnoringVisibility> (WindowInsets.android.kt:238)");
        }
        ValueInsets navigationBarsIgnoringVisibility = WindowInsetsHolder.Companion.current(composer, 6).getNavigationBarsIgnoringVisibility();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return navigationBarsIgnoringVisibility;
    }

    public static final WindowInsets getStatusBarsIgnoringVisibility(WindowInsets.Companion companion, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 594020756, "C(<get-statusBarsIgnoringVisibility>)250@10130L9:WindowInsets.android.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(594020756, i, -1, "androidx.compose.foundation.layout.<get-statusBarsIgnoringVisibility> (WindowInsets.android.kt:250)");
        }
        ValueInsets statusBarsIgnoringVisibility = WindowInsetsHolder.Companion.current(composer, 6).getStatusBarsIgnoringVisibility();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return statusBarsIgnoringVisibility;
    }

    public static final WindowInsets getSystemBarsIgnoringVisibility(WindowInsets.Companion companion, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1564566798, "C(<get-systemBarsIgnoringVisibility>)263@10567L9:WindowInsets.android.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1564566798, i, -1, "androidx.compose.foundation.layout.<get-systemBarsIgnoringVisibility> (WindowInsets.android.kt:263)");
        }
        ValueInsets systemBarsIgnoringVisibility = WindowInsetsHolder.Companion.current(composer, 6).getSystemBarsIgnoringVisibility();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return systemBarsIgnoringVisibility;
    }

    public static final WindowInsets getTappableElementIgnoringVisibility(WindowInsets.Companion companion, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1488788292, "C(<get-tappableElementIgnoringVisibility>)276@11012L9:WindowInsets.android.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1488788292, i, -1, "androidx.compose.foundation.layout.<get-tappableElementIgnoringVisibility> (WindowInsets.android.kt:276)");
        }
        ValueInsets tappableElementIgnoringVisibility = WindowInsetsHolder.Companion.current(composer, 6).getTappableElementIgnoringVisibility();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return tappableElementIgnoringVisibility;
    }

    public static final boolean isCaptionBarVisible(WindowInsets.Companion companion, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -501076620, "C(<get-isCaptionBarVisible>)288@11418L9:WindowInsets.android.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-501076620, i, -1, "androidx.compose.foundation.layout.<get-isCaptionBarVisible> (WindowInsets.android.kt:288)");
        }
        boolean isVisible = WindowInsetsHolder.Companion.current(composer, 6).getCaptionBar().isVisible();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return isVisible;
    }

    public static final boolean isImeVisible(WindowInsets.Companion companion, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1873571424, "C(<get-isImeVisible>)300@11799L9:WindowInsets.android.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1873571424, i, -1, "androidx.compose.foundation.layout.<get-isImeVisible> (WindowInsets.android.kt:300)");
        }
        boolean isVisible = WindowInsetsHolder.Companion.current(composer, 6).getIme().isVisible();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return isVisible;
    }

    public static final boolean getAreStatusBarsVisible(WindowInsets.Companion companion, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1613283456, "C(<get-areStatusBarsVisible>)312@12176L9:WindowInsets.android.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1613283456, i, -1, "androidx.compose.foundation.layout.<get-areStatusBarsVisible> (WindowInsets.android.kt:312)");
        }
        boolean isVisible = WindowInsetsHolder.Companion.current(composer, 6).getStatusBars().isVisible();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return isVisible;
    }

    public static final boolean getAreNavigationBarsVisible(WindowInsets.Companion companion, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 710310464, "C(<get-areNavigationBarsVisible>)324@12568L9:WindowInsets.android.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(710310464, i, -1, "androidx.compose.foundation.layout.<get-areNavigationBarsVisible> (WindowInsets.android.kt:324)");
        }
        boolean isVisible = WindowInsetsHolder.Companion.current(composer, 6).getNavigationBars().isVisible();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return isVisible;
    }

    public static final boolean getAreSystemBarsVisible(WindowInsets.Companion companion, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1985490720, "C(<get-areSystemBarsVisible>)336@12956L9:WindowInsets.android.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1985490720, i, -1, "androidx.compose.foundation.layout.<get-areSystemBarsVisible> (WindowInsets.android.kt:336)");
        }
        boolean isVisible = WindowInsetsHolder.Companion.current(composer, 6).getSystemBars().isVisible();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return isVisible;
    }

    public static final boolean isTappableElementVisible(WindowInsets.Companion companion, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1737201120, "C(<get-isTappableElementVisible>)347@13347L9:WindowInsets.android.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1737201120, i, -1, "androidx.compose.foundation.layout.<get-isTappableElementVisible> (WindowInsets.android.kt:347)");
        }
        boolean isVisible = WindowInsetsHolder.Companion.current(composer, 6).getTappableElement().isVisible();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return isVisible;
    }

    public static final WindowInsets getImeAnimationSource(WindowInsets.Companion companion, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1126064918, "C(<get-imeAnimationSource>)361@13856L9:WindowInsets.android.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1126064918, i, -1, "androidx.compose.foundation.layout.<get-imeAnimationSource> (WindowInsets.android.kt:361)");
        }
        ValueInsets imeAnimationSource = WindowInsetsHolder.Companion.current(composer, 6).getImeAnimationSource();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return imeAnimationSource;
    }

    public static final WindowInsets getImeAnimationTarget(WindowInsets.Companion companion, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -466319786, "C(<get-imeAnimationTarget>)375@14394L9:WindowInsets.android.kt#2w3rfo");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-466319786, i, -1, "androidx.compose.foundation.layout.<get-imeAnimationTarget> (WindowInsets.android.kt:375)");
        }
        ValueInsets imeAnimationTarget = WindowInsetsHolder.Companion.current(composer, 6).getImeAnimationTarget();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return imeAnimationTarget;
    }
}
