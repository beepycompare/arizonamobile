package androidx.window.embedding;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import android.util.Pair;
import android.view.WindowMetrics;
import androidx.window.WindowSdkExtensions;
import androidx.window.core.Bounds;
import androidx.window.core.PredicateAdapter;
import androidx.window.embedding.DividerAttributes;
import androidx.window.embedding.EmbeddingAdapter;
import androidx.window.embedding.EmbeddingAnimationBackground;
import androidx.window.embedding.EmbeddingAnimationParams;
import androidx.window.embedding.EmbeddingConfiguration;
import androidx.window.embedding.SplitAttributes;
import androidx.window.embedding.SplitRule;
import androidx.window.extensions.embedding.ActivityRule;
import androidx.window.extensions.embedding.AnimationBackground;
import androidx.window.extensions.embedding.AnimationParams;
import androidx.window.extensions.embedding.DividerAttributes;
import androidx.window.extensions.embedding.SplitAttributes;
import androidx.window.extensions.embedding.SplitInfo;
import androidx.window.extensions.embedding.SplitPairRule;
import androidx.window.extensions.embedding.SplitPinRule;
import androidx.window.extensions.embedding.SplitPlaceholderRule;
import androidx.window.extensions.embedding.WindowAttributes;
import androidx.window.extensions.layout.WindowLayoutInfo;
import androidx.window.layout.WindowMetricsCalculator;
import androidx.window.layout.adapter.extensions.ExtensionsWindowLayoutInfoAdapter;
import androidx.window.layout.util.DensityCompatHelper;
import androidx.window.reflection.JFunction2;
import androidx.window.reflection.Predicate2;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
/* compiled from: EmbeddingAdapter.kt */
@Metadata(d1 = {"\u0000\u0086\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 d2\u00020\u0001:\u0004abcdB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0019J\u0010\u0010\u0018\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001cH\u0002J\u0015\u0010\u0018\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0000¢\u0006\u0002\b!J!\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00192\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020 0\u0019H\u0000¢\u0006\u0002\b!J\u0015\u0010\u0018\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0000¢\u0006\u0002\b!J\u0015\u0010\u0018\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0001¢\u0006\u0002\b!J&\u0010)\u001a\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020%0*2\u0012\u0010,\u001a\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020#0-J\u0010\u0010\u0018\u001a\u00020.2\u0006\u0010/\u001a\u00020+H\u0007J$\u00100\u001a\u0002012\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u0002052\n\u00106\u001a\u0006\u0012\u0002\b\u000307H\u0002J\u0016\u00108\u001a\u0002092\u0006\u00102\u001a\u0002032\u0006\u0010:\u001a\u00020;J\u000e\u0010<\u001a\u00020%2\u0006\u0010$\u001a\u00020#J\r\u0010=\u001a\u00020>H\u0000¢\u0006\u0002\b?J\u0010\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020CH\u0002J$\u0010D\u001a\u00020E2\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u00020F2\n\u00106\u001a\u0006\u0012\u0002\b\u000307H\u0002J\u000e\u0010G\u001a\u00020\u00072\u0006\u0010H\u001a\u00020IJ\u001c\u0010J\u001a\u00020K2\u0006\u00104\u001a\u00020L2\n\u00106\u001a\u0006\u0012\u0002\b\u000307H\u0002J\"\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020N0M2\u0006\u00102\u001a\u0002032\f\u0010O\u001a\b\u0012\u0004\u0012\u00020P0MJ\u0010\u0010Q\u001a\u00020R2\u0006\u0010S\u001a\u00020TH\u0003J\u0010\u0010U\u001a\u00020T2\u0006\u0010S\u001a\u00020RH\u0003J\u0010\u0010V\u001a\u00020\u00072\u0006\u0010W\u001a\u00020XH\u0003J\u0010\u0010Y\u001a\u00020X2\u0006\u0010Z\u001a\u00020\u0007H\u0003J\u0012\u0010[\u001a\u0004\u0018\u00010\\2\u0006\u0010]\u001a\u00020^H\u0007J\u0012\u0010_\u001a\u00020^2\b\u0010`\u001a\u0004\u0018\u00010\\H\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00060\u000bR\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00060\rR\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00060\u000fR\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006e"}, d2 = {"Landroidx/window/embedding/EmbeddingAdapter;", "", "predicateAdapter", "Landroidx/window/core/PredicateAdapter;", "<init>", "(Landroidx/window/core/PredicateAdapter;)V", "extensionVersion", "", "getExtensionVersion", "()I", "api1Impl", "Landroidx/window/embedding/EmbeddingAdapter$VendorApiLevel1Impl;", "api2Impl", "Landroidx/window/embedding/EmbeddingAdapter$VendorApiLevel2Impl;", "api3Impl", "Landroidx/window/embedding/EmbeddingAdapter$VendorApiLevel3Impl;", "embeddingConfiguration", "Landroidx/window/embedding/EmbeddingConfiguration;", "getEmbeddingConfiguration$annotations", "()V", "getEmbeddingConfiguration", "()Landroidx/window/embedding/EmbeddingConfiguration;", "setEmbeddingConfiguration", "(Landroidx/window/embedding/EmbeddingConfiguration;)V", "translate", "", "Landroidx/window/embedding/SplitInfo;", "splitInfoList", "Landroidx/window/extensions/embedding/SplitInfo;", "splitInfo", "Landroidx/window/embedding/ActivityStack;", "activityStack", "Landroidx/window/extensions/embedding/ActivityStack;", "translate$window_release", "activityStacks", "Landroidx/window/embedding/SplitAttributes;", "splitAttributes", "Landroidx/window/extensions/embedding/SplitAttributes;", "Landroidx/window/embedding/ParentContainerInfo;", "parentContainerInfo", "Landroidx/window/extensions/embedding/ParentContainerInfo;", "translateSplitAttributesCalculator", "Landroidx/window/reflection/JFunction2;", "Landroidx/window/extensions/embedding/SplitAttributesCalculatorParams;", "calculator", "Lkotlin/Function1;", "Landroidx/window/embedding/SplitAttributesCalculatorParams;", "params", "translateSplitPairRule", "Landroidx/window/extensions/embedding/SplitPairRule;", "context", "Landroid/content/Context;", "rule", "Landroidx/window/embedding/SplitPairRule;", "predicateClass", "Ljava/lang/Class;", "translateSplitPinRule", "Landroidx/window/extensions/embedding/SplitPinRule;", "splitPinRule", "Landroidx/window/embedding/SplitPinRule;", "translateSplitAttributes", "translateWindowAttributes", "Landroidx/window/extensions/embedding/WindowAttributes;", "translateWindowAttributes$window_release", "translateSplitType", "Landroidx/window/extensions/embedding/SplitAttributes$SplitType;", "splitType", "Landroidx/window/embedding/SplitAttributes$SplitType;", "translateSplitPlaceholderRule", "Landroidx/window/extensions/embedding/SplitPlaceholderRule;", "Landroidx/window/embedding/SplitPlaceholderRule;", "translateFinishBehavior", "behavior", "Landroidx/window/embedding/SplitRule$FinishBehavior;", "translateActivityRule", "Landroidx/window/extensions/embedding/ActivityRule;", "Landroidx/window/embedding/ActivityRule;", "", "Landroidx/window/extensions/embedding/EmbeddingRule;", "rules", "Landroidx/window/embedding/EmbeddingRule;", "translateToOemAnimationBackground", "Landroidx/window/extensions/embedding/AnimationBackground;", "animationBackground", "Landroidx/window/embedding/EmbeddingAnimationBackground;", "translateToJetpackAnimationBackground", "translateToOemAnimationResId", "animationSpec", "Landroidx/window/embedding/EmbeddingAnimationParams$AnimationSpec;", "translateToJetpackAnimationSpec", "animationResId", "translateToOemDividerAttributes", "Landroidx/window/extensions/embedding/DividerAttributes;", "dividerAttributes", "Landroidx/window/embedding/DividerAttributes;", "translateToJetpackDividerAttributes", "oemDividerAttributes", "VendorApiLevel3Impl", "VendorApiLevel2Impl", "VendorApiLevel1Impl", "Companion", "window_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class EmbeddingAdapter {
    private final VendorApiLevel1Impl api1Impl;
    private final VendorApiLevel2Impl api2Impl;
    private final VendorApiLevel3Impl api3Impl;
    private EmbeddingConfiguration embeddingConfiguration;
    private final PredicateAdapter predicateAdapter;
    public static final Companion Companion = new Companion(null);
    private static final String TAG = Reflection.getOrCreateKotlinClass(EmbeddingAdapter.class).getSimpleName();
    private static final String RULE_TAG_PREFIX = "ae-gen:";
    private static final Binder INVALID_SPLIT_INFO_TOKEN = new Binder();

    public static /* synthetic */ void getEmbeddingConfiguration$annotations() {
    }

    public EmbeddingAdapter(PredicateAdapter predicateAdapter) {
        Intrinsics.checkNotNullParameter(predicateAdapter, "predicateAdapter");
        this.predicateAdapter = predicateAdapter;
        this.api1Impl = new VendorApiLevel1Impl(this, predicateAdapter);
        this.api2Impl = new VendorApiLevel2Impl();
        this.api3Impl = new VendorApiLevel3Impl();
    }

    private final int getExtensionVersion() {
        return WindowSdkExtensions.Companion.getInstance().getExtensionVersion();
    }

    public final EmbeddingConfiguration getEmbeddingConfiguration() {
        return this.embeddingConfiguration;
    }

    public final void setEmbeddingConfiguration(EmbeddingConfiguration embeddingConfiguration) {
        this.embeddingConfiguration = embeddingConfiguration;
    }

    public final List<SplitInfo> translate(List<? extends androidx.window.extensions.embedding.SplitInfo> splitInfoList) {
        Intrinsics.checkNotNullParameter(splitInfoList, "splitInfoList");
        List<? extends androidx.window.extensions.embedding.SplitInfo> list = splitInfoList;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (androidx.window.extensions.embedding.SplitInfo splitInfo : list) {
            arrayList.add(translate(splitInfo));
        }
        return arrayList;
    }

    private final SplitInfo translate(androidx.window.extensions.embedding.SplitInfo splitInfo) {
        int extensionVersion = getExtensionVersion();
        if (extensionVersion == 1) {
            return this.api1Impl.translateCompat(splitInfo);
        }
        if (extensionVersion == 2) {
            return this.api2Impl.translateCompat(splitInfo);
        }
        if (3 <= extensionVersion && extensionVersion < 5) {
            return this.api3Impl.translateCompat(splitInfo);
        }
        androidx.window.extensions.embedding.ActivityStack primaryActivityStack = splitInfo.getPrimaryActivityStack();
        Intrinsics.checkNotNullExpressionValue(primaryActivityStack, "getPrimaryActivityStack(...)");
        ActivityStack translate$window_release = translate$window_release(primaryActivityStack);
        androidx.window.extensions.embedding.ActivityStack secondaryActivityStack = splitInfo.getSecondaryActivityStack();
        Intrinsics.checkNotNullExpressionValue(secondaryActivityStack, "getSecondaryActivityStack(...)");
        ActivityStack translate$window_release2 = translate$window_release(secondaryActivityStack);
        androidx.window.extensions.embedding.SplitAttributes splitAttributes = splitInfo.getSplitAttributes();
        Intrinsics.checkNotNullExpressionValue(splitAttributes, "getSplitAttributes(...)");
        SplitAttributes translate$window_release3 = translate$window_release(splitAttributes);
        SplitInfo.Token splitInfoToken = splitInfo.getSplitInfoToken();
        Intrinsics.checkNotNullExpressionValue(splitInfoToken, "getSplitInfoToken(...)");
        return new SplitInfo(translate$window_release, translate$window_release2, translate$window_release3, splitInfoToken);
    }

    public final ActivityStack translate$window_release(androidx.window.extensions.embedding.ActivityStack activityStack) {
        Intrinsics.checkNotNullParameter(activityStack, "activityStack");
        int extensionVersion = getExtensionVersion();
        if (1 <= extensionVersion && extensionVersion < 5) {
            return this.api1Impl.translateCompat(activityStack);
        }
        List activities = activityStack.getActivities();
        Intrinsics.checkNotNullExpressionValue(activities, "getActivities(...)");
        return new ActivityStack(activities, activityStack.isEmpty(), activityStack.getActivityStackToken());
    }

    public final List<ActivityStack> translate$window_release(List<? extends androidx.window.extensions.embedding.ActivityStack> activityStacks) {
        Intrinsics.checkNotNullParameter(activityStacks, "activityStacks");
        List<? extends androidx.window.extensions.embedding.ActivityStack> list = activityStacks;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (androidx.window.extensions.embedding.ActivityStack activityStack : list) {
            arrayList.add(translate$window_release(activityStack));
        }
        return arrayList;
    }

    public final SplitAttributes translate$window_release(androidx.window.extensions.embedding.SplitAttributes splitAttributes) {
        SplitAttributes.SplitType ratio;
        SplitAttributes.LayoutDirection layoutDirection;
        Intrinsics.checkNotNullParameter(splitAttributes, "splitAttributes");
        SplitAttributes.Builder builder = new SplitAttributes.Builder();
        SplitAttributes.SplitType.RatioSplitType splitType = splitAttributes.getSplitType();
        Intrinsics.checkNotNullExpressionValue(splitType, "getSplitType(...)");
        if (splitType instanceof SplitAttributes.SplitType.HingeSplitType) {
            ratio = SplitAttributes.SplitType.SPLIT_TYPE_HINGE;
        } else if (splitType instanceof SplitAttributes.SplitType.ExpandContainersSplitType) {
            ratio = SplitAttributes.SplitType.SPLIT_TYPE_EXPAND;
        } else if (!(splitType instanceof SplitAttributes.SplitType.RatioSplitType)) {
            throw new IllegalArgumentException("Unknown split type: " + splitType);
        } else {
            ratio = SplitAttributes.SplitType.Companion.ratio(splitType.getRatio());
        }
        SplitAttributes.Builder splitType2 = builder.setSplitType(ratio);
        int layoutDirection2 = splitAttributes.getLayoutDirection();
        if (layoutDirection2 == 0) {
            layoutDirection = SplitAttributes.LayoutDirection.LEFT_TO_RIGHT;
        } else if (layoutDirection2 == 1) {
            layoutDirection = SplitAttributes.LayoutDirection.RIGHT_TO_LEFT;
        } else if (layoutDirection2 == 3) {
            layoutDirection = SplitAttributes.LayoutDirection.LOCALE;
        } else if (layoutDirection2 == 4) {
            layoutDirection = SplitAttributes.LayoutDirection.TOP_TO_BOTTOM;
        } else if (layoutDirection2 == 5) {
            layoutDirection = SplitAttributes.LayoutDirection.BOTTOM_TO_TOP;
        } else {
            throw new IllegalArgumentException("Unknown layout direction: " + layoutDirection2);
        }
        SplitAttributes.Builder layoutDirection3 = splitType2.setLayoutDirection(layoutDirection);
        int extensionVersion = getExtensionVersion();
        if (5 <= extensionVersion && extensionVersion < 7) {
            EmbeddingAnimationParams.Builder builder2 = new EmbeddingAnimationParams.Builder();
            AnimationBackground animationBackground = splitAttributes.getAnimationBackground();
            Intrinsics.checkNotNullExpressionValue(animationBackground, "getAnimationBackground(...)");
            layoutDirection3.setAnimationParams(builder2.setAnimationBackground(translateToJetpackAnimationBackground(animationBackground)).build());
        }
        if (getExtensionVersion() >= 7) {
            EmbeddingAnimationParams.Builder builder3 = new EmbeddingAnimationParams.Builder();
            AnimationBackground animationBackground2 = splitAttributes.getAnimationParams().getAnimationBackground();
            Intrinsics.checkNotNullExpressionValue(animationBackground2, "getAnimationBackground(...)");
            layoutDirection3.setAnimationParams(builder3.setAnimationBackground(translateToJetpackAnimationBackground(animationBackground2)).setOpenAnimation(translateToJetpackAnimationSpec(splitAttributes.getAnimationParams().getOpenAnimationResId())).setCloseAnimation(translateToJetpackAnimationSpec(splitAttributes.getAnimationParams().getCloseAnimationResId())).setChangeAnimation(translateToJetpackAnimationSpec(splitAttributes.getAnimationParams().getChangeAnimationResId())).build());
        }
        if (getExtensionVersion() >= 6) {
            layoutDirection3.setDividerAttributes(translateToJetpackDividerAttributes(splitAttributes.getDividerAttributes()));
        }
        return layoutDirection3.build();
    }

    public final ParentContainerInfo translate$window_release(androidx.window.extensions.embedding.ParentContainerInfo parentContainerInfo) {
        Intrinsics.checkNotNullParameter(parentContainerInfo, "parentContainerInfo");
        Configuration configuration = parentContainerInfo.getConfiguration();
        Intrinsics.checkNotNullExpressionValue(configuration, "getConfiguration(...)");
        DensityCompatHelper companion = DensityCompatHelper.Companion.getInstance();
        Configuration configuration2 = parentContainerInfo.getConfiguration();
        Intrinsics.checkNotNullExpressionValue(configuration2, "getConfiguration(...)");
        WindowMetrics windowMetrics = parentContainerInfo.getWindowMetrics();
        Intrinsics.checkNotNullExpressionValue(windowMetrics, "getWindowMetrics(...)");
        float density = companion.density(configuration2, windowMetrics);
        WindowMetricsCalculator.Companion companion2 = WindowMetricsCalculator.Companion;
        WindowMetrics windowMetrics2 = parentContainerInfo.getWindowMetrics();
        Intrinsics.checkNotNullExpressionValue(windowMetrics2, "getWindowMetrics(...)");
        androidx.window.layout.WindowMetrics translateWindowMetrics$window_release = companion2.translateWindowMetrics$window_release(windowMetrics2, density);
        Bounds bounds = new Bounds(translateWindowMetrics$window_release.getBounds());
        ExtensionsWindowLayoutInfoAdapter extensionsWindowLayoutInfoAdapter = ExtensionsWindowLayoutInfoAdapter.INSTANCE;
        WindowLayoutInfo windowLayoutInfo = parentContainerInfo.getWindowLayoutInfo();
        Intrinsics.checkNotNullExpressionValue(windowLayoutInfo, "getWindowLayoutInfo(...)");
        return new ParentContainerInfo(bounds, extensionsWindowLayoutInfoAdapter.translate$window_release(translateWindowMetrics$window_release, windowLayoutInfo), configuration, density);
    }

    public final JFunction2<androidx.window.extensions.embedding.SplitAttributesCalculatorParams, androidx.window.extensions.embedding.SplitAttributes> translateSplitAttributesCalculator(final Function1<? super SplitAttributesCalculatorParams, SplitAttributes> calculator) {
        Intrinsics.checkNotNullParameter(calculator, "calculator");
        return new JFunction2() { // from class: androidx.window.embedding.EmbeddingAdapter$$ExternalSyntheticLambda1
            @Override // androidx.window.reflection.JFunction2
            public final Object apply(Object obj) {
                return EmbeddingAdapter.translateSplitAttributesCalculator$lambda$1(EmbeddingAdapter.this, calculator, (androidx.window.extensions.embedding.SplitAttributesCalculatorParams) obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final androidx.window.extensions.embedding.SplitAttributes translateSplitAttributesCalculator$lambda$1(EmbeddingAdapter embeddingAdapter, Function1 function1, androidx.window.extensions.embedding.SplitAttributesCalculatorParams oemParams) {
        Intrinsics.checkNotNullParameter(oemParams, "oemParams");
        return embeddingAdapter.translateSplitAttributes((SplitAttributes) function1.invoke(embeddingAdapter.translate(oemParams)));
    }

    public final SplitAttributesCalculatorParams translate(androidx.window.extensions.embedding.SplitAttributesCalculatorParams params) {
        String str;
        Intrinsics.checkNotNullParameter(params, "params");
        WindowMetrics parentWindowMetrics = params.getParentWindowMetrics();
        Intrinsics.checkNotNullExpressionValue(parentWindowMetrics, "getParentWindowMetrics(...)");
        Configuration parentConfiguration = params.getParentConfiguration();
        Intrinsics.checkNotNullExpressionValue(parentConfiguration, "getParentConfiguration(...)");
        WindowLayoutInfo parentWindowLayoutInfo = params.getParentWindowLayoutInfo();
        Intrinsics.checkNotNullExpressionValue(parentWindowLayoutInfo, "getParentWindowLayoutInfo(...)");
        androidx.window.extensions.embedding.SplitAttributes defaultSplitAttributes = params.getDefaultSplitAttributes();
        Intrinsics.checkNotNullExpressionValue(defaultSplitAttributes, "getDefaultSplitAttributes(...)");
        boolean areDefaultConstraintsSatisfied = params.areDefaultConstraintsSatisfied();
        if (params.getSplitRuleTag() != null) {
            Companion companion = Companion;
            String splitRuleTag = params.getSplitRuleTag();
            Intrinsics.checkNotNull(splitRuleTag);
            if (!companion.isTagGenerated(splitRuleTag)) {
                str = params.getSplitRuleTag();
                String str2 = str;
                androidx.window.layout.WindowMetrics translateWindowMetrics$window_release = WindowMetricsCalculator.Companion.translateWindowMetrics$window_release(parentWindowMetrics, DensityCompatHelper.Companion.getInstance().density(parentConfiguration, parentWindowMetrics));
                return new SplitAttributesCalculatorParams(translateWindowMetrics$window_release, parentConfiguration, ExtensionsWindowLayoutInfoAdapter.INSTANCE.translate$window_release(translateWindowMetrics$window_release, parentWindowLayoutInfo), translate$window_release(defaultSplitAttributes), areDefaultConstraintsSatisfied, str2);
            }
        }
        str = null;
        String str22 = str;
        androidx.window.layout.WindowMetrics translateWindowMetrics$window_release2 = WindowMetricsCalculator.Companion.translateWindowMetrics$window_release(parentWindowMetrics, DensityCompatHelper.Companion.getInstance().density(parentConfiguration, parentWindowMetrics));
        return new SplitAttributesCalculatorParams(translateWindowMetrics$window_release2, parentConfiguration, ExtensionsWindowLayoutInfoAdapter.INSTANCE.translate$window_release(translateWindowMetrics$window_release2, parentWindowLayoutInfo), translate$window_release(defaultSplitAttributes), areDefaultConstraintsSatisfied, str22);
    }

    private final androidx.window.extensions.embedding.SplitPairRule translateSplitPairRule(final Context context, final SplitPairRule splitPairRule, Class<?> cls) {
        if (getExtensionVersion() < 2) {
            return this.api1Impl.translateSplitPairRuleCompat(context, splitPairRule, cls);
        }
        Predicate2 predicate2 = new Predicate2() { // from class: androidx.window.embedding.EmbeddingAdapter$$ExternalSyntheticLambda5
            @Override // androidx.window.reflection.Predicate2
            public final boolean test(Object obj) {
                return EmbeddingAdapter.translateSplitPairRule$lambda$4(SplitPairRule.this, (Pair) obj);
            }
        };
        Predicate2 predicate22 = new Predicate2() { // from class: androidx.window.embedding.EmbeddingAdapter$$ExternalSyntheticLambda6
            @Override // androidx.window.reflection.Predicate2
            public final boolean test(Object obj) {
                return EmbeddingAdapter.translateSplitPairRule$lambda$6(SplitPairRule.this, (Pair) obj);
            }
        };
        Predicate2 predicate23 = new Predicate2() { // from class: androidx.window.embedding.EmbeddingAdapter$$ExternalSyntheticLambda7
            @Override // androidx.window.reflection.Predicate2
            public final boolean test(Object obj) {
                return EmbeddingAdapter.translateSplitPairRule$lambda$7(SplitPairRule.this, context, (WindowMetrics) obj);
            }
        };
        String tag = splitPairRule.getTag();
        SplitPairRule.Builder shouldClearTop = new SplitPairRule.Builder(predicate2, predicate22, predicate23).setDefaultSplitAttributes(translateSplitAttributes(splitPairRule.getDefaultSplitAttributes())).setFinishPrimaryWithSecondary(translateFinishBehavior(splitPairRule.getFinishPrimaryWithSecondary())).setFinishSecondaryWithPrimary(translateFinishBehavior(splitPairRule.getFinishSecondaryWithPrimary())).setShouldClearTop(splitPairRule.getClearTop());
        Intrinsics.checkNotNullExpressionValue(shouldClearTop, "setShouldClearTop(...)");
        if (tag == null) {
            tag = Companion.generateTag(splitPairRule);
        }
        shouldClearTop.setTag(tag);
        androidx.window.extensions.embedding.SplitPairRule build = shouldClearTop.build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        return build;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean translateSplitPairRule$lambda$4(SplitPairRule splitPairRule, Pair activitiesPair) {
        Intrinsics.checkNotNullParameter(activitiesPair, "activitiesPair");
        Set<SplitPairFilter> filters = splitPairRule.getFilters();
        if ((filters instanceof Collection) && filters.isEmpty()) {
            return false;
        }
        for (SplitPairFilter splitPairFilter : filters) {
            Object first = activitiesPair.first;
            Intrinsics.checkNotNullExpressionValue(first, "first");
            Object second = activitiesPair.second;
            Intrinsics.checkNotNullExpressionValue(second, "second");
            if (splitPairFilter.matchesActivityPair((Activity) first, (Activity) second)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean translateSplitPairRule$lambda$6(SplitPairRule splitPairRule, Pair activityIntentPair) {
        Intrinsics.checkNotNullParameter(activityIntentPair, "activityIntentPair");
        Set<SplitPairFilter> filters = splitPairRule.getFilters();
        if ((filters instanceof Collection) && filters.isEmpty()) {
            return false;
        }
        for (SplitPairFilter splitPairFilter : filters) {
            Object first = activityIntentPair.first;
            Intrinsics.checkNotNullExpressionValue(first, "first");
            Object second = activityIntentPair.second;
            Intrinsics.checkNotNullExpressionValue(second, "second");
            if (splitPairFilter.matchesActivityIntentPair((Activity) first, (Intent) second)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean translateSplitPairRule$lambda$7(SplitPairRule splitPairRule, Context context, WindowMetrics windowMetrics) {
        Intrinsics.checkNotNullParameter(windowMetrics, "windowMetrics");
        return splitPairRule.checkParentMetrics$window_release(context, windowMetrics);
    }

    public final androidx.window.extensions.embedding.SplitPinRule translateSplitPinRule(final Context context, final SplitPinRule splitPinRule) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(splitPinRule, "splitPinRule");
        WindowSdkExtensions.Companion.getInstance().requireExtensionVersion$window_release(5);
        SplitPinRule.Builder builder = new SplitPinRule.Builder(translateSplitAttributes(splitPinRule.getDefaultSplitAttributes()), new Predicate2() { // from class: androidx.window.embedding.EmbeddingAdapter$$ExternalSyntheticLambda0
            @Override // androidx.window.reflection.Predicate2
            public final boolean test(Object obj) {
                return EmbeddingAdapter.translateSplitPinRule$lambda$8(SplitPinRule.this, context, (WindowMetrics) obj);
            }
        });
        builder.setSticky(splitPinRule.isSticky());
        String tag = splitPinRule.getTag();
        if (tag == null) {
            tag = Companion.generateTag(splitPinRule);
        }
        builder.setTag(tag);
        androidx.window.extensions.embedding.SplitPinRule build = builder.build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        return build;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean translateSplitPinRule$lambda$8(SplitPinRule splitPinRule, Context context, WindowMetrics windowMetrics) {
        Intrinsics.checkNotNullParameter(windowMetrics, "windowMetrics");
        return splitPinRule.checkParentMetrics$window_release(context, windowMetrics);
    }

    public final androidx.window.extensions.embedding.SplitAttributes translateSplitAttributes(SplitAttributes splitAttributes) {
        int i;
        Intrinsics.checkNotNullParameter(splitAttributes, "splitAttributes");
        if (getExtensionVersion() < 2) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        SplitAttributes.Builder splitType = new SplitAttributes.Builder().setSplitType(translateSplitType(splitAttributes.getSplitType()));
        SplitAttributes.LayoutDirection layoutDirection = splitAttributes.getLayoutDirection();
        if (Intrinsics.areEqual(layoutDirection, SplitAttributes.LayoutDirection.LOCALE)) {
            i = 3;
        } else if (Intrinsics.areEqual(layoutDirection, SplitAttributes.LayoutDirection.LEFT_TO_RIGHT)) {
            i = 0;
        } else if (Intrinsics.areEqual(layoutDirection, SplitAttributes.LayoutDirection.RIGHT_TO_LEFT)) {
            i = 1;
        } else if (Intrinsics.areEqual(layoutDirection, SplitAttributes.LayoutDirection.TOP_TO_BOTTOM)) {
            i = 4;
        } else if (!Intrinsics.areEqual(layoutDirection, SplitAttributes.LayoutDirection.BOTTOM_TO_TOP)) {
            throw new IllegalArgumentException("Unsupported layoutDirection:" + splitAttributes + ".layoutDirection");
        } else {
            i = 5;
        }
        SplitAttributes.Builder layoutDirection2 = splitType.setLayoutDirection(i);
        Intrinsics.checkNotNullExpressionValue(layoutDirection2, "setLayoutDirection(...)");
        if (getExtensionVersion() >= 5) {
            layoutDirection2.setWindowAttributes(translateWindowAttributes$window_release());
        }
        int extensionVersion = getExtensionVersion();
        if (5 <= extensionVersion && extensionVersion < 7) {
            layoutDirection2.setAnimationBackground(translateToOemAnimationBackground(splitAttributes.getAnimationParams().getAnimationBackground()));
        }
        if (getExtensionVersion() >= 7) {
            AnimationParams build = new AnimationParams.Builder().setAnimationBackground(translateToOemAnimationBackground(splitAttributes.getAnimationParams().getAnimationBackground())).setOpenAnimationResId(translateToOemAnimationResId(splitAttributes.getAnimationParams().getOpenAnimation())).setCloseAnimationResId(translateToOemAnimationResId(splitAttributes.getAnimationParams().getCloseAnimation())).setChangeAnimationResId(translateToOemAnimationResId(splitAttributes.getAnimationParams().getChangeAnimation())).build();
            Intrinsics.checkNotNullExpressionValue(build, "build(...)");
            layoutDirection2.setAnimationParams(build);
        }
        if (getExtensionVersion() >= 6) {
            layoutDirection2.setDividerAttributes(translateToOemDividerAttributes(splitAttributes.getDividerAttributes()));
        }
        androidx.window.extensions.embedding.SplitAttributes build2 = layoutDirection2.build();
        Intrinsics.checkNotNullExpressionValue(build2, "build(...)");
        return build2;
    }

    public final WindowAttributes translateWindowAttributes$window_release() {
        WindowSdkExtensions.Companion.getInstance().requireExtensionVersion$window_release(5);
        EmbeddingConfiguration embeddingConfiguration = this.embeddingConfiguration;
        return new WindowAttributes(Intrinsics.areEqual(embeddingConfiguration != null ? embeddingConfiguration.getDimAreaBehavior() : null, EmbeddingConfiguration.DimAreaBehavior.ON_ACTIVITY_STACK) ? 1 : 2);
    }

    private final SplitAttributes.SplitType translateSplitType(SplitAttributes.SplitType splitType) {
        if (getExtensionVersion() < 2) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (Intrinsics.areEqual(splitType, SplitAttributes.SplitType.SPLIT_TYPE_HINGE)) {
            return new SplitAttributes.SplitType.HingeSplitType(translateSplitType(SplitAttributes.SplitType.SPLIT_TYPE_EQUAL));
        }
        if (Intrinsics.areEqual(splitType, SplitAttributes.SplitType.SPLIT_TYPE_EXPAND)) {
            return new SplitAttributes.SplitType.ExpandContainersSplitType();
        }
        float value$window_release = splitType.getValue$window_release();
        double d = value$window_release;
        if (d > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE && d < 1.0d) {
            return new SplitAttributes.SplitType.RatioSplitType(value$window_release);
        }
        throw new IllegalArgumentException("Unsupported SplitType: " + splitType + " with value: " + splitType.getValue$window_release());
    }

    private final androidx.window.extensions.embedding.SplitPlaceholderRule translateSplitPlaceholderRule(final Context context, final SplitPlaceholderRule splitPlaceholderRule, Class<?> cls) {
        if (getExtensionVersion() < 2) {
            return this.api1Impl.translateSplitPlaceholderRuleCompat(context, splitPlaceholderRule, cls);
        }
        Predicate2 predicate2 = new Predicate2() { // from class: androidx.window.embedding.EmbeddingAdapter$$ExternalSyntheticLambda2
            @Override // androidx.window.reflection.Predicate2
            public final boolean test(Object obj) {
                return EmbeddingAdapter.translateSplitPlaceholderRule$lambda$11(SplitPlaceholderRule.this, (Activity) obj);
            }
        };
        Predicate2 predicate22 = new Predicate2() { // from class: androidx.window.embedding.EmbeddingAdapter$$ExternalSyntheticLambda3
            @Override // androidx.window.reflection.Predicate2
            public final boolean test(Object obj) {
                return EmbeddingAdapter.translateSplitPlaceholderRule$lambda$13(SplitPlaceholderRule.this, (Intent) obj);
            }
        };
        Predicate2 predicate23 = new Predicate2() { // from class: androidx.window.embedding.EmbeddingAdapter$$ExternalSyntheticLambda4
            @Override // androidx.window.reflection.Predicate2
            public final boolean test(Object obj) {
                return EmbeddingAdapter.translateSplitPlaceholderRule$lambda$14(SplitPlaceholderRule.this, context, (WindowMetrics) obj);
            }
        };
        String tag = splitPlaceholderRule.getTag();
        SplitPlaceholderRule.Builder finishPrimaryWithPlaceholder = new SplitPlaceholderRule.Builder(splitPlaceholderRule.getPlaceholderIntent(), predicate2, predicate22, predicate23).setSticky(splitPlaceholderRule.isSticky()).setDefaultSplitAttributes(translateSplitAttributes(splitPlaceholderRule.getDefaultSplitAttributes())).setFinishPrimaryWithPlaceholder(translateFinishBehavior(splitPlaceholderRule.getFinishPrimaryWithPlaceholder()));
        Intrinsics.checkNotNullExpressionValue(finishPrimaryWithPlaceholder, "setFinishPrimaryWithPlaceholder(...)");
        if (tag == null) {
            tag = Companion.generateTag(splitPlaceholderRule);
        }
        finishPrimaryWithPlaceholder.setTag(tag);
        androidx.window.extensions.embedding.SplitPlaceholderRule build = finishPrimaryWithPlaceholder.build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        return build;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean translateSplitPlaceholderRule$lambda$11(SplitPlaceholderRule splitPlaceholderRule, Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Set<ActivityFilter> filters = splitPlaceholderRule.getFilters();
        if ((filters instanceof Collection) && filters.isEmpty()) {
            return false;
        }
        for (ActivityFilter activityFilter : filters) {
            if (activityFilter.matchesActivity(activity)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean translateSplitPlaceholderRule$lambda$13(SplitPlaceholderRule splitPlaceholderRule, Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        Set<ActivityFilter> filters = splitPlaceholderRule.getFilters();
        if ((filters instanceof Collection) && filters.isEmpty()) {
            return false;
        }
        for (ActivityFilter activityFilter : filters) {
            if (activityFilter.matchesIntent(intent)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean translateSplitPlaceholderRule$lambda$14(SplitPlaceholderRule splitPlaceholderRule, Context context, WindowMetrics windowMetrics) {
        Intrinsics.checkNotNullParameter(windowMetrics, "windowMetrics");
        return splitPlaceholderRule.checkParentMetrics$window_release(context, windowMetrics);
    }

    public final int translateFinishBehavior(SplitRule.FinishBehavior behavior) {
        Intrinsics.checkNotNullParameter(behavior, "behavior");
        if (Intrinsics.areEqual(behavior, SplitRule.FinishBehavior.NEVER)) {
            return 0;
        }
        if (Intrinsics.areEqual(behavior, SplitRule.FinishBehavior.ALWAYS)) {
            return 1;
        }
        if (Intrinsics.areEqual(behavior, SplitRule.FinishBehavior.ADJACENT)) {
            return 2;
        }
        throw new IllegalArgumentException("Unknown finish behavior:" + behavior);
    }

    private final androidx.window.extensions.embedding.ActivityRule translateActivityRule(final ActivityRule activityRule, Class<?> cls) {
        if (getExtensionVersion() < 2) {
            return this.api1Impl.translateActivityRuleCompat(activityRule, cls);
        }
        ActivityRule.Builder shouldAlwaysExpand = new ActivityRule.Builder(new Predicate2() { // from class: androidx.window.embedding.EmbeddingAdapter$$ExternalSyntheticLambda8
            @Override // androidx.window.reflection.Predicate2
            public final boolean test(Object obj) {
                return EmbeddingAdapter.translateActivityRule$lambda$16(ActivityRule.this, (Activity) obj);
            }
        }, new Predicate2() { // from class: androidx.window.embedding.EmbeddingAdapter$$ExternalSyntheticLambda9
            @Override // androidx.window.reflection.Predicate2
            public final boolean test(Object obj) {
                return EmbeddingAdapter.translateActivityRule$lambda$18(ActivityRule.this, (Intent) obj);
            }
        }).setShouldAlwaysExpand(activityRule.getAlwaysExpand());
        Intrinsics.checkNotNullExpressionValue(shouldAlwaysExpand, "setShouldAlwaysExpand(...)");
        String tag = activityRule.getTag();
        if (tag == null) {
            tag = Companion.generateTag(activityRule);
        }
        shouldAlwaysExpand.setTag(tag);
        androidx.window.extensions.embedding.ActivityRule build = shouldAlwaysExpand.build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        return build;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean translateActivityRule$lambda$16(ActivityRule activityRule, Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Set<ActivityFilter> filters = activityRule.getFilters();
        if ((filters instanceof Collection) && filters.isEmpty()) {
            return false;
        }
        for (ActivityFilter activityFilter : filters) {
            if (activityFilter.matchesActivity(activity)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean translateActivityRule$lambda$18(ActivityRule activityRule, Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        Set<ActivityFilter> filters = activityRule.getFilters();
        if ((filters instanceof Collection) && filters.isEmpty()) {
            return false;
        }
        for (ActivityFilter activityFilter : filters) {
            if (activityFilter.matchesIntent(intent)) {
                return true;
            }
        }
        return false;
    }

    public final Set<androidx.window.extensions.embedding.EmbeddingRule> translate(Context context, Set<? extends EmbeddingRule> rules) {
        androidx.window.extensions.embedding.SplitPairRule translateActivityRule;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(rules, "rules");
        Class<?> predicateClassOrNull$window_release = this.predicateAdapter.predicateClassOrNull$window_release();
        if (predicateClassOrNull$window_release == null) {
            return SetsKt.emptySet();
        }
        Set<? extends EmbeddingRule> set = rules;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(set, 10));
        for (EmbeddingRule embeddingRule : set) {
            if (embeddingRule instanceof SplitPairRule) {
                translateActivityRule = translateSplitPairRule(context, (SplitPairRule) embeddingRule, predicateClassOrNull$window_release);
            } else if (embeddingRule instanceof SplitPlaceholderRule) {
                translateActivityRule = translateSplitPlaceholderRule(context, (SplitPlaceholderRule) embeddingRule, predicateClassOrNull$window_release);
            } else if (!(embeddingRule instanceof ActivityRule)) {
                throw new IllegalArgumentException("Unsupported rule type");
            } else {
                translateActivityRule = translateActivityRule((ActivityRule) embeddingRule, predicateClassOrNull$window_release);
            }
            arrayList.add((androidx.window.extensions.embedding.EmbeddingRule) translateActivityRule);
        }
        return CollectionsKt.toSet(arrayList);
    }

    private final AnimationBackground translateToOemAnimationBackground(EmbeddingAnimationBackground embeddingAnimationBackground) {
        WindowSdkExtensions.Companion.getInstance().requireExtensionVersion$window_release(5);
        if (embeddingAnimationBackground instanceof EmbeddingAnimationBackground.ColorBackground) {
            AnimationBackground createColorBackground = AnimationBackground.createColorBackground(((EmbeddingAnimationBackground.ColorBackground) embeddingAnimationBackground).getColor());
            Intrinsics.checkNotNull(createColorBackground);
            return createColorBackground;
        }
        AnimationBackground animationBackground = AnimationBackground.ANIMATION_BACKGROUND_DEFAULT;
        Intrinsics.checkNotNull(animationBackground);
        return animationBackground;
    }

    private final EmbeddingAnimationBackground translateToJetpackAnimationBackground(AnimationBackground animationBackground) {
        WindowSdkExtensions.Companion.getInstance().requireExtensionVersion$window_release(5);
        if (animationBackground instanceof AnimationBackground.ColorBackground) {
            return EmbeddingAnimationBackground.Companion.createColorBackground(((AnimationBackground.ColorBackground) animationBackground).getColor());
        }
        return EmbeddingAnimationBackground.DEFAULT;
    }

    private final int translateToOemAnimationResId(EmbeddingAnimationParams.AnimationSpec animationSpec) {
        WindowSdkExtensions.Companion.getInstance().requireExtensionVersion$window_release(7);
        return Intrinsics.areEqual(animationSpec, EmbeddingAnimationParams.AnimationSpec.JUMP_CUT) ? 0 : -1;
    }

    private final EmbeddingAnimationParams.AnimationSpec translateToJetpackAnimationSpec(int i) {
        WindowSdkExtensions.Companion.getInstance().requireExtensionVersion$window_release(7);
        if (i == 0) {
            return EmbeddingAnimationParams.AnimationSpec.JUMP_CUT;
        }
        return EmbeddingAnimationParams.AnimationSpec.DEFAULT;
    }

    public final androidx.window.extensions.embedding.DividerAttributes translateToOemDividerAttributes(DividerAttributes dividerAttributes) {
        int i;
        Intrinsics.checkNotNullParameter(dividerAttributes, "dividerAttributes");
        WindowSdkExtensions.Companion.getInstance().requireExtensionVersion$window_release(6);
        if (dividerAttributes == DividerAttributes.NO_DIVIDER) {
            return null;
        }
        if (dividerAttributes instanceof DividerAttributes.FixedDividerAttributes) {
            i = 1;
        } else if (!(dividerAttributes instanceof DividerAttributes.DraggableDividerAttributes)) {
            throw new IllegalArgumentException("Unknown divider attributes " + dividerAttributes);
        } else {
            i = 2;
        }
        DividerAttributes.Builder widthDp = new DividerAttributes.Builder(i).setDividerColor(dividerAttributes.getColor()).setWidthDp(dividerAttributes.getWidthDp());
        Intrinsics.checkNotNullExpressionValue(widthDp, "setWidthDp(...)");
        if (dividerAttributes instanceof DividerAttributes.DraggableDividerAttributes) {
            DividerAttributes.DraggableDividerAttributes draggableDividerAttributes = (DividerAttributes.DraggableDividerAttributes) dividerAttributes;
            if (draggableDividerAttributes.getDragRange() instanceof DividerAttributes.DragRange.SplitRatioDragRange) {
                widthDp.setPrimaryMinRatio(((DividerAttributes.DragRange.SplitRatioDragRange) draggableDividerAttributes.getDragRange()).getMinRatio()).setPrimaryMaxRatio(((DividerAttributes.DragRange.SplitRatioDragRange) draggableDividerAttributes.getDragRange()).getMaxRatio());
            }
            if (getExtensionVersion() >= 7) {
                widthDp.setDraggingToFullscreenAllowed(draggableDividerAttributes.isDraggingToFullscreenAllowed());
            }
        }
        if (getExtensionVersion() == 7 && dividerAttributes.getWidthDp() == 0) {
            widthDp.setWidthDp(1);
        }
        return widthDp.build();
    }

    public final DividerAttributes translateToJetpackDividerAttributes(androidx.window.extensions.embedding.DividerAttributes dividerAttributes) {
        DividerAttributes.DragRange.SplitRatioDragRange splitRatioDragRange;
        WindowSdkExtensions.Companion.getInstance().requireExtensionVersion$window_release(6);
        if (dividerAttributes == null) {
            return DividerAttributes.NO_DIVIDER;
        }
        int dividerType = dividerAttributes.getDividerType();
        boolean z = true;
        if (dividerType != 1) {
            if (dividerType == 2) {
                DividerAttributes.DraggableDividerAttributes.Builder color = new DividerAttributes.DraggableDividerAttributes.Builder().setWidthDp(dividerAttributes.getWidthDp()).setColor(dividerAttributes.getDividerColor());
                if (dividerAttributes.getPrimaryMinRatio() == -1.0f && dividerAttributes.getPrimaryMaxRatio() == -1.0f) {
                    splitRatioDragRange = DividerAttributes.DragRange.DRAG_RANGE_SYSTEM_DEFAULT;
                } else {
                    splitRatioDragRange = new DividerAttributes.DragRange.SplitRatioDragRange(dividerAttributes.getPrimaryMinRatio(), dividerAttributes.getPrimaryMaxRatio());
                }
                return color.setDragRange(splitRatioDragRange).setDraggingToFullscreenAllowed((getExtensionVersion() < 7 || !dividerAttributes.isDraggingToFullscreenAllowed()) ? false : false).build();
            }
            Log.w(TAG, "Unknown divider type " + dividerAttributes + ".dividerType, default to fixed divider type");
            return new DividerAttributes.FixedDividerAttributes.Builder().setWidthDp(dividerAttributes.getWidthDp()).setColor(dividerAttributes.getDividerColor()).build();
        }
        return new DividerAttributes.FixedDividerAttributes.Builder().setWidthDp(dividerAttributes.getWidthDp()).setColor(dividerAttributes.getDividerColor()).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: EmbeddingAdapter.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Landroidx/window/embedding/EmbeddingAdapter$VendorApiLevel3Impl;", "", "<init>", "(Landroidx/window/embedding/EmbeddingAdapter;)V", "translateCompat", "Landroidx/window/embedding/SplitInfo;", "splitInfo", "Landroidx/window/extensions/embedding/SplitInfo;", "window_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public final class VendorApiLevel3Impl {
        public VendorApiLevel3Impl() {
        }

        public final SplitInfo translateCompat(androidx.window.extensions.embedding.SplitInfo splitInfo) {
            Intrinsics.checkNotNullParameter(splitInfo, "splitInfo");
            VendorApiLevel1Impl vendorApiLevel1Impl = EmbeddingAdapter.this.api1Impl;
            androidx.window.extensions.embedding.ActivityStack primaryActivityStack = splitInfo.getPrimaryActivityStack();
            Intrinsics.checkNotNullExpressionValue(primaryActivityStack, "getPrimaryActivityStack(...)");
            ActivityStack translateCompat = vendorApiLevel1Impl.translateCompat(primaryActivityStack);
            VendorApiLevel1Impl vendorApiLevel1Impl2 = EmbeddingAdapter.this.api1Impl;
            androidx.window.extensions.embedding.ActivityStack secondaryActivityStack = splitInfo.getSecondaryActivityStack();
            Intrinsics.checkNotNullExpressionValue(secondaryActivityStack, "getSecondaryActivityStack(...)");
            ActivityStack translateCompat2 = vendorApiLevel1Impl2.translateCompat(secondaryActivityStack);
            EmbeddingAdapter embeddingAdapter = EmbeddingAdapter.this;
            androidx.window.extensions.embedding.SplitAttributes splitAttributes = splitInfo.getSplitAttributes();
            Intrinsics.checkNotNullExpressionValue(splitAttributes, "getSplitAttributes(...)");
            SplitAttributes translate$window_release = embeddingAdapter.translate$window_release(splitAttributes);
            IBinder token = splitInfo.getToken();
            Intrinsics.checkNotNullExpressionValue(token, "getToken(...)");
            return new SplitInfo(translateCompat, translateCompat2, translate$window_release, token);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: EmbeddingAdapter.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Landroidx/window/embedding/EmbeddingAdapter$VendorApiLevel2Impl;", "", "<init>", "(Landroidx/window/embedding/EmbeddingAdapter;)V", "translateCompat", "Landroidx/window/embedding/SplitInfo;", "splitInfo", "Landroidx/window/extensions/embedding/SplitInfo;", "window_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public final class VendorApiLevel2Impl {
        public VendorApiLevel2Impl() {
        }

        public final SplitInfo translateCompat(androidx.window.extensions.embedding.SplitInfo splitInfo) {
            Intrinsics.checkNotNullParameter(splitInfo, "splitInfo");
            VendorApiLevel1Impl vendorApiLevel1Impl = EmbeddingAdapter.this.api1Impl;
            androidx.window.extensions.embedding.ActivityStack primaryActivityStack = splitInfo.getPrimaryActivityStack();
            Intrinsics.checkNotNullExpressionValue(primaryActivityStack, "getPrimaryActivityStack(...)");
            ActivityStack translateCompat = vendorApiLevel1Impl.translateCompat(primaryActivityStack);
            VendorApiLevel1Impl vendorApiLevel1Impl2 = EmbeddingAdapter.this.api1Impl;
            androidx.window.extensions.embedding.ActivityStack secondaryActivityStack = splitInfo.getSecondaryActivityStack();
            Intrinsics.checkNotNullExpressionValue(secondaryActivityStack, "getSecondaryActivityStack(...)");
            ActivityStack translateCompat2 = vendorApiLevel1Impl2.translateCompat(secondaryActivityStack);
            EmbeddingAdapter embeddingAdapter = EmbeddingAdapter.this;
            androidx.window.extensions.embedding.SplitAttributes splitAttributes = splitInfo.getSplitAttributes();
            Intrinsics.checkNotNullExpressionValue(splitAttributes, "getSplitAttributes(...)");
            return new SplitInfo(translateCompat, translateCompat2, embeddingAdapter.translate$window_release(splitAttributes));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: EmbeddingAdapter.kt */
    @Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u001a\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u0011J\"\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u000e\u001a\u00020\u00162\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u0011J\u0014\u0010\u0017\u001a\u00020\u0018*\u00020\u00182\u0006\u0010\u0019\u001a\u00020\tH\u0002J\"\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u000e\u001a\u00020\u001c2\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u0011J\u0016\u0010\u001d\u001a\u00020\u00012\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001fH\u0003J\u0016\u0010!\u001a\u00020\u00012\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001fH\u0003J\u0014\u0010\u0017\u001a\u00020\"*\u00020\"2\u0006\u0010\u0019\u001a\u00020\tH\u0002J\u001c\u0010#\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020&0$2\u0006\u0010'\u001a\u00020\tH\u0002J\u0010\u0010(\u001a\u00020)2\u0006\u0010'\u001a\u00020\tH\u0002J\u0016\u0010*\u001a\u00020\u00012\f\u0010+\u001a\b\u0012\u0004\u0012\u00020,0\u001fH\u0003J\u0016\u0010-\u001a\u00020\u00012\f\u0010+\u001a\b\u0012\u0004\u0012\u00020,0\u001fH\u0003J\u0018\u0010.\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010/\u001a\u000200H\u0003J\u000e\u00101\u001a\u0002022\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u00101\u001a\u0002032\u0006\u00104\u001a\u000205R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u00066"}, d2 = {"Landroidx/window/embedding/EmbeddingAdapter$VendorApiLevel1Impl;", "", "predicateAdapter", "Landroidx/window/core/PredicateAdapter;", "<init>", "(Landroidx/window/embedding/EmbeddingAdapter;Landroidx/window/core/PredicateAdapter;)V", "getPredicateAdapter", "()Landroidx/window/core/PredicateAdapter;", "getSplitAttributesCompat", "Landroidx/window/embedding/SplitAttributes;", "splitInfo", "Landroidx/window/extensions/embedding/SplitInfo;", "translateActivityRuleCompat", "Landroidx/window/extensions/embedding/ActivityRule;", "rule", "Landroidx/window/embedding/ActivityRule;", "predicateClass", "Ljava/lang/Class;", "translateSplitPlaceholderRuleCompat", "Landroidx/window/extensions/embedding/SplitPlaceholderRule;", "context", "Landroid/content/Context;", "Landroidx/window/embedding/SplitPlaceholderRule;", "setDefaultSplitAttributesCompat", "Landroidx/window/extensions/embedding/SplitPlaceholderRule$Builder;", "defaultAttrs", "translateSplitPairRuleCompat", "Landroidx/window/extensions/embedding/SplitPairRule;", "Landroidx/window/embedding/SplitPairRule;", "translateActivityPairPredicates", "splitPairFilters", "", "Landroidx/window/embedding/SplitPairFilter;", "translateActivityIntentPredicates", "Landroidx/window/extensions/embedding/SplitPairRule$Builder;", "translateSplitAttributesCompatInternal", "Lkotlin/Pair;", "", "", "attrs", "isSplitAttributesSupported", "", "translateActivityPredicates", "activityFilters", "Landroidx/window/embedding/ActivityFilter;", "translateIntentPredicates", "translateParentMetricsPredicate", "splitRule", "Landroidx/window/embedding/SplitRule;", "translateCompat", "Landroidx/window/embedding/SplitInfo;", "Landroidx/window/embedding/ActivityStack;", "activityStack", "Landroidx/window/extensions/embedding/ActivityStack;", "window_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public final class VendorApiLevel1Impl {
        private final PredicateAdapter predicateAdapter;
        final /* synthetic */ EmbeddingAdapter this$0;

        public VendorApiLevel1Impl(EmbeddingAdapter embeddingAdapter, PredicateAdapter predicateAdapter) {
            Intrinsics.checkNotNullParameter(predicateAdapter, "predicateAdapter");
            this.this$0 = embeddingAdapter;
            this.predicateAdapter = predicateAdapter;
        }

        public final PredicateAdapter getPredicateAdapter() {
            return this.predicateAdapter;
        }

        public final SplitAttributes getSplitAttributesCompat(androidx.window.extensions.embedding.SplitInfo splitInfo) {
            Intrinsics.checkNotNullParameter(splitInfo, "splitInfo");
            return new SplitAttributes.Builder().setSplitType(SplitAttributes.SplitType.Companion.buildSplitTypeFromValue$window_release(splitInfo.getSplitRatio())).setLayoutDirection(SplitAttributes.LayoutDirection.LOCALE).build();
        }

        public final androidx.window.extensions.embedding.ActivityRule translateActivityRuleCompat(ActivityRule rule, Class<?> predicateClass) {
            Intrinsics.checkNotNullParameter(rule, "rule");
            Intrinsics.checkNotNullParameter(predicateClass, "predicateClass");
            androidx.window.extensions.embedding.ActivityRule build = ((ActivityRule.Builder) ActivityRule.Builder.class.getConstructor(predicateClass, predicateClass).newInstance(translateActivityPredicates(rule.getFilters()), translateIntentPredicates(rule.getFilters()))).setShouldAlwaysExpand(rule.getAlwaysExpand()).build();
            Intrinsics.checkNotNullExpressionValue(build, "build(...)");
            return build;
        }

        public final androidx.window.extensions.embedding.SplitPlaceholderRule translateSplitPlaceholderRuleCompat(Context context, SplitPlaceholderRule rule, Class<?> predicateClass) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(rule, "rule");
            Intrinsics.checkNotNullParameter(predicateClass, "predicateClass");
            SplitPlaceholderRule.Builder finishPrimaryWithSecondary = ((SplitPlaceholderRule.Builder) SplitPlaceholderRule.Builder.class.getConstructor(Intent.class, predicateClass, predicateClass, predicateClass).newInstance(rule.getPlaceholderIntent(), translateActivityPredicates(rule.getFilters()), translateIntentPredicates(rule.getFilters()), translateParentMetricsPredicate(context, rule))).setSticky(rule.isSticky()).setFinishPrimaryWithSecondary(this.this$0.translateFinishBehavior(rule.getFinishPrimaryWithPlaceholder()));
            Intrinsics.checkNotNullExpressionValue(finishPrimaryWithSecondary, "setFinishPrimaryWithSecondary(...)");
            androidx.window.extensions.embedding.SplitPlaceholderRule build = setDefaultSplitAttributesCompat(finishPrimaryWithSecondary, rule.getDefaultSplitAttributes()).build();
            Intrinsics.checkNotNullExpressionValue(build, "build(...)");
            return build;
        }

        private final SplitPlaceholderRule.Builder setDefaultSplitAttributesCompat(SplitPlaceholderRule.Builder builder, SplitAttributes splitAttributes) {
            kotlin.Pair<Float, Integer> translateSplitAttributesCompatInternal = translateSplitAttributesCompatInternal(splitAttributes);
            float floatValue = translateSplitAttributesCompatInternal.component1().floatValue();
            int intValue = translateSplitAttributesCompatInternal.component2().intValue();
            builder.setSplitRatio(floatValue);
            builder.setLayoutDirection(intValue);
            return builder;
        }

        public final androidx.window.extensions.embedding.SplitPairRule translateSplitPairRuleCompat(Context context, SplitPairRule rule, Class<?> predicateClass) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(rule, "rule");
            Intrinsics.checkNotNullParameter(predicateClass, "predicateClass");
            Object newInstance = SplitPairRule.Builder.class.getConstructor(predicateClass, predicateClass, predicateClass).newInstance(translateActivityPairPredicates(rule.getFilters()), translateActivityIntentPredicates(rule.getFilters()), translateParentMetricsPredicate(context, rule));
            Intrinsics.checkNotNullExpressionValue(newInstance, "newInstance(...)");
            androidx.window.extensions.embedding.SplitPairRule build = setDefaultSplitAttributesCompat((SplitPairRule.Builder) newInstance, rule.getDefaultSplitAttributes()).setShouldClearTop(rule.getClearTop()).setFinishPrimaryWithSecondary(this.this$0.translateFinishBehavior(rule.getFinishPrimaryWithSecondary())).setFinishSecondaryWithPrimary(this.this$0.translateFinishBehavior(rule.getFinishSecondaryWithPrimary())).build();
            Intrinsics.checkNotNullExpressionValue(build, "build(...)");
            return build;
        }

        private final Object translateActivityPairPredicates(final Set<SplitPairFilter> set) {
            return this.predicateAdapter.buildPairPredicate(Reflection.getOrCreateKotlinClass(Activity.class), Reflection.getOrCreateKotlinClass(Activity.class), new Function2() { // from class: androidx.window.embedding.EmbeddingAdapter$VendorApiLevel1Impl$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return Boolean.valueOf(EmbeddingAdapter.VendorApiLevel1Impl.translateActivityPairPredicates$lambda$2(set, (Activity) obj, (Activity) obj2));
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static final boolean translateActivityPairPredicates$lambda$2(Set set, Activity first, Activity second) {
            Intrinsics.checkNotNullParameter(first, "first");
            Intrinsics.checkNotNullParameter(second, "second");
            Set<SplitPairFilter> set2 = set;
            if ((set2 instanceof Collection) && set2.isEmpty()) {
                return false;
            }
            for (SplitPairFilter splitPairFilter : set2) {
                if (splitPairFilter.matchesActivityPair(first, second)) {
                    return true;
                }
            }
            return false;
        }

        private final Object translateActivityIntentPredicates(final Set<SplitPairFilter> set) {
            return this.predicateAdapter.buildPairPredicate(Reflection.getOrCreateKotlinClass(Activity.class), Reflection.getOrCreateKotlinClass(Intent.class), new Function2() { // from class: androidx.window.embedding.EmbeddingAdapter$VendorApiLevel1Impl$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return Boolean.valueOf(EmbeddingAdapter.VendorApiLevel1Impl.translateActivityIntentPredicates$lambda$4(set, (Activity) obj, (Intent) obj2));
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static final boolean translateActivityIntentPredicates$lambda$4(Set set, Activity first, Intent second) {
            Intrinsics.checkNotNullParameter(first, "first");
            Intrinsics.checkNotNullParameter(second, "second");
            Set<SplitPairFilter> set2 = set;
            if ((set2 instanceof Collection) && set2.isEmpty()) {
                return false;
            }
            for (SplitPairFilter splitPairFilter : set2) {
                if (splitPairFilter.matchesActivityIntentPair(first, second)) {
                    return true;
                }
            }
            return false;
        }

        private final SplitPairRule.Builder setDefaultSplitAttributesCompat(SplitPairRule.Builder builder, SplitAttributes splitAttributes) {
            kotlin.Pair<Float, Integer> translateSplitAttributesCompatInternal = translateSplitAttributesCompatInternal(splitAttributes);
            float floatValue = translateSplitAttributesCompatInternal.component1().floatValue();
            int intValue = translateSplitAttributesCompatInternal.component2().intValue();
            builder.setSplitRatio(floatValue);
            builder.setLayoutDirection(intValue);
            return builder;
        }

        private final kotlin.Pair<Float, Integer> translateSplitAttributesCompatInternal(SplitAttributes splitAttributes) {
            int i = 3;
            if (!isSplitAttributesSupported(splitAttributes)) {
                return new kotlin.Pair<>(Float.valueOf(0.0f), 3);
            }
            Float valueOf = Float.valueOf(splitAttributes.getSplitType().getValue$window_release());
            SplitAttributes.LayoutDirection layoutDirection = splitAttributes.getLayoutDirection();
            if (!Intrinsics.areEqual(layoutDirection, SplitAttributes.LayoutDirection.LOCALE)) {
                if (Intrinsics.areEqual(layoutDirection, SplitAttributes.LayoutDirection.LEFT_TO_RIGHT)) {
                    i = 0;
                } else if (!Intrinsics.areEqual(layoutDirection, SplitAttributes.LayoutDirection.RIGHT_TO_LEFT)) {
                    throw new IllegalStateException("Unsupported layout direction must be covered in @isSplitAttributesSupported!");
                } else {
                    i = 1;
                }
            }
            return new kotlin.Pair<>(valueOf, Integer.valueOf(i));
        }

        private final boolean isSplitAttributesSupported(SplitAttributes splitAttributes) {
            double value$window_release = splitAttributes.getSplitType().getValue$window_release();
            return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE <= value$window_release && value$window_release <= 1.0d && splitAttributes.getSplitType().getValue$window_release() != 1.0f && ArraysKt.contains(new SplitAttributes.LayoutDirection[]{SplitAttributes.LayoutDirection.LEFT_TO_RIGHT, SplitAttributes.LayoutDirection.RIGHT_TO_LEFT, SplitAttributes.LayoutDirection.LOCALE}, splitAttributes.getLayoutDirection());
        }

        private final Object translateActivityPredicates(final Set<ActivityFilter> set) {
            return this.predicateAdapter.buildPredicate(Reflection.getOrCreateKotlinClass(Activity.class), new Function1() { // from class: androidx.window.embedding.EmbeddingAdapter$VendorApiLevel1Impl$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return Boolean.valueOf(EmbeddingAdapter.VendorApiLevel1Impl.translateActivityPredicates$lambda$7(set, (Activity) obj));
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static final boolean translateActivityPredicates$lambda$7(Set set, Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Set<ActivityFilter> set2 = set;
            if ((set2 instanceof Collection) && set2.isEmpty()) {
                return false;
            }
            for (ActivityFilter activityFilter : set2) {
                if (activityFilter.matchesActivity(activity)) {
                    return true;
                }
            }
            return false;
        }

        private final Object translateIntentPredicates(final Set<ActivityFilter> set) {
            return this.predicateAdapter.buildPredicate(Reflection.getOrCreateKotlinClass(Intent.class), new Function1() { // from class: androidx.window.embedding.EmbeddingAdapter$VendorApiLevel1Impl$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return Boolean.valueOf(EmbeddingAdapter.VendorApiLevel1Impl.translateIntentPredicates$lambda$9(set, (Intent) obj));
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static final boolean translateIntentPredicates$lambda$9(Set set, Intent intent) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            Set<ActivityFilter> set2 = set;
            if ((set2 instanceof Collection) && set2.isEmpty()) {
                return false;
            }
            for (ActivityFilter activityFilter : set2) {
                if (activityFilter.matchesIntent(intent)) {
                    return true;
                }
            }
            return false;
        }

        private final Object translateParentMetricsPredicate(final Context context, final SplitRule splitRule) {
            return this.predicateAdapter.buildPredicate(Reflection.getOrCreateKotlinClass(WindowMetrics.class), new Function1() { // from class: androidx.window.embedding.EmbeddingAdapter$VendorApiLevel1Impl$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return Boolean.valueOf(EmbeddingAdapter.VendorApiLevel1Impl.translateParentMetricsPredicate$lambda$10(SplitRule.this, context, (WindowMetrics) obj));
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static final boolean translateParentMetricsPredicate$lambda$10(SplitRule splitRule, Context context, WindowMetrics windowMetrics) {
            Intrinsics.checkNotNullParameter(windowMetrics, "windowMetrics");
            return splitRule.checkParentMetrics$window_release(context, windowMetrics);
        }

        public final SplitInfo translateCompat(androidx.window.extensions.embedding.SplitInfo splitInfo) {
            Intrinsics.checkNotNullParameter(splitInfo, "splitInfo");
            androidx.window.extensions.embedding.ActivityStack primaryActivityStack = splitInfo.getPrimaryActivityStack();
            Intrinsics.checkNotNullExpressionValue(primaryActivityStack, "getPrimaryActivityStack(...)");
            ActivityStack translateCompat = translateCompat(primaryActivityStack);
            androidx.window.extensions.embedding.ActivityStack secondaryActivityStack = splitInfo.getSecondaryActivityStack();
            Intrinsics.checkNotNullExpressionValue(secondaryActivityStack, "getSecondaryActivityStack(...)");
            return new SplitInfo(translateCompat, translateCompat(secondaryActivityStack), getSplitAttributesCompat(splitInfo));
        }

        public final ActivityStack translateCompat(androidx.window.extensions.embedding.ActivityStack activityStack) {
            Intrinsics.checkNotNullParameter(activityStack, "activityStack");
            List activities = activityStack.getActivities();
            Intrinsics.checkNotNullExpressionValue(activities, "getActivities(...)");
            return new ActivityStack(activities, activityStack.isEmpty());
        }
    }

    /* compiled from: EmbeddingAdapter.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0005R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0013"}, d2 = {"Landroidx/window/embedding/EmbeddingAdapter$Companion;", "", "<init>", "()V", "TAG", "", "RULE_TAG_PREFIX", "getRULE_TAG_PREFIX", "()Ljava/lang/String;", "INVALID_SPLIT_INFO_TOKEN", "Landroid/os/Binder;", "getINVALID_SPLIT_INFO_TOKEN", "()Landroid/os/Binder;", "generateTag", "rule", "Landroidx/window/embedding/EmbeddingRule;", "isTagGenerated", "", "tag", "window_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getRULE_TAG_PREFIX() {
            return EmbeddingAdapter.RULE_TAG_PREFIX;
        }

        public final Binder getINVALID_SPLIT_INFO_TOKEN() {
            return EmbeddingAdapter.INVALID_SPLIT_INFO_TOKEN;
        }

        public final String generateTag(EmbeddingRule rule) {
            Intrinsics.checkNotNullParameter(rule, "rule");
            return getRULE_TAG_PREFIX() + Integer.toHexString(rule.hashCode());
        }

        public final boolean isTagGenerated(String tag) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            String removePrefix = StringsKt.removePrefix(tag, (CharSequence) getRULE_TAG_PREFIX());
            return (Intrinsics.areEqual(removePrefix, tag) || StringsKt.toIntOrNull(removePrefix, 16) == null) ? false : true;
        }
    }
}
