package androidx.window.embedding;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import androidx.window.core.ActivityComponentInfo;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
/* compiled from: MatcherUtils.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0000¢\u0006\u0002\b\tJ\u001d\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u0007H\u0000¢\u0006\u0002\b\rJ\u001d\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\u0007H\u0000¢\u0006\u0002\b\u0011J\u0018\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\u001d\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u0014H\u0000¢\u0006\u0002\b\u001aR\u000e\u0010\u001b\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0014X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Landroidx/window/embedding/MatcherUtils;", "", "<init>", "()V", "areComponentsMatching", "", "activityComponent", "Landroidx/window/core/ActivityComponentInfo;", "ruleComponent", "areComponentsMatching$window_release", "isActivityMatching", "activity", "Landroid/app/Activity;", "isActivityMatching$window_release", "isIntentMatching", "intent", "Landroid/content/Intent;", "isIntentMatching$window_release", "wildcardMatch", "name", "", "pattern", "validateComponentName", "", RemoteConfigConstants.RequestFieldKey.PACKAGE_NAME, "className", "validateComponentName$window_release", "sDebugMatchers", "sMatchersTag", "window_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class MatcherUtils {
    public static final MatcherUtils INSTANCE = new MatcherUtils();
    public static final boolean sDebugMatchers = false;
    public static final String sMatchersTag = "SplitRuleResolution";

    private MatcherUtils() {
    }

    public final boolean areComponentsMatching$window_release(ActivityComponentInfo activityComponentInfo, ActivityComponentInfo ruleComponent) {
        Intrinsics.checkNotNullParameter(ruleComponent, "ruleComponent");
        if (activityComponentInfo == null) {
            return Intrinsics.areEqual(ruleComponent.getPackageName(), "*") && Intrinsics.areEqual(ruleComponent.getClassName(), "*");
        } else if (StringsKt.contains$default((CharSequence) activityComponentInfo.toString(), (CharSequence) "*", false, 2, (Object) null)) {
            throw new IllegalArgumentException("Wildcard can only be part of the rule.".toString());
        } else {
            return (Intrinsics.areEqual(activityComponentInfo.getPackageName(), ruleComponent.getPackageName()) || wildcardMatch(activityComponentInfo.getPackageName(), ruleComponent.getPackageName())) && (Intrinsics.areEqual(activityComponentInfo.getClassName(), ruleComponent.getClassName()) || wildcardMatch(activityComponentInfo.getClassName(), ruleComponent.getClassName()));
        }
    }

    public final boolean isActivityMatching$window_release(Activity activity, ActivityComponentInfo ruleComponent) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(ruleComponent, "ruleComponent");
        ComponentName componentName = activity.getComponentName();
        Intrinsics.checkNotNullExpressionValue(componentName, "getComponentName(...)");
        if (areComponentsMatching$window_release(new ActivityComponentInfo(componentName), ruleComponent)) {
            return true;
        }
        Intent intent = activity.getIntent();
        if (intent != null) {
            return INSTANCE.isIntentMatching$window_release(intent, ruleComponent);
        }
        return false;
    }

    public final boolean isIntentMatching$window_release(Intent intent, ActivityComponentInfo ruleComponent) {
        String str;
        Intrinsics.checkNotNullParameter(intent, "intent");
        Intrinsics.checkNotNullParameter(ruleComponent, "ruleComponent");
        ComponentName component = intent.getComponent();
        if (areComponentsMatching$window_release(component != null ? new ActivityComponentInfo(component) : null, ruleComponent)) {
            return true;
        }
        if (intent.getComponent() == null && (str = intent.getPackage()) != null) {
            return (Intrinsics.areEqual(str, ruleComponent.getPackageName()) || wildcardMatch(str, ruleComponent.getPackageName())) && Intrinsics.areEqual(ruleComponent.getClassName(), "*");
        }
        return false;
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
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            return StringsKt.startsWith$default(str, substring, false, 2, (Object) null);
        }
        return false;
    }

    public final void validateComponentName$window_release(String packageName, String className) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(className, "className");
        String str = packageName;
        if (str.length() <= 0) {
            throw new IllegalArgumentException("Package name must not be empty".toString());
        }
        String str2 = className;
        if (str2.length() <= 0) {
            throw new IllegalArgumentException("Activity class name must not be empty".toString());
        }
        if (StringsKt.contains$default((CharSequence) str, (CharSequence) "*", false, 2, (Object) null) && StringsKt.indexOf$default((CharSequence) str, "*", 0, false, 6, (Object) null) != packageName.length() - 1) {
            throw new IllegalArgumentException("Wildcard in package name is only allowed at the end.".toString());
        }
        if (StringsKt.contains$default((CharSequence) str2, (CharSequence) "*", false, 2, (Object) null) && StringsKt.indexOf$default((CharSequence) str2, "*", 0, false, 6, (Object) null) != className.length() - 1) {
            throw new IllegalArgumentException("Wildcard in class name is only allowed at the end.".toString());
        }
    }
}
