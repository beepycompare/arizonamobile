package androidx.window.embedding;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
/* compiled from: MatcherUtils.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001d\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0000¢\u0006\u0002\b\fJ\u001f\u0010\r\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\n\u001a\u00020\u000bH\u0000¢\u0006\u0002\b\u000fJ\u0018\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Landroidx/window/embedding/MatcherUtils;", "", "()V", "sDebugMatchers", "", "sMatchersTag", "", "areActivityOrIntentComponentsMatching", "activity", "Landroid/app/Activity;", "ruleComponent", "Landroid/content/ComponentName;", "areActivityOrIntentComponentsMatching$window_release", "areComponentsMatching", "activityComponent", "areComponentsMatching$window_release", "wildcardMatch", "name", "pattern", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class MatcherUtils {
    public static final MatcherUtils INSTANCE = new MatcherUtils();
    public static final boolean sDebugMatchers = false;
    public static final String sMatchersTag = "SplitRuleResolution";

    private MatcherUtils() {
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x008c A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean areComponentsMatching$window_release(ComponentName componentName, ComponentName ruleComponent) {
        boolean z;
        boolean z2;
        Intrinsics.checkNotNullParameter(ruleComponent, "ruleComponent");
        if (componentName == null) {
            return Intrinsics.areEqual(ruleComponent.getPackageName(), "*") && Intrinsics.areEqual(ruleComponent.getClassName(), "*");
        }
        String componentName2 = componentName.toString();
        Intrinsics.checkNotNullExpressionValue(componentName2, "activityComponent.toString()");
        if (StringsKt.contains$default((CharSequence) componentName2, (CharSequence) "*", false, 2, (Object) null)) {
            throw new IllegalArgumentException("Wildcard can only be part of the rule.".toString());
        }
        if (!Intrinsics.areEqual(componentName.getPackageName(), ruleComponent.getPackageName())) {
            String packageName = componentName.getPackageName();
            Intrinsics.checkNotNullExpressionValue(packageName, "activityComponent.packageName");
            String packageName2 = ruleComponent.getPackageName();
            Intrinsics.checkNotNullExpressionValue(packageName2, "ruleComponent.packageName");
            if (!wildcardMatch(packageName, packageName2)) {
                z = false;
                if (!Intrinsics.areEqual(componentName.getClassName(), ruleComponent.getClassName())) {
                    String className = componentName.getClassName();
                    Intrinsics.checkNotNullExpressionValue(className, "activityComponent.className");
                    String className2 = ruleComponent.getClassName();
                    Intrinsics.checkNotNullExpressionValue(className2, "ruleComponent.className");
                    if (!wildcardMatch(className, className2)) {
                        z2 = false;
                        return !z && z2;
                    }
                }
                z2 = true;
                if (z) {
                }
            }
        }
        z = true;
        if (!Intrinsics.areEqual(componentName.getClassName(), ruleComponent.getClassName())) {
        }
        z2 = true;
        if (z) {
        }
    }

    public final boolean areActivityOrIntentComponentsMatching$window_release(Activity activity, ComponentName ruleComponent) {
        ComponentName component;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(ruleComponent, "ruleComponent");
        if (areComponentsMatching$window_release(activity.getComponentName(), ruleComponent)) {
            return true;
        }
        Intent intent = activity.getIntent();
        if (intent == null || (component = intent.getComponent()) == null) {
            return false;
        }
        return INSTANCE.areComponentsMatching$window_release(component, ruleComponent);
    }

    private final boolean wildcardMatch(String str, String str2) {
        String str3 = str2;
        if (StringsKt.contains$default((CharSequence) str3, (CharSequence) "*", false, 2, (Object) null)) {
            if (Intrinsics.areEqual(str2, "*")) {
                return true;
            }
            if (StringsKt.indexOf$default((CharSequence) str3, "*", 0, false, 6, (Object) null) != StringsKt.lastIndexOf$default((CharSequence) str3, "*", 0, false, 6, (Object) null) || !StringsKt.endsWith$default(str2, "*", false, 2, (Object) null)) {
                throw new IllegalArgumentException("Name pattern with a wildcard must only contain a single wildcard in the end".toString());
            }
            String substring = str2.substring(0, str2.length() - 1);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            return StringsKt.startsWith$default(str, substring, false, 2, (Object) null);
        }
        return false;
    }
}
