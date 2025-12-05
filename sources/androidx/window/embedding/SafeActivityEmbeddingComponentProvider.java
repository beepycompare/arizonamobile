package androidx.window.embedding;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.IBinder;
import android.view.WindowMetrics;
import androidx.window.SafeWindowExtensionsProvider;
import androidx.window.WindowSdkExtensions;
import androidx.window.core.ConsumerAdapter;
import androidx.window.extensions.WindowExtensions;
import androidx.window.extensions.core.util.function.Consumer;
import androidx.window.extensions.core.util.function.Function;
import androidx.window.extensions.core.util.function.Predicate;
import androidx.window.extensions.embedding.ActivityEmbeddingComponent;
import androidx.window.extensions.embedding.ActivityRule;
import androidx.window.extensions.embedding.ActivityStack;
import androidx.window.extensions.embedding.ActivityStackAttributes;
import androidx.window.extensions.embedding.ActivityStackAttributesCalculatorParams;
import androidx.window.extensions.embedding.AnimationBackground;
import androidx.window.extensions.embedding.AnimationParams;
import androidx.window.extensions.embedding.DividerAttributes;
import androidx.window.extensions.embedding.SplitAttributes;
import androidx.window.extensions.embedding.SplitInfo;
import androidx.window.extensions.embedding.SplitPairRule;
import androidx.window.extensions.embedding.SplitPlaceholderRule;
import androidx.window.extensions.embedding.WindowAttributes;
import androidx.window.extensions.layout.WindowLayoutInfo;
import androidx.window.reflection.ReflectionUtils;
import androidx.window.reflection.WindowExtensionsConstants;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Set;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: SafeActivityEmbeddingComponentProvider.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\bB\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0010\u001a\u00020\u0011H\u0002J\r\u0010\u0012\u001a\u00020\u0011H\u0001¢\u0006\u0002\b\u0013J\r\u0010\u0014\u001a\u00020\u0011H\u0001¢\u0006\u0002\b\u0015J\r\u0010\u0016\u001a\u00020\u0011H\u0001¢\u0006\u0002\b\u0017J\r\u0010\u0018\u001a\u00020\u0011H\u0001¢\u0006\u0002\b\u0019J\r\u0010\u001a\u001a\u00020\u0011H\u0001¢\u0006\u0002\b\u001bJ\r\u0010\u001c\u001a\u00020\u0011H\u0001¢\u0006\u0002\b\u001dJ\r\u0010\u001e\u001a\u00020\u0011H\u0001¢\u0006\u0002\b\u001fJ\r\u0010 \u001a\u00020\u0011H\u0001¢\u0006\u0002\b!J\b\u0010\"\u001a\u00020\u0011H\u0002J\b\u0010'\u001a\u00020\u0011H\u0002J\b\u0010(\u001a\u00020\u0011H\u0002J\b\u0010)\u001a\u00020\u0011H\u0002J\b\u0010*\u001a\u00020\u0011H\u0002J\b\u0010+\u001a\u00020\u0011H\u0002J\b\u0010,\u001a\u00020\u0011H\u0002J\b\u0010-\u001a\u00020\u0011H\u0002J\b\u0010.\u001a\u00020\u0011H\u0002J\b\u0010/\u001a\u00020\u0011H\u0002J\b\u00100\u001a\u00020\u0011H\u0002J\b\u00101\u001a\u00020\u0011H\u0002J\b\u00102\u001a\u00020\u0011H\u0002J\b\u00103\u001a\u00020\u0011H\u0002J\b\u00104\u001a\u00020\u0011H\u0002J\b\u00105\u001a\u00020\u0011H\u0002J\b\u00106\u001a\u00020\u0011H\u0002J\b\u00107\u001a\u00020\u0011H\u0002J\b\u00108\u001a\u00020\u0011H\u0002J\b\u00109\u001a\u00020\u0011H\u0002J\b\u0010:\u001a\u00020\u0011H\u0002J\b\u0010;\u001a\u00020\u0011H\u0002J\b\u0010<\u001a\u00020\u0011H\u0002J\b\u0010=\u001a\u00020\u0011H\u0002J\b\u0010>\u001a\u00020\u0011H\u0002J\b\u0010?\u001a\u00020\u0011H\u0002J\b\u0010@\u001a\u00020\u0011H\u0002J\b\u0010A\u001a\u00020\u0011H\u0002J\b\u0010B\u001a\u00020\u0011H\u0002J\b\u0010C\u001a\u00020\u0011H\u0002J\b\u0010D\u001a\u00020\u0011H\u0002J\b\u0010E\u001a\u00020\u0011H\u0002J\b\u0010F\u001a\u00020\u0011H\u0002J\b\u0010G\u001a\u00020\u0011H\u0002J\b\u0010H\u001a\u00020\u0011H\u0002J\b\u0010I\u001a\u00020\u0011H\u0002J\b\u0010J\u001a\u00020\u0011H\u0002J\b\u0010K\u001a\u00020\u0011H\u0002J\b\u0010L\u001a\u00020\u0011H\u0002J\b\u0010M\u001a\u00020\u0011H\u0002J\b\u0010N\u001a\u00020\u0011H\u0002J\b\u0010O\u001a\u00020\u0011H\u0002J\b\u0010P\u001a\u00020\u0011H\u0002J\b\u0010Q\u001a\u00020\u0011H\u0002J\b\u0010R\u001a\u00020\u0011H\u0002J\b\u0010S\u001a\u00020\u0011H\u0002J\b\u0010T\u001a\u00020\u0011H\u0002J\b\u0010U\u001a\u00020\u0011H\u0002J\b\u0010V\u001a\u00020\u0011H\u0002J\b\u0010W\u001a\u00020\u0011H\u0002J\b\u0010X\u001a\u00020\u0011H\u0002J\b\u0010Y\u001a\u00020\u0011H\u0002J\b\u0010Z\u001a\u00020\u0011H\u0002J\b\u0010[\u001a\u00020\u0011H\u0002J\b\u0010\\\u001a\u00020\u0011H\u0002J\b\u0010]\u001a\u00020\u0011H\u0002J\b\u0010^\u001a\u00020\u0011H\u0002J\b\u0010_\u001a\u00020\u0011H\u0002J\b\u0010`\u001a\u00020\u0011H\u0002J\b\u0010a\u001a\u00020\u0011H\u0002J\b\u0010b\u001a\u00020\u0011H\u0002J\b\u0010c\u001a\u00020\u0011H\u0002J\b\u0010d\u001a\u00020\u0011H\u0002J\b\u0010e\u001a\u00020\u0011H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\f\u001a\u0004\u0018\u00010\r8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010#\u001a\u0006\u0012\u0002\b\u00030$8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&¨\u0006f"}, d2 = {"Landroidx/window/embedding/SafeActivityEmbeddingComponentProvider;", "", "loader", "Ljava/lang/ClassLoader;", "consumerAdapter", "Landroidx/window/core/ConsumerAdapter;", "windowExtensions", "Landroidx/window/extensions/WindowExtensions;", "<init>", "(Ljava/lang/ClassLoader;Landroidx/window/core/ConsumerAdapter;Landroidx/window/extensions/WindowExtensions;)V", "safeWindowExtensionsProvider", "Landroidx/window/SafeWindowExtensionsProvider;", "activityEmbeddingComponent", "Landroidx/window/extensions/embedding/ActivityEmbeddingComponent;", "getActivityEmbeddingComponent", "()Landroidx/window/extensions/embedding/ActivityEmbeddingComponent;", "canUseActivityEmbeddingComponent", "", "isActivityEmbeddingComponentAccessible", "isActivityEmbeddingComponentAccessible$window_release", "hasValidVendorApiLevel1", "hasValidVendorApiLevel1$window_release", "hasValidVendorApiLevel2", "hasValidVendorApiLevel2$window_release", "hasValidVendorApiLevel3", "hasValidVendorApiLevel3$window_release", "hasValidVendorApiLevel5", "hasValidVendorApiLevel5$window_release", "hasValidVendorApiLevel6", "hasValidVendorApiLevel6$window_release", "hasValidVendorApiLevel7", "hasValidVendorApiLevel7$window_release", "hasValidVendorApiLevel8", "hasValidVendorApiLevel8$window_release", "isOverlayFeatureValid", "activityEmbeddingComponentClass", "Ljava/lang/Class;", "getActivityEmbeddingComponentClass", "()Ljava/lang/Class;", "isActivityEmbeddingComponentValid", "isMethodSetEmbeddingRulesValid", "isMethodIsActivityEmbeddedValid", "isMethodSetSplitInfoCallbackJavaConsumerValid", "isMethodGetSplitRatioValid", "isMethodGetLayoutDirectionValid", "isClassActivityRuleValid", "isClassActivityRuleBuilderLevel1Valid", "isClassSplitInfoValid", "isClassSplitPairRuleValid", "isClassSplitPairRuleBuilderLevel1Valid", "isClassSplitPlaceholderRuleValid", "isClassSplitPlaceholderRuleBuilderLevel1Valid", "isMethodSetSplitInfoCallbackWindowConsumerValid", "isMethodClearSplitInfoCallbackValid", "isMethodSplitAttributesCalculatorValid", "isMethodGetSplitAttributesValid", "isMethodGetFinishPrimaryWithPlaceholderValid", "isMethodGetDefaultSplitAttributesValid", "isClassActivityRuleBuilderLevel2Valid", "isClassEmbeddingRuleValid", "isClassSplitAttributesValid", "isClassSplitAttributesCalculatorParamsValid", "isClassSplitTypeValid", "isClassSplitPairRuleBuilderLevel2Valid", "isClassSplitPlaceholderRuleBuilderLevel2Valid", "isMethodInvalidateTopVisibleSplitAttributesValid", "isMethodUpdateSplitAttributesValid", "isMethodSplitInfoGetTokenValid", "isActivityStackGetActivityStackTokenValid", "isMethodRegisterActivityStackCallbackValid", "isMethodUnregisterActivityStackCallbackValid", "isMethodPinUnpinTopActivityStackValid", "isMethodUpdateSplitAttributesWithTokenValid", "isMethodGetSplitInfoTokenValid", "isClassAnimationBackgroundValid", "isClassActivityStackTokenValid", "isClassWindowAttributesValid", "isClassSplitInfoTokenValid", "isMethodGetEmbeddedActivityWindowInfoValid", "isMethodSetEmbeddedActivityWindowInfoCallbackValid", "isMethodClearEmbeddedActivityWindowInfoCallbackValid", "isMethodGetDividerAttributesValid", "isMethodSetDividerAttributesValid", "isClassEmbeddedActivityWindowInfoValid", "isClassDividerAttributesValid", "isClassDividerAttributesBuilderValid", "isMethodGetAnimationParamsValid", "isMethodSetAnimationParamsValid", "isMethodIsDraggingToFullscreenAllowedValid", "isMethodSetDraggingToFullscreenAllowedValid", "isClassAnimationParamsValid", "isClassAnimationParamsBuilderValid", "isActivityStackGetTagValid", "isMethodGetActivityStackTokenValid", "isClassParentContainerInfoValid", "isMethodGetParentContainerInfoValid", "isMethodSetActivityStackAttributesCalculatorValid", "isMethodClearActivityStackAttributesCalculatorValid", "isMethodUpdateActivityStackAttributesValid", "isClassActivityStackAttributesValid", "isClassActivityStackAttributesBuilderValid", "isClassActivityStackAttributesCalculatorParamsValid", "window_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SafeActivityEmbeddingComponentProvider {
    private final ConsumerAdapter consumerAdapter;
    private final ClassLoader loader;
    private final SafeWindowExtensionsProvider safeWindowExtensionsProvider;
    private final WindowExtensions windowExtensions;

    public SafeActivityEmbeddingComponentProvider(ClassLoader loader, ConsumerAdapter consumerAdapter, WindowExtensions windowExtensions) {
        Intrinsics.checkNotNullParameter(loader, "loader");
        Intrinsics.checkNotNullParameter(consumerAdapter, "consumerAdapter");
        Intrinsics.checkNotNullParameter(windowExtensions, "windowExtensions");
        this.loader = loader;
        this.consumerAdapter = consumerAdapter;
        this.windowExtensions = windowExtensions;
        this.safeWindowExtensionsProvider = new SafeWindowExtensionsProvider(loader);
    }

    public final ActivityEmbeddingComponent getActivityEmbeddingComponent() {
        if (canUseActivityEmbeddingComponent()) {
            try {
                return this.windowExtensions.getActivityEmbeddingComponent();
            } catch (UnsupportedOperationException unused) {
                return null;
            }
        }
        return null;
    }

    private final boolean canUseActivityEmbeddingComponent() {
        if (isActivityEmbeddingComponentAccessible$window_release()) {
            int extensionVersion = WindowSdkExtensions.Companion.getInstance().getExtensionVersion();
            if (extensionVersion == 1) {
                return hasValidVendorApiLevel1$window_release();
            }
            if (extensionVersion == 2) {
                return hasValidVendorApiLevel2$window_release();
            }
            if (3 > extensionVersion || extensionVersion >= 5) {
                if (extensionVersion == 5) {
                    return hasValidVendorApiLevel5$window_release();
                }
                if (extensionVersion == 6) {
                    return hasValidVendorApiLevel6$window_release();
                }
                if (extensionVersion == 7) {
                    return hasValidVendorApiLevel7$window_release();
                }
                if (8 > extensionVersion || extensionVersion > Integer.MAX_VALUE) {
                    return false;
                }
                return hasValidVendorApiLevel8$window_release();
            }
            return hasValidVendorApiLevel3$window_release();
        }
        return false;
    }

    public final boolean isActivityEmbeddingComponentAccessible$window_release() {
        return this.safeWindowExtensionsProvider.isWindowExtensionsValid$window_release() && isActivityEmbeddingComponentValid();
    }

    public final boolean hasValidVendorApiLevel1$window_release() {
        return isMethodSetEmbeddingRulesValid() && isMethodIsActivityEmbeddedValid() && isMethodSetSplitInfoCallbackJavaConsumerValid() && isMethodGetSplitRatioValid() && isMethodGetLayoutDirectionValid() && isClassActivityRuleValid() && isClassActivityRuleBuilderLevel1Valid() && isClassSplitInfoValid() && isClassSplitPairRuleValid() && isClassSplitPairRuleBuilderLevel1Valid() && isClassSplitPlaceholderRuleValid() && isClassSplitPlaceholderRuleBuilderLevel1Valid();
    }

    public final boolean hasValidVendorApiLevel2$window_release() {
        return hasValidVendorApiLevel1$window_release() && isMethodSetSplitInfoCallbackWindowConsumerValid() && isMethodClearSplitInfoCallbackValid() && isMethodSplitAttributesCalculatorValid() && isMethodGetSplitAttributesValid() && isMethodGetFinishPrimaryWithPlaceholderValid() && isMethodGetDefaultSplitAttributesValid() && isClassActivityRuleBuilderLevel2Valid() && isClassEmbeddingRuleValid() && isClassSplitAttributesValid() && isClassSplitAttributesCalculatorParamsValid() && isClassSplitTypeValid() && isClassSplitPairRuleBuilderLevel2Valid() && isClassSplitPlaceholderRuleBuilderLevel2Valid();
    }

    public final boolean hasValidVendorApiLevel3$window_release() {
        return hasValidVendorApiLevel2$window_release() && isMethodInvalidateTopVisibleSplitAttributesValid() && isMethodUpdateSplitAttributesValid() && isMethodSplitInfoGetTokenValid();
    }

    public final boolean hasValidVendorApiLevel5$window_release() {
        return hasValidVendorApiLevel3$window_release() && isActivityStackGetActivityStackTokenValid() && isMethodRegisterActivityStackCallbackValid() && isMethodUnregisterActivityStackCallbackValid() && isMethodPinUnpinTopActivityStackValid() && isMethodUpdateSplitAttributesWithTokenValid() && isMethodGetSplitInfoTokenValid() && isClassAnimationBackgroundValid() && isClassActivityStackTokenValid() && isClassWindowAttributesValid() && isClassSplitInfoTokenValid();
    }

    public final boolean hasValidVendorApiLevel6$window_release() {
        return hasValidVendorApiLevel5$window_release() && isMethodGetEmbeddedActivityWindowInfoValid() && isMethodSetEmbeddedActivityWindowInfoCallbackValid() && isMethodClearEmbeddedActivityWindowInfoCallbackValid() && isMethodGetDividerAttributesValid() && isMethodSetDividerAttributesValid() && isClassEmbeddedActivityWindowInfoValid() && isClassDividerAttributesValid() && isClassDividerAttributesBuilderValid();
    }

    public final boolean hasValidVendorApiLevel7$window_release() {
        return hasValidVendorApiLevel6$window_release() && isMethodGetAnimationParamsValid() && isMethodSetAnimationParamsValid() && isMethodIsDraggingToFullscreenAllowedValid() && isMethodSetDraggingToFullscreenAllowedValid() && isClassAnimationParamsValid() && isClassAnimationParamsBuilderValid();
    }

    public final boolean hasValidVendorApiLevel8$window_release() {
        return hasValidVendorApiLevel7$window_release();
    }

    private final boolean isOverlayFeatureValid() {
        return isActivityStackGetTagValid() && isMethodGetActivityStackTokenValid() && isClassParentContainerInfoValid() && isMethodGetParentContainerInfoValid() && isMethodSetActivityStackAttributesCalculatorValid() && isMethodClearActivityStackAttributesCalculatorValid() && isMethodUpdateActivityStackAttributesValid() && isClassActivityStackAttributesValid() && isClassActivityStackAttributesBuilderValid() && isClassActivityStackAttributesCalculatorParamsValid();
    }

    private final Class<?> getActivityEmbeddingComponentClass() {
        Class<?> loadClass = this.loader.loadClass(WindowExtensionsConstants.ACTIVITY_EMBEDDING_COMPONENT_CLASS);
        Intrinsics.checkNotNullExpressionValue(loadClass, "loadClass(...)");
        return loadClass;
    }

    private final boolean isActivityEmbeddingComponentValid() {
        return ReflectionUtils.validateReflection$window_release("WindowExtensions#getActivityEmbeddingComponent is not valid", new Function0() { // from class: androidx.window.embedding.SafeActivityEmbeddingComponentProvider$$ExternalSyntheticLambda57
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                boolean isActivityEmbeddingComponentValid$lambda$0;
                isActivityEmbeddingComponentValid$lambda$0 = SafeActivityEmbeddingComponentProvider.isActivityEmbeddingComponentValid$lambda$0(SafeActivityEmbeddingComponentProvider.this);
                return Boolean.valueOf(isActivityEmbeddingComponentValid$lambda$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isActivityEmbeddingComponentValid$lambda$0(SafeActivityEmbeddingComponentProvider safeActivityEmbeddingComponentProvider) {
        Method method = safeActivityEmbeddingComponentProvider.safeWindowExtensionsProvider.getWindowExtensionsClass$window_release().getMethod("getActivityEmbeddingComponent", new Class[0]);
        Class<?> activityEmbeddingComponentClass = safeActivityEmbeddingComponentProvider.getActivityEmbeddingComponentClass();
        ReflectionUtils reflectionUtils = ReflectionUtils.INSTANCE;
        Intrinsics.checkNotNull(method);
        return reflectionUtils.isPublic$window_release(method) && ReflectionUtils.INSTANCE.doesReturn$window_release(method, activityEmbeddingComponentClass);
    }

    private final boolean isMethodSetEmbeddingRulesValid() {
        return ReflectionUtils.validateReflection$window_release("ActivityEmbeddingComponent#setEmbeddingRules is not valid", new Function0() { // from class: androidx.window.embedding.SafeActivityEmbeddingComponentProvider$$ExternalSyntheticLambda52
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                boolean isMethodSetEmbeddingRulesValid$lambda$1;
                isMethodSetEmbeddingRulesValid$lambda$1 = SafeActivityEmbeddingComponentProvider.isMethodSetEmbeddingRulesValid$lambda$1(SafeActivityEmbeddingComponentProvider.this);
                return Boolean.valueOf(isMethodSetEmbeddingRulesValid$lambda$1);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isMethodSetEmbeddingRulesValid$lambda$1(SafeActivityEmbeddingComponentProvider safeActivityEmbeddingComponentProvider) {
        Method method = safeActivityEmbeddingComponentProvider.getActivityEmbeddingComponentClass().getMethod("setEmbeddingRules", Set.class);
        ReflectionUtils reflectionUtils = ReflectionUtils.INSTANCE;
        Intrinsics.checkNotNull(method);
        return reflectionUtils.isPublic$window_release(method);
    }

    private final boolean isMethodIsActivityEmbeddedValid() {
        return ReflectionUtils.validateReflection$window_release("ActivityEmbeddingComponent#isActivityEmbedded is not valid", new Function0() { // from class: androidx.window.embedding.SafeActivityEmbeddingComponentProvider$$ExternalSyntheticLambda38
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                boolean isMethodIsActivityEmbeddedValid$lambda$2;
                isMethodIsActivityEmbeddedValid$lambda$2 = SafeActivityEmbeddingComponentProvider.isMethodIsActivityEmbeddedValid$lambda$2(SafeActivityEmbeddingComponentProvider.this);
                return Boolean.valueOf(isMethodIsActivityEmbeddedValid$lambda$2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isMethodIsActivityEmbeddedValid$lambda$2(SafeActivityEmbeddingComponentProvider safeActivityEmbeddingComponentProvider) {
        Method method = safeActivityEmbeddingComponentProvider.getActivityEmbeddingComponentClass().getMethod("isActivityEmbedded", Activity.class);
        ReflectionUtils reflectionUtils = ReflectionUtils.INSTANCE;
        Intrinsics.checkNotNull(method);
        return reflectionUtils.isPublic$window_release(method) && ReflectionUtils.INSTANCE.doesReturn$window_release(method, Boolean.TYPE);
    }

    private final boolean isMethodSetSplitInfoCallbackJavaConsumerValid() {
        return ReflectionUtils.validateReflection$window_release("ActivityEmbeddingComponent#setSplitInfoCallback is not valid", new Function0() { // from class: androidx.window.embedding.SafeActivityEmbeddingComponentProvider$$ExternalSyntheticLambda40
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                boolean isMethodSetSplitInfoCallbackJavaConsumerValid$lambda$3;
                isMethodSetSplitInfoCallbackJavaConsumerValid$lambda$3 = SafeActivityEmbeddingComponentProvider.isMethodSetSplitInfoCallbackJavaConsumerValid$lambda$3(SafeActivityEmbeddingComponentProvider.this);
                return Boolean.valueOf(isMethodSetSplitInfoCallbackJavaConsumerValid$lambda$3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isMethodSetSplitInfoCallbackJavaConsumerValid$lambda$3(SafeActivityEmbeddingComponentProvider safeActivityEmbeddingComponentProvider) {
        Class<?> consumerClassOrNull$window_release = safeActivityEmbeddingComponentProvider.consumerAdapter.consumerClassOrNull$window_release();
        if (consumerClassOrNull$window_release == null) {
            return false;
        }
        Method method = safeActivityEmbeddingComponentProvider.getActivityEmbeddingComponentClass().getMethod("setSplitInfoCallback", consumerClassOrNull$window_release);
        ReflectionUtils reflectionUtils = ReflectionUtils.INSTANCE;
        Intrinsics.checkNotNull(method);
        return reflectionUtils.isPublic$window_release(method);
    }

    private final boolean isMethodGetSplitRatioValid() {
        return ReflectionUtils.validateReflection$window_release("SplitRule#getSplitRatio is not valid", new Function0() { // from class: androidx.window.embedding.SafeActivityEmbeddingComponentProvider$$ExternalSyntheticLambda37
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                boolean isMethodGetSplitRatioValid$lambda$4;
                isMethodGetSplitRatioValid$lambda$4 = SafeActivityEmbeddingComponentProvider.isMethodGetSplitRatioValid$lambda$4();
                return Boolean.valueOf(isMethodGetSplitRatioValid$lambda$4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isMethodGetSplitRatioValid$lambda$4() {
        Method method = androidx.window.extensions.embedding.SplitRule.class.getMethod("getSplitRatio", new Class[0]);
        ReflectionUtils reflectionUtils = ReflectionUtils.INSTANCE;
        Intrinsics.checkNotNull(method);
        return reflectionUtils.isPublic$window_release(method) && ReflectionUtils.INSTANCE.doesReturn$window_release(method, Float.TYPE);
    }

    private final boolean isMethodGetLayoutDirectionValid() {
        return ReflectionUtils.validateReflection$window_release("SplitRule#getLayoutDirection is not valid", new Function0() { // from class: androidx.window.embedding.SafeActivityEmbeddingComponentProvider$$ExternalSyntheticLambda50
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                boolean isMethodGetLayoutDirectionValid$lambda$5;
                isMethodGetLayoutDirectionValid$lambda$5 = SafeActivityEmbeddingComponentProvider.isMethodGetLayoutDirectionValid$lambda$5();
                return Boolean.valueOf(isMethodGetLayoutDirectionValid$lambda$5);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isMethodGetLayoutDirectionValid$lambda$5() {
        Method method = androidx.window.extensions.embedding.SplitRule.class.getMethod("getLayoutDirection", new Class[0]);
        ReflectionUtils reflectionUtils = ReflectionUtils.INSTANCE;
        Intrinsics.checkNotNull(method);
        return reflectionUtils.isPublic$window_release(method) && ReflectionUtils.INSTANCE.doesReturn$window_release(method, Integer.TYPE);
    }

    private final boolean isClassActivityRuleValid() {
        return ReflectionUtils.validateReflection$window_release("Class ActivityRule is not valid", new Function0() { // from class: androidx.window.embedding.SafeActivityEmbeddingComponentProvider$$ExternalSyntheticLambda11
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                boolean isClassActivityRuleValid$lambda$6;
                isClassActivityRuleValid$lambda$6 = SafeActivityEmbeddingComponentProvider.isClassActivityRuleValid$lambda$6();
                return Boolean.valueOf(isClassActivityRuleValid$lambda$6);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isClassActivityRuleValid$lambda$6() {
        Method method = androidx.window.extensions.embedding.ActivityRule.class.getMethod("shouldAlwaysExpand", new Class[0]);
        ReflectionUtils reflectionUtils = ReflectionUtils.INSTANCE;
        Intrinsics.checkNotNull(method);
        return reflectionUtils.isPublic$window_release(method) && ReflectionUtils.INSTANCE.doesReturn$window_release(method, Boolean.TYPE);
    }

    private final boolean isClassActivityRuleBuilderLevel1Valid() {
        return ReflectionUtils.validateReflection$window_release("Class ActivityRule.Builder is not valid", new Function0() { // from class: androidx.window.embedding.SafeActivityEmbeddingComponentProvider$$ExternalSyntheticLambda26
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                boolean isClassActivityRuleBuilderLevel1Valid$lambda$7;
                isClassActivityRuleBuilderLevel1Valid$lambda$7 = SafeActivityEmbeddingComponentProvider.isClassActivityRuleBuilderLevel1Valid$lambda$7();
                return Boolean.valueOf(isClassActivityRuleBuilderLevel1Valid$lambda$7);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isClassActivityRuleBuilderLevel1Valid$lambda$7() {
        Method method = ActivityRule.Builder.class.getMethod("setShouldAlwaysExpand", Boolean.TYPE);
        ReflectionUtils reflectionUtils = ReflectionUtils.INSTANCE;
        Intrinsics.checkNotNull(method);
        return reflectionUtils.isPublic$window_release(method) && ReflectionUtils.INSTANCE.doesReturn$window_release(method, ActivityRule.Builder.class);
    }

    private final boolean isClassSplitInfoValid() {
        return ReflectionUtils.validateReflection$window_release("Class SplitInfo is not valid", new Function0() { // from class: androidx.window.embedding.SafeActivityEmbeddingComponentProvider$$ExternalSyntheticLambda18
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                boolean isClassSplitInfoValid$lambda$8;
                isClassSplitInfoValid$lambda$8 = SafeActivityEmbeddingComponentProvider.isClassSplitInfoValid$lambda$8();
                return Boolean.valueOf(isClassSplitInfoValid$lambda$8);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isClassSplitInfoValid$lambda$8() {
        Method method = androidx.window.extensions.embedding.SplitInfo.class.getMethod("getPrimaryActivityStack", new Class[0]);
        Method method2 = androidx.window.extensions.embedding.SplitInfo.class.getMethod("getSecondaryActivityStack", new Class[0]);
        Method method3 = androidx.window.extensions.embedding.SplitInfo.class.getMethod("getSplitRatio", new Class[0]);
        ReflectionUtils reflectionUtils = ReflectionUtils.INSTANCE;
        Intrinsics.checkNotNull(method);
        if (reflectionUtils.isPublic$window_release(method) && ReflectionUtils.INSTANCE.doesReturn$window_release(method, androidx.window.extensions.embedding.ActivityStack.class)) {
            ReflectionUtils reflectionUtils2 = ReflectionUtils.INSTANCE;
            Intrinsics.checkNotNull(method2);
            if (reflectionUtils2.isPublic$window_release(method2) && ReflectionUtils.INSTANCE.doesReturn$window_release(method2, androidx.window.extensions.embedding.ActivityStack.class)) {
                ReflectionUtils reflectionUtils3 = ReflectionUtils.INSTANCE;
                Intrinsics.checkNotNull(method3);
                if (reflectionUtils3.isPublic$window_release(method3) && ReflectionUtils.INSTANCE.doesReturn$window_release(method3, Float.TYPE)) {
                    return true;
                }
            }
        }
        return false;
    }

    private final boolean isClassSplitPairRuleValid() {
        return ReflectionUtils.validateReflection$window_release("Class SplitPairRule is not valid", new Function0() { // from class: androidx.window.embedding.SafeActivityEmbeddingComponentProvider$$ExternalSyntheticLambda59
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                boolean isClassSplitPairRuleValid$lambda$9;
                isClassSplitPairRuleValid$lambda$9 = SafeActivityEmbeddingComponentProvider.isClassSplitPairRuleValid$lambda$9();
                return Boolean.valueOf(isClassSplitPairRuleValid$lambda$9);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isClassSplitPairRuleValid$lambda$9() {
        Method method = androidx.window.extensions.embedding.SplitPairRule.class.getMethod("getFinishPrimaryWithSecondary", new Class[0]);
        Method method2 = androidx.window.extensions.embedding.SplitPairRule.class.getMethod("getFinishSecondaryWithPrimary", new Class[0]);
        Method method3 = androidx.window.extensions.embedding.SplitPairRule.class.getMethod("shouldClearTop", new Class[0]);
        ReflectionUtils reflectionUtils = ReflectionUtils.INSTANCE;
        Intrinsics.checkNotNull(method);
        if (reflectionUtils.isPublic$window_release(method) && ReflectionUtils.INSTANCE.doesReturn$window_release(method, Integer.TYPE)) {
            ReflectionUtils reflectionUtils2 = ReflectionUtils.INSTANCE;
            Intrinsics.checkNotNull(method2);
            if (reflectionUtils2.isPublic$window_release(method2) && ReflectionUtils.INSTANCE.doesReturn$window_release(method2, Integer.TYPE)) {
                ReflectionUtils reflectionUtils3 = ReflectionUtils.INSTANCE;
                Intrinsics.checkNotNull(method3);
                if (reflectionUtils3.isPublic$window_release(method3) && ReflectionUtils.INSTANCE.doesReturn$window_release(method3, Boolean.TYPE)) {
                    return true;
                }
            }
        }
        return false;
    }

    private final boolean isClassSplitPairRuleBuilderLevel1Valid() {
        return ReflectionUtils.validateReflection$window_release("Class SplitPairRule.Builder is not valid", new Function0() { // from class: androidx.window.embedding.SafeActivityEmbeddingComponentProvider$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                boolean isClassSplitPairRuleBuilderLevel1Valid$lambda$10;
                isClassSplitPairRuleBuilderLevel1Valid$lambda$10 = SafeActivityEmbeddingComponentProvider.isClassSplitPairRuleBuilderLevel1Valid$lambda$10();
                return Boolean.valueOf(isClassSplitPairRuleBuilderLevel1Valid$lambda$10);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isClassSplitPairRuleBuilderLevel1Valid$lambda$10() {
        Method method = SplitPairRule.Builder.class.getMethod("setSplitRatio", Float.TYPE);
        Method method2 = SplitPairRule.Builder.class.getMethod("setLayoutDirection", Integer.TYPE);
        ReflectionUtils reflectionUtils = ReflectionUtils.INSTANCE;
        Intrinsics.checkNotNull(method);
        if (reflectionUtils.isPublic$window_release(method) && ReflectionUtils.INSTANCE.doesReturn$window_release(method, SplitPairRule.Builder.class)) {
            ReflectionUtils reflectionUtils2 = ReflectionUtils.INSTANCE;
            Intrinsics.checkNotNull(method2);
            if (reflectionUtils2.isPublic$window_release(method2) && ReflectionUtils.INSTANCE.doesReturn$window_release(method2, SplitPairRule.Builder.class)) {
                return true;
            }
        }
        return false;
    }

    private final boolean isClassSplitPlaceholderRuleValid() {
        return ReflectionUtils.validateReflection$window_release("Class SplitPlaceholderRule is not valid", new Function0() { // from class: androidx.window.embedding.SafeActivityEmbeddingComponentProvider$$ExternalSyntheticLambda44
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                boolean isClassSplitPlaceholderRuleValid$lambda$11;
                isClassSplitPlaceholderRuleValid$lambda$11 = SafeActivityEmbeddingComponentProvider.isClassSplitPlaceholderRuleValid$lambda$11();
                return Boolean.valueOf(isClassSplitPlaceholderRuleValid$lambda$11);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isClassSplitPlaceholderRuleValid$lambda$11() {
        Method method = androidx.window.extensions.embedding.SplitPlaceholderRule.class.getMethod("getPlaceholderIntent", new Class[0]);
        Method method2 = androidx.window.extensions.embedding.SplitPlaceholderRule.class.getMethod("isSticky", new Class[0]);
        Method method3 = androidx.window.extensions.embedding.SplitPlaceholderRule.class.getMethod("getFinishPrimaryWithSecondary", new Class[0]);
        ReflectionUtils reflectionUtils = ReflectionUtils.INSTANCE;
        Intrinsics.checkNotNull(method);
        if (reflectionUtils.isPublic$window_release(method) && ReflectionUtils.INSTANCE.doesReturn$window_release(method, Intent.class)) {
            ReflectionUtils reflectionUtils2 = ReflectionUtils.INSTANCE;
            Intrinsics.checkNotNull(method2);
            if (reflectionUtils2.isPublic$window_release(method2) && ReflectionUtils.INSTANCE.doesReturn$window_release(method2, Boolean.TYPE)) {
                ReflectionUtils reflectionUtils3 = ReflectionUtils.INSTANCE;
                Intrinsics.checkNotNull(method3);
                if (reflectionUtils3.isPublic$window_release(method3) && ReflectionUtils.INSTANCE.doesReturn$window_release(method3, Integer.TYPE)) {
                    return true;
                }
            }
        }
        return false;
    }

    private final boolean isClassSplitPlaceholderRuleBuilderLevel1Valid() {
        return ReflectionUtils.validateReflection$window_release("Class SplitPlaceholderRule.Builder is not valid", new Function0() { // from class: androidx.window.embedding.SafeActivityEmbeddingComponentProvider$$ExternalSyntheticLambda14
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                boolean isClassSplitPlaceholderRuleBuilderLevel1Valid$lambda$12;
                isClassSplitPlaceholderRuleBuilderLevel1Valid$lambda$12 = SafeActivityEmbeddingComponentProvider.isClassSplitPlaceholderRuleBuilderLevel1Valid$lambda$12();
                return Boolean.valueOf(isClassSplitPlaceholderRuleBuilderLevel1Valid$lambda$12);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isClassSplitPlaceholderRuleBuilderLevel1Valid$lambda$12() {
        Method method = SplitPlaceholderRule.Builder.class.getMethod("setSplitRatio", Float.TYPE);
        Method method2 = SplitPlaceholderRule.Builder.class.getMethod("setLayoutDirection", Integer.TYPE);
        Method method3 = SplitPlaceholderRule.Builder.class.getMethod("setSticky", Boolean.TYPE);
        Method method4 = SplitPlaceholderRule.Builder.class.getMethod("setFinishPrimaryWithSecondary", Integer.TYPE);
        ReflectionUtils reflectionUtils = ReflectionUtils.INSTANCE;
        Intrinsics.checkNotNull(method);
        if (reflectionUtils.isPublic$window_release(method) && ReflectionUtils.INSTANCE.doesReturn$window_release(method, SplitPlaceholderRule.Builder.class)) {
            ReflectionUtils reflectionUtils2 = ReflectionUtils.INSTANCE;
            Intrinsics.checkNotNull(method2);
            if (reflectionUtils2.isPublic$window_release(method2) && ReflectionUtils.INSTANCE.doesReturn$window_release(method2, SplitPlaceholderRule.Builder.class)) {
                ReflectionUtils reflectionUtils3 = ReflectionUtils.INSTANCE;
                Intrinsics.checkNotNull(method3);
                if (reflectionUtils3.isPublic$window_release(method3) && ReflectionUtils.INSTANCE.doesReturn$window_release(method3, SplitPlaceholderRule.Builder.class)) {
                    ReflectionUtils reflectionUtils4 = ReflectionUtils.INSTANCE;
                    Intrinsics.checkNotNull(method4);
                    if (reflectionUtils4.isPublic$window_release(method4) && ReflectionUtils.INSTANCE.doesReturn$window_release(method4, SplitPlaceholderRule.Builder.class)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private final boolean isMethodSetSplitInfoCallbackWindowConsumerValid() {
        return ReflectionUtils.validateReflection$window_release("ActivityEmbeddingComponent#setSplitInfoCallback is not valid", new Function0() { // from class: androidx.window.embedding.SafeActivityEmbeddingComponentProvider$$ExternalSyntheticLambda41
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                boolean isMethodSetSplitInfoCallbackWindowConsumerValid$lambda$13;
                isMethodSetSplitInfoCallbackWindowConsumerValid$lambda$13 = SafeActivityEmbeddingComponentProvider.isMethodSetSplitInfoCallbackWindowConsumerValid$lambda$13(SafeActivityEmbeddingComponentProvider.this);
                return Boolean.valueOf(isMethodSetSplitInfoCallbackWindowConsumerValid$lambda$13);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isMethodSetSplitInfoCallbackWindowConsumerValid$lambda$13(SafeActivityEmbeddingComponentProvider safeActivityEmbeddingComponentProvider) {
        Method method = safeActivityEmbeddingComponentProvider.getActivityEmbeddingComponentClass().getMethod("setSplitInfoCallback", Consumer.class);
        ReflectionUtils reflectionUtils = ReflectionUtils.INSTANCE;
        Intrinsics.checkNotNull(method);
        return reflectionUtils.isPublic$window_release(method);
    }

    private final boolean isMethodClearSplitInfoCallbackValid() {
        return ReflectionUtils.validateReflection$window_release("ActivityEmbeddingComponent#clearSplitInfoCallback is not valid", new Function0() { // from class: androidx.window.embedding.SafeActivityEmbeddingComponentProvider$$ExternalSyntheticLambda21
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                boolean isMethodClearSplitInfoCallbackValid$lambda$14;
                isMethodClearSplitInfoCallbackValid$lambda$14 = SafeActivityEmbeddingComponentProvider.isMethodClearSplitInfoCallbackValid$lambda$14(SafeActivityEmbeddingComponentProvider.this);
                return Boolean.valueOf(isMethodClearSplitInfoCallbackValid$lambda$14);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isMethodClearSplitInfoCallbackValid$lambda$14(SafeActivityEmbeddingComponentProvider safeActivityEmbeddingComponentProvider) {
        Method method = safeActivityEmbeddingComponentProvider.getActivityEmbeddingComponentClass().getMethod("clearSplitInfoCallback", new Class[0]);
        ReflectionUtils reflectionUtils = ReflectionUtils.INSTANCE;
        Intrinsics.checkNotNull(method);
        return reflectionUtils.isPublic$window_release(method);
    }

    private final boolean isMethodSplitAttributesCalculatorValid() {
        return ReflectionUtils.validateReflection$window_release("ActivityEmbeddingComponent#setSplitAttributesCalculator is not valid", new Function0() { // from class: androidx.window.embedding.SafeActivityEmbeddingComponentProvider$$ExternalSyntheticLambda54
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                boolean isMethodSplitAttributesCalculatorValid$lambda$15;
                isMethodSplitAttributesCalculatorValid$lambda$15 = SafeActivityEmbeddingComponentProvider.isMethodSplitAttributesCalculatorValid$lambda$15(SafeActivityEmbeddingComponentProvider.this);
                return Boolean.valueOf(isMethodSplitAttributesCalculatorValid$lambda$15);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isMethodSplitAttributesCalculatorValid$lambda$15(SafeActivityEmbeddingComponentProvider safeActivityEmbeddingComponentProvider) {
        Method method = safeActivityEmbeddingComponentProvider.getActivityEmbeddingComponentClass().getMethod("setSplitAttributesCalculator", Function.class);
        Method method2 = safeActivityEmbeddingComponentProvider.getActivityEmbeddingComponentClass().getMethod("clearSplitAttributesCalculator", new Class[0]);
        ReflectionUtils reflectionUtils = ReflectionUtils.INSTANCE;
        Intrinsics.checkNotNull(method);
        if (reflectionUtils.isPublic$window_release(method)) {
            ReflectionUtils reflectionUtils2 = ReflectionUtils.INSTANCE;
            Intrinsics.checkNotNull(method2);
            if (reflectionUtils2.isPublic$window_release(method2)) {
                return true;
            }
        }
        return false;
    }

    private final boolean isMethodGetSplitAttributesValid() {
        return ReflectionUtils.validateReflection$window_release("SplitInfo#getSplitAttributes is not valid", new Function0() { // from class: androidx.window.embedding.SafeActivityEmbeddingComponentProvider$$ExternalSyntheticLambda60
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                boolean isMethodGetSplitAttributesValid$lambda$16;
                isMethodGetSplitAttributesValid$lambda$16 = SafeActivityEmbeddingComponentProvider.isMethodGetSplitAttributesValid$lambda$16();
                return Boolean.valueOf(isMethodGetSplitAttributesValid$lambda$16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isMethodGetSplitAttributesValid$lambda$16() {
        Method method = androidx.window.extensions.embedding.SplitInfo.class.getMethod("getSplitAttributes", new Class[0]);
        ReflectionUtils reflectionUtils = ReflectionUtils.INSTANCE;
        Intrinsics.checkNotNull(method);
        return reflectionUtils.isPublic$window_release(method) && ReflectionUtils.INSTANCE.doesReturn$window_release(method, androidx.window.extensions.embedding.SplitAttributes.class);
    }

    private final boolean isMethodGetFinishPrimaryWithPlaceholderValid() {
        return ReflectionUtils.validateReflection$window_release("SplitPlaceholderRule#getFinishPrimaryWithPlaceholder is not valid", new Function0() { // from class: androidx.window.embedding.SafeActivityEmbeddingComponentProvider$$ExternalSyntheticLambda12
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                boolean isMethodGetFinishPrimaryWithPlaceholderValid$lambda$17;
                isMethodGetFinishPrimaryWithPlaceholderValid$lambda$17 = SafeActivityEmbeddingComponentProvider.isMethodGetFinishPrimaryWithPlaceholderValid$lambda$17();
                return Boolean.valueOf(isMethodGetFinishPrimaryWithPlaceholderValid$lambda$17);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isMethodGetFinishPrimaryWithPlaceholderValid$lambda$17() {
        Method method = androidx.window.extensions.embedding.SplitPlaceholderRule.class.getMethod("getFinishPrimaryWithPlaceholder", new Class[0]);
        ReflectionUtils reflectionUtils = ReflectionUtils.INSTANCE;
        Intrinsics.checkNotNull(method);
        return reflectionUtils.isPublic$window_release(method) && ReflectionUtils.INSTANCE.doesReturn$window_release(method, Integer.TYPE);
    }

    private final boolean isMethodGetDefaultSplitAttributesValid() {
        return ReflectionUtils.validateReflection$window_release("SplitRule#getDefaultSplitAttributes is not valid", new Function0() { // from class: androidx.window.embedding.SafeActivityEmbeddingComponentProvider$$ExternalSyntheticLambda39
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                boolean isMethodGetDefaultSplitAttributesValid$lambda$18;
                isMethodGetDefaultSplitAttributesValid$lambda$18 = SafeActivityEmbeddingComponentProvider.isMethodGetDefaultSplitAttributesValid$lambda$18();
                return Boolean.valueOf(isMethodGetDefaultSplitAttributesValid$lambda$18);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isMethodGetDefaultSplitAttributesValid$lambda$18() {
        Method method = androidx.window.extensions.embedding.SplitRule.class.getMethod("getDefaultSplitAttributes", new Class[0]);
        ReflectionUtils reflectionUtils = ReflectionUtils.INSTANCE;
        Intrinsics.checkNotNull(method);
        return reflectionUtils.isPublic$window_release(method) && ReflectionUtils.INSTANCE.doesReturn$window_release(method, androidx.window.extensions.embedding.SplitAttributes.class);
    }

    private final boolean isClassActivityRuleBuilderLevel2Valid() {
        return ReflectionUtils.validateReflection$window_release("Class ActivityRule.Builder is not valid", new Function0() { // from class: androidx.window.embedding.SafeActivityEmbeddingComponentProvider$$ExternalSyntheticLambda33
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                boolean isClassActivityRuleBuilderLevel2Valid$lambda$19;
                isClassActivityRuleBuilderLevel2Valid$lambda$19 = SafeActivityEmbeddingComponentProvider.isClassActivityRuleBuilderLevel2Valid$lambda$19();
                return Boolean.valueOf(isClassActivityRuleBuilderLevel2Valid$lambda$19);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isClassActivityRuleBuilderLevel2Valid$lambda$19() {
        Constructor<?> declaredConstructor = ActivityRule.Builder.class.getDeclaredConstructor(Predicate.class, Predicate.class);
        Method method = ActivityRule.Builder.class.getMethod("setTag", String.class);
        ReflectionUtils reflectionUtils = ReflectionUtils.INSTANCE;
        Intrinsics.checkNotNull(declaredConstructor);
        if (reflectionUtils.isPublic$window_release(declaredConstructor)) {
            ReflectionUtils reflectionUtils2 = ReflectionUtils.INSTANCE;
            Intrinsics.checkNotNull(method);
            if (reflectionUtils2.isPublic$window_release(method) && ReflectionUtils.INSTANCE.doesReturn$window_release(method, ActivityRule.Builder.class)) {
                return true;
            }
        }
        return false;
    }

    private final boolean isClassEmbeddingRuleValid() {
        return ReflectionUtils.validateReflection$window_release("Class EmbeddingRule is not valid", new Function0() { // from class: androidx.window.embedding.SafeActivityEmbeddingComponentProvider$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                boolean isClassEmbeddingRuleValid$lambda$20;
                isClassEmbeddingRuleValid$lambda$20 = SafeActivityEmbeddingComponentProvider.isClassEmbeddingRuleValid$lambda$20();
                return Boolean.valueOf(isClassEmbeddingRuleValid$lambda$20);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isClassEmbeddingRuleValid$lambda$20() {
        Method method = EmbeddingRule.class.getMethod("getTag", new Class[0]);
        ReflectionUtils reflectionUtils = ReflectionUtils.INSTANCE;
        Intrinsics.checkNotNull(method);
        return reflectionUtils.isPublic$window_release(method) && ReflectionUtils.INSTANCE.doesReturn$window_release(method, String.class);
    }

    private final boolean isClassSplitAttributesValid() {
        return ReflectionUtils.validateReflection$window_release("Class SplitAttributes is not valid", new Function0() { // from class: androidx.window.embedding.SafeActivityEmbeddingComponentProvider$$ExternalSyntheticLambda35
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                boolean isClassSplitAttributesValid$lambda$21;
                isClassSplitAttributesValid$lambda$21 = SafeActivityEmbeddingComponentProvider.isClassSplitAttributesValid$lambda$21();
                return Boolean.valueOf(isClassSplitAttributesValid$lambda$21);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isClassSplitAttributesValid$lambda$21() {
        Method method = androidx.window.extensions.embedding.SplitAttributes.class.getMethod("getLayoutDirection", new Class[0]);
        Method method2 = androidx.window.extensions.embedding.SplitAttributes.class.getMethod("getSplitType", new Class[0]);
        Method method3 = SplitAttributes.Builder.class.getMethod("setSplitType", SplitAttributes.SplitType.class);
        Method method4 = SplitAttributes.Builder.class.getMethod("setLayoutDirection", Integer.TYPE);
        ReflectionUtils reflectionUtils = ReflectionUtils.INSTANCE;
        Intrinsics.checkNotNull(method);
        if (reflectionUtils.isPublic$window_release(method) && ReflectionUtils.INSTANCE.doesReturn$window_release(method, Integer.TYPE)) {
            ReflectionUtils reflectionUtils2 = ReflectionUtils.INSTANCE;
            Intrinsics.checkNotNull(method2);
            if (reflectionUtils2.isPublic$window_release(method2) && ReflectionUtils.INSTANCE.doesReturn$window_release(method2, SplitAttributes.SplitType.class)) {
                ReflectionUtils reflectionUtils3 = ReflectionUtils.INSTANCE;
                Intrinsics.checkNotNull(method3);
                if (reflectionUtils3.isPublic$window_release(method3)) {
                    ReflectionUtils reflectionUtils4 = ReflectionUtils.INSTANCE;
                    Intrinsics.checkNotNull(method4);
                    if (reflectionUtils4.isPublic$window_release(method4)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private final boolean isClassSplitAttributesCalculatorParamsValid() {
        return ReflectionUtils.validateReflection$window_release("Class SplitAttributesCalculatorParams is not valid", new Function0() { // from class: androidx.window.embedding.SafeActivityEmbeddingComponentProvider$$ExternalSyntheticLambda20
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                boolean isClassSplitAttributesCalculatorParamsValid$lambda$22;
                isClassSplitAttributesCalculatorParamsValid$lambda$22 = SafeActivityEmbeddingComponentProvider.isClassSplitAttributesCalculatorParamsValid$lambda$22();
                return Boolean.valueOf(isClassSplitAttributesCalculatorParamsValid$lambda$22);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isClassSplitAttributesCalculatorParamsValid$lambda$22() {
        Method method = androidx.window.extensions.embedding.SplitAttributesCalculatorParams.class.getMethod("getParentWindowMetrics", new Class[0]);
        Method method2 = androidx.window.extensions.embedding.SplitAttributesCalculatorParams.class.getMethod("getParentConfiguration", new Class[0]);
        Method method3 = androidx.window.extensions.embedding.SplitAttributesCalculatorParams.class.getMethod("getDefaultSplitAttributes", new Class[0]);
        Method method4 = androidx.window.extensions.embedding.SplitAttributesCalculatorParams.class.getMethod("areDefaultConstraintsSatisfied", new Class[0]);
        Method method5 = androidx.window.extensions.embedding.SplitAttributesCalculatorParams.class.getMethod("getParentWindowLayoutInfo", new Class[0]);
        Method method6 = androidx.window.extensions.embedding.SplitAttributesCalculatorParams.class.getMethod("getSplitRuleTag", new Class[0]);
        ReflectionUtils reflectionUtils = ReflectionUtils.INSTANCE;
        Intrinsics.checkNotNull(method);
        if (reflectionUtils.isPublic$window_release(method) && ReflectionUtils.INSTANCE.doesReturn$window_release(method, WindowMetrics.class)) {
            ReflectionUtils reflectionUtils2 = ReflectionUtils.INSTANCE;
            Intrinsics.checkNotNull(method2);
            if (reflectionUtils2.isPublic$window_release(method2) && ReflectionUtils.INSTANCE.doesReturn$window_release(method2, Configuration.class)) {
                ReflectionUtils reflectionUtils3 = ReflectionUtils.INSTANCE;
                Intrinsics.checkNotNull(method3);
                if (reflectionUtils3.isPublic$window_release(method3) && ReflectionUtils.INSTANCE.doesReturn$window_release(method3, androidx.window.extensions.embedding.SplitAttributes.class)) {
                    ReflectionUtils reflectionUtils4 = ReflectionUtils.INSTANCE;
                    Intrinsics.checkNotNull(method4);
                    if (reflectionUtils4.isPublic$window_release(method4) && ReflectionUtils.INSTANCE.doesReturn$window_release(method4, Boolean.TYPE)) {
                        ReflectionUtils reflectionUtils5 = ReflectionUtils.INSTANCE;
                        Intrinsics.checkNotNull(method5);
                        if (reflectionUtils5.isPublic$window_release(method5) && ReflectionUtils.INSTANCE.doesReturn$window_release(method5, WindowLayoutInfo.class)) {
                            ReflectionUtils reflectionUtils6 = ReflectionUtils.INSTANCE;
                            Intrinsics.checkNotNull(method6);
                            if (reflectionUtils6.isPublic$window_release(method6) && ReflectionUtils.INSTANCE.doesReturn$window_release(method6, String.class)) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    private final boolean isClassSplitTypeValid() {
        return ReflectionUtils.validateReflection$window_release("Class SplitAttributes.SplitType is not valid", new Function0() { // from class: androidx.window.embedding.SafeActivityEmbeddingComponentProvider$$ExternalSyntheticLambda36
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                boolean isClassSplitTypeValid$lambda$23;
                isClassSplitTypeValid$lambda$23 = SafeActivityEmbeddingComponentProvider.isClassSplitTypeValid$lambda$23();
                return Boolean.valueOf(isClassSplitTypeValid$lambda$23);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isClassSplitTypeValid$lambda$23() {
        Constructor<?> declaredConstructor = SplitAttributes.SplitType.RatioSplitType.class.getDeclaredConstructor(Float.TYPE);
        Method method = SplitAttributes.SplitType.RatioSplitType.class.getMethod("getRatio", new Class[0]);
        Method method2 = SplitAttributes.SplitType.RatioSplitType.class.getMethod("splitEqually", new Class[0]);
        Constructor<?> declaredConstructor2 = SplitAttributes.SplitType.HingeSplitType.class.getDeclaredConstructor(SplitAttributes.SplitType.class);
        Method method3 = SplitAttributes.SplitType.HingeSplitType.class.getMethod("getFallbackSplitType", new Class[0]);
        Constructor<?> declaredConstructor3 = SplitAttributes.SplitType.ExpandContainersSplitType.class.getDeclaredConstructor(new Class[0]);
        ReflectionUtils reflectionUtils = ReflectionUtils.INSTANCE;
        Intrinsics.checkNotNull(declaredConstructor);
        if (reflectionUtils.isPublic$window_release(declaredConstructor)) {
            ReflectionUtils reflectionUtils2 = ReflectionUtils.INSTANCE;
            Intrinsics.checkNotNull(method);
            if (reflectionUtils2.isPublic$window_release(method) && ReflectionUtils.INSTANCE.doesReturn$window_release(method, Float.TYPE)) {
                ReflectionUtils reflectionUtils3 = ReflectionUtils.INSTANCE;
                Intrinsics.checkNotNull(declaredConstructor2);
                if (reflectionUtils3.isPublic$window_release(declaredConstructor2)) {
                    ReflectionUtils reflectionUtils4 = ReflectionUtils.INSTANCE;
                    Intrinsics.checkNotNull(method2);
                    if (reflectionUtils4.isPublic$window_release(method2) && ReflectionUtils.INSTANCE.doesReturn$window_release(method2, SplitAttributes.SplitType.RatioSplitType.class)) {
                        ReflectionUtils reflectionUtils5 = ReflectionUtils.INSTANCE;
                        Intrinsics.checkNotNull(method3);
                        if (reflectionUtils5.isPublic$window_release(method3) && ReflectionUtils.INSTANCE.doesReturn$window_release(method3, SplitAttributes.SplitType.class)) {
                            ReflectionUtils reflectionUtils6 = ReflectionUtils.INSTANCE;
                            Intrinsics.checkNotNull(declaredConstructor3);
                            if (reflectionUtils6.isPublic$window_release(declaredConstructor3)) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    private final boolean isClassSplitPairRuleBuilderLevel2Valid() {
        return ReflectionUtils.validateReflection$window_release("Class SplitPairRule.Builder is not valid", new Function0() { // from class: androidx.window.embedding.SafeActivityEmbeddingComponentProvider$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                boolean isClassSplitPairRuleBuilderLevel2Valid$lambda$24;
                isClassSplitPairRuleBuilderLevel2Valid$lambda$24 = SafeActivityEmbeddingComponentProvider.isClassSplitPairRuleBuilderLevel2Valid$lambda$24();
                return Boolean.valueOf(isClassSplitPairRuleBuilderLevel2Valid$lambda$24);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isClassSplitPairRuleBuilderLevel2Valid$lambda$24() {
        Constructor<?> declaredConstructor = SplitPairRule.Builder.class.getDeclaredConstructor(Predicate.class, Predicate.class, Predicate.class);
        Method method = SplitPairRule.Builder.class.getMethod("setDefaultSplitAttributes", androidx.window.extensions.embedding.SplitAttributes.class);
        Method method2 = SplitPairRule.Builder.class.getMethod("setTag", String.class);
        ReflectionUtils reflectionUtils = ReflectionUtils.INSTANCE;
        Intrinsics.checkNotNull(declaredConstructor);
        if (reflectionUtils.isPublic$window_release(declaredConstructor)) {
            ReflectionUtils reflectionUtils2 = ReflectionUtils.INSTANCE;
            Intrinsics.checkNotNull(method);
            if (reflectionUtils2.isPublic$window_release(method) && ReflectionUtils.INSTANCE.doesReturn$window_release(method, SplitPairRule.Builder.class)) {
                ReflectionUtils reflectionUtils3 = ReflectionUtils.INSTANCE;
                Intrinsics.checkNotNull(method2);
                if (reflectionUtils3.isPublic$window_release(method2) && ReflectionUtils.INSTANCE.doesReturn$window_release(method2, SplitPairRule.Builder.class)) {
                    return true;
                }
            }
        }
        return false;
    }

    private final boolean isClassSplitPlaceholderRuleBuilderLevel2Valid() {
        return ReflectionUtils.validateReflection$window_release("Class SplitPlaceholderRule.Builder is not valid", new Function0() { // from class: androidx.window.embedding.SafeActivityEmbeddingComponentProvider$$ExternalSyntheticLambda46
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                boolean isClassSplitPlaceholderRuleBuilderLevel2Valid$lambda$25;
                isClassSplitPlaceholderRuleBuilderLevel2Valid$lambda$25 = SafeActivityEmbeddingComponentProvider.isClassSplitPlaceholderRuleBuilderLevel2Valid$lambda$25();
                return Boolean.valueOf(isClassSplitPlaceholderRuleBuilderLevel2Valid$lambda$25);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isClassSplitPlaceholderRuleBuilderLevel2Valid$lambda$25() {
        Constructor<?> declaredConstructor = SplitPlaceholderRule.Builder.class.getDeclaredConstructor(Intent.class, Predicate.class, Predicate.class, Predicate.class);
        Method method = SplitPlaceholderRule.Builder.class.getMethod("setDefaultSplitAttributes", androidx.window.extensions.embedding.SplitAttributes.class);
        Method method2 = SplitPlaceholderRule.Builder.class.getMethod("setFinishPrimaryWithPlaceholder", Integer.TYPE);
        Method method3 = SplitPlaceholderRule.Builder.class.getMethod("setTag", String.class);
        ReflectionUtils reflectionUtils = ReflectionUtils.INSTANCE;
        Intrinsics.checkNotNull(declaredConstructor);
        if (reflectionUtils.isPublic$window_release(declaredConstructor)) {
            ReflectionUtils reflectionUtils2 = ReflectionUtils.INSTANCE;
            Intrinsics.checkNotNull(method);
            if (reflectionUtils2.isPublic$window_release(method) && ReflectionUtils.INSTANCE.doesReturn$window_release(method, SplitPlaceholderRule.Builder.class)) {
                ReflectionUtils reflectionUtils3 = ReflectionUtils.INSTANCE;
                Intrinsics.checkNotNull(method2);
                if (reflectionUtils3.isPublic$window_release(method2) && ReflectionUtils.INSTANCE.doesReturn$window_release(method2, SplitPlaceholderRule.Builder.class)) {
                    ReflectionUtils reflectionUtils4 = ReflectionUtils.INSTANCE;
                    Intrinsics.checkNotNull(method3);
                    if (reflectionUtils4.isPublic$window_release(method3) && ReflectionUtils.INSTANCE.doesReturn$window_release(method3, SplitPlaceholderRule.Builder.class)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private final boolean isMethodInvalidateTopVisibleSplitAttributesValid() {
        return ReflectionUtils.validateReflection$window_release("#invalidateTopVisibleSplitAttributes is not valid", new Function0() { // from class: androidx.window.embedding.SafeActivityEmbeddingComponentProvider$$ExternalSyntheticLambda25
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                boolean isMethodInvalidateTopVisibleSplitAttributesValid$lambda$26;
                isMethodInvalidateTopVisibleSplitAttributesValid$lambda$26 = SafeActivityEmbeddingComponentProvider.isMethodInvalidateTopVisibleSplitAttributesValid$lambda$26(SafeActivityEmbeddingComponentProvider.this);
                return Boolean.valueOf(isMethodInvalidateTopVisibleSplitAttributesValid$lambda$26);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isMethodInvalidateTopVisibleSplitAttributesValid$lambda$26(SafeActivityEmbeddingComponentProvider safeActivityEmbeddingComponentProvider) {
        Method method = safeActivityEmbeddingComponentProvider.getActivityEmbeddingComponentClass().getMethod("invalidateTopVisibleSplitAttributes", new Class[0]);
        ReflectionUtils reflectionUtils = ReflectionUtils.INSTANCE;
        Intrinsics.checkNotNull(method);
        return reflectionUtils.isPublic$window_release(method);
    }

    private final boolean isMethodUpdateSplitAttributesValid() {
        return ReflectionUtils.validateReflection$window_release("#updateSplitAttributes is not valid", new Function0() { // from class: androidx.window.embedding.SafeActivityEmbeddingComponentProvider$$ExternalSyntheticLambda22
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                boolean isMethodUpdateSplitAttributesValid$lambda$27;
                isMethodUpdateSplitAttributesValid$lambda$27 = SafeActivityEmbeddingComponentProvider.isMethodUpdateSplitAttributesValid$lambda$27(SafeActivityEmbeddingComponentProvider.this);
                return Boolean.valueOf(isMethodUpdateSplitAttributesValid$lambda$27);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isMethodUpdateSplitAttributesValid$lambda$27(SafeActivityEmbeddingComponentProvider safeActivityEmbeddingComponentProvider) {
        Method method = safeActivityEmbeddingComponentProvider.getActivityEmbeddingComponentClass().getMethod("updateSplitAttributes", IBinder.class, androidx.window.extensions.embedding.SplitAttributes.class);
        ReflectionUtils reflectionUtils = ReflectionUtils.INSTANCE;
        Intrinsics.checkNotNull(method);
        return reflectionUtils.isPublic$window_release(method);
    }

    private final boolean isMethodSplitInfoGetTokenValid() {
        return ReflectionUtils.validateReflection$window_release("SplitInfo#getToken is not valid", new Function0() { // from class: androidx.window.embedding.SafeActivityEmbeddingComponentProvider$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                boolean isMethodSplitInfoGetTokenValid$lambda$28;
                isMethodSplitInfoGetTokenValid$lambda$28 = SafeActivityEmbeddingComponentProvider.isMethodSplitInfoGetTokenValid$lambda$28();
                return Boolean.valueOf(isMethodSplitInfoGetTokenValid$lambda$28);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isMethodSplitInfoGetTokenValid$lambda$28() {
        Method method = androidx.window.extensions.embedding.SplitInfo.class.getMethod("getToken", new Class[0]);
        ReflectionUtils reflectionUtils = ReflectionUtils.INSTANCE;
        Intrinsics.checkNotNull(method);
        return reflectionUtils.isPublic$window_release(method) && ReflectionUtils.INSTANCE.doesReturn$window_release(method, IBinder.class);
    }

    private final boolean isActivityStackGetActivityStackTokenValid() {
        return ReflectionUtils.validateReflection$window_release("ActivityStack#getActivityToken is not valid", new Function0() { // from class: androidx.window.embedding.SafeActivityEmbeddingComponentProvider$$ExternalSyntheticLambda42
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                boolean isActivityStackGetActivityStackTokenValid$lambda$29;
                isActivityStackGetActivityStackTokenValid$lambda$29 = SafeActivityEmbeddingComponentProvider.isActivityStackGetActivityStackTokenValid$lambda$29();
                return Boolean.valueOf(isActivityStackGetActivityStackTokenValid$lambda$29);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isActivityStackGetActivityStackTokenValid$lambda$29() {
        Method method = androidx.window.extensions.embedding.ActivityStack.class.getMethod("getActivityStackToken", new Class[0]);
        ReflectionUtils reflectionUtils = ReflectionUtils.INSTANCE;
        Intrinsics.checkNotNull(method);
        return reflectionUtils.isPublic$window_release(method) && ReflectionUtils.INSTANCE.doesReturn$window_release(method, ActivityStack.Token.class);
    }

    private final boolean isMethodRegisterActivityStackCallbackValid() {
        return ReflectionUtils.validateReflection$window_release("registerActivityStackCallback is not valid", new Function0() { // from class: androidx.window.embedding.SafeActivityEmbeddingComponentProvider$$ExternalSyntheticLambda55
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                boolean isMethodRegisterActivityStackCallbackValid$lambda$30;
                isMethodRegisterActivityStackCallbackValid$lambda$30 = SafeActivityEmbeddingComponentProvider.isMethodRegisterActivityStackCallbackValid$lambda$30(SafeActivityEmbeddingComponentProvider.this);
                return Boolean.valueOf(isMethodRegisterActivityStackCallbackValid$lambda$30);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isMethodRegisterActivityStackCallbackValid$lambda$30(SafeActivityEmbeddingComponentProvider safeActivityEmbeddingComponentProvider) {
        Method method = safeActivityEmbeddingComponentProvider.getActivityEmbeddingComponentClass().getMethod("registerActivityStackCallback", Executor.class, Consumer.class);
        ReflectionUtils reflectionUtils = ReflectionUtils.INSTANCE;
        Intrinsics.checkNotNull(method);
        return reflectionUtils.isPublic$window_release(method);
    }

    private final boolean isMethodUnregisterActivityStackCallbackValid() {
        return ReflectionUtils.validateReflection$window_release("unregisterActivityStackCallback is not valid", new Function0() { // from class: androidx.window.embedding.SafeActivityEmbeddingComponentProvider$$ExternalSyntheticLambda61
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                boolean isMethodUnregisterActivityStackCallbackValid$lambda$31;
                isMethodUnregisterActivityStackCallbackValid$lambda$31 = SafeActivityEmbeddingComponentProvider.isMethodUnregisterActivityStackCallbackValid$lambda$31(SafeActivityEmbeddingComponentProvider.this);
                return Boolean.valueOf(isMethodUnregisterActivityStackCallbackValid$lambda$31);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isMethodUnregisterActivityStackCallbackValid$lambda$31(SafeActivityEmbeddingComponentProvider safeActivityEmbeddingComponentProvider) {
        Method method = safeActivityEmbeddingComponentProvider.getActivityEmbeddingComponentClass().getMethod("unregisterActivityStackCallback", Consumer.class);
        ReflectionUtils reflectionUtils = ReflectionUtils.INSTANCE;
        Intrinsics.checkNotNull(method);
        return reflectionUtils.isPublic$window_release(method);
    }

    private final boolean isMethodPinUnpinTopActivityStackValid() {
        return ReflectionUtils.validateReflection$window_release("#pin(unPin)TopActivityStack is not valid", new Function0() { // from class: androidx.window.embedding.SafeActivityEmbeddingComponentProvider$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                boolean isMethodPinUnpinTopActivityStackValid$lambda$32;
                isMethodPinUnpinTopActivityStackValid$lambda$32 = SafeActivityEmbeddingComponentProvider.isMethodPinUnpinTopActivityStackValid$lambda$32(SafeActivityEmbeddingComponentProvider.this);
                return Boolean.valueOf(isMethodPinUnpinTopActivityStackValid$lambda$32);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isMethodPinUnpinTopActivityStackValid$lambda$32(SafeActivityEmbeddingComponentProvider safeActivityEmbeddingComponentProvider) {
        Method method = androidx.window.extensions.embedding.SplitPinRule.class.getMethod("isSticky", new Class[0]);
        Method method2 = safeActivityEmbeddingComponentProvider.getActivityEmbeddingComponentClass().getMethod("pinTopActivityStack", Integer.TYPE, androidx.window.extensions.embedding.SplitPinRule.class);
        Method method3 = safeActivityEmbeddingComponentProvider.getActivityEmbeddingComponentClass().getMethod("unpinTopActivityStack", Integer.TYPE);
        ReflectionUtils reflectionUtils = ReflectionUtils.INSTANCE;
        Intrinsics.checkNotNull(method);
        if (reflectionUtils.isPublic$window_release(method) && ReflectionUtils.INSTANCE.doesReturn$window_release(method, Boolean.TYPE)) {
            ReflectionUtils reflectionUtils2 = ReflectionUtils.INSTANCE;
            Intrinsics.checkNotNull(method2);
            if (reflectionUtils2.isPublic$window_release(method2) && ReflectionUtils.INSTANCE.doesReturn$window_release(method2, Boolean.TYPE)) {
                ReflectionUtils reflectionUtils3 = ReflectionUtils.INSTANCE;
                Intrinsics.checkNotNull(method3);
                if (reflectionUtils3.isPublic$window_release(method3)) {
                    return true;
                }
            }
        }
        return false;
    }

    private final boolean isMethodUpdateSplitAttributesWithTokenValid() {
        return ReflectionUtils.validateReflection$window_release("updateSplitAttributes is not valid", new Function0() { // from class: androidx.window.embedding.SafeActivityEmbeddingComponentProvider$$ExternalSyntheticLambda56
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                boolean isMethodUpdateSplitAttributesWithTokenValid$lambda$33;
                isMethodUpdateSplitAttributesWithTokenValid$lambda$33 = SafeActivityEmbeddingComponentProvider.isMethodUpdateSplitAttributesWithTokenValid$lambda$33(SafeActivityEmbeddingComponentProvider.this);
                return Boolean.valueOf(isMethodUpdateSplitAttributesWithTokenValid$lambda$33);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isMethodUpdateSplitAttributesWithTokenValid$lambda$33(SafeActivityEmbeddingComponentProvider safeActivityEmbeddingComponentProvider) {
        Method method = safeActivityEmbeddingComponentProvider.getActivityEmbeddingComponentClass().getMethod("updateSplitAttributes", SplitInfo.Token.class, androidx.window.extensions.embedding.SplitAttributes.class);
        ReflectionUtils reflectionUtils = ReflectionUtils.INSTANCE;
        Intrinsics.checkNotNull(method);
        return reflectionUtils.isPublic$window_release(method);
    }

    private final boolean isMethodGetSplitInfoTokenValid() {
        return ReflectionUtils.validateReflection$window_release("SplitInfo#getSplitInfoToken is not valid", new Function0() { // from class: androidx.window.embedding.SafeActivityEmbeddingComponentProvider$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                boolean isMethodGetSplitInfoTokenValid$lambda$34;
                isMethodGetSplitInfoTokenValid$lambda$34 = SafeActivityEmbeddingComponentProvider.isMethodGetSplitInfoTokenValid$lambda$34();
                return Boolean.valueOf(isMethodGetSplitInfoTokenValid$lambda$34);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isMethodGetSplitInfoTokenValid$lambda$34() {
        Method method = androidx.window.extensions.embedding.SplitInfo.class.getMethod("getSplitInfoToken", new Class[0]);
        ReflectionUtils reflectionUtils = ReflectionUtils.INSTANCE;
        Intrinsics.checkNotNull(method);
        return reflectionUtils.isPublic$window_release(method) && ReflectionUtils.INSTANCE.doesReturn$window_release(method, SplitInfo.Token.class);
    }

    private final boolean isClassAnimationBackgroundValid() {
        return ReflectionUtils.validateReflection$window_release("Class AnimationBackground is not valid", new Function0() { // from class: androidx.window.embedding.SafeActivityEmbeddingComponentProvider$$ExternalSyntheticLambda32
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                boolean isClassAnimationBackgroundValid$lambda$35;
                isClassAnimationBackgroundValid$lambda$35 = SafeActivityEmbeddingComponentProvider.isClassAnimationBackgroundValid$lambda$35();
                return Boolean.valueOf(isClassAnimationBackgroundValid$lambda$35);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isClassAnimationBackgroundValid$lambda$35() {
        Method method = AnimationBackground.class.getMethod("createColorBackground", Integer.TYPE);
        Field declaredField = AnimationBackground.class.getDeclaredField("ANIMATION_BACKGROUND_DEFAULT");
        Method method2 = AnimationBackground.ColorBackground.class.getMethod("getColor", new Class[0]);
        Method method3 = androidx.window.extensions.embedding.SplitAttributes.class.getMethod("getAnimationBackground", new Class[0]);
        Method method4 = SplitAttributes.Builder.class.getMethod("setAnimationBackground", AnimationBackground.class);
        ReflectionUtils reflectionUtils = ReflectionUtils.INSTANCE;
        Intrinsics.checkNotNull(method);
        if (reflectionUtils.isPublic$window_release(method) && ReflectionUtils.INSTANCE.doesReturn$window_release(method, AnimationBackground.ColorBackground.class)) {
            ReflectionUtils reflectionUtils2 = ReflectionUtils.INSTANCE;
            Intrinsics.checkNotNull(declaredField);
            if (reflectionUtils2.isPublic$window_release(declaredField)) {
                ReflectionUtils reflectionUtils3 = ReflectionUtils.INSTANCE;
                Intrinsics.checkNotNull(method2);
                if (reflectionUtils3.isPublic$window_release(method2) && ReflectionUtils.INSTANCE.doesReturn$window_release(method2, Integer.TYPE)) {
                    ReflectionUtils reflectionUtils4 = ReflectionUtils.INSTANCE;
                    Intrinsics.checkNotNull(method3);
                    if (reflectionUtils4.isPublic$window_release(method3) && ReflectionUtils.INSTANCE.doesReturn$window_release(method3, AnimationBackground.class)) {
                        ReflectionUtils reflectionUtils5 = ReflectionUtils.INSTANCE;
                        Intrinsics.checkNotNull(method4);
                        if (reflectionUtils5.isPublic$window_release(method4) && ReflectionUtils.INSTANCE.doesReturn$window_release(method4, SplitAttributes.Builder.class)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    private final boolean isClassActivityStackTokenValid() {
        return ReflectionUtils.validateReflection$window_release("Class ActivityStack.Token is not valid", new Function0() { // from class: androidx.window.embedding.SafeActivityEmbeddingComponentProvider$$ExternalSyntheticLambda62
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                boolean isClassActivityStackTokenValid$lambda$36;
                isClassActivityStackTokenValid$lambda$36 = SafeActivityEmbeddingComponentProvider.isClassActivityStackTokenValid$lambda$36();
                return Boolean.valueOf(isClassActivityStackTokenValid$lambda$36);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isClassActivityStackTokenValid$lambda$36() {
        Method method = ActivityStack.Token.class.getMethod("toBundle", new Class[0]);
        Method method2 = ActivityStack.Token.class.getMethod("readFromBundle", Bundle.class);
        Method method3 = ActivityStack.Token.class.getMethod("createFromBinder", IBinder.class);
        Field declaredField = ActivityStack.Token.class.getDeclaredField("INVALID_ACTIVITY_STACK_TOKEN");
        ReflectionUtils reflectionUtils = ReflectionUtils.INSTANCE;
        Intrinsics.checkNotNull(method);
        if (reflectionUtils.isPublic$window_release(method) && ReflectionUtils.INSTANCE.doesReturn$window_release(method, Bundle.class)) {
            ReflectionUtils reflectionUtils2 = ReflectionUtils.INSTANCE;
            Intrinsics.checkNotNull(method2);
            if (reflectionUtils2.isPublic$window_release(method2) && ReflectionUtils.INSTANCE.doesReturn$window_release(method2, ActivityStack.Token.class)) {
                ReflectionUtils reflectionUtils3 = ReflectionUtils.INSTANCE;
                Intrinsics.checkNotNull(method3);
                if (reflectionUtils3.isPublic$window_release(method3) && ReflectionUtils.INSTANCE.doesReturn$window_release(method3, ActivityStack.Token.class)) {
                    ReflectionUtils reflectionUtils4 = ReflectionUtils.INSTANCE;
                    Intrinsics.checkNotNull(declaredField);
                    if (reflectionUtils4.isPublic$window_release(declaredField)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private final boolean isClassWindowAttributesValid() {
        return ReflectionUtils.validateReflection$window_release("Class WindowAttributes is not valid", new Function0() { // from class: androidx.window.embedding.SafeActivityEmbeddingComponentProvider$$ExternalSyntheticLambda23
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                boolean isClassWindowAttributesValid$lambda$37;
                isClassWindowAttributesValid$lambda$37 = SafeActivityEmbeddingComponentProvider.isClassWindowAttributesValid$lambda$37();
                return Boolean.valueOf(isClassWindowAttributesValid$lambda$37);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isClassWindowAttributesValid$lambda$37() {
        Method method = WindowAttributes.class.getMethod("getDimAreaBehavior", new Class[0]);
        Method method2 = androidx.window.extensions.embedding.SplitAttributes.class.getMethod("getWindowAttributes", new Class[0]);
        Method method3 = SplitAttributes.Builder.class.getMethod("setWindowAttributes", WindowAttributes.class);
        ReflectionUtils reflectionUtils = ReflectionUtils.INSTANCE;
        Intrinsics.checkNotNull(method);
        if (reflectionUtils.isPublic$window_release(method) && ReflectionUtils.INSTANCE.doesReturn$window_release(method, Integer.TYPE)) {
            ReflectionUtils reflectionUtils2 = ReflectionUtils.INSTANCE;
            Intrinsics.checkNotNull(method2);
            if (reflectionUtils2.isPublic$window_release(method2) && ReflectionUtils.INSTANCE.doesReturn$window_release(method2, WindowAttributes.class)) {
                ReflectionUtils reflectionUtils3 = ReflectionUtils.INSTANCE;
                Intrinsics.checkNotNull(method3);
                if (reflectionUtils3.isPublic$window_release(method3) && ReflectionUtils.INSTANCE.doesReturn$window_release(method3, SplitAttributes.Builder.class)) {
                    return true;
                }
            }
        }
        return false;
    }

    private final boolean isClassSplitInfoTokenValid() {
        return ReflectionUtils.validateReflection$window_release("SplitInfo.Token is not valid", new Function0() { // from class: androidx.window.embedding.SafeActivityEmbeddingComponentProvider$$ExternalSyntheticLambda24
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                boolean isClassSplitInfoTokenValid$lambda$38;
                isClassSplitInfoTokenValid$lambda$38 = SafeActivityEmbeddingComponentProvider.isClassSplitInfoTokenValid$lambda$38();
                return Boolean.valueOf(isClassSplitInfoTokenValid$lambda$38);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isClassSplitInfoTokenValid$lambda$38() {
        Method method = SplitInfo.Token.class.getMethod("createFromBinder", IBinder.class);
        ReflectionUtils reflectionUtils = ReflectionUtils.INSTANCE;
        Intrinsics.checkNotNull(method);
        return reflectionUtils.isPublic$window_release(method) && ReflectionUtils.INSTANCE.doesReturn$window_release(method, SplitInfo.Token.class);
    }

    private final boolean isMethodGetEmbeddedActivityWindowInfoValid() {
        return ReflectionUtils.validateReflection$window_release("ActivityEmbeddingComponent#getEmbeddedActivityWindowInfo is not valid", new Function0() { // from class: androidx.window.embedding.SafeActivityEmbeddingComponentProvider$$ExternalSyntheticLambda19
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                boolean isMethodGetEmbeddedActivityWindowInfoValid$lambda$39;
                isMethodGetEmbeddedActivityWindowInfoValid$lambda$39 = SafeActivityEmbeddingComponentProvider.isMethodGetEmbeddedActivityWindowInfoValid$lambda$39(SafeActivityEmbeddingComponentProvider.this);
                return Boolean.valueOf(isMethodGetEmbeddedActivityWindowInfoValid$lambda$39);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isMethodGetEmbeddedActivityWindowInfoValid$lambda$39(SafeActivityEmbeddingComponentProvider safeActivityEmbeddingComponentProvider) {
        Method method = safeActivityEmbeddingComponentProvider.getActivityEmbeddingComponentClass().getMethod("getEmbeddedActivityWindowInfo", Activity.class);
        ReflectionUtils reflectionUtils = ReflectionUtils.INSTANCE;
        Intrinsics.checkNotNull(method);
        return reflectionUtils.isPublic$window_release(method) && ReflectionUtils.INSTANCE.doesReturn$window_release(method, androidx.window.extensions.embedding.EmbeddedActivityWindowInfo.class);
    }

    private final boolean isMethodSetEmbeddedActivityWindowInfoCallbackValid() {
        return ReflectionUtils.validateReflection$window_release("ActivityEmbeddingComponent#setEmbeddedActivityWindowInfoCallback is not valid", new Function0() { // from class: androidx.window.embedding.SafeActivityEmbeddingComponentProvider$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                boolean isMethodSetEmbeddedActivityWindowInfoCallbackValid$lambda$40;
                isMethodSetEmbeddedActivityWindowInfoCallbackValid$lambda$40 = SafeActivityEmbeddingComponentProvider.isMethodSetEmbeddedActivityWindowInfoCallbackValid$lambda$40(SafeActivityEmbeddingComponentProvider.this);
                return Boolean.valueOf(isMethodSetEmbeddedActivityWindowInfoCallbackValid$lambda$40);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isMethodSetEmbeddedActivityWindowInfoCallbackValid$lambda$40(SafeActivityEmbeddingComponentProvider safeActivityEmbeddingComponentProvider) {
        Method method = safeActivityEmbeddingComponentProvider.getActivityEmbeddingComponentClass().getMethod("setEmbeddedActivityWindowInfoCallback", Executor.class, Consumer.class);
        ReflectionUtils reflectionUtils = ReflectionUtils.INSTANCE;
        Intrinsics.checkNotNull(method);
        return reflectionUtils.isPublic$window_release(method);
    }

    private final boolean isMethodClearEmbeddedActivityWindowInfoCallbackValid() {
        return ReflectionUtils.validateReflection$window_release("ActivityEmbeddingComponent#clearEmbeddedActivityWindowInfoCallback is not valid", new Function0() { // from class: androidx.window.embedding.SafeActivityEmbeddingComponentProvider$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                boolean isMethodClearEmbeddedActivityWindowInfoCallbackValid$lambda$41;
                isMethodClearEmbeddedActivityWindowInfoCallbackValid$lambda$41 = SafeActivityEmbeddingComponentProvider.isMethodClearEmbeddedActivityWindowInfoCallbackValid$lambda$41(SafeActivityEmbeddingComponentProvider.this);
                return Boolean.valueOf(isMethodClearEmbeddedActivityWindowInfoCallbackValid$lambda$41);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isMethodClearEmbeddedActivityWindowInfoCallbackValid$lambda$41(SafeActivityEmbeddingComponentProvider safeActivityEmbeddingComponentProvider) {
        Method method = safeActivityEmbeddingComponentProvider.getActivityEmbeddingComponentClass().getMethod("clearEmbeddedActivityWindowInfoCallback", new Class[0]);
        ReflectionUtils reflectionUtils = ReflectionUtils.INSTANCE;
        Intrinsics.checkNotNull(method);
        return reflectionUtils.isPublic$window_release(method);
    }

    private final boolean isMethodGetDividerAttributesValid() {
        return ReflectionUtils.validateReflection$window_release("SplitAttributes#getDividerAttributes is not valid", new Function0() { // from class: androidx.window.embedding.SafeActivityEmbeddingComponentProvider$$ExternalSyntheticLambda48
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                boolean isMethodGetDividerAttributesValid$lambda$42;
                isMethodGetDividerAttributesValid$lambda$42 = SafeActivityEmbeddingComponentProvider.isMethodGetDividerAttributesValid$lambda$42();
                return Boolean.valueOf(isMethodGetDividerAttributesValid$lambda$42);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isMethodGetDividerAttributesValid$lambda$42() {
        Method method = androidx.window.extensions.embedding.SplitAttributes.class.getMethod("getDividerAttributes", new Class[0]);
        ReflectionUtils reflectionUtils = ReflectionUtils.INSTANCE;
        Intrinsics.checkNotNull(method);
        return reflectionUtils.isPublic$window_release(method) && ReflectionUtils.INSTANCE.doesReturn$window_release(method, androidx.window.extensions.embedding.DividerAttributes.class);
    }

    private final boolean isMethodSetDividerAttributesValid() {
        return ReflectionUtils.validateReflection$window_release("SplitAttributes#setDividerAttributes is not valid", new Function0() { // from class: androidx.window.embedding.SafeActivityEmbeddingComponentProvider$$ExternalSyntheticLambda29
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                boolean isMethodSetDividerAttributesValid$lambda$43;
                isMethodSetDividerAttributesValid$lambda$43 = SafeActivityEmbeddingComponentProvider.isMethodSetDividerAttributesValid$lambda$43();
                return Boolean.valueOf(isMethodSetDividerAttributesValid$lambda$43);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isMethodSetDividerAttributesValid$lambda$43() {
        Method method = SplitAttributes.Builder.class.getMethod("setDividerAttributes", androidx.window.extensions.embedding.DividerAttributes.class);
        ReflectionUtils reflectionUtils = ReflectionUtils.INSTANCE;
        Intrinsics.checkNotNull(method);
        return reflectionUtils.isPublic$window_release(method) && ReflectionUtils.INSTANCE.doesReturn$window_release(method, SplitAttributes.Builder.class);
    }

    private final boolean isClassEmbeddedActivityWindowInfoValid() {
        return ReflectionUtils.validateReflection$window_release("Class EmbeddedActivityWindowInfo is not valid", new Function0() { // from class: androidx.window.embedding.SafeActivityEmbeddingComponentProvider$$ExternalSyntheticLambda45
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                boolean isClassEmbeddedActivityWindowInfoValid$lambda$44;
                isClassEmbeddedActivityWindowInfoValid$lambda$44 = SafeActivityEmbeddingComponentProvider.isClassEmbeddedActivityWindowInfoValid$lambda$44();
                return Boolean.valueOf(isClassEmbeddedActivityWindowInfoValid$lambda$44);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isClassEmbeddedActivityWindowInfoValid$lambda$44() {
        Method method = androidx.window.extensions.embedding.EmbeddedActivityWindowInfo.class.getMethod("getActivity", new Class[0]);
        Method method2 = androidx.window.extensions.embedding.EmbeddedActivityWindowInfo.class.getMethod("isEmbedded", new Class[0]);
        Method method3 = androidx.window.extensions.embedding.EmbeddedActivityWindowInfo.class.getMethod("getTaskBounds", new Class[0]);
        Method method4 = androidx.window.extensions.embedding.EmbeddedActivityWindowInfo.class.getMethod("getActivityStackBounds", new Class[0]);
        ReflectionUtils reflectionUtils = ReflectionUtils.INSTANCE;
        Intrinsics.checkNotNull(method);
        if (reflectionUtils.isPublic$window_release(method) && ReflectionUtils.INSTANCE.doesReturn$window_release(method, Activity.class)) {
            ReflectionUtils reflectionUtils2 = ReflectionUtils.INSTANCE;
            Intrinsics.checkNotNull(method2);
            if (reflectionUtils2.isPublic$window_release(method2) && ReflectionUtils.INSTANCE.doesReturn$window_release(method2, Boolean.TYPE)) {
                ReflectionUtils reflectionUtils3 = ReflectionUtils.INSTANCE;
                Intrinsics.checkNotNull(method3);
                if (reflectionUtils3.isPublic$window_release(method3) && ReflectionUtils.INSTANCE.doesReturn$window_release(method3, Rect.class)) {
                    ReflectionUtils reflectionUtils4 = ReflectionUtils.INSTANCE;
                    Intrinsics.checkNotNull(method4);
                    if (reflectionUtils4.isPublic$window_release(method4) && ReflectionUtils.INSTANCE.doesReturn$window_release(method4, Rect.class)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private final boolean isClassDividerAttributesValid() {
        return ReflectionUtils.validateReflection$window_release("Class DividerAttributes is not valid", new Function0() { // from class: androidx.window.embedding.SafeActivityEmbeddingComponentProvider$$ExternalSyntheticLambda51
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                boolean isClassDividerAttributesValid$lambda$45;
                isClassDividerAttributesValid$lambda$45 = SafeActivityEmbeddingComponentProvider.isClassDividerAttributesValid$lambda$45();
                return Boolean.valueOf(isClassDividerAttributesValid$lambda$45);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isClassDividerAttributesValid$lambda$45() {
        Method method = androidx.window.extensions.embedding.DividerAttributes.class.getMethod("getDividerType", new Class[0]);
        Method method2 = androidx.window.extensions.embedding.DividerAttributes.class.getMethod("getWidthDp", new Class[0]);
        Method method3 = androidx.window.extensions.embedding.DividerAttributes.class.getMethod("getPrimaryMinRatio", new Class[0]);
        Method method4 = androidx.window.extensions.embedding.DividerAttributes.class.getMethod("getPrimaryMaxRatio", new Class[0]);
        Method method5 = androidx.window.extensions.embedding.DividerAttributes.class.getMethod("getDividerColor", new Class[0]);
        ReflectionUtils reflectionUtils = ReflectionUtils.INSTANCE;
        Intrinsics.checkNotNull(method);
        if (reflectionUtils.isPublic$window_release(method) && ReflectionUtils.INSTANCE.doesReturn$window_release(method, Integer.TYPE)) {
            ReflectionUtils reflectionUtils2 = ReflectionUtils.INSTANCE;
            Intrinsics.checkNotNull(method2);
            if (reflectionUtils2.isPublic$window_release(method2) && ReflectionUtils.INSTANCE.doesReturn$window_release(method2, Integer.TYPE)) {
                ReflectionUtils reflectionUtils3 = ReflectionUtils.INSTANCE;
                Intrinsics.checkNotNull(method3);
                if (reflectionUtils3.isPublic$window_release(method3) && ReflectionUtils.INSTANCE.doesReturn$window_release(method3, Float.TYPE)) {
                    ReflectionUtils reflectionUtils4 = ReflectionUtils.INSTANCE;
                    Intrinsics.checkNotNull(method4);
                    if (reflectionUtils4.isPublic$window_release(method4) && ReflectionUtils.INSTANCE.doesReturn$window_release(method4, Float.TYPE)) {
                        ReflectionUtils reflectionUtils5 = ReflectionUtils.INSTANCE;
                        Intrinsics.checkNotNull(method5);
                        if (reflectionUtils5.isPublic$window_release(method5) && ReflectionUtils.INSTANCE.doesReturn$window_release(method5, Integer.TYPE)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    private final boolean isClassDividerAttributesBuilderValid() {
        return ReflectionUtils.validateReflection$window_release("Class DividerAttributes.Builder is not valid", new Function0() { // from class: androidx.window.embedding.SafeActivityEmbeddingComponentProvider$$ExternalSyntheticLambda27
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                boolean isClassDividerAttributesBuilderValid$lambda$46;
                isClassDividerAttributesBuilderValid$lambda$46 = SafeActivityEmbeddingComponentProvider.isClassDividerAttributesBuilderValid$lambda$46();
                return Boolean.valueOf(isClassDividerAttributesBuilderValid$lambda$46);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isClassDividerAttributesBuilderValid$lambda$46() {
        Constructor<?> declaredConstructor = DividerAttributes.Builder.class.getDeclaredConstructor(Integer.TYPE);
        Constructor<?> declaredConstructor2 = DividerAttributes.Builder.class.getDeclaredConstructor(androidx.window.extensions.embedding.DividerAttributes.class);
        Method method = DividerAttributes.Builder.class.getMethod("setWidthDp", Integer.TYPE);
        Method method2 = DividerAttributes.Builder.class.getMethod("setPrimaryMinRatio", Float.TYPE);
        Method method3 = DividerAttributes.Builder.class.getMethod("setPrimaryMaxRatio", Float.TYPE);
        Method method4 = DividerAttributes.Builder.class.getMethod("setDividerColor", Integer.TYPE);
        ReflectionUtils reflectionUtils = ReflectionUtils.INSTANCE;
        Intrinsics.checkNotNull(declaredConstructor);
        if (reflectionUtils.isPublic$window_release(declaredConstructor)) {
            ReflectionUtils reflectionUtils2 = ReflectionUtils.INSTANCE;
            Intrinsics.checkNotNull(declaredConstructor2);
            if (reflectionUtils2.isPublic$window_release(declaredConstructor2)) {
                ReflectionUtils reflectionUtils3 = ReflectionUtils.INSTANCE;
                Intrinsics.checkNotNull(method);
                if (reflectionUtils3.isPublic$window_release(method) && ReflectionUtils.INSTANCE.doesReturn$window_release(method, DividerAttributes.Builder.class)) {
                    ReflectionUtils reflectionUtils4 = ReflectionUtils.INSTANCE;
                    Intrinsics.checkNotNull(method2);
                    if (reflectionUtils4.isPublic$window_release(method2) && ReflectionUtils.INSTANCE.doesReturn$window_release(method2, DividerAttributes.Builder.class)) {
                        ReflectionUtils reflectionUtils5 = ReflectionUtils.INSTANCE;
                        Intrinsics.checkNotNull(method3);
                        if (reflectionUtils5.isPublic$window_release(method3) && ReflectionUtils.INSTANCE.doesReturn$window_release(method3, DividerAttributes.Builder.class)) {
                            ReflectionUtils reflectionUtils6 = ReflectionUtils.INSTANCE;
                            Intrinsics.checkNotNull(method4);
                            if (reflectionUtils6.isPublic$window_release(method4) && ReflectionUtils.INSTANCE.doesReturn$window_release(method4, DividerAttributes.Builder.class)) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    private final boolean isMethodGetAnimationParamsValid() {
        return ReflectionUtils.validateReflection$window_release("SplitAttributes#getAnimationParams is not valid", new Function0() { // from class: androidx.window.embedding.SafeActivityEmbeddingComponentProvider$$ExternalSyntheticLambda15
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                boolean isMethodGetAnimationParamsValid$lambda$47;
                isMethodGetAnimationParamsValid$lambda$47 = SafeActivityEmbeddingComponentProvider.isMethodGetAnimationParamsValid$lambda$47();
                return Boolean.valueOf(isMethodGetAnimationParamsValid$lambda$47);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isMethodGetAnimationParamsValid$lambda$47() {
        Method method = androidx.window.extensions.embedding.SplitAttributes.class.getMethod("getAnimationParams", new Class[0]);
        ReflectionUtils reflectionUtils = ReflectionUtils.INSTANCE;
        Intrinsics.checkNotNull(method);
        return reflectionUtils.isPublic$window_release(method) && ReflectionUtils.INSTANCE.doesReturn$window_release(method, AnimationParams.class);
    }

    private final boolean isMethodSetAnimationParamsValid() {
        return ReflectionUtils.validateReflection$window_release("SplitAttributes#setAnimationParams is not valid", new Function0() { // from class: androidx.window.embedding.SafeActivityEmbeddingComponentProvider$$ExternalSyntheticLambda58
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                boolean isMethodSetAnimationParamsValid$lambda$48;
                isMethodSetAnimationParamsValid$lambda$48 = SafeActivityEmbeddingComponentProvider.isMethodSetAnimationParamsValid$lambda$48();
                return Boolean.valueOf(isMethodSetAnimationParamsValid$lambda$48);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isMethodSetAnimationParamsValid$lambda$48() {
        Method method = SplitAttributes.Builder.class.getMethod("setAnimationParams", AnimationParams.class);
        ReflectionUtils reflectionUtils = ReflectionUtils.INSTANCE;
        Intrinsics.checkNotNull(method);
        return reflectionUtils.isPublic$window_release(method) && ReflectionUtils.INSTANCE.doesReturn$window_release(method, SplitAttributes.Builder.class);
    }

    private final boolean isMethodIsDraggingToFullscreenAllowedValid() {
        return ReflectionUtils.validateReflection$window_release("DividerAttributes#isDraggingToFullscreenAllowed is not valid", new Function0() { // from class: androidx.window.embedding.SafeActivityEmbeddingComponentProvider$$ExternalSyntheticLambda43
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                boolean isMethodIsDraggingToFullscreenAllowedValid$lambda$49;
                isMethodIsDraggingToFullscreenAllowedValid$lambda$49 = SafeActivityEmbeddingComponentProvider.isMethodIsDraggingToFullscreenAllowedValid$lambda$49();
                return Boolean.valueOf(isMethodIsDraggingToFullscreenAllowedValid$lambda$49);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isMethodIsDraggingToFullscreenAllowedValid$lambda$49() {
        Method method = androidx.window.extensions.embedding.DividerAttributes.class.getMethod("isDraggingToFullscreenAllowed", new Class[0]);
        ReflectionUtils reflectionUtils = ReflectionUtils.INSTANCE;
        Intrinsics.checkNotNull(method);
        return reflectionUtils.isPublic$window_release(method) && ReflectionUtils.INSTANCE.doesReturn$window_release(method, Boolean.TYPE);
    }

    private final boolean isMethodSetDraggingToFullscreenAllowedValid() {
        return ReflectionUtils.validateReflection$window_release("DividerAttributes.Builder#setDraggingToFullscreenAllowed is not valid", new Function0() { // from class: androidx.window.embedding.SafeActivityEmbeddingComponentProvider$$ExternalSyntheticLambda16
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                boolean isMethodSetDraggingToFullscreenAllowedValid$lambda$50;
                isMethodSetDraggingToFullscreenAllowedValid$lambda$50 = SafeActivityEmbeddingComponentProvider.isMethodSetDraggingToFullscreenAllowedValid$lambda$50();
                return Boolean.valueOf(isMethodSetDraggingToFullscreenAllowedValid$lambda$50);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isMethodSetDraggingToFullscreenAllowedValid$lambda$50() {
        Method method = DividerAttributes.Builder.class.getMethod("setDraggingToFullscreenAllowed", Boolean.TYPE);
        ReflectionUtils reflectionUtils = ReflectionUtils.INSTANCE;
        Intrinsics.checkNotNull(method);
        return reflectionUtils.isPublic$window_release(method) && ReflectionUtils.INSTANCE.doesReturn$window_release(method, DividerAttributes.Builder.class);
    }

    private final boolean isClassAnimationParamsValid() {
        return ReflectionUtils.validateReflection$window_release("Class AnimationParams is not valid", new Function0() { // from class: androidx.window.embedding.SafeActivityEmbeddingComponentProvider$$ExternalSyntheticLambda34
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                boolean isClassAnimationParamsValid$lambda$51;
                isClassAnimationParamsValid$lambda$51 = SafeActivityEmbeddingComponentProvider.isClassAnimationParamsValid$lambda$51();
                return Boolean.valueOf(isClassAnimationParamsValid$lambda$51);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isClassAnimationParamsValid$lambda$51() {
        Field declaredField = AnimationParams.class.getDeclaredField("DEFAULT_ANIMATION_RESOURCES_ID");
        Method method = AnimationParams.class.getMethod("getAnimationBackground", new Class[0]);
        Method method2 = AnimationParams.class.getMethod("getOpenAnimationResId", new Class[0]);
        Method method3 = AnimationParams.class.getMethod("getCloseAnimationResId", new Class[0]);
        Method method4 = AnimationParams.class.getMethod("getChangeAnimationResId", new Class[0]);
        ReflectionUtils reflectionUtils = ReflectionUtils.INSTANCE;
        Intrinsics.checkNotNull(declaredField);
        if (reflectionUtils.isPublic$window_release(declaredField)) {
            ReflectionUtils reflectionUtils2 = ReflectionUtils.INSTANCE;
            Intrinsics.checkNotNull(method);
            if (reflectionUtils2.isPublic$window_release(method) && ReflectionUtils.INSTANCE.doesReturn$window_release(method, AnimationBackground.class)) {
                ReflectionUtils reflectionUtils3 = ReflectionUtils.INSTANCE;
                Intrinsics.checkNotNull(method2);
                if (reflectionUtils3.isPublic$window_release(method2) && ReflectionUtils.INSTANCE.doesReturn$window_release(method2, Integer.TYPE)) {
                    ReflectionUtils reflectionUtils4 = ReflectionUtils.INSTANCE;
                    Intrinsics.checkNotNull(method3);
                    if (reflectionUtils4.isPublic$window_release(method3) && ReflectionUtils.INSTANCE.doesReturn$window_release(method3, Integer.TYPE)) {
                        ReflectionUtils reflectionUtils5 = ReflectionUtils.INSTANCE;
                        Intrinsics.checkNotNull(method4);
                        if (reflectionUtils5.isPublic$window_release(method4) && ReflectionUtils.INSTANCE.doesReturn$window_release(method4, Integer.TYPE)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    private final boolean isClassAnimationParamsBuilderValid() {
        return ReflectionUtils.validateReflection$window_release("Class AnimationParams.Builder is not valid", new Function0() { // from class: androidx.window.embedding.SafeActivityEmbeddingComponentProvider$$ExternalSyntheticLambda30
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                boolean isClassAnimationParamsBuilderValid$lambda$52;
                isClassAnimationParamsBuilderValid$lambda$52 = SafeActivityEmbeddingComponentProvider.isClassAnimationParamsBuilderValid$lambda$52();
                return Boolean.valueOf(isClassAnimationParamsBuilderValid$lambda$52);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isClassAnimationParamsBuilderValid$lambda$52() {
        Method method = AnimationParams.Builder.class.getMethod("setAnimationBackground", AnimationBackground.class);
        Method method2 = AnimationParams.Builder.class.getMethod("setOpenAnimationResId", Integer.TYPE);
        Method method3 = AnimationParams.Builder.class.getMethod("setCloseAnimationResId", Integer.TYPE);
        Method method4 = AnimationParams.Builder.class.getMethod("setChangeAnimationResId", Integer.TYPE);
        ReflectionUtils reflectionUtils = ReflectionUtils.INSTANCE;
        Intrinsics.checkNotNull(method);
        if (reflectionUtils.isPublic$window_release(method) && ReflectionUtils.INSTANCE.doesReturn$window_release(method, AnimationParams.Builder.class)) {
            ReflectionUtils reflectionUtils2 = ReflectionUtils.INSTANCE;
            Intrinsics.checkNotNull(method2);
            if (reflectionUtils2.isPublic$window_release(method2) && ReflectionUtils.INSTANCE.doesReturn$window_release(method2, AnimationParams.Builder.class)) {
                ReflectionUtils reflectionUtils3 = ReflectionUtils.INSTANCE;
                Intrinsics.checkNotNull(method3);
                if (reflectionUtils3.isPublic$window_release(method3) && ReflectionUtils.INSTANCE.doesReturn$window_release(method3, AnimationParams.Builder.class)) {
                    ReflectionUtils reflectionUtils4 = ReflectionUtils.INSTANCE;
                    Intrinsics.checkNotNull(method4);
                    if (reflectionUtils4.isPublic$window_release(method4) && ReflectionUtils.INSTANCE.doesReturn$window_release(method4, AnimationParams.Builder.class)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private final boolean isActivityStackGetTagValid() {
        return ReflectionUtils.validateReflection$window_release("ActivityStack#getTag is not valid", new Function0() { // from class: androidx.window.embedding.SafeActivityEmbeddingComponentProvider$$ExternalSyntheticLambda28
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                boolean isActivityStackGetTagValid$lambda$53;
                isActivityStackGetTagValid$lambda$53 = SafeActivityEmbeddingComponentProvider.isActivityStackGetTagValid$lambda$53();
                return Boolean.valueOf(isActivityStackGetTagValid$lambda$53);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isActivityStackGetTagValid$lambda$53() {
        Method method = androidx.window.extensions.embedding.ActivityStack.class.getMethod("getTag", new Class[0]);
        ReflectionUtils reflectionUtils = ReflectionUtils.INSTANCE;
        Intrinsics.checkNotNull(method);
        return reflectionUtils.isPublic$window_release(method) && ReflectionUtils.INSTANCE.doesReturn$window_release(method, String.class);
    }

    private final boolean isMethodGetActivityStackTokenValid() {
        return ReflectionUtils.validateReflection$window_release("getActivityStackToken is not valid", new Function0() { // from class: androidx.window.embedding.SafeActivityEmbeddingComponentProvider$$ExternalSyntheticLambda53
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                boolean isMethodGetActivityStackTokenValid$lambda$54;
                isMethodGetActivityStackTokenValid$lambda$54 = SafeActivityEmbeddingComponentProvider.isMethodGetActivityStackTokenValid$lambda$54(SafeActivityEmbeddingComponentProvider.this);
                return Boolean.valueOf(isMethodGetActivityStackTokenValid$lambda$54);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isMethodGetActivityStackTokenValid$lambda$54(SafeActivityEmbeddingComponentProvider safeActivityEmbeddingComponentProvider) {
        Method method = safeActivityEmbeddingComponentProvider.getActivityEmbeddingComponentClass().getMethod("getActivityStackToken", String.class);
        ReflectionUtils reflectionUtils = ReflectionUtils.INSTANCE;
        Intrinsics.checkNotNull(method);
        return reflectionUtils.isPublic$window_release(method) && ReflectionUtils.INSTANCE.doesReturn$window_release(method, ActivityStack.Token.class);
    }

    private final boolean isClassParentContainerInfoValid() {
        return ReflectionUtils.validateReflection$window_release("ParentContainerInfo is not valid", new Function0() { // from class: androidx.window.embedding.SafeActivityEmbeddingComponentProvider$$ExternalSyntheticLambda47
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                boolean isClassParentContainerInfoValid$lambda$55;
                isClassParentContainerInfoValid$lambda$55 = SafeActivityEmbeddingComponentProvider.isClassParentContainerInfoValid$lambda$55();
                return Boolean.valueOf(isClassParentContainerInfoValid$lambda$55);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isClassParentContainerInfoValid$lambda$55() {
        Method method = androidx.window.extensions.embedding.ParentContainerInfo.class.getMethod("getWindowMetrics", new Class[0]);
        Method method2 = androidx.window.extensions.embedding.ParentContainerInfo.class.getMethod("getConfiguration", new Class[0]);
        Method method3 = androidx.window.extensions.embedding.ParentContainerInfo.class.getMethod("getWindowLayoutInfo", new Class[0]);
        ReflectionUtils reflectionUtils = ReflectionUtils.INSTANCE;
        Intrinsics.checkNotNull(method);
        if (reflectionUtils.isPublic$window_release(method) && ReflectionUtils.INSTANCE.doesReturn$window_release(method, WindowMetrics.class)) {
            ReflectionUtils reflectionUtils2 = ReflectionUtils.INSTANCE;
            Intrinsics.checkNotNull(method2);
            if (reflectionUtils2.isPublic$window_release(method2) && ReflectionUtils.INSTANCE.doesReturn$window_release(method2, Configuration.class)) {
                ReflectionUtils reflectionUtils3 = ReflectionUtils.INSTANCE;
                Intrinsics.checkNotNull(method3);
                if (reflectionUtils3.isPublic$window_release(method3) && ReflectionUtils.INSTANCE.doesReturn$window_release(method3, WindowLayoutInfo.class)) {
                    return true;
                }
            }
        }
        return false;
    }

    private final boolean isMethodGetParentContainerInfoValid() {
        return ReflectionUtils.validateReflection$window_release("ActivityEmbeddingComponent#getParentContainerInfo is not valid", new Function0() { // from class: androidx.window.embedding.SafeActivityEmbeddingComponentProvider$$ExternalSyntheticLambda49
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                boolean isMethodGetParentContainerInfoValid$lambda$56;
                isMethodGetParentContainerInfoValid$lambda$56 = SafeActivityEmbeddingComponentProvider.isMethodGetParentContainerInfoValid$lambda$56(SafeActivityEmbeddingComponentProvider.this);
                return Boolean.valueOf(isMethodGetParentContainerInfoValid$lambda$56);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isMethodGetParentContainerInfoValid$lambda$56(SafeActivityEmbeddingComponentProvider safeActivityEmbeddingComponentProvider) {
        Method method = safeActivityEmbeddingComponentProvider.getActivityEmbeddingComponentClass().getMethod("getParentContainerInfo", ActivityStack.Token.class);
        ReflectionUtils reflectionUtils = ReflectionUtils.INSTANCE;
        Intrinsics.checkNotNull(method);
        return reflectionUtils.isPublic$window_release(method) && ReflectionUtils.INSTANCE.doesReturn$window_release(method, androidx.window.extensions.embedding.ParentContainerInfo.class);
    }

    private final boolean isMethodSetActivityStackAttributesCalculatorValid() {
        return ReflectionUtils.validateReflection$window_release("setActivityStackAttributesCalculator is not valid", new Function0() { // from class: androidx.window.embedding.SafeActivityEmbeddingComponentProvider$$ExternalSyntheticLambda17
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                boolean isMethodSetActivityStackAttributesCalculatorValid$lambda$57;
                isMethodSetActivityStackAttributesCalculatorValid$lambda$57 = SafeActivityEmbeddingComponentProvider.isMethodSetActivityStackAttributesCalculatorValid$lambda$57(SafeActivityEmbeddingComponentProvider.this);
                return Boolean.valueOf(isMethodSetActivityStackAttributesCalculatorValid$lambda$57);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isMethodSetActivityStackAttributesCalculatorValid$lambda$57(SafeActivityEmbeddingComponentProvider safeActivityEmbeddingComponentProvider) {
        Method method = safeActivityEmbeddingComponentProvider.getActivityEmbeddingComponentClass().getMethod("setActivityStackAttributesCalculator", Function.class);
        ReflectionUtils reflectionUtils = ReflectionUtils.INSTANCE;
        Intrinsics.checkNotNull(method);
        return reflectionUtils.isPublic$window_release(method);
    }

    private final boolean isMethodClearActivityStackAttributesCalculatorValid() {
        return ReflectionUtils.validateReflection$window_release("clearActivityStackAttributesCalculator is not valid", new Function0() { // from class: androidx.window.embedding.SafeActivityEmbeddingComponentProvider$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                boolean isMethodClearActivityStackAttributesCalculatorValid$lambda$58;
                isMethodClearActivityStackAttributesCalculatorValid$lambda$58 = SafeActivityEmbeddingComponentProvider.isMethodClearActivityStackAttributesCalculatorValid$lambda$58(SafeActivityEmbeddingComponentProvider.this);
                return Boolean.valueOf(isMethodClearActivityStackAttributesCalculatorValid$lambda$58);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isMethodClearActivityStackAttributesCalculatorValid$lambda$58(SafeActivityEmbeddingComponentProvider safeActivityEmbeddingComponentProvider) {
        Method method = safeActivityEmbeddingComponentProvider.getActivityEmbeddingComponentClass().getMethod("clearActivityStackAttributesCalculator", new Class[0]);
        ReflectionUtils reflectionUtils = ReflectionUtils.INSTANCE;
        Intrinsics.checkNotNull(method);
        return reflectionUtils.isPublic$window_release(method);
    }

    private final boolean isMethodUpdateActivityStackAttributesValid() {
        return ReflectionUtils.validateReflection$window_release("updateActivityStackAttributes is not valid", new Function0() { // from class: androidx.window.embedding.SafeActivityEmbeddingComponentProvider$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                boolean isMethodUpdateActivityStackAttributesValid$lambda$59;
                isMethodUpdateActivityStackAttributesValid$lambda$59 = SafeActivityEmbeddingComponentProvider.isMethodUpdateActivityStackAttributesValid$lambda$59(SafeActivityEmbeddingComponentProvider.this);
                return Boolean.valueOf(isMethodUpdateActivityStackAttributesValid$lambda$59);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isMethodUpdateActivityStackAttributesValid$lambda$59(SafeActivityEmbeddingComponentProvider safeActivityEmbeddingComponentProvider) {
        Method method = safeActivityEmbeddingComponentProvider.getActivityEmbeddingComponentClass().getMethod("updateActivityStackAttributes", ActivityStack.Token.class, ActivityStackAttributes.class);
        ReflectionUtils reflectionUtils = ReflectionUtils.INSTANCE;
        Intrinsics.checkNotNull(method);
        return reflectionUtils.isPublic$window_release(method);
    }

    private final boolean isClassActivityStackAttributesValid() {
        return ReflectionUtils.validateReflection$window_release("Class ActivityStackAttributes is not valid", new Function0() { // from class: androidx.window.embedding.SafeActivityEmbeddingComponentProvider$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                boolean isClassActivityStackAttributesValid$lambda$60;
                isClassActivityStackAttributesValid$lambda$60 = SafeActivityEmbeddingComponentProvider.isClassActivityStackAttributesValid$lambda$60();
                return Boolean.valueOf(isClassActivityStackAttributesValid$lambda$60);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isClassActivityStackAttributesValid$lambda$60() {
        Method method = ActivityStackAttributes.class.getMethod("getRelativeBounds", new Class[0]);
        Method method2 = ActivityStackAttributes.class.getMethod("getWindowAttributes", new Class[0]);
        ReflectionUtils reflectionUtils = ReflectionUtils.INSTANCE;
        Intrinsics.checkNotNull(method);
        if (reflectionUtils.isPublic$window_release(method) && ReflectionUtils.INSTANCE.doesReturn$window_release(method, Rect.class)) {
            ReflectionUtils reflectionUtils2 = ReflectionUtils.INSTANCE;
            Intrinsics.checkNotNull(method2);
            if (reflectionUtils2.isPublic$window_release(method2) && ReflectionUtils.INSTANCE.doesReturn$window_release(method2, WindowAttributes.class)) {
                return true;
            }
        }
        return false;
    }

    private final boolean isClassActivityStackAttributesBuilderValid() {
        return ReflectionUtils.validateReflection$window_release("Class ActivityStackAttributes.Builder is not valid", new Function0() { // from class: androidx.window.embedding.SafeActivityEmbeddingComponentProvider$$ExternalSyntheticLambda31
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                boolean isClassActivityStackAttributesBuilderValid$lambda$61;
                isClassActivityStackAttributesBuilderValid$lambda$61 = SafeActivityEmbeddingComponentProvider.isClassActivityStackAttributesBuilderValid$lambda$61();
                return Boolean.valueOf(isClassActivityStackAttributesBuilderValid$lambda$61);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isClassActivityStackAttributesBuilderValid$lambda$61() {
        Constructor<?> declaredConstructor = ActivityStackAttributes.Builder.class.getDeclaredConstructor(new Class[0]);
        Method method = ActivityStackAttributes.Builder.class.getMethod("setRelativeBounds", Rect.class);
        Method method2 = ActivityStackAttributes.Builder.class.getMethod("setWindowAttributes", WindowAttributes.class);
        ReflectionUtils reflectionUtils = ReflectionUtils.INSTANCE;
        Intrinsics.checkNotNull(declaredConstructor);
        if (reflectionUtils.isPublic$window_release(declaredConstructor)) {
            ReflectionUtils reflectionUtils2 = ReflectionUtils.INSTANCE;
            Intrinsics.checkNotNull(method);
            if (reflectionUtils2.isPublic$window_release(method) && ReflectionUtils.INSTANCE.doesReturn$window_release(method, ActivityStackAttributes.Builder.class)) {
                ReflectionUtils reflectionUtils3 = ReflectionUtils.INSTANCE;
                Intrinsics.checkNotNull(method2);
                if (reflectionUtils3.isPublic$window_release(method2) && ReflectionUtils.INSTANCE.doesReturn$window_release(method2, ActivityStackAttributes.Builder.class)) {
                    return true;
                }
            }
        }
        return false;
    }

    private final boolean isClassActivityStackAttributesCalculatorParamsValid() {
        return ReflectionUtils.validateReflection$window_release("Class ActivityStackAttributesCalculatorParams is not valid", new Function0() { // from class: androidx.window.embedding.SafeActivityEmbeddingComponentProvider$$ExternalSyntheticLambda13
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                boolean isClassActivityStackAttributesCalculatorParamsValid$lambda$62;
                isClassActivityStackAttributesCalculatorParamsValid$lambda$62 = SafeActivityEmbeddingComponentProvider.isClassActivityStackAttributesCalculatorParamsValid$lambda$62();
                return Boolean.valueOf(isClassActivityStackAttributesCalculatorParamsValid$lambda$62);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isClassActivityStackAttributesCalculatorParamsValid$lambda$62() {
        Method method = ActivityStackAttributesCalculatorParams.class.getMethod("getParentContainerInfo", new Class[0]);
        Method method2 = ActivityStackAttributesCalculatorParams.class.getMethod("getActivityStackTag", new Class[0]);
        Method method3 = ActivityStackAttributesCalculatorParams.class.getMethod("getLaunchOptions", new Class[0]);
        ReflectionUtils reflectionUtils = ReflectionUtils.INSTANCE;
        Intrinsics.checkNotNull(method);
        if (reflectionUtils.isPublic$window_release(method) && ReflectionUtils.INSTANCE.doesReturn$window_release(method, androidx.window.extensions.embedding.ParentContainerInfo.class)) {
            ReflectionUtils reflectionUtils2 = ReflectionUtils.INSTANCE;
            Intrinsics.checkNotNull(method2);
            if (reflectionUtils2.isPublic$window_release(method2) && ReflectionUtils.INSTANCE.doesReturn$window_release(method2, String.class)) {
                ReflectionUtils reflectionUtils3 = ReflectionUtils.INSTANCE;
                Intrinsics.checkNotNull(method3);
                if (reflectionUtils3.isPublic$window_release(method3) && ReflectionUtils.INSTANCE.doesReturn$window_release(method3, Bundle.class)) {
                    return true;
                }
            }
        }
        return false;
    }
}
